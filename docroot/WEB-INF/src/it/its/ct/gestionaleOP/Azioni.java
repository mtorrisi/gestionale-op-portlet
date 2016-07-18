package it.its.ct.gestionaleOP;

import it.bysoftware.ct.model.Articoli;
import it.bysoftware.ct.service.ArticoliLocalServiceUtil;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.FileUtil;

public class Azioni implements Runnable {

	private final Log _log = LogFactoryUtil.getLog(Azioni.class);
	private ArrayList<Azione> azioni;
	private String fileName = "sync.json";
	private File f;

	public Azioni(File file) {
		super();
		this.f = file;
		this.azioni = new ArrayList<Azione>();
	}

	public Azioni(File file, String fileName) {
		this.azioni = new ArrayList<Azione>();
		this.f = file;
		this.fileName = fileName;
		this.azioni = new ArrayList<Azione>();
	}

	public ArrayList<Azione> getAzioni() {
		return azioni;
	}

	public void setAzioni(ArrayList<Azione> azioni) {
		this.azioni = azioni;
	}

	@Override
	public void run() {
		File folder = new File("/opt/glassfish4/data/upload");
		fileName.replaceAll("[^a-zA-Z0-9.-]", "_");
		// This is our final file path.
		File filePath = new File(folder.getAbsolutePath() + File.separator
				+ fileName);

		try {
			FileUtil.copyFile(f, filePath);
			try {
				Reader reader = new FileReader(filePath);
				Gson gson = new Gson();
				Azione[] azioni = gson.fromJson(reader, Azione[].class);
				for (Azione azione : azioni) {
					performAction(azione);
				}
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void performAction(Azione azione) throws SystemException,
			PortalException {
		switch (azione.getTabella()) {
		case "Articoli":
			List<Articoli> articoli = getArticoli(azione);
			for (Articoli articolo : articoli) {
				switch (azione.getAzione()) {
				case "insert":
				case "update":
					_log.info("Inserting or updating articolo: " + articolo);
					ArticoliLocalServiceUtil.updateArticoli(articolo);
					break;
				case "delete":
					_log.info("Deleting articolo: " + articolo);
					ArticoliLocalServiceUtil.deleteArticoli(articolo
							.getCodiceArticolo());
					break;
				default:
					_log.warn("Unrecognized action !!!");
					break;
				}
			}
			break;
		default:
			_log.warn("Unrecognized table !!!");
			break;
		}
	}

	private List<Articoli> getArticoli(Azione azione) throws PortalException,
			SystemException {
		List<Articoli> result = new ArrayList<Articoli>();
		Articoli a = null;
		if (!azione.getAzione().equals("delete")) {
			JsonArray array = azione.getItems();
			for (JsonElement jsonElement : array) {
				if (azione.getAzione().equals("insert")) {
					a = ArticoliLocalServiceUtil.createArticoli(azione
							.getChiave());
				} else {
					a = ArticoliLocalServiceUtil
							.getArticoli(azione.getChiave());
				}

				JsonObject jsonObject = jsonElement.getAsJsonObject();
				a.setCategoriaMerceologica(jsonObject.get("RanCatmer")
						.getAsString());
				a.setDescrizione(jsonObject.get("RanDescri").getAsString());
				a.setDescrizioneDocumento(jsonObject.get("RanDesdoc")
						.getAsString());
				a.setDescrizioneFiscale(jsonObject.get("RanDesfis")
						.getAsString());
				a.setTara(Double.parseDouble(jsonObject.get("RanTara")
						.getAsString()));
				a.setUnitaMisura(jsonObject.get("RanUnimis").getAsString());

				result.add(a);
				a = null;
			}
		} else {
			a = ArticoliLocalServiceUtil
					.getArticoli(azione.getChiave());
			result.add(a);
		}
		return result;
	}

	class Azione {
		private long id;
		private String tabella;
		private String azione;
		private String chiave;
		private JsonArray Items;

		// private ArrayList<Object> Items;

		public Azione() {
			super();
			// Items = new ArrayList<Object>();
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getTabella() {
			return tabella;
		}

		public void setTabella(String tabella) {
			this.tabella = tabella;
		}

		public String getAzione() {
			return azione;
		}

		public void setAzione(String azione) {
			this.azione = azione;
		}

		public String getChiave() {
			return chiave;
		}

		public void setChiave(String chiave) {
			this.chiave = chiave;
		}

		// public ArrayList<Object> getItems() {
		// return Items;
		// }
		//
		// public void setItems(ArrayList<Object> items) {
		// Items = items;
		// }

		public JsonArray getItems() {
			return Items;
		}

		public void setItems(JsonArray items) {
			Items = items;
		}

		@Override
		public String toString() {
			return "Azione [id=" + id + ", tabella=" + tabella + ", azione="
					+ azione + ", chiave=" + chiave + ", Items=" + Items + "]";
		}
	}

}

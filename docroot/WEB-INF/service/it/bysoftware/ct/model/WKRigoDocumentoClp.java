/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.bysoftware.ct.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import it.bysoftware.ct.service.ClpSerializer;
import it.bysoftware.ct.service.WKRigoDocumentoLocalServiceUtil;
import it.bysoftware.ct.service.persistence.WKRigoDocumentoPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class WKRigoDocumentoClp extends BaseModelImpl<WKRigoDocumento>
	implements WKRigoDocumento {
	public WKRigoDocumentoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return WKRigoDocumento.class;
	}

	@Override
	public String getModelClassName() {
		return WKRigoDocumento.class.getName();
	}

	@Override
	public WKRigoDocumentoPK getPrimaryKey() {
		return new WKRigoDocumentoPK(_anno, _numeroOrdine, _rigoOrdine,
			_tipoDocumento, _idAssociato);
	}

	@Override
	public void setPrimaryKey(WKRigoDocumentoPK primaryKey) {
		setAnno(primaryKey.anno);
		setNumeroOrdine(primaryKey.numeroOrdine);
		setRigoOrdine(primaryKey.rigoOrdine);
		setTipoDocumento(primaryKey.tipoDocumento);
		setIdAssociato(primaryKey.idAssociato);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new WKRigoDocumentoPK(_anno, _numeroOrdine, _rigoOrdine,
			_tipoDocumento, _idAssociato);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((WKRigoDocumentoPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("anno", getAnno());
		attributes.put("numeroOrdine", getNumeroOrdine());
		attributes.put("rigoOrdine", getRigoOrdine());
		attributes.put("codiceVariante", getCodiceVariante());
		attributes.put("descrizioneVariante", getDescrizioneVariante());
		attributes.put("codiceArticolo", getCodiceArticolo());
		attributes.put("descrizione", getDescrizione());
		attributes.put("unitaMisura", getUnitaMisura());
		attributes.put("colli", getColli());
		attributes.put("pesoLordo", getPesoLordo());
		attributes.put("tara", getTara());
		attributes.put("pesoNetto", getPesoNetto());
		attributes.put("prezzo", getPrezzo());
		attributes.put("pedane", getPedane());
		attributes.put("note", getNote());
		attributes.put("totalePesata", getTotalePesata());
		attributes.put("imballo", getImballo());
		attributes.put("gestioneReti", getGestioneReti());
		attributes.put("RtxCl", getRtxCl());
		attributes.put("kgRete", getKgRete());
		attributes.put("lotto", getLotto());
		attributes.put("passaporto", getPassaporto());
		attributes.put("progressivo", getProgressivo());
		attributes.put("riferimentoBolla", getRiferimentoBolla());
		attributes.put("sconto1", getSconto1());
		attributes.put("sconto2", getSconto2());
		attributes.put("sconto3", getSconto3());
		attributes.put("tipoDocumento", getTipoDocumento());
		attributes.put("idAssociato", getIdAssociato());
		attributes.put("verificato", getVerificato());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer anno = (Integer)attributes.get("anno");

		if (anno != null) {
			setAnno(anno);
		}

		Long numeroOrdine = (Long)attributes.get("numeroOrdine");

		if (numeroOrdine != null) {
			setNumeroOrdine(numeroOrdine);
		}

		Integer rigoOrdine = (Integer)attributes.get("rigoOrdine");

		if (rigoOrdine != null) {
			setRigoOrdine(rigoOrdine);
		}

		String codiceVariante = (String)attributes.get("codiceVariante");

		if (codiceVariante != null) {
			setCodiceVariante(codiceVariante);
		}

		String descrizioneVariante = (String)attributes.get(
				"descrizioneVariante");

		if (descrizioneVariante != null) {
			setDescrizioneVariante(descrizioneVariante);
		}

		String codiceArticolo = (String)attributes.get("codiceArticolo");

		if (codiceArticolo != null) {
			setCodiceArticolo(codiceArticolo);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}

		String unitaMisura = (String)attributes.get("unitaMisura");

		if (unitaMisura != null) {
			setUnitaMisura(unitaMisura);
		}

		Integer colli = (Integer)attributes.get("colli");

		if (colli != null) {
			setColli(colli);
		}

		Double pesoLordo = (Double)attributes.get("pesoLordo");

		if (pesoLordo != null) {
			setPesoLordo(pesoLordo);
		}

		Double tara = (Double)attributes.get("tara");

		if (tara != null) {
			setTara(tara);
		}

		Double pesoNetto = (Double)attributes.get("pesoNetto");

		if (pesoNetto != null) {
			setPesoNetto(pesoNetto);
		}

		Double prezzo = (Double)attributes.get("prezzo");

		if (prezzo != null) {
			setPrezzo(prezzo);
		}

		Double pedane = (Double)attributes.get("pedane");

		if (pedane != null) {
			setPedane(pedane);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		Double totalePesata = (Double)attributes.get("totalePesata");

		if (totalePesata != null) {
			setTotalePesata(totalePesata);
		}

		String imballo = (String)attributes.get("imballo");

		if (imballo != null) {
			setImballo(imballo);
		}

		Boolean gestioneReti = (Boolean)attributes.get("gestioneReti");

		if (gestioneReti != null) {
			setGestioneReti(gestioneReti);
		}

		Double RtxCl = (Double)attributes.get("RtxCl");

		if (RtxCl != null) {
			setRtxCl(RtxCl);
		}

		Double kgRete = (Double)attributes.get("kgRete");

		if (kgRete != null) {
			setKgRete(kgRete);
		}

		String lotto = (String)attributes.get("lotto");

		if (lotto != null) {
			setLotto(lotto);
		}

		String passaporto = (String)attributes.get("passaporto");

		if (passaporto != null) {
			setPassaporto(passaporto);
		}

		Integer progressivo = (Integer)attributes.get("progressivo");

		if (progressivo != null) {
			setProgressivo(progressivo);
		}

		Integer riferimentoBolla = (Integer)attributes.get("riferimentoBolla");

		if (riferimentoBolla != null) {
			setRiferimentoBolla(riferimentoBolla);
		}

		Float sconto1 = (Float)attributes.get("sconto1");

		if (sconto1 != null) {
			setSconto1(sconto1);
		}

		Float sconto2 = (Float)attributes.get("sconto2");

		if (sconto2 != null) {
			setSconto2(sconto2);
		}

		Float sconto3 = (Float)attributes.get("sconto3");

		if (sconto3 != null) {
			setSconto3(sconto3);
		}

		String tipoDocumento = (String)attributes.get("tipoDocumento");

		if (tipoDocumento != null) {
			setTipoDocumento(tipoDocumento);
		}

		Long idAssociato = (Long)attributes.get("idAssociato");

		if (idAssociato != null) {
			setIdAssociato(idAssociato);
		}

		Boolean verificato = (Boolean)attributes.get("verificato");

		if (verificato != null) {
			setVerificato(verificato);
		}
	}

	@Override
	public int getAnno() {
		return _anno;
	}

	@Override
	public void setAnno(int anno) {
		_anno = anno;

		if (_wkRigoDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkRigoDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setAnno", int.class);

				method.invoke(_wkRigoDocumentoRemoteModel, anno);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNumeroOrdine() {
		return _numeroOrdine;
	}

	@Override
	public void setNumeroOrdine(long numeroOrdine) {
		_numeroOrdine = numeroOrdine;

		if (_wkRigoDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkRigoDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setNumeroOrdine", long.class);

				method.invoke(_wkRigoDocumentoRemoteModel, numeroOrdine);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getRigoOrdine() {
		return _rigoOrdine;
	}

	@Override
	public void setRigoOrdine(int rigoOrdine) {
		_rigoOrdine = rigoOrdine;

		if (_wkRigoDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkRigoDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setRigoOrdine", int.class);

				method.invoke(_wkRigoDocumentoRemoteModel, rigoOrdine);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodiceVariante() {
		return _codiceVariante;
	}

	@Override
	public void setCodiceVariante(String codiceVariante) {
		_codiceVariante = codiceVariante;

		if (_wkRigoDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkRigoDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceVariante",
						String.class);

				method.invoke(_wkRigoDocumentoRemoteModel, codiceVariante);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescrizioneVariante() {
		return _descrizioneVariante;
	}

	@Override
	public void setDescrizioneVariante(String descrizioneVariante) {
		_descrizioneVariante = descrizioneVariante;

		if (_wkRigoDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkRigoDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setDescrizioneVariante",
						String.class);

				method.invoke(_wkRigoDocumentoRemoteModel, descrizioneVariante);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodiceArticolo() {
		return _codiceArticolo;
	}

	@Override
	public void setCodiceArticolo(String codiceArticolo) {
		_codiceArticolo = codiceArticolo;

		if (_wkRigoDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkRigoDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceArticolo",
						String.class);

				method.invoke(_wkRigoDocumentoRemoteModel, codiceArticolo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescrizione() {
		return _descrizione;
	}

	@Override
	public void setDescrizione(String descrizione) {
		_descrizione = descrizione;

		if (_wkRigoDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkRigoDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setDescrizione", String.class);

				method.invoke(_wkRigoDocumentoRemoteModel, descrizione);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUnitaMisura() {
		return _unitaMisura;
	}

	@Override
	public void setUnitaMisura(String unitaMisura) {
		_unitaMisura = unitaMisura;

		if (_wkRigoDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkRigoDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setUnitaMisura", String.class);

				method.invoke(_wkRigoDocumentoRemoteModel, unitaMisura);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getColli() {
		return _colli;
	}

	@Override
	public void setColli(int colli) {
		_colli = colli;

		if (_wkRigoDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkRigoDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setColli", int.class);

				method.invoke(_wkRigoDocumentoRemoteModel, colli);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getPesoLordo() {
		return _pesoLordo;
	}

	@Override
	public void setPesoLordo(double pesoLordo) {
		_pesoLordo = pesoLordo;

		if (_wkRigoDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkRigoDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setPesoLordo", double.class);

				method.invoke(_wkRigoDocumentoRemoteModel, pesoLordo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getTara() {
		return _tara;
	}

	@Override
	public void setTara(double tara) {
		_tara = tara;

		if (_wkRigoDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkRigoDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setTara", double.class);

				method.invoke(_wkRigoDocumentoRemoteModel, tara);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getPesoNetto() {
		return _pesoNetto;
	}

	@Override
	public void setPesoNetto(double pesoNetto) {
		_pesoNetto = pesoNetto;

		if (_wkRigoDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkRigoDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setPesoNetto", double.class);

				method.invoke(_wkRigoDocumentoRemoteModel, pesoNetto);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getPrezzo() {
		return _prezzo;
	}

	@Override
	public void setPrezzo(double prezzo) {
		_prezzo = prezzo;

		if (_wkRigoDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkRigoDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setPrezzo", double.class);

				method.invoke(_wkRigoDocumentoRemoteModel, prezzo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getPedane() {
		return _pedane;
	}

	@Override
	public void setPedane(double pedane) {
		_pedane = pedane;

		if (_wkRigoDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkRigoDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setPedane", double.class);

				method.invoke(_wkRigoDocumentoRemoteModel, pedane);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNote() {
		return _note;
	}

	@Override
	public void setNote(String note) {
		_note = note;

		if (_wkRigoDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkRigoDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setNote", String.class);

				method.invoke(_wkRigoDocumentoRemoteModel, note);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getTotalePesata() {
		return _totalePesata;
	}

	@Override
	public void setTotalePesata(double totalePesata) {
		_totalePesata = totalePesata;

		if (_wkRigoDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkRigoDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setTotalePesata", double.class);

				method.invoke(_wkRigoDocumentoRemoteModel, totalePesata);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImballo() {
		return _imballo;
	}

	@Override
	public void setImballo(String imballo) {
		_imballo = imballo;

		if (_wkRigoDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkRigoDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setImballo", String.class);

				method.invoke(_wkRigoDocumentoRemoteModel, imballo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getGestioneReti() {
		return _gestioneReti;
	}

	@Override
	public boolean isGestioneReti() {
		return _gestioneReti;
	}

	@Override
	public void setGestioneReti(boolean gestioneReti) {
		_gestioneReti = gestioneReti;

		if (_wkRigoDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkRigoDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setGestioneReti", boolean.class);

				method.invoke(_wkRigoDocumentoRemoteModel, gestioneReti);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getRtxCl() {
		return _RtxCl;
	}

	@Override
	public void setRtxCl(double RtxCl) {
		_RtxCl = RtxCl;

		if (_wkRigoDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkRigoDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setRtxCl", double.class);

				method.invoke(_wkRigoDocumentoRemoteModel, RtxCl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getKgRete() {
		return _kgRete;
	}

	@Override
	public void setKgRete(double kgRete) {
		_kgRete = kgRete;

		if (_wkRigoDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkRigoDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setKgRete", double.class);

				method.invoke(_wkRigoDocumentoRemoteModel, kgRete);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLotto() {
		return _lotto;
	}

	@Override
	public void setLotto(String lotto) {
		_lotto = lotto;

		if (_wkRigoDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkRigoDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setLotto", String.class);

				method.invoke(_wkRigoDocumentoRemoteModel, lotto);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPassaporto() {
		return _passaporto;
	}

	@Override
	public void setPassaporto(String passaporto) {
		_passaporto = passaporto;

		if (_wkRigoDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkRigoDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setPassaporto", String.class);

				method.invoke(_wkRigoDocumentoRemoteModel, passaporto);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getProgressivo() {
		return _progressivo;
	}

	@Override
	public void setProgressivo(int progressivo) {
		_progressivo = progressivo;

		if (_wkRigoDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkRigoDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setProgressivo", int.class);

				method.invoke(_wkRigoDocumentoRemoteModel, progressivo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getRiferimentoBolla() {
		return _riferimentoBolla;
	}

	@Override
	public void setRiferimentoBolla(int riferimentoBolla) {
		_riferimentoBolla = riferimentoBolla;

		if (_wkRigoDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkRigoDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setRiferimentoBolla", int.class);

				method.invoke(_wkRigoDocumentoRemoteModel, riferimentoBolla);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public float getSconto1() {
		return _sconto1;
	}

	@Override
	public void setSconto1(float sconto1) {
		_sconto1 = sconto1;

		if (_wkRigoDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkRigoDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setSconto1", float.class);

				method.invoke(_wkRigoDocumentoRemoteModel, sconto1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public float getSconto2() {
		return _sconto2;
	}

	@Override
	public void setSconto2(float sconto2) {
		_sconto2 = sconto2;

		if (_wkRigoDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkRigoDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setSconto2", float.class);

				method.invoke(_wkRigoDocumentoRemoteModel, sconto2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public float getSconto3() {
		return _sconto3;
	}

	@Override
	public void setSconto3(float sconto3) {
		_sconto3 = sconto3;

		if (_wkRigoDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkRigoDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setSconto3", float.class);

				method.invoke(_wkRigoDocumentoRemoteModel, sconto3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTipoDocumento() {
		return _tipoDocumento;
	}

	@Override
	public void setTipoDocumento(String tipoDocumento) {
		_tipoDocumento = tipoDocumento;

		if (_wkRigoDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkRigoDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setTipoDocumento", String.class);

				method.invoke(_wkRigoDocumentoRemoteModel, tipoDocumento);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIdAssociato() {
		return _idAssociato;
	}

	@Override
	public void setIdAssociato(long idAssociato) {
		_idAssociato = idAssociato;

		if (_wkRigoDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkRigoDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setIdAssociato", long.class);

				method.invoke(_wkRigoDocumentoRemoteModel, idAssociato);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getVerificato() {
		return _verificato;
	}

	@Override
	public boolean isVerificato() {
		return _verificato;
	}

	@Override
	public void setVerificato(boolean verificato) {
		_verificato = verificato;

		if (_wkRigoDocumentoRemoteModel != null) {
			try {
				Class<?> clazz = _wkRigoDocumentoRemoteModel.getClass();

				Method method = clazz.getMethod("setVerificato", boolean.class);

				method.invoke(_wkRigoDocumentoRemoteModel, verificato);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getWKRigoDocumentoRemoteModel() {
		return _wkRigoDocumentoRemoteModel;
	}

	public void setWKRigoDocumentoRemoteModel(
		BaseModel<?> wkRigoDocumentoRemoteModel) {
		_wkRigoDocumentoRemoteModel = wkRigoDocumentoRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _wkRigoDocumentoRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_wkRigoDocumentoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			WKRigoDocumentoLocalServiceUtil.addWKRigoDocumento(this);
		}
		else {
			WKRigoDocumentoLocalServiceUtil.updateWKRigoDocumento(this);
		}
	}

	@Override
	public WKRigoDocumento toEscapedModel() {
		return (WKRigoDocumento)ProxyUtil.newProxyInstance(WKRigoDocumento.class.getClassLoader(),
			new Class[] { WKRigoDocumento.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		WKRigoDocumentoClp clone = new WKRigoDocumentoClp();

		clone.setAnno(getAnno());
		clone.setNumeroOrdine(getNumeroOrdine());
		clone.setRigoOrdine(getRigoOrdine());
		clone.setCodiceVariante(getCodiceVariante());
		clone.setDescrizioneVariante(getDescrizioneVariante());
		clone.setCodiceArticolo(getCodiceArticolo());
		clone.setDescrizione(getDescrizione());
		clone.setUnitaMisura(getUnitaMisura());
		clone.setColli(getColli());
		clone.setPesoLordo(getPesoLordo());
		clone.setTara(getTara());
		clone.setPesoNetto(getPesoNetto());
		clone.setPrezzo(getPrezzo());
		clone.setPedane(getPedane());
		clone.setNote(getNote());
		clone.setTotalePesata(getTotalePesata());
		clone.setImballo(getImballo());
		clone.setGestioneReti(getGestioneReti());
		clone.setRtxCl(getRtxCl());
		clone.setKgRete(getKgRete());
		clone.setLotto(getLotto());
		clone.setPassaporto(getPassaporto());
		clone.setProgressivo(getProgressivo());
		clone.setRiferimentoBolla(getRiferimentoBolla());
		clone.setSconto1(getSconto1());
		clone.setSconto2(getSconto2());
		clone.setSconto3(getSconto3());
		clone.setTipoDocumento(getTipoDocumento());
		clone.setIdAssociato(getIdAssociato());
		clone.setVerificato(getVerificato());

		return clone;
	}

	@Override
	public int compareTo(WKRigoDocumento wkRigoDocumento) {
		int value = 0;

		if (getNumeroOrdine() < wkRigoDocumento.getNumeroOrdine()) {
			value = -1;
		}
		else if (getNumeroOrdine() > wkRigoDocumento.getNumeroOrdine()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getRigoOrdine() < wkRigoDocumento.getRigoOrdine()) {
			value = -1;
		}
		else if (getRigoOrdine() > wkRigoDocumento.getRigoOrdine()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WKRigoDocumentoClp)) {
			return false;
		}

		WKRigoDocumentoClp wkRigoDocumento = (WKRigoDocumentoClp)obj;

		WKRigoDocumentoPK primaryKey = wkRigoDocumento.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(61);

		sb.append("{anno=");
		sb.append(getAnno());
		sb.append(", numeroOrdine=");
		sb.append(getNumeroOrdine());
		sb.append(", rigoOrdine=");
		sb.append(getRigoOrdine());
		sb.append(", codiceVariante=");
		sb.append(getCodiceVariante());
		sb.append(", descrizioneVariante=");
		sb.append(getDescrizioneVariante());
		sb.append(", codiceArticolo=");
		sb.append(getCodiceArticolo());
		sb.append(", descrizione=");
		sb.append(getDescrizione());
		sb.append(", unitaMisura=");
		sb.append(getUnitaMisura());
		sb.append(", colli=");
		sb.append(getColli());
		sb.append(", pesoLordo=");
		sb.append(getPesoLordo());
		sb.append(", tara=");
		sb.append(getTara());
		sb.append(", pesoNetto=");
		sb.append(getPesoNetto());
		sb.append(", prezzo=");
		sb.append(getPrezzo());
		sb.append(", pedane=");
		sb.append(getPedane());
		sb.append(", note=");
		sb.append(getNote());
		sb.append(", totalePesata=");
		sb.append(getTotalePesata());
		sb.append(", imballo=");
		sb.append(getImballo());
		sb.append(", gestioneReti=");
		sb.append(getGestioneReti());
		sb.append(", RtxCl=");
		sb.append(getRtxCl());
		sb.append(", kgRete=");
		sb.append(getKgRete());
		sb.append(", lotto=");
		sb.append(getLotto());
		sb.append(", passaporto=");
		sb.append(getPassaporto());
		sb.append(", progressivo=");
		sb.append(getProgressivo());
		sb.append(", riferimentoBolla=");
		sb.append(getRiferimentoBolla());
		sb.append(", sconto1=");
		sb.append(getSconto1());
		sb.append(", sconto2=");
		sb.append(getSconto2());
		sb.append(", sconto3=");
		sb.append(getSconto3());
		sb.append(", tipoDocumento=");
		sb.append(getTipoDocumento());
		sb.append(", idAssociato=");
		sb.append(getIdAssociato());
		sb.append(", verificato=");
		sb.append(getVerificato());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(94);

		sb.append("<model><model-name>");
		sb.append("it.bysoftware.ct.model.WKRigoDocumento");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>anno</column-name><column-value><![CDATA[");
		sb.append(getAnno());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numeroOrdine</column-name><column-value><![CDATA[");
		sb.append(getNumeroOrdine());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rigoOrdine</column-name><column-value><![CDATA[");
		sb.append(getRigoOrdine());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceVariante</column-name><column-value><![CDATA[");
		sb.append(getCodiceVariante());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descrizioneVariante</column-name><column-value><![CDATA[");
		sb.append(getDescrizioneVariante());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceArticolo</column-name><column-value><![CDATA[");
		sb.append(getCodiceArticolo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descrizione</column-name><column-value><![CDATA[");
		sb.append(getDescrizione());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>unitaMisura</column-name><column-value><![CDATA[");
		sb.append(getUnitaMisura());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>colli</column-name><column-value><![CDATA[");
		sb.append(getColli());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pesoLordo</column-name><column-value><![CDATA[");
		sb.append(getPesoLordo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tara</column-name><column-value><![CDATA[");
		sb.append(getTara());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pesoNetto</column-name><column-value><![CDATA[");
		sb.append(getPesoNetto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>prezzo</column-name><column-value><![CDATA[");
		sb.append(getPrezzo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pedane</column-name><column-value><![CDATA[");
		sb.append(getPedane());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>note</column-name><column-value><![CDATA[");
		sb.append(getNote());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalePesata</column-name><column-value><![CDATA[");
		sb.append(getTotalePesata());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imballo</column-name><column-value><![CDATA[");
		sb.append(getImballo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gestioneReti</column-name><column-value><![CDATA[");
		sb.append(getGestioneReti());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>RtxCl</column-name><column-value><![CDATA[");
		sb.append(getRtxCl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kgRete</column-name><column-value><![CDATA[");
		sb.append(getKgRete());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lotto</column-name><column-value><![CDATA[");
		sb.append(getLotto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>passaporto</column-name><column-value><![CDATA[");
		sb.append(getPassaporto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>progressivo</column-name><column-value><![CDATA[");
		sb.append(getProgressivo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>riferimentoBolla</column-name><column-value><![CDATA[");
		sb.append(getRiferimentoBolla());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sconto1</column-name><column-value><![CDATA[");
		sb.append(getSconto1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sconto2</column-name><column-value><![CDATA[");
		sb.append(getSconto2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sconto3</column-name><column-value><![CDATA[");
		sb.append(getSconto3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipoDocumento</column-name><column-value><![CDATA[");
		sb.append(getTipoDocumento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idAssociato</column-name><column-value><![CDATA[");
		sb.append(getIdAssociato());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>verificato</column-name><column-value><![CDATA[");
		sb.append(getVerificato());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _anno;
	private long _numeroOrdine;
	private int _rigoOrdine;
	private String _codiceVariante;
	private String _descrizioneVariante;
	private String _codiceArticolo;
	private String _descrizione;
	private String _unitaMisura;
	private int _colli;
	private double _pesoLordo;
	private double _tara;
	private double _pesoNetto;
	private double _prezzo;
	private double _pedane;
	private String _note;
	private double _totalePesata;
	private String _imballo;
	private boolean _gestioneReti;
	private double _RtxCl;
	private double _kgRete;
	private String _lotto;
	private String _passaporto;
	private int _progressivo;
	private int _riferimentoBolla;
	private float _sconto1;
	private float _sconto2;
	private float _sconto3;
	private String _tipoDocumento;
	private long _idAssociato;
	private boolean _verificato;
	private BaseModel<?> _wkRigoDocumentoRemoteModel;
	private Class<?> _clpSerializerClass = it.bysoftware.ct.service.ClpSerializer.class;
}
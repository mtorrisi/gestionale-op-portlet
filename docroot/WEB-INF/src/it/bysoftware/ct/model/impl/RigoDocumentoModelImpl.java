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

package it.bysoftware.ct.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import it.bysoftware.ct.model.RigoDocumento;
import it.bysoftware.ct.model.RigoDocumentoModel;
import it.bysoftware.ct.model.RigoDocumentoSoap;
import it.bysoftware.ct.service.persistence.RigoDocumentoPK;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the RigoDocumento service. Represents a row in the &quot;SSRIGORD&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.bysoftware.ct.model.RigoDocumentoModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RigoDocumentoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RigoDocumentoImpl
 * @see it.bysoftware.ct.model.RigoDocumento
 * @see it.bysoftware.ct.model.RigoDocumentoModel
 * @generated
 */
@JSON(strict = true)
public class RigoDocumentoModelImpl extends BaseModelImpl<RigoDocumento>
	implements RigoDocumentoModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a rigo documento model instance should use the {@link it.bysoftware.ct.model.RigoDocumento} interface instead.
	 */
	public static final String TABLE_NAME = "SSRIGORD";
	public static final Object[][] TABLE_COLUMNS = {
			{ "WKAnno", Types.INTEGER },
			{ "WkNOrd", Types.BIGINT },
			{ "WkRigord", Types.INTEGER },
			{ "WkVarian", Types.VARCHAR },
			{ "WkDesvar", Types.VARCHAR },
			{ "WkCodart", Types.VARCHAR },
			{ "WkDescri", Types.VARCHAR },
			{ "WkUnimis", Types.VARCHAR },
			{ "WkColli", Types.INTEGER },
			{ "WkPeslor", Types.DOUBLE },
			{ "WkTara", Types.DOUBLE },
			{ "WkPesnet", Types.DOUBLE },
			{ "WkPrezzo", Types.DOUBLE },
			{ "WkPedane", Types.DOUBLE },
			{ "WkNote", Types.VARCHAR },
			{ "WkTotpes", Types.DOUBLE },
			{ "WKImballo", Types.VARCHAR },
			{ "WkGesRetine", Types.BOOLEAN },
			{ "WkRtxCl", Types.DOUBLE },
			{ "WkKgRetine", Types.DOUBLE },
			{ "WkLotto", Types.VARCHAR },
			{ "CodPassaportoAlfa", Types.VARCHAR },
			{ "CodPassaportoNum", Types.INTEGER },
			{ "NRigRiferimento", Types.INTEGER },
			{ "sconto1", Types.FLOAT },
			{ "sconto2", Types.FLOAT },
			{ "sconto3", Types.FLOAT },
			{ "WKTipdoc", Types.VARCHAR },
			{ "codice_iva", Types.VARCHAR },
			{ "id_associato", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table SSRIGORD (WKAnno INTEGER not null,WkNOrd LONG not null,WkRigord INTEGER not null,WkVarian VARCHAR(75) null,WkDesvar VARCHAR(75) null,WkCodart VARCHAR(75) null,WkDescri VARCHAR(75) null,WkUnimis VARCHAR(75) null,WkColli INTEGER,WkPeslor DOUBLE,WkTara DOUBLE,WkPesnet DOUBLE,WkPrezzo DOUBLE,WkPedane DOUBLE,WkNote VARCHAR(75) null,WkTotpes DOUBLE,WKImballo VARCHAR(75) null,WkGesRetine BOOLEAN,WkRtxCl DOUBLE,WkKgRetine DOUBLE,WkLotto VARCHAR(75) null,CodPassaportoAlfa VARCHAR(75) null,CodPassaportoNum INTEGER,NRigRiferimento INTEGER,sconto1 DOUBLE,sconto2 DOUBLE,sconto3 DOUBLE,WKTipdoc VARCHAR(75) not null,codice_iva VARCHAR(75) null,id_associato LONG not null,primary key (WKAnno, WkNOrd, WkRigord, WKTipdoc, id_associato))";
	public static final String TABLE_SQL_DROP = "drop table SSRIGORD";
	public static final String ORDER_BY_JPQL = " ORDER BY rigoDocumento.id.anno ASC, rigoDocumento.id.numeroOrdine ASC, rigoDocumento.id.rigoOrdine ASC, rigoDocumento.id.tipoDocumento ASC, rigoDocumento.id.idAssociato ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SSRIGORD.WKAnno ASC, SSRIGORD.WkNOrd ASC, SSRIGORD.WkRigord ASC, SSRIGORD.WKTipdoc ASC, SSRIGORD.id_associato ASC";
	public static final String DATA_SOURCE = "gestionaleOPDataSource";
	public static final String SESSION_FACTORY = "gestionaleOPSessionFactory";
	public static final String TX_MANAGER = "gestionaleOPTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.bysoftware.ct.model.RigoDocumento"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.bysoftware.ct.model.RigoDocumento"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.bysoftware.ct.model.RigoDocumento"),
			true);
	public static long ANNO_COLUMN_BITMASK = 1L;
	public static long CODICEARTICOLO_COLUMN_BITMASK = 2L;
	public static long CODICEVARIANTE_COLUMN_BITMASK = 4L;
	public static long IDASSOCIATO_COLUMN_BITMASK = 8L;
	public static long IMBALLO_COLUMN_BITMASK = 16L;
	public static long NUMEROORDINE_COLUMN_BITMASK = 32L;
	public static long TIPODOCUMENTO_COLUMN_BITMASK = 64L;
	public static long RIGOORDINE_COLUMN_BITMASK = 128L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static RigoDocumento toModel(RigoDocumentoSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		RigoDocumento model = new RigoDocumentoImpl();

		model.setAnno(soapModel.getAnno());
		model.setNumeroOrdine(soapModel.getNumeroOrdine());
		model.setRigoOrdine(soapModel.getRigoOrdine());
		model.setCodiceVariante(soapModel.getCodiceVariante());
		model.setDescrizioneVariante(soapModel.getDescrizioneVariante());
		model.setCodiceArticolo(soapModel.getCodiceArticolo());
		model.setDescrizione(soapModel.getDescrizione());
		model.setUnitaMisura(soapModel.getUnitaMisura());
		model.setColli(soapModel.getColli());
		model.setPesoLordo(soapModel.getPesoLordo());
		model.setTara(soapModel.getTara());
		model.setPesoNetto(soapModel.getPesoNetto());
		model.setPrezzo(soapModel.getPrezzo());
		model.setPedane(soapModel.getPedane());
		model.setNote(soapModel.getNote());
		model.setTotalePesata(soapModel.getTotalePesata());
		model.setImballo(soapModel.getImballo());
		model.setGestioneReti(soapModel.getGestioneReti());
		model.setRtxCl(soapModel.getRtxCl());
		model.setKgRete(soapModel.getKgRete());
		model.setLotto(soapModel.getLotto());
		model.setPassaporto(soapModel.getPassaporto());
		model.setProgressivo(soapModel.getProgressivo());
		model.setRiferimentoBolla(soapModel.getRiferimentoBolla());
		model.setSconto1(soapModel.getSconto1());
		model.setSconto2(soapModel.getSconto2());
		model.setSconto3(soapModel.getSconto3());
		model.setTipoDocumento(soapModel.getTipoDocumento());
		model.setCodiceIva(soapModel.getCodiceIva());
		model.setIdAssociato(soapModel.getIdAssociato());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<RigoDocumento> toModels(RigoDocumentoSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<RigoDocumento> models = new ArrayList<RigoDocumento>(soapModels.length);

		for (RigoDocumentoSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.bysoftware.ct.model.RigoDocumento"));

	public RigoDocumentoModelImpl() {
	}

	@Override
	public RigoDocumentoPK getPrimaryKey() {
		return new RigoDocumentoPK(_anno, _numeroOrdine, _rigoOrdine,
			_tipoDocumento, _idAssociato);
	}

	@Override
	public void setPrimaryKey(RigoDocumentoPK primaryKey) {
		setAnno(primaryKey.anno);
		setNumeroOrdine(primaryKey.numeroOrdine);
		setRigoOrdine(primaryKey.rigoOrdine);
		setTipoDocumento(primaryKey.tipoDocumento);
		setIdAssociato(primaryKey.idAssociato);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new RigoDocumentoPK(_anno, _numeroOrdine, _rigoOrdine,
			_tipoDocumento, _idAssociato);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((RigoDocumentoPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return RigoDocumento.class;
	}

	@Override
	public String getModelClassName() {
		return RigoDocumento.class.getName();
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
		attributes.put("codiceIva", getCodiceIva());
		attributes.put("idAssociato", getIdAssociato());

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

		String codiceIva = (String)attributes.get("codiceIva");

		if (codiceIva != null) {
			setCodiceIva(codiceIva);
		}

		Long idAssociato = (Long)attributes.get("idAssociato");

		if (idAssociato != null) {
			setIdAssociato(idAssociato);
		}
	}

	@JSON
	@Override
	public int getAnno() {
		return _anno;
	}

	@Override
	public void setAnno(int anno) {
		_columnBitmask |= ANNO_COLUMN_BITMASK;

		if (!_setOriginalAnno) {
			_setOriginalAnno = true;

			_originalAnno = _anno;
		}

		_anno = anno;
	}

	public int getOriginalAnno() {
		return _originalAnno;
	}

	@JSON
	@Override
	public long getNumeroOrdine() {
		return _numeroOrdine;
	}

	@Override
	public void setNumeroOrdine(long numeroOrdine) {
		_columnBitmask |= NUMEROORDINE_COLUMN_BITMASK;

		if (!_setOriginalNumeroOrdine) {
			_setOriginalNumeroOrdine = true;

			_originalNumeroOrdine = _numeroOrdine;
		}

		_numeroOrdine = numeroOrdine;
	}

	public long getOriginalNumeroOrdine() {
		return _originalNumeroOrdine;
	}

	@JSON
	@Override
	public int getRigoOrdine() {
		return _rigoOrdine;
	}

	@Override
	public void setRigoOrdine(int rigoOrdine) {
		_rigoOrdine = rigoOrdine;
	}

	@JSON
	@Override
	public String getCodiceVariante() {
		if (_codiceVariante == null) {
			return StringPool.BLANK;
		}
		else {
			return _codiceVariante;
		}
	}

	@Override
	public void setCodiceVariante(String codiceVariante) {
		_columnBitmask |= CODICEVARIANTE_COLUMN_BITMASK;

		if (_originalCodiceVariante == null) {
			_originalCodiceVariante = _codiceVariante;
		}

		_codiceVariante = codiceVariante;
	}

	public String getOriginalCodiceVariante() {
		return GetterUtil.getString(_originalCodiceVariante);
	}

	@JSON
	@Override
	public String getDescrizioneVariante() {
		if (_descrizioneVariante == null) {
			return StringPool.BLANK;
		}
		else {
			return _descrizioneVariante;
		}
	}

	@Override
	public void setDescrizioneVariante(String descrizioneVariante) {
		_descrizioneVariante = descrizioneVariante;
	}

	@JSON
	@Override
	public String getCodiceArticolo() {
		if (_codiceArticolo == null) {
			return StringPool.BLANK;
		}
		else {
			return _codiceArticolo;
		}
	}

	@Override
	public void setCodiceArticolo(String codiceArticolo) {
		_columnBitmask |= CODICEARTICOLO_COLUMN_BITMASK;

		if (_originalCodiceArticolo == null) {
			_originalCodiceArticolo = _codiceArticolo;
		}

		_codiceArticolo = codiceArticolo;
	}

	public String getOriginalCodiceArticolo() {
		return GetterUtil.getString(_originalCodiceArticolo);
	}

	@JSON
	@Override
	public String getDescrizione() {
		if (_descrizione == null) {
			return StringPool.BLANK;
		}
		else {
			return _descrizione;
		}
	}

	@Override
	public void setDescrizione(String descrizione) {
		_descrizione = descrizione;
	}

	@JSON
	@Override
	public String getUnitaMisura() {
		if (_unitaMisura == null) {
			return StringPool.BLANK;
		}
		else {
			return _unitaMisura;
		}
	}

	@Override
	public void setUnitaMisura(String unitaMisura) {
		_unitaMisura = unitaMisura;
	}

	@JSON
	@Override
	public int getColli() {
		return _colli;
	}

	@Override
	public void setColli(int colli) {
		_colli = colli;
	}

	@JSON
	@Override
	public double getPesoLordo() {
		return _pesoLordo;
	}

	@Override
	public void setPesoLordo(double pesoLordo) {
		_pesoLordo = pesoLordo;
	}

	@JSON
	@Override
	public double getTara() {
		return _tara;
	}

	@Override
	public void setTara(double tara) {
		_tara = tara;
	}

	@JSON
	@Override
	public double getPesoNetto() {
		return _pesoNetto;
	}

	@Override
	public void setPesoNetto(double pesoNetto) {
		_pesoNetto = pesoNetto;
	}

	@JSON
	@Override
	public double getPrezzo() {
		return _prezzo;
	}

	@Override
	public void setPrezzo(double prezzo) {
		_prezzo = prezzo;
	}

	@JSON
	@Override
	public double getPedane() {
		return _pedane;
	}

	@Override
	public void setPedane(double pedane) {
		_pedane = pedane;
	}

	@JSON
	@Override
	public String getNote() {
		if (_note == null) {
			return StringPool.BLANK;
		}
		else {
			return _note;
		}
	}

	@Override
	public void setNote(String note) {
		_note = note;
	}

	@JSON
	@Override
	public double getTotalePesata() {
		return _totalePesata;
	}

	@Override
	public void setTotalePesata(double totalePesata) {
		_totalePesata = totalePesata;
	}

	@JSON
	@Override
	public String getImballo() {
		if (_imballo == null) {
			return StringPool.BLANK;
		}
		else {
			return _imballo;
		}
	}

	@Override
	public void setImballo(String imballo) {
		_columnBitmask |= IMBALLO_COLUMN_BITMASK;

		if (_originalImballo == null) {
			_originalImballo = _imballo;
		}

		_imballo = imballo;
	}

	public String getOriginalImballo() {
		return GetterUtil.getString(_originalImballo);
	}

	@JSON
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
	}

	@JSON
	@Override
	public double getRtxCl() {
		return _RtxCl;
	}

	@Override
	public void setRtxCl(double RtxCl) {
		_RtxCl = RtxCl;
	}

	@JSON
	@Override
	public double getKgRete() {
		return _kgRete;
	}

	@Override
	public void setKgRete(double kgRete) {
		_kgRete = kgRete;
	}

	@JSON
	@Override
	public String getLotto() {
		if (_lotto == null) {
			return StringPool.BLANK;
		}
		else {
			return _lotto;
		}
	}

	@Override
	public void setLotto(String lotto) {
		_lotto = lotto;
	}

	@JSON
	@Override
	public String getPassaporto() {
		if (_passaporto == null) {
			return StringPool.BLANK;
		}
		else {
			return _passaporto;
		}
	}

	@Override
	public void setPassaporto(String passaporto) {
		_passaporto = passaporto;
	}

	@JSON
	@Override
	public int getProgressivo() {
		return _progressivo;
	}

	@Override
	public void setProgressivo(int progressivo) {
		_progressivo = progressivo;
	}

	@JSON
	@Override
	public int getRiferimentoBolla() {
		return _riferimentoBolla;
	}

	@Override
	public void setRiferimentoBolla(int riferimentoBolla) {
		_riferimentoBolla = riferimentoBolla;
	}

	@JSON
	@Override
	public float getSconto1() {
		return _sconto1;
	}

	@Override
	public void setSconto1(float sconto1) {
		_sconto1 = sconto1;
	}

	@JSON
	@Override
	public float getSconto2() {
		return _sconto2;
	}

	@Override
	public void setSconto2(float sconto2) {
		_sconto2 = sconto2;
	}

	@JSON
	@Override
	public float getSconto3() {
		return _sconto3;
	}

	@Override
	public void setSconto3(float sconto3) {
		_sconto3 = sconto3;
	}

	@JSON
	@Override
	public String getTipoDocumento() {
		if (_tipoDocumento == null) {
			return StringPool.BLANK;
		}
		else {
			return _tipoDocumento;
		}
	}

	@Override
	public void setTipoDocumento(String tipoDocumento) {
		_columnBitmask |= TIPODOCUMENTO_COLUMN_BITMASK;

		if (_originalTipoDocumento == null) {
			_originalTipoDocumento = _tipoDocumento;
		}

		_tipoDocumento = tipoDocumento;
	}

	public String getOriginalTipoDocumento() {
		return GetterUtil.getString(_originalTipoDocumento);
	}

	@JSON
	@Override
	public String getCodiceIva() {
		if (_codiceIva == null) {
			return StringPool.BLANK;
		}
		else {
			return _codiceIva;
		}
	}

	@Override
	public void setCodiceIva(String codiceIva) {
		_codiceIva = codiceIva;
	}

	@JSON
	@Override
	public long getIdAssociato() {
		return _idAssociato;
	}

	@Override
	public void setIdAssociato(long idAssociato) {
		_columnBitmask |= IDASSOCIATO_COLUMN_BITMASK;

		if (!_setOriginalIdAssociato) {
			_setOriginalIdAssociato = true;

			_originalIdAssociato = _idAssociato;
		}

		_idAssociato = idAssociato;
	}

	public long getOriginalIdAssociato() {
		return _originalIdAssociato;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public RigoDocumento toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (RigoDocumento)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		RigoDocumentoImpl rigoDocumentoImpl = new RigoDocumentoImpl();

		rigoDocumentoImpl.setAnno(getAnno());
		rigoDocumentoImpl.setNumeroOrdine(getNumeroOrdine());
		rigoDocumentoImpl.setRigoOrdine(getRigoOrdine());
		rigoDocumentoImpl.setCodiceVariante(getCodiceVariante());
		rigoDocumentoImpl.setDescrizioneVariante(getDescrizioneVariante());
		rigoDocumentoImpl.setCodiceArticolo(getCodiceArticolo());
		rigoDocumentoImpl.setDescrizione(getDescrizione());
		rigoDocumentoImpl.setUnitaMisura(getUnitaMisura());
		rigoDocumentoImpl.setColli(getColli());
		rigoDocumentoImpl.setPesoLordo(getPesoLordo());
		rigoDocumentoImpl.setTara(getTara());
		rigoDocumentoImpl.setPesoNetto(getPesoNetto());
		rigoDocumentoImpl.setPrezzo(getPrezzo());
		rigoDocumentoImpl.setPedane(getPedane());
		rigoDocumentoImpl.setNote(getNote());
		rigoDocumentoImpl.setTotalePesata(getTotalePesata());
		rigoDocumentoImpl.setImballo(getImballo());
		rigoDocumentoImpl.setGestioneReti(getGestioneReti());
		rigoDocumentoImpl.setRtxCl(getRtxCl());
		rigoDocumentoImpl.setKgRete(getKgRete());
		rigoDocumentoImpl.setLotto(getLotto());
		rigoDocumentoImpl.setPassaporto(getPassaporto());
		rigoDocumentoImpl.setProgressivo(getProgressivo());
		rigoDocumentoImpl.setRiferimentoBolla(getRiferimentoBolla());
		rigoDocumentoImpl.setSconto1(getSconto1());
		rigoDocumentoImpl.setSconto2(getSconto2());
		rigoDocumentoImpl.setSconto3(getSconto3());
		rigoDocumentoImpl.setTipoDocumento(getTipoDocumento());
		rigoDocumentoImpl.setCodiceIva(getCodiceIva());
		rigoDocumentoImpl.setIdAssociato(getIdAssociato());

		rigoDocumentoImpl.resetOriginalValues();

		return rigoDocumentoImpl;
	}

	@Override
	public int compareTo(RigoDocumento rigoDocumento) {
		RigoDocumentoPK primaryKey = rigoDocumento.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RigoDocumento)) {
			return false;
		}

		RigoDocumento rigoDocumento = (RigoDocumento)obj;

		RigoDocumentoPK primaryKey = rigoDocumento.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public void resetOriginalValues() {
		RigoDocumentoModelImpl rigoDocumentoModelImpl = this;

		rigoDocumentoModelImpl._originalAnno = rigoDocumentoModelImpl._anno;

		rigoDocumentoModelImpl._setOriginalAnno = false;

		rigoDocumentoModelImpl._originalNumeroOrdine = rigoDocumentoModelImpl._numeroOrdine;

		rigoDocumentoModelImpl._setOriginalNumeroOrdine = false;

		rigoDocumentoModelImpl._originalCodiceVariante = rigoDocumentoModelImpl._codiceVariante;

		rigoDocumentoModelImpl._originalCodiceArticolo = rigoDocumentoModelImpl._codiceArticolo;

		rigoDocumentoModelImpl._originalImballo = rigoDocumentoModelImpl._imballo;

		rigoDocumentoModelImpl._originalTipoDocumento = rigoDocumentoModelImpl._tipoDocumento;

		rigoDocumentoModelImpl._originalIdAssociato = rigoDocumentoModelImpl._idAssociato;

		rigoDocumentoModelImpl._setOriginalIdAssociato = false;

		rigoDocumentoModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<RigoDocumento> toCacheModel() {
		RigoDocumentoCacheModel rigoDocumentoCacheModel = new RigoDocumentoCacheModel();

		rigoDocumentoCacheModel.anno = getAnno();

		rigoDocumentoCacheModel.numeroOrdine = getNumeroOrdine();

		rigoDocumentoCacheModel.rigoOrdine = getRigoOrdine();

		rigoDocumentoCacheModel.codiceVariante = getCodiceVariante();

		String codiceVariante = rigoDocumentoCacheModel.codiceVariante;

		if ((codiceVariante != null) && (codiceVariante.length() == 0)) {
			rigoDocumentoCacheModel.codiceVariante = null;
		}

		rigoDocumentoCacheModel.descrizioneVariante = getDescrizioneVariante();

		String descrizioneVariante = rigoDocumentoCacheModel.descrizioneVariante;

		if ((descrizioneVariante != null) &&
				(descrizioneVariante.length() == 0)) {
			rigoDocumentoCacheModel.descrizioneVariante = null;
		}

		rigoDocumentoCacheModel.codiceArticolo = getCodiceArticolo();

		String codiceArticolo = rigoDocumentoCacheModel.codiceArticolo;

		if ((codiceArticolo != null) && (codiceArticolo.length() == 0)) {
			rigoDocumentoCacheModel.codiceArticolo = null;
		}

		rigoDocumentoCacheModel.descrizione = getDescrizione();

		String descrizione = rigoDocumentoCacheModel.descrizione;

		if ((descrizione != null) && (descrizione.length() == 0)) {
			rigoDocumentoCacheModel.descrizione = null;
		}

		rigoDocumentoCacheModel.unitaMisura = getUnitaMisura();

		String unitaMisura = rigoDocumentoCacheModel.unitaMisura;

		if ((unitaMisura != null) && (unitaMisura.length() == 0)) {
			rigoDocumentoCacheModel.unitaMisura = null;
		}

		rigoDocumentoCacheModel.colli = getColli();

		rigoDocumentoCacheModel.pesoLordo = getPesoLordo();

		rigoDocumentoCacheModel.tara = getTara();

		rigoDocumentoCacheModel.pesoNetto = getPesoNetto();

		rigoDocumentoCacheModel.prezzo = getPrezzo();

		rigoDocumentoCacheModel.pedane = getPedane();

		rigoDocumentoCacheModel.note = getNote();

		String note = rigoDocumentoCacheModel.note;

		if ((note != null) && (note.length() == 0)) {
			rigoDocumentoCacheModel.note = null;
		}

		rigoDocumentoCacheModel.totalePesata = getTotalePesata();

		rigoDocumentoCacheModel.imballo = getImballo();

		String imballo = rigoDocumentoCacheModel.imballo;

		if ((imballo != null) && (imballo.length() == 0)) {
			rigoDocumentoCacheModel.imballo = null;
		}

		rigoDocumentoCacheModel.gestioneReti = getGestioneReti();

		rigoDocumentoCacheModel.RtxCl = getRtxCl();

		rigoDocumentoCacheModel.kgRete = getKgRete();

		rigoDocumentoCacheModel.lotto = getLotto();

		String lotto = rigoDocumentoCacheModel.lotto;

		if ((lotto != null) && (lotto.length() == 0)) {
			rigoDocumentoCacheModel.lotto = null;
		}

		rigoDocumentoCacheModel.passaporto = getPassaporto();

		String passaporto = rigoDocumentoCacheModel.passaporto;

		if ((passaporto != null) && (passaporto.length() == 0)) {
			rigoDocumentoCacheModel.passaporto = null;
		}

		rigoDocumentoCacheModel.progressivo = getProgressivo();

		rigoDocumentoCacheModel.riferimentoBolla = getRiferimentoBolla();

		rigoDocumentoCacheModel.sconto1 = getSconto1();

		rigoDocumentoCacheModel.sconto2 = getSconto2();

		rigoDocumentoCacheModel.sconto3 = getSconto3();

		rigoDocumentoCacheModel.tipoDocumento = getTipoDocumento();

		String tipoDocumento = rigoDocumentoCacheModel.tipoDocumento;

		if ((tipoDocumento != null) && (tipoDocumento.length() == 0)) {
			rigoDocumentoCacheModel.tipoDocumento = null;
		}

		rigoDocumentoCacheModel.codiceIva = getCodiceIva();

		String codiceIva = rigoDocumentoCacheModel.codiceIva;

		if ((codiceIva != null) && (codiceIva.length() == 0)) {
			rigoDocumentoCacheModel.codiceIva = null;
		}

		rigoDocumentoCacheModel.idAssociato = getIdAssociato();

		return rigoDocumentoCacheModel;
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
		sb.append(", codiceIva=");
		sb.append(getCodiceIva());
		sb.append(", idAssociato=");
		sb.append(getIdAssociato());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(94);

		sb.append("<model><model-name>");
		sb.append("it.bysoftware.ct.model.RigoDocumento");
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
			"<column><column-name>codiceIva</column-name><column-value><![CDATA[");
		sb.append(getCodiceIva());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idAssociato</column-name><column-value><![CDATA[");
		sb.append(getIdAssociato());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = RigoDocumento.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			RigoDocumento.class
		};
	private int _anno;
	private int _originalAnno;
	private boolean _setOriginalAnno;
	private long _numeroOrdine;
	private long _originalNumeroOrdine;
	private boolean _setOriginalNumeroOrdine;
	private int _rigoOrdine;
	private String _codiceVariante;
	private String _originalCodiceVariante;
	private String _descrizioneVariante;
	private String _codiceArticolo;
	private String _originalCodiceArticolo;
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
	private String _originalImballo;
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
	private String _originalTipoDocumento;
	private String _codiceIva;
	private long _idAssociato;
	private long _originalIdAssociato;
	private boolean _setOriginalIdAssociato;
	private long _columnBitmask;
	private RigoDocumento _escapedModel;
}
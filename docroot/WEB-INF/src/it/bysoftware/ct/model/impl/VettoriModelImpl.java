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

import it.bysoftware.ct.model.Vettori;
import it.bysoftware.ct.model.VettoriModel;
import it.bysoftware.ct.model.VettoriSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Vettori service. Represents a row in the &quot;Vettori&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.bysoftware.ct.model.VettoriModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VettoriImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VettoriImpl
 * @see it.bysoftware.ct.model.Vettori
 * @see it.bysoftware.ct.model.VettoriModel
 * @generated
 */
@JSON(strict = true)
public class VettoriModelImpl extends BaseModelImpl<Vettori>
	implements VettoriModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a vettori model instance should use the {@link it.bysoftware.ct.model.Vettori} interface instead.
	 */
	public static final String TABLE_NAME = "Vettori";
	public static final Object[][] TABLE_COLUMNS = {
			{ "RavAlbo", Types.VARCHAR },
			{ "RavCap", Types.VARCHAR },
			{ "RavCodana", Types.VARCHAR },
			{ "RavCodfis", Types.VARCHAR },
			{ "RavCodrif", Types.VARCHAR },
			{ "RavComune", Types.VARCHAR },
			{ "RavIndiri", Types.VARCHAR },
			{ "RavNote", Types.VARCHAR },
			{ "RavPariva", Types.VARCHAR },
			{ "RavRagso1", Types.VARCHAR },
			{ "RavRagso2", Types.VARCHAR },
			{ "RavSigpro", Types.VARCHAR },
			{ "RavSigsta", Types.VARCHAR },
			{ "RavTipana", Types.VARCHAR },
			{ "RavCodiaz", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table Vettori (RavAlbo VARCHAR(75) null,RavCap VARCHAR(75) null,RavCodana VARCHAR(75) not null primary key,RavCodfis VARCHAR(75) null,RavCodrif VARCHAR(75) null,RavComune VARCHAR(75) null,RavIndiri VARCHAR(75) null,RavNote VARCHAR(75) null,RavPariva VARCHAR(75) null,RavRagso1 VARCHAR(75) null,RavRagso2 VARCHAR(75) null,RavSigpro VARCHAR(75) null,RavSigsta VARCHAR(75) null,RavTipana VARCHAR(75) null,RavCodiaz VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table Vettori";
	public static final String ORDER_BY_JPQL = " ORDER BY vettori.codiceVettore ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Vettori.RavCodana ASC";
	public static final String DATA_SOURCE = "gestionaleOPDataSource";
	public static final String SESSION_FACTORY = "gestionaleOPSessionFactory";
	public static final String TX_MANAGER = "gestionaleOPTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.bysoftware.ct.model.Vettori"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.bysoftware.ct.model.Vettori"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Vettori toModel(VettoriSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Vettori model = new VettoriImpl();

		model.setAlbo(soapModel.getAlbo());
		model.setCAP(soapModel.getCAP());
		model.setCodiceVettore(soapModel.getCodiceVettore());
		model.setCodiceFiscale(soapModel.getCodiceFiscale());
		model.setCodiceRiferimento(soapModel.getCodiceRiferimento());
		model.setComune(soapModel.getComune());
		model.setIndirizzo(soapModel.getIndirizzo());
		model.setNote(soapModel.getNote());
		model.setPartitaIVA(soapModel.getPartitaIVA());
		model.setRagioneSociale(soapModel.getRagioneSociale());
		model.setRagioneSociale2(soapModel.getRagioneSociale2());
		model.setProvincia(soapModel.getProvincia());
		model.setStato(soapModel.getStato());
		model.setTipoAnagrafica(soapModel.getTipoAnagrafica());
		model.setCodiceAzienda(soapModel.getCodiceAzienda());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Vettori> toModels(VettoriSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Vettori> models = new ArrayList<Vettori>(soapModels.length);

		for (VettoriSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.bysoftware.ct.model.Vettori"));

	public VettoriModelImpl() {
	}

	@Override
	public String getPrimaryKey() {
		return _codiceVettore;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setCodiceVettore(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _codiceVettore;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return Vettori.class;
	}

	@Override
	public String getModelClassName() {
		return Vettori.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("albo", getAlbo());
		attributes.put("CAP", getCAP());
		attributes.put("codiceVettore", getCodiceVettore());
		attributes.put("codiceFiscale", getCodiceFiscale());
		attributes.put("codiceRiferimento", getCodiceRiferimento());
		attributes.put("comune", getComune());
		attributes.put("indirizzo", getIndirizzo());
		attributes.put("note", getNote());
		attributes.put("partitaIVA", getPartitaIVA());
		attributes.put("ragioneSociale", getRagioneSociale());
		attributes.put("ragioneSociale2", getRagioneSociale2());
		attributes.put("provincia", getProvincia());
		attributes.put("stato", getStato());
		attributes.put("tipoAnagrafica", getTipoAnagrafica());
		attributes.put("codiceAzienda", getCodiceAzienda());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String albo = (String)attributes.get("albo");

		if (albo != null) {
			setAlbo(albo);
		}

		String CAP = (String)attributes.get("CAP");

		if (CAP != null) {
			setCAP(CAP);
		}

		String codiceVettore = (String)attributes.get("codiceVettore");

		if (codiceVettore != null) {
			setCodiceVettore(codiceVettore);
		}

		String codiceFiscale = (String)attributes.get("codiceFiscale");

		if (codiceFiscale != null) {
			setCodiceFiscale(codiceFiscale);
		}

		String codiceRiferimento = (String)attributes.get("codiceRiferimento");

		if (codiceRiferimento != null) {
			setCodiceRiferimento(codiceRiferimento);
		}

		String comune = (String)attributes.get("comune");

		if (comune != null) {
			setComune(comune);
		}

		String indirizzo = (String)attributes.get("indirizzo");

		if (indirizzo != null) {
			setIndirizzo(indirizzo);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		String partitaIVA = (String)attributes.get("partitaIVA");

		if (partitaIVA != null) {
			setPartitaIVA(partitaIVA);
		}

		String ragioneSociale = (String)attributes.get("ragioneSociale");

		if (ragioneSociale != null) {
			setRagioneSociale(ragioneSociale);
		}

		String ragioneSociale2 = (String)attributes.get("ragioneSociale2");

		if (ragioneSociale2 != null) {
			setRagioneSociale2(ragioneSociale2);
		}

		String provincia = (String)attributes.get("provincia");

		if (provincia != null) {
			setProvincia(provincia);
		}

		String stato = (String)attributes.get("stato");

		if (stato != null) {
			setStato(stato);
		}

		String tipoAnagrafica = (String)attributes.get("tipoAnagrafica");

		if (tipoAnagrafica != null) {
			setTipoAnagrafica(tipoAnagrafica);
		}

		String codiceAzienda = (String)attributes.get("codiceAzienda");

		if (codiceAzienda != null) {
			setCodiceAzienda(codiceAzienda);
		}
	}

	@JSON
	@Override
	public String getAlbo() {
		if (_albo == null) {
			return StringPool.BLANK;
		}
		else {
			return _albo;
		}
	}

	@Override
	public void setAlbo(String albo) {
		_albo = albo;
	}

	@JSON
	@Override
	public String getCAP() {
		if (_CAP == null) {
			return StringPool.BLANK;
		}
		else {
			return _CAP;
		}
	}

	@Override
	public void setCAP(String CAP) {
		_CAP = CAP;
	}

	@JSON
	@Override
	public String getCodiceVettore() {
		if (_codiceVettore == null) {
			return StringPool.BLANK;
		}
		else {
			return _codiceVettore;
		}
	}

	@Override
	public void setCodiceVettore(String codiceVettore) {
		_codiceVettore = codiceVettore;
	}

	@JSON
	@Override
	public String getCodiceFiscale() {
		if (_codiceFiscale == null) {
			return StringPool.BLANK;
		}
		else {
			return _codiceFiscale;
		}
	}

	@Override
	public void setCodiceFiscale(String codiceFiscale) {
		_codiceFiscale = codiceFiscale;
	}

	@JSON
	@Override
	public String getCodiceRiferimento() {
		if (_codiceRiferimento == null) {
			return StringPool.BLANK;
		}
		else {
			return _codiceRiferimento;
		}
	}

	@Override
	public void setCodiceRiferimento(String codiceRiferimento) {
		_codiceRiferimento = codiceRiferimento;
	}

	@JSON
	@Override
	public String getComune() {
		if (_comune == null) {
			return StringPool.BLANK;
		}
		else {
			return _comune;
		}
	}

	@Override
	public void setComune(String comune) {
		_comune = comune;
	}

	@JSON
	@Override
	public String getIndirizzo() {
		if (_indirizzo == null) {
			return StringPool.BLANK;
		}
		else {
			return _indirizzo;
		}
	}

	@Override
	public void setIndirizzo(String indirizzo) {
		_indirizzo = indirizzo;
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
	public String getPartitaIVA() {
		if (_partitaIVA == null) {
			return StringPool.BLANK;
		}
		else {
			return _partitaIVA;
		}
	}

	@Override
	public void setPartitaIVA(String partitaIVA) {
		_partitaIVA = partitaIVA;
	}

	@JSON
	@Override
	public String getRagioneSociale() {
		if (_ragioneSociale == null) {
			return StringPool.BLANK;
		}
		else {
			return _ragioneSociale;
		}
	}

	@Override
	public void setRagioneSociale(String ragioneSociale) {
		_ragioneSociale = ragioneSociale;
	}

	@JSON
	@Override
	public String getRagioneSociale2() {
		if (_ragioneSociale2 == null) {
			return StringPool.BLANK;
		}
		else {
			return _ragioneSociale2;
		}
	}

	@Override
	public void setRagioneSociale2(String ragioneSociale2) {
		_ragioneSociale2 = ragioneSociale2;
	}

	@JSON
	@Override
	public String getProvincia() {
		if (_provincia == null) {
			return StringPool.BLANK;
		}
		else {
			return _provincia;
		}
	}

	@Override
	public void setProvincia(String provincia) {
		_provincia = provincia;
	}

	@JSON
	@Override
	public String getStato() {
		if (_stato == null) {
			return StringPool.BLANK;
		}
		else {
			return _stato;
		}
	}

	@Override
	public void setStato(String stato) {
		_stato = stato;
	}

	@JSON
	@Override
	public String getTipoAnagrafica() {
		if (_tipoAnagrafica == null) {
			return StringPool.BLANK;
		}
		else {
			return _tipoAnagrafica;
		}
	}

	@Override
	public void setTipoAnagrafica(String tipoAnagrafica) {
		_tipoAnagrafica = tipoAnagrafica;
	}

	@JSON
	@Override
	public String getCodiceAzienda() {
		if (_codiceAzienda == null) {
			return StringPool.BLANK;
		}
		else {
			return _codiceAzienda;
		}
	}

	@Override
	public void setCodiceAzienda(String codiceAzienda) {
		_codiceAzienda = codiceAzienda;
	}

	@Override
	public Vettori toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Vettori)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		VettoriImpl vettoriImpl = new VettoriImpl();

		vettoriImpl.setAlbo(getAlbo());
		vettoriImpl.setCAP(getCAP());
		vettoriImpl.setCodiceVettore(getCodiceVettore());
		vettoriImpl.setCodiceFiscale(getCodiceFiscale());
		vettoriImpl.setCodiceRiferimento(getCodiceRiferimento());
		vettoriImpl.setComune(getComune());
		vettoriImpl.setIndirizzo(getIndirizzo());
		vettoriImpl.setNote(getNote());
		vettoriImpl.setPartitaIVA(getPartitaIVA());
		vettoriImpl.setRagioneSociale(getRagioneSociale());
		vettoriImpl.setRagioneSociale2(getRagioneSociale2());
		vettoriImpl.setProvincia(getProvincia());
		vettoriImpl.setStato(getStato());
		vettoriImpl.setTipoAnagrafica(getTipoAnagrafica());
		vettoriImpl.setCodiceAzienda(getCodiceAzienda());

		vettoriImpl.resetOriginalValues();

		return vettoriImpl;
	}

	@Override
	public int compareTo(Vettori vettori) {
		String primaryKey = vettori.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Vettori)) {
			return false;
		}

		Vettori vettori = (Vettori)obj;

		String primaryKey = vettori.getPrimaryKey();

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
	}

	@Override
	public CacheModel<Vettori> toCacheModel() {
		VettoriCacheModel vettoriCacheModel = new VettoriCacheModel();

		vettoriCacheModel.albo = getAlbo();

		String albo = vettoriCacheModel.albo;

		if ((albo != null) && (albo.length() == 0)) {
			vettoriCacheModel.albo = null;
		}

		vettoriCacheModel.CAP = getCAP();

		String CAP = vettoriCacheModel.CAP;

		if ((CAP != null) && (CAP.length() == 0)) {
			vettoriCacheModel.CAP = null;
		}

		vettoriCacheModel.codiceVettore = getCodiceVettore();

		String codiceVettore = vettoriCacheModel.codiceVettore;

		if ((codiceVettore != null) && (codiceVettore.length() == 0)) {
			vettoriCacheModel.codiceVettore = null;
		}

		vettoriCacheModel.codiceFiscale = getCodiceFiscale();

		String codiceFiscale = vettoriCacheModel.codiceFiscale;

		if ((codiceFiscale != null) && (codiceFiscale.length() == 0)) {
			vettoriCacheModel.codiceFiscale = null;
		}

		vettoriCacheModel.codiceRiferimento = getCodiceRiferimento();

		String codiceRiferimento = vettoriCacheModel.codiceRiferimento;

		if ((codiceRiferimento != null) && (codiceRiferimento.length() == 0)) {
			vettoriCacheModel.codiceRiferimento = null;
		}

		vettoriCacheModel.comune = getComune();

		String comune = vettoriCacheModel.comune;

		if ((comune != null) && (comune.length() == 0)) {
			vettoriCacheModel.comune = null;
		}

		vettoriCacheModel.indirizzo = getIndirizzo();

		String indirizzo = vettoriCacheModel.indirizzo;

		if ((indirizzo != null) && (indirizzo.length() == 0)) {
			vettoriCacheModel.indirizzo = null;
		}

		vettoriCacheModel.note = getNote();

		String note = vettoriCacheModel.note;

		if ((note != null) && (note.length() == 0)) {
			vettoriCacheModel.note = null;
		}

		vettoriCacheModel.partitaIVA = getPartitaIVA();

		String partitaIVA = vettoriCacheModel.partitaIVA;

		if ((partitaIVA != null) && (partitaIVA.length() == 0)) {
			vettoriCacheModel.partitaIVA = null;
		}

		vettoriCacheModel.ragioneSociale = getRagioneSociale();

		String ragioneSociale = vettoriCacheModel.ragioneSociale;

		if ((ragioneSociale != null) && (ragioneSociale.length() == 0)) {
			vettoriCacheModel.ragioneSociale = null;
		}

		vettoriCacheModel.ragioneSociale2 = getRagioneSociale2();

		String ragioneSociale2 = vettoriCacheModel.ragioneSociale2;

		if ((ragioneSociale2 != null) && (ragioneSociale2.length() == 0)) {
			vettoriCacheModel.ragioneSociale2 = null;
		}

		vettoriCacheModel.provincia = getProvincia();

		String provincia = vettoriCacheModel.provincia;

		if ((provincia != null) && (provincia.length() == 0)) {
			vettoriCacheModel.provincia = null;
		}

		vettoriCacheModel.stato = getStato();

		String stato = vettoriCacheModel.stato;

		if ((stato != null) && (stato.length() == 0)) {
			vettoriCacheModel.stato = null;
		}

		vettoriCacheModel.tipoAnagrafica = getTipoAnagrafica();

		String tipoAnagrafica = vettoriCacheModel.tipoAnagrafica;

		if ((tipoAnagrafica != null) && (tipoAnagrafica.length() == 0)) {
			vettoriCacheModel.tipoAnagrafica = null;
		}

		vettoriCacheModel.codiceAzienda = getCodiceAzienda();

		String codiceAzienda = vettoriCacheModel.codiceAzienda;

		if ((codiceAzienda != null) && (codiceAzienda.length() == 0)) {
			vettoriCacheModel.codiceAzienda = null;
		}

		return vettoriCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{albo=");
		sb.append(getAlbo());
		sb.append(", CAP=");
		sb.append(getCAP());
		sb.append(", codiceVettore=");
		sb.append(getCodiceVettore());
		sb.append(", codiceFiscale=");
		sb.append(getCodiceFiscale());
		sb.append(", codiceRiferimento=");
		sb.append(getCodiceRiferimento());
		sb.append(", comune=");
		sb.append(getComune());
		sb.append(", indirizzo=");
		sb.append(getIndirizzo());
		sb.append(", note=");
		sb.append(getNote());
		sb.append(", partitaIVA=");
		sb.append(getPartitaIVA());
		sb.append(", ragioneSociale=");
		sb.append(getRagioneSociale());
		sb.append(", ragioneSociale2=");
		sb.append(getRagioneSociale2());
		sb.append(", provincia=");
		sb.append(getProvincia());
		sb.append(", stato=");
		sb.append(getStato());
		sb.append(", tipoAnagrafica=");
		sb.append(getTipoAnagrafica());
		sb.append(", codiceAzienda=");
		sb.append(getCodiceAzienda());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("it.bysoftware.ct.model.Vettori");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>albo</column-name><column-value><![CDATA[");
		sb.append(getAlbo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CAP</column-name><column-value><![CDATA[");
		sb.append(getCAP());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceVettore</column-name><column-value><![CDATA[");
		sb.append(getCodiceVettore());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceFiscale</column-name><column-value><![CDATA[");
		sb.append(getCodiceFiscale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceRiferimento</column-name><column-value><![CDATA[");
		sb.append(getCodiceRiferimento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comune</column-name><column-value><![CDATA[");
		sb.append(getComune());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>indirizzo</column-name><column-value><![CDATA[");
		sb.append(getIndirizzo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>note</column-name><column-value><![CDATA[");
		sb.append(getNote());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>partitaIVA</column-name><column-value><![CDATA[");
		sb.append(getPartitaIVA());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ragioneSociale</column-name><column-value><![CDATA[");
		sb.append(getRagioneSociale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ragioneSociale2</column-name><column-value><![CDATA[");
		sb.append(getRagioneSociale2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>provincia</column-name><column-value><![CDATA[");
		sb.append(getProvincia());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stato</column-name><column-value><![CDATA[");
		sb.append(getStato());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipoAnagrafica</column-name><column-value><![CDATA[");
		sb.append(getTipoAnagrafica());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceAzienda</column-name><column-value><![CDATA[");
		sb.append(getCodiceAzienda());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Vettori.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Vettori.class
		};
	private String _albo;
	private String _CAP;
	private String _codiceVettore;
	private String _codiceFiscale;
	private String _codiceRiferimento;
	private String _comune;
	private String _indirizzo;
	private String _note;
	private String _partitaIVA;
	private String _ragioneSociale;
	private String _ragioneSociale2;
	private String _provincia;
	private String _stato;
	private String _tipoAnagrafica;
	private String _codiceAzienda;
	private Vettori _escapedModel;
}
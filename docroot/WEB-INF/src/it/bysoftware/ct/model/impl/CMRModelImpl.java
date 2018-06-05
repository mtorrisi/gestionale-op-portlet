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

import it.bysoftware.ct.model.CMR;
import it.bysoftware.ct.model.CMRModel;
import it.bysoftware.ct.model.CMRSoap;
import it.bysoftware.ct.service.persistence.CMRPK;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CMR service. Represents a row in the &quot;CMR&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.bysoftware.ct.model.CMRModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CMRImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CMRImpl
 * @see it.bysoftware.ct.model.CMR
 * @see it.bysoftware.ct.model.CMRModel
 * @generated
 */
@JSON(strict = true)
public class CMRModelImpl extends BaseModelImpl<CMR> implements CMRModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a c m r model instance should use the {@link it.bysoftware.ct.model.CMR} interface instead.
	 */
	public static final String TABLE_NAME = "CMR";
	public static final Object[][] TABLE_COLUMNS = {
			{ "numero_CMR", Types.BIGINT },
			{ "anno", Types.INTEGER },
			{ "numero_documento", Types.BIGINT },
			{ "id_associato", Types.BIGINT },
			{ "riserve", Types.VARCHAR },
			{ "allegati", Types.VARCHAR },
			{ "classe", Types.VARCHAR },
			{ "cifra", Types.VARCHAR },
			{ "lettera", Types.VARCHAR },
			{ "ADR", Types.VARCHAR },
			{ "istruzioni", Types.VARCHAR },
			{ "convenzioni", Types.VARCHAR },
			{ "rimborso", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table CMR (numero_CMR LONG not null,anno INTEGER not null,numero_documento LONG not null,id_associato LONG not null,riserve VARCHAR(75) null,allegati VARCHAR(75) null,classe VARCHAR(75) null,cifra VARCHAR(75) null,lettera VARCHAR(75) null,ADR VARCHAR(75) null,istruzioni VARCHAR(75) null,convenzioni VARCHAR(75) null,rimborso VARCHAR(75) null,primary key (numero_CMR, anno, numero_documento, id_associato))";
	public static final String TABLE_SQL_DROP = "drop table CMR";
	public static final String ORDER_BY_JPQL = " ORDER BY cmr.id.numeroCMR DESC";
	public static final String ORDER_BY_SQL = " ORDER BY CMR.numero_CMR DESC";
	public static final String DATA_SOURCE = "gestionaleOPDataSource";
	public static final String SESSION_FACTORY = "gestionaleOPSessionFactory";
	public static final String TX_MANAGER = "gestionaleOPTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.bysoftware.ct.model.CMR"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.bysoftware.ct.model.CMR"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.bysoftware.ct.model.CMR"),
			true);
	public static long ANNO_COLUMN_BITMASK = 1L;
	public static long IDASSOCIATO_COLUMN_BITMASK = 2L;
	public static long NUMERODOCUMENTO_COLUMN_BITMASK = 4L;
	public static long NUMEROCMR_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CMR toModel(CMRSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CMR model = new CMRImpl();

		model.setNumeroCMR(soapModel.getNumeroCMR());
		model.setAnno(soapModel.getAnno());
		model.setNumeroDocumento(soapModel.getNumeroDocumento());
		model.setIdAssociato(soapModel.getIdAssociato());
		model.setRiserve(soapModel.getRiserve());
		model.setAllegati(soapModel.getAllegati());
		model.setClasse(soapModel.getClasse());
		model.setCifra(soapModel.getCifra());
		model.setLettera(soapModel.getLettera());
		model.setAdr(soapModel.getAdr());
		model.setIstruzioni(soapModel.getIstruzioni());
		model.setConvenzioni(soapModel.getConvenzioni());
		model.setRimborso(soapModel.getRimborso());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CMR> toModels(CMRSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CMR> models = new ArrayList<CMR>(soapModels.length);

		for (CMRSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.bysoftware.ct.model.CMR"));

	public CMRModelImpl() {
	}

	@Override
	public CMRPK getPrimaryKey() {
		return new CMRPK(_numeroCMR, _anno, _numeroDocumento, _idAssociato);
	}

	@Override
	public void setPrimaryKey(CMRPK primaryKey) {
		setNumeroCMR(primaryKey.numeroCMR);
		setAnno(primaryKey.anno);
		setNumeroDocumento(primaryKey.numeroDocumento);
		setIdAssociato(primaryKey.idAssociato);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new CMRPK(_numeroCMR, _anno, _numeroDocumento, _idAssociato);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((CMRPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return CMR.class;
	}

	@Override
	public String getModelClassName() {
		return CMR.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("numeroCMR", getNumeroCMR());
		attributes.put("anno", getAnno());
		attributes.put("numeroDocumento", getNumeroDocumento());
		attributes.put("idAssociato", getIdAssociato());
		attributes.put("riserve", getRiserve());
		attributes.put("allegati", getAllegati());
		attributes.put("classe", getClasse());
		attributes.put("cifra", getCifra());
		attributes.put("lettera", getLettera());
		attributes.put("adr", getAdr());
		attributes.put("istruzioni", getIstruzioni());
		attributes.put("convenzioni", getConvenzioni());
		attributes.put("rimborso", getRimborso());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long numeroCMR = (Long)attributes.get("numeroCMR");

		if (numeroCMR != null) {
			setNumeroCMR(numeroCMR);
		}

		Integer anno = (Integer)attributes.get("anno");

		if (anno != null) {
			setAnno(anno);
		}

		Long numeroDocumento = (Long)attributes.get("numeroDocumento");

		if (numeroDocumento != null) {
			setNumeroDocumento(numeroDocumento);
		}

		Long idAssociato = (Long)attributes.get("idAssociato");

		if (idAssociato != null) {
			setIdAssociato(idAssociato);
		}

		String riserve = (String)attributes.get("riserve");

		if (riserve != null) {
			setRiserve(riserve);
		}

		String allegati = (String)attributes.get("allegati");

		if (allegati != null) {
			setAllegati(allegati);
		}

		String classe = (String)attributes.get("classe");

		if (classe != null) {
			setClasse(classe);
		}

		String cifra = (String)attributes.get("cifra");

		if (cifra != null) {
			setCifra(cifra);
		}

		String lettera = (String)attributes.get("lettera");

		if (lettera != null) {
			setLettera(lettera);
		}

		String adr = (String)attributes.get("adr");

		if (adr != null) {
			setAdr(adr);
		}

		String istruzioni = (String)attributes.get("istruzioni");

		if (istruzioni != null) {
			setIstruzioni(istruzioni);
		}

		String convenzioni = (String)attributes.get("convenzioni");

		if (convenzioni != null) {
			setConvenzioni(convenzioni);
		}

		String rimborso = (String)attributes.get("rimborso");

		if (rimborso != null) {
			setRimborso(rimborso);
		}
	}

	@JSON
	@Override
	public long getNumeroCMR() {
		return _numeroCMR;
	}

	@Override
	public void setNumeroCMR(long numeroCMR) {
		_columnBitmask = -1L;

		_numeroCMR = numeroCMR;
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
	public long getNumeroDocumento() {
		return _numeroDocumento;
	}

	@Override
	public void setNumeroDocumento(long numeroDocumento) {
		_columnBitmask |= NUMERODOCUMENTO_COLUMN_BITMASK;

		if (!_setOriginalNumeroDocumento) {
			_setOriginalNumeroDocumento = true;

			_originalNumeroDocumento = _numeroDocumento;
		}

		_numeroDocumento = numeroDocumento;
	}

	public long getOriginalNumeroDocumento() {
		return _originalNumeroDocumento;
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

	@JSON
	@Override
	public String getRiserve() {
		if (_riserve == null) {
			return StringPool.BLANK;
		}
		else {
			return _riserve;
		}
	}

	@Override
	public void setRiserve(String riserve) {
		_riserve = riserve;
	}

	@JSON
	@Override
	public String getAllegati() {
		if (_allegati == null) {
			return StringPool.BLANK;
		}
		else {
			return _allegati;
		}
	}

	@Override
	public void setAllegati(String allegati) {
		_allegati = allegati;
	}

	@JSON
	@Override
	public String getClasse() {
		if (_classe == null) {
			return StringPool.BLANK;
		}
		else {
			return _classe;
		}
	}

	@Override
	public void setClasse(String classe) {
		_classe = classe;
	}

	@JSON
	@Override
	public String getCifra() {
		if (_cifra == null) {
			return StringPool.BLANK;
		}
		else {
			return _cifra;
		}
	}

	@Override
	public void setCifra(String cifra) {
		_cifra = cifra;
	}

	@JSON
	@Override
	public String getLettera() {
		if (_lettera == null) {
			return StringPool.BLANK;
		}
		else {
			return _lettera;
		}
	}

	@Override
	public void setLettera(String lettera) {
		_lettera = lettera;
	}

	@JSON
	@Override
	public String getAdr() {
		if (_adr == null) {
			return StringPool.BLANK;
		}
		else {
			return _adr;
		}
	}

	@Override
	public void setAdr(String adr) {
		_adr = adr;
	}

	@JSON
	@Override
	public String getIstruzioni() {
		if (_istruzioni == null) {
			return StringPool.BLANK;
		}
		else {
			return _istruzioni;
		}
	}

	@Override
	public void setIstruzioni(String istruzioni) {
		_istruzioni = istruzioni;
	}

	@JSON
	@Override
	public String getConvenzioni() {
		if (_convenzioni == null) {
			return StringPool.BLANK;
		}
		else {
			return _convenzioni;
		}
	}

	@Override
	public void setConvenzioni(String convenzioni) {
		_convenzioni = convenzioni;
	}

	@JSON
	@Override
	public String getRimborso() {
		if (_rimborso == null) {
			return StringPool.BLANK;
		}
		else {
			return _rimborso;
		}
	}

	@Override
	public void setRimborso(String rimborso) {
		_rimborso = rimborso;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public CMR toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CMR)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CMRImpl cmrImpl = new CMRImpl();

		cmrImpl.setNumeroCMR(getNumeroCMR());
		cmrImpl.setAnno(getAnno());
		cmrImpl.setNumeroDocumento(getNumeroDocumento());
		cmrImpl.setIdAssociato(getIdAssociato());
		cmrImpl.setRiserve(getRiserve());
		cmrImpl.setAllegati(getAllegati());
		cmrImpl.setClasse(getClasse());
		cmrImpl.setCifra(getCifra());
		cmrImpl.setLettera(getLettera());
		cmrImpl.setAdr(getAdr());
		cmrImpl.setIstruzioni(getIstruzioni());
		cmrImpl.setConvenzioni(getConvenzioni());
		cmrImpl.setRimborso(getRimborso());

		cmrImpl.resetOriginalValues();

		return cmrImpl;
	}

	@Override
	public int compareTo(CMR cmr) {
		int value = 0;

		if (getNumeroCMR() < cmr.getNumeroCMR()) {
			value = -1;
		}
		else if (getNumeroCMR() > cmr.getNumeroCMR()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

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

		if (!(obj instanceof CMR)) {
			return false;
		}

		CMR cmr = (CMR)obj;

		CMRPK primaryKey = cmr.getPrimaryKey();

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
		CMRModelImpl cmrModelImpl = this;

		cmrModelImpl._originalAnno = cmrModelImpl._anno;

		cmrModelImpl._setOriginalAnno = false;

		cmrModelImpl._originalNumeroDocumento = cmrModelImpl._numeroDocumento;

		cmrModelImpl._setOriginalNumeroDocumento = false;

		cmrModelImpl._originalIdAssociato = cmrModelImpl._idAssociato;

		cmrModelImpl._setOriginalIdAssociato = false;

		cmrModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CMR> toCacheModel() {
		CMRCacheModel cmrCacheModel = new CMRCacheModel();

		cmrCacheModel.numeroCMR = getNumeroCMR();

		cmrCacheModel.anno = getAnno();

		cmrCacheModel.numeroDocumento = getNumeroDocumento();

		cmrCacheModel.idAssociato = getIdAssociato();

		cmrCacheModel.riserve = getRiserve();

		String riserve = cmrCacheModel.riserve;

		if ((riserve != null) && (riserve.length() == 0)) {
			cmrCacheModel.riserve = null;
		}

		cmrCacheModel.allegati = getAllegati();

		String allegati = cmrCacheModel.allegati;

		if ((allegati != null) && (allegati.length() == 0)) {
			cmrCacheModel.allegati = null;
		}

		cmrCacheModel.classe = getClasse();

		String classe = cmrCacheModel.classe;

		if ((classe != null) && (classe.length() == 0)) {
			cmrCacheModel.classe = null;
		}

		cmrCacheModel.cifra = getCifra();

		String cifra = cmrCacheModel.cifra;

		if ((cifra != null) && (cifra.length() == 0)) {
			cmrCacheModel.cifra = null;
		}

		cmrCacheModel.lettera = getLettera();

		String lettera = cmrCacheModel.lettera;

		if ((lettera != null) && (lettera.length() == 0)) {
			cmrCacheModel.lettera = null;
		}

		cmrCacheModel.adr = getAdr();

		String adr = cmrCacheModel.adr;

		if ((adr != null) && (adr.length() == 0)) {
			cmrCacheModel.adr = null;
		}

		cmrCacheModel.istruzioni = getIstruzioni();

		String istruzioni = cmrCacheModel.istruzioni;

		if ((istruzioni != null) && (istruzioni.length() == 0)) {
			cmrCacheModel.istruzioni = null;
		}

		cmrCacheModel.convenzioni = getConvenzioni();

		String convenzioni = cmrCacheModel.convenzioni;

		if ((convenzioni != null) && (convenzioni.length() == 0)) {
			cmrCacheModel.convenzioni = null;
		}

		cmrCacheModel.rimborso = getRimborso();

		String rimborso = cmrCacheModel.rimborso;

		if ((rimborso != null) && (rimborso.length() == 0)) {
			cmrCacheModel.rimborso = null;
		}

		return cmrCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{numeroCMR=");
		sb.append(getNumeroCMR());
		sb.append(", anno=");
		sb.append(getAnno());
		sb.append(", numeroDocumento=");
		sb.append(getNumeroDocumento());
		sb.append(", idAssociato=");
		sb.append(getIdAssociato());
		sb.append(", riserve=");
		sb.append(getRiserve());
		sb.append(", allegati=");
		sb.append(getAllegati());
		sb.append(", classe=");
		sb.append(getClasse());
		sb.append(", cifra=");
		sb.append(getCifra());
		sb.append(", lettera=");
		sb.append(getLettera());
		sb.append(", adr=");
		sb.append(getAdr());
		sb.append(", istruzioni=");
		sb.append(getIstruzioni());
		sb.append(", convenzioni=");
		sb.append(getConvenzioni());
		sb.append(", rimborso=");
		sb.append(getRimborso());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("it.bysoftware.ct.model.CMR");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>numeroCMR</column-name><column-value><![CDATA[");
		sb.append(getNumeroCMR());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>anno</column-name><column-value><![CDATA[");
		sb.append(getAnno());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numeroDocumento</column-name><column-value><![CDATA[");
		sb.append(getNumeroDocumento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idAssociato</column-name><column-value><![CDATA[");
		sb.append(getIdAssociato());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>riserve</column-name><column-value><![CDATA[");
		sb.append(getRiserve());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>allegati</column-name><column-value><![CDATA[");
		sb.append(getAllegati());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classe</column-name><column-value><![CDATA[");
		sb.append(getClasse());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cifra</column-name><column-value><![CDATA[");
		sb.append(getCifra());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lettera</column-name><column-value><![CDATA[");
		sb.append(getLettera());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>adr</column-name><column-value><![CDATA[");
		sb.append(getAdr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>istruzioni</column-name><column-value><![CDATA[");
		sb.append(getIstruzioni());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>convenzioni</column-name><column-value><![CDATA[");
		sb.append(getConvenzioni());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rimborso</column-name><column-value><![CDATA[");
		sb.append(getRimborso());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = CMR.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { CMR.class };
	private long _numeroCMR;
	private int _anno;
	private int _originalAnno;
	private boolean _setOriginalAnno;
	private long _numeroDocumento;
	private long _originalNumeroDocumento;
	private boolean _setOriginalNumeroDocumento;
	private long _idAssociato;
	private long _originalIdAssociato;
	private boolean _setOriginalIdAssociato;
	private String _riserve;
	private String _allegati;
	private String _classe;
	private String _cifra;
	private String _lettera;
	private String _adr;
	private String _istruzioni;
	private String _convenzioni;
	private String _rimborso;
	private long _columnBitmask;
	private CMR _escapedModel;
}
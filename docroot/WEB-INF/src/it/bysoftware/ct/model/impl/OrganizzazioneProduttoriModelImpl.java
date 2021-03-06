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
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import it.bysoftware.ct.model.OrganizzazioneProduttori;
import it.bysoftware.ct.model.OrganizzazioneProduttoriModel;
import it.bysoftware.ct.model.OrganizzazioneProduttoriSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the OrganizzazioneProduttori service. Represents a row in the &quot;op&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.bysoftware.ct.model.OrganizzazioneProduttoriModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link OrganizzazioneProduttoriImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizzazioneProduttoriImpl
 * @see it.bysoftware.ct.model.OrganizzazioneProduttori
 * @see it.bysoftware.ct.model.OrganizzazioneProduttoriModel
 * @generated
 */
@JSON(strict = true)
public class OrganizzazioneProduttoriModelImpl extends BaseModelImpl<OrganizzazioneProduttori>
	implements OrganizzazioneProduttoriModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a organizzazione produttori model instance should use the {@link it.bysoftware.ct.model.OrganizzazioneProduttori} interface instead.
	 */
	public static final String TABLE_NAME = "op";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", Types.BIGINT },
			{ "ragione_sociale", Types.VARCHAR },
			{ "partita_iva", Types.VARCHAR },
			{ "indirizzo", Types.VARCHAR },
			{ "telefono", Types.VARCHAR },
			{ "fax", Types.VARCHAR },
			{ "sito_web", Types.VARCHAR },
			{ "email", Types.VARCHAR },
			{ "password", Types.VARCHAR },
			{ "id_liferay", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table op (id LONG not null primary key,ragione_sociale VARCHAR(75) null,partita_iva VARCHAR(75) null,indirizzo VARCHAR(75) null,telefono VARCHAR(75) null,fax VARCHAR(75) null,sito_web VARCHAR(75) null,email VARCHAR(75) null,password VARCHAR(75) null,id_liferay LONG)";
	public static final String TABLE_SQL_DROP = "drop table op";
	public static final String ORDER_BY_JPQL = " ORDER BY organizzazioneProduttori.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY op.id ASC";
	public static final String DATA_SOURCE = "gestionaleOPDataSource";
	public static final String SESSION_FACTORY = "gestionaleOPSessionFactory";
	public static final String TX_MANAGER = "gestionaleOPTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.bysoftware.ct.model.OrganizzazioneProduttori"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.bysoftware.ct.model.OrganizzazioneProduttori"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.bysoftware.ct.model.OrganizzazioneProduttori"),
			true);
	public static long EMAIL_COLUMN_BITMASK = 1L;
	public static long IDLIFERAY_COLUMN_BITMASK = 2L;
	public static long PARTITAIVA_COLUMN_BITMASK = 4L;
	public static long RAGIONESOCIALE_COLUMN_BITMASK = 8L;
	public static long ID_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static OrganizzazioneProduttori toModel(
		OrganizzazioneProduttoriSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		OrganizzazioneProduttori model = new OrganizzazioneProduttoriImpl();

		model.setId(soapModel.getId());
		model.setRagioneSociale(soapModel.getRagioneSociale());
		model.setPartitaIVA(soapModel.getPartitaIVA());
		model.setIndirizzo(soapModel.getIndirizzo());
		model.setTelefono(soapModel.getTelefono());
		model.setFax(soapModel.getFax());
		model.setSitoWeb(soapModel.getSitoWeb());
		model.setEmail(soapModel.getEmail());
		model.setPassword(soapModel.getPassword());
		model.setIdLiferay(soapModel.getIdLiferay());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<OrganizzazioneProduttori> toModels(
		OrganizzazioneProduttoriSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<OrganizzazioneProduttori> models = new ArrayList<OrganizzazioneProduttori>(soapModels.length);

		for (OrganizzazioneProduttoriSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.bysoftware.ct.model.OrganizzazioneProduttori"));

	public OrganizzazioneProduttoriModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return OrganizzazioneProduttori.class;
	}

	@Override
	public String getModelClassName() {
		return OrganizzazioneProduttori.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("ragioneSociale", getRagioneSociale());
		attributes.put("partitaIVA", getPartitaIVA());
		attributes.put("indirizzo", getIndirizzo());
		attributes.put("telefono", getTelefono());
		attributes.put("fax", getFax());
		attributes.put("sitoWeb", getSitoWeb());
		attributes.put("email", getEmail());
		attributes.put("password", getPassword());
		attributes.put("idLiferay", getIdLiferay());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String ragioneSociale = (String)attributes.get("ragioneSociale");

		if (ragioneSociale != null) {
			setRagioneSociale(ragioneSociale);
		}

		String partitaIVA = (String)attributes.get("partitaIVA");

		if (partitaIVA != null) {
			setPartitaIVA(partitaIVA);
		}

		String indirizzo = (String)attributes.get("indirizzo");

		if (indirizzo != null) {
			setIndirizzo(indirizzo);
		}

		String telefono = (String)attributes.get("telefono");

		if (telefono != null) {
			setTelefono(telefono);
		}

		String fax = (String)attributes.get("fax");

		if (fax != null) {
			setFax(fax);
		}

		String sitoWeb = (String)attributes.get("sitoWeb");

		if (sitoWeb != null) {
			setSitoWeb(sitoWeb);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		Long idLiferay = (Long)attributes.get("idLiferay");

		if (idLiferay != null) {
			setIdLiferay(idLiferay);
		}
	}

	@JSON
	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
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
		_columnBitmask |= RAGIONESOCIALE_COLUMN_BITMASK;

		if (_originalRagioneSociale == null) {
			_originalRagioneSociale = _ragioneSociale;
		}

		_ragioneSociale = ragioneSociale;
	}

	public String getOriginalRagioneSociale() {
		return GetterUtil.getString(_originalRagioneSociale);
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
		_columnBitmask |= PARTITAIVA_COLUMN_BITMASK;

		if (_originalPartitaIVA == null) {
			_originalPartitaIVA = _partitaIVA;
		}

		_partitaIVA = partitaIVA;
	}

	public String getOriginalPartitaIVA() {
		return GetterUtil.getString(_originalPartitaIVA);
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
	public String getTelefono() {
		if (_telefono == null) {
			return StringPool.BLANK;
		}
		else {
			return _telefono;
		}
	}

	@Override
	public void setTelefono(String telefono) {
		_telefono = telefono;
	}

	@JSON
	@Override
	public String getFax() {
		if (_fax == null) {
			return StringPool.BLANK;
		}
		else {
			return _fax;
		}
	}

	@Override
	public void setFax(String fax) {
		_fax = fax;
	}

	@JSON
	@Override
	public String getSitoWeb() {
		if (_sitoWeb == null) {
			return StringPool.BLANK;
		}
		else {
			return _sitoWeb;
		}
	}

	@Override
	public void setSitoWeb(String sitoWeb) {
		_sitoWeb = sitoWeb;
	}

	@JSON
	@Override
	public String getEmail() {
		if (_email == null) {
			return StringPool.BLANK;
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		_columnBitmask |= EMAIL_COLUMN_BITMASK;

		if (_originalEmail == null) {
			_originalEmail = _email;
		}

		_email = email;
	}

	public String getOriginalEmail() {
		return GetterUtil.getString(_originalEmail);
	}

	@JSON
	@Override
	public String getPassword() {
		if (_password == null) {
			return StringPool.BLANK;
		}
		else {
			return _password;
		}
	}

	@Override
	public void setPassword(String password) {
		_password = password;
	}

	@JSON
	@Override
	public long getIdLiferay() {
		return _idLiferay;
	}

	@Override
	public void setIdLiferay(long idLiferay) {
		_columnBitmask |= IDLIFERAY_COLUMN_BITMASK;

		if (!_setOriginalIdLiferay) {
			_setOriginalIdLiferay = true;

			_originalIdLiferay = _idLiferay;
		}

		_idLiferay = idLiferay;
	}

	public long getOriginalIdLiferay() {
		return _originalIdLiferay;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			OrganizzazioneProduttori.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public OrganizzazioneProduttori toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (OrganizzazioneProduttori)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		OrganizzazioneProduttoriImpl organizzazioneProduttoriImpl = new OrganizzazioneProduttoriImpl();

		organizzazioneProduttoriImpl.setId(getId());
		organizzazioneProduttoriImpl.setRagioneSociale(getRagioneSociale());
		organizzazioneProduttoriImpl.setPartitaIVA(getPartitaIVA());
		organizzazioneProduttoriImpl.setIndirizzo(getIndirizzo());
		organizzazioneProduttoriImpl.setTelefono(getTelefono());
		organizzazioneProduttoriImpl.setFax(getFax());
		organizzazioneProduttoriImpl.setSitoWeb(getSitoWeb());
		organizzazioneProduttoriImpl.setEmail(getEmail());
		organizzazioneProduttoriImpl.setPassword(getPassword());
		organizzazioneProduttoriImpl.setIdLiferay(getIdLiferay());

		organizzazioneProduttoriImpl.resetOriginalValues();

		return organizzazioneProduttoriImpl;
	}

	@Override
	public int compareTo(OrganizzazioneProduttori organizzazioneProduttori) {
		long primaryKey = organizzazioneProduttori.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OrganizzazioneProduttori)) {
			return false;
		}

		OrganizzazioneProduttori organizzazioneProduttori = (OrganizzazioneProduttori)obj;

		long primaryKey = organizzazioneProduttori.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		OrganizzazioneProduttoriModelImpl organizzazioneProduttoriModelImpl = this;

		organizzazioneProduttoriModelImpl._originalRagioneSociale = organizzazioneProduttoriModelImpl._ragioneSociale;

		organizzazioneProduttoriModelImpl._originalPartitaIVA = organizzazioneProduttoriModelImpl._partitaIVA;

		organizzazioneProduttoriModelImpl._originalEmail = organizzazioneProduttoriModelImpl._email;

		organizzazioneProduttoriModelImpl._originalIdLiferay = organizzazioneProduttoriModelImpl._idLiferay;

		organizzazioneProduttoriModelImpl._setOriginalIdLiferay = false;

		organizzazioneProduttoriModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<OrganizzazioneProduttori> toCacheModel() {
		OrganizzazioneProduttoriCacheModel organizzazioneProduttoriCacheModel = new OrganizzazioneProduttoriCacheModel();

		organizzazioneProduttoriCacheModel.id = getId();

		organizzazioneProduttoriCacheModel.ragioneSociale = getRagioneSociale();

		String ragioneSociale = organizzazioneProduttoriCacheModel.ragioneSociale;

		if ((ragioneSociale != null) && (ragioneSociale.length() == 0)) {
			organizzazioneProduttoriCacheModel.ragioneSociale = null;
		}

		organizzazioneProduttoriCacheModel.partitaIVA = getPartitaIVA();

		String partitaIVA = organizzazioneProduttoriCacheModel.partitaIVA;

		if ((partitaIVA != null) && (partitaIVA.length() == 0)) {
			organizzazioneProduttoriCacheModel.partitaIVA = null;
		}

		organizzazioneProduttoriCacheModel.indirizzo = getIndirizzo();

		String indirizzo = organizzazioneProduttoriCacheModel.indirizzo;

		if ((indirizzo != null) && (indirizzo.length() == 0)) {
			organizzazioneProduttoriCacheModel.indirizzo = null;
		}

		organizzazioneProduttoriCacheModel.telefono = getTelefono();

		String telefono = organizzazioneProduttoriCacheModel.telefono;

		if ((telefono != null) && (telefono.length() == 0)) {
			organizzazioneProduttoriCacheModel.telefono = null;
		}

		organizzazioneProduttoriCacheModel.fax = getFax();

		String fax = organizzazioneProduttoriCacheModel.fax;

		if ((fax != null) && (fax.length() == 0)) {
			organizzazioneProduttoriCacheModel.fax = null;
		}

		organizzazioneProduttoriCacheModel.sitoWeb = getSitoWeb();

		String sitoWeb = organizzazioneProduttoriCacheModel.sitoWeb;

		if ((sitoWeb != null) && (sitoWeb.length() == 0)) {
			organizzazioneProduttoriCacheModel.sitoWeb = null;
		}

		organizzazioneProduttoriCacheModel.email = getEmail();

		String email = organizzazioneProduttoriCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			organizzazioneProduttoriCacheModel.email = null;
		}

		organizzazioneProduttoriCacheModel.password = getPassword();

		String password = organizzazioneProduttoriCacheModel.password;

		if ((password != null) && (password.length() == 0)) {
			organizzazioneProduttoriCacheModel.password = null;
		}

		organizzazioneProduttoriCacheModel.idLiferay = getIdLiferay();

		return organizzazioneProduttoriCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", ragioneSociale=");
		sb.append(getRagioneSociale());
		sb.append(", partitaIVA=");
		sb.append(getPartitaIVA());
		sb.append(", indirizzo=");
		sb.append(getIndirizzo());
		sb.append(", telefono=");
		sb.append(getTelefono());
		sb.append(", fax=");
		sb.append(getFax());
		sb.append(", sitoWeb=");
		sb.append(getSitoWeb());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", password=");
		sb.append(getPassword());
		sb.append(", idLiferay=");
		sb.append(getIdLiferay());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("it.bysoftware.ct.model.OrganizzazioneProduttori");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ragioneSociale</column-name><column-value><![CDATA[");
		sb.append(getRagioneSociale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>partitaIVA</column-name><column-value><![CDATA[");
		sb.append(getPartitaIVA());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>indirizzo</column-name><column-value><![CDATA[");
		sb.append(getIndirizzo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>telefono</column-name><column-value><![CDATA[");
		sb.append(getTelefono());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fax</column-name><column-value><![CDATA[");
		sb.append(getFax());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sitoWeb</column-name><column-value><![CDATA[");
		sb.append(getSitoWeb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>password</column-name><column-value><![CDATA[");
		sb.append(getPassword());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idLiferay</column-name><column-value><![CDATA[");
		sb.append(getIdLiferay());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = OrganizzazioneProduttori.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			OrganizzazioneProduttori.class
		};
	private long _id;
	private String _ragioneSociale;
	private String _originalRagioneSociale;
	private String _partitaIVA;
	private String _originalPartitaIVA;
	private String _indirizzo;
	private String _telefono;
	private String _fax;
	private String _sitoWeb;
	private String _email;
	private String _originalEmail;
	private String _password;
	private long _idLiferay;
	private long _originalIdLiferay;
	private boolean _setOriginalIdLiferay;
	private long _columnBitmask;
	private OrganizzazioneProduttori _escapedModel;
}
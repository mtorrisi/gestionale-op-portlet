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

import it.bysoftware.ct.model.Associato;
import it.bysoftware.ct.model.AssociatoModel;
import it.bysoftware.ct.model.AssociatoSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Associato service. Represents a row in the &quot;associato&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.bysoftware.ct.model.AssociatoModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AssociatoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssociatoImpl
 * @see it.bysoftware.ct.model.Associato
 * @see it.bysoftware.ct.model.AssociatoModel
 * @generated
 */
@JSON(strict = true)
public class AssociatoModelImpl extends BaseModelImpl<Associato>
	implements AssociatoModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a associato model instance should use the {@link it.bysoftware.ct.model.Associato} interface instead.
	 */
	public static final String TABLE_NAME = "associato";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", Types.BIGINT },
			{ "centro", Types.VARCHAR },
			{ "ragione_sociale", Types.VARCHAR },
			{ "partita_iva", Types.VARCHAR },
			{ "indirizzo", Types.VARCHAR },
			{ "telefono", Types.VARCHAR },
			{ "fax", Types.VARCHAR },
			{ "email", Types.VARCHAR },
			{ "password", Types.VARCHAR },
			{ "id_liferay", Types.BIGINT },
			{ "id_op", Types.BIGINT },
			{ "attivo", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table associato (id LONG not null primary key,centro VARCHAR(75) null,ragione_sociale VARCHAR(75) null,partita_iva VARCHAR(75) null,indirizzo VARCHAR(75) null,telefono VARCHAR(75) null,fax VARCHAR(75) null,email VARCHAR(75) null,password VARCHAR(75) null,id_liferay LONG,id_op LONG,attivo BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table associato";
	public static final String ORDER_BY_JPQL = " ORDER BY associato.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY associato.id ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.bysoftware.ct.model.Associato"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.bysoftware.ct.model.Associato"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.bysoftware.ct.model.Associato"),
			true);
	public static long PARTITAIVA_COLUMN_BITMASK = 1L;
	public static long RAGIONESOCIALE_COLUMN_BITMASK = 2L;
	public static long ID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Associato toModel(AssociatoSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Associato model = new AssociatoImpl();

		model.setId(soapModel.getId());
		model.setCentro(soapModel.getCentro());
		model.setRagioneSociale(soapModel.getRagioneSociale());
		model.setPartitaIVA(soapModel.getPartitaIVA());
		model.setIndirizzo(soapModel.getIndirizzo());
		model.setTelefono(soapModel.getTelefono());
		model.setFax(soapModel.getFax());
		model.setEmail(soapModel.getEmail());
		model.setPassword(soapModel.getPassword());
		model.setIdLiferay(soapModel.getIdLiferay());
		model.setIdOp(soapModel.getIdOp());
		model.setAttivo(soapModel.getAttivo());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Associato> toModels(AssociatoSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Associato> models = new ArrayList<Associato>(soapModels.length);

		for (AssociatoSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.bysoftware.ct.model.Associato"));

	public AssociatoModelImpl() {
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
		return Associato.class;
	}

	@Override
	public String getModelClassName() {
		return Associato.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("centro", getCentro());
		attributes.put("ragioneSociale", getRagioneSociale());
		attributes.put("partitaIVA", getPartitaIVA());
		attributes.put("indirizzo", getIndirizzo());
		attributes.put("telefono", getTelefono());
		attributes.put("fax", getFax());
		attributes.put("email", getEmail());
		attributes.put("password", getPassword());
		attributes.put("idLiferay", getIdLiferay());
		attributes.put("idOp", getIdOp());
		attributes.put("attivo", getAttivo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String centro = (String)attributes.get("centro");

		if (centro != null) {
			setCentro(centro);
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

		Long idOp = (Long)attributes.get("idOp");

		if (idOp != null) {
			setIdOp(idOp);
		}

		Boolean attivo = (Boolean)attributes.get("attivo");

		if (attivo != null) {
			setAttivo(attivo);
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
	public String getCentro() {
		if (_centro == null) {
			return StringPool.BLANK;
		}
		else {
			return _centro;
		}
	}

	@Override
	public void setCentro(String centro) {
		_centro = centro;
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
		_email = email;
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
		_idLiferay = idLiferay;
	}

	@JSON
	@Override
	public long getIdOp() {
		return _idOp;
	}

	@Override
	public void setIdOp(long idOp) {
		_idOp = idOp;
	}

	@JSON
	@Override
	public boolean getAttivo() {
		return _attivo;
	}

	@Override
	public boolean isAttivo() {
		return _attivo;
	}

	@Override
	public void setAttivo(boolean attivo) {
		_attivo = attivo;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Associato.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Associato toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Associato)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AssociatoImpl associatoImpl = new AssociatoImpl();

		associatoImpl.setId(getId());
		associatoImpl.setCentro(getCentro());
		associatoImpl.setRagioneSociale(getRagioneSociale());
		associatoImpl.setPartitaIVA(getPartitaIVA());
		associatoImpl.setIndirizzo(getIndirizzo());
		associatoImpl.setTelefono(getTelefono());
		associatoImpl.setFax(getFax());
		associatoImpl.setEmail(getEmail());
		associatoImpl.setPassword(getPassword());
		associatoImpl.setIdLiferay(getIdLiferay());
		associatoImpl.setIdOp(getIdOp());
		associatoImpl.setAttivo(getAttivo());

		associatoImpl.resetOriginalValues();

		return associatoImpl;
	}

	@Override
	public int compareTo(Associato associato) {
		long primaryKey = associato.getPrimaryKey();

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

		if (!(obj instanceof Associato)) {
			return false;
		}

		Associato associato = (Associato)obj;

		long primaryKey = associato.getPrimaryKey();

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
		AssociatoModelImpl associatoModelImpl = this;

		associatoModelImpl._originalRagioneSociale = associatoModelImpl._ragioneSociale;

		associatoModelImpl._originalPartitaIVA = associatoModelImpl._partitaIVA;

		associatoModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Associato> toCacheModel() {
		AssociatoCacheModel associatoCacheModel = new AssociatoCacheModel();

		associatoCacheModel.id = getId();

		associatoCacheModel.centro = getCentro();

		String centro = associatoCacheModel.centro;

		if ((centro != null) && (centro.length() == 0)) {
			associatoCacheModel.centro = null;
		}

		associatoCacheModel.ragioneSociale = getRagioneSociale();

		String ragioneSociale = associatoCacheModel.ragioneSociale;

		if ((ragioneSociale != null) && (ragioneSociale.length() == 0)) {
			associatoCacheModel.ragioneSociale = null;
		}

		associatoCacheModel.partitaIVA = getPartitaIVA();

		String partitaIVA = associatoCacheModel.partitaIVA;

		if ((partitaIVA != null) && (partitaIVA.length() == 0)) {
			associatoCacheModel.partitaIVA = null;
		}

		associatoCacheModel.indirizzo = getIndirizzo();

		String indirizzo = associatoCacheModel.indirizzo;

		if ((indirizzo != null) && (indirizzo.length() == 0)) {
			associatoCacheModel.indirizzo = null;
		}

		associatoCacheModel.telefono = getTelefono();

		String telefono = associatoCacheModel.telefono;

		if ((telefono != null) && (telefono.length() == 0)) {
			associatoCacheModel.telefono = null;
		}

		associatoCacheModel.fax = getFax();

		String fax = associatoCacheModel.fax;

		if ((fax != null) && (fax.length() == 0)) {
			associatoCacheModel.fax = null;
		}

		associatoCacheModel.email = getEmail();

		String email = associatoCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			associatoCacheModel.email = null;
		}

		associatoCacheModel.password = getPassword();

		String password = associatoCacheModel.password;

		if ((password != null) && (password.length() == 0)) {
			associatoCacheModel.password = null;
		}

		associatoCacheModel.idLiferay = getIdLiferay();

		associatoCacheModel.idOp = getIdOp();

		associatoCacheModel.attivo = getAttivo();

		return associatoCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", centro=");
		sb.append(getCentro());
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
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", password=");
		sb.append(getPassword());
		sb.append(", idLiferay=");
		sb.append(getIdLiferay());
		sb.append(", idOp=");
		sb.append(getIdOp());
		sb.append(", attivo=");
		sb.append(getAttivo());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("it.bysoftware.ct.model.Associato");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>centro</column-name><column-value><![CDATA[");
		sb.append(getCentro());
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
		sb.append(
			"<column><column-name>idOp</column-name><column-value><![CDATA[");
		sb.append(getIdOp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attivo</column-name><column-value><![CDATA[");
		sb.append(getAttivo());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Associato.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Associato.class
		};
	private long _id;
	private String _centro;
	private String _ragioneSociale;
	private String _originalRagioneSociale;
	private String _partitaIVA;
	private String _originalPartitaIVA;
	private String _indirizzo;
	private String _telefono;
	private String _fax;
	private String _email;
	private String _password;
	private long _idLiferay;
	private long _idOp;
	private boolean _attivo;
	private long _columnBitmask;
	private Associato _escapedModel;
}
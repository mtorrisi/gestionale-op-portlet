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

import it.bysoftware.ct.model.Iva;
import it.bysoftware.ct.model.IvaModel;
import it.bysoftware.ct.model.IvaSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Iva service. Represents a row in the &quot;VociIva&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.bysoftware.ct.model.IvaModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link IvaImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IvaImpl
 * @see it.bysoftware.ct.model.Iva
 * @see it.bysoftware.ct.model.IvaModel
 * @generated
 */
@JSON(strict = true)
public class IvaModelImpl extends BaseModelImpl<Iva> implements IvaModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a iva model instance should use the {@link it.bysoftware.ct.model.Iva} interface instead.
	 */
	public static final String TABLE_NAME = "VociIva";
	public static final Object[][] TABLE_COLUMNS = {
			{ "RiaCodiva", Types.VARCHAR },
			{ "RiaDescri", Types.VARCHAR },
			{ "RiaDesdoc", Types.VARCHAR },
			{ "RiaAliquo", Types.DOUBLE }
		};
	public static final String TABLE_SQL_CREATE = "create table VociIva (RiaCodiva VARCHAR(75) not null primary key,RiaDescri VARCHAR(75) null,RiaDesdoc VARCHAR(75) null,RiaAliquo DOUBLE)";
	public static final String TABLE_SQL_DROP = "drop table VociIva";
	public static final String ORDER_BY_JPQL = " ORDER BY iva.codiceIva ASC";
	public static final String ORDER_BY_SQL = " ORDER BY VociIva.RiaCodiva ASC";
	public static final String DATA_SOURCE = "gestionaleOPDataSource";
	public static final String SESSION_FACTORY = "gestionaleOPSessionFactory";
	public static final String TX_MANAGER = "gestionaleOPTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.bysoftware.ct.model.Iva"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.bysoftware.ct.model.Iva"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Iva toModel(IvaSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Iva model = new IvaImpl();

		model.setCodiceIva(soapModel.getCodiceIva());
		model.setDescrizione(soapModel.getDescrizione());
		model.setDescrizioneDocumento(soapModel.getDescrizioneDocumento());
		model.setAliquota(soapModel.getAliquota());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Iva> toModels(IvaSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Iva> models = new ArrayList<Iva>(soapModels.length);

		for (IvaSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.bysoftware.ct.model.Iva"));

	public IvaModelImpl() {
	}

	@Override
	public String getPrimaryKey() {
		return _codiceIva;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setCodiceIva(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _codiceIva;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return Iva.class;
	}

	@Override
	public String getModelClassName() {
		return Iva.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("codiceIva", getCodiceIva());
		attributes.put("descrizione", getDescrizione());
		attributes.put("descrizioneDocumento", getDescrizioneDocumento());
		attributes.put("aliquota", getAliquota());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String codiceIva = (String)attributes.get("codiceIva");

		if (codiceIva != null) {
			setCodiceIva(codiceIva);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}

		String descrizioneDocumento = (String)attributes.get(
				"descrizioneDocumento");

		if (descrizioneDocumento != null) {
			setDescrizioneDocumento(descrizioneDocumento);
		}

		Double aliquota = (Double)attributes.get("aliquota");

		if (aliquota != null) {
			setAliquota(aliquota);
		}
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
	public String getDescrizioneDocumento() {
		if (_descrizioneDocumento == null) {
			return StringPool.BLANK;
		}
		else {
			return _descrizioneDocumento;
		}
	}

	@Override
	public void setDescrizioneDocumento(String descrizioneDocumento) {
		_descrizioneDocumento = descrizioneDocumento;
	}

	@JSON
	@Override
	public double getAliquota() {
		return _aliquota;
	}

	@Override
	public void setAliquota(double aliquota) {
		_aliquota = aliquota;
	}

	@Override
	public Iva toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Iva)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		IvaImpl ivaImpl = new IvaImpl();

		ivaImpl.setCodiceIva(getCodiceIva());
		ivaImpl.setDescrizione(getDescrizione());
		ivaImpl.setDescrizioneDocumento(getDescrizioneDocumento());
		ivaImpl.setAliquota(getAliquota());

		ivaImpl.resetOriginalValues();

		return ivaImpl;
	}

	@Override
	public int compareTo(Iva iva) {
		String primaryKey = iva.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Iva)) {
			return false;
		}

		Iva iva = (Iva)obj;

		String primaryKey = iva.getPrimaryKey();

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
	public CacheModel<Iva> toCacheModel() {
		IvaCacheModel ivaCacheModel = new IvaCacheModel();

		ivaCacheModel.codiceIva = getCodiceIva();

		String codiceIva = ivaCacheModel.codiceIva;

		if ((codiceIva != null) && (codiceIva.length() == 0)) {
			ivaCacheModel.codiceIva = null;
		}

		ivaCacheModel.descrizione = getDescrizione();

		String descrizione = ivaCacheModel.descrizione;

		if ((descrizione != null) && (descrizione.length() == 0)) {
			ivaCacheModel.descrizione = null;
		}

		ivaCacheModel.descrizioneDocumento = getDescrizioneDocumento();

		String descrizioneDocumento = ivaCacheModel.descrizioneDocumento;

		if ((descrizioneDocumento != null) &&
				(descrizioneDocumento.length() == 0)) {
			ivaCacheModel.descrizioneDocumento = null;
		}

		ivaCacheModel.aliquota = getAliquota();

		return ivaCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{codiceIva=");
		sb.append(getCodiceIva());
		sb.append(", descrizione=");
		sb.append(getDescrizione());
		sb.append(", descrizioneDocumento=");
		sb.append(getDescrizioneDocumento());
		sb.append(", aliquota=");
		sb.append(getAliquota());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("it.bysoftware.ct.model.Iva");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>codiceIva</column-name><column-value><![CDATA[");
		sb.append(getCodiceIva());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descrizione</column-name><column-value><![CDATA[");
		sb.append(getDescrizione());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descrizioneDocumento</column-name><column-value><![CDATA[");
		sb.append(getDescrizioneDocumento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>aliquota</column-name><column-value><![CDATA[");
		sb.append(getAliquota());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Iva.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Iva.class };
	private String _codiceIva;
	private String _descrizione;
	private String _descrizioneDocumento;
	private double _aliquota;
	private Iva _escapedModel;
}
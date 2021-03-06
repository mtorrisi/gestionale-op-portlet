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

import it.bysoftware.ct.model.CausaleTrasporto;
import it.bysoftware.ct.model.CausaleTrasportoModel;
import it.bysoftware.ct.model.CausaleTrasportoSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CausaleTrasporto service. Represents a row in the &quot;CausaleTrasporto&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.bysoftware.ct.model.CausaleTrasportoModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CausaleTrasportoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CausaleTrasportoImpl
 * @see it.bysoftware.ct.model.CausaleTrasporto
 * @see it.bysoftware.ct.model.CausaleTrasportoModel
 * @generated
 */
@JSON(strict = true)
public class CausaleTrasportoModelImpl extends BaseModelImpl<CausaleTrasporto>
	implements CausaleTrasportoModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a causale trasporto model instance should use the {@link it.bysoftware.ct.model.CausaleTrasporto} interface instead.
	 */
	public static final String TABLE_NAME = "CausaleTrasporto";
	public static final Object[][] TABLE_COLUMNS = {
			{ "RdeCoddes", Types.VARCHAR },
			{ "RdeDescri", Types.VARCHAR },
			{ "RdeCodiaz", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table CausaleTrasporto (RdeCoddes VARCHAR(75) not null primary key,RdeDescri VARCHAR(75) null,RdeCodiaz VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table CausaleTrasporto";
	public static final String ORDER_BY_JPQL = " ORDER BY causaleTrasporto.codiceCausaleTrasporto ASC";
	public static final String ORDER_BY_SQL = " ORDER BY CausaleTrasporto.RdeCoddes ASC";
	public static final String DATA_SOURCE = "gestionaleOPDataSource";
	public static final String SESSION_FACTORY = "gestionaleOPSessionFactory";
	public static final String TX_MANAGER = "gestionaleOPTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.bysoftware.ct.model.CausaleTrasporto"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.bysoftware.ct.model.CausaleTrasporto"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CausaleTrasporto toModel(CausaleTrasportoSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CausaleTrasporto model = new CausaleTrasportoImpl();

		model.setCodiceCausaleTrasporto(soapModel.getCodiceCausaleTrasporto());
		model.setDescrizione(soapModel.getDescrizione());
		model.setCodiceAzienda(soapModel.getCodiceAzienda());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CausaleTrasporto> toModels(
		CausaleTrasportoSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CausaleTrasporto> models = new ArrayList<CausaleTrasporto>(soapModels.length);

		for (CausaleTrasportoSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.bysoftware.ct.model.CausaleTrasporto"));

	public CausaleTrasportoModelImpl() {
	}

	@Override
	public String getPrimaryKey() {
		return _codiceCausaleTrasporto;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setCodiceCausaleTrasporto(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _codiceCausaleTrasporto;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return CausaleTrasporto.class;
	}

	@Override
	public String getModelClassName() {
		return CausaleTrasporto.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("codiceCausaleTrasporto", getCodiceCausaleTrasporto());
		attributes.put("descrizione", getDescrizione());
		attributes.put("codiceAzienda", getCodiceAzienda());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String codiceCausaleTrasporto = (String)attributes.get(
				"codiceCausaleTrasporto");

		if (codiceCausaleTrasporto != null) {
			setCodiceCausaleTrasporto(codiceCausaleTrasporto);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}

		String codiceAzienda = (String)attributes.get("codiceAzienda");

		if (codiceAzienda != null) {
			setCodiceAzienda(codiceAzienda);
		}
	}

	@JSON
	@Override
	public String getCodiceCausaleTrasporto() {
		if (_codiceCausaleTrasporto == null) {
			return StringPool.BLANK;
		}
		else {
			return _codiceCausaleTrasporto;
		}
	}

	@Override
	public void setCodiceCausaleTrasporto(String codiceCausaleTrasporto) {
		_codiceCausaleTrasporto = codiceCausaleTrasporto;
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
	public CausaleTrasporto toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CausaleTrasporto)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CausaleTrasportoImpl causaleTrasportoImpl = new CausaleTrasportoImpl();

		causaleTrasportoImpl.setCodiceCausaleTrasporto(getCodiceCausaleTrasporto());
		causaleTrasportoImpl.setDescrizione(getDescrizione());
		causaleTrasportoImpl.setCodiceAzienda(getCodiceAzienda());

		causaleTrasportoImpl.resetOriginalValues();

		return causaleTrasportoImpl;
	}

	@Override
	public int compareTo(CausaleTrasporto causaleTrasporto) {
		String primaryKey = causaleTrasporto.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CausaleTrasporto)) {
			return false;
		}

		CausaleTrasporto causaleTrasporto = (CausaleTrasporto)obj;

		String primaryKey = causaleTrasporto.getPrimaryKey();

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
	public CacheModel<CausaleTrasporto> toCacheModel() {
		CausaleTrasportoCacheModel causaleTrasportoCacheModel = new CausaleTrasportoCacheModel();

		causaleTrasportoCacheModel.codiceCausaleTrasporto = getCodiceCausaleTrasporto();

		String codiceCausaleTrasporto = causaleTrasportoCacheModel.codiceCausaleTrasporto;

		if ((codiceCausaleTrasporto != null) &&
				(codiceCausaleTrasporto.length() == 0)) {
			causaleTrasportoCacheModel.codiceCausaleTrasporto = null;
		}

		causaleTrasportoCacheModel.descrizione = getDescrizione();

		String descrizione = causaleTrasportoCacheModel.descrizione;

		if ((descrizione != null) && (descrizione.length() == 0)) {
			causaleTrasportoCacheModel.descrizione = null;
		}

		causaleTrasportoCacheModel.codiceAzienda = getCodiceAzienda();

		String codiceAzienda = causaleTrasportoCacheModel.codiceAzienda;

		if ((codiceAzienda != null) && (codiceAzienda.length() == 0)) {
			causaleTrasportoCacheModel.codiceAzienda = null;
		}

		return causaleTrasportoCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{codiceCausaleTrasporto=");
		sb.append(getCodiceCausaleTrasporto());
		sb.append(", descrizione=");
		sb.append(getDescrizione());
		sb.append(", codiceAzienda=");
		sb.append(getCodiceAzienda());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("it.bysoftware.ct.model.CausaleTrasporto");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>codiceCausaleTrasporto</column-name><column-value><![CDATA[");
		sb.append(getCodiceCausaleTrasporto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descrizione</column-name><column-value><![CDATA[");
		sb.append(getDescrizione());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceAzienda</column-name><column-value><![CDATA[");
		sb.append(getCodiceAzienda());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = CausaleTrasporto.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			CausaleTrasporto.class
		};
	private String _codiceCausaleTrasporto;
	private String _descrizione;
	private String _codiceAzienda;
	private CausaleTrasporto _escapedModel;
}
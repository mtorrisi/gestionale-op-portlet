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

import it.bysoftware.ct.model.CuraTrasporto;
import it.bysoftware.ct.model.CuraTrasportoModel;
import it.bysoftware.ct.model.CuraTrasportoSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CuraTrasporto service. Represents a row in the &quot;CuraTrasporto&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.bysoftware.ct.model.CuraTrasportoModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CuraTrasportoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CuraTrasportoImpl
 * @see it.bysoftware.ct.model.CuraTrasporto
 * @see it.bysoftware.ct.model.CuraTrasportoModel
 * @generated
 */
@JSON(strict = true)
public class CuraTrasportoModelImpl extends BaseModelImpl<CuraTrasporto>
	implements CuraTrasportoModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cura trasporto model instance should use the {@link it.bysoftware.ct.model.CuraTrasporto} interface instead.
	 */
	public static final String TABLE_NAME = "CuraTrasporto";
	public static final Object[][] TABLE_COLUMNS = {
			{ "RdeCoddes", Types.VARCHAR },
			{ "RdeDescri", Types.VARCHAR },
			{ "RdeCodiaz", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table CuraTrasporto (RdeCoddes VARCHAR(75) not null primary key,RdeDescri VARCHAR(75) null,RdeCodiaz VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table CuraTrasporto";
	public static final String ORDER_BY_JPQL = " ORDER BY curaTrasporto.codiceCuraTrasporto ASC";
	public static final String ORDER_BY_SQL = " ORDER BY CuraTrasporto.RdeCoddes ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.bysoftware.ct.model.CuraTrasporto"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.bysoftware.ct.model.CuraTrasporto"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CuraTrasporto toModel(CuraTrasportoSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CuraTrasporto model = new CuraTrasportoImpl();

		model.setCodiceCuraTrasporto(soapModel.getCodiceCuraTrasporto());
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
	public static List<CuraTrasporto> toModels(CuraTrasportoSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CuraTrasporto> models = new ArrayList<CuraTrasporto>(soapModels.length);

		for (CuraTrasportoSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.bysoftware.ct.model.CuraTrasporto"));

	public CuraTrasportoModelImpl() {
	}

	@Override
	public String getPrimaryKey() {
		return _codiceCuraTrasporto;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setCodiceCuraTrasporto(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _codiceCuraTrasporto;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return CuraTrasporto.class;
	}

	@Override
	public String getModelClassName() {
		return CuraTrasporto.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("codiceCuraTrasporto", getCodiceCuraTrasporto());
		attributes.put("descrizione", getDescrizione());
		attributes.put("codiceAzienda", getCodiceAzienda());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String codiceCuraTrasporto = (String)attributes.get(
				"codiceCuraTrasporto");

		if (codiceCuraTrasporto != null) {
			setCodiceCuraTrasporto(codiceCuraTrasporto);
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
	public String getCodiceCuraTrasporto() {
		if (_codiceCuraTrasporto == null) {
			return StringPool.BLANK;
		}
		else {
			return _codiceCuraTrasporto;
		}
	}

	@Override
	public void setCodiceCuraTrasporto(String codiceCuraTrasporto) {
		_codiceCuraTrasporto = codiceCuraTrasporto;
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
	public CuraTrasporto toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CuraTrasporto)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CuraTrasportoImpl curaTrasportoImpl = new CuraTrasportoImpl();

		curaTrasportoImpl.setCodiceCuraTrasporto(getCodiceCuraTrasporto());
		curaTrasportoImpl.setDescrizione(getDescrizione());
		curaTrasportoImpl.setCodiceAzienda(getCodiceAzienda());

		curaTrasportoImpl.resetOriginalValues();

		return curaTrasportoImpl;
	}

	@Override
	public int compareTo(CuraTrasporto curaTrasporto) {
		String primaryKey = curaTrasporto.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CuraTrasporto)) {
			return false;
		}

		CuraTrasporto curaTrasporto = (CuraTrasporto)obj;

		String primaryKey = curaTrasporto.getPrimaryKey();

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
	public CacheModel<CuraTrasporto> toCacheModel() {
		CuraTrasportoCacheModel curaTrasportoCacheModel = new CuraTrasportoCacheModel();

		curaTrasportoCacheModel.codiceCuraTrasporto = getCodiceCuraTrasporto();

		String codiceCuraTrasporto = curaTrasportoCacheModel.codiceCuraTrasporto;

		if ((codiceCuraTrasporto != null) &&
				(codiceCuraTrasporto.length() == 0)) {
			curaTrasportoCacheModel.codiceCuraTrasporto = null;
		}

		curaTrasportoCacheModel.descrizione = getDescrizione();

		String descrizione = curaTrasportoCacheModel.descrizione;

		if ((descrizione != null) && (descrizione.length() == 0)) {
			curaTrasportoCacheModel.descrizione = null;
		}

		curaTrasportoCacheModel.codiceAzienda = getCodiceAzienda();

		String codiceAzienda = curaTrasportoCacheModel.codiceAzienda;

		if ((codiceAzienda != null) && (codiceAzienda.length() == 0)) {
			curaTrasportoCacheModel.codiceAzienda = null;
		}

		return curaTrasportoCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{codiceCuraTrasporto=");
		sb.append(getCodiceCuraTrasporto());
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
		sb.append("it.bysoftware.ct.model.CuraTrasporto");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>codiceCuraTrasporto</column-name><column-value><![CDATA[");
		sb.append(getCodiceCuraTrasporto());
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

	private static ClassLoader _classLoader = CuraTrasporto.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			CuraTrasporto.class
		};
	private String _codiceCuraTrasporto;
	private String _descrizione;
	private String _codiceAzienda;
	private CuraTrasporto _escapedModel;
}
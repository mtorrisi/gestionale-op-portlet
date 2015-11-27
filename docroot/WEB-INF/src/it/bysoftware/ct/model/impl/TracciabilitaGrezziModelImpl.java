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

import it.bysoftware.ct.model.TracciabilitaGrezzi;
import it.bysoftware.ct.model.TracciabilitaGrezziModel;
import it.bysoftware.ct.model.TracciabilitaGrezziSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the TracciabilitaGrezzi service. Represents a row in the &quot;TracciabilitaGrezzi&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.bysoftware.ct.model.TracciabilitaGrezziModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TracciabilitaGrezziImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TracciabilitaGrezziImpl
 * @see it.bysoftware.ct.model.TracciabilitaGrezzi
 * @see it.bysoftware.ct.model.TracciabilitaGrezziModel
 * @generated
 */
@JSON(strict = true)
public class TracciabilitaGrezziModelImpl extends BaseModelImpl<TracciabilitaGrezzi>
	implements TracciabilitaGrezziModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a tracciabilita grezzi model instance should use the {@link it.bysoftware.ct.model.TracciabilitaGrezzi} interface instead.
	 */
	public static final String TABLE_NAME = "TracciabilitaGrezzi";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", Types.BIGINT },
			{ "lotto_grezzo", Types.VARCHAR },
			{ "prodotto", Types.VARCHAR },
			{ "kg", Types.DOUBLE },
			{ "produttore", Types.VARCHAR },
			{ "foglio", Types.INTEGER },
			{ "particella", Types.INTEGER },
			{ "id_scheda_tracciabilita", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table TracciabilitaGrezzi (id LONG not null primary key,lotto_grezzo VARCHAR(75) null,prodotto VARCHAR(75) null,kg DOUBLE,produttore VARCHAR(75) null,foglio INTEGER,particella INTEGER,id_scheda_tracciabilita LONG)";
	public static final String TABLE_SQL_DROP = "drop table TracciabilitaGrezzi";
	public static final String ORDER_BY_JPQL = " ORDER BY tracciabilitaGrezzi.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY TracciabilitaGrezzi.id ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.bysoftware.ct.model.TracciabilitaGrezzi"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.bysoftware.ct.model.TracciabilitaGrezzi"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static TracciabilitaGrezzi toModel(TracciabilitaGrezziSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		TracciabilitaGrezzi model = new TracciabilitaGrezziImpl();

		model.setId(soapModel.getId());
		model.setLottoGrezzo(soapModel.getLottoGrezzo());
		model.setProdotto(soapModel.getProdotto());
		model.setKg(soapModel.getKg());
		model.setProduttore(soapModel.getProduttore());
		model.setFoglio(soapModel.getFoglio());
		model.setParticella(soapModel.getParticella());
		model.setIdSchedaTracciabilta(soapModel.getIdSchedaTracciabilta());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<TracciabilitaGrezzi> toModels(
		TracciabilitaGrezziSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<TracciabilitaGrezzi> models = new ArrayList<TracciabilitaGrezzi>(soapModels.length);

		for (TracciabilitaGrezziSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.bysoftware.ct.model.TracciabilitaGrezzi"));

	public TracciabilitaGrezziModelImpl() {
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
		return TracciabilitaGrezzi.class;
	}

	@Override
	public String getModelClassName() {
		return TracciabilitaGrezzi.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("lottoGrezzo", getLottoGrezzo());
		attributes.put("prodotto", getProdotto());
		attributes.put("kg", getKg());
		attributes.put("produttore", getProduttore());
		attributes.put("foglio", getFoglio());
		attributes.put("particella", getParticella());
		attributes.put("idSchedaTracciabilta", getIdSchedaTracciabilta());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String lottoGrezzo = (String)attributes.get("lottoGrezzo");

		if (lottoGrezzo != null) {
			setLottoGrezzo(lottoGrezzo);
		}

		String prodotto = (String)attributes.get("prodotto");

		if (prodotto != null) {
			setProdotto(prodotto);
		}

		Double kg = (Double)attributes.get("kg");

		if (kg != null) {
			setKg(kg);
		}

		String produttore = (String)attributes.get("produttore");

		if (produttore != null) {
			setProduttore(produttore);
		}

		Integer foglio = (Integer)attributes.get("foglio");

		if (foglio != null) {
			setFoglio(foglio);
		}

		Integer particella = (Integer)attributes.get("particella");

		if (particella != null) {
			setParticella(particella);
		}

		Long idSchedaTracciabilta = (Long)attributes.get("idSchedaTracciabilta");

		if (idSchedaTracciabilta != null) {
			setIdSchedaTracciabilta(idSchedaTracciabilta);
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
	public String getLottoGrezzo() {
		if (_lottoGrezzo == null) {
			return StringPool.BLANK;
		}
		else {
			return _lottoGrezzo;
		}
	}

	@Override
	public void setLottoGrezzo(String lottoGrezzo) {
		_lottoGrezzo = lottoGrezzo;
	}

	@JSON
	@Override
	public String getProdotto() {
		if (_prodotto == null) {
			return StringPool.BLANK;
		}
		else {
			return _prodotto;
		}
	}

	@Override
	public void setProdotto(String prodotto) {
		_prodotto = prodotto;
	}

	@JSON
	@Override
	public double getKg() {
		return _kg;
	}

	@Override
	public void setKg(double kg) {
		_kg = kg;
	}

	@JSON
	@Override
	public String getProduttore() {
		if (_produttore == null) {
			return StringPool.BLANK;
		}
		else {
			return _produttore;
		}
	}

	@Override
	public void setProduttore(String produttore) {
		_produttore = produttore;
	}

	@JSON
	@Override
	public int getFoglio() {
		return _foglio;
	}

	@Override
	public void setFoglio(int foglio) {
		_foglio = foglio;
	}

	@JSON
	@Override
	public int getParticella() {
		return _particella;
	}

	@Override
	public void setParticella(int particella) {
		_particella = particella;
	}

	@JSON
	@Override
	public long getIdSchedaTracciabilta() {
		return _idSchedaTracciabilta;
	}

	@Override
	public void setIdSchedaTracciabilta(long idSchedaTracciabilta) {
		_idSchedaTracciabilta = idSchedaTracciabilta;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			TracciabilitaGrezzi.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TracciabilitaGrezzi toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TracciabilitaGrezzi)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TracciabilitaGrezziImpl tracciabilitaGrezziImpl = new TracciabilitaGrezziImpl();

		tracciabilitaGrezziImpl.setId(getId());
		tracciabilitaGrezziImpl.setLottoGrezzo(getLottoGrezzo());
		tracciabilitaGrezziImpl.setProdotto(getProdotto());
		tracciabilitaGrezziImpl.setKg(getKg());
		tracciabilitaGrezziImpl.setProduttore(getProduttore());
		tracciabilitaGrezziImpl.setFoglio(getFoglio());
		tracciabilitaGrezziImpl.setParticella(getParticella());
		tracciabilitaGrezziImpl.setIdSchedaTracciabilta(getIdSchedaTracciabilta());

		tracciabilitaGrezziImpl.resetOriginalValues();

		return tracciabilitaGrezziImpl;
	}

	@Override
	public int compareTo(TracciabilitaGrezzi tracciabilitaGrezzi) {
		long primaryKey = tracciabilitaGrezzi.getPrimaryKey();

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

		if (!(obj instanceof TracciabilitaGrezzi)) {
			return false;
		}

		TracciabilitaGrezzi tracciabilitaGrezzi = (TracciabilitaGrezzi)obj;

		long primaryKey = tracciabilitaGrezzi.getPrimaryKey();

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
	}

	@Override
	public CacheModel<TracciabilitaGrezzi> toCacheModel() {
		TracciabilitaGrezziCacheModel tracciabilitaGrezziCacheModel = new TracciabilitaGrezziCacheModel();

		tracciabilitaGrezziCacheModel.id = getId();

		tracciabilitaGrezziCacheModel.lottoGrezzo = getLottoGrezzo();

		String lottoGrezzo = tracciabilitaGrezziCacheModel.lottoGrezzo;

		if ((lottoGrezzo != null) && (lottoGrezzo.length() == 0)) {
			tracciabilitaGrezziCacheModel.lottoGrezzo = null;
		}

		tracciabilitaGrezziCacheModel.prodotto = getProdotto();

		String prodotto = tracciabilitaGrezziCacheModel.prodotto;

		if ((prodotto != null) && (prodotto.length() == 0)) {
			tracciabilitaGrezziCacheModel.prodotto = null;
		}

		tracciabilitaGrezziCacheModel.kg = getKg();

		tracciabilitaGrezziCacheModel.produttore = getProduttore();

		String produttore = tracciabilitaGrezziCacheModel.produttore;

		if ((produttore != null) && (produttore.length() == 0)) {
			tracciabilitaGrezziCacheModel.produttore = null;
		}

		tracciabilitaGrezziCacheModel.foglio = getFoglio();

		tracciabilitaGrezziCacheModel.particella = getParticella();

		tracciabilitaGrezziCacheModel.idSchedaTracciabilta = getIdSchedaTracciabilta();

		return tracciabilitaGrezziCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", lottoGrezzo=");
		sb.append(getLottoGrezzo());
		sb.append(", prodotto=");
		sb.append(getProdotto());
		sb.append(", kg=");
		sb.append(getKg());
		sb.append(", produttore=");
		sb.append(getProduttore());
		sb.append(", foglio=");
		sb.append(getFoglio());
		sb.append(", particella=");
		sb.append(getParticella());
		sb.append(", idSchedaTracciabilta=");
		sb.append(getIdSchedaTracciabilta());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("it.bysoftware.ct.model.TracciabilitaGrezzi");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lottoGrezzo</column-name><column-value><![CDATA[");
		sb.append(getLottoGrezzo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>prodotto</column-name><column-value><![CDATA[");
		sb.append(getProdotto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kg</column-name><column-value><![CDATA[");
		sb.append(getKg());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>produttore</column-name><column-value><![CDATA[");
		sb.append(getProduttore());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>foglio</column-name><column-value><![CDATA[");
		sb.append(getFoglio());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>particella</column-name><column-value><![CDATA[");
		sb.append(getParticella());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idSchedaTracciabilta</column-name><column-value><![CDATA[");
		sb.append(getIdSchedaTracciabilta());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = TracciabilitaGrezzi.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			TracciabilitaGrezzi.class
		};
	private long _id;
	private String _lottoGrezzo;
	private String _prodotto;
	private double _kg;
	private String _produttore;
	private int _foglio;
	private int _particella;
	private long _idSchedaTracciabilta;
	private TracciabilitaGrezzi _escapedModel;
}
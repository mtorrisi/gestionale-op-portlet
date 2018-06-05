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

import it.bysoftware.ct.model.TracciabilitaScheda;
import it.bysoftware.ct.model.TracciabilitaSchedaModel;
import it.bysoftware.ct.model.TracciabilitaSchedaSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the TracciabilitaScheda service. Represents a row in the &quot;tracciabilitaScheda&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.bysoftware.ct.model.TracciabilitaSchedaModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TracciabilitaSchedaImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TracciabilitaSchedaImpl
 * @see it.bysoftware.ct.model.TracciabilitaScheda
 * @see it.bysoftware.ct.model.TracciabilitaSchedaModel
 * @generated
 */
@JSON(strict = true)
public class TracciabilitaSchedaModelImpl extends BaseModelImpl<TracciabilitaScheda>
	implements TracciabilitaSchedaModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a tracciabilita scheda model instance should use the {@link it.bysoftware.ct.model.TracciabilitaScheda} interface instead.
	 */
	public static final String TABLE_NAME = "tracciabilitaScheda";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", Types.BIGINT },
			{ "codice_prodotto", Types.VARCHAR },
			{ "prodotto", Types.VARCHAR },
			{ "kg", Types.DOUBLE },
			{ "lotto_vendita", Types.VARCHAR },
			{ "anno", Types.INTEGER },
			{ "numero_documento", Types.BIGINT },
			{ "rigo_ordine", Types.INTEGER },
			{ "tipo_documento", Types.VARCHAR },
			{ "id_associato", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table tracciabilitaScheda (id LONG not null primary key IDENTITY,codice_prodotto VARCHAR(75) null,prodotto VARCHAR(75) null,kg DOUBLE,lotto_vendita VARCHAR(75) null,anno INTEGER,numero_documento LONG,rigo_ordine INTEGER,tipo_documento VARCHAR(75) null,id_associato LONG)";
	public static final String TABLE_SQL_DROP = "drop table tracciabilitaScheda";
	public static final String ORDER_BY_JPQL = " ORDER BY tracciabilitaScheda.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY tracciabilitaScheda.id ASC";
	public static final String DATA_SOURCE = "gestionaleOPDataSource";
	public static final String SESSION_FACTORY = "gestionaleOPSessionFactory";
	public static final String TX_MANAGER = "gestionaleOPTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.bysoftware.ct.model.TracciabilitaScheda"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.bysoftware.ct.model.TracciabilitaScheda"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.bysoftware.ct.model.TracciabilitaScheda"),
			true);
	public static long ANNO_COLUMN_BITMASK = 1L;
	public static long CODICEPRODOTTO_COLUMN_BITMASK = 2L;
	public static long IDASSOCIATO_COLUMN_BITMASK = 4L;
	public static long NUMERODOCUMENTO_COLUMN_BITMASK = 8L;
	public static long TIPODOCUMENTO_COLUMN_BITMASK = 16L;
	public static long ID_COLUMN_BITMASK = 32L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static TracciabilitaScheda toModel(TracciabilitaSchedaSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		TracciabilitaScheda model = new TracciabilitaSchedaImpl();

		model.setId(soapModel.getId());
		model.setCodiceProdotto(soapModel.getCodiceProdotto());
		model.setProdottoVenduto(soapModel.getProdottoVenduto());
		model.setKgVenduti(soapModel.getKgVenduti());
		model.setLottoVendita(soapModel.getLottoVendita());
		model.setAnno(soapModel.getAnno());
		model.setNumeroDocumento(soapModel.getNumeroDocumento());
		model.setRigoOrdine(soapModel.getRigoOrdine());
		model.setTipoDocumento(soapModel.getTipoDocumento());
		model.setIdAssociato(soapModel.getIdAssociato());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<TracciabilitaScheda> toModels(
		TracciabilitaSchedaSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<TracciabilitaScheda> models = new ArrayList<TracciabilitaScheda>(soapModels.length);

		for (TracciabilitaSchedaSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.bysoftware.ct.model.TracciabilitaScheda"));

	public TracciabilitaSchedaModelImpl() {
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
		return TracciabilitaScheda.class;
	}

	@Override
	public String getModelClassName() {
		return TracciabilitaScheda.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("codiceProdotto", getCodiceProdotto());
		attributes.put("prodottoVenduto", getProdottoVenduto());
		attributes.put("kgVenduti", getKgVenduti());
		attributes.put("lottoVendita", getLottoVendita());
		attributes.put("anno", getAnno());
		attributes.put("numeroDocumento", getNumeroDocumento());
		attributes.put("rigoOrdine", getRigoOrdine());
		attributes.put("tipoDocumento", getTipoDocumento());
		attributes.put("idAssociato", getIdAssociato());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String codiceProdotto = (String)attributes.get("codiceProdotto");

		if (codiceProdotto != null) {
			setCodiceProdotto(codiceProdotto);
		}

		String prodottoVenduto = (String)attributes.get("prodottoVenduto");

		if (prodottoVenduto != null) {
			setProdottoVenduto(prodottoVenduto);
		}

		Double kgVenduti = (Double)attributes.get("kgVenduti");

		if (kgVenduti != null) {
			setKgVenduti(kgVenduti);
		}

		String lottoVendita = (String)attributes.get("lottoVendita");

		if (lottoVendita != null) {
			setLottoVendita(lottoVendita);
		}

		Integer anno = (Integer)attributes.get("anno");

		if (anno != null) {
			setAnno(anno);
		}

		Long numeroDocumento = (Long)attributes.get("numeroDocumento");

		if (numeroDocumento != null) {
			setNumeroDocumento(numeroDocumento);
		}

		Integer rigoOrdine = (Integer)attributes.get("rigoOrdine");

		if (rigoOrdine != null) {
			setRigoOrdine(rigoOrdine);
		}

		String tipoDocumento = (String)attributes.get("tipoDocumento");

		if (tipoDocumento != null) {
			setTipoDocumento(tipoDocumento);
		}

		Long idAssociato = (Long)attributes.get("idAssociato");

		if (idAssociato != null) {
			setIdAssociato(idAssociato);
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
	public String getCodiceProdotto() {
		if (_codiceProdotto == null) {
			return StringPool.BLANK;
		}
		else {
			return _codiceProdotto;
		}
	}

	@Override
	public void setCodiceProdotto(String codiceProdotto) {
		_columnBitmask |= CODICEPRODOTTO_COLUMN_BITMASK;

		if (_originalCodiceProdotto == null) {
			_originalCodiceProdotto = _codiceProdotto;
		}

		_codiceProdotto = codiceProdotto;
	}

	public String getOriginalCodiceProdotto() {
		return GetterUtil.getString(_originalCodiceProdotto);
	}

	@JSON
	@Override
	public String getProdottoVenduto() {
		if (_prodottoVenduto == null) {
			return StringPool.BLANK;
		}
		else {
			return _prodottoVenduto;
		}
	}

	@Override
	public void setProdottoVenduto(String prodottoVenduto) {
		_prodottoVenduto = prodottoVenduto;
	}

	@JSON
	@Override
	public double getKgVenduti() {
		return _kgVenduti;
	}

	@Override
	public void setKgVenduti(double kgVenduti) {
		_kgVenduti = kgVenduti;
	}

	@JSON
	@Override
	public String getLottoVendita() {
		if (_lottoVendita == null) {
			return StringPool.BLANK;
		}
		else {
			return _lottoVendita;
		}
	}

	@Override
	public void setLottoVendita(String lottoVendita) {
		_lottoVendita = lottoVendita;
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
	public int getRigoOrdine() {
		return _rigoOrdine;
	}

	@Override
	public void setRigoOrdine(int rigoOrdine) {
		_rigoOrdine = rigoOrdine;
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
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			TracciabilitaScheda.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TracciabilitaScheda toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TracciabilitaScheda)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TracciabilitaSchedaImpl tracciabilitaSchedaImpl = new TracciabilitaSchedaImpl();

		tracciabilitaSchedaImpl.setId(getId());
		tracciabilitaSchedaImpl.setCodiceProdotto(getCodiceProdotto());
		tracciabilitaSchedaImpl.setProdottoVenduto(getProdottoVenduto());
		tracciabilitaSchedaImpl.setKgVenduti(getKgVenduti());
		tracciabilitaSchedaImpl.setLottoVendita(getLottoVendita());
		tracciabilitaSchedaImpl.setAnno(getAnno());
		tracciabilitaSchedaImpl.setNumeroDocumento(getNumeroDocumento());
		tracciabilitaSchedaImpl.setRigoOrdine(getRigoOrdine());
		tracciabilitaSchedaImpl.setTipoDocumento(getTipoDocumento());
		tracciabilitaSchedaImpl.setIdAssociato(getIdAssociato());

		tracciabilitaSchedaImpl.resetOriginalValues();

		return tracciabilitaSchedaImpl;
	}

	@Override
	public int compareTo(TracciabilitaScheda tracciabilitaScheda) {
		long primaryKey = tracciabilitaScheda.getPrimaryKey();

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

		if (!(obj instanceof TracciabilitaScheda)) {
			return false;
		}

		TracciabilitaScheda tracciabilitaScheda = (TracciabilitaScheda)obj;

		long primaryKey = tracciabilitaScheda.getPrimaryKey();

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
		TracciabilitaSchedaModelImpl tracciabilitaSchedaModelImpl = this;

		tracciabilitaSchedaModelImpl._originalCodiceProdotto = tracciabilitaSchedaModelImpl._codiceProdotto;

		tracciabilitaSchedaModelImpl._originalAnno = tracciabilitaSchedaModelImpl._anno;

		tracciabilitaSchedaModelImpl._setOriginalAnno = false;

		tracciabilitaSchedaModelImpl._originalNumeroDocumento = tracciabilitaSchedaModelImpl._numeroDocumento;

		tracciabilitaSchedaModelImpl._setOriginalNumeroDocumento = false;

		tracciabilitaSchedaModelImpl._originalTipoDocumento = tracciabilitaSchedaModelImpl._tipoDocumento;

		tracciabilitaSchedaModelImpl._originalIdAssociato = tracciabilitaSchedaModelImpl._idAssociato;

		tracciabilitaSchedaModelImpl._setOriginalIdAssociato = false;

		tracciabilitaSchedaModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TracciabilitaScheda> toCacheModel() {
		TracciabilitaSchedaCacheModel tracciabilitaSchedaCacheModel = new TracciabilitaSchedaCacheModel();

		tracciabilitaSchedaCacheModel.id = getId();

		tracciabilitaSchedaCacheModel.codiceProdotto = getCodiceProdotto();

		String codiceProdotto = tracciabilitaSchedaCacheModel.codiceProdotto;

		if ((codiceProdotto != null) && (codiceProdotto.length() == 0)) {
			tracciabilitaSchedaCacheModel.codiceProdotto = null;
		}

		tracciabilitaSchedaCacheModel.prodottoVenduto = getProdottoVenduto();

		String prodottoVenduto = tracciabilitaSchedaCacheModel.prodottoVenduto;

		if ((prodottoVenduto != null) && (prodottoVenduto.length() == 0)) {
			tracciabilitaSchedaCacheModel.prodottoVenduto = null;
		}

		tracciabilitaSchedaCacheModel.kgVenduti = getKgVenduti();

		tracciabilitaSchedaCacheModel.lottoVendita = getLottoVendita();

		String lottoVendita = tracciabilitaSchedaCacheModel.lottoVendita;

		if ((lottoVendita != null) && (lottoVendita.length() == 0)) {
			tracciabilitaSchedaCacheModel.lottoVendita = null;
		}

		tracciabilitaSchedaCacheModel.anno = getAnno();

		tracciabilitaSchedaCacheModel.numeroDocumento = getNumeroDocumento();

		tracciabilitaSchedaCacheModel.rigoOrdine = getRigoOrdine();

		tracciabilitaSchedaCacheModel.tipoDocumento = getTipoDocumento();

		String tipoDocumento = tracciabilitaSchedaCacheModel.tipoDocumento;

		if ((tipoDocumento != null) && (tipoDocumento.length() == 0)) {
			tracciabilitaSchedaCacheModel.tipoDocumento = null;
		}

		tracciabilitaSchedaCacheModel.idAssociato = getIdAssociato();

		return tracciabilitaSchedaCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", codiceProdotto=");
		sb.append(getCodiceProdotto());
		sb.append(", prodottoVenduto=");
		sb.append(getProdottoVenduto());
		sb.append(", kgVenduti=");
		sb.append(getKgVenduti());
		sb.append(", lottoVendita=");
		sb.append(getLottoVendita());
		sb.append(", anno=");
		sb.append(getAnno());
		sb.append(", numeroDocumento=");
		sb.append(getNumeroDocumento());
		sb.append(", rigoOrdine=");
		sb.append(getRigoOrdine());
		sb.append(", tipoDocumento=");
		sb.append(getTipoDocumento());
		sb.append(", idAssociato=");
		sb.append(getIdAssociato());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("it.bysoftware.ct.model.TracciabilitaScheda");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceProdotto</column-name><column-value><![CDATA[");
		sb.append(getCodiceProdotto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>prodottoVenduto</column-name><column-value><![CDATA[");
		sb.append(getProdottoVenduto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kgVenduti</column-name><column-value><![CDATA[");
		sb.append(getKgVenduti());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lottoVendita</column-name><column-value><![CDATA[");
		sb.append(getLottoVendita());
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
			"<column><column-name>rigoOrdine</column-name><column-value><![CDATA[");
		sb.append(getRigoOrdine());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipoDocumento</column-name><column-value><![CDATA[");
		sb.append(getTipoDocumento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idAssociato</column-name><column-value><![CDATA[");
		sb.append(getIdAssociato());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = TracciabilitaScheda.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			TracciabilitaScheda.class
		};
	private long _id;
	private String _codiceProdotto;
	private String _originalCodiceProdotto;
	private String _prodottoVenduto;
	private double _kgVenduti;
	private String _lottoVendita;
	private int _anno;
	private int _originalAnno;
	private boolean _setOriginalAnno;
	private long _numeroDocumento;
	private long _originalNumeroDocumento;
	private boolean _setOriginalNumeroDocumento;
	private int _rigoOrdine;
	private String _tipoDocumento;
	private String _originalTipoDocumento;
	private long _idAssociato;
	private long _originalIdAssociato;
	private boolean _setOriginalIdAssociato;
	private long _columnBitmask;
	private TracciabilitaScheda _escapedModel;
}
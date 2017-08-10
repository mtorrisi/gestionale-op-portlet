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

import it.bysoftware.ct.model.CessioneCredito;
import it.bysoftware.ct.model.CessioneCreditoModel;
import it.bysoftware.ct.model.CessioneCreditoSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CessioneCredito service. Represents a row in the &quot;cessioneCredito&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.bysoftware.ct.model.CessioneCreditoModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CessioneCreditoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CessioneCreditoImpl
 * @see it.bysoftware.ct.model.CessioneCredito
 * @see it.bysoftware.ct.model.CessioneCreditoModel
 * @generated
 */
@JSON(strict = true)
public class CessioneCreditoModelImpl extends BaseModelImpl<CessioneCredito>
	implements CessioneCreditoModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cessione credito model instance should use the {@link it.bysoftware.ct.model.CessioneCredito} interface instead.
	 */
	public static final String TABLE_NAME = "cessioneCredito";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", Types.BIGINT },
			{ "data", Types.TIMESTAMP },
			{ "RacCodana", Types.VARCHAR },
			{ "id_associato", Types.BIGINT },
			{ "id_file", Types.BIGINT },
			{ "anno", Types.INTEGER },
			{ "numero_fattura", Types.INTEGER },
			{ "totale", Types.DOUBLE },
			{ "note", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table cessioneCredito (id LONG not null primary key,data DATE null,RacCodana VARCHAR(75) null,id_associato LONG,id_file LONG,anno INTEGER,numero_fattura INTEGER,totale DOUBLE,note VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table cessioneCredito";
	public static final String ORDER_BY_JPQL = " ORDER BY cessioneCredito.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY cessioneCredito.id ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.bysoftware.ct.model.CessioneCredito"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.bysoftware.ct.model.CessioneCredito"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.bysoftware.ct.model.CessioneCredito"),
			true);
	public static long ANNO_COLUMN_BITMASK = 1L;
	public static long IDASSOCIATO_COLUMN_BITMASK = 2L;
	public static long NUMEROFATTURA_COLUMN_BITMASK = 4L;
	public static long ID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CessioneCredito toModel(CessioneCreditoSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CessioneCredito model = new CessioneCreditoImpl();

		model.setId(soapModel.getId());
		model.setData(soapModel.getData());
		model.setCodiceSoggetto(soapModel.getCodiceSoggetto());
		model.setIdAssociato(soapModel.getIdAssociato());
		model.setIdFile(soapModel.getIdFile());
		model.setAnno(soapModel.getAnno());
		model.setNumeroFattura(soapModel.getNumeroFattura());
		model.setTotale(soapModel.getTotale());
		model.setNote(soapModel.getNote());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CessioneCredito> toModels(
		CessioneCreditoSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CessioneCredito> models = new ArrayList<CessioneCredito>(soapModels.length);

		for (CessioneCreditoSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.bysoftware.ct.model.CessioneCredito"));

	public CessioneCreditoModelImpl() {
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
		return CessioneCredito.class;
	}

	@Override
	public String getModelClassName() {
		return CessioneCredito.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("data", getData());
		attributes.put("codiceSoggetto", getCodiceSoggetto());
		attributes.put("idAssociato", getIdAssociato());
		attributes.put("idFile", getIdFile());
		attributes.put("anno", getAnno());
		attributes.put("numeroFattura", getNumeroFattura());
		attributes.put("totale", getTotale());
		attributes.put("note", getNote());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Date data = (Date)attributes.get("data");

		if (data != null) {
			setData(data);
		}

		String codiceSoggetto = (String)attributes.get("codiceSoggetto");

		if (codiceSoggetto != null) {
			setCodiceSoggetto(codiceSoggetto);
		}

		Long idAssociato = (Long)attributes.get("idAssociato");

		if (idAssociato != null) {
			setIdAssociato(idAssociato);
		}

		Long idFile = (Long)attributes.get("idFile");

		if (idFile != null) {
			setIdFile(idFile);
		}

		Integer anno = (Integer)attributes.get("anno");

		if (anno != null) {
			setAnno(anno);
		}

		Integer numeroFattura = (Integer)attributes.get("numeroFattura");

		if (numeroFattura != null) {
			setNumeroFattura(numeroFattura);
		}

		Double totale = (Double)attributes.get("totale");

		if (totale != null) {
			setTotale(totale);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
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
	public Date getData() {
		return _data;
	}

	@Override
	public void setData(Date data) {
		_data = data;
	}

	@JSON
	@Override
	public String getCodiceSoggetto() {
		if (_codiceSoggetto == null) {
			return StringPool.BLANK;
		}
		else {
			return _codiceSoggetto;
		}
	}

	@Override
	public void setCodiceSoggetto(String codiceSoggetto) {
		_codiceSoggetto = codiceSoggetto;
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
	public long getIdFile() {
		return _idFile;
	}

	@Override
	public void setIdFile(long idFile) {
		_idFile = idFile;
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
	public int getNumeroFattura() {
		return _numeroFattura;
	}

	@Override
	public void setNumeroFattura(int numeroFattura) {
		_columnBitmask |= NUMEROFATTURA_COLUMN_BITMASK;

		if (!_setOriginalNumeroFattura) {
			_setOriginalNumeroFattura = true;

			_originalNumeroFattura = _numeroFattura;
		}

		_numeroFattura = numeroFattura;
	}

	public int getOriginalNumeroFattura() {
		return _originalNumeroFattura;
	}

	@JSON
	@Override
	public double getTotale() {
		return _totale;
	}

	@Override
	public void setTotale(double totale) {
		_totale = totale;
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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			CessioneCredito.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CessioneCredito toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CessioneCredito)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CessioneCreditoImpl cessioneCreditoImpl = new CessioneCreditoImpl();

		cessioneCreditoImpl.setId(getId());
		cessioneCreditoImpl.setData(getData());
		cessioneCreditoImpl.setCodiceSoggetto(getCodiceSoggetto());
		cessioneCreditoImpl.setIdAssociato(getIdAssociato());
		cessioneCreditoImpl.setIdFile(getIdFile());
		cessioneCreditoImpl.setAnno(getAnno());
		cessioneCreditoImpl.setNumeroFattura(getNumeroFattura());
		cessioneCreditoImpl.setTotale(getTotale());
		cessioneCreditoImpl.setNote(getNote());

		cessioneCreditoImpl.resetOriginalValues();

		return cessioneCreditoImpl;
	}

	@Override
	public int compareTo(CessioneCredito cessioneCredito) {
		long primaryKey = cessioneCredito.getPrimaryKey();

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

		if (!(obj instanceof CessioneCredito)) {
			return false;
		}

		CessioneCredito cessioneCredito = (CessioneCredito)obj;

		long primaryKey = cessioneCredito.getPrimaryKey();

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
		CessioneCreditoModelImpl cessioneCreditoModelImpl = this;

		cessioneCreditoModelImpl._originalIdAssociato = cessioneCreditoModelImpl._idAssociato;

		cessioneCreditoModelImpl._setOriginalIdAssociato = false;

		cessioneCreditoModelImpl._originalAnno = cessioneCreditoModelImpl._anno;

		cessioneCreditoModelImpl._setOriginalAnno = false;

		cessioneCreditoModelImpl._originalNumeroFattura = cessioneCreditoModelImpl._numeroFattura;

		cessioneCreditoModelImpl._setOriginalNumeroFattura = false;

		cessioneCreditoModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CessioneCredito> toCacheModel() {
		CessioneCreditoCacheModel cessioneCreditoCacheModel = new CessioneCreditoCacheModel();

		cessioneCreditoCacheModel.id = getId();

		Date data = getData();

		if (data != null) {
			cessioneCreditoCacheModel.data = data.getTime();
		}
		else {
			cessioneCreditoCacheModel.data = Long.MIN_VALUE;
		}

		cessioneCreditoCacheModel.codiceSoggetto = getCodiceSoggetto();

		String codiceSoggetto = cessioneCreditoCacheModel.codiceSoggetto;

		if ((codiceSoggetto != null) && (codiceSoggetto.length() == 0)) {
			cessioneCreditoCacheModel.codiceSoggetto = null;
		}

		cessioneCreditoCacheModel.idAssociato = getIdAssociato();

		cessioneCreditoCacheModel.idFile = getIdFile();

		cessioneCreditoCacheModel.anno = getAnno();

		cessioneCreditoCacheModel.numeroFattura = getNumeroFattura();

		cessioneCreditoCacheModel.totale = getTotale();

		cessioneCreditoCacheModel.note = getNote();

		String note = cessioneCreditoCacheModel.note;

		if ((note != null) && (note.length() == 0)) {
			cessioneCreditoCacheModel.note = null;
		}

		return cessioneCreditoCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", data=");
		sb.append(getData());
		sb.append(", codiceSoggetto=");
		sb.append(getCodiceSoggetto());
		sb.append(", idAssociato=");
		sb.append(getIdAssociato());
		sb.append(", idFile=");
		sb.append(getIdFile());
		sb.append(", anno=");
		sb.append(getAnno());
		sb.append(", numeroFattura=");
		sb.append(getNumeroFattura());
		sb.append(", totale=");
		sb.append(getTotale());
		sb.append(", note=");
		sb.append(getNote());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("it.bysoftware.ct.model.CessioneCredito");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>data</column-name><column-value><![CDATA[");
		sb.append(getData());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceSoggetto</column-name><column-value><![CDATA[");
		sb.append(getCodiceSoggetto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idAssociato</column-name><column-value><![CDATA[");
		sb.append(getIdAssociato());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idFile</column-name><column-value><![CDATA[");
		sb.append(getIdFile());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>anno</column-name><column-value><![CDATA[");
		sb.append(getAnno());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numeroFattura</column-name><column-value><![CDATA[");
		sb.append(getNumeroFattura());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totale</column-name><column-value><![CDATA[");
		sb.append(getTotale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>note</column-name><column-value><![CDATA[");
		sb.append(getNote());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = CessioneCredito.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			CessioneCredito.class
		};
	private long _id;
	private Date _data;
	private String _codiceSoggetto;
	private long _idAssociato;
	private long _originalIdAssociato;
	private boolean _setOriginalIdAssociato;
	private long _idFile;
	private int _anno;
	private int _originalAnno;
	private boolean _setOriginalAnno;
	private int _numeroFattura;
	private int _originalNumeroFattura;
	private boolean _setOriginalNumeroFattura;
	private double _totale;
	private String _note;
	private long _columnBitmask;
	private CessioneCredito _escapedModel;
}
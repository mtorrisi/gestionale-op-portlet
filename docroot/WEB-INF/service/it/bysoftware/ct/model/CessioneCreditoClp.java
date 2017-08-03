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

package it.bysoftware.ct.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import it.bysoftware.ct.service.CessioneCreditoLocalServiceUtil;
import it.bysoftware.ct.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class CessioneCreditoClp extends BaseModelImpl<CessioneCredito>
	implements CessioneCredito {
	public CessioneCreditoClp() {
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

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_cessioneCreditoRemoteModel != null) {
			try {
				Class<?> clazz = _cessioneCreditoRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_cessioneCreditoRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getData() {
		return _data;
	}

	@Override
	public void setData(Date data) {
		_data = data;

		if (_cessioneCreditoRemoteModel != null) {
			try {
				Class<?> clazz = _cessioneCreditoRemoteModel.getClass();

				Method method = clazz.getMethod("setData", Date.class);

				method.invoke(_cessioneCreditoRemoteModel, data);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodiceSoggetto() {
		return _codiceSoggetto;
	}

	@Override
	public void setCodiceSoggetto(String codiceSoggetto) {
		_codiceSoggetto = codiceSoggetto;

		if (_cessioneCreditoRemoteModel != null) {
			try {
				Class<?> clazz = _cessioneCreditoRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceSoggetto",
						String.class);

				method.invoke(_cessioneCreditoRemoteModel, codiceSoggetto);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIdAssociato() {
		return _idAssociato;
	}

	@Override
	public void setIdAssociato(long idAssociato) {
		_idAssociato = idAssociato;

		if (_cessioneCreditoRemoteModel != null) {
			try {
				Class<?> clazz = _cessioneCreditoRemoteModel.getClass();

				Method method = clazz.getMethod("setIdAssociato", long.class);

				method.invoke(_cessioneCreditoRemoteModel, idAssociato);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIdFile() {
		return _idFile;
	}

	@Override
	public void setIdFile(long idFile) {
		_idFile = idFile;

		if (_cessioneCreditoRemoteModel != null) {
			try {
				Class<?> clazz = _cessioneCreditoRemoteModel.getClass();

				Method method = clazz.getMethod("setIdFile", long.class);

				method.invoke(_cessioneCreditoRemoteModel, idFile);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getAnno() {
		return _anno;
	}

	@Override
	public void setAnno(int anno) {
		_anno = anno;

		if (_cessioneCreditoRemoteModel != null) {
			try {
				Class<?> clazz = _cessioneCreditoRemoteModel.getClass();

				Method method = clazz.getMethod("setAnno", int.class);

				method.invoke(_cessioneCreditoRemoteModel, anno);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getNumeroFattura() {
		return _numeroFattura;
	}

	@Override
	public void setNumeroFattura(int numeroFattura) {
		_numeroFattura = numeroFattura;

		if (_cessioneCreditoRemoteModel != null) {
			try {
				Class<?> clazz = _cessioneCreditoRemoteModel.getClass();

				Method method = clazz.getMethod("setNumeroFattura", int.class);

				method.invoke(_cessioneCreditoRemoteModel, numeroFattura);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getTotale() {
		return _totale;
	}

	@Override
	public void setTotale(double totale) {
		_totale = totale;

		if (_cessioneCreditoRemoteModel != null) {
			try {
				Class<?> clazz = _cessioneCreditoRemoteModel.getClass();

				Method method = clazz.getMethod("setTotale", double.class);

				method.invoke(_cessioneCreditoRemoteModel, totale);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNote() {
		return _note;
	}

	@Override
	public void setNote(String note) {
		_note = note;

		if (_cessioneCreditoRemoteModel != null) {
			try {
				Class<?> clazz = _cessioneCreditoRemoteModel.getClass();

				Method method = clazz.getMethod("setNote", String.class);

				method.invoke(_cessioneCreditoRemoteModel, note);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCessioneCreditoRemoteModel() {
		return _cessioneCreditoRemoteModel;
	}

	public void setCessioneCreditoRemoteModel(
		BaseModel<?> cessioneCreditoRemoteModel) {
		_cessioneCreditoRemoteModel = cessioneCreditoRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _cessioneCreditoRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_cessioneCreditoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CessioneCreditoLocalServiceUtil.addCessioneCredito(this);
		}
		else {
			CessioneCreditoLocalServiceUtil.updateCessioneCredito(this);
		}
	}

	@Override
	public CessioneCredito toEscapedModel() {
		return (CessioneCredito)ProxyUtil.newProxyInstance(CessioneCredito.class.getClassLoader(),
			new Class[] { CessioneCredito.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CessioneCreditoClp clone = new CessioneCreditoClp();

		clone.setId(getId());
		clone.setData(getData());
		clone.setCodiceSoggetto(getCodiceSoggetto());
		clone.setIdAssociato(getIdAssociato());
		clone.setIdFile(getIdFile());
		clone.setAnno(getAnno());
		clone.setNumeroFattura(getNumeroFattura());
		clone.setTotale(getTotale());
		clone.setNote(getNote());

		return clone;
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

		if (!(obj instanceof CessioneCreditoClp)) {
			return false;
		}

		CessioneCreditoClp cessioneCredito = (CessioneCreditoClp)obj;

		long primaryKey = cessioneCredito.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
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

	private long _id;
	private Date _data;
	private String _codiceSoggetto;
	private long _idAssociato;
	private long _idFile;
	private int _anno;
	private int _numeroFattura;
	private double _totale;
	private String _note;
	private BaseModel<?> _cessioneCreditoRemoteModel;
	private Class<?> _clpSerializerClass = it.bysoftware.ct.service.ClpSerializer.class;
}
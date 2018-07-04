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

import it.bysoftware.ct.service.ClpSerializer;
import it.bysoftware.ct.service.IvaLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class IvaClp extends BaseModelImpl<Iva> implements Iva {
	public IvaClp() {
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

	@Override
	public String getCodiceIva() {
		return _codiceIva;
	}

	@Override
	public void setCodiceIva(String codiceIva) {
		_codiceIva = codiceIva;

		if (_ivaRemoteModel != null) {
			try {
				Class<?> clazz = _ivaRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceIva", String.class);

				method.invoke(_ivaRemoteModel, codiceIva);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescrizione() {
		return _descrizione;
	}

	@Override
	public void setDescrizione(String descrizione) {
		_descrizione = descrizione;

		if (_ivaRemoteModel != null) {
			try {
				Class<?> clazz = _ivaRemoteModel.getClass();

				Method method = clazz.getMethod("setDescrizione", String.class);

				method.invoke(_ivaRemoteModel, descrizione);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescrizioneDocumento() {
		return _descrizioneDocumento;
	}

	@Override
	public void setDescrizioneDocumento(String descrizioneDocumento) {
		_descrizioneDocumento = descrizioneDocumento;

		if (_ivaRemoteModel != null) {
			try {
				Class<?> clazz = _ivaRemoteModel.getClass();

				Method method = clazz.getMethod("setDescrizioneDocumento",
						String.class);

				method.invoke(_ivaRemoteModel, descrizioneDocumento);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getAliquota() {
		return _aliquota;
	}

	@Override
	public void setAliquota(double aliquota) {
		_aliquota = aliquota;

		if (_ivaRemoteModel != null) {
			try {
				Class<?> clazz = _ivaRemoteModel.getClass();

				Method method = clazz.getMethod("setAliquota", double.class);

				method.invoke(_ivaRemoteModel, aliquota);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getIvaRemoteModel() {
		return _ivaRemoteModel;
	}

	public void setIvaRemoteModel(BaseModel<?> ivaRemoteModel) {
		_ivaRemoteModel = ivaRemoteModel;
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

		Class<?> remoteModelClass = _ivaRemoteModel.getClass();

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

		Object returnValue = method.invoke(_ivaRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			IvaLocalServiceUtil.addIva(this);
		}
		else {
			IvaLocalServiceUtil.updateIva(this);
		}
	}

	@Override
	public Iva toEscapedModel() {
		return (Iva)ProxyUtil.newProxyInstance(Iva.class.getClassLoader(),
			new Class[] { Iva.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		IvaClp clone = new IvaClp();

		clone.setCodiceIva(getCodiceIva());
		clone.setDescrizione(getDescrizione());
		clone.setDescrizioneDocumento(getDescrizioneDocumento());
		clone.setAliquota(getAliquota());

		return clone;
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

		if (!(obj instanceof IvaClp)) {
			return false;
		}

		IvaClp iva = (IvaClp)obj;

		String primaryKey = iva.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
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
		return getPrimaryKey().hashCode();
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

	private String _codiceIva;
	private String _descrizione;
	private String _descrizioneDocumento;
	private double _aliquota;
	private BaseModel<?> _ivaRemoteModel;
	private Class<?> _clpSerializerClass = it.bysoftware.ct.service.ClpSerializer.class;
}
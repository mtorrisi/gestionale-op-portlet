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

import it.bysoftware.ct.service.AspettoEsterioreBeniLocalServiceUtil;
import it.bysoftware.ct.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class AspettoEsterioreBeniClp extends BaseModelImpl<AspettoEsterioreBeni>
	implements AspettoEsterioreBeni {
	public AspettoEsterioreBeniClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return AspettoEsterioreBeni.class;
	}

	@Override
	public String getModelClassName() {
		return AspettoEsterioreBeni.class.getName();
	}

	@Override
	public String getPrimaryKey() {
		return _codiceAspettoEsteriore;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setCodiceAspettoEsteriore(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _codiceAspettoEsteriore;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("codiceAspettoEsteriore", getCodiceAspettoEsteriore());
		attributes.put("descrizione", getDescrizione());
		attributes.put("codiceAzienda", getCodiceAzienda());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String codiceAspettoEsteriore = (String)attributes.get(
				"codiceAspettoEsteriore");

		if (codiceAspettoEsteriore != null) {
			setCodiceAspettoEsteriore(codiceAspettoEsteriore);
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

	@Override
	public String getCodiceAspettoEsteriore() {
		return _codiceAspettoEsteriore;
	}

	@Override
	public void setCodiceAspettoEsteriore(String codiceAspettoEsteriore) {
		_codiceAspettoEsteriore = codiceAspettoEsteriore;

		if (_aspettoEsterioreBeniRemoteModel != null) {
			try {
				Class<?> clazz = _aspettoEsterioreBeniRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceAspettoEsteriore",
						String.class);

				method.invoke(_aspettoEsterioreBeniRemoteModel,
					codiceAspettoEsteriore);
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

		if (_aspettoEsterioreBeniRemoteModel != null) {
			try {
				Class<?> clazz = _aspettoEsterioreBeniRemoteModel.getClass();

				Method method = clazz.getMethod("setDescrizione", String.class);

				method.invoke(_aspettoEsterioreBeniRemoteModel, descrizione);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodiceAzienda() {
		return _codiceAzienda;
	}

	@Override
	public void setCodiceAzienda(String codiceAzienda) {
		_codiceAzienda = codiceAzienda;

		if (_aspettoEsterioreBeniRemoteModel != null) {
			try {
				Class<?> clazz = _aspettoEsterioreBeniRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceAzienda", String.class);

				method.invoke(_aspettoEsterioreBeniRemoteModel, codiceAzienda);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAspettoEsterioreBeniRemoteModel() {
		return _aspettoEsterioreBeniRemoteModel;
	}

	public void setAspettoEsterioreBeniRemoteModel(
		BaseModel<?> aspettoEsterioreBeniRemoteModel) {
		_aspettoEsterioreBeniRemoteModel = aspettoEsterioreBeniRemoteModel;
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

		Class<?> remoteModelClass = _aspettoEsterioreBeniRemoteModel.getClass();

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

		Object returnValue = method.invoke(_aspettoEsterioreBeniRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AspettoEsterioreBeniLocalServiceUtil.addAspettoEsterioreBeni(this);
		}
		else {
			AspettoEsterioreBeniLocalServiceUtil.updateAspettoEsterioreBeni(this);
		}
	}

	@Override
	public AspettoEsterioreBeni toEscapedModel() {
		return (AspettoEsterioreBeni)ProxyUtil.newProxyInstance(AspettoEsterioreBeni.class.getClassLoader(),
			new Class[] { AspettoEsterioreBeni.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AspettoEsterioreBeniClp clone = new AspettoEsterioreBeniClp();

		clone.setCodiceAspettoEsteriore(getCodiceAspettoEsteriore());
		clone.setDescrizione(getDescrizione());
		clone.setCodiceAzienda(getCodiceAzienda());

		return clone;
	}

	@Override
	public int compareTo(AspettoEsterioreBeni aspettoEsterioreBeni) {
		String primaryKey = aspettoEsterioreBeni.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AspettoEsterioreBeniClp)) {
			return false;
		}

		AspettoEsterioreBeniClp aspettoEsterioreBeni = (AspettoEsterioreBeniClp)obj;

		String primaryKey = aspettoEsterioreBeni.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{codiceAspettoEsteriore=");
		sb.append(getCodiceAspettoEsteriore());
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
		sb.append("it.bysoftware.ct.model.AspettoEsterioreBeni");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>codiceAspettoEsteriore</column-name><column-value><![CDATA[");
		sb.append(getCodiceAspettoEsteriore());
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

	private String _codiceAspettoEsteriore;
	private String _descrizione;
	private String _codiceAzienda;
	private BaseModel<?> _aspettoEsterioreBeniRemoteModel;
	private Class<?> _clpSerializerClass = it.bysoftware.ct.service.ClpSerializer.class;
}
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
import it.bysoftware.ct.service.CuraTrasportoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class CuraTrasportoClp extends BaseModelImpl<CuraTrasporto>
	implements CuraTrasporto {
	public CuraTrasportoClp() {
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

	@Override
	public String getCodiceCuraTrasporto() {
		return _codiceCuraTrasporto;
	}

	@Override
	public void setCodiceCuraTrasporto(String codiceCuraTrasporto) {
		_codiceCuraTrasporto = codiceCuraTrasporto;

		if (_curaTrasportoRemoteModel != null) {
			try {
				Class<?> clazz = _curaTrasportoRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceCuraTrasporto",
						String.class);

				method.invoke(_curaTrasportoRemoteModel, codiceCuraTrasporto);
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

		if (_curaTrasportoRemoteModel != null) {
			try {
				Class<?> clazz = _curaTrasportoRemoteModel.getClass();

				Method method = clazz.getMethod("setDescrizione", String.class);

				method.invoke(_curaTrasportoRemoteModel, descrizione);
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

		if (_curaTrasportoRemoteModel != null) {
			try {
				Class<?> clazz = _curaTrasportoRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceAzienda", String.class);

				method.invoke(_curaTrasportoRemoteModel, codiceAzienda);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCuraTrasportoRemoteModel() {
		return _curaTrasportoRemoteModel;
	}

	public void setCuraTrasportoRemoteModel(
		BaseModel<?> curaTrasportoRemoteModel) {
		_curaTrasportoRemoteModel = curaTrasportoRemoteModel;
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

		Class<?> remoteModelClass = _curaTrasportoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_curaTrasportoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CuraTrasportoLocalServiceUtil.addCuraTrasporto(this);
		}
		else {
			CuraTrasportoLocalServiceUtil.updateCuraTrasporto(this);
		}
	}

	@Override
	public CuraTrasporto toEscapedModel() {
		return (CuraTrasporto)ProxyUtil.newProxyInstance(CuraTrasporto.class.getClassLoader(),
			new Class[] { CuraTrasporto.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CuraTrasportoClp clone = new CuraTrasportoClp();

		clone.setCodiceCuraTrasporto(getCodiceCuraTrasporto());
		clone.setDescrizione(getDescrizione());
		clone.setCodiceAzienda(getCodiceAzienda());

		return clone;
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

		if (!(obj instanceof CuraTrasportoClp)) {
			return false;
		}

		CuraTrasportoClp curaTrasporto = (CuraTrasportoClp)obj;

		String primaryKey = curaTrasporto.getPrimaryKey();

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

	private String _codiceCuraTrasporto;
	private String _descrizione;
	private String _codiceAzienda;
	private BaseModel<?> _curaTrasportoRemoteModel;
	private Class<?> _clpSerializerClass = it.bysoftware.ct.service.ClpSerializer.class;
}
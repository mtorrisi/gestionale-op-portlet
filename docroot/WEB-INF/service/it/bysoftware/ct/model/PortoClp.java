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
import it.bysoftware.ct.service.PortoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class PortoClp extends BaseModelImpl<Porto> implements Porto {
	public PortoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Porto.class;
	}

	@Override
	public String getModelClassName() {
		return Porto.class.getName();
	}

	@Override
	public String getPrimaryKey() {
		return _codicePorto;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setCodicePorto(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _codicePorto;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("Cdinco", getCdinco());
		attributes.put("codicePorto", getCodicePorto());
		attributes.put("descrizione", getDescrizione());
		attributes.put("Incoterm", getIncoterm());
		attributes.put("codiceAzienda", getCodiceAzienda());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String Cdinco = (String)attributes.get("Cdinco");

		if (Cdinco != null) {
			setCdinco(Cdinco);
		}

		String codicePorto = (String)attributes.get("codicePorto");

		if (codicePorto != null) {
			setCodicePorto(codicePorto);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}

		String Incoterm = (String)attributes.get("Incoterm");

		if (Incoterm != null) {
			setIncoterm(Incoterm);
		}

		String codiceAzienda = (String)attributes.get("codiceAzienda");

		if (codiceAzienda != null) {
			setCodiceAzienda(codiceAzienda);
		}
	}

	@Override
	public String getCdinco() {
		return _Cdinco;
	}

	@Override
	public void setCdinco(String Cdinco) {
		_Cdinco = Cdinco;

		if (_portoRemoteModel != null) {
			try {
				Class<?> clazz = _portoRemoteModel.getClass();

				Method method = clazz.getMethod("setCdinco", String.class);

				method.invoke(_portoRemoteModel, Cdinco);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodicePorto() {
		return _codicePorto;
	}

	@Override
	public void setCodicePorto(String codicePorto) {
		_codicePorto = codicePorto;

		if (_portoRemoteModel != null) {
			try {
				Class<?> clazz = _portoRemoteModel.getClass();

				Method method = clazz.getMethod("setCodicePorto", String.class);

				method.invoke(_portoRemoteModel, codicePorto);
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

		if (_portoRemoteModel != null) {
			try {
				Class<?> clazz = _portoRemoteModel.getClass();

				Method method = clazz.getMethod("setDescrizione", String.class);

				method.invoke(_portoRemoteModel, descrizione);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIncoterm() {
		return _Incoterm;
	}

	@Override
	public void setIncoterm(String Incoterm) {
		_Incoterm = Incoterm;

		if (_portoRemoteModel != null) {
			try {
				Class<?> clazz = _portoRemoteModel.getClass();

				Method method = clazz.getMethod("setIncoterm", String.class);

				method.invoke(_portoRemoteModel, Incoterm);
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

		if (_portoRemoteModel != null) {
			try {
				Class<?> clazz = _portoRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceAzienda", String.class);

				method.invoke(_portoRemoteModel, codiceAzienda);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPortoRemoteModel() {
		return _portoRemoteModel;
	}

	public void setPortoRemoteModel(BaseModel<?> portoRemoteModel) {
		_portoRemoteModel = portoRemoteModel;
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

		Class<?> remoteModelClass = _portoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_portoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PortoLocalServiceUtil.addPorto(this);
		}
		else {
			PortoLocalServiceUtil.updatePorto(this);
		}
	}

	@Override
	public Porto toEscapedModel() {
		return (Porto)ProxyUtil.newProxyInstance(Porto.class.getClassLoader(),
			new Class[] { Porto.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PortoClp clone = new PortoClp();

		clone.setCdinco(getCdinco());
		clone.setCodicePorto(getCodicePorto());
		clone.setDescrizione(getDescrizione());
		clone.setIncoterm(getIncoterm());
		clone.setCodiceAzienda(getCodiceAzienda());

		return clone;
	}

	@Override
	public int compareTo(Porto porto) {
		String primaryKey = porto.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PortoClp)) {
			return false;
		}

		PortoClp porto = (PortoClp)obj;

		String primaryKey = porto.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{Cdinco=");
		sb.append(getCdinco());
		sb.append(", codicePorto=");
		sb.append(getCodicePorto());
		sb.append(", descrizione=");
		sb.append(getDescrizione());
		sb.append(", Incoterm=");
		sb.append(getIncoterm());
		sb.append(", codiceAzienda=");
		sb.append(getCodiceAzienda());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("it.bysoftware.ct.model.Porto");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>Cdinco</column-name><column-value><![CDATA[");
		sb.append(getCdinco());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codicePorto</column-name><column-value><![CDATA[");
		sb.append(getCodicePorto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descrizione</column-name><column-value><![CDATA[");
		sb.append(getDescrizione());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Incoterm</column-name><column-value><![CDATA[");
		sb.append(getIncoterm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceAzienda</column-name><column-value><![CDATA[");
		sb.append(getCodiceAzienda());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _Cdinco;
	private String _codicePorto;
	private String _descrizione;
	private String _Incoterm;
	private String _codiceAzienda;
	private BaseModel<?> _portoRemoteModel;
	private Class<?> _clpSerializerClass = it.bysoftware.ct.service.ClpSerializer.class;
}
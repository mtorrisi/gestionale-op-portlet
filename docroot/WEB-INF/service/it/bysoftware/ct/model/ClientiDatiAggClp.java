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

import it.bysoftware.ct.service.ClientiDatiAggLocalServiceUtil;
import it.bysoftware.ct.service.ClpSerializer;
import it.bysoftware.ct.service.persistence.ClientiDatiAggPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class ClientiDatiAggClp extends BaseModelImpl<ClientiDatiAgg>
	implements ClientiDatiAgg {
	public ClientiDatiAggClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ClientiDatiAgg.class;
	}

	@Override
	public String getModelClassName() {
		return ClientiDatiAgg.class.getName();
	}

	@Override
	public ClientiDatiAggPK getPrimaryKey() {
		return new ClientiDatiAggPK(_codiceAnagrafica, _tipo);
	}

	@Override
	public void setPrimaryKey(ClientiDatiAggPK primaryKey) {
		setCodiceAnagrafica(primaryKey.codiceAnagrafica);
		setTipo(primaryKey.tipo);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ClientiDatiAggPK(_codiceAnagrafica, _tipo);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ClientiDatiAggPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("codiceAnagrafica", getCodiceAnagrafica());
		attributes.put("tipo", getTipo());
		attributes.put("associati", getAssociati());
		attributes.put("codiceAliquota", getCodiceAliquota());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String codiceAnagrafica = (String)attributes.get("codiceAnagrafica");

		if (codiceAnagrafica != null) {
			setCodiceAnagrafica(codiceAnagrafica);
		}

		Boolean tipo = (Boolean)attributes.get("tipo");

		if (tipo != null) {
			setTipo(tipo);
		}

		String associati = (String)attributes.get("associati");

		if (associati != null) {
			setAssociati(associati);
		}

		String codiceAliquota = (String)attributes.get("codiceAliquota");

		if (codiceAliquota != null) {
			setCodiceAliquota(codiceAliquota);
		}
	}

	@Override
	public String getCodiceAnagrafica() {
		return _codiceAnagrafica;
	}

	@Override
	public void setCodiceAnagrafica(String codiceAnagrafica) {
		_codiceAnagrafica = codiceAnagrafica;

		if (_clientiDatiAggRemoteModel != null) {
			try {
				Class<?> clazz = _clientiDatiAggRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceAnagrafica",
						String.class);

				method.invoke(_clientiDatiAggRemoteModel, codiceAnagrafica);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getTipo() {
		return _tipo;
	}

	@Override
	public boolean isTipo() {
		return _tipo;
	}

	@Override
	public void setTipo(boolean tipo) {
		_tipo = tipo;

		if (_clientiDatiAggRemoteModel != null) {
			try {
				Class<?> clazz = _clientiDatiAggRemoteModel.getClass();

				Method method = clazz.getMethod("setTipo", boolean.class);

				method.invoke(_clientiDatiAggRemoteModel, tipo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAssociati() {
		return _associati;
	}

	@Override
	public void setAssociati(String associati) {
		_associati = associati;

		if (_clientiDatiAggRemoteModel != null) {
			try {
				Class<?> clazz = _clientiDatiAggRemoteModel.getClass();

				Method method = clazz.getMethod("setAssociati", String.class);

				method.invoke(_clientiDatiAggRemoteModel, associati);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodiceAliquota() {
		return _codiceAliquota;
	}

	@Override
	public void setCodiceAliquota(String codiceAliquota) {
		_codiceAliquota = codiceAliquota;

		if (_clientiDatiAggRemoteModel != null) {
			try {
				Class<?> clazz = _clientiDatiAggRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceAliquota",
						String.class);

				method.invoke(_clientiDatiAggRemoteModel, codiceAliquota);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getClientiDatiAggRemoteModel() {
		return _clientiDatiAggRemoteModel;
	}

	public void setClientiDatiAggRemoteModel(
		BaseModel<?> clientiDatiAggRemoteModel) {
		_clientiDatiAggRemoteModel = clientiDatiAggRemoteModel;
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

		Class<?> remoteModelClass = _clientiDatiAggRemoteModel.getClass();

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

		Object returnValue = method.invoke(_clientiDatiAggRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ClientiDatiAggLocalServiceUtil.addClientiDatiAgg(this);
		}
		else {
			ClientiDatiAggLocalServiceUtil.updateClientiDatiAgg(this);
		}
	}

	@Override
	public ClientiDatiAgg toEscapedModel() {
		return (ClientiDatiAgg)ProxyUtil.newProxyInstance(ClientiDatiAgg.class.getClassLoader(),
			new Class[] { ClientiDatiAgg.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ClientiDatiAggClp clone = new ClientiDatiAggClp();

		clone.setCodiceAnagrafica(getCodiceAnagrafica());
		clone.setTipo(getTipo());
		clone.setAssociati(getAssociati());
		clone.setCodiceAliquota(getCodiceAliquota());

		return clone;
	}

	@Override
	public int compareTo(ClientiDatiAgg clientiDatiAgg) {
		ClientiDatiAggPK primaryKey = clientiDatiAgg.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ClientiDatiAggClp)) {
			return false;
		}

		ClientiDatiAggClp clientiDatiAgg = (ClientiDatiAggClp)obj;

		ClientiDatiAggPK primaryKey = clientiDatiAgg.getPrimaryKey();

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

		sb.append("{codiceAnagrafica=");
		sb.append(getCodiceAnagrafica());
		sb.append(", tipo=");
		sb.append(getTipo());
		sb.append(", associati=");
		sb.append(getAssociati());
		sb.append(", codiceAliquota=");
		sb.append(getCodiceAliquota());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("it.bysoftware.ct.model.ClientiDatiAgg");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>codiceAnagrafica</column-name><column-value><![CDATA[");
		sb.append(getCodiceAnagrafica());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipo</column-name><column-value><![CDATA[");
		sb.append(getTipo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>associati</column-name><column-value><![CDATA[");
		sb.append(getAssociati());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceAliquota</column-name><column-value><![CDATA[");
		sb.append(getCodiceAliquota());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _codiceAnagrafica;
	private boolean _tipo;
	private String _associati;
	private String _codiceAliquota;
	private BaseModel<?> _clientiDatiAggRemoteModel;
	private Class<?> _clpSerializerClass = it.bysoftware.ct.service.ClpSerializer.class;
}
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
import it.bysoftware.ct.service.DescrizioniVariantiLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class DescrizioniVariantiClp extends BaseModelImpl<DescrizioniVarianti>
	implements DescrizioniVarianti {
	public DescrizioniVariantiClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return DescrizioniVarianti.class;
	}

	@Override
	public String getModelClassName() {
		return DescrizioniVarianti.class.getName();
	}

	@Override
	public String getPrimaryKey() {
		return _codiceVariante;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setCodiceVariante(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _codiceVariante;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("codiceVariante", getCodiceVariante());
		attributes.put("descrizioneVariante", getDescrizioneVariante());
		attributes.put("ordine", getOrdine());
		attributes.put("tipoVariante", getTipoVariante());
		attributes.put("codiceAzienda", getCodiceAzienda());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String codiceVariante = (String)attributes.get("codiceVariante");

		if (codiceVariante != null) {
			setCodiceVariante(codiceVariante);
		}

		String descrizioneVariante = (String)attributes.get(
				"descrizioneVariante");

		if (descrizioneVariante != null) {
			setDescrizioneVariante(descrizioneVariante);
		}

		Integer ordine = (Integer)attributes.get("ordine");

		if (ordine != null) {
			setOrdine(ordine);
		}

		String tipoVariante = (String)attributes.get("tipoVariante");

		if (tipoVariante != null) {
			setTipoVariante(tipoVariante);
		}

		String codiceAzienda = (String)attributes.get("codiceAzienda");

		if (codiceAzienda != null) {
			setCodiceAzienda(codiceAzienda);
		}
	}

	@Override
	public String getCodiceVariante() {
		return _codiceVariante;
	}

	@Override
	public void setCodiceVariante(String codiceVariante) {
		_codiceVariante = codiceVariante;

		if (_descrizioniVariantiRemoteModel != null) {
			try {
				Class<?> clazz = _descrizioniVariantiRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceVariante",
						String.class);

				method.invoke(_descrizioniVariantiRemoteModel, codiceVariante);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescrizioneVariante() {
		return _descrizioneVariante;
	}

	@Override
	public void setDescrizioneVariante(String descrizioneVariante) {
		_descrizioneVariante = descrizioneVariante;

		if (_descrizioniVariantiRemoteModel != null) {
			try {
				Class<?> clazz = _descrizioniVariantiRemoteModel.getClass();

				Method method = clazz.getMethod("setDescrizioneVariante",
						String.class);

				method.invoke(_descrizioniVariantiRemoteModel,
					descrizioneVariante);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getOrdine() {
		return _ordine;
	}

	@Override
	public void setOrdine(int ordine) {
		_ordine = ordine;

		if (_descrizioniVariantiRemoteModel != null) {
			try {
				Class<?> clazz = _descrizioniVariantiRemoteModel.getClass();

				Method method = clazz.getMethod("setOrdine", int.class);

				method.invoke(_descrizioniVariantiRemoteModel, ordine);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTipoVariante() {
		return _tipoVariante;
	}

	@Override
	public void setTipoVariante(String tipoVariante) {
		_tipoVariante = tipoVariante;

		if (_descrizioniVariantiRemoteModel != null) {
			try {
				Class<?> clazz = _descrizioniVariantiRemoteModel.getClass();

				Method method = clazz.getMethod("setTipoVariante", String.class);

				method.invoke(_descrizioniVariantiRemoteModel, tipoVariante);
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

		if (_descrizioniVariantiRemoteModel != null) {
			try {
				Class<?> clazz = _descrizioniVariantiRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceAzienda", String.class);

				method.invoke(_descrizioniVariantiRemoteModel, codiceAzienda);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDescrizioniVariantiRemoteModel() {
		return _descrizioniVariantiRemoteModel;
	}

	public void setDescrizioniVariantiRemoteModel(
		BaseModel<?> descrizioniVariantiRemoteModel) {
		_descrizioniVariantiRemoteModel = descrizioniVariantiRemoteModel;
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

		Class<?> remoteModelClass = _descrizioniVariantiRemoteModel.getClass();

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

		Object returnValue = method.invoke(_descrizioniVariantiRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DescrizioniVariantiLocalServiceUtil.addDescrizioniVarianti(this);
		}
		else {
			DescrizioniVariantiLocalServiceUtil.updateDescrizioniVarianti(this);
		}
	}

	@Override
	public DescrizioniVarianti toEscapedModel() {
		return (DescrizioniVarianti)ProxyUtil.newProxyInstance(DescrizioniVarianti.class.getClassLoader(),
			new Class[] { DescrizioniVarianti.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DescrizioniVariantiClp clone = new DescrizioniVariantiClp();

		clone.setCodiceVariante(getCodiceVariante());
		clone.setDescrizioneVariante(getDescrizioneVariante());
		clone.setOrdine(getOrdine());
		clone.setTipoVariante(getTipoVariante());
		clone.setCodiceAzienda(getCodiceAzienda());

		return clone;
	}

	@Override
	public int compareTo(DescrizioniVarianti descrizioniVarianti) {
		String primaryKey = descrizioniVarianti.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DescrizioniVariantiClp)) {
			return false;
		}

		DescrizioniVariantiClp descrizioniVarianti = (DescrizioniVariantiClp)obj;

		String primaryKey = descrizioniVarianti.getPrimaryKey();

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

		sb.append("{codiceVariante=");
		sb.append(getCodiceVariante());
		sb.append(", descrizioneVariante=");
		sb.append(getDescrizioneVariante());
		sb.append(", ordine=");
		sb.append(getOrdine());
		sb.append(", tipoVariante=");
		sb.append(getTipoVariante());
		sb.append(", codiceAzienda=");
		sb.append(getCodiceAzienda());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("it.bysoftware.ct.model.DescrizioniVarianti");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>codiceVariante</column-name><column-value><![CDATA[");
		sb.append(getCodiceVariante());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descrizioneVariante</column-name><column-value><![CDATA[");
		sb.append(getDescrizioneVariante());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ordine</column-name><column-value><![CDATA[");
		sb.append(getOrdine());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipoVariante</column-name><column-value><![CDATA[");
		sb.append(getTipoVariante());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceAzienda</column-name><column-value><![CDATA[");
		sb.append(getCodiceAzienda());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _codiceVariante;
	private String _descrizioneVariante;
	private int _ordine;
	private String _tipoVariante;
	private String _codiceAzienda;
	private BaseModel<?> _descrizioniVariantiRemoteModel;
	private Class<?> _clpSerializerClass = it.bysoftware.ct.service.ClpSerializer.class;
}
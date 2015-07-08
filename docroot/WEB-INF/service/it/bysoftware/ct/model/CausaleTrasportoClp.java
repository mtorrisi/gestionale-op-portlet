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

import it.bysoftware.ct.service.CausaleTrasportoLocalServiceUtil;
import it.bysoftware.ct.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class CausaleTrasportoClp extends BaseModelImpl<CausaleTrasporto>
	implements CausaleTrasporto {
	public CausaleTrasportoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CausaleTrasporto.class;
	}

	@Override
	public String getModelClassName() {
		return CausaleTrasporto.class.getName();
	}

	@Override
	public String getPrimaryKey() {
		return _codiceCausaleTrasporto;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setCodiceCausaleTrasporto(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _codiceCausaleTrasporto;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("codiceCausaleTrasporto", getCodiceCausaleTrasporto());
		attributes.put("descrizione", getDescrizione());
		attributes.put("codiceAzienda", getCodiceAzienda());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String codiceCausaleTrasporto = (String)attributes.get(
				"codiceCausaleTrasporto");

		if (codiceCausaleTrasporto != null) {
			setCodiceCausaleTrasporto(codiceCausaleTrasporto);
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
	public String getCodiceCausaleTrasporto() {
		return _codiceCausaleTrasporto;
	}

	@Override
	public void setCodiceCausaleTrasporto(String codiceCausaleTrasporto) {
		_codiceCausaleTrasporto = codiceCausaleTrasporto;

		if (_causaleTrasportoRemoteModel != null) {
			try {
				Class<?> clazz = _causaleTrasportoRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceCausaleTrasporto",
						String.class);

				method.invoke(_causaleTrasportoRemoteModel,
					codiceCausaleTrasporto);
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

		if (_causaleTrasportoRemoteModel != null) {
			try {
				Class<?> clazz = _causaleTrasportoRemoteModel.getClass();

				Method method = clazz.getMethod("setDescrizione", String.class);

				method.invoke(_causaleTrasportoRemoteModel, descrizione);
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

		if (_causaleTrasportoRemoteModel != null) {
			try {
				Class<?> clazz = _causaleTrasportoRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceAzienda", String.class);

				method.invoke(_causaleTrasportoRemoteModel, codiceAzienda);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCausaleTrasportoRemoteModel() {
		return _causaleTrasportoRemoteModel;
	}

	public void setCausaleTrasportoRemoteModel(
		BaseModel<?> causaleTrasportoRemoteModel) {
		_causaleTrasportoRemoteModel = causaleTrasportoRemoteModel;
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

		Class<?> remoteModelClass = _causaleTrasportoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_causaleTrasportoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CausaleTrasportoLocalServiceUtil.addCausaleTrasporto(this);
		}
		else {
			CausaleTrasportoLocalServiceUtil.updateCausaleTrasporto(this);
		}
	}

	@Override
	public CausaleTrasporto toEscapedModel() {
		return (CausaleTrasporto)ProxyUtil.newProxyInstance(CausaleTrasporto.class.getClassLoader(),
			new Class[] { CausaleTrasporto.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CausaleTrasportoClp clone = new CausaleTrasportoClp();

		clone.setCodiceCausaleTrasporto(getCodiceCausaleTrasporto());
		clone.setDescrizione(getDescrizione());
		clone.setCodiceAzienda(getCodiceAzienda());

		return clone;
	}

	@Override
	public int compareTo(CausaleTrasporto causaleTrasporto) {
		String primaryKey = causaleTrasporto.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CausaleTrasportoClp)) {
			return false;
		}

		CausaleTrasportoClp causaleTrasporto = (CausaleTrasportoClp)obj;

		String primaryKey = causaleTrasporto.getPrimaryKey();

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

		sb.append("{codiceCausaleTrasporto=");
		sb.append(getCodiceCausaleTrasporto());
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
		sb.append("it.bysoftware.ct.model.CausaleTrasporto");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>codiceCausaleTrasporto</column-name><column-value><![CDATA[");
		sb.append(getCodiceCausaleTrasporto());
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

	private String _codiceCausaleTrasporto;
	private String _descrizione;
	private String _codiceAzienda;
	private BaseModel<?> _causaleTrasportoRemoteModel;
	private Class<?> _clpSerializerClass = it.bysoftware.ct.service.ClpSerializer.class;
}
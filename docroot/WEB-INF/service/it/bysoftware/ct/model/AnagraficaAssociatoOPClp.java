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

import it.bysoftware.ct.service.AnagraficaAssociatoOPLocalServiceUtil;
import it.bysoftware.ct.service.ClpSerializer;
import it.bysoftware.ct.service.persistence.AnagraficaAssociatoOPPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class AnagraficaAssociatoOPClp extends BaseModelImpl<AnagraficaAssociatoOP>
	implements AnagraficaAssociatoOP {
	public AnagraficaAssociatoOPClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return AnagraficaAssociatoOP.class;
	}

	@Override
	public String getModelClassName() {
		return AnagraficaAssociatoOP.class.getName();
	}

	@Override
	public AnagraficaAssociatoOPPK getPrimaryKey() {
		return new AnagraficaAssociatoOPPK(_idAssociato, _codiceSogettoAssociato);
	}

	@Override
	public void setPrimaryKey(AnagraficaAssociatoOPPK primaryKey) {
		setIdAssociato(primaryKey.idAssociato);
		setCodiceSogettoAssociato(primaryKey.codiceSogettoAssociato);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new AnagraficaAssociatoOPPK(_idAssociato, _codiceSogettoAssociato);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((AnagraficaAssociatoOPPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idAssociato", getIdAssociato());
		attributes.put("codiceSogettoAssociato", getCodiceSogettoAssociato());
		attributes.put("codiceSogettoOP", getCodiceSogettoOP());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idAssociato = (Long)attributes.get("idAssociato");

		if (idAssociato != null) {
			setIdAssociato(idAssociato);
		}

		String codiceSogettoAssociato = (String)attributes.get(
				"codiceSogettoAssociato");

		if (codiceSogettoAssociato != null) {
			setCodiceSogettoAssociato(codiceSogettoAssociato);
		}

		String codiceSogettoOP = (String)attributes.get("codiceSogettoOP");

		if (codiceSogettoOP != null) {
			setCodiceSogettoOP(codiceSogettoOP);
		}
	}

	@Override
	public long getIdAssociato() {
		return _idAssociato;
	}

	@Override
	public void setIdAssociato(long idAssociato) {
		_idAssociato = idAssociato;

		if (_anagraficaAssociatoOPRemoteModel != null) {
			try {
				Class<?> clazz = _anagraficaAssociatoOPRemoteModel.getClass();

				Method method = clazz.getMethod("setIdAssociato", long.class);

				method.invoke(_anagraficaAssociatoOPRemoteModel, idAssociato);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodiceSogettoAssociato() {
		return _codiceSogettoAssociato;
	}

	@Override
	public void setCodiceSogettoAssociato(String codiceSogettoAssociato) {
		_codiceSogettoAssociato = codiceSogettoAssociato;

		if (_anagraficaAssociatoOPRemoteModel != null) {
			try {
				Class<?> clazz = _anagraficaAssociatoOPRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceSogettoAssociato",
						String.class);

				method.invoke(_anagraficaAssociatoOPRemoteModel,
					codiceSogettoAssociato);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodiceSogettoOP() {
		return _codiceSogettoOP;
	}

	@Override
	public void setCodiceSogettoOP(String codiceSogettoOP) {
		_codiceSogettoOP = codiceSogettoOP;

		if (_anagraficaAssociatoOPRemoteModel != null) {
			try {
				Class<?> clazz = _anagraficaAssociatoOPRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceSogettoOP",
						String.class);

				method.invoke(_anagraficaAssociatoOPRemoteModel, codiceSogettoOP);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAnagraficaAssociatoOPRemoteModel() {
		return _anagraficaAssociatoOPRemoteModel;
	}

	public void setAnagraficaAssociatoOPRemoteModel(
		BaseModel<?> anagraficaAssociatoOPRemoteModel) {
		_anagraficaAssociatoOPRemoteModel = anagraficaAssociatoOPRemoteModel;
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

		Class<?> remoteModelClass = _anagraficaAssociatoOPRemoteModel.getClass();

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

		Object returnValue = method.invoke(_anagraficaAssociatoOPRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AnagraficaAssociatoOPLocalServiceUtil.addAnagraficaAssociatoOP(this);
		}
		else {
			AnagraficaAssociatoOPLocalServiceUtil.updateAnagraficaAssociatoOP(this);
		}
	}

	@Override
	public AnagraficaAssociatoOP toEscapedModel() {
		return (AnagraficaAssociatoOP)ProxyUtil.newProxyInstance(AnagraficaAssociatoOP.class.getClassLoader(),
			new Class[] { AnagraficaAssociatoOP.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AnagraficaAssociatoOPClp clone = new AnagraficaAssociatoOPClp();

		clone.setIdAssociato(getIdAssociato());
		clone.setCodiceSogettoAssociato(getCodiceSogettoAssociato());
		clone.setCodiceSogettoOP(getCodiceSogettoOP());

		return clone;
	}

	@Override
	public int compareTo(AnagraficaAssociatoOP anagraficaAssociatoOP) {
		AnagraficaAssociatoOPPK primaryKey = anagraficaAssociatoOP.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnagraficaAssociatoOPClp)) {
			return false;
		}

		AnagraficaAssociatoOPClp anagraficaAssociatoOP = (AnagraficaAssociatoOPClp)obj;

		AnagraficaAssociatoOPPK primaryKey = anagraficaAssociatoOP.getPrimaryKey();

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

		sb.append("{idAssociato=");
		sb.append(getIdAssociato());
		sb.append(", codiceSogettoAssociato=");
		sb.append(getCodiceSogettoAssociato());
		sb.append(", codiceSogettoOP=");
		sb.append(getCodiceSogettoOP());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("it.bysoftware.ct.model.AnagraficaAssociatoOP");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idAssociato</column-name><column-value><![CDATA[");
		sb.append(getIdAssociato());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceSogettoAssociato</column-name><column-value><![CDATA[");
		sb.append(getCodiceSogettoAssociato());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceSogettoOP</column-name><column-value><![CDATA[");
		sb.append(getCodiceSogettoOP());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _idAssociato;
	private String _codiceSogettoAssociato;
	private String _codiceSogettoOP;
	private BaseModel<?> _anagraficaAssociatoOPRemoteModel;
	private Class<?> _clpSerializerClass = it.bysoftware.ct.service.ClpSerializer.class;
}
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

import it.bysoftware.ct.service.ArticoliAssociatoOPLocalServiceUtil;
import it.bysoftware.ct.service.ClpSerializer;
import it.bysoftware.ct.service.persistence.ArticoliAssociatoOPPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class ArticoliAssociatoOPClp extends BaseModelImpl<ArticoliAssociatoOP>
	implements ArticoliAssociatoOP {
	public ArticoliAssociatoOPClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ArticoliAssociatoOP.class;
	}

	@Override
	public String getModelClassName() {
		return ArticoliAssociatoOP.class.getName();
	}

	@Override
	public ArticoliAssociatoOPPK getPrimaryKey() {
		return new ArticoliAssociatoOPPK(_idAssociato, _codiceArticoloAssociato);
	}

	@Override
	public void setPrimaryKey(ArticoliAssociatoOPPK primaryKey) {
		setIdAssociato(primaryKey.idAssociato);
		setCodiceArticoloAssociato(primaryKey.codiceArticoloAssociato);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ArticoliAssociatoOPPK(_idAssociato, _codiceArticoloAssociato);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ArticoliAssociatoOPPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idAssociato", getIdAssociato());
		attributes.put("codiceArticoloAssociato", getCodiceArticoloAssociato());
		attributes.put("codiceArticoloOP", getCodiceArticoloOP());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idAssociato = (Long)attributes.get("idAssociato");

		if (idAssociato != null) {
			setIdAssociato(idAssociato);
		}

		String codiceArticoloAssociato = (String)attributes.get(
				"codiceArticoloAssociato");

		if (codiceArticoloAssociato != null) {
			setCodiceArticoloAssociato(codiceArticoloAssociato);
		}

		String codiceArticoloOP = (String)attributes.get("codiceArticoloOP");

		if (codiceArticoloOP != null) {
			setCodiceArticoloOP(codiceArticoloOP);
		}
	}

	@Override
	public long getIdAssociato() {
		return _idAssociato;
	}

	@Override
	public void setIdAssociato(long idAssociato) {
		_idAssociato = idAssociato;

		if (_articoliAssociatoOPRemoteModel != null) {
			try {
				Class<?> clazz = _articoliAssociatoOPRemoteModel.getClass();

				Method method = clazz.getMethod("setIdAssociato", long.class);

				method.invoke(_articoliAssociatoOPRemoteModel, idAssociato);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodiceArticoloAssociato() {
		return _codiceArticoloAssociato;
	}

	@Override
	public void setCodiceArticoloAssociato(String codiceArticoloAssociato) {
		_codiceArticoloAssociato = codiceArticoloAssociato;

		if (_articoliAssociatoOPRemoteModel != null) {
			try {
				Class<?> clazz = _articoliAssociatoOPRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceArticoloAssociato",
						String.class);

				method.invoke(_articoliAssociatoOPRemoteModel,
					codiceArticoloAssociato);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodiceArticoloOP() {
		return _codiceArticoloOP;
	}

	@Override
	public void setCodiceArticoloOP(String codiceArticoloOP) {
		_codiceArticoloOP = codiceArticoloOP;

		if (_articoliAssociatoOPRemoteModel != null) {
			try {
				Class<?> clazz = _articoliAssociatoOPRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceArticoloOP",
						String.class);

				method.invoke(_articoliAssociatoOPRemoteModel, codiceArticoloOP);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getArticoliAssociatoOPRemoteModel() {
		return _articoliAssociatoOPRemoteModel;
	}

	public void setArticoliAssociatoOPRemoteModel(
		BaseModel<?> articoliAssociatoOPRemoteModel) {
		_articoliAssociatoOPRemoteModel = articoliAssociatoOPRemoteModel;
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

		Class<?> remoteModelClass = _articoliAssociatoOPRemoteModel.getClass();

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

		Object returnValue = method.invoke(_articoliAssociatoOPRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ArticoliAssociatoOPLocalServiceUtil.addArticoliAssociatoOP(this);
		}
		else {
			ArticoliAssociatoOPLocalServiceUtil.updateArticoliAssociatoOP(this);
		}
	}

	@Override
	public ArticoliAssociatoOP toEscapedModel() {
		return (ArticoliAssociatoOP)ProxyUtil.newProxyInstance(ArticoliAssociatoOP.class.getClassLoader(),
			new Class[] { ArticoliAssociatoOP.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ArticoliAssociatoOPClp clone = new ArticoliAssociatoOPClp();

		clone.setIdAssociato(getIdAssociato());
		clone.setCodiceArticoloAssociato(getCodiceArticoloAssociato());
		clone.setCodiceArticoloOP(getCodiceArticoloOP());

		return clone;
	}

	@Override
	public int compareTo(ArticoliAssociatoOP articoliAssociatoOP) {
		ArticoliAssociatoOPPK primaryKey = articoliAssociatoOP.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ArticoliAssociatoOPClp)) {
			return false;
		}

		ArticoliAssociatoOPClp articoliAssociatoOP = (ArticoliAssociatoOPClp)obj;

		ArticoliAssociatoOPPK primaryKey = articoliAssociatoOP.getPrimaryKey();

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
		sb.append(", codiceArticoloAssociato=");
		sb.append(getCodiceArticoloAssociato());
		sb.append(", codiceArticoloOP=");
		sb.append(getCodiceArticoloOP());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("it.bysoftware.ct.model.ArticoliAssociatoOP");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idAssociato</column-name><column-value><![CDATA[");
		sb.append(getIdAssociato());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceArticoloAssociato</column-name><column-value><![CDATA[");
		sb.append(getCodiceArticoloAssociato());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceArticoloOP</column-name><column-value><![CDATA[");
		sb.append(getCodiceArticoloOP());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _idAssociato;
	private String _codiceArticoloAssociato;
	private String _codiceArticoloOP;
	private BaseModel<?> _articoliAssociatoOPRemoteModel;
	private Class<?> _clpSerializerClass = it.bysoftware.ct.service.ClpSerializer.class;
}
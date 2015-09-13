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
import it.bysoftware.ct.service.DescrizioniDocumentiLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class DescrizioniDocumentiClp extends BaseModelImpl<DescrizioniDocumenti>
	implements DescrizioniDocumenti {
	public DescrizioniDocumentiClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return DescrizioniDocumenti.class;
	}

	@Override
	public String getModelClassName() {
		return DescrizioniDocumenti.class.getName();
	}

	@Override
	public String getPrimaryKey() {
		return _codiceDescrizione;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setCodiceDescrizione(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _codiceDescrizione;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("codiceDescrizione", getCodiceDescrizione());
		attributes.put("codiceIVA", getCodiceIVA());
		attributes.put("descrizione", getDescrizione());
		attributes.put("descrizioneFiscale", getDescrizioneFiscale());
		attributes.put("codiceAzienda", getCodiceAzienda());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String codiceDescrizione = (String)attributes.get("codiceDescrizione");

		if (codiceDescrizione != null) {
			setCodiceDescrizione(codiceDescrizione);
		}

		String codiceIVA = (String)attributes.get("codiceIVA");

		if (codiceIVA != null) {
			setCodiceIVA(codiceIVA);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}

		String descrizioneFiscale = (String)attributes.get("descrizioneFiscale");

		if (descrizioneFiscale != null) {
			setDescrizioneFiscale(descrizioneFiscale);
		}

		String codiceAzienda = (String)attributes.get("codiceAzienda");

		if (codiceAzienda != null) {
			setCodiceAzienda(codiceAzienda);
		}
	}

	@Override
	public String getCodiceDescrizione() {
		return _codiceDescrizione;
	}

	@Override
	public void setCodiceDescrizione(String codiceDescrizione) {
		_codiceDescrizione = codiceDescrizione;

		if (_descrizioniDocumentiRemoteModel != null) {
			try {
				Class<?> clazz = _descrizioniDocumentiRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceDescrizione",
						String.class);

				method.invoke(_descrizioniDocumentiRemoteModel,
					codiceDescrizione);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodiceIVA() {
		return _codiceIVA;
	}

	@Override
	public void setCodiceIVA(String codiceIVA) {
		_codiceIVA = codiceIVA;

		if (_descrizioniDocumentiRemoteModel != null) {
			try {
				Class<?> clazz = _descrizioniDocumentiRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceIVA", String.class);

				method.invoke(_descrizioniDocumentiRemoteModel, codiceIVA);
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

		if (_descrizioniDocumentiRemoteModel != null) {
			try {
				Class<?> clazz = _descrizioniDocumentiRemoteModel.getClass();

				Method method = clazz.getMethod("setDescrizione", String.class);

				method.invoke(_descrizioniDocumentiRemoteModel, descrizione);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescrizioneFiscale() {
		return _descrizioneFiscale;
	}

	@Override
	public void setDescrizioneFiscale(String descrizioneFiscale) {
		_descrizioneFiscale = descrizioneFiscale;

		if (_descrizioniDocumentiRemoteModel != null) {
			try {
				Class<?> clazz = _descrizioniDocumentiRemoteModel.getClass();

				Method method = clazz.getMethod("setDescrizioneFiscale",
						String.class);

				method.invoke(_descrizioniDocumentiRemoteModel,
					descrizioneFiscale);
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

		if (_descrizioniDocumentiRemoteModel != null) {
			try {
				Class<?> clazz = _descrizioniDocumentiRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceAzienda", String.class);

				method.invoke(_descrizioniDocumentiRemoteModel, codiceAzienda);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDescrizioniDocumentiRemoteModel() {
		return _descrizioniDocumentiRemoteModel;
	}

	public void setDescrizioniDocumentiRemoteModel(
		BaseModel<?> descrizioniDocumentiRemoteModel) {
		_descrizioniDocumentiRemoteModel = descrizioniDocumentiRemoteModel;
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

		Class<?> remoteModelClass = _descrizioniDocumentiRemoteModel.getClass();

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

		Object returnValue = method.invoke(_descrizioniDocumentiRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DescrizioniDocumentiLocalServiceUtil.addDescrizioniDocumenti(this);
		}
		else {
			DescrizioniDocumentiLocalServiceUtil.updateDescrizioniDocumenti(this);
		}
	}

	@Override
	public DescrizioniDocumenti toEscapedModel() {
		return (DescrizioniDocumenti)ProxyUtil.newProxyInstance(DescrizioniDocumenti.class.getClassLoader(),
			new Class[] { DescrizioniDocumenti.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DescrizioniDocumentiClp clone = new DescrizioniDocumentiClp();

		clone.setCodiceDescrizione(getCodiceDescrizione());
		clone.setCodiceIVA(getCodiceIVA());
		clone.setDescrizione(getDescrizione());
		clone.setDescrizioneFiscale(getDescrizioneFiscale());
		clone.setCodiceAzienda(getCodiceAzienda());

		return clone;
	}

	@Override
	public int compareTo(DescrizioniDocumenti descrizioniDocumenti) {
		String primaryKey = descrizioniDocumenti.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DescrizioniDocumentiClp)) {
			return false;
		}

		DescrizioniDocumentiClp descrizioniDocumenti = (DescrizioniDocumentiClp)obj;

		String primaryKey = descrizioniDocumenti.getPrimaryKey();

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

		sb.append("{codiceDescrizione=");
		sb.append(getCodiceDescrizione());
		sb.append(", codiceIVA=");
		sb.append(getCodiceIVA());
		sb.append(", descrizione=");
		sb.append(getDescrizione());
		sb.append(", descrizioneFiscale=");
		sb.append(getDescrizioneFiscale());
		sb.append(", codiceAzienda=");
		sb.append(getCodiceAzienda());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("it.bysoftware.ct.model.DescrizioniDocumenti");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>codiceDescrizione</column-name><column-value><![CDATA[");
		sb.append(getCodiceDescrizione());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceIVA</column-name><column-value><![CDATA[");
		sb.append(getCodiceIVA());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descrizione</column-name><column-value><![CDATA[");
		sb.append(getDescrizione());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descrizioneFiscale</column-name><column-value><![CDATA[");
		sb.append(getDescrizioneFiscale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceAzienda</column-name><column-value><![CDATA[");
		sb.append(getCodiceAzienda());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _codiceDescrizione;
	private String _codiceIVA;
	private String _descrizione;
	private String _descrizioneFiscale;
	private String _codiceAzienda;
	private BaseModel<?> _descrizioniDocumentiRemoteModel;
	private Class<?> _clpSerializerClass = it.bysoftware.ct.service.ClpSerializer.class;
}
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

import it.bysoftware.ct.service.BancheAppoggioLocalServiceUtil;
import it.bysoftware.ct.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class BancheAppoggioClp extends BaseModelImpl<BancheAppoggio>
	implements BancheAppoggio {
	public BancheAppoggioClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BancheAppoggio.class;
	}

	@Override
	public String getModelClassName() {
		return BancheAppoggio.class.getName();
	}

	@Override
	public String getPrimaryKey() {
		return _codiceBanca;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setCodiceBanca(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _codiceBanca;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cBanca", getCBanca());
		attributes.put("codiceABI", getCodiceABI());
		attributes.put("codiceAgenzia", getCodiceAgenzia());
		attributes.put("codiceBanca", getCodiceBanca());
		attributes.put("codiceCAB", getCodiceCAB());
		attributes.put("descrizione", getDescrizione());
		attributes.put("piazza", getPiazza());
		attributes.put("codiceAzienda", getCodiceAzienda());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String cBanca = (String)attributes.get("cBanca");

		if (cBanca != null) {
			setCBanca(cBanca);
		}

		Integer codiceABI = (Integer)attributes.get("codiceABI");

		if (codiceABI != null) {
			setCodiceABI(codiceABI);
		}

		String codiceAgenzia = (String)attributes.get("codiceAgenzia");

		if (codiceAgenzia != null) {
			setCodiceAgenzia(codiceAgenzia);
		}

		String codiceBanca = (String)attributes.get("codiceBanca");

		if (codiceBanca != null) {
			setCodiceBanca(codiceBanca);
		}

		Integer codiceCAB = (Integer)attributes.get("codiceCAB");

		if (codiceCAB != null) {
			setCodiceCAB(codiceCAB);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}

		String piazza = (String)attributes.get("piazza");

		if (piazza != null) {
			setPiazza(piazza);
		}

		String codiceAzienda = (String)attributes.get("codiceAzienda");

		if (codiceAzienda != null) {
			setCodiceAzienda(codiceAzienda);
		}
	}

	@Override
	public String getCBanca() {
		return _cBanca;
	}

	@Override
	public void setCBanca(String cBanca) {
		_cBanca = cBanca;

		if (_bancheAppoggioRemoteModel != null) {
			try {
				Class<?> clazz = _bancheAppoggioRemoteModel.getClass();

				Method method = clazz.getMethod("setCBanca", String.class);

				method.invoke(_bancheAppoggioRemoteModel, cBanca);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getCodiceABI() {
		return _codiceABI;
	}

	@Override
	public void setCodiceABI(int codiceABI) {
		_codiceABI = codiceABI;

		if (_bancheAppoggioRemoteModel != null) {
			try {
				Class<?> clazz = _bancheAppoggioRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceABI", int.class);

				method.invoke(_bancheAppoggioRemoteModel, codiceABI);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodiceAgenzia() {
		return _codiceAgenzia;
	}

	@Override
	public void setCodiceAgenzia(String codiceAgenzia) {
		_codiceAgenzia = codiceAgenzia;

		if (_bancheAppoggioRemoteModel != null) {
			try {
				Class<?> clazz = _bancheAppoggioRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceAgenzia", String.class);

				method.invoke(_bancheAppoggioRemoteModel, codiceAgenzia);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodiceBanca() {
		return _codiceBanca;
	}

	@Override
	public void setCodiceBanca(String codiceBanca) {
		_codiceBanca = codiceBanca;

		if (_bancheAppoggioRemoteModel != null) {
			try {
				Class<?> clazz = _bancheAppoggioRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceBanca", String.class);

				method.invoke(_bancheAppoggioRemoteModel, codiceBanca);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getCodiceCAB() {
		return _codiceCAB;
	}

	@Override
	public void setCodiceCAB(int codiceCAB) {
		_codiceCAB = codiceCAB;

		if (_bancheAppoggioRemoteModel != null) {
			try {
				Class<?> clazz = _bancheAppoggioRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceCAB", int.class);

				method.invoke(_bancheAppoggioRemoteModel, codiceCAB);
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

		if (_bancheAppoggioRemoteModel != null) {
			try {
				Class<?> clazz = _bancheAppoggioRemoteModel.getClass();

				Method method = clazz.getMethod("setDescrizione", String.class);

				method.invoke(_bancheAppoggioRemoteModel, descrizione);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPiazza() {
		return _piazza;
	}

	@Override
	public void setPiazza(String piazza) {
		_piazza = piazza;

		if (_bancheAppoggioRemoteModel != null) {
			try {
				Class<?> clazz = _bancheAppoggioRemoteModel.getClass();

				Method method = clazz.getMethod("setPiazza", String.class);

				method.invoke(_bancheAppoggioRemoteModel, piazza);
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

		if (_bancheAppoggioRemoteModel != null) {
			try {
				Class<?> clazz = _bancheAppoggioRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceAzienda", String.class);

				method.invoke(_bancheAppoggioRemoteModel, codiceAzienda);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBancheAppoggioRemoteModel() {
		return _bancheAppoggioRemoteModel;
	}

	public void setBancheAppoggioRemoteModel(
		BaseModel<?> bancheAppoggioRemoteModel) {
		_bancheAppoggioRemoteModel = bancheAppoggioRemoteModel;
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

		Class<?> remoteModelClass = _bancheAppoggioRemoteModel.getClass();

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

		Object returnValue = method.invoke(_bancheAppoggioRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BancheAppoggioLocalServiceUtil.addBancheAppoggio(this);
		}
		else {
			BancheAppoggioLocalServiceUtil.updateBancheAppoggio(this);
		}
	}

	@Override
	public BancheAppoggio toEscapedModel() {
		return (BancheAppoggio)ProxyUtil.newProxyInstance(BancheAppoggio.class.getClassLoader(),
			new Class[] { BancheAppoggio.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BancheAppoggioClp clone = new BancheAppoggioClp();

		clone.setCBanca(getCBanca());
		clone.setCodiceABI(getCodiceABI());
		clone.setCodiceAgenzia(getCodiceAgenzia());
		clone.setCodiceBanca(getCodiceBanca());
		clone.setCodiceCAB(getCodiceCAB());
		clone.setDescrizione(getDescrizione());
		clone.setPiazza(getPiazza());
		clone.setCodiceAzienda(getCodiceAzienda());

		return clone;
	}

	@Override
	public int compareTo(BancheAppoggio bancheAppoggio) {
		String primaryKey = bancheAppoggio.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BancheAppoggioClp)) {
			return false;
		}

		BancheAppoggioClp bancheAppoggio = (BancheAppoggioClp)obj;

		String primaryKey = bancheAppoggio.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{cBanca=");
		sb.append(getCBanca());
		sb.append(", codiceABI=");
		sb.append(getCodiceABI());
		sb.append(", codiceAgenzia=");
		sb.append(getCodiceAgenzia());
		sb.append(", codiceBanca=");
		sb.append(getCodiceBanca());
		sb.append(", codiceCAB=");
		sb.append(getCodiceCAB());
		sb.append(", descrizione=");
		sb.append(getDescrizione());
		sb.append(", piazza=");
		sb.append(getPiazza());
		sb.append(", codiceAzienda=");
		sb.append(getCodiceAzienda());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("it.bysoftware.ct.model.BancheAppoggio");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>cBanca</column-name><column-value><![CDATA[");
		sb.append(getCBanca());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceABI</column-name><column-value><![CDATA[");
		sb.append(getCodiceABI());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceAgenzia</column-name><column-value><![CDATA[");
		sb.append(getCodiceAgenzia());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceBanca</column-name><column-value><![CDATA[");
		sb.append(getCodiceBanca());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceCAB</column-name><column-value><![CDATA[");
		sb.append(getCodiceCAB());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descrizione</column-name><column-value><![CDATA[");
		sb.append(getDescrizione());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>piazza</column-name><column-value><![CDATA[");
		sb.append(getPiazza());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceAzienda</column-name><column-value><![CDATA[");
		sb.append(getCodiceAzienda());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _cBanca;
	private int _codiceABI;
	private String _codiceAgenzia;
	private String _codiceBanca;
	private int _codiceCAB;
	private String _descrizione;
	private String _piazza;
	private String _codiceAzienda;
	private BaseModel<?> _bancheAppoggioRemoteModel;
	private Class<?> _clpSerializerClass = it.bysoftware.ct.service.ClpSerializer.class;
}
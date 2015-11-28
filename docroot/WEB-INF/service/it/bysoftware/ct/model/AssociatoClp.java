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

import it.bysoftware.ct.service.AssociatoLocalServiceUtil;
import it.bysoftware.ct.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class AssociatoClp extends BaseModelImpl<Associato> implements Associato {
	public AssociatoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Associato.class;
	}

	@Override
	public String getModelClassName() {
		return Associato.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("centro", getCentro());
		attributes.put("ragioneSociale", getRagioneSociale());
		attributes.put("partitaIVA", getPartitaIVA());
		attributes.put("indirizzo", getIndirizzo());
		attributes.put("telefono", getTelefono());
		attributes.put("fax", getFax());
		attributes.put("nomeUtente", getNomeUtente());
		attributes.put("email", getEmail());
		attributes.put("password", getPassword());
		attributes.put("idLiferay", getIdLiferay());
		attributes.put("idOp", getIdOp());
		attributes.put("attivo", getAttivo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String centro = (String)attributes.get("centro");

		if (centro != null) {
			setCentro(centro);
		}

		String ragioneSociale = (String)attributes.get("ragioneSociale");

		if (ragioneSociale != null) {
			setRagioneSociale(ragioneSociale);
		}

		String partitaIVA = (String)attributes.get("partitaIVA");

		if (partitaIVA != null) {
			setPartitaIVA(partitaIVA);
		}

		String indirizzo = (String)attributes.get("indirizzo");

		if (indirizzo != null) {
			setIndirizzo(indirizzo);
		}

		String telefono = (String)attributes.get("telefono");

		if (telefono != null) {
			setTelefono(telefono);
		}

		String fax = (String)attributes.get("fax");

		if (fax != null) {
			setFax(fax);
		}

		String nomeUtente = (String)attributes.get("nomeUtente");

		if (nomeUtente != null) {
			setNomeUtente(nomeUtente);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		Long idLiferay = (Long)attributes.get("idLiferay");

		if (idLiferay != null) {
			setIdLiferay(idLiferay);
		}

		Long idOp = (Long)attributes.get("idOp");

		if (idOp != null) {
			setIdOp(idOp);
		}

		Boolean attivo = (Boolean)attributes.get("attivo");

		if (attivo != null) {
			setAttivo(attivo);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_associatoRemoteModel != null) {
			try {
				Class<?> clazz = _associatoRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_associatoRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCentro() {
		return _centro;
	}

	@Override
	public void setCentro(String centro) {
		_centro = centro;

		if (_associatoRemoteModel != null) {
			try {
				Class<?> clazz = _associatoRemoteModel.getClass();

				Method method = clazz.getMethod("setCentro", String.class);

				method.invoke(_associatoRemoteModel, centro);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRagioneSociale() {
		return _ragioneSociale;
	}

	@Override
	public void setRagioneSociale(String ragioneSociale) {
		_ragioneSociale = ragioneSociale;

		if (_associatoRemoteModel != null) {
			try {
				Class<?> clazz = _associatoRemoteModel.getClass();

				Method method = clazz.getMethod("setRagioneSociale",
						String.class);

				method.invoke(_associatoRemoteModel, ragioneSociale);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPartitaIVA() {
		return _partitaIVA;
	}

	@Override
	public void setPartitaIVA(String partitaIVA) {
		_partitaIVA = partitaIVA;

		if (_associatoRemoteModel != null) {
			try {
				Class<?> clazz = _associatoRemoteModel.getClass();

				Method method = clazz.getMethod("setPartitaIVA", String.class);

				method.invoke(_associatoRemoteModel, partitaIVA);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIndirizzo() {
		return _indirizzo;
	}

	@Override
	public void setIndirizzo(String indirizzo) {
		_indirizzo = indirizzo;

		if (_associatoRemoteModel != null) {
			try {
				Class<?> clazz = _associatoRemoteModel.getClass();

				Method method = clazz.getMethod("setIndirizzo", String.class);

				method.invoke(_associatoRemoteModel, indirizzo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTelefono() {
		return _telefono;
	}

	@Override
	public void setTelefono(String telefono) {
		_telefono = telefono;

		if (_associatoRemoteModel != null) {
			try {
				Class<?> clazz = _associatoRemoteModel.getClass();

				Method method = clazz.getMethod("setTelefono", String.class);

				method.invoke(_associatoRemoteModel, telefono);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFax() {
		return _fax;
	}

	@Override
	public void setFax(String fax) {
		_fax = fax;

		if (_associatoRemoteModel != null) {
			try {
				Class<?> clazz = _associatoRemoteModel.getClass();

				Method method = clazz.getMethod("setFax", String.class);

				method.invoke(_associatoRemoteModel, fax);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNomeUtente() {
		return _nomeUtente;
	}

	@Override
	public void setNomeUtente(String nomeUtente) {
		_nomeUtente = nomeUtente;

		if (_associatoRemoteModel != null) {
			try {
				Class<?> clazz = _associatoRemoteModel.getClass();

				Method method = clazz.getMethod("setNomeUtente", String.class);

				method.invoke(_associatoRemoteModel, nomeUtente);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmail() {
		return _email;
	}

	@Override
	public void setEmail(String email) {
		_email = email;

		if (_associatoRemoteModel != null) {
			try {
				Class<?> clazz = _associatoRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_associatoRemoteModel, email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPassword() {
		return _password;
	}

	@Override
	public void setPassword(String password) {
		_password = password;

		if (_associatoRemoteModel != null) {
			try {
				Class<?> clazz = _associatoRemoteModel.getClass();

				Method method = clazz.getMethod("setPassword", String.class);

				method.invoke(_associatoRemoteModel, password);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIdLiferay() {
		return _idLiferay;
	}

	@Override
	public void setIdLiferay(long idLiferay) {
		_idLiferay = idLiferay;

		if (_associatoRemoteModel != null) {
			try {
				Class<?> clazz = _associatoRemoteModel.getClass();

				Method method = clazz.getMethod("setIdLiferay", long.class);

				method.invoke(_associatoRemoteModel, idLiferay);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIdOp() {
		return _idOp;
	}

	@Override
	public void setIdOp(long idOp) {
		_idOp = idOp;

		if (_associatoRemoteModel != null) {
			try {
				Class<?> clazz = _associatoRemoteModel.getClass();

				Method method = clazz.getMethod("setIdOp", long.class);

				method.invoke(_associatoRemoteModel, idOp);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getAttivo() {
		return _attivo;
	}

	@Override
	public boolean isAttivo() {
		return _attivo;
	}

	@Override
	public void setAttivo(boolean attivo) {
		_attivo = attivo;

		if (_associatoRemoteModel != null) {
			try {
				Class<?> clazz = _associatoRemoteModel.getClass();

				Method method = clazz.getMethod("setAttivo", boolean.class);

				method.invoke(_associatoRemoteModel, attivo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAssociatoRemoteModel() {
		return _associatoRemoteModel;
	}

	public void setAssociatoRemoteModel(BaseModel<?> associatoRemoteModel) {
		_associatoRemoteModel = associatoRemoteModel;
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

		Class<?> remoteModelClass = _associatoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_associatoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AssociatoLocalServiceUtil.addAssociato(this);
		}
		else {
			AssociatoLocalServiceUtil.updateAssociato(this);
		}
	}

	@Override
	public Associato toEscapedModel() {
		return (Associato)ProxyUtil.newProxyInstance(Associato.class.getClassLoader(),
			new Class[] { Associato.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AssociatoClp clone = new AssociatoClp();

		clone.setId(getId());
		clone.setCentro(getCentro());
		clone.setRagioneSociale(getRagioneSociale());
		clone.setPartitaIVA(getPartitaIVA());
		clone.setIndirizzo(getIndirizzo());
		clone.setTelefono(getTelefono());
		clone.setFax(getFax());
		clone.setNomeUtente(getNomeUtente());
		clone.setEmail(getEmail());
		clone.setPassword(getPassword());
		clone.setIdLiferay(getIdLiferay());
		clone.setIdOp(getIdOp());
		clone.setAttivo(getAttivo());

		return clone;
	}

	@Override
	public int compareTo(Associato associato) {
		long primaryKey = associato.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AssociatoClp)) {
			return false;
		}

		AssociatoClp associato = (AssociatoClp)obj;

		long primaryKey = associato.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
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
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", centro=");
		sb.append(getCentro());
		sb.append(", ragioneSociale=");
		sb.append(getRagioneSociale());
		sb.append(", partitaIVA=");
		sb.append(getPartitaIVA());
		sb.append(", indirizzo=");
		sb.append(getIndirizzo());
		sb.append(", telefono=");
		sb.append(getTelefono());
		sb.append(", fax=");
		sb.append(getFax());
		sb.append(", nomeUtente=");
		sb.append(getNomeUtente());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", password=");
		sb.append(getPassword());
		sb.append(", idLiferay=");
		sb.append(getIdLiferay());
		sb.append(", idOp=");
		sb.append(getIdOp());
		sb.append(", attivo=");
		sb.append(getAttivo());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("it.bysoftware.ct.model.Associato");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>centro</column-name><column-value><![CDATA[");
		sb.append(getCentro());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ragioneSociale</column-name><column-value><![CDATA[");
		sb.append(getRagioneSociale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>partitaIVA</column-name><column-value><![CDATA[");
		sb.append(getPartitaIVA());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>indirizzo</column-name><column-value><![CDATA[");
		sb.append(getIndirizzo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>telefono</column-name><column-value><![CDATA[");
		sb.append(getTelefono());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fax</column-name><column-value><![CDATA[");
		sb.append(getFax());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nomeUtente</column-name><column-value><![CDATA[");
		sb.append(getNomeUtente());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>password</column-name><column-value><![CDATA[");
		sb.append(getPassword());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idLiferay</column-name><column-value><![CDATA[");
		sb.append(getIdLiferay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idOp</column-name><column-value><![CDATA[");
		sb.append(getIdOp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attivo</column-name><column-value><![CDATA[");
		sb.append(getAttivo());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _centro;
	private String _ragioneSociale;
	private String _partitaIVA;
	private String _indirizzo;
	private String _telefono;
	private String _fax;
	private String _nomeUtente;
	private String _email;
	private String _password;
	private long _idLiferay;
	private long _idOp;
	private boolean _attivo;
	private BaseModel<?> _associatoRemoteModel;
	private Class<?> _clpSerializerClass = it.bysoftware.ct.service.ClpSerializer.class;
}
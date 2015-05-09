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
import it.bysoftware.ct.service.DestinatariDiversiLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class DestinatariDiversiClp extends BaseModelImpl<DestinatariDiversi>
	implements DestinatariDiversi {
	public DestinatariDiversiClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return DestinatariDiversi.class;
	}

	@Override
	public String getModelClassName() {
		return DestinatariDiversi.class.getName();
	}

	@Override
	public String getPrimaryKey() {
		return _codiceAnagrafica;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setCodiceAnagrafica(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _codiceAnagrafica;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("codiceAnagrafica", getCodiceAnagrafica());
		attributes.put("codiceRiferimento", getCodiceRiferimento());
		attributes.put("CAP", getCAP());
		attributes.put("comune", getComune());
		attributes.put("indirizzo", getIndirizzo());
		attributes.put("provincia", getProvincia());
		attributes.put("stato", getStato());
		attributes.put("tipoAnagrafica", getTipoAnagrafica());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String codiceAnagrafica = (String)attributes.get("codiceAnagrafica");

		if (codiceAnagrafica != null) {
			setCodiceAnagrafica(codiceAnagrafica);
		}

		String codiceRiferimento = (String)attributes.get("codiceRiferimento");

		if (codiceRiferimento != null) {
			setCodiceRiferimento(codiceRiferimento);
		}

		String CAP = (String)attributes.get("CAP");

		if (CAP != null) {
			setCAP(CAP);
		}

		String comune = (String)attributes.get("comune");

		if (comune != null) {
			setComune(comune);
		}

		String indirizzo = (String)attributes.get("indirizzo");

		if (indirizzo != null) {
			setIndirizzo(indirizzo);
		}

		String provincia = (String)attributes.get("provincia");

		if (provincia != null) {
			setProvincia(provincia);
		}

		String stato = (String)attributes.get("stato");

		if (stato != null) {
			setStato(stato);
		}

		String tipoAnagrafica = (String)attributes.get("tipoAnagrafica");

		if (tipoAnagrafica != null) {
			setTipoAnagrafica(tipoAnagrafica);
		}
	}

	@Override
	public String getCodiceAnagrafica() {
		return _codiceAnagrafica;
	}

	@Override
	public void setCodiceAnagrafica(String codiceAnagrafica) {
		_codiceAnagrafica = codiceAnagrafica;

		if (_destinatariDiversiRemoteModel != null) {
			try {
				Class<?> clazz = _destinatariDiversiRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceAnagrafica",
						String.class);

				method.invoke(_destinatariDiversiRemoteModel, codiceAnagrafica);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodiceRiferimento() {
		return _codiceRiferimento;
	}

	@Override
	public void setCodiceRiferimento(String codiceRiferimento) {
		_codiceRiferimento = codiceRiferimento;

		if (_destinatariDiversiRemoteModel != null) {
			try {
				Class<?> clazz = _destinatariDiversiRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceRiferimento",
						String.class);

				method.invoke(_destinatariDiversiRemoteModel, codiceRiferimento);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCAP() {
		return _CAP;
	}

	@Override
	public void setCAP(String CAP) {
		_CAP = CAP;

		if (_destinatariDiversiRemoteModel != null) {
			try {
				Class<?> clazz = _destinatariDiversiRemoteModel.getClass();

				Method method = clazz.getMethod("setCAP", String.class);

				method.invoke(_destinatariDiversiRemoteModel, CAP);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getComune() {
		return _comune;
	}

	@Override
	public void setComune(String comune) {
		_comune = comune;

		if (_destinatariDiversiRemoteModel != null) {
			try {
				Class<?> clazz = _destinatariDiversiRemoteModel.getClass();

				Method method = clazz.getMethod("setComune", String.class);

				method.invoke(_destinatariDiversiRemoteModel, comune);
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

		if (_destinatariDiversiRemoteModel != null) {
			try {
				Class<?> clazz = _destinatariDiversiRemoteModel.getClass();

				Method method = clazz.getMethod("setIndirizzo", String.class);

				method.invoke(_destinatariDiversiRemoteModel, indirizzo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProvincia() {
		return _provincia;
	}

	@Override
	public void setProvincia(String provincia) {
		_provincia = provincia;

		if (_destinatariDiversiRemoteModel != null) {
			try {
				Class<?> clazz = _destinatariDiversiRemoteModel.getClass();

				Method method = clazz.getMethod("setProvincia", String.class);

				method.invoke(_destinatariDiversiRemoteModel, provincia);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStato() {
		return _stato;
	}

	@Override
	public void setStato(String stato) {
		_stato = stato;

		if (_destinatariDiversiRemoteModel != null) {
			try {
				Class<?> clazz = _destinatariDiversiRemoteModel.getClass();

				Method method = clazz.getMethod("setStato", String.class);

				method.invoke(_destinatariDiversiRemoteModel, stato);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTipoAnagrafica() {
		return _tipoAnagrafica;
	}

	@Override
	public void setTipoAnagrafica(String tipoAnagrafica) {
		_tipoAnagrafica = tipoAnagrafica;

		if (_destinatariDiversiRemoteModel != null) {
			try {
				Class<?> clazz = _destinatariDiversiRemoteModel.getClass();

				Method method = clazz.getMethod("setTipoAnagrafica",
						String.class);

				method.invoke(_destinatariDiversiRemoteModel, tipoAnagrafica);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDestinatariDiversiRemoteModel() {
		return _destinatariDiversiRemoteModel;
	}

	public void setDestinatariDiversiRemoteModel(
		BaseModel<?> destinatariDiversiRemoteModel) {
		_destinatariDiversiRemoteModel = destinatariDiversiRemoteModel;
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

		Class<?> remoteModelClass = _destinatariDiversiRemoteModel.getClass();

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

		Object returnValue = method.invoke(_destinatariDiversiRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DestinatariDiversiLocalServiceUtil.addDestinatariDiversi(this);
		}
		else {
			DestinatariDiversiLocalServiceUtil.updateDestinatariDiversi(this);
		}
	}

	@Override
	public DestinatariDiversi toEscapedModel() {
		return (DestinatariDiversi)ProxyUtil.newProxyInstance(DestinatariDiversi.class.getClassLoader(),
			new Class[] { DestinatariDiversi.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DestinatariDiversiClp clone = new DestinatariDiversiClp();

		clone.setCodiceAnagrafica(getCodiceAnagrafica());
		clone.setCodiceRiferimento(getCodiceRiferimento());
		clone.setCAP(getCAP());
		clone.setComune(getComune());
		clone.setIndirizzo(getIndirizzo());
		clone.setProvincia(getProvincia());
		clone.setStato(getStato());
		clone.setTipoAnagrafica(getTipoAnagrafica());

		return clone;
	}

	@Override
	public int compareTo(DestinatariDiversi destinatariDiversi) {
		String primaryKey = destinatariDiversi.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DestinatariDiversiClp)) {
			return false;
		}

		DestinatariDiversiClp destinatariDiversi = (DestinatariDiversiClp)obj;

		String primaryKey = destinatariDiversi.getPrimaryKey();

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

		sb.append("{codiceAnagrafica=");
		sb.append(getCodiceAnagrafica());
		sb.append(", codiceRiferimento=");
		sb.append(getCodiceRiferimento());
		sb.append(", CAP=");
		sb.append(getCAP());
		sb.append(", comune=");
		sb.append(getComune());
		sb.append(", indirizzo=");
		sb.append(getIndirizzo());
		sb.append(", provincia=");
		sb.append(getProvincia());
		sb.append(", stato=");
		sb.append(getStato());
		sb.append(", tipoAnagrafica=");
		sb.append(getTipoAnagrafica());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("it.bysoftware.ct.model.DestinatariDiversi");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>codiceAnagrafica</column-name><column-value><![CDATA[");
		sb.append(getCodiceAnagrafica());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceRiferimento</column-name><column-value><![CDATA[");
		sb.append(getCodiceRiferimento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CAP</column-name><column-value><![CDATA[");
		sb.append(getCAP());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comune</column-name><column-value><![CDATA[");
		sb.append(getComune());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>indirizzo</column-name><column-value><![CDATA[");
		sb.append(getIndirizzo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>provincia</column-name><column-value><![CDATA[");
		sb.append(getProvincia());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stato</column-name><column-value><![CDATA[");
		sb.append(getStato());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipoAnagrafica</column-name><column-value><![CDATA[");
		sb.append(getTipoAnagrafica());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _codiceAnagrafica;
	private String _codiceRiferimento;
	private String _CAP;
	private String _comune;
	private String _indirizzo;
	private String _provincia;
	private String _stato;
	private String _tipoAnagrafica;
	private BaseModel<?> _destinatariDiversiRemoteModel;
	private Class<?> _clpSerializerClass = it.bysoftware.ct.service.ClpSerializer.class;
}
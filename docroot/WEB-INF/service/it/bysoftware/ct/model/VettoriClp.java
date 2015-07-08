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
import it.bysoftware.ct.service.VettoriLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class VettoriClp extends BaseModelImpl<Vettori> implements Vettori {
	public VettoriClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Vettori.class;
	}

	@Override
	public String getModelClassName() {
		return Vettori.class.getName();
	}

	@Override
	public String getPrimaryKey() {
		return _codiceVettore;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setCodiceVettore(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _codiceVettore;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("albo", getAlbo());
		attributes.put("CAP", getCAP());
		attributes.put("codiceVettore", getCodiceVettore());
		attributes.put("codiceFiscale", getCodiceFiscale());
		attributes.put("codiceRiferimento", getCodiceRiferimento());
		attributes.put("comune", getComune());
		attributes.put("indirizzo", getIndirizzo());
		attributes.put("note", getNote());
		attributes.put("partitaIVA", getPartitaIVA());
		attributes.put("ragioneSociale", getRagioneSociale());
		attributes.put("ragioneSociale2", getRagioneSociale2());
		attributes.put("provincia", getProvincia());
		attributes.put("stato", getStato());
		attributes.put("tipoAnagrafica", getTipoAnagrafica());
		attributes.put("codiceAzienda", getCodiceAzienda());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String albo = (String)attributes.get("albo");

		if (albo != null) {
			setAlbo(albo);
		}

		String CAP = (String)attributes.get("CAP");

		if (CAP != null) {
			setCAP(CAP);
		}

		String codiceVettore = (String)attributes.get("codiceVettore");

		if (codiceVettore != null) {
			setCodiceVettore(codiceVettore);
		}

		String codiceFiscale = (String)attributes.get("codiceFiscale");

		if (codiceFiscale != null) {
			setCodiceFiscale(codiceFiscale);
		}

		String codiceRiferimento = (String)attributes.get("codiceRiferimento");

		if (codiceRiferimento != null) {
			setCodiceRiferimento(codiceRiferimento);
		}

		String comune = (String)attributes.get("comune");

		if (comune != null) {
			setComune(comune);
		}

		String indirizzo = (String)attributes.get("indirizzo");

		if (indirizzo != null) {
			setIndirizzo(indirizzo);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		String partitaIVA = (String)attributes.get("partitaIVA");

		if (partitaIVA != null) {
			setPartitaIVA(partitaIVA);
		}

		String ragioneSociale = (String)attributes.get("ragioneSociale");

		if (ragioneSociale != null) {
			setRagioneSociale(ragioneSociale);
		}

		String ragioneSociale2 = (String)attributes.get("ragioneSociale2");

		if (ragioneSociale2 != null) {
			setRagioneSociale2(ragioneSociale2);
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

		String codiceAzienda = (String)attributes.get("codiceAzienda");

		if (codiceAzienda != null) {
			setCodiceAzienda(codiceAzienda);
		}
	}

	@Override
	public String getAlbo() {
		return _albo;
	}

	@Override
	public void setAlbo(String albo) {
		_albo = albo;

		if (_vettoriRemoteModel != null) {
			try {
				Class<?> clazz = _vettoriRemoteModel.getClass();

				Method method = clazz.getMethod("setAlbo", String.class);

				method.invoke(_vettoriRemoteModel, albo);
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

		if (_vettoriRemoteModel != null) {
			try {
				Class<?> clazz = _vettoriRemoteModel.getClass();

				Method method = clazz.getMethod("setCAP", String.class);

				method.invoke(_vettoriRemoteModel, CAP);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodiceVettore() {
		return _codiceVettore;
	}

	@Override
	public void setCodiceVettore(String codiceVettore) {
		_codiceVettore = codiceVettore;

		if (_vettoriRemoteModel != null) {
			try {
				Class<?> clazz = _vettoriRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceVettore", String.class);

				method.invoke(_vettoriRemoteModel, codiceVettore);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodiceFiscale() {
		return _codiceFiscale;
	}

	@Override
	public void setCodiceFiscale(String codiceFiscale) {
		_codiceFiscale = codiceFiscale;

		if (_vettoriRemoteModel != null) {
			try {
				Class<?> clazz = _vettoriRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceFiscale", String.class);

				method.invoke(_vettoriRemoteModel, codiceFiscale);
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

		if (_vettoriRemoteModel != null) {
			try {
				Class<?> clazz = _vettoriRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceRiferimento",
						String.class);

				method.invoke(_vettoriRemoteModel, codiceRiferimento);
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

		if (_vettoriRemoteModel != null) {
			try {
				Class<?> clazz = _vettoriRemoteModel.getClass();

				Method method = clazz.getMethod("setComune", String.class);

				method.invoke(_vettoriRemoteModel, comune);
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

		if (_vettoriRemoteModel != null) {
			try {
				Class<?> clazz = _vettoriRemoteModel.getClass();

				Method method = clazz.getMethod("setIndirizzo", String.class);

				method.invoke(_vettoriRemoteModel, indirizzo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNote() {
		return _note;
	}

	@Override
	public void setNote(String note) {
		_note = note;

		if (_vettoriRemoteModel != null) {
			try {
				Class<?> clazz = _vettoriRemoteModel.getClass();

				Method method = clazz.getMethod("setNote", String.class);

				method.invoke(_vettoriRemoteModel, note);
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

		if (_vettoriRemoteModel != null) {
			try {
				Class<?> clazz = _vettoriRemoteModel.getClass();

				Method method = clazz.getMethod("setPartitaIVA", String.class);

				method.invoke(_vettoriRemoteModel, partitaIVA);
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

		if (_vettoriRemoteModel != null) {
			try {
				Class<?> clazz = _vettoriRemoteModel.getClass();

				Method method = clazz.getMethod("setRagioneSociale",
						String.class);

				method.invoke(_vettoriRemoteModel, ragioneSociale);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRagioneSociale2() {
		return _ragioneSociale2;
	}

	@Override
	public void setRagioneSociale2(String ragioneSociale2) {
		_ragioneSociale2 = ragioneSociale2;

		if (_vettoriRemoteModel != null) {
			try {
				Class<?> clazz = _vettoriRemoteModel.getClass();

				Method method = clazz.getMethod("setRagioneSociale2",
						String.class);

				method.invoke(_vettoriRemoteModel, ragioneSociale2);
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

		if (_vettoriRemoteModel != null) {
			try {
				Class<?> clazz = _vettoriRemoteModel.getClass();

				Method method = clazz.getMethod("setProvincia", String.class);

				method.invoke(_vettoriRemoteModel, provincia);
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

		if (_vettoriRemoteModel != null) {
			try {
				Class<?> clazz = _vettoriRemoteModel.getClass();

				Method method = clazz.getMethod("setStato", String.class);

				method.invoke(_vettoriRemoteModel, stato);
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

		if (_vettoriRemoteModel != null) {
			try {
				Class<?> clazz = _vettoriRemoteModel.getClass();

				Method method = clazz.getMethod("setTipoAnagrafica",
						String.class);

				method.invoke(_vettoriRemoteModel, tipoAnagrafica);
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

		if (_vettoriRemoteModel != null) {
			try {
				Class<?> clazz = _vettoriRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceAzienda", String.class);

				method.invoke(_vettoriRemoteModel, codiceAzienda);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVettoriRemoteModel() {
		return _vettoriRemoteModel;
	}

	public void setVettoriRemoteModel(BaseModel<?> vettoriRemoteModel) {
		_vettoriRemoteModel = vettoriRemoteModel;
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

		Class<?> remoteModelClass = _vettoriRemoteModel.getClass();

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

		Object returnValue = method.invoke(_vettoriRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VettoriLocalServiceUtil.addVettori(this);
		}
		else {
			VettoriLocalServiceUtil.updateVettori(this);
		}
	}

	@Override
	public Vettori toEscapedModel() {
		return (Vettori)ProxyUtil.newProxyInstance(Vettori.class.getClassLoader(),
			new Class[] { Vettori.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VettoriClp clone = new VettoriClp();

		clone.setAlbo(getAlbo());
		clone.setCAP(getCAP());
		clone.setCodiceVettore(getCodiceVettore());
		clone.setCodiceFiscale(getCodiceFiscale());
		clone.setCodiceRiferimento(getCodiceRiferimento());
		clone.setComune(getComune());
		clone.setIndirizzo(getIndirizzo());
		clone.setNote(getNote());
		clone.setPartitaIVA(getPartitaIVA());
		clone.setRagioneSociale(getRagioneSociale());
		clone.setRagioneSociale2(getRagioneSociale2());
		clone.setProvincia(getProvincia());
		clone.setStato(getStato());
		clone.setTipoAnagrafica(getTipoAnagrafica());
		clone.setCodiceAzienda(getCodiceAzienda());

		return clone;
	}

	@Override
	public int compareTo(Vettori vettori) {
		String primaryKey = vettori.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VettoriClp)) {
			return false;
		}

		VettoriClp vettori = (VettoriClp)obj;

		String primaryKey = vettori.getPrimaryKey();

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
		StringBundler sb = new StringBundler(31);

		sb.append("{albo=");
		sb.append(getAlbo());
		sb.append(", CAP=");
		sb.append(getCAP());
		sb.append(", codiceVettore=");
		sb.append(getCodiceVettore());
		sb.append(", codiceFiscale=");
		sb.append(getCodiceFiscale());
		sb.append(", codiceRiferimento=");
		sb.append(getCodiceRiferimento());
		sb.append(", comune=");
		sb.append(getComune());
		sb.append(", indirizzo=");
		sb.append(getIndirizzo());
		sb.append(", note=");
		sb.append(getNote());
		sb.append(", partitaIVA=");
		sb.append(getPartitaIVA());
		sb.append(", ragioneSociale=");
		sb.append(getRagioneSociale());
		sb.append(", ragioneSociale2=");
		sb.append(getRagioneSociale2());
		sb.append(", provincia=");
		sb.append(getProvincia());
		sb.append(", stato=");
		sb.append(getStato());
		sb.append(", tipoAnagrafica=");
		sb.append(getTipoAnagrafica());
		sb.append(", codiceAzienda=");
		sb.append(getCodiceAzienda());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("it.bysoftware.ct.model.Vettori");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>albo</column-name><column-value><![CDATA[");
		sb.append(getAlbo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CAP</column-name><column-value><![CDATA[");
		sb.append(getCAP());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceVettore</column-name><column-value><![CDATA[");
		sb.append(getCodiceVettore());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceFiscale</column-name><column-value><![CDATA[");
		sb.append(getCodiceFiscale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceRiferimento</column-name><column-value><![CDATA[");
		sb.append(getCodiceRiferimento());
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
			"<column><column-name>note</column-name><column-value><![CDATA[");
		sb.append(getNote());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>partitaIVA</column-name><column-value><![CDATA[");
		sb.append(getPartitaIVA());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ragioneSociale</column-name><column-value><![CDATA[");
		sb.append(getRagioneSociale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ragioneSociale2</column-name><column-value><![CDATA[");
		sb.append(getRagioneSociale2());
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
		sb.append(
			"<column><column-name>codiceAzienda</column-name><column-value><![CDATA[");
		sb.append(getCodiceAzienda());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _albo;
	private String _CAP;
	private String _codiceVettore;
	private String _codiceFiscale;
	private String _codiceRiferimento;
	private String _comune;
	private String _indirizzo;
	private String _note;
	private String _partitaIVA;
	private String _ragioneSociale;
	private String _ragioneSociale2;
	private String _provincia;
	private String _stato;
	private String _tipoAnagrafica;
	private String _codiceAzienda;
	private BaseModel<?> _vettoriRemoteModel;
	private Class<?> _clpSerializerClass = it.bysoftware.ct.service.ClpSerializer.class;
}
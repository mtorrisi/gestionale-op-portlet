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

import it.bysoftware.ct.service.AnagraficaLocalServiceUtil;
import it.bysoftware.ct.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class AnagraficaClp extends BaseModelImpl<Anagrafica>
	implements Anagrafica {
	public AnagraficaClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Anagrafica.class;
	}

	@Override
	public String getModelClassName() {
		return Anagrafica.class.getName();
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

		attributes.put("attivoEC", getAttivoEC());
		attributes.put("cap", getCap());
		attributes.put("codiceAnagrafica", getCodiceAnagrafica());
		attributes.put("codiceFiscale", getCodiceFiscale());
		attributes.put("codiceMne", getCodiceMne());
		attributes.put("comune", getComune());
		attributes.put("Indirizzo", getIndirizzo());
		attributes.put("note", getNote());
		attributes.put("partitaIVA", getPartitaIVA());
		attributes.put("ragioneSociale", getRagioneSociale());
		attributes.put("ragioneSocialeAlternativa",
			getRagioneSocialeAlternativa());
		attributes.put("provincia", getProvincia());
		attributes.put("stato", getStato());
		attributes.put("tepefi", getTepefi());
		attributes.put("tipoSoggetto", getTipoSoggetto());
		attributes.put("tipsol", getTipsol());
		attributes.put("codiceAzienda", getCodiceAzienda());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer attivoEC = (Integer)attributes.get("attivoEC");

		if (attivoEC != null) {
			setAttivoEC(attivoEC);
		}

		String cap = (String)attributes.get("cap");

		if (cap != null) {
			setCap(cap);
		}

		String codiceAnagrafica = (String)attributes.get("codiceAnagrafica");

		if (codiceAnagrafica != null) {
			setCodiceAnagrafica(codiceAnagrafica);
		}

		String codiceFiscale = (String)attributes.get("codiceFiscale");

		if (codiceFiscale != null) {
			setCodiceFiscale(codiceFiscale);
		}

		String codiceMne = (String)attributes.get("codiceMne");

		if (codiceMne != null) {
			setCodiceMne(codiceMne);
		}

		String comune = (String)attributes.get("comune");

		if (comune != null) {
			setComune(comune);
		}

		String Indirizzo = (String)attributes.get("Indirizzo");

		if (Indirizzo != null) {
			setIndirizzo(Indirizzo);
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

		String ragioneSocialeAlternativa = (String)attributes.get(
				"ragioneSocialeAlternativa");

		if (ragioneSocialeAlternativa != null) {
			setRagioneSocialeAlternativa(ragioneSocialeAlternativa);
		}

		String provincia = (String)attributes.get("provincia");

		if (provincia != null) {
			setProvincia(provincia);
		}

		String stato = (String)attributes.get("stato");

		if (stato != null) {
			setStato(stato);
		}

		Integer tepefi = (Integer)attributes.get("tepefi");

		if (tepefi != null) {
			setTepefi(tepefi);
		}

		String tipoSoggetto = (String)attributes.get("tipoSoggetto");

		if (tipoSoggetto != null) {
			setTipoSoggetto(tipoSoggetto);
		}

		Integer tipsol = (Integer)attributes.get("tipsol");

		if (tipsol != null) {
			setTipsol(tipsol);
		}

		String codiceAzienda = (String)attributes.get("codiceAzienda");

		if (codiceAzienda != null) {
			setCodiceAzienda(codiceAzienda);
		}
	}

	@Override
	public int getAttivoEC() {
		return _attivoEC;
	}

	@Override
	public void setAttivoEC(int attivoEC) {
		_attivoEC = attivoEC;

		if (_anagraficaRemoteModel != null) {
			try {
				Class<?> clazz = _anagraficaRemoteModel.getClass();

				Method method = clazz.getMethod("setAttivoEC", int.class);

				method.invoke(_anagraficaRemoteModel, attivoEC);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCap() {
		return _cap;
	}

	@Override
	public void setCap(String cap) {
		_cap = cap;

		if (_anagraficaRemoteModel != null) {
			try {
				Class<?> clazz = _anagraficaRemoteModel.getClass();

				Method method = clazz.getMethod("setCap", String.class);

				method.invoke(_anagraficaRemoteModel, cap);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodiceAnagrafica() {
		return _codiceAnagrafica;
	}

	@Override
	public void setCodiceAnagrafica(String codiceAnagrafica) {
		_codiceAnagrafica = codiceAnagrafica;

		if (_anagraficaRemoteModel != null) {
			try {
				Class<?> clazz = _anagraficaRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceAnagrafica",
						String.class);

				method.invoke(_anagraficaRemoteModel, codiceAnagrafica);
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

		if (_anagraficaRemoteModel != null) {
			try {
				Class<?> clazz = _anagraficaRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceFiscale", String.class);

				method.invoke(_anagraficaRemoteModel, codiceFiscale);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodiceMne() {
		return _codiceMne;
	}

	@Override
	public void setCodiceMne(String codiceMne) {
		_codiceMne = codiceMne;

		if (_anagraficaRemoteModel != null) {
			try {
				Class<?> clazz = _anagraficaRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceMne", String.class);

				method.invoke(_anagraficaRemoteModel, codiceMne);
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

		if (_anagraficaRemoteModel != null) {
			try {
				Class<?> clazz = _anagraficaRemoteModel.getClass();

				Method method = clazz.getMethod("setComune", String.class);

				method.invoke(_anagraficaRemoteModel, comune);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIndirizzo() {
		return _Indirizzo;
	}

	@Override
	public void setIndirizzo(String Indirizzo) {
		_Indirizzo = Indirizzo;

		if (_anagraficaRemoteModel != null) {
			try {
				Class<?> clazz = _anagraficaRemoteModel.getClass();

				Method method = clazz.getMethod("setIndirizzo", String.class);

				method.invoke(_anagraficaRemoteModel, Indirizzo);
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

		if (_anagraficaRemoteModel != null) {
			try {
				Class<?> clazz = _anagraficaRemoteModel.getClass();

				Method method = clazz.getMethod("setNote", String.class);

				method.invoke(_anagraficaRemoteModel, note);
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

		if (_anagraficaRemoteModel != null) {
			try {
				Class<?> clazz = _anagraficaRemoteModel.getClass();

				Method method = clazz.getMethod("setPartitaIVA", String.class);

				method.invoke(_anagraficaRemoteModel, partitaIVA);
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

		if (_anagraficaRemoteModel != null) {
			try {
				Class<?> clazz = _anagraficaRemoteModel.getClass();

				Method method = clazz.getMethod("setRagioneSociale",
						String.class);

				method.invoke(_anagraficaRemoteModel, ragioneSociale);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRagioneSocialeAlternativa() {
		return _ragioneSocialeAlternativa;
	}

	@Override
	public void setRagioneSocialeAlternativa(String ragioneSocialeAlternativa) {
		_ragioneSocialeAlternativa = ragioneSocialeAlternativa;

		if (_anagraficaRemoteModel != null) {
			try {
				Class<?> clazz = _anagraficaRemoteModel.getClass();

				Method method = clazz.getMethod("setRagioneSocialeAlternativa",
						String.class);

				method.invoke(_anagraficaRemoteModel, ragioneSocialeAlternativa);
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

		if (_anagraficaRemoteModel != null) {
			try {
				Class<?> clazz = _anagraficaRemoteModel.getClass();

				Method method = clazz.getMethod("setProvincia", String.class);

				method.invoke(_anagraficaRemoteModel, provincia);
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

		if (_anagraficaRemoteModel != null) {
			try {
				Class<?> clazz = _anagraficaRemoteModel.getClass();

				Method method = clazz.getMethod("setStato", String.class);

				method.invoke(_anagraficaRemoteModel, stato);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getTepefi() {
		return _tepefi;
	}

	@Override
	public void setTepefi(int tepefi) {
		_tepefi = tepefi;

		if (_anagraficaRemoteModel != null) {
			try {
				Class<?> clazz = _anagraficaRemoteModel.getClass();

				Method method = clazz.getMethod("setTepefi", int.class);

				method.invoke(_anagraficaRemoteModel, tepefi);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTipoSoggetto() {
		return _tipoSoggetto;
	}

	@Override
	public void setTipoSoggetto(String tipoSoggetto) {
		_tipoSoggetto = tipoSoggetto;

		if (_anagraficaRemoteModel != null) {
			try {
				Class<?> clazz = _anagraficaRemoteModel.getClass();

				Method method = clazz.getMethod("setTipoSoggetto", String.class);

				method.invoke(_anagraficaRemoteModel, tipoSoggetto);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getTipsol() {
		return _tipsol;
	}

	@Override
	public void setTipsol(int tipsol) {
		_tipsol = tipsol;

		if (_anagraficaRemoteModel != null) {
			try {
				Class<?> clazz = _anagraficaRemoteModel.getClass();

				Method method = clazz.getMethod("setTipsol", int.class);

				method.invoke(_anagraficaRemoteModel, tipsol);
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

		if (_anagraficaRemoteModel != null) {
			try {
				Class<?> clazz = _anagraficaRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceAzienda", String.class);

				method.invoke(_anagraficaRemoteModel, codiceAzienda);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAnagraficaRemoteModel() {
		return _anagraficaRemoteModel;
	}

	public void setAnagraficaRemoteModel(BaseModel<?> anagraficaRemoteModel) {
		_anagraficaRemoteModel = anagraficaRemoteModel;
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

		Class<?> remoteModelClass = _anagraficaRemoteModel.getClass();

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

		Object returnValue = method.invoke(_anagraficaRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AnagraficaLocalServiceUtil.addAnagrafica(this);
		}
		else {
			AnagraficaLocalServiceUtil.updateAnagrafica(this);
		}
	}

	@Override
	public Anagrafica toEscapedModel() {
		return (Anagrafica)ProxyUtil.newProxyInstance(Anagrafica.class.getClassLoader(),
			new Class[] { Anagrafica.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AnagraficaClp clone = new AnagraficaClp();

		clone.setAttivoEC(getAttivoEC());
		clone.setCap(getCap());
		clone.setCodiceAnagrafica(getCodiceAnagrafica());
		clone.setCodiceFiscale(getCodiceFiscale());
		clone.setCodiceMne(getCodiceMne());
		clone.setComune(getComune());
		clone.setIndirizzo(getIndirizzo());
		clone.setNote(getNote());
		clone.setPartitaIVA(getPartitaIVA());
		clone.setRagioneSociale(getRagioneSociale());
		clone.setRagioneSocialeAlternativa(getRagioneSocialeAlternativa());
		clone.setProvincia(getProvincia());
		clone.setStato(getStato());
		clone.setTepefi(getTepefi());
		clone.setTipoSoggetto(getTipoSoggetto());
		clone.setTipsol(getTipsol());
		clone.setCodiceAzienda(getCodiceAzienda());

		return clone;
	}

	@Override
	public int compareTo(Anagrafica anagrafica) {
		String primaryKey = anagrafica.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnagraficaClp)) {
			return false;
		}

		AnagraficaClp anagrafica = (AnagraficaClp)obj;

		String primaryKey = anagrafica.getPrimaryKey();

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
		StringBundler sb = new StringBundler(35);

		sb.append("{attivoEC=");
		sb.append(getAttivoEC());
		sb.append(", cap=");
		sb.append(getCap());
		sb.append(", codiceAnagrafica=");
		sb.append(getCodiceAnagrafica());
		sb.append(", codiceFiscale=");
		sb.append(getCodiceFiscale());
		sb.append(", codiceMne=");
		sb.append(getCodiceMne());
		sb.append(", comune=");
		sb.append(getComune());
		sb.append(", Indirizzo=");
		sb.append(getIndirizzo());
		sb.append(", note=");
		sb.append(getNote());
		sb.append(", partitaIVA=");
		sb.append(getPartitaIVA());
		sb.append(", ragioneSociale=");
		sb.append(getRagioneSociale());
		sb.append(", ragioneSocialeAlternativa=");
		sb.append(getRagioneSocialeAlternativa());
		sb.append(", provincia=");
		sb.append(getProvincia());
		sb.append(", stato=");
		sb.append(getStato());
		sb.append(", tepefi=");
		sb.append(getTepefi());
		sb.append(", tipoSoggetto=");
		sb.append(getTipoSoggetto());
		sb.append(", tipsol=");
		sb.append(getTipsol());
		sb.append(", codiceAzienda=");
		sb.append(getCodiceAzienda());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("it.bysoftware.ct.model.Anagrafica");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>attivoEC</column-name><column-value><![CDATA[");
		sb.append(getAttivoEC());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cap</column-name><column-value><![CDATA[");
		sb.append(getCap());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceAnagrafica</column-name><column-value><![CDATA[");
		sb.append(getCodiceAnagrafica());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceFiscale</column-name><column-value><![CDATA[");
		sb.append(getCodiceFiscale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceMne</column-name><column-value><![CDATA[");
		sb.append(getCodiceMne());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comune</column-name><column-value><![CDATA[");
		sb.append(getComune());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Indirizzo</column-name><column-value><![CDATA[");
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
			"<column><column-name>ragioneSocialeAlternativa</column-name><column-value><![CDATA[");
		sb.append(getRagioneSocialeAlternativa());
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
			"<column><column-name>tepefi</column-name><column-value><![CDATA[");
		sb.append(getTepefi());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipoSoggetto</column-name><column-value><![CDATA[");
		sb.append(getTipoSoggetto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipsol</column-name><column-value><![CDATA[");
		sb.append(getTipsol());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceAzienda</column-name><column-value><![CDATA[");
		sb.append(getCodiceAzienda());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _attivoEC;
	private String _cap;
	private String _codiceAnagrafica;
	private String _codiceFiscale;
	private String _codiceMne;
	private String _comune;
	private String _Indirizzo;
	private String _note;
	private String _partitaIVA;
	private String _ragioneSociale;
	private String _ragioneSocialeAlternativa;
	private String _provincia;
	private String _stato;
	private int _tepefi;
	private String _tipoSoggetto;
	private int _tipsol;
	private String _codiceAzienda;
	private BaseModel<?> _anagraficaRemoteModel;
	private Class<?> _clpSerializerClass = it.bysoftware.ct.service.ClpSerializer.class;
}
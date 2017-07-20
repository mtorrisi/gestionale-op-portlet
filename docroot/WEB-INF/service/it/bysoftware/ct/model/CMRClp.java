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

import it.bysoftware.ct.service.CMRLocalServiceUtil;
import it.bysoftware.ct.service.ClpSerializer;
import it.bysoftware.ct.service.persistence.CMRPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class CMRClp extends BaseModelImpl<CMR> implements CMR {
	public CMRClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CMR.class;
	}

	@Override
	public String getModelClassName() {
		return CMR.class.getName();
	}

	@Override
	public CMRPK getPrimaryKey() {
		return new CMRPK(_numeroCMR, _anno, _numeroDocumento, _idAssociato);
	}

	@Override
	public void setPrimaryKey(CMRPK primaryKey) {
		setNumeroCMR(primaryKey.numeroCMR);
		setAnno(primaryKey.anno);
		setNumeroDocumento(primaryKey.numeroDocumento);
		setIdAssociato(primaryKey.idAssociato);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new CMRPK(_numeroCMR, _anno, _numeroDocumento, _idAssociato);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((CMRPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("numeroCMR", getNumeroCMR());
		attributes.put("anno", getAnno());
		attributes.put("numeroDocumento", getNumeroDocumento());
		attributes.put("idAssociato", getIdAssociato());
		attributes.put("riserve", getRiserve());
		attributes.put("allegati", getAllegati());
		attributes.put("classe", getClasse());
		attributes.put("cifra", getCifra());
		attributes.put("lettera", getLettera());
		attributes.put("adr", getAdr());
		attributes.put("istruzioni", getIstruzioni());
		attributes.put("convenzioni", getConvenzioni());
		attributes.put("rimborso", getRimborso());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long numeroCMR = (Long)attributes.get("numeroCMR");

		if (numeroCMR != null) {
			setNumeroCMR(numeroCMR);
		}

		Integer anno = (Integer)attributes.get("anno");

		if (anno != null) {
			setAnno(anno);
		}

		Long numeroDocumento = (Long)attributes.get("numeroDocumento");

		if (numeroDocumento != null) {
			setNumeroDocumento(numeroDocumento);
		}

		Long idAssociato = (Long)attributes.get("idAssociato");

		if (idAssociato != null) {
			setIdAssociato(idAssociato);
		}

		String riserve = (String)attributes.get("riserve");

		if (riserve != null) {
			setRiserve(riserve);
		}

		String allegati = (String)attributes.get("allegati");

		if (allegati != null) {
			setAllegati(allegati);
		}

		String classe = (String)attributes.get("classe");

		if (classe != null) {
			setClasse(classe);
		}

		String cifra = (String)attributes.get("cifra");

		if (cifra != null) {
			setCifra(cifra);
		}

		String lettera = (String)attributes.get("lettera");

		if (lettera != null) {
			setLettera(lettera);
		}

		String adr = (String)attributes.get("adr");

		if (adr != null) {
			setAdr(adr);
		}

		String istruzioni = (String)attributes.get("istruzioni");

		if (istruzioni != null) {
			setIstruzioni(istruzioni);
		}

		String convenzioni = (String)attributes.get("convenzioni");

		if (convenzioni != null) {
			setConvenzioni(convenzioni);
		}

		String rimborso = (String)attributes.get("rimborso");

		if (rimborso != null) {
			setRimborso(rimborso);
		}
	}

	@Override
	public long getNumeroCMR() {
		return _numeroCMR;
	}

	@Override
	public void setNumeroCMR(long numeroCMR) {
		_numeroCMR = numeroCMR;

		if (_cmrRemoteModel != null) {
			try {
				Class<?> clazz = _cmrRemoteModel.getClass();

				Method method = clazz.getMethod("setNumeroCMR", long.class);

				method.invoke(_cmrRemoteModel, numeroCMR);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getAnno() {
		return _anno;
	}

	@Override
	public void setAnno(int anno) {
		_anno = anno;

		if (_cmrRemoteModel != null) {
			try {
				Class<?> clazz = _cmrRemoteModel.getClass();

				Method method = clazz.getMethod("setAnno", int.class);

				method.invoke(_cmrRemoteModel, anno);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNumeroDocumento() {
		return _numeroDocumento;
	}

	@Override
	public void setNumeroDocumento(long numeroDocumento) {
		_numeroDocumento = numeroDocumento;

		if (_cmrRemoteModel != null) {
			try {
				Class<?> clazz = _cmrRemoteModel.getClass();

				Method method = clazz.getMethod("setNumeroDocumento", long.class);

				method.invoke(_cmrRemoteModel, numeroDocumento);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIdAssociato() {
		return _idAssociato;
	}

	@Override
	public void setIdAssociato(long idAssociato) {
		_idAssociato = idAssociato;

		if (_cmrRemoteModel != null) {
			try {
				Class<?> clazz = _cmrRemoteModel.getClass();

				Method method = clazz.getMethod("setIdAssociato", long.class);

				method.invoke(_cmrRemoteModel, idAssociato);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRiserve() {
		return _riserve;
	}

	@Override
	public void setRiserve(String riserve) {
		_riserve = riserve;

		if (_cmrRemoteModel != null) {
			try {
				Class<?> clazz = _cmrRemoteModel.getClass();

				Method method = clazz.getMethod("setRiserve", String.class);

				method.invoke(_cmrRemoteModel, riserve);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAllegati() {
		return _allegati;
	}

	@Override
	public void setAllegati(String allegati) {
		_allegati = allegati;

		if (_cmrRemoteModel != null) {
			try {
				Class<?> clazz = _cmrRemoteModel.getClass();

				Method method = clazz.getMethod("setAllegati", String.class);

				method.invoke(_cmrRemoteModel, allegati);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getClasse() {
		return _classe;
	}

	@Override
	public void setClasse(String classe) {
		_classe = classe;

		if (_cmrRemoteModel != null) {
			try {
				Class<?> clazz = _cmrRemoteModel.getClass();

				Method method = clazz.getMethod("setClasse", String.class);

				method.invoke(_cmrRemoteModel, classe);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCifra() {
		return _cifra;
	}

	@Override
	public void setCifra(String cifra) {
		_cifra = cifra;

		if (_cmrRemoteModel != null) {
			try {
				Class<?> clazz = _cmrRemoteModel.getClass();

				Method method = clazz.getMethod("setCifra", String.class);

				method.invoke(_cmrRemoteModel, cifra);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLettera() {
		return _lettera;
	}

	@Override
	public void setLettera(String lettera) {
		_lettera = lettera;

		if (_cmrRemoteModel != null) {
			try {
				Class<?> clazz = _cmrRemoteModel.getClass();

				Method method = clazz.getMethod("setLettera", String.class);

				method.invoke(_cmrRemoteModel, lettera);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAdr() {
		return _adr;
	}

	@Override
	public void setAdr(String adr) {
		_adr = adr;

		if (_cmrRemoteModel != null) {
			try {
				Class<?> clazz = _cmrRemoteModel.getClass();

				Method method = clazz.getMethod("setAdr", String.class);

				method.invoke(_cmrRemoteModel, adr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIstruzioni() {
		return _istruzioni;
	}

	@Override
	public void setIstruzioni(String istruzioni) {
		_istruzioni = istruzioni;

		if (_cmrRemoteModel != null) {
			try {
				Class<?> clazz = _cmrRemoteModel.getClass();

				Method method = clazz.getMethod("setIstruzioni", String.class);

				method.invoke(_cmrRemoteModel, istruzioni);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getConvenzioni() {
		return _convenzioni;
	}

	@Override
	public void setConvenzioni(String convenzioni) {
		_convenzioni = convenzioni;

		if (_cmrRemoteModel != null) {
			try {
				Class<?> clazz = _cmrRemoteModel.getClass();

				Method method = clazz.getMethod("setConvenzioni", String.class);

				method.invoke(_cmrRemoteModel, convenzioni);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRimborso() {
		return _rimborso;
	}

	@Override
	public void setRimborso(String rimborso) {
		_rimborso = rimborso;

		if (_cmrRemoteModel != null) {
			try {
				Class<?> clazz = _cmrRemoteModel.getClass();

				Method method = clazz.getMethod("setRimborso", String.class);

				method.invoke(_cmrRemoteModel, rimborso);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCMRRemoteModel() {
		return _cmrRemoteModel;
	}

	public void setCMRRemoteModel(BaseModel<?> cmrRemoteModel) {
		_cmrRemoteModel = cmrRemoteModel;
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

		Class<?> remoteModelClass = _cmrRemoteModel.getClass();

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

		Object returnValue = method.invoke(_cmrRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CMRLocalServiceUtil.addCMR(this);
		}
		else {
			CMRLocalServiceUtil.updateCMR(this);
		}
	}

	@Override
	public CMR toEscapedModel() {
		return (CMR)ProxyUtil.newProxyInstance(CMR.class.getClassLoader(),
			new Class[] { CMR.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CMRClp clone = new CMRClp();

		clone.setNumeroCMR(getNumeroCMR());
		clone.setAnno(getAnno());
		clone.setNumeroDocumento(getNumeroDocumento());
		clone.setIdAssociato(getIdAssociato());
		clone.setRiserve(getRiserve());
		clone.setAllegati(getAllegati());
		clone.setClasse(getClasse());
		clone.setCifra(getCifra());
		clone.setLettera(getLettera());
		clone.setAdr(getAdr());
		clone.setIstruzioni(getIstruzioni());
		clone.setConvenzioni(getConvenzioni());
		clone.setRimborso(getRimborso());

		return clone;
	}

	@Override
	public int compareTo(CMR cmr) {
		int value = 0;

		if (getNumeroCMR() < cmr.getNumeroCMR()) {
			value = -1;
		}
		else if (getNumeroCMR() > cmr.getNumeroCMR()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CMRClp)) {
			return false;
		}

		CMRClp cmr = (CMRClp)obj;

		CMRPK primaryKey = cmr.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{numeroCMR=");
		sb.append(getNumeroCMR());
		sb.append(", anno=");
		sb.append(getAnno());
		sb.append(", numeroDocumento=");
		sb.append(getNumeroDocumento());
		sb.append(", idAssociato=");
		sb.append(getIdAssociato());
		sb.append(", riserve=");
		sb.append(getRiserve());
		sb.append(", allegati=");
		sb.append(getAllegati());
		sb.append(", classe=");
		sb.append(getClasse());
		sb.append(", cifra=");
		sb.append(getCifra());
		sb.append(", lettera=");
		sb.append(getLettera());
		sb.append(", adr=");
		sb.append(getAdr());
		sb.append(", istruzioni=");
		sb.append(getIstruzioni());
		sb.append(", convenzioni=");
		sb.append(getConvenzioni());
		sb.append(", rimborso=");
		sb.append(getRimborso());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("it.bysoftware.ct.model.CMR");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>numeroCMR</column-name><column-value><![CDATA[");
		sb.append(getNumeroCMR());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>anno</column-name><column-value><![CDATA[");
		sb.append(getAnno());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numeroDocumento</column-name><column-value><![CDATA[");
		sb.append(getNumeroDocumento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idAssociato</column-name><column-value><![CDATA[");
		sb.append(getIdAssociato());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>riserve</column-name><column-value><![CDATA[");
		sb.append(getRiserve());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>allegati</column-name><column-value><![CDATA[");
		sb.append(getAllegati());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classe</column-name><column-value><![CDATA[");
		sb.append(getClasse());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cifra</column-name><column-value><![CDATA[");
		sb.append(getCifra());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lettera</column-name><column-value><![CDATA[");
		sb.append(getLettera());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>adr</column-name><column-value><![CDATA[");
		sb.append(getAdr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>istruzioni</column-name><column-value><![CDATA[");
		sb.append(getIstruzioni());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>convenzioni</column-name><column-value><![CDATA[");
		sb.append(getConvenzioni());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rimborso</column-name><column-value><![CDATA[");
		sb.append(getRimborso());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _numeroCMR;
	private int _anno;
	private long _numeroDocumento;
	private long _idAssociato;
	private String _riserve;
	private String _allegati;
	private String _classe;
	private String _cifra;
	private String _lettera;
	private String _adr;
	private String _istruzioni;
	private String _convenzioni;
	private String _rimborso;
	private BaseModel<?> _cmrRemoteModel;
	private Class<?> _clpSerializerClass = it.bysoftware.ct.service.ClpSerializer.class;
}
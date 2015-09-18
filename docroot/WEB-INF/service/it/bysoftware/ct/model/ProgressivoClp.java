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
import it.bysoftware.ct.service.ProgressivoLocalServiceUtil;
import it.bysoftware.ct.service.persistence.ProgressivoPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class ProgressivoClp extends BaseModelImpl<Progressivo>
	implements Progressivo {
	public ProgressivoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Progressivo.class;
	}

	@Override
	public String getModelClassName() {
		return Progressivo.class.getName();
	}

	@Override
	public ProgressivoPK getPrimaryKey() {
		return new ProgressivoPK(_anno, _idAssociato, _tipoDocumento,
			_numeroProgressivo);
	}

	@Override
	public void setPrimaryKey(ProgressivoPK primaryKey) {
		setAnno(primaryKey.anno);
		setIdAssociato(primaryKey.idAssociato);
		setTipoDocumento(primaryKey.tipoDocumento);
		setNumeroProgressivo(primaryKey.numeroProgressivo);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ProgressivoPK(_anno, _idAssociato, _tipoDocumento,
			_numeroProgressivo);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ProgressivoPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("anno", getAnno());
		attributes.put("idAssociato", getIdAssociato());
		attributes.put("codiceCentro", getCodiceCentro());
		attributes.put("codiceDeposito", getCodiceDeposito());
		attributes.put("dataRegistrazione", getDataRegistrazione());
		attributes.put("numeroBolla", getNumeroBolla());
		attributes.put("tipoDocumento", getTipoDocumento());
		attributes.put("numeroProgressivo", getNumeroProgressivo());
		attributes.put("tipoCon", getTipoCon());
		attributes.put("codiceAzienda", getCodiceAzienda());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer anno = (Integer)attributes.get("anno");

		if (anno != null) {
			setAnno(anno);
		}

		Long idAssociato = (Long)attributes.get("idAssociato");

		if (idAssociato != null) {
			setIdAssociato(idAssociato);
		}

		String codiceCentro = (String)attributes.get("codiceCentro");

		if (codiceCentro != null) {
			setCodiceCentro(codiceCentro);
		}

		String codiceDeposito = (String)attributes.get("codiceDeposito");

		if (codiceDeposito != null) {
			setCodiceDeposito(codiceDeposito);
		}

		String dataRegistrazione = (String)attributes.get("dataRegistrazione");

		if (dataRegistrazione != null) {
			setDataRegistrazione(dataRegistrazione);
		}

		Long numeroBolla = (Long)attributes.get("numeroBolla");

		if (numeroBolla != null) {
			setNumeroBolla(numeroBolla);
		}

		Integer tipoDocumento = (Integer)attributes.get("tipoDocumento");

		if (tipoDocumento != null) {
			setTipoDocumento(tipoDocumento);
		}

		Integer numeroProgressivo = (Integer)attributes.get("numeroProgressivo");

		if (numeroProgressivo != null) {
			setNumeroProgressivo(numeroProgressivo);
		}

		Integer tipoCon = (Integer)attributes.get("tipoCon");

		if (tipoCon != null) {
			setTipoCon(tipoCon);
		}

		String codiceAzienda = (String)attributes.get("codiceAzienda");

		if (codiceAzienda != null) {
			setCodiceAzienda(codiceAzienda);
		}
	}

	@Override
	public int getAnno() {
		return _anno;
	}

	@Override
	public void setAnno(int anno) {
		_anno = anno;

		if (_progressivoRemoteModel != null) {
			try {
				Class<?> clazz = _progressivoRemoteModel.getClass();

				Method method = clazz.getMethod("setAnno", int.class);

				method.invoke(_progressivoRemoteModel, anno);
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

		if (_progressivoRemoteModel != null) {
			try {
				Class<?> clazz = _progressivoRemoteModel.getClass();

				Method method = clazz.getMethod("setIdAssociato", long.class);

				method.invoke(_progressivoRemoteModel, idAssociato);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodiceCentro() {
		return _codiceCentro;
	}

	@Override
	public void setCodiceCentro(String codiceCentro) {
		_codiceCentro = codiceCentro;

		if (_progressivoRemoteModel != null) {
			try {
				Class<?> clazz = _progressivoRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceCentro", String.class);

				method.invoke(_progressivoRemoteModel, codiceCentro);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodiceDeposito() {
		return _codiceDeposito;
	}

	@Override
	public void setCodiceDeposito(String codiceDeposito) {
		_codiceDeposito = codiceDeposito;

		if (_progressivoRemoteModel != null) {
			try {
				Class<?> clazz = _progressivoRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceDeposito",
						String.class);

				method.invoke(_progressivoRemoteModel, codiceDeposito);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDataRegistrazione() {
		return _dataRegistrazione;
	}

	@Override
	public void setDataRegistrazione(String dataRegistrazione) {
		_dataRegistrazione = dataRegistrazione;

		if (_progressivoRemoteModel != null) {
			try {
				Class<?> clazz = _progressivoRemoteModel.getClass();

				Method method = clazz.getMethod("setDataRegistrazione",
						String.class);

				method.invoke(_progressivoRemoteModel, dataRegistrazione);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNumeroBolla() {
		return _numeroBolla;
	}

	@Override
	public void setNumeroBolla(long numeroBolla) {
		_numeroBolla = numeroBolla;

		if (_progressivoRemoteModel != null) {
			try {
				Class<?> clazz = _progressivoRemoteModel.getClass();

				Method method = clazz.getMethod("setNumeroBolla", long.class);

				method.invoke(_progressivoRemoteModel, numeroBolla);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getTipoDocumento() {
		return _tipoDocumento;
	}

	@Override
	public void setTipoDocumento(int tipoDocumento) {
		_tipoDocumento = tipoDocumento;

		if (_progressivoRemoteModel != null) {
			try {
				Class<?> clazz = _progressivoRemoteModel.getClass();

				Method method = clazz.getMethod("setTipoDocumento", int.class);

				method.invoke(_progressivoRemoteModel, tipoDocumento);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getNumeroProgressivo() {
		return _numeroProgressivo;
	}

	@Override
	public void setNumeroProgressivo(int numeroProgressivo) {
		_numeroProgressivo = numeroProgressivo;

		if (_progressivoRemoteModel != null) {
			try {
				Class<?> clazz = _progressivoRemoteModel.getClass();

				Method method = clazz.getMethod("setNumeroProgressivo",
						int.class);

				method.invoke(_progressivoRemoteModel, numeroProgressivo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getTipoCon() {
		return _tipoCon;
	}

	@Override
	public void setTipoCon(int tipoCon) {
		_tipoCon = tipoCon;

		if (_progressivoRemoteModel != null) {
			try {
				Class<?> clazz = _progressivoRemoteModel.getClass();

				Method method = clazz.getMethod("setTipoCon", int.class);

				method.invoke(_progressivoRemoteModel, tipoCon);
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

		if (_progressivoRemoteModel != null) {
			try {
				Class<?> clazz = _progressivoRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceAzienda", String.class);

				method.invoke(_progressivoRemoteModel, codiceAzienda);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getProgressivoRemoteModel() {
		return _progressivoRemoteModel;
	}

	public void setProgressivoRemoteModel(BaseModel<?> progressivoRemoteModel) {
		_progressivoRemoteModel = progressivoRemoteModel;
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

		Class<?> remoteModelClass = _progressivoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_progressivoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ProgressivoLocalServiceUtil.addProgressivo(this);
		}
		else {
			ProgressivoLocalServiceUtil.updateProgressivo(this);
		}
	}

	@Override
	public Progressivo toEscapedModel() {
		return (Progressivo)ProxyUtil.newProxyInstance(Progressivo.class.getClassLoader(),
			new Class[] { Progressivo.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ProgressivoClp clone = new ProgressivoClp();

		clone.setAnno(getAnno());
		clone.setIdAssociato(getIdAssociato());
		clone.setCodiceCentro(getCodiceCentro());
		clone.setCodiceDeposito(getCodiceDeposito());
		clone.setDataRegistrazione(getDataRegistrazione());
		clone.setNumeroBolla(getNumeroBolla());
		clone.setTipoDocumento(getTipoDocumento());
		clone.setNumeroProgressivo(getNumeroProgressivo());
		clone.setTipoCon(getTipoCon());
		clone.setCodiceAzienda(getCodiceAzienda());

		return clone;
	}

	@Override
	public int compareTo(Progressivo progressivo) {
		ProgressivoPK primaryKey = progressivo.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProgressivoClp)) {
			return false;
		}

		ProgressivoClp progressivo = (ProgressivoClp)obj;

		ProgressivoPK primaryKey = progressivo.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{anno=");
		sb.append(getAnno());
		sb.append(", idAssociato=");
		sb.append(getIdAssociato());
		sb.append(", codiceCentro=");
		sb.append(getCodiceCentro());
		sb.append(", codiceDeposito=");
		sb.append(getCodiceDeposito());
		sb.append(", dataRegistrazione=");
		sb.append(getDataRegistrazione());
		sb.append(", numeroBolla=");
		sb.append(getNumeroBolla());
		sb.append(", tipoDocumento=");
		sb.append(getTipoDocumento());
		sb.append(", numeroProgressivo=");
		sb.append(getNumeroProgressivo());
		sb.append(", tipoCon=");
		sb.append(getTipoCon());
		sb.append(", codiceAzienda=");
		sb.append(getCodiceAzienda());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("it.bysoftware.ct.model.Progressivo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>anno</column-name><column-value><![CDATA[");
		sb.append(getAnno());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idAssociato</column-name><column-value><![CDATA[");
		sb.append(getIdAssociato());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceCentro</column-name><column-value><![CDATA[");
		sb.append(getCodiceCentro());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceDeposito</column-name><column-value><![CDATA[");
		sb.append(getCodiceDeposito());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dataRegistrazione</column-name><column-value><![CDATA[");
		sb.append(getDataRegistrazione());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numeroBolla</column-name><column-value><![CDATA[");
		sb.append(getNumeroBolla());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipoDocumento</column-name><column-value><![CDATA[");
		sb.append(getTipoDocumento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numeroProgressivo</column-name><column-value><![CDATA[");
		sb.append(getNumeroProgressivo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipoCon</column-name><column-value><![CDATA[");
		sb.append(getTipoCon());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceAzienda</column-name><column-value><![CDATA[");
		sb.append(getCodiceAzienda());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _anno;
	private long _idAssociato;
	private String _codiceCentro;
	private String _codiceDeposito;
	private String _dataRegistrazione;
	private long _numeroBolla;
	private int _tipoDocumento;
	private int _numeroProgressivo;
	private int _tipoCon;
	private String _codiceAzienda;
	private BaseModel<?> _progressivoRemoteModel;
	private Class<?> _clpSerializerClass = it.bysoftware.ct.service.ClpSerializer.class;
}
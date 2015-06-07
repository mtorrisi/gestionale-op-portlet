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

import it.bysoftware.ct.service.ArticoliLocalServiceUtil;
import it.bysoftware.ct.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class ArticoliClp extends BaseModelImpl<Articoli> implements Articoli {
	public ArticoliClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Articoli.class;
	}

	@Override
	public String getModelClassName() {
		return Articoli.class.getName();
	}

	@Override
	public String getPrimaryKey() {
		return _codiceArticolo;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setCodiceArticolo(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _codiceArticolo;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("codiceArticolo", getCodiceArticolo());
		attributes.put("categoriaMerceologica", getCategoriaMerceologica());
		attributes.put("descrizione", getDescrizione());
		attributes.put("descrizioneDocumento", getDescrizioneDocumento());
		attributes.put("descrizioneFiscale", getDescrizioneFiscale());
		attributes.put("tara", getTara());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String codiceArticolo = (String)attributes.get("codiceArticolo");

		if (codiceArticolo != null) {
			setCodiceArticolo(codiceArticolo);
		}

		String categoriaMerceologica = (String)attributes.get(
				"categoriaMerceologica");

		if (categoriaMerceologica != null) {
			setCategoriaMerceologica(categoriaMerceologica);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}

		String descrizioneDocumento = (String)attributes.get(
				"descrizioneDocumento");

		if (descrizioneDocumento != null) {
			setDescrizioneDocumento(descrizioneDocumento);
		}

		String descrizioneFiscale = (String)attributes.get("descrizioneFiscale");

		if (descrizioneFiscale != null) {
			setDescrizioneFiscale(descrizioneFiscale);
		}

		Double tara = (Double)attributes.get("tara");

		if (tara != null) {
			setTara(tara);
		}
	}

	@Override
	public String getCodiceArticolo() {
		return _codiceArticolo;
	}

	@Override
	public void setCodiceArticolo(String codiceArticolo) {
		_codiceArticolo = codiceArticolo;

		if (_articoliRemoteModel != null) {
			try {
				Class<?> clazz = _articoliRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceArticolo",
						String.class);

				method.invoke(_articoliRemoteModel, codiceArticolo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCategoriaMerceologica() {
		return _categoriaMerceologica;
	}

	@Override
	public void setCategoriaMerceologica(String categoriaMerceologica) {
		_categoriaMerceologica = categoriaMerceologica;

		if (_articoliRemoteModel != null) {
			try {
				Class<?> clazz = _articoliRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoriaMerceologica",
						String.class);

				method.invoke(_articoliRemoteModel, categoriaMerceologica);
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

		if (_articoliRemoteModel != null) {
			try {
				Class<?> clazz = _articoliRemoteModel.getClass();

				Method method = clazz.getMethod("setDescrizione", String.class);

				method.invoke(_articoliRemoteModel, descrizione);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescrizioneDocumento() {
		return _descrizioneDocumento;
	}

	@Override
	public void setDescrizioneDocumento(String descrizioneDocumento) {
		_descrizioneDocumento = descrizioneDocumento;

		if (_articoliRemoteModel != null) {
			try {
				Class<?> clazz = _articoliRemoteModel.getClass();

				Method method = clazz.getMethod("setDescrizioneDocumento",
						String.class);

				method.invoke(_articoliRemoteModel, descrizioneDocumento);
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

		if (_articoliRemoteModel != null) {
			try {
				Class<?> clazz = _articoliRemoteModel.getClass();

				Method method = clazz.getMethod("setDescrizioneFiscale",
						String.class);

				method.invoke(_articoliRemoteModel, descrizioneFiscale);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getTara() {
		return _tara;
	}

	@Override
	public void setTara(double tara) {
		_tara = tara;

		if (_articoliRemoteModel != null) {
			try {
				Class<?> clazz = _articoliRemoteModel.getClass();

				Method method = clazz.getMethod("setTara", double.class);

				method.invoke(_articoliRemoteModel, tara);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getArticoliRemoteModel() {
		return _articoliRemoteModel;
	}

	public void setArticoliRemoteModel(BaseModel<?> articoliRemoteModel) {
		_articoliRemoteModel = articoliRemoteModel;
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

		Class<?> remoteModelClass = _articoliRemoteModel.getClass();

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

		Object returnValue = method.invoke(_articoliRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ArticoliLocalServiceUtil.addArticoli(this);
		}
		else {
			ArticoliLocalServiceUtil.updateArticoli(this);
		}
	}

	@Override
	public Articoli toEscapedModel() {
		return (Articoli)ProxyUtil.newProxyInstance(Articoli.class.getClassLoader(),
			new Class[] { Articoli.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ArticoliClp clone = new ArticoliClp();

		clone.setCodiceArticolo(getCodiceArticolo());
		clone.setCategoriaMerceologica(getCategoriaMerceologica());
		clone.setDescrizione(getDescrizione());
		clone.setDescrizioneDocumento(getDescrizioneDocumento());
		clone.setDescrizioneFiscale(getDescrizioneFiscale());
		clone.setTara(getTara());

		return clone;
	}

	@Override
	public int compareTo(Articoli articoli) {
		String primaryKey = articoli.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ArticoliClp)) {
			return false;
		}

		ArticoliClp articoli = (ArticoliClp)obj;

		String primaryKey = articoli.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{codiceArticolo=");
		sb.append(getCodiceArticolo());
		sb.append(", categoriaMerceologica=");
		sb.append(getCategoriaMerceologica());
		sb.append(", descrizione=");
		sb.append(getDescrizione());
		sb.append(", descrizioneDocumento=");
		sb.append(getDescrizioneDocumento());
		sb.append(", descrizioneFiscale=");
		sb.append(getDescrizioneFiscale());
		sb.append(", tara=");
		sb.append(getTara());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("it.bysoftware.ct.model.Articoli");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>codiceArticolo</column-name><column-value><![CDATA[");
		sb.append(getCodiceArticolo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoriaMerceologica</column-name><column-value><![CDATA[");
		sb.append(getCategoriaMerceologica());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descrizione</column-name><column-value><![CDATA[");
		sb.append(getDescrizione());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descrizioneDocumento</column-name><column-value><![CDATA[");
		sb.append(getDescrizioneDocumento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descrizioneFiscale</column-name><column-value><![CDATA[");
		sb.append(getDescrizioneFiscale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tara</column-name><column-value><![CDATA[");
		sb.append(getTara());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _codiceArticolo;
	private String _categoriaMerceologica;
	private String _descrizione;
	private String _descrizioneDocumento;
	private String _descrizioneFiscale;
	private double _tara;
	private BaseModel<?> _articoliRemoteModel;
	private Class<?> _clpSerializerClass = it.bysoftware.ct.service.ClpSerializer.class;
}
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
import it.bysoftware.ct.service.TracciabilitaGrezziLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class TracciabilitaGrezziClp extends BaseModelImpl<TracciabilitaGrezzi>
	implements TracciabilitaGrezzi {
	public TracciabilitaGrezziClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return TracciabilitaGrezzi.class;
	}

	@Override
	public String getModelClassName() {
		return TracciabilitaGrezzi.class.getName();
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
		attributes.put("lottoGrezzo", getLottoGrezzo());
		attributes.put("prodotto", getProdotto());
		attributes.put("kg", getKg());
		attributes.put("produttore", getProduttore());
		attributes.put("foglio", getFoglio());
		attributes.put("particella", getParticella());
		attributes.put("note", getNote());
		attributes.put("numeroColli", getNumeroColli());
		attributes.put("kgScarto", getKgScarto());
		attributes.put("idSchedaTracciabilta", getIdSchedaTracciabilta());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String lottoGrezzo = (String)attributes.get("lottoGrezzo");

		if (lottoGrezzo != null) {
			setLottoGrezzo(lottoGrezzo);
		}

		String prodotto = (String)attributes.get("prodotto");

		if (prodotto != null) {
			setProdotto(prodotto);
		}

		Double kg = (Double)attributes.get("kg");

		if (kg != null) {
			setKg(kg);
		}

		String produttore = (String)attributes.get("produttore");

		if (produttore != null) {
			setProduttore(produttore);
		}

		Integer foglio = (Integer)attributes.get("foglio");

		if (foglio != null) {
			setFoglio(foglio);
		}

		Integer particella = (Integer)attributes.get("particella");

		if (particella != null) {
			setParticella(particella);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		Integer numeroColli = (Integer)attributes.get("numeroColli");

		if (numeroColli != null) {
			setNumeroColli(numeroColli);
		}

		Double kgScarto = (Double)attributes.get("kgScarto");

		if (kgScarto != null) {
			setKgScarto(kgScarto);
		}

		Long idSchedaTracciabilta = (Long)attributes.get("idSchedaTracciabilta");

		if (idSchedaTracciabilta != null) {
			setIdSchedaTracciabilta(idSchedaTracciabilta);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_tracciabilitaGrezziRemoteModel != null) {
			try {
				Class<?> clazz = _tracciabilitaGrezziRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_tracciabilitaGrezziRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLottoGrezzo() {
		return _lottoGrezzo;
	}

	@Override
	public void setLottoGrezzo(String lottoGrezzo) {
		_lottoGrezzo = lottoGrezzo;

		if (_tracciabilitaGrezziRemoteModel != null) {
			try {
				Class<?> clazz = _tracciabilitaGrezziRemoteModel.getClass();

				Method method = clazz.getMethod("setLottoGrezzo", String.class);

				method.invoke(_tracciabilitaGrezziRemoteModel, lottoGrezzo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProdotto() {
		return _prodotto;
	}

	@Override
	public void setProdotto(String prodotto) {
		_prodotto = prodotto;

		if (_tracciabilitaGrezziRemoteModel != null) {
			try {
				Class<?> clazz = _tracciabilitaGrezziRemoteModel.getClass();

				Method method = clazz.getMethod("setProdotto", String.class);

				method.invoke(_tracciabilitaGrezziRemoteModel, prodotto);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getKg() {
		return _kg;
	}

	@Override
	public void setKg(double kg) {
		_kg = kg;

		if (_tracciabilitaGrezziRemoteModel != null) {
			try {
				Class<?> clazz = _tracciabilitaGrezziRemoteModel.getClass();

				Method method = clazz.getMethod("setKg", double.class);

				method.invoke(_tracciabilitaGrezziRemoteModel, kg);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProduttore() {
		return _produttore;
	}

	@Override
	public void setProduttore(String produttore) {
		_produttore = produttore;

		if (_tracciabilitaGrezziRemoteModel != null) {
			try {
				Class<?> clazz = _tracciabilitaGrezziRemoteModel.getClass();

				Method method = clazz.getMethod("setProduttore", String.class);

				method.invoke(_tracciabilitaGrezziRemoteModel, produttore);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getFoglio() {
		return _foglio;
	}

	@Override
	public void setFoglio(int foglio) {
		_foglio = foglio;

		if (_tracciabilitaGrezziRemoteModel != null) {
			try {
				Class<?> clazz = _tracciabilitaGrezziRemoteModel.getClass();

				Method method = clazz.getMethod("setFoglio", int.class);

				method.invoke(_tracciabilitaGrezziRemoteModel, foglio);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getParticella() {
		return _particella;
	}

	@Override
	public void setParticella(int particella) {
		_particella = particella;

		if (_tracciabilitaGrezziRemoteModel != null) {
			try {
				Class<?> clazz = _tracciabilitaGrezziRemoteModel.getClass();

				Method method = clazz.getMethod("setParticella", int.class);

				method.invoke(_tracciabilitaGrezziRemoteModel, particella);
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

		if (_tracciabilitaGrezziRemoteModel != null) {
			try {
				Class<?> clazz = _tracciabilitaGrezziRemoteModel.getClass();

				Method method = clazz.getMethod("setNote", String.class);

				method.invoke(_tracciabilitaGrezziRemoteModel, note);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getNumeroColli() {
		return _numeroColli;
	}

	@Override
	public void setNumeroColli(int numeroColli) {
		_numeroColli = numeroColli;

		if (_tracciabilitaGrezziRemoteModel != null) {
			try {
				Class<?> clazz = _tracciabilitaGrezziRemoteModel.getClass();

				Method method = clazz.getMethod("setNumeroColli", int.class);

				method.invoke(_tracciabilitaGrezziRemoteModel, numeroColli);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getKgScarto() {
		return _kgScarto;
	}

	@Override
	public void setKgScarto(double kgScarto) {
		_kgScarto = kgScarto;

		if (_tracciabilitaGrezziRemoteModel != null) {
			try {
				Class<?> clazz = _tracciabilitaGrezziRemoteModel.getClass();

				Method method = clazz.getMethod("setKgScarto", double.class);

				method.invoke(_tracciabilitaGrezziRemoteModel, kgScarto);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIdSchedaTracciabilta() {
		return _idSchedaTracciabilta;
	}

	@Override
	public void setIdSchedaTracciabilta(long idSchedaTracciabilta) {
		_idSchedaTracciabilta = idSchedaTracciabilta;

		if (_tracciabilitaGrezziRemoteModel != null) {
			try {
				Class<?> clazz = _tracciabilitaGrezziRemoteModel.getClass();

				Method method = clazz.getMethod("setIdSchedaTracciabilta",
						long.class);

				method.invoke(_tracciabilitaGrezziRemoteModel,
					idSchedaTracciabilta);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTracciabilitaGrezziRemoteModel() {
		return _tracciabilitaGrezziRemoteModel;
	}

	public void setTracciabilitaGrezziRemoteModel(
		BaseModel<?> tracciabilitaGrezziRemoteModel) {
		_tracciabilitaGrezziRemoteModel = tracciabilitaGrezziRemoteModel;
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

		Class<?> remoteModelClass = _tracciabilitaGrezziRemoteModel.getClass();

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

		Object returnValue = method.invoke(_tracciabilitaGrezziRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TracciabilitaGrezziLocalServiceUtil.addTracciabilitaGrezzi(this);
		}
		else {
			TracciabilitaGrezziLocalServiceUtil.updateTracciabilitaGrezzi(this);
		}
	}

	@Override
	public TracciabilitaGrezzi toEscapedModel() {
		return (TracciabilitaGrezzi)ProxyUtil.newProxyInstance(TracciabilitaGrezzi.class.getClassLoader(),
			new Class[] { TracciabilitaGrezzi.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TracciabilitaGrezziClp clone = new TracciabilitaGrezziClp();

		clone.setId(getId());
		clone.setLottoGrezzo(getLottoGrezzo());
		clone.setProdotto(getProdotto());
		clone.setKg(getKg());
		clone.setProduttore(getProduttore());
		clone.setFoglio(getFoglio());
		clone.setParticella(getParticella());
		clone.setNote(getNote());
		clone.setNumeroColli(getNumeroColli());
		clone.setKgScarto(getKgScarto());
		clone.setIdSchedaTracciabilta(getIdSchedaTracciabilta());

		return clone;
	}

	@Override
	public int compareTo(TracciabilitaGrezzi tracciabilitaGrezzi) {
		long primaryKey = tracciabilitaGrezzi.getPrimaryKey();

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

		if (!(obj instanceof TracciabilitaGrezziClp)) {
			return false;
		}

		TracciabilitaGrezziClp tracciabilitaGrezzi = (TracciabilitaGrezziClp)obj;

		long primaryKey = tracciabilitaGrezzi.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", lottoGrezzo=");
		sb.append(getLottoGrezzo());
		sb.append(", prodotto=");
		sb.append(getProdotto());
		sb.append(", kg=");
		sb.append(getKg());
		sb.append(", produttore=");
		sb.append(getProduttore());
		sb.append(", foglio=");
		sb.append(getFoglio());
		sb.append(", particella=");
		sb.append(getParticella());
		sb.append(", note=");
		sb.append(getNote());
		sb.append(", numeroColli=");
		sb.append(getNumeroColli());
		sb.append(", kgScarto=");
		sb.append(getKgScarto());
		sb.append(", idSchedaTracciabilta=");
		sb.append(getIdSchedaTracciabilta());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("it.bysoftware.ct.model.TracciabilitaGrezzi");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lottoGrezzo</column-name><column-value><![CDATA[");
		sb.append(getLottoGrezzo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>prodotto</column-name><column-value><![CDATA[");
		sb.append(getProdotto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kg</column-name><column-value><![CDATA[");
		sb.append(getKg());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>produttore</column-name><column-value><![CDATA[");
		sb.append(getProduttore());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>foglio</column-name><column-value><![CDATA[");
		sb.append(getFoglio());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>particella</column-name><column-value><![CDATA[");
		sb.append(getParticella());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>note</column-name><column-value><![CDATA[");
		sb.append(getNote());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numeroColli</column-name><column-value><![CDATA[");
		sb.append(getNumeroColli());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kgScarto</column-name><column-value><![CDATA[");
		sb.append(getKgScarto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idSchedaTracciabilta</column-name><column-value><![CDATA[");
		sb.append(getIdSchedaTracciabilta());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _lottoGrezzo;
	private String _prodotto;
	private double _kg;
	private String _produttore;
	private int _foglio;
	private int _particella;
	private String _note;
	private int _numeroColli;
	private double _kgScarto;
	private long _idSchedaTracciabilta;
	private BaseModel<?> _tracciabilitaGrezziRemoteModel;
	private Class<?> _clpSerializerClass = it.bysoftware.ct.service.ClpSerializer.class;
}
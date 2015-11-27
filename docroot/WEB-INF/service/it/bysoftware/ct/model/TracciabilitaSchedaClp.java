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
import it.bysoftware.ct.service.TracciabilitaSchedaLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class TracciabilitaSchedaClp extends BaseModelImpl<TracciabilitaScheda>
	implements TracciabilitaScheda {
	public TracciabilitaSchedaClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return TracciabilitaScheda.class;
	}

	@Override
	public String getModelClassName() {
		return TracciabilitaScheda.class.getName();
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
		attributes.put("codiceProdotto", getCodiceProdotto());
		attributes.put("prodottoVenduto", getProdottoVenduto());
		attributes.put("kgVenduti", getKgVenduti());
		attributes.put("lottoVendita", getLottoVendita());
		attributes.put("anno", getAnno());
		attributes.put("numeroDocumento", getNumeroDocumento());
		attributes.put("rigoOrdine", getRigoOrdine());
		attributes.put("tipoDocumento", getTipoDocumento());
		attributes.put("idAssociato", getIdAssociato());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String codiceProdotto = (String)attributes.get("codiceProdotto");

		if (codiceProdotto != null) {
			setCodiceProdotto(codiceProdotto);
		}

		String prodottoVenduto = (String)attributes.get("prodottoVenduto");

		if (prodottoVenduto != null) {
			setProdottoVenduto(prodottoVenduto);
		}

		Double kgVenduti = (Double)attributes.get("kgVenduti");

		if (kgVenduti != null) {
			setKgVenduti(kgVenduti);
		}

		String lottoVendita = (String)attributes.get("lottoVendita");

		if (lottoVendita != null) {
			setLottoVendita(lottoVendita);
		}

		Integer anno = (Integer)attributes.get("anno");

		if (anno != null) {
			setAnno(anno);
		}

		Long numeroDocumento = (Long)attributes.get("numeroDocumento");

		if (numeroDocumento != null) {
			setNumeroDocumento(numeroDocumento);
		}

		Integer rigoOrdine = (Integer)attributes.get("rigoOrdine");

		if (rigoOrdine != null) {
			setRigoOrdine(rigoOrdine);
		}

		String tipoDocumento = (String)attributes.get("tipoDocumento");

		if (tipoDocumento != null) {
			setTipoDocumento(tipoDocumento);
		}

		Long idAssociato = (Long)attributes.get("idAssociato");

		if (idAssociato != null) {
			setIdAssociato(idAssociato);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_tracciabilitaSchedaRemoteModel != null) {
			try {
				Class<?> clazz = _tracciabilitaSchedaRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_tracciabilitaSchedaRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodiceProdotto() {
		return _codiceProdotto;
	}

	@Override
	public void setCodiceProdotto(String codiceProdotto) {
		_codiceProdotto = codiceProdotto;

		if (_tracciabilitaSchedaRemoteModel != null) {
			try {
				Class<?> clazz = _tracciabilitaSchedaRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceProdotto",
						String.class);

				method.invoke(_tracciabilitaSchedaRemoteModel, codiceProdotto);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProdottoVenduto() {
		return _prodottoVenduto;
	}

	@Override
	public void setProdottoVenduto(String prodottoVenduto) {
		_prodottoVenduto = prodottoVenduto;

		if (_tracciabilitaSchedaRemoteModel != null) {
			try {
				Class<?> clazz = _tracciabilitaSchedaRemoteModel.getClass();

				Method method = clazz.getMethod("setProdottoVenduto",
						String.class);

				method.invoke(_tracciabilitaSchedaRemoteModel, prodottoVenduto);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getKgVenduti() {
		return _kgVenduti;
	}

	@Override
	public void setKgVenduti(double kgVenduti) {
		_kgVenduti = kgVenduti;

		if (_tracciabilitaSchedaRemoteModel != null) {
			try {
				Class<?> clazz = _tracciabilitaSchedaRemoteModel.getClass();

				Method method = clazz.getMethod("setKgVenduti", double.class);

				method.invoke(_tracciabilitaSchedaRemoteModel, kgVenduti);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLottoVendita() {
		return _lottoVendita;
	}

	@Override
	public void setLottoVendita(String lottoVendita) {
		_lottoVendita = lottoVendita;

		if (_tracciabilitaSchedaRemoteModel != null) {
			try {
				Class<?> clazz = _tracciabilitaSchedaRemoteModel.getClass();

				Method method = clazz.getMethod("setLottoVendita", String.class);

				method.invoke(_tracciabilitaSchedaRemoteModel, lottoVendita);
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

		if (_tracciabilitaSchedaRemoteModel != null) {
			try {
				Class<?> clazz = _tracciabilitaSchedaRemoteModel.getClass();

				Method method = clazz.getMethod("setAnno", int.class);

				method.invoke(_tracciabilitaSchedaRemoteModel, anno);
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

		if (_tracciabilitaSchedaRemoteModel != null) {
			try {
				Class<?> clazz = _tracciabilitaSchedaRemoteModel.getClass();

				Method method = clazz.getMethod("setNumeroDocumento", long.class);

				method.invoke(_tracciabilitaSchedaRemoteModel, numeroDocumento);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getRigoOrdine() {
		return _rigoOrdine;
	}

	@Override
	public void setRigoOrdine(int rigoOrdine) {
		_rigoOrdine = rigoOrdine;

		if (_tracciabilitaSchedaRemoteModel != null) {
			try {
				Class<?> clazz = _tracciabilitaSchedaRemoteModel.getClass();

				Method method = clazz.getMethod("setRigoOrdine", int.class);

				method.invoke(_tracciabilitaSchedaRemoteModel, rigoOrdine);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTipoDocumento() {
		return _tipoDocumento;
	}

	@Override
	public void setTipoDocumento(String tipoDocumento) {
		_tipoDocumento = tipoDocumento;

		if (_tracciabilitaSchedaRemoteModel != null) {
			try {
				Class<?> clazz = _tracciabilitaSchedaRemoteModel.getClass();

				Method method = clazz.getMethod("setTipoDocumento", String.class);

				method.invoke(_tracciabilitaSchedaRemoteModel, tipoDocumento);
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

		if (_tracciabilitaSchedaRemoteModel != null) {
			try {
				Class<?> clazz = _tracciabilitaSchedaRemoteModel.getClass();

				Method method = clazz.getMethod("setIdAssociato", long.class);

				method.invoke(_tracciabilitaSchedaRemoteModel, idAssociato);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTracciabilitaSchedaRemoteModel() {
		return _tracciabilitaSchedaRemoteModel;
	}

	public void setTracciabilitaSchedaRemoteModel(
		BaseModel<?> tracciabilitaSchedaRemoteModel) {
		_tracciabilitaSchedaRemoteModel = tracciabilitaSchedaRemoteModel;
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

		Class<?> remoteModelClass = _tracciabilitaSchedaRemoteModel.getClass();

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

		Object returnValue = method.invoke(_tracciabilitaSchedaRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TracciabilitaSchedaLocalServiceUtil.addTracciabilitaScheda(this);
		}
		else {
			TracciabilitaSchedaLocalServiceUtil.updateTracciabilitaScheda(this);
		}
	}

	@Override
	public TracciabilitaScheda toEscapedModel() {
		return (TracciabilitaScheda)ProxyUtil.newProxyInstance(TracciabilitaScheda.class.getClassLoader(),
			new Class[] { TracciabilitaScheda.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TracciabilitaSchedaClp clone = new TracciabilitaSchedaClp();

		clone.setId(getId());
		clone.setCodiceProdotto(getCodiceProdotto());
		clone.setProdottoVenduto(getProdottoVenduto());
		clone.setKgVenduti(getKgVenduti());
		clone.setLottoVendita(getLottoVendita());
		clone.setAnno(getAnno());
		clone.setNumeroDocumento(getNumeroDocumento());
		clone.setRigoOrdine(getRigoOrdine());
		clone.setTipoDocumento(getTipoDocumento());
		clone.setIdAssociato(getIdAssociato());

		return clone;
	}

	@Override
	public int compareTo(TracciabilitaScheda tracciabilitaScheda) {
		long primaryKey = tracciabilitaScheda.getPrimaryKey();

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

		if (!(obj instanceof TracciabilitaSchedaClp)) {
			return false;
		}

		TracciabilitaSchedaClp tracciabilitaScheda = (TracciabilitaSchedaClp)obj;

		long primaryKey = tracciabilitaScheda.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", codiceProdotto=");
		sb.append(getCodiceProdotto());
		sb.append(", prodottoVenduto=");
		sb.append(getProdottoVenduto());
		sb.append(", kgVenduti=");
		sb.append(getKgVenduti());
		sb.append(", lottoVendita=");
		sb.append(getLottoVendita());
		sb.append(", anno=");
		sb.append(getAnno());
		sb.append(", numeroDocumento=");
		sb.append(getNumeroDocumento());
		sb.append(", rigoOrdine=");
		sb.append(getRigoOrdine());
		sb.append(", tipoDocumento=");
		sb.append(getTipoDocumento());
		sb.append(", idAssociato=");
		sb.append(getIdAssociato());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("it.bysoftware.ct.model.TracciabilitaScheda");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codiceProdotto</column-name><column-value><![CDATA[");
		sb.append(getCodiceProdotto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>prodottoVenduto</column-name><column-value><![CDATA[");
		sb.append(getProdottoVenduto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kgVenduti</column-name><column-value><![CDATA[");
		sb.append(getKgVenduti());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lottoVendita</column-name><column-value><![CDATA[");
		sb.append(getLottoVendita());
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
			"<column><column-name>rigoOrdine</column-name><column-value><![CDATA[");
		sb.append(getRigoOrdine());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipoDocumento</column-name><column-value><![CDATA[");
		sb.append(getTipoDocumento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idAssociato</column-name><column-value><![CDATA[");
		sb.append(getIdAssociato());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _codiceProdotto;
	private String _prodottoVenduto;
	private double _kgVenduti;
	private String _lottoVendita;
	private int _anno;
	private long _numeroDocumento;
	private int _rigoOrdine;
	private String _tipoDocumento;
	private long _idAssociato;
	private BaseModel<?> _tracciabilitaSchedaRemoteModel;
	private Class<?> _clpSerializerClass = it.bysoftware.ct.service.ClpSerializer.class;
}
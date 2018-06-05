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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Iva}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Iva
 * @generated
 */
public class IvaWrapper implements Iva, ModelWrapper<Iva> {
	public IvaWrapper(Iva iva) {
		_iva = iva;
	}

	@Override
	public Class<?> getModelClass() {
		return Iva.class;
	}

	@Override
	public String getModelClassName() {
		return Iva.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("codiceIva", getCodiceIva());
		attributes.put("descrizione", getDescrizione());
		attributes.put("descrizioneDocumento", getDescrizioneDocumento());
		attributes.put("aliquota", getAliquota());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String codiceIva = (String)attributes.get("codiceIva");

		if (codiceIva != null) {
			setCodiceIva(codiceIva);
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

		Double aliquota = (Double)attributes.get("aliquota");

		if (aliquota != null) {
			setAliquota(aliquota);
		}
	}

	/**
	* Returns the primary key of this iva.
	*
	* @return the primary key of this iva
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _iva.getPrimaryKey();
	}

	/**
	* Sets the primary key of this iva.
	*
	* @param primaryKey the primary key of this iva
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_iva.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the codice iva of this iva.
	*
	* @return the codice iva of this iva
	*/
	@Override
	public java.lang.String getCodiceIva() {
		return _iva.getCodiceIva();
	}

	/**
	* Sets the codice iva of this iva.
	*
	* @param codiceIva the codice iva of this iva
	*/
	@Override
	public void setCodiceIva(java.lang.String codiceIva) {
		_iva.setCodiceIva(codiceIva);
	}

	/**
	* Returns the descrizione of this iva.
	*
	* @return the descrizione of this iva
	*/
	@Override
	public java.lang.String getDescrizione() {
		return _iva.getDescrizione();
	}

	/**
	* Sets the descrizione of this iva.
	*
	* @param descrizione the descrizione of this iva
	*/
	@Override
	public void setDescrizione(java.lang.String descrizione) {
		_iva.setDescrizione(descrizione);
	}

	/**
	* Returns the descrizione documento of this iva.
	*
	* @return the descrizione documento of this iva
	*/
	@Override
	public java.lang.String getDescrizioneDocumento() {
		return _iva.getDescrizioneDocumento();
	}

	/**
	* Sets the descrizione documento of this iva.
	*
	* @param descrizioneDocumento the descrizione documento of this iva
	*/
	@Override
	public void setDescrizioneDocumento(java.lang.String descrizioneDocumento) {
		_iva.setDescrizioneDocumento(descrizioneDocumento);
	}

	/**
	* Returns the aliquota of this iva.
	*
	* @return the aliquota of this iva
	*/
	@Override
	public double getAliquota() {
		return _iva.getAliquota();
	}

	/**
	* Sets the aliquota of this iva.
	*
	* @param aliquota the aliquota of this iva
	*/
	@Override
	public void setAliquota(double aliquota) {
		_iva.setAliquota(aliquota);
	}

	@Override
	public boolean isNew() {
		return _iva.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_iva.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _iva.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_iva.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _iva.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _iva.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_iva.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _iva.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_iva.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_iva.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_iva.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new IvaWrapper((Iva)_iva.clone());
	}

	@Override
	public int compareTo(it.bysoftware.ct.model.Iva iva) {
		return _iva.compareTo(iva);
	}

	@Override
	public int hashCode() {
		return _iva.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.bysoftware.ct.model.Iva> toCacheModel() {
		return _iva.toCacheModel();
	}

	@Override
	public it.bysoftware.ct.model.Iva toEscapedModel() {
		return new IvaWrapper(_iva.toEscapedModel());
	}

	@Override
	public it.bysoftware.ct.model.Iva toUnescapedModel() {
		return new IvaWrapper(_iva.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _iva.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _iva.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_iva.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof IvaWrapper)) {
			return false;
		}

		IvaWrapper ivaWrapper = (IvaWrapper)obj;

		if (Validator.equals(_iva, ivaWrapper._iva)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Iva getWrappedIva() {
		return _iva;
	}

	@Override
	public Iva getWrappedModel() {
		return _iva;
	}

	@Override
	public void resetOriginalValues() {
		_iva.resetOriginalValues();
	}

	private Iva _iva;
}
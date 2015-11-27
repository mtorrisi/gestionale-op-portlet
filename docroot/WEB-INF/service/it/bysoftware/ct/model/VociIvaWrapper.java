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
 * This class is a wrapper for {@link VociIva}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VociIva
 * @generated
 */
public class VociIvaWrapper implements VociIva, ModelWrapper<VociIva> {
	public VociIvaWrapper(VociIva vociIva) {
		_vociIva = vociIva;
	}

	@Override
	public Class<?> getModelClass() {
		return VociIva.class;
	}

	@Override
	public String getModelClassName() {
		return VociIva.class.getName();
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
	* Returns the primary key of this voci iva.
	*
	* @return the primary key of this voci iva
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _vociIva.getPrimaryKey();
	}

	/**
	* Sets the primary key of this voci iva.
	*
	* @param primaryKey the primary key of this voci iva
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_vociIva.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the codice iva of this voci iva.
	*
	* @return the codice iva of this voci iva
	*/
	@Override
	public java.lang.String getCodiceIva() {
		return _vociIva.getCodiceIva();
	}

	/**
	* Sets the codice iva of this voci iva.
	*
	* @param codiceIva the codice iva of this voci iva
	*/
	@Override
	public void setCodiceIva(java.lang.String codiceIva) {
		_vociIva.setCodiceIva(codiceIva);
	}

	/**
	* Returns the descrizione of this voci iva.
	*
	* @return the descrizione of this voci iva
	*/
	@Override
	public java.lang.String getDescrizione() {
		return _vociIva.getDescrizione();
	}

	/**
	* Sets the descrizione of this voci iva.
	*
	* @param descrizione the descrizione of this voci iva
	*/
	@Override
	public void setDescrizione(java.lang.String descrizione) {
		_vociIva.setDescrizione(descrizione);
	}

	/**
	* Returns the descrizione documento of this voci iva.
	*
	* @return the descrizione documento of this voci iva
	*/
	@Override
	public java.lang.String getDescrizioneDocumento() {
		return _vociIva.getDescrizioneDocumento();
	}

	/**
	* Sets the descrizione documento of this voci iva.
	*
	* @param descrizioneDocumento the descrizione documento of this voci iva
	*/
	@Override
	public void setDescrizioneDocumento(java.lang.String descrizioneDocumento) {
		_vociIva.setDescrizioneDocumento(descrizioneDocumento);
	}

	/**
	* Returns the aliquota of this voci iva.
	*
	* @return the aliquota of this voci iva
	*/
	@Override
	public double getAliquota() {
		return _vociIva.getAliquota();
	}

	/**
	* Sets the aliquota of this voci iva.
	*
	* @param aliquota the aliquota of this voci iva
	*/
	@Override
	public void setAliquota(double aliquota) {
		_vociIva.setAliquota(aliquota);
	}

	@Override
	public boolean isNew() {
		return _vociIva.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_vociIva.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _vociIva.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vociIva.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _vociIva.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _vociIva.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vociIva.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vociIva.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_vociIva.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_vociIva.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vociIva.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VociIvaWrapper((VociIva)_vociIva.clone());
	}

	@Override
	public int compareTo(it.bysoftware.ct.model.VociIva vociIva) {
		return _vociIva.compareTo(vociIva);
	}

	@Override
	public int hashCode() {
		return _vociIva.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.bysoftware.ct.model.VociIva> toCacheModel() {
		return _vociIva.toCacheModel();
	}

	@Override
	public it.bysoftware.ct.model.VociIva toEscapedModel() {
		return new VociIvaWrapper(_vociIva.toEscapedModel());
	}

	@Override
	public it.bysoftware.ct.model.VociIva toUnescapedModel() {
		return new VociIvaWrapper(_vociIva.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vociIva.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vociIva.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vociIva.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VociIvaWrapper)) {
			return false;
		}

		VociIvaWrapper vociIvaWrapper = (VociIvaWrapper)obj;

		if (Validator.equals(_vociIva, vociIvaWrapper._vociIva)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VociIva getWrappedVociIva() {
		return _vociIva;
	}

	@Override
	public VociIva getWrappedModel() {
		return _vociIva;
	}

	@Override
	public void resetOriginalValues() {
		_vociIva.resetOriginalValues();
	}

	private VociIva _vociIva;
}
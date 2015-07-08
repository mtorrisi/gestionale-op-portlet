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
 * This class is a wrapper for {@link AspettoEsterioreBeni}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AspettoEsterioreBeni
 * @generated
 */
public class AspettoEsterioreBeniWrapper implements AspettoEsterioreBeni,
	ModelWrapper<AspettoEsterioreBeni> {
	public AspettoEsterioreBeniWrapper(
		AspettoEsterioreBeni aspettoEsterioreBeni) {
		_aspettoEsterioreBeni = aspettoEsterioreBeni;
	}

	@Override
	public Class<?> getModelClass() {
		return AspettoEsterioreBeni.class;
	}

	@Override
	public String getModelClassName() {
		return AspettoEsterioreBeni.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("codiceAspettoEsteriore", getCodiceAspettoEsteriore());
		attributes.put("descrizione", getDescrizione());
		attributes.put("codiceAzienda", getCodiceAzienda());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String codiceAspettoEsteriore = (String)attributes.get(
				"codiceAspettoEsteriore");

		if (codiceAspettoEsteriore != null) {
			setCodiceAspettoEsteriore(codiceAspettoEsteriore);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}

		String codiceAzienda = (String)attributes.get("codiceAzienda");

		if (codiceAzienda != null) {
			setCodiceAzienda(codiceAzienda);
		}
	}

	/**
	* Returns the primary key of this aspetto esteriore beni.
	*
	* @return the primary key of this aspetto esteriore beni
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _aspettoEsterioreBeni.getPrimaryKey();
	}

	/**
	* Sets the primary key of this aspetto esteriore beni.
	*
	* @param primaryKey the primary key of this aspetto esteriore beni
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_aspettoEsterioreBeni.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the codice aspetto esteriore of this aspetto esteriore beni.
	*
	* @return the codice aspetto esteriore of this aspetto esteriore beni
	*/
	@Override
	public java.lang.String getCodiceAspettoEsteriore() {
		return _aspettoEsterioreBeni.getCodiceAspettoEsteriore();
	}

	/**
	* Sets the codice aspetto esteriore of this aspetto esteriore beni.
	*
	* @param codiceAspettoEsteriore the codice aspetto esteriore of this aspetto esteriore beni
	*/
	@Override
	public void setCodiceAspettoEsteriore(
		java.lang.String codiceAspettoEsteriore) {
		_aspettoEsterioreBeni.setCodiceAspettoEsteriore(codiceAspettoEsteriore);
	}

	/**
	* Returns the descrizione of this aspetto esteriore beni.
	*
	* @return the descrizione of this aspetto esteriore beni
	*/
	@Override
	public java.lang.String getDescrizione() {
		return _aspettoEsterioreBeni.getDescrizione();
	}

	/**
	* Sets the descrizione of this aspetto esteriore beni.
	*
	* @param descrizione the descrizione of this aspetto esteriore beni
	*/
	@Override
	public void setDescrizione(java.lang.String descrizione) {
		_aspettoEsterioreBeni.setDescrizione(descrizione);
	}

	/**
	* Returns the codice azienda of this aspetto esteriore beni.
	*
	* @return the codice azienda of this aspetto esteriore beni
	*/
	@Override
	public java.lang.String getCodiceAzienda() {
		return _aspettoEsterioreBeni.getCodiceAzienda();
	}

	/**
	* Sets the codice azienda of this aspetto esteriore beni.
	*
	* @param codiceAzienda the codice azienda of this aspetto esteriore beni
	*/
	@Override
	public void setCodiceAzienda(java.lang.String codiceAzienda) {
		_aspettoEsterioreBeni.setCodiceAzienda(codiceAzienda);
	}

	@Override
	public boolean isNew() {
		return _aspettoEsterioreBeni.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_aspettoEsterioreBeni.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _aspettoEsterioreBeni.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_aspettoEsterioreBeni.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _aspettoEsterioreBeni.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _aspettoEsterioreBeni.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_aspettoEsterioreBeni.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _aspettoEsterioreBeni.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_aspettoEsterioreBeni.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_aspettoEsterioreBeni.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_aspettoEsterioreBeni.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AspettoEsterioreBeniWrapper((AspettoEsterioreBeni)_aspettoEsterioreBeni.clone());
	}

	@Override
	public int compareTo(AspettoEsterioreBeni aspettoEsterioreBeni) {
		return _aspettoEsterioreBeni.compareTo(aspettoEsterioreBeni);
	}

	@Override
	public int hashCode() {
		return _aspettoEsterioreBeni.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<AspettoEsterioreBeni> toCacheModel() {
		return _aspettoEsterioreBeni.toCacheModel();
	}

	@Override
	public AspettoEsterioreBeni toEscapedModel() {
		return new AspettoEsterioreBeniWrapper(_aspettoEsterioreBeni.toEscapedModel());
	}

	@Override
	public AspettoEsterioreBeni toUnescapedModel() {
		return new AspettoEsterioreBeniWrapper(_aspettoEsterioreBeni.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _aspettoEsterioreBeni.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _aspettoEsterioreBeni.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_aspettoEsterioreBeni.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AspettoEsterioreBeniWrapper)) {
			return false;
		}

		AspettoEsterioreBeniWrapper aspettoEsterioreBeniWrapper = (AspettoEsterioreBeniWrapper)obj;

		if (Validator.equals(_aspettoEsterioreBeni,
					aspettoEsterioreBeniWrapper._aspettoEsterioreBeni)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AspettoEsterioreBeni getWrappedAspettoEsterioreBeni() {
		return _aspettoEsterioreBeni;
	}

	@Override
	public AspettoEsterioreBeni getWrappedModel() {
		return _aspettoEsterioreBeni;
	}

	@Override
	public void resetOriginalValues() {
		_aspettoEsterioreBeni.resetOriginalValues();
	}

	private AspettoEsterioreBeni _aspettoEsterioreBeni;
}
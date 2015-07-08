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
 * This class is a wrapper for {@link Porto}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Porto
 * @generated
 */
public class PortoWrapper implements Porto, ModelWrapper<Porto> {
	public PortoWrapper(Porto porto) {
		_porto = porto;
	}

	@Override
	public Class<?> getModelClass() {
		return Porto.class;
	}

	@Override
	public String getModelClassName() {
		return Porto.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("Cdinco", getCdinco());
		attributes.put("codicePorto", getCodicePorto());
		attributes.put("descrizione", getDescrizione());
		attributes.put("Incoterm", getIncoterm());
		attributes.put("codiceAzienda", getCodiceAzienda());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String Cdinco = (String)attributes.get("Cdinco");

		if (Cdinco != null) {
			setCdinco(Cdinco);
		}

		String codicePorto = (String)attributes.get("codicePorto");

		if (codicePorto != null) {
			setCodicePorto(codicePorto);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}

		String Incoterm = (String)attributes.get("Incoterm");

		if (Incoterm != null) {
			setIncoterm(Incoterm);
		}

		String codiceAzienda = (String)attributes.get("codiceAzienda");

		if (codiceAzienda != null) {
			setCodiceAzienda(codiceAzienda);
		}
	}

	/**
	* Returns the primary key of this porto.
	*
	* @return the primary key of this porto
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _porto.getPrimaryKey();
	}

	/**
	* Sets the primary key of this porto.
	*
	* @param primaryKey the primary key of this porto
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_porto.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the cdinco of this porto.
	*
	* @return the cdinco of this porto
	*/
	@Override
	public java.lang.String getCdinco() {
		return _porto.getCdinco();
	}

	/**
	* Sets the cdinco of this porto.
	*
	* @param Cdinco the cdinco of this porto
	*/
	@Override
	public void setCdinco(java.lang.String Cdinco) {
		_porto.setCdinco(Cdinco);
	}

	/**
	* Returns the codice porto of this porto.
	*
	* @return the codice porto of this porto
	*/
	@Override
	public java.lang.String getCodicePorto() {
		return _porto.getCodicePorto();
	}

	/**
	* Sets the codice porto of this porto.
	*
	* @param codicePorto the codice porto of this porto
	*/
	@Override
	public void setCodicePorto(java.lang.String codicePorto) {
		_porto.setCodicePorto(codicePorto);
	}

	/**
	* Returns the descrizione of this porto.
	*
	* @return the descrizione of this porto
	*/
	@Override
	public java.lang.String getDescrizione() {
		return _porto.getDescrizione();
	}

	/**
	* Sets the descrizione of this porto.
	*
	* @param descrizione the descrizione of this porto
	*/
	@Override
	public void setDescrizione(java.lang.String descrizione) {
		_porto.setDescrizione(descrizione);
	}

	/**
	* Returns the incoterm of this porto.
	*
	* @return the incoterm of this porto
	*/
	@Override
	public java.lang.String getIncoterm() {
		return _porto.getIncoterm();
	}

	/**
	* Sets the incoterm of this porto.
	*
	* @param Incoterm the incoterm of this porto
	*/
	@Override
	public void setIncoterm(java.lang.String Incoterm) {
		_porto.setIncoterm(Incoterm);
	}

	/**
	* Returns the codice azienda of this porto.
	*
	* @return the codice azienda of this porto
	*/
	@Override
	public java.lang.String getCodiceAzienda() {
		return _porto.getCodiceAzienda();
	}

	/**
	* Sets the codice azienda of this porto.
	*
	* @param codiceAzienda the codice azienda of this porto
	*/
	@Override
	public void setCodiceAzienda(java.lang.String codiceAzienda) {
		_porto.setCodiceAzienda(codiceAzienda);
	}

	@Override
	public boolean isNew() {
		return _porto.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_porto.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _porto.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_porto.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _porto.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _porto.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_porto.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _porto.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_porto.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_porto.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_porto.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PortoWrapper((Porto)_porto.clone());
	}

	@Override
	public int compareTo(Porto porto) {
		return _porto.compareTo(porto);
	}

	@Override
	public int hashCode() {
		return _porto.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<Porto> toCacheModel() {
		return _porto.toCacheModel();
	}

	@Override
	public Porto toEscapedModel() {
		return new PortoWrapper(_porto.toEscapedModel());
	}

	@Override
	public Porto toUnescapedModel() {
		return new PortoWrapper(_porto.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _porto.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _porto.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_porto.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PortoWrapper)) {
			return false;
		}

		PortoWrapper portoWrapper = (PortoWrapper)obj;

		if (Validator.equals(_porto, portoWrapper._porto)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Porto getWrappedPorto() {
		return _porto;
	}

	@Override
	public Porto getWrappedModel() {
		return _porto;
	}

	@Override
	public void resetOriginalValues() {
		_porto.resetOriginalValues();
	}

	private Porto _porto;
}
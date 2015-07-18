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
 * This class is a wrapper for {@link CausaleTrasporto}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CausaleTrasporto
 * @generated
 */
public class CausaleTrasportoWrapper implements CausaleTrasporto,
	ModelWrapper<CausaleTrasporto> {
	public CausaleTrasportoWrapper(CausaleTrasporto causaleTrasporto) {
		_causaleTrasporto = causaleTrasporto;
	}

	@Override
	public Class<?> getModelClass() {
		return CausaleTrasporto.class;
	}

	@Override
	public String getModelClassName() {
		return CausaleTrasporto.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("codiceCausaleTrasporto", getCodiceCausaleTrasporto());
		attributes.put("descrizione", getDescrizione());
		attributes.put("codiceAzienda", getCodiceAzienda());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String codiceCausaleTrasporto = (String)attributes.get(
				"codiceCausaleTrasporto");

		if (codiceCausaleTrasporto != null) {
			setCodiceCausaleTrasporto(codiceCausaleTrasporto);
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
	* Returns the primary key of this causale trasporto.
	*
	* @return the primary key of this causale trasporto
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _causaleTrasporto.getPrimaryKey();
	}

	/**
	* Sets the primary key of this causale trasporto.
	*
	* @param primaryKey the primary key of this causale trasporto
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_causaleTrasporto.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the codice causale trasporto of this causale trasporto.
	*
	* @return the codice causale trasporto of this causale trasporto
	*/
	@Override
	public java.lang.String getCodiceCausaleTrasporto() {
		return _causaleTrasporto.getCodiceCausaleTrasporto();
	}

	/**
	* Sets the codice causale trasporto of this causale trasporto.
	*
	* @param codiceCausaleTrasporto the codice causale trasporto of this causale trasporto
	*/
	@Override
	public void setCodiceCausaleTrasporto(
		java.lang.String codiceCausaleTrasporto) {
		_causaleTrasporto.setCodiceCausaleTrasporto(codiceCausaleTrasporto);
	}

	/**
	* Returns the descrizione of this causale trasporto.
	*
	* @return the descrizione of this causale trasporto
	*/
	@Override
	public java.lang.String getDescrizione() {
		return _causaleTrasporto.getDescrizione();
	}

	/**
	* Sets the descrizione of this causale trasporto.
	*
	* @param descrizione the descrizione of this causale trasporto
	*/
	@Override
	public void setDescrizione(java.lang.String descrizione) {
		_causaleTrasporto.setDescrizione(descrizione);
	}

	/**
	* Returns the codice azienda of this causale trasporto.
	*
	* @return the codice azienda of this causale trasporto
	*/
	@Override
	public java.lang.String getCodiceAzienda() {
		return _causaleTrasporto.getCodiceAzienda();
	}

	/**
	* Sets the codice azienda of this causale trasporto.
	*
	* @param codiceAzienda the codice azienda of this causale trasporto
	*/
	@Override
	public void setCodiceAzienda(java.lang.String codiceAzienda) {
		_causaleTrasporto.setCodiceAzienda(codiceAzienda);
	}

	@Override
	public boolean isNew() {
		return _causaleTrasporto.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_causaleTrasporto.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _causaleTrasporto.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_causaleTrasporto.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _causaleTrasporto.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _causaleTrasporto.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_causaleTrasporto.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _causaleTrasporto.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_causaleTrasporto.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_causaleTrasporto.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_causaleTrasporto.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CausaleTrasportoWrapper((CausaleTrasporto)_causaleTrasporto.clone());
	}

	@Override
	public int compareTo(
		it.bysoftware.ct.model.CausaleTrasporto causaleTrasporto) {
		return _causaleTrasporto.compareTo(causaleTrasporto);
	}

	@Override
	public int hashCode() {
		return _causaleTrasporto.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.bysoftware.ct.model.CausaleTrasporto> toCacheModel() {
		return _causaleTrasporto.toCacheModel();
	}

	@Override
	public it.bysoftware.ct.model.CausaleTrasporto toEscapedModel() {
		return new CausaleTrasportoWrapper(_causaleTrasporto.toEscapedModel());
	}

	@Override
	public it.bysoftware.ct.model.CausaleTrasporto toUnescapedModel() {
		return new CausaleTrasportoWrapper(_causaleTrasporto.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _causaleTrasporto.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _causaleTrasporto.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_causaleTrasporto.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CausaleTrasportoWrapper)) {
			return false;
		}

		CausaleTrasportoWrapper causaleTrasportoWrapper = (CausaleTrasportoWrapper)obj;

		if (Validator.equals(_causaleTrasporto,
					causaleTrasportoWrapper._causaleTrasporto)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CausaleTrasporto getWrappedCausaleTrasporto() {
		return _causaleTrasporto;
	}

	@Override
	public CausaleTrasporto getWrappedModel() {
		return _causaleTrasporto;
	}

	@Override
	public void resetOriginalValues() {
		_causaleTrasporto.resetOriginalValues();
	}

	private CausaleTrasporto _causaleTrasporto;
}
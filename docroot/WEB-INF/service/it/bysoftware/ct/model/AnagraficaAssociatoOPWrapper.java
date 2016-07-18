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
 * This class is a wrapper for {@link AnagraficaAssociatoOP}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnagraficaAssociatoOP
 * @generated
 */
public class AnagraficaAssociatoOPWrapper implements AnagraficaAssociatoOP,
	ModelWrapper<AnagraficaAssociatoOP> {
	public AnagraficaAssociatoOPWrapper(
		AnagraficaAssociatoOP anagraficaAssociatoOP) {
		_anagraficaAssociatoOP = anagraficaAssociatoOP;
	}

	@Override
	public Class<?> getModelClass() {
		return AnagraficaAssociatoOP.class;
	}

	@Override
	public String getModelClassName() {
		return AnagraficaAssociatoOP.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idAssociato", getIdAssociato());
		attributes.put("codiceSogettoAssociato", getCodiceSogettoAssociato());
		attributes.put("codiceSogettoOP", getCodiceSogettoOP());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idAssociato = (Long)attributes.get("idAssociato");

		if (idAssociato != null) {
			setIdAssociato(idAssociato);
		}

		String codiceSogettoAssociato = (String)attributes.get(
				"codiceSogettoAssociato");

		if (codiceSogettoAssociato != null) {
			setCodiceSogettoAssociato(codiceSogettoAssociato);
		}

		String codiceSogettoOP = (String)attributes.get("codiceSogettoOP");

		if (codiceSogettoOP != null) {
			setCodiceSogettoOP(codiceSogettoOP);
		}
	}

	/**
	* Returns the primary key of this anagrafica associato o p.
	*
	* @return the primary key of this anagrafica associato o p
	*/
	@Override
	public it.bysoftware.ct.service.persistence.AnagraficaAssociatoOPPK getPrimaryKey() {
		return _anagraficaAssociatoOP.getPrimaryKey();
	}

	/**
	* Sets the primary key of this anagrafica associato o p.
	*
	* @param primaryKey the primary key of this anagrafica associato o p
	*/
	@Override
	public void setPrimaryKey(
		it.bysoftware.ct.service.persistence.AnagraficaAssociatoOPPK primaryKey) {
		_anagraficaAssociatoOP.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id associato of this anagrafica associato o p.
	*
	* @return the id associato of this anagrafica associato o p
	*/
	@Override
	public long getIdAssociato() {
		return _anagraficaAssociatoOP.getIdAssociato();
	}

	/**
	* Sets the id associato of this anagrafica associato o p.
	*
	* @param idAssociato the id associato of this anagrafica associato o p
	*/
	@Override
	public void setIdAssociato(long idAssociato) {
		_anagraficaAssociatoOP.setIdAssociato(idAssociato);
	}

	/**
	* Returns the codice sogetto associato of this anagrafica associato o p.
	*
	* @return the codice sogetto associato of this anagrafica associato o p
	*/
	@Override
	public java.lang.String getCodiceSogettoAssociato() {
		return _anagraficaAssociatoOP.getCodiceSogettoAssociato();
	}

	/**
	* Sets the codice sogetto associato of this anagrafica associato o p.
	*
	* @param codiceSogettoAssociato the codice sogetto associato of this anagrafica associato o p
	*/
	@Override
	public void setCodiceSogettoAssociato(
		java.lang.String codiceSogettoAssociato) {
		_anagraficaAssociatoOP.setCodiceSogettoAssociato(codiceSogettoAssociato);
	}

	/**
	* Returns the codice sogetto o p of this anagrafica associato o p.
	*
	* @return the codice sogetto o p of this anagrafica associato o p
	*/
	@Override
	public java.lang.String getCodiceSogettoOP() {
		return _anagraficaAssociatoOP.getCodiceSogettoOP();
	}

	/**
	* Sets the codice sogetto o p of this anagrafica associato o p.
	*
	* @param codiceSogettoOP the codice sogetto o p of this anagrafica associato o p
	*/
	@Override
	public void setCodiceSogettoOP(java.lang.String codiceSogettoOP) {
		_anagraficaAssociatoOP.setCodiceSogettoOP(codiceSogettoOP);
	}

	@Override
	public boolean isNew() {
		return _anagraficaAssociatoOP.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_anagraficaAssociatoOP.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _anagraficaAssociatoOP.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_anagraficaAssociatoOP.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _anagraficaAssociatoOP.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _anagraficaAssociatoOP.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_anagraficaAssociatoOP.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _anagraficaAssociatoOP.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_anagraficaAssociatoOP.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_anagraficaAssociatoOP.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_anagraficaAssociatoOP.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AnagraficaAssociatoOPWrapper((AnagraficaAssociatoOP)_anagraficaAssociatoOP.clone());
	}

	@Override
	public int compareTo(
		it.bysoftware.ct.model.AnagraficaAssociatoOP anagraficaAssociatoOP) {
		return _anagraficaAssociatoOP.compareTo(anagraficaAssociatoOP);
	}

	@Override
	public int hashCode() {
		return _anagraficaAssociatoOP.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.bysoftware.ct.model.AnagraficaAssociatoOP> toCacheModel() {
		return _anagraficaAssociatoOP.toCacheModel();
	}

	@Override
	public it.bysoftware.ct.model.AnagraficaAssociatoOP toEscapedModel() {
		return new AnagraficaAssociatoOPWrapper(_anagraficaAssociatoOP.toEscapedModel());
	}

	@Override
	public it.bysoftware.ct.model.AnagraficaAssociatoOP toUnescapedModel() {
		return new AnagraficaAssociatoOPWrapper(_anagraficaAssociatoOP.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _anagraficaAssociatoOP.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _anagraficaAssociatoOP.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_anagraficaAssociatoOP.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnagraficaAssociatoOPWrapper)) {
			return false;
		}

		AnagraficaAssociatoOPWrapper anagraficaAssociatoOPWrapper = (AnagraficaAssociatoOPWrapper)obj;

		if (Validator.equals(_anagraficaAssociatoOP,
					anagraficaAssociatoOPWrapper._anagraficaAssociatoOP)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AnagraficaAssociatoOP getWrappedAnagraficaAssociatoOP() {
		return _anagraficaAssociatoOP;
	}

	@Override
	public AnagraficaAssociatoOP getWrappedModel() {
		return _anagraficaAssociatoOP;
	}

	@Override
	public void resetOriginalValues() {
		_anagraficaAssociatoOP.resetOriginalValues();
	}

	private AnagraficaAssociatoOP _anagraficaAssociatoOP;
}
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
 * This class is a wrapper for {@link ArticoliAssociatoOP}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ArticoliAssociatoOP
 * @generated
 */
public class ArticoliAssociatoOPWrapper implements ArticoliAssociatoOP,
	ModelWrapper<ArticoliAssociatoOP> {
	public ArticoliAssociatoOPWrapper(ArticoliAssociatoOP articoliAssociatoOP) {
		_articoliAssociatoOP = articoliAssociatoOP;
	}

	@Override
	public Class<?> getModelClass() {
		return ArticoliAssociatoOP.class;
	}

	@Override
	public String getModelClassName() {
		return ArticoliAssociatoOP.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idAssociato", getIdAssociato());
		attributes.put("codiceArticoloAssociato", getCodiceArticoloAssociato());
		attributes.put("codiceArticoloOP", getCodiceArticoloOP());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idAssociato = (Long)attributes.get("idAssociato");

		if (idAssociato != null) {
			setIdAssociato(idAssociato);
		}

		String codiceArticoloAssociato = (String)attributes.get(
				"codiceArticoloAssociato");

		if (codiceArticoloAssociato != null) {
			setCodiceArticoloAssociato(codiceArticoloAssociato);
		}

		String codiceArticoloOP = (String)attributes.get("codiceArticoloOP");

		if (codiceArticoloOP != null) {
			setCodiceArticoloOP(codiceArticoloOP);
		}
	}

	/**
	* Returns the primary key of this articoli associato o p.
	*
	* @return the primary key of this articoli associato o p
	*/
	@Override
	public it.bysoftware.ct.service.persistence.ArticoliAssociatoOPPK getPrimaryKey() {
		return _articoliAssociatoOP.getPrimaryKey();
	}

	/**
	* Sets the primary key of this articoli associato o p.
	*
	* @param primaryKey the primary key of this articoli associato o p
	*/
	@Override
	public void setPrimaryKey(
		it.bysoftware.ct.service.persistence.ArticoliAssociatoOPPK primaryKey) {
		_articoliAssociatoOP.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id associato of this articoli associato o p.
	*
	* @return the id associato of this articoli associato o p
	*/
	@Override
	public long getIdAssociato() {
		return _articoliAssociatoOP.getIdAssociato();
	}

	/**
	* Sets the id associato of this articoli associato o p.
	*
	* @param idAssociato the id associato of this articoli associato o p
	*/
	@Override
	public void setIdAssociato(long idAssociato) {
		_articoliAssociatoOP.setIdAssociato(idAssociato);
	}

	/**
	* Returns the codice articolo associato of this articoli associato o p.
	*
	* @return the codice articolo associato of this articoli associato o p
	*/
	@Override
	public java.lang.String getCodiceArticoloAssociato() {
		return _articoliAssociatoOP.getCodiceArticoloAssociato();
	}

	/**
	* Sets the codice articolo associato of this articoli associato o p.
	*
	* @param codiceArticoloAssociato the codice articolo associato of this articoli associato o p
	*/
	@Override
	public void setCodiceArticoloAssociato(
		java.lang.String codiceArticoloAssociato) {
		_articoliAssociatoOP.setCodiceArticoloAssociato(codiceArticoloAssociato);
	}

	/**
	* Returns the codice articolo o p of this articoli associato o p.
	*
	* @return the codice articolo o p of this articoli associato o p
	*/
	@Override
	public java.lang.String getCodiceArticoloOP() {
		return _articoliAssociatoOP.getCodiceArticoloOP();
	}

	/**
	* Sets the codice articolo o p of this articoli associato o p.
	*
	* @param codiceArticoloOP the codice articolo o p of this articoli associato o p
	*/
	@Override
	public void setCodiceArticoloOP(java.lang.String codiceArticoloOP) {
		_articoliAssociatoOP.setCodiceArticoloOP(codiceArticoloOP);
	}

	@Override
	public boolean isNew() {
		return _articoliAssociatoOP.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_articoliAssociatoOP.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _articoliAssociatoOP.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_articoliAssociatoOP.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _articoliAssociatoOP.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _articoliAssociatoOP.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_articoliAssociatoOP.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _articoliAssociatoOP.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_articoliAssociatoOP.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_articoliAssociatoOP.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_articoliAssociatoOP.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ArticoliAssociatoOPWrapper((ArticoliAssociatoOP)_articoliAssociatoOP.clone());
	}

	@Override
	public int compareTo(
		it.bysoftware.ct.model.ArticoliAssociatoOP articoliAssociatoOP) {
		return _articoliAssociatoOP.compareTo(articoliAssociatoOP);
	}

	@Override
	public int hashCode() {
		return _articoliAssociatoOP.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.bysoftware.ct.model.ArticoliAssociatoOP> toCacheModel() {
		return _articoliAssociatoOP.toCacheModel();
	}

	@Override
	public it.bysoftware.ct.model.ArticoliAssociatoOP toEscapedModel() {
		return new ArticoliAssociatoOPWrapper(_articoliAssociatoOP.toEscapedModel());
	}

	@Override
	public it.bysoftware.ct.model.ArticoliAssociatoOP toUnescapedModel() {
		return new ArticoliAssociatoOPWrapper(_articoliAssociatoOP.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _articoliAssociatoOP.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _articoliAssociatoOP.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_articoliAssociatoOP.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ArticoliAssociatoOPWrapper)) {
			return false;
		}

		ArticoliAssociatoOPWrapper articoliAssociatoOPWrapper = (ArticoliAssociatoOPWrapper)obj;

		if (Validator.equals(_articoliAssociatoOP,
					articoliAssociatoOPWrapper._articoliAssociatoOP)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ArticoliAssociatoOP getWrappedArticoliAssociatoOP() {
		return _articoliAssociatoOP;
	}

	@Override
	public ArticoliAssociatoOP getWrappedModel() {
		return _articoliAssociatoOP;
	}

	@Override
	public void resetOriginalValues() {
		_articoliAssociatoOP.resetOriginalValues();
	}

	private ArticoliAssociatoOP _articoliAssociatoOP;
}
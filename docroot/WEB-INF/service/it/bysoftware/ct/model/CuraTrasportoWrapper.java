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
 * This class is a wrapper for {@link CuraTrasporto}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CuraTrasporto
 * @generated
 */
public class CuraTrasportoWrapper implements CuraTrasporto,
	ModelWrapper<CuraTrasporto> {
	public CuraTrasportoWrapper(CuraTrasporto curaTrasporto) {
		_curaTrasporto = curaTrasporto;
	}

	@Override
	public Class<?> getModelClass() {
		return CuraTrasporto.class;
	}

	@Override
	public String getModelClassName() {
		return CuraTrasporto.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("codiceCuraTrasporto", getCodiceCuraTrasporto());
		attributes.put("descrizione", getDescrizione());
		attributes.put("codiceAzienda", getCodiceAzienda());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String codiceCuraTrasporto = (String)attributes.get(
				"codiceCuraTrasporto");

		if (codiceCuraTrasporto != null) {
			setCodiceCuraTrasporto(codiceCuraTrasporto);
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
	* Returns the primary key of this cura trasporto.
	*
	* @return the primary key of this cura trasporto
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _curaTrasporto.getPrimaryKey();
	}

	/**
	* Sets the primary key of this cura trasporto.
	*
	* @param primaryKey the primary key of this cura trasporto
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_curaTrasporto.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the codice cura trasporto of this cura trasporto.
	*
	* @return the codice cura trasporto of this cura trasporto
	*/
	@Override
	public java.lang.String getCodiceCuraTrasporto() {
		return _curaTrasporto.getCodiceCuraTrasporto();
	}

	/**
	* Sets the codice cura trasporto of this cura trasporto.
	*
	* @param codiceCuraTrasporto the codice cura trasporto of this cura trasporto
	*/
	@Override
	public void setCodiceCuraTrasporto(java.lang.String codiceCuraTrasporto) {
		_curaTrasporto.setCodiceCuraTrasporto(codiceCuraTrasporto);
	}

	/**
	* Returns the descrizione of this cura trasporto.
	*
	* @return the descrizione of this cura trasporto
	*/
	@Override
	public java.lang.String getDescrizione() {
		return _curaTrasporto.getDescrizione();
	}

	/**
	* Sets the descrizione of this cura trasporto.
	*
	* @param descrizione the descrizione of this cura trasporto
	*/
	@Override
	public void setDescrizione(java.lang.String descrizione) {
		_curaTrasporto.setDescrizione(descrizione);
	}

	/**
	* Returns the codice azienda of this cura trasporto.
	*
	* @return the codice azienda of this cura trasporto
	*/
	@Override
	public java.lang.String getCodiceAzienda() {
		return _curaTrasporto.getCodiceAzienda();
	}

	/**
	* Sets the codice azienda of this cura trasporto.
	*
	* @param codiceAzienda the codice azienda of this cura trasporto
	*/
	@Override
	public void setCodiceAzienda(java.lang.String codiceAzienda) {
		_curaTrasporto.setCodiceAzienda(codiceAzienda);
	}

	@Override
	public boolean isNew() {
		return _curaTrasporto.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_curaTrasporto.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _curaTrasporto.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_curaTrasporto.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _curaTrasporto.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _curaTrasporto.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_curaTrasporto.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _curaTrasporto.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_curaTrasporto.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_curaTrasporto.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_curaTrasporto.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CuraTrasportoWrapper((CuraTrasporto)_curaTrasporto.clone());
	}

	@Override
	public int compareTo(it.bysoftware.ct.model.CuraTrasporto curaTrasporto) {
		return _curaTrasporto.compareTo(curaTrasporto);
	}

	@Override
	public int hashCode() {
		return _curaTrasporto.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.bysoftware.ct.model.CuraTrasporto> toCacheModel() {
		return _curaTrasporto.toCacheModel();
	}

	@Override
	public it.bysoftware.ct.model.CuraTrasporto toEscapedModel() {
		return new CuraTrasportoWrapper(_curaTrasporto.toEscapedModel());
	}

	@Override
	public it.bysoftware.ct.model.CuraTrasporto toUnescapedModel() {
		return new CuraTrasportoWrapper(_curaTrasporto.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _curaTrasporto.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _curaTrasporto.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_curaTrasporto.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CuraTrasportoWrapper)) {
			return false;
		}

		CuraTrasportoWrapper curaTrasportoWrapper = (CuraTrasportoWrapper)obj;

		if (Validator.equals(_curaTrasporto, curaTrasportoWrapper._curaTrasporto)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CuraTrasporto getWrappedCuraTrasporto() {
		return _curaTrasporto;
	}

	@Override
	public CuraTrasporto getWrappedModel() {
		return _curaTrasporto;
	}

	@Override
	public void resetOriginalValues() {
		_curaTrasporto.resetOriginalValues();
	}

	private CuraTrasporto _curaTrasporto;
}
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
 * This class is a wrapper for {@link DescrizioniDocumenti}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DescrizioniDocumenti
 * @generated
 */
public class DescrizioniDocumentiWrapper implements DescrizioniDocumenti,
	ModelWrapper<DescrizioniDocumenti> {
	public DescrizioniDocumentiWrapper(
		DescrizioniDocumenti descrizioniDocumenti) {
		_descrizioniDocumenti = descrizioniDocumenti;
	}

	@Override
	public Class<?> getModelClass() {
		return DescrizioniDocumenti.class;
	}

	@Override
	public String getModelClassName() {
		return DescrizioniDocumenti.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("codiceDescrizione", getCodiceDescrizione());
		attributes.put("codiceIVA", getCodiceIVA());
		attributes.put("descrizione", getDescrizione());
		attributes.put("descrizioneFiscale", getDescrizioneFiscale());
		attributes.put("codiceAzienda", getCodiceAzienda());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String codiceDescrizione = (String)attributes.get("codiceDescrizione");

		if (codiceDescrizione != null) {
			setCodiceDescrizione(codiceDescrizione);
		}

		String codiceIVA = (String)attributes.get("codiceIVA");

		if (codiceIVA != null) {
			setCodiceIVA(codiceIVA);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}

		String descrizioneFiscale = (String)attributes.get("descrizioneFiscale");

		if (descrizioneFiscale != null) {
			setDescrizioneFiscale(descrizioneFiscale);
		}

		String codiceAzienda = (String)attributes.get("codiceAzienda");

		if (codiceAzienda != null) {
			setCodiceAzienda(codiceAzienda);
		}
	}

	/**
	* Returns the primary key of this descrizioni documenti.
	*
	* @return the primary key of this descrizioni documenti
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _descrizioniDocumenti.getPrimaryKey();
	}

	/**
	* Sets the primary key of this descrizioni documenti.
	*
	* @param primaryKey the primary key of this descrizioni documenti
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_descrizioniDocumenti.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the codice descrizione of this descrizioni documenti.
	*
	* @return the codice descrizione of this descrizioni documenti
	*/
	@Override
	public java.lang.String getCodiceDescrizione() {
		return _descrizioniDocumenti.getCodiceDescrizione();
	}

	/**
	* Sets the codice descrizione of this descrizioni documenti.
	*
	* @param codiceDescrizione the codice descrizione of this descrizioni documenti
	*/
	@Override
	public void setCodiceDescrizione(java.lang.String codiceDescrizione) {
		_descrizioniDocumenti.setCodiceDescrizione(codiceDescrizione);
	}

	/**
	* Returns the codice i v a of this descrizioni documenti.
	*
	* @return the codice i v a of this descrizioni documenti
	*/
	@Override
	public java.lang.String getCodiceIVA() {
		return _descrizioniDocumenti.getCodiceIVA();
	}

	/**
	* Sets the codice i v a of this descrizioni documenti.
	*
	* @param codiceIVA the codice i v a of this descrizioni documenti
	*/
	@Override
	public void setCodiceIVA(java.lang.String codiceIVA) {
		_descrizioniDocumenti.setCodiceIVA(codiceIVA);
	}

	/**
	* Returns the descrizione of this descrizioni documenti.
	*
	* @return the descrizione of this descrizioni documenti
	*/
	@Override
	public java.lang.String getDescrizione() {
		return _descrizioniDocumenti.getDescrizione();
	}

	/**
	* Sets the descrizione of this descrizioni documenti.
	*
	* @param descrizione the descrizione of this descrizioni documenti
	*/
	@Override
	public void setDescrizione(java.lang.String descrizione) {
		_descrizioniDocumenti.setDescrizione(descrizione);
	}

	/**
	* Returns the descrizione fiscale of this descrizioni documenti.
	*
	* @return the descrizione fiscale of this descrizioni documenti
	*/
	@Override
	public java.lang.String getDescrizioneFiscale() {
		return _descrizioniDocumenti.getDescrizioneFiscale();
	}

	/**
	* Sets the descrizione fiscale of this descrizioni documenti.
	*
	* @param descrizioneFiscale the descrizione fiscale of this descrizioni documenti
	*/
	@Override
	public void setDescrizioneFiscale(java.lang.String descrizioneFiscale) {
		_descrizioniDocumenti.setDescrizioneFiscale(descrizioneFiscale);
	}

	/**
	* Returns the codice azienda of this descrizioni documenti.
	*
	* @return the codice azienda of this descrizioni documenti
	*/
	@Override
	public java.lang.String getCodiceAzienda() {
		return _descrizioniDocumenti.getCodiceAzienda();
	}

	/**
	* Sets the codice azienda of this descrizioni documenti.
	*
	* @param codiceAzienda the codice azienda of this descrizioni documenti
	*/
	@Override
	public void setCodiceAzienda(java.lang.String codiceAzienda) {
		_descrizioniDocumenti.setCodiceAzienda(codiceAzienda);
	}

	@Override
	public boolean isNew() {
		return _descrizioniDocumenti.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_descrizioniDocumenti.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _descrizioniDocumenti.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_descrizioniDocumenti.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _descrizioniDocumenti.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _descrizioniDocumenti.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_descrizioniDocumenti.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _descrizioniDocumenti.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_descrizioniDocumenti.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_descrizioniDocumenti.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_descrizioniDocumenti.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DescrizioniDocumentiWrapper((DescrizioniDocumenti)_descrizioniDocumenti.clone());
	}

	@Override
	public int compareTo(
		it.bysoftware.ct.model.DescrizioniDocumenti descrizioniDocumenti) {
		return _descrizioniDocumenti.compareTo(descrizioniDocumenti);
	}

	@Override
	public int hashCode() {
		return _descrizioniDocumenti.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.bysoftware.ct.model.DescrizioniDocumenti> toCacheModel() {
		return _descrizioniDocumenti.toCacheModel();
	}

	@Override
	public it.bysoftware.ct.model.DescrizioniDocumenti toEscapedModel() {
		return new DescrizioniDocumentiWrapper(_descrizioniDocumenti.toEscapedModel());
	}

	@Override
	public it.bysoftware.ct.model.DescrizioniDocumenti toUnescapedModel() {
		return new DescrizioniDocumentiWrapper(_descrizioniDocumenti.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _descrizioniDocumenti.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _descrizioniDocumenti.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_descrizioniDocumenti.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DescrizioniDocumentiWrapper)) {
			return false;
		}

		DescrizioniDocumentiWrapper descrizioniDocumentiWrapper = (DescrizioniDocumentiWrapper)obj;

		if (Validator.equals(_descrizioniDocumenti,
					descrizioniDocumentiWrapper._descrizioniDocumenti)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DescrizioniDocumenti getWrappedDescrizioniDocumenti() {
		return _descrizioniDocumenti;
	}

	@Override
	public DescrizioniDocumenti getWrappedModel() {
		return _descrizioniDocumenti;
	}

	@Override
	public void resetOriginalValues() {
		_descrizioniDocumenti.resetOriginalValues();
	}

	private DescrizioniDocumenti _descrizioniDocumenti;
}
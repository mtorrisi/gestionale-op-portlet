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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CessioneCredito}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CessioneCredito
 * @generated
 */
public class CessioneCreditoWrapper implements CessioneCredito,
	ModelWrapper<CessioneCredito> {
	public CessioneCreditoWrapper(CessioneCredito cessioneCredito) {
		_cessioneCredito = cessioneCredito;
	}

	@Override
	public Class<?> getModelClass() {
		return CessioneCredito.class;
	}

	@Override
	public String getModelClassName() {
		return CessioneCredito.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("data", getData());
		attributes.put("codiceSoggetto", getCodiceSoggetto());
		attributes.put("idAssociato", getIdAssociato());
		attributes.put("idFile", getIdFile());
		attributes.put("anno", getAnno());
		attributes.put("numeroFattura", getNumeroFattura());
		attributes.put("totale", getTotale());
		attributes.put("note", getNote());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Date data = (Date)attributes.get("data");

		if (data != null) {
			setData(data);
		}

		String codiceSoggetto = (String)attributes.get("codiceSoggetto");

		if (codiceSoggetto != null) {
			setCodiceSoggetto(codiceSoggetto);
		}

		Long idAssociato = (Long)attributes.get("idAssociato");

		if (idAssociato != null) {
			setIdAssociato(idAssociato);
		}

		Long idFile = (Long)attributes.get("idFile");

		if (idFile != null) {
			setIdFile(idFile);
		}

		Integer anno = (Integer)attributes.get("anno");

		if (anno != null) {
			setAnno(anno);
		}

		Integer numeroFattura = (Integer)attributes.get("numeroFattura");

		if (numeroFattura != null) {
			setNumeroFattura(numeroFattura);
		}

		Double totale = (Double)attributes.get("totale");

		if (totale != null) {
			setTotale(totale);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}
	}

	/**
	* Returns the primary key of this cessione credito.
	*
	* @return the primary key of this cessione credito
	*/
	@Override
	public long getPrimaryKey() {
		return _cessioneCredito.getPrimaryKey();
	}

	/**
	* Sets the primary key of this cessione credito.
	*
	* @param primaryKey the primary key of this cessione credito
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_cessioneCredito.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this cessione credito.
	*
	* @return the ID of this cessione credito
	*/
	@Override
	public long getId() {
		return _cessioneCredito.getId();
	}

	/**
	* Sets the ID of this cessione credito.
	*
	* @param id the ID of this cessione credito
	*/
	@Override
	public void setId(long id) {
		_cessioneCredito.setId(id);
	}

	/**
	* Returns the data of this cessione credito.
	*
	* @return the data of this cessione credito
	*/
	@Override
	public java.util.Date getData() {
		return _cessioneCredito.getData();
	}

	/**
	* Sets the data of this cessione credito.
	*
	* @param data the data of this cessione credito
	*/
	@Override
	public void setData(java.util.Date data) {
		_cessioneCredito.setData(data);
	}

	/**
	* Returns the codice soggetto of this cessione credito.
	*
	* @return the codice soggetto of this cessione credito
	*/
	@Override
	public java.lang.String getCodiceSoggetto() {
		return _cessioneCredito.getCodiceSoggetto();
	}

	/**
	* Sets the codice soggetto of this cessione credito.
	*
	* @param codiceSoggetto the codice soggetto of this cessione credito
	*/
	@Override
	public void setCodiceSoggetto(java.lang.String codiceSoggetto) {
		_cessioneCredito.setCodiceSoggetto(codiceSoggetto);
	}

	/**
	* Returns the id associato of this cessione credito.
	*
	* @return the id associato of this cessione credito
	*/
	@Override
	public long getIdAssociato() {
		return _cessioneCredito.getIdAssociato();
	}

	/**
	* Sets the id associato of this cessione credito.
	*
	* @param idAssociato the id associato of this cessione credito
	*/
	@Override
	public void setIdAssociato(long idAssociato) {
		_cessioneCredito.setIdAssociato(idAssociato);
	}

	/**
	* Returns the id file of this cessione credito.
	*
	* @return the id file of this cessione credito
	*/
	@Override
	public long getIdFile() {
		return _cessioneCredito.getIdFile();
	}

	/**
	* Sets the id file of this cessione credito.
	*
	* @param idFile the id file of this cessione credito
	*/
	@Override
	public void setIdFile(long idFile) {
		_cessioneCredito.setIdFile(idFile);
	}

	/**
	* Returns the anno of this cessione credito.
	*
	* @return the anno of this cessione credito
	*/
	@Override
	public int getAnno() {
		return _cessioneCredito.getAnno();
	}

	/**
	* Sets the anno of this cessione credito.
	*
	* @param anno the anno of this cessione credito
	*/
	@Override
	public void setAnno(int anno) {
		_cessioneCredito.setAnno(anno);
	}

	/**
	* Returns the numero fattura of this cessione credito.
	*
	* @return the numero fattura of this cessione credito
	*/
	@Override
	public int getNumeroFattura() {
		return _cessioneCredito.getNumeroFattura();
	}

	/**
	* Sets the numero fattura of this cessione credito.
	*
	* @param numeroFattura the numero fattura of this cessione credito
	*/
	@Override
	public void setNumeroFattura(int numeroFattura) {
		_cessioneCredito.setNumeroFattura(numeroFattura);
	}

	/**
	* Returns the totale of this cessione credito.
	*
	* @return the totale of this cessione credito
	*/
	@Override
	public double getTotale() {
		return _cessioneCredito.getTotale();
	}

	/**
	* Sets the totale of this cessione credito.
	*
	* @param totale the totale of this cessione credito
	*/
	@Override
	public void setTotale(double totale) {
		_cessioneCredito.setTotale(totale);
	}

	/**
	* Returns the note of this cessione credito.
	*
	* @return the note of this cessione credito
	*/
	@Override
	public java.lang.String getNote() {
		return _cessioneCredito.getNote();
	}

	/**
	* Sets the note of this cessione credito.
	*
	* @param note the note of this cessione credito
	*/
	@Override
	public void setNote(java.lang.String note) {
		_cessioneCredito.setNote(note);
	}

	@Override
	public boolean isNew() {
		return _cessioneCredito.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_cessioneCredito.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _cessioneCredito.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_cessioneCredito.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _cessioneCredito.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _cessioneCredito.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_cessioneCredito.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _cessioneCredito.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_cessioneCredito.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_cessioneCredito.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_cessioneCredito.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CessioneCreditoWrapper((CessioneCredito)_cessioneCredito.clone());
	}

	@Override
	public int compareTo(it.bysoftware.ct.model.CessioneCredito cessioneCredito) {
		return _cessioneCredito.compareTo(cessioneCredito);
	}

	@Override
	public int hashCode() {
		return _cessioneCredito.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.bysoftware.ct.model.CessioneCredito> toCacheModel() {
		return _cessioneCredito.toCacheModel();
	}

	@Override
	public it.bysoftware.ct.model.CessioneCredito toEscapedModel() {
		return new CessioneCreditoWrapper(_cessioneCredito.toEscapedModel());
	}

	@Override
	public it.bysoftware.ct.model.CessioneCredito toUnescapedModel() {
		return new CessioneCreditoWrapper(_cessioneCredito.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _cessioneCredito.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _cessioneCredito.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_cessioneCredito.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CessioneCreditoWrapper)) {
			return false;
		}

		CessioneCreditoWrapper cessioneCreditoWrapper = (CessioneCreditoWrapper)obj;

		if (Validator.equals(_cessioneCredito,
					cessioneCreditoWrapper._cessioneCredito)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CessioneCredito getWrappedCessioneCredito() {
		return _cessioneCredito;
	}

	@Override
	public CessioneCredito getWrappedModel() {
		return _cessioneCredito;
	}

	@Override
	public void resetOriginalValues() {
		_cessioneCredito.resetOriginalValues();
	}

	private CessioneCredito _cessioneCredito;
}
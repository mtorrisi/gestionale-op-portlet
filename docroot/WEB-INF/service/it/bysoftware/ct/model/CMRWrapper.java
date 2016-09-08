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
 * This class is a wrapper for {@link CMR}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CMR
 * @generated
 */
public class CMRWrapper implements CMR, ModelWrapper<CMR> {
	public CMRWrapper(CMR cmr) {
		_cmr = cmr;
	}

	@Override
	public Class<?> getModelClass() {
		return CMR.class;
	}

	@Override
	public String getModelClassName() {
		return CMR.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("anno", getAnno());
		attributes.put("numeroDocumento", getNumeroDocumento());
		attributes.put("idAssociato", getIdAssociato());
		attributes.put("riserve", getRiserve());
		attributes.put("allegati", getAllegati());
		attributes.put("classe", getClasse());
		attributes.put("cifra", getCifra());
		attributes.put("lettera", getLettera());
		attributes.put("adr", getAdr());
		attributes.put("istruzioni", getIstruzioni());
		attributes.put("convenzioni", getConvenzioni());
		attributes.put("rimborso", getRimborso());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer anno = (Integer)attributes.get("anno");

		if (anno != null) {
			setAnno(anno);
		}

		Long numeroDocumento = (Long)attributes.get("numeroDocumento");

		if (numeroDocumento != null) {
			setNumeroDocumento(numeroDocumento);
		}

		Integer idAssociato = (Integer)attributes.get("idAssociato");

		if (idAssociato != null) {
			setIdAssociato(idAssociato);
		}

		String riserve = (String)attributes.get("riserve");

		if (riserve != null) {
			setRiserve(riserve);
		}

		String allegati = (String)attributes.get("allegati");

		if (allegati != null) {
			setAllegati(allegati);
		}

		String classe = (String)attributes.get("classe");

		if (classe != null) {
			setClasse(classe);
		}

		String cifra = (String)attributes.get("cifra");

		if (cifra != null) {
			setCifra(cifra);
		}

		String lettera = (String)attributes.get("lettera");

		if (lettera != null) {
			setLettera(lettera);
		}

		String adr = (String)attributes.get("adr");

		if (adr != null) {
			setAdr(adr);
		}

		String istruzioni = (String)attributes.get("istruzioni");

		if (istruzioni != null) {
			setIstruzioni(istruzioni);
		}

		String convenzioni = (String)attributes.get("convenzioni");

		if (convenzioni != null) {
			setConvenzioni(convenzioni);
		}

		String rimborso = (String)attributes.get("rimborso");

		if (rimborso != null) {
			setRimborso(rimborso);
		}
	}

	/**
	* Returns the primary key of this c m r.
	*
	* @return the primary key of this c m r
	*/
	@Override
	public it.bysoftware.ct.service.persistence.CMRPK getPrimaryKey() {
		return _cmr.getPrimaryKey();
	}

	/**
	* Sets the primary key of this c m r.
	*
	* @param primaryKey the primary key of this c m r
	*/
	@Override
	public void setPrimaryKey(
		it.bysoftware.ct.service.persistence.CMRPK primaryKey) {
		_cmr.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the anno of this c m r.
	*
	* @return the anno of this c m r
	*/
	@Override
	public int getAnno() {
		return _cmr.getAnno();
	}

	/**
	* Sets the anno of this c m r.
	*
	* @param anno the anno of this c m r
	*/
	@Override
	public void setAnno(int anno) {
		_cmr.setAnno(anno);
	}

	/**
	* Returns the numero documento of this c m r.
	*
	* @return the numero documento of this c m r
	*/
	@Override
	public long getNumeroDocumento() {
		return _cmr.getNumeroDocumento();
	}

	/**
	* Sets the numero documento of this c m r.
	*
	* @param numeroDocumento the numero documento of this c m r
	*/
	@Override
	public void setNumeroDocumento(long numeroDocumento) {
		_cmr.setNumeroDocumento(numeroDocumento);
	}

	/**
	* Returns the id associato of this c m r.
	*
	* @return the id associato of this c m r
	*/
	@Override
	public int getIdAssociato() {
		return _cmr.getIdAssociato();
	}

	/**
	* Sets the id associato of this c m r.
	*
	* @param idAssociato the id associato of this c m r
	*/
	@Override
	public void setIdAssociato(int idAssociato) {
		_cmr.setIdAssociato(idAssociato);
	}

	/**
	* Returns the riserve of this c m r.
	*
	* @return the riserve of this c m r
	*/
	@Override
	public java.lang.String getRiserve() {
		return _cmr.getRiserve();
	}

	/**
	* Sets the riserve of this c m r.
	*
	* @param riserve the riserve of this c m r
	*/
	@Override
	public void setRiserve(java.lang.String riserve) {
		_cmr.setRiserve(riserve);
	}

	/**
	* Returns the allegati of this c m r.
	*
	* @return the allegati of this c m r
	*/
	@Override
	public java.lang.String getAllegati() {
		return _cmr.getAllegati();
	}

	/**
	* Sets the allegati of this c m r.
	*
	* @param allegati the allegati of this c m r
	*/
	@Override
	public void setAllegati(java.lang.String allegati) {
		_cmr.setAllegati(allegati);
	}

	/**
	* Returns the classe of this c m r.
	*
	* @return the classe of this c m r
	*/
	@Override
	public java.lang.String getClasse() {
		return _cmr.getClasse();
	}

	/**
	* Sets the classe of this c m r.
	*
	* @param classe the classe of this c m r
	*/
	@Override
	public void setClasse(java.lang.String classe) {
		_cmr.setClasse(classe);
	}

	/**
	* Returns the cifra of this c m r.
	*
	* @return the cifra of this c m r
	*/
	@Override
	public java.lang.String getCifra() {
		return _cmr.getCifra();
	}

	/**
	* Sets the cifra of this c m r.
	*
	* @param cifra the cifra of this c m r
	*/
	@Override
	public void setCifra(java.lang.String cifra) {
		_cmr.setCifra(cifra);
	}

	/**
	* Returns the lettera of this c m r.
	*
	* @return the lettera of this c m r
	*/
	@Override
	public java.lang.String getLettera() {
		return _cmr.getLettera();
	}

	/**
	* Sets the lettera of this c m r.
	*
	* @param lettera the lettera of this c m r
	*/
	@Override
	public void setLettera(java.lang.String lettera) {
		_cmr.setLettera(lettera);
	}

	/**
	* Returns the adr of this c m r.
	*
	* @return the adr of this c m r
	*/
	@Override
	public java.lang.String getAdr() {
		return _cmr.getAdr();
	}

	/**
	* Sets the adr of this c m r.
	*
	* @param adr the adr of this c m r
	*/
	@Override
	public void setAdr(java.lang.String adr) {
		_cmr.setAdr(adr);
	}

	/**
	* Returns the istruzioni of this c m r.
	*
	* @return the istruzioni of this c m r
	*/
	@Override
	public java.lang.String getIstruzioni() {
		return _cmr.getIstruzioni();
	}

	/**
	* Sets the istruzioni of this c m r.
	*
	* @param istruzioni the istruzioni of this c m r
	*/
	@Override
	public void setIstruzioni(java.lang.String istruzioni) {
		_cmr.setIstruzioni(istruzioni);
	}

	/**
	* Returns the convenzioni of this c m r.
	*
	* @return the convenzioni of this c m r
	*/
	@Override
	public java.lang.String getConvenzioni() {
		return _cmr.getConvenzioni();
	}

	/**
	* Sets the convenzioni of this c m r.
	*
	* @param convenzioni the convenzioni of this c m r
	*/
	@Override
	public void setConvenzioni(java.lang.String convenzioni) {
		_cmr.setConvenzioni(convenzioni);
	}

	/**
	* Returns the rimborso of this c m r.
	*
	* @return the rimborso of this c m r
	*/
	@Override
	public java.lang.String getRimborso() {
		return _cmr.getRimborso();
	}

	/**
	* Sets the rimborso of this c m r.
	*
	* @param rimborso the rimborso of this c m r
	*/
	@Override
	public void setRimborso(java.lang.String rimborso) {
		_cmr.setRimborso(rimborso);
	}

	@Override
	public boolean isNew() {
		return _cmr.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_cmr.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _cmr.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_cmr.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _cmr.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _cmr.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_cmr.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _cmr.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_cmr.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_cmr.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_cmr.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CMRWrapper((CMR)_cmr.clone());
	}

	@Override
	public int compareTo(it.bysoftware.ct.model.CMR cmr) {
		return _cmr.compareTo(cmr);
	}

	@Override
	public int hashCode() {
		return _cmr.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.bysoftware.ct.model.CMR> toCacheModel() {
		return _cmr.toCacheModel();
	}

	@Override
	public it.bysoftware.ct.model.CMR toEscapedModel() {
		return new CMRWrapper(_cmr.toEscapedModel());
	}

	@Override
	public it.bysoftware.ct.model.CMR toUnescapedModel() {
		return new CMRWrapper(_cmr.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _cmr.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _cmr.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_cmr.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CMRWrapper)) {
			return false;
		}

		CMRWrapper cmrWrapper = (CMRWrapper)obj;

		if (Validator.equals(_cmr, cmrWrapper._cmr)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CMR getWrappedCMR() {
		return _cmr;
	}

	@Override
	public CMR getWrappedModel() {
		return _cmr;
	}

	@Override
	public void resetOriginalValues() {
		_cmr.resetOriginalValues();
	}

	private CMR _cmr;
}
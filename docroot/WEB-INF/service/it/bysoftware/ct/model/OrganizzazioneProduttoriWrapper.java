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
 * This class is a wrapper for {@link OrganizzazioneProduttori}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizzazioneProduttori
 * @generated
 */
public class OrganizzazioneProduttoriWrapper implements OrganizzazioneProduttori,
	ModelWrapper<OrganizzazioneProduttori> {
	public OrganizzazioneProduttoriWrapper(
		OrganizzazioneProduttori organizzazioneProduttori) {
		_organizzazioneProduttori = organizzazioneProduttori;
	}

	@Override
	public Class<?> getModelClass() {
		return OrganizzazioneProduttori.class;
	}

	@Override
	public String getModelClassName() {
		return OrganizzazioneProduttori.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("ragioneSociale", getRagioneSociale());
		attributes.put("partitaIVA", getPartitaIVA());
		attributes.put("indirizzo", getIndirizzo());
		attributes.put("telefono", getTelefono());
		attributes.put("fax", getFax());
		attributes.put("sitoWeb", getSitoWeb());
		attributes.put("email", getEmail());
		attributes.put("password", getPassword());
		attributes.put("idLiferay", getIdLiferay());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String ragioneSociale = (String)attributes.get("ragioneSociale");

		if (ragioneSociale != null) {
			setRagioneSociale(ragioneSociale);
		}

		String partitaIVA = (String)attributes.get("partitaIVA");

		if (partitaIVA != null) {
			setPartitaIVA(partitaIVA);
		}

		String indirizzo = (String)attributes.get("indirizzo");

		if (indirizzo != null) {
			setIndirizzo(indirizzo);
		}

		String telefono = (String)attributes.get("telefono");

		if (telefono != null) {
			setTelefono(telefono);
		}

		String fax = (String)attributes.get("fax");

		if (fax != null) {
			setFax(fax);
		}

		String sitoWeb = (String)attributes.get("sitoWeb");

		if (sitoWeb != null) {
			setSitoWeb(sitoWeb);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		Long idLiferay = (Long)attributes.get("idLiferay");

		if (idLiferay != null) {
			setIdLiferay(idLiferay);
		}
	}

	/**
	* Returns the primary key of this organizzazione produttori.
	*
	* @return the primary key of this organizzazione produttori
	*/
	@Override
	public long getPrimaryKey() {
		return _organizzazioneProduttori.getPrimaryKey();
	}

	/**
	* Sets the primary key of this organizzazione produttori.
	*
	* @param primaryKey the primary key of this organizzazione produttori
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_organizzazioneProduttori.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this organizzazione produttori.
	*
	* @return the ID of this organizzazione produttori
	*/
	@Override
	public long getId() {
		return _organizzazioneProduttori.getId();
	}

	/**
	* Sets the ID of this organizzazione produttori.
	*
	* @param id the ID of this organizzazione produttori
	*/
	@Override
	public void setId(long id) {
		_organizzazioneProduttori.setId(id);
	}

	/**
	* Returns the ragione sociale of this organizzazione produttori.
	*
	* @return the ragione sociale of this organizzazione produttori
	*/
	@Override
	public java.lang.String getRagioneSociale() {
		return _organizzazioneProduttori.getRagioneSociale();
	}

	/**
	* Sets the ragione sociale of this organizzazione produttori.
	*
	* @param ragioneSociale the ragione sociale of this organizzazione produttori
	*/
	@Override
	public void setRagioneSociale(java.lang.String ragioneSociale) {
		_organizzazioneProduttori.setRagioneSociale(ragioneSociale);
	}

	/**
	* Returns the partita i v a of this organizzazione produttori.
	*
	* @return the partita i v a of this organizzazione produttori
	*/
	@Override
	public java.lang.String getPartitaIVA() {
		return _organizzazioneProduttori.getPartitaIVA();
	}

	/**
	* Sets the partita i v a of this organizzazione produttori.
	*
	* @param partitaIVA the partita i v a of this organizzazione produttori
	*/
	@Override
	public void setPartitaIVA(java.lang.String partitaIVA) {
		_organizzazioneProduttori.setPartitaIVA(partitaIVA);
	}

	/**
	* Returns the indirizzo of this organizzazione produttori.
	*
	* @return the indirizzo of this organizzazione produttori
	*/
	@Override
	public java.lang.String getIndirizzo() {
		return _organizzazioneProduttori.getIndirizzo();
	}

	/**
	* Sets the indirizzo of this organizzazione produttori.
	*
	* @param indirizzo the indirizzo of this organizzazione produttori
	*/
	@Override
	public void setIndirizzo(java.lang.String indirizzo) {
		_organizzazioneProduttori.setIndirizzo(indirizzo);
	}

	/**
	* Returns the telefono of this organizzazione produttori.
	*
	* @return the telefono of this organizzazione produttori
	*/
	@Override
	public java.lang.String getTelefono() {
		return _organizzazioneProduttori.getTelefono();
	}

	/**
	* Sets the telefono of this organizzazione produttori.
	*
	* @param telefono the telefono of this organizzazione produttori
	*/
	@Override
	public void setTelefono(java.lang.String telefono) {
		_organizzazioneProduttori.setTelefono(telefono);
	}

	/**
	* Returns the fax of this organizzazione produttori.
	*
	* @return the fax of this organizzazione produttori
	*/
	@Override
	public java.lang.String getFax() {
		return _organizzazioneProduttori.getFax();
	}

	/**
	* Sets the fax of this organizzazione produttori.
	*
	* @param fax the fax of this organizzazione produttori
	*/
	@Override
	public void setFax(java.lang.String fax) {
		_organizzazioneProduttori.setFax(fax);
	}

	/**
	* Returns the sito web of this organizzazione produttori.
	*
	* @return the sito web of this organizzazione produttori
	*/
	@Override
	public java.lang.String getSitoWeb() {
		return _organizzazioneProduttori.getSitoWeb();
	}

	/**
	* Sets the sito web of this organizzazione produttori.
	*
	* @param sitoWeb the sito web of this organizzazione produttori
	*/
	@Override
	public void setSitoWeb(java.lang.String sitoWeb) {
		_organizzazioneProduttori.setSitoWeb(sitoWeb);
	}

	/**
	* Returns the email of this organizzazione produttori.
	*
	* @return the email of this organizzazione produttori
	*/
	@Override
	public java.lang.String getEmail() {
		return _organizzazioneProduttori.getEmail();
	}

	/**
	* Sets the email of this organizzazione produttori.
	*
	* @param email the email of this organizzazione produttori
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_organizzazioneProduttori.setEmail(email);
	}

	/**
	* Returns the password of this organizzazione produttori.
	*
	* @return the password of this organizzazione produttori
	*/
	@Override
	public java.lang.String getPassword() {
		return _organizzazioneProduttori.getPassword();
	}

	/**
	* Sets the password of this organizzazione produttori.
	*
	* @param password the password of this organizzazione produttori
	*/
	@Override
	public void setPassword(java.lang.String password) {
		_organizzazioneProduttori.setPassword(password);
	}

	/**
	* Returns the id liferay of this organizzazione produttori.
	*
	* @return the id liferay of this organizzazione produttori
	*/
	@Override
	public long getIdLiferay() {
		return _organizzazioneProduttori.getIdLiferay();
	}

	/**
	* Sets the id liferay of this organizzazione produttori.
	*
	* @param idLiferay the id liferay of this organizzazione produttori
	*/
	@Override
	public void setIdLiferay(long idLiferay) {
		_organizzazioneProduttori.setIdLiferay(idLiferay);
	}

	@Override
	public boolean isNew() {
		return _organizzazioneProduttori.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_organizzazioneProduttori.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _organizzazioneProduttori.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_organizzazioneProduttori.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _organizzazioneProduttori.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _organizzazioneProduttori.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_organizzazioneProduttori.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _organizzazioneProduttori.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_organizzazioneProduttori.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_organizzazioneProduttori.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_organizzazioneProduttori.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OrganizzazioneProduttoriWrapper((OrganizzazioneProduttori)_organizzazioneProduttori.clone());
	}

	@Override
	public int compareTo(
		it.bysoftware.ct.model.OrganizzazioneProduttori organizzazioneProduttori) {
		return _organizzazioneProduttori.compareTo(organizzazioneProduttori);
	}

	@Override
	public int hashCode() {
		return _organizzazioneProduttori.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.bysoftware.ct.model.OrganizzazioneProduttori> toCacheModel() {
		return _organizzazioneProduttori.toCacheModel();
	}

	@Override
	public it.bysoftware.ct.model.OrganizzazioneProduttori toEscapedModel() {
		return new OrganizzazioneProduttoriWrapper(_organizzazioneProduttori.toEscapedModel());
	}

	@Override
	public it.bysoftware.ct.model.OrganizzazioneProduttori toUnescapedModel() {
		return new OrganizzazioneProduttoriWrapper(_organizzazioneProduttori.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _organizzazioneProduttori.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _organizzazioneProduttori.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_organizzazioneProduttori.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OrganizzazioneProduttoriWrapper)) {
			return false;
		}

		OrganizzazioneProduttoriWrapper organizzazioneProduttoriWrapper = (OrganizzazioneProduttoriWrapper)obj;

		if (Validator.equals(_organizzazioneProduttori,
					organizzazioneProduttoriWrapper._organizzazioneProduttori)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public OrganizzazioneProduttori getWrappedOrganizzazioneProduttori() {
		return _organizzazioneProduttori;
	}

	@Override
	public OrganizzazioneProduttori getWrappedModel() {
		return _organizzazioneProduttori;
	}

	@Override
	public void resetOriginalValues() {
		_organizzazioneProduttori.resetOriginalValues();
	}

	private OrganizzazioneProduttori _organizzazioneProduttori;
}
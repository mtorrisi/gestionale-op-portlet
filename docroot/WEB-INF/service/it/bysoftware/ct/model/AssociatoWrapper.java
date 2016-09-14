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
 * This class is a wrapper for {@link Associato}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Associato
 * @generated
 */
public class AssociatoWrapper implements Associato, ModelWrapper<Associato> {
	public AssociatoWrapper(Associato associato) {
		_associato = associato;
	}

	@Override
	public Class<?> getModelClass() {
		return Associato.class;
	}

	@Override
	public String getModelClassName() {
		return Associato.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("centro", getCentro());
		attributes.put("ragioneSociale", getRagioneSociale());
		attributes.put("partitaIVA", getPartitaIVA());
		attributes.put("indirizzo", getIndirizzo());
		attributes.put("comune", getComune());
		attributes.put("telefono", getTelefono());
		attributes.put("fax", getFax());
		attributes.put("nomeUtente", getNomeUtente());
		attributes.put("email", getEmail());
		attributes.put("password", getPassword());
		attributes.put("idLiferay", getIdLiferay());
		attributes.put("idOp", getIdOp());
		attributes.put("attivo", getAttivo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String centro = (String)attributes.get("centro");

		if (centro != null) {
			setCentro(centro);
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

		String comune = (String)attributes.get("comune");

		if (comune != null) {
			setComune(comune);
		}

		String telefono = (String)attributes.get("telefono");

		if (telefono != null) {
			setTelefono(telefono);
		}

		String fax = (String)attributes.get("fax");

		if (fax != null) {
			setFax(fax);
		}

		String nomeUtente = (String)attributes.get("nomeUtente");

		if (nomeUtente != null) {
			setNomeUtente(nomeUtente);
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

		Long idOp = (Long)attributes.get("idOp");

		if (idOp != null) {
			setIdOp(idOp);
		}

		Boolean attivo = (Boolean)attributes.get("attivo");

		if (attivo != null) {
			setAttivo(attivo);
		}
	}

	/**
	* Returns the primary key of this associato.
	*
	* @return the primary key of this associato
	*/
	@Override
	public long getPrimaryKey() {
		return _associato.getPrimaryKey();
	}

	/**
	* Sets the primary key of this associato.
	*
	* @param primaryKey the primary key of this associato
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_associato.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this associato.
	*
	* @return the ID of this associato
	*/
	@Override
	public long getId() {
		return _associato.getId();
	}

	/**
	* Sets the ID of this associato.
	*
	* @param id the ID of this associato
	*/
	@Override
	public void setId(long id) {
		_associato.setId(id);
	}

	/**
	* Returns the centro of this associato.
	*
	* @return the centro of this associato
	*/
	@Override
	public java.lang.String getCentro() {
		return _associato.getCentro();
	}

	/**
	* Sets the centro of this associato.
	*
	* @param centro the centro of this associato
	*/
	@Override
	public void setCentro(java.lang.String centro) {
		_associato.setCentro(centro);
	}

	/**
	* Returns the ragione sociale of this associato.
	*
	* @return the ragione sociale of this associato
	*/
	@Override
	public java.lang.String getRagioneSociale() {
		return _associato.getRagioneSociale();
	}

	/**
	* Sets the ragione sociale of this associato.
	*
	* @param ragioneSociale the ragione sociale of this associato
	*/
	@Override
	public void setRagioneSociale(java.lang.String ragioneSociale) {
		_associato.setRagioneSociale(ragioneSociale);
	}

	/**
	* Returns the partita i v a of this associato.
	*
	* @return the partita i v a of this associato
	*/
	@Override
	public java.lang.String getPartitaIVA() {
		return _associato.getPartitaIVA();
	}

	/**
	* Sets the partita i v a of this associato.
	*
	* @param partitaIVA the partita i v a of this associato
	*/
	@Override
	public void setPartitaIVA(java.lang.String partitaIVA) {
		_associato.setPartitaIVA(partitaIVA);
	}

	/**
	* Returns the indirizzo of this associato.
	*
	* @return the indirizzo of this associato
	*/
	@Override
	public java.lang.String getIndirizzo() {
		return _associato.getIndirizzo();
	}

	/**
	* Sets the indirizzo of this associato.
	*
	* @param indirizzo the indirizzo of this associato
	*/
	@Override
	public void setIndirizzo(java.lang.String indirizzo) {
		_associato.setIndirizzo(indirizzo);
	}

	/**
	* Returns the comune of this associato.
	*
	* @return the comune of this associato
	*/
	@Override
	public java.lang.String getComune() {
		return _associato.getComune();
	}

	/**
	* Sets the comune of this associato.
	*
	* @param comune the comune of this associato
	*/
	@Override
	public void setComune(java.lang.String comune) {
		_associato.setComune(comune);
	}

	/**
	* Returns the telefono of this associato.
	*
	* @return the telefono of this associato
	*/
	@Override
	public java.lang.String getTelefono() {
		return _associato.getTelefono();
	}

	/**
	* Sets the telefono of this associato.
	*
	* @param telefono the telefono of this associato
	*/
	@Override
	public void setTelefono(java.lang.String telefono) {
		_associato.setTelefono(telefono);
	}

	/**
	* Returns the fax of this associato.
	*
	* @return the fax of this associato
	*/
	@Override
	public java.lang.String getFax() {
		return _associato.getFax();
	}

	/**
	* Sets the fax of this associato.
	*
	* @param fax the fax of this associato
	*/
	@Override
	public void setFax(java.lang.String fax) {
		_associato.setFax(fax);
	}

	/**
	* Returns the nome utente of this associato.
	*
	* @return the nome utente of this associato
	*/
	@Override
	public java.lang.String getNomeUtente() {
		return _associato.getNomeUtente();
	}

	/**
	* Sets the nome utente of this associato.
	*
	* @param nomeUtente the nome utente of this associato
	*/
	@Override
	public void setNomeUtente(java.lang.String nomeUtente) {
		_associato.setNomeUtente(nomeUtente);
	}

	/**
	* Returns the email of this associato.
	*
	* @return the email of this associato
	*/
	@Override
	public java.lang.String getEmail() {
		return _associato.getEmail();
	}

	/**
	* Sets the email of this associato.
	*
	* @param email the email of this associato
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_associato.setEmail(email);
	}

	/**
	* Returns the password of this associato.
	*
	* @return the password of this associato
	*/
	@Override
	public java.lang.String getPassword() {
		return _associato.getPassword();
	}

	/**
	* Sets the password of this associato.
	*
	* @param password the password of this associato
	*/
	@Override
	public void setPassword(java.lang.String password) {
		_associato.setPassword(password);
	}

	/**
	* Returns the id liferay of this associato.
	*
	* @return the id liferay of this associato
	*/
	@Override
	public long getIdLiferay() {
		return _associato.getIdLiferay();
	}

	/**
	* Sets the id liferay of this associato.
	*
	* @param idLiferay the id liferay of this associato
	*/
	@Override
	public void setIdLiferay(long idLiferay) {
		_associato.setIdLiferay(idLiferay);
	}

	/**
	* Returns the id op of this associato.
	*
	* @return the id op of this associato
	*/
	@Override
	public long getIdOp() {
		return _associato.getIdOp();
	}

	/**
	* Sets the id op of this associato.
	*
	* @param idOp the id op of this associato
	*/
	@Override
	public void setIdOp(long idOp) {
		_associato.setIdOp(idOp);
	}

	/**
	* Returns the attivo of this associato.
	*
	* @return the attivo of this associato
	*/
	@Override
	public boolean getAttivo() {
		return _associato.getAttivo();
	}

	/**
	* Returns <code>true</code> if this associato is attivo.
	*
	* @return <code>true</code> if this associato is attivo; <code>false</code> otherwise
	*/
	@Override
	public boolean isAttivo() {
		return _associato.isAttivo();
	}

	/**
	* Sets whether this associato is attivo.
	*
	* @param attivo the attivo of this associato
	*/
	@Override
	public void setAttivo(boolean attivo) {
		_associato.setAttivo(attivo);
	}

	@Override
	public boolean isNew() {
		return _associato.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_associato.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _associato.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_associato.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _associato.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _associato.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_associato.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _associato.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_associato.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_associato.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_associato.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AssociatoWrapper((Associato)_associato.clone());
	}

	@Override
	public int compareTo(it.bysoftware.ct.model.Associato associato) {
		return _associato.compareTo(associato);
	}

	@Override
	public int hashCode() {
		return _associato.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.bysoftware.ct.model.Associato> toCacheModel() {
		return _associato.toCacheModel();
	}

	@Override
	public it.bysoftware.ct.model.Associato toEscapedModel() {
		return new AssociatoWrapper(_associato.toEscapedModel());
	}

	@Override
	public it.bysoftware.ct.model.Associato toUnescapedModel() {
		return new AssociatoWrapper(_associato.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _associato.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _associato.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_associato.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AssociatoWrapper)) {
			return false;
		}

		AssociatoWrapper associatoWrapper = (AssociatoWrapper)obj;

		if (Validator.equals(_associato, associatoWrapper._associato)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Associato getWrappedAssociato() {
		return _associato;
	}

	@Override
	public Associato getWrappedModel() {
		return _associato;
	}

	@Override
	public void resetOriginalValues() {
		_associato.resetOriginalValues();
	}

	private Associato _associato;
}
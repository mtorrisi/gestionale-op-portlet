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
 * This class is a wrapper for {@link DestinatariDiversi}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DestinatariDiversi
 * @generated
 */
public class DestinatariDiversiWrapper implements DestinatariDiversi,
	ModelWrapper<DestinatariDiversi> {
	public DestinatariDiversiWrapper(DestinatariDiversi destinatariDiversi) {
		_destinatariDiversi = destinatariDiversi;
	}

	@Override
	public Class<?> getModelClass() {
		return DestinatariDiversi.class;
	}

	@Override
	public String getModelClassName() {
		return DestinatariDiversi.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("codiceAnagrafica", getCodiceAnagrafica());
		attributes.put("codiceRiferimento", getCodiceRiferimento());
		attributes.put("CAP", getCAP());
		attributes.put("comune", getComune());
		attributes.put("indirizzo", getIndirizzo());
		attributes.put("provincia", getProvincia());
		attributes.put("stato", getStato());
		attributes.put("tipoAnagrafica", getTipoAnagrafica());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String codiceAnagrafica = (String)attributes.get("codiceAnagrafica");

		if (codiceAnagrafica != null) {
			setCodiceAnagrafica(codiceAnagrafica);
		}

		String codiceRiferimento = (String)attributes.get("codiceRiferimento");

		if (codiceRiferimento != null) {
			setCodiceRiferimento(codiceRiferimento);
		}

		String CAP = (String)attributes.get("CAP");

		if (CAP != null) {
			setCAP(CAP);
		}

		String comune = (String)attributes.get("comune");

		if (comune != null) {
			setComune(comune);
		}

		String indirizzo = (String)attributes.get("indirizzo");

		if (indirizzo != null) {
			setIndirizzo(indirizzo);
		}

		String provincia = (String)attributes.get("provincia");

		if (provincia != null) {
			setProvincia(provincia);
		}

		String stato = (String)attributes.get("stato");

		if (stato != null) {
			setStato(stato);
		}

		String tipoAnagrafica = (String)attributes.get("tipoAnagrafica");

		if (tipoAnagrafica != null) {
			setTipoAnagrafica(tipoAnagrafica);
		}
	}

	/**
	* Returns the primary key of this destinatari diversi.
	*
	* @return the primary key of this destinatari diversi
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _destinatariDiversi.getPrimaryKey();
	}

	/**
	* Sets the primary key of this destinatari diversi.
	*
	* @param primaryKey the primary key of this destinatari diversi
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_destinatariDiversi.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the codice anagrafica of this destinatari diversi.
	*
	* @return the codice anagrafica of this destinatari diversi
	*/
	@Override
	public java.lang.String getCodiceAnagrafica() {
		return _destinatariDiversi.getCodiceAnagrafica();
	}

	/**
	* Sets the codice anagrafica of this destinatari diversi.
	*
	* @param codiceAnagrafica the codice anagrafica of this destinatari diversi
	*/
	@Override
	public void setCodiceAnagrafica(java.lang.String codiceAnagrafica) {
		_destinatariDiversi.setCodiceAnagrafica(codiceAnagrafica);
	}

	/**
	* Returns the codice riferimento of this destinatari diversi.
	*
	* @return the codice riferimento of this destinatari diversi
	*/
	@Override
	public java.lang.String getCodiceRiferimento() {
		return _destinatariDiversi.getCodiceRiferimento();
	}

	/**
	* Sets the codice riferimento of this destinatari diversi.
	*
	* @param codiceRiferimento the codice riferimento of this destinatari diversi
	*/
	@Override
	public void setCodiceRiferimento(java.lang.String codiceRiferimento) {
		_destinatariDiversi.setCodiceRiferimento(codiceRiferimento);
	}

	/**
	* Returns the c a p of this destinatari diversi.
	*
	* @return the c a p of this destinatari diversi
	*/
	@Override
	public java.lang.String getCAP() {
		return _destinatariDiversi.getCAP();
	}

	/**
	* Sets the c a p of this destinatari diversi.
	*
	* @param CAP the c a p of this destinatari diversi
	*/
	@Override
	public void setCAP(java.lang.String CAP) {
		_destinatariDiversi.setCAP(CAP);
	}

	/**
	* Returns the comune of this destinatari diversi.
	*
	* @return the comune of this destinatari diversi
	*/
	@Override
	public java.lang.String getComune() {
		return _destinatariDiversi.getComune();
	}

	/**
	* Sets the comune of this destinatari diversi.
	*
	* @param comune the comune of this destinatari diversi
	*/
	@Override
	public void setComune(java.lang.String comune) {
		_destinatariDiversi.setComune(comune);
	}

	/**
	* Returns the indirizzo of this destinatari diversi.
	*
	* @return the indirizzo of this destinatari diversi
	*/
	@Override
	public java.lang.String getIndirizzo() {
		return _destinatariDiversi.getIndirizzo();
	}

	/**
	* Sets the indirizzo of this destinatari diversi.
	*
	* @param indirizzo the indirizzo of this destinatari diversi
	*/
	@Override
	public void setIndirizzo(java.lang.String indirizzo) {
		_destinatariDiversi.setIndirizzo(indirizzo);
	}

	/**
	* Returns the provincia of this destinatari diversi.
	*
	* @return the provincia of this destinatari diversi
	*/
	@Override
	public java.lang.String getProvincia() {
		return _destinatariDiversi.getProvincia();
	}

	/**
	* Sets the provincia of this destinatari diversi.
	*
	* @param provincia the provincia of this destinatari diversi
	*/
	@Override
	public void setProvincia(java.lang.String provincia) {
		_destinatariDiversi.setProvincia(provincia);
	}

	/**
	* Returns the stato of this destinatari diversi.
	*
	* @return the stato of this destinatari diversi
	*/
	@Override
	public java.lang.String getStato() {
		return _destinatariDiversi.getStato();
	}

	/**
	* Sets the stato of this destinatari diversi.
	*
	* @param stato the stato of this destinatari diversi
	*/
	@Override
	public void setStato(java.lang.String stato) {
		_destinatariDiversi.setStato(stato);
	}

	/**
	* Returns the tipo anagrafica of this destinatari diversi.
	*
	* @return the tipo anagrafica of this destinatari diversi
	*/
	@Override
	public java.lang.String getTipoAnagrafica() {
		return _destinatariDiversi.getTipoAnagrafica();
	}

	/**
	* Sets the tipo anagrafica of this destinatari diversi.
	*
	* @param tipoAnagrafica the tipo anagrafica of this destinatari diversi
	*/
	@Override
	public void setTipoAnagrafica(java.lang.String tipoAnagrafica) {
		_destinatariDiversi.setTipoAnagrafica(tipoAnagrafica);
	}

	@Override
	public boolean isNew() {
		return _destinatariDiversi.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_destinatariDiversi.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _destinatariDiversi.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_destinatariDiversi.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _destinatariDiversi.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _destinatariDiversi.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_destinatariDiversi.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _destinatariDiversi.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_destinatariDiversi.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_destinatariDiversi.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_destinatariDiversi.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DestinatariDiversiWrapper((DestinatariDiversi)_destinatariDiversi.clone());
	}

	@Override
	public int compareTo(
		it.bysoftware.ct.model.DestinatariDiversi destinatariDiversi) {
		return _destinatariDiversi.compareTo(destinatariDiversi);
	}

	@Override
	public int hashCode() {
		return _destinatariDiversi.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.bysoftware.ct.model.DestinatariDiversi> toCacheModel() {
		return _destinatariDiversi.toCacheModel();
	}

	@Override
	public it.bysoftware.ct.model.DestinatariDiversi toEscapedModel() {
		return new DestinatariDiversiWrapper(_destinatariDiversi.toEscapedModel());
	}

	@Override
	public it.bysoftware.ct.model.DestinatariDiversi toUnescapedModel() {
		return new DestinatariDiversiWrapper(_destinatariDiversi.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _destinatariDiversi.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _destinatariDiversi.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_destinatariDiversi.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DestinatariDiversiWrapper)) {
			return false;
		}

		DestinatariDiversiWrapper destinatariDiversiWrapper = (DestinatariDiversiWrapper)obj;

		if (Validator.equals(_destinatariDiversi,
					destinatariDiversiWrapper._destinatariDiversi)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DestinatariDiversi getWrappedDestinatariDiversi() {
		return _destinatariDiversi;
	}

	@Override
	public DestinatariDiversi getWrappedModel() {
		return _destinatariDiversi;
	}

	@Override
	public void resetOriginalValues() {
		_destinatariDiversi.resetOriginalValues();
	}

	private DestinatariDiversi _destinatariDiversi;
}
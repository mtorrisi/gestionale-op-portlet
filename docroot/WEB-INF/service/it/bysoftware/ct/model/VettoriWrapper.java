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
 * This class is a wrapper for {@link Vettori}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Vettori
 * @generated
 */
public class VettoriWrapper implements Vettori, ModelWrapper<Vettori> {
	public VettoriWrapper(Vettori vettori) {
		_vettori = vettori;
	}

	@Override
	public Class<?> getModelClass() {
		return Vettori.class;
	}

	@Override
	public String getModelClassName() {
		return Vettori.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("albo", getAlbo());
		attributes.put("CAP", getCAP());
		attributes.put("codiceVettore", getCodiceVettore());
		attributes.put("codiceFiscale", getCodiceFiscale());
		attributes.put("codiceRiferimento", getCodiceRiferimento());
		attributes.put("comune", getComune());
		attributes.put("indirizzo", getIndirizzo());
		attributes.put("note", getNote());
		attributes.put("partitaIVA", getPartitaIVA());
		attributes.put("ragioneSociale", getRagioneSociale());
		attributes.put("ragioneSociale2", getRagioneSociale2());
		attributes.put("provincia", getProvincia());
		attributes.put("stato", getStato());
		attributes.put("tipoAnagrafica", getTipoAnagrafica());
		attributes.put("codiceAzienda", getCodiceAzienda());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String albo = (String)attributes.get("albo");

		if (albo != null) {
			setAlbo(albo);
		}

		String CAP = (String)attributes.get("CAP");

		if (CAP != null) {
			setCAP(CAP);
		}

		String codiceVettore = (String)attributes.get("codiceVettore");

		if (codiceVettore != null) {
			setCodiceVettore(codiceVettore);
		}

		String codiceFiscale = (String)attributes.get("codiceFiscale");

		if (codiceFiscale != null) {
			setCodiceFiscale(codiceFiscale);
		}

		String codiceRiferimento = (String)attributes.get("codiceRiferimento");

		if (codiceRiferimento != null) {
			setCodiceRiferimento(codiceRiferimento);
		}

		String comune = (String)attributes.get("comune");

		if (comune != null) {
			setComune(comune);
		}

		String indirizzo = (String)attributes.get("indirizzo");

		if (indirizzo != null) {
			setIndirizzo(indirizzo);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		String partitaIVA = (String)attributes.get("partitaIVA");

		if (partitaIVA != null) {
			setPartitaIVA(partitaIVA);
		}

		String ragioneSociale = (String)attributes.get("ragioneSociale");

		if (ragioneSociale != null) {
			setRagioneSociale(ragioneSociale);
		}

		String ragioneSociale2 = (String)attributes.get("ragioneSociale2");

		if (ragioneSociale2 != null) {
			setRagioneSociale2(ragioneSociale2);
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

		String codiceAzienda = (String)attributes.get("codiceAzienda");

		if (codiceAzienda != null) {
			setCodiceAzienda(codiceAzienda);
		}
	}

	/**
	* Returns the primary key of this vettori.
	*
	* @return the primary key of this vettori
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _vettori.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vettori.
	*
	* @param primaryKey the primary key of this vettori
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_vettori.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the albo of this vettori.
	*
	* @return the albo of this vettori
	*/
	@Override
	public java.lang.String getAlbo() {
		return _vettori.getAlbo();
	}

	/**
	* Sets the albo of this vettori.
	*
	* @param albo the albo of this vettori
	*/
	@Override
	public void setAlbo(java.lang.String albo) {
		_vettori.setAlbo(albo);
	}

	/**
	* Returns the c a p of this vettori.
	*
	* @return the c a p of this vettori
	*/
	@Override
	public java.lang.String getCAP() {
		return _vettori.getCAP();
	}

	/**
	* Sets the c a p of this vettori.
	*
	* @param CAP the c a p of this vettori
	*/
	@Override
	public void setCAP(java.lang.String CAP) {
		_vettori.setCAP(CAP);
	}

	/**
	* Returns the codice vettore of this vettori.
	*
	* @return the codice vettore of this vettori
	*/
	@Override
	public java.lang.String getCodiceVettore() {
		return _vettori.getCodiceVettore();
	}

	/**
	* Sets the codice vettore of this vettori.
	*
	* @param codiceVettore the codice vettore of this vettori
	*/
	@Override
	public void setCodiceVettore(java.lang.String codiceVettore) {
		_vettori.setCodiceVettore(codiceVettore);
	}

	/**
	* Returns the codice fiscale of this vettori.
	*
	* @return the codice fiscale of this vettori
	*/
	@Override
	public java.lang.String getCodiceFiscale() {
		return _vettori.getCodiceFiscale();
	}

	/**
	* Sets the codice fiscale of this vettori.
	*
	* @param codiceFiscale the codice fiscale of this vettori
	*/
	@Override
	public void setCodiceFiscale(java.lang.String codiceFiscale) {
		_vettori.setCodiceFiscale(codiceFiscale);
	}

	/**
	* Returns the codice riferimento of this vettori.
	*
	* @return the codice riferimento of this vettori
	*/
	@Override
	public java.lang.String getCodiceRiferimento() {
		return _vettori.getCodiceRiferimento();
	}

	/**
	* Sets the codice riferimento of this vettori.
	*
	* @param codiceRiferimento the codice riferimento of this vettori
	*/
	@Override
	public void setCodiceRiferimento(java.lang.String codiceRiferimento) {
		_vettori.setCodiceRiferimento(codiceRiferimento);
	}

	/**
	* Returns the comune of this vettori.
	*
	* @return the comune of this vettori
	*/
	@Override
	public java.lang.String getComune() {
		return _vettori.getComune();
	}

	/**
	* Sets the comune of this vettori.
	*
	* @param comune the comune of this vettori
	*/
	@Override
	public void setComune(java.lang.String comune) {
		_vettori.setComune(comune);
	}

	/**
	* Returns the indirizzo of this vettori.
	*
	* @return the indirizzo of this vettori
	*/
	@Override
	public java.lang.String getIndirizzo() {
		return _vettori.getIndirizzo();
	}

	/**
	* Sets the indirizzo of this vettori.
	*
	* @param indirizzo the indirizzo of this vettori
	*/
	@Override
	public void setIndirizzo(java.lang.String indirizzo) {
		_vettori.setIndirizzo(indirizzo);
	}

	/**
	* Returns the note of this vettori.
	*
	* @return the note of this vettori
	*/
	@Override
	public java.lang.String getNote() {
		return _vettori.getNote();
	}

	/**
	* Sets the note of this vettori.
	*
	* @param note the note of this vettori
	*/
	@Override
	public void setNote(java.lang.String note) {
		_vettori.setNote(note);
	}

	/**
	* Returns the partita i v a of this vettori.
	*
	* @return the partita i v a of this vettori
	*/
	@Override
	public java.lang.String getPartitaIVA() {
		return _vettori.getPartitaIVA();
	}

	/**
	* Sets the partita i v a of this vettori.
	*
	* @param partitaIVA the partita i v a of this vettori
	*/
	@Override
	public void setPartitaIVA(java.lang.String partitaIVA) {
		_vettori.setPartitaIVA(partitaIVA);
	}

	/**
	* Returns the ragione sociale of this vettori.
	*
	* @return the ragione sociale of this vettori
	*/
	@Override
	public java.lang.String getRagioneSociale() {
		return _vettori.getRagioneSociale();
	}

	/**
	* Sets the ragione sociale of this vettori.
	*
	* @param ragioneSociale the ragione sociale of this vettori
	*/
	@Override
	public void setRagioneSociale(java.lang.String ragioneSociale) {
		_vettori.setRagioneSociale(ragioneSociale);
	}

	/**
	* Returns the ragione sociale2 of this vettori.
	*
	* @return the ragione sociale2 of this vettori
	*/
	@Override
	public java.lang.String getRagioneSociale2() {
		return _vettori.getRagioneSociale2();
	}

	/**
	* Sets the ragione sociale2 of this vettori.
	*
	* @param ragioneSociale2 the ragione sociale2 of this vettori
	*/
	@Override
	public void setRagioneSociale2(java.lang.String ragioneSociale2) {
		_vettori.setRagioneSociale2(ragioneSociale2);
	}

	/**
	* Returns the provincia of this vettori.
	*
	* @return the provincia of this vettori
	*/
	@Override
	public java.lang.String getProvincia() {
		return _vettori.getProvincia();
	}

	/**
	* Sets the provincia of this vettori.
	*
	* @param provincia the provincia of this vettori
	*/
	@Override
	public void setProvincia(java.lang.String provincia) {
		_vettori.setProvincia(provincia);
	}

	/**
	* Returns the stato of this vettori.
	*
	* @return the stato of this vettori
	*/
	@Override
	public java.lang.String getStato() {
		return _vettori.getStato();
	}

	/**
	* Sets the stato of this vettori.
	*
	* @param stato the stato of this vettori
	*/
	@Override
	public void setStato(java.lang.String stato) {
		_vettori.setStato(stato);
	}

	/**
	* Returns the tipo anagrafica of this vettori.
	*
	* @return the tipo anagrafica of this vettori
	*/
	@Override
	public java.lang.String getTipoAnagrafica() {
		return _vettori.getTipoAnagrafica();
	}

	/**
	* Sets the tipo anagrafica of this vettori.
	*
	* @param tipoAnagrafica the tipo anagrafica of this vettori
	*/
	@Override
	public void setTipoAnagrafica(java.lang.String tipoAnagrafica) {
		_vettori.setTipoAnagrafica(tipoAnagrafica);
	}

	/**
	* Returns the codice azienda of this vettori.
	*
	* @return the codice azienda of this vettori
	*/
	@Override
	public java.lang.String getCodiceAzienda() {
		return _vettori.getCodiceAzienda();
	}

	/**
	* Sets the codice azienda of this vettori.
	*
	* @param codiceAzienda the codice azienda of this vettori
	*/
	@Override
	public void setCodiceAzienda(java.lang.String codiceAzienda) {
		_vettori.setCodiceAzienda(codiceAzienda);
	}

	@Override
	public boolean isNew() {
		return _vettori.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_vettori.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _vettori.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vettori.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _vettori.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _vettori.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vettori.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vettori.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_vettori.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_vettori.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vettori.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VettoriWrapper((Vettori)_vettori.clone());
	}

	@Override
	public int compareTo(Vettori vettori) {
		return _vettori.compareTo(vettori);
	}

	@Override
	public int hashCode() {
		return _vettori.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<Vettori> toCacheModel() {
		return _vettori.toCacheModel();
	}

	@Override
	public Vettori toEscapedModel() {
		return new VettoriWrapper(_vettori.toEscapedModel());
	}

	@Override
	public Vettori toUnescapedModel() {
		return new VettoriWrapper(_vettori.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vettori.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vettori.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vettori.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VettoriWrapper)) {
			return false;
		}

		VettoriWrapper vettoriWrapper = (VettoriWrapper)obj;

		if (Validator.equals(_vettori, vettoriWrapper._vettori)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Vettori getWrappedVettori() {
		return _vettori;
	}

	@Override
	public Vettori getWrappedModel() {
		return _vettori;
	}

	@Override
	public void resetOriginalValues() {
		_vettori.resetOriginalValues();
	}

	private Vettori _vettori;
}
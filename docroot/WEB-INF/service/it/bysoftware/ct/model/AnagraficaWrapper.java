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
 * This class is a wrapper for {@link Anagrafica}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Anagrafica
 * @generated
 */
public class AnagraficaWrapper implements Anagrafica, ModelWrapper<Anagrafica> {
	public AnagraficaWrapper(Anagrafica anagrafica) {
		_anagrafica = anagrafica;
	}

	@Override
	public Class<?> getModelClass() {
		return Anagrafica.class;
	}

	@Override
	public String getModelClassName() {
		return Anagrafica.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("attivoEC", getAttivoEC());
		attributes.put("cap", getCap());
		attributes.put("codiceAnagrafica", getCodiceAnagrafica());
		attributes.put("codiceFiscale", getCodiceFiscale());
		attributes.put("codiceMne", getCodiceMne());
		attributes.put("comune", getComune());
		attributes.put("Indirizzo", getIndirizzo());
		attributes.put("note", getNote());
		attributes.put("partitaIVA", getPartitaIVA());
		attributes.put("ragioneSociale", getRagioneSociale());
		attributes.put("ragioneSocialeAlternativa",
			getRagioneSocialeAlternativa());
		attributes.put("provincia", getProvincia());
		attributes.put("stato", getStato());
		attributes.put("tepefi", getTepefi());
		attributes.put("tipoSoggetto", getTipoSoggetto());
		attributes.put("tipsol", getTipsol());
		attributes.put("codiceAzienda", getCodiceAzienda());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer attivoEC = (Integer)attributes.get("attivoEC");

		if (attivoEC != null) {
			setAttivoEC(attivoEC);
		}

		String cap = (String)attributes.get("cap");

		if (cap != null) {
			setCap(cap);
		}

		String codiceAnagrafica = (String)attributes.get("codiceAnagrafica");

		if (codiceAnagrafica != null) {
			setCodiceAnagrafica(codiceAnagrafica);
		}

		String codiceFiscale = (String)attributes.get("codiceFiscale");

		if (codiceFiscale != null) {
			setCodiceFiscale(codiceFiscale);
		}

		String codiceMne = (String)attributes.get("codiceMne");

		if (codiceMne != null) {
			setCodiceMne(codiceMne);
		}

		String comune = (String)attributes.get("comune");

		if (comune != null) {
			setComune(comune);
		}

		String Indirizzo = (String)attributes.get("Indirizzo");

		if (Indirizzo != null) {
			setIndirizzo(Indirizzo);
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

		String ragioneSocialeAlternativa = (String)attributes.get(
				"ragioneSocialeAlternativa");

		if (ragioneSocialeAlternativa != null) {
			setRagioneSocialeAlternativa(ragioneSocialeAlternativa);
		}

		String provincia = (String)attributes.get("provincia");

		if (provincia != null) {
			setProvincia(provincia);
		}

		String stato = (String)attributes.get("stato");

		if (stato != null) {
			setStato(stato);
		}

		Integer tepefi = (Integer)attributes.get("tepefi");

		if (tepefi != null) {
			setTepefi(tepefi);
		}

		String tipoSoggetto = (String)attributes.get("tipoSoggetto");

		if (tipoSoggetto != null) {
			setTipoSoggetto(tipoSoggetto);
		}

		Integer tipsol = (Integer)attributes.get("tipsol");

		if (tipsol != null) {
			setTipsol(tipsol);
		}

		String codiceAzienda = (String)attributes.get("codiceAzienda");

		if (codiceAzienda != null) {
			setCodiceAzienda(codiceAzienda);
		}
	}

	/**
	* Returns the primary key of this anagrafica.
	*
	* @return the primary key of this anagrafica
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _anagrafica.getPrimaryKey();
	}

	/**
	* Sets the primary key of this anagrafica.
	*
	* @param primaryKey the primary key of this anagrafica
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_anagrafica.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the attivo e c of this anagrafica.
	*
	* @return the attivo e c of this anagrafica
	*/
	@Override
	public int getAttivoEC() {
		return _anagrafica.getAttivoEC();
	}

	/**
	* Sets the attivo e c of this anagrafica.
	*
	* @param attivoEC the attivo e c of this anagrafica
	*/
	@Override
	public void setAttivoEC(int attivoEC) {
		_anagrafica.setAttivoEC(attivoEC);
	}

	/**
	* Returns the cap of this anagrafica.
	*
	* @return the cap of this anagrafica
	*/
	@Override
	public java.lang.String getCap() {
		return _anagrafica.getCap();
	}

	/**
	* Sets the cap of this anagrafica.
	*
	* @param cap the cap of this anagrafica
	*/
	@Override
	public void setCap(java.lang.String cap) {
		_anagrafica.setCap(cap);
	}

	/**
	* Returns the codice anagrafica of this anagrafica.
	*
	* @return the codice anagrafica of this anagrafica
	*/
	@Override
	public java.lang.String getCodiceAnagrafica() {
		return _anagrafica.getCodiceAnagrafica();
	}

	/**
	* Sets the codice anagrafica of this anagrafica.
	*
	* @param codiceAnagrafica the codice anagrafica of this anagrafica
	*/
	@Override
	public void setCodiceAnagrafica(java.lang.String codiceAnagrafica) {
		_anagrafica.setCodiceAnagrafica(codiceAnagrafica);
	}

	/**
	* Returns the codice fiscale of this anagrafica.
	*
	* @return the codice fiscale of this anagrafica
	*/
	@Override
	public java.lang.String getCodiceFiscale() {
		return _anagrafica.getCodiceFiscale();
	}

	/**
	* Sets the codice fiscale of this anagrafica.
	*
	* @param codiceFiscale the codice fiscale of this anagrafica
	*/
	@Override
	public void setCodiceFiscale(java.lang.String codiceFiscale) {
		_anagrafica.setCodiceFiscale(codiceFiscale);
	}

	/**
	* Returns the codice mne of this anagrafica.
	*
	* @return the codice mne of this anagrafica
	*/
	@Override
	public java.lang.String getCodiceMne() {
		return _anagrafica.getCodiceMne();
	}

	/**
	* Sets the codice mne of this anagrafica.
	*
	* @param codiceMne the codice mne of this anagrafica
	*/
	@Override
	public void setCodiceMne(java.lang.String codiceMne) {
		_anagrafica.setCodiceMne(codiceMne);
	}

	/**
	* Returns the comune of this anagrafica.
	*
	* @return the comune of this anagrafica
	*/
	@Override
	public java.lang.String getComune() {
		return _anagrafica.getComune();
	}

	/**
	* Sets the comune of this anagrafica.
	*
	* @param comune the comune of this anagrafica
	*/
	@Override
	public void setComune(java.lang.String comune) {
		_anagrafica.setComune(comune);
	}

	/**
	* Returns the indirizzo of this anagrafica.
	*
	* @return the indirizzo of this anagrafica
	*/
	@Override
	public java.lang.String getIndirizzo() {
		return _anagrafica.getIndirizzo();
	}

	/**
	* Sets the indirizzo of this anagrafica.
	*
	* @param Indirizzo the indirizzo of this anagrafica
	*/
	@Override
	public void setIndirizzo(java.lang.String Indirizzo) {
		_anagrafica.setIndirizzo(Indirizzo);
	}

	/**
	* Returns the note of this anagrafica.
	*
	* @return the note of this anagrafica
	*/
	@Override
	public java.lang.String getNote() {
		return _anagrafica.getNote();
	}

	/**
	* Sets the note of this anagrafica.
	*
	* @param note the note of this anagrafica
	*/
	@Override
	public void setNote(java.lang.String note) {
		_anagrafica.setNote(note);
	}

	/**
	* Returns the partita i v a of this anagrafica.
	*
	* @return the partita i v a of this anagrafica
	*/
	@Override
	public java.lang.String getPartitaIVA() {
		return _anagrafica.getPartitaIVA();
	}

	/**
	* Sets the partita i v a of this anagrafica.
	*
	* @param partitaIVA the partita i v a of this anagrafica
	*/
	@Override
	public void setPartitaIVA(java.lang.String partitaIVA) {
		_anagrafica.setPartitaIVA(partitaIVA);
	}

	/**
	* Returns the ragione sociale of this anagrafica.
	*
	* @return the ragione sociale of this anagrafica
	*/
	@Override
	public java.lang.String getRagioneSociale() {
		return _anagrafica.getRagioneSociale();
	}

	/**
	* Sets the ragione sociale of this anagrafica.
	*
	* @param ragioneSociale the ragione sociale of this anagrafica
	*/
	@Override
	public void setRagioneSociale(java.lang.String ragioneSociale) {
		_anagrafica.setRagioneSociale(ragioneSociale);
	}

	/**
	* Returns the ragione sociale alternativa of this anagrafica.
	*
	* @return the ragione sociale alternativa of this anagrafica
	*/
	@Override
	public java.lang.String getRagioneSocialeAlternativa() {
		return _anagrafica.getRagioneSocialeAlternativa();
	}

	/**
	* Sets the ragione sociale alternativa of this anagrafica.
	*
	* @param ragioneSocialeAlternativa the ragione sociale alternativa of this anagrafica
	*/
	@Override
	public void setRagioneSocialeAlternativa(
		java.lang.String ragioneSocialeAlternativa) {
		_anagrafica.setRagioneSocialeAlternativa(ragioneSocialeAlternativa);
	}

	/**
	* Returns the provincia of this anagrafica.
	*
	* @return the provincia of this anagrafica
	*/
	@Override
	public java.lang.String getProvincia() {
		return _anagrafica.getProvincia();
	}

	/**
	* Sets the provincia of this anagrafica.
	*
	* @param provincia the provincia of this anagrafica
	*/
	@Override
	public void setProvincia(java.lang.String provincia) {
		_anagrafica.setProvincia(provincia);
	}

	/**
	* Returns the stato of this anagrafica.
	*
	* @return the stato of this anagrafica
	*/
	@Override
	public java.lang.String getStato() {
		return _anagrafica.getStato();
	}

	/**
	* Sets the stato of this anagrafica.
	*
	* @param stato the stato of this anagrafica
	*/
	@Override
	public void setStato(java.lang.String stato) {
		_anagrafica.setStato(stato);
	}

	/**
	* Returns the tepefi of this anagrafica.
	*
	* @return the tepefi of this anagrafica
	*/
	@Override
	public int getTepefi() {
		return _anagrafica.getTepefi();
	}

	/**
	* Sets the tepefi of this anagrafica.
	*
	* @param tepefi the tepefi of this anagrafica
	*/
	@Override
	public void setTepefi(int tepefi) {
		_anagrafica.setTepefi(tepefi);
	}

	/**
	* Returns the tipo soggetto of this anagrafica.
	*
	* @return the tipo soggetto of this anagrafica
	*/
	@Override
	public java.lang.String getTipoSoggetto() {
		return _anagrafica.getTipoSoggetto();
	}

	/**
	* Sets the tipo soggetto of this anagrafica.
	*
	* @param tipoSoggetto the tipo soggetto of this anagrafica
	*/
	@Override
	public void setTipoSoggetto(java.lang.String tipoSoggetto) {
		_anagrafica.setTipoSoggetto(tipoSoggetto);
	}

	/**
	* Returns the tipsol of this anagrafica.
	*
	* @return the tipsol of this anagrafica
	*/
	@Override
	public int getTipsol() {
		return _anagrafica.getTipsol();
	}

	/**
	* Sets the tipsol of this anagrafica.
	*
	* @param tipsol the tipsol of this anagrafica
	*/
	@Override
	public void setTipsol(int tipsol) {
		_anagrafica.setTipsol(tipsol);
	}

	/**
	* Returns the codice azienda of this anagrafica.
	*
	* @return the codice azienda of this anagrafica
	*/
	@Override
	public java.lang.String getCodiceAzienda() {
		return _anagrafica.getCodiceAzienda();
	}

	/**
	* Sets the codice azienda of this anagrafica.
	*
	* @param codiceAzienda the codice azienda of this anagrafica
	*/
	@Override
	public void setCodiceAzienda(java.lang.String codiceAzienda) {
		_anagrafica.setCodiceAzienda(codiceAzienda);
	}

	@Override
	public boolean isNew() {
		return _anagrafica.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_anagrafica.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _anagrafica.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_anagrafica.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _anagrafica.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _anagrafica.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_anagrafica.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _anagrafica.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_anagrafica.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_anagrafica.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_anagrafica.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AnagraficaWrapper((Anagrafica)_anagrafica.clone());
	}

	@Override
	public int compareTo(it.bysoftware.ct.model.Anagrafica anagrafica) {
		return _anagrafica.compareTo(anagrafica);
	}

	@Override
	public int hashCode() {
		return _anagrafica.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.bysoftware.ct.model.Anagrafica> toCacheModel() {
		return _anagrafica.toCacheModel();
	}

	@Override
	public it.bysoftware.ct.model.Anagrafica toEscapedModel() {
		return new AnagraficaWrapper(_anagrafica.toEscapedModel());
	}

	@Override
	public it.bysoftware.ct.model.Anagrafica toUnescapedModel() {
		return new AnagraficaWrapper(_anagrafica.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _anagrafica.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _anagrafica.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_anagrafica.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnagraficaWrapper)) {
			return false;
		}

		AnagraficaWrapper anagraficaWrapper = (AnagraficaWrapper)obj;

		if (Validator.equals(_anagrafica, anagraficaWrapper._anagrafica)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Anagrafica getWrappedAnagrafica() {
		return _anagrafica;
	}

	@Override
	public Anagrafica getWrappedModel() {
		return _anagrafica;
	}

	@Override
	public void resetOriginalValues() {
		_anagrafica.resetOriginalValues();
	}

	private Anagrafica _anagrafica;
}
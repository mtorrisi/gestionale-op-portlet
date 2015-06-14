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
 * This class is a wrapper for {@link RigoDocumento}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RigoDocumento
 * @generated
 */
public class RigoDocumentoWrapper implements RigoDocumento,
	ModelWrapper<RigoDocumento> {
	public RigoDocumentoWrapper(RigoDocumento rigoDocumento) {
		_rigoDocumento = rigoDocumento;
	}

	@Override
	public Class<?> getModelClass() {
		return RigoDocumento.class;
	}

	@Override
	public String getModelClassName() {
		return RigoDocumento.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("anno", getAnno());
		attributes.put("numeroOrdine", getNumeroOrdine());
		attributes.put("rigoOrdin", getRigoOrdin());
		attributes.put("descrizioneVariante", getDescrizioneVariante());
		attributes.put("codiceArticolo", getCodiceArticolo());
		attributes.put("descrizione", getDescrizione());
		attributes.put("unitaMisura", getUnitaMisura());
		attributes.put("colli", getColli());
		attributes.put("pesoLordo", getPesoLordo());
		attributes.put("tara", getTara());
		attributes.put("pesoNetto", getPesoNetto());
		attributes.put("prezzo", getPrezzo());
		attributes.put("pedane", getPedane());
		attributes.put("note", getNote());
		attributes.put("totalePesata", getTotalePesata());
		attributes.put("imballo", getImballo());
		attributes.put("gestioneReti", getGestioneReti());
		attributes.put("RtxCl", getRtxCl());
		attributes.put("kgRete", getKgRete());
		attributes.put("lotto", getLotto());
		attributes.put("passaporto", getPassaporto());
		attributes.put("progressivo", getProgressivo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer anno = (Integer)attributes.get("anno");

		if (anno != null) {
			setAnno(anno);
		}

		Integer numeroOrdine = (Integer)attributes.get("numeroOrdine");

		if (numeroOrdine != null) {
			setNumeroOrdine(numeroOrdine);
		}

		Integer rigoOrdin = (Integer)attributes.get("rigoOrdin");

		if (rigoOrdin != null) {
			setRigoOrdin(rigoOrdin);
		}

		String descrizioneVariante = (String)attributes.get(
				"descrizioneVariante");

		if (descrizioneVariante != null) {
			setDescrizioneVariante(descrizioneVariante);
		}

		String codiceArticolo = (String)attributes.get("codiceArticolo");

		if (codiceArticolo != null) {
			setCodiceArticolo(codiceArticolo);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}

		String unitaMisura = (String)attributes.get("unitaMisura");

		if (unitaMisura != null) {
			setUnitaMisura(unitaMisura);
		}

		Integer colli = (Integer)attributes.get("colli");

		if (colli != null) {
			setColli(colli);
		}

		Double pesoLordo = (Double)attributes.get("pesoLordo");

		if (pesoLordo != null) {
			setPesoLordo(pesoLordo);
		}

		Double tara = (Double)attributes.get("tara");

		if (tara != null) {
			setTara(tara);
		}

		Double pesoNetto = (Double)attributes.get("pesoNetto");

		if (pesoNetto != null) {
			setPesoNetto(pesoNetto);
		}

		Double prezzo = (Double)attributes.get("prezzo");

		if (prezzo != null) {
			setPrezzo(prezzo);
		}

		Double pedane = (Double)attributes.get("pedane");

		if (pedane != null) {
			setPedane(pedane);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		Double totalePesata = (Double)attributes.get("totalePesata");

		if (totalePesata != null) {
			setTotalePesata(totalePesata);
		}

		String imballo = (String)attributes.get("imballo");

		if (imballo != null) {
			setImballo(imballo);
		}

		Boolean gestioneReti = (Boolean)attributes.get("gestioneReti");

		if (gestioneReti != null) {
			setGestioneReti(gestioneReti);
		}

		Double RtxCl = (Double)attributes.get("RtxCl");

		if (RtxCl != null) {
			setRtxCl(RtxCl);
		}

		Double kgRete = (Double)attributes.get("kgRete");

		if (kgRete != null) {
			setKgRete(kgRete);
		}

		String lotto = (String)attributes.get("lotto");

		if (lotto != null) {
			setLotto(lotto);
		}

		String passaporto = (String)attributes.get("passaporto");

		if (passaporto != null) {
			setPassaporto(passaporto);
		}

		Integer progressivo = (Integer)attributes.get("progressivo");

		if (progressivo != null) {
			setProgressivo(progressivo);
		}
	}

	/**
	* Returns the primary key of this rigo documento.
	*
	* @return the primary key of this rigo documento
	*/
	@Override
	public it.bysoftware.ct.service.persistence.RigoDocumentoPK getPrimaryKey() {
		return _rigoDocumento.getPrimaryKey();
	}

	/**
	* Sets the primary key of this rigo documento.
	*
	* @param primaryKey the primary key of this rigo documento
	*/
	@Override
	public void setPrimaryKey(
		it.bysoftware.ct.service.persistence.RigoDocumentoPK primaryKey) {
		_rigoDocumento.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the anno of this rigo documento.
	*
	* @return the anno of this rigo documento
	*/
	@Override
	public int getAnno() {
		return _rigoDocumento.getAnno();
	}

	/**
	* Sets the anno of this rigo documento.
	*
	* @param anno the anno of this rigo documento
	*/
	@Override
	public void setAnno(int anno) {
		_rigoDocumento.setAnno(anno);
	}

	/**
	* Returns the numero ordine of this rigo documento.
	*
	* @return the numero ordine of this rigo documento
	*/
	@Override
	public int getNumeroOrdine() {
		return _rigoDocumento.getNumeroOrdine();
	}

	/**
	* Sets the numero ordine of this rigo documento.
	*
	* @param numeroOrdine the numero ordine of this rigo documento
	*/
	@Override
	public void setNumeroOrdine(int numeroOrdine) {
		_rigoDocumento.setNumeroOrdine(numeroOrdine);
	}

	/**
	* Returns the rigo ordin of this rigo documento.
	*
	* @return the rigo ordin of this rigo documento
	*/
	@Override
	public int getRigoOrdin() {
		return _rigoDocumento.getRigoOrdin();
	}

	/**
	* Sets the rigo ordin of this rigo documento.
	*
	* @param rigoOrdin the rigo ordin of this rigo documento
	*/
	@Override
	public void setRigoOrdin(int rigoOrdin) {
		_rigoDocumento.setRigoOrdin(rigoOrdin);
	}

	/**
	* Returns the descrizione variante of this rigo documento.
	*
	* @return the descrizione variante of this rigo documento
	*/
	@Override
	public java.lang.String getDescrizioneVariante() {
		return _rigoDocumento.getDescrizioneVariante();
	}

	/**
	* Sets the descrizione variante of this rigo documento.
	*
	* @param descrizioneVariante the descrizione variante of this rigo documento
	*/
	@Override
	public void setDescrizioneVariante(java.lang.String descrizioneVariante) {
		_rigoDocumento.setDescrizioneVariante(descrizioneVariante);
	}

	/**
	* Returns the codice articolo of this rigo documento.
	*
	* @return the codice articolo of this rigo documento
	*/
	@Override
	public java.lang.String getCodiceArticolo() {
		return _rigoDocumento.getCodiceArticolo();
	}

	/**
	* Sets the codice articolo of this rigo documento.
	*
	* @param codiceArticolo the codice articolo of this rigo documento
	*/
	@Override
	public void setCodiceArticolo(java.lang.String codiceArticolo) {
		_rigoDocumento.setCodiceArticolo(codiceArticolo);
	}

	/**
	* Returns the descrizione of this rigo documento.
	*
	* @return the descrizione of this rigo documento
	*/
	@Override
	public java.lang.String getDescrizione() {
		return _rigoDocumento.getDescrizione();
	}

	/**
	* Sets the descrizione of this rigo documento.
	*
	* @param descrizione the descrizione of this rigo documento
	*/
	@Override
	public void setDescrizione(java.lang.String descrizione) {
		_rigoDocumento.setDescrizione(descrizione);
	}

	/**
	* Returns the unita misura of this rigo documento.
	*
	* @return the unita misura of this rigo documento
	*/
	@Override
	public java.lang.String getUnitaMisura() {
		return _rigoDocumento.getUnitaMisura();
	}

	/**
	* Sets the unita misura of this rigo documento.
	*
	* @param unitaMisura the unita misura of this rigo documento
	*/
	@Override
	public void setUnitaMisura(java.lang.String unitaMisura) {
		_rigoDocumento.setUnitaMisura(unitaMisura);
	}

	/**
	* Returns the colli of this rigo documento.
	*
	* @return the colli of this rigo documento
	*/
	@Override
	public int getColli() {
		return _rigoDocumento.getColli();
	}

	/**
	* Sets the colli of this rigo documento.
	*
	* @param colli the colli of this rigo documento
	*/
	@Override
	public void setColli(int colli) {
		_rigoDocumento.setColli(colli);
	}

	/**
	* Returns the peso lordo of this rigo documento.
	*
	* @return the peso lordo of this rigo documento
	*/
	@Override
	public double getPesoLordo() {
		return _rigoDocumento.getPesoLordo();
	}

	/**
	* Sets the peso lordo of this rigo documento.
	*
	* @param pesoLordo the peso lordo of this rigo documento
	*/
	@Override
	public void setPesoLordo(double pesoLordo) {
		_rigoDocumento.setPesoLordo(pesoLordo);
	}

	/**
	* Returns the tara of this rigo documento.
	*
	* @return the tara of this rigo documento
	*/
	@Override
	public double getTara() {
		return _rigoDocumento.getTara();
	}

	/**
	* Sets the tara of this rigo documento.
	*
	* @param tara the tara of this rigo documento
	*/
	@Override
	public void setTara(double tara) {
		_rigoDocumento.setTara(tara);
	}

	/**
	* Returns the peso netto of this rigo documento.
	*
	* @return the peso netto of this rigo documento
	*/
	@Override
	public double getPesoNetto() {
		return _rigoDocumento.getPesoNetto();
	}

	/**
	* Sets the peso netto of this rigo documento.
	*
	* @param pesoNetto the peso netto of this rigo documento
	*/
	@Override
	public void setPesoNetto(double pesoNetto) {
		_rigoDocumento.setPesoNetto(pesoNetto);
	}

	/**
	* Returns the prezzo of this rigo documento.
	*
	* @return the prezzo of this rigo documento
	*/
	@Override
	public double getPrezzo() {
		return _rigoDocumento.getPrezzo();
	}

	/**
	* Sets the prezzo of this rigo documento.
	*
	* @param prezzo the prezzo of this rigo documento
	*/
	@Override
	public void setPrezzo(double prezzo) {
		_rigoDocumento.setPrezzo(prezzo);
	}

	/**
	* Returns the pedane of this rigo documento.
	*
	* @return the pedane of this rigo documento
	*/
	@Override
	public double getPedane() {
		return _rigoDocumento.getPedane();
	}

	/**
	* Sets the pedane of this rigo documento.
	*
	* @param pedane the pedane of this rigo documento
	*/
	@Override
	public void setPedane(double pedane) {
		_rigoDocumento.setPedane(pedane);
	}

	/**
	* Returns the note of this rigo documento.
	*
	* @return the note of this rigo documento
	*/
	@Override
	public java.lang.String getNote() {
		return _rigoDocumento.getNote();
	}

	/**
	* Sets the note of this rigo documento.
	*
	* @param note the note of this rigo documento
	*/
	@Override
	public void setNote(java.lang.String note) {
		_rigoDocumento.setNote(note);
	}

	/**
	* Returns the totale pesata of this rigo documento.
	*
	* @return the totale pesata of this rigo documento
	*/
	@Override
	public double getTotalePesata() {
		return _rigoDocumento.getTotalePesata();
	}

	/**
	* Sets the totale pesata of this rigo documento.
	*
	* @param totalePesata the totale pesata of this rigo documento
	*/
	@Override
	public void setTotalePesata(double totalePesata) {
		_rigoDocumento.setTotalePesata(totalePesata);
	}

	/**
	* Returns the imballo of this rigo documento.
	*
	* @return the imballo of this rigo documento
	*/
	@Override
	public java.lang.String getImballo() {
		return _rigoDocumento.getImballo();
	}

	/**
	* Sets the imballo of this rigo documento.
	*
	* @param imballo the imballo of this rigo documento
	*/
	@Override
	public void setImballo(java.lang.String imballo) {
		_rigoDocumento.setImballo(imballo);
	}

	/**
	* Returns the gestione reti of this rigo documento.
	*
	* @return the gestione reti of this rigo documento
	*/
	@Override
	public boolean getGestioneReti() {
		return _rigoDocumento.getGestioneReti();
	}

	/**
	* Returns <code>true</code> if this rigo documento is gestione reti.
	*
	* @return <code>true</code> if this rigo documento is gestione reti; <code>false</code> otherwise
	*/
	@Override
	public boolean isGestioneReti() {
		return _rigoDocumento.isGestioneReti();
	}

	/**
	* Sets whether this rigo documento is gestione reti.
	*
	* @param gestioneReti the gestione reti of this rigo documento
	*/
	@Override
	public void setGestioneReti(boolean gestioneReti) {
		_rigoDocumento.setGestioneReti(gestioneReti);
	}

	/**
	* Returns the rtx cl of this rigo documento.
	*
	* @return the rtx cl of this rigo documento
	*/
	@Override
	public double getRtxCl() {
		return _rigoDocumento.getRtxCl();
	}

	/**
	* Sets the rtx cl of this rigo documento.
	*
	* @param RtxCl the rtx cl of this rigo documento
	*/
	@Override
	public void setRtxCl(double RtxCl) {
		_rigoDocumento.setRtxCl(RtxCl);
	}

	/**
	* Returns the kg rete of this rigo documento.
	*
	* @return the kg rete of this rigo documento
	*/
	@Override
	public double getKgRete() {
		return _rigoDocumento.getKgRete();
	}

	/**
	* Sets the kg rete of this rigo documento.
	*
	* @param kgRete the kg rete of this rigo documento
	*/
	@Override
	public void setKgRete(double kgRete) {
		_rigoDocumento.setKgRete(kgRete);
	}

	/**
	* Returns the lotto of this rigo documento.
	*
	* @return the lotto of this rigo documento
	*/
	@Override
	public java.lang.String getLotto() {
		return _rigoDocumento.getLotto();
	}

	/**
	* Sets the lotto of this rigo documento.
	*
	* @param lotto the lotto of this rigo documento
	*/
	@Override
	public void setLotto(java.lang.String lotto) {
		_rigoDocumento.setLotto(lotto);
	}

	/**
	* Returns the passaporto of this rigo documento.
	*
	* @return the passaporto of this rigo documento
	*/
	@Override
	public java.lang.String getPassaporto() {
		return _rigoDocumento.getPassaporto();
	}

	/**
	* Sets the passaporto of this rigo documento.
	*
	* @param passaporto the passaporto of this rigo documento
	*/
	@Override
	public void setPassaporto(java.lang.String passaporto) {
		_rigoDocumento.setPassaporto(passaporto);
	}

	/**
	* Returns the progressivo of this rigo documento.
	*
	* @return the progressivo of this rigo documento
	*/
	@Override
	public int getProgressivo() {
		return _rigoDocumento.getProgressivo();
	}

	/**
	* Sets the progressivo of this rigo documento.
	*
	* @param progressivo the progressivo of this rigo documento
	*/
	@Override
	public void setProgressivo(int progressivo) {
		_rigoDocumento.setProgressivo(progressivo);
	}

	@Override
	public boolean isNew() {
		return _rigoDocumento.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_rigoDocumento.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _rigoDocumento.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_rigoDocumento.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _rigoDocumento.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _rigoDocumento.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_rigoDocumento.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _rigoDocumento.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_rigoDocumento.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_rigoDocumento.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_rigoDocumento.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RigoDocumentoWrapper((RigoDocumento)_rigoDocumento.clone());
	}

	@Override
	public int compareTo(it.bysoftware.ct.model.RigoDocumento rigoDocumento) {
		return _rigoDocumento.compareTo(rigoDocumento);
	}

	@Override
	public int hashCode() {
		return _rigoDocumento.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.bysoftware.ct.model.RigoDocumento> toCacheModel() {
		return _rigoDocumento.toCacheModel();
	}

	@Override
	public it.bysoftware.ct.model.RigoDocumento toEscapedModel() {
		return new RigoDocumentoWrapper(_rigoDocumento.toEscapedModel());
	}

	@Override
	public it.bysoftware.ct.model.RigoDocumento toUnescapedModel() {
		return new RigoDocumentoWrapper(_rigoDocumento.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _rigoDocumento.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _rigoDocumento.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_rigoDocumento.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RigoDocumentoWrapper)) {
			return false;
		}

		RigoDocumentoWrapper rigoDocumentoWrapper = (RigoDocumentoWrapper)obj;

		if (Validator.equals(_rigoDocumento, rigoDocumentoWrapper._rigoDocumento)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public RigoDocumento getWrappedRigoDocumento() {
		return _rigoDocumento;
	}

	@Override
	public RigoDocumento getWrappedModel() {
		return _rigoDocumento;
	}

	@Override
	public void resetOriginalValues() {
		_rigoDocumento.resetOriginalValues();
	}

	private RigoDocumento _rigoDocumento;
}
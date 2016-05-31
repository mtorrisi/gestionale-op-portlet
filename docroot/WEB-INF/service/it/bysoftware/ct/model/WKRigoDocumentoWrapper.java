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
 * This class is a wrapper for {@link WKRigoDocumento}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WKRigoDocumento
 * @generated
 */
public class WKRigoDocumentoWrapper implements WKRigoDocumento,
	ModelWrapper<WKRigoDocumento> {
	public WKRigoDocumentoWrapper(WKRigoDocumento wkRigoDocumento) {
		_wkRigoDocumento = wkRigoDocumento;
	}

	@Override
	public Class<?> getModelClass() {
		return WKRigoDocumento.class;
	}

	@Override
	public String getModelClassName() {
		return WKRigoDocumento.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("anno", getAnno());
		attributes.put("numeroOrdine", getNumeroOrdine());
		attributes.put("rigoOrdine", getRigoOrdine());
		attributes.put("codiceVariante", getCodiceVariante());
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
		attributes.put("sconto1", getSconto1());
		attributes.put("sconto2", getSconto2());
		attributes.put("sconto3", getSconto3());
		attributes.put("tipoDocumento", getTipoDocumento());
		attributes.put("idAssociato", getIdAssociato());
		attributes.put("verificato", getVerificato());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer anno = (Integer)attributes.get("anno");

		if (anno != null) {
			setAnno(anno);
		}

		Long numeroOrdine = (Long)attributes.get("numeroOrdine");

		if (numeroOrdine != null) {
			setNumeroOrdine(numeroOrdine);
		}

		Integer rigoOrdine = (Integer)attributes.get("rigoOrdine");

		if (rigoOrdine != null) {
			setRigoOrdine(rigoOrdine);
		}

		String codiceVariante = (String)attributes.get("codiceVariante");

		if (codiceVariante != null) {
			setCodiceVariante(codiceVariante);
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

		Float sconto1 = (Float)attributes.get("sconto1");

		if (sconto1 != null) {
			setSconto1(sconto1);
		}

		Float sconto2 = (Float)attributes.get("sconto2");

		if (sconto2 != null) {
			setSconto2(sconto2);
		}

		Float sconto3 = (Float)attributes.get("sconto3");

		if (sconto3 != null) {
			setSconto3(sconto3);
		}

		String tipoDocumento = (String)attributes.get("tipoDocumento");

		if (tipoDocumento != null) {
			setTipoDocumento(tipoDocumento);
		}

		Long idAssociato = (Long)attributes.get("idAssociato");

		if (idAssociato != null) {
			setIdAssociato(idAssociato);
		}

		Boolean verificato = (Boolean)attributes.get("verificato");

		if (verificato != null) {
			setVerificato(verificato);
		}
	}

	/**
	* Returns the primary key of this w k rigo documento.
	*
	* @return the primary key of this w k rigo documento
	*/
	@Override
	public it.bysoftware.ct.service.persistence.WKRigoDocumentoPK getPrimaryKey() {
		return _wkRigoDocumento.getPrimaryKey();
	}

	/**
	* Sets the primary key of this w k rigo documento.
	*
	* @param primaryKey the primary key of this w k rigo documento
	*/
	@Override
	public void setPrimaryKey(
		it.bysoftware.ct.service.persistence.WKRigoDocumentoPK primaryKey) {
		_wkRigoDocumento.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the anno of this w k rigo documento.
	*
	* @return the anno of this w k rigo documento
	*/
	@Override
	public int getAnno() {
		return _wkRigoDocumento.getAnno();
	}

	/**
	* Sets the anno of this w k rigo documento.
	*
	* @param anno the anno of this w k rigo documento
	*/
	@Override
	public void setAnno(int anno) {
		_wkRigoDocumento.setAnno(anno);
	}

	/**
	* Returns the numero ordine of this w k rigo documento.
	*
	* @return the numero ordine of this w k rigo documento
	*/
	@Override
	public long getNumeroOrdine() {
		return _wkRigoDocumento.getNumeroOrdine();
	}

	/**
	* Sets the numero ordine of this w k rigo documento.
	*
	* @param numeroOrdine the numero ordine of this w k rigo documento
	*/
	@Override
	public void setNumeroOrdine(long numeroOrdine) {
		_wkRigoDocumento.setNumeroOrdine(numeroOrdine);
	}

	/**
	* Returns the rigo ordine of this w k rigo documento.
	*
	* @return the rigo ordine of this w k rigo documento
	*/
	@Override
	public int getRigoOrdine() {
		return _wkRigoDocumento.getRigoOrdine();
	}

	/**
	* Sets the rigo ordine of this w k rigo documento.
	*
	* @param rigoOrdine the rigo ordine of this w k rigo documento
	*/
	@Override
	public void setRigoOrdine(int rigoOrdine) {
		_wkRigoDocumento.setRigoOrdine(rigoOrdine);
	}

	/**
	* Returns the codice variante of this w k rigo documento.
	*
	* @return the codice variante of this w k rigo documento
	*/
	@Override
	public java.lang.String getCodiceVariante() {
		return _wkRigoDocumento.getCodiceVariante();
	}

	/**
	* Sets the codice variante of this w k rigo documento.
	*
	* @param codiceVariante the codice variante of this w k rigo documento
	*/
	@Override
	public void setCodiceVariante(java.lang.String codiceVariante) {
		_wkRigoDocumento.setCodiceVariante(codiceVariante);
	}

	/**
	* Returns the descrizione variante of this w k rigo documento.
	*
	* @return the descrizione variante of this w k rigo documento
	*/
	@Override
	public java.lang.String getDescrizioneVariante() {
		return _wkRigoDocumento.getDescrizioneVariante();
	}

	/**
	* Sets the descrizione variante of this w k rigo documento.
	*
	* @param descrizioneVariante the descrizione variante of this w k rigo documento
	*/
	@Override
	public void setDescrizioneVariante(java.lang.String descrizioneVariante) {
		_wkRigoDocumento.setDescrizioneVariante(descrizioneVariante);
	}

	/**
	* Returns the codice articolo of this w k rigo documento.
	*
	* @return the codice articolo of this w k rigo documento
	*/
	@Override
	public java.lang.String getCodiceArticolo() {
		return _wkRigoDocumento.getCodiceArticolo();
	}

	/**
	* Sets the codice articolo of this w k rigo documento.
	*
	* @param codiceArticolo the codice articolo of this w k rigo documento
	*/
	@Override
	public void setCodiceArticolo(java.lang.String codiceArticolo) {
		_wkRigoDocumento.setCodiceArticolo(codiceArticolo);
	}

	/**
	* Returns the descrizione of this w k rigo documento.
	*
	* @return the descrizione of this w k rigo documento
	*/
	@Override
	public java.lang.String getDescrizione() {
		return _wkRigoDocumento.getDescrizione();
	}

	/**
	* Sets the descrizione of this w k rigo documento.
	*
	* @param descrizione the descrizione of this w k rigo documento
	*/
	@Override
	public void setDescrizione(java.lang.String descrizione) {
		_wkRigoDocumento.setDescrizione(descrizione);
	}

	/**
	* Returns the unita misura of this w k rigo documento.
	*
	* @return the unita misura of this w k rigo documento
	*/
	@Override
	public java.lang.String getUnitaMisura() {
		return _wkRigoDocumento.getUnitaMisura();
	}

	/**
	* Sets the unita misura of this w k rigo documento.
	*
	* @param unitaMisura the unita misura of this w k rigo documento
	*/
	@Override
	public void setUnitaMisura(java.lang.String unitaMisura) {
		_wkRigoDocumento.setUnitaMisura(unitaMisura);
	}

	/**
	* Returns the colli of this w k rigo documento.
	*
	* @return the colli of this w k rigo documento
	*/
	@Override
	public int getColli() {
		return _wkRigoDocumento.getColli();
	}

	/**
	* Sets the colli of this w k rigo documento.
	*
	* @param colli the colli of this w k rigo documento
	*/
	@Override
	public void setColli(int colli) {
		_wkRigoDocumento.setColli(colli);
	}

	/**
	* Returns the peso lordo of this w k rigo documento.
	*
	* @return the peso lordo of this w k rigo documento
	*/
	@Override
	public double getPesoLordo() {
		return _wkRigoDocumento.getPesoLordo();
	}

	/**
	* Sets the peso lordo of this w k rigo documento.
	*
	* @param pesoLordo the peso lordo of this w k rigo documento
	*/
	@Override
	public void setPesoLordo(double pesoLordo) {
		_wkRigoDocumento.setPesoLordo(pesoLordo);
	}

	/**
	* Returns the tara of this w k rigo documento.
	*
	* @return the tara of this w k rigo documento
	*/
	@Override
	public double getTara() {
		return _wkRigoDocumento.getTara();
	}

	/**
	* Sets the tara of this w k rigo documento.
	*
	* @param tara the tara of this w k rigo documento
	*/
	@Override
	public void setTara(double tara) {
		_wkRigoDocumento.setTara(tara);
	}

	/**
	* Returns the peso netto of this w k rigo documento.
	*
	* @return the peso netto of this w k rigo documento
	*/
	@Override
	public double getPesoNetto() {
		return _wkRigoDocumento.getPesoNetto();
	}

	/**
	* Sets the peso netto of this w k rigo documento.
	*
	* @param pesoNetto the peso netto of this w k rigo documento
	*/
	@Override
	public void setPesoNetto(double pesoNetto) {
		_wkRigoDocumento.setPesoNetto(pesoNetto);
	}

	/**
	* Returns the prezzo of this w k rigo documento.
	*
	* @return the prezzo of this w k rigo documento
	*/
	@Override
	public double getPrezzo() {
		return _wkRigoDocumento.getPrezzo();
	}

	/**
	* Sets the prezzo of this w k rigo documento.
	*
	* @param prezzo the prezzo of this w k rigo documento
	*/
	@Override
	public void setPrezzo(double prezzo) {
		_wkRigoDocumento.setPrezzo(prezzo);
	}

	/**
	* Returns the pedane of this w k rigo documento.
	*
	* @return the pedane of this w k rigo documento
	*/
	@Override
	public double getPedane() {
		return _wkRigoDocumento.getPedane();
	}

	/**
	* Sets the pedane of this w k rigo documento.
	*
	* @param pedane the pedane of this w k rigo documento
	*/
	@Override
	public void setPedane(double pedane) {
		_wkRigoDocumento.setPedane(pedane);
	}

	/**
	* Returns the note of this w k rigo documento.
	*
	* @return the note of this w k rigo documento
	*/
	@Override
	public java.lang.String getNote() {
		return _wkRigoDocumento.getNote();
	}

	/**
	* Sets the note of this w k rigo documento.
	*
	* @param note the note of this w k rigo documento
	*/
	@Override
	public void setNote(java.lang.String note) {
		_wkRigoDocumento.setNote(note);
	}

	/**
	* Returns the totale pesata of this w k rigo documento.
	*
	* @return the totale pesata of this w k rigo documento
	*/
	@Override
	public double getTotalePesata() {
		return _wkRigoDocumento.getTotalePesata();
	}

	/**
	* Sets the totale pesata of this w k rigo documento.
	*
	* @param totalePesata the totale pesata of this w k rigo documento
	*/
	@Override
	public void setTotalePesata(double totalePesata) {
		_wkRigoDocumento.setTotalePesata(totalePesata);
	}

	/**
	* Returns the imballo of this w k rigo documento.
	*
	* @return the imballo of this w k rigo documento
	*/
	@Override
	public java.lang.String getImballo() {
		return _wkRigoDocumento.getImballo();
	}

	/**
	* Sets the imballo of this w k rigo documento.
	*
	* @param imballo the imballo of this w k rigo documento
	*/
	@Override
	public void setImballo(java.lang.String imballo) {
		_wkRigoDocumento.setImballo(imballo);
	}

	/**
	* Returns the gestione reti of this w k rigo documento.
	*
	* @return the gestione reti of this w k rigo documento
	*/
	@Override
	public boolean getGestioneReti() {
		return _wkRigoDocumento.getGestioneReti();
	}

	/**
	* Returns <code>true</code> if this w k rigo documento is gestione reti.
	*
	* @return <code>true</code> if this w k rigo documento is gestione reti; <code>false</code> otherwise
	*/
	@Override
	public boolean isGestioneReti() {
		return _wkRigoDocumento.isGestioneReti();
	}

	/**
	* Sets whether this w k rigo documento is gestione reti.
	*
	* @param gestioneReti the gestione reti of this w k rigo documento
	*/
	@Override
	public void setGestioneReti(boolean gestioneReti) {
		_wkRigoDocumento.setGestioneReti(gestioneReti);
	}

	/**
	* Returns the rtx cl of this w k rigo documento.
	*
	* @return the rtx cl of this w k rigo documento
	*/
	@Override
	public double getRtxCl() {
		return _wkRigoDocumento.getRtxCl();
	}

	/**
	* Sets the rtx cl of this w k rigo documento.
	*
	* @param RtxCl the rtx cl of this w k rigo documento
	*/
	@Override
	public void setRtxCl(double RtxCl) {
		_wkRigoDocumento.setRtxCl(RtxCl);
	}

	/**
	* Returns the kg rete of this w k rigo documento.
	*
	* @return the kg rete of this w k rigo documento
	*/
	@Override
	public double getKgRete() {
		return _wkRigoDocumento.getKgRete();
	}

	/**
	* Sets the kg rete of this w k rigo documento.
	*
	* @param kgRete the kg rete of this w k rigo documento
	*/
	@Override
	public void setKgRete(double kgRete) {
		_wkRigoDocumento.setKgRete(kgRete);
	}

	/**
	* Returns the lotto of this w k rigo documento.
	*
	* @return the lotto of this w k rigo documento
	*/
	@Override
	public java.lang.String getLotto() {
		return _wkRigoDocumento.getLotto();
	}

	/**
	* Sets the lotto of this w k rigo documento.
	*
	* @param lotto the lotto of this w k rigo documento
	*/
	@Override
	public void setLotto(java.lang.String lotto) {
		_wkRigoDocumento.setLotto(lotto);
	}

	/**
	* Returns the passaporto of this w k rigo documento.
	*
	* @return the passaporto of this w k rigo documento
	*/
	@Override
	public java.lang.String getPassaporto() {
		return _wkRigoDocumento.getPassaporto();
	}

	/**
	* Sets the passaporto of this w k rigo documento.
	*
	* @param passaporto the passaporto of this w k rigo documento
	*/
	@Override
	public void setPassaporto(java.lang.String passaporto) {
		_wkRigoDocumento.setPassaporto(passaporto);
	}

	/**
	* Returns the progressivo of this w k rigo documento.
	*
	* @return the progressivo of this w k rigo documento
	*/
	@Override
	public int getProgressivo() {
		return _wkRigoDocumento.getProgressivo();
	}

	/**
	* Sets the progressivo of this w k rigo documento.
	*
	* @param progressivo the progressivo of this w k rigo documento
	*/
	@Override
	public void setProgressivo(int progressivo) {
		_wkRigoDocumento.setProgressivo(progressivo);
	}

	/**
	* Returns the sconto1 of this w k rigo documento.
	*
	* @return the sconto1 of this w k rigo documento
	*/
	@Override
	public float getSconto1() {
		return _wkRigoDocumento.getSconto1();
	}

	/**
	* Sets the sconto1 of this w k rigo documento.
	*
	* @param sconto1 the sconto1 of this w k rigo documento
	*/
	@Override
	public void setSconto1(float sconto1) {
		_wkRigoDocumento.setSconto1(sconto1);
	}

	/**
	* Returns the sconto2 of this w k rigo documento.
	*
	* @return the sconto2 of this w k rigo documento
	*/
	@Override
	public float getSconto2() {
		return _wkRigoDocumento.getSconto2();
	}

	/**
	* Sets the sconto2 of this w k rigo documento.
	*
	* @param sconto2 the sconto2 of this w k rigo documento
	*/
	@Override
	public void setSconto2(float sconto2) {
		_wkRigoDocumento.setSconto2(sconto2);
	}

	/**
	* Returns the sconto3 of this w k rigo documento.
	*
	* @return the sconto3 of this w k rigo documento
	*/
	@Override
	public float getSconto3() {
		return _wkRigoDocumento.getSconto3();
	}

	/**
	* Sets the sconto3 of this w k rigo documento.
	*
	* @param sconto3 the sconto3 of this w k rigo documento
	*/
	@Override
	public void setSconto3(float sconto3) {
		_wkRigoDocumento.setSconto3(sconto3);
	}

	/**
	* Returns the tipo documento of this w k rigo documento.
	*
	* @return the tipo documento of this w k rigo documento
	*/
	@Override
	public java.lang.String getTipoDocumento() {
		return _wkRigoDocumento.getTipoDocumento();
	}

	/**
	* Sets the tipo documento of this w k rigo documento.
	*
	* @param tipoDocumento the tipo documento of this w k rigo documento
	*/
	@Override
	public void setTipoDocumento(java.lang.String tipoDocumento) {
		_wkRigoDocumento.setTipoDocumento(tipoDocumento);
	}

	/**
	* Returns the id associato of this w k rigo documento.
	*
	* @return the id associato of this w k rigo documento
	*/
	@Override
	public long getIdAssociato() {
		return _wkRigoDocumento.getIdAssociato();
	}

	/**
	* Sets the id associato of this w k rigo documento.
	*
	* @param idAssociato the id associato of this w k rigo documento
	*/
	@Override
	public void setIdAssociato(long idAssociato) {
		_wkRigoDocumento.setIdAssociato(idAssociato);
	}

	/**
	* Returns the verificato of this w k rigo documento.
	*
	* @return the verificato of this w k rigo documento
	*/
	@Override
	public boolean getVerificato() {
		return _wkRigoDocumento.getVerificato();
	}

	/**
	* Returns <code>true</code> if this w k rigo documento is verificato.
	*
	* @return <code>true</code> if this w k rigo documento is verificato; <code>false</code> otherwise
	*/
	@Override
	public boolean isVerificato() {
		return _wkRigoDocumento.isVerificato();
	}

	/**
	* Sets whether this w k rigo documento is verificato.
	*
	* @param verificato the verificato of this w k rigo documento
	*/
	@Override
	public void setVerificato(boolean verificato) {
		_wkRigoDocumento.setVerificato(verificato);
	}

	@Override
	public boolean isNew() {
		return _wkRigoDocumento.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_wkRigoDocumento.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _wkRigoDocumento.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_wkRigoDocumento.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _wkRigoDocumento.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _wkRigoDocumento.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_wkRigoDocumento.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _wkRigoDocumento.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_wkRigoDocumento.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_wkRigoDocumento.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_wkRigoDocumento.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WKRigoDocumentoWrapper((WKRigoDocumento)_wkRigoDocumento.clone());
	}

	@Override
	public int compareTo(it.bysoftware.ct.model.WKRigoDocumento wkRigoDocumento) {
		return _wkRigoDocumento.compareTo(wkRigoDocumento);
	}

	@Override
	public int hashCode() {
		return _wkRigoDocumento.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.bysoftware.ct.model.WKRigoDocumento> toCacheModel() {
		return _wkRigoDocumento.toCacheModel();
	}

	@Override
	public it.bysoftware.ct.model.WKRigoDocumento toEscapedModel() {
		return new WKRigoDocumentoWrapper(_wkRigoDocumento.toEscapedModel());
	}

	@Override
	public it.bysoftware.ct.model.WKRigoDocumento toUnescapedModel() {
		return new WKRigoDocumentoWrapper(_wkRigoDocumento.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _wkRigoDocumento.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _wkRigoDocumento.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_wkRigoDocumento.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WKRigoDocumentoWrapper)) {
			return false;
		}

		WKRigoDocumentoWrapper wkRigoDocumentoWrapper = (WKRigoDocumentoWrapper)obj;

		if (Validator.equals(_wkRigoDocumento,
					wkRigoDocumentoWrapper._wkRigoDocumento)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public WKRigoDocumento getWrappedWKRigoDocumento() {
		return _wkRigoDocumento;
	}

	@Override
	public WKRigoDocumento getWrappedModel() {
		return _wkRigoDocumento;
	}

	@Override
	public void resetOriginalValues() {
		_wkRigoDocumento.resetOriginalValues();
	}

	private WKRigoDocumento _wkRigoDocumento;
}
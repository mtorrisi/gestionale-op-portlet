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
 * This class is a wrapper for {@link WKTestataDocumento}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WKTestataDocumento
 * @generated
 */
public class WKTestataDocumentoWrapper implements WKTestataDocumento,
	ModelWrapper<WKTestataDocumento> {
	public WKTestataDocumentoWrapper(WKTestataDocumento wkTestataDocumento) {
		_wkTestataDocumento = wkTestataDocumento;
	}

	@Override
	public Class<?> getModelClass() {
		return WKTestataDocumento.class;
	}

	@Override
	public String getModelClassName() {
		return WKTestataDocumento.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("anno", getAnno());
		attributes.put("numeroOrdine", getNumeroOrdine());
		attributes.put("codiceSoggetto", getCodiceSoggetto());
		attributes.put("dataOrdine", getDataOrdine());
		attributes.put("dataConsegna", getDataConsegna());
		attributes.put("destinazione", getDestinazione());
		attributes.put("codiceDestinazione", getCodiceDestinazione());
		attributes.put("ragioneSociale", getRagioneSociale());
		attributes.put("completo", getCompleto());
		attributes.put("operatore", getOperatore());
		attributes.put("visto", getVisto());
		attributes.put("inviato", getInviato());
		attributes.put("lotto", getLotto());
		attributes.put("tipoDocumento", getTipoDocumento());
		attributes.put("vettore", getVettore());
		attributes.put("autista", getAutista());
		attributes.put("telefono", getTelefono());
		attributes.put("centro", getCentro());
		attributes.put("palletCaricati", getPalletCaricati());
		attributes.put("palletScaricati", getPalletScaricati());
		attributes.put("codiceVettore", getCodiceVettore());
		attributes.put("destinazioneVettore", getDestinazioneVettore());
		attributes.put("nota1", getNota1());
		attributes.put("nota2", getNota2());
		attributes.put("rigoDescrittivo", getRigoDescrittivo());
		attributes.put("vettore2", getVettore2());
		attributes.put("curaTrasporto", getCuraTrasporto());
		attributes.put("aspettoEsteriore", getAspettoEsteriore());
		attributes.put("causaleTrasporto", getCausaleTrasporto());
		attributes.put("porto", getPorto());
		attributes.put("origine", getOrigine());
		attributes.put("numeroPedaneEuro", getNumeroPedaneEuro());
		attributes.put("numeroPedaneNormali", getNumeroPedaneNormali());
		attributes.put("costoTrasporto", getCostoTrasporto());
		attributes.put("totalePedaneOrdine", getTotalePedaneOrdine());
		attributes.put("targaCamion", getTargaCamion());
		attributes.put("targaRimorchio", getTargaRimorchio());
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

		String codiceSoggetto = (String)attributes.get("codiceSoggetto");

		if (codiceSoggetto != null) {
			setCodiceSoggetto(codiceSoggetto);
		}

		String dataOrdine = (String)attributes.get("dataOrdine");

		if (dataOrdine != null) {
			setDataOrdine(dataOrdine);
		}

		String dataConsegna = (String)attributes.get("dataConsegna");

		if (dataConsegna != null) {
			setDataConsegna(dataConsegna);
		}

		String destinazione = (String)attributes.get("destinazione");

		if (destinazione != null) {
			setDestinazione(destinazione);
		}

		String codiceDestinazione = (String)attributes.get("codiceDestinazione");

		if (codiceDestinazione != null) {
			setCodiceDestinazione(codiceDestinazione);
		}

		String ragioneSociale = (String)attributes.get("ragioneSociale");

		if (ragioneSociale != null) {
			setRagioneSociale(ragioneSociale);
		}

		String completo = (String)attributes.get("completo");

		if (completo != null) {
			setCompleto(completo);
		}

		String operatore = (String)attributes.get("operatore");

		if (operatore != null) {
			setOperatore(operatore);
		}

		Integer visto = (Integer)attributes.get("visto");

		if (visto != null) {
			setVisto(visto);
		}

		Integer inviato = (Integer)attributes.get("inviato");

		if (inviato != null) {
			setInviato(inviato);
		}

		String lotto = (String)attributes.get("lotto");

		if (lotto != null) {
			setLotto(lotto);
		}

		String tipoDocumento = (String)attributes.get("tipoDocumento");

		if (tipoDocumento != null) {
			setTipoDocumento(tipoDocumento);
		}

		String vettore = (String)attributes.get("vettore");

		if (vettore != null) {
			setVettore(vettore);
		}

		String autista = (String)attributes.get("autista");

		if (autista != null) {
			setAutista(autista);
		}

		String telefono = (String)attributes.get("telefono");

		if (telefono != null) {
			setTelefono(telefono);
		}

		String centro = (String)attributes.get("centro");

		if (centro != null) {
			setCentro(centro);
		}

		Integer palletCaricati = (Integer)attributes.get("palletCaricati");

		if (palletCaricati != null) {
			setPalletCaricati(palletCaricati);
		}

		Integer palletScaricati = (Integer)attributes.get("palletScaricati");

		if (palletScaricati != null) {
			setPalletScaricati(palletScaricati);
		}

		String codiceVettore = (String)attributes.get("codiceVettore");

		if (codiceVettore != null) {
			setCodiceVettore(codiceVettore);
		}

		String destinazioneVettore = (String)attributes.get(
				"destinazioneVettore");

		if (destinazioneVettore != null) {
			setDestinazioneVettore(destinazioneVettore);
		}

		String nota1 = (String)attributes.get("nota1");

		if (nota1 != null) {
			setNota1(nota1);
		}

		String nota2 = (String)attributes.get("nota2");

		if (nota2 != null) {
			setNota2(nota2);
		}

		String rigoDescrittivo = (String)attributes.get("rigoDescrittivo");

		if (rigoDescrittivo != null) {
			setRigoDescrittivo(rigoDescrittivo);
		}

		String vettore2 = (String)attributes.get("vettore2");

		if (vettore2 != null) {
			setVettore2(vettore2);
		}

		String curaTrasporto = (String)attributes.get("curaTrasporto");

		if (curaTrasporto != null) {
			setCuraTrasporto(curaTrasporto);
		}

		String aspettoEsteriore = (String)attributes.get("aspettoEsteriore");

		if (aspettoEsteriore != null) {
			setAspettoEsteriore(aspettoEsteriore);
		}

		String causaleTrasporto = (String)attributes.get("causaleTrasporto");

		if (causaleTrasporto != null) {
			setCausaleTrasporto(causaleTrasporto);
		}

		String porto = (String)attributes.get("porto");

		if (porto != null) {
			setPorto(porto);
		}

		String origine = (String)attributes.get("origine");

		if (origine != null) {
			setOrigine(origine);
		}

		Integer numeroPedaneEuro = (Integer)attributes.get("numeroPedaneEuro");

		if (numeroPedaneEuro != null) {
			setNumeroPedaneEuro(numeroPedaneEuro);
		}

		Integer numeroPedaneNormali = (Integer)attributes.get(
				"numeroPedaneNormali");

		if (numeroPedaneNormali != null) {
			setNumeroPedaneNormali(numeroPedaneNormali);
		}

		Double costoTrasporto = (Double)attributes.get("costoTrasporto");

		if (costoTrasporto != null) {
			setCostoTrasporto(costoTrasporto);
		}

		Integer totalePedaneOrdine = (Integer)attributes.get(
				"totalePedaneOrdine");

		if (totalePedaneOrdine != null) {
			setTotalePedaneOrdine(totalePedaneOrdine);
		}

		String targaCamion = (String)attributes.get("targaCamion");

		if (targaCamion != null) {
			setTargaCamion(targaCamion);
		}

		String targaRimorchio = (String)attributes.get("targaRimorchio");

		if (targaRimorchio != null) {
			setTargaRimorchio(targaRimorchio);
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
	* Returns the primary key of this w k testata documento.
	*
	* @return the primary key of this w k testata documento
	*/
	@Override
	public it.bysoftware.ct.service.persistence.WKTestataDocumentoPK getPrimaryKey() {
		return _wkTestataDocumento.getPrimaryKey();
	}

	/**
	* Sets the primary key of this w k testata documento.
	*
	* @param primaryKey the primary key of this w k testata documento
	*/
	@Override
	public void setPrimaryKey(
		it.bysoftware.ct.service.persistence.WKTestataDocumentoPK primaryKey) {
		_wkTestataDocumento.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the anno of this w k testata documento.
	*
	* @return the anno of this w k testata documento
	*/
	@Override
	public int getAnno() {
		return _wkTestataDocumento.getAnno();
	}

	/**
	* Sets the anno of this w k testata documento.
	*
	* @param anno the anno of this w k testata documento
	*/
	@Override
	public void setAnno(int anno) {
		_wkTestataDocumento.setAnno(anno);
	}

	/**
	* Returns the numero ordine of this w k testata documento.
	*
	* @return the numero ordine of this w k testata documento
	*/
	@Override
	public long getNumeroOrdine() {
		return _wkTestataDocumento.getNumeroOrdine();
	}

	/**
	* Sets the numero ordine of this w k testata documento.
	*
	* @param numeroOrdine the numero ordine of this w k testata documento
	*/
	@Override
	public void setNumeroOrdine(long numeroOrdine) {
		_wkTestataDocumento.setNumeroOrdine(numeroOrdine);
	}

	/**
	* Returns the codice soggetto of this w k testata documento.
	*
	* @return the codice soggetto of this w k testata documento
	*/
	@Override
	public java.lang.String getCodiceSoggetto() {
		return _wkTestataDocumento.getCodiceSoggetto();
	}

	/**
	* Sets the codice soggetto of this w k testata documento.
	*
	* @param codiceSoggetto the codice soggetto of this w k testata documento
	*/
	@Override
	public void setCodiceSoggetto(java.lang.String codiceSoggetto) {
		_wkTestataDocumento.setCodiceSoggetto(codiceSoggetto);
	}

	/**
	* Returns the data ordine of this w k testata documento.
	*
	* @return the data ordine of this w k testata documento
	*/
	@Override
	public java.lang.String getDataOrdine() {
		return _wkTestataDocumento.getDataOrdine();
	}

	/**
	* Sets the data ordine of this w k testata documento.
	*
	* @param dataOrdine the data ordine of this w k testata documento
	*/
	@Override
	public void setDataOrdine(java.lang.String dataOrdine) {
		_wkTestataDocumento.setDataOrdine(dataOrdine);
	}

	/**
	* Returns the data consegna of this w k testata documento.
	*
	* @return the data consegna of this w k testata documento
	*/
	@Override
	public java.lang.String getDataConsegna() {
		return _wkTestataDocumento.getDataConsegna();
	}

	/**
	* Sets the data consegna of this w k testata documento.
	*
	* @param dataConsegna the data consegna of this w k testata documento
	*/
	@Override
	public void setDataConsegna(java.lang.String dataConsegna) {
		_wkTestataDocumento.setDataConsegna(dataConsegna);
	}

	/**
	* Returns the destinazione of this w k testata documento.
	*
	* @return the destinazione of this w k testata documento
	*/
	@Override
	public java.lang.String getDestinazione() {
		return _wkTestataDocumento.getDestinazione();
	}

	/**
	* Sets the destinazione of this w k testata documento.
	*
	* @param destinazione the destinazione of this w k testata documento
	*/
	@Override
	public void setDestinazione(java.lang.String destinazione) {
		_wkTestataDocumento.setDestinazione(destinazione);
	}

	/**
	* Returns the codice destinazione of this w k testata documento.
	*
	* @return the codice destinazione of this w k testata documento
	*/
	@Override
	public java.lang.String getCodiceDestinazione() {
		return _wkTestataDocumento.getCodiceDestinazione();
	}

	/**
	* Sets the codice destinazione of this w k testata documento.
	*
	* @param codiceDestinazione the codice destinazione of this w k testata documento
	*/
	@Override
	public void setCodiceDestinazione(java.lang.String codiceDestinazione) {
		_wkTestataDocumento.setCodiceDestinazione(codiceDestinazione);
	}

	/**
	* Returns the ragione sociale of this w k testata documento.
	*
	* @return the ragione sociale of this w k testata documento
	*/
	@Override
	public java.lang.String getRagioneSociale() {
		return _wkTestataDocumento.getRagioneSociale();
	}

	/**
	* Sets the ragione sociale of this w k testata documento.
	*
	* @param ragioneSociale the ragione sociale of this w k testata documento
	*/
	@Override
	public void setRagioneSociale(java.lang.String ragioneSociale) {
		_wkTestataDocumento.setRagioneSociale(ragioneSociale);
	}

	/**
	* Returns the completo of this w k testata documento.
	*
	* @return the completo of this w k testata documento
	*/
	@Override
	public java.lang.String getCompleto() {
		return _wkTestataDocumento.getCompleto();
	}

	/**
	* Sets the completo of this w k testata documento.
	*
	* @param completo the completo of this w k testata documento
	*/
	@Override
	public void setCompleto(java.lang.String completo) {
		_wkTestataDocumento.setCompleto(completo);
	}

	/**
	* Returns the operatore of this w k testata documento.
	*
	* @return the operatore of this w k testata documento
	*/
	@Override
	public java.lang.String getOperatore() {
		return _wkTestataDocumento.getOperatore();
	}

	/**
	* Sets the operatore of this w k testata documento.
	*
	* @param operatore the operatore of this w k testata documento
	*/
	@Override
	public void setOperatore(java.lang.String operatore) {
		_wkTestataDocumento.setOperatore(operatore);
	}

	/**
	* Returns the visto of this w k testata documento.
	*
	* @return the visto of this w k testata documento
	*/
	@Override
	public int getVisto() {
		return _wkTestataDocumento.getVisto();
	}

	/**
	* Sets the visto of this w k testata documento.
	*
	* @param visto the visto of this w k testata documento
	*/
	@Override
	public void setVisto(int visto) {
		_wkTestataDocumento.setVisto(visto);
	}

	/**
	* Returns the inviato of this w k testata documento.
	*
	* @return the inviato of this w k testata documento
	*/
	@Override
	public int getInviato() {
		return _wkTestataDocumento.getInviato();
	}

	/**
	* Sets the inviato of this w k testata documento.
	*
	* @param inviato the inviato of this w k testata documento
	*/
	@Override
	public void setInviato(int inviato) {
		_wkTestataDocumento.setInviato(inviato);
	}

	/**
	* Returns the lotto of this w k testata documento.
	*
	* @return the lotto of this w k testata documento
	*/
	@Override
	public java.lang.String getLotto() {
		return _wkTestataDocumento.getLotto();
	}

	/**
	* Sets the lotto of this w k testata documento.
	*
	* @param lotto the lotto of this w k testata documento
	*/
	@Override
	public void setLotto(java.lang.String lotto) {
		_wkTestataDocumento.setLotto(lotto);
	}

	/**
	* Returns the tipo documento of this w k testata documento.
	*
	* @return the tipo documento of this w k testata documento
	*/
	@Override
	public java.lang.String getTipoDocumento() {
		return _wkTestataDocumento.getTipoDocumento();
	}

	/**
	* Sets the tipo documento of this w k testata documento.
	*
	* @param tipoDocumento the tipo documento of this w k testata documento
	*/
	@Override
	public void setTipoDocumento(java.lang.String tipoDocumento) {
		_wkTestataDocumento.setTipoDocumento(tipoDocumento);
	}

	/**
	* Returns the vettore of this w k testata documento.
	*
	* @return the vettore of this w k testata documento
	*/
	@Override
	public java.lang.String getVettore() {
		return _wkTestataDocumento.getVettore();
	}

	/**
	* Sets the vettore of this w k testata documento.
	*
	* @param vettore the vettore of this w k testata documento
	*/
	@Override
	public void setVettore(java.lang.String vettore) {
		_wkTestataDocumento.setVettore(vettore);
	}

	/**
	* Returns the autista of this w k testata documento.
	*
	* @return the autista of this w k testata documento
	*/
	@Override
	public java.lang.String getAutista() {
		return _wkTestataDocumento.getAutista();
	}

	/**
	* Sets the autista of this w k testata documento.
	*
	* @param autista the autista of this w k testata documento
	*/
	@Override
	public void setAutista(java.lang.String autista) {
		_wkTestataDocumento.setAutista(autista);
	}

	/**
	* Returns the telefono of this w k testata documento.
	*
	* @return the telefono of this w k testata documento
	*/
	@Override
	public java.lang.String getTelefono() {
		return _wkTestataDocumento.getTelefono();
	}

	/**
	* Sets the telefono of this w k testata documento.
	*
	* @param telefono the telefono of this w k testata documento
	*/
	@Override
	public void setTelefono(java.lang.String telefono) {
		_wkTestataDocumento.setTelefono(telefono);
	}

	/**
	* Returns the centro of this w k testata documento.
	*
	* @return the centro of this w k testata documento
	*/
	@Override
	public java.lang.String getCentro() {
		return _wkTestataDocumento.getCentro();
	}

	/**
	* Sets the centro of this w k testata documento.
	*
	* @param centro the centro of this w k testata documento
	*/
	@Override
	public void setCentro(java.lang.String centro) {
		_wkTestataDocumento.setCentro(centro);
	}

	/**
	* Returns the pallet caricati of this w k testata documento.
	*
	* @return the pallet caricati of this w k testata documento
	*/
	@Override
	public int getPalletCaricati() {
		return _wkTestataDocumento.getPalletCaricati();
	}

	/**
	* Sets the pallet caricati of this w k testata documento.
	*
	* @param palletCaricati the pallet caricati of this w k testata documento
	*/
	@Override
	public void setPalletCaricati(int palletCaricati) {
		_wkTestataDocumento.setPalletCaricati(palletCaricati);
	}

	/**
	* Returns the pallet scaricati of this w k testata documento.
	*
	* @return the pallet scaricati of this w k testata documento
	*/
	@Override
	public int getPalletScaricati() {
		return _wkTestataDocumento.getPalletScaricati();
	}

	/**
	* Sets the pallet scaricati of this w k testata documento.
	*
	* @param palletScaricati the pallet scaricati of this w k testata documento
	*/
	@Override
	public void setPalletScaricati(int palletScaricati) {
		_wkTestataDocumento.setPalletScaricati(palletScaricati);
	}

	/**
	* Returns the codice vettore of this w k testata documento.
	*
	* @return the codice vettore of this w k testata documento
	*/
	@Override
	public java.lang.String getCodiceVettore() {
		return _wkTestataDocumento.getCodiceVettore();
	}

	/**
	* Sets the codice vettore of this w k testata documento.
	*
	* @param codiceVettore the codice vettore of this w k testata documento
	*/
	@Override
	public void setCodiceVettore(java.lang.String codiceVettore) {
		_wkTestataDocumento.setCodiceVettore(codiceVettore);
	}

	/**
	* Returns the destinazione vettore of this w k testata documento.
	*
	* @return the destinazione vettore of this w k testata documento
	*/
	@Override
	public java.lang.String getDestinazioneVettore() {
		return _wkTestataDocumento.getDestinazioneVettore();
	}

	/**
	* Sets the destinazione vettore of this w k testata documento.
	*
	* @param destinazioneVettore the destinazione vettore of this w k testata documento
	*/
	@Override
	public void setDestinazioneVettore(java.lang.String destinazioneVettore) {
		_wkTestataDocumento.setDestinazioneVettore(destinazioneVettore);
	}

	/**
	* Returns the nota1 of this w k testata documento.
	*
	* @return the nota1 of this w k testata documento
	*/
	@Override
	public java.lang.String getNota1() {
		return _wkTestataDocumento.getNota1();
	}

	/**
	* Sets the nota1 of this w k testata documento.
	*
	* @param nota1 the nota1 of this w k testata documento
	*/
	@Override
	public void setNota1(java.lang.String nota1) {
		_wkTestataDocumento.setNota1(nota1);
	}

	/**
	* Returns the nota2 of this w k testata documento.
	*
	* @return the nota2 of this w k testata documento
	*/
	@Override
	public java.lang.String getNota2() {
		return _wkTestataDocumento.getNota2();
	}

	/**
	* Sets the nota2 of this w k testata documento.
	*
	* @param nota2 the nota2 of this w k testata documento
	*/
	@Override
	public void setNota2(java.lang.String nota2) {
		_wkTestataDocumento.setNota2(nota2);
	}

	/**
	* Returns the rigo descrittivo of this w k testata documento.
	*
	* @return the rigo descrittivo of this w k testata documento
	*/
	@Override
	public java.lang.String getRigoDescrittivo() {
		return _wkTestataDocumento.getRigoDescrittivo();
	}

	/**
	* Sets the rigo descrittivo of this w k testata documento.
	*
	* @param rigoDescrittivo the rigo descrittivo of this w k testata documento
	*/
	@Override
	public void setRigoDescrittivo(java.lang.String rigoDescrittivo) {
		_wkTestataDocumento.setRigoDescrittivo(rigoDescrittivo);
	}

	/**
	* Returns the vettore2 of this w k testata documento.
	*
	* @return the vettore2 of this w k testata documento
	*/
	@Override
	public java.lang.String getVettore2() {
		return _wkTestataDocumento.getVettore2();
	}

	/**
	* Sets the vettore2 of this w k testata documento.
	*
	* @param vettore2 the vettore2 of this w k testata documento
	*/
	@Override
	public void setVettore2(java.lang.String vettore2) {
		_wkTestataDocumento.setVettore2(vettore2);
	}

	/**
	* Returns the cura trasporto of this w k testata documento.
	*
	* @return the cura trasporto of this w k testata documento
	*/
	@Override
	public java.lang.String getCuraTrasporto() {
		return _wkTestataDocumento.getCuraTrasporto();
	}

	/**
	* Sets the cura trasporto of this w k testata documento.
	*
	* @param curaTrasporto the cura trasporto of this w k testata documento
	*/
	@Override
	public void setCuraTrasporto(java.lang.String curaTrasporto) {
		_wkTestataDocumento.setCuraTrasporto(curaTrasporto);
	}

	/**
	* Returns the aspetto esteriore of this w k testata documento.
	*
	* @return the aspetto esteriore of this w k testata documento
	*/
	@Override
	public java.lang.String getAspettoEsteriore() {
		return _wkTestataDocumento.getAspettoEsteriore();
	}

	/**
	* Sets the aspetto esteriore of this w k testata documento.
	*
	* @param aspettoEsteriore the aspetto esteriore of this w k testata documento
	*/
	@Override
	public void setAspettoEsteriore(java.lang.String aspettoEsteriore) {
		_wkTestataDocumento.setAspettoEsteriore(aspettoEsteriore);
	}

	/**
	* Returns the causale trasporto of this w k testata documento.
	*
	* @return the causale trasporto of this w k testata documento
	*/
	@Override
	public java.lang.String getCausaleTrasporto() {
		return _wkTestataDocumento.getCausaleTrasporto();
	}

	/**
	* Sets the causale trasporto of this w k testata documento.
	*
	* @param causaleTrasporto the causale trasporto of this w k testata documento
	*/
	@Override
	public void setCausaleTrasporto(java.lang.String causaleTrasporto) {
		_wkTestataDocumento.setCausaleTrasporto(causaleTrasporto);
	}

	/**
	* Returns the porto of this w k testata documento.
	*
	* @return the porto of this w k testata documento
	*/
	@Override
	public java.lang.String getPorto() {
		return _wkTestataDocumento.getPorto();
	}

	/**
	* Sets the porto of this w k testata documento.
	*
	* @param porto the porto of this w k testata documento
	*/
	@Override
	public void setPorto(java.lang.String porto) {
		_wkTestataDocumento.setPorto(porto);
	}

	/**
	* Returns the origine of this w k testata documento.
	*
	* @return the origine of this w k testata documento
	*/
	@Override
	public java.lang.String getOrigine() {
		return _wkTestataDocumento.getOrigine();
	}

	/**
	* Sets the origine of this w k testata documento.
	*
	* @param origine the origine of this w k testata documento
	*/
	@Override
	public void setOrigine(java.lang.String origine) {
		_wkTestataDocumento.setOrigine(origine);
	}

	/**
	* Returns the numero pedane euro of this w k testata documento.
	*
	* @return the numero pedane euro of this w k testata documento
	*/
	@Override
	public int getNumeroPedaneEuro() {
		return _wkTestataDocumento.getNumeroPedaneEuro();
	}

	/**
	* Sets the numero pedane euro of this w k testata documento.
	*
	* @param numeroPedaneEuro the numero pedane euro of this w k testata documento
	*/
	@Override
	public void setNumeroPedaneEuro(int numeroPedaneEuro) {
		_wkTestataDocumento.setNumeroPedaneEuro(numeroPedaneEuro);
	}

	/**
	* Returns the numero pedane normali of this w k testata documento.
	*
	* @return the numero pedane normali of this w k testata documento
	*/
	@Override
	public int getNumeroPedaneNormali() {
		return _wkTestataDocumento.getNumeroPedaneNormali();
	}

	/**
	* Sets the numero pedane normali of this w k testata documento.
	*
	* @param numeroPedaneNormali the numero pedane normali of this w k testata documento
	*/
	@Override
	public void setNumeroPedaneNormali(int numeroPedaneNormali) {
		_wkTestataDocumento.setNumeroPedaneNormali(numeroPedaneNormali);
	}

	/**
	* Returns the costo trasporto of this w k testata documento.
	*
	* @return the costo trasporto of this w k testata documento
	*/
	@Override
	public double getCostoTrasporto() {
		return _wkTestataDocumento.getCostoTrasporto();
	}

	/**
	* Sets the costo trasporto of this w k testata documento.
	*
	* @param costoTrasporto the costo trasporto of this w k testata documento
	*/
	@Override
	public void setCostoTrasporto(double costoTrasporto) {
		_wkTestataDocumento.setCostoTrasporto(costoTrasporto);
	}

	/**
	* Returns the totale pedane ordine of this w k testata documento.
	*
	* @return the totale pedane ordine of this w k testata documento
	*/
	@Override
	public int getTotalePedaneOrdine() {
		return _wkTestataDocumento.getTotalePedaneOrdine();
	}

	/**
	* Sets the totale pedane ordine of this w k testata documento.
	*
	* @param totalePedaneOrdine the totale pedane ordine of this w k testata documento
	*/
	@Override
	public void setTotalePedaneOrdine(int totalePedaneOrdine) {
		_wkTestataDocumento.setTotalePedaneOrdine(totalePedaneOrdine);
	}

	/**
	* Returns the targa camion of this w k testata documento.
	*
	* @return the targa camion of this w k testata documento
	*/
	@Override
	public java.lang.String getTargaCamion() {
		return _wkTestataDocumento.getTargaCamion();
	}

	/**
	* Sets the targa camion of this w k testata documento.
	*
	* @param targaCamion the targa camion of this w k testata documento
	*/
	@Override
	public void setTargaCamion(java.lang.String targaCamion) {
		_wkTestataDocumento.setTargaCamion(targaCamion);
	}

	/**
	* Returns the targa rimorchio of this w k testata documento.
	*
	* @return the targa rimorchio of this w k testata documento
	*/
	@Override
	public java.lang.String getTargaRimorchio() {
		return _wkTestataDocumento.getTargaRimorchio();
	}

	/**
	* Sets the targa rimorchio of this w k testata documento.
	*
	* @param targaRimorchio the targa rimorchio of this w k testata documento
	*/
	@Override
	public void setTargaRimorchio(java.lang.String targaRimorchio) {
		_wkTestataDocumento.setTargaRimorchio(targaRimorchio);
	}

	/**
	* Returns the id associato of this w k testata documento.
	*
	* @return the id associato of this w k testata documento
	*/
	@Override
	public long getIdAssociato() {
		return _wkTestataDocumento.getIdAssociato();
	}

	/**
	* Sets the id associato of this w k testata documento.
	*
	* @param idAssociato the id associato of this w k testata documento
	*/
	@Override
	public void setIdAssociato(long idAssociato) {
		_wkTestataDocumento.setIdAssociato(idAssociato);
	}

	/**
	* Returns the verificato of this w k testata documento.
	*
	* @return the verificato of this w k testata documento
	*/
	@Override
	public boolean getVerificato() {
		return _wkTestataDocumento.getVerificato();
	}

	/**
	* Returns <code>true</code> if this w k testata documento is verificato.
	*
	* @return <code>true</code> if this w k testata documento is verificato; <code>false</code> otherwise
	*/
	@Override
	public boolean isVerificato() {
		return _wkTestataDocumento.isVerificato();
	}

	/**
	* Sets whether this w k testata documento is verificato.
	*
	* @param verificato the verificato of this w k testata documento
	*/
	@Override
	public void setVerificato(boolean verificato) {
		_wkTestataDocumento.setVerificato(verificato);
	}

	@Override
	public boolean isNew() {
		return _wkTestataDocumento.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_wkTestataDocumento.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _wkTestataDocumento.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_wkTestataDocumento.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _wkTestataDocumento.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _wkTestataDocumento.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_wkTestataDocumento.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _wkTestataDocumento.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_wkTestataDocumento.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_wkTestataDocumento.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_wkTestataDocumento.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WKTestataDocumentoWrapper((WKTestataDocumento)_wkTestataDocumento.clone());
	}

	@Override
	public int compareTo(
		it.bysoftware.ct.model.WKTestataDocumento wkTestataDocumento) {
		return _wkTestataDocumento.compareTo(wkTestataDocumento);
	}

	@Override
	public int hashCode() {
		return _wkTestataDocumento.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.bysoftware.ct.model.WKTestataDocumento> toCacheModel() {
		return _wkTestataDocumento.toCacheModel();
	}

	@Override
	public it.bysoftware.ct.model.WKTestataDocumento toEscapedModel() {
		return new WKTestataDocumentoWrapper(_wkTestataDocumento.toEscapedModel());
	}

	@Override
	public it.bysoftware.ct.model.WKTestataDocumento toUnescapedModel() {
		return new WKTestataDocumentoWrapper(_wkTestataDocumento.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _wkTestataDocumento.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _wkTestataDocumento.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_wkTestataDocumento.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WKTestataDocumentoWrapper)) {
			return false;
		}

		WKTestataDocumentoWrapper wkTestataDocumentoWrapper = (WKTestataDocumentoWrapper)obj;

		if (Validator.equals(_wkTestataDocumento,
					wkTestataDocumentoWrapper._wkTestataDocumento)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public WKTestataDocumento getWrappedWKTestataDocumento() {
		return _wkTestataDocumento;
	}

	@Override
	public WKTestataDocumento getWrappedModel() {
		return _wkTestataDocumento;
	}

	@Override
	public void resetOriginalValues() {
		_wkTestataDocumento.resetOriginalValues();
	}

	private WKTestataDocumento _wkTestataDocumento;
}
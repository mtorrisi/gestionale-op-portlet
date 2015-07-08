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
 * This class is a wrapper for {@link TestataDocumento}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TestataDocumento
 * @generated
 */
public class TestataDocumentoWrapper implements TestataDocumento,
	ModelWrapper<TestataDocumento> {
	public TestataDocumentoWrapper(TestataDocumento testataDocumento) {
		_testataDocumento = testataDocumento;
	}

	@Override
	public Class<?> getModelClass() {
		return TestataDocumento.class;
	}

	@Override
	public String getModelClassName() {
		return TestataDocumento.class.getName();
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
		attributes.put("tipoDocumeto", getTipoDocumeto());
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
		attributes.put("curaTrasoirto", getCuraTrasoirto());
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

		Integer codiceDestinazione = (Integer)attributes.get(
				"codiceDestinazione");

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

		String tipoDocumeto = (String)attributes.get("tipoDocumeto");

		if (tipoDocumeto != null) {
			setTipoDocumeto(tipoDocumeto);
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

		String curaTrasoirto = (String)attributes.get("curaTrasoirto");

		if (curaTrasoirto != null) {
			setCuraTrasoirto(curaTrasoirto);
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
	}

	/**
	* Returns the primary key of this testata documento.
	*
	* @return the primary key of this testata documento
	*/
	@Override
	public it.bysoftware.ct.service.persistence.TestataDocumentoPK getPrimaryKey() {
		return _testataDocumento.getPrimaryKey();
	}

	/**
	* Sets the primary key of this testata documento.
	*
	* @param primaryKey the primary key of this testata documento
	*/
	@Override
	public void setPrimaryKey(
		it.bysoftware.ct.service.persistence.TestataDocumentoPK primaryKey) {
		_testataDocumento.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the anno of this testata documento.
	*
	* @return the anno of this testata documento
	*/
	@Override
	public int getAnno() {
		return _testataDocumento.getAnno();
	}

	/**
	* Sets the anno of this testata documento.
	*
	* @param anno the anno of this testata documento
	*/
	@Override
	public void setAnno(int anno) {
		_testataDocumento.setAnno(anno);
	}

	/**
	* Returns the numero ordine of this testata documento.
	*
	* @return the numero ordine of this testata documento
	*/
	@Override
	public int getNumeroOrdine() {
		return _testataDocumento.getNumeroOrdine();
	}

	/**
	* Sets the numero ordine of this testata documento.
	*
	* @param numeroOrdine the numero ordine of this testata documento
	*/
	@Override
	public void setNumeroOrdine(int numeroOrdine) {
		_testataDocumento.setNumeroOrdine(numeroOrdine);
	}

	/**
	* Returns the codice soggetto of this testata documento.
	*
	* @return the codice soggetto of this testata documento
	*/
	@Override
	public java.lang.String getCodiceSoggetto() {
		return _testataDocumento.getCodiceSoggetto();
	}

	/**
	* Sets the codice soggetto of this testata documento.
	*
	* @param codiceSoggetto the codice soggetto of this testata documento
	*/
	@Override
	public void setCodiceSoggetto(java.lang.String codiceSoggetto) {
		_testataDocumento.setCodiceSoggetto(codiceSoggetto);
	}

	/**
	* Returns the data ordine of this testata documento.
	*
	* @return the data ordine of this testata documento
	*/
	@Override
	public java.lang.String getDataOrdine() {
		return _testataDocumento.getDataOrdine();
	}

	/**
	* Sets the data ordine of this testata documento.
	*
	* @param dataOrdine the data ordine of this testata documento
	*/
	@Override
	public void setDataOrdine(java.lang.String dataOrdine) {
		_testataDocumento.setDataOrdine(dataOrdine);
	}

	/**
	* Returns the data consegna of this testata documento.
	*
	* @return the data consegna of this testata documento
	*/
	@Override
	public java.lang.String getDataConsegna() {
		return _testataDocumento.getDataConsegna();
	}

	/**
	* Sets the data consegna of this testata documento.
	*
	* @param dataConsegna the data consegna of this testata documento
	*/
	@Override
	public void setDataConsegna(java.lang.String dataConsegna) {
		_testataDocumento.setDataConsegna(dataConsegna);
	}

	/**
	* Returns the destinazione of this testata documento.
	*
	* @return the destinazione of this testata documento
	*/
	@Override
	public java.lang.String getDestinazione() {
		return _testataDocumento.getDestinazione();
	}

	/**
	* Sets the destinazione of this testata documento.
	*
	* @param destinazione the destinazione of this testata documento
	*/
	@Override
	public void setDestinazione(java.lang.String destinazione) {
		_testataDocumento.setDestinazione(destinazione);
	}

	/**
	* Returns the codice destinazione of this testata documento.
	*
	* @return the codice destinazione of this testata documento
	*/
	@Override
	public int getCodiceDestinazione() {
		return _testataDocumento.getCodiceDestinazione();
	}

	/**
	* Sets the codice destinazione of this testata documento.
	*
	* @param codiceDestinazione the codice destinazione of this testata documento
	*/
	@Override
	public void setCodiceDestinazione(int codiceDestinazione) {
		_testataDocumento.setCodiceDestinazione(codiceDestinazione);
	}

	/**
	* Returns the ragione sociale of this testata documento.
	*
	* @return the ragione sociale of this testata documento
	*/
	@Override
	public java.lang.String getRagioneSociale() {
		return _testataDocumento.getRagioneSociale();
	}

	/**
	* Sets the ragione sociale of this testata documento.
	*
	* @param ragioneSociale the ragione sociale of this testata documento
	*/
	@Override
	public void setRagioneSociale(java.lang.String ragioneSociale) {
		_testataDocumento.setRagioneSociale(ragioneSociale);
	}

	/**
	* Returns the completo of this testata documento.
	*
	* @return the completo of this testata documento
	*/
	@Override
	public java.lang.String getCompleto() {
		return _testataDocumento.getCompleto();
	}

	/**
	* Sets the completo of this testata documento.
	*
	* @param completo the completo of this testata documento
	*/
	@Override
	public void setCompleto(java.lang.String completo) {
		_testataDocumento.setCompleto(completo);
	}

	/**
	* Returns the operatore of this testata documento.
	*
	* @return the operatore of this testata documento
	*/
	@Override
	public java.lang.String getOperatore() {
		return _testataDocumento.getOperatore();
	}

	/**
	* Sets the operatore of this testata documento.
	*
	* @param operatore the operatore of this testata documento
	*/
	@Override
	public void setOperatore(java.lang.String operatore) {
		_testataDocumento.setOperatore(operatore);
	}

	/**
	* Returns the visto of this testata documento.
	*
	* @return the visto of this testata documento
	*/
	@Override
	public int getVisto() {
		return _testataDocumento.getVisto();
	}

	/**
	* Sets the visto of this testata documento.
	*
	* @param visto the visto of this testata documento
	*/
	@Override
	public void setVisto(int visto) {
		_testataDocumento.setVisto(visto);
	}

	/**
	* Returns the inviato of this testata documento.
	*
	* @return the inviato of this testata documento
	*/
	@Override
	public int getInviato() {
		return _testataDocumento.getInviato();
	}

	/**
	* Sets the inviato of this testata documento.
	*
	* @param inviato the inviato of this testata documento
	*/
	@Override
	public void setInviato(int inviato) {
		_testataDocumento.setInviato(inviato);
	}

	/**
	* Returns the lotto of this testata documento.
	*
	* @return the lotto of this testata documento
	*/
	@Override
	public java.lang.String getLotto() {
		return _testataDocumento.getLotto();
	}

	/**
	* Sets the lotto of this testata documento.
	*
	* @param lotto the lotto of this testata documento
	*/
	@Override
	public void setLotto(java.lang.String lotto) {
		_testataDocumento.setLotto(lotto);
	}

	/**
	* Returns the tipo documeto of this testata documento.
	*
	* @return the tipo documeto of this testata documento
	*/
	@Override
	public java.lang.String getTipoDocumeto() {
		return _testataDocumento.getTipoDocumeto();
	}

	/**
	* Sets the tipo documeto of this testata documento.
	*
	* @param tipoDocumeto the tipo documeto of this testata documento
	*/
	@Override
	public void setTipoDocumeto(java.lang.String tipoDocumeto) {
		_testataDocumento.setTipoDocumeto(tipoDocumeto);
	}

	/**
	* Returns the vettore of this testata documento.
	*
	* @return the vettore of this testata documento
	*/
	@Override
	public java.lang.String getVettore() {
		return _testataDocumento.getVettore();
	}

	/**
	* Sets the vettore of this testata documento.
	*
	* @param vettore the vettore of this testata documento
	*/
	@Override
	public void setVettore(java.lang.String vettore) {
		_testataDocumento.setVettore(vettore);
	}

	/**
	* Returns the autista of this testata documento.
	*
	* @return the autista of this testata documento
	*/
	@Override
	public java.lang.String getAutista() {
		return _testataDocumento.getAutista();
	}

	/**
	* Sets the autista of this testata documento.
	*
	* @param autista the autista of this testata documento
	*/
	@Override
	public void setAutista(java.lang.String autista) {
		_testataDocumento.setAutista(autista);
	}

	/**
	* Returns the telefono of this testata documento.
	*
	* @return the telefono of this testata documento
	*/
	@Override
	public java.lang.String getTelefono() {
		return _testataDocumento.getTelefono();
	}

	/**
	* Sets the telefono of this testata documento.
	*
	* @param telefono the telefono of this testata documento
	*/
	@Override
	public void setTelefono(java.lang.String telefono) {
		_testataDocumento.setTelefono(telefono);
	}

	/**
	* Returns the centro of this testata documento.
	*
	* @return the centro of this testata documento
	*/
	@Override
	public java.lang.String getCentro() {
		return _testataDocumento.getCentro();
	}

	/**
	* Sets the centro of this testata documento.
	*
	* @param centro the centro of this testata documento
	*/
	@Override
	public void setCentro(java.lang.String centro) {
		_testataDocumento.setCentro(centro);
	}

	/**
	* Returns the pallet caricati of this testata documento.
	*
	* @return the pallet caricati of this testata documento
	*/
	@Override
	public int getPalletCaricati() {
		return _testataDocumento.getPalletCaricati();
	}

	/**
	* Sets the pallet caricati of this testata documento.
	*
	* @param palletCaricati the pallet caricati of this testata documento
	*/
	@Override
	public void setPalletCaricati(int palletCaricati) {
		_testataDocumento.setPalletCaricati(palletCaricati);
	}

	/**
	* Returns the pallet scaricati of this testata documento.
	*
	* @return the pallet scaricati of this testata documento
	*/
	@Override
	public int getPalletScaricati() {
		return _testataDocumento.getPalletScaricati();
	}

	/**
	* Sets the pallet scaricati of this testata documento.
	*
	* @param palletScaricati the pallet scaricati of this testata documento
	*/
	@Override
	public void setPalletScaricati(int palletScaricati) {
		_testataDocumento.setPalletScaricati(palletScaricati);
	}

	/**
	* Returns the codice vettore of this testata documento.
	*
	* @return the codice vettore of this testata documento
	*/
	@Override
	public java.lang.String getCodiceVettore() {
		return _testataDocumento.getCodiceVettore();
	}

	/**
	* Sets the codice vettore of this testata documento.
	*
	* @param codiceVettore the codice vettore of this testata documento
	*/
	@Override
	public void setCodiceVettore(java.lang.String codiceVettore) {
		_testataDocumento.setCodiceVettore(codiceVettore);
	}

	/**
	* Returns the destinazione vettore of this testata documento.
	*
	* @return the destinazione vettore of this testata documento
	*/
	@Override
	public java.lang.String getDestinazioneVettore() {
		return _testataDocumento.getDestinazioneVettore();
	}

	/**
	* Sets the destinazione vettore of this testata documento.
	*
	* @param destinazioneVettore the destinazione vettore of this testata documento
	*/
	@Override
	public void setDestinazioneVettore(java.lang.String destinazioneVettore) {
		_testataDocumento.setDestinazioneVettore(destinazioneVettore);
	}

	/**
	* Returns the nota1 of this testata documento.
	*
	* @return the nota1 of this testata documento
	*/
	@Override
	public java.lang.String getNota1() {
		return _testataDocumento.getNota1();
	}

	/**
	* Sets the nota1 of this testata documento.
	*
	* @param nota1 the nota1 of this testata documento
	*/
	@Override
	public void setNota1(java.lang.String nota1) {
		_testataDocumento.setNota1(nota1);
	}

	/**
	* Returns the nota2 of this testata documento.
	*
	* @return the nota2 of this testata documento
	*/
	@Override
	public java.lang.String getNota2() {
		return _testataDocumento.getNota2();
	}

	/**
	* Sets the nota2 of this testata documento.
	*
	* @param nota2 the nota2 of this testata documento
	*/
	@Override
	public void setNota2(java.lang.String nota2) {
		_testataDocumento.setNota2(nota2);
	}

	/**
	* Returns the rigo descrittivo of this testata documento.
	*
	* @return the rigo descrittivo of this testata documento
	*/
	@Override
	public java.lang.String getRigoDescrittivo() {
		return _testataDocumento.getRigoDescrittivo();
	}

	/**
	* Sets the rigo descrittivo of this testata documento.
	*
	* @param rigoDescrittivo the rigo descrittivo of this testata documento
	*/
	@Override
	public void setRigoDescrittivo(java.lang.String rigoDescrittivo) {
		_testataDocumento.setRigoDescrittivo(rigoDescrittivo);
	}

	/**
	* Returns the vettore2 of this testata documento.
	*
	* @return the vettore2 of this testata documento
	*/
	@Override
	public java.lang.String getVettore2() {
		return _testataDocumento.getVettore2();
	}

	/**
	* Sets the vettore2 of this testata documento.
	*
	* @param vettore2 the vettore2 of this testata documento
	*/
	@Override
	public void setVettore2(java.lang.String vettore2) {
		_testataDocumento.setVettore2(vettore2);
	}

	/**
	* Returns the cura trasoirto of this testata documento.
	*
	* @return the cura trasoirto of this testata documento
	*/
	@Override
	public java.lang.String getCuraTrasoirto() {
		return _testataDocumento.getCuraTrasoirto();
	}

	/**
	* Sets the cura trasoirto of this testata documento.
	*
	* @param curaTrasoirto the cura trasoirto of this testata documento
	*/
	@Override
	public void setCuraTrasoirto(java.lang.String curaTrasoirto) {
		_testataDocumento.setCuraTrasoirto(curaTrasoirto);
	}

	/**
	* Returns the aspetto esteriore of this testata documento.
	*
	* @return the aspetto esteriore of this testata documento
	*/
	@Override
	public java.lang.String getAspettoEsteriore() {
		return _testataDocumento.getAspettoEsteriore();
	}

	/**
	* Sets the aspetto esteriore of this testata documento.
	*
	* @param aspettoEsteriore the aspetto esteriore of this testata documento
	*/
	@Override
	public void setAspettoEsteriore(java.lang.String aspettoEsteriore) {
		_testataDocumento.setAspettoEsteriore(aspettoEsteriore);
	}

	/**
	* Returns the causale trasporto of this testata documento.
	*
	* @return the causale trasporto of this testata documento
	*/
	@Override
	public java.lang.String getCausaleTrasporto() {
		return _testataDocumento.getCausaleTrasporto();
	}

	/**
	* Sets the causale trasporto of this testata documento.
	*
	* @param causaleTrasporto the causale trasporto of this testata documento
	*/
	@Override
	public void setCausaleTrasporto(java.lang.String causaleTrasporto) {
		_testataDocumento.setCausaleTrasporto(causaleTrasporto);
	}

	/**
	* Returns the porto of this testata documento.
	*
	* @return the porto of this testata documento
	*/
	@Override
	public java.lang.String getPorto() {
		return _testataDocumento.getPorto();
	}

	/**
	* Sets the porto of this testata documento.
	*
	* @param porto the porto of this testata documento
	*/
	@Override
	public void setPorto(java.lang.String porto) {
		_testataDocumento.setPorto(porto);
	}

	/**
	* Returns the origine of this testata documento.
	*
	* @return the origine of this testata documento
	*/
	@Override
	public java.lang.String getOrigine() {
		return _testataDocumento.getOrigine();
	}

	/**
	* Sets the origine of this testata documento.
	*
	* @param origine the origine of this testata documento
	*/
	@Override
	public void setOrigine(java.lang.String origine) {
		_testataDocumento.setOrigine(origine);
	}

	/**
	* Returns the numero pedane euro of this testata documento.
	*
	* @return the numero pedane euro of this testata documento
	*/
	@Override
	public int getNumeroPedaneEuro() {
		return _testataDocumento.getNumeroPedaneEuro();
	}

	/**
	* Sets the numero pedane euro of this testata documento.
	*
	* @param numeroPedaneEuro the numero pedane euro of this testata documento
	*/
	@Override
	public void setNumeroPedaneEuro(int numeroPedaneEuro) {
		_testataDocumento.setNumeroPedaneEuro(numeroPedaneEuro);
	}

	/**
	* Returns the numero pedane normali of this testata documento.
	*
	* @return the numero pedane normali of this testata documento
	*/
	@Override
	public int getNumeroPedaneNormali() {
		return _testataDocumento.getNumeroPedaneNormali();
	}

	/**
	* Sets the numero pedane normali of this testata documento.
	*
	* @param numeroPedaneNormali the numero pedane normali of this testata documento
	*/
	@Override
	public void setNumeroPedaneNormali(int numeroPedaneNormali) {
		_testataDocumento.setNumeroPedaneNormali(numeroPedaneNormali);
	}

	/**
	* Returns the costo trasporto of this testata documento.
	*
	* @return the costo trasporto of this testata documento
	*/
	@Override
	public double getCostoTrasporto() {
		return _testataDocumento.getCostoTrasporto();
	}

	/**
	* Sets the costo trasporto of this testata documento.
	*
	* @param costoTrasporto the costo trasporto of this testata documento
	*/
	@Override
	public void setCostoTrasporto(double costoTrasporto) {
		_testataDocumento.setCostoTrasporto(costoTrasporto);
	}

	/**
	* Returns the totale pedane ordine of this testata documento.
	*
	* @return the totale pedane ordine of this testata documento
	*/
	@Override
	public int getTotalePedaneOrdine() {
		return _testataDocumento.getTotalePedaneOrdine();
	}

	/**
	* Sets the totale pedane ordine of this testata documento.
	*
	* @param totalePedaneOrdine the totale pedane ordine of this testata documento
	*/
	@Override
	public void setTotalePedaneOrdine(int totalePedaneOrdine) {
		_testataDocumento.setTotalePedaneOrdine(totalePedaneOrdine);
	}

	/**
	* Returns the targa camion of this testata documento.
	*
	* @return the targa camion of this testata documento
	*/
	@Override
	public java.lang.String getTargaCamion() {
		return _testataDocumento.getTargaCamion();
	}

	/**
	* Sets the targa camion of this testata documento.
	*
	* @param targaCamion the targa camion of this testata documento
	*/
	@Override
	public void setTargaCamion(java.lang.String targaCamion) {
		_testataDocumento.setTargaCamion(targaCamion);
	}

	/**
	* Returns the targa rimorchio of this testata documento.
	*
	* @return the targa rimorchio of this testata documento
	*/
	@Override
	public java.lang.String getTargaRimorchio() {
		return _testataDocumento.getTargaRimorchio();
	}

	/**
	* Sets the targa rimorchio of this testata documento.
	*
	* @param targaRimorchio the targa rimorchio of this testata documento
	*/
	@Override
	public void setTargaRimorchio(java.lang.String targaRimorchio) {
		_testataDocumento.setTargaRimorchio(targaRimorchio);
	}

	@Override
	public boolean isNew() {
		return _testataDocumento.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_testataDocumento.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _testataDocumento.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_testataDocumento.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _testataDocumento.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _testataDocumento.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_testataDocumento.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _testataDocumento.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_testataDocumento.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_testataDocumento.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_testataDocumento.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TestataDocumentoWrapper((TestataDocumento)_testataDocumento.clone());
	}

	@Override
	public int compareTo(
		it.bysoftware.ct.model.TestataDocumento testataDocumento) {
		return _testataDocumento.compareTo(testataDocumento);
	}

	@Override
	public int hashCode() {
		return _testataDocumento.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.bysoftware.ct.model.TestataDocumento> toCacheModel() {
		return _testataDocumento.toCacheModel();
	}

	@Override
	public it.bysoftware.ct.model.TestataDocumento toEscapedModel() {
		return new TestataDocumentoWrapper(_testataDocumento.toEscapedModel());
	}

	@Override
	public it.bysoftware.ct.model.TestataDocumento toUnescapedModel() {
		return new TestataDocumentoWrapper(_testataDocumento.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _testataDocumento.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _testataDocumento.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_testataDocumento.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TestataDocumentoWrapper)) {
			return false;
		}

		TestataDocumentoWrapper testataDocumentoWrapper = (TestataDocumentoWrapper)obj;

		if (Validator.equals(_testataDocumento,
					testataDocumentoWrapper._testataDocumento)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TestataDocumento getWrappedTestataDocumento() {
		return _testataDocumento;
	}

	@Override
	public TestataDocumento getWrappedModel() {
		return _testataDocumento;
	}

	@Override
	public void resetOriginalValues() {
		_testataDocumento.resetOriginalValues();
	}

	private TestataDocumento _testataDocumento;
}
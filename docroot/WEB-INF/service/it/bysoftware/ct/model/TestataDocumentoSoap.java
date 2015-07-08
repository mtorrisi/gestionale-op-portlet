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

import it.bysoftware.ct.service.persistence.TestataDocumentoPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.bysoftware.ct.service.http.TestataDocumentoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.http.TestataDocumentoServiceSoap
 * @generated
 */
public class TestataDocumentoSoap implements Serializable {
	public static TestataDocumentoSoap toSoapModel(TestataDocumento model) {
		TestataDocumentoSoap soapModel = new TestataDocumentoSoap();

		soapModel.setAnno(model.getAnno());
		soapModel.setNumeroOrdine(model.getNumeroOrdine());
		soapModel.setCodiceSoggetto(model.getCodiceSoggetto());
		soapModel.setDataOrdine(model.getDataOrdine());
		soapModel.setDataConsegna(model.getDataConsegna());
		soapModel.setDestinazione(model.getDestinazione());
		soapModel.setCodiceDestinazione(model.getCodiceDestinazione());
		soapModel.setRagioneSociale(model.getRagioneSociale());
		soapModel.setCompleto(model.getCompleto());
		soapModel.setOperatore(model.getOperatore());
		soapModel.setVisto(model.getVisto());
		soapModel.setInviato(model.getInviato());
		soapModel.setLotto(model.getLotto());
		soapModel.setTipoDocumeto(model.getTipoDocumeto());
		soapModel.setVettore(model.getVettore());
		soapModel.setAutista(model.getAutista());
		soapModel.setTelefono(model.getTelefono());
		soapModel.setCentro(model.getCentro());
		soapModel.setPalletCaricati(model.getPalletCaricati());
		soapModel.setPalletScaricati(model.getPalletScaricati());
		soapModel.setCodiceVettore(model.getCodiceVettore());
		soapModel.setDestinazioneVettore(model.getDestinazioneVettore());
		soapModel.setNota1(model.getNota1());
		soapModel.setNota2(model.getNota2());
		soapModel.setRigoDescrittivo(model.getRigoDescrittivo());
		soapModel.setVettore2(model.getVettore2());
		soapModel.setCuraTrasporto(model.getCuraTrasporto());
		soapModel.setAspettoEsteriore(model.getAspettoEsteriore());
		soapModel.setCausaleTrasporto(model.getCausaleTrasporto());
		soapModel.setPorto(model.getPorto());
		soapModel.setOrigine(model.getOrigine());
		soapModel.setNumeroPedaneEuro(model.getNumeroPedaneEuro());
		soapModel.setNumeroPedaneNormali(model.getNumeroPedaneNormali());
		soapModel.setCostoTrasporto(model.getCostoTrasporto());
		soapModel.setTotalePedaneOrdine(model.getTotalePedaneOrdine());
		soapModel.setTargaCamion(model.getTargaCamion());
		soapModel.setTargaRimorchio(model.getTargaRimorchio());

		return soapModel;
	}

	public static TestataDocumentoSoap[] toSoapModels(TestataDocumento[] models) {
		TestataDocumentoSoap[] soapModels = new TestataDocumentoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TestataDocumentoSoap[][] toSoapModels(
		TestataDocumento[][] models) {
		TestataDocumentoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TestataDocumentoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TestataDocumentoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TestataDocumentoSoap[] toSoapModels(
		List<TestataDocumento> models) {
		List<TestataDocumentoSoap> soapModels = new ArrayList<TestataDocumentoSoap>(models.size());

		for (TestataDocumento model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TestataDocumentoSoap[soapModels.size()]);
	}

	public TestataDocumentoSoap() {
	}

	public TestataDocumentoPK getPrimaryKey() {
		return new TestataDocumentoPK(_anno, _numeroOrdine);
	}

	public void setPrimaryKey(TestataDocumentoPK pk) {
		setAnno(pk.anno);
		setNumeroOrdine(pk.numeroOrdine);
	}

	public int getAnno() {
		return _anno;
	}

	public void setAnno(int anno) {
		_anno = anno;
	}

	public int getNumeroOrdine() {
		return _numeroOrdine;
	}

	public void setNumeroOrdine(int numeroOrdine) {
		_numeroOrdine = numeroOrdine;
	}

	public String getCodiceSoggetto() {
		return _codiceSoggetto;
	}

	public void setCodiceSoggetto(String codiceSoggetto) {
		_codiceSoggetto = codiceSoggetto;
	}

	public String getDataOrdine() {
		return _dataOrdine;
	}

	public void setDataOrdine(String dataOrdine) {
		_dataOrdine = dataOrdine;
	}

	public String getDataConsegna() {
		return _dataConsegna;
	}

	public void setDataConsegna(String dataConsegna) {
		_dataConsegna = dataConsegna;
	}

	public String getDestinazione() {
		return _destinazione;
	}

	public void setDestinazione(String destinazione) {
		_destinazione = destinazione;
	}

	public int getCodiceDestinazione() {
		return _codiceDestinazione;
	}

	public void setCodiceDestinazione(int codiceDestinazione) {
		_codiceDestinazione = codiceDestinazione;
	}

	public String getRagioneSociale() {
		return _ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		_ragioneSociale = ragioneSociale;
	}

	public String getCompleto() {
		return _completo;
	}

	public void setCompleto(String completo) {
		_completo = completo;
	}

	public String getOperatore() {
		return _operatore;
	}

	public void setOperatore(String operatore) {
		_operatore = operatore;
	}

	public int getVisto() {
		return _visto;
	}

	public void setVisto(int visto) {
		_visto = visto;
	}

	public int getInviato() {
		return _inviato;
	}

	public void setInviato(int inviato) {
		_inviato = inviato;
	}

	public String getLotto() {
		return _lotto;
	}

	public void setLotto(String lotto) {
		_lotto = lotto;
	}

	public String getTipoDocumeto() {
		return _tipoDocumeto;
	}

	public void setTipoDocumeto(String tipoDocumeto) {
		_tipoDocumeto = tipoDocumeto;
	}

	public String getVettore() {
		return _vettore;
	}

	public void setVettore(String vettore) {
		_vettore = vettore;
	}

	public String getAutista() {
		return _autista;
	}

	public void setAutista(String autista) {
		_autista = autista;
	}

	public String getTelefono() {
		return _telefono;
	}

	public void setTelefono(String telefono) {
		_telefono = telefono;
	}

	public String getCentro() {
		return _centro;
	}

	public void setCentro(String centro) {
		_centro = centro;
	}

	public int getPalletCaricati() {
		return _palletCaricati;
	}

	public void setPalletCaricati(int palletCaricati) {
		_palletCaricati = palletCaricati;
	}

	public int getPalletScaricati() {
		return _palletScaricati;
	}

	public void setPalletScaricati(int palletScaricati) {
		_palletScaricati = palletScaricati;
	}

	public String getCodiceVettore() {
		return _codiceVettore;
	}

	public void setCodiceVettore(String codiceVettore) {
		_codiceVettore = codiceVettore;
	}

	public String getDestinazioneVettore() {
		return _destinazioneVettore;
	}

	public void setDestinazioneVettore(String destinazioneVettore) {
		_destinazioneVettore = destinazioneVettore;
	}

	public String getNota1() {
		return _nota1;
	}

	public void setNota1(String nota1) {
		_nota1 = nota1;
	}

	public String getNota2() {
		return _nota2;
	}

	public void setNota2(String nota2) {
		_nota2 = nota2;
	}

	public String getRigoDescrittivo() {
		return _rigoDescrittivo;
	}

	public void setRigoDescrittivo(String rigoDescrittivo) {
		_rigoDescrittivo = rigoDescrittivo;
	}

	public String getVettore2() {
		return _vettore2;
	}

	public void setVettore2(String vettore2) {
		_vettore2 = vettore2;
	}

	public String getCuraTrasporto() {
		return _curaTrasporto;
	}

	public void setCuraTrasporto(String curaTrasporto) {
		_curaTrasporto = curaTrasporto;
	}

	public String getAspettoEsteriore() {
		return _aspettoEsteriore;
	}

	public void setAspettoEsteriore(String aspettoEsteriore) {
		_aspettoEsteriore = aspettoEsteriore;
	}

	public String getCausaleTrasporto() {
		return _causaleTrasporto;
	}

	public void setCausaleTrasporto(String causaleTrasporto) {
		_causaleTrasporto = causaleTrasporto;
	}

	public String getPorto() {
		return _porto;
	}

	public void setPorto(String porto) {
		_porto = porto;
	}

	public String getOrigine() {
		return _origine;
	}

	public void setOrigine(String origine) {
		_origine = origine;
	}

	public int getNumeroPedaneEuro() {
		return _numeroPedaneEuro;
	}

	public void setNumeroPedaneEuro(int numeroPedaneEuro) {
		_numeroPedaneEuro = numeroPedaneEuro;
	}

	public int getNumeroPedaneNormali() {
		return _numeroPedaneNormali;
	}

	public void setNumeroPedaneNormali(int numeroPedaneNormali) {
		_numeroPedaneNormali = numeroPedaneNormali;
	}

	public double getCostoTrasporto() {
		return _costoTrasporto;
	}

	public void setCostoTrasporto(double costoTrasporto) {
		_costoTrasporto = costoTrasporto;
	}

	public int getTotalePedaneOrdine() {
		return _totalePedaneOrdine;
	}

	public void setTotalePedaneOrdine(int totalePedaneOrdine) {
		_totalePedaneOrdine = totalePedaneOrdine;
	}

	public String getTargaCamion() {
		return _targaCamion;
	}

	public void setTargaCamion(String targaCamion) {
		_targaCamion = targaCamion;
	}

	public String getTargaRimorchio() {
		return _targaRimorchio;
	}

	public void setTargaRimorchio(String targaRimorchio) {
		_targaRimorchio = targaRimorchio;
	}

	private int _anno;
	private int _numeroOrdine;
	private String _codiceSoggetto;
	private String _dataOrdine;
	private String _dataConsegna;
	private String _destinazione;
	private int _codiceDestinazione;
	private String _ragioneSociale;
	private String _completo;
	private String _operatore;
	private int _visto;
	private int _inviato;
	private String _lotto;
	private String _tipoDocumeto;
	private String _vettore;
	private String _autista;
	private String _telefono;
	private String _centro;
	private int _palletCaricati;
	private int _palletScaricati;
	private String _codiceVettore;
	private String _destinazioneVettore;
	private String _nota1;
	private String _nota2;
	private String _rigoDescrittivo;
	private String _vettore2;
	private String _curaTrasporto;
	private String _aspettoEsteriore;
	private String _causaleTrasporto;
	private String _porto;
	private String _origine;
	private int _numeroPedaneEuro;
	private int _numeroPedaneNormali;
	private double _costoTrasporto;
	private int _totalePedaneOrdine;
	private String _targaCamion;
	private String _targaRimorchio;
}
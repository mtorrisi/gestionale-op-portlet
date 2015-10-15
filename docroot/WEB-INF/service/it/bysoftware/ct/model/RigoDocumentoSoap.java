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

import it.bysoftware.ct.service.persistence.RigoDocumentoPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.bysoftware.ct.service.http.RigoDocumentoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.http.RigoDocumentoServiceSoap
 * @generated
 */
public class RigoDocumentoSoap implements Serializable {
	public static RigoDocumentoSoap toSoapModel(RigoDocumento model) {
		RigoDocumentoSoap soapModel = new RigoDocumentoSoap();

		soapModel.setAnno(model.getAnno());
		soapModel.setNumeroOrdine(model.getNumeroOrdine());
		soapModel.setRigoOrdine(model.getRigoOrdine());
		soapModel.setCodiceVariante(model.getCodiceVariante());
		soapModel.setDescrizioneVariante(model.getDescrizioneVariante());
		soapModel.setCodiceArticolo(model.getCodiceArticolo());
		soapModel.setDescrizione(model.getDescrizione());
		soapModel.setUnitaMisura(model.getUnitaMisura());
		soapModel.setColli(model.getColli());
		soapModel.setPesoLordo(model.getPesoLordo());
		soapModel.setTara(model.getTara());
		soapModel.setPesoNetto(model.getPesoNetto());
		soapModel.setPrezzo(model.getPrezzo());
		soapModel.setPedane(model.getPedane());
		soapModel.setNote(model.getNote());
		soapModel.setTotalePesata(model.getTotalePesata());
		soapModel.setImballo(model.getImballo());
		soapModel.setGestioneReti(model.getGestioneReti());
		soapModel.setRtxCl(model.getRtxCl());
		soapModel.setKgRete(model.getKgRete());
		soapModel.setLotto(model.getLotto());
		soapModel.setPassaporto(model.getPassaporto());
		soapModel.setProgressivo(model.getProgressivo());
		soapModel.setSconto1(model.getSconto1());
		soapModel.setSconto2(model.getSconto2());
		soapModel.setSconto3(model.getSconto3());
		soapModel.setTipoDocumento(model.getTipoDocumento());
		soapModel.setIdAssociato(model.getIdAssociato());

		return soapModel;
	}

	public static RigoDocumentoSoap[] toSoapModels(RigoDocumento[] models) {
		RigoDocumentoSoap[] soapModels = new RigoDocumentoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RigoDocumentoSoap[][] toSoapModels(RigoDocumento[][] models) {
		RigoDocumentoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RigoDocumentoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RigoDocumentoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RigoDocumentoSoap[] toSoapModels(List<RigoDocumento> models) {
		List<RigoDocumentoSoap> soapModels = new ArrayList<RigoDocumentoSoap>(models.size());

		for (RigoDocumento model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RigoDocumentoSoap[soapModels.size()]);
	}

	public RigoDocumentoSoap() {
	}

	public RigoDocumentoPK getPrimaryKey() {
		return new RigoDocumentoPK(_anno, _numeroOrdine, _rigoOrdine,
			_tipoDocumento, _idAssociato);
	}

	public void setPrimaryKey(RigoDocumentoPK pk) {
		setAnno(pk.anno);
		setNumeroOrdine(pk.numeroOrdine);
		setRigoOrdine(pk.rigoOrdine);
		setTipoDocumento(pk.tipoDocumento);
		setIdAssociato(pk.idAssociato);
	}

	public int getAnno() {
		return _anno;
	}

	public void setAnno(int anno) {
		_anno = anno;
	}

	public long getNumeroOrdine() {
		return _numeroOrdine;
	}

	public void setNumeroOrdine(long numeroOrdine) {
		_numeroOrdine = numeroOrdine;
	}

	public int getRigoOrdine() {
		return _rigoOrdine;
	}

	public void setRigoOrdine(int rigoOrdine) {
		_rigoOrdine = rigoOrdine;
	}

	public String getCodiceVariante() {
		return _codiceVariante;
	}

	public void setCodiceVariante(String codiceVariante) {
		_codiceVariante = codiceVariante;
	}

	public String getDescrizioneVariante() {
		return _descrizioneVariante;
	}

	public void setDescrizioneVariante(String descrizioneVariante) {
		_descrizioneVariante = descrizioneVariante;
	}

	public String getCodiceArticolo() {
		return _codiceArticolo;
	}

	public void setCodiceArticolo(String codiceArticolo) {
		_codiceArticolo = codiceArticolo;
	}

	public String getDescrizione() {
		return _descrizione;
	}

	public void setDescrizione(String descrizione) {
		_descrizione = descrizione;
	}

	public String getUnitaMisura() {
		return _unitaMisura;
	}

	public void setUnitaMisura(String unitaMisura) {
		_unitaMisura = unitaMisura;
	}

	public int getColli() {
		return _colli;
	}

	public void setColli(int colli) {
		_colli = colli;
	}

	public double getPesoLordo() {
		return _pesoLordo;
	}

	public void setPesoLordo(double pesoLordo) {
		_pesoLordo = pesoLordo;
	}

	public double getTara() {
		return _tara;
	}

	public void setTara(double tara) {
		_tara = tara;
	}

	public double getPesoNetto() {
		return _pesoNetto;
	}

	public void setPesoNetto(double pesoNetto) {
		_pesoNetto = pesoNetto;
	}

	public double getPrezzo() {
		return _prezzo;
	}

	public void setPrezzo(double prezzo) {
		_prezzo = prezzo;
	}

	public double getPedane() {
		return _pedane;
	}

	public void setPedane(double pedane) {
		_pedane = pedane;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	public double getTotalePesata() {
		return _totalePesata;
	}

	public void setTotalePesata(double totalePesata) {
		_totalePesata = totalePesata;
	}

	public String getImballo() {
		return _imballo;
	}

	public void setImballo(String imballo) {
		_imballo = imballo;
	}

	public boolean getGestioneReti() {
		return _gestioneReti;
	}

	public boolean isGestioneReti() {
		return _gestioneReti;
	}

	public void setGestioneReti(boolean gestioneReti) {
		_gestioneReti = gestioneReti;
	}

	public double getRtxCl() {
		return _RtxCl;
	}

	public void setRtxCl(double RtxCl) {
		_RtxCl = RtxCl;
	}

	public double getKgRete() {
		return _kgRete;
	}

	public void setKgRete(double kgRete) {
		_kgRete = kgRete;
	}

	public String getLotto() {
		return _lotto;
	}

	public void setLotto(String lotto) {
		_lotto = lotto;
	}

	public String getPassaporto() {
		return _passaporto;
	}

	public void setPassaporto(String passaporto) {
		_passaporto = passaporto;
	}

	public int getProgressivo() {
		return _progressivo;
	}

	public void setProgressivo(int progressivo) {
		_progressivo = progressivo;
	}

	public float getSconto1() {
		return _sconto1;
	}

	public void setSconto1(float sconto1) {
		_sconto1 = sconto1;
	}

	public float getSconto2() {
		return _sconto2;
	}

	public void setSconto2(float sconto2) {
		_sconto2 = sconto2;
	}

	public float getSconto3() {
		return _sconto3;
	}

	public void setSconto3(float sconto3) {
		_sconto3 = sconto3;
	}

	public String getTipoDocumento() {
		return _tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		_tipoDocumento = tipoDocumento;
	}

	public long getIdAssociato() {
		return _idAssociato;
	}

	public void setIdAssociato(long idAssociato) {
		_idAssociato = idAssociato;
	}

	private int _anno;
	private long _numeroOrdine;
	private int _rigoOrdine;
	private String _codiceVariante;
	private String _descrizioneVariante;
	private String _codiceArticolo;
	private String _descrizione;
	private String _unitaMisura;
	private int _colli;
	private double _pesoLordo;
	private double _tara;
	private double _pesoNetto;
	private double _prezzo;
	private double _pedane;
	private String _note;
	private double _totalePesata;
	private String _imballo;
	private boolean _gestioneReti;
	private double _RtxCl;
	private double _kgRete;
	private String _lotto;
	private String _passaporto;
	private int _progressivo;
	private float _sconto1;
	private float _sconto2;
	private float _sconto3;
	private String _tipoDocumento;
	private long _idAssociato;
}
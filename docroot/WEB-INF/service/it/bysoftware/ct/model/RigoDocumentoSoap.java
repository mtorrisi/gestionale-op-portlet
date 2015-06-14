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
		soapModel.setRigoOrdin(model.getRigoOrdin());
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
		return new RigoDocumentoPK(_anno, _numeroOrdine, _rigoOrdin);
	}

	public void setPrimaryKey(RigoDocumentoPK pk) {
		setAnno(pk.anno);
		setNumeroOrdine(pk.numeroOrdine);
		setRigoOrdin(pk.rigoOrdin);
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

	public int getRigoOrdin() {
		return _rigoOrdin;
	}

	public void setRigoOrdin(int rigoOrdin) {
		_rigoOrdin = rigoOrdin;
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

	private int _anno;
	private int _numeroOrdine;
	private int _rigoOrdin;
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
}
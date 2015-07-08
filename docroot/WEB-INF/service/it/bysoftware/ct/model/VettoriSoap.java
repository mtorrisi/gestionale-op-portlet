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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.bysoftware.ct.service.http.VettoriServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.http.VettoriServiceSoap
 * @generated
 */
public class VettoriSoap implements Serializable {
	public static VettoriSoap toSoapModel(Vettori model) {
		VettoriSoap soapModel = new VettoriSoap();

		soapModel.setAlbo(model.getAlbo());
		soapModel.setCAP(model.getCAP());
		soapModel.setCodiceVettore(model.getCodiceVettore());
		soapModel.setCodiceFiscale(model.getCodiceFiscale());
		soapModel.setCodiceRiferimento(model.getCodiceRiferimento());
		soapModel.setComune(model.getComune());
		soapModel.setIndirizzo(model.getIndirizzo());
		soapModel.setNote(model.getNote());
		soapModel.setPartitaIVA(model.getPartitaIVA());
		soapModel.setRagioneSociale(model.getRagioneSociale());
		soapModel.setRagioneSociale2(model.getRagioneSociale2());
		soapModel.setProvincia(model.getProvincia());
		soapModel.setStato(model.getStato());
		soapModel.setTipoAnagrafica(model.getTipoAnagrafica());
		soapModel.setCodiceAzienda(model.getCodiceAzienda());

		return soapModel;
	}

	public static VettoriSoap[] toSoapModels(Vettori[] models) {
		VettoriSoap[] soapModels = new VettoriSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VettoriSoap[][] toSoapModels(Vettori[][] models) {
		VettoriSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VettoriSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VettoriSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VettoriSoap[] toSoapModels(List<Vettori> models) {
		List<VettoriSoap> soapModels = new ArrayList<VettoriSoap>(models.size());

		for (Vettori model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VettoriSoap[soapModels.size()]);
	}

	public VettoriSoap() {
	}

	public String getPrimaryKey() {
		return _codiceVettore;
	}

	public void setPrimaryKey(String pk) {
		setCodiceVettore(pk);
	}

	public String getAlbo() {
		return _albo;
	}

	public void setAlbo(String albo) {
		_albo = albo;
	}

	public String getCAP() {
		return _CAP;
	}

	public void setCAP(String CAP) {
		_CAP = CAP;
	}

	public String getCodiceVettore() {
		return _codiceVettore;
	}

	public void setCodiceVettore(String codiceVettore) {
		_codiceVettore = codiceVettore;
	}

	public String getCodiceFiscale() {
		return _codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		_codiceFiscale = codiceFiscale;
	}

	public String getCodiceRiferimento() {
		return _codiceRiferimento;
	}

	public void setCodiceRiferimento(String codiceRiferimento) {
		_codiceRiferimento = codiceRiferimento;
	}

	public String getComune() {
		return _comune;
	}

	public void setComune(String comune) {
		_comune = comune;
	}

	public String getIndirizzo() {
		return _indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		_indirizzo = indirizzo;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	public String getPartitaIVA() {
		return _partitaIVA;
	}

	public void setPartitaIVA(String partitaIVA) {
		_partitaIVA = partitaIVA;
	}

	public String getRagioneSociale() {
		return _ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		_ragioneSociale = ragioneSociale;
	}

	public String getRagioneSociale2() {
		return _ragioneSociale2;
	}

	public void setRagioneSociale2(String ragioneSociale2) {
		_ragioneSociale2 = ragioneSociale2;
	}

	public String getProvincia() {
		return _provincia;
	}

	public void setProvincia(String provincia) {
		_provincia = provincia;
	}

	public String getStato() {
		return _stato;
	}

	public void setStato(String stato) {
		_stato = stato;
	}

	public String getTipoAnagrafica() {
		return _tipoAnagrafica;
	}

	public void setTipoAnagrafica(String tipoAnagrafica) {
		_tipoAnagrafica = tipoAnagrafica;
	}

	public String getCodiceAzienda() {
		return _codiceAzienda;
	}

	public void setCodiceAzienda(String codiceAzienda) {
		_codiceAzienda = codiceAzienda;
	}

	private String _albo;
	private String _CAP;
	private String _codiceVettore;
	private String _codiceFiscale;
	private String _codiceRiferimento;
	private String _comune;
	private String _indirizzo;
	private String _note;
	private String _partitaIVA;
	private String _ragioneSociale;
	private String _ragioneSociale2;
	private String _provincia;
	private String _stato;
	private String _tipoAnagrafica;
	private String _codiceAzienda;
}
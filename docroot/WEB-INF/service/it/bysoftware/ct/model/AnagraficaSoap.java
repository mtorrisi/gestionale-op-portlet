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
 * This class is used by SOAP remote services, specifically {@link it.bysoftware.ct.service.http.AnagraficaServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.http.AnagraficaServiceSoap
 * @generated
 */
public class AnagraficaSoap implements Serializable {
	public static AnagraficaSoap toSoapModel(Anagrafica model) {
		AnagraficaSoap soapModel = new AnagraficaSoap();

		soapModel.setAttivoEC(model.getAttivoEC());
		soapModel.setCap(model.getCap());
		soapModel.setCodiceAnagrafica(model.getCodiceAnagrafica());
		soapModel.setCodiceFiscale(model.getCodiceFiscale());
		soapModel.setCodiceMne(model.getCodiceMne());
		soapModel.setComune(model.getComune());
		soapModel.setIndirizzo(model.getIndirizzo());
		soapModel.setNote(model.getNote());
		soapModel.setPartitaIVA(model.getPartitaIVA());
		soapModel.setRagioneSociale(model.getRagioneSociale());
		soapModel.setRagioneSocialeAlternativa(model.getRagioneSocialeAlternativa());
		soapModel.setProvincia(model.getProvincia());
		soapModel.setStato(model.getStato());
		soapModel.setTepefi(model.getTepefi());
		soapModel.setTipoSoggetto(model.getTipoSoggetto());
		soapModel.setTipsol(model.getTipsol());
		soapModel.setCodiceAzienda(model.getCodiceAzienda());

		return soapModel;
	}

	public static AnagraficaSoap[] toSoapModels(Anagrafica[] models) {
		AnagraficaSoap[] soapModels = new AnagraficaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AnagraficaSoap[][] toSoapModels(Anagrafica[][] models) {
		AnagraficaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AnagraficaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AnagraficaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AnagraficaSoap[] toSoapModels(List<Anagrafica> models) {
		List<AnagraficaSoap> soapModels = new ArrayList<AnagraficaSoap>(models.size());

		for (Anagrafica model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AnagraficaSoap[soapModels.size()]);
	}

	public AnagraficaSoap() {
	}

	public String getPrimaryKey() {
		return _codiceAnagrafica;
	}

	public void setPrimaryKey(String pk) {
		setCodiceAnagrafica(pk);
	}

	public int getAttivoEC() {
		return _attivoEC;
	}

	public void setAttivoEC(int attivoEC) {
		_attivoEC = attivoEC;
	}

	public String getCap() {
		return _cap;
	}

	public void setCap(String cap) {
		_cap = cap;
	}

	public String getCodiceAnagrafica() {
		return _codiceAnagrafica;
	}

	public void setCodiceAnagrafica(String codiceAnagrafica) {
		_codiceAnagrafica = codiceAnagrafica;
	}

	public String getCodiceFiscale() {
		return _codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		_codiceFiscale = codiceFiscale;
	}

	public String getCodiceMne() {
		return _codiceMne;
	}

	public void setCodiceMne(String codiceMne) {
		_codiceMne = codiceMne;
	}

	public String getComune() {
		return _comune;
	}

	public void setComune(String comune) {
		_comune = comune;
	}

	public String getIndirizzo() {
		return _Indirizzo;
	}

	public void setIndirizzo(String Indirizzo) {
		_Indirizzo = Indirizzo;
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

	public String getRagioneSocialeAlternativa() {
		return _ragioneSocialeAlternativa;
	}

	public void setRagioneSocialeAlternativa(String ragioneSocialeAlternativa) {
		_ragioneSocialeAlternativa = ragioneSocialeAlternativa;
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

	public int getTepefi() {
		return _tepefi;
	}

	public void setTepefi(int tepefi) {
		_tepefi = tepefi;
	}

	public String getTipoSoggetto() {
		return _tipoSoggetto;
	}

	public void setTipoSoggetto(String tipoSoggetto) {
		_tipoSoggetto = tipoSoggetto;
	}

	public int getTipsol() {
		return _tipsol;
	}

	public void setTipsol(int tipsol) {
		_tipsol = tipsol;
	}

	public String getCodiceAzienda() {
		return _codiceAzienda;
	}

	public void setCodiceAzienda(String codiceAzienda) {
		_codiceAzienda = codiceAzienda;
	}

	private int _attivoEC;
	private String _cap;
	private String _codiceAnagrafica;
	private String _codiceFiscale;
	private String _codiceMne;
	private String _comune;
	private String _Indirizzo;
	private String _note;
	private String _partitaIVA;
	private String _ragioneSociale;
	private String _ragioneSocialeAlternativa;
	private String _provincia;
	private String _stato;
	private int _tepefi;
	private String _tipoSoggetto;
	private int _tipsol;
	private String _codiceAzienda;
}
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
 * This class is used by SOAP remote services, specifically {@link it.bysoftware.ct.service.http.AssociatoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.http.AssociatoServiceSoap
 * @generated
 */
public class AssociatoSoap implements Serializable {
	public static AssociatoSoap toSoapModel(Associato model) {
		AssociatoSoap soapModel = new AssociatoSoap();

		soapModel.setId(model.getId());
		soapModel.setCentro(model.getCentro());
		soapModel.setRagioneSociale(model.getRagioneSociale());
		soapModel.setPartitaIVA(model.getPartitaIVA());
		soapModel.setIndirizzo(model.getIndirizzo());
		soapModel.setComune(model.getComune());
		soapModel.setTelefono(model.getTelefono());
		soapModel.setFax(model.getFax());
		soapModel.setNomeUtente(model.getNomeUtente());
		soapModel.setEmail(model.getEmail());
		soapModel.setPassword(model.getPassword());
		soapModel.setIdLiferay(model.getIdLiferay());
		soapModel.setIdOp(model.getIdOp());
		soapModel.setAttivo(model.getAttivo());
		soapModel.setSezionaleOP(model.getSezionaleOP());

		return soapModel;
	}

	public static AssociatoSoap[] toSoapModels(Associato[] models) {
		AssociatoSoap[] soapModels = new AssociatoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AssociatoSoap[][] toSoapModels(Associato[][] models) {
		AssociatoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AssociatoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AssociatoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AssociatoSoap[] toSoapModels(List<Associato> models) {
		List<AssociatoSoap> soapModels = new ArrayList<AssociatoSoap>(models.size());

		for (Associato model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AssociatoSoap[soapModels.size()]);
	}

	public AssociatoSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getCentro() {
		return _centro;
	}

	public void setCentro(String centro) {
		_centro = centro;
	}

	public String getRagioneSociale() {
		return _ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		_ragioneSociale = ragioneSociale;
	}

	public String getPartitaIVA() {
		return _partitaIVA;
	}

	public void setPartitaIVA(String partitaIVA) {
		_partitaIVA = partitaIVA;
	}

	public String getIndirizzo() {
		return _indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		_indirizzo = indirizzo;
	}

	public String getComune() {
		return _comune;
	}

	public void setComune(String comune) {
		_comune = comune;
	}

	public String getTelefono() {
		return _telefono;
	}

	public void setTelefono(String telefono) {
		_telefono = telefono;
	}

	public String getFax() {
		return _fax;
	}

	public void setFax(String fax) {
		_fax = fax;
	}

	public String getNomeUtente() {
		return _nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		_nomeUtente = nomeUtente;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		_password = password;
	}

	public long getIdLiferay() {
		return _idLiferay;
	}

	public void setIdLiferay(long idLiferay) {
		_idLiferay = idLiferay;
	}

	public long getIdOp() {
		return _idOp;
	}

	public void setIdOp(long idOp) {
		_idOp = idOp;
	}

	public boolean getAttivo() {
		return _attivo;
	}

	public boolean isAttivo() {
		return _attivo;
	}

	public void setAttivo(boolean attivo) {
		_attivo = attivo;
	}

	public String getSezionaleOP() {
		return _sezionaleOP;
	}

	public void setSezionaleOP(String sezionaleOP) {
		_sezionaleOP = sezionaleOP;
	}

	private long _id;
	private String _centro;
	private String _ragioneSociale;
	private String _partitaIVA;
	private String _indirizzo;
	private String _comune;
	private String _telefono;
	private String _fax;
	private String _nomeUtente;
	private String _email;
	private String _password;
	private long _idLiferay;
	private long _idOp;
	private boolean _attivo;
	private String _sezionaleOP;
}
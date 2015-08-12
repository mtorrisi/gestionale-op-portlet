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
 * This class is used by SOAP remote services, specifically {@link it.bysoftware.ct.service.http.OrganizzazioneProduttoriServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.http.OrganizzazioneProduttoriServiceSoap
 * @generated
 */
public class OrganizzazioneProduttoriSoap implements Serializable {
	public static OrganizzazioneProduttoriSoap toSoapModel(
		OrganizzazioneProduttori model) {
		OrganizzazioneProduttoriSoap soapModel = new OrganizzazioneProduttoriSoap();

		soapModel.setId(model.getId());
		soapModel.setRagioneSociale(model.getRagioneSociale());
		soapModel.setPartitaIVA(model.getPartitaIVA());
		soapModel.setIndirizzo(model.getIndirizzo());
		soapModel.setTelefono(model.getTelefono());
		soapModel.setFax(model.getFax());
		soapModel.setSitoWeb(model.getSitoWeb());
		soapModel.setEmail(model.getEmail());
		soapModel.setPassword(model.getPassword());
		soapModel.setIdLiferay(model.getIdLiferay());

		return soapModel;
	}

	public static OrganizzazioneProduttoriSoap[] toSoapModels(
		OrganizzazioneProduttori[] models) {
		OrganizzazioneProduttoriSoap[] soapModels = new OrganizzazioneProduttoriSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrganizzazioneProduttoriSoap[][] toSoapModels(
		OrganizzazioneProduttori[][] models) {
		OrganizzazioneProduttoriSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OrganizzazioneProduttoriSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrganizzazioneProduttoriSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrganizzazioneProduttoriSoap[] toSoapModels(
		List<OrganizzazioneProduttori> models) {
		List<OrganizzazioneProduttoriSoap> soapModels = new ArrayList<OrganizzazioneProduttoriSoap>(models.size());

		for (OrganizzazioneProduttori model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OrganizzazioneProduttoriSoap[soapModels.size()]);
	}

	public OrganizzazioneProduttoriSoap() {
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

	public String getSitoWeb() {
		return _sitoWeb;
	}

	public void setSitoWeb(String sitoWeb) {
		_sitoWeb = sitoWeb;
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

	private long _id;
	private String _ragioneSociale;
	private String _partitaIVA;
	private String _indirizzo;
	private String _telefono;
	private String _fax;
	private String _sitoWeb;
	private String _email;
	private String _password;
	private long _idLiferay;
}
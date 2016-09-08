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

import it.bysoftware.ct.service.persistence.CMRPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.bysoftware.ct.service.http.CMRServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.http.CMRServiceSoap
 * @generated
 */
public class CMRSoap implements Serializable {
	public static CMRSoap toSoapModel(CMR model) {
		CMRSoap soapModel = new CMRSoap();

		soapModel.setAnno(model.getAnno());
		soapModel.setNumeroDocumento(model.getNumeroDocumento());
		soapModel.setIdAssociato(model.getIdAssociato());
		soapModel.setRiserve(model.getRiserve());
		soapModel.setAllegati(model.getAllegati());
		soapModel.setClasse(model.getClasse());
		soapModel.setCifra(model.getCifra());
		soapModel.setLettera(model.getLettera());
		soapModel.setAdr(model.getAdr());
		soapModel.setIstruzioni(model.getIstruzioni());
		soapModel.setConvenzioni(model.getConvenzioni());
		soapModel.setRimborso(model.getRimborso());

		return soapModel;
	}

	public static CMRSoap[] toSoapModels(CMR[] models) {
		CMRSoap[] soapModels = new CMRSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CMRSoap[][] toSoapModels(CMR[][] models) {
		CMRSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CMRSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CMRSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CMRSoap[] toSoapModels(List<CMR> models) {
		List<CMRSoap> soapModels = new ArrayList<CMRSoap>(models.size());

		for (CMR model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CMRSoap[soapModels.size()]);
	}

	public CMRSoap() {
	}

	public CMRPK getPrimaryKey() {
		return new CMRPK(_anno, _numeroDocumento, _idAssociato);
	}

	public void setPrimaryKey(CMRPK pk) {
		setAnno(pk.anno);
		setNumeroDocumento(pk.numeroDocumento);
		setIdAssociato(pk.idAssociato);
	}

	public int getAnno() {
		return _anno;
	}

	public void setAnno(int anno) {
		_anno = anno;
	}

	public long getNumeroDocumento() {
		return _numeroDocumento;
	}

	public void setNumeroDocumento(long numeroDocumento) {
		_numeroDocumento = numeroDocumento;
	}

	public int getIdAssociato() {
		return _idAssociato;
	}

	public void setIdAssociato(int idAssociato) {
		_idAssociato = idAssociato;
	}

	public String getRiserve() {
		return _riserve;
	}

	public void setRiserve(String riserve) {
		_riserve = riserve;
	}

	public String getAllegati() {
		return _allegati;
	}

	public void setAllegati(String allegati) {
		_allegati = allegati;
	}

	public String getClasse() {
		return _classe;
	}

	public void setClasse(String classe) {
		_classe = classe;
	}

	public String getCifra() {
		return _cifra;
	}

	public void setCifra(String cifra) {
		_cifra = cifra;
	}

	public String getLettera() {
		return _lettera;
	}

	public void setLettera(String lettera) {
		_lettera = lettera;
	}

	public String getAdr() {
		return _adr;
	}

	public void setAdr(String adr) {
		_adr = adr;
	}

	public String getIstruzioni() {
		return _istruzioni;
	}

	public void setIstruzioni(String istruzioni) {
		_istruzioni = istruzioni;
	}

	public String getConvenzioni() {
		return _convenzioni;
	}

	public void setConvenzioni(String convenzioni) {
		_convenzioni = convenzioni;
	}

	public String getRimborso() {
		return _rimborso;
	}

	public void setRimborso(String rimborso) {
		_rimborso = rimborso;
	}

	private int _anno;
	private long _numeroDocumento;
	private int _idAssociato;
	private String _riserve;
	private String _allegati;
	private String _classe;
	private String _cifra;
	private String _lettera;
	private String _adr;
	private String _istruzioni;
	private String _convenzioni;
	private String _rimborso;
}
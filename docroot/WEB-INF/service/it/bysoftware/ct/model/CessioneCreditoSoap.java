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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.bysoftware.ct.service.http.CessioneCreditoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.http.CessioneCreditoServiceSoap
 * @generated
 */
public class CessioneCreditoSoap implements Serializable {
	public static CessioneCreditoSoap toSoapModel(CessioneCredito model) {
		CessioneCreditoSoap soapModel = new CessioneCreditoSoap();

		soapModel.setId(model.getId());
		soapModel.setData(model.getData());
		soapModel.setCodiceSoggetto(model.getCodiceSoggetto());
		soapModel.setIdAssociato(model.getIdAssociato());
		soapModel.setIdFile(model.getIdFile());
		soapModel.setAnno(model.getAnno());
		soapModel.setNumeroFattura(model.getNumeroFattura());
		soapModel.setTotale(model.getTotale());
		soapModel.setNote(model.getNote());

		return soapModel;
	}

	public static CessioneCreditoSoap[] toSoapModels(CessioneCredito[] models) {
		CessioneCreditoSoap[] soapModels = new CessioneCreditoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CessioneCreditoSoap[][] toSoapModels(
		CessioneCredito[][] models) {
		CessioneCreditoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CessioneCreditoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CessioneCreditoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CessioneCreditoSoap[] toSoapModels(
		List<CessioneCredito> models) {
		List<CessioneCreditoSoap> soapModels = new ArrayList<CessioneCreditoSoap>(models.size());

		for (CessioneCredito model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CessioneCreditoSoap[soapModels.size()]);
	}

	public CessioneCreditoSoap() {
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

	public Date getData() {
		return _data;
	}

	public void setData(Date data) {
		_data = data;
	}

	public String getCodiceSoggetto() {
		return _codiceSoggetto;
	}

	public void setCodiceSoggetto(String codiceSoggetto) {
		_codiceSoggetto = codiceSoggetto;
	}

	public long getIdAssociato() {
		return _idAssociato;
	}

	public void setIdAssociato(long idAssociato) {
		_idAssociato = idAssociato;
	}

	public long getIdFile() {
		return _idFile;
	}

	public void setIdFile(long idFile) {
		_idFile = idFile;
	}

	public int getAnno() {
		return _anno;
	}

	public void setAnno(int anno) {
		_anno = anno;
	}

	public int getNumeroFattura() {
		return _numeroFattura;
	}

	public void setNumeroFattura(int numeroFattura) {
		_numeroFattura = numeroFattura;
	}

	public double getTotale() {
		return _totale;
	}

	public void setTotale(double totale) {
		_totale = totale;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	private long _id;
	private Date _data;
	private String _codiceSoggetto;
	private long _idAssociato;
	private long _idFile;
	private int _anno;
	private int _numeroFattura;
	private double _totale;
	private String _note;
}
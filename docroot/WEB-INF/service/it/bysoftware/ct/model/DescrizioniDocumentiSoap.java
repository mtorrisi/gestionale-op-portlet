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
 * This class is used by SOAP remote services, specifically {@link it.bysoftware.ct.service.http.DescrizioniDocumentiServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.http.DescrizioniDocumentiServiceSoap
 * @generated
 */
public class DescrizioniDocumentiSoap implements Serializable {
	public static DescrizioniDocumentiSoap toSoapModel(
		DescrizioniDocumenti model) {
		DescrizioniDocumentiSoap soapModel = new DescrizioniDocumentiSoap();

		soapModel.setCodiceDescrizione(model.getCodiceDescrizione());
		soapModel.setCodiceIVA(model.getCodiceIVA());
		soapModel.setDescrizione(model.getDescrizione());
		soapModel.setDescrizioneFiscale(model.getDescrizioneFiscale());
		soapModel.setCodiceAzienda(model.getCodiceAzienda());

		return soapModel;
	}

	public static DescrizioniDocumentiSoap[] toSoapModels(
		DescrizioniDocumenti[] models) {
		DescrizioniDocumentiSoap[] soapModels = new DescrizioniDocumentiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DescrizioniDocumentiSoap[][] toSoapModels(
		DescrizioniDocumenti[][] models) {
		DescrizioniDocumentiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DescrizioniDocumentiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DescrizioniDocumentiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DescrizioniDocumentiSoap[] toSoapModels(
		List<DescrizioniDocumenti> models) {
		List<DescrizioniDocumentiSoap> soapModels = new ArrayList<DescrizioniDocumentiSoap>(models.size());

		for (DescrizioniDocumenti model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DescrizioniDocumentiSoap[soapModels.size()]);
	}

	public DescrizioniDocumentiSoap() {
	}

	public String getPrimaryKey() {
		return _codiceDescrizione;
	}

	public void setPrimaryKey(String pk) {
		setCodiceDescrizione(pk);
	}

	public String getCodiceDescrizione() {
		return _codiceDescrizione;
	}

	public void setCodiceDescrizione(String codiceDescrizione) {
		_codiceDescrizione = codiceDescrizione;
	}

	public String getCodiceIVA() {
		return _codiceIVA;
	}

	public void setCodiceIVA(String codiceIVA) {
		_codiceIVA = codiceIVA;
	}

	public String getDescrizione() {
		return _descrizione;
	}

	public void setDescrizione(String descrizione) {
		_descrizione = descrizione;
	}

	public String getDescrizioneFiscale() {
		return _descrizioneFiscale;
	}

	public void setDescrizioneFiscale(String descrizioneFiscale) {
		_descrizioneFiscale = descrizioneFiscale;
	}

	public String getCodiceAzienda() {
		return _codiceAzienda;
	}

	public void setCodiceAzienda(String codiceAzienda) {
		_codiceAzienda = codiceAzienda;
	}

	private String _codiceDescrizione;
	private String _codiceIVA;
	private String _descrizione;
	private String _descrizioneFiscale;
	private String _codiceAzienda;
}
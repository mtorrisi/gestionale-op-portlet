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
 * This class is used by SOAP remote services, specifically {@link it.bysoftware.ct.service.http.CausaleTrasportoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.http.CausaleTrasportoServiceSoap
 * @generated
 */
public class CausaleTrasportoSoap implements Serializable {
	public static CausaleTrasportoSoap toSoapModel(CausaleTrasporto model) {
		CausaleTrasportoSoap soapModel = new CausaleTrasportoSoap();

		soapModel.setCodiceCausaleTrasporto(model.getCodiceCausaleTrasporto());
		soapModel.setDescrizione(model.getDescrizione());
		soapModel.setCodiceAzienda(model.getCodiceAzienda());

		return soapModel;
	}

	public static CausaleTrasportoSoap[] toSoapModels(CausaleTrasporto[] models) {
		CausaleTrasportoSoap[] soapModels = new CausaleTrasportoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CausaleTrasportoSoap[][] toSoapModels(
		CausaleTrasporto[][] models) {
		CausaleTrasportoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CausaleTrasportoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CausaleTrasportoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CausaleTrasportoSoap[] toSoapModels(
		List<CausaleTrasporto> models) {
		List<CausaleTrasportoSoap> soapModels = new ArrayList<CausaleTrasportoSoap>(models.size());

		for (CausaleTrasporto model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CausaleTrasportoSoap[soapModels.size()]);
	}

	public CausaleTrasportoSoap() {
	}

	public String getPrimaryKey() {
		return _codiceCausaleTrasporto;
	}

	public void setPrimaryKey(String pk) {
		setCodiceCausaleTrasporto(pk);
	}

	public String getCodiceCausaleTrasporto() {
		return _codiceCausaleTrasporto;
	}

	public void setCodiceCausaleTrasporto(String codiceCausaleTrasporto) {
		_codiceCausaleTrasporto = codiceCausaleTrasporto;
	}

	public String getDescrizione() {
		return _descrizione;
	}

	public void setDescrizione(String descrizione) {
		_descrizione = descrizione;
	}

	public String getCodiceAzienda() {
		return _codiceAzienda;
	}

	public void setCodiceAzienda(String codiceAzienda) {
		_codiceAzienda = codiceAzienda;
	}

	private String _codiceCausaleTrasporto;
	private String _descrizione;
	private String _codiceAzienda;
}
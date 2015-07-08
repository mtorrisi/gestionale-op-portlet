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
 * This class is used by SOAP remote services, specifically {@link it.bysoftware.ct.service.http.CuraTrasportoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.http.CuraTrasportoServiceSoap
 * @generated
 */
public class CuraTrasportoSoap implements Serializable {
	public static CuraTrasportoSoap toSoapModel(CuraTrasporto model) {
		CuraTrasportoSoap soapModel = new CuraTrasportoSoap();

		soapModel.setCodiceCuraTrasporto(model.getCodiceCuraTrasporto());
		soapModel.setDescrizione(model.getDescrizione());
		soapModel.setCodiceAzienda(model.getCodiceAzienda());

		return soapModel;
	}

	public static CuraTrasportoSoap[] toSoapModels(CuraTrasporto[] models) {
		CuraTrasportoSoap[] soapModels = new CuraTrasportoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CuraTrasportoSoap[][] toSoapModels(CuraTrasporto[][] models) {
		CuraTrasportoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CuraTrasportoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CuraTrasportoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CuraTrasportoSoap[] toSoapModels(List<CuraTrasporto> models) {
		List<CuraTrasportoSoap> soapModels = new ArrayList<CuraTrasportoSoap>(models.size());

		for (CuraTrasporto model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CuraTrasportoSoap[soapModels.size()]);
	}

	public CuraTrasportoSoap() {
	}

	public String getPrimaryKey() {
		return _codiceCuraTrasporto;
	}

	public void setPrimaryKey(String pk) {
		setCodiceCuraTrasporto(pk);
	}

	public String getCodiceCuraTrasporto() {
		return _codiceCuraTrasporto;
	}

	public void setCodiceCuraTrasporto(String codiceCuraTrasporto) {
		_codiceCuraTrasporto = codiceCuraTrasporto;
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

	private String _codiceCuraTrasporto;
	private String _descrizione;
	private String _codiceAzienda;
}
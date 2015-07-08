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
 * This class is used by SOAP remote services, specifically {@link it.bysoftware.ct.service.http.AspettoEsterioreBeniServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.http.AspettoEsterioreBeniServiceSoap
 * @generated
 */
public class AspettoEsterioreBeniSoap implements Serializable {
	public static AspettoEsterioreBeniSoap toSoapModel(
		AspettoEsterioreBeni model) {
		AspettoEsterioreBeniSoap soapModel = new AspettoEsterioreBeniSoap();

		soapModel.setCodiceAspettoEsteriore(model.getCodiceAspettoEsteriore());
		soapModel.setDescrizione(model.getDescrizione());
		soapModel.setCodiceAzienda(model.getCodiceAzienda());

		return soapModel;
	}

	public static AspettoEsterioreBeniSoap[] toSoapModels(
		AspettoEsterioreBeni[] models) {
		AspettoEsterioreBeniSoap[] soapModels = new AspettoEsterioreBeniSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AspettoEsterioreBeniSoap[][] toSoapModels(
		AspettoEsterioreBeni[][] models) {
		AspettoEsterioreBeniSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AspettoEsterioreBeniSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AspettoEsterioreBeniSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AspettoEsterioreBeniSoap[] toSoapModels(
		List<AspettoEsterioreBeni> models) {
		List<AspettoEsterioreBeniSoap> soapModels = new ArrayList<AspettoEsterioreBeniSoap>(models.size());

		for (AspettoEsterioreBeni model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AspettoEsterioreBeniSoap[soapModels.size()]);
	}

	public AspettoEsterioreBeniSoap() {
	}

	public String getPrimaryKey() {
		return _codiceAspettoEsteriore;
	}

	public void setPrimaryKey(String pk) {
		setCodiceAspettoEsteriore(pk);
	}

	public String getCodiceAspettoEsteriore() {
		return _codiceAspettoEsteriore;
	}

	public void setCodiceAspettoEsteriore(String codiceAspettoEsteriore) {
		_codiceAspettoEsteriore = codiceAspettoEsteriore;
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

	private String _codiceAspettoEsteriore;
	private String _descrizione;
	private String _codiceAzienda;
}
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
 * This class is used by SOAP remote services, specifically {@link it.bysoftware.ct.service.http.PortoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.http.PortoServiceSoap
 * @generated
 */
public class PortoSoap implements Serializable {
	public static PortoSoap toSoapModel(Porto model) {
		PortoSoap soapModel = new PortoSoap();

		soapModel.setCdinco(model.getCdinco());
		soapModel.setCodicePorto(model.getCodicePorto());
		soapModel.setDescrizione(model.getDescrizione());
		soapModel.setIncoterm(model.getIncoterm());
		soapModel.setCodiceAzienda(model.getCodiceAzienda());

		return soapModel;
	}

	public static PortoSoap[] toSoapModels(Porto[] models) {
		PortoSoap[] soapModels = new PortoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PortoSoap[][] toSoapModels(Porto[][] models) {
		PortoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PortoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PortoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PortoSoap[] toSoapModels(List<Porto> models) {
		List<PortoSoap> soapModels = new ArrayList<PortoSoap>(models.size());

		for (Porto model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PortoSoap[soapModels.size()]);
	}

	public PortoSoap() {
	}

	public String getPrimaryKey() {
		return _codicePorto;
	}

	public void setPrimaryKey(String pk) {
		setCodicePorto(pk);
	}

	public String getCdinco() {
		return _Cdinco;
	}

	public void setCdinco(String Cdinco) {
		_Cdinco = Cdinco;
	}

	public String getCodicePorto() {
		return _codicePorto;
	}

	public void setCodicePorto(String codicePorto) {
		_codicePorto = codicePorto;
	}

	public String getDescrizione() {
		return _descrizione;
	}

	public void setDescrizione(String descrizione) {
		_descrizione = descrizione;
	}

	public String getIncoterm() {
		return _Incoterm;
	}

	public void setIncoterm(String Incoterm) {
		_Incoterm = Incoterm;
	}

	public String getCodiceAzienda() {
		return _codiceAzienda;
	}

	public void setCodiceAzienda(String codiceAzienda) {
		_codiceAzienda = codiceAzienda;
	}

	private String _Cdinco;
	private String _codicePorto;
	private String _descrizione;
	private String _Incoterm;
	private String _codiceAzienda;
}
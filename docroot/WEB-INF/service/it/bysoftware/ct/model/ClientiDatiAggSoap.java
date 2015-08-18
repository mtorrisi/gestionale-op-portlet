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
 * This class is used by SOAP remote services, specifically {@link it.bysoftware.ct.service.http.ClientiDatiAggServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.http.ClientiDatiAggServiceSoap
 * @generated
 */
public class ClientiDatiAggSoap implements Serializable {
	public static ClientiDatiAggSoap toSoapModel(ClientiDatiAgg model) {
		ClientiDatiAggSoap soapModel = new ClientiDatiAggSoap();

		soapModel.setCodiceAnagrafica(model.getCodiceAnagrafica());
		soapModel.setAssociati(model.getAssociati());

		return soapModel;
	}

	public static ClientiDatiAggSoap[] toSoapModels(ClientiDatiAgg[] models) {
		ClientiDatiAggSoap[] soapModels = new ClientiDatiAggSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ClientiDatiAggSoap[][] toSoapModels(ClientiDatiAgg[][] models) {
		ClientiDatiAggSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ClientiDatiAggSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ClientiDatiAggSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ClientiDatiAggSoap[] toSoapModels(List<ClientiDatiAgg> models) {
		List<ClientiDatiAggSoap> soapModels = new ArrayList<ClientiDatiAggSoap>(models.size());

		for (ClientiDatiAgg model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ClientiDatiAggSoap[soapModels.size()]);
	}

	public ClientiDatiAggSoap() {
	}

	public String getPrimaryKey() {
		return _codiceAnagrafica;
	}

	public void setPrimaryKey(String pk) {
		setCodiceAnagrafica(pk);
	}

	public String getCodiceAnagrafica() {
		return _codiceAnagrafica;
	}

	public void setCodiceAnagrafica(String codiceAnagrafica) {
		_codiceAnagrafica = codiceAnagrafica;
	}

	public String getAssociati() {
		return _associati;
	}

	public void setAssociati(String associati) {
		_associati = associati;
	}

	private String _codiceAnagrafica;
	private String _associati;
}
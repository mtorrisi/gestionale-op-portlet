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
 * This class is used by SOAP remote services, specifically {@link it.bysoftware.ct.service.http.BancheAppoggioServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.http.BancheAppoggioServiceSoap
 * @generated
 */
public class BancheAppoggioSoap implements Serializable {
	public static BancheAppoggioSoap toSoapModel(BancheAppoggio model) {
		BancheAppoggioSoap soapModel = new BancheAppoggioSoap();

		soapModel.setCBanca(model.getCBanca());
		soapModel.setCodiceABI(model.getCodiceABI());
		soapModel.setCodiceAgenzia(model.getCodiceAgenzia());
		soapModel.setCodiceBanca(model.getCodiceBanca());
		soapModel.setCodiceCAB(model.getCodiceCAB());
		soapModel.setDescrizione(model.getDescrizione());
		soapModel.setPiazza(model.getPiazza());
		soapModel.setCodiceAzienda(model.getCodiceAzienda());

		return soapModel;
	}

	public static BancheAppoggioSoap[] toSoapModels(BancheAppoggio[] models) {
		BancheAppoggioSoap[] soapModels = new BancheAppoggioSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BancheAppoggioSoap[][] toSoapModels(BancheAppoggio[][] models) {
		BancheAppoggioSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BancheAppoggioSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BancheAppoggioSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BancheAppoggioSoap[] toSoapModels(List<BancheAppoggio> models) {
		List<BancheAppoggioSoap> soapModels = new ArrayList<BancheAppoggioSoap>(models.size());

		for (BancheAppoggio model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BancheAppoggioSoap[soapModels.size()]);
	}

	public BancheAppoggioSoap() {
	}

	public String getPrimaryKey() {
		return _codiceBanca;
	}

	public void setPrimaryKey(String pk) {
		setCodiceBanca(pk);
	}

	public String getCBanca() {
		return _cBanca;
	}

	public void setCBanca(String cBanca) {
		_cBanca = cBanca;
	}

	public int getCodiceABI() {
		return _codiceABI;
	}

	public void setCodiceABI(int codiceABI) {
		_codiceABI = codiceABI;
	}

	public String getCodiceAgenzia() {
		return _codiceAgenzia;
	}

	public void setCodiceAgenzia(String codiceAgenzia) {
		_codiceAgenzia = codiceAgenzia;
	}

	public String getCodiceBanca() {
		return _codiceBanca;
	}

	public void setCodiceBanca(String codiceBanca) {
		_codiceBanca = codiceBanca;
	}

	public int getCodiceCAB() {
		return _codiceCAB;
	}

	public void setCodiceCAB(int codiceCAB) {
		_codiceCAB = codiceCAB;
	}

	public String getDescrizione() {
		return _descrizione;
	}

	public void setDescrizione(String descrizione) {
		_descrizione = descrizione;
	}

	public String getPiazza() {
		return _piazza;
	}

	public void setPiazza(String piazza) {
		_piazza = piazza;
	}

	public String getCodiceAzienda() {
		return _codiceAzienda;
	}

	public void setCodiceAzienda(String codiceAzienda) {
		_codiceAzienda = codiceAzienda;
	}

	private String _cBanca;
	private int _codiceABI;
	private String _codiceAgenzia;
	private String _codiceBanca;
	private int _codiceCAB;
	private String _descrizione;
	private String _piazza;
	private String _codiceAzienda;
}
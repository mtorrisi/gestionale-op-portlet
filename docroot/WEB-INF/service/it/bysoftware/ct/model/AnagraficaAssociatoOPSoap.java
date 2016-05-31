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

import it.bysoftware.ct.service.persistence.AnagraficaAssociatoOPPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.bysoftware.ct.service.http.AnagraficaAssociatoOPServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.http.AnagraficaAssociatoOPServiceSoap
 * @generated
 */
public class AnagraficaAssociatoOPSoap implements Serializable {
	public static AnagraficaAssociatoOPSoap toSoapModel(
		AnagraficaAssociatoOP model) {
		AnagraficaAssociatoOPSoap soapModel = new AnagraficaAssociatoOPSoap();

		soapModel.setIdAssociato(model.getIdAssociato());
		soapModel.setCodiceSogettoAssociato(model.getCodiceSogettoAssociato());
		soapModel.setCodiceSogettoOP(model.getCodiceSogettoOP());

		return soapModel;
	}

	public static AnagraficaAssociatoOPSoap[] toSoapModels(
		AnagraficaAssociatoOP[] models) {
		AnagraficaAssociatoOPSoap[] soapModels = new AnagraficaAssociatoOPSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AnagraficaAssociatoOPSoap[][] toSoapModels(
		AnagraficaAssociatoOP[][] models) {
		AnagraficaAssociatoOPSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AnagraficaAssociatoOPSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AnagraficaAssociatoOPSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AnagraficaAssociatoOPSoap[] toSoapModels(
		List<AnagraficaAssociatoOP> models) {
		List<AnagraficaAssociatoOPSoap> soapModels = new ArrayList<AnagraficaAssociatoOPSoap>(models.size());

		for (AnagraficaAssociatoOP model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AnagraficaAssociatoOPSoap[soapModels.size()]);
	}

	public AnagraficaAssociatoOPSoap() {
	}

	public AnagraficaAssociatoOPPK getPrimaryKey() {
		return new AnagraficaAssociatoOPPK(_idAssociato, _codiceSogettoAssociato);
	}

	public void setPrimaryKey(AnagraficaAssociatoOPPK pk) {
		setIdAssociato(pk.idAssociato);
		setCodiceSogettoAssociato(pk.codiceSogettoAssociato);
	}

	public long getIdAssociato() {
		return _idAssociato;
	}

	public void setIdAssociato(long idAssociato) {
		_idAssociato = idAssociato;
	}

	public String getCodiceSogettoAssociato() {
		return _codiceSogettoAssociato;
	}

	public void setCodiceSogettoAssociato(String codiceSogettoAssociato) {
		_codiceSogettoAssociato = codiceSogettoAssociato;
	}

	public String getCodiceSogettoOP() {
		return _codiceSogettoOP;
	}

	public void setCodiceSogettoOP(String codiceSogettoOP) {
		_codiceSogettoOP = codiceSogettoOP;
	}

	private long _idAssociato;
	private String _codiceSogettoAssociato;
	private String _codiceSogettoOP;
}
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

import it.bysoftware.ct.service.persistence.ArticoliAssociatoOPPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.bysoftware.ct.service.http.ArticoliAssociatoOPServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.http.ArticoliAssociatoOPServiceSoap
 * @generated
 */
public class ArticoliAssociatoOPSoap implements Serializable {
	public static ArticoliAssociatoOPSoap toSoapModel(ArticoliAssociatoOP model) {
		ArticoliAssociatoOPSoap soapModel = new ArticoliAssociatoOPSoap();

		soapModel.setIdAssociato(model.getIdAssociato());
		soapModel.setCodiceArticoloAssociato(model.getCodiceArticoloAssociato());
		soapModel.setCodiceArticoloOP(model.getCodiceArticoloOP());

		return soapModel;
	}

	public static ArticoliAssociatoOPSoap[] toSoapModels(
		ArticoliAssociatoOP[] models) {
		ArticoliAssociatoOPSoap[] soapModels = new ArticoliAssociatoOPSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ArticoliAssociatoOPSoap[][] toSoapModels(
		ArticoliAssociatoOP[][] models) {
		ArticoliAssociatoOPSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ArticoliAssociatoOPSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ArticoliAssociatoOPSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ArticoliAssociatoOPSoap[] toSoapModels(
		List<ArticoliAssociatoOP> models) {
		List<ArticoliAssociatoOPSoap> soapModels = new ArrayList<ArticoliAssociatoOPSoap>(models.size());

		for (ArticoliAssociatoOP model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ArticoliAssociatoOPSoap[soapModels.size()]);
	}

	public ArticoliAssociatoOPSoap() {
	}

	public ArticoliAssociatoOPPK getPrimaryKey() {
		return new ArticoliAssociatoOPPK(_idAssociato, _codiceArticoloAssociato);
	}

	public void setPrimaryKey(ArticoliAssociatoOPPK pk) {
		setIdAssociato(pk.idAssociato);
		setCodiceArticoloAssociato(pk.codiceArticoloAssociato);
	}

	public long getIdAssociato() {
		return _idAssociato;
	}

	public void setIdAssociato(long idAssociato) {
		_idAssociato = idAssociato;
	}

	public String getCodiceArticoloAssociato() {
		return _codiceArticoloAssociato;
	}

	public void setCodiceArticoloAssociato(String codiceArticoloAssociato) {
		_codiceArticoloAssociato = codiceArticoloAssociato;
	}

	public String getCodiceArticoloOP() {
		return _codiceArticoloOP;
	}

	public void setCodiceArticoloOP(String codiceArticoloOP) {
		_codiceArticoloOP = codiceArticoloOP;
	}

	private long _idAssociato;
	private String _codiceArticoloAssociato;
	private String _codiceArticoloOP;
}
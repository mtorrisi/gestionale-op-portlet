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
 * This class is used by SOAP remote services, specifically {@link it.bysoftware.ct.service.http.IvaServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.http.IvaServiceSoap
 * @generated
 */
public class IvaSoap implements Serializable {
	public static IvaSoap toSoapModel(Iva model) {
		IvaSoap soapModel = new IvaSoap();

		soapModel.setCodiceIva(model.getCodiceIva());
		soapModel.setDescrizione(model.getDescrizione());
		soapModel.setDescrizioneDocumento(model.getDescrizioneDocumento());
		soapModel.setAliquota(model.getAliquota());

		return soapModel;
	}

	public static IvaSoap[] toSoapModels(Iva[] models) {
		IvaSoap[] soapModels = new IvaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static IvaSoap[][] toSoapModels(Iva[][] models) {
		IvaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new IvaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new IvaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static IvaSoap[] toSoapModels(List<Iva> models) {
		List<IvaSoap> soapModels = new ArrayList<IvaSoap>(models.size());

		for (Iva model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new IvaSoap[soapModels.size()]);
	}

	public IvaSoap() {
	}

	public String getPrimaryKey() {
		return _codiceIva;
	}

	public void setPrimaryKey(String pk) {
		setCodiceIva(pk);
	}

	public String getCodiceIva() {
		return _codiceIva;
	}

	public void setCodiceIva(String codiceIva) {
		_codiceIva = codiceIva;
	}

	public String getDescrizione() {
		return _descrizione;
	}

	public void setDescrizione(String descrizione) {
		_descrizione = descrizione;
	}

	public String getDescrizioneDocumento() {
		return _descrizioneDocumento;
	}

	public void setDescrizioneDocumento(String descrizioneDocumento) {
		_descrizioneDocumento = descrizioneDocumento;
	}

	public double getAliquota() {
		return _aliquota;
	}

	public void setAliquota(double aliquota) {
		_aliquota = aliquota;
	}

	private String _codiceIva;
	private String _descrizione;
	private String _descrizioneDocumento;
	private double _aliquota;
}
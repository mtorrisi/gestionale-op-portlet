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
 * This class is used by SOAP remote services, specifically {@link it.bysoftware.ct.service.http.DescrizioniVariantiServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.http.DescrizioniVariantiServiceSoap
 * @generated
 */
public class DescrizioniVariantiSoap implements Serializable {
	public static DescrizioniVariantiSoap toSoapModel(DescrizioniVarianti model) {
		DescrizioniVariantiSoap soapModel = new DescrizioniVariantiSoap();

		soapModel.setCodiceVariante(model.getCodiceVariante());
		soapModel.setDescrizioneVariante(model.getDescrizioneVariante());
		soapModel.setOrdine(model.getOrdine());
		soapModel.setTipoVariante(model.getTipoVariante());
		soapModel.setCodiceAzienda(model.getCodiceAzienda());

		return soapModel;
	}

	public static DescrizioniVariantiSoap[] toSoapModels(
		DescrizioniVarianti[] models) {
		DescrizioniVariantiSoap[] soapModels = new DescrizioniVariantiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DescrizioniVariantiSoap[][] toSoapModels(
		DescrizioniVarianti[][] models) {
		DescrizioniVariantiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DescrizioniVariantiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DescrizioniVariantiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DescrizioniVariantiSoap[] toSoapModels(
		List<DescrizioniVarianti> models) {
		List<DescrizioniVariantiSoap> soapModels = new ArrayList<DescrizioniVariantiSoap>(models.size());

		for (DescrizioniVarianti model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DescrizioniVariantiSoap[soapModels.size()]);
	}

	public DescrizioniVariantiSoap() {
	}

	public String getPrimaryKey() {
		return _codiceVariante;
	}

	public void setPrimaryKey(String pk) {
		setCodiceVariante(pk);
	}

	public String getCodiceVariante() {
		return _codiceVariante;
	}

	public void setCodiceVariante(String codiceVariante) {
		_codiceVariante = codiceVariante;
	}

	public String getDescrizioneVariante() {
		return _descrizioneVariante;
	}

	public void setDescrizioneVariante(String descrizioneVariante) {
		_descrizioneVariante = descrizioneVariante;
	}

	public int getOrdine() {
		return _ordine;
	}

	public void setOrdine(int ordine) {
		_ordine = ordine;
	}

	public String getTipoVariante() {
		return _tipoVariante;
	}

	public void setTipoVariante(String tipoVariante) {
		_tipoVariante = tipoVariante;
	}

	public String getCodiceAzienda() {
		return _codiceAzienda;
	}

	public void setCodiceAzienda(String codiceAzienda) {
		_codiceAzienda = codiceAzienda;
	}

	private String _codiceVariante;
	private String _descrizioneVariante;
	private int _ordine;
	private String _tipoVariante;
	private String _codiceAzienda;
}
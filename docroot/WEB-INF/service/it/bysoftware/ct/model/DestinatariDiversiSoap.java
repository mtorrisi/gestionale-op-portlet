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
 * This class is used by SOAP remote services, specifically {@link it.bysoftware.ct.service.http.DestinatariDiversiServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.http.DestinatariDiversiServiceSoap
 * @generated
 */
public class DestinatariDiversiSoap implements Serializable {
	public static DestinatariDiversiSoap toSoapModel(DestinatariDiversi model) {
		DestinatariDiversiSoap soapModel = new DestinatariDiversiSoap();

		soapModel.setCodiceAnagrafica(model.getCodiceAnagrafica());
		soapModel.setCodiceRiferimento(model.getCodiceRiferimento());
		soapModel.setCAP(model.getCAP());
		soapModel.setComune(model.getComune());
		soapModel.setIndirizzo(model.getIndirizzo());
		soapModel.setProvincia(model.getProvincia());
		soapModel.setStato(model.getStato());
		soapModel.setTipoAnagrafica(model.getTipoAnagrafica());

		return soapModel;
	}

	public static DestinatariDiversiSoap[] toSoapModels(
		DestinatariDiversi[] models) {
		DestinatariDiversiSoap[] soapModels = new DestinatariDiversiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DestinatariDiversiSoap[][] toSoapModels(
		DestinatariDiversi[][] models) {
		DestinatariDiversiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DestinatariDiversiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DestinatariDiversiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DestinatariDiversiSoap[] toSoapModels(
		List<DestinatariDiversi> models) {
		List<DestinatariDiversiSoap> soapModels = new ArrayList<DestinatariDiversiSoap>(models.size());

		for (DestinatariDiversi model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DestinatariDiversiSoap[soapModels.size()]);
	}

	public DestinatariDiversiSoap() {
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

	public String getCodiceRiferimento() {
		return _codiceRiferimento;
	}

	public void setCodiceRiferimento(String codiceRiferimento) {
		_codiceRiferimento = codiceRiferimento;
	}

	public String getCAP() {
		return _CAP;
	}

	public void setCAP(String CAP) {
		_CAP = CAP;
	}

	public String getComune() {
		return _comune;
	}

	public void setComune(String comune) {
		_comune = comune;
	}

	public String getIndirizzo() {
		return _indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		_indirizzo = indirizzo;
	}

	public String getProvincia() {
		return _provincia;
	}

	public void setProvincia(String provincia) {
		_provincia = provincia;
	}

	public String getStato() {
		return _stato;
	}

	public void setStato(String stato) {
		_stato = stato;
	}

	public String getTipoAnagrafica() {
		return _tipoAnagrafica;
	}

	public void setTipoAnagrafica(String tipoAnagrafica) {
		_tipoAnagrafica = tipoAnagrafica;
	}

	private String _codiceAnagrafica;
	private String _codiceRiferimento;
	private String _CAP;
	private String _comune;
	private String _indirizzo;
	private String _provincia;
	private String _stato;
	private String _tipoAnagrafica;
}
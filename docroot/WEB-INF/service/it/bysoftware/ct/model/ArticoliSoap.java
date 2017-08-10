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
 * This class is used by SOAP remote services, specifically {@link it.bysoftware.ct.service.http.ArticoliServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.http.ArticoliServiceSoap
 * @generated
 */
public class ArticoliSoap implements Serializable {
	public static ArticoliSoap toSoapModel(Articoli model) {
		ArticoliSoap soapModel = new ArticoliSoap();

		soapModel.setCodiceArticolo(model.getCodiceArticolo());
		soapModel.setCategoriaMerceologica(model.getCategoriaMerceologica());
		soapModel.setDescrizione(model.getDescrizione());
		soapModel.setDescrizioneDocumento(model.getDescrizioneDocumento());
		soapModel.setDescrizioneFiscale(model.getDescrizioneFiscale());
		soapModel.setUnitaMisura(model.getUnitaMisura());
		soapModel.setTara(model.getTara());
		soapModel.setCodiceIVA(model.getCodiceIVA());

		return soapModel;
	}

	public static ArticoliSoap[] toSoapModels(Articoli[] models) {
		ArticoliSoap[] soapModels = new ArticoliSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ArticoliSoap[][] toSoapModels(Articoli[][] models) {
		ArticoliSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ArticoliSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ArticoliSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ArticoliSoap[] toSoapModels(List<Articoli> models) {
		List<ArticoliSoap> soapModels = new ArrayList<ArticoliSoap>(models.size());

		for (Articoli model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ArticoliSoap[soapModels.size()]);
	}

	public ArticoliSoap() {
	}

	public String getPrimaryKey() {
		return _codiceArticolo;
	}

	public void setPrimaryKey(String pk) {
		setCodiceArticolo(pk);
	}

	public String getCodiceArticolo() {
		return _codiceArticolo;
	}

	public void setCodiceArticolo(String codiceArticolo) {
		_codiceArticolo = codiceArticolo;
	}

	public String getCategoriaMerceologica() {
		return _categoriaMerceologica;
	}

	public void setCategoriaMerceologica(String categoriaMerceologica) {
		_categoriaMerceologica = categoriaMerceologica;
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

	public String getDescrizioneFiscale() {
		return _descrizioneFiscale;
	}

	public void setDescrizioneFiscale(String descrizioneFiscale) {
		_descrizioneFiscale = descrizioneFiscale;
	}

	public String getUnitaMisura() {
		return _unitaMisura;
	}

	public void setUnitaMisura(String unitaMisura) {
		_unitaMisura = unitaMisura;
	}

	public double getTara() {
		return _tara;
	}

	public void setTara(double tara) {
		_tara = tara;
	}

	public String getCodiceIVA() {
		return _codiceIVA;
	}

	public void setCodiceIVA(String codiceIVA) {
		_codiceIVA = codiceIVA;
	}

	private String _codiceArticolo;
	private String _categoriaMerceologica;
	private String _descrizione;
	private String _descrizioneDocumento;
	private String _descrizioneFiscale;
	private String _unitaMisura;
	private double _tara;
	private String _codiceIVA;
}
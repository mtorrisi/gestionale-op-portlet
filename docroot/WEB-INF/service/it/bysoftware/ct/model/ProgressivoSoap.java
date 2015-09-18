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

import it.bysoftware.ct.service.persistence.ProgressivoPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.bysoftware.ct.service.http.ProgressivoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.http.ProgressivoServiceSoap
 * @generated
 */
public class ProgressivoSoap implements Serializable {
	public static ProgressivoSoap toSoapModel(Progressivo model) {
		ProgressivoSoap soapModel = new ProgressivoSoap();

		soapModel.setAnno(model.getAnno());
		soapModel.setIdAssociato(model.getIdAssociato());
		soapModel.setCodiceCentro(model.getCodiceCentro());
		soapModel.setCodiceDeposito(model.getCodiceDeposito());
		soapModel.setDataRegistrazione(model.getDataRegistrazione());
		soapModel.setNumeroBolla(model.getNumeroBolla());
		soapModel.setTipoDocumento(model.getTipoDocumento());
		soapModel.setNumeroProgressivo(model.getNumeroProgressivo());
		soapModel.setTipoCon(model.getTipoCon());
		soapModel.setCodiceAzienda(model.getCodiceAzienda());

		return soapModel;
	}

	public static ProgressivoSoap[] toSoapModels(Progressivo[] models) {
		ProgressivoSoap[] soapModels = new ProgressivoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProgressivoSoap[][] toSoapModels(Progressivo[][] models) {
		ProgressivoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProgressivoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProgressivoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProgressivoSoap[] toSoapModels(List<Progressivo> models) {
		List<ProgressivoSoap> soapModels = new ArrayList<ProgressivoSoap>(models.size());

		for (Progressivo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProgressivoSoap[soapModels.size()]);
	}

	public ProgressivoSoap() {
	}

	public ProgressivoPK getPrimaryKey() {
		return new ProgressivoPK(_anno, _idAssociato, _tipoDocumento,
			_numeroProgressivo);
	}

	public void setPrimaryKey(ProgressivoPK pk) {
		setAnno(pk.anno);
		setIdAssociato(pk.idAssociato);
		setTipoDocumento(pk.tipoDocumento);
		setNumeroProgressivo(pk.numeroProgressivo);
	}

	public int getAnno() {
		return _anno;
	}

	public void setAnno(int anno) {
		_anno = anno;
	}

	public long getIdAssociato() {
		return _idAssociato;
	}

	public void setIdAssociato(long idAssociato) {
		_idAssociato = idAssociato;
	}

	public String getCodiceCentro() {
		return _codiceCentro;
	}

	public void setCodiceCentro(String codiceCentro) {
		_codiceCentro = codiceCentro;
	}

	public String getCodiceDeposito() {
		return _codiceDeposito;
	}

	public void setCodiceDeposito(String codiceDeposito) {
		_codiceDeposito = codiceDeposito;
	}

	public String getDataRegistrazione() {
		return _dataRegistrazione;
	}

	public void setDataRegistrazione(String dataRegistrazione) {
		_dataRegistrazione = dataRegistrazione;
	}

	public long getNumeroBolla() {
		return _numeroBolla;
	}

	public void setNumeroBolla(long numeroBolla) {
		_numeroBolla = numeroBolla;
	}

	public int getTipoDocumento() {
		return _tipoDocumento;
	}

	public void setTipoDocumento(int tipoDocumento) {
		_tipoDocumento = tipoDocumento;
	}

	public int getNumeroProgressivo() {
		return _numeroProgressivo;
	}

	public void setNumeroProgressivo(int numeroProgressivo) {
		_numeroProgressivo = numeroProgressivo;
	}

	public int getTipoCon() {
		return _tipoCon;
	}

	public void setTipoCon(int tipoCon) {
		_tipoCon = tipoCon;
	}

	public String getCodiceAzienda() {
		return _codiceAzienda;
	}

	public void setCodiceAzienda(String codiceAzienda) {
		_codiceAzienda = codiceAzienda;
	}

	private int _anno;
	private long _idAssociato;
	private String _codiceCentro;
	private String _codiceDeposito;
	private String _dataRegistrazione;
	private long _numeroBolla;
	private int _tipoDocumento;
	private int _numeroProgressivo;
	private int _tipoCon;
	private String _codiceAzienda;
}
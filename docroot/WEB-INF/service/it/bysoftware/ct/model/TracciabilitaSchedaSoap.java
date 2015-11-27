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
 * This class is used by SOAP remote services, specifically {@link it.bysoftware.ct.service.http.TracciabilitaSchedaServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.http.TracciabilitaSchedaServiceSoap
 * @generated
 */
public class TracciabilitaSchedaSoap implements Serializable {
	public static TracciabilitaSchedaSoap toSoapModel(TracciabilitaScheda model) {
		TracciabilitaSchedaSoap soapModel = new TracciabilitaSchedaSoap();

		soapModel.setId(model.getId());
		soapModel.setCodiceProdotto(model.getCodiceProdotto());
		soapModel.setProdottoVenduto(model.getProdottoVenduto());
		soapModel.setKgVenduti(model.getKgVenduti());
		soapModel.setLottoVendita(model.getLottoVendita());
		soapModel.setAnno(model.getAnno());
		soapModel.setNumeroDocumento(model.getNumeroDocumento());
		soapModel.setRigoOrdine(model.getRigoOrdine());
		soapModel.setTipoDocumento(model.getTipoDocumento());
		soapModel.setIdAssociato(model.getIdAssociato());

		return soapModel;
	}

	public static TracciabilitaSchedaSoap[] toSoapModels(
		TracciabilitaScheda[] models) {
		TracciabilitaSchedaSoap[] soapModels = new TracciabilitaSchedaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TracciabilitaSchedaSoap[][] toSoapModels(
		TracciabilitaScheda[][] models) {
		TracciabilitaSchedaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TracciabilitaSchedaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TracciabilitaSchedaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TracciabilitaSchedaSoap[] toSoapModels(
		List<TracciabilitaScheda> models) {
		List<TracciabilitaSchedaSoap> soapModels = new ArrayList<TracciabilitaSchedaSoap>(models.size());

		for (TracciabilitaScheda model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TracciabilitaSchedaSoap[soapModels.size()]);
	}

	public TracciabilitaSchedaSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getCodiceProdotto() {
		return _codiceProdotto;
	}

	public void setCodiceProdotto(String codiceProdotto) {
		_codiceProdotto = codiceProdotto;
	}

	public String getProdottoVenduto() {
		return _prodottoVenduto;
	}

	public void setProdottoVenduto(String prodottoVenduto) {
		_prodottoVenduto = prodottoVenduto;
	}

	public double getKgVenduti() {
		return _kgVenduti;
	}

	public void setKgVenduti(double kgVenduti) {
		_kgVenduti = kgVenduti;
	}

	public String getLottoVendita() {
		return _lottoVendita;
	}

	public void setLottoVendita(String lottoVendita) {
		_lottoVendita = lottoVendita;
	}

	public int getAnno() {
		return _anno;
	}

	public void setAnno(int anno) {
		_anno = anno;
	}

	public long getNumeroDocumento() {
		return _numeroDocumento;
	}

	public void setNumeroDocumento(long numeroDocumento) {
		_numeroDocumento = numeroDocumento;
	}

	public int getRigoOrdine() {
		return _rigoOrdine;
	}

	public void setRigoOrdine(int rigoOrdine) {
		_rigoOrdine = rigoOrdine;
	}

	public String getTipoDocumento() {
		return _tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		_tipoDocumento = tipoDocumento;
	}

	public long getIdAssociato() {
		return _idAssociato;
	}

	public void setIdAssociato(long idAssociato) {
		_idAssociato = idAssociato;
	}

	private long _id;
	private String _codiceProdotto;
	private String _prodottoVenduto;
	private double _kgVenduti;
	private String _lottoVendita;
	private int _anno;
	private long _numeroDocumento;
	private int _rigoOrdine;
	private String _tipoDocumento;
	private long _idAssociato;
}
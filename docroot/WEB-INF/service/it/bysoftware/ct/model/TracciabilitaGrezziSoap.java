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
 * This class is used by SOAP remote services, specifically {@link it.bysoftware.ct.service.http.TracciabilitaGrezziServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.http.TracciabilitaGrezziServiceSoap
 * @generated
 */
public class TracciabilitaGrezziSoap implements Serializable {
	public static TracciabilitaGrezziSoap toSoapModel(TracciabilitaGrezzi model) {
		TracciabilitaGrezziSoap soapModel = new TracciabilitaGrezziSoap();

		soapModel.setId(model.getId());
		soapModel.setLottoGrezzo(model.getLottoGrezzo());
		soapModel.setProdotto(model.getProdotto());
		soapModel.setKg(model.getKg());
		soapModel.setProduttore(model.getProduttore());
		soapModel.setFoglio(model.getFoglio());
		soapModel.setParticella(model.getParticella());
		soapModel.setIdSchedaTracciabilta(model.getIdSchedaTracciabilta());

		return soapModel;
	}

	public static TracciabilitaGrezziSoap[] toSoapModels(
		TracciabilitaGrezzi[] models) {
		TracciabilitaGrezziSoap[] soapModels = new TracciabilitaGrezziSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TracciabilitaGrezziSoap[][] toSoapModels(
		TracciabilitaGrezzi[][] models) {
		TracciabilitaGrezziSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TracciabilitaGrezziSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TracciabilitaGrezziSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TracciabilitaGrezziSoap[] toSoapModels(
		List<TracciabilitaGrezzi> models) {
		List<TracciabilitaGrezziSoap> soapModels = new ArrayList<TracciabilitaGrezziSoap>(models.size());

		for (TracciabilitaGrezzi model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TracciabilitaGrezziSoap[soapModels.size()]);
	}

	public TracciabilitaGrezziSoap() {
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

	public String getLottoGrezzo() {
		return _lottoGrezzo;
	}

	public void setLottoGrezzo(String lottoGrezzo) {
		_lottoGrezzo = lottoGrezzo;
	}

	public String getProdotto() {
		return _prodotto;
	}

	public void setProdotto(String prodotto) {
		_prodotto = prodotto;
	}

	public double getKg() {
		return _kg;
	}

	public void setKg(double kg) {
		_kg = kg;
	}

	public String getProduttore() {
		return _produttore;
	}

	public void setProduttore(String produttore) {
		_produttore = produttore;
	}

	public int getFoglio() {
		return _foglio;
	}

	public void setFoglio(int foglio) {
		_foglio = foglio;
	}

	public int getParticella() {
		return _particella;
	}

	public void setParticella(int particella) {
		_particella = particella;
	}

	public long getIdSchedaTracciabilta() {
		return _idSchedaTracciabilta;
	}

	public void setIdSchedaTracciabilta(long idSchedaTracciabilta) {
		_idSchedaTracciabilta = idSchedaTracciabilta;
	}

	private long _id;
	private String _lottoGrezzo;
	private String _prodotto;
	private double _kg;
	private String _produttore;
	private int _foglio;
	private int _particella;
	private long _idSchedaTracciabilta;
}
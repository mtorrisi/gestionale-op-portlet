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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TracciabilitaScheda}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TracciabilitaScheda
 * @generated
 */
public class TracciabilitaSchedaWrapper implements TracciabilitaScheda,
	ModelWrapper<TracciabilitaScheda> {
	public TracciabilitaSchedaWrapper(TracciabilitaScheda tracciabilitaScheda) {
		_tracciabilitaScheda = tracciabilitaScheda;
	}

	@Override
	public Class<?> getModelClass() {
		return TracciabilitaScheda.class;
	}

	@Override
	public String getModelClassName() {
		return TracciabilitaScheda.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("codiceProdotto", getCodiceProdotto());
		attributes.put("prodottoVenduto", getProdottoVenduto());
		attributes.put("kgVenduti", getKgVenduti());
		attributes.put("lottoVendita", getLottoVendita());
		attributes.put("anno", getAnno());
		attributes.put("numeroDocumento", getNumeroDocumento());
		attributes.put("rigoOrdine", getRigoOrdine());
		attributes.put("tipoDocumento", getTipoDocumento());
		attributes.put("idAssociato", getIdAssociato());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String codiceProdotto = (String)attributes.get("codiceProdotto");

		if (codiceProdotto != null) {
			setCodiceProdotto(codiceProdotto);
		}

		String prodottoVenduto = (String)attributes.get("prodottoVenduto");

		if (prodottoVenduto != null) {
			setProdottoVenduto(prodottoVenduto);
		}

		Double kgVenduti = (Double)attributes.get("kgVenduti");

		if (kgVenduti != null) {
			setKgVenduti(kgVenduti);
		}

		String lottoVendita = (String)attributes.get("lottoVendita");

		if (lottoVendita != null) {
			setLottoVendita(lottoVendita);
		}

		Integer anno = (Integer)attributes.get("anno");

		if (anno != null) {
			setAnno(anno);
		}

		Long numeroDocumento = (Long)attributes.get("numeroDocumento");

		if (numeroDocumento != null) {
			setNumeroDocumento(numeroDocumento);
		}

		Integer rigoOrdine = (Integer)attributes.get("rigoOrdine");

		if (rigoOrdine != null) {
			setRigoOrdine(rigoOrdine);
		}

		String tipoDocumento = (String)attributes.get("tipoDocumento");

		if (tipoDocumento != null) {
			setTipoDocumento(tipoDocumento);
		}

		Long idAssociato = (Long)attributes.get("idAssociato");

		if (idAssociato != null) {
			setIdAssociato(idAssociato);
		}
	}

	/**
	* Returns the primary key of this tracciabilita scheda.
	*
	* @return the primary key of this tracciabilita scheda
	*/
	@Override
	public long getPrimaryKey() {
		return _tracciabilitaScheda.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tracciabilita scheda.
	*
	* @param primaryKey the primary key of this tracciabilita scheda
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tracciabilitaScheda.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this tracciabilita scheda.
	*
	* @return the ID of this tracciabilita scheda
	*/
	@Override
	public long getId() {
		return _tracciabilitaScheda.getId();
	}

	/**
	* Sets the ID of this tracciabilita scheda.
	*
	* @param id the ID of this tracciabilita scheda
	*/
	@Override
	public void setId(long id) {
		_tracciabilitaScheda.setId(id);
	}

	/**
	* Returns the codice prodotto of this tracciabilita scheda.
	*
	* @return the codice prodotto of this tracciabilita scheda
	*/
	@Override
	public java.lang.String getCodiceProdotto() {
		return _tracciabilitaScheda.getCodiceProdotto();
	}

	/**
	* Sets the codice prodotto of this tracciabilita scheda.
	*
	* @param codiceProdotto the codice prodotto of this tracciabilita scheda
	*/
	@Override
	public void setCodiceProdotto(java.lang.String codiceProdotto) {
		_tracciabilitaScheda.setCodiceProdotto(codiceProdotto);
	}

	/**
	* Returns the prodotto venduto of this tracciabilita scheda.
	*
	* @return the prodotto venduto of this tracciabilita scheda
	*/
	@Override
	public java.lang.String getProdottoVenduto() {
		return _tracciabilitaScheda.getProdottoVenduto();
	}

	/**
	* Sets the prodotto venduto of this tracciabilita scheda.
	*
	* @param prodottoVenduto the prodotto venduto of this tracciabilita scheda
	*/
	@Override
	public void setProdottoVenduto(java.lang.String prodottoVenduto) {
		_tracciabilitaScheda.setProdottoVenduto(prodottoVenduto);
	}

	/**
	* Returns the kg venduti of this tracciabilita scheda.
	*
	* @return the kg venduti of this tracciabilita scheda
	*/
	@Override
	public double getKgVenduti() {
		return _tracciabilitaScheda.getKgVenduti();
	}

	/**
	* Sets the kg venduti of this tracciabilita scheda.
	*
	* @param kgVenduti the kg venduti of this tracciabilita scheda
	*/
	@Override
	public void setKgVenduti(double kgVenduti) {
		_tracciabilitaScheda.setKgVenduti(kgVenduti);
	}

	/**
	* Returns the lotto vendita of this tracciabilita scheda.
	*
	* @return the lotto vendita of this tracciabilita scheda
	*/
	@Override
	public java.lang.String getLottoVendita() {
		return _tracciabilitaScheda.getLottoVendita();
	}

	/**
	* Sets the lotto vendita of this tracciabilita scheda.
	*
	* @param lottoVendita the lotto vendita of this tracciabilita scheda
	*/
	@Override
	public void setLottoVendita(java.lang.String lottoVendita) {
		_tracciabilitaScheda.setLottoVendita(lottoVendita);
	}

	/**
	* Returns the anno of this tracciabilita scheda.
	*
	* @return the anno of this tracciabilita scheda
	*/
	@Override
	public int getAnno() {
		return _tracciabilitaScheda.getAnno();
	}

	/**
	* Sets the anno of this tracciabilita scheda.
	*
	* @param anno the anno of this tracciabilita scheda
	*/
	@Override
	public void setAnno(int anno) {
		_tracciabilitaScheda.setAnno(anno);
	}

	/**
	* Returns the numero documento of this tracciabilita scheda.
	*
	* @return the numero documento of this tracciabilita scheda
	*/
	@Override
	public long getNumeroDocumento() {
		return _tracciabilitaScheda.getNumeroDocumento();
	}

	/**
	* Sets the numero documento of this tracciabilita scheda.
	*
	* @param numeroDocumento the numero documento of this tracciabilita scheda
	*/
	@Override
	public void setNumeroDocumento(long numeroDocumento) {
		_tracciabilitaScheda.setNumeroDocumento(numeroDocumento);
	}

	/**
	* Returns the rigo ordine of this tracciabilita scheda.
	*
	* @return the rigo ordine of this tracciabilita scheda
	*/
	@Override
	public int getRigoOrdine() {
		return _tracciabilitaScheda.getRigoOrdine();
	}

	/**
	* Sets the rigo ordine of this tracciabilita scheda.
	*
	* @param rigoOrdine the rigo ordine of this tracciabilita scheda
	*/
	@Override
	public void setRigoOrdine(int rigoOrdine) {
		_tracciabilitaScheda.setRigoOrdine(rigoOrdine);
	}

	/**
	* Returns the tipo documento of this tracciabilita scheda.
	*
	* @return the tipo documento of this tracciabilita scheda
	*/
	@Override
	public java.lang.String getTipoDocumento() {
		return _tracciabilitaScheda.getTipoDocumento();
	}

	/**
	* Sets the tipo documento of this tracciabilita scheda.
	*
	* @param tipoDocumento the tipo documento of this tracciabilita scheda
	*/
	@Override
	public void setTipoDocumento(java.lang.String tipoDocumento) {
		_tracciabilitaScheda.setTipoDocumento(tipoDocumento);
	}

	/**
	* Returns the id associato of this tracciabilita scheda.
	*
	* @return the id associato of this tracciabilita scheda
	*/
	@Override
	public long getIdAssociato() {
		return _tracciabilitaScheda.getIdAssociato();
	}

	/**
	* Sets the id associato of this tracciabilita scheda.
	*
	* @param idAssociato the id associato of this tracciabilita scheda
	*/
	@Override
	public void setIdAssociato(long idAssociato) {
		_tracciabilitaScheda.setIdAssociato(idAssociato);
	}

	@Override
	public boolean isNew() {
		return _tracciabilitaScheda.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_tracciabilitaScheda.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _tracciabilitaScheda.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tracciabilitaScheda.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _tracciabilitaScheda.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _tracciabilitaScheda.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tracciabilitaScheda.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tracciabilitaScheda.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_tracciabilitaScheda.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_tracciabilitaScheda.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tracciabilitaScheda.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TracciabilitaSchedaWrapper((TracciabilitaScheda)_tracciabilitaScheda.clone());
	}

	@Override
	public int compareTo(
		it.bysoftware.ct.model.TracciabilitaScheda tracciabilitaScheda) {
		return _tracciabilitaScheda.compareTo(tracciabilitaScheda);
	}

	@Override
	public int hashCode() {
		return _tracciabilitaScheda.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.bysoftware.ct.model.TracciabilitaScheda> toCacheModel() {
		return _tracciabilitaScheda.toCacheModel();
	}

	@Override
	public it.bysoftware.ct.model.TracciabilitaScheda toEscapedModel() {
		return new TracciabilitaSchedaWrapper(_tracciabilitaScheda.toEscapedModel());
	}

	@Override
	public it.bysoftware.ct.model.TracciabilitaScheda toUnescapedModel() {
		return new TracciabilitaSchedaWrapper(_tracciabilitaScheda.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tracciabilitaScheda.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tracciabilitaScheda.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tracciabilitaScheda.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TracciabilitaSchedaWrapper)) {
			return false;
		}

		TracciabilitaSchedaWrapper tracciabilitaSchedaWrapper = (TracciabilitaSchedaWrapper)obj;

		if (Validator.equals(_tracciabilitaScheda,
					tracciabilitaSchedaWrapper._tracciabilitaScheda)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TracciabilitaScheda getWrappedTracciabilitaScheda() {
		return _tracciabilitaScheda;
	}

	@Override
	public TracciabilitaScheda getWrappedModel() {
		return _tracciabilitaScheda;
	}

	@Override
	public void resetOriginalValues() {
		_tracciabilitaScheda.resetOriginalValues();
	}

	private TracciabilitaScheda _tracciabilitaScheda;
}
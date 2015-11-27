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
 * This class is a wrapper for {@link TracciabilitaGrezzi}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TracciabilitaGrezzi
 * @generated
 */
public class TracciabilitaGrezziWrapper implements TracciabilitaGrezzi,
	ModelWrapper<TracciabilitaGrezzi> {
	public TracciabilitaGrezziWrapper(TracciabilitaGrezzi tracciabilitaGrezzi) {
		_tracciabilitaGrezzi = tracciabilitaGrezzi;
	}

	@Override
	public Class<?> getModelClass() {
		return TracciabilitaGrezzi.class;
	}

	@Override
	public String getModelClassName() {
		return TracciabilitaGrezzi.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("lottoGrezzo", getLottoGrezzo());
		attributes.put("prodotto", getProdotto());
		attributes.put("kg", getKg());
		attributes.put("produttore", getProduttore());
		attributes.put("foglio", getFoglio());
		attributes.put("particella", getParticella());
		attributes.put("idSchedaTracciabilta", getIdSchedaTracciabilta());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String lottoGrezzo = (String)attributes.get("lottoGrezzo");

		if (lottoGrezzo != null) {
			setLottoGrezzo(lottoGrezzo);
		}

		String prodotto = (String)attributes.get("prodotto");

		if (prodotto != null) {
			setProdotto(prodotto);
		}

		Double kg = (Double)attributes.get("kg");

		if (kg != null) {
			setKg(kg);
		}

		String produttore = (String)attributes.get("produttore");

		if (produttore != null) {
			setProduttore(produttore);
		}

		Integer foglio = (Integer)attributes.get("foglio");

		if (foglio != null) {
			setFoglio(foglio);
		}

		Integer particella = (Integer)attributes.get("particella");

		if (particella != null) {
			setParticella(particella);
		}

		Long idSchedaTracciabilta = (Long)attributes.get("idSchedaTracciabilta");

		if (idSchedaTracciabilta != null) {
			setIdSchedaTracciabilta(idSchedaTracciabilta);
		}
	}

	/**
	* Returns the primary key of this tracciabilita grezzi.
	*
	* @return the primary key of this tracciabilita grezzi
	*/
	@Override
	public long getPrimaryKey() {
		return _tracciabilitaGrezzi.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tracciabilita grezzi.
	*
	* @param primaryKey the primary key of this tracciabilita grezzi
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tracciabilitaGrezzi.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this tracciabilita grezzi.
	*
	* @return the ID of this tracciabilita grezzi
	*/
	@Override
	public long getId() {
		return _tracciabilitaGrezzi.getId();
	}

	/**
	* Sets the ID of this tracciabilita grezzi.
	*
	* @param id the ID of this tracciabilita grezzi
	*/
	@Override
	public void setId(long id) {
		_tracciabilitaGrezzi.setId(id);
	}

	/**
	* Returns the lotto grezzo of this tracciabilita grezzi.
	*
	* @return the lotto grezzo of this tracciabilita grezzi
	*/
	@Override
	public java.lang.String getLottoGrezzo() {
		return _tracciabilitaGrezzi.getLottoGrezzo();
	}

	/**
	* Sets the lotto grezzo of this tracciabilita grezzi.
	*
	* @param lottoGrezzo the lotto grezzo of this tracciabilita grezzi
	*/
	@Override
	public void setLottoGrezzo(java.lang.String lottoGrezzo) {
		_tracciabilitaGrezzi.setLottoGrezzo(lottoGrezzo);
	}

	/**
	* Returns the prodotto of this tracciabilita grezzi.
	*
	* @return the prodotto of this tracciabilita grezzi
	*/
	@Override
	public java.lang.String getProdotto() {
		return _tracciabilitaGrezzi.getProdotto();
	}

	/**
	* Sets the prodotto of this tracciabilita grezzi.
	*
	* @param prodotto the prodotto of this tracciabilita grezzi
	*/
	@Override
	public void setProdotto(java.lang.String prodotto) {
		_tracciabilitaGrezzi.setProdotto(prodotto);
	}

	/**
	* Returns the kg of this tracciabilita grezzi.
	*
	* @return the kg of this tracciabilita grezzi
	*/
	@Override
	public double getKg() {
		return _tracciabilitaGrezzi.getKg();
	}

	/**
	* Sets the kg of this tracciabilita grezzi.
	*
	* @param kg the kg of this tracciabilita grezzi
	*/
	@Override
	public void setKg(double kg) {
		_tracciabilitaGrezzi.setKg(kg);
	}

	/**
	* Returns the produttore of this tracciabilita grezzi.
	*
	* @return the produttore of this tracciabilita grezzi
	*/
	@Override
	public java.lang.String getProduttore() {
		return _tracciabilitaGrezzi.getProduttore();
	}

	/**
	* Sets the produttore of this tracciabilita grezzi.
	*
	* @param produttore the produttore of this tracciabilita grezzi
	*/
	@Override
	public void setProduttore(java.lang.String produttore) {
		_tracciabilitaGrezzi.setProduttore(produttore);
	}

	/**
	* Returns the foglio of this tracciabilita grezzi.
	*
	* @return the foglio of this tracciabilita grezzi
	*/
	@Override
	public int getFoglio() {
		return _tracciabilitaGrezzi.getFoglio();
	}

	/**
	* Sets the foglio of this tracciabilita grezzi.
	*
	* @param foglio the foglio of this tracciabilita grezzi
	*/
	@Override
	public void setFoglio(int foglio) {
		_tracciabilitaGrezzi.setFoglio(foglio);
	}

	/**
	* Returns the particella of this tracciabilita grezzi.
	*
	* @return the particella of this tracciabilita grezzi
	*/
	@Override
	public int getParticella() {
		return _tracciabilitaGrezzi.getParticella();
	}

	/**
	* Sets the particella of this tracciabilita grezzi.
	*
	* @param particella the particella of this tracciabilita grezzi
	*/
	@Override
	public void setParticella(int particella) {
		_tracciabilitaGrezzi.setParticella(particella);
	}

	/**
	* Returns the id scheda tracciabilta of this tracciabilita grezzi.
	*
	* @return the id scheda tracciabilta of this tracciabilita grezzi
	*/
	@Override
	public long getIdSchedaTracciabilta() {
		return _tracciabilitaGrezzi.getIdSchedaTracciabilta();
	}

	/**
	* Sets the id scheda tracciabilta of this tracciabilita grezzi.
	*
	* @param idSchedaTracciabilta the id scheda tracciabilta of this tracciabilita grezzi
	*/
	@Override
	public void setIdSchedaTracciabilta(long idSchedaTracciabilta) {
		_tracciabilitaGrezzi.setIdSchedaTracciabilta(idSchedaTracciabilta);
	}

	@Override
	public boolean isNew() {
		return _tracciabilitaGrezzi.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_tracciabilitaGrezzi.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _tracciabilitaGrezzi.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tracciabilitaGrezzi.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _tracciabilitaGrezzi.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _tracciabilitaGrezzi.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tracciabilitaGrezzi.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tracciabilitaGrezzi.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_tracciabilitaGrezzi.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_tracciabilitaGrezzi.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tracciabilitaGrezzi.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TracciabilitaGrezziWrapper((TracciabilitaGrezzi)_tracciabilitaGrezzi.clone());
	}

	@Override
	public int compareTo(
		it.bysoftware.ct.model.TracciabilitaGrezzi tracciabilitaGrezzi) {
		return _tracciabilitaGrezzi.compareTo(tracciabilitaGrezzi);
	}

	@Override
	public int hashCode() {
		return _tracciabilitaGrezzi.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.bysoftware.ct.model.TracciabilitaGrezzi> toCacheModel() {
		return _tracciabilitaGrezzi.toCacheModel();
	}

	@Override
	public it.bysoftware.ct.model.TracciabilitaGrezzi toEscapedModel() {
		return new TracciabilitaGrezziWrapper(_tracciabilitaGrezzi.toEscapedModel());
	}

	@Override
	public it.bysoftware.ct.model.TracciabilitaGrezzi toUnescapedModel() {
		return new TracciabilitaGrezziWrapper(_tracciabilitaGrezzi.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tracciabilitaGrezzi.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tracciabilitaGrezzi.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tracciabilitaGrezzi.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TracciabilitaGrezziWrapper)) {
			return false;
		}

		TracciabilitaGrezziWrapper tracciabilitaGrezziWrapper = (TracciabilitaGrezziWrapper)obj;

		if (Validator.equals(_tracciabilitaGrezzi,
					tracciabilitaGrezziWrapper._tracciabilitaGrezzi)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TracciabilitaGrezzi getWrappedTracciabilitaGrezzi() {
		return _tracciabilitaGrezzi;
	}

	@Override
	public TracciabilitaGrezzi getWrappedModel() {
		return _tracciabilitaGrezzi;
	}

	@Override
	public void resetOriginalValues() {
		_tracciabilitaGrezzi.resetOriginalValues();
	}

	private TracciabilitaGrezzi _tracciabilitaGrezzi;
}
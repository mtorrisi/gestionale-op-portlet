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
 * This class is a wrapper for {@link BancheAppoggio}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BancheAppoggio
 * @generated
 */
public class BancheAppoggioWrapper implements BancheAppoggio,
	ModelWrapper<BancheAppoggio> {
	public BancheAppoggioWrapper(BancheAppoggio bancheAppoggio) {
		_bancheAppoggio = bancheAppoggio;
	}

	@Override
	public Class<?> getModelClass() {
		return BancheAppoggio.class;
	}

	@Override
	public String getModelClassName() {
		return BancheAppoggio.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cBanca", getCBanca());
		attributes.put("codiceABI", getCodiceABI());
		attributes.put("codiceAgenzia", getCodiceAgenzia());
		attributes.put("codiceBanca", getCodiceBanca());
		attributes.put("codiceCAB", getCodiceCAB());
		attributes.put("descrizione", getDescrizione());
		attributes.put("piazza", getPiazza());
		attributes.put("codiceAzienda", getCodiceAzienda());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String cBanca = (String)attributes.get("cBanca");

		if (cBanca != null) {
			setCBanca(cBanca);
		}

		Integer codiceABI = (Integer)attributes.get("codiceABI");

		if (codiceABI != null) {
			setCodiceABI(codiceABI);
		}

		String codiceAgenzia = (String)attributes.get("codiceAgenzia");

		if (codiceAgenzia != null) {
			setCodiceAgenzia(codiceAgenzia);
		}

		String codiceBanca = (String)attributes.get("codiceBanca");

		if (codiceBanca != null) {
			setCodiceBanca(codiceBanca);
		}

		Integer codiceCAB = (Integer)attributes.get("codiceCAB");

		if (codiceCAB != null) {
			setCodiceCAB(codiceCAB);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}

		String piazza = (String)attributes.get("piazza");

		if (piazza != null) {
			setPiazza(piazza);
		}

		String codiceAzienda = (String)attributes.get("codiceAzienda");

		if (codiceAzienda != null) {
			setCodiceAzienda(codiceAzienda);
		}
	}

	/**
	* Returns the primary key of this banche appoggio.
	*
	* @return the primary key of this banche appoggio
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _bancheAppoggio.getPrimaryKey();
	}

	/**
	* Sets the primary key of this banche appoggio.
	*
	* @param primaryKey the primary key of this banche appoggio
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_bancheAppoggio.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the c banca of this banche appoggio.
	*
	* @return the c banca of this banche appoggio
	*/
	@Override
	public java.lang.String getCBanca() {
		return _bancheAppoggio.getCBanca();
	}

	/**
	* Sets the c banca of this banche appoggio.
	*
	* @param cBanca the c banca of this banche appoggio
	*/
	@Override
	public void setCBanca(java.lang.String cBanca) {
		_bancheAppoggio.setCBanca(cBanca);
	}

	/**
	* Returns the codice a b i of this banche appoggio.
	*
	* @return the codice a b i of this banche appoggio
	*/
	@Override
	public int getCodiceABI() {
		return _bancheAppoggio.getCodiceABI();
	}

	/**
	* Sets the codice a b i of this banche appoggio.
	*
	* @param codiceABI the codice a b i of this banche appoggio
	*/
	@Override
	public void setCodiceABI(int codiceABI) {
		_bancheAppoggio.setCodiceABI(codiceABI);
	}

	/**
	* Returns the codice agenzia of this banche appoggio.
	*
	* @return the codice agenzia of this banche appoggio
	*/
	@Override
	public java.lang.String getCodiceAgenzia() {
		return _bancheAppoggio.getCodiceAgenzia();
	}

	/**
	* Sets the codice agenzia of this banche appoggio.
	*
	* @param codiceAgenzia the codice agenzia of this banche appoggio
	*/
	@Override
	public void setCodiceAgenzia(java.lang.String codiceAgenzia) {
		_bancheAppoggio.setCodiceAgenzia(codiceAgenzia);
	}

	/**
	* Returns the codice banca of this banche appoggio.
	*
	* @return the codice banca of this banche appoggio
	*/
	@Override
	public java.lang.String getCodiceBanca() {
		return _bancheAppoggio.getCodiceBanca();
	}

	/**
	* Sets the codice banca of this banche appoggio.
	*
	* @param codiceBanca the codice banca of this banche appoggio
	*/
	@Override
	public void setCodiceBanca(java.lang.String codiceBanca) {
		_bancheAppoggio.setCodiceBanca(codiceBanca);
	}

	/**
	* Returns the codice c a b of this banche appoggio.
	*
	* @return the codice c a b of this banche appoggio
	*/
	@Override
	public int getCodiceCAB() {
		return _bancheAppoggio.getCodiceCAB();
	}

	/**
	* Sets the codice c a b of this banche appoggio.
	*
	* @param codiceCAB the codice c a b of this banche appoggio
	*/
	@Override
	public void setCodiceCAB(int codiceCAB) {
		_bancheAppoggio.setCodiceCAB(codiceCAB);
	}

	/**
	* Returns the descrizione of this banche appoggio.
	*
	* @return the descrizione of this banche appoggio
	*/
	@Override
	public java.lang.String getDescrizione() {
		return _bancheAppoggio.getDescrizione();
	}

	/**
	* Sets the descrizione of this banche appoggio.
	*
	* @param descrizione the descrizione of this banche appoggio
	*/
	@Override
	public void setDescrizione(java.lang.String descrizione) {
		_bancheAppoggio.setDescrizione(descrizione);
	}

	/**
	* Returns the piazza of this banche appoggio.
	*
	* @return the piazza of this banche appoggio
	*/
	@Override
	public java.lang.String getPiazza() {
		return _bancheAppoggio.getPiazza();
	}

	/**
	* Sets the piazza of this banche appoggio.
	*
	* @param piazza the piazza of this banche appoggio
	*/
	@Override
	public void setPiazza(java.lang.String piazza) {
		_bancheAppoggio.setPiazza(piazza);
	}

	/**
	* Returns the codice azienda of this banche appoggio.
	*
	* @return the codice azienda of this banche appoggio
	*/
	@Override
	public java.lang.String getCodiceAzienda() {
		return _bancheAppoggio.getCodiceAzienda();
	}

	/**
	* Sets the codice azienda of this banche appoggio.
	*
	* @param codiceAzienda the codice azienda of this banche appoggio
	*/
	@Override
	public void setCodiceAzienda(java.lang.String codiceAzienda) {
		_bancheAppoggio.setCodiceAzienda(codiceAzienda);
	}

	@Override
	public boolean isNew() {
		return _bancheAppoggio.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_bancheAppoggio.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _bancheAppoggio.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_bancheAppoggio.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _bancheAppoggio.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _bancheAppoggio.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_bancheAppoggio.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _bancheAppoggio.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_bancheAppoggio.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_bancheAppoggio.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_bancheAppoggio.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BancheAppoggioWrapper((BancheAppoggio)_bancheAppoggio.clone());
	}

	@Override
	public int compareTo(it.bysoftware.ct.model.BancheAppoggio bancheAppoggio) {
		return _bancheAppoggio.compareTo(bancheAppoggio);
	}

	@Override
	public int hashCode() {
		return _bancheAppoggio.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.bysoftware.ct.model.BancheAppoggio> toCacheModel() {
		return _bancheAppoggio.toCacheModel();
	}

	@Override
	public it.bysoftware.ct.model.BancheAppoggio toEscapedModel() {
		return new BancheAppoggioWrapper(_bancheAppoggio.toEscapedModel());
	}

	@Override
	public it.bysoftware.ct.model.BancheAppoggio toUnescapedModel() {
		return new BancheAppoggioWrapper(_bancheAppoggio.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _bancheAppoggio.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _bancheAppoggio.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_bancheAppoggio.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BancheAppoggioWrapper)) {
			return false;
		}

		BancheAppoggioWrapper bancheAppoggioWrapper = (BancheAppoggioWrapper)obj;

		if (Validator.equals(_bancheAppoggio,
					bancheAppoggioWrapper._bancheAppoggio)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BancheAppoggio getWrappedBancheAppoggio() {
		return _bancheAppoggio;
	}

	@Override
	public BancheAppoggio getWrappedModel() {
		return _bancheAppoggio;
	}

	@Override
	public void resetOriginalValues() {
		_bancheAppoggio.resetOriginalValues();
	}

	private BancheAppoggio _bancheAppoggio;
}
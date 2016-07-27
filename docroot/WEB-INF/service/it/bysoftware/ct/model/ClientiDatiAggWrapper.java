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
 * This class is a wrapper for {@link ClientiDatiAgg}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClientiDatiAgg
 * @generated
 */
public class ClientiDatiAggWrapper implements ClientiDatiAgg,
	ModelWrapper<ClientiDatiAgg> {
	public ClientiDatiAggWrapper(ClientiDatiAgg clientiDatiAgg) {
		_clientiDatiAgg = clientiDatiAgg;
	}

	@Override
	public Class<?> getModelClass() {
		return ClientiDatiAgg.class;
	}

	@Override
	public String getModelClassName() {
		return ClientiDatiAgg.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("codiceAnagrafica", getCodiceAnagrafica());
		attributes.put("tipo", getTipo());
		attributes.put("associati", getAssociati());
		attributes.put("codiceAliquota", getCodiceAliquota());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String codiceAnagrafica = (String)attributes.get("codiceAnagrafica");

		if (codiceAnagrafica != null) {
			setCodiceAnagrafica(codiceAnagrafica);
		}

		Boolean tipo = (Boolean)attributes.get("tipo");

		if (tipo != null) {
			setTipo(tipo);
		}

		String associati = (String)attributes.get("associati");

		if (associati != null) {
			setAssociati(associati);
		}

		String codiceAliquota = (String)attributes.get("codiceAliquota");

		if (codiceAliquota != null) {
			setCodiceAliquota(codiceAliquota);
		}
	}

	/**
	* Returns the primary key of this clienti dati agg.
	*
	* @return the primary key of this clienti dati agg
	*/
	@Override
	public it.bysoftware.ct.service.persistence.ClientiDatiAggPK getPrimaryKey() {
		return _clientiDatiAgg.getPrimaryKey();
	}

	/**
	* Sets the primary key of this clienti dati agg.
	*
	* @param primaryKey the primary key of this clienti dati agg
	*/
	@Override
	public void setPrimaryKey(
		it.bysoftware.ct.service.persistence.ClientiDatiAggPK primaryKey) {
		_clientiDatiAgg.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the codice anagrafica of this clienti dati agg.
	*
	* @return the codice anagrafica of this clienti dati agg
	*/
	@Override
	public java.lang.String getCodiceAnagrafica() {
		return _clientiDatiAgg.getCodiceAnagrafica();
	}

	/**
	* Sets the codice anagrafica of this clienti dati agg.
	*
	* @param codiceAnagrafica the codice anagrafica of this clienti dati agg
	*/
	@Override
	public void setCodiceAnagrafica(java.lang.String codiceAnagrafica) {
		_clientiDatiAgg.setCodiceAnagrafica(codiceAnagrafica);
	}

	/**
	* Returns the tipo of this clienti dati agg.
	*
	* @return the tipo of this clienti dati agg
	*/
	@Override
	public boolean getTipo() {
		return _clientiDatiAgg.getTipo();
	}

	/**
	* Returns <code>true</code> if this clienti dati agg is tipo.
	*
	* @return <code>true</code> if this clienti dati agg is tipo; <code>false</code> otherwise
	*/
	@Override
	public boolean isTipo() {
		return _clientiDatiAgg.isTipo();
	}

	/**
	* Sets whether this clienti dati agg is tipo.
	*
	* @param tipo the tipo of this clienti dati agg
	*/
	@Override
	public void setTipo(boolean tipo) {
		_clientiDatiAgg.setTipo(tipo);
	}

	/**
	* Returns the associati of this clienti dati agg.
	*
	* @return the associati of this clienti dati agg
	*/
	@Override
	public java.lang.String getAssociati() {
		return _clientiDatiAgg.getAssociati();
	}

	/**
	* Sets the associati of this clienti dati agg.
	*
	* @param associati the associati of this clienti dati agg
	*/
	@Override
	public void setAssociati(java.lang.String associati) {
		_clientiDatiAgg.setAssociati(associati);
	}

	/**
	* Returns the codice aliquota of this clienti dati agg.
	*
	* @return the codice aliquota of this clienti dati agg
	*/
	@Override
	public java.lang.String getCodiceAliquota() {
		return _clientiDatiAgg.getCodiceAliquota();
	}

	/**
	* Sets the codice aliquota of this clienti dati agg.
	*
	* @param codiceAliquota the codice aliquota of this clienti dati agg
	*/
	@Override
	public void setCodiceAliquota(java.lang.String codiceAliquota) {
		_clientiDatiAgg.setCodiceAliquota(codiceAliquota);
	}

	@Override
	public boolean isNew() {
		return _clientiDatiAgg.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_clientiDatiAgg.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _clientiDatiAgg.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_clientiDatiAgg.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _clientiDatiAgg.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _clientiDatiAgg.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_clientiDatiAgg.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _clientiDatiAgg.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_clientiDatiAgg.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_clientiDatiAgg.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_clientiDatiAgg.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ClientiDatiAggWrapper((ClientiDatiAgg)_clientiDatiAgg.clone());
	}

	@Override
	public int compareTo(it.bysoftware.ct.model.ClientiDatiAgg clientiDatiAgg) {
		return _clientiDatiAgg.compareTo(clientiDatiAgg);
	}

	@Override
	public int hashCode() {
		return _clientiDatiAgg.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.bysoftware.ct.model.ClientiDatiAgg> toCacheModel() {
		return _clientiDatiAgg.toCacheModel();
	}

	@Override
	public it.bysoftware.ct.model.ClientiDatiAgg toEscapedModel() {
		return new ClientiDatiAggWrapper(_clientiDatiAgg.toEscapedModel());
	}

	@Override
	public it.bysoftware.ct.model.ClientiDatiAgg toUnescapedModel() {
		return new ClientiDatiAggWrapper(_clientiDatiAgg.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _clientiDatiAgg.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _clientiDatiAgg.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_clientiDatiAgg.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ClientiDatiAggWrapper)) {
			return false;
		}

		ClientiDatiAggWrapper clientiDatiAggWrapper = (ClientiDatiAggWrapper)obj;

		if (Validator.equals(_clientiDatiAgg,
					clientiDatiAggWrapper._clientiDatiAgg)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ClientiDatiAgg getWrappedClientiDatiAgg() {
		return _clientiDatiAgg;
	}

	@Override
	public ClientiDatiAgg getWrappedModel() {
		return _clientiDatiAgg;
	}

	@Override
	public void resetOriginalValues() {
		_clientiDatiAgg.resetOriginalValues();
	}

	private ClientiDatiAgg _clientiDatiAgg;
}
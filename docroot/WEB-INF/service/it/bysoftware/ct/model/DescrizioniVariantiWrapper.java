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
 * This class is a wrapper for {@link DescrizioniVarianti}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DescrizioniVarianti
 * @generated
 */
public class DescrizioniVariantiWrapper implements DescrizioniVarianti,
	ModelWrapper<DescrizioniVarianti> {
	public DescrizioniVariantiWrapper(DescrizioniVarianti descrizioniVarianti) {
		_descrizioniVarianti = descrizioniVarianti;
	}

	@Override
	public Class<?> getModelClass() {
		return DescrizioniVarianti.class;
	}

	@Override
	public String getModelClassName() {
		return DescrizioniVarianti.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("codiceVariante", getCodiceVariante());
		attributes.put("descrizioneVariante", getDescrizioneVariante());
		attributes.put("ordine", getOrdine());
		attributes.put("tipoVariante", getTipoVariante());
		attributes.put("codiceAzienda", getCodiceAzienda());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String codiceVariante = (String)attributes.get("codiceVariante");

		if (codiceVariante != null) {
			setCodiceVariante(codiceVariante);
		}

		String descrizioneVariante = (String)attributes.get(
				"descrizioneVariante");

		if (descrizioneVariante != null) {
			setDescrizioneVariante(descrizioneVariante);
		}

		Integer ordine = (Integer)attributes.get("ordine");

		if (ordine != null) {
			setOrdine(ordine);
		}

		String tipoVariante = (String)attributes.get("tipoVariante");

		if (tipoVariante != null) {
			setTipoVariante(tipoVariante);
		}

		String codiceAzienda = (String)attributes.get("codiceAzienda");

		if (codiceAzienda != null) {
			setCodiceAzienda(codiceAzienda);
		}
	}

	/**
	* Returns the primary key of this descrizioni varianti.
	*
	* @return the primary key of this descrizioni varianti
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _descrizioniVarianti.getPrimaryKey();
	}

	/**
	* Sets the primary key of this descrizioni varianti.
	*
	* @param primaryKey the primary key of this descrizioni varianti
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_descrizioniVarianti.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the codice variante of this descrizioni varianti.
	*
	* @return the codice variante of this descrizioni varianti
	*/
	@Override
	public java.lang.String getCodiceVariante() {
		return _descrizioniVarianti.getCodiceVariante();
	}

	/**
	* Sets the codice variante of this descrizioni varianti.
	*
	* @param codiceVariante the codice variante of this descrizioni varianti
	*/
	@Override
	public void setCodiceVariante(java.lang.String codiceVariante) {
		_descrizioniVarianti.setCodiceVariante(codiceVariante);
	}

	/**
	* Returns the descrizione variante of this descrizioni varianti.
	*
	* @return the descrizione variante of this descrizioni varianti
	*/
	@Override
	public java.lang.String getDescrizioneVariante() {
		return _descrizioniVarianti.getDescrizioneVariante();
	}

	/**
	* Sets the descrizione variante of this descrizioni varianti.
	*
	* @param descrizioneVariante the descrizione variante of this descrizioni varianti
	*/
	@Override
	public void setDescrizioneVariante(java.lang.String descrizioneVariante) {
		_descrizioniVarianti.setDescrizioneVariante(descrizioneVariante);
	}

	/**
	* Returns the ordine of this descrizioni varianti.
	*
	* @return the ordine of this descrizioni varianti
	*/
	@Override
	public int getOrdine() {
		return _descrizioniVarianti.getOrdine();
	}

	/**
	* Sets the ordine of this descrizioni varianti.
	*
	* @param ordine the ordine of this descrizioni varianti
	*/
	@Override
	public void setOrdine(int ordine) {
		_descrizioniVarianti.setOrdine(ordine);
	}

	/**
	* Returns the tipo variante of this descrizioni varianti.
	*
	* @return the tipo variante of this descrizioni varianti
	*/
	@Override
	public java.lang.String getTipoVariante() {
		return _descrizioniVarianti.getTipoVariante();
	}

	/**
	* Sets the tipo variante of this descrizioni varianti.
	*
	* @param tipoVariante the tipo variante of this descrizioni varianti
	*/
	@Override
	public void setTipoVariante(java.lang.String tipoVariante) {
		_descrizioniVarianti.setTipoVariante(tipoVariante);
	}

	/**
	* Returns the codice azienda of this descrizioni varianti.
	*
	* @return the codice azienda of this descrizioni varianti
	*/
	@Override
	public java.lang.String getCodiceAzienda() {
		return _descrizioniVarianti.getCodiceAzienda();
	}

	/**
	* Sets the codice azienda of this descrizioni varianti.
	*
	* @param codiceAzienda the codice azienda of this descrizioni varianti
	*/
	@Override
	public void setCodiceAzienda(java.lang.String codiceAzienda) {
		_descrizioniVarianti.setCodiceAzienda(codiceAzienda);
	}

	@Override
	public boolean isNew() {
		return _descrizioniVarianti.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_descrizioniVarianti.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _descrizioniVarianti.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_descrizioniVarianti.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _descrizioniVarianti.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _descrizioniVarianti.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_descrizioniVarianti.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _descrizioniVarianti.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_descrizioniVarianti.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_descrizioniVarianti.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_descrizioniVarianti.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DescrizioniVariantiWrapper((DescrizioniVarianti)_descrizioniVarianti.clone());
	}

	@Override
	public int compareTo(
		it.bysoftware.ct.model.DescrizioniVarianti descrizioniVarianti) {
		return _descrizioniVarianti.compareTo(descrizioniVarianti);
	}

	@Override
	public int hashCode() {
		return _descrizioniVarianti.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.bysoftware.ct.model.DescrizioniVarianti> toCacheModel() {
		return _descrizioniVarianti.toCacheModel();
	}

	@Override
	public it.bysoftware.ct.model.DescrizioniVarianti toEscapedModel() {
		return new DescrizioniVariantiWrapper(_descrizioniVarianti.toEscapedModel());
	}

	@Override
	public it.bysoftware.ct.model.DescrizioniVarianti toUnescapedModel() {
		return new DescrizioniVariantiWrapper(_descrizioniVarianti.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _descrizioniVarianti.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _descrizioniVarianti.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_descrizioniVarianti.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DescrizioniVariantiWrapper)) {
			return false;
		}

		DescrizioniVariantiWrapper descrizioniVariantiWrapper = (DescrizioniVariantiWrapper)obj;

		if (Validator.equals(_descrizioniVarianti,
					descrizioniVariantiWrapper._descrizioniVarianti)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DescrizioniVarianti getWrappedDescrizioniVarianti() {
		return _descrizioniVarianti;
	}

	@Override
	public DescrizioniVarianti getWrappedModel() {
		return _descrizioniVarianti;
	}

	@Override
	public void resetOriginalValues() {
		_descrizioniVarianti.resetOriginalValues();
	}

	private DescrizioniVarianti _descrizioniVarianti;
}
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
 * This class is a wrapper for {@link Articoli}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Articoli
 * @generated
 */
public class ArticoliWrapper implements Articoli, ModelWrapper<Articoli> {
	public ArticoliWrapper(Articoli articoli) {
		_articoli = articoli;
	}

	@Override
	public Class<?> getModelClass() {
		return Articoli.class;
	}

	@Override
	public String getModelClassName() {
		return Articoli.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("codiceArticolo", getCodiceArticolo());
		attributes.put("categoriaMerceologica", getCategoriaMerceologica());
		attributes.put("descrizione", getDescrizione());
		attributes.put("descrizioneDocumento", getDescrizioneDocumento());
		attributes.put("descrizioneFiscale", getDescrizioneFiscale());
		attributes.put("tara", getTara());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String codiceArticolo = (String)attributes.get("codiceArticolo");

		if (codiceArticolo != null) {
			setCodiceArticolo(codiceArticolo);
		}

		String categoriaMerceologica = (String)attributes.get(
				"categoriaMerceologica");

		if (categoriaMerceologica != null) {
			setCategoriaMerceologica(categoriaMerceologica);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}

		String descrizioneDocumento = (String)attributes.get(
				"descrizioneDocumento");

		if (descrizioneDocumento != null) {
			setDescrizioneDocumento(descrizioneDocumento);
		}

		String descrizioneFiscale = (String)attributes.get("descrizioneFiscale");

		if (descrizioneFiscale != null) {
			setDescrizioneFiscale(descrizioneFiscale);
		}

		Double tara = (Double)attributes.get("tara");

		if (tara != null) {
			setTara(tara);
		}
	}

	/**
	* Returns the primary key of this articoli.
	*
	* @return the primary key of this articoli
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _articoli.getPrimaryKey();
	}

	/**
	* Sets the primary key of this articoli.
	*
	* @param primaryKey the primary key of this articoli
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_articoli.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the codice articolo of this articoli.
	*
	* @return the codice articolo of this articoli
	*/
	@Override
	public java.lang.String getCodiceArticolo() {
		return _articoli.getCodiceArticolo();
	}

	/**
	* Sets the codice articolo of this articoli.
	*
	* @param codiceArticolo the codice articolo of this articoli
	*/
	@Override
	public void setCodiceArticolo(java.lang.String codiceArticolo) {
		_articoli.setCodiceArticolo(codiceArticolo);
	}

	/**
	* Returns the categoria merceologica of this articoli.
	*
	* @return the categoria merceologica of this articoli
	*/
	@Override
	public java.lang.String getCategoriaMerceologica() {
		return _articoli.getCategoriaMerceologica();
	}

	/**
	* Sets the categoria merceologica of this articoli.
	*
	* @param categoriaMerceologica the categoria merceologica of this articoli
	*/
	@Override
	public void setCategoriaMerceologica(java.lang.String categoriaMerceologica) {
		_articoli.setCategoriaMerceologica(categoriaMerceologica);
	}

	/**
	* Returns the descrizione of this articoli.
	*
	* @return the descrizione of this articoli
	*/
	@Override
	public java.lang.String getDescrizione() {
		return _articoli.getDescrizione();
	}

	/**
	* Sets the descrizione of this articoli.
	*
	* @param descrizione the descrizione of this articoli
	*/
	@Override
	public void setDescrizione(java.lang.String descrizione) {
		_articoli.setDescrizione(descrizione);
	}

	/**
	* Returns the descrizione documento of this articoli.
	*
	* @return the descrizione documento of this articoli
	*/
	@Override
	public java.lang.String getDescrizioneDocumento() {
		return _articoli.getDescrizioneDocumento();
	}

	/**
	* Sets the descrizione documento of this articoli.
	*
	* @param descrizioneDocumento the descrizione documento of this articoli
	*/
	@Override
	public void setDescrizioneDocumento(java.lang.String descrizioneDocumento) {
		_articoli.setDescrizioneDocumento(descrizioneDocumento);
	}

	/**
	* Returns the descrizione fiscale of this articoli.
	*
	* @return the descrizione fiscale of this articoli
	*/
	@Override
	public java.lang.String getDescrizioneFiscale() {
		return _articoli.getDescrizioneFiscale();
	}

	/**
	* Sets the descrizione fiscale of this articoli.
	*
	* @param descrizioneFiscale the descrizione fiscale of this articoli
	*/
	@Override
	public void setDescrizioneFiscale(java.lang.String descrizioneFiscale) {
		_articoli.setDescrizioneFiscale(descrizioneFiscale);
	}

	/**
	* Returns the tara of this articoli.
	*
	* @return the tara of this articoli
	*/
	@Override
	public double getTara() {
		return _articoli.getTara();
	}

	/**
	* Sets the tara of this articoli.
	*
	* @param tara the tara of this articoli
	*/
	@Override
	public void setTara(double tara) {
		_articoli.setTara(tara);
	}

	@Override
	public boolean isNew() {
		return _articoli.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_articoli.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _articoli.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_articoli.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _articoli.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _articoli.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_articoli.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _articoli.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_articoli.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_articoli.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_articoli.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ArticoliWrapper((Articoli)_articoli.clone());
	}

	@Override
	public int compareTo(it.bysoftware.ct.model.Articoli articoli) {
		return _articoli.compareTo(articoli);
	}

	@Override
	public int hashCode() {
		return _articoli.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.bysoftware.ct.model.Articoli> toCacheModel() {
		return _articoli.toCacheModel();
	}

	@Override
	public it.bysoftware.ct.model.Articoli toEscapedModel() {
		return new ArticoliWrapper(_articoli.toEscapedModel());
	}

	@Override
	public it.bysoftware.ct.model.Articoli toUnescapedModel() {
		return new ArticoliWrapper(_articoli.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _articoli.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _articoli.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_articoli.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ArticoliWrapper)) {
			return false;
		}

		ArticoliWrapper articoliWrapper = (ArticoliWrapper)obj;

		if (Validator.equals(_articoli, articoliWrapper._articoli)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Articoli getWrappedArticoli() {
		return _articoli;
	}

	@Override
	public Articoli getWrappedModel() {
		return _articoli;
	}

	@Override
	public void resetOriginalValues() {
		_articoli.resetOriginalValues();
	}

	private Articoli _articoli;
}
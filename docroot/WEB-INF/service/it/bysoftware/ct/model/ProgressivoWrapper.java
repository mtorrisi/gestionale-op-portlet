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
 * This class is a wrapper for {@link Progressivo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Progressivo
 * @generated
 */
public class ProgressivoWrapper implements Progressivo,
	ModelWrapper<Progressivo> {
	public ProgressivoWrapper(Progressivo progressivo) {
		_progressivo = progressivo;
	}

	@Override
	public Class<?> getModelClass() {
		return Progressivo.class;
	}

	@Override
	public String getModelClassName() {
		return Progressivo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("anno", getAnno());
		attributes.put("idAssociato", getIdAssociato());
		attributes.put("codiceCentro", getCodiceCentro());
		attributes.put("codiceDeposito", getCodiceDeposito());
		attributes.put("dataRegistrazione", getDataRegistrazione());
		attributes.put("numeroBolla", getNumeroBolla());
		attributes.put("tipoDocumento", getTipoDocumento());
		attributes.put("numeroProgressivo", getNumeroProgressivo());
		attributes.put("tipoCon", getTipoCon());
		attributes.put("codiceAzienda", getCodiceAzienda());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer anno = (Integer)attributes.get("anno");

		if (anno != null) {
			setAnno(anno);
		}

		Long idAssociato = (Long)attributes.get("idAssociato");

		if (idAssociato != null) {
			setIdAssociato(idAssociato);
		}

		String codiceCentro = (String)attributes.get("codiceCentro");

		if (codiceCentro != null) {
			setCodiceCentro(codiceCentro);
		}

		String codiceDeposito = (String)attributes.get("codiceDeposito");

		if (codiceDeposito != null) {
			setCodiceDeposito(codiceDeposito);
		}

		String dataRegistrazione = (String)attributes.get("dataRegistrazione");

		if (dataRegistrazione != null) {
			setDataRegistrazione(dataRegistrazione);
		}

		Long numeroBolla = (Long)attributes.get("numeroBolla");

		if (numeroBolla != null) {
			setNumeroBolla(numeroBolla);
		}

		Integer tipoDocumento = (Integer)attributes.get("tipoDocumento");

		if (tipoDocumento != null) {
			setTipoDocumento(tipoDocumento);
		}

		Integer numeroProgressivo = (Integer)attributes.get("numeroProgressivo");

		if (numeroProgressivo != null) {
			setNumeroProgressivo(numeroProgressivo);
		}

		Integer tipoCon = (Integer)attributes.get("tipoCon");

		if (tipoCon != null) {
			setTipoCon(tipoCon);
		}

		String codiceAzienda = (String)attributes.get("codiceAzienda");

		if (codiceAzienda != null) {
			setCodiceAzienda(codiceAzienda);
		}
	}

	/**
	* Returns the primary key of this progressivo.
	*
	* @return the primary key of this progressivo
	*/
	@Override
	public it.bysoftware.ct.service.persistence.ProgressivoPK getPrimaryKey() {
		return _progressivo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this progressivo.
	*
	* @param primaryKey the primary key of this progressivo
	*/
	@Override
	public void setPrimaryKey(
		it.bysoftware.ct.service.persistence.ProgressivoPK primaryKey) {
		_progressivo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the anno of this progressivo.
	*
	* @return the anno of this progressivo
	*/
	@Override
	public int getAnno() {
		return _progressivo.getAnno();
	}

	/**
	* Sets the anno of this progressivo.
	*
	* @param anno the anno of this progressivo
	*/
	@Override
	public void setAnno(int anno) {
		_progressivo.setAnno(anno);
	}

	/**
	* Returns the id associato of this progressivo.
	*
	* @return the id associato of this progressivo
	*/
	@Override
	public long getIdAssociato() {
		return _progressivo.getIdAssociato();
	}

	/**
	* Sets the id associato of this progressivo.
	*
	* @param idAssociato the id associato of this progressivo
	*/
	@Override
	public void setIdAssociato(long idAssociato) {
		_progressivo.setIdAssociato(idAssociato);
	}

	/**
	* Returns the codice centro of this progressivo.
	*
	* @return the codice centro of this progressivo
	*/
	@Override
	public java.lang.String getCodiceCentro() {
		return _progressivo.getCodiceCentro();
	}

	/**
	* Sets the codice centro of this progressivo.
	*
	* @param codiceCentro the codice centro of this progressivo
	*/
	@Override
	public void setCodiceCentro(java.lang.String codiceCentro) {
		_progressivo.setCodiceCentro(codiceCentro);
	}

	/**
	* Returns the codice deposito of this progressivo.
	*
	* @return the codice deposito of this progressivo
	*/
	@Override
	public java.lang.String getCodiceDeposito() {
		return _progressivo.getCodiceDeposito();
	}

	/**
	* Sets the codice deposito of this progressivo.
	*
	* @param codiceDeposito the codice deposito of this progressivo
	*/
	@Override
	public void setCodiceDeposito(java.lang.String codiceDeposito) {
		_progressivo.setCodiceDeposito(codiceDeposito);
	}

	/**
	* Returns the data registrazione of this progressivo.
	*
	* @return the data registrazione of this progressivo
	*/
	@Override
	public java.lang.String getDataRegistrazione() {
		return _progressivo.getDataRegistrazione();
	}

	/**
	* Sets the data registrazione of this progressivo.
	*
	* @param dataRegistrazione the data registrazione of this progressivo
	*/
	@Override
	public void setDataRegistrazione(java.lang.String dataRegistrazione) {
		_progressivo.setDataRegistrazione(dataRegistrazione);
	}

	/**
	* Returns the numero bolla of this progressivo.
	*
	* @return the numero bolla of this progressivo
	*/
	@Override
	public long getNumeroBolla() {
		return _progressivo.getNumeroBolla();
	}

	/**
	* Sets the numero bolla of this progressivo.
	*
	* @param numeroBolla the numero bolla of this progressivo
	*/
	@Override
	public void setNumeroBolla(long numeroBolla) {
		_progressivo.setNumeroBolla(numeroBolla);
	}

	/**
	* Returns the tipo documento of this progressivo.
	*
	* @return the tipo documento of this progressivo
	*/
	@Override
	public int getTipoDocumento() {
		return _progressivo.getTipoDocumento();
	}

	/**
	* Sets the tipo documento of this progressivo.
	*
	* @param tipoDocumento the tipo documento of this progressivo
	*/
	@Override
	public void setTipoDocumento(int tipoDocumento) {
		_progressivo.setTipoDocumento(tipoDocumento);
	}

	/**
	* Returns the numero progressivo of this progressivo.
	*
	* @return the numero progressivo of this progressivo
	*/
	@Override
	public int getNumeroProgressivo() {
		return _progressivo.getNumeroProgressivo();
	}

	/**
	* Sets the numero progressivo of this progressivo.
	*
	* @param numeroProgressivo the numero progressivo of this progressivo
	*/
	@Override
	public void setNumeroProgressivo(int numeroProgressivo) {
		_progressivo.setNumeroProgressivo(numeroProgressivo);
	}

	/**
	* Returns the tipo con of this progressivo.
	*
	* @return the tipo con of this progressivo
	*/
	@Override
	public int getTipoCon() {
		return _progressivo.getTipoCon();
	}

	/**
	* Sets the tipo con of this progressivo.
	*
	* @param tipoCon the tipo con of this progressivo
	*/
	@Override
	public void setTipoCon(int tipoCon) {
		_progressivo.setTipoCon(tipoCon);
	}

	/**
	* Returns the codice azienda of this progressivo.
	*
	* @return the codice azienda of this progressivo
	*/
	@Override
	public java.lang.String getCodiceAzienda() {
		return _progressivo.getCodiceAzienda();
	}

	/**
	* Sets the codice azienda of this progressivo.
	*
	* @param codiceAzienda the codice azienda of this progressivo
	*/
	@Override
	public void setCodiceAzienda(java.lang.String codiceAzienda) {
		_progressivo.setCodiceAzienda(codiceAzienda);
	}

	@Override
	public boolean isNew() {
		return _progressivo.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_progressivo.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _progressivo.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_progressivo.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _progressivo.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _progressivo.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_progressivo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _progressivo.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_progressivo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_progressivo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_progressivo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProgressivoWrapper((Progressivo)_progressivo.clone());
	}

	@Override
	public int compareTo(it.bysoftware.ct.model.Progressivo progressivo) {
		return _progressivo.compareTo(progressivo);
	}

	@Override
	public int hashCode() {
		return _progressivo.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.bysoftware.ct.model.Progressivo> toCacheModel() {
		return _progressivo.toCacheModel();
	}

	@Override
	public it.bysoftware.ct.model.Progressivo toEscapedModel() {
		return new ProgressivoWrapper(_progressivo.toEscapedModel());
	}

	@Override
	public it.bysoftware.ct.model.Progressivo toUnescapedModel() {
		return new ProgressivoWrapper(_progressivo.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _progressivo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _progressivo.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_progressivo.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProgressivoWrapper)) {
			return false;
		}

		ProgressivoWrapper progressivoWrapper = (ProgressivoWrapper)obj;

		if (Validator.equals(_progressivo, progressivoWrapper._progressivo)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Progressivo getWrappedProgressivo() {
		return _progressivo;
	}

	@Override
	public Progressivo getWrappedModel() {
		return _progressivo;
	}

	@Override
	public void resetOriginalValues() {
		_progressivo.resetOriginalValues();
	}

	private Progressivo _progressivo;
}
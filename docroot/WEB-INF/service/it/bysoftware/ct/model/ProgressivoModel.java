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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import it.bysoftware.ct.service.persistence.ProgressivoPK;

import java.io.Serializable;

/**
 * The base model interface for the Progressivo service. Represents a row in the &quot;ProgAnnFor&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.bysoftware.ct.model.impl.ProgressivoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.bysoftware.ct.model.impl.ProgressivoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Progressivo
 * @see it.bysoftware.ct.model.impl.ProgressivoImpl
 * @see it.bysoftware.ct.model.impl.ProgressivoModelImpl
 * @generated
 */
public interface ProgressivoModel extends BaseModel<Progressivo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a progressivo model instance should use the {@link Progressivo} interface instead.
	 */

	/**
	 * Returns the primary key of this progressivo.
	 *
	 * @return the primary key of this progressivo
	 */
	public ProgressivoPK getPrimaryKey();

	/**
	 * Sets the primary key of this progressivo.
	 *
	 * @param primaryKey the primary key of this progressivo
	 */
	public void setPrimaryKey(ProgressivoPK primaryKey);

	/**
	 * Returns the anno of this progressivo.
	 *
	 * @return the anno of this progressivo
	 */
	public int getAnno();

	/**
	 * Sets the anno of this progressivo.
	 *
	 * @param anno the anno of this progressivo
	 */
	public void setAnno(int anno);

	/**
	 * Returns the id associato of this progressivo.
	 *
	 * @return the id associato of this progressivo
	 */
	public long getIdAssociato();

	/**
	 * Sets the id associato of this progressivo.
	 *
	 * @param idAssociato the id associato of this progressivo
	 */
	public void setIdAssociato(long idAssociato);

	/**
	 * Returns the codice centro of this progressivo.
	 *
	 * @return the codice centro of this progressivo
	 */
	@AutoEscape
	public String getCodiceCentro();

	/**
	 * Sets the codice centro of this progressivo.
	 *
	 * @param codiceCentro the codice centro of this progressivo
	 */
	public void setCodiceCentro(String codiceCentro);

	/**
	 * Returns the codice deposito of this progressivo.
	 *
	 * @return the codice deposito of this progressivo
	 */
	@AutoEscape
	public String getCodiceDeposito();

	/**
	 * Sets the codice deposito of this progressivo.
	 *
	 * @param codiceDeposito the codice deposito of this progressivo
	 */
	public void setCodiceDeposito(String codiceDeposito);

	/**
	 * Returns the data registrazione of this progressivo.
	 *
	 * @return the data registrazione of this progressivo
	 */
	@AutoEscape
	public String getDataRegistrazione();

	/**
	 * Sets the data registrazione of this progressivo.
	 *
	 * @param dataRegistrazione the data registrazione of this progressivo
	 */
	public void setDataRegistrazione(String dataRegistrazione);

	/**
	 * Returns the numero bolla of this progressivo.
	 *
	 * @return the numero bolla of this progressivo
	 */
	public long getNumeroBolla();

	/**
	 * Sets the numero bolla of this progressivo.
	 *
	 * @param numeroBolla the numero bolla of this progressivo
	 */
	public void setNumeroBolla(long numeroBolla);

	/**
	 * Returns the tipo documento of this progressivo.
	 *
	 * @return the tipo documento of this progressivo
	 */
	public int getTipoDocumento();

	/**
	 * Sets the tipo documento of this progressivo.
	 *
	 * @param tipoDocumento the tipo documento of this progressivo
	 */
	public void setTipoDocumento(int tipoDocumento);

	/**
	 * Returns the numero progressivo of this progressivo.
	 *
	 * @return the numero progressivo of this progressivo
	 */
	public int getNumeroProgressivo();

	/**
	 * Sets the numero progressivo of this progressivo.
	 *
	 * @param numeroProgressivo the numero progressivo of this progressivo
	 */
	public void setNumeroProgressivo(int numeroProgressivo);

	/**
	 * Returns the tipo con of this progressivo.
	 *
	 * @return the tipo con of this progressivo
	 */
	public int getTipoCon();

	/**
	 * Sets the tipo con of this progressivo.
	 *
	 * @param tipoCon the tipo con of this progressivo
	 */
	public void setTipoCon(int tipoCon);

	/**
	 * Returns the codice azienda of this progressivo.
	 *
	 * @return the codice azienda of this progressivo
	 */
	@AutoEscape
	public String getCodiceAzienda();

	/**
	 * Sets the codice azienda of this progressivo.
	 *
	 * @param codiceAzienda the codice azienda of this progressivo
	 */
	public void setCodiceAzienda(String codiceAzienda);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(it.bysoftware.ct.model.Progressivo progressivo);

	@Override
	public int hashCode();

	@Override
	public CacheModel<it.bysoftware.ct.model.Progressivo> toCacheModel();

	@Override
	public it.bysoftware.ct.model.Progressivo toEscapedModel();

	@Override
	public it.bysoftware.ct.model.Progressivo toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
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

import java.io.Serializable;

/**
 * The base model interface for the Articoli service. Represents a row in the &quot;Articoli&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.bysoftware.ct.model.impl.ArticoliModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.bysoftware.ct.model.impl.ArticoliImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Articoli
 * @see it.bysoftware.ct.model.impl.ArticoliImpl
 * @see it.bysoftware.ct.model.impl.ArticoliModelImpl
 * @generated
 */
public interface ArticoliModel extends BaseModel<Articoli> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a articoli model instance should use the {@link Articoli} interface instead.
	 */

	/**
	 * Returns the primary key of this articoli.
	 *
	 * @return the primary key of this articoli
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this articoli.
	 *
	 * @param primaryKey the primary key of this articoli
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the codice articolo of this articoli.
	 *
	 * @return the codice articolo of this articoli
	 */
	@AutoEscape
	public String getCodiceArticolo();

	/**
	 * Sets the codice articolo of this articoli.
	 *
	 * @param codiceArticolo the codice articolo of this articoli
	 */
	public void setCodiceArticolo(String codiceArticolo);

	/**
	 * Returns the categoria merceologica of this articoli.
	 *
	 * @return the categoria merceologica of this articoli
	 */
	@AutoEscape
	public String getCategoriaMerceologica();

	/**
	 * Sets the categoria merceologica of this articoli.
	 *
	 * @param categoriaMerceologica the categoria merceologica of this articoli
	 */
	public void setCategoriaMerceologica(String categoriaMerceologica);

	/**
	 * Returns the descrizione of this articoli.
	 *
	 * @return the descrizione of this articoli
	 */
	@AutoEscape
	public String getDescrizione();

	/**
	 * Sets the descrizione of this articoli.
	 *
	 * @param descrizione the descrizione of this articoli
	 */
	public void setDescrizione(String descrizione);

	/**
	 * Returns the descrizione documento of this articoli.
	 *
	 * @return the descrizione documento of this articoli
	 */
	@AutoEscape
	public String getDescrizioneDocumento();

	/**
	 * Sets the descrizione documento of this articoli.
	 *
	 * @param descrizioneDocumento the descrizione documento of this articoli
	 */
	public void setDescrizioneDocumento(String descrizioneDocumento);

	/**
	 * Returns the descrizione fiscale of this articoli.
	 *
	 * @return the descrizione fiscale of this articoli
	 */
	@AutoEscape
	public String getDescrizioneFiscale();

	/**
	 * Sets the descrizione fiscale of this articoli.
	 *
	 * @param descrizioneFiscale the descrizione fiscale of this articoli
	 */
	public void setDescrizioneFiscale(String descrizioneFiscale);

	/**
	 * Returns the tara of this articoli.
	 *
	 * @return the tara of this articoli
	 */
	public double getTara();

	/**
	 * Sets the tara of this articoli.
	 *
	 * @param tara the tara of this articoli
	 */
	public void setTara(double tara);

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
	public int compareTo(it.bysoftware.ct.model.Articoli articoli);

	@Override
	public int hashCode();

	@Override
	public CacheModel<it.bysoftware.ct.model.Articoli> toCacheModel();

	@Override
	public it.bysoftware.ct.model.Articoli toEscapedModel();

	@Override
	public it.bysoftware.ct.model.Articoli toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
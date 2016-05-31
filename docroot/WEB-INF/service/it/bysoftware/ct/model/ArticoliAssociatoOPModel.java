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

import it.bysoftware.ct.service.persistence.ArticoliAssociatoOPPK;

import java.io.Serializable;

/**
 * The base model interface for the ArticoliAssociatoOP service. Represents a row in the &quot;articoli_associato_op&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.bysoftware.ct.model.impl.ArticoliAssociatoOPModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.bysoftware.ct.model.impl.ArticoliAssociatoOPImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ArticoliAssociatoOP
 * @see it.bysoftware.ct.model.impl.ArticoliAssociatoOPImpl
 * @see it.bysoftware.ct.model.impl.ArticoliAssociatoOPModelImpl
 * @generated
 */
public interface ArticoliAssociatoOPModel extends BaseModel<ArticoliAssociatoOP> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a articoli associato o p model instance should use the {@link ArticoliAssociatoOP} interface instead.
	 */

	/**
	 * Returns the primary key of this articoli associato o p.
	 *
	 * @return the primary key of this articoli associato o p
	 */
	public ArticoliAssociatoOPPK getPrimaryKey();

	/**
	 * Sets the primary key of this articoli associato o p.
	 *
	 * @param primaryKey the primary key of this articoli associato o p
	 */
	public void setPrimaryKey(ArticoliAssociatoOPPK primaryKey);

	/**
	 * Returns the id associato of this articoli associato o p.
	 *
	 * @return the id associato of this articoli associato o p
	 */
	public long getIdAssociato();

	/**
	 * Sets the id associato of this articoli associato o p.
	 *
	 * @param idAssociato the id associato of this articoli associato o p
	 */
	public void setIdAssociato(long idAssociato);

	/**
	 * Returns the codice articolo associato of this articoli associato o p.
	 *
	 * @return the codice articolo associato of this articoli associato o p
	 */
	@AutoEscape
	public String getCodiceArticoloAssociato();

	/**
	 * Sets the codice articolo associato of this articoli associato o p.
	 *
	 * @param codiceArticoloAssociato the codice articolo associato of this articoli associato o p
	 */
	public void setCodiceArticoloAssociato(String codiceArticoloAssociato);

	/**
	 * Returns the codice articolo o p of this articoli associato o p.
	 *
	 * @return the codice articolo o p of this articoli associato o p
	 */
	@AutoEscape
	public String getCodiceArticoloOP();

	/**
	 * Sets the codice articolo o p of this articoli associato o p.
	 *
	 * @param codiceArticoloOP the codice articolo o p of this articoli associato o p
	 */
	public void setCodiceArticoloOP(String codiceArticoloOP);

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
	public int compareTo(
		it.bysoftware.ct.model.ArticoliAssociatoOP articoliAssociatoOP);

	@Override
	public int hashCode();

	@Override
	public CacheModel<it.bysoftware.ct.model.ArticoliAssociatoOP> toCacheModel();

	@Override
	public it.bysoftware.ct.model.ArticoliAssociatoOP toEscapedModel();

	@Override
	public it.bysoftware.ct.model.ArticoliAssociatoOP toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
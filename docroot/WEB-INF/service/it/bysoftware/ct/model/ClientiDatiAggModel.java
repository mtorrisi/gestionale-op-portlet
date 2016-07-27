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

import it.bysoftware.ct.service.persistence.ClientiDatiAggPK;

import java.io.Serializable;

/**
 * The base model interface for the ClientiDatiAgg service. Represents a row in the &quot;ClientiFornitoriDatiAgg&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.bysoftware.ct.model.impl.ClientiDatiAggModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.bysoftware.ct.model.impl.ClientiDatiAggImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClientiDatiAgg
 * @see it.bysoftware.ct.model.impl.ClientiDatiAggImpl
 * @see it.bysoftware.ct.model.impl.ClientiDatiAggModelImpl
 * @generated
 */
public interface ClientiDatiAggModel extends BaseModel<ClientiDatiAgg> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a clienti dati agg model instance should use the {@link ClientiDatiAgg} interface instead.
	 */

	/**
	 * Returns the primary key of this clienti dati agg.
	 *
	 * @return the primary key of this clienti dati agg
	 */
	public ClientiDatiAggPK getPrimaryKey();

	/**
	 * Sets the primary key of this clienti dati agg.
	 *
	 * @param primaryKey the primary key of this clienti dati agg
	 */
	public void setPrimaryKey(ClientiDatiAggPK primaryKey);

	/**
	 * Returns the codice anagrafica of this clienti dati agg.
	 *
	 * @return the codice anagrafica of this clienti dati agg
	 */
	@AutoEscape
	public String getCodiceAnagrafica();

	/**
	 * Sets the codice anagrafica of this clienti dati agg.
	 *
	 * @param codiceAnagrafica the codice anagrafica of this clienti dati agg
	 */
	public void setCodiceAnagrafica(String codiceAnagrafica);

	/**
	 * Returns the tipo of this clienti dati agg.
	 *
	 * @return the tipo of this clienti dati agg
	 */
	public boolean getTipo();

	/**
	 * Returns <code>true</code> if this clienti dati agg is tipo.
	 *
	 * @return <code>true</code> if this clienti dati agg is tipo; <code>false</code> otherwise
	 */
	public boolean isTipo();

	/**
	 * Sets whether this clienti dati agg is tipo.
	 *
	 * @param tipo the tipo of this clienti dati agg
	 */
	public void setTipo(boolean tipo);

	/**
	 * Returns the associati of this clienti dati agg.
	 *
	 * @return the associati of this clienti dati agg
	 */
	@AutoEscape
	public String getAssociati();

	/**
	 * Sets the associati of this clienti dati agg.
	 *
	 * @param associati the associati of this clienti dati agg
	 */
	public void setAssociati(String associati);

	/**
	 * Returns the codice aliquota of this clienti dati agg.
	 *
	 * @return the codice aliquota of this clienti dati agg
	 */
	@AutoEscape
	public String getCodiceAliquota();

	/**
	 * Sets the codice aliquota of this clienti dati agg.
	 *
	 * @param codiceAliquota the codice aliquota of this clienti dati agg
	 */
	public void setCodiceAliquota(String codiceAliquota);

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
	public int compareTo(it.bysoftware.ct.model.ClientiDatiAgg clientiDatiAgg);

	@Override
	public int hashCode();

	@Override
	public CacheModel<it.bysoftware.ct.model.ClientiDatiAgg> toCacheModel();

	@Override
	public it.bysoftware.ct.model.ClientiDatiAgg toEscapedModel();

	@Override
	public it.bysoftware.ct.model.ClientiDatiAgg toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
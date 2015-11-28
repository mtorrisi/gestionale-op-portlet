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
 * The base model interface for the BancheAppoggio service. Represents a row in the &quot;BancheAppoggio&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.bysoftware.ct.model.impl.BancheAppoggioModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.bysoftware.ct.model.impl.BancheAppoggioImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BancheAppoggio
 * @see it.bysoftware.ct.model.impl.BancheAppoggioImpl
 * @see it.bysoftware.ct.model.impl.BancheAppoggioModelImpl
 * @generated
 */
public interface BancheAppoggioModel extends BaseModel<BancheAppoggio> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a banche appoggio model instance should use the {@link BancheAppoggio} interface instead.
	 */

	/**
	 * Returns the primary key of this banche appoggio.
	 *
	 * @return the primary key of this banche appoggio
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this banche appoggio.
	 *
	 * @param primaryKey the primary key of this banche appoggio
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the c banca of this banche appoggio.
	 *
	 * @return the c banca of this banche appoggio
	 */
	@AutoEscape
	public String getCBanca();

	/**
	 * Sets the c banca of this banche appoggio.
	 *
	 * @param cBanca the c banca of this banche appoggio
	 */
	public void setCBanca(String cBanca);

	/**
	 * Returns the codice a b i of this banche appoggio.
	 *
	 * @return the codice a b i of this banche appoggio
	 */
	public int getCodiceABI();

	/**
	 * Sets the codice a b i of this banche appoggio.
	 *
	 * @param codiceABI the codice a b i of this banche appoggio
	 */
	public void setCodiceABI(int codiceABI);

	/**
	 * Returns the codice agenzia of this banche appoggio.
	 *
	 * @return the codice agenzia of this banche appoggio
	 */
	@AutoEscape
	public String getCodiceAgenzia();

	/**
	 * Sets the codice agenzia of this banche appoggio.
	 *
	 * @param codiceAgenzia the codice agenzia of this banche appoggio
	 */
	public void setCodiceAgenzia(String codiceAgenzia);

	/**
	 * Returns the codice banca of this banche appoggio.
	 *
	 * @return the codice banca of this banche appoggio
	 */
	@AutoEscape
	public String getCodiceBanca();

	/**
	 * Sets the codice banca of this banche appoggio.
	 *
	 * @param codiceBanca the codice banca of this banche appoggio
	 */
	public void setCodiceBanca(String codiceBanca);

	/**
	 * Returns the codice c a b of this banche appoggio.
	 *
	 * @return the codice c a b of this banche appoggio
	 */
	public int getCodiceCAB();

	/**
	 * Sets the codice c a b of this banche appoggio.
	 *
	 * @param codiceCAB the codice c a b of this banche appoggio
	 */
	public void setCodiceCAB(int codiceCAB);

	/**
	 * Returns the descrizione of this banche appoggio.
	 *
	 * @return the descrizione of this banche appoggio
	 */
	@AutoEscape
	public String getDescrizione();

	/**
	 * Sets the descrizione of this banche appoggio.
	 *
	 * @param descrizione the descrizione of this banche appoggio
	 */
	public void setDescrizione(String descrizione);

	/**
	 * Returns the piazza of this banche appoggio.
	 *
	 * @return the piazza of this banche appoggio
	 */
	@AutoEscape
	public String getPiazza();

	/**
	 * Sets the piazza of this banche appoggio.
	 *
	 * @param piazza the piazza of this banche appoggio
	 */
	public void setPiazza(String piazza);

	/**
	 * Returns the codice azienda of this banche appoggio.
	 *
	 * @return the codice azienda of this banche appoggio
	 */
	@AutoEscape
	public String getCodiceAzienda();

	/**
	 * Sets the codice azienda of this banche appoggio.
	 *
	 * @param codiceAzienda the codice azienda of this banche appoggio
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
	public int compareTo(it.bysoftware.ct.model.BancheAppoggio bancheAppoggio);

	@Override
	public int hashCode();

	@Override
	public CacheModel<it.bysoftware.ct.model.BancheAppoggio> toCacheModel();

	@Override
	public it.bysoftware.ct.model.BancheAppoggio toEscapedModel();

	@Override
	public it.bysoftware.ct.model.BancheAppoggio toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
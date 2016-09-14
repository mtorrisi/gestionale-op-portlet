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

import it.bysoftware.ct.service.persistence.CMRPK;

import java.io.Serializable;

/**
 * The base model interface for the CMR service. Represents a row in the &quot;CMR&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.bysoftware.ct.model.impl.CMRModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.bysoftware.ct.model.impl.CMRImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CMR
 * @see it.bysoftware.ct.model.impl.CMRImpl
 * @see it.bysoftware.ct.model.impl.CMRModelImpl
 * @generated
 */
public interface CMRModel extends BaseModel<CMR> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a c m r model instance should use the {@link CMR} interface instead.
	 */

	/**
	 * Returns the primary key of this c m r.
	 *
	 * @return the primary key of this c m r
	 */
	public CMRPK getPrimaryKey();

	/**
	 * Sets the primary key of this c m r.
	 *
	 * @param primaryKey the primary key of this c m r
	 */
	public void setPrimaryKey(CMRPK primaryKey);

	/**
	 * Returns the numero c m r of this c m r.
	 *
	 * @return the numero c m r of this c m r
	 */
	public long getNumeroCMR();

	/**
	 * Sets the numero c m r of this c m r.
	 *
	 * @param numeroCMR the numero c m r of this c m r
	 */
	public void setNumeroCMR(long numeroCMR);

	/**
	 * Returns the anno of this c m r.
	 *
	 * @return the anno of this c m r
	 */
	public int getAnno();

	/**
	 * Sets the anno of this c m r.
	 *
	 * @param anno the anno of this c m r
	 */
	public void setAnno(int anno);

	/**
	 * Returns the numero documento of this c m r.
	 *
	 * @return the numero documento of this c m r
	 */
	public long getNumeroDocumento();

	/**
	 * Sets the numero documento of this c m r.
	 *
	 * @param numeroDocumento the numero documento of this c m r
	 */
	public void setNumeroDocumento(long numeroDocumento);

	/**
	 * Returns the id associato of this c m r.
	 *
	 * @return the id associato of this c m r
	 */
	public long getIdAssociato();

	/**
	 * Sets the id associato of this c m r.
	 *
	 * @param idAssociato the id associato of this c m r
	 */
	public void setIdAssociato(long idAssociato);

	/**
	 * Returns the riserve of this c m r.
	 *
	 * @return the riserve of this c m r
	 */
	@AutoEscape
	public String getRiserve();

	/**
	 * Sets the riserve of this c m r.
	 *
	 * @param riserve the riserve of this c m r
	 */
	public void setRiserve(String riserve);

	/**
	 * Returns the allegati of this c m r.
	 *
	 * @return the allegati of this c m r
	 */
	@AutoEscape
	public String getAllegati();

	/**
	 * Sets the allegati of this c m r.
	 *
	 * @param allegati the allegati of this c m r
	 */
	public void setAllegati(String allegati);

	/**
	 * Returns the classe of this c m r.
	 *
	 * @return the classe of this c m r
	 */
	@AutoEscape
	public String getClasse();

	/**
	 * Sets the classe of this c m r.
	 *
	 * @param classe the classe of this c m r
	 */
	public void setClasse(String classe);

	/**
	 * Returns the cifra of this c m r.
	 *
	 * @return the cifra of this c m r
	 */
	@AutoEscape
	public String getCifra();

	/**
	 * Sets the cifra of this c m r.
	 *
	 * @param cifra the cifra of this c m r
	 */
	public void setCifra(String cifra);

	/**
	 * Returns the lettera of this c m r.
	 *
	 * @return the lettera of this c m r
	 */
	@AutoEscape
	public String getLettera();

	/**
	 * Sets the lettera of this c m r.
	 *
	 * @param lettera the lettera of this c m r
	 */
	public void setLettera(String lettera);

	/**
	 * Returns the adr of this c m r.
	 *
	 * @return the adr of this c m r
	 */
	@AutoEscape
	public String getAdr();

	/**
	 * Sets the adr of this c m r.
	 *
	 * @param adr the adr of this c m r
	 */
	public void setAdr(String adr);

	/**
	 * Returns the istruzioni of this c m r.
	 *
	 * @return the istruzioni of this c m r
	 */
	@AutoEscape
	public String getIstruzioni();

	/**
	 * Sets the istruzioni of this c m r.
	 *
	 * @param istruzioni the istruzioni of this c m r
	 */
	public void setIstruzioni(String istruzioni);

	/**
	 * Returns the convenzioni of this c m r.
	 *
	 * @return the convenzioni of this c m r
	 */
	@AutoEscape
	public String getConvenzioni();

	/**
	 * Sets the convenzioni of this c m r.
	 *
	 * @param convenzioni the convenzioni of this c m r
	 */
	public void setConvenzioni(String convenzioni);

	/**
	 * Returns the rimborso of this c m r.
	 *
	 * @return the rimborso of this c m r
	 */
	@AutoEscape
	public String getRimborso();

	/**
	 * Sets the rimborso of this c m r.
	 *
	 * @param rimborso the rimborso of this c m r
	 */
	public void setRimborso(String rimborso);

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
	public int compareTo(it.bysoftware.ct.model.CMR cmr);

	@Override
	public int hashCode();

	@Override
	public CacheModel<it.bysoftware.ct.model.CMR> toCacheModel();

	@Override
	public it.bysoftware.ct.model.CMR toEscapedModel();

	@Override
	public it.bysoftware.ct.model.CMR toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
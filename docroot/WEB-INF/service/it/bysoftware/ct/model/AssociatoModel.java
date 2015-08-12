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
 * The base model interface for the Associato service. Represents a row in the &quot;associato&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.bysoftware.ct.model.impl.AssociatoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.bysoftware.ct.model.impl.AssociatoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Associato
 * @see it.bysoftware.ct.model.impl.AssociatoImpl
 * @see it.bysoftware.ct.model.impl.AssociatoModelImpl
 * @generated
 */
public interface AssociatoModel extends BaseModel<Associato> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a associato model instance should use the {@link Associato} interface instead.
	 */

	/**
	 * Returns the primary key of this associato.
	 *
	 * @return the primary key of this associato
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this associato.
	 *
	 * @param primaryKey the primary key of this associato
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this associato.
	 *
	 * @return the ID of this associato
	 */
	public long getId();

	/**
	 * Sets the ID of this associato.
	 *
	 * @param id the ID of this associato
	 */
	public void setId(long id);

	/**
	 * Returns the centro of this associato.
	 *
	 * @return the centro of this associato
	 */
	@AutoEscape
	public String getCentro();

	/**
	 * Sets the centro of this associato.
	 *
	 * @param centro the centro of this associato
	 */
	public void setCentro(String centro);

	/**
	 * Returns the ragione sociale of this associato.
	 *
	 * @return the ragione sociale of this associato
	 */
	@AutoEscape
	public String getRagioneSociale();

	/**
	 * Sets the ragione sociale of this associato.
	 *
	 * @param ragioneSociale the ragione sociale of this associato
	 */
	public void setRagioneSociale(String ragioneSociale);

	/**
	 * Returns the partita i v a of this associato.
	 *
	 * @return the partita i v a of this associato
	 */
	@AutoEscape
	public String getPartitaIVA();

	/**
	 * Sets the partita i v a of this associato.
	 *
	 * @param partitaIVA the partita i v a of this associato
	 */
	public void setPartitaIVA(String partitaIVA);

	/**
	 * Returns the indirizzo of this associato.
	 *
	 * @return the indirizzo of this associato
	 */
	@AutoEscape
	public String getIndirizzo();

	/**
	 * Sets the indirizzo of this associato.
	 *
	 * @param indirizzo the indirizzo of this associato
	 */
	public void setIndirizzo(String indirizzo);

	/**
	 * Returns the telefono of this associato.
	 *
	 * @return the telefono of this associato
	 */
	@AutoEscape
	public String getTelefono();

	/**
	 * Sets the telefono of this associato.
	 *
	 * @param telefono the telefono of this associato
	 */
	public void setTelefono(String telefono);

	/**
	 * Returns the fax of this associato.
	 *
	 * @return the fax of this associato
	 */
	@AutoEscape
	public String getFax();

	/**
	 * Sets the fax of this associato.
	 *
	 * @param fax the fax of this associato
	 */
	public void setFax(String fax);

	/**
	 * Returns the email of this associato.
	 *
	 * @return the email of this associato
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this associato.
	 *
	 * @param email the email of this associato
	 */
	public void setEmail(String email);

	/**
	 * Returns the password of this associato.
	 *
	 * @return the password of this associato
	 */
	@AutoEscape
	public String getPassword();

	/**
	 * Sets the password of this associato.
	 *
	 * @param password the password of this associato
	 */
	public void setPassword(String password);

	/**
	 * Returns the id liferay of this associato.
	 *
	 * @return the id liferay of this associato
	 */
	public long getIdLiferay();

	/**
	 * Sets the id liferay of this associato.
	 *
	 * @param idLiferay the id liferay of this associato
	 */
	public void setIdLiferay(long idLiferay);

	/**
	 * Returns the id op of this associato.
	 *
	 * @return the id op of this associato
	 */
	public long getIdOp();

	/**
	 * Sets the id op of this associato.
	 *
	 * @param idOp the id op of this associato
	 */
	public void setIdOp(long idOp);

	/**
	 * Returns the attivo of this associato.
	 *
	 * @return the attivo of this associato
	 */
	public boolean getAttivo();

	/**
	 * Returns <code>true</code> if this associato is attivo.
	 *
	 * @return <code>true</code> if this associato is attivo; <code>false</code> otherwise
	 */
	public boolean isAttivo();

	/**
	 * Sets whether this associato is attivo.
	 *
	 * @param attivo the attivo of this associato
	 */
	public void setAttivo(boolean attivo);

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
	public int compareTo(Associato associato);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Associato> toCacheModel();

	@Override
	public Associato toEscapedModel();

	@Override
	public Associato toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
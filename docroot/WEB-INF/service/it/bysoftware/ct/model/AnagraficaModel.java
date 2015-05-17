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
 * The base model interface for the Anagrafica service. Represents a row in the &quot;AnagraficheClientiFornitori&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.bysoftware.ct.model.impl.AnagraficaModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.bysoftware.ct.model.impl.AnagraficaImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Anagrafica
 * @see it.bysoftware.ct.model.impl.AnagraficaImpl
 * @see it.bysoftware.ct.model.impl.AnagraficaModelImpl
 * @generated
 */
public interface AnagraficaModel extends BaseModel<Anagrafica> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a anagrafica model instance should use the {@link Anagrafica} interface instead.
	 */

	/**
	 * Returns the primary key of this anagrafica.
	 *
	 * @return the primary key of this anagrafica
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this anagrafica.
	 *
	 * @param primaryKey the primary key of this anagrafica
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the attivo e c of this anagrafica.
	 *
	 * @return the attivo e c of this anagrafica
	 */
	public int getAttivoEC();

	/**
	 * Sets the attivo e c of this anagrafica.
	 *
	 * @param attivoEC the attivo e c of this anagrafica
	 */
	public void setAttivoEC(int attivoEC);

	/**
	 * Returns the cap of this anagrafica.
	 *
	 * @return the cap of this anagrafica
	 */
	@AutoEscape
	public String getCap();

	/**
	 * Sets the cap of this anagrafica.
	 *
	 * @param cap the cap of this anagrafica
	 */
	public void setCap(String cap);

	/**
	 * Returns the codice anagrafica of this anagrafica.
	 *
	 * @return the codice anagrafica of this anagrafica
	 */
	@AutoEscape
	public String getCodiceAnagrafica();

	/**
	 * Sets the codice anagrafica of this anagrafica.
	 *
	 * @param codiceAnagrafica the codice anagrafica of this anagrafica
	 */
	public void setCodiceAnagrafica(String codiceAnagrafica);

	/**
	 * Returns the codice fiscale of this anagrafica.
	 *
	 * @return the codice fiscale of this anagrafica
	 */
	@AutoEscape
	public String getCodiceFiscale();

	/**
	 * Sets the codice fiscale of this anagrafica.
	 *
	 * @param codiceFiscale the codice fiscale of this anagrafica
	 */
	public void setCodiceFiscale(String codiceFiscale);

	/**
	 * Returns the codice mne of this anagrafica.
	 *
	 * @return the codice mne of this anagrafica
	 */
	@AutoEscape
	public String getCodiceMne();

	/**
	 * Sets the codice mne of this anagrafica.
	 *
	 * @param codiceMne the codice mne of this anagrafica
	 */
	public void setCodiceMne(String codiceMne);

	/**
	 * Returns the comune of this anagrafica.
	 *
	 * @return the comune of this anagrafica
	 */
	@AutoEscape
	public String getComune();

	/**
	 * Sets the comune of this anagrafica.
	 *
	 * @param comune the comune of this anagrafica
	 */
	public void setComune(String comune);

	/**
	 * Returns the indirizzo of this anagrafica.
	 *
	 * @return the indirizzo of this anagrafica
	 */
	@AutoEscape
	public String getIndirizzo();

	/**
	 * Sets the indirizzo of this anagrafica.
	 *
	 * @param Indirizzo the indirizzo of this anagrafica
	 */
	public void setIndirizzo(String Indirizzo);

	/**
	 * Returns the note of this anagrafica.
	 *
	 * @return the note of this anagrafica
	 */
	@AutoEscape
	public String getNote();

	/**
	 * Sets the note of this anagrafica.
	 *
	 * @param note the note of this anagrafica
	 */
	public void setNote(String note);

	/**
	 * Returns the partita i v a of this anagrafica.
	 *
	 * @return the partita i v a of this anagrafica
	 */
	@AutoEscape
	public String getPartitaIVA();

	/**
	 * Sets the partita i v a of this anagrafica.
	 *
	 * @param partitaIVA the partita i v a of this anagrafica
	 */
	public void setPartitaIVA(String partitaIVA);

	/**
	 * Returns the ragione sociale of this anagrafica.
	 *
	 * @return the ragione sociale of this anagrafica
	 */
	@AutoEscape
	public String getRagioneSociale();

	/**
	 * Sets the ragione sociale of this anagrafica.
	 *
	 * @param ragioneSociale the ragione sociale of this anagrafica
	 */
	public void setRagioneSociale(String ragioneSociale);

	/**
	 * Returns the ragione sociale alternativa of this anagrafica.
	 *
	 * @return the ragione sociale alternativa of this anagrafica
	 */
	@AutoEscape
	public String getRagioneSocialeAlternativa();

	/**
	 * Sets the ragione sociale alternativa of this anagrafica.
	 *
	 * @param ragioneSocialeAlternativa the ragione sociale alternativa of this anagrafica
	 */
	public void setRagioneSocialeAlternativa(String ragioneSocialeAlternativa);

	/**
	 * Returns the provincia of this anagrafica.
	 *
	 * @return the provincia of this anagrafica
	 */
	@AutoEscape
	public String getProvincia();

	/**
	 * Sets the provincia of this anagrafica.
	 *
	 * @param provincia the provincia of this anagrafica
	 */
	public void setProvincia(String provincia);

	/**
	 * Returns the stato of this anagrafica.
	 *
	 * @return the stato of this anagrafica
	 */
	@AutoEscape
	public String getStato();

	/**
	 * Sets the stato of this anagrafica.
	 *
	 * @param stato the stato of this anagrafica
	 */
	public void setStato(String stato);

	/**
	 * Returns the tepefi of this anagrafica.
	 *
	 * @return the tepefi of this anagrafica
	 */
	public int getTepefi();

	/**
	 * Sets the tepefi of this anagrafica.
	 *
	 * @param tepefi the tepefi of this anagrafica
	 */
	public void setTepefi(int tepefi);

	/**
	 * Returns the tipo soggetto of this anagrafica.
	 *
	 * @return the tipo soggetto of this anagrafica
	 */
	@AutoEscape
	public String getTipoSoggetto();

	/**
	 * Sets the tipo soggetto of this anagrafica.
	 *
	 * @param tipoSoggetto the tipo soggetto of this anagrafica
	 */
	public void setTipoSoggetto(String tipoSoggetto);

	/**
	 * Returns the tipsol of this anagrafica.
	 *
	 * @return the tipsol of this anagrafica
	 */
	public int getTipsol();

	/**
	 * Sets the tipsol of this anagrafica.
	 *
	 * @param tipsol the tipsol of this anagrafica
	 */
	public void setTipsol(int tipsol);

	/**
	 * Returns the codice azienda of this anagrafica.
	 *
	 * @return the codice azienda of this anagrafica
	 */
	@AutoEscape
	public String getCodiceAzienda();

	/**
	 * Sets the codice azienda of this anagrafica.
	 *
	 * @param codiceAzienda the codice azienda of this anagrafica
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
	public int compareTo(Anagrafica anagrafica);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Anagrafica> toCacheModel();

	@Override
	public Anagrafica toEscapedModel();

	@Override
	public Anagrafica toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
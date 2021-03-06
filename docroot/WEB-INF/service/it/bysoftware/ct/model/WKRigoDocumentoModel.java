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

import it.bysoftware.ct.service.persistence.WKRigoDocumentoPK;

import java.io.Serializable;

/**
 * The base model interface for the WKRigoDocumento service. Represents a row in the &quot;WK_SSRIGORD&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.bysoftware.ct.model.impl.WKRigoDocumentoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.bysoftware.ct.model.impl.WKRigoDocumentoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WKRigoDocumento
 * @see it.bysoftware.ct.model.impl.WKRigoDocumentoImpl
 * @see it.bysoftware.ct.model.impl.WKRigoDocumentoModelImpl
 * @generated
 */
public interface WKRigoDocumentoModel extends BaseModel<WKRigoDocumento> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a w k rigo documento model instance should use the {@link WKRigoDocumento} interface instead.
	 */

	/**
	 * Returns the primary key of this w k rigo documento.
	 *
	 * @return the primary key of this w k rigo documento
	 */
	public WKRigoDocumentoPK getPrimaryKey();

	/**
	 * Sets the primary key of this w k rigo documento.
	 *
	 * @param primaryKey the primary key of this w k rigo documento
	 */
	public void setPrimaryKey(WKRigoDocumentoPK primaryKey);

	/**
	 * Returns the anno of this w k rigo documento.
	 *
	 * @return the anno of this w k rigo documento
	 */
	public int getAnno();

	/**
	 * Sets the anno of this w k rigo documento.
	 *
	 * @param anno the anno of this w k rigo documento
	 */
	public void setAnno(int anno);

	/**
	 * Returns the numero ordine of this w k rigo documento.
	 *
	 * @return the numero ordine of this w k rigo documento
	 */
	public long getNumeroOrdine();

	/**
	 * Sets the numero ordine of this w k rigo documento.
	 *
	 * @param numeroOrdine the numero ordine of this w k rigo documento
	 */
	public void setNumeroOrdine(long numeroOrdine);

	/**
	 * Returns the rigo ordine of this w k rigo documento.
	 *
	 * @return the rigo ordine of this w k rigo documento
	 */
	public int getRigoOrdine();

	/**
	 * Sets the rigo ordine of this w k rigo documento.
	 *
	 * @param rigoOrdine the rigo ordine of this w k rigo documento
	 */
	public void setRigoOrdine(int rigoOrdine);

	/**
	 * Returns the codice variante of this w k rigo documento.
	 *
	 * @return the codice variante of this w k rigo documento
	 */
	@AutoEscape
	public String getCodiceVariante();

	/**
	 * Sets the codice variante of this w k rigo documento.
	 *
	 * @param codiceVariante the codice variante of this w k rigo documento
	 */
	public void setCodiceVariante(String codiceVariante);

	/**
	 * Returns the descrizione variante of this w k rigo documento.
	 *
	 * @return the descrizione variante of this w k rigo documento
	 */
	@AutoEscape
	public String getDescrizioneVariante();

	/**
	 * Sets the descrizione variante of this w k rigo documento.
	 *
	 * @param descrizioneVariante the descrizione variante of this w k rigo documento
	 */
	public void setDescrizioneVariante(String descrizioneVariante);

	/**
	 * Returns the codice articolo of this w k rigo documento.
	 *
	 * @return the codice articolo of this w k rigo documento
	 */
	@AutoEscape
	public String getCodiceArticolo();

	/**
	 * Sets the codice articolo of this w k rigo documento.
	 *
	 * @param codiceArticolo the codice articolo of this w k rigo documento
	 */
	public void setCodiceArticolo(String codiceArticolo);

	/**
	 * Returns the descrizione of this w k rigo documento.
	 *
	 * @return the descrizione of this w k rigo documento
	 */
	@AutoEscape
	public String getDescrizione();

	/**
	 * Sets the descrizione of this w k rigo documento.
	 *
	 * @param descrizione the descrizione of this w k rigo documento
	 */
	public void setDescrizione(String descrizione);

	/**
	 * Returns the unita misura of this w k rigo documento.
	 *
	 * @return the unita misura of this w k rigo documento
	 */
	@AutoEscape
	public String getUnitaMisura();

	/**
	 * Sets the unita misura of this w k rigo documento.
	 *
	 * @param unitaMisura the unita misura of this w k rigo documento
	 */
	public void setUnitaMisura(String unitaMisura);

	/**
	 * Returns the colli of this w k rigo documento.
	 *
	 * @return the colli of this w k rigo documento
	 */
	public int getColli();

	/**
	 * Sets the colli of this w k rigo documento.
	 *
	 * @param colli the colli of this w k rigo documento
	 */
	public void setColli(int colli);

	/**
	 * Returns the peso lordo of this w k rigo documento.
	 *
	 * @return the peso lordo of this w k rigo documento
	 */
	public double getPesoLordo();

	/**
	 * Sets the peso lordo of this w k rigo documento.
	 *
	 * @param pesoLordo the peso lordo of this w k rigo documento
	 */
	public void setPesoLordo(double pesoLordo);

	/**
	 * Returns the tara of this w k rigo documento.
	 *
	 * @return the tara of this w k rigo documento
	 */
	public double getTara();

	/**
	 * Sets the tara of this w k rigo documento.
	 *
	 * @param tara the tara of this w k rigo documento
	 */
	public void setTara(double tara);

	/**
	 * Returns the peso netto of this w k rigo documento.
	 *
	 * @return the peso netto of this w k rigo documento
	 */
	public double getPesoNetto();

	/**
	 * Sets the peso netto of this w k rigo documento.
	 *
	 * @param pesoNetto the peso netto of this w k rigo documento
	 */
	public void setPesoNetto(double pesoNetto);

	/**
	 * Returns the prezzo of this w k rigo documento.
	 *
	 * @return the prezzo of this w k rigo documento
	 */
	public double getPrezzo();

	/**
	 * Sets the prezzo of this w k rigo documento.
	 *
	 * @param prezzo the prezzo of this w k rigo documento
	 */
	public void setPrezzo(double prezzo);

	/**
	 * Returns the pedane of this w k rigo documento.
	 *
	 * @return the pedane of this w k rigo documento
	 */
	public double getPedane();

	/**
	 * Sets the pedane of this w k rigo documento.
	 *
	 * @param pedane the pedane of this w k rigo documento
	 */
	public void setPedane(double pedane);

	/**
	 * Returns the note of this w k rigo documento.
	 *
	 * @return the note of this w k rigo documento
	 */
	@AutoEscape
	public String getNote();

	/**
	 * Sets the note of this w k rigo documento.
	 *
	 * @param note the note of this w k rigo documento
	 */
	public void setNote(String note);

	/**
	 * Returns the totale pesata of this w k rigo documento.
	 *
	 * @return the totale pesata of this w k rigo documento
	 */
	public double getTotalePesata();

	/**
	 * Sets the totale pesata of this w k rigo documento.
	 *
	 * @param totalePesata the totale pesata of this w k rigo documento
	 */
	public void setTotalePesata(double totalePesata);

	/**
	 * Returns the imballo of this w k rigo documento.
	 *
	 * @return the imballo of this w k rigo documento
	 */
	@AutoEscape
	public String getImballo();

	/**
	 * Sets the imballo of this w k rigo documento.
	 *
	 * @param imballo the imballo of this w k rigo documento
	 */
	public void setImballo(String imballo);

	/**
	 * Returns the gestione reti of this w k rigo documento.
	 *
	 * @return the gestione reti of this w k rigo documento
	 */
	public boolean getGestioneReti();

	/**
	 * Returns <code>true</code> if this w k rigo documento is gestione reti.
	 *
	 * @return <code>true</code> if this w k rigo documento is gestione reti; <code>false</code> otherwise
	 */
	public boolean isGestioneReti();

	/**
	 * Sets whether this w k rigo documento is gestione reti.
	 *
	 * @param gestioneReti the gestione reti of this w k rigo documento
	 */
	public void setGestioneReti(boolean gestioneReti);

	/**
	 * Returns the rtx cl of this w k rigo documento.
	 *
	 * @return the rtx cl of this w k rigo documento
	 */
	public double getRtxCl();

	/**
	 * Sets the rtx cl of this w k rigo documento.
	 *
	 * @param RtxCl the rtx cl of this w k rigo documento
	 */
	public void setRtxCl(double RtxCl);

	/**
	 * Returns the kg rete of this w k rigo documento.
	 *
	 * @return the kg rete of this w k rigo documento
	 */
	public double getKgRete();

	/**
	 * Sets the kg rete of this w k rigo documento.
	 *
	 * @param kgRete the kg rete of this w k rigo documento
	 */
	public void setKgRete(double kgRete);

	/**
	 * Returns the lotto of this w k rigo documento.
	 *
	 * @return the lotto of this w k rigo documento
	 */
	@AutoEscape
	public String getLotto();

	/**
	 * Sets the lotto of this w k rigo documento.
	 *
	 * @param lotto the lotto of this w k rigo documento
	 */
	public void setLotto(String lotto);

	/**
	 * Returns the passaporto of this w k rigo documento.
	 *
	 * @return the passaporto of this w k rigo documento
	 */
	@AutoEscape
	public String getPassaporto();

	/**
	 * Sets the passaporto of this w k rigo documento.
	 *
	 * @param passaporto the passaporto of this w k rigo documento
	 */
	public void setPassaporto(String passaporto);

	/**
	 * Returns the progressivo of this w k rigo documento.
	 *
	 * @return the progressivo of this w k rigo documento
	 */
	public int getProgressivo();

	/**
	 * Sets the progressivo of this w k rigo documento.
	 *
	 * @param progressivo the progressivo of this w k rigo documento
	 */
	public void setProgressivo(int progressivo);

	/**
	 * Returns the riferimento bolla of this w k rigo documento.
	 *
	 * @return the riferimento bolla of this w k rigo documento
	 */
	public int getRiferimentoBolla();

	/**
	 * Sets the riferimento bolla of this w k rigo documento.
	 *
	 * @param riferimentoBolla the riferimento bolla of this w k rigo documento
	 */
	public void setRiferimentoBolla(int riferimentoBolla);

	/**
	 * Returns the sconto1 of this w k rigo documento.
	 *
	 * @return the sconto1 of this w k rigo documento
	 */
	public float getSconto1();

	/**
	 * Sets the sconto1 of this w k rigo documento.
	 *
	 * @param sconto1 the sconto1 of this w k rigo documento
	 */
	public void setSconto1(float sconto1);

	/**
	 * Returns the sconto2 of this w k rigo documento.
	 *
	 * @return the sconto2 of this w k rigo documento
	 */
	public float getSconto2();

	/**
	 * Sets the sconto2 of this w k rigo documento.
	 *
	 * @param sconto2 the sconto2 of this w k rigo documento
	 */
	public void setSconto2(float sconto2);

	/**
	 * Returns the sconto3 of this w k rigo documento.
	 *
	 * @return the sconto3 of this w k rigo documento
	 */
	public float getSconto3();

	/**
	 * Sets the sconto3 of this w k rigo documento.
	 *
	 * @param sconto3 the sconto3 of this w k rigo documento
	 */
	public void setSconto3(float sconto3);

	/**
	 * Returns the tipo documento of this w k rigo documento.
	 *
	 * @return the tipo documento of this w k rigo documento
	 */
	@AutoEscape
	public String getTipoDocumento();

	/**
	 * Sets the tipo documento of this w k rigo documento.
	 *
	 * @param tipoDocumento the tipo documento of this w k rigo documento
	 */
	public void setTipoDocumento(String tipoDocumento);

	/**
	 * Returns the id associato of this w k rigo documento.
	 *
	 * @return the id associato of this w k rigo documento
	 */
	public long getIdAssociato();

	/**
	 * Sets the id associato of this w k rigo documento.
	 *
	 * @param idAssociato the id associato of this w k rigo documento
	 */
	public void setIdAssociato(long idAssociato);

	/**
	 * Returns the verificato of this w k rigo documento.
	 *
	 * @return the verificato of this w k rigo documento
	 */
	public boolean getVerificato();

	/**
	 * Returns <code>true</code> if this w k rigo documento is verificato.
	 *
	 * @return <code>true</code> if this w k rigo documento is verificato; <code>false</code> otherwise
	 */
	public boolean isVerificato();

	/**
	 * Sets whether this w k rigo documento is verificato.
	 *
	 * @param verificato the verificato of this w k rigo documento
	 */
	public void setVerificato(boolean verificato);

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
	public int compareTo(it.bysoftware.ct.model.WKRigoDocumento wkRigoDocumento);

	@Override
	public int hashCode();

	@Override
	public CacheModel<it.bysoftware.ct.model.WKRigoDocumento> toCacheModel();

	@Override
	public it.bysoftware.ct.model.WKRigoDocumento toEscapedModel();

	@Override
	public it.bysoftware.ct.model.WKRigoDocumento toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
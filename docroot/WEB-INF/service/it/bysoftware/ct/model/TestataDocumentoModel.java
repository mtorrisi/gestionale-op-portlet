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

import it.bysoftware.ct.service.persistence.TestataDocumentoPK;

import java.io.Serializable;

/**
 * The base model interface for the TestataDocumento service. Represents a row in the &quot;SSTESORD&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.bysoftware.ct.model.impl.TestataDocumentoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.bysoftware.ct.model.impl.TestataDocumentoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TestataDocumento
 * @see it.bysoftware.ct.model.impl.TestataDocumentoImpl
 * @see it.bysoftware.ct.model.impl.TestataDocumentoModelImpl
 * @generated
 */
public interface TestataDocumentoModel extends BaseModel<TestataDocumento> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a testata documento model instance should use the {@link TestataDocumento} interface instead.
	 */

	/**
	 * Returns the primary key of this testata documento.
	 *
	 * @return the primary key of this testata documento
	 */
	public TestataDocumentoPK getPrimaryKey();

	/**
	 * Sets the primary key of this testata documento.
	 *
	 * @param primaryKey the primary key of this testata documento
	 */
	public void setPrimaryKey(TestataDocumentoPK primaryKey);

	/**
	 * Returns the anno of this testata documento.
	 *
	 * @return the anno of this testata documento
	 */
	public int getAnno();

	/**
	 * Sets the anno of this testata documento.
	 *
	 * @param anno the anno of this testata documento
	 */
	public void setAnno(int anno);

	/**
	 * Returns the numero ordine of this testata documento.
	 *
	 * @return the numero ordine of this testata documento
	 */
	public int getNumeroOrdine();

	/**
	 * Sets the numero ordine of this testata documento.
	 *
	 * @param numeroOrdine the numero ordine of this testata documento
	 */
	public void setNumeroOrdine(int numeroOrdine);

	/**
	 * Returns the codice soggetto of this testata documento.
	 *
	 * @return the codice soggetto of this testata documento
	 */
	@AutoEscape
	public String getCodiceSoggetto();

	/**
	 * Sets the codice soggetto of this testata documento.
	 *
	 * @param codiceSoggetto the codice soggetto of this testata documento
	 */
	public void setCodiceSoggetto(String codiceSoggetto);

	/**
	 * Returns the data ordine of this testata documento.
	 *
	 * @return the data ordine of this testata documento
	 */
	@AutoEscape
	public String getDataOrdine();

	/**
	 * Sets the data ordine of this testata documento.
	 *
	 * @param dataOrdine the data ordine of this testata documento
	 */
	public void setDataOrdine(String dataOrdine);

	/**
	 * Returns the data consegna of this testata documento.
	 *
	 * @return the data consegna of this testata documento
	 */
	@AutoEscape
	public String getDataConsegna();

	/**
	 * Sets the data consegna of this testata documento.
	 *
	 * @param dataConsegna the data consegna of this testata documento
	 */
	public void setDataConsegna(String dataConsegna);

	/**
	 * Returns the destinazione of this testata documento.
	 *
	 * @return the destinazione of this testata documento
	 */
	@AutoEscape
	public String getDestinazione();

	/**
	 * Sets the destinazione of this testata documento.
	 *
	 * @param destinazione the destinazione of this testata documento
	 */
	public void setDestinazione(String destinazione);

	/**
	 * Returns the codice destinazione of this testata documento.
	 *
	 * @return the codice destinazione of this testata documento
	 */
	public int getCodiceDestinazione();

	/**
	 * Sets the codice destinazione of this testata documento.
	 *
	 * @param codiceDestinazione the codice destinazione of this testata documento
	 */
	public void setCodiceDestinazione(int codiceDestinazione);

	/**
	 * Returns the completo of this testata documento.
	 *
	 * @return the completo of this testata documento
	 */
	@AutoEscape
	public String getCompleto();

	/**
	 * Sets the completo of this testata documento.
	 *
	 * @param completo the completo of this testata documento
	 */
	public void setCompleto(String completo);

	/**
	 * Returns the operatore of this testata documento.
	 *
	 * @return the operatore of this testata documento
	 */
	@AutoEscape
	public String getOperatore();

	/**
	 * Sets the operatore of this testata documento.
	 *
	 * @param operatore the operatore of this testata documento
	 */
	public void setOperatore(String operatore);

	/**
	 * Returns the visto of this testata documento.
	 *
	 * @return the visto of this testata documento
	 */
	public int getVisto();

	/**
	 * Sets the visto of this testata documento.
	 *
	 * @param visto the visto of this testata documento
	 */
	public void setVisto(int visto);

	/**
	 * Returns the inviato of this testata documento.
	 *
	 * @return the inviato of this testata documento
	 */
	public int getInviato();

	/**
	 * Sets the inviato of this testata documento.
	 *
	 * @param inviato the inviato of this testata documento
	 */
	public void setInviato(int inviato);

	/**
	 * Returns the lotto of this testata documento.
	 *
	 * @return the lotto of this testata documento
	 */
	@AutoEscape
	public String getLotto();

	/**
	 * Sets the lotto of this testata documento.
	 *
	 * @param lotto the lotto of this testata documento
	 */
	public void setLotto(String lotto);

	/**
	 * Returns the tipo documeto of this testata documento.
	 *
	 * @return the tipo documeto of this testata documento
	 */
	@AutoEscape
	public String getTipoDocumeto();

	/**
	 * Sets the tipo documeto of this testata documento.
	 *
	 * @param tipoDocumeto the tipo documeto of this testata documento
	 */
	public void setTipoDocumeto(String tipoDocumeto);

	/**
	 * Returns the vettore of this testata documento.
	 *
	 * @return the vettore of this testata documento
	 */
	@AutoEscape
	public String getVettore();

	/**
	 * Sets the vettore of this testata documento.
	 *
	 * @param vettore the vettore of this testata documento
	 */
	public void setVettore(String vettore);

	/**
	 * Returns the autista of this testata documento.
	 *
	 * @return the autista of this testata documento
	 */
	@AutoEscape
	public String getAutista();

	/**
	 * Sets the autista of this testata documento.
	 *
	 * @param autista the autista of this testata documento
	 */
	public void setAutista(String autista);

	/**
	 * Returns the telefono of this testata documento.
	 *
	 * @return the telefono of this testata documento
	 */
	@AutoEscape
	public String getTelefono();

	/**
	 * Sets the telefono of this testata documento.
	 *
	 * @param telefono the telefono of this testata documento
	 */
	public void setTelefono(String telefono);

	/**
	 * Returns the centro of this testata documento.
	 *
	 * @return the centro of this testata documento
	 */
	@AutoEscape
	public String getCentro();

	/**
	 * Sets the centro of this testata documento.
	 *
	 * @param centro the centro of this testata documento
	 */
	public void setCentro(String centro);

	/**
	 * Returns the pallet caricati of this testata documento.
	 *
	 * @return the pallet caricati of this testata documento
	 */
	public int getPalletCaricati();

	/**
	 * Sets the pallet caricati of this testata documento.
	 *
	 * @param palletCaricati the pallet caricati of this testata documento
	 */
	public void setPalletCaricati(int palletCaricati);

	/**
	 * Returns the pallet scaricati of this testata documento.
	 *
	 * @return the pallet scaricati of this testata documento
	 */
	public int getPalletScaricati();

	/**
	 * Sets the pallet scaricati of this testata documento.
	 *
	 * @param palletScaricati the pallet scaricati of this testata documento
	 */
	public void setPalletScaricati(int palletScaricati);

	/**
	 * Returns the codice vettore of this testata documento.
	 *
	 * @return the codice vettore of this testata documento
	 */
	@AutoEscape
	public String getCodiceVettore();

	/**
	 * Sets the codice vettore of this testata documento.
	 *
	 * @param codiceVettore the codice vettore of this testata documento
	 */
	public void setCodiceVettore(String codiceVettore);

	/**
	 * Returns the destinazione vettore of this testata documento.
	 *
	 * @return the destinazione vettore of this testata documento
	 */
	@AutoEscape
	public String getDestinazioneVettore();

	/**
	 * Sets the destinazione vettore of this testata documento.
	 *
	 * @param destinazioneVettore the destinazione vettore of this testata documento
	 */
	public void setDestinazioneVettore(String destinazioneVettore);

	/**
	 * Returns the nota1 of this testata documento.
	 *
	 * @return the nota1 of this testata documento
	 */
	@AutoEscape
	public String getNota1();

	/**
	 * Sets the nota1 of this testata documento.
	 *
	 * @param nota1 the nota1 of this testata documento
	 */
	public void setNota1(String nota1);

	/**
	 * Returns the nota2 of this testata documento.
	 *
	 * @return the nota2 of this testata documento
	 */
	@AutoEscape
	public String getNota2();

	/**
	 * Sets the nota2 of this testata documento.
	 *
	 * @param nota2 the nota2 of this testata documento
	 */
	public void setNota2(String nota2);

	/**
	 * Returns the rigo descrittivo of this testata documento.
	 *
	 * @return the rigo descrittivo of this testata documento
	 */
	@AutoEscape
	public String getRigoDescrittivo();

	/**
	 * Sets the rigo descrittivo of this testata documento.
	 *
	 * @param rigoDescrittivo the rigo descrittivo of this testata documento
	 */
	public void setRigoDescrittivo(String rigoDescrittivo);

	/**
	 * Returns the vettore2 of this testata documento.
	 *
	 * @return the vettore2 of this testata documento
	 */
	@AutoEscape
	public String getVettore2();

	/**
	 * Sets the vettore2 of this testata documento.
	 *
	 * @param vettore2 the vettore2 of this testata documento
	 */
	public void setVettore2(String vettore2);

	/**
	 * Returns the cura trasoirto of this testata documento.
	 *
	 * @return the cura trasoirto of this testata documento
	 */
	@AutoEscape
	public String getCuraTrasoirto();

	/**
	 * Sets the cura trasoirto of this testata documento.
	 *
	 * @param curaTrasoirto the cura trasoirto of this testata documento
	 */
	public void setCuraTrasoirto(String curaTrasoirto);

	/**
	 * Returns the aspetto esteriore of this testata documento.
	 *
	 * @return the aspetto esteriore of this testata documento
	 */
	@AutoEscape
	public String getAspettoEsteriore();

	/**
	 * Sets the aspetto esteriore of this testata documento.
	 *
	 * @param aspettoEsteriore the aspetto esteriore of this testata documento
	 */
	public void setAspettoEsteriore(String aspettoEsteriore);

	/**
	 * Returns the causale trasporto of this testata documento.
	 *
	 * @return the causale trasporto of this testata documento
	 */
	@AutoEscape
	public String getCausaleTrasporto();

	/**
	 * Sets the causale trasporto of this testata documento.
	 *
	 * @param causaleTrasporto the causale trasporto of this testata documento
	 */
	public void setCausaleTrasporto(String causaleTrasporto);

	/**
	 * Returns the porto of this testata documento.
	 *
	 * @return the porto of this testata documento
	 */
	@AutoEscape
	public String getPorto();

	/**
	 * Sets the porto of this testata documento.
	 *
	 * @param porto the porto of this testata documento
	 */
	public void setPorto(String porto);

	/**
	 * Returns the origine of this testata documento.
	 *
	 * @return the origine of this testata documento
	 */
	@AutoEscape
	public String getOrigine();

	/**
	 * Sets the origine of this testata documento.
	 *
	 * @param origine the origine of this testata documento
	 */
	public void setOrigine(String origine);

	/**
	 * Returns the numero pedane euro of this testata documento.
	 *
	 * @return the numero pedane euro of this testata documento
	 */
	public int getNumeroPedaneEuro();

	/**
	 * Sets the numero pedane euro of this testata documento.
	 *
	 * @param numeroPedaneEuro the numero pedane euro of this testata documento
	 */
	public void setNumeroPedaneEuro(int numeroPedaneEuro);

	/**
	 * Returns the numero pedane normali of this testata documento.
	 *
	 * @return the numero pedane normali of this testata documento
	 */
	public int getNumeroPedaneNormali();

	/**
	 * Sets the numero pedane normali of this testata documento.
	 *
	 * @param numeroPedaneNormali the numero pedane normali of this testata documento
	 */
	public void setNumeroPedaneNormali(int numeroPedaneNormali);

	/**
	 * Returns the costo trasporto of this testata documento.
	 *
	 * @return the costo trasporto of this testata documento
	 */
	public double getCostoTrasporto();

	/**
	 * Sets the costo trasporto of this testata documento.
	 *
	 * @param costoTrasporto the costo trasporto of this testata documento
	 */
	public void setCostoTrasporto(double costoTrasporto);

	/**
	 * Returns the totale pedane ordine of this testata documento.
	 *
	 * @return the totale pedane ordine of this testata documento
	 */
	public int getTotalePedaneOrdine();

	/**
	 * Sets the totale pedane ordine of this testata documento.
	 *
	 * @param totalePedaneOrdine the totale pedane ordine of this testata documento
	 */
	public void setTotalePedaneOrdine(int totalePedaneOrdine);

	/**
	 * Returns the targa camion of this testata documento.
	 *
	 * @return the targa camion of this testata documento
	 */
	@AutoEscape
	public String getTargaCamion();

	/**
	 * Sets the targa camion of this testata documento.
	 *
	 * @param targaCamion the targa camion of this testata documento
	 */
	public void setTargaCamion(String targaCamion);

	/**
	 * Returns the targa rimorchio of this testata documento.
	 *
	 * @return the targa rimorchio of this testata documento
	 */
	@AutoEscape
	public String getTargaRimorchio();

	/**
	 * Sets the targa rimorchio of this testata documento.
	 *
	 * @param targaRimorchio the targa rimorchio of this testata documento
	 */
	public void setTargaRimorchio(String targaRimorchio);

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
	public int compareTo(TestataDocumento testataDocumento);

	@Override
	public int hashCode();

	@Override
	public CacheModel<TestataDocumento> toCacheModel();

	@Override
	public TestataDocumento toEscapedModel();

	@Override
	public TestataDocumento toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
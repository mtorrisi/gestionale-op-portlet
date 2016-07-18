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

package it.bysoftware.ct.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import it.bysoftware.ct.model.WKTestataDocumento;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing WKTestataDocumento in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see WKTestataDocumento
 * @generated
 */
public class WKTestataDocumentoCacheModel implements CacheModel<WKTestataDocumento>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(79);

		sb.append("{anno=");
		sb.append(anno);
		sb.append(", numeroOrdine=");
		sb.append(numeroOrdine);
		sb.append(", codiceSoggetto=");
		sb.append(codiceSoggetto);
		sb.append(", dataOrdine=");
		sb.append(dataOrdine);
		sb.append(", dataConsegna=");
		sb.append(dataConsegna);
		sb.append(", destinazione=");
		sb.append(destinazione);
		sb.append(", codiceDestinazione=");
		sb.append(codiceDestinazione);
		sb.append(", ragioneSociale=");
		sb.append(ragioneSociale);
		sb.append(", completo=");
		sb.append(completo);
		sb.append(", operatore=");
		sb.append(operatore);
		sb.append(", visto=");
		sb.append(visto);
		sb.append(", inviato=");
		sb.append(inviato);
		sb.append(", lotto=");
		sb.append(lotto);
		sb.append(", tipoDocumento=");
		sb.append(tipoDocumento);
		sb.append(", vettore=");
		sb.append(vettore);
		sb.append(", autista=");
		sb.append(autista);
		sb.append(", telefono=");
		sb.append(telefono);
		sb.append(", centro=");
		sb.append(centro);
		sb.append(", palletCaricati=");
		sb.append(palletCaricati);
		sb.append(", palletScaricati=");
		sb.append(palletScaricati);
		sb.append(", codiceVettore=");
		sb.append(codiceVettore);
		sb.append(", destinazioneVettore=");
		sb.append(destinazioneVettore);
		sb.append(", nota1=");
		sb.append(nota1);
		sb.append(", nota2=");
		sb.append(nota2);
		sb.append(", rigoDescrittivo=");
		sb.append(rigoDescrittivo);
		sb.append(", vettore2=");
		sb.append(vettore2);
		sb.append(", curaTrasporto=");
		sb.append(curaTrasporto);
		sb.append(", aspettoEsteriore=");
		sb.append(aspettoEsteriore);
		sb.append(", causaleTrasporto=");
		sb.append(causaleTrasporto);
		sb.append(", porto=");
		sb.append(porto);
		sb.append(", origine=");
		sb.append(origine);
		sb.append(", numeroPedaneEuro=");
		sb.append(numeroPedaneEuro);
		sb.append(", numeroPedaneNormali=");
		sb.append(numeroPedaneNormali);
		sb.append(", costoTrasporto=");
		sb.append(costoTrasporto);
		sb.append(", totalePedaneOrdine=");
		sb.append(totalePedaneOrdine);
		sb.append(", targaCamion=");
		sb.append(targaCamion);
		sb.append(", targaRimorchio=");
		sb.append(targaRimorchio);
		sb.append(", idAssociato=");
		sb.append(idAssociato);
		sb.append(", verificato=");
		sb.append(verificato);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WKTestataDocumento toEntityModel() {
		WKTestataDocumentoImpl wkTestataDocumentoImpl = new WKTestataDocumentoImpl();

		wkTestataDocumentoImpl.setAnno(anno);
		wkTestataDocumentoImpl.setNumeroOrdine(numeroOrdine);

		if (codiceSoggetto == null) {
			wkTestataDocumentoImpl.setCodiceSoggetto(StringPool.BLANK);
		}
		else {
			wkTestataDocumentoImpl.setCodiceSoggetto(codiceSoggetto);
		}

		if (dataOrdine == null) {
			wkTestataDocumentoImpl.setDataOrdine(StringPool.BLANK);
		}
		else {
			wkTestataDocumentoImpl.setDataOrdine(dataOrdine);
		}

		if (dataConsegna == null) {
			wkTestataDocumentoImpl.setDataConsegna(StringPool.BLANK);
		}
		else {
			wkTestataDocumentoImpl.setDataConsegna(dataConsegna);
		}

		if (destinazione == null) {
			wkTestataDocumentoImpl.setDestinazione(StringPool.BLANK);
		}
		else {
			wkTestataDocumentoImpl.setDestinazione(destinazione);
		}

		if (codiceDestinazione == null) {
			wkTestataDocumentoImpl.setCodiceDestinazione(StringPool.BLANK);
		}
		else {
			wkTestataDocumentoImpl.setCodiceDestinazione(codiceDestinazione);
		}

		if (ragioneSociale == null) {
			wkTestataDocumentoImpl.setRagioneSociale(StringPool.BLANK);
		}
		else {
			wkTestataDocumentoImpl.setRagioneSociale(ragioneSociale);
		}

		if (completo == null) {
			wkTestataDocumentoImpl.setCompleto(StringPool.BLANK);
		}
		else {
			wkTestataDocumentoImpl.setCompleto(completo);
		}

		if (operatore == null) {
			wkTestataDocumentoImpl.setOperatore(StringPool.BLANK);
		}
		else {
			wkTestataDocumentoImpl.setOperatore(operatore);
		}

		wkTestataDocumentoImpl.setVisto(visto);
		wkTestataDocumentoImpl.setInviato(inviato);

		if (lotto == null) {
			wkTestataDocumentoImpl.setLotto(StringPool.BLANK);
		}
		else {
			wkTestataDocumentoImpl.setLotto(lotto);
		}

		if (tipoDocumento == null) {
			wkTestataDocumentoImpl.setTipoDocumento(StringPool.BLANK);
		}
		else {
			wkTestataDocumentoImpl.setTipoDocumento(tipoDocumento);
		}

		if (vettore == null) {
			wkTestataDocumentoImpl.setVettore(StringPool.BLANK);
		}
		else {
			wkTestataDocumentoImpl.setVettore(vettore);
		}

		if (autista == null) {
			wkTestataDocumentoImpl.setAutista(StringPool.BLANK);
		}
		else {
			wkTestataDocumentoImpl.setAutista(autista);
		}

		if (telefono == null) {
			wkTestataDocumentoImpl.setTelefono(StringPool.BLANK);
		}
		else {
			wkTestataDocumentoImpl.setTelefono(telefono);
		}

		if (centro == null) {
			wkTestataDocumentoImpl.setCentro(StringPool.BLANK);
		}
		else {
			wkTestataDocumentoImpl.setCentro(centro);
		}

		wkTestataDocumentoImpl.setPalletCaricati(palletCaricati);
		wkTestataDocumentoImpl.setPalletScaricati(palletScaricati);

		if (codiceVettore == null) {
			wkTestataDocumentoImpl.setCodiceVettore(StringPool.BLANK);
		}
		else {
			wkTestataDocumentoImpl.setCodiceVettore(codiceVettore);
		}

		if (destinazioneVettore == null) {
			wkTestataDocumentoImpl.setDestinazioneVettore(StringPool.BLANK);
		}
		else {
			wkTestataDocumentoImpl.setDestinazioneVettore(destinazioneVettore);
		}

		if (nota1 == null) {
			wkTestataDocumentoImpl.setNota1(StringPool.BLANK);
		}
		else {
			wkTestataDocumentoImpl.setNota1(nota1);
		}

		if (nota2 == null) {
			wkTestataDocumentoImpl.setNota2(StringPool.BLANK);
		}
		else {
			wkTestataDocumentoImpl.setNota2(nota2);
		}

		if (rigoDescrittivo == null) {
			wkTestataDocumentoImpl.setRigoDescrittivo(StringPool.BLANK);
		}
		else {
			wkTestataDocumentoImpl.setRigoDescrittivo(rigoDescrittivo);
		}

		if (vettore2 == null) {
			wkTestataDocumentoImpl.setVettore2(StringPool.BLANK);
		}
		else {
			wkTestataDocumentoImpl.setVettore2(vettore2);
		}

		if (curaTrasporto == null) {
			wkTestataDocumentoImpl.setCuraTrasporto(StringPool.BLANK);
		}
		else {
			wkTestataDocumentoImpl.setCuraTrasporto(curaTrasporto);
		}

		if (aspettoEsteriore == null) {
			wkTestataDocumentoImpl.setAspettoEsteriore(StringPool.BLANK);
		}
		else {
			wkTestataDocumentoImpl.setAspettoEsteriore(aspettoEsteriore);
		}

		if (causaleTrasporto == null) {
			wkTestataDocumentoImpl.setCausaleTrasporto(StringPool.BLANK);
		}
		else {
			wkTestataDocumentoImpl.setCausaleTrasporto(causaleTrasporto);
		}

		if (porto == null) {
			wkTestataDocumentoImpl.setPorto(StringPool.BLANK);
		}
		else {
			wkTestataDocumentoImpl.setPorto(porto);
		}

		if (origine == null) {
			wkTestataDocumentoImpl.setOrigine(StringPool.BLANK);
		}
		else {
			wkTestataDocumentoImpl.setOrigine(origine);
		}

		wkTestataDocumentoImpl.setNumeroPedaneEuro(numeroPedaneEuro);
		wkTestataDocumentoImpl.setNumeroPedaneNormali(numeroPedaneNormali);
		wkTestataDocumentoImpl.setCostoTrasporto(costoTrasporto);
		wkTestataDocumentoImpl.setTotalePedaneOrdine(totalePedaneOrdine);

		if (targaCamion == null) {
			wkTestataDocumentoImpl.setTargaCamion(StringPool.BLANK);
		}
		else {
			wkTestataDocumentoImpl.setTargaCamion(targaCamion);
		}

		if (targaRimorchio == null) {
			wkTestataDocumentoImpl.setTargaRimorchio(StringPool.BLANK);
		}
		else {
			wkTestataDocumentoImpl.setTargaRimorchio(targaRimorchio);
		}

		wkTestataDocumentoImpl.setIdAssociato(idAssociato);
		wkTestataDocumentoImpl.setVerificato(verificato);

		wkTestataDocumentoImpl.resetOriginalValues();

		return wkTestataDocumentoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		anno = objectInput.readInt();
		numeroOrdine = objectInput.readLong();
		codiceSoggetto = objectInput.readUTF();
		dataOrdine = objectInput.readUTF();
		dataConsegna = objectInput.readUTF();
		destinazione = objectInput.readUTF();
		codiceDestinazione = objectInput.readUTF();
		ragioneSociale = objectInput.readUTF();
		completo = objectInput.readUTF();
		operatore = objectInput.readUTF();
		visto = objectInput.readInt();
		inviato = objectInput.readInt();
		lotto = objectInput.readUTF();
		tipoDocumento = objectInput.readUTF();
		vettore = objectInput.readUTF();
		autista = objectInput.readUTF();
		telefono = objectInput.readUTF();
		centro = objectInput.readUTF();
		palletCaricati = objectInput.readInt();
		palletScaricati = objectInput.readInt();
		codiceVettore = objectInput.readUTF();
		destinazioneVettore = objectInput.readUTF();
		nota1 = objectInput.readUTF();
		nota2 = objectInput.readUTF();
		rigoDescrittivo = objectInput.readUTF();
		vettore2 = objectInput.readUTF();
		curaTrasporto = objectInput.readUTF();
		aspettoEsteriore = objectInput.readUTF();
		causaleTrasporto = objectInput.readUTF();
		porto = objectInput.readUTF();
		origine = objectInput.readUTF();
		numeroPedaneEuro = objectInput.readInt();
		numeroPedaneNormali = objectInput.readInt();
		costoTrasporto = objectInput.readDouble();
		totalePedaneOrdine = objectInput.readInt();
		targaCamion = objectInput.readUTF();
		targaRimorchio = objectInput.readUTF();
		idAssociato = objectInput.readLong();
		verificato = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(anno);
		objectOutput.writeLong(numeroOrdine);

		if (codiceSoggetto == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceSoggetto);
		}

		if (dataOrdine == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dataOrdine);
		}

		if (dataConsegna == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dataConsegna);
		}

		if (destinazione == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(destinazione);
		}

		if (codiceDestinazione == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceDestinazione);
		}

		if (ragioneSociale == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ragioneSociale);
		}

		if (completo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(completo);
		}

		if (operatore == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(operatore);
		}

		objectOutput.writeInt(visto);
		objectOutput.writeInt(inviato);

		if (lotto == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lotto);
		}

		if (tipoDocumento == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tipoDocumento);
		}

		if (vettore == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(vettore);
		}

		if (autista == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(autista);
		}

		if (telefono == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(telefono);
		}

		if (centro == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(centro);
		}

		objectOutput.writeInt(palletCaricati);
		objectOutput.writeInt(palletScaricati);

		if (codiceVettore == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceVettore);
		}

		if (destinazioneVettore == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(destinazioneVettore);
		}

		if (nota1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nota1);
		}

		if (nota2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nota2);
		}

		if (rigoDescrittivo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(rigoDescrittivo);
		}

		if (vettore2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(vettore2);
		}

		if (curaTrasporto == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(curaTrasporto);
		}

		if (aspettoEsteriore == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(aspettoEsteriore);
		}

		if (causaleTrasporto == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(causaleTrasporto);
		}

		if (porto == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(porto);
		}

		if (origine == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(origine);
		}

		objectOutput.writeInt(numeroPedaneEuro);
		objectOutput.writeInt(numeroPedaneNormali);
		objectOutput.writeDouble(costoTrasporto);
		objectOutput.writeInt(totalePedaneOrdine);

		if (targaCamion == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(targaCamion);
		}

		if (targaRimorchio == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(targaRimorchio);
		}

		objectOutput.writeLong(idAssociato);
		objectOutput.writeBoolean(verificato);
	}

	public int anno;
	public long numeroOrdine;
	public String codiceSoggetto;
	public String dataOrdine;
	public String dataConsegna;
	public String destinazione;
	public String codiceDestinazione;
	public String ragioneSociale;
	public String completo;
	public String operatore;
	public int visto;
	public int inviato;
	public String lotto;
	public String tipoDocumento;
	public String vettore;
	public String autista;
	public String telefono;
	public String centro;
	public int palletCaricati;
	public int palletScaricati;
	public String codiceVettore;
	public String destinazioneVettore;
	public String nota1;
	public String nota2;
	public String rigoDescrittivo;
	public String vettore2;
	public String curaTrasporto;
	public String aspettoEsteriore;
	public String causaleTrasporto;
	public String porto;
	public String origine;
	public int numeroPedaneEuro;
	public int numeroPedaneNormali;
	public double costoTrasporto;
	public int totalePedaneOrdine;
	public String targaCamion;
	public String targaRimorchio;
	public long idAssociato;
	public boolean verificato;
}
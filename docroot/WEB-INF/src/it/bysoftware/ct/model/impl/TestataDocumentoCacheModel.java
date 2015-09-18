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

import it.bysoftware.ct.model.TestataDocumento;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TestataDocumento in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see TestataDocumento
 * @generated
 */
public class TestataDocumentoCacheModel implements CacheModel<TestataDocumento>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(77);

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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TestataDocumento toEntityModel() {
		TestataDocumentoImpl testataDocumentoImpl = new TestataDocumentoImpl();

		testataDocumentoImpl.setAnno(anno);
		testataDocumentoImpl.setNumeroOrdine(numeroOrdine);

		if (codiceSoggetto == null) {
			testataDocumentoImpl.setCodiceSoggetto(StringPool.BLANK);
		}
		else {
			testataDocumentoImpl.setCodiceSoggetto(codiceSoggetto);
		}

		if (dataOrdine == null) {
			testataDocumentoImpl.setDataOrdine(StringPool.BLANK);
		}
		else {
			testataDocumentoImpl.setDataOrdine(dataOrdine);
		}

		if (dataConsegna == null) {
			testataDocumentoImpl.setDataConsegna(StringPool.BLANK);
		}
		else {
			testataDocumentoImpl.setDataConsegna(dataConsegna);
		}

		if (destinazione == null) {
			testataDocumentoImpl.setDestinazione(StringPool.BLANK);
		}
		else {
			testataDocumentoImpl.setDestinazione(destinazione);
		}

		if (codiceDestinazione == null) {
			testataDocumentoImpl.setCodiceDestinazione(StringPool.BLANK);
		}
		else {
			testataDocumentoImpl.setCodiceDestinazione(codiceDestinazione);
		}

		if (ragioneSociale == null) {
			testataDocumentoImpl.setRagioneSociale(StringPool.BLANK);
		}
		else {
			testataDocumentoImpl.setRagioneSociale(ragioneSociale);
		}

		if (completo == null) {
			testataDocumentoImpl.setCompleto(StringPool.BLANK);
		}
		else {
			testataDocumentoImpl.setCompleto(completo);
		}

		if (operatore == null) {
			testataDocumentoImpl.setOperatore(StringPool.BLANK);
		}
		else {
			testataDocumentoImpl.setOperatore(operatore);
		}

		testataDocumentoImpl.setVisto(visto);
		testataDocumentoImpl.setInviato(inviato);

		if (lotto == null) {
			testataDocumentoImpl.setLotto(StringPool.BLANK);
		}
		else {
			testataDocumentoImpl.setLotto(lotto);
		}

		if (tipoDocumento == null) {
			testataDocumentoImpl.setTipoDocumento(StringPool.BLANK);
		}
		else {
			testataDocumentoImpl.setTipoDocumento(tipoDocumento);
		}

		if (vettore == null) {
			testataDocumentoImpl.setVettore(StringPool.BLANK);
		}
		else {
			testataDocumentoImpl.setVettore(vettore);
		}

		if (autista == null) {
			testataDocumentoImpl.setAutista(StringPool.BLANK);
		}
		else {
			testataDocumentoImpl.setAutista(autista);
		}

		if (telefono == null) {
			testataDocumentoImpl.setTelefono(StringPool.BLANK);
		}
		else {
			testataDocumentoImpl.setTelefono(telefono);
		}

		if (centro == null) {
			testataDocumentoImpl.setCentro(StringPool.BLANK);
		}
		else {
			testataDocumentoImpl.setCentro(centro);
		}

		testataDocumentoImpl.setPalletCaricati(palletCaricati);
		testataDocumentoImpl.setPalletScaricati(palletScaricati);

		if (codiceVettore == null) {
			testataDocumentoImpl.setCodiceVettore(StringPool.BLANK);
		}
		else {
			testataDocumentoImpl.setCodiceVettore(codiceVettore);
		}

		if (destinazioneVettore == null) {
			testataDocumentoImpl.setDestinazioneVettore(StringPool.BLANK);
		}
		else {
			testataDocumentoImpl.setDestinazioneVettore(destinazioneVettore);
		}

		if (nota1 == null) {
			testataDocumentoImpl.setNota1(StringPool.BLANK);
		}
		else {
			testataDocumentoImpl.setNota1(nota1);
		}

		if (nota2 == null) {
			testataDocumentoImpl.setNota2(StringPool.BLANK);
		}
		else {
			testataDocumentoImpl.setNota2(nota2);
		}

		if (rigoDescrittivo == null) {
			testataDocumentoImpl.setRigoDescrittivo(StringPool.BLANK);
		}
		else {
			testataDocumentoImpl.setRigoDescrittivo(rigoDescrittivo);
		}

		if (vettore2 == null) {
			testataDocumentoImpl.setVettore2(StringPool.BLANK);
		}
		else {
			testataDocumentoImpl.setVettore2(vettore2);
		}

		if (curaTrasporto == null) {
			testataDocumentoImpl.setCuraTrasporto(StringPool.BLANK);
		}
		else {
			testataDocumentoImpl.setCuraTrasporto(curaTrasporto);
		}

		if (aspettoEsteriore == null) {
			testataDocumentoImpl.setAspettoEsteriore(StringPool.BLANK);
		}
		else {
			testataDocumentoImpl.setAspettoEsteriore(aspettoEsteriore);
		}

		if (causaleTrasporto == null) {
			testataDocumentoImpl.setCausaleTrasporto(StringPool.BLANK);
		}
		else {
			testataDocumentoImpl.setCausaleTrasporto(causaleTrasporto);
		}

		if (porto == null) {
			testataDocumentoImpl.setPorto(StringPool.BLANK);
		}
		else {
			testataDocumentoImpl.setPorto(porto);
		}

		if (origine == null) {
			testataDocumentoImpl.setOrigine(StringPool.BLANK);
		}
		else {
			testataDocumentoImpl.setOrigine(origine);
		}

		testataDocumentoImpl.setNumeroPedaneEuro(numeroPedaneEuro);
		testataDocumentoImpl.setNumeroPedaneNormali(numeroPedaneNormali);
		testataDocumentoImpl.setCostoTrasporto(costoTrasporto);
		testataDocumentoImpl.setTotalePedaneOrdine(totalePedaneOrdine);

		if (targaCamion == null) {
			testataDocumentoImpl.setTargaCamion(StringPool.BLANK);
		}
		else {
			testataDocumentoImpl.setTargaCamion(targaCamion);
		}

		if (targaRimorchio == null) {
			testataDocumentoImpl.setTargaRimorchio(StringPool.BLANK);
		}
		else {
			testataDocumentoImpl.setTargaRimorchio(targaRimorchio);
		}

		testataDocumentoImpl.setIdAssociato(idAssociato);

		testataDocumentoImpl.resetOriginalValues();

		return testataDocumentoImpl;
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
}
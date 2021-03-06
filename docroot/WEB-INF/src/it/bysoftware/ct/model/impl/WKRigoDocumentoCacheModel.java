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

import it.bysoftware.ct.model.WKRigoDocumento;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing WKRigoDocumento in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see WKRigoDocumento
 * @generated
 */
public class WKRigoDocumentoCacheModel implements CacheModel<WKRigoDocumento>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(61);

		sb.append("{anno=");
		sb.append(anno);
		sb.append(", numeroOrdine=");
		sb.append(numeroOrdine);
		sb.append(", rigoOrdine=");
		sb.append(rigoOrdine);
		sb.append(", codiceVariante=");
		sb.append(codiceVariante);
		sb.append(", descrizioneVariante=");
		sb.append(descrizioneVariante);
		sb.append(", codiceArticolo=");
		sb.append(codiceArticolo);
		sb.append(", descrizione=");
		sb.append(descrizione);
		sb.append(", unitaMisura=");
		sb.append(unitaMisura);
		sb.append(", colli=");
		sb.append(colli);
		sb.append(", pesoLordo=");
		sb.append(pesoLordo);
		sb.append(", tara=");
		sb.append(tara);
		sb.append(", pesoNetto=");
		sb.append(pesoNetto);
		sb.append(", prezzo=");
		sb.append(prezzo);
		sb.append(", pedane=");
		sb.append(pedane);
		sb.append(", note=");
		sb.append(note);
		sb.append(", totalePesata=");
		sb.append(totalePesata);
		sb.append(", imballo=");
		sb.append(imballo);
		sb.append(", gestioneReti=");
		sb.append(gestioneReti);
		sb.append(", RtxCl=");
		sb.append(RtxCl);
		sb.append(", kgRete=");
		sb.append(kgRete);
		sb.append(", lotto=");
		sb.append(lotto);
		sb.append(", passaporto=");
		sb.append(passaporto);
		sb.append(", progressivo=");
		sb.append(progressivo);
		sb.append(", riferimentoBolla=");
		sb.append(riferimentoBolla);
		sb.append(", sconto1=");
		sb.append(sconto1);
		sb.append(", sconto2=");
		sb.append(sconto2);
		sb.append(", sconto3=");
		sb.append(sconto3);
		sb.append(", tipoDocumento=");
		sb.append(tipoDocumento);
		sb.append(", idAssociato=");
		sb.append(idAssociato);
		sb.append(", verificato=");
		sb.append(verificato);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WKRigoDocumento toEntityModel() {
		WKRigoDocumentoImpl wkRigoDocumentoImpl = new WKRigoDocumentoImpl();

		wkRigoDocumentoImpl.setAnno(anno);
		wkRigoDocumentoImpl.setNumeroOrdine(numeroOrdine);
		wkRigoDocumentoImpl.setRigoOrdine(rigoOrdine);

		if (codiceVariante == null) {
			wkRigoDocumentoImpl.setCodiceVariante(StringPool.BLANK);
		}
		else {
			wkRigoDocumentoImpl.setCodiceVariante(codiceVariante);
		}

		if (descrizioneVariante == null) {
			wkRigoDocumentoImpl.setDescrizioneVariante(StringPool.BLANK);
		}
		else {
			wkRigoDocumentoImpl.setDescrizioneVariante(descrizioneVariante);
		}

		if (codiceArticolo == null) {
			wkRigoDocumentoImpl.setCodiceArticolo(StringPool.BLANK);
		}
		else {
			wkRigoDocumentoImpl.setCodiceArticolo(codiceArticolo);
		}

		if (descrizione == null) {
			wkRigoDocumentoImpl.setDescrizione(StringPool.BLANK);
		}
		else {
			wkRigoDocumentoImpl.setDescrizione(descrizione);
		}

		if (unitaMisura == null) {
			wkRigoDocumentoImpl.setUnitaMisura(StringPool.BLANK);
		}
		else {
			wkRigoDocumentoImpl.setUnitaMisura(unitaMisura);
		}

		wkRigoDocumentoImpl.setColli(colli);
		wkRigoDocumentoImpl.setPesoLordo(pesoLordo);
		wkRigoDocumentoImpl.setTara(tara);
		wkRigoDocumentoImpl.setPesoNetto(pesoNetto);
		wkRigoDocumentoImpl.setPrezzo(prezzo);
		wkRigoDocumentoImpl.setPedane(pedane);

		if (note == null) {
			wkRigoDocumentoImpl.setNote(StringPool.BLANK);
		}
		else {
			wkRigoDocumentoImpl.setNote(note);
		}

		wkRigoDocumentoImpl.setTotalePesata(totalePesata);

		if (imballo == null) {
			wkRigoDocumentoImpl.setImballo(StringPool.BLANK);
		}
		else {
			wkRigoDocumentoImpl.setImballo(imballo);
		}

		wkRigoDocumentoImpl.setGestioneReti(gestioneReti);
		wkRigoDocumentoImpl.setRtxCl(RtxCl);
		wkRigoDocumentoImpl.setKgRete(kgRete);

		if (lotto == null) {
			wkRigoDocumentoImpl.setLotto(StringPool.BLANK);
		}
		else {
			wkRigoDocumentoImpl.setLotto(lotto);
		}

		if (passaporto == null) {
			wkRigoDocumentoImpl.setPassaporto(StringPool.BLANK);
		}
		else {
			wkRigoDocumentoImpl.setPassaporto(passaporto);
		}

		wkRigoDocumentoImpl.setProgressivo(progressivo);
		wkRigoDocumentoImpl.setRiferimentoBolla(riferimentoBolla);
		wkRigoDocumentoImpl.setSconto1(sconto1);
		wkRigoDocumentoImpl.setSconto2(sconto2);
		wkRigoDocumentoImpl.setSconto3(sconto3);

		if (tipoDocumento == null) {
			wkRigoDocumentoImpl.setTipoDocumento(StringPool.BLANK);
		}
		else {
			wkRigoDocumentoImpl.setTipoDocumento(tipoDocumento);
		}

		wkRigoDocumentoImpl.setIdAssociato(idAssociato);
		wkRigoDocumentoImpl.setVerificato(verificato);

		wkRigoDocumentoImpl.resetOriginalValues();

		return wkRigoDocumentoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		anno = objectInput.readInt();
		numeroOrdine = objectInput.readLong();
		rigoOrdine = objectInput.readInt();
		codiceVariante = objectInput.readUTF();
		descrizioneVariante = objectInput.readUTF();
		codiceArticolo = objectInput.readUTF();
		descrizione = objectInput.readUTF();
		unitaMisura = objectInput.readUTF();
		colli = objectInput.readInt();
		pesoLordo = objectInput.readDouble();
		tara = objectInput.readDouble();
		pesoNetto = objectInput.readDouble();
		prezzo = objectInput.readDouble();
		pedane = objectInput.readDouble();
		note = objectInput.readUTF();
		totalePesata = objectInput.readDouble();
		imballo = objectInput.readUTF();
		gestioneReti = objectInput.readBoolean();
		RtxCl = objectInput.readDouble();
		kgRete = objectInput.readDouble();
		lotto = objectInput.readUTF();
		passaporto = objectInput.readUTF();
		progressivo = objectInput.readInt();
		riferimentoBolla = objectInput.readInt();
		sconto1 = objectInput.readFloat();
		sconto2 = objectInput.readFloat();
		sconto3 = objectInput.readFloat();
		tipoDocumento = objectInput.readUTF();
		idAssociato = objectInput.readLong();
		verificato = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(anno);
		objectOutput.writeLong(numeroOrdine);
		objectOutput.writeInt(rigoOrdine);

		if (codiceVariante == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceVariante);
		}

		if (descrizioneVariante == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(descrizioneVariante);
		}

		if (codiceArticolo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceArticolo);
		}

		if (descrizione == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(descrizione);
		}

		if (unitaMisura == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(unitaMisura);
		}

		objectOutput.writeInt(colli);
		objectOutput.writeDouble(pesoLordo);
		objectOutput.writeDouble(tara);
		objectOutput.writeDouble(pesoNetto);
		objectOutput.writeDouble(prezzo);
		objectOutput.writeDouble(pedane);

		if (note == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note);
		}

		objectOutput.writeDouble(totalePesata);

		if (imballo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(imballo);
		}

		objectOutput.writeBoolean(gestioneReti);
		objectOutput.writeDouble(RtxCl);
		objectOutput.writeDouble(kgRete);

		if (lotto == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lotto);
		}

		if (passaporto == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(passaporto);
		}

		objectOutput.writeInt(progressivo);
		objectOutput.writeInt(riferimentoBolla);
		objectOutput.writeFloat(sconto1);
		objectOutput.writeFloat(sconto2);
		objectOutput.writeFloat(sconto3);

		if (tipoDocumento == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tipoDocumento);
		}

		objectOutput.writeLong(idAssociato);
		objectOutput.writeBoolean(verificato);
	}

	public int anno;
	public long numeroOrdine;
	public int rigoOrdine;
	public String codiceVariante;
	public String descrizioneVariante;
	public String codiceArticolo;
	public String descrizione;
	public String unitaMisura;
	public int colli;
	public double pesoLordo;
	public double tara;
	public double pesoNetto;
	public double prezzo;
	public double pedane;
	public String note;
	public double totalePesata;
	public String imballo;
	public boolean gestioneReti;
	public double RtxCl;
	public double kgRete;
	public String lotto;
	public String passaporto;
	public int progressivo;
	public int riferimentoBolla;
	public float sconto1;
	public float sconto2;
	public float sconto3;
	public String tipoDocumento;
	public long idAssociato;
	public boolean verificato;
}
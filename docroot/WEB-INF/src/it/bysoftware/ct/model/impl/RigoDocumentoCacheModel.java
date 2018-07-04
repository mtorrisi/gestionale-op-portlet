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

import it.bysoftware.ct.model.RigoDocumento;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RigoDocumento in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see RigoDocumento
 * @generated
 */
public class RigoDocumentoCacheModel implements CacheModel<RigoDocumento>,
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
		sb.append(", codiceIva=");
		sb.append(codiceIva);
		sb.append(", idAssociato=");
		sb.append(idAssociato);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RigoDocumento toEntityModel() {
		RigoDocumentoImpl rigoDocumentoImpl = new RigoDocumentoImpl();

		rigoDocumentoImpl.setAnno(anno);
		rigoDocumentoImpl.setNumeroOrdine(numeroOrdine);
		rigoDocumentoImpl.setRigoOrdine(rigoOrdine);

		if (codiceVariante == null) {
			rigoDocumentoImpl.setCodiceVariante(StringPool.BLANK);
		}
		else {
			rigoDocumentoImpl.setCodiceVariante(codiceVariante);
		}

		if (descrizioneVariante == null) {
			rigoDocumentoImpl.setDescrizioneVariante(StringPool.BLANK);
		}
		else {
			rigoDocumentoImpl.setDescrizioneVariante(descrizioneVariante);
		}

		if (codiceArticolo == null) {
			rigoDocumentoImpl.setCodiceArticolo(StringPool.BLANK);
		}
		else {
			rigoDocumentoImpl.setCodiceArticolo(codiceArticolo);
		}

		if (descrizione == null) {
			rigoDocumentoImpl.setDescrizione(StringPool.BLANK);
		}
		else {
			rigoDocumentoImpl.setDescrizione(descrizione);
		}

		if (unitaMisura == null) {
			rigoDocumentoImpl.setUnitaMisura(StringPool.BLANK);
		}
		else {
			rigoDocumentoImpl.setUnitaMisura(unitaMisura);
		}

		rigoDocumentoImpl.setColli(colli);
		rigoDocumentoImpl.setPesoLordo(pesoLordo);
		rigoDocumentoImpl.setTara(tara);
		rigoDocumentoImpl.setPesoNetto(pesoNetto);
		rigoDocumentoImpl.setPrezzo(prezzo);
		rigoDocumentoImpl.setPedane(pedane);

		if (note == null) {
			rigoDocumentoImpl.setNote(StringPool.BLANK);
		}
		else {
			rigoDocumentoImpl.setNote(note);
		}

		rigoDocumentoImpl.setTotalePesata(totalePesata);

		if (imballo == null) {
			rigoDocumentoImpl.setImballo(StringPool.BLANK);
		}
		else {
			rigoDocumentoImpl.setImballo(imballo);
		}

		rigoDocumentoImpl.setGestioneReti(gestioneReti);
		rigoDocumentoImpl.setRtxCl(RtxCl);
		rigoDocumentoImpl.setKgRete(kgRete);

		if (lotto == null) {
			rigoDocumentoImpl.setLotto(StringPool.BLANK);
		}
		else {
			rigoDocumentoImpl.setLotto(lotto);
		}

		if (passaporto == null) {
			rigoDocumentoImpl.setPassaporto(StringPool.BLANK);
		}
		else {
			rigoDocumentoImpl.setPassaporto(passaporto);
		}

		rigoDocumentoImpl.setProgressivo(progressivo);
		rigoDocumentoImpl.setRiferimentoBolla(riferimentoBolla);
		rigoDocumentoImpl.setSconto1(sconto1);
		rigoDocumentoImpl.setSconto2(sconto2);
		rigoDocumentoImpl.setSconto3(sconto3);

		if (tipoDocumento == null) {
			rigoDocumentoImpl.setTipoDocumento(StringPool.BLANK);
		}
		else {
			rigoDocumentoImpl.setTipoDocumento(tipoDocumento);
		}

		if (codiceIva == null) {
			rigoDocumentoImpl.setCodiceIva(StringPool.BLANK);
		}
		else {
			rigoDocumentoImpl.setCodiceIva(codiceIva);
		}

		rigoDocumentoImpl.setIdAssociato(idAssociato);

		rigoDocumentoImpl.resetOriginalValues();

		return rigoDocumentoImpl;
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
		codiceIva = objectInput.readUTF();
		idAssociato = objectInput.readLong();
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

		if (codiceIva == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceIva);
		}

		objectOutput.writeLong(idAssociato);
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
	public String codiceIva;
	public long idAssociato;
}
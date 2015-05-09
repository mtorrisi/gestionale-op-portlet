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

import it.bysoftware.ct.model.Anagrafica;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Anagrafica in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Anagrafica
 * @generated
 */
public class AnagraficaCacheModel implements CacheModel<Anagrafica>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{attivoEC=");
		sb.append(attivoEC);
		sb.append(", cap=");
		sb.append(cap);
		sb.append(", codiceAnagrafica=");
		sb.append(codiceAnagrafica);
		sb.append(", codiceFiscale=");
		sb.append(codiceFiscale);
		sb.append(", codiceMne=");
		sb.append(codiceMne);
		sb.append(", comune=");
		sb.append(comune);
		sb.append(", Indirizzo=");
		sb.append(Indirizzo);
		sb.append(", note=");
		sb.append(note);
		sb.append(", partitaIVA=");
		sb.append(partitaIVA);
		sb.append(", ragioneSociale=");
		sb.append(ragioneSociale);
		sb.append(", ragioneSocialeAlternativa=");
		sb.append(ragioneSocialeAlternativa);
		sb.append(", provincia=");
		sb.append(provincia);
		sb.append(", stato=");
		sb.append(stato);
		sb.append(", tepefi=");
		sb.append(tepefi);
		sb.append(", tipoSoggetto=");
		sb.append(tipoSoggetto);
		sb.append(", tipsol=");
		sb.append(tipsol);
		sb.append(", codiceAzienda=");
		sb.append(codiceAzienda);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Anagrafica toEntityModel() {
		AnagraficaImpl anagraficaImpl = new AnagraficaImpl();

		anagraficaImpl.setAttivoEC(attivoEC);

		if (cap == null) {
			anagraficaImpl.setCap(StringPool.BLANK);
		}
		else {
			anagraficaImpl.setCap(cap);
		}

		if (codiceAnagrafica == null) {
			anagraficaImpl.setCodiceAnagrafica(StringPool.BLANK);
		}
		else {
			anagraficaImpl.setCodiceAnagrafica(codiceAnagrafica);
		}

		if (codiceFiscale == null) {
			anagraficaImpl.setCodiceFiscale(StringPool.BLANK);
		}
		else {
			anagraficaImpl.setCodiceFiscale(codiceFiscale);
		}

		if (codiceMne == null) {
			anagraficaImpl.setCodiceMne(StringPool.BLANK);
		}
		else {
			anagraficaImpl.setCodiceMne(codiceMne);
		}

		if (comune == null) {
			anagraficaImpl.setComune(StringPool.BLANK);
		}
		else {
			anagraficaImpl.setComune(comune);
		}

		if (Indirizzo == null) {
			anagraficaImpl.setIndirizzo(StringPool.BLANK);
		}
		else {
			anagraficaImpl.setIndirizzo(Indirizzo);
		}

		if (note == null) {
			anagraficaImpl.setNote(StringPool.BLANK);
		}
		else {
			anagraficaImpl.setNote(note);
		}

		if (partitaIVA == null) {
			anagraficaImpl.setPartitaIVA(StringPool.BLANK);
		}
		else {
			anagraficaImpl.setPartitaIVA(partitaIVA);
		}

		if (ragioneSociale == null) {
			anagraficaImpl.setRagioneSociale(StringPool.BLANK);
		}
		else {
			anagraficaImpl.setRagioneSociale(ragioneSociale);
		}

		if (ragioneSocialeAlternativa == null) {
			anagraficaImpl.setRagioneSocialeAlternativa(StringPool.BLANK);
		}
		else {
			anagraficaImpl.setRagioneSocialeAlternativa(ragioneSocialeAlternativa);
		}

		if (provincia == null) {
			anagraficaImpl.setProvincia(StringPool.BLANK);
		}
		else {
			anagraficaImpl.setProvincia(provincia);
		}

		if (stato == null) {
			anagraficaImpl.setStato(StringPool.BLANK);
		}
		else {
			anagraficaImpl.setStato(stato);
		}

		anagraficaImpl.setTepefi(tepefi);

		if (tipoSoggetto == null) {
			anagraficaImpl.setTipoSoggetto(StringPool.BLANK);
		}
		else {
			anagraficaImpl.setTipoSoggetto(tipoSoggetto);
		}

		anagraficaImpl.setTipsol(tipsol);

		if (codiceAzienda == null) {
			anagraficaImpl.setCodiceAzienda(StringPool.BLANK);
		}
		else {
			anagraficaImpl.setCodiceAzienda(codiceAzienda);
		}

		anagraficaImpl.resetOriginalValues();

		return anagraficaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		attivoEC = objectInput.readInt();
		cap = objectInput.readUTF();
		codiceAnagrafica = objectInput.readUTF();
		codiceFiscale = objectInput.readUTF();
		codiceMne = objectInput.readUTF();
		comune = objectInput.readUTF();
		Indirizzo = objectInput.readUTF();
		note = objectInput.readUTF();
		partitaIVA = objectInput.readUTF();
		ragioneSociale = objectInput.readUTF();
		ragioneSocialeAlternativa = objectInput.readUTF();
		provincia = objectInput.readUTF();
		stato = objectInput.readUTF();
		tepefi = objectInput.readInt();
		tipoSoggetto = objectInput.readUTF();
		tipsol = objectInput.readInt();
		codiceAzienda = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(attivoEC);

		if (cap == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cap);
		}

		if (codiceAnagrafica == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceAnagrafica);
		}

		if (codiceFiscale == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceFiscale);
		}

		if (codiceMne == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceMne);
		}

		if (comune == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comune);
		}

		if (Indirizzo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Indirizzo);
		}

		if (note == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note);
		}

		if (partitaIVA == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(partitaIVA);
		}

		if (ragioneSociale == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ragioneSociale);
		}

		if (ragioneSocialeAlternativa == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ragioneSocialeAlternativa);
		}

		if (provincia == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(provincia);
		}

		if (stato == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stato);
		}

		objectOutput.writeInt(tepefi);

		if (tipoSoggetto == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tipoSoggetto);
		}

		objectOutput.writeInt(tipsol);

		if (codiceAzienda == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceAzienda);
		}
	}

	public int attivoEC;
	public String cap;
	public String codiceAnagrafica;
	public String codiceFiscale;
	public String codiceMne;
	public String comune;
	public String Indirizzo;
	public String note;
	public String partitaIVA;
	public String ragioneSociale;
	public String ragioneSocialeAlternativa;
	public String provincia;
	public String stato;
	public int tepefi;
	public String tipoSoggetto;
	public int tipsol;
	public String codiceAzienda;
}
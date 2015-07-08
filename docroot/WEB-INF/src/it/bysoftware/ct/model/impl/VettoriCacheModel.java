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

import it.bysoftware.ct.model.Vettori;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Vettori in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Vettori
 * @generated
 */
public class VettoriCacheModel implements CacheModel<Vettori>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{albo=");
		sb.append(albo);
		sb.append(", CAP=");
		sb.append(CAP);
		sb.append(", codiceVettore=");
		sb.append(codiceVettore);
		sb.append(", codiceFiscale=");
		sb.append(codiceFiscale);
		sb.append(", codiceRiferimento=");
		sb.append(codiceRiferimento);
		sb.append(", comune=");
		sb.append(comune);
		sb.append(", indirizzo=");
		sb.append(indirizzo);
		sb.append(", note=");
		sb.append(note);
		sb.append(", partitaIVA=");
		sb.append(partitaIVA);
		sb.append(", ragioneSociale=");
		sb.append(ragioneSociale);
		sb.append(", ragioneSociale2=");
		sb.append(ragioneSociale2);
		sb.append(", provincia=");
		sb.append(provincia);
		sb.append(", stato=");
		sb.append(stato);
		sb.append(", tipoAnagrafica=");
		sb.append(tipoAnagrafica);
		sb.append(", codiceAzienda=");
		sb.append(codiceAzienda);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Vettori toEntityModel() {
		VettoriImpl vettoriImpl = new VettoriImpl();

		if (albo == null) {
			vettoriImpl.setAlbo(StringPool.BLANK);
		}
		else {
			vettoriImpl.setAlbo(albo);
		}

		if (CAP == null) {
			vettoriImpl.setCAP(StringPool.BLANK);
		}
		else {
			vettoriImpl.setCAP(CAP);
		}

		if (codiceVettore == null) {
			vettoriImpl.setCodiceVettore(StringPool.BLANK);
		}
		else {
			vettoriImpl.setCodiceVettore(codiceVettore);
		}

		if (codiceFiscale == null) {
			vettoriImpl.setCodiceFiscale(StringPool.BLANK);
		}
		else {
			vettoriImpl.setCodiceFiscale(codiceFiscale);
		}

		if (codiceRiferimento == null) {
			vettoriImpl.setCodiceRiferimento(StringPool.BLANK);
		}
		else {
			vettoriImpl.setCodiceRiferimento(codiceRiferimento);
		}

		if (comune == null) {
			vettoriImpl.setComune(StringPool.BLANK);
		}
		else {
			vettoriImpl.setComune(comune);
		}

		if (indirizzo == null) {
			vettoriImpl.setIndirizzo(StringPool.BLANK);
		}
		else {
			vettoriImpl.setIndirizzo(indirizzo);
		}

		if (note == null) {
			vettoriImpl.setNote(StringPool.BLANK);
		}
		else {
			vettoriImpl.setNote(note);
		}

		if (partitaIVA == null) {
			vettoriImpl.setPartitaIVA(StringPool.BLANK);
		}
		else {
			vettoriImpl.setPartitaIVA(partitaIVA);
		}

		if (ragioneSociale == null) {
			vettoriImpl.setRagioneSociale(StringPool.BLANK);
		}
		else {
			vettoriImpl.setRagioneSociale(ragioneSociale);
		}

		if (ragioneSociale2 == null) {
			vettoriImpl.setRagioneSociale2(StringPool.BLANK);
		}
		else {
			vettoriImpl.setRagioneSociale2(ragioneSociale2);
		}

		if (provincia == null) {
			vettoriImpl.setProvincia(StringPool.BLANK);
		}
		else {
			vettoriImpl.setProvincia(provincia);
		}

		if (stato == null) {
			vettoriImpl.setStato(StringPool.BLANK);
		}
		else {
			vettoriImpl.setStato(stato);
		}

		if (tipoAnagrafica == null) {
			vettoriImpl.setTipoAnagrafica(StringPool.BLANK);
		}
		else {
			vettoriImpl.setTipoAnagrafica(tipoAnagrafica);
		}

		if (codiceAzienda == null) {
			vettoriImpl.setCodiceAzienda(StringPool.BLANK);
		}
		else {
			vettoriImpl.setCodiceAzienda(codiceAzienda);
		}

		vettoriImpl.resetOriginalValues();

		return vettoriImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		albo = objectInput.readUTF();
		CAP = objectInput.readUTF();
		codiceVettore = objectInput.readUTF();
		codiceFiscale = objectInput.readUTF();
		codiceRiferimento = objectInput.readUTF();
		comune = objectInput.readUTF();
		indirizzo = objectInput.readUTF();
		note = objectInput.readUTF();
		partitaIVA = objectInput.readUTF();
		ragioneSociale = objectInput.readUTF();
		ragioneSociale2 = objectInput.readUTF();
		provincia = objectInput.readUTF();
		stato = objectInput.readUTF();
		tipoAnagrafica = objectInput.readUTF();
		codiceAzienda = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (albo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(albo);
		}

		if (CAP == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CAP);
		}

		if (codiceVettore == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceVettore);
		}

		if (codiceFiscale == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceFiscale);
		}

		if (codiceRiferimento == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceRiferimento);
		}

		if (comune == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comune);
		}

		if (indirizzo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(indirizzo);
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

		if (ragioneSociale2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ragioneSociale2);
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

		if (tipoAnagrafica == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tipoAnagrafica);
		}

		if (codiceAzienda == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceAzienda);
		}
	}

	public String albo;
	public String CAP;
	public String codiceVettore;
	public String codiceFiscale;
	public String codiceRiferimento;
	public String comune;
	public String indirizzo;
	public String note;
	public String partitaIVA;
	public String ragioneSociale;
	public String ragioneSociale2;
	public String provincia;
	public String stato;
	public String tipoAnagrafica;
	public String codiceAzienda;
}
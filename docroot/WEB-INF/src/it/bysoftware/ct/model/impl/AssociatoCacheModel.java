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

import it.bysoftware.ct.model.Associato;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Associato in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Associato
 * @generated
 */
public class AssociatoCacheModel implements CacheModel<Associato>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{id=");
		sb.append(id);
		sb.append(", centro=");
		sb.append(centro);
		sb.append(", ragioneSociale=");
		sb.append(ragioneSociale);
		sb.append(", partitaIVA=");
		sb.append(partitaIVA);
		sb.append(", indirizzo=");
		sb.append(indirizzo);
		sb.append(", comune=");
		sb.append(comune);
		sb.append(", telefono=");
		sb.append(telefono);
		sb.append(", fax=");
		sb.append(fax);
		sb.append(", nomeUtente=");
		sb.append(nomeUtente);
		sb.append(", email=");
		sb.append(email);
		sb.append(", password=");
		sb.append(password);
		sb.append(", idLiferay=");
		sb.append(idLiferay);
		sb.append(", idOp=");
		sb.append(idOp);
		sb.append(", attivo=");
		sb.append(attivo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Associato toEntityModel() {
		AssociatoImpl associatoImpl = new AssociatoImpl();

		associatoImpl.setId(id);

		if (centro == null) {
			associatoImpl.setCentro(StringPool.BLANK);
		}
		else {
			associatoImpl.setCentro(centro);
		}

		if (ragioneSociale == null) {
			associatoImpl.setRagioneSociale(StringPool.BLANK);
		}
		else {
			associatoImpl.setRagioneSociale(ragioneSociale);
		}

		if (partitaIVA == null) {
			associatoImpl.setPartitaIVA(StringPool.BLANK);
		}
		else {
			associatoImpl.setPartitaIVA(partitaIVA);
		}

		if (indirizzo == null) {
			associatoImpl.setIndirizzo(StringPool.BLANK);
		}
		else {
			associatoImpl.setIndirizzo(indirizzo);
		}

		if (comune == null) {
			associatoImpl.setComune(StringPool.BLANK);
		}
		else {
			associatoImpl.setComune(comune);
		}

		if (telefono == null) {
			associatoImpl.setTelefono(StringPool.BLANK);
		}
		else {
			associatoImpl.setTelefono(telefono);
		}

		if (fax == null) {
			associatoImpl.setFax(StringPool.BLANK);
		}
		else {
			associatoImpl.setFax(fax);
		}

		if (nomeUtente == null) {
			associatoImpl.setNomeUtente(StringPool.BLANK);
		}
		else {
			associatoImpl.setNomeUtente(nomeUtente);
		}

		if (email == null) {
			associatoImpl.setEmail(StringPool.BLANK);
		}
		else {
			associatoImpl.setEmail(email);
		}

		if (password == null) {
			associatoImpl.setPassword(StringPool.BLANK);
		}
		else {
			associatoImpl.setPassword(password);
		}

		associatoImpl.setIdLiferay(idLiferay);
		associatoImpl.setIdOp(idOp);
		associatoImpl.setAttivo(attivo);

		associatoImpl.resetOriginalValues();

		return associatoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		centro = objectInput.readUTF();
		ragioneSociale = objectInput.readUTF();
		partitaIVA = objectInput.readUTF();
		indirizzo = objectInput.readUTF();
		comune = objectInput.readUTF();
		telefono = objectInput.readUTF();
		fax = objectInput.readUTF();
		nomeUtente = objectInput.readUTF();
		email = objectInput.readUTF();
		password = objectInput.readUTF();
		idLiferay = objectInput.readLong();
		idOp = objectInput.readLong();
		attivo = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (centro == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(centro);
		}

		if (ragioneSociale == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ragioneSociale);
		}

		if (partitaIVA == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(partitaIVA);
		}

		if (indirizzo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(indirizzo);
		}

		if (comune == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comune);
		}

		if (telefono == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(telefono);
		}

		if (fax == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fax);
		}

		if (nomeUtente == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nomeUtente);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (password == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(password);
		}

		objectOutput.writeLong(idLiferay);
		objectOutput.writeLong(idOp);
		objectOutput.writeBoolean(attivo);
	}

	public long id;
	public String centro;
	public String ragioneSociale;
	public String partitaIVA;
	public String indirizzo;
	public String comune;
	public String telefono;
	public String fax;
	public String nomeUtente;
	public String email;
	public String password;
	public long idLiferay;
	public long idOp;
	public boolean attivo;
}
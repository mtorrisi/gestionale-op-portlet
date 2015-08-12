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

import it.bysoftware.ct.model.OrganizzazioneProduttori;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing OrganizzazioneProduttori in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see OrganizzazioneProduttori
 * @generated
 */
public class OrganizzazioneProduttoriCacheModel implements CacheModel<OrganizzazioneProduttori>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ragioneSociale=");
		sb.append(ragioneSociale);
		sb.append(", partitaIVA=");
		sb.append(partitaIVA);
		sb.append(", indirizzo=");
		sb.append(indirizzo);
		sb.append(", telefono=");
		sb.append(telefono);
		sb.append(", fax=");
		sb.append(fax);
		sb.append(", sitoWeb=");
		sb.append(sitoWeb);
		sb.append(", email=");
		sb.append(email);
		sb.append(", password=");
		sb.append(password);
		sb.append(", idLiferay=");
		sb.append(idLiferay);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public OrganizzazioneProduttori toEntityModel() {
		OrganizzazioneProduttoriImpl organizzazioneProduttoriImpl = new OrganizzazioneProduttoriImpl();

		organizzazioneProduttoriImpl.setId(id);

		if (ragioneSociale == null) {
			organizzazioneProduttoriImpl.setRagioneSociale(StringPool.BLANK);
		}
		else {
			organizzazioneProduttoriImpl.setRagioneSociale(ragioneSociale);
		}

		if (partitaIVA == null) {
			organizzazioneProduttoriImpl.setPartitaIVA(StringPool.BLANK);
		}
		else {
			organizzazioneProduttoriImpl.setPartitaIVA(partitaIVA);
		}

		if (indirizzo == null) {
			organizzazioneProduttoriImpl.setIndirizzo(StringPool.BLANK);
		}
		else {
			organizzazioneProduttoriImpl.setIndirizzo(indirizzo);
		}

		if (telefono == null) {
			organizzazioneProduttoriImpl.setTelefono(StringPool.BLANK);
		}
		else {
			organizzazioneProduttoriImpl.setTelefono(telefono);
		}

		if (fax == null) {
			organizzazioneProduttoriImpl.setFax(StringPool.BLANK);
		}
		else {
			organizzazioneProduttoriImpl.setFax(fax);
		}

		if (sitoWeb == null) {
			organizzazioneProduttoriImpl.setSitoWeb(StringPool.BLANK);
		}
		else {
			organizzazioneProduttoriImpl.setSitoWeb(sitoWeb);
		}

		if (email == null) {
			organizzazioneProduttoriImpl.setEmail(StringPool.BLANK);
		}
		else {
			organizzazioneProduttoriImpl.setEmail(email);
		}

		if (password == null) {
			organizzazioneProduttoriImpl.setPassword(StringPool.BLANK);
		}
		else {
			organizzazioneProduttoriImpl.setPassword(password);
		}

		organizzazioneProduttoriImpl.setIdLiferay(idLiferay);

		organizzazioneProduttoriImpl.resetOriginalValues();

		return organizzazioneProduttoriImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		ragioneSociale = objectInput.readUTF();
		partitaIVA = objectInput.readUTF();
		indirizzo = objectInput.readUTF();
		telefono = objectInput.readUTF();
		fax = objectInput.readUTF();
		sitoWeb = objectInput.readUTF();
		email = objectInput.readUTF();
		password = objectInput.readUTF();
		idLiferay = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

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

		if (sitoWeb == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sitoWeb);
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
	}

	public long id;
	public String ragioneSociale;
	public String partitaIVA;
	public String indirizzo;
	public String telefono;
	public String fax;
	public String sitoWeb;
	public String email;
	public String password;
	public long idLiferay;
}
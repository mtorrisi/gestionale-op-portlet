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

import it.bysoftware.ct.model.DestinatariDiversi;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DestinatariDiversi in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see DestinatariDiversi
 * @generated
 */
public class DestinatariDiversiCacheModel implements CacheModel<DestinatariDiversi>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{codiceAnagrafica=");
		sb.append(codiceAnagrafica);
		sb.append(", codiceRiferimento=");
		sb.append(codiceRiferimento);
		sb.append(", CAP=");
		sb.append(CAP);
		sb.append(", comune=");
		sb.append(comune);
		sb.append(", indirizzo=");
		sb.append(indirizzo);
		sb.append(", provincia=");
		sb.append(provincia);
		sb.append(", stato=");
		sb.append(stato);
		sb.append(", tipoAnagrafica=");
		sb.append(tipoAnagrafica);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DestinatariDiversi toEntityModel() {
		DestinatariDiversiImpl destinatariDiversiImpl = new DestinatariDiversiImpl();

		if (codiceAnagrafica == null) {
			destinatariDiversiImpl.setCodiceAnagrafica(StringPool.BLANK);
		}
		else {
			destinatariDiversiImpl.setCodiceAnagrafica(codiceAnagrafica);
		}

		if (codiceRiferimento == null) {
			destinatariDiversiImpl.setCodiceRiferimento(StringPool.BLANK);
		}
		else {
			destinatariDiversiImpl.setCodiceRiferimento(codiceRiferimento);
		}

		if (CAP == null) {
			destinatariDiversiImpl.setCAP(StringPool.BLANK);
		}
		else {
			destinatariDiversiImpl.setCAP(CAP);
		}

		if (comune == null) {
			destinatariDiversiImpl.setComune(StringPool.BLANK);
		}
		else {
			destinatariDiversiImpl.setComune(comune);
		}

		if (indirizzo == null) {
			destinatariDiversiImpl.setIndirizzo(StringPool.BLANK);
		}
		else {
			destinatariDiversiImpl.setIndirizzo(indirizzo);
		}

		if (provincia == null) {
			destinatariDiversiImpl.setProvincia(StringPool.BLANK);
		}
		else {
			destinatariDiversiImpl.setProvincia(provincia);
		}

		if (stato == null) {
			destinatariDiversiImpl.setStato(StringPool.BLANK);
		}
		else {
			destinatariDiversiImpl.setStato(stato);
		}

		if (tipoAnagrafica == null) {
			destinatariDiversiImpl.setTipoAnagrafica(StringPool.BLANK);
		}
		else {
			destinatariDiversiImpl.setTipoAnagrafica(tipoAnagrafica);
		}

		destinatariDiversiImpl.resetOriginalValues();

		return destinatariDiversiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		codiceAnagrafica = objectInput.readUTF();
		codiceRiferimento = objectInput.readUTF();
		CAP = objectInput.readUTF();
		comune = objectInput.readUTF();
		indirizzo = objectInput.readUTF();
		provincia = objectInput.readUTF();
		stato = objectInput.readUTF();
		tipoAnagrafica = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (codiceAnagrafica == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceAnagrafica);
		}

		if (codiceRiferimento == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceRiferimento);
		}

		if (CAP == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CAP);
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
	}

	public String codiceAnagrafica;
	public String codiceRiferimento;
	public String CAP;
	public String comune;
	public String indirizzo;
	public String provincia;
	public String stato;
	public String tipoAnagrafica;
}
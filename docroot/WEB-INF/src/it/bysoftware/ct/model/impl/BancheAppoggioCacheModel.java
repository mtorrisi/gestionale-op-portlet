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

import it.bysoftware.ct.model.BancheAppoggio;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing BancheAppoggio in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see BancheAppoggio
 * @generated
 */
public class BancheAppoggioCacheModel implements CacheModel<BancheAppoggio>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{cBanca=");
		sb.append(cBanca);
		sb.append(", codiceABI=");
		sb.append(codiceABI);
		sb.append(", codiceAgenzia=");
		sb.append(codiceAgenzia);
		sb.append(", codiceBanca=");
		sb.append(codiceBanca);
		sb.append(", codiceCAB=");
		sb.append(codiceCAB);
		sb.append(", descrizione=");
		sb.append(descrizione);
		sb.append(", piazza=");
		sb.append(piazza);
		sb.append(", codiceAzienda=");
		sb.append(codiceAzienda);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BancheAppoggio toEntityModel() {
		BancheAppoggioImpl bancheAppoggioImpl = new BancheAppoggioImpl();

		if (cBanca == null) {
			bancheAppoggioImpl.setCBanca(StringPool.BLANK);
		}
		else {
			bancheAppoggioImpl.setCBanca(cBanca);
		}

		bancheAppoggioImpl.setCodiceABI(codiceABI);

		if (codiceAgenzia == null) {
			bancheAppoggioImpl.setCodiceAgenzia(StringPool.BLANK);
		}
		else {
			bancheAppoggioImpl.setCodiceAgenzia(codiceAgenzia);
		}

		if (codiceBanca == null) {
			bancheAppoggioImpl.setCodiceBanca(StringPool.BLANK);
		}
		else {
			bancheAppoggioImpl.setCodiceBanca(codiceBanca);
		}

		bancheAppoggioImpl.setCodiceCAB(codiceCAB);

		if (descrizione == null) {
			bancheAppoggioImpl.setDescrizione(StringPool.BLANK);
		}
		else {
			bancheAppoggioImpl.setDescrizione(descrizione);
		}

		if (piazza == null) {
			bancheAppoggioImpl.setPiazza(StringPool.BLANK);
		}
		else {
			bancheAppoggioImpl.setPiazza(piazza);
		}

		if (codiceAzienda == null) {
			bancheAppoggioImpl.setCodiceAzienda(StringPool.BLANK);
		}
		else {
			bancheAppoggioImpl.setCodiceAzienda(codiceAzienda);
		}

		bancheAppoggioImpl.resetOriginalValues();

		return bancheAppoggioImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		cBanca = objectInput.readUTF();
		codiceABI = objectInput.readInt();
		codiceAgenzia = objectInput.readUTF();
		codiceBanca = objectInput.readUTF();
		codiceCAB = objectInput.readInt();
		descrizione = objectInput.readUTF();
		piazza = objectInput.readUTF();
		codiceAzienda = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (cBanca == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cBanca);
		}

		objectOutput.writeInt(codiceABI);

		if (codiceAgenzia == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceAgenzia);
		}

		if (codiceBanca == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceBanca);
		}

		objectOutput.writeInt(codiceCAB);

		if (descrizione == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(descrizione);
		}

		if (piazza == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(piazza);
		}

		if (codiceAzienda == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceAzienda);
		}
	}

	public String cBanca;
	public int codiceABI;
	public String codiceAgenzia;
	public String codiceBanca;
	public int codiceCAB;
	public String descrizione;
	public String piazza;
	public String codiceAzienda;
}
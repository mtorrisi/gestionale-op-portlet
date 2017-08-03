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

import it.bysoftware.ct.model.CessioneCredito;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CessioneCredito in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CessioneCredito
 * @generated
 */
public class CessioneCreditoCacheModel implements CacheModel<CessioneCredito>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(id);
		sb.append(", data=");
		sb.append(data);
		sb.append(", codiceSoggetto=");
		sb.append(codiceSoggetto);
		sb.append(", idAssociato=");
		sb.append(idAssociato);
		sb.append(", idFile=");
		sb.append(idFile);
		sb.append(", anno=");
		sb.append(anno);
		sb.append(", numeroFattura=");
		sb.append(numeroFattura);
		sb.append(", totale=");
		sb.append(totale);
		sb.append(", note=");
		sb.append(note);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CessioneCredito toEntityModel() {
		CessioneCreditoImpl cessioneCreditoImpl = new CessioneCreditoImpl();

		cessioneCreditoImpl.setId(id);

		if (data == Long.MIN_VALUE) {
			cessioneCreditoImpl.setData(null);
		}
		else {
			cessioneCreditoImpl.setData(new Date(data));
		}

		if (codiceSoggetto == null) {
			cessioneCreditoImpl.setCodiceSoggetto(StringPool.BLANK);
		}
		else {
			cessioneCreditoImpl.setCodiceSoggetto(codiceSoggetto);
		}

		cessioneCreditoImpl.setIdAssociato(idAssociato);
		cessioneCreditoImpl.setIdFile(idFile);
		cessioneCreditoImpl.setAnno(anno);
		cessioneCreditoImpl.setNumeroFattura(numeroFattura);
		cessioneCreditoImpl.setTotale(totale);

		if (note == null) {
			cessioneCreditoImpl.setNote(StringPool.BLANK);
		}
		else {
			cessioneCreditoImpl.setNote(note);
		}

		cessioneCreditoImpl.resetOriginalValues();

		return cessioneCreditoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		data = objectInput.readLong();
		codiceSoggetto = objectInput.readUTF();
		idAssociato = objectInput.readLong();
		idFile = objectInput.readLong();
		anno = objectInput.readInt();
		numeroFattura = objectInput.readInt();
		totale = objectInput.readDouble();
		note = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(data);

		if (codiceSoggetto == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceSoggetto);
		}

		objectOutput.writeLong(idAssociato);
		objectOutput.writeLong(idFile);
		objectOutput.writeInt(anno);
		objectOutput.writeInt(numeroFattura);
		objectOutput.writeDouble(totale);

		if (note == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note);
		}
	}

	public long id;
	public long data;
	public String codiceSoggetto;
	public long idAssociato;
	public long idFile;
	public int anno;
	public int numeroFattura;
	public double totale;
	public String note;
}
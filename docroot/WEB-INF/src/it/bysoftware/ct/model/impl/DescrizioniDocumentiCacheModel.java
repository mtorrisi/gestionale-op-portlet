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

import it.bysoftware.ct.model.DescrizioniDocumenti;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DescrizioniDocumenti in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see DescrizioniDocumenti
 * @generated
 */
public class DescrizioniDocumentiCacheModel implements CacheModel<DescrizioniDocumenti>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{codiceDescrizione=");
		sb.append(codiceDescrizione);
		sb.append(", codiceIVA=");
		sb.append(codiceIVA);
		sb.append(", descrizione=");
		sb.append(descrizione);
		sb.append(", descrizioneFiscale=");
		sb.append(descrizioneFiscale);
		sb.append(", codiceAzienda=");
		sb.append(codiceAzienda);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DescrizioniDocumenti toEntityModel() {
		DescrizioniDocumentiImpl descrizioniDocumentiImpl = new DescrizioniDocumentiImpl();

		if (codiceDescrizione == null) {
			descrizioniDocumentiImpl.setCodiceDescrizione(StringPool.BLANK);
		}
		else {
			descrizioniDocumentiImpl.setCodiceDescrizione(codiceDescrizione);
		}

		if (codiceIVA == null) {
			descrizioniDocumentiImpl.setCodiceIVA(StringPool.BLANK);
		}
		else {
			descrizioniDocumentiImpl.setCodiceIVA(codiceIVA);
		}

		if (descrizione == null) {
			descrizioniDocumentiImpl.setDescrizione(StringPool.BLANK);
		}
		else {
			descrizioniDocumentiImpl.setDescrizione(descrizione);
		}

		if (descrizioneFiscale == null) {
			descrizioniDocumentiImpl.setDescrizioneFiscale(StringPool.BLANK);
		}
		else {
			descrizioniDocumentiImpl.setDescrizioneFiscale(descrizioneFiscale);
		}

		if (codiceAzienda == null) {
			descrizioniDocumentiImpl.setCodiceAzienda(StringPool.BLANK);
		}
		else {
			descrizioniDocumentiImpl.setCodiceAzienda(codiceAzienda);
		}

		descrizioniDocumentiImpl.resetOriginalValues();

		return descrizioniDocumentiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		codiceDescrizione = objectInput.readUTF();
		codiceIVA = objectInput.readUTF();
		descrizione = objectInput.readUTF();
		descrizioneFiscale = objectInput.readUTF();
		codiceAzienda = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (codiceDescrizione == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceDescrizione);
		}

		if (codiceIVA == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceIVA);
		}

		if (descrizione == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(descrizione);
		}

		if (descrizioneFiscale == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(descrizioneFiscale);
		}

		if (codiceAzienda == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceAzienda);
		}
	}

	public String codiceDescrizione;
	public String codiceIVA;
	public String descrizione;
	public String descrizioneFiscale;
	public String codiceAzienda;
}
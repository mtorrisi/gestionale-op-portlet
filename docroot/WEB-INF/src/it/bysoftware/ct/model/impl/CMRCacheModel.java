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

import it.bysoftware.ct.model.CMR;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CMR in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CMR
 * @generated
 */
public class CMRCacheModel implements CacheModel<CMR>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{numeroCMR=");
		sb.append(numeroCMR);
		sb.append(", anno=");
		sb.append(anno);
		sb.append(", numeroDocumento=");
		sb.append(numeroDocumento);
		sb.append(", idAssociato=");
		sb.append(idAssociato);
		sb.append(", riserve=");
		sb.append(riserve);
		sb.append(", allegati=");
		sb.append(allegati);
		sb.append(", classe=");
		sb.append(classe);
		sb.append(", cifra=");
		sb.append(cifra);
		sb.append(", lettera=");
		sb.append(lettera);
		sb.append(", adr=");
		sb.append(adr);
		sb.append(", istruzioni=");
		sb.append(istruzioni);
		sb.append(", convenzioni=");
		sb.append(convenzioni);
		sb.append(", rimborso=");
		sb.append(rimborso);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CMR toEntityModel() {
		CMRImpl cmrImpl = new CMRImpl();

		cmrImpl.setNumeroCMR(numeroCMR);
		cmrImpl.setAnno(anno);
		cmrImpl.setNumeroDocumento(numeroDocumento);
		cmrImpl.setIdAssociato(idAssociato);

		if (riserve == null) {
			cmrImpl.setRiserve(StringPool.BLANK);
		}
		else {
			cmrImpl.setRiserve(riserve);
		}

		if (allegati == null) {
			cmrImpl.setAllegati(StringPool.BLANK);
		}
		else {
			cmrImpl.setAllegati(allegati);
		}

		if (classe == null) {
			cmrImpl.setClasse(StringPool.BLANK);
		}
		else {
			cmrImpl.setClasse(classe);
		}

		if (cifra == null) {
			cmrImpl.setCifra(StringPool.BLANK);
		}
		else {
			cmrImpl.setCifra(cifra);
		}

		if (lettera == null) {
			cmrImpl.setLettera(StringPool.BLANK);
		}
		else {
			cmrImpl.setLettera(lettera);
		}

		if (adr == null) {
			cmrImpl.setAdr(StringPool.BLANK);
		}
		else {
			cmrImpl.setAdr(adr);
		}

		if (istruzioni == null) {
			cmrImpl.setIstruzioni(StringPool.BLANK);
		}
		else {
			cmrImpl.setIstruzioni(istruzioni);
		}

		if (convenzioni == null) {
			cmrImpl.setConvenzioni(StringPool.BLANK);
		}
		else {
			cmrImpl.setConvenzioni(convenzioni);
		}

		if (rimborso == null) {
			cmrImpl.setRimborso(StringPool.BLANK);
		}
		else {
			cmrImpl.setRimborso(rimborso);
		}

		cmrImpl.resetOriginalValues();

		return cmrImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		numeroCMR = objectInput.readLong();
		anno = objectInput.readInt();
		numeroDocumento = objectInput.readLong();
		idAssociato = objectInput.readLong();
		riserve = objectInput.readUTF();
		allegati = objectInput.readUTF();
		classe = objectInput.readUTF();
		cifra = objectInput.readUTF();
		lettera = objectInput.readUTF();
		adr = objectInput.readUTF();
		istruzioni = objectInput.readUTF();
		convenzioni = objectInput.readUTF();
		rimborso = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(numeroCMR);
		objectOutput.writeInt(anno);
		objectOutput.writeLong(numeroDocumento);
		objectOutput.writeLong(idAssociato);

		if (riserve == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(riserve);
		}

		if (allegati == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(allegati);
		}

		if (classe == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(classe);
		}

		if (cifra == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cifra);
		}

		if (lettera == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lettera);
		}

		if (adr == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(adr);
		}

		if (istruzioni == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(istruzioni);
		}

		if (convenzioni == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(convenzioni);
		}

		if (rimborso == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(rimborso);
		}
	}

	public long numeroCMR;
	public int anno;
	public long numeroDocumento;
	public long idAssociato;
	public String riserve;
	public String allegati;
	public String classe;
	public String cifra;
	public String lettera;
	public String adr;
	public String istruzioni;
	public String convenzioni;
	public String rimborso;
}
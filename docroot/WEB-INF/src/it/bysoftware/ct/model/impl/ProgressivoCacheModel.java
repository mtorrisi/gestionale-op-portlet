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

import it.bysoftware.ct.model.Progressivo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Progressivo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Progressivo
 * @generated
 */
public class ProgressivoCacheModel implements CacheModel<Progressivo>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{anno=");
		sb.append(anno);
		sb.append(", idAssociato=");
		sb.append(idAssociato);
		sb.append(", codiceCentro=");
		sb.append(codiceCentro);
		sb.append(", codiceDeposito=");
		sb.append(codiceDeposito);
		sb.append(", dataRegistrazione=");
		sb.append(dataRegistrazione);
		sb.append(", numeroBolla=");
		sb.append(numeroBolla);
		sb.append(", tipoDocumento=");
		sb.append(tipoDocumento);
		sb.append(", numeroProgressivo=");
		sb.append(numeroProgressivo);
		sb.append(", tipoCon=");
		sb.append(tipoCon);
		sb.append(", codiceAzienda=");
		sb.append(codiceAzienda);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Progressivo toEntityModel() {
		ProgressivoImpl progressivoImpl = new ProgressivoImpl();

		progressivoImpl.setAnno(anno);
		progressivoImpl.setIdAssociato(idAssociato);

		if (codiceCentro == null) {
			progressivoImpl.setCodiceCentro(StringPool.BLANK);
		}
		else {
			progressivoImpl.setCodiceCentro(codiceCentro);
		}

		if (codiceDeposito == null) {
			progressivoImpl.setCodiceDeposito(StringPool.BLANK);
		}
		else {
			progressivoImpl.setCodiceDeposito(codiceDeposito);
		}

		if (dataRegistrazione == null) {
			progressivoImpl.setDataRegistrazione(StringPool.BLANK);
		}
		else {
			progressivoImpl.setDataRegistrazione(dataRegistrazione);
		}

		progressivoImpl.setNumeroBolla(numeroBolla);
		progressivoImpl.setTipoDocumento(tipoDocumento);
		progressivoImpl.setNumeroProgressivo(numeroProgressivo);
		progressivoImpl.setTipoCon(tipoCon);

		if (codiceAzienda == null) {
			progressivoImpl.setCodiceAzienda(StringPool.BLANK);
		}
		else {
			progressivoImpl.setCodiceAzienda(codiceAzienda);
		}

		progressivoImpl.resetOriginalValues();

		return progressivoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		anno = objectInput.readInt();
		idAssociato = objectInput.readLong();
		codiceCentro = objectInput.readUTF();
		codiceDeposito = objectInput.readUTF();
		dataRegistrazione = objectInput.readUTF();
		numeroBolla = objectInput.readLong();
		tipoDocumento = objectInput.readInt();
		numeroProgressivo = objectInput.readInt();
		tipoCon = objectInput.readInt();
		codiceAzienda = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(anno);
		objectOutput.writeLong(idAssociato);

		if (codiceCentro == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceCentro);
		}

		if (codiceDeposito == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceDeposito);
		}

		if (dataRegistrazione == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dataRegistrazione);
		}

		objectOutput.writeLong(numeroBolla);
		objectOutput.writeInt(tipoDocumento);
		objectOutput.writeInt(numeroProgressivo);
		objectOutput.writeInt(tipoCon);

		if (codiceAzienda == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceAzienda);
		}
	}

	public int anno;
	public long idAssociato;
	public String codiceCentro;
	public String codiceDeposito;
	public String dataRegistrazione;
	public long numeroBolla;
	public int tipoDocumento;
	public int numeroProgressivo;
	public int tipoCon;
	public String codiceAzienda;
}
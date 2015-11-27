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

import it.bysoftware.ct.model.VociIva;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing VociIva in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see VociIva
 * @generated
 */
public class VociIvaCacheModel implements CacheModel<VociIva>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{codiceIva=");
		sb.append(codiceIva);
		sb.append(", descrizione=");
		sb.append(descrizione);
		sb.append(", descrizioneDocumento=");
		sb.append(descrizioneDocumento);
		sb.append(", aliquota=");
		sb.append(aliquota);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VociIva toEntityModel() {
		VociIvaImpl vociIvaImpl = new VociIvaImpl();

		if (codiceIva == null) {
			vociIvaImpl.setCodiceIva(StringPool.BLANK);
		}
		else {
			vociIvaImpl.setCodiceIva(codiceIva);
		}

		if (descrizione == null) {
			vociIvaImpl.setDescrizione(StringPool.BLANK);
		}
		else {
			vociIvaImpl.setDescrizione(descrizione);
		}

		if (descrizioneDocumento == null) {
			vociIvaImpl.setDescrizioneDocumento(StringPool.BLANK);
		}
		else {
			vociIvaImpl.setDescrizioneDocumento(descrizioneDocumento);
		}

		vociIvaImpl.setAliquota(aliquota);

		vociIvaImpl.resetOriginalValues();

		return vociIvaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		codiceIva = objectInput.readUTF();
		descrizione = objectInput.readUTF();
		descrizioneDocumento = objectInput.readUTF();
		aliquota = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (codiceIva == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceIva);
		}

		if (descrizione == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(descrizione);
		}

		if (descrizioneDocumento == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(descrizioneDocumento);
		}

		objectOutput.writeDouble(aliquota);
	}

	public String codiceIva;
	public String descrizione;
	public String descrizioneDocumento;
	public double aliquota;
}
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

import it.bysoftware.ct.model.DescrizioniVarianti;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DescrizioniVarianti in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see DescrizioniVarianti
 * @generated
 */
public class DescrizioniVariantiCacheModel implements CacheModel<DescrizioniVarianti>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{codiceVariante=");
		sb.append(codiceVariante);
		sb.append(", descrizioneVariante=");
		sb.append(descrizioneVariante);
		sb.append(", ordine=");
		sb.append(ordine);
		sb.append(", tipoVariante=");
		sb.append(tipoVariante);
		sb.append(", codiceAzienda=");
		sb.append(codiceAzienda);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DescrizioniVarianti toEntityModel() {
		DescrizioniVariantiImpl descrizioniVariantiImpl = new DescrizioniVariantiImpl();

		if (codiceVariante == null) {
			descrizioniVariantiImpl.setCodiceVariante(StringPool.BLANK);
		}
		else {
			descrizioniVariantiImpl.setCodiceVariante(codiceVariante);
		}

		if (descrizioneVariante == null) {
			descrizioniVariantiImpl.setDescrizioneVariante(StringPool.BLANK);
		}
		else {
			descrizioniVariantiImpl.setDescrizioneVariante(descrizioneVariante);
		}

		descrizioniVariantiImpl.setOrdine(ordine);

		if (tipoVariante == null) {
			descrizioniVariantiImpl.setTipoVariante(StringPool.BLANK);
		}
		else {
			descrizioniVariantiImpl.setTipoVariante(tipoVariante);
		}

		if (codiceAzienda == null) {
			descrizioniVariantiImpl.setCodiceAzienda(StringPool.BLANK);
		}
		else {
			descrizioniVariantiImpl.setCodiceAzienda(codiceAzienda);
		}

		descrizioniVariantiImpl.resetOriginalValues();

		return descrizioniVariantiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		codiceVariante = objectInput.readUTF();
		descrizioneVariante = objectInput.readUTF();
		ordine = objectInput.readInt();
		tipoVariante = objectInput.readUTF();
		codiceAzienda = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (codiceVariante == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceVariante);
		}

		if (descrizioneVariante == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(descrizioneVariante);
		}

		objectOutput.writeInt(ordine);

		if (tipoVariante == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tipoVariante);
		}

		if (codiceAzienda == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceAzienda);
		}
	}

	public String codiceVariante;
	public String descrizioneVariante;
	public int ordine;
	public String tipoVariante;
	public String codiceAzienda;
}
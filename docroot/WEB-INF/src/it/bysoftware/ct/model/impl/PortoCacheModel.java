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

import it.bysoftware.ct.model.Porto;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Porto in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Porto
 * @generated
 */
public class PortoCacheModel implements CacheModel<Porto>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{Cdinco=");
		sb.append(Cdinco);
		sb.append(", codicePorto=");
		sb.append(codicePorto);
		sb.append(", descrizione=");
		sb.append(descrizione);
		sb.append(", Incoterm=");
		sb.append(Incoterm);
		sb.append(", codiceAzienda=");
		sb.append(codiceAzienda);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Porto toEntityModel() {
		PortoImpl portoImpl = new PortoImpl();

		if (Cdinco == null) {
			portoImpl.setCdinco(StringPool.BLANK);
		}
		else {
			portoImpl.setCdinco(Cdinco);
		}

		if (codicePorto == null) {
			portoImpl.setCodicePorto(StringPool.BLANK);
		}
		else {
			portoImpl.setCodicePorto(codicePorto);
		}

		if (descrizione == null) {
			portoImpl.setDescrizione(StringPool.BLANK);
		}
		else {
			portoImpl.setDescrizione(descrizione);
		}

		if (Incoterm == null) {
			portoImpl.setIncoterm(StringPool.BLANK);
		}
		else {
			portoImpl.setIncoterm(Incoterm);
		}

		if (codiceAzienda == null) {
			portoImpl.setCodiceAzienda(StringPool.BLANK);
		}
		else {
			portoImpl.setCodiceAzienda(codiceAzienda);
		}

		portoImpl.resetOriginalValues();

		return portoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		Cdinco = objectInput.readUTF();
		codicePorto = objectInput.readUTF();
		descrizione = objectInput.readUTF();
		Incoterm = objectInput.readUTF();
		codiceAzienda = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (Cdinco == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Cdinco);
		}

		if (codicePorto == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codicePorto);
		}

		if (descrizione == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(descrizione);
		}

		if (Incoterm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Incoterm);
		}

		if (codiceAzienda == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceAzienda);
		}
	}

	public String Cdinco;
	public String codicePorto;
	public String descrizione;
	public String Incoterm;
	public String codiceAzienda;
}
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

import it.bysoftware.ct.model.CuraTrasporto;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CuraTrasporto in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CuraTrasporto
 * @generated
 */
public class CuraTrasportoCacheModel implements CacheModel<CuraTrasporto>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{codiceCuraTrasporto=");
		sb.append(codiceCuraTrasporto);
		sb.append(", descrizione=");
		sb.append(descrizione);
		sb.append(", codiceAzienda=");
		sb.append(codiceAzienda);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CuraTrasporto toEntityModel() {
		CuraTrasportoImpl curaTrasportoImpl = new CuraTrasportoImpl();

		if (codiceCuraTrasporto == null) {
			curaTrasportoImpl.setCodiceCuraTrasporto(StringPool.BLANK);
		}
		else {
			curaTrasportoImpl.setCodiceCuraTrasporto(codiceCuraTrasporto);
		}

		if (descrizione == null) {
			curaTrasportoImpl.setDescrizione(StringPool.BLANK);
		}
		else {
			curaTrasportoImpl.setDescrizione(descrizione);
		}

		if (codiceAzienda == null) {
			curaTrasportoImpl.setCodiceAzienda(StringPool.BLANK);
		}
		else {
			curaTrasportoImpl.setCodiceAzienda(codiceAzienda);
		}

		curaTrasportoImpl.resetOriginalValues();

		return curaTrasportoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		codiceCuraTrasporto = objectInput.readUTF();
		descrizione = objectInput.readUTF();
		codiceAzienda = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (codiceCuraTrasporto == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceCuraTrasporto);
		}

		if (descrizione == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(descrizione);
		}

		if (codiceAzienda == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceAzienda);
		}
	}

	public String codiceCuraTrasporto;
	public String descrizione;
	public String codiceAzienda;
}
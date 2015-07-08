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

import it.bysoftware.ct.model.CausaleTrasporto;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CausaleTrasporto in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CausaleTrasporto
 * @generated
 */
public class CausaleTrasportoCacheModel implements CacheModel<CausaleTrasporto>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{codiceCausaleTrasporto=");
		sb.append(codiceCausaleTrasporto);
		sb.append(", descrizione=");
		sb.append(descrizione);
		sb.append(", codiceAzienda=");
		sb.append(codiceAzienda);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CausaleTrasporto toEntityModel() {
		CausaleTrasportoImpl causaleTrasportoImpl = new CausaleTrasportoImpl();

		if (codiceCausaleTrasporto == null) {
			causaleTrasportoImpl.setCodiceCausaleTrasporto(StringPool.BLANK);
		}
		else {
			causaleTrasportoImpl.setCodiceCausaleTrasporto(codiceCausaleTrasporto);
		}

		if (descrizione == null) {
			causaleTrasportoImpl.setDescrizione(StringPool.BLANK);
		}
		else {
			causaleTrasportoImpl.setDescrizione(descrizione);
		}

		if (codiceAzienda == null) {
			causaleTrasportoImpl.setCodiceAzienda(StringPool.BLANK);
		}
		else {
			causaleTrasportoImpl.setCodiceAzienda(codiceAzienda);
		}

		causaleTrasportoImpl.resetOriginalValues();

		return causaleTrasportoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		codiceCausaleTrasporto = objectInput.readUTF();
		descrizione = objectInput.readUTF();
		codiceAzienda = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (codiceCausaleTrasporto == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceCausaleTrasporto);
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

	public String codiceCausaleTrasporto;
	public String descrizione;
	public String codiceAzienda;
}
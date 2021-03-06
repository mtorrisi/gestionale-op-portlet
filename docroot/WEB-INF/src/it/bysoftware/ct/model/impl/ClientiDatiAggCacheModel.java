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

import it.bysoftware.ct.model.ClientiDatiAgg;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ClientiDatiAgg in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ClientiDatiAgg
 * @generated
 */
public class ClientiDatiAggCacheModel implements CacheModel<ClientiDatiAgg>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{codiceAnagrafica=");
		sb.append(codiceAnagrafica);
		sb.append(", tipo=");
		sb.append(tipo);
		sb.append(", associati=");
		sb.append(associati);
		sb.append(", codiceAliquota=");
		sb.append(codiceAliquota);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ClientiDatiAgg toEntityModel() {
		ClientiDatiAggImpl clientiDatiAggImpl = new ClientiDatiAggImpl();

		if (codiceAnagrafica == null) {
			clientiDatiAggImpl.setCodiceAnagrafica(StringPool.BLANK);
		}
		else {
			clientiDatiAggImpl.setCodiceAnagrafica(codiceAnagrafica);
		}

		clientiDatiAggImpl.setTipo(tipo);

		if (associati == null) {
			clientiDatiAggImpl.setAssociati(StringPool.BLANK);
		}
		else {
			clientiDatiAggImpl.setAssociati(associati);
		}

		if (codiceAliquota == null) {
			clientiDatiAggImpl.setCodiceAliquota(StringPool.BLANK);
		}
		else {
			clientiDatiAggImpl.setCodiceAliquota(codiceAliquota);
		}

		clientiDatiAggImpl.resetOriginalValues();

		return clientiDatiAggImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		codiceAnagrafica = objectInput.readUTF();
		tipo = objectInput.readBoolean();
		associati = objectInput.readUTF();
		codiceAliquota = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (codiceAnagrafica == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceAnagrafica);
		}

		objectOutput.writeBoolean(tipo);

		if (associati == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(associati);
		}

		if (codiceAliquota == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceAliquota);
		}
	}

	public String codiceAnagrafica;
	public boolean tipo;
	public String associati;
	public String codiceAliquota;
}
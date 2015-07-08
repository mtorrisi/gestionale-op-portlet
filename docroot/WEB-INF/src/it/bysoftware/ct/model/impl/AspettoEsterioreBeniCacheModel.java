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

import it.bysoftware.ct.model.AspettoEsterioreBeni;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AspettoEsterioreBeni in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AspettoEsterioreBeni
 * @generated
 */
public class AspettoEsterioreBeniCacheModel implements CacheModel<AspettoEsterioreBeni>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{codiceAspettoEsteriore=");
		sb.append(codiceAspettoEsteriore);
		sb.append(", descrizione=");
		sb.append(descrizione);
		sb.append(", codiceAzienda=");
		sb.append(codiceAzienda);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AspettoEsterioreBeni toEntityModel() {
		AspettoEsterioreBeniImpl aspettoEsterioreBeniImpl = new AspettoEsterioreBeniImpl();

		if (codiceAspettoEsteriore == null) {
			aspettoEsterioreBeniImpl.setCodiceAspettoEsteriore(StringPool.BLANK);
		}
		else {
			aspettoEsterioreBeniImpl.setCodiceAspettoEsteriore(codiceAspettoEsteriore);
		}

		if (descrizione == null) {
			aspettoEsterioreBeniImpl.setDescrizione(StringPool.BLANK);
		}
		else {
			aspettoEsterioreBeniImpl.setDescrizione(descrizione);
		}

		if (codiceAzienda == null) {
			aspettoEsterioreBeniImpl.setCodiceAzienda(StringPool.BLANK);
		}
		else {
			aspettoEsterioreBeniImpl.setCodiceAzienda(codiceAzienda);
		}

		aspettoEsterioreBeniImpl.resetOriginalValues();

		return aspettoEsterioreBeniImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		codiceAspettoEsteriore = objectInput.readUTF();
		descrizione = objectInput.readUTF();
		codiceAzienda = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (codiceAspettoEsteriore == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceAspettoEsteriore);
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

	public String codiceAspettoEsteriore;
	public String descrizione;
	public String codiceAzienda;
}
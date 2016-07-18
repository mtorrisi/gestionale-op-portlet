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

import it.bysoftware.ct.model.AnagraficaAssociatoOP;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AnagraficaAssociatoOP in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AnagraficaAssociatoOP
 * @generated
 */
public class AnagraficaAssociatoOPCacheModel implements CacheModel<AnagraficaAssociatoOP>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{idAssociato=");
		sb.append(idAssociato);
		sb.append(", codiceSogettoAssociato=");
		sb.append(codiceSogettoAssociato);
		sb.append(", codiceSogettoOP=");
		sb.append(codiceSogettoOP);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AnagraficaAssociatoOP toEntityModel() {
		AnagraficaAssociatoOPImpl anagraficaAssociatoOPImpl = new AnagraficaAssociatoOPImpl();

		anagraficaAssociatoOPImpl.setIdAssociato(idAssociato);

		if (codiceSogettoAssociato == null) {
			anagraficaAssociatoOPImpl.setCodiceSogettoAssociato(StringPool.BLANK);
		}
		else {
			anagraficaAssociatoOPImpl.setCodiceSogettoAssociato(codiceSogettoAssociato);
		}

		if (codiceSogettoOP == null) {
			anagraficaAssociatoOPImpl.setCodiceSogettoOP(StringPool.BLANK);
		}
		else {
			anagraficaAssociatoOPImpl.setCodiceSogettoOP(codiceSogettoOP);
		}

		anagraficaAssociatoOPImpl.resetOriginalValues();

		return anagraficaAssociatoOPImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		idAssociato = objectInput.readLong();
		codiceSogettoAssociato = objectInput.readUTF();
		codiceSogettoOP = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(idAssociato);

		if (codiceSogettoAssociato == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceSogettoAssociato);
		}

		if (codiceSogettoOP == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceSogettoOP);
		}
	}

	public long idAssociato;
	public String codiceSogettoAssociato;
	public String codiceSogettoOP;
}
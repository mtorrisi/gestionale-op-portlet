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

import it.bysoftware.ct.model.ArticoliAssociatoOP;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ArticoliAssociatoOP in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ArticoliAssociatoOP
 * @generated
 */
public class ArticoliAssociatoOPCacheModel implements CacheModel<ArticoliAssociatoOP>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{idAssociato=");
		sb.append(idAssociato);
		sb.append(", codiceArticoloAssociato=");
		sb.append(codiceArticoloAssociato);
		sb.append(", codiceArticoloOP=");
		sb.append(codiceArticoloOP);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ArticoliAssociatoOP toEntityModel() {
		ArticoliAssociatoOPImpl articoliAssociatoOPImpl = new ArticoliAssociatoOPImpl();

		articoliAssociatoOPImpl.setIdAssociato(idAssociato);

		if (codiceArticoloAssociato == null) {
			articoliAssociatoOPImpl.setCodiceArticoloAssociato(StringPool.BLANK);
		}
		else {
			articoliAssociatoOPImpl.setCodiceArticoloAssociato(codiceArticoloAssociato);
		}

		if (codiceArticoloOP == null) {
			articoliAssociatoOPImpl.setCodiceArticoloOP(StringPool.BLANK);
		}
		else {
			articoliAssociatoOPImpl.setCodiceArticoloOP(codiceArticoloOP);
		}

		articoliAssociatoOPImpl.resetOriginalValues();

		return articoliAssociatoOPImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		idAssociato = objectInput.readLong();
		codiceArticoloAssociato = objectInput.readUTF();
		codiceArticoloOP = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(idAssociato);

		if (codiceArticoloAssociato == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceArticoloAssociato);
		}

		if (codiceArticoloOP == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceArticoloOP);
		}
	}

	public long idAssociato;
	public String codiceArticoloAssociato;
	public String codiceArticoloOP;
}
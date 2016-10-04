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

import it.bysoftware.ct.model.TracciabilitaGrezzi;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TracciabilitaGrezzi in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see TracciabilitaGrezzi
 * @generated
 */
public class TracciabilitaGrezziCacheModel implements CacheModel<TracciabilitaGrezzi>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{id=");
		sb.append(id);
		sb.append(", lottoGrezzo=");
		sb.append(lottoGrezzo);
		sb.append(", prodotto=");
		sb.append(prodotto);
		sb.append(", kg=");
		sb.append(kg);
		sb.append(", produttore=");
		sb.append(produttore);
		sb.append(", foglio=");
		sb.append(foglio);
		sb.append(", particella=");
		sb.append(particella);
		sb.append(", note=");
		sb.append(note);
		sb.append(", numeroColli=");
		sb.append(numeroColli);
		sb.append(", kgScarto=");
		sb.append(kgScarto);
		sb.append(", idSchedaTracciabilta=");
		sb.append(idSchedaTracciabilta);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TracciabilitaGrezzi toEntityModel() {
		TracciabilitaGrezziImpl tracciabilitaGrezziImpl = new TracciabilitaGrezziImpl();

		tracciabilitaGrezziImpl.setId(id);

		if (lottoGrezzo == null) {
			tracciabilitaGrezziImpl.setLottoGrezzo(StringPool.BLANK);
		}
		else {
			tracciabilitaGrezziImpl.setLottoGrezzo(lottoGrezzo);
		}

		if (prodotto == null) {
			tracciabilitaGrezziImpl.setProdotto(StringPool.BLANK);
		}
		else {
			tracciabilitaGrezziImpl.setProdotto(prodotto);
		}

		tracciabilitaGrezziImpl.setKg(kg);

		if (produttore == null) {
			tracciabilitaGrezziImpl.setProduttore(StringPool.BLANK);
		}
		else {
			tracciabilitaGrezziImpl.setProduttore(produttore);
		}

		tracciabilitaGrezziImpl.setFoglio(foglio);
		tracciabilitaGrezziImpl.setParticella(particella);

		if (note == null) {
			tracciabilitaGrezziImpl.setNote(StringPool.BLANK);
		}
		else {
			tracciabilitaGrezziImpl.setNote(note);
		}

		tracciabilitaGrezziImpl.setNumeroColli(numeroColli);
		tracciabilitaGrezziImpl.setKgScarto(kgScarto);
		tracciabilitaGrezziImpl.setIdSchedaTracciabilta(idSchedaTracciabilta);

		tracciabilitaGrezziImpl.resetOriginalValues();

		return tracciabilitaGrezziImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		lottoGrezzo = objectInput.readUTF();
		prodotto = objectInput.readUTF();
		kg = objectInput.readDouble();
		produttore = objectInput.readUTF();
		foglio = objectInput.readInt();
		particella = objectInput.readInt();
		note = objectInput.readUTF();
		numeroColli = objectInput.readInt();
		kgScarto = objectInput.readDouble();
		idSchedaTracciabilta = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (lottoGrezzo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lottoGrezzo);
		}

		if (prodotto == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(prodotto);
		}

		objectOutput.writeDouble(kg);

		if (produttore == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(produttore);
		}

		objectOutput.writeInt(foglio);
		objectOutput.writeInt(particella);

		if (note == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note);
		}

		objectOutput.writeInt(numeroColli);
		objectOutput.writeDouble(kgScarto);
		objectOutput.writeLong(idSchedaTracciabilta);
	}

	public long id;
	public String lottoGrezzo;
	public String prodotto;
	public double kg;
	public String produttore;
	public int foglio;
	public int particella;
	public String note;
	public int numeroColli;
	public double kgScarto;
	public long idSchedaTracciabilta;
}
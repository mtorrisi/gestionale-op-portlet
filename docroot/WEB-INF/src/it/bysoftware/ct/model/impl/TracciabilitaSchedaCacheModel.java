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

import it.bysoftware.ct.model.TracciabilitaScheda;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TracciabilitaScheda in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see TracciabilitaScheda
 * @generated
 */
public class TracciabilitaSchedaCacheModel implements CacheModel<TracciabilitaScheda>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(id);
		sb.append(", codiceProdotto=");
		sb.append(codiceProdotto);
		sb.append(", prodottoVenduto=");
		sb.append(prodottoVenduto);
		sb.append(", kgVenduti=");
		sb.append(kgVenduti);
		sb.append(", lottoVendita=");
		sb.append(lottoVendita);
		sb.append(", anno=");
		sb.append(anno);
		sb.append(", numeroDocumento=");
		sb.append(numeroDocumento);
		sb.append(", rigoOrdine=");
		sb.append(rigoOrdine);
		sb.append(", tipoDocumento=");
		sb.append(tipoDocumento);
		sb.append(", idAssociato=");
		sb.append(idAssociato);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TracciabilitaScheda toEntityModel() {
		TracciabilitaSchedaImpl tracciabilitaSchedaImpl = new TracciabilitaSchedaImpl();

		tracciabilitaSchedaImpl.setId(id);

		if (codiceProdotto == null) {
			tracciabilitaSchedaImpl.setCodiceProdotto(StringPool.BLANK);
		}
		else {
			tracciabilitaSchedaImpl.setCodiceProdotto(codiceProdotto);
		}

		if (prodottoVenduto == null) {
			tracciabilitaSchedaImpl.setProdottoVenduto(StringPool.BLANK);
		}
		else {
			tracciabilitaSchedaImpl.setProdottoVenduto(prodottoVenduto);
		}

		tracciabilitaSchedaImpl.setKgVenduti(kgVenduti);

		if (lottoVendita == null) {
			tracciabilitaSchedaImpl.setLottoVendita(StringPool.BLANK);
		}
		else {
			tracciabilitaSchedaImpl.setLottoVendita(lottoVendita);
		}

		tracciabilitaSchedaImpl.setAnno(anno);
		tracciabilitaSchedaImpl.setNumeroDocumento(numeroDocumento);
		tracciabilitaSchedaImpl.setRigoOrdine(rigoOrdine);

		if (tipoDocumento == null) {
			tracciabilitaSchedaImpl.setTipoDocumento(StringPool.BLANK);
		}
		else {
			tracciabilitaSchedaImpl.setTipoDocumento(tipoDocumento);
		}

		tracciabilitaSchedaImpl.setIdAssociato(idAssociato);

		tracciabilitaSchedaImpl.resetOriginalValues();

		return tracciabilitaSchedaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		codiceProdotto = objectInput.readUTF();
		prodottoVenduto = objectInput.readUTF();
		kgVenduti = objectInput.readDouble();
		lottoVendita = objectInput.readUTF();
		anno = objectInput.readInt();
		numeroDocumento = objectInput.readLong();
		rigoOrdine = objectInput.readInt();
		tipoDocumento = objectInput.readUTF();
		idAssociato = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (codiceProdotto == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceProdotto);
		}

		if (prodottoVenduto == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(prodottoVenduto);
		}

		objectOutput.writeDouble(kgVenduti);

		if (lottoVendita == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lottoVendita);
		}

		objectOutput.writeInt(anno);
		objectOutput.writeLong(numeroDocumento);
		objectOutput.writeInt(rigoOrdine);

		if (tipoDocumento == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tipoDocumento);
		}

		objectOutput.writeLong(idAssociato);
	}

	public long id;
	public String codiceProdotto;
	public String prodottoVenduto;
	public double kgVenduti;
	public String lottoVendita;
	public int anno;
	public long numeroDocumento;
	public int rigoOrdine;
	public String tipoDocumento;
	public long idAssociato;
}
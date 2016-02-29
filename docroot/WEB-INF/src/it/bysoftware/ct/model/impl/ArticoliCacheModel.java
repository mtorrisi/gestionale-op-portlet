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

import it.bysoftware.ct.model.Articoli;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Articoli in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Articoli
 * @generated
 */
public class ArticoliCacheModel implements CacheModel<Articoli>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{codiceArticolo=");
		sb.append(codiceArticolo);
		sb.append(", categoriaMerceologica=");
		sb.append(categoriaMerceologica);
		sb.append(", descrizione=");
		sb.append(descrizione);
		sb.append(", descrizioneDocumento=");
		sb.append(descrizioneDocumento);
		sb.append(", descrizioneFiscale=");
		sb.append(descrizioneFiscale);
		sb.append(", unitaMisura=");
		sb.append(unitaMisura);
		sb.append(", tara=");
		sb.append(tara);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Articoli toEntityModel() {
		ArticoliImpl articoliImpl = new ArticoliImpl();

		if (codiceArticolo == null) {
			articoliImpl.setCodiceArticolo(StringPool.BLANK);
		}
		else {
			articoliImpl.setCodiceArticolo(codiceArticolo);
		}

		if (categoriaMerceologica == null) {
			articoliImpl.setCategoriaMerceologica(StringPool.BLANK);
		}
		else {
			articoliImpl.setCategoriaMerceologica(categoriaMerceologica);
		}

		if (descrizione == null) {
			articoliImpl.setDescrizione(StringPool.BLANK);
		}
		else {
			articoliImpl.setDescrizione(descrizione);
		}

		if (descrizioneDocumento == null) {
			articoliImpl.setDescrizioneDocumento(StringPool.BLANK);
		}
		else {
			articoliImpl.setDescrizioneDocumento(descrizioneDocumento);
		}

		if (descrizioneFiscale == null) {
			articoliImpl.setDescrizioneFiscale(StringPool.BLANK);
		}
		else {
			articoliImpl.setDescrizioneFiscale(descrizioneFiscale);
		}

		if (unitaMisura == null) {
			articoliImpl.setUnitaMisura(StringPool.BLANK);
		}
		else {
			articoliImpl.setUnitaMisura(unitaMisura);
		}

		articoliImpl.setTara(tara);

		articoliImpl.resetOriginalValues();

		return articoliImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		codiceArticolo = objectInput.readUTF();
		categoriaMerceologica = objectInput.readUTF();
		descrizione = objectInput.readUTF();
		descrizioneDocumento = objectInput.readUTF();
		descrizioneFiscale = objectInput.readUTF();
		unitaMisura = objectInput.readUTF();
		tara = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (codiceArticolo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codiceArticolo);
		}

		if (categoriaMerceologica == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(categoriaMerceologica);
		}

		if (descrizione == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(descrizione);
		}

		if (descrizioneDocumento == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(descrizioneDocumento);
		}

		if (descrizioneFiscale == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(descrizioneFiscale);
		}

		if (unitaMisura == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(unitaMisura);
		}

		objectOutput.writeDouble(tara);
	}

	public String codiceArticolo;
	public String categoriaMerceologica;
	public String descrizione;
	public String descrizioneDocumento;
	public String descrizioneFiscale;
	public String unitaMisura;
	public double tara;
}
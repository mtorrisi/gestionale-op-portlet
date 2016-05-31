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

package it.bysoftware.ct.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AnagraficaAssociatoOPPK implements Comparable<AnagraficaAssociatoOPPK>,
	Serializable {
	public long idAssociato;
	public String codiceSogettoAssociato;

	public AnagraficaAssociatoOPPK() {
	}

	public AnagraficaAssociatoOPPK(long idAssociato,
		String codiceSogettoAssociato) {
		this.idAssociato = idAssociato;
		this.codiceSogettoAssociato = codiceSogettoAssociato;
	}

	public long getIdAssociato() {
		return idAssociato;
	}

	public void setIdAssociato(long idAssociato) {
		this.idAssociato = idAssociato;
	}

	public String getCodiceSogettoAssociato() {
		return codiceSogettoAssociato;
	}

	public void setCodiceSogettoAssociato(String codiceSogettoAssociato) {
		this.codiceSogettoAssociato = codiceSogettoAssociato;
	}

	@Override
	public int compareTo(AnagraficaAssociatoOPPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (idAssociato < pk.idAssociato) {
			value = -1;
		}
		else if (idAssociato > pk.idAssociato) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = codiceSogettoAssociato.compareTo(pk.codiceSogettoAssociato);

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnagraficaAssociatoOPPK)) {
			return false;
		}

		AnagraficaAssociatoOPPK pk = (AnagraficaAssociatoOPPK)obj;

		if ((idAssociato == pk.idAssociato) &&
				(codiceSogettoAssociato.equals(pk.codiceSogettoAssociato))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(idAssociato) +
		String.valueOf(codiceSogettoAssociato)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("idAssociato");
		sb.append(StringPool.EQUAL);
		sb.append(idAssociato);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("codiceSogettoAssociato");
		sb.append(StringPool.EQUAL);
		sb.append(codiceSogettoAssociato);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}
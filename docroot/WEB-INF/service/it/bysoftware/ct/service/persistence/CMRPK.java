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
public class CMRPK implements Comparable<CMRPK>, Serializable {
	public long numeroCMR;
	public int anno;
	public long numeroDocumento;
	public long idAssociato;

	public CMRPK() {
	}

	public CMRPK(long numeroCMR, int anno, long numeroDocumento,
		long idAssociato) {
		this.numeroCMR = numeroCMR;
		this.anno = anno;
		this.numeroDocumento = numeroDocumento;
		this.idAssociato = idAssociato;
	}

	public long getNumeroCMR() {
		return numeroCMR;
	}

	public void setNumeroCMR(long numeroCMR) {
		this.numeroCMR = numeroCMR;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public long getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public long getIdAssociato() {
		return idAssociato;
	}

	public void setIdAssociato(long idAssociato) {
		this.idAssociato = idAssociato;
	}

	@Override
	public int compareTo(CMRPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (numeroCMR < pk.numeroCMR) {
			value = -1;
		}
		else if (numeroCMR > pk.numeroCMR) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (anno < pk.anno) {
			value = -1;
		}
		else if (anno > pk.anno) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (numeroDocumento < pk.numeroDocumento) {
			value = -1;
		}
		else if (numeroDocumento > pk.numeroDocumento) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

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

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CMRPK)) {
			return false;
		}

		CMRPK pk = (CMRPK)obj;

		if ((numeroCMR == pk.numeroCMR) && (anno == pk.anno) &&
				(numeroDocumento == pk.numeroDocumento) &&
				(idAssociato == pk.idAssociato)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(numeroCMR) + String.valueOf(anno) +
		String.valueOf(numeroDocumento) + String.valueOf(idAssociato)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(20);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("numeroCMR");
		sb.append(StringPool.EQUAL);
		sb.append(numeroCMR);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("anno");
		sb.append(StringPool.EQUAL);
		sb.append(anno);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("numeroDocumento");
		sb.append(StringPool.EQUAL);
		sb.append(numeroDocumento);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("idAssociato");
		sb.append(StringPool.EQUAL);
		sb.append(idAssociato);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}
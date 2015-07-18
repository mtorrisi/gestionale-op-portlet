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
public class RigoDocumentoPK implements Comparable<RigoDocumentoPK>,
	Serializable {
	public int anno;
	public long numeroOrdine;
	public int rigoOrdine;

	public RigoDocumentoPK() {
	}

	public RigoDocumentoPK(int anno, long numeroOrdine, int rigoOrdine) {
		this.anno = anno;
		this.numeroOrdine = numeroOrdine;
		this.rigoOrdine = rigoOrdine;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public long getNumeroOrdine() {
		return numeroOrdine;
	}

	public void setNumeroOrdine(long numeroOrdine) {
		this.numeroOrdine = numeroOrdine;
	}

	public int getRigoOrdine() {
		return rigoOrdine;
	}

	public void setRigoOrdine(int rigoOrdine) {
		this.rigoOrdine = rigoOrdine;
	}

	@Override
	public int compareTo(RigoDocumentoPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

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

		if (numeroOrdine < pk.numeroOrdine) {
			value = -1;
		}
		else if (numeroOrdine > pk.numeroOrdine) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (rigoOrdine < pk.rigoOrdine) {
			value = -1;
		}
		else if (rigoOrdine > pk.rigoOrdine) {
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

		if (!(obj instanceof RigoDocumentoPK)) {
			return false;
		}

		RigoDocumentoPK pk = (RigoDocumentoPK)obj;

		if ((anno == pk.anno) && (numeroOrdine == pk.numeroOrdine) &&
				(rigoOrdine == pk.rigoOrdine)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(anno) + String.valueOf(numeroOrdine) +
		String.valueOf(rigoOrdine)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("anno");
		sb.append(StringPool.EQUAL);
		sb.append(anno);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("numeroOrdine");
		sb.append(StringPool.EQUAL);
		sb.append(numeroOrdine);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("rigoOrdine");
		sb.append(StringPool.EQUAL);
		sb.append(rigoOrdine);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}
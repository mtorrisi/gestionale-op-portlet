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
	public int numeroOrdine;
	public int rigoOrdin;

	public RigoDocumentoPK() {
	}

	public RigoDocumentoPK(int anno, int numeroOrdine, int rigoOrdin) {
		this.anno = anno;
		this.numeroOrdine = numeroOrdine;
		this.rigoOrdin = rigoOrdin;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public int getNumeroOrdine() {
		return numeroOrdine;
	}

	public void setNumeroOrdine(int numeroOrdine) {
		this.numeroOrdine = numeroOrdine;
	}

	public int getRigoOrdin() {
		return rigoOrdin;
	}

	public void setRigoOrdin(int rigoOrdin) {
		this.rigoOrdin = rigoOrdin;
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

		if (rigoOrdin < pk.rigoOrdin) {
			value = -1;
		}
		else if (rigoOrdin > pk.rigoOrdin) {
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
				(rigoOrdin == pk.rigoOrdin)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(anno) + String.valueOf(numeroOrdine) +
		String.valueOf(rigoOrdin)).hashCode();
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
		sb.append("rigoOrdin");
		sb.append(StringPool.EQUAL);
		sb.append(rigoOrdin);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}
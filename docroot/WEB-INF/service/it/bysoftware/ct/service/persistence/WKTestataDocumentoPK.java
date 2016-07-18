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
public class WKTestataDocumentoPK implements Comparable<WKTestataDocumentoPK>,
	Serializable {
	public int anno;
	public long numeroOrdine;
	public String tipoDocumento;
	public long idAssociato;

	public WKTestataDocumentoPK() {
	}

	public WKTestataDocumentoPK(int anno, long numeroOrdine,
		String tipoDocumento, long idAssociato) {
		this.anno = anno;
		this.numeroOrdine = numeroOrdine;
		this.tipoDocumento = tipoDocumento;
		this.idAssociato = idAssociato;
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

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public long getIdAssociato() {
		return idAssociato;
	}

	public void setIdAssociato(long idAssociato) {
		this.idAssociato = idAssociato;
	}

	@Override
	public int compareTo(WKTestataDocumentoPK pk) {
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

		value = tipoDocumento.compareTo(pk.tipoDocumento);

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

		if (!(obj instanceof WKTestataDocumentoPK)) {
			return false;
		}

		WKTestataDocumentoPK pk = (WKTestataDocumentoPK)obj;

		if ((anno == pk.anno) && (numeroOrdine == pk.numeroOrdine) &&
				(tipoDocumento.equals(pk.tipoDocumento)) &&
				(idAssociato == pk.idAssociato)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(anno) + String.valueOf(numeroOrdine) +
		String.valueOf(tipoDocumento) + String.valueOf(idAssociato)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(20);

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
		sb.append("tipoDocumento");
		sb.append(StringPool.EQUAL);
		sb.append(tipoDocumento);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("idAssociato");
		sb.append(StringPool.EQUAL);
		sb.append(idAssociato);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}
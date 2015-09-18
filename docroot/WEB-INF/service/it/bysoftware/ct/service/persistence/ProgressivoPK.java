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
public class ProgressivoPK implements Comparable<ProgressivoPK>, Serializable {
	public int anno;
	public long idAssociato;
	public int tipoDocumento;
	public int numeroProgressivo;

	public ProgressivoPK() {
	}

	public ProgressivoPK(int anno, long idAssociato, int tipoDocumento,
		int numeroProgressivo) {
		this.anno = anno;
		this.idAssociato = idAssociato;
		this.tipoDocumento = tipoDocumento;
		this.numeroProgressivo = numeroProgressivo;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public long getIdAssociato() {
		return idAssociato;
	}

	public void setIdAssociato(long idAssociato) {
		this.idAssociato = idAssociato;
	}

	public int getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(int tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public int getNumeroProgressivo() {
		return numeroProgressivo;
	}

	public void setNumeroProgressivo(int numeroProgressivo) {
		this.numeroProgressivo = numeroProgressivo;
	}

	@Override
	public int compareTo(ProgressivoPK pk) {
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

		if (tipoDocumento < pk.tipoDocumento) {
			value = -1;
		}
		else if (tipoDocumento > pk.tipoDocumento) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (numeroProgressivo < pk.numeroProgressivo) {
			value = -1;
		}
		else if (numeroProgressivo > pk.numeroProgressivo) {
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

		if (!(obj instanceof ProgressivoPK)) {
			return false;
		}

		ProgressivoPK pk = (ProgressivoPK)obj;

		if ((anno == pk.anno) && (idAssociato == pk.idAssociato) &&
				(tipoDocumento == pk.tipoDocumento) &&
				(numeroProgressivo == pk.numeroProgressivo)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(anno) + String.valueOf(idAssociato) +
		String.valueOf(tipoDocumento) + String.valueOf(numeroProgressivo)).hashCode();
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
		sb.append("idAssociato");
		sb.append(StringPool.EQUAL);
		sb.append(idAssociato);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("tipoDocumento");
		sb.append(StringPool.EQUAL);
		sb.append(tipoDocumento);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("numeroProgressivo");
		sb.append(StringPool.EQUAL);
		sb.append(numeroProgressivo);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}
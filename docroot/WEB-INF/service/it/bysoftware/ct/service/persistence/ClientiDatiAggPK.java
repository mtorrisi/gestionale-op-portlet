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
public class ClientiDatiAggPK implements Comparable<ClientiDatiAggPK>,
	Serializable {
	public String codiceAnagrafica;
	public boolean tipo;

	public ClientiDatiAggPK() {
	}

	public ClientiDatiAggPK(String codiceAnagrafica, boolean tipo) {
		this.codiceAnagrafica = codiceAnagrafica;
		this.tipo = tipo;
	}

	public String getCodiceAnagrafica() {
		return codiceAnagrafica;
	}

	public void setCodiceAnagrafica(String codiceAnagrafica) {
		this.codiceAnagrafica = codiceAnagrafica;
	}

	public boolean getTipo() {
		return tipo;
	}

	public boolean isTipo() {
		return tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}

	@Override
	public int compareTo(ClientiDatiAggPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		value = codiceAnagrafica.compareTo(pk.codiceAnagrafica);

		if (value != 0) {
			return value;
		}

		if (!tipo && pk.tipo) {
			value = -1;
		}
		else if (tipo && !pk.tipo) {
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

		if (!(obj instanceof ClientiDatiAggPK)) {
			return false;
		}

		ClientiDatiAggPK pk = (ClientiDatiAggPK)obj;

		if ((codiceAnagrafica.equals(pk.codiceAnagrafica)) &&
				(tipo == pk.tipo)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(codiceAnagrafica) + String.valueOf(tipo)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("codiceAnagrafica");
		sb.append(StringPool.EQUAL);
		sb.append(codiceAnagrafica);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("tipo");
		sb.append(StringPool.EQUAL);
		sb.append(tipo);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}
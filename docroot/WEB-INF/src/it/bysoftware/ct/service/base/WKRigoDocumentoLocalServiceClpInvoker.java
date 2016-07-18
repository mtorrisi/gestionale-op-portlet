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

package it.bysoftware.ct.service.base;

import it.bysoftware.ct.service.WKRigoDocumentoLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class WKRigoDocumentoLocalServiceClpInvoker {
	public WKRigoDocumentoLocalServiceClpInvoker() {
		_methodName0 = "addWKRigoDocumento";

		_methodParameterTypes0 = new String[] {
				"it.bysoftware.ct.model.WKRigoDocumento"
			};

		_methodName1 = "createWKRigoDocumento";

		_methodParameterTypes1 = new String[] {
				"it.bysoftware.ct.service.persistence.WKRigoDocumentoPK"
			};

		_methodName2 = "deleteWKRigoDocumento";

		_methodParameterTypes2 = new String[] {
				"it.bysoftware.ct.service.persistence.WKRigoDocumentoPK"
			};

		_methodName3 = "deleteWKRigoDocumento";

		_methodParameterTypes3 = new String[] {
				"it.bysoftware.ct.model.WKRigoDocumento"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchWKRigoDocumento";

		_methodParameterTypes10 = new String[] {
				"it.bysoftware.ct.service.persistence.WKRigoDocumentoPK"
			};

		_methodName11 = "getWKRigoDocumento";

		_methodParameterTypes11 = new String[] {
				"it.bysoftware.ct.service.persistence.WKRigoDocumentoPK"
			};

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getWKRigoDocumentos";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getWKRigoDocumentosCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateWKRigoDocumento";

		_methodParameterTypes15 = new String[] {
				"it.bysoftware.ct.model.WKRigoDocumento"
			};

		_methodName178 = "getBeanIdentifier";

		_methodParameterTypes178 = new String[] {  };

		_methodName179 = "setBeanIdentifier";

		_methodParameterTypes179 = new String[] { "java.lang.String" };

		_methodName184 = "getByNumeroOrdineAnnoAssociatoTipoDocumento";

		_methodParameterTypes184 = new String[] {
				"long", "int", "long", "java.lang.String"
			};

		_methodName185 = "getByAnnoAssociato";

		_methodParameterTypes185 = new String[] { "int", "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return WKRigoDocumentoLocalServiceUtil.addWKRigoDocumento((it.bysoftware.ct.model.WKRigoDocumento)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return WKRigoDocumentoLocalServiceUtil.createWKRigoDocumento((it.bysoftware.ct.service.persistence.WKRigoDocumentoPK)arguments[0]);
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return WKRigoDocumentoLocalServiceUtil.deleteWKRigoDocumento((it.bysoftware.ct.service.persistence.WKRigoDocumentoPK)arguments[0]);
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return WKRigoDocumentoLocalServiceUtil.deleteWKRigoDocumento((it.bysoftware.ct.model.WKRigoDocumento)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return WKRigoDocumentoLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return WKRigoDocumentoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return WKRigoDocumentoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return WKRigoDocumentoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return WKRigoDocumentoLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return WKRigoDocumentoLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return WKRigoDocumentoLocalServiceUtil.fetchWKRigoDocumento((it.bysoftware.ct.service.persistence.WKRigoDocumentoPK)arguments[0]);
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return WKRigoDocumentoLocalServiceUtil.getWKRigoDocumento((it.bysoftware.ct.service.persistence.WKRigoDocumentoPK)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return WKRigoDocumentoLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return WKRigoDocumentoLocalServiceUtil.getWKRigoDocumentos(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return WKRigoDocumentoLocalServiceUtil.getWKRigoDocumentosCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return WKRigoDocumentoLocalServiceUtil.updateWKRigoDocumento((it.bysoftware.ct.model.WKRigoDocumento)arguments[0]);
		}

		if (_methodName178.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes178, parameterTypes)) {
			return WKRigoDocumentoLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName179.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes179, parameterTypes)) {
			WKRigoDocumentoLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName184.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes184, parameterTypes)) {
			return WKRigoDocumentoLocalServiceUtil.getByNumeroOrdineAnnoAssociatoTipoDocumento(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Long)arguments[2]).longValue(), (java.lang.String)arguments[3]);
		}

		if (_methodName185.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes185, parameterTypes)) {
			return WKRigoDocumentoLocalServiceUtil.getByAnnoAssociato(((Integer)arguments[0]).intValue(),
				((Long)arguments[1]).longValue());
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName178;
	private String[] _methodParameterTypes178;
	private String _methodName179;
	private String[] _methodParameterTypes179;
	private String _methodName184;
	private String[] _methodParameterTypes184;
	private String _methodName185;
	private String[] _methodParameterTypes185;
}
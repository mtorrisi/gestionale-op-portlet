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

import it.bysoftware.ct.service.TestataDocumentoLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TestataDocumentoLocalServiceClpInvoker {
	public TestataDocumentoLocalServiceClpInvoker() {
		_methodName0 = "addTestataDocumento";

		_methodParameterTypes0 = new String[] {
				"it.bysoftware.ct.model.TestataDocumento"
			};

		_methodName1 = "createTestataDocumento";

		_methodParameterTypes1 = new String[] {
				"it.bysoftware.ct.service.persistence.TestataDocumentoPK"
			};

		_methodName2 = "deleteTestataDocumento";

		_methodParameterTypes2 = new String[] {
				"it.bysoftware.ct.service.persistence.TestataDocumentoPK"
			};

		_methodName3 = "deleteTestataDocumento";

		_methodParameterTypes3 = new String[] {
				"it.bysoftware.ct.model.TestataDocumento"
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

		_methodName10 = "fetchTestataDocumento";

		_methodParameterTypes10 = new String[] {
				"it.bysoftware.ct.service.persistence.TestataDocumentoPK"
			};

		_methodName11 = "getTestataDocumento";

		_methodParameterTypes11 = new String[] {
				"it.bysoftware.ct.service.persistence.TestataDocumentoPK"
			};

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getTestataDocumentos";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getTestataDocumentosCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateTestataDocumento";

		_methodParameterTypes15 = new String[] {
				"it.bysoftware.ct.model.TestataDocumento"
			};

		_methodName190 = "getBeanIdentifier";

		_methodParameterTypes190 = new String[] {  };

		_methodName191 = "setBeanIdentifier";

		_methodParameterTypes191 = new String[] { "java.lang.String" };

		_methodName196 = "countDocumnetByCodiceOperatore";

		_methodParameterTypes196 = new String[] {
				"java.lang.String", "java.lang.String", "int"
			};

		_methodName197 = "getByCodiceOperatore";

		_methodParameterTypes197 = new String[] { "java.lang.String" };

		_methodName198 = "getByCodiceOperatore";

		_methodParameterTypes198 = new String[] {
				"java.lang.String", "java.lang.String", "int"
			};

		_methodName199 = "getByCodiceSoggettoCodiceOperatore";

		_methodParameterTypes199 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName200 = "getDocumentiCollegati";

		_methodParameterTypes200 = new String[] {
				"int", "java.lang.String", "long", "java.lang.String"
			};

		_methodName201 = "getDocumentiSoggetto";

		_methodParameterTypes201 = new String[] {
				"int", "java.lang.String", "long"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return TestataDocumentoLocalServiceUtil.addTestataDocumento((it.bysoftware.ct.model.TestataDocumento)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return TestataDocumentoLocalServiceUtil.createTestataDocumento((it.bysoftware.ct.service.persistence.TestataDocumentoPK)arguments[0]);
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return TestataDocumentoLocalServiceUtil.deleteTestataDocumento((it.bysoftware.ct.service.persistence.TestataDocumentoPK)arguments[0]);
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return TestataDocumentoLocalServiceUtil.deleteTestataDocumento((it.bysoftware.ct.model.TestataDocumento)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return TestataDocumentoLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return TestataDocumentoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return TestataDocumentoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return TestataDocumentoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return TestataDocumentoLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return TestataDocumentoLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return TestataDocumentoLocalServiceUtil.fetchTestataDocumento((it.bysoftware.ct.service.persistence.TestataDocumentoPK)arguments[0]);
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return TestataDocumentoLocalServiceUtil.getTestataDocumento((it.bysoftware.ct.service.persistence.TestataDocumentoPK)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return TestataDocumentoLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return TestataDocumentoLocalServiceUtil.getTestataDocumentos(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return TestataDocumentoLocalServiceUtil.getTestataDocumentosCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return TestataDocumentoLocalServiceUtil.updateTestataDocumento((it.bysoftware.ct.model.TestataDocumento)arguments[0]);
		}

		if (_methodName190.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes190, parameterTypes)) {
			return TestataDocumentoLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName191.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes191, parameterTypes)) {
			TestataDocumentoLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName196.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes196, parameterTypes)) {
			return TestataDocumentoLocalServiceUtil.countDocumnetByCodiceOperatore((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue());
		}

		if (_methodName197.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes197, parameterTypes)) {
			return TestataDocumentoLocalServiceUtil.getByCodiceOperatore((java.lang.String)arguments[0]);
		}

		if (_methodName198.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes198, parameterTypes)) {
			return TestataDocumentoLocalServiceUtil.getByCodiceOperatore((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue());
		}

		if (_methodName199.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes199, parameterTypes)) {
			return TestataDocumentoLocalServiceUtil.getByCodiceSoggettoCodiceOperatore((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName200.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes200, parameterTypes)) {
			return TestataDocumentoLocalServiceUtil.getDocumentiCollegati(((Integer)arguments[0]).intValue(),
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(), (java.lang.String)arguments[3]);
		}

		if (_methodName201.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes201, parameterTypes)) {
			return TestataDocumentoLocalServiceUtil.getDocumentiSoggetto(((Integer)arguments[0]).intValue(),
				(java.lang.String)arguments[1], ((Long)arguments[2]).longValue());
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
	private String _methodName190;
	private String[] _methodParameterTypes190;
	private String _methodName191;
	private String[] _methodParameterTypes191;
	private String _methodName196;
	private String[] _methodParameterTypes196;
	private String _methodName197;
	private String[] _methodParameterTypes197;
	private String _methodName198;
	private String[] _methodParameterTypes198;
	private String _methodName199;
	private String[] _methodParameterTypes199;
	private String _methodName200;
	private String[] _methodParameterTypes200;
	private String _methodName201;
	private String[] _methodParameterTypes201;
}
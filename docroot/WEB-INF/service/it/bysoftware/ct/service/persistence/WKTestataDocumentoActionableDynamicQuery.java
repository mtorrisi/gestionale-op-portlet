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

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import it.bysoftware.ct.model.WKTestataDocumento;
import it.bysoftware.ct.service.WKTestataDocumentoLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class WKTestataDocumentoActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public WKTestataDocumentoActionableDynamicQuery() throws SystemException {
		setBaseLocalService(WKTestataDocumentoLocalServiceUtil.getService());
		setClass(WKTestataDocumento.class);

		setClassLoader(it.bysoftware.ct.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("primaryKey.anno");
	}
}
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

package it.bysoftware.ct.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link WKTestataDocumentoService}.
 *
 * @author Brian Wing Shun Chan
 * @see WKTestataDocumentoService
 * @generated
 */
public class WKTestataDocumentoServiceWrapper
	implements WKTestataDocumentoService,
		ServiceWrapper<WKTestataDocumentoService> {
	public WKTestataDocumentoServiceWrapper(
		WKTestataDocumentoService wkTestataDocumentoService) {
		_wkTestataDocumentoService = wkTestataDocumentoService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _wkTestataDocumentoService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_wkTestataDocumentoService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _wkTestataDocumentoService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public WKTestataDocumentoService getWrappedWKTestataDocumentoService() {
		return _wkTestataDocumentoService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedWKTestataDocumentoService(
		WKTestataDocumentoService wkTestataDocumentoService) {
		_wkTestataDocumentoService = wkTestataDocumentoService;
	}

	@Override
	public WKTestataDocumentoService getWrappedService() {
		return _wkTestataDocumentoService;
	}

	@Override
	public void setWrappedService(
		WKTestataDocumentoService wkTestataDocumentoService) {
		_wkTestataDocumentoService = wkTestataDocumentoService;
	}

	private WKTestataDocumentoService _wkTestataDocumentoService;
}
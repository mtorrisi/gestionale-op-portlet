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
 * Provides a wrapper for {@link DestinatariDiversiService}.
 *
 * @author Brian Wing Shun Chan
 * @see DestinatariDiversiService
 * @generated
 */
public class DestinatariDiversiServiceWrapper
	implements DestinatariDiversiService,
		ServiceWrapper<DestinatariDiversiService> {
	public DestinatariDiversiServiceWrapper(
		DestinatariDiversiService destinatariDiversiService) {
		_destinatariDiversiService = destinatariDiversiService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _destinatariDiversiService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_destinatariDiversiService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _destinatariDiversiService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DestinatariDiversiService getWrappedDestinatariDiversiService() {
		return _destinatariDiversiService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDestinatariDiversiService(
		DestinatariDiversiService destinatariDiversiService) {
		_destinatariDiversiService = destinatariDiversiService;
	}

	@Override
	public DestinatariDiversiService getWrappedService() {
		return _destinatariDiversiService;
	}

	@Override
	public void setWrappedService(
		DestinatariDiversiService destinatariDiversiService) {
		_destinatariDiversiService = destinatariDiversiService;
	}

	private DestinatariDiversiService _destinatariDiversiService;
}
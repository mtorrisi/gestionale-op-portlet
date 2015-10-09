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
 * Provides a wrapper for {@link DescrizioniVariantiService}.
 *
 * @author Brian Wing Shun Chan
 * @see DescrizioniVariantiService
 * @generated
 */
public class DescrizioniVariantiServiceWrapper
	implements DescrizioniVariantiService,
		ServiceWrapper<DescrizioniVariantiService> {
	public DescrizioniVariantiServiceWrapper(
		DescrizioniVariantiService descrizioniVariantiService) {
		_descrizioniVariantiService = descrizioniVariantiService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _descrizioniVariantiService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_descrizioniVariantiService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _descrizioniVariantiService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DescrizioniVariantiService getWrappedDescrizioniVariantiService() {
		return _descrizioniVariantiService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDescrizioniVariantiService(
		DescrizioniVariantiService descrizioniVariantiService) {
		_descrizioniVariantiService = descrizioniVariantiService;
	}

	@Override
	public DescrizioniVariantiService getWrappedService() {
		return _descrizioniVariantiService;
	}

	@Override
	public void setWrappedService(
		DescrizioniVariantiService descrizioniVariantiService) {
		_descrizioniVariantiService = descrizioniVariantiService;
	}

	private DescrizioniVariantiService _descrizioniVariantiService;
}
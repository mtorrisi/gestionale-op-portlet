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
 * Provides a wrapper for {@link ArticoliAssociatoOPService}.
 *
 * @author Brian Wing Shun Chan
 * @see ArticoliAssociatoOPService
 * @generated
 */
public class ArticoliAssociatoOPServiceWrapper
	implements ArticoliAssociatoOPService,
		ServiceWrapper<ArticoliAssociatoOPService> {
	public ArticoliAssociatoOPServiceWrapper(
		ArticoliAssociatoOPService articoliAssociatoOPService) {
		_articoliAssociatoOPService = articoliAssociatoOPService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _articoliAssociatoOPService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_articoliAssociatoOPService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _articoliAssociatoOPService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ArticoliAssociatoOPService getWrappedArticoliAssociatoOPService() {
		return _articoliAssociatoOPService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedArticoliAssociatoOPService(
		ArticoliAssociatoOPService articoliAssociatoOPService) {
		_articoliAssociatoOPService = articoliAssociatoOPService;
	}

	@Override
	public ArticoliAssociatoOPService getWrappedService() {
		return _articoliAssociatoOPService;
	}

	@Override
	public void setWrappedService(
		ArticoliAssociatoOPService articoliAssociatoOPService) {
		_articoliAssociatoOPService = articoliAssociatoOPService;
	}

	private ArticoliAssociatoOPService _articoliAssociatoOPService;
}
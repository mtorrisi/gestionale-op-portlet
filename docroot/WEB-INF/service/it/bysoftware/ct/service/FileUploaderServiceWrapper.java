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
 * Provides a wrapper for {@link FileUploaderService}.
 *
 * @author Brian Wing Shun Chan
 * @see FileUploaderService
 * @generated
 */
public class FileUploaderServiceWrapper implements FileUploaderService,
	ServiceWrapper<FileUploaderService> {
	public FileUploaderServiceWrapper(FileUploaderService fileUploaderService) {
		_fileUploaderService = fileUploaderService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _fileUploaderService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_fileUploaderService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _fileUploaderService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public void add(java.io.File file) {
		_fileUploaderService.add(file);
	}

	@Override
	public void add(java.io.File file, java.lang.String name) {
		_fileUploaderService.add(file, name);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FileUploaderService getWrappedFileUploaderService() {
		return _fileUploaderService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFileUploaderService(
		FileUploaderService fileUploaderService) {
		_fileUploaderService = fileUploaderService;
	}

	@Override
	public FileUploaderService getWrappedService() {
		return _fileUploaderService;
	}

	@Override
	public void setWrappedService(FileUploaderService fileUploaderService) {
		_fileUploaderService = fileUploaderService;
	}

	private FileUploaderService _fileUploaderService;
}
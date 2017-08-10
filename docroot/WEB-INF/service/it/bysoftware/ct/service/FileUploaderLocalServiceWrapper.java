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
 * Provides a wrapper for {@link FileUploaderLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FileUploaderLocalService
 * @generated
 */
public class FileUploaderLocalServiceWrapper implements FileUploaderLocalService,
	ServiceWrapper<FileUploaderLocalService> {
	public FileUploaderLocalServiceWrapper(
		FileUploaderLocalService fileUploaderLocalService) {
		_fileUploaderLocalService = fileUploaderLocalService;
	}

	/**
	* Adds the file uploader to the database. Also notifies the appropriate model listeners.
	*
	* @param fileUploader the file uploader
	* @return the file uploader that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.FileUploader addFileUploader(
		it.bysoftware.ct.model.FileUploader fileUploader)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileUploaderLocalService.addFileUploader(fileUploader);
	}

	/**
	* Creates a new file uploader with the primary key. Does not add the file uploader to the database.
	*
	* @param fid the primary key for the new file uploader
	* @return the new file uploader
	*/
	@Override
	public it.bysoftware.ct.model.FileUploader createFileUploader(long fid) {
		return _fileUploaderLocalService.createFileUploader(fid);
	}

	/**
	* Deletes the file uploader with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fid the primary key of the file uploader
	* @return the file uploader that was removed
	* @throws PortalException if a file uploader with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.FileUploader deleteFileUploader(long fid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fileUploaderLocalService.deleteFileUploader(fid);
	}

	/**
	* Deletes the file uploader from the database. Also notifies the appropriate model listeners.
	*
	* @param fileUploader the file uploader
	* @return the file uploader that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.FileUploader deleteFileUploader(
		it.bysoftware.ct.model.FileUploader fileUploader)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileUploaderLocalService.deleteFileUploader(fileUploader);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _fileUploaderLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileUploaderLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.FileUploaderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _fileUploaderLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.FileUploaderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileUploaderLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileUploaderLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileUploaderLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.bysoftware.ct.model.FileUploader fetchFileUploader(long fid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileUploaderLocalService.fetchFileUploader(fid);
	}

	/**
	* Returns the file uploader with the primary key.
	*
	* @param fid the primary key of the file uploader
	* @return the file uploader
	* @throws PortalException if a file uploader with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.FileUploader getFileUploader(long fid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fileUploaderLocalService.getFileUploader(fid);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fileUploaderLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the file uploaders.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.FileUploaderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of file uploaders
	* @param end the upper bound of the range of file uploaders (not inclusive)
	* @return the range of file uploaders
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.bysoftware.ct.model.FileUploader> getFileUploaders(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileUploaderLocalService.getFileUploaders(start, end);
	}

	/**
	* Returns the number of file uploaders.
	*
	* @return the number of file uploaders
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFileUploadersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileUploaderLocalService.getFileUploadersCount();
	}

	/**
	* Updates the file uploader in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param fileUploader the file uploader
	* @return the file uploader that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.FileUploader updateFileUploader(
		it.bysoftware.ct.model.FileUploader fileUploader)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileUploaderLocalService.updateFileUploader(fileUploader);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _fileUploaderLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_fileUploaderLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _fileUploaderLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link
	* it.bysoftware.ct.service.FileUploaderLocalServiceUtil} to access the file
	* uploader local service.
	*/
	@Override
	public void add(java.io.File file) {
		_fileUploaderLocalService.add(file);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FileUploaderLocalService getWrappedFileUploaderLocalService() {
		return _fileUploaderLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFileUploaderLocalService(
		FileUploaderLocalService fileUploaderLocalService) {
		_fileUploaderLocalService = fileUploaderLocalService;
	}

	@Override
	public FileUploaderLocalService getWrappedService() {
		return _fileUploaderLocalService;
	}

	@Override
	public void setWrappedService(
		FileUploaderLocalService fileUploaderLocalService) {
		_fileUploaderLocalService = fileUploaderLocalService;
	}

	private FileUploaderLocalService _fileUploaderLocalService;
}
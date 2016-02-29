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
 * Provides a wrapper for {@link TracciabilitaGrezziLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TracciabilitaGrezziLocalService
 * @generated
 */
public class TracciabilitaGrezziLocalServiceWrapper
	implements TracciabilitaGrezziLocalService,
		ServiceWrapper<TracciabilitaGrezziLocalService> {
	public TracciabilitaGrezziLocalServiceWrapper(
		TracciabilitaGrezziLocalService tracciabilitaGrezziLocalService) {
		_tracciabilitaGrezziLocalService = tracciabilitaGrezziLocalService;
	}

	/**
	* Adds the tracciabilita grezzi to the database. Also notifies the appropriate model listeners.
	*
	* @param tracciabilitaGrezzi the tracciabilita grezzi
	* @return the tracciabilita grezzi that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.TracciabilitaGrezzi addTracciabilitaGrezzi(
		it.bysoftware.ct.model.TracciabilitaGrezzi tracciabilitaGrezzi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tracciabilitaGrezziLocalService.addTracciabilitaGrezzi(tracciabilitaGrezzi);
	}

	/**
	* Creates a new tracciabilita grezzi with the primary key. Does not add the tracciabilita grezzi to the database.
	*
	* @param id the primary key for the new tracciabilita grezzi
	* @return the new tracciabilita grezzi
	*/
	@Override
	public it.bysoftware.ct.model.TracciabilitaGrezzi createTracciabilitaGrezzi(
		long id) {
		return _tracciabilitaGrezziLocalService.createTracciabilitaGrezzi(id);
	}

	/**
	* Deletes the tracciabilita grezzi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the tracciabilita grezzi
	* @return the tracciabilita grezzi that was removed
	* @throws PortalException if a tracciabilita grezzi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.TracciabilitaGrezzi deleteTracciabilitaGrezzi(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tracciabilitaGrezziLocalService.deleteTracciabilitaGrezzi(id);
	}

	/**
	* Deletes the tracciabilita grezzi from the database. Also notifies the appropriate model listeners.
	*
	* @param tracciabilitaGrezzi the tracciabilita grezzi
	* @return the tracciabilita grezzi that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.TracciabilitaGrezzi deleteTracciabilitaGrezzi(
		it.bysoftware.ct.model.TracciabilitaGrezzi tracciabilitaGrezzi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tracciabilitaGrezziLocalService.deleteTracciabilitaGrezzi(tracciabilitaGrezzi);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tracciabilitaGrezziLocalService.dynamicQuery();
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
		return _tracciabilitaGrezziLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TracciabilitaGrezziModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tracciabilitaGrezziLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TracciabilitaGrezziModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tracciabilitaGrezziLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _tracciabilitaGrezziLocalService.dynamicQueryCount(dynamicQuery);
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
		return _tracciabilitaGrezziLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.bysoftware.ct.model.TracciabilitaGrezzi fetchTracciabilitaGrezzi(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _tracciabilitaGrezziLocalService.fetchTracciabilitaGrezzi(id);
	}

	/**
	* Returns the tracciabilita grezzi with the primary key.
	*
	* @param id the primary key of the tracciabilita grezzi
	* @return the tracciabilita grezzi
	* @throws PortalException if a tracciabilita grezzi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.TracciabilitaGrezzi getTracciabilitaGrezzi(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tracciabilitaGrezziLocalService.getTracciabilitaGrezzi(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tracciabilitaGrezziLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the tracciabilita grezzis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TracciabilitaGrezziModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tracciabilita grezzis
	* @param end the upper bound of the range of tracciabilita grezzis (not inclusive)
	* @return the range of tracciabilita grezzis
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.bysoftware.ct.model.TracciabilitaGrezzi> getTracciabilitaGrezzis(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tracciabilitaGrezziLocalService.getTracciabilitaGrezzis(start,
			end);
	}

	/**
	* Returns the number of tracciabilita grezzis.
	*
	* @return the number of tracciabilita grezzis
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTracciabilitaGrezzisCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tracciabilitaGrezziLocalService.getTracciabilitaGrezzisCount();
	}

	/**
	* Updates the tracciabilita grezzi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tracciabilitaGrezzi the tracciabilita grezzi
	* @return the tracciabilita grezzi that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.TracciabilitaGrezzi updateTracciabilitaGrezzi(
		it.bysoftware.ct.model.TracciabilitaGrezzi tracciabilitaGrezzi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tracciabilitaGrezziLocalService.updateTracciabilitaGrezzi(tracciabilitaGrezzi);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tracciabilitaGrezziLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tracciabilitaGrezziLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tracciabilitaGrezziLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<it.bysoftware.ct.model.TracciabilitaGrezzi> getIdSchedaTracciabilita(
		long idSchedaTracciabilita)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tracciabilitaGrezziLocalService.getIdSchedaTracciabilita(idSchedaTracciabilita);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TracciabilitaGrezziLocalService getWrappedTracciabilitaGrezziLocalService() {
		return _tracciabilitaGrezziLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTracciabilitaGrezziLocalService(
		TracciabilitaGrezziLocalService tracciabilitaGrezziLocalService) {
		_tracciabilitaGrezziLocalService = tracciabilitaGrezziLocalService;
	}

	@Override
	public TracciabilitaGrezziLocalService getWrappedService() {
		return _tracciabilitaGrezziLocalService;
	}

	@Override
	public void setWrappedService(
		TracciabilitaGrezziLocalService tracciabilitaGrezziLocalService) {
		_tracciabilitaGrezziLocalService = tracciabilitaGrezziLocalService;
	}

	private TracciabilitaGrezziLocalService _tracciabilitaGrezziLocalService;
}
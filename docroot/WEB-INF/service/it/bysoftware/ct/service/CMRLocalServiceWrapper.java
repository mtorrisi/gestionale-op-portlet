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
 * Provides a wrapper for {@link CMRLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CMRLocalService
 * @generated
 */
public class CMRLocalServiceWrapper implements CMRLocalService,
	ServiceWrapper<CMRLocalService> {
	public CMRLocalServiceWrapper(CMRLocalService cmrLocalService) {
		_cmrLocalService = cmrLocalService;
	}

	/**
	* Adds the c m r to the database. Also notifies the appropriate model listeners.
	*
	* @param cmr the c m r
	* @return the c m r that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.CMR addCMR(it.bysoftware.ct.model.CMR cmr)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cmrLocalService.addCMR(cmr);
	}

	/**
	* Creates a new c m r with the primary key. Does not add the c m r to the database.
	*
	* @param cmrPK the primary key for the new c m r
	* @return the new c m r
	*/
	@Override
	public it.bysoftware.ct.model.CMR createCMR(
		it.bysoftware.ct.service.persistence.CMRPK cmrPK) {
		return _cmrLocalService.createCMR(cmrPK);
	}

	/**
	* Deletes the c m r with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cmrPK the primary key of the c m r
	* @return the c m r that was removed
	* @throws PortalException if a c m r with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.CMR deleteCMR(
		it.bysoftware.ct.service.persistence.CMRPK cmrPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cmrLocalService.deleteCMR(cmrPK);
	}

	/**
	* Deletes the c m r from the database. Also notifies the appropriate model listeners.
	*
	* @param cmr the c m r
	* @return the c m r that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.CMR deleteCMR(it.bysoftware.ct.model.CMR cmr)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cmrLocalService.deleteCMR(cmr);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cmrLocalService.dynamicQuery();
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
		return _cmrLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.CMRModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _cmrLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.CMRModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _cmrLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _cmrLocalService.dynamicQueryCount(dynamicQuery);
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
		return _cmrLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.bysoftware.ct.model.CMR fetchCMR(
		it.bysoftware.ct.service.persistence.CMRPK cmrPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cmrLocalService.fetchCMR(cmrPK);
	}

	/**
	* Returns the c m r with the primary key.
	*
	* @param cmrPK the primary key of the c m r
	* @return the c m r
	* @throws PortalException if a c m r with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.CMR getCMR(
		it.bysoftware.ct.service.persistence.CMRPK cmrPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cmrLocalService.getCMR(cmrPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cmrLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the c m rs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.CMRModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of c m rs
	* @param end the upper bound of the range of c m rs (not inclusive)
	* @return the range of c m rs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.bysoftware.ct.model.CMR> getCMRs(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cmrLocalService.getCMRs(start, end);
	}

	/**
	* Returns the number of c m rs.
	*
	* @return the number of c m rs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCMRsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cmrLocalService.getCMRsCount();
	}

	/**
	* Updates the c m r in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cmr the c m r
	* @return the c m r that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.CMR updateCMR(it.bysoftware.ct.model.CMR cmr)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cmrLocalService.updateCMR(cmr);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _cmrLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_cmrLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _cmrLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CMRLocalService getWrappedCMRLocalService() {
		return _cmrLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCMRLocalService(CMRLocalService cmrLocalService) {
		_cmrLocalService = cmrLocalService;
	}

	@Override
	public CMRLocalService getWrappedService() {
		return _cmrLocalService;
	}

	@Override
	public void setWrappedService(CMRLocalService cmrLocalService) {
		_cmrLocalService = cmrLocalService;
	}

	private CMRLocalService _cmrLocalService;
}
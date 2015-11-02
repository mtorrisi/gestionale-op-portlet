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
 * Provides a wrapper for {@link BancheAppoggioLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BancheAppoggioLocalService
 * @generated
 */
public class BancheAppoggioLocalServiceWrapper
	implements BancheAppoggioLocalService,
		ServiceWrapper<BancheAppoggioLocalService> {
	public BancheAppoggioLocalServiceWrapper(
		BancheAppoggioLocalService bancheAppoggioLocalService) {
		_bancheAppoggioLocalService = bancheAppoggioLocalService;
	}

	/**
	* Adds the banche appoggio to the database. Also notifies the appropriate model listeners.
	*
	* @param bancheAppoggio the banche appoggio
	* @return the banche appoggio that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.BancheAppoggio addBancheAppoggio(
		it.bysoftware.ct.model.BancheAppoggio bancheAppoggio)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bancheAppoggioLocalService.addBancheAppoggio(bancheAppoggio);
	}

	/**
	* Creates a new banche appoggio with the primary key. Does not add the banche appoggio to the database.
	*
	* @param codiceBanca the primary key for the new banche appoggio
	* @return the new banche appoggio
	*/
	@Override
	public it.bysoftware.ct.model.BancheAppoggio createBancheAppoggio(
		java.lang.String codiceBanca) {
		return _bancheAppoggioLocalService.createBancheAppoggio(codiceBanca);
	}

	/**
	* Deletes the banche appoggio with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param codiceBanca the primary key of the banche appoggio
	* @return the banche appoggio that was removed
	* @throws PortalException if a banche appoggio with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.BancheAppoggio deleteBancheAppoggio(
		java.lang.String codiceBanca)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bancheAppoggioLocalService.deleteBancheAppoggio(codiceBanca);
	}

	/**
	* Deletes the banche appoggio from the database. Also notifies the appropriate model listeners.
	*
	* @param bancheAppoggio the banche appoggio
	* @return the banche appoggio that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.BancheAppoggio deleteBancheAppoggio(
		it.bysoftware.ct.model.BancheAppoggio bancheAppoggio)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bancheAppoggioLocalService.deleteBancheAppoggio(bancheAppoggio);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bancheAppoggioLocalService.dynamicQuery();
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
		return _bancheAppoggioLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.BancheAppoggioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _bancheAppoggioLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.BancheAppoggioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _bancheAppoggioLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _bancheAppoggioLocalService.dynamicQueryCount(dynamicQuery);
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
		return _bancheAppoggioLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.bysoftware.ct.model.BancheAppoggio fetchBancheAppoggio(
		java.lang.String codiceBanca)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bancheAppoggioLocalService.fetchBancheAppoggio(codiceBanca);
	}

	/**
	* Returns the banche appoggio with the primary key.
	*
	* @param codiceBanca the primary key of the banche appoggio
	* @return the banche appoggio
	* @throws PortalException if a banche appoggio with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.BancheAppoggio getBancheAppoggio(
		java.lang.String codiceBanca)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bancheAppoggioLocalService.getBancheAppoggio(codiceBanca);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bancheAppoggioLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the banche appoggios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.BancheAppoggioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of banche appoggios
	* @param end the upper bound of the range of banche appoggios (not inclusive)
	* @return the range of banche appoggios
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.bysoftware.ct.model.BancheAppoggio> getBancheAppoggios(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bancheAppoggioLocalService.getBancheAppoggios(start, end);
	}

	/**
	* Returns the number of banche appoggios.
	*
	* @return the number of banche appoggios
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getBancheAppoggiosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bancheAppoggioLocalService.getBancheAppoggiosCount();
	}

	/**
	* Updates the banche appoggio in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bancheAppoggio the banche appoggio
	* @return the banche appoggio that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.BancheAppoggio updateBancheAppoggio(
		it.bysoftware.ct.model.BancheAppoggio bancheAppoggio)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bancheAppoggioLocalService.updateBancheAppoggio(bancheAppoggio);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _bancheAppoggioLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_bancheAppoggioLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _bancheAppoggioLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BancheAppoggioLocalService getWrappedBancheAppoggioLocalService() {
		return _bancheAppoggioLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBancheAppoggioLocalService(
		BancheAppoggioLocalService bancheAppoggioLocalService) {
		_bancheAppoggioLocalService = bancheAppoggioLocalService;
	}

	@Override
	public BancheAppoggioLocalService getWrappedService() {
		return _bancheAppoggioLocalService;
	}

	@Override
	public void setWrappedService(
		BancheAppoggioLocalService bancheAppoggioLocalService) {
		_bancheAppoggioLocalService = bancheAppoggioLocalService;
	}

	private BancheAppoggioLocalService _bancheAppoggioLocalService;
}
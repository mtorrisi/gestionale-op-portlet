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
 * Provides a wrapper for {@link OrganizzazioneProduttoriLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see OrganizzazioneProduttoriLocalService
 * @generated
 */
public class OrganizzazioneProduttoriLocalServiceWrapper
	implements OrganizzazioneProduttoriLocalService,
		ServiceWrapper<OrganizzazioneProduttoriLocalService> {
	public OrganizzazioneProduttoriLocalServiceWrapper(
		OrganizzazioneProduttoriLocalService organizzazioneProduttoriLocalService) {
		_organizzazioneProduttoriLocalService = organizzazioneProduttoriLocalService;
	}

	/**
	* Adds the organizzazione produttori to the database. Also notifies the appropriate model listeners.
	*
	* @param organizzazioneProduttori the organizzazione produttori
	* @return the organizzazione produttori that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.OrganizzazioneProduttori addOrganizzazioneProduttori(
		it.bysoftware.ct.model.OrganizzazioneProduttori organizzazioneProduttori)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organizzazioneProduttoriLocalService.addOrganizzazioneProduttori(organizzazioneProduttori);
	}

	/**
	* Creates a new organizzazione produttori with the primary key. Does not add the organizzazione produttori to the database.
	*
	* @param id the primary key for the new organizzazione produttori
	* @return the new organizzazione produttori
	*/
	@Override
	public it.bysoftware.ct.model.OrganizzazioneProduttori createOrganizzazioneProduttori(
		long id) {
		return _organizzazioneProduttoriLocalService.createOrganizzazioneProduttori(id);
	}

	/**
	* Deletes the organizzazione produttori with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the organizzazione produttori
	* @return the organizzazione produttori that was removed
	* @throws PortalException if a organizzazione produttori with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.OrganizzazioneProduttori deleteOrganizzazioneProduttori(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _organizzazioneProduttoriLocalService.deleteOrganizzazioneProduttori(id);
	}

	/**
	* Deletes the organizzazione produttori from the database. Also notifies the appropriate model listeners.
	*
	* @param organizzazioneProduttori the organizzazione produttori
	* @return the organizzazione produttori that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.OrganizzazioneProduttori deleteOrganizzazioneProduttori(
		it.bysoftware.ct.model.OrganizzazioneProduttori organizzazioneProduttori)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organizzazioneProduttoriLocalService.deleteOrganizzazioneProduttori(organizzazioneProduttori);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _organizzazioneProduttoriLocalService.dynamicQuery();
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
		return _organizzazioneProduttoriLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.OrganizzazioneProduttoriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _organizzazioneProduttoriLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.OrganizzazioneProduttoriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _organizzazioneProduttoriLocalService.dynamicQuery(dynamicQuery,
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
		return _organizzazioneProduttoriLocalService.dynamicQueryCount(dynamicQuery);
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
		return _organizzazioneProduttoriLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.bysoftware.ct.model.OrganizzazioneProduttori fetchOrganizzazioneProduttori(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _organizzazioneProduttoriLocalService.fetchOrganizzazioneProduttori(id);
	}

	/**
	* Returns the organizzazione produttori with the primary key.
	*
	* @param id the primary key of the organizzazione produttori
	* @return the organizzazione produttori
	* @throws PortalException if a organizzazione produttori with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.OrganizzazioneProduttori getOrganizzazioneProduttori(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _organizzazioneProduttoriLocalService.getOrganizzazioneProduttori(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _organizzazioneProduttoriLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the organizzazione produttoris.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.OrganizzazioneProduttoriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of organizzazione produttoris
	* @param end the upper bound of the range of organizzazione produttoris (not inclusive)
	* @return the range of organizzazione produttoris
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.bysoftware.ct.model.OrganizzazioneProduttori> getOrganizzazioneProduttoris(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organizzazioneProduttoriLocalService.getOrganizzazioneProduttoris(start,
			end);
	}

	/**
	* Returns the number of organizzazione produttoris.
	*
	* @return the number of organizzazione produttoris
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getOrganizzazioneProduttorisCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organizzazioneProduttoriLocalService.getOrganizzazioneProduttorisCount();
	}

	/**
	* Updates the organizzazione produttori in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param organizzazioneProduttori the organizzazione produttori
	* @return the organizzazione produttori that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.OrganizzazioneProduttori updateOrganizzazioneProduttori(
		it.bysoftware.ct.model.OrganizzazioneProduttori organizzazioneProduttori)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organizzazioneProduttoriLocalService.updateOrganizzazioneProduttori(organizzazioneProduttori);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _organizzazioneProduttoriLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_organizzazioneProduttoriLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _organizzazioneProduttoriLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link it.bysoftware.ct.service.OrganizzazioneProduttoriLocalServiceUtil} to access the organizzazione produttori local service.
	*/
	@Override
	public it.bysoftware.ct.model.OrganizzazioneProduttori getOP(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException {
		return _organizzazioneProduttoriLocalService.getOP(id);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public OrganizzazioneProduttoriLocalService getWrappedOrganizzazioneProduttoriLocalService() {
		return _organizzazioneProduttoriLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedOrganizzazioneProduttoriLocalService(
		OrganizzazioneProduttoriLocalService organizzazioneProduttoriLocalService) {
		_organizzazioneProduttoriLocalService = organizzazioneProduttoriLocalService;
	}

	@Override
	public OrganizzazioneProduttoriLocalService getWrappedService() {
		return _organizzazioneProduttoriLocalService;
	}

	@Override
	public void setWrappedService(
		OrganizzazioneProduttoriLocalService organizzazioneProduttoriLocalService) {
		_organizzazioneProduttoriLocalService = organizzazioneProduttoriLocalService;
	}

	private OrganizzazioneProduttoriLocalService _organizzazioneProduttoriLocalService;
}
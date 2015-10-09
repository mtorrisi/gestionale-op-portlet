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
 * Provides a wrapper for {@link DescrizioniVariantiLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DescrizioniVariantiLocalService
 * @generated
 */
public class DescrizioniVariantiLocalServiceWrapper
	implements DescrizioniVariantiLocalService,
		ServiceWrapper<DescrizioniVariantiLocalService> {
	public DescrizioniVariantiLocalServiceWrapper(
		DescrizioniVariantiLocalService descrizioniVariantiLocalService) {
		_descrizioniVariantiLocalService = descrizioniVariantiLocalService;
	}

	/**
	* Adds the descrizioni varianti to the database. Also notifies the appropriate model listeners.
	*
	* @param descrizioniVarianti the descrizioni varianti
	* @return the descrizioni varianti that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.DescrizioniVarianti addDescrizioniVarianti(
		it.bysoftware.ct.model.DescrizioniVarianti descrizioniVarianti)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _descrizioniVariantiLocalService.addDescrizioniVarianti(descrizioniVarianti);
	}

	/**
	* Creates a new descrizioni varianti with the primary key. Does not add the descrizioni varianti to the database.
	*
	* @param codiceVariante the primary key for the new descrizioni varianti
	* @return the new descrizioni varianti
	*/
	@Override
	public it.bysoftware.ct.model.DescrizioniVarianti createDescrizioniVarianti(
		java.lang.String codiceVariante) {
		return _descrizioniVariantiLocalService.createDescrizioniVarianti(codiceVariante);
	}

	/**
	* Deletes the descrizioni varianti with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param codiceVariante the primary key of the descrizioni varianti
	* @return the descrizioni varianti that was removed
	* @throws PortalException if a descrizioni varianti with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.DescrizioniVarianti deleteDescrizioniVarianti(
		java.lang.String codiceVariante)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _descrizioniVariantiLocalService.deleteDescrizioniVarianti(codiceVariante);
	}

	/**
	* Deletes the descrizioni varianti from the database. Also notifies the appropriate model listeners.
	*
	* @param descrizioniVarianti the descrizioni varianti
	* @return the descrizioni varianti that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.DescrizioniVarianti deleteDescrizioniVarianti(
		it.bysoftware.ct.model.DescrizioniVarianti descrizioniVarianti)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _descrizioniVariantiLocalService.deleteDescrizioniVarianti(descrizioniVarianti);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _descrizioniVariantiLocalService.dynamicQuery();
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
		return _descrizioniVariantiLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.DescrizioniVariantiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _descrizioniVariantiLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.DescrizioniVariantiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _descrizioniVariantiLocalService.dynamicQuery(dynamicQuery,
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
		return _descrizioniVariantiLocalService.dynamicQueryCount(dynamicQuery);
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
		return _descrizioniVariantiLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.bysoftware.ct.model.DescrizioniVarianti fetchDescrizioniVarianti(
		java.lang.String codiceVariante)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _descrizioniVariantiLocalService.fetchDescrizioniVarianti(codiceVariante);
	}

	/**
	* Returns the descrizioni varianti with the primary key.
	*
	* @param codiceVariante the primary key of the descrizioni varianti
	* @return the descrizioni varianti
	* @throws PortalException if a descrizioni varianti with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.DescrizioniVarianti getDescrizioniVarianti(
		java.lang.String codiceVariante)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _descrizioniVariantiLocalService.getDescrizioniVarianti(codiceVariante);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _descrizioniVariantiLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the descrizioni variantis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.DescrizioniVariantiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of descrizioni variantis
	* @param end the upper bound of the range of descrizioni variantis (not inclusive)
	* @return the range of descrizioni variantis
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.bysoftware.ct.model.DescrizioniVarianti> getDescrizioniVariantis(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _descrizioniVariantiLocalService.getDescrizioniVariantis(start,
			end);
	}

	/**
	* Returns the number of descrizioni variantis.
	*
	* @return the number of descrizioni variantis
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDescrizioniVariantisCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _descrizioniVariantiLocalService.getDescrizioniVariantisCount();
	}

	/**
	* Updates the descrizioni varianti in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param descrizioniVarianti the descrizioni varianti
	* @return the descrizioni varianti that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.DescrizioniVarianti updateDescrizioniVarianti(
		it.bysoftware.ct.model.DescrizioniVarianti descrizioniVarianti)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _descrizioniVariantiLocalService.updateDescrizioniVarianti(descrizioniVarianti);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _descrizioniVariantiLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_descrizioniVariantiLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _descrizioniVariantiLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<it.bysoftware.ct.model.DescrizioniVarianti> getVarianti()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _descrizioniVariantiLocalService.getVarianti();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DescrizioniVariantiLocalService getWrappedDescrizioniVariantiLocalService() {
		return _descrizioniVariantiLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDescrizioniVariantiLocalService(
		DescrizioniVariantiLocalService descrizioniVariantiLocalService) {
		_descrizioniVariantiLocalService = descrizioniVariantiLocalService;
	}

	@Override
	public DescrizioniVariantiLocalService getWrappedService() {
		return _descrizioniVariantiLocalService;
	}

	@Override
	public void setWrappedService(
		DescrizioniVariantiLocalService descrizioniVariantiLocalService) {
		_descrizioniVariantiLocalService = descrizioniVariantiLocalService;
	}

	private DescrizioniVariantiLocalService _descrizioniVariantiLocalService;
}
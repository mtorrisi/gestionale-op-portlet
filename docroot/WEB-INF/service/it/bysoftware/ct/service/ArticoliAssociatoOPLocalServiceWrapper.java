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
 * Provides a wrapper for {@link ArticoliAssociatoOPLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ArticoliAssociatoOPLocalService
 * @generated
 */
public class ArticoliAssociatoOPLocalServiceWrapper
	implements ArticoliAssociatoOPLocalService,
		ServiceWrapper<ArticoliAssociatoOPLocalService> {
	public ArticoliAssociatoOPLocalServiceWrapper(
		ArticoliAssociatoOPLocalService articoliAssociatoOPLocalService) {
		_articoliAssociatoOPLocalService = articoliAssociatoOPLocalService;
	}

	/**
	* Adds the articoli associato o p to the database. Also notifies the appropriate model listeners.
	*
	* @param articoliAssociatoOP the articoli associato o p
	* @return the articoli associato o p that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.ArticoliAssociatoOP addArticoliAssociatoOP(
		it.bysoftware.ct.model.ArticoliAssociatoOP articoliAssociatoOP)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _articoliAssociatoOPLocalService.addArticoliAssociatoOP(articoliAssociatoOP);
	}

	/**
	* Creates a new articoli associato o p with the primary key. Does not add the articoli associato o p to the database.
	*
	* @param articoliAssociatoOPPK the primary key for the new articoli associato o p
	* @return the new articoli associato o p
	*/
	@Override
	public it.bysoftware.ct.model.ArticoliAssociatoOP createArticoliAssociatoOP(
		it.bysoftware.ct.service.persistence.ArticoliAssociatoOPPK articoliAssociatoOPPK) {
		return _articoliAssociatoOPLocalService.createArticoliAssociatoOP(articoliAssociatoOPPK);
	}

	/**
	* Deletes the articoli associato o p with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param articoliAssociatoOPPK the primary key of the articoli associato o p
	* @return the articoli associato o p that was removed
	* @throws PortalException if a articoli associato o p with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.ArticoliAssociatoOP deleteArticoliAssociatoOP(
		it.bysoftware.ct.service.persistence.ArticoliAssociatoOPPK articoliAssociatoOPPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _articoliAssociatoOPLocalService.deleteArticoliAssociatoOP(articoliAssociatoOPPK);
	}

	/**
	* Deletes the articoli associato o p from the database. Also notifies the appropriate model listeners.
	*
	* @param articoliAssociatoOP the articoli associato o p
	* @return the articoli associato o p that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.ArticoliAssociatoOP deleteArticoliAssociatoOP(
		it.bysoftware.ct.model.ArticoliAssociatoOP articoliAssociatoOP)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _articoliAssociatoOPLocalService.deleteArticoliAssociatoOP(articoliAssociatoOP);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _articoliAssociatoOPLocalService.dynamicQuery();
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
		return _articoliAssociatoOPLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.ArticoliAssociatoOPModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _articoliAssociatoOPLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.ArticoliAssociatoOPModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _articoliAssociatoOPLocalService.dynamicQuery(dynamicQuery,
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
		return _articoliAssociatoOPLocalService.dynamicQueryCount(dynamicQuery);
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
		return _articoliAssociatoOPLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.bysoftware.ct.model.ArticoliAssociatoOP fetchArticoliAssociatoOP(
		it.bysoftware.ct.service.persistence.ArticoliAssociatoOPPK articoliAssociatoOPPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _articoliAssociatoOPLocalService.fetchArticoliAssociatoOP(articoliAssociatoOPPK);
	}

	/**
	* Returns the articoli associato o p with the primary key.
	*
	* @param articoliAssociatoOPPK the primary key of the articoli associato o p
	* @return the articoli associato o p
	* @throws PortalException if a articoli associato o p with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.ArticoliAssociatoOP getArticoliAssociatoOP(
		it.bysoftware.ct.service.persistence.ArticoliAssociatoOPPK articoliAssociatoOPPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _articoliAssociatoOPLocalService.getArticoliAssociatoOP(articoliAssociatoOPPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _articoliAssociatoOPLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the articoli associato o ps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.ArticoliAssociatoOPModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of articoli associato o ps
	* @param end the upper bound of the range of articoli associato o ps (not inclusive)
	* @return the range of articoli associato o ps
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.bysoftware.ct.model.ArticoliAssociatoOP> getArticoliAssociatoOPs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _articoliAssociatoOPLocalService.getArticoliAssociatoOPs(start,
			end);
	}

	/**
	* Returns the number of articoli associato o ps.
	*
	* @return the number of articoli associato o ps
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getArticoliAssociatoOPsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _articoliAssociatoOPLocalService.getArticoliAssociatoOPsCount();
	}

	/**
	* Updates the articoli associato o p in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param articoliAssociatoOP the articoli associato o p
	* @return the articoli associato o p that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.ArticoliAssociatoOP updateArticoliAssociatoOP(
		it.bysoftware.ct.model.ArticoliAssociatoOP articoliAssociatoOP)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _articoliAssociatoOPLocalService.updateArticoliAssociatoOP(articoliAssociatoOP);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _articoliAssociatoOPLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_articoliAssociatoOPLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _articoliAssociatoOPLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ArticoliAssociatoOPLocalService getWrappedArticoliAssociatoOPLocalService() {
		return _articoliAssociatoOPLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedArticoliAssociatoOPLocalService(
		ArticoliAssociatoOPLocalService articoliAssociatoOPLocalService) {
		_articoliAssociatoOPLocalService = articoliAssociatoOPLocalService;
	}

	@Override
	public ArticoliAssociatoOPLocalService getWrappedService() {
		return _articoliAssociatoOPLocalService;
	}

	@Override
	public void setWrappedService(
		ArticoliAssociatoOPLocalService articoliAssociatoOPLocalService) {
		_articoliAssociatoOPLocalService = articoliAssociatoOPLocalService;
	}

	private ArticoliAssociatoOPLocalService _articoliAssociatoOPLocalService;
}
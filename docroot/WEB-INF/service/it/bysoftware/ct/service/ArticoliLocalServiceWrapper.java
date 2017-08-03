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
 * Provides a wrapper for {@link ArticoliLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ArticoliLocalService
 * @generated
 */
public class ArticoliLocalServiceWrapper implements ArticoliLocalService,
	ServiceWrapper<ArticoliLocalService> {
	public ArticoliLocalServiceWrapper(
		ArticoliLocalService articoliLocalService) {
		_articoliLocalService = articoliLocalService;
	}

	/**
	* Adds the articoli to the database. Also notifies the appropriate model listeners.
	*
	* @param articoli the articoli
	* @return the articoli that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.Articoli addArticoli(
		it.bysoftware.ct.model.Articoli articoli)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _articoliLocalService.addArticoli(articoli);
	}

	/**
	* Creates a new articoli with the primary key. Does not add the articoli to the database.
	*
	* @param codiceArticolo the primary key for the new articoli
	* @return the new articoli
	*/
	@Override
	public it.bysoftware.ct.model.Articoli createArticoli(
		java.lang.String codiceArticolo) {
		return _articoliLocalService.createArticoli(codiceArticolo);
	}

	/**
	* Deletes the articoli with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param codiceArticolo the primary key of the articoli
	* @return the articoli that was removed
	* @throws PortalException if a articoli with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.Articoli deleteArticoli(
		java.lang.String codiceArticolo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _articoliLocalService.deleteArticoli(codiceArticolo);
	}

	/**
	* Deletes the articoli from the database. Also notifies the appropriate model listeners.
	*
	* @param articoli the articoli
	* @return the articoli that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.Articoli deleteArticoli(
		it.bysoftware.ct.model.Articoli articoli)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _articoliLocalService.deleteArticoli(articoli);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _articoliLocalService.dynamicQuery();
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
		return _articoliLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.ArticoliModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _articoliLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.ArticoliModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _articoliLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _articoliLocalService.dynamicQueryCount(dynamicQuery);
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
		return _articoliLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.bysoftware.ct.model.Articoli fetchArticoli(
		java.lang.String codiceArticolo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _articoliLocalService.fetchArticoli(codiceArticolo);
	}

	/**
	* Returns the articoli with the primary key.
	*
	* @param codiceArticolo the primary key of the articoli
	* @return the articoli
	* @throws PortalException if a articoli with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.Articoli getArticoli(
		java.lang.String codiceArticolo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _articoliLocalService.getArticoli(codiceArticolo);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _articoliLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the articolis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.ArticoliModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of articolis
	* @param end the upper bound of the range of articolis (not inclusive)
	* @return the range of articolis
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.bysoftware.ct.model.Articoli> getArticolis(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _articoliLocalService.getArticolis(start, end);
	}

	/**
	* Returns the number of articolis.
	*
	* @return the number of articolis
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getArticolisCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _articoliLocalService.getArticolisCount();
	}

	/**
	* Updates the articoli in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param articoli the articoli
	* @return the articoli that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.Articoli updateArticoli(
		it.bysoftware.ct.model.Articoli articoli)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _articoliLocalService.updateArticoli(articoli);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _articoliLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_articoliLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _articoliLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<it.bysoftware.ct.model.Articoli> getImballaggi()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _articoliLocalService.getImballaggi();
	}

	@Override
	public int countImballaggi()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _articoliLocalService.countImballaggi();
	}

	@Override
	public java.util.List<it.bysoftware.ct.model.Articoli> getArticoli()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _articoliLocalService.getArticoli();
	}

	@Override
	public int countArticoli()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _articoliLocalService.countArticoli();
	}

	@Override
	public java.util.List<it.bysoftware.ct.model.Articoli> searchArticoli(
		java.lang.String codiceArticolo, java.lang.String descrizione,
		boolean andSearch, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _articoliLocalService.searchArticoli(codiceArticolo,
			descrizione, andSearch, start, end, orderByComparator);
	}

	@Override
	public java.util.List<it.bysoftware.ct.model.Articoli> searchImballaggi(
		java.lang.String codiceImballaggio, boolean andSearch, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _articoliLocalService.searchImballaggi(codiceImballaggio,
			andSearch, start, end, orderByComparator);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ArticoliLocalService getWrappedArticoliLocalService() {
		return _articoliLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedArticoliLocalService(
		ArticoliLocalService articoliLocalService) {
		_articoliLocalService = articoliLocalService;
	}

	@Override
	public ArticoliLocalService getWrappedService() {
		return _articoliLocalService;
	}

	@Override
	public void setWrappedService(ArticoliLocalService articoliLocalService) {
		_articoliLocalService = articoliLocalService;
	}

	private ArticoliLocalService _articoliLocalService;
}
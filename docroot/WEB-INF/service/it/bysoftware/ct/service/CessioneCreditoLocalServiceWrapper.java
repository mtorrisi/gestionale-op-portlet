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
 * Provides a wrapper for {@link CessioneCreditoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CessioneCreditoLocalService
 * @generated
 */
public class CessioneCreditoLocalServiceWrapper
	implements CessioneCreditoLocalService,
		ServiceWrapper<CessioneCreditoLocalService> {
	public CessioneCreditoLocalServiceWrapper(
		CessioneCreditoLocalService cessioneCreditoLocalService) {
		_cessioneCreditoLocalService = cessioneCreditoLocalService;
	}

	/**
	* Adds the cessione credito to the database. Also notifies the appropriate model listeners.
	*
	* @param cessioneCredito the cessione credito
	* @return the cessione credito that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.CessioneCredito addCessioneCredito(
		it.bysoftware.ct.model.CessioneCredito cessioneCredito)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cessioneCreditoLocalService.addCessioneCredito(cessioneCredito);
	}

	/**
	* Creates a new cessione credito with the primary key. Does not add the cessione credito to the database.
	*
	* @param id the primary key for the new cessione credito
	* @return the new cessione credito
	*/
	@Override
	public it.bysoftware.ct.model.CessioneCredito createCessioneCredito(long id) {
		return _cessioneCreditoLocalService.createCessioneCredito(id);
	}

	/**
	* Deletes the cessione credito with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the cessione credito
	* @return the cessione credito that was removed
	* @throws PortalException if a cessione credito with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.CessioneCredito deleteCessioneCredito(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cessioneCreditoLocalService.deleteCessioneCredito(id);
	}

	/**
	* Deletes the cessione credito from the database. Also notifies the appropriate model listeners.
	*
	* @param cessioneCredito the cessione credito
	* @return the cessione credito that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.CessioneCredito deleteCessioneCredito(
		it.bysoftware.ct.model.CessioneCredito cessioneCredito)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cessioneCreditoLocalService.deleteCessioneCredito(cessioneCredito);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cessioneCreditoLocalService.dynamicQuery();
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
		return _cessioneCreditoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.CessioneCreditoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _cessioneCreditoLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.CessioneCreditoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _cessioneCreditoLocalService.dynamicQuery(dynamicQuery, start,
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
		return _cessioneCreditoLocalService.dynamicQueryCount(dynamicQuery);
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
		return _cessioneCreditoLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.bysoftware.ct.model.CessioneCredito fetchCessioneCredito(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cessioneCreditoLocalService.fetchCessioneCredito(id);
	}

	/**
	* Returns the cessione credito with the primary key.
	*
	* @param id the primary key of the cessione credito
	* @return the cessione credito
	* @throws PortalException if a cessione credito with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.CessioneCredito getCessioneCredito(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cessioneCreditoLocalService.getCessioneCredito(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cessioneCreditoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the cessione creditos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.CessioneCreditoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cessione creditos
	* @param end the upper bound of the range of cessione creditos (not inclusive)
	* @return the range of cessione creditos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.bysoftware.ct.model.CessioneCredito> getCessioneCreditos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cessioneCreditoLocalService.getCessioneCreditos(start, end);
	}

	/**
	* Returns the number of cessione creditos.
	*
	* @return the number of cessione creditos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCessioneCreditosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cessioneCreditoLocalService.getCessioneCreditosCount();
	}

	/**
	* Updates the cessione credito in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cessioneCredito the cessione credito
	* @return the cessione credito that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.CessioneCredito updateCessioneCredito(
		it.bysoftware.ct.model.CessioneCredito cessioneCredito)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cessioneCreditoLocalService.updateCessioneCredito(cessioneCredito);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _cessioneCreditoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_cessioneCreditoLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _cessioneCreditoLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public it.bysoftware.ct.model.CessioneCredito getByAnnoAssociatoNumeroFattura(
		int anno, long idAssociato, int numeroFattura)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cessioneCreditoLocalService.getByAnnoAssociatoNumeroFattura(anno,
			idAssociato, numeroFattura);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CessioneCreditoLocalService getWrappedCessioneCreditoLocalService() {
		return _cessioneCreditoLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCessioneCreditoLocalService(
		CessioneCreditoLocalService cessioneCreditoLocalService) {
		_cessioneCreditoLocalService = cessioneCreditoLocalService;
	}

	@Override
	public CessioneCreditoLocalService getWrappedService() {
		return _cessioneCreditoLocalService;
	}

	@Override
	public void setWrappedService(
		CessioneCreditoLocalService cessioneCreditoLocalService) {
		_cessioneCreditoLocalService = cessioneCreditoLocalService;
	}

	private CessioneCreditoLocalService _cessioneCreditoLocalService;
}
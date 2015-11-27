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
 * Provides a wrapper for {@link VociIvaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see VociIvaLocalService
 * @generated
 */
public class VociIvaLocalServiceWrapper implements VociIvaLocalService,
	ServiceWrapper<VociIvaLocalService> {
	public VociIvaLocalServiceWrapper(VociIvaLocalService vociIvaLocalService) {
		_vociIvaLocalService = vociIvaLocalService;
	}

	/**
	* Adds the voci iva to the database. Also notifies the appropriate model listeners.
	*
	* @param vociIva the voci iva
	* @return the voci iva that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.VociIva addVociIva(
		it.bysoftware.ct.model.VociIva vociIva)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vociIvaLocalService.addVociIva(vociIva);
	}

	/**
	* Creates a new voci iva with the primary key. Does not add the voci iva to the database.
	*
	* @param codiceIva the primary key for the new voci iva
	* @return the new voci iva
	*/
	@Override
	public it.bysoftware.ct.model.VociIva createVociIva(
		java.lang.String codiceIva) {
		return _vociIvaLocalService.createVociIva(codiceIva);
	}

	/**
	* Deletes the voci iva with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param codiceIva the primary key of the voci iva
	* @return the voci iva that was removed
	* @throws PortalException if a voci iva with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.VociIva deleteVociIva(
		java.lang.String codiceIva)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vociIvaLocalService.deleteVociIva(codiceIva);
	}

	/**
	* Deletes the voci iva from the database. Also notifies the appropriate model listeners.
	*
	* @param vociIva the voci iva
	* @return the voci iva that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.VociIva deleteVociIva(
		it.bysoftware.ct.model.VociIva vociIva)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vociIvaLocalService.deleteVociIva(vociIva);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _vociIvaLocalService.dynamicQuery();
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
		return _vociIvaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.VociIvaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vociIvaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.VociIvaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vociIvaLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _vociIvaLocalService.dynamicQueryCount(dynamicQuery);
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
		return _vociIvaLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.bysoftware.ct.model.VociIva fetchVociIva(
		java.lang.String codiceIva)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vociIvaLocalService.fetchVociIva(codiceIva);
	}

	/**
	* Returns the voci iva with the primary key.
	*
	* @param codiceIva the primary key of the voci iva
	* @return the voci iva
	* @throws PortalException if a voci iva with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.VociIva getVociIva(java.lang.String codiceIva)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vociIvaLocalService.getVociIva(codiceIva);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vociIvaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the voci ivas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.VociIvaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of voci ivas
	* @param end the upper bound of the range of voci ivas (not inclusive)
	* @return the range of voci ivas
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.bysoftware.ct.model.VociIva> getVociIvas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vociIvaLocalService.getVociIvas(start, end);
	}

	/**
	* Returns the number of voci ivas.
	*
	* @return the number of voci ivas
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVociIvasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vociIvaLocalService.getVociIvasCount();
	}

	/**
	* Updates the voci iva in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vociIva the voci iva
	* @return the voci iva that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.VociIva updateVociIva(
		it.bysoftware.ct.model.VociIva vociIva)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vociIvaLocalService.updateVociIva(vociIva);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _vociIvaLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vociIvaLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _vociIvaLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VociIvaLocalService getWrappedVociIvaLocalService() {
		return _vociIvaLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVociIvaLocalService(
		VociIvaLocalService vociIvaLocalService) {
		_vociIvaLocalService = vociIvaLocalService;
	}

	@Override
	public VociIvaLocalService getWrappedService() {
		return _vociIvaLocalService;
	}

	@Override
	public void setWrappedService(VociIvaLocalService vociIvaLocalService) {
		_vociIvaLocalService = vociIvaLocalService;
	}

	private VociIvaLocalService _vociIvaLocalService;
}
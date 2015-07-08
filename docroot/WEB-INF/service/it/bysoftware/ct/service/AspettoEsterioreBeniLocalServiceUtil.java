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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for AspettoEsterioreBeni. This utility wraps
 * {@link it.bysoftware.ct.service.impl.AspettoEsterioreBeniLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AspettoEsterioreBeniLocalService
 * @see it.bysoftware.ct.service.base.AspettoEsterioreBeniLocalServiceBaseImpl
 * @see it.bysoftware.ct.service.impl.AspettoEsterioreBeniLocalServiceImpl
 * @generated
 */
public class AspettoEsterioreBeniLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.bysoftware.ct.service.impl.AspettoEsterioreBeniLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the aspetto esteriore beni to the database. Also notifies the appropriate model listeners.
	*
	* @param aspettoEsterioreBeni the aspetto esteriore beni
	* @return the aspetto esteriore beni that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.AspettoEsterioreBeni addAspettoEsterioreBeni(
		it.bysoftware.ct.model.AspettoEsterioreBeni aspettoEsterioreBeni)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addAspettoEsterioreBeni(aspettoEsterioreBeni);
	}

	/**
	* Creates a new aspetto esteriore beni with the primary key. Does not add the aspetto esteriore beni to the database.
	*
	* @param codiceAspettoEsteriore the primary key for the new aspetto esteriore beni
	* @return the new aspetto esteriore beni
	*/
	public static it.bysoftware.ct.model.AspettoEsterioreBeni createAspettoEsterioreBeni(
		java.lang.String codiceAspettoEsteriore) {
		return getService().createAspettoEsterioreBeni(codiceAspettoEsteriore);
	}

	/**
	* Deletes the aspetto esteriore beni with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param codiceAspettoEsteriore the primary key of the aspetto esteriore beni
	* @return the aspetto esteriore beni that was removed
	* @throws PortalException if a aspetto esteriore beni with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.AspettoEsterioreBeni deleteAspettoEsterioreBeni(
		java.lang.String codiceAspettoEsteriore)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAspettoEsterioreBeni(codiceAspettoEsteriore);
	}

	/**
	* Deletes the aspetto esteriore beni from the database. Also notifies the appropriate model listeners.
	*
	* @param aspettoEsterioreBeni the aspetto esteriore beni
	* @return the aspetto esteriore beni that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.AspettoEsterioreBeni deleteAspettoEsterioreBeni(
		it.bysoftware.ct.model.AspettoEsterioreBeni aspettoEsterioreBeni)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAspettoEsterioreBeni(aspettoEsterioreBeni);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AspettoEsterioreBeniModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AspettoEsterioreBeniModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static it.bysoftware.ct.model.AspettoEsterioreBeni fetchAspettoEsterioreBeni(
		java.lang.String codiceAspettoEsteriore)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAspettoEsterioreBeni(codiceAspettoEsteriore);
	}

	/**
	* Returns the aspetto esteriore beni with the primary key.
	*
	* @param codiceAspettoEsteriore the primary key of the aspetto esteriore beni
	* @return the aspetto esteriore beni
	* @throws PortalException if a aspetto esteriore beni with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.AspettoEsterioreBeni getAspettoEsterioreBeni(
		java.lang.String codiceAspettoEsteriore)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAspettoEsterioreBeni(codiceAspettoEsteriore);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the aspetto esteriore benis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AspettoEsterioreBeniModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of aspetto esteriore benis
	* @param end the upper bound of the range of aspetto esteriore benis (not inclusive)
	* @return the range of aspetto esteriore benis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.AspettoEsterioreBeni> getAspettoEsterioreBenis(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAspettoEsterioreBenis(start, end);
	}

	/**
	* Returns the number of aspetto esteriore benis.
	*
	* @return the number of aspetto esteriore benis
	* @throws SystemException if a system exception occurred
	*/
	public static int getAspettoEsterioreBenisCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAspettoEsterioreBenisCount();
	}

	/**
	* Updates the aspetto esteriore beni in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param aspettoEsterioreBeni the aspetto esteriore beni
	* @return the aspetto esteriore beni that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.AspettoEsterioreBeni updateAspettoEsterioreBeni(
		it.bysoftware.ct.model.AspettoEsterioreBeni aspettoEsterioreBeni)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAspettoEsterioreBeni(aspettoEsterioreBeni);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void clearService() {
		_service = null;
	}

	public static AspettoEsterioreBeniLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					AspettoEsterioreBeniLocalService.class.getName());

			if (invokableLocalService instanceof AspettoEsterioreBeniLocalService) {
				_service = (AspettoEsterioreBeniLocalService)invokableLocalService;
			}
			else {
				_service = new AspettoEsterioreBeniLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(AspettoEsterioreBeniLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(AspettoEsterioreBeniLocalService service) {
	}

	private static AspettoEsterioreBeniLocalService _service;
}
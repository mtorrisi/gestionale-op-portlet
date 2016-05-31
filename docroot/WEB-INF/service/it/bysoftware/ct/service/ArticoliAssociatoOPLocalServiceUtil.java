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
 * Provides the local service utility for ArticoliAssociatoOP. This utility wraps
 * {@link it.bysoftware.ct.service.impl.ArticoliAssociatoOPLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ArticoliAssociatoOPLocalService
 * @see it.bysoftware.ct.service.base.ArticoliAssociatoOPLocalServiceBaseImpl
 * @see it.bysoftware.ct.service.impl.ArticoliAssociatoOPLocalServiceImpl
 * @generated
 */
public class ArticoliAssociatoOPLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.bysoftware.ct.service.impl.ArticoliAssociatoOPLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the articoli associato o p to the database. Also notifies the appropriate model listeners.
	*
	* @param articoliAssociatoOP the articoli associato o p
	* @return the articoli associato o p that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.ArticoliAssociatoOP addArticoliAssociatoOP(
		it.bysoftware.ct.model.ArticoliAssociatoOP articoliAssociatoOP)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addArticoliAssociatoOP(articoliAssociatoOP);
	}

	/**
	* Creates a new articoli associato o p with the primary key. Does not add the articoli associato o p to the database.
	*
	* @param articoliAssociatoOPPK the primary key for the new articoli associato o p
	* @return the new articoli associato o p
	*/
	public static it.bysoftware.ct.model.ArticoliAssociatoOP createArticoliAssociatoOP(
		it.bysoftware.ct.service.persistence.ArticoliAssociatoOPPK articoliAssociatoOPPK) {
		return getService().createArticoliAssociatoOP(articoliAssociatoOPPK);
	}

	/**
	* Deletes the articoli associato o p with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param articoliAssociatoOPPK the primary key of the articoli associato o p
	* @return the articoli associato o p that was removed
	* @throws PortalException if a articoli associato o p with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.ArticoliAssociatoOP deleteArticoliAssociatoOP(
		it.bysoftware.ct.service.persistence.ArticoliAssociatoOPPK articoliAssociatoOPPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteArticoliAssociatoOP(articoliAssociatoOPPK);
	}

	/**
	* Deletes the articoli associato o p from the database. Also notifies the appropriate model listeners.
	*
	* @param articoliAssociatoOP the articoli associato o p
	* @return the articoli associato o p that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.ArticoliAssociatoOP deleteArticoliAssociatoOP(
		it.bysoftware.ct.model.ArticoliAssociatoOP articoliAssociatoOP)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteArticoliAssociatoOP(articoliAssociatoOP);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.ArticoliAssociatoOPModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.bysoftware.ct.model.ArticoliAssociatoOP fetchArticoliAssociatoOP(
		it.bysoftware.ct.service.persistence.ArticoliAssociatoOPPK articoliAssociatoOPPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchArticoliAssociatoOP(articoliAssociatoOPPK);
	}

	/**
	* Returns the articoli associato o p with the primary key.
	*
	* @param articoliAssociatoOPPK the primary key of the articoli associato o p
	* @return the articoli associato o p
	* @throws PortalException if a articoli associato o p with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.ArticoliAssociatoOP getArticoliAssociatoOP(
		it.bysoftware.ct.service.persistence.ArticoliAssociatoOPPK articoliAssociatoOPPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getArticoliAssociatoOP(articoliAssociatoOPPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<it.bysoftware.ct.model.ArticoliAssociatoOP> getArticoliAssociatoOPs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getArticoliAssociatoOPs(start, end);
	}

	/**
	* Returns the number of articoli associato o ps.
	*
	* @return the number of articoli associato o ps
	* @throws SystemException if a system exception occurred
	*/
	public static int getArticoliAssociatoOPsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getArticoliAssociatoOPsCount();
	}

	/**
	* Updates the articoli associato o p in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param articoliAssociatoOP the articoli associato o p
	* @return the articoli associato o p that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.ArticoliAssociatoOP updateArticoliAssociatoOP(
		it.bysoftware.ct.model.ArticoliAssociatoOP articoliAssociatoOP)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateArticoliAssociatoOP(articoliAssociatoOP);
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

	public static ArticoliAssociatoOPLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ArticoliAssociatoOPLocalService.class.getName());

			if (invokableLocalService instanceof ArticoliAssociatoOPLocalService) {
				_service = (ArticoliAssociatoOPLocalService)invokableLocalService;
			}
			else {
				_service = new ArticoliAssociatoOPLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ArticoliAssociatoOPLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ArticoliAssociatoOPLocalService service) {
	}

	private static ArticoliAssociatoOPLocalService _service;
}
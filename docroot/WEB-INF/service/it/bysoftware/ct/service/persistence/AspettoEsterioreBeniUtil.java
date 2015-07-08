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

package it.bysoftware.ct.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import it.bysoftware.ct.model.AspettoEsterioreBeni;

import java.util.List;

/**
 * The persistence utility for the aspetto esteriore beni service. This utility wraps {@link AspettoEsterioreBeniPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AspettoEsterioreBeniPersistence
 * @see AspettoEsterioreBeniPersistenceImpl
 * @generated
 */
public class AspettoEsterioreBeniUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(AspettoEsterioreBeni aspettoEsterioreBeni) {
		getPersistence().clearCache(aspettoEsterioreBeni);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AspettoEsterioreBeni> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AspettoEsterioreBeni> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AspettoEsterioreBeni> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static AspettoEsterioreBeni update(
		AspettoEsterioreBeni aspettoEsterioreBeni) throws SystemException {
		return getPersistence().update(aspettoEsterioreBeni);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static AspettoEsterioreBeni update(
		AspettoEsterioreBeni aspettoEsterioreBeni, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(aspettoEsterioreBeni, serviceContext);
	}

	/**
	* Caches the aspetto esteriore beni in the entity cache if it is enabled.
	*
	* @param aspettoEsterioreBeni the aspetto esteriore beni
	*/
	public static void cacheResult(
		it.bysoftware.ct.model.AspettoEsterioreBeni aspettoEsterioreBeni) {
		getPersistence().cacheResult(aspettoEsterioreBeni);
	}

	/**
	* Caches the aspetto esteriore benis in the entity cache if it is enabled.
	*
	* @param aspettoEsterioreBenis the aspetto esteriore benis
	*/
	public static void cacheResult(
		java.util.List<it.bysoftware.ct.model.AspettoEsterioreBeni> aspettoEsterioreBenis) {
		getPersistence().cacheResult(aspettoEsterioreBenis);
	}

	/**
	* Creates a new aspetto esteriore beni with the primary key. Does not add the aspetto esteriore beni to the database.
	*
	* @param codiceAspettoEsteriore the primary key for the new aspetto esteriore beni
	* @return the new aspetto esteriore beni
	*/
	public static it.bysoftware.ct.model.AspettoEsterioreBeni create(
		java.lang.String codiceAspettoEsteriore) {
		return getPersistence().create(codiceAspettoEsteriore);
	}

	/**
	* Removes the aspetto esteriore beni with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param codiceAspettoEsteriore the primary key of the aspetto esteriore beni
	* @return the aspetto esteriore beni that was removed
	* @throws it.bysoftware.ct.NoSuchAspettoEsterioreBeniException if a aspetto esteriore beni with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.AspettoEsterioreBeni remove(
		java.lang.String codiceAspettoEsteriore)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAspettoEsterioreBeniException {
		return getPersistence().remove(codiceAspettoEsteriore);
	}

	public static it.bysoftware.ct.model.AspettoEsterioreBeni updateImpl(
		it.bysoftware.ct.model.AspettoEsterioreBeni aspettoEsterioreBeni)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(aspettoEsterioreBeni);
	}

	/**
	* Returns the aspetto esteriore beni with the primary key or throws a {@link it.bysoftware.ct.NoSuchAspettoEsterioreBeniException} if it could not be found.
	*
	* @param codiceAspettoEsteriore the primary key of the aspetto esteriore beni
	* @return the aspetto esteriore beni
	* @throws it.bysoftware.ct.NoSuchAspettoEsterioreBeniException if a aspetto esteriore beni with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.AspettoEsterioreBeni findByPrimaryKey(
		java.lang.String codiceAspettoEsteriore)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAspettoEsterioreBeniException {
		return getPersistence().findByPrimaryKey(codiceAspettoEsteriore);
	}

	/**
	* Returns the aspetto esteriore beni with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param codiceAspettoEsteriore the primary key of the aspetto esteriore beni
	* @return the aspetto esteriore beni, or <code>null</code> if a aspetto esteriore beni with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.AspettoEsterioreBeni fetchByPrimaryKey(
		java.lang.String codiceAspettoEsteriore)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(codiceAspettoEsteriore);
	}

	/**
	* Returns all the aspetto esteriore benis.
	*
	* @return the aspetto esteriore benis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.AspettoEsterioreBeni> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<it.bysoftware.ct.model.AspettoEsterioreBeni> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the aspetto esteriore benis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AspettoEsterioreBeniModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of aspetto esteriore benis
	* @param end the upper bound of the range of aspetto esteriore benis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of aspetto esteriore benis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.AspettoEsterioreBeni> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the aspetto esteriore benis from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of aspetto esteriore benis.
	*
	* @return the number of aspetto esteriore benis
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AspettoEsterioreBeniPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AspettoEsterioreBeniPersistence)PortletBeanLocatorUtil.locate(it.bysoftware.ct.service.ClpSerializer.getServletContextName(),
					AspettoEsterioreBeniPersistence.class.getName());

			ReferenceRegistry.registerReference(AspettoEsterioreBeniUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(AspettoEsterioreBeniPersistence persistence) {
	}

	private static AspettoEsterioreBeniPersistence _persistence;
}
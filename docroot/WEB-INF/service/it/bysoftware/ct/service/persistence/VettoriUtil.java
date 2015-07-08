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

import it.bysoftware.ct.model.Vettori;

import java.util.List;

/**
 * The persistence utility for the vettori service. This utility wraps {@link VettoriPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VettoriPersistence
 * @see VettoriPersistenceImpl
 * @generated
 */
public class VettoriUtil {
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
	public static void clearCache(Vettori vettori) {
		getPersistence().clearCache(vettori);
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
	public static List<Vettori> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Vettori> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Vettori> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Vettori update(Vettori vettori) throws SystemException {
		return getPersistence().update(vettori);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Vettori update(Vettori vettori, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(vettori, serviceContext);
	}

	/**
	* Caches the vettori in the entity cache if it is enabled.
	*
	* @param vettori the vettori
	*/
	public static void cacheResult(it.bysoftware.ct.model.Vettori vettori) {
		getPersistence().cacheResult(vettori);
	}

	/**
	* Caches the vettoris in the entity cache if it is enabled.
	*
	* @param vettoris the vettoris
	*/
	public static void cacheResult(
		java.util.List<it.bysoftware.ct.model.Vettori> vettoris) {
		getPersistence().cacheResult(vettoris);
	}

	/**
	* Creates a new vettori with the primary key. Does not add the vettori to the database.
	*
	* @param codiceVettore the primary key for the new vettori
	* @return the new vettori
	*/
	public static it.bysoftware.ct.model.Vettori create(
		java.lang.String codiceVettore) {
		return getPersistence().create(codiceVettore);
	}

	/**
	* Removes the vettori with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param codiceVettore the primary key of the vettori
	* @return the vettori that was removed
	* @throws it.bysoftware.ct.NoSuchVettoriException if a vettori with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Vettori remove(
		java.lang.String codiceVettore)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchVettoriException {
		return getPersistence().remove(codiceVettore);
	}

	public static it.bysoftware.ct.model.Vettori updateImpl(
		it.bysoftware.ct.model.Vettori vettori)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vettori);
	}

	/**
	* Returns the vettori with the primary key or throws a {@link it.bysoftware.ct.NoSuchVettoriException} if it could not be found.
	*
	* @param codiceVettore the primary key of the vettori
	* @return the vettori
	* @throws it.bysoftware.ct.NoSuchVettoriException if a vettori with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Vettori findByPrimaryKey(
		java.lang.String codiceVettore)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchVettoriException {
		return getPersistence().findByPrimaryKey(codiceVettore);
	}

	/**
	* Returns the vettori with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param codiceVettore the primary key of the vettori
	* @return the vettori, or <code>null</code> if a vettori with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Vettori fetchByPrimaryKey(
		java.lang.String codiceVettore)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(codiceVettore);
	}

	/**
	* Returns all the vettoris.
	*
	* @return the vettoris
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.Vettori> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the vettoris.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.VettoriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vettoris
	* @param end the upper bound of the range of vettoris (not inclusive)
	* @return the range of vettoris
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.Vettori> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the vettoris.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.VettoriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vettoris
	* @param end the upper bound of the range of vettoris (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of vettoris
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.Vettori> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the vettoris from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of vettoris.
	*
	* @return the number of vettoris
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VettoriPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VettoriPersistence)PortletBeanLocatorUtil.locate(it.bysoftware.ct.service.ClpSerializer.getServletContextName(),
					VettoriPersistence.class.getName());

			ReferenceRegistry.registerReference(VettoriUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(VettoriPersistence persistence) {
	}

	private static VettoriPersistence _persistence;
}
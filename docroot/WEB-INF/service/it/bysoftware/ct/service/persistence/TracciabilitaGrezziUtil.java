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

import it.bysoftware.ct.model.TracciabilitaGrezzi;

import java.util.List;

/**
 * The persistence utility for the tracciabilita grezzi service. This utility wraps {@link TracciabilitaGrezziPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TracciabilitaGrezziPersistence
 * @see TracciabilitaGrezziPersistenceImpl
 * @generated
 */
public class TracciabilitaGrezziUtil {
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
	public static void clearCache(TracciabilitaGrezzi tracciabilitaGrezzi) {
		getPersistence().clearCache(tracciabilitaGrezzi);
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
	public static List<TracciabilitaGrezzi> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TracciabilitaGrezzi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TracciabilitaGrezzi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TracciabilitaGrezzi update(
		TracciabilitaGrezzi tracciabilitaGrezzi) throws SystemException {
		return getPersistence().update(tracciabilitaGrezzi);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TracciabilitaGrezzi update(
		TracciabilitaGrezzi tracciabilitaGrezzi, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(tracciabilitaGrezzi, serviceContext);
	}

	/**
	* Caches the tracciabilita grezzi in the entity cache if it is enabled.
	*
	* @param tracciabilitaGrezzi the tracciabilita grezzi
	*/
	public static void cacheResult(
		it.bysoftware.ct.model.TracciabilitaGrezzi tracciabilitaGrezzi) {
		getPersistence().cacheResult(tracciabilitaGrezzi);
	}

	/**
	* Caches the tracciabilita grezzis in the entity cache if it is enabled.
	*
	* @param tracciabilitaGrezzis the tracciabilita grezzis
	*/
	public static void cacheResult(
		java.util.List<it.bysoftware.ct.model.TracciabilitaGrezzi> tracciabilitaGrezzis) {
		getPersistence().cacheResult(tracciabilitaGrezzis);
	}

	/**
	* Creates a new tracciabilita grezzi with the primary key. Does not add the tracciabilita grezzi to the database.
	*
	* @param id the primary key for the new tracciabilita grezzi
	* @return the new tracciabilita grezzi
	*/
	public static it.bysoftware.ct.model.TracciabilitaGrezzi create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the tracciabilita grezzi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the tracciabilita grezzi
	* @return the tracciabilita grezzi that was removed
	* @throws it.bysoftware.ct.NoSuchTracciabilitaGrezziException if a tracciabilita grezzi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.TracciabilitaGrezzi remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTracciabilitaGrezziException {
		return getPersistence().remove(id);
	}

	public static it.bysoftware.ct.model.TracciabilitaGrezzi updateImpl(
		it.bysoftware.ct.model.TracciabilitaGrezzi tracciabilitaGrezzi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(tracciabilitaGrezzi);
	}

	/**
	* Returns the tracciabilita grezzi with the primary key or throws a {@link it.bysoftware.ct.NoSuchTracciabilitaGrezziException} if it could not be found.
	*
	* @param id the primary key of the tracciabilita grezzi
	* @return the tracciabilita grezzi
	* @throws it.bysoftware.ct.NoSuchTracciabilitaGrezziException if a tracciabilita grezzi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.TracciabilitaGrezzi findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTracciabilitaGrezziException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the tracciabilita grezzi with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the tracciabilita grezzi
	* @return the tracciabilita grezzi, or <code>null</code> if a tracciabilita grezzi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.TracciabilitaGrezzi fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the tracciabilita grezzis.
	*
	* @return the tracciabilita grezzis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.TracciabilitaGrezzi> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the tracciabilita grezzis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TracciabilitaGrezziModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tracciabilita grezzis
	* @param end the upper bound of the range of tracciabilita grezzis (not inclusive)
	* @return the range of tracciabilita grezzis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.TracciabilitaGrezzi> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tracciabilita grezzis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TracciabilitaGrezziModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tracciabilita grezzis
	* @param end the upper bound of the range of tracciabilita grezzis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tracciabilita grezzis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.TracciabilitaGrezzi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the tracciabilita grezzis from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tracciabilita grezzis.
	*
	* @return the number of tracciabilita grezzis
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TracciabilitaGrezziPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TracciabilitaGrezziPersistence)PortletBeanLocatorUtil.locate(it.bysoftware.ct.service.ClpSerializer.getServletContextName(),
					TracciabilitaGrezziPersistence.class.getName());

			ReferenceRegistry.registerReference(TracciabilitaGrezziUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TracciabilitaGrezziPersistence persistence) {
	}

	private static TracciabilitaGrezziPersistence _persistence;
}
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

import it.bysoftware.ct.model.BancheAppoggio;

import java.util.List;

/**
 * The persistence utility for the banche appoggio service. This utility wraps {@link BancheAppoggioPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BancheAppoggioPersistence
 * @see BancheAppoggioPersistenceImpl
 * @generated
 */
public class BancheAppoggioUtil {
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
	public static void clearCache(BancheAppoggio bancheAppoggio) {
		getPersistence().clearCache(bancheAppoggio);
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
	public static List<BancheAppoggio> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BancheAppoggio> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BancheAppoggio> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static BancheAppoggio update(BancheAppoggio bancheAppoggio)
		throws SystemException {
		return getPersistence().update(bancheAppoggio);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static BancheAppoggio update(BancheAppoggio bancheAppoggio,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(bancheAppoggio, serviceContext);
	}

	/**
	* Caches the banche appoggio in the entity cache if it is enabled.
	*
	* @param bancheAppoggio the banche appoggio
	*/
	public static void cacheResult(
		it.bysoftware.ct.model.BancheAppoggio bancheAppoggio) {
		getPersistence().cacheResult(bancheAppoggio);
	}

	/**
	* Caches the banche appoggios in the entity cache if it is enabled.
	*
	* @param bancheAppoggios the banche appoggios
	*/
	public static void cacheResult(
		java.util.List<it.bysoftware.ct.model.BancheAppoggio> bancheAppoggios) {
		getPersistence().cacheResult(bancheAppoggios);
	}

	/**
	* Creates a new banche appoggio with the primary key. Does not add the banche appoggio to the database.
	*
	* @param codiceBanca the primary key for the new banche appoggio
	* @return the new banche appoggio
	*/
	public static it.bysoftware.ct.model.BancheAppoggio create(
		java.lang.String codiceBanca) {
		return getPersistence().create(codiceBanca);
	}

	/**
	* Removes the banche appoggio with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param codiceBanca the primary key of the banche appoggio
	* @return the banche appoggio that was removed
	* @throws it.bysoftware.ct.NoSuchBancheAppoggioException if a banche appoggio with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.BancheAppoggio remove(
		java.lang.String codiceBanca)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchBancheAppoggioException {
		return getPersistence().remove(codiceBanca);
	}

	public static it.bysoftware.ct.model.BancheAppoggio updateImpl(
		it.bysoftware.ct.model.BancheAppoggio bancheAppoggio)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(bancheAppoggio);
	}

	/**
	* Returns the banche appoggio with the primary key or throws a {@link it.bysoftware.ct.NoSuchBancheAppoggioException} if it could not be found.
	*
	* @param codiceBanca the primary key of the banche appoggio
	* @return the banche appoggio
	* @throws it.bysoftware.ct.NoSuchBancheAppoggioException if a banche appoggio with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.BancheAppoggio findByPrimaryKey(
		java.lang.String codiceBanca)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchBancheAppoggioException {
		return getPersistence().findByPrimaryKey(codiceBanca);
	}

	/**
	* Returns the banche appoggio with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param codiceBanca the primary key of the banche appoggio
	* @return the banche appoggio, or <code>null</code> if a banche appoggio with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.BancheAppoggio fetchByPrimaryKey(
		java.lang.String codiceBanca)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(codiceBanca);
	}

	/**
	* Returns all the banche appoggios.
	*
	* @return the banche appoggios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.BancheAppoggio> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the banche appoggios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.BancheAppoggioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of banche appoggios
	* @param end the upper bound of the range of banche appoggios (not inclusive)
	* @return the range of banche appoggios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.BancheAppoggio> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the banche appoggios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.BancheAppoggioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of banche appoggios
	* @param end the upper bound of the range of banche appoggios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of banche appoggios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.BancheAppoggio> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the banche appoggios from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of banche appoggios.
	*
	* @return the number of banche appoggios
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BancheAppoggioPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BancheAppoggioPersistence)PortletBeanLocatorUtil.locate(it.bysoftware.ct.service.ClpSerializer.getServletContextName(),
					BancheAppoggioPersistence.class.getName());

			ReferenceRegistry.registerReference(BancheAppoggioUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(BancheAppoggioPersistence persistence) {
	}

	private static BancheAppoggioPersistence _persistence;
}
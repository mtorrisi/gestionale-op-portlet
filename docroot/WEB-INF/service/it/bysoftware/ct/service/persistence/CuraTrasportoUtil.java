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

import it.bysoftware.ct.model.CuraTrasporto;

import java.util.List;

/**
 * The persistence utility for the cura trasporto service. This utility wraps {@link CuraTrasportoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CuraTrasportoPersistence
 * @see CuraTrasportoPersistenceImpl
 * @generated
 */
public class CuraTrasportoUtil {
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
	public static void clearCache(CuraTrasporto curaTrasporto) {
		getPersistence().clearCache(curaTrasporto);
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
	public static List<CuraTrasporto> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CuraTrasporto> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CuraTrasporto> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CuraTrasporto update(CuraTrasporto curaTrasporto)
		throws SystemException {
		return getPersistence().update(curaTrasporto);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CuraTrasporto update(CuraTrasporto curaTrasporto,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(curaTrasporto, serviceContext);
	}

	/**
	* Caches the cura trasporto in the entity cache if it is enabled.
	*
	* @param curaTrasporto the cura trasporto
	*/
	public static void cacheResult(
		it.bysoftware.ct.model.CuraTrasporto curaTrasporto) {
		getPersistence().cacheResult(curaTrasporto);
	}

	/**
	* Caches the cura trasportos in the entity cache if it is enabled.
	*
	* @param curaTrasportos the cura trasportos
	*/
	public static void cacheResult(
		java.util.List<it.bysoftware.ct.model.CuraTrasporto> curaTrasportos) {
		getPersistence().cacheResult(curaTrasportos);
	}

	/**
	* Creates a new cura trasporto with the primary key. Does not add the cura trasporto to the database.
	*
	* @param codiceCuraTrasporto the primary key for the new cura trasporto
	* @return the new cura trasporto
	*/
	public static it.bysoftware.ct.model.CuraTrasporto create(
		java.lang.String codiceCuraTrasporto) {
		return getPersistence().create(codiceCuraTrasporto);
	}

	/**
	* Removes the cura trasporto with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param codiceCuraTrasporto the primary key of the cura trasporto
	* @return the cura trasporto that was removed
	* @throws it.bysoftware.ct.NoSuchCuraTrasportoException if a cura trasporto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.CuraTrasporto remove(
		java.lang.String codiceCuraTrasporto)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchCuraTrasportoException {
		return getPersistence().remove(codiceCuraTrasporto);
	}

	public static it.bysoftware.ct.model.CuraTrasporto updateImpl(
		it.bysoftware.ct.model.CuraTrasporto curaTrasporto)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(curaTrasporto);
	}

	/**
	* Returns the cura trasporto with the primary key or throws a {@link it.bysoftware.ct.NoSuchCuraTrasportoException} if it could not be found.
	*
	* @param codiceCuraTrasporto the primary key of the cura trasporto
	* @return the cura trasporto
	* @throws it.bysoftware.ct.NoSuchCuraTrasportoException if a cura trasporto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.CuraTrasporto findByPrimaryKey(
		java.lang.String codiceCuraTrasporto)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchCuraTrasportoException {
		return getPersistence().findByPrimaryKey(codiceCuraTrasporto);
	}

	/**
	* Returns the cura trasporto with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param codiceCuraTrasporto the primary key of the cura trasporto
	* @return the cura trasporto, or <code>null</code> if a cura trasporto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.CuraTrasporto fetchByPrimaryKey(
		java.lang.String codiceCuraTrasporto)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(codiceCuraTrasporto);
	}

	/**
	* Returns all the cura trasportos.
	*
	* @return the cura trasportos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.CuraTrasporto> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the cura trasportos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.CuraTrasportoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cura trasportos
	* @param end the upper bound of the range of cura trasportos (not inclusive)
	* @return the range of cura trasportos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.CuraTrasporto> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the cura trasportos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.CuraTrasportoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cura trasportos
	* @param end the upper bound of the range of cura trasportos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cura trasportos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.CuraTrasporto> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the cura trasportos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of cura trasportos.
	*
	* @return the number of cura trasportos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CuraTrasportoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CuraTrasportoPersistence)PortletBeanLocatorUtil.locate(it.bysoftware.ct.service.ClpSerializer.getServletContextName(),
					CuraTrasportoPersistence.class.getName());

			ReferenceRegistry.registerReference(CuraTrasportoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CuraTrasportoPersistence persistence) {
	}

	private static CuraTrasportoPersistence _persistence;
}
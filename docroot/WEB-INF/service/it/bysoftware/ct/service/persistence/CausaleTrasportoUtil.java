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

import it.bysoftware.ct.model.CausaleTrasporto;

import java.util.List;

/**
 * The persistence utility for the causale trasporto service. This utility wraps {@link CausaleTrasportoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CausaleTrasportoPersistence
 * @see CausaleTrasportoPersistenceImpl
 * @generated
 */
public class CausaleTrasportoUtil {
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
	public static void clearCache(CausaleTrasporto causaleTrasporto) {
		getPersistence().clearCache(causaleTrasporto);
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
	public static List<CausaleTrasporto> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CausaleTrasporto> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CausaleTrasporto> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CausaleTrasporto update(CausaleTrasporto causaleTrasporto)
		throws SystemException {
		return getPersistence().update(causaleTrasporto);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CausaleTrasporto update(CausaleTrasporto causaleTrasporto,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(causaleTrasporto, serviceContext);
	}

	/**
	* Caches the causale trasporto in the entity cache if it is enabled.
	*
	* @param causaleTrasporto the causale trasporto
	*/
	public static void cacheResult(
		it.bysoftware.ct.model.CausaleTrasporto causaleTrasporto) {
		getPersistence().cacheResult(causaleTrasporto);
	}

	/**
	* Caches the causale trasportos in the entity cache if it is enabled.
	*
	* @param causaleTrasportos the causale trasportos
	*/
	public static void cacheResult(
		java.util.List<it.bysoftware.ct.model.CausaleTrasporto> causaleTrasportos) {
		getPersistence().cacheResult(causaleTrasportos);
	}

	/**
	* Creates a new causale trasporto with the primary key. Does not add the causale trasporto to the database.
	*
	* @param codiceCausaleTrasporto the primary key for the new causale trasporto
	* @return the new causale trasporto
	*/
	public static it.bysoftware.ct.model.CausaleTrasporto create(
		java.lang.String codiceCausaleTrasporto) {
		return getPersistence().create(codiceCausaleTrasporto);
	}

	/**
	* Removes the causale trasporto with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param codiceCausaleTrasporto the primary key of the causale trasporto
	* @return the causale trasporto that was removed
	* @throws it.bysoftware.ct.NoSuchCausaleTrasportoException if a causale trasporto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.CausaleTrasporto remove(
		java.lang.String codiceCausaleTrasporto)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchCausaleTrasportoException {
		return getPersistence().remove(codiceCausaleTrasporto);
	}

	public static it.bysoftware.ct.model.CausaleTrasporto updateImpl(
		it.bysoftware.ct.model.CausaleTrasporto causaleTrasporto)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(causaleTrasporto);
	}

	/**
	* Returns the causale trasporto with the primary key or throws a {@link it.bysoftware.ct.NoSuchCausaleTrasportoException} if it could not be found.
	*
	* @param codiceCausaleTrasporto the primary key of the causale trasporto
	* @return the causale trasporto
	* @throws it.bysoftware.ct.NoSuchCausaleTrasportoException if a causale trasporto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.CausaleTrasporto findByPrimaryKey(
		java.lang.String codiceCausaleTrasporto)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchCausaleTrasportoException {
		return getPersistence().findByPrimaryKey(codiceCausaleTrasporto);
	}

	/**
	* Returns the causale trasporto with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param codiceCausaleTrasporto the primary key of the causale trasporto
	* @return the causale trasporto, or <code>null</code> if a causale trasporto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.CausaleTrasporto fetchByPrimaryKey(
		java.lang.String codiceCausaleTrasporto)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(codiceCausaleTrasporto);
	}

	/**
	* Returns all the causale trasportos.
	*
	* @return the causale trasportos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.CausaleTrasporto> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the causale trasportos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.CausaleTrasportoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of causale trasportos
	* @param end the upper bound of the range of causale trasportos (not inclusive)
	* @return the range of causale trasportos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.CausaleTrasporto> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the causale trasportos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.CausaleTrasportoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of causale trasportos
	* @param end the upper bound of the range of causale trasportos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of causale trasportos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.CausaleTrasporto> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the causale trasportos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of causale trasportos.
	*
	* @return the number of causale trasportos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CausaleTrasportoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CausaleTrasportoPersistence)PortletBeanLocatorUtil.locate(it.bysoftware.ct.service.ClpSerializer.getServletContextName(),
					CausaleTrasportoPersistence.class.getName());

			ReferenceRegistry.registerReference(CausaleTrasportoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CausaleTrasportoPersistence persistence) {
	}

	private static CausaleTrasportoPersistence _persistence;
}
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

import it.bysoftware.ct.model.ClientiDatiAgg;

import java.util.List;

/**
 * The persistence utility for the clienti dati agg service. This utility wraps {@link ClientiDatiAggPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClientiDatiAggPersistence
 * @see ClientiDatiAggPersistenceImpl
 * @generated
 */
public class ClientiDatiAggUtil {
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
	public static void clearCache(ClientiDatiAgg clientiDatiAgg) {
		getPersistence().clearCache(clientiDatiAgg);
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
	public static List<ClientiDatiAgg> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ClientiDatiAgg> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ClientiDatiAgg> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ClientiDatiAgg update(ClientiDatiAgg clientiDatiAgg)
		throws SystemException {
		return getPersistence().update(clientiDatiAgg);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ClientiDatiAgg update(ClientiDatiAgg clientiDatiAgg,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(clientiDatiAgg, serviceContext);
	}

	/**
	* Returns the clienti dati agg where codiceAnagrafica = &#63; or throws a {@link it.bysoftware.ct.NoSuchClientiDatiAggException} if it could not be found.
	*
	* @param codiceAnagrafica the codice anagrafica
	* @return the matching clienti dati agg
	* @throws it.bysoftware.ct.NoSuchClientiDatiAggException if a matching clienti dati agg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.ClientiDatiAgg findByCodiceAnagrafica(
		java.lang.String codiceAnagrafica)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchClientiDatiAggException {
		return getPersistence().findByCodiceAnagrafica(codiceAnagrafica);
	}

	/**
	* Returns the clienti dati agg where codiceAnagrafica = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param codiceAnagrafica the codice anagrafica
	* @return the matching clienti dati agg, or <code>null</code> if a matching clienti dati agg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.ClientiDatiAgg fetchByCodiceAnagrafica(
		java.lang.String codiceAnagrafica)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCodiceAnagrafica(codiceAnagrafica);
	}

	/**
	* Returns the clienti dati agg where codiceAnagrafica = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param codiceAnagrafica the codice anagrafica
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching clienti dati agg, or <code>null</code> if a matching clienti dati agg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.ClientiDatiAgg fetchByCodiceAnagrafica(
		java.lang.String codiceAnagrafica, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCodiceAnagrafica(codiceAnagrafica, retrieveFromCache);
	}

	/**
	* Removes the clienti dati agg where codiceAnagrafica = &#63; from the database.
	*
	* @param codiceAnagrafica the codice anagrafica
	* @return the clienti dati agg that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.ClientiDatiAgg removeByCodiceAnagrafica(
		java.lang.String codiceAnagrafica)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchClientiDatiAggException {
		return getPersistence().removeByCodiceAnagrafica(codiceAnagrafica);
	}

	/**
	* Returns the number of clienti dati aggs where codiceAnagrafica = &#63;.
	*
	* @param codiceAnagrafica the codice anagrafica
	* @return the number of matching clienti dati aggs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCodiceAnagrafica(java.lang.String codiceAnagrafica)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCodiceAnagrafica(codiceAnagrafica);
	}

	/**
	* Caches the clienti dati agg in the entity cache if it is enabled.
	*
	* @param clientiDatiAgg the clienti dati agg
	*/
	public static void cacheResult(
		it.bysoftware.ct.model.ClientiDatiAgg clientiDatiAgg) {
		getPersistence().cacheResult(clientiDatiAgg);
	}

	/**
	* Caches the clienti dati aggs in the entity cache if it is enabled.
	*
	* @param clientiDatiAggs the clienti dati aggs
	*/
	public static void cacheResult(
		java.util.List<it.bysoftware.ct.model.ClientiDatiAgg> clientiDatiAggs) {
		getPersistence().cacheResult(clientiDatiAggs);
	}

	/**
	* Creates a new clienti dati agg with the primary key. Does not add the clienti dati agg to the database.
	*
	* @param codiceAnagrafica the primary key for the new clienti dati agg
	* @return the new clienti dati agg
	*/
	public static it.bysoftware.ct.model.ClientiDatiAgg create(
		java.lang.String codiceAnagrafica) {
		return getPersistence().create(codiceAnagrafica);
	}

	/**
	* Removes the clienti dati agg with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param codiceAnagrafica the primary key of the clienti dati agg
	* @return the clienti dati agg that was removed
	* @throws it.bysoftware.ct.NoSuchClientiDatiAggException if a clienti dati agg with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.ClientiDatiAgg remove(
		java.lang.String codiceAnagrafica)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchClientiDatiAggException {
		return getPersistence().remove(codiceAnagrafica);
	}

	public static it.bysoftware.ct.model.ClientiDatiAgg updateImpl(
		it.bysoftware.ct.model.ClientiDatiAgg clientiDatiAgg)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(clientiDatiAgg);
	}

	/**
	* Returns the clienti dati agg with the primary key or throws a {@link it.bysoftware.ct.NoSuchClientiDatiAggException} if it could not be found.
	*
	* @param codiceAnagrafica the primary key of the clienti dati agg
	* @return the clienti dati agg
	* @throws it.bysoftware.ct.NoSuchClientiDatiAggException if a clienti dati agg with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.ClientiDatiAgg findByPrimaryKey(
		java.lang.String codiceAnagrafica)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchClientiDatiAggException {
		return getPersistence().findByPrimaryKey(codiceAnagrafica);
	}

	/**
	* Returns the clienti dati agg with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param codiceAnagrafica the primary key of the clienti dati agg
	* @return the clienti dati agg, or <code>null</code> if a clienti dati agg with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.ClientiDatiAgg fetchByPrimaryKey(
		java.lang.String codiceAnagrafica)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(codiceAnagrafica);
	}

	/**
	* Returns all the clienti dati aggs.
	*
	* @return the clienti dati aggs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.ClientiDatiAgg> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the clienti dati aggs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.ClientiDatiAggModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of clienti dati aggs
	* @param end the upper bound of the range of clienti dati aggs (not inclusive)
	* @return the range of clienti dati aggs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.ClientiDatiAgg> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the clienti dati aggs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.ClientiDatiAggModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of clienti dati aggs
	* @param end the upper bound of the range of clienti dati aggs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of clienti dati aggs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.ClientiDatiAgg> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the clienti dati aggs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of clienti dati aggs.
	*
	* @return the number of clienti dati aggs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ClientiDatiAggPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ClientiDatiAggPersistence)PortletBeanLocatorUtil.locate(it.bysoftware.ct.service.ClpSerializer.getServletContextName(),
					ClientiDatiAggPersistence.class.getName());

			ReferenceRegistry.registerReference(ClientiDatiAggUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ClientiDatiAggPersistence persistence) {
	}

	private static ClientiDatiAggPersistence _persistence;
}
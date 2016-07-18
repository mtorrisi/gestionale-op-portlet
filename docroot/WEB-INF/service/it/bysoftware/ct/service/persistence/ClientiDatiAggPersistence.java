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

import com.liferay.portal.service.persistence.BasePersistence;

import it.bysoftware.ct.model.ClientiDatiAgg;

/**
 * The persistence interface for the clienti dati agg service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClientiDatiAggPersistenceImpl
 * @see ClientiDatiAggUtil
 * @generated
 */
public interface ClientiDatiAggPersistence extends BasePersistence<ClientiDatiAgg> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ClientiDatiAggUtil} to access the clienti dati agg persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the clienti dati agg where codiceAnagrafica = &#63; or throws a {@link it.bysoftware.ct.NoSuchClientiDatiAggException} if it could not be found.
	*
	* @param codiceAnagrafica the codice anagrafica
	* @return the matching clienti dati agg
	* @throws it.bysoftware.ct.NoSuchClientiDatiAggException if a matching clienti dati agg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.ClientiDatiAgg findByCodiceAnagrafica(
		java.lang.String codiceAnagrafica)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchClientiDatiAggException;

	/**
	* Returns the clienti dati agg where codiceAnagrafica = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param codiceAnagrafica the codice anagrafica
	* @return the matching clienti dati agg, or <code>null</code> if a matching clienti dati agg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.ClientiDatiAgg fetchByCodiceAnagrafica(
		java.lang.String codiceAnagrafica)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the clienti dati agg where codiceAnagrafica = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param codiceAnagrafica the codice anagrafica
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching clienti dati agg, or <code>null</code> if a matching clienti dati agg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.ClientiDatiAgg fetchByCodiceAnagrafica(
		java.lang.String codiceAnagrafica, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the clienti dati agg where codiceAnagrafica = &#63; from the database.
	*
	* @param codiceAnagrafica the codice anagrafica
	* @return the clienti dati agg that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.ClientiDatiAgg removeByCodiceAnagrafica(
		java.lang.String codiceAnagrafica)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchClientiDatiAggException;

	/**
	* Returns the number of clienti dati aggs where codiceAnagrafica = &#63;.
	*
	* @param codiceAnagrafica the codice anagrafica
	* @return the number of matching clienti dati aggs
	* @throws SystemException if a system exception occurred
	*/
	public int countByCodiceAnagrafica(java.lang.String codiceAnagrafica)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the clienti dati agg in the entity cache if it is enabled.
	*
	* @param clientiDatiAgg the clienti dati agg
	*/
	public void cacheResult(
		it.bysoftware.ct.model.ClientiDatiAgg clientiDatiAgg);

	/**
	* Caches the clienti dati aggs in the entity cache if it is enabled.
	*
	* @param clientiDatiAggs the clienti dati aggs
	*/
	public void cacheResult(
		java.util.List<it.bysoftware.ct.model.ClientiDatiAgg> clientiDatiAggs);

	/**
	* Creates a new clienti dati agg with the primary key. Does not add the clienti dati agg to the database.
	*
	* @param clientiDatiAggPK the primary key for the new clienti dati agg
	* @return the new clienti dati agg
	*/
	public it.bysoftware.ct.model.ClientiDatiAgg create(
		ClientiDatiAggPK clientiDatiAggPK);

	/**
	* Removes the clienti dati agg with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param clientiDatiAggPK the primary key of the clienti dati agg
	* @return the clienti dati agg that was removed
	* @throws it.bysoftware.ct.NoSuchClientiDatiAggException if a clienti dati agg with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.ClientiDatiAgg remove(
		ClientiDatiAggPK clientiDatiAggPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchClientiDatiAggException;

	public it.bysoftware.ct.model.ClientiDatiAgg updateImpl(
		it.bysoftware.ct.model.ClientiDatiAgg clientiDatiAgg)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the clienti dati agg with the primary key or throws a {@link it.bysoftware.ct.NoSuchClientiDatiAggException} if it could not be found.
	*
	* @param clientiDatiAggPK the primary key of the clienti dati agg
	* @return the clienti dati agg
	* @throws it.bysoftware.ct.NoSuchClientiDatiAggException if a clienti dati agg with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.ClientiDatiAgg findByPrimaryKey(
		ClientiDatiAggPK clientiDatiAggPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchClientiDatiAggException;

	/**
	* Returns the clienti dati agg with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param clientiDatiAggPK the primary key of the clienti dati agg
	* @return the clienti dati agg, or <code>null</code> if a clienti dati agg with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.ClientiDatiAgg fetchByPrimaryKey(
		ClientiDatiAggPK clientiDatiAggPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the clienti dati aggs.
	*
	* @return the clienti dati aggs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.ClientiDatiAgg> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.bysoftware.ct.model.ClientiDatiAgg> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.bysoftware.ct.model.ClientiDatiAgg> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the clienti dati aggs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of clienti dati aggs.
	*
	* @return the number of clienti dati aggs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
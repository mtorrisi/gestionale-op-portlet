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

import it.bysoftware.ct.model.TracciabilitaGrezzi;

/**
 * The persistence interface for the tracciabilita grezzi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TracciabilitaGrezziPersistenceImpl
 * @see TracciabilitaGrezziUtil
 * @generated
 */
public interface TracciabilitaGrezziPersistence extends BasePersistence<TracciabilitaGrezzi> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TracciabilitaGrezziUtil} to access the tracciabilita grezzi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the tracciabilita grezzi in the entity cache if it is enabled.
	*
	* @param tracciabilitaGrezzi the tracciabilita grezzi
	*/
	public void cacheResult(
		it.bysoftware.ct.model.TracciabilitaGrezzi tracciabilitaGrezzi);

	/**
	* Caches the tracciabilita grezzis in the entity cache if it is enabled.
	*
	* @param tracciabilitaGrezzis the tracciabilita grezzis
	*/
	public void cacheResult(
		java.util.List<it.bysoftware.ct.model.TracciabilitaGrezzi> tracciabilitaGrezzis);

	/**
	* Creates a new tracciabilita grezzi with the primary key. Does not add the tracciabilita grezzi to the database.
	*
	* @param id the primary key for the new tracciabilita grezzi
	* @return the new tracciabilita grezzi
	*/
	public it.bysoftware.ct.model.TracciabilitaGrezzi create(long id);

	/**
	* Removes the tracciabilita grezzi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the tracciabilita grezzi
	* @return the tracciabilita grezzi that was removed
	* @throws it.bysoftware.ct.NoSuchTracciabilitaGrezziException if a tracciabilita grezzi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.TracciabilitaGrezzi remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTracciabilitaGrezziException;

	public it.bysoftware.ct.model.TracciabilitaGrezzi updateImpl(
		it.bysoftware.ct.model.TracciabilitaGrezzi tracciabilitaGrezzi)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tracciabilita grezzi with the primary key or throws a {@link it.bysoftware.ct.NoSuchTracciabilitaGrezziException} if it could not be found.
	*
	* @param id the primary key of the tracciabilita grezzi
	* @return the tracciabilita grezzi
	* @throws it.bysoftware.ct.NoSuchTracciabilitaGrezziException if a tracciabilita grezzi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.TracciabilitaGrezzi findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTracciabilitaGrezziException;

	/**
	* Returns the tracciabilita grezzi with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the tracciabilita grezzi
	* @return the tracciabilita grezzi, or <code>null</code> if a tracciabilita grezzi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.TracciabilitaGrezzi fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tracciabilita grezzis.
	*
	* @return the tracciabilita grezzis
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.TracciabilitaGrezzi> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.bysoftware.ct.model.TracciabilitaGrezzi> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.bysoftware.ct.model.TracciabilitaGrezzi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tracciabilita grezzis from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tracciabilita grezzis.
	*
	* @return the number of tracciabilita grezzis
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
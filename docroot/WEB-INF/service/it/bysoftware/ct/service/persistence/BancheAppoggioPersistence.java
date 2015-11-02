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

import it.bysoftware.ct.model.BancheAppoggio;

/**
 * The persistence interface for the banche appoggio service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BancheAppoggioPersistenceImpl
 * @see BancheAppoggioUtil
 * @generated
 */
public interface BancheAppoggioPersistence extends BasePersistence<BancheAppoggio> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BancheAppoggioUtil} to access the banche appoggio persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the banche appoggio in the entity cache if it is enabled.
	*
	* @param bancheAppoggio the banche appoggio
	*/
	public void cacheResult(
		it.bysoftware.ct.model.BancheAppoggio bancheAppoggio);

	/**
	* Caches the banche appoggios in the entity cache if it is enabled.
	*
	* @param bancheAppoggios the banche appoggios
	*/
	public void cacheResult(
		java.util.List<it.bysoftware.ct.model.BancheAppoggio> bancheAppoggios);

	/**
	* Creates a new banche appoggio with the primary key. Does not add the banche appoggio to the database.
	*
	* @param codiceBanca the primary key for the new banche appoggio
	* @return the new banche appoggio
	*/
	public it.bysoftware.ct.model.BancheAppoggio create(
		java.lang.String codiceBanca);

	/**
	* Removes the banche appoggio with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param codiceBanca the primary key of the banche appoggio
	* @return the banche appoggio that was removed
	* @throws it.bysoftware.ct.NoSuchBancheAppoggioException if a banche appoggio with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.BancheAppoggio remove(
		java.lang.String codiceBanca)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchBancheAppoggioException;

	public it.bysoftware.ct.model.BancheAppoggio updateImpl(
		it.bysoftware.ct.model.BancheAppoggio bancheAppoggio)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the banche appoggio with the primary key or throws a {@link it.bysoftware.ct.NoSuchBancheAppoggioException} if it could not be found.
	*
	* @param codiceBanca the primary key of the banche appoggio
	* @return the banche appoggio
	* @throws it.bysoftware.ct.NoSuchBancheAppoggioException if a banche appoggio with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.BancheAppoggio findByPrimaryKey(
		java.lang.String codiceBanca)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchBancheAppoggioException;

	/**
	* Returns the banche appoggio with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param codiceBanca the primary key of the banche appoggio
	* @return the banche appoggio, or <code>null</code> if a banche appoggio with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.BancheAppoggio fetchByPrimaryKey(
		java.lang.String codiceBanca)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the banche appoggios.
	*
	* @return the banche appoggios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.BancheAppoggio> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.bysoftware.ct.model.BancheAppoggio> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.bysoftware.ct.model.BancheAppoggio> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the banche appoggios from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of banche appoggios.
	*
	* @return the number of banche appoggios
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
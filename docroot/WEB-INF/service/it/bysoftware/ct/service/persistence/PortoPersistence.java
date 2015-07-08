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

import it.bysoftware.ct.model.Porto;

/**
 * The persistence interface for the porto service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PortoPersistenceImpl
 * @see PortoUtil
 * @generated
 */
public interface PortoPersistence extends BasePersistence<Porto> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PortoUtil} to access the porto persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the porto in the entity cache if it is enabled.
	*
	* @param porto the porto
	*/
	public void cacheResult(it.bysoftware.ct.model.Porto porto);

	/**
	* Caches the portos in the entity cache if it is enabled.
	*
	* @param portos the portos
	*/
	public void cacheResult(java.util.List<it.bysoftware.ct.model.Porto> portos);

	/**
	* Creates a new porto with the primary key. Does not add the porto to the database.
	*
	* @param codicePorto the primary key for the new porto
	* @return the new porto
	*/
	public it.bysoftware.ct.model.Porto create(java.lang.String codicePorto);

	/**
	* Removes the porto with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param codicePorto the primary key of the porto
	* @return the porto that was removed
	* @throws it.bysoftware.ct.NoSuchPortoException if a porto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Porto remove(java.lang.String codicePorto)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchPortoException;

	public it.bysoftware.ct.model.Porto updateImpl(
		it.bysoftware.ct.model.Porto porto)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the porto with the primary key or throws a {@link it.bysoftware.ct.NoSuchPortoException} if it could not be found.
	*
	* @param codicePorto the primary key of the porto
	* @return the porto
	* @throws it.bysoftware.ct.NoSuchPortoException if a porto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Porto findByPrimaryKey(
		java.lang.String codicePorto)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchPortoException;

	/**
	* Returns the porto with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param codicePorto the primary key of the porto
	* @return the porto, or <code>null</code> if a porto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Porto fetchByPrimaryKey(
		java.lang.String codicePorto)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the portos.
	*
	* @return the portos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.Porto> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the portos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.PortoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of portos
	* @param end the upper bound of the range of portos (not inclusive)
	* @return the range of portos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.Porto> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the portos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.PortoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of portos
	* @param end the upper bound of the range of portos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of portos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.Porto> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the portos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of portos.
	*
	* @return the number of portos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
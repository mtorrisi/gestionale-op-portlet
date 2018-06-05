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

import it.bysoftware.ct.model.Iva;

/**
 * The persistence interface for the iva service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IvaPersistenceImpl
 * @see IvaUtil
 * @generated
 */
public interface IvaPersistence extends BasePersistence<Iva> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link IvaUtil} to access the iva persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the iva in the entity cache if it is enabled.
	*
	* @param iva the iva
	*/
	public void cacheResult(it.bysoftware.ct.model.Iva iva);

	/**
	* Caches the ivas in the entity cache if it is enabled.
	*
	* @param ivas the ivas
	*/
	public void cacheResult(java.util.List<it.bysoftware.ct.model.Iva> ivas);

	/**
	* Creates a new iva with the primary key. Does not add the iva to the database.
	*
	* @param codiceIva the primary key for the new iva
	* @return the new iva
	*/
	public it.bysoftware.ct.model.Iva create(java.lang.String codiceIva);

	/**
	* Removes the iva with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param codiceIva the primary key of the iva
	* @return the iva that was removed
	* @throws it.bysoftware.ct.NoSuchIvaException if a iva with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Iva remove(java.lang.String codiceIva)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchIvaException;

	public it.bysoftware.ct.model.Iva updateImpl(it.bysoftware.ct.model.Iva iva)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the iva with the primary key or throws a {@link it.bysoftware.ct.NoSuchIvaException} if it could not be found.
	*
	* @param codiceIva the primary key of the iva
	* @return the iva
	* @throws it.bysoftware.ct.NoSuchIvaException if a iva with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Iva findByPrimaryKey(
		java.lang.String codiceIva)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchIvaException;

	/**
	* Returns the iva with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param codiceIva the primary key of the iva
	* @return the iva, or <code>null</code> if a iva with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Iva fetchByPrimaryKey(
		java.lang.String codiceIva)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ivas.
	*
	* @return the ivas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.Iva> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ivas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.IvaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ivas
	* @param end the upper bound of the range of ivas (not inclusive)
	* @return the range of ivas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.Iva> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ivas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.IvaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ivas
	* @param end the upper bound of the range of ivas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ivas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.Iva> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ivas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ivas.
	*
	* @return the number of ivas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
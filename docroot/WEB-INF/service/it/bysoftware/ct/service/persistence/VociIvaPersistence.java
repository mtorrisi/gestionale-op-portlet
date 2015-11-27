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

import it.bysoftware.ct.model.VociIva;

/**
 * The persistence interface for the voci iva service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VociIvaPersistenceImpl
 * @see VociIvaUtil
 * @generated
 */
public interface VociIvaPersistence extends BasePersistence<VociIva> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VociIvaUtil} to access the voci iva persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the voci iva in the entity cache if it is enabled.
	*
	* @param vociIva the voci iva
	*/
	public void cacheResult(it.bysoftware.ct.model.VociIva vociIva);

	/**
	* Caches the voci ivas in the entity cache if it is enabled.
	*
	* @param vociIvas the voci ivas
	*/
	public void cacheResult(
		java.util.List<it.bysoftware.ct.model.VociIva> vociIvas);

	/**
	* Creates a new voci iva with the primary key. Does not add the voci iva to the database.
	*
	* @param codiceIva the primary key for the new voci iva
	* @return the new voci iva
	*/
	public it.bysoftware.ct.model.VociIva create(java.lang.String codiceIva);

	/**
	* Removes the voci iva with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param codiceIva the primary key of the voci iva
	* @return the voci iva that was removed
	* @throws it.bysoftware.ct.NoSuchVociIvaException if a voci iva with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.VociIva remove(java.lang.String codiceIva)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchVociIvaException;

	public it.bysoftware.ct.model.VociIva updateImpl(
		it.bysoftware.ct.model.VociIva vociIva)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the voci iva with the primary key or throws a {@link it.bysoftware.ct.NoSuchVociIvaException} if it could not be found.
	*
	* @param codiceIva the primary key of the voci iva
	* @return the voci iva
	* @throws it.bysoftware.ct.NoSuchVociIvaException if a voci iva with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.VociIva findByPrimaryKey(
		java.lang.String codiceIva)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchVociIvaException;

	/**
	* Returns the voci iva with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param codiceIva the primary key of the voci iva
	* @return the voci iva, or <code>null</code> if a voci iva with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.VociIva fetchByPrimaryKey(
		java.lang.String codiceIva)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the voci ivas.
	*
	* @return the voci ivas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.VociIva> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the voci ivas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.VociIvaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of voci ivas
	* @param end the upper bound of the range of voci ivas (not inclusive)
	* @return the range of voci ivas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.VociIva> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the voci ivas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.VociIvaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of voci ivas
	* @param end the upper bound of the range of voci ivas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of voci ivas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.VociIva> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the voci ivas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of voci ivas.
	*
	* @return the number of voci ivas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
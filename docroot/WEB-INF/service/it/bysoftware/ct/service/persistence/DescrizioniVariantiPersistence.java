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

import it.bysoftware.ct.model.DescrizioniVarianti;

/**
 * The persistence interface for the descrizioni varianti service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DescrizioniVariantiPersistenceImpl
 * @see DescrizioniVariantiUtil
 * @generated
 */
public interface DescrizioniVariantiPersistence extends BasePersistence<DescrizioniVarianti> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DescrizioniVariantiUtil} to access the descrizioni varianti persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the descrizioni varianti in the entity cache if it is enabled.
	*
	* @param descrizioniVarianti the descrizioni varianti
	*/
	public void cacheResult(
		it.bysoftware.ct.model.DescrizioniVarianti descrizioniVarianti);

	/**
	* Caches the descrizioni variantis in the entity cache if it is enabled.
	*
	* @param descrizioniVariantis the descrizioni variantis
	*/
	public void cacheResult(
		java.util.List<it.bysoftware.ct.model.DescrizioniVarianti> descrizioniVariantis);

	/**
	* Creates a new descrizioni varianti with the primary key. Does not add the descrizioni varianti to the database.
	*
	* @param codiceVariante the primary key for the new descrizioni varianti
	* @return the new descrizioni varianti
	*/
	public it.bysoftware.ct.model.DescrizioniVarianti create(
		java.lang.String codiceVariante);

	/**
	* Removes the descrizioni varianti with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param codiceVariante the primary key of the descrizioni varianti
	* @return the descrizioni varianti that was removed
	* @throws it.bysoftware.ct.NoSuchDescrizioniVariantiException if a descrizioni varianti with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.DescrizioniVarianti remove(
		java.lang.String codiceVariante)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchDescrizioniVariantiException;

	public it.bysoftware.ct.model.DescrizioniVarianti updateImpl(
		it.bysoftware.ct.model.DescrizioniVarianti descrizioniVarianti)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the descrizioni varianti with the primary key or throws a {@link it.bysoftware.ct.NoSuchDescrizioniVariantiException} if it could not be found.
	*
	* @param codiceVariante the primary key of the descrizioni varianti
	* @return the descrizioni varianti
	* @throws it.bysoftware.ct.NoSuchDescrizioniVariantiException if a descrizioni varianti with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.DescrizioniVarianti findByPrimaryKey(
		java.lang.String codiceVariante)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchDescrizioniVariantiException;

	/**
	* Returns the descrizioni varianti with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param codiceVariante the primary key of the descrizioni varianti
	* @return the descrizioni varianti, or <code>null</code> if a descrizioni varianti with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.DescrizioniVarianti fetchByPrimaryKey(
		java.lang.String codiceVariante)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the descrizioni variantis.
	*
	* @return the descrizioni variantis
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.DescrizioniVarianti> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the descrizioni variantis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.DescrizioniVariantiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of descrizioni variantis
	* @param end the upper bound of the range of descrizioni variantis (not inclusive)
	* @return the range of descrizioni variantis
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.DescrizioniVarianti> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the descrizioni variantis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.DescrizioniVariantiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of descrizioni variantis
	* @param end the upper bound of the range of descrizioni variantis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of descrizioni variantis
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.DescrizioniVarianti> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the descrizioni variantis from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of descrizioni variantis.
	*
	* @return the number of descrizioni variantis
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
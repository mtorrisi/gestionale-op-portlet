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

import it.bysoftware.ct.model.DescrizioniDocumenti;

/**
 * The persistence interface for the descrizioni documenti service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DescrizioniDocumentiPersistenceImpl
 * @see DescrizioniDocumentiUtil
 * @generated
 */
public interface DescrizioniDocumentiPersistence extends BasePersistence<DescrizioniDocumenti> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DescrizioniDocumentiUtil} to access the descrizioni documenti persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the descrizioni documenti in the entity cache if it is enabled.
	*
	* @param descrizioniDocumenti the descrizioni documenti
	*/
	public void cacheResult(
		it.bysoftware.ct.model.DescrizioniDocumenti descrizioniDocumenti);

	/**
	* Caches the descrizioni documentis in the entity cache if it is enabled.
	*
	* @param descrizioniDocumentis the descrizioni documentis
	*/
	public void cacheResult(
		java.util.List<it.bysoftware.ct.model.DescrizioniDocumenti> descrizioniDocumentis);

	/**
	* Creates a new descrizioni documenti with the primary key. Does not add the descrizioni documenti to the database.
	*
	* @param codiceDescrizione the primary key for the new descrizioni documenti
	* @return the new descrizioni documenti
	*/
	public it.bysoftware.ct.model.DescrizioniDocumenti create(
		java.lang.String codiceDescrizione);

	/**
	* Removes the descrizioni documenti with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param codiceDescrizione the primary key of the descrizioni documenti
	* @return the descrizioni documenti that was removed
	* @throws it.bysoftware.ct.NoSuchDescrizioniDocumentiException if a descrizioni documenti with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.DescrizioniDocumenti remove(
		java.lang.String codiceDescrizione)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchDescrizioniDocumentiException;

	public it.bysoftware.ct.model.DescrizioniDocumenti updateImpl(
		it.bysoftware.ct.model.DescrizioniDocumenti descrizioniDocumenti)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the descrizioni documenti with the primary key or throws a {@link it.bysoftware.ct.NoSuchDescrizioniDocumentiException} if it could not be found.
	*
	* @param codiceDescrizione the primary key of the descrizioni documenti
	* @return the descrizioni documenti
	* @throws it.bysoftware.ct.NoSuchDescrizioniDocumentiException if a descrizioni documenti with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.DescrizioniDocumenti findByPrimaryKey(
		java.lang.String codiceDescrizione)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchDescrizioniDocumentiException;

	/**
	* Returns the descrizioni documenti with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param codiceDescrizione the primary key of the descrizioni documenti
	* @return the descrizioni documenti, or <code>null</code> if a descrizioni documenti with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.DescrizioniDocumenti fetchByPrimaryKey(
		java.lang.String codiceDescrizione)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the descrizioni documentis.
	*
	* @return the descrizioni documentis
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.DescrizioniDocumenti> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the descrizioni documentis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.DescrizioniDocumentiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of descrizioni documentis
	* @param end the upper bound of the range of descrizioni documentis (not inclusive)
	* @return the range of descrizioni documentis
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.DescrizioniDocumenti> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the descrizioni documentis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.DescrizioniDocumentiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of descrizioni documentis
	* @param end the upper bound of the range of descrizioni documentis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of descrizioni documentis
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.DescrizioniDocumenti> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the descrizioni documentis from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of descrizioni documentis.
	*
	* @return the number of descrizioni documentis
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
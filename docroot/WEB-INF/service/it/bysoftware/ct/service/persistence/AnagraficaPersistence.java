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

import it.bysoftware.ct.model.Anagrafica;

/**
 * The persistence interface for the anagrafica service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnagraficaPersistenceImpl
 * @see AnagraficaUtil
 * @generated
 */
public interface AnagraficaPersistence extends BasePersistence<Anagrafica> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnagraficaUtil} to access the anagrafica persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the anagraficas where tipoSoggetto = &#63;.
	*
	* @param tipoSoggetto the tipo soggetto
	* @return the matching anagraficas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.Anagrafica> findBytipoSoggetto(
		java.lang.String tipoSoggetto)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the anagraficas where tipoSoggetto = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AnagraficaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tipoSoggetto the tipo soggetto
	* @param start the lower bound of the range of anagraficas
	* @param end the upper bound of the range of anagraficas (not inclusive)
	* @return the range of matching anagraficas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.Anagrafica> findBytipoSoggetto(
		java.lang.String tipoSoggetto, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the anagraficas where tipoSoggetto = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AnagraficaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tipoSoggetto the tipo soggetto
	* @param start the lower bound of the range of anagraficas
	* @param end the upper bound of the range of anagraficas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching anagraficas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.Anagrafica> findBytipoSoggetto(
		java.lang.String tipoSoggetto, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first anagrafica in the ordered set where tipoSoggetto = &#63;.
	*
	* @param tipoSoggetto the tipo soggetto
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anagrafica
	* @throws it.bysoftware.ct.NoSuchAnagraficaException if a matching anagrafica could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Anagrafica findBytipoSoggetto_First(
		java.lang.String tipoSoggetto,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAnagraficaException;

	/**
	* Returns the first anagrafica in the ordered set where tipoSoggetto = &#63;.
	*
	* @param tipoSoggetto the tipo soggetto
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anagrafica, or <code>null</code> if a matching anagrafica could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Anagrafica fetchBytipoSoggetto_First(
		java.lang.String tipoSoggetto,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last anagrafica in the ordered set where tipoSoggetto = &#63;.
	*
	* @param tipoSoggetto the tipo soggetto
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anagrafica
	* @throws it.bysoftware.ct.NoSuchAnagraficaException if a matching anagrafica could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Anagrafica findBytipoSoggetto_Last(
		java.lang.String tipoSoggetto,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAnagraficaException;

	/**
	* Returns the last anagrafica in the ordered set where tipoSoggetto = &#63;.
	*
	* @param tipoSoggetto the tipo soggetto
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anagrafica, or <code>null</code> if a matching anagrafica could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Anagrafica fetchBytipoSoggetto_Last(
		java.lang.String tipoSoggetto,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the anagraficas before and after the current anagrafica in the ordered set where tipoSoggetto = &#63;.
	*
	* @param codiceAnagrafica the primary key of the current anagrafica
	* @param tipoSoggetto the tipo soggetto
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next anagrafica
	* @throws it.bysoftware.ct.NoSuchAnagraficaException if a anagrafica with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Anagrafica[] findBytipoSoggetto_PrevAndNext(
		java.lang.String codiceAnagrafica, java.lang.String tipoSoggetto,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAnagraficaException;

	/**
	* Removes all the anagraficas where tipoSoggetto = &#63; from the database.
	*
	* @param tipoSoggetto the tipo soggetto
	* @throws SystemException if a system exception occurred
	*/
	public void removeBytipoSoggetto(java.lang.String tipoSoggetto)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of anagraficas where tipoSoggetto = &#63;.
	*
	* @param tipoSoggetto the tipo soggetto
	* @return the number of matching anagraficas
	* @throws SystemException if a system exception occurred
	*/
	public int countBytipoSoggetto(java.lang.String tipoSoggetto)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the anagrafica in the entity cache if it is enabled.
	*
	* @param anagrafica the anagrafica
	*/
	public void cacheResult(it.bysoftware.ct.model.Anagrafica anagrafica);

	/**
	* Caches the anagraficas in the entity cache if it is enabled.
	*
	* @param anagraficas the anagraficas
	*/
	public void cacheResult(
		java.util.List<it.bysoftware.ct.model.Anagrafica> anagraficas);

	/**
	* Creates a new anagrafica with the primary key. Does not add the anagrafica to the database.
	*
	* @param codiceAnagrafica the primary key for the new anagrafica
	* @return the new anagrafica
	*/
	public it.bysoftware.ct.model.Anagrafica create(
		java.lang.String codiceAnagrafica);

	/**
	* Removes the anagrafica with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param codiceAnagrafica the primary key of the anagrafica
	* @return the anagrafica that was removed
	* @throws it.bysoftware.ct.NoSuchAnagraficaException if a anagrafica with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Anagrafica remove(
		java.lang.String codiceAnagrafica)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAnagraficaException;

	public it.bysoftware.ct.model.Anagrafica updateImpl(
		it.bysoftware.ct.model.Anagrafica anagrafica)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the anagrafica with the primary key or throws a {@link it.bysoftware.ct.NoSuchAnagraficaException} if it could not be found.
	*
	* @param codiceAnagrafica the primary key of the anagrafica
	* @return the anagrafica
	* @throws it.bysoftware.ct.NoSuchAnagraficaException if a anagrafica with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Anagrafica findByPrimaryKey(
		java.lang.String codiceAnagrafica)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAnagraficaException;

	/**
	* Returns the anagrafica with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param codiceAnagrafica the primary key of the anagrafica
	* @return the anagrafica, or <code>null</code> if a anagrafica with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Anagrafica fetchByPrimaryKey(
		java.lang.String codiceAnagrafica)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the anagraficas.
	*
	* @return the anagraficas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.Anagrafica> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the anagraficas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AnagraficaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of anagraficas
	* @param end the upper bound of the range of anagraficas (not inclusive)
	* @return the range of anagraficas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.Anagrafica> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the anagraficas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AnagraficaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of anagraficas
	* @param end the upper bound of the range of anagraficas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of anagraficas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.Anagrafica> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the anagraficas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of anagraficas.
	*
	* @return the number of anagraficas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
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

import it.bysoftware.ct.model.OrganizzazioneProduttori;

/**
 * The persistence interface for the organizzazione produttori service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizzazioneProduttoriPersistenceImpl
 * @see OrganizzazioneProduttoriUtil
 * @generated
 */
public interface OrganizzazioneProduttoriPersistence extends BasePersistence<OrganizzazioneProduttori> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OrganizzazioneProduttoriUtil} to access the organizzazione produttori persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the organizzazione produttoris where ragioneSociale LIKE &#63;.
	*
	* @param ragioneSociale the ragione sociale
	* @return the matching organizzazione produttoris
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.OrganizzazioneProduttori> findByRagioneSociale(
		java.lang.String ragioneSociale)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the organizzazione produttoris where ragioneSociale LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.OrganizzazioneProduttoriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ragioneSociale the ragione sociale
	* @param start the lower bound of the range of organizzazione produttoris
	* @param end the upper bound of the range of organizzazione produttoris (not inclusive)
	* @return the range of matching organizzazione produttoris
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.OrganizzazioneProduttori> findByRagioneSociale(
		java.lang.String ragioneSociale, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the organizzazione produttoris where ragioneSociale LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.OrganizzazioneProduttoriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ragioneSociale the ragione sociale
	* @param start the lower bound of the range of organizzazione produttoris
	* @param end the upper bound of the range of organizzazione produttoris (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching organizzazione produttoris
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.OrganizzazioneProduttori> findByRagioneSociale(
		java.lang.String ragioneSociale, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first organizzazione produttori in the ordered set where ragioneSociale LIKE &#63;.
	*
	* @param ragioneSociale the ragione sociale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching organizzazione produttori
	* @throws it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException if a matching organizzazione produttori could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.OrganizzazioneProduttori findByRagioneSociale_First(
		java.lang.String ragioneSociale,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException;

	/**
	* Returns the first organizzazione produttori in the ordered set where ragioneSociale LIKE &#63;.
	*
	* @param ragioneSociale the ragione sociale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching organizzazione produttori, or <code>null</code> if a matching organizzazione produttori could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.OrganizzazioneProduttori fetchByRagioneSociale_First(
		java.lang.String ragioneSociale,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last organizzazione produttori in the ordered set where ragioneSociale LIKE &#63;.
	*
	* @param ragioneSociale the ragione sociale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching organizzazione produttori
	* @throws it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException if a matching organizzazione produttori could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.OrganizzazioneProduttori findByRagioneSociale_Last(
		java.lang.String ragioneSociale,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException;

	/**
	* Returns the last organizzazione produttori in the ordered set where ragioneSociale LIKE &#63;.
	*
	* @param ragioneSociale the ragione sociale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching organizzazione produttori, or <code>null</code> if a matching organizzazione produttori could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.OrganizzazioneProduttori fetchByRagioneSociale_Last(
		java.lang.String ragioneSociale,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the organizzazione produttoris before and after the current organizzazione produttori in the ordered set where ragioneSociale LIKE &#63;.
	*
	* @param id the primary key of the current organizzazione produttori
	* @param ragioneSociale the ragione sociale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next organizzazione produttori
	* @throws it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException if a organizzazione produttori with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.OrganizzazioneProduttori[] findByRagioneSociale_PrevAndNext(
		long id, java.lang.String ragioneSociale,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException;

	/**
	* Removes all the organizzazione produttoris where ragioneSociale LIKE &#63; from the database.
	*
	* @param ragioneSociale the ragione sociale
	* @throws SystemException if a system exception occurred
	*/
	public void removeByRagioneSociale(java.lang.String ragioneSociale)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of organizzazione produttoris where ragioneSociale LIKE &#63;.
	*
	* @param ragioneSociale the ragione sociale
	* @return the number of matching organizzazione produttoris
	* @throws SystemException if a system exception occurred
	*/
	public int countByRagioneSociale(java.lang.String ragioneSociale)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the organizzazione produttoris where partitaIVA LIKE &#63;.
	*
	* @param partitaIVA the partita i v a
	* @return the matching organizzazione produttoris
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.OrganizzazioneProduttori> findByPartitaIVA(
		java.lang.String partitaIVA)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the organizzazione produttoris where partitaIVA LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.OrganizzazioneProduttoriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param partitaIVA the partita i v a
	* @param start the lower bound of the range of organizzazione produttoris
	* @param end the upper bound of the range of organizzazione produttoris (not inclusive)
	* @return the range of matching organizzazione produttoris
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.OrganizzazioneProduttori> findByPartitaIVA(
		java.lang.String partitaIVA, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the organizzazione produttoris where partitaIVA LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.OrganizzazioneProduttoriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param partitaIVA the partita i v a
	* @param start the lower bound of the range of organizzazione produttoris
	* @param end the upper bound of the range of organizzazione produttoris (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching organizzazione produttoris
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.OrganizzazioneProduttori> findByPartitaIVA(
		java.lang.String partitaIVA, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first organizzazione produttori in the ordered set where partitaIVA LIKE &#63;.
	*
	* @param partitaIVA the partita i v a
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching organizzazione produttori
	* @throws it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException if a matching organizzazione produttori could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.OrganizzazioneProduttori findByPartitaIVA_First(
		java.lang.String partitaIVA,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException;

	/**
	* Returns the first organizzazione produttori in the ordered set where partitaIVA LIKE &#63;.
	*
	* @param partitaIVA the partita i v a
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching organizzazione produttori, or <code>null</code> if a matching organizzazione produttori could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.OrganizzazioneProduttori fetchByPartitaIVA_First(
		java.lang.String partitaIVA,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last organizzazione produttori in the ordered set where partitaIVA LIKE &#63;.
	*
	* @param partitaIVA the partita i v a
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching organizzazione produttori
	* @throws it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException if a matching organizzazione produttori could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.OrganizzazioneProduttori findByPartitaIVA_Last(
		java.lang.String partitaIVA,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException;

	/**
	* Returns the last organizzazione produttori in the ordered set where partitaIVA LIKE &#63;.
	*
	* @param partitaIVA the partita i v a
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching organizzazione produttori, or <code>null</code> if a matching organizzazione produttori could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.OrganizzazioneProduttori fetchByPartitaIVA_Last(
		java.lang.String partitaIVA,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the organizzazione produttoris before and after the current organizzazione produttori in the ordered set where partitaIVA LIKE &#63;.
	*
	* @param id the primary key of the current organizzazione produttori
	* @param partitaIVA the partita i v a
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next organizzazione produttori
	* @throws it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException if a organizzazione produttori with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.OrganizzazioneProduttori[] findByPartitaIVA_PrevAndNext(
		long id, java.lang.String partitaIVA,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException;

	/**
	* Removes all the organizzazione produttoris where partitaIVA LIKE &#63; from the database.
	*
	* @param partitaIVA the partita i v a
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPartitaIVA(java.lang.String partitaIVA)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of organizzazione produttoris where partitaIVA LIKE &#63;.
	*
	* @param partitaIVA the partita i v a
	* @return the number of matching organizzazione produttoris
	* @throws SystemException if a system exception occurred
	*/
	public int countByPartitaIVA(java.lang.String partitaIVA)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the organizzazione produttori where idLiferay = &#63; or throws a {@link it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException} if it could not be found.
	*
	* @param idLiferay the id liferay
	* @return the matching organizzazione produttori
	* @throws it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException if a matching organizzazione produttori could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.OrganizzazioneProduttori findByIdLiferay(
		long idLiferay)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException;

	/**
	* Returns the organizzazione produttori where idLiferay = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param idLiferay the id liferay
	* @return the matching organizzazione produttori, or <code>null</code> if a matching organizzazione produttori could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.OrganizzazioneProduttori fetchByIdLiferay(
		long idLiferay)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the organizzazione produttori where idLiferay = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param idLiferay the id liferay
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching organizzazione produttori, or <code>null</code> if a matching organizzazione produttori could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.OrganizzazioneProduttori fetchByIdLiferay(
		long idLiferay, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the organizzazione produttori where idLiferay = &#63; from the database.
	*
	* @param idLiferay the id liferay
	* @return the organizzazione produttori that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.OrganizzazioneProduttori removeByIdLiferay(
		long idLiferay)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException;

	/**
	* Returns the number of organizzazione produttoris where idLiferay = &#63;.
	*
	* @param idLiferay the id liferay
	* @return the number of matching organizzazione produttoris
	* @throws SystemException if a system exception occurred
	*/
	public int countByIdLiferay(long idLiferay)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the organizzazione produttori where email = &#63; or throws a {@link it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException} if it could not be found.
	*
	* @param email the email
	* @return the matching organizzazione produttori
	* @throws it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException if a matching organizzazione produttori could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.OrganizzazioneProduttori findByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException;

	/**
	* Returns the organizzazione produttori where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param email the email
	* @return the matching organizzazione produttori, or <code>null</code> if a matching organizzazione produttori could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.OrganizzazioneProduttori fetchByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the organizzazione produttori where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param email the email
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching organizzazione produttori, or <code>null</code> if a matching organizzazione produttori could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.OrganizzazioneProduttori fetchByEmail(
		java.lang.String email, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the organizzazione produttori where email = &#63; from the database.
	*
	* @param email the email
	* @return the organizzazione produttori that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.OrganizzazioneProduttori removeByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException;

	/**
	* Returns the number of organizzazione produttoris where email = &#63;.
	*
	* @param email the email
	* @return the number of matching organizzazione produttoris
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmail(java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the organizzazione produttori in the entity cache if it is enabled.
	*
	* @param organizzazioneProduttori the organizzazione produttori
	*/
	public void cacheResult(
		it.bysoftware.ct.model.OrganizzazioneProduttori organizzazioneProduttori);

	/**
	* Caches the organizzazione produttoris in the entity cache if it is enabled.
	*
	* @param organizzazioneProduttoris the organizzazione produttoris
	*/
	public void cacheResult(
		java.util.List<it.bysoftware.ct.model.OrganizzazioneProduttori> organizzazioneProduttoris);

	/**
	* Creates a new organizzazione produttori with the primary key. Does not add the organizzazione produttori to the database.
	*
	* @param id the primary key for the new organizzazione produttori
	* @return the new organizzazione produttori
	*/
	public it.bysoftware.ct.model.OrganizzazioneProduttori create(long id);

	/**
	* Removes the organizzazione produttori with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the organizzazione produttori
	* @return the organizzazione produttori that was removed
	* @throws it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException if a organizzazione produttori with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.OrganizzazioneProduttori remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException;

	public it.bysoftware.ct.model.OrganizzazioneProduttori updateImpl(
		it.bysoftware.ct.model.OrganizzazioneProduttori organizzazioneProduttori)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the organizzazione produttori with the primary key or throws a {@link it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException} if it could not be found.
	*
	* @param id the primary key of the organizzazione produttori
	* @return the organizzazione produttori
	* @throws it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException if a organizzazione produttori with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.OrganizzazioneProduttori findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException;

	/**
	* Returns the organizzazione produttori with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the organizzazione produttori
	* @return the organizzazione produttori, or <code>null</code> if a organizzazione produttori with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.OrganizzazioneProduttori fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the organizzazione produttoris.
	*
	* @return the organizzazione produttoris
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.OrganizzazioneProduttori> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the organizzazione produttoris.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.OrganizzazioneProduttoriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of organizzazione produttoris
	* @param end the upper bound of the range of organizzazione produttoris (not inclusive)
	* @return the range of organizzazione produttoris
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.OrganizzazioneProduttori> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the organizzazione produttoris.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.OrganizzazioneProduttoriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of organizzazione produttoris
	* @param end the upper bound of the range of organizzazione produttoris (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of organizzazione produttoris
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.OrganizzazioneProduttori> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the organizzazione produttoris from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of organizzazione produttoris.
	*
	* @return the number of organizzazione produttoris
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
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

import it.bysoftware.ct.model.Associato;

/**
 * The persistence interface for the associato service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssociatoPersistenceImpl
 * @see AssociatoUtil
 * @generated
 */
public interface AssociatoPersistence extends BasePersistence<Associato> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AssociatoUtil} to access the associato persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the associatos where ragioneSociale LIKE &#63;.
	*
	* @param ragioneSociale the ragione sociale
	* @return the matching associatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.Associato> findByRagioneSociale(
		java.lang.String ragioneSociale)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the associatos where ragioneSociale LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AssociatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ragioneSociale the ragione sociale
	* @param start the lower bound of the range of associatos
	* @param end the upper bound of the range of associatos (not inclusive)
	* @return the range of matching associatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.Associato> findByRagioneSociale(
		java.lang.String ragioneSociale, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the associatos where ragioneSociale LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AssociatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ragioneSociale the ragione sociale
	* @param start the lower bound of the range of associatos
	* @param end the upper bound of the range of associatos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching associatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.Associato> findByRagioneSociale(
		java.lang.String ragioneSociale, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first associato in the ordered set where ragioneSociale LIKE &#63;.
	*
	* @param ragioneSociale the ragione sociale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching associato
	* @throws it.bysoftware.ct.NoSuchAssociatoException if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Associato findByRagioneSociale_First(
		java.lang.String ragioneSociale,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAssociatoException;

	/**
	* Returns the first associato in the ordered set where ragioneSociale LIKE &#63;.
	*
	* @param ragioneSociale the ragione sociale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching associato, or <code>null</code> if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Associato fetchByRagioneSociale_First(
		java.lang.String ragioneSociale,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last associato in the ordered set where ragioneSociale LIKE &#63;.
	*
	* @param ragioneSociale the ragione sociale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching associato
	* @throws it.bysoftware.ct.NoSuchAssociatoException if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Associato findByRagioneSociale_Last(
		java.lang.String ragioneSociale,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAssociatoException;

	/**
	* Returns the last associato in the ordered set where ragioneSociale LIKE &#63;.
	*
	* @param ragioneSociale the ragione sociale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching associato, or <code>null</code> if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Associato fetchByRagioneSociale_Last(
		java.lang.String ragioneSociale,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associatos before and after the current associato in the ordered set where ragioneSociale LIKE &#63;.
	*
	* @param id the primary key of the current associato
	* @param ragioneSociale the ragione sociale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next associato
	* @throws it.bysoftware.ct.NoSuchAssociatoException if a associato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Associato[] findByRagioneSociale_PrevAndNext(
		long id, java.lang.String ragioneSociale,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAssociatoException;

	/**
	* Removes all the associatos where ragioneSociale LIKE &#63; from the database.
	*
	* @param ragioneSociale the ragione sociale
	* @throws SystemException if a system exception occurred
	*/
	public void removeByRagioneSociale(java.lang.String ragioneSociale)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of associatos where ragioneSociale LIKE &#63;.
	*
	* @param ragioneSociale the ragione sociale
	* @return the number of matching associatos
	* @throws SystemException if a system exception occurred
	*/
	public int countByRagioneSociale(java.lang.String ragioneSociale)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the associatos where partitaIVA LIKE &#63;.
	*
	* @param partitaIVA the partita i v a
	* @return the matching associatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.Associato> findByPartitaIVA(
		java.lang.String partitaIVA)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the associatos where partitaIVA LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AssociatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param partitaIVA the partita i v a
	* @param start the lower bound of the range of associatos
	* @param end the upper bound of the range of associatos (not inclusive)
	* @return the range of matching associatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.Associato> findByPartitaIVA(
		java.lang.String partitaIVA, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the associatos where partitaIVA LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AssociatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param partitaIVA the partita i v a
	* @param start the lower bound of the range of associatos
	* @param end the upper bound of the range of associatos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching associatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.Associato> findByPartitaIVA(
		java.lang.String partitaIVA, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first associato in the ordered set where partitaIVA LIKE &#63;.
	*
	* @param partitaIVA the partita i v a
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching associato
	* @throws it.bysoftware.ct.NoSuchAssociatoException if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Associato findByPartitaIVA_First(
		java.lang.String partitaIVA,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAssociatoException;

	/**
	* Returns the first associato in the ordered set where partitaIVA LIKE &#63;.
	*
	* @param partitaIVA the partita i v a
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching associato, or <code>null</code> if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Associato fetchByPartitaIVA_First(
		java.lang.String partitaIVA,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last associato in the ordered set where partitaIVA LIKE &#63;.
	*
	* @param partitaIVA the partita i v a
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching associato
	* @throws it.bysoftware.ct.NoSuchAssociatoException if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Associato findByPartitaIVA_Last(
		java.lang.String partitaIVA,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAssociatoException;

	/**
	* Returns the last associato in the ordered set where partitaIVA LIKE &#63;.
	*
	* @param partitaIVA the partita i v a
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching associato, or <code>null</code> if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Associato fetchByPartitaIVA_Last(
		java.lang.String partitaIVA,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associatos before and after the current associato in the ordered set where partitaIVA LIKE &#63;.
	*
	* @param id the primary key of the current associato
	* @param partitaIVA the partita i v a
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next associato
	* @throws it.bysoftware.ct.NoSuchAssociatoException if a associato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Associato[] findByPartitaIVA_PrevAndNext(
		long id, java.lang.String partitaIVA,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAssociatoException;

	/**
	* Removes all the associatos where partitaIVA LIKE &#63; from the database.
	*
	* @param partitaIVA the partita i v a
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPartitaIVA(java.lang.String partitaIVA)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of associatos where partitaIVA LIKE &#63;.
	*
	* @param partitaIVA the partita i v a
	* @return the number of matching associatos
	* @throws SystemException if a system exception occurred
	*/
	public int countByPartitaIVA(java.lang.String partitaIVA)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associato where centro = &#63; or throws a {@link it.bysoftware.ct.NoSuchAssociatoException} if it could not be found.
	*
	* @param centro the centro
	* @return the matching associato
	* @throws it.bysoftware.ct.NoSuchAssociatoException if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Associato findByCentro(
		java.lang.String centro)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAssociatoException;

	/**
	* Returns the associato where centro = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param centro the centro
	* @return the matching associato, or <code>null</code> if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Associato fetchByCentro(
		java.lang.String centro)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associato where centro = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param centro the centro
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching associato, or <code>null</code> if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Associato fetchByCentro(
		java.lang.String centro, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the associato where centro = &#63; from the database.
	*
	* @param centro the centro
	* @return the associato that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Associato removeByCentro(
		java.lang.String centro)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAssociatoException;

	/**
	* Returns the number of associatos where centro = &#63;.
	*
	* @param centro the centro
	* @return the number of matching associatos
	* @throws SystemException if a system exception occurred
	*/
	public int countByCentro(java.lang.String centro)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the associatos where attivo = &#63;.
	*
	* @param attivo the attivo
	* @return the matching associatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.Associato> findByAssociatiAttivi(
		boolean attivo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the associatos where attivo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AssociatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param attivo the attivo
	* @param start the lower bound of the range of associatos
	* @param end the upper bound of the range of associatos (not inclusive)
	* @return the range of matching associatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.Associato> findByAssociatiAttivi(
		boolean attivo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the associatos where attivo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AssociatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param attivo the attivo
	* @param start the lower bound of the range of associatos
	* @param end the upper bound of the range of associatos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching associatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.Associato> findByAssociatiAttivi(
		boolean attivo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first associato in the ordered set where attivo = &#63;.
	*
	* @param attivo the attivo
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching associato
	* @throws it.bysoftware.ct.NoSuchAssociatoException if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Associato findByAssociatiAttivi_First(
		boolean attivo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAssociatoException;

	/**
	* Returns the first associato in the ordered set where attivo = &#63;.
	*
	* @param attivo the attivo
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching associato, or <code>null</code> if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Associato fetchByAssociatiAttivi_First(
		boolean attivo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last associato in the ordered set where attivo = &#63;.
	*
	* @param attivo the attivo
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching associato
	* @throws it.bysoftware.ct.NoSuchAssociatoException if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Associato findByAssociatiAttivi_Last(
		boolean attivo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAssociatoException;

	/**
	* Returns the last associato in the ordered set where attivo = &#63;.
	*
	* @param attivo the attivo
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching associato, or <code>null</code> if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Associato fetchByAssociatiAttivi_Last(
		boolean attivo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associatos before and after the current associato in the ordered set where attivo = &#63;.
	*
	* @param id the primary key of the current associato
	* @param attivo the attivo
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next associato
	* @throws it.bysoftware.ct.NoSuchAssociatoException if a associato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Associato[] findByAssociatiAttivi_PrevAndNext(
		long id, boolean attivo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAssociatoException;

	/**
	* Removes all the associatos where attivo = &#63; from the database.
	*
	* @param attivo the attivo
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAssociatiAttivi(boolean attivo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of associatos where attivo = &#63;.
	*
	* @param attivo the attivo
	* @return the number of matching associatos
	* @throws SystemException if a system exception occurred
	*/
	public int countByAssociatiAttivi(boolean attivo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associato where email = &#63; or throws a {@link it.bysoftware.ct.NoSuchAssociatoException} if it could not be found.
	*
	* @param email the email
	* @return the matching associato
	* @throws it.bysoftware.ct.NoSuchAssociatoException if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Associato findByEmail(java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAssociatoException;

	/**
	* Returns the associato where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param email the email
	* @return the matching associato, or <code>null</code> if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Associato fetchByEmail(java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associato where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param email the email
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching associato, or <code>null</code> if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Associato fetchByEmail(
		java.lang.String email, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the associato where email = &#63; from the database.
	*
	* @param email the email
	* @return the associato that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Associato removeByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAssociatoException;

	/**
	* Returns the number of associatos where email = &#63;.
	*
	* @param email the email
	* @return the number of matching associatos
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmail(java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the associato in the entity cache if it is enabled.
	*
	* @param associato the associato
	*/
	public void cacheResult(it.bysoftware.ct.model.Associato associato);

	/**
	* Caches the associatos in the entity cache if it is enabled.
	*
	* @param associatos the associatos
	*/
	public void cacheResult(
		java.util.List<it.bysoftware.ct.model.Associato> associatos);

	/**
	* Creates a new associato with the primary key. Does not add the associato to the database.
	*
	* @param id the primary key for the new associato
	* @return the new associato
	*/
	public it.bysoftware.ct.model.Associato create(long id);

	/**
	* Removes the associato with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the associato
	* @return the associato that was removed
	* @throws it.bysoftware.ct.NoSuchAssociatoException if a associato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Associato remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAssociatoException;

	public it.bysoftware.ct.model.Associato updateImpl(
		it.bysoftware.ct.model.Associato associato)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the associato with the primary key or throws a {@link it.bysoftware.ct.NoSuchAssociatoException} if it could not be found.
	*
	* @param id the primary key of the associato
	* @return the associato
	* @throws it.bysoftware.ct.NoSuchAssociatoException if a associato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Associato findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAssociatoException;

	/**
	* Returns the associato with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the associato
	* @return the associato, or <code>null</code> if a associato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Associato fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the associatos.
	*
	* @return the associatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.Associato> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the associatos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AssociatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of associatos
	* @param end the upper bound of the range of associatos (not inclusive)
	* @return the range of associatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.Associato> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the associatos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AssociatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of associatos
	* @param end the upper bound of the range of associatos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of associatos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.Associato> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the associatos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of associatos.
	*
	* @return the number of associatos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
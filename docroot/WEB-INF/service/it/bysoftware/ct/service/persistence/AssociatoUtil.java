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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import it.bysoftware.ct.model.Associato;

import java.util.List;

/**
 * The persistence utility for the associato service. This utility wraps {@link AssociatoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssociatoPersistence
 * @see AssociatoPersistenceImpl
 * @generated
 */
public class AssociatoUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Associato associato) {
		getPersistence().clearCache(associato);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Associato> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Associato> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Associato> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Associato update(Associato associato)
		throws SystemException {
		return getPersistence().update(associato);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Associato update(Associato associato,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(associato, serviceContext);
	}

	/**
	* Returns the associato where idLiferay = &#63; or throws a {@link it.bysoftware.ct.NoSuchAssociatoException} if it could not be found.
	*
	* @param idLiferay the id liferay
	* @return the matching associato
	* @throws it.bysoftware.ct.NoSuchAssociatoException if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Associato findByIdLiferay(
		long idLiferay)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAssociatoException {
		return getPersistence().findByIdLiferay(idLiferay);
	}

	/**
	* Returns the associato where idLiferay = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param idLiferay the id liferay
	* @return the matching associato, or <code>null</code> if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Associato fetchByIdLiferay(
		long idLiferay)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByIdLiferay(idLiferay);
	}

	/**
	* Returns the associato where idLiferay = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param idLiferay the id liferay
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching associato, or <code>null</code> if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Associato fetchByIdLiferay(
		long idLiferay, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByIdLiferay(idLiferay, retrieveFromCache);
	}

	/**
	* Removes the associato where idLiferay = &#63; from the database.
	*
	* @param idLiferay the id liferay
	* @return the associato that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Associato removeByIdLiferay(
		long idLiferay)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAssociatoException {
		return getPersistence().removeByIdLiferay(idLiferay);
	}

	/**
	* Returns the number of associatos where idLiferay = &#63;.
	*
	* @param idLiferay the id liferay
	* @return the number of matching associatos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIdLiferay(long idLiferay)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByIdLiferay(idLiferay);
	}

	/**
	* Returns all the associatos where ragioneSociale LIKE &#63;.
	*
	* @param ragioneSociale the ragione sociale
	* @return the matching associatos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.Associato> findByRagioneSociale(
		java.lang.String ragioneSociale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRagioneSociale(ragioneSociale);
	}

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
	public static java.util.List<it.bysoftware.ct.model.Associato> findByRagioneSociale(
		java.lang.String ragioneSociale, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRagioneSociale(ragioneSociale, start, end);
	}

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
	public static java.util.List<it.bysoftware.ct.model.Associato> findByRagioneSociale(
		java.lang.String ragioneSociale, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRagioneSociale(ragioneSociale, start, end,
			orderByComparator);
	}

	/**
	* Returns the first associato in the ordered set where ragioneSociale LIKE &#63;.
	*
	* @param ragioneSociale the ragione sociale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching associato
	* @throws it.bysoftware.ct.NoSuchAssociatoException if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Associato findByRagioneSociale_First(
		java.lang.String ragioneSociale,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAssociatoException {
		return getPersistence()
				   .findByRagioneSociale_First(ragioneSociale, orderByComparator);
	}

	/**
	* Returns the first associato in the ordered set where ragioneSociale LIKE &#63;.
	*
	* @param ragioneSociale the ragione sociale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching associato, or <code>null</code> if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Associato fetchByRagioneSociale_First(
		java.lang.String ragioneSociale,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRagioneSociale_First(ragioneSociale,
			orderByComparator);
	}

	/**
	* Returns the last associato in the ordered set where ragioneSociale LIKE &#63;.
	*
	* @param ragioneSociale the ragione sociale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching associato
	* @throws it.bysoftware.ct.NoSuchAssociatoException if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Associato findByRagioneSociale_Last(
		java.lang.String ragioneSociale,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAssociatoException {
		return getPersistence()
				   .findByRagioneSociale_Last(ragioneSociale, orderByComparator);
	}

	/**
	* Returns the last associato in the ordered set where ragioneSociale LIKE &#63;.
	*
	* @param ragioneSociale the ragione sociale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching associato, or <code>null</code> if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Associato fetchByRagioneSociale_Last(
		java.lang.String ragioneSociale,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRagioneSociale_Last(ragioneSociale, orderByComparator);
	}

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
	public static it.bysoftware.ct.model.Associato[] findByRagioneSociale_PrevAndNext(
		long id, java.lang.String ragioneSociale,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAssociatoException {
		return getPersistence()
				   .findByRagioneSociale_PrevAndNext(id, ragioneSociale,
			orderByComparator);
	}

	/**
	* Removes all the associatos where ragioneSociale LIKE &#63; from the database.
	*
	* @param ragioneSociale the ragione sociale
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByRagioneSociale(java.lang.String ragioneSociale)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByRagioneSociale(ragioneSociale);
	}

	/**
	* Returns the number of associatos where ragioneSociale LIKE &#63;.
	*
	* @param ragioneSociale the ragione sociale
	* @return the number of matching associatos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRagioneSociale(java.lang.String ragioneSociale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRagioneSociale(ragioneSociale);
	}

	/**
	* Returns all the associatos where partitaIVA LIKE &#63;.
	*
	* @param partitaIVA the partita i v a
	* @return the matching associatos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.Associato> findByPartitaIVA(
		java.lang.String partitaIVA)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPartitaIVA(partitaIVA);
	}

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
	public static java.util.List<it.bysoftware.ct.model.Associato> findByPartitaIVA(
		java.lang.String partitaIVA, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPartitaIVA(partitaIVA, start, end);
	}

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
	public static java.util.List<it.bysoftware.ct.model.Associato> findByPartitaIVA(
		java.lang.String partitaIVA, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPartitaIVA(partitaIVA, start, end, orderByComparator);
	}

	/**
	* Returns the first associato in the ordered set where partitaIVA LIKE &#63;.
	*
	* @param partitaIVA the partita i v a
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching associato
	* @throws it.bysoftware.ct.NoSuchAssociatoException if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Associato findByPartitaIVA_First(
		java.lang.String partitaIVA,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAssociatoException {
		return getPersistence()
				   .findByPartitaIVA_First(partitaIVA, orderByComparator);
	}

	/**
	* Returns the first associato in the ordered set where partitaIVA LIKE &#63;.
	*
	* @param partitaIVA the partita i v a
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching associato, or <code>null</code> if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Associato fetchByPartitaIVA_First(
		java.lang.String partitaIVA,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPartitaIVA_First(partitaIVA, orderByComparator);
	}

	/**
	* Returns the last associato in the ordered set where partitaIVA LIKE &#63;.
	*
	* @param partitaIVA the partita i v a
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching associato
	* @throws it.bysoftware.ct.NoSuchAssociatoException if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Associato findByPartitaIVA_Last(
		java.lang.String partitaIVA,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAssociatoException {
		return getPersistence()
				   .findByPartitaIVA_Last(partitaIVA, orderByComparator);
	}

	/**
	* Returns the last associato in the ordered set where partitaIVA LIKE &#63;.
	*
	* @param partitaIVA the partita i v a
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching associato, or <code>null</code> if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Associato fetchByPartitaIVA_Last(
		java.lang.String partitaIVA,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPartitaIVA_Last(partitaIVA, orderByComparator);
	}

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
	public static it.bysoftware.ct.model.Associato[] findByPartitaIVA_PrevAndNext(
		long id, java.lang.String partitaIVA,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAssociatoException {
		return getPersistence()
				   .findByPartitaIVA_PrevAndNext(id, partitaIVA,
			orderByComparator);
	}

	/**
	* Removes all the associatos where partitaIVA LIKE &#63; from the database.
	*
	* @param partitaIVA the partita i v a
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPartitaIVA(java.lang.String partitaIVA)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPartitaIVA(partitaIVA);
	}

	/**
	* Returns the number of associatos where partitaIVA LIKE &#63;.
	*
	* @param partitaIVA the partita i v a
	* @return the number of matching associatos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPartitaIVA(java.lang.String partitaIVA)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPartitaIVA(partitaIVA);
	}

	/**
	* Returns the associato where centro = &#63; or throws a {@link it.bysoftware.ct.NoSuchAssociatoException} if it could not be found.
	*
	* @param centro the centro
	* @return the matching associato
	* @throws it.bysoftware.ct.NoSuchAssociatoException if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Associato findByCentro(
		java.lang.String centro)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAssociatoException {
		return getPersistence().findByCentro(centro);
	}

	/**
	* Returns the associato where centro = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param centro the centro
	* @return the matching associato, or <code>null</code> if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Associato fetchByCentro(
		java.lang.String centro)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCentro(centro);
	}

	/**
	* Returns the associato where centro = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param centro the centro
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching associato, or <code>null</code> if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Associato fetchByCentro(
		java.lang.String centro, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCentro(centro, retrieveFromCache);
	}

	/**
	* Removes the associato where centro = &#63; from the database.
	*
	* @param centro the centro
	* @return the associato that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Associato removeByCentro(
		java.lang.String centro)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAssociatoException {
		return getPersistence().removeByCentro(centro);
	}

	/**
	* Returns the number of associatos where centro = &#63;.
	*
	* @param centro the centro
	* @return the number of matching associatos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCentro(java.lang.String centro)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCentro(centro);
	}

	/**
	* Returns all the associatos where attivo = &#63; and idOp = &#63;.
	*
	* @param attivo the attivo
	* @param idOp the id op
	* @return the matching associatos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.Associato> findByAssociatiAttivi(
		boolean attivo, long idOp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAssociatiAttivi(attivo, idOp);
	}

	/**
	* Returns a range of all the associatos where attivo = &#63; and idOp = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AssociatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param attivo the attivo
	* @param idOp the id op
	* @param start the lower bound of the range of associatos
	* @param end the upper bound of the range of associatos (not inclusive)
	* @return the range of matching associatos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.Associato> findByAssociatiAttivi(
		boolean attivo, long idOp, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAssociatiAttivi(attivo, idOp, start, end);
	}

	/**
	* Returns an ordered range of all the associatos where attivo = &#63; and idOp = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AssociatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param attivo the attivo
	* @param idOp the id op
	* @param start the lower bound of the range of associatos
	* @param end the upper bound of the range of associatos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching associatos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.Associato> findByAssociatiAttivi(
		boolean attivo, long idOp, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAssociatiAttivi(attivo, idOp, start, end,
			orderByComparator);
	}

	/**
	* Returns the first associato in the ordered set where attivo = &#63; and idOp = &#63;.
	*
	* @param attivo the attivo
	* @param idOp the id op
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching associato
	* @throws it.bysoftware.ct.NoSuchAssociatoException if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Associato findByAssociatiAttivi_First(
		boolean attivo, long idOp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAssociatoException {
		return getPersistence()
				   .findByAssociatiAttivi_First(attivo, idOp, orderByComparator);
	}

	/**
	* Returns the first associato in the ordered set where attivo = &#63; and idOp = &#63;.
	*
	* @param attivo the attivo
	* @param idOp the id op
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching associato, or <code>null</code> if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Associato fetchByAssociatiAttivi_First(
		boolean attivo, long idOp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAssociatiAttivi_First(attivo, idOp, orderByComparator);
	}

	/**
	* Returns the last associato in the ordered set where attivo = &#63; and idOp = &#63;.
	*
	* @param attivo the attivo
	* @param idOp the id op
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching associato
	* @throws it.bysoftware.ct.NoSuchAssociatoException if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Associato findByAssociatiAttivi_Last(
		boolean attivo, long idOp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAssociatoException {
		return getPersistence()
				   .findByAssociatiAttivi_Last(attivo, idOp, orderByComparator);
	}

	/**
	* Returns the last associato in the ordered set where attivo = &#63; and idOp = &#63;.
	*
	* @param attivo the attivo
	* @param idOp the id op
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching associato, or <code>null</code> if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Associato fetchByAssociatiAttivi_Last(
		boolean attivo, long idOp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAssociatiAttivi_Last(attivo, idOp, orderByComparator);
	}

	/**
	* Returns the associatos before and after the current associato in the ordered set where attivo = &#63; and idOp = &#63;.
	*
	* @param id the primary key of the current associato
	* @param attivo the attivo
	* @param idOp the id op
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next associato
	* @throws it.bysoftware.ct.NoSuchAssociatoException if a associato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Associato[] findByAssociatiAttivi_PrevAndNext(
		long id, boolean attivo, long idOp,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAssociatoException {
		return getPersistence()
				   .findByAssociatiAttivi_PrevAndNext(id, attivo, idOp,
			orderByComparator);
	}

	/**
	* Removes all the associatos where attivo = &#63; and idOp = &#63; from the database.
	*
	* @param attivo the attivo
	* @param idOp the id op
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAssociatiAttivi(boolean attivo, long idOp)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAssociatiAttivi(attivo, idOp);
	}

	/**
	* Returns the number of associatos where attivo = &#63; and idOp = &#63;.
	*
	* @param attivo the attivo
	* @param idOp the id op
	* @return the number of matching associatos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAssociatiAttivi(boolean attivo, long idOp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAssociatiAttivi(attivo, idOp);
	}

	/**
	* Returns the associato where email = &#63; or throws a {@link it.bysoftware.ct.NoSuchAssociatoException} if it could not be found.
	*
	* @param email the email
	* @return the matching associato
	* @throws it.bysoftware.ct.NoSuchAssociatoException if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Associato findByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAssociatoException {
		return getPersistence().findByEmail(email);
	}

	/**
	* Returns the associato where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param email the email
	* @return the matching associato, or <code>null</code> if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Associato fetchByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEmail(email);
	}

	/**
	* Returns the associato where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param email the email
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching associato, or <code>null</code> if a matching associato could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Associato fetchByEmail(
		java.lang.String email, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEmail(email, retrieveFromCache);
	}

	/**
	* Removes the associato where email = &#63; from the database.
	*
	* @param email the email
	* @return the associato that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Associato removeByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAssociatoException {
		return getPersistence().removeByEmail(email);
	}

	/**
	* Returns the number of associatos where email = &#63;.
	*
	* @param email the email
	* @return the number of matching associatos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmail(java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEmail(email);
	}

	/**
	* Caches the associato in the entity cache if it is enabled.
	*
	* @param associato the associato
	*/
	public static void cacheResult(it.bysoftware.ct.model.Associato associato) {
		getPersistence().cacheResult(associato);
	}

	/**
	* Caches the associatos in the entity cache if it is enabled.
	*
	* @param associatos the associatos
	*/
	public static void cacheResult(
		java.util.List<it.bysoftware.ct.model.Associato> associatos) {
		getPersistence().cacheResult(associatos);
	}

	/**
	* Creates a new associato with the primary key. Does not add the associato to the database.
	*
	* @param id the primary key for the new associato
	* @return the new associato
	*/
	public static it.bysoftware.ct.model.Associato create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the associato with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the associato
	* @return the associato that was removed
	* @throws it.bysoftware.ct.NoSuchAssociatoException if a associato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Associato remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAssociatoException {
		return getPersistence().remove(id);
	}

	public static it.bysoftware.ct.model.Associato updateImpl(
		it.bysoftware.ct.model.Associato associato)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(associato);
	}

	/**
	* Returns the associato with the primary key or throws a {@link it.bysoftware.ct.NoSuchAssociatoException} if it could not be found.
	*
	* @param id the primary key of the associato
	* @return the associato
	* @throws it.bysoftware.ct.NoSuchAssociatoException if a associato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Associato findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAssociatoException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the associato with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the associato
	* @return the associato, or <code>null</code> if a associato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Associato fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the associatos.
	*
	* @return the associatos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.Associato> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<it.bysoftware.ct.model.Associato> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<it.bysoftware.ct.model.Associato> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the associatos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of associatos.
	*
	* @return the number of associatos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AssociatoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AssociatoPersistence)PortletBeanLocatorUtil.locate(it.bysoftware.ct.service.ClpSerializer.getServletContextName(),
					AssociatoPersistence.class.getName());

			ReferenceRegistry.registerReference(AssociatoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(AssociatoPersistence persistence) {
	}

	private static AssociatoPersistence _persistence;
}
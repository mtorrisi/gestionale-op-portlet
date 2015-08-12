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

import it.bysoftware.ct.model.OrganizzazioneProduttori;

import java.util.List;

/**
 * The persistence utility for the organizzazione produttori service. This utility wraps {@link OrganizzazioneProduttoriPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizzazioneProduttoriPersistence
 * @see OrganizzazioneProduttoriPersistenceImpl
 * @generated
 */
public class OrganizzazioneProduttoriUtil {
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
	public static void clearCache(
		OrganizzazioneProduttori organizzazioneProduttori) {
		getPersistence().clearCache(organizzazioneProduttori);
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
	public static List<OrganizzazioneProduttori> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OrganizzazioneProduttori> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OrganizzazioneProduttori> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static OrganizzazioneProduttori update(
		OrganizzazioneProduttori organizzazioneProduttori)
		throws SystemException {
		return getPersistence().update(organizzazioneProduttori);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static OrganizzazioneProduttori update(
		OrganizzazioneProduttori organizzazioneProduttori,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(organizzazioneProduttori, serviceContext);
	}

	/**
	* Returns all the organizzazione produttoris where ragioneSociale LIKE &#63;.
	*
	* @param ragioneSociale the ragione sociale
	* @return the matching organizzazione produttoris
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.OrganizzazioneProduttori> findByRagioneSociale(
		java.lang.String ragioneSociale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRagioneSociale(ragioneSociale);
	}

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
	public static java.util.List<it.bysoftware.ct.model.OrganizzazioneProduttori> findByRagioneSociale(
		java.lang.String ragioneSociale, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRagioneSociale(ragioneSociale, start, end);
	}

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
	public static java.util.List<it.bysoftware.ct.model.OrganizzazioneProduttori> findByRagioneSociale(
		java.lang.String ragioneSociale, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRagioneSociale(ragioneSociale, start, end,
			orderByComparator);
	}

	/**
	* Returns the first organizzazione produttori in the ordered set where ragioneSociale LIKE &#63;.
	*
	* @param ragioneSociale the ragione sociale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching organizzazione produttori
	* @throws it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException if a matching organizzazione produttori could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.OrganizzazioneProduttori findByRagioneSociale_First(
		java.lang.String ragioneSociale,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException {
		return getPersistence()
				   .findByRagioneSociale_First(ragioneSociale, orderByComparator);
	}

	/**
	* Returns the first organizzazione produttori in the ordered set where ragioneSociale LIKE &#63;.
	*
	* @param ragioneSociale the ragione sociale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching organizzazione produttori, or <code>null</code> if a matching organizzazione produttori could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.OrganizzazioneProduttori fetchByRagioneSociale_First(
		java.lang.String ragioneSociale,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRagioneSociale_First(ragioneSociale,
			orderByComparator);
	}

	/**
	* Returns the last organizzazione produttori in the ordered set where ragioneSociale LIKE &#63;.
	*
	* @param ragioneSociale the ragione sociale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching organizzazione produttori
	* @throws it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException if a matching organizzazione produttori could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.OrganizzazioneProduttori findByRagioneSociale_Last(
		java.lang.String ragioneSociale,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException {
		return getPersistence()
				   .findByRagioneSociale_Last(ragioneSociale, orderByComparator);
	}

	/**
	* Returns the last organizzazione produttori in the ordered set where ragioneSociale LIKE &#63;.
	*
	* @param ragioneSociale the ragione sociale
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching organizzazione produttori, or <code>null</code> if a matching organizzazione produttori could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.OrganizzazioneProduttori fetchByRagioneSociale_Last(
		java.lang.String ragioneSociale,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRagioneSociale_Last(ragioneSociale, orderByComparator);
	}

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
	public static it.bysoftware.ct.model.OrganizzazioneProduttori[] findByRagioneSociale_PrevAndNext(
		long id, java.lang.String ragioneSociale,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException {
		return getPersistence()
				   .findByRagioneSociale_PrevAndNext(id, ragioneSociale,
			orderByComparator);
	}

	/**
	* Removes all the organizzazione produttoris where ragioneSociale LIKE &#63; from the database.
	*
	* @param ragioneSociale the ragione sociale
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByRagioneSociale(java.lang.String ragioneSociale)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByRagioneSociale(ragioneSociale);
	}

	/**
	* Returns the number of organizzazione produttoris where ragioneSociale LIKE &#63;.
	*
	* @param ragioneSociale the ragione sociale
	* @return the number of matching organizzazione produttoris
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRagioneSociale(java.lang.String ragioneSociale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRagioneSociale(ragioneSociale);
	}

	/**
	* Returns all the organizzazione produttoris where partitaIVA LIKE &#63;.
	*
	* @param partitaIVA the partita i v a
	* @return the matching organizzazione produttoris
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.OrganizzazioneProduttori> findByPartitaIVA(
		java.lang.String partitaIVA)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPartitaIVA(partitaIVA);
	}

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
	public static java.util.List<it.bysoftware.ct.model.OrganizzazioneProduttori> findByPartitaIVA(
		java.lang.String partitaIVA, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPartitaIVA(partitaIVA, start, end);
	}

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
	public static java.util.List<it.bysoftware.ct.model.OrganizzazioneProduttori> findByPartitaIVA(
		java.lang.String partitaIVA, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPartitaIVA(partitaIVA, start, end, orderByComparator);
	}

	/**
	* Returns the first organizzazione produttori in the ordered set where partitaIVA LIKE &#63;.
	*
	* @param partitaIVA the partita i v a
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching organizzazione produttori
	* @throws it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException if a matching organizzazione produttori could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.OrganizzazioneProduttori findByPartitaIVA_First(
		java.lang.String partitaIVA,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException {
		return getPersistence()
				   .findByPartitaIVA_First(partitaIVA, orderByComparator);
	}

	/**
	* Returns the first organizzazione produttori in the ordered set where partitaIVA LIKE &#63;.
	*
	* @param partitaIVA the partita i v a
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching organizzazione produttori, or <code>null</code> if a matching organizzazione produttori could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.OrganizzazioneProduttori fetchByPartitaIVA_First(
		java.lang.String partitaIVA,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPartitaIVA_First(partitaIVA, orderByComparator);
	}

	/**
	* Returns the last organizzazione produttori in the ordered set where partitaIVA LIKE &#63;.
	*
	* @param partitaIVA the partita i v a
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching organizzazione produttori
	* @throws it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException if a matching organizzazione produttori could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.OrganizzazioneProduttori findByPartitaIVA_Last(
		java.lang.String partitaIVA,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException {
		return getPersistence()
				   .findByPartitaIVA_Last(partitaIVA, orderByComparator);
	}

	/**
	* Returns the last organizzazione produttori in the ordered set where partitaIVA LIKE &#63;.
	*
	* @param partitaIVA the partita i v a
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching organizzazione produttori, or <code>null</code> if a matching organizzazione produttori could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.OrganizzazioneProduttori fetchByPartitaIVA_Last(
		java.lang.String partitaIVA,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPartitaIVA_Last(partitaIVA, orderByComparator);
	}

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
	public static it.bysoftware.ct.model.OrganizzazioneProduttori[] findByPartitaIVA_PrevAndNext(
		long id, java.lang.String partitaIVA,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException {
		return getPersistence()
				   .findByPartitaIVA_PrevAndNext(id, partitaIVA,
			orderByComparator);
	}

	/**
	* Removes all the organizzazione produttoris where partitaIVA LIKE &#63; from the database.
	*
	* @param partitaIVA the partita i v a
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPartitaIVA(java.lang.String partitaIVA)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPartitaIVA(partitaIVA);
	}

	/**
	* Returns the number of organizzazione produttoris where partitaIVA LIKE &#63;.
	*
	* @param partitaIVA the partita i v a
	* @return the number of matching organizzazione produttoris
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPartitaIVA(java.lang.String partitaIVA)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPartitaIVA(partitaIVA);
	}

	/**
	* Returns the organizzazione produttori where idLiferay = &#63; or throws a {@link it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException} if it could not be found.
	*
	* @param idLiferay the id liferay
	* @return the matching organizzazione produttori
	* @throws it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException if a matching organizzazione produttori could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.OrganizzazioneProduttori findByIdLiferay(
		long idLiferay)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException {
		return getPersistence().findByIdLiferay(idLiferay);
	}

	/**
	* Returns the organizzazione produttori where idLiferay = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param idLiferay the id liferay
	* @return the matching organizzazione produttori, or <code>null</code> if a matching organizzazione produttori could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.OrganizzazioneProduttori fetchByIdLiferay(
		long idLiferay)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByIdLiferay(idLiferay);
	}

	/**
	* Returns the organizzazione produttori where idLiferay = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param idLiferay the id liferay
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching organizzazione produttori, or <code>null</code> if a matching organizzazione produttori could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.OrganizzazioneProduttori fetchByIdLiferay(
		long idLiferay, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByIdLiferay(idLiferay, retrieveFromCache);
	}

	/**
	* Removes the organizzazione produttori where idLiferay = &#63; from the database.
	*
	* @param idLiferay the id liferay
	* @return the organizzazione produttori that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.OrganizzazioneProduttori removeByIdLiferay(
		long idLiferay)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException {
		return getPersistence().removeByIdLiferay(idLiferay);
	}

	/**
	* Returns the number of organizzazione produttoris where idLiferay = &#63;.
	*
	* @param idLiferay the id liferay
	* @return the number of matching organizzazione produttoris
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIdLiferay(long idLiferay)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByIdLiferay(idLiferay);
	}

	/**
	* Returns the organizzazione produttori where email = &#63; or throws a {@link it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException} if it could not be found.
	*
	* @param email the email
	* @return the matching organizzazione produttori
	* @throws it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException if a matching organizzazione produttori could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.OrganizzazioneProduttori findByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException {
		return getPersistence().findByEmail(email);
	}

	/**
	* Returns the organizzazione produttori where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param email the email
	* @return the matching organizzazione produttori, or <code>null</code> if a matching organizzazione produttori could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.OrganizzazioneProduttori fetchByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEmail(email);
	}

	/**
	* Returns the organizzazione produttori where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param email the email
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching organizzazione produttori, or <code>null</code> if a matching organizzazione produttori could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.OrganizzazioneProduttori fetchByEmail(
		java.lang.String email, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEmail(email, retrieveFromCache);
	}

	/**
	* Removes the organizzazione produttori where email = &#63; from the database.
	*
	* @param email the email
	* @return the organizzazione produttori that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.OrganizzazioneProduttori removeByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException {
		return getPersistence().removeByEmail(email);
	}

	/**
	* Returns the number of organizzazione produttoris where email = &#63;.
	*
	* @param email the email
	* @return the number of matching organizzazione produttoris
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmail(java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEmail(email);
	}

	/**
	* Caches the organizzazione produttori in the entity cache if it is enabled.
	*
	* @param organizzazioneProduttori the organizzazione produttori
	*/
	public static void cacheResult(
		it.bysoftware.ct.model.OrganizzazioneProduttori organizzazioneProduttori) {
		getPersistence().cacheResult(organizzazioneProduttori);
	}

	/**
	* Caches the organizzazione produttoris in the entity cache if it is enabled.
	*
	* @param organizzazioneProduttoris the organizzazione produttoris
	*/
	public static void cacheResult(
		java.util.List<it.bysoftware.ct.model.OrganizzazioneProduttori> organizzazioneProduttoris) {
		getPersistence().cacheResult(organizzazioneProduttoris);
	}

	/**
	* Creates a new organizzazione produttori with the primary key. Does not add the organizzazione produttori to the database.
	*
	* @param id the primary key for the new organizzazione produttori
	* @return the new organizzazione produttori
	*/
	public static it.bysoftware.ct.model.OrganizzazioneProduttori create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the organizzazione produttori with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the organizzazione produttori
	* @return the organizzazione produttori that was removed
	* @throws it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException if a organizzazione produttori with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.OrganizzazioneProduttori remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException {
		return getPersistence().remove(id);
	}

	public static it.bysoftware.ct.model.OrganizzazioneProduttori updateImpl(
		it.bysoftware.ct.model.OrganizzazioneProduttori organizzazioneProduttori)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(organizzazioneProduttori);
	}

	/**
	* Returns the organizzazione produttori with the primary key or throws a {@link it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException} if it could not be found.
	*
	* @param id the primary key of the organizzazione produttori
	* @return the organizzazione produttori
	* @throws it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException if a organizzazione produttori with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.OrganizzazioneProduttori findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the organizzazione produttori with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the organizzazione produttori
	* @return the organizzazione produttori, or <code>null</code> if a organizzazione produttori with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.OrganizzazioneProduttori fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the organizzazione produttoris.
	*
	* @return the organizzazione produttoris
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.OrganizzazioneProduttori> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<it.bysoftware.ct.model.OrganizzazioneProduttori> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<it.bysoftware.ct.model.OrganizzazioneProduttori> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the organizzazione produttoris from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of organizzazione produttoris.
	*
	* @return the number of organizzazione produttoris
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static OrganizzazioneProduttoriPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (OrganizzazioneProduttoriPersistence)PortletBeanLocatorUtil.locate(it.bysoftware.ct.service.ClpSerializer.getServletContextName(),
					OrganizzazioneProduttoriPersistence.class.getName());

			ReferenceRegistry.registerReference(OrganizzazioneProduttoriUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(OrganizzazioneProduttoriPersistence persistence) {
	}

	private static OrganizzazioneProduttoriPersistence _persistence;
}
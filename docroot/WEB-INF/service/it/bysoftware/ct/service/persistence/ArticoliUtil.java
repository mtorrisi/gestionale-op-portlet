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

import it.bysoftware.ct.model.Articoli;

import java.util.List;

/**
 * The persistence utility for the articoli service. This utility wraps {@link ArticoliPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ArticoliPersistence
 * @see ArticoliPersistenceImpl
 * @generated
 */
public class ArticoliUtil {
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
	public static void clearCache(Articoli articoli) {
		getPersistence().clearCache(articoli);
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
	public static List<Articoli> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Articoli> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Articoli> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Articoli update(Articoli articoli) throws SystemException {
		return getPersistence().update(articoli);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Articoli update(Articoli articoli,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(articoli, serviceContext);
	}

	/**
	* Returns all the articolis where categoriaMerceologica = &#63;.
	*
	* @param categoriaMerceologica the categoria merceologica
	* @return the matching articolis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.Articoli> findBycategoriaMerceologica(
		java.lang.String categoriaMerceologica)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycategoriaMerceologica(categoriaMerceologica);
	}

	/**
	* Returns a range of all the articolis where categoriaMerceologica = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.ArticoliModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoriaMerceologica the categoria merceologica
	* @param start the lower bound of the range of articolis
	* @param end the upper bound of the range of articolis (not inclusive)
	* @return the range of matching articolis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.Articoli> findBycategoriaMerceologica(
		java.lang.String categoriaMerceologica, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycategoriaMerceologica(categoriaMerceologica, start,
			end);
	}

	/**
	* Returns an ordered range of all the articolis where categoriaMerceologica = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.ArticoliModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoriaMerceologica the categoria merceologica
	* @param start the lower bound of the range of articolis
	* @param end the upper bound of the range of articolis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching articolis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.Articoli> findBycategoriaMerceologica(
		java.lang.String categoriaMerceologica, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycategoriaMerceologica(categoriaMerceologica, start,
			end, orderByComparator);
	}

	/**
	* Returns the first articoli in the ordered set where categoriaMerceologica = &#63;.
	*
	* @param categoriaMerceologica the categoria merceologica
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching articoli
	* @throws it.bysoftware.ct.NoSuchArticoliException if a matching articoli could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Articoli findBycategoriaMerceologica_First(
		java.lang.String categoriaMerceologica,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchArticoliException {
		return getPersistence()
				   .findBycategoriaMerceologica_First(categoriaMerceologica,
			orderByComparator);
	}

	/**
	* Returns the first articoli in the ordered set where categoriaMerceologica = &#63;.
	*
	* @param categoriaMerceologica the categoria merceologica
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching articoli, or <code>null</code> if a matching articoli could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Articoli fetchBycategoriaMerceologica_First(
		java.lang.String categoriaMerceologica,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycategoriaMerceologica_First(categoriaMerceologica,
			orderByComparator);
	}

	/**
	* Returns the last articoli in the ordered set where categoriaMerceologica = &#63;.
	*
	* @param categoriaMerceologica the categoria merceologica
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching articoli
	* @throws it.bysoftware.ct.NoSuchArticoliException if a matching articoli could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Articoli findBycategoriaMerceologica_Last(
		java.lang.String categoriaMerceologica,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchArticoliException {
		return getPersistence()
				   .findBycategoriaMerceologica_Last(categoriaMerceologica,
			orderByComparator);
	}

	/**
	* Returns the last articoli in the ordered set where categoriaMerceologica = &#63;.
	*
	* @param categoriaMerceologica the categoria merceologica
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching articoli, or <code>null</code> if a matching articoli could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Articoli fetchBycategoriaMerceologica_Last(
		java.lang.String categoriaMerceologica,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycategoriaMerceologica_Last(categoriaMerceologica,
			orderByComparator);
	}

	/**
	* Returns the articolis before and after the current articoli in the ordered set where categoriaMerceologica = &#63;.
	*
	* @param codiceArticolo the primary key of the current articoli
	* @param categoriaMerceologica the categoria merceologica
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next articoli
	* @throws it.bysoftware.ct.NoSuchArticoliException if a articoli with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Articoli[] findBycategoriaMerceologica_PrevAndNext(
		java.lang.String codiceArticolo,
		java.lang.String categoriaMerceologica,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchArticoliException {
		return getPersistence()
				   .findBycategoriaMerceologica_PrevAndNext(codiceArticolo,
			categoriaMerceologica, orderByComparator);
	}

	/**
	* Removes all the articolis where categoriaMerceologica = &#63; from the database.
	*
	* @param categoriaMerceologica the categoria merceologica
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBycategoriaMerceologica(
		java.lang.String categoriaMerceologica)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBycategoriaMerceologica(categoriaMerceologica);
	}

	/**
	* Returns the number of articolis where categoriaMerceologica = &#63;.
	*
	* @param categoriaMerceologica the categoria merceologica
	* @return the number of matching articolis
	* @throws SystemException if a system exception occurred
	*/
	public static int countBycategoriaMerceologica(
		java.lang.String categoriaMerceologica)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countBycategoriaMerceologica(categoriaMerceologica);
	}

	/**
	* Returns all the articolis where categoriaMerceologica &ne; &#63;.
	*
	* @param categoriaMerceologica the categoria merceologica
	* @return the matching articolis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.Articoli> findBycategoriaArticoli(
		java.lang.String categoriaMerceologica)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBycategoriaArticoli(categoriaMerceologica);
	}

	/**
	* Returns a range of all the articolis where categoriaMerceologica &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.ArticoliModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoriaMerceologica the categoria merceologica
	* @param start the lower bound of the range of articolis
	* @param end the upper bound of the range of articolis (not inclusive)
	* @return the range of matching articolis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.Articoli> findBycategoriaArticoli(
		java.lang.String categoriaMerceologica, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycategoriaArticoli(categoriaMerceologica, start, end);
	}

	/**
	* Returns an ordered range of all the articolis where categoriaMerceologica &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.ArticoliModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoriaMerceologica the categoria merceologica
	* @param start the lower bound of the range of articolis
	* @param end the upper bound of the range of articolis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching articolis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.Articoli> findBycategoriaArticoli(
		java.lang.String categoriaMerceologica, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycategoriaArticoli(categoriaMerceologica, start, end,
			orderByComparator);
	}

	/**
	* Returns the first articoli in the ordered set where categoriaMerceologica &ne; &#63;.
	*
	* @param categoriaMerceologica the categoria merceologica
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching articoli
	* @throws it.bysoftware.ct.NoSuchArticoliException if a matching articoli could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Articoli findBycategoriaArticoli_First(
		java.lang.String categoriaMerceologica,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchArticoliException {
		return getPersistence()
				   .findBycategoriaArticoli_First(categoriaMerceologica,
			orderByComparator);
	}

	/**
	* Returns the first articoli in the ordered set where categoriaMerceologica &ne; &#63;.
	*
	* @param categoriaMerceologica the categoria merceologica
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching articoli, or <code>null</code> if a matching articoli could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Articoli fetchBycategoriaArticoli_First(
		java.lang.String categoriaMerceologica,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycategoriaArticoli_First(categoriaMerceologica,
			orderByComparator);
	}

	/**
	* Returns the last articoli in the ordered set where categoriaMerceologica &ne; &#63;.
	*
	* @param categoriaMerceologica the categoria merceologica
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching articoli
	* @throws it.bysoftware.ct.NoSuchArticoliException if a matching articoli could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Articoli findBycategoriaArticoli_Last(
		java.lang.String categoriaMerceologica,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchArticoliException {
		return getPersistence()
				   .findBycategoriaArticoli_Last(categoriaMerceologica,
			orderByComparator);
	}

	/**
	* Returns the last articoli in the ordered set where categoriaMerceologica &ne; &#63;.
	*
	* @param categoriaMerceologica the categoria merceologica
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching articoli, or <code>null</code> if a matching articoli could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Articoli fetchBycategoriaArticoli_Last(
		java.lang.String categoriaMerceologica,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycategoriaArticoli_Last(categoriaMerceologica,
			orderByComparator);
	}

	/**
	* Returns the articolis before and after the current articoli in the ordered set where categoriaMerceologica &ne; &#63;.
	*
	* @param codiceArticolo the primary key of the current articoli
	* @param categoriaMerceologica the categoria merceologica
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next articoli
	* @throws it.bysoftware.ct.NoSuchArticoliException if a articoli with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Articoli[] findBycategoriaArticoli_PrevAndNext(
		java.lang.String codiceArticolo,
		java.lang.String categoriaMerceologica,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchArticoliException {
		return getPersistence()
				   .findBycategoriaArticoli_PrevAndNext(codiceArticolo,
			categoriaMerceologica, orderByComparator);
	}

	/**
	* Removes all the articolis where categoriaMerceologica &ne; &#63; from the database.
	*
	* @param categoriaMerceologica the categoria merceologica
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBycategoriaArticoli(
		java.lang.String categoriaMerceologica)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBycategoriaArticoli(categoriaMerceologica);
	}

	/**
	* Returns the number of articolis where categoriaMerceologica &ne; &#63;.
	*
	* @param categoriaMerceologica the categoria merceologica
	* @return the number of matching articolis
	* @throws SystemException if a system exception occurred
	*/
	public static int countBycategoriaArticoli(
		java.lang.String categoriaMerceologica)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBycategoriaArticoli(categoriaMerceologica);
	}

	/**
	* Caches the articoli in the entity cache if it is enabled.
	*
	* @param articoli the articoli
	*/
	public static void cacheResult(it.bysoftware.ct.model.Articoli articoli) {
		getPersistence().cacheResult(articoli);
	}

	/**
	* Caches the articolis in the entity cache if it is enabled.
	*
	* @param articolis the articolis
	*/
	public static void cacheResult(
		java.util.List<it.bysoftware.ct.model.Articoli> articolis) {
		getPersistence().cacheResult(articolis);
	}

	/**
	* Creates a new articoli with the primary key. Does not add the articoli to the database.
	*
	* @param codiceArticolo the primary key for the new articoli
	* @return the new articoli
	*/
	public static it.bysoftware.ct.model.Articoli create(
		java.lang.String codiceArticolo) {
		return getPersistence().create(codiceArticolo);
	}

	/**
	* Removes the articoli with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param codiceArticolo the primary key of the articoli
	* @return the articoli that was removed
	* @throws it.bysoftware.ct.NoSuchArticoliException if a articoli with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Articoli remove(
		java.lang.String codiceArticolo)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchArticoliException {
		return getPersistence().remove(codiceArticolo);
	}

	public static it.bysoftware.ct.model.Articoli updateImpl(
		it.bysoftware.ct.model.Articoli articoli)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(articoli);
	}

	/**
	* Returns the articoli with the primary key or throws a {@link it.bysoftware.ct.NoSuchArticoliException} if it could not be found.
	*
	* @param codiceArticolo the primary key of the articoli
	* @return the articoli
	* @throws it.bysoftware.ct.NoSuchArticoliException if a articoli with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Articoli findByPrimaryKey(
		java.lang.String codiceArticolo)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchArticoliException {
		return getPersistence().findByPrimaryKey(codiceArticolo);
	}

	/**
	* Returns the articoli with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param codiceArticolo the primary key of the articoli
	* @return the articoli, or <code>null</code> if a articoli with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Articoli fetchByPrimaryKey(
		java.lang.String codiceArticolo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(codiceArticolo);
	}

	/**
	* Returns all the articolis.
	*
	* @return the articolis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.Articoli> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the articolis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.ArticoliModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of articolis
	* @param end the upper bound of the range of articolis (not inclusive)
	* @return the range of articolis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.Articoli> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the articolis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.ArticoliModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of articolis
	* @param end the upper bound of the range of articolis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of articolis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.Articoli> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the articolis from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of articolis.
	*
	* @return the number of articolis
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ArticoliPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ArticoliPersistence)PortletBeanLocatorUtil.locate(it.bysoftware.ct.service.ClpSerializer.getServletContextName(),
					ArticoliPersistence.class.getName());

			ReferenceRegistry.registerReference(ArticoliUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ArticoliPersistence persistence) {
	}

	private static ArticoliPersistence _persistence;
}
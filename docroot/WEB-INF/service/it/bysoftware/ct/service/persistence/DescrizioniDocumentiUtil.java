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

import it.bysoftware.ct.model.DescrizioniDocumenti;

import java.util.List;

/**
 * The persistence utility for the descrizioni documenti service. This utility wraps {@link DescrizioniDocumentiPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DescrizioniDocumentiPersistence
 * @see DescrizioniDocumentiPersistenceImpl
 * @generated
 */
public class DescrizioniDocumentiUtil {
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
	public static void clearCache(DescrizioniDocumenti descrizioniDocumenti) {
		getPersistence().clearCache(descrizioniDocumenti);
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
	public static List<DescrizioniDocumenti> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DescrizioniDocumenti> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DescrizioniDocumenti> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static DescrizioniDocumenti update(
		DescrizioniDocumenti descrizioniDocumenti) throws SystemException {
		return getPersistence().update(descrizioniDocumenti);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static DescrizioniDocumenti update(
		DescrizioniDocumenti descrizioniDocumenti, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(descrizioniDocumenti, serviceContext);
	}

	/**
	* Caches the descrizioni documenti in the entity cache if it is enabled.
	*
	* @param descrizioniDocumenti the descrizioni documenti
	*/
	public static void cacheResult(
		it.bysoftware.ct.model.DescrizioniDocumenti descrizioniDocumenti) {
		getPersistence().cacheResult(descrizioniDocumenti);
	}

	/**
	* Caches the descrizioni documentis in the entity cache if it is enabled.
	*
	* @param descrizioniDocumentis the descrizioni documentis
	*/
	public static void cacheResult(
		java.util.List<it.bysoftware.ct.model.DescrizioniDocumenti> descrizioniDocumentis) {
		getPersistence().cacheResult(descrizioniDocumentis);
	}

	/**
	* Creates a new descrizioni documenti with the primary key. Does not add the descrizioni documenti to the database.
	*
	* @param codiceDescrizione the primary key for the new descrizioni documenti
	* @return the new descrizioni documenti
	*/
	public static it.bysoftware.ct.model.DescrizioniDocumenti create(
		java.lang.String codiceDescrizione) {
		return getPersistence().create(codiceDescrizione);
	}

	/**
	* Removes the descrizioni documenti with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param codiceDescrizione the primary key of the descrizioni documenti
	* @return the descrizioni documenti that was removed
	* @throws it.bysoftware.ct.NoSuchDescrizioniDocumentiException if a descrizioni documenti with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.DescrizioniDocumenti remove(
		java.lang.String codiceDescrizione)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchDescrizioniDocumentiException {
		return getPersistence().remove(codiceDescrizione);
	}

	public static it.bysoftware.ct.model.DescrizioniDocumenti updateImpl(
		it.bysoftware.ct.model.DescrizioniDocumenti descrizioniDocumenti)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(descrizioniDocumenti);
	}

	/**
	* Returns the descrizioni documenti with the primary key or throws a {@link it.bysoftware.ct.NoSuchDescrizioniDocumentiException} if it could not be found.
	*
	* @param codiceDescrizione the primary key of the descrizioni documenti
	* @return the descrizioni documenti
	* @throws it.bysoftware.ct.NoSuchDescrizioniDocumentiException if a descrizioni documenti with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.DescrizioniDocumenti findByPrimaryKey(
		java.lang.String codiceDescrizione)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchDescrizioniDocumentiException {
		return getPersistence().findByPrimaryKey(codiceDescrizione);
	}

	/**
	* Returns the descrizioni documenti with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param codiceDescrizione the primary key of the descrizioni documenti
	* @return the descrizioni documenti, or <code>null</code> if a descrizioni documenti with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.DescrizioniDocumenti fetchByPrimaryKey(
		java.lang.String codiceDescrizione)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(codiceDescrizione);
	}

	/**
	* Returns all the descrizioni documentis.
	*
	* @return the descrizioni documentis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.DescrizioniDocumenti> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<it.bysoftware.ct.model.DescrizioniDocumenti> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<it.bysoftware.ct.model.DescrizioniDocumenti> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the descrizioni documentis from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of descrizioni documentis.
	*
	* @return the number of descrizioni documentis
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DescrizioniDocumentiPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DescrizioniDocumentiPersistence)PortletBeanLocatorUtil.locate(it.bysoftware.ct.service.ClpSerializer.getServletContextName(),
					DescrizioniDocumentiPersistence.class.getName());

			ReferenceRegistry.registerReference(DescrizioniDocumentiUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(DescrizioniDocumentiPersistence persistence) {
	}

	private static DescrizioniDocumentiPersistence _persistence;
}
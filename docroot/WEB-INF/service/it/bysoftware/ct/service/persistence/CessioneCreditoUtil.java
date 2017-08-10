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

import it.bysoftware.ct.model.CessioneCredito;

import java.util.List;

/**
 * The persistence utility for the cessione credito service. This utility wraps {@link CessioneCreditoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CessioneCreditoPersistence
 * @see CessioneCreditoPersistenceImpl
 * @generated
 */
public class CessioneCreditoUtil {
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
	public static void clearCache(CessioneCredito cessioneCredito) {
		getPersistence().clearCache(cessioneCredito);
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
	public static List<CessioneCredito> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CessioneCredito> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CessioneCredito> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CessioneCredito update(CessioneCredito cessioneCredito)
		throws SystemException {
		return getPersistence().update(cessioneCredito);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CessioneCredito update(CessioneCredito cessioneCredito,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(cessioneCredito, serviceContext);
	}

	/**
	* Returns the cessione credito where anno = &#63; and idAssociato = &#63; and numeroFattura = &#63; or throws a {@link it.bysoftware.ct.NoSuchCessioneCreditoException} if it could not be found.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param numeroFattura the numero fattura
	* @return the matching cessione credito
	* @throws it.bysoftware.ct.NoSuchCessioneCreditoException if a matching cessione credito could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.CessioneCredito findByAnnoAssociatoNumeroFattura(
		int anno, long idAssociato, int numeroFattura)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchCessioneCreditoException {
		return getPersistence()
				   .findByAnnoAssociatoNumeroFattura(anno, idAssociato,
			numeroFattura);
	}

	/**
	* Returns the cessione credito where anno = &#63; and idAssociato = &#63; and numeroFattura = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param numeroFattura the numero fattura
	* @return the matching cessione credito, or <code>null</code> if a matching cessione credito could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.CessioneCredito fetchByAnnoAssociatoNumeroFattura(
		int anno, long idAssociato, int numeroFattura)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAnnoAssociatoNumeroFattura(anno, idAssociato,
			numeroFattura);
	}

	/**
	* Returns the cessione credito where anno = &#63; and idAssociato = &#63; and numeroFattura = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param numeroFattura the numero fattura
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cessione credito, or <code>null</code> if a matching cessione credito could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.CessioneCredito fetchByAnnoAssociatoNumeroFattura(
		int anno, long idAssociato, int numeroFattura, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAnnoAssociatoNumeroFattura(anno, idAssociato,
			numeroFattura, retrieveFromCache);
	}

	/**
	* Removes the cessione credito where anno = &#63; and idAssociato = &#63; and numeroFattura = &#63; from the database.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param numeroFattura the numero fattura
	* @return the cessione credito that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.CessioneCredito removeByAnnoAssociatoNumeroFattura(
		int anno, long idAssociato, int numeroFattura)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchCessioneCreditoException {
		return getPersistence()
				   .removeByAnnoAssociatoNumeroFattura(anno, idAssociato,
			numeroFattura);
	}

	/**
	* Returns the number of cessione creditos where anno = &#63; and idAssociato = &#63; and numeroFattura = &#63;.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param numeroFattura the numero fattura
	* @return the number of matching cessione creditos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAnnoAssociatoNumeroFattura(int anno,
		long idAssociato, int numeroFattura)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByAnnoAssociatoNumeroFattura(anno, idAssociato,
			numeroFattura);
	}

	/**
	* Caches the cessione credito in the entity cache if it is enabled.
	*
	* @param cessioneCredito the cessione credito
	*/
	public static void cacheResult(
		it.bysoftware.ct.model.CessioneCredito cessioneCredito) {
		getPersistence().cacheResult(cessioneCredito);
	}

	/**
	* Caches the cessione creditos in the entity cache if it is enabled.
	*
	* @param cessioneCreditos the cessione creditos
	*/
	public static void cacheResult(
		java.util.List<it.bysoftware.ct.model.CessioneCredito> cessioneCreditos) {
		getPersistence().cacheResult(cessioneCreditos);
	}

	/**
	* Creates a new cessione credito with the primary key. Does not add the cessione credito to the database.
	*
	* @param id the primary key for the new cessione credito
	* @return the new cessione credito
	*/
	public static it.bysoftware.ct.model.CessioneCredito create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the cessione credito with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the cessione credito
	* @return the cessione credito that was removed
	* @throws it.bysoftware.ct.NoSuchCessioneCreditoException if a cessione credito with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.CessioneCredito remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchCessioneCreditoException {
		return getPersistence().remove(id);
	}

	public static it.bysoftware.ct.model.CessioneCredito updateImpl(
		it.bysoftware.ct.model.CessioneCredito cessioneCredito)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(cessioneCredito);
	}

	/**
	* Returns the cessione credito with the primary key or throws a {@link it.bysoftware.ct.NoSuchCessioneCreditoException} if it could not be found.
	*
	* @param id the primary key of the cessione credito
	* @return the cessione credito
	* @throws it.bysoftware.ct.NoSuchCessioneCreditoException if a cessione credito with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.CessioneCredito findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchCessioneCreditoException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the cessione credito with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the cessione credito
	* @return the cessione credito, or <code>null</code> if a cessione credito with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.CessioneCredito fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the cessione creditos.
	*
	* @return the cessione creditos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.CessioneCredito> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the cessione creditos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.CessioneCreditoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cessione creditos
	* @param end the upper bound of the range of cessione creditos (not inclusive)
	* @return the range of cessione creditos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.CessioneCredito> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the cessione creditos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.CessioneCreditoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cessione creditos
	* @param end the upper bound of the range of cessione creditos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cessione creditos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.CessioneCredito> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the cessione creditos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of cessione creditos.
	*
	* @return the number of cessione creditos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CessioneCreditoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CessioneCreditoPersistence)PortletBeanLocatorUtil.locate(it.bysoftware.ct.service.ClpSerializer.getServletContextName(),
					CessioneCreditoPersistence.class.getName());

			ReferenceRegistry.registerReference(CessioneCreditoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CessioneCreditoPersistence persistence) {
	}

	private static CessioneCreditoPersistence _persistence;
}
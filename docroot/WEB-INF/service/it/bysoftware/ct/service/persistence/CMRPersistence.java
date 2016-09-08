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

import it.bysoftware.ct.model.CMR;

/**
 * The persistence interface for the c m r service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CMRPersistenceImpl
 * @see CMRUtil
 * @generated
 */
public interface CMRPersistence extends BasePersistence<CMR> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CMRUtil} to access the c m r persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the c m r where anno = &#63; and idAssociato = &#63; or throws a {@link it.bysoftware.ct.NoSuchCMRException} if it could not be found.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @return the matching c m r
	* @throws it.bysoftware.ct.NoSuchCMRException if a matching c m r could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.CMR findByprogressivo(int anno,
		int idAssociato)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchCMRException;

	/**
	* Returns the c m r where anno = &#63; and idAssociato = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @return the matching c m r, or <code>null</code> if a matching c m r could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.CMR fetchByprogressivo(int anno,
		int idAssociato)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c m r where anno = &#63; and idAssociato = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching c m r, or <code>null</code> if a matching c m r could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.CMR fetchByprogressivo(int anno,
		int idAssociato, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the c m r where anno = &#63; and idAssociato = &#63; from the database.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @return the c m r that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.CMR removeByprogressivo(int anno,
		int idAssociato)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchCMRException;

	/**
	* Returns the number of c m rs where anno = &#63; and idAssociato = &#63;.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @return the number of matching c m rs
	* @throws SystemException if a system exception occurred
	*/
	public int countByprogressivo(int anno, int idAssociato)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the c m r in the entity cache if it is enabled.
	*
	* @param cmr the c m r
	*/
	public void cacheResult(it.bysoftware.ct.model.CMR cmr);

	/**
	* Caches the c m rs in the entity cache if it is enabled.
	*
	* @param cmrs the c m rs
	*/
	public void cacheResult(java.util.List<it.bysoftware.ct.model.CMR> cmrs);

	/**
	* Creates a new c m r with the primary key. Does not add the c m r to the database.
	*
	* @param cmrPK the primary key for the new c m r
	* @return the new c m r
	*/
	public it.bysoftware.ct.model.CMR create(CMRPK cmrPK);

	/**
	* Removes the c m r with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cmrPK the primary key of the c m r
	* @return the c m r that was removed
	* @throws it.bysoftware.ct.NoSuchCMRException if a c m r with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.CMR remove(CMRPK cmrPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchCMRException;

	public it.bysoftware.ct.model.CMR updateImpl(it.bysoftware.ct.model.CMR cmr)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c m r with the primary key or throws a {@link it.bysoftware.ct.NoSuchCMRException} if it could not be found.
	*
	* @param cmrPK the primary key of the c m r
	* @return the c m r
	* @throws it.bysoftware.ct.NoSuchCMRException if a c m r with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.CMR findByPrimaryKey(CMRPK cmrPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchCMRException;

	/**
	* Returns the c m r with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cmrPK the primary key of the c m r
	* @return the c m r, or <code>null</code> if a c m r with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.CMR fetchByPrimaryKey(CMRPK cmrPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the c m rs.
	*
	* @return the c m rs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.CMR> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c m rs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.CMRModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of c m rs
	* @param end the upper bound of the range of c m rs (not inclusive)
	* @return the range of c m rs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.CMR> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c m rs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.CMRModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of c m rs
	* @param end the upper bound of the range of c m rs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of c m rs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.CMR> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c m rs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c m rs.
	*
	* @return the number of c m rs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
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

import it.bysoftware.ct.model.AnagraficaAssociatoOP;

/**
 * The persistence interface for the anagrafica associato o p service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnagraficaAssociatoOPPersistenceImpl
 * @see AnagraficaAssociatoOPUtil
 * @generated
 */
public interface AnagraficaAssociatoOPPersistence extends BasePersistence<AnagraficaAssociatoOP> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnagraficaAssociatoOPUtil} to access the anagrafica associato o p persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the anagrafica associato o p in the entity cache if it is enabled.
	*
	* @param anagraficaAssociatoOP the anagrafica associato o p
	*/
	public void cacheResult(
		it.bysoftware.ct.model.AnagraficaAssociatoOP anagraficaAssociatoOP);

	/**
	* Caches the anagrafica associato o ps in the entity cache if it is enabled.
	*
	* @param anagraficaAssociatoOPs the anagrafica associato o ps
	*/
	public void cacheResult(
		java.util.List<it.bysoftware.ct.model.AnagraficaAssociatoOP> anagraficaAssociatoOPs);

	/**
	* Creates a new anagrafica associato o p with the primary key. Does not add the anagrafica associato o p to the database.
	*
	* @param anagraficaAssociatoOPPK the primary key for the new anagrafica associato o p
	* @return the new anagrafica associato o p
	*/
	public it.bysoftware.ct.model.AnagraficaAssociatoOP create(
		it.bysoftware.ct.service.persistence.AnagraficaAssociatoOPPK anagraficaAssociatoOPPK);

	/**
	* Removes the anagrafica associato o p with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param anagraficaAssociatoOPPK the primary key of the anagrafica associato o p
	* @return the anagrafica associato o p that was removed
	* @throws it.bysoftware.ct.NoSuchAnagraficaAssociatoOPException if a anagrafica associato o p with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.AnagraficaAssociatoOP remove(
		it.bysoftware.ct.service.persistence.AnagraficaAssociatoOPPK anagraficaAssociatoOPPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAnagraficaAssociatoOPException;

	public it.bysoftware.ct.model.AnagraficaAssociatoOP updateImpl(
		it.bysoftware.ct.model.AnagraficaAssociatoOP anagraficaAssociatoOP)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the anagrafica associato o p with the primary key or throws a {@link it.bysoftware.ct.NoSuchAnagraficaAssociatoOPException} if it could not be found.
	*
	* @param anagraficaAssociatoOPPK the primary key of the anagrafica associato o p
	* @return the anagrafica associato o p
	* @throws it.bysoftware.ct.NoSuchAnagraficaAssociatoOPException if a anagrafica associato o p with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.AnagraficaAssociatoOP findByPrimaryKey(
		it.bysoftware.ct.service.persistence.AnagraficaAssociatoOPPK anagraficaAssociatoOPPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAnagraficaAssociatoOPException;

	/**
	* Returns the anagrafica associato o p with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param anagraficaAssociatoOPPK the primary key of the anagrafica associato o p
	* @return the anagrafica associato o p, or <code>null</code> if a anagrafica associato o p with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.AnagraficaAssociatoOP fetchByPrimaryKey(
		it.bysoftware.ct.service.persistence.AnagraficaAssociatoOPPK anagraficaAssociatoOPPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the anagrafica associato o ps.
	*
	* @return the anagrafica associato o ps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.AnagraficaAssociatoOP> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the anagrafica associato o ps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AnagraficaAssociatoOPModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of anagrafica associato o ps
	* @param end the upper bound of the range of anagrafica associato o ps (not inclusive)
	* @return the range of anagrafica associato o ps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.AnagraficaAssociatoOP> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the anagrafica associato o ps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AnagraficaAssociatoOPModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of anagrafica associato o ps
	* @param end the upper bound of the range of anagrafica associato o ps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of anagrafica associato o ps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.AnagraficaAssociatoOP> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the anagrafica associato o ps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of anagrafica associato o ps.
	*
	* @return the number of anagrafica associato o ps
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
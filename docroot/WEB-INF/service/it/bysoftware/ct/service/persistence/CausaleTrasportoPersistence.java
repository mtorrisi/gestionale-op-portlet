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

import it.bysoftware.ct.model.CausaleTrasporto;

/**
 * The persistence interface for the causale trasporto service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CausaleTrasportoPersistenceImpl
 * @see CausaleTrasportoUtil
 * @generated
 */
public interface CausaleTrasportoPersistence extends BasePersistence<CausaleTrasporto> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CausaleTrasportoUtil} to access the causale trasporto persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the causale trasporto in the entity cache if it is enabled.
	*
	* @param causaleTrasporto the causale trasporto
	*/
	public void cacheResult(
		it.bysoftware.ct.model.CausaleTrasporto causaleTrasporto);

	/**
	* Caches the causale trasportos in the entity cache if it is enabled.
	*
	* @param causaleTrasportos the causale trasportos
	*/
	public void cacheResult(
		java.util.List<it.bysoftware.ct.model.CausaleTrasporto> causaleTrasportos);

	/**
	* Creates a new causale trasporto with the primary key. Does not add the causale trasporto to the database.
	*
	* @param codiceCausaleTrasporto the primary key for the new causale trasporto
	* @return the new causale trasporto
	*/
	public it.bysoftware.ct.model.CausaleTrasporto create(
		java.lang.String codiceCausaleTrasporto);

	/**
	* Removes the causale trasporto with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param codiceCausaleTrasporto the primary key of the causale trasporto
	* @return the causale trasporto that was removed
	* @throws it.bysoftware.ct.NoSuchCausaleTrasportoException if a causale trasporto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.CausaleTrasporto remove(
		java.lang.String codiceCausaleTrasporto)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchCausaleTrasportoException;

	public it.bysoftware.ct.model.CausaleTrasporto updateImpl(
		it.bysoftware.ct.model.CausaleTrasporto causaleTrasporto)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the causale trasporto with the primary key or throws a {@link it.bysoftware.ct.NoSuchCausaleTrasportoException} if it could not be found.
	*
	* @param codiceCausaleTrasporto the primary key of the causale trasporto
	* @return the causale trasporto
	* @throws it.bysoftware.ct.NoSuchCausaleTrasportoException if a causale trasporto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.CausaleTrasporto findByPrimaryKey(
		java.lang.String codiceCausaleTrasporto)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchCausaleTrasportoException;

	/**
	* Returns the causale trasporto with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param codiceCausaleTrasporto the primary key of the causale trasporto
	* @return the causale trasporto, or <code>null</code> if a causale trasporto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.CausaleTrasporto fetchByPrimaryKey(
		java.lang.String codiceCausaleTrasporto)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the causale trasportos.
	*
	* @return the causale trasportos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.CausaleTrasporto> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the causale trasportos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.CausaleTrasportoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of causale trasportos
	* @param end the upper bound of the range of causale trasportos (not inclusive)
	* @return the range of causale trasportos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.CausaleTrasporto> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the causale trasportos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.CausaleTrasportoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of causale trasportos
	* @param end the upper bound of the range of causale trasportos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of causale trasportos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.CausaleTrasporto> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the causale trasportos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of causale trasportos.
	*
	* @return the number of causale trasportos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
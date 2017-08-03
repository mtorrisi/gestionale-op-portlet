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

import it.bysoftware.ct.model.CessioneCredito;

/**
 * The persistence interface for the cessione credito service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CessioneCreditoPersistenceImpl
 * @see CessioneCreditoUtil
 * @generated
 */
public interface CessioneCreditoPersistence extends BasePersistence<CessioneCredito> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CessioneCreditoUtil} to access the cessione credito persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

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
	public it.bysoftware.ct.model.CessioneCredito findByAnnoAssociatoNumeroFattura(
		int anno, long idAssociato, int numeroFattura)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchCessioneCreditoException;

	/**
	* Returns the cessione credito where anno = &#63; and idAssociato = &#63; and numeroFattura = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param numeroFattura the numero fattura
	* @return the matching cessione credito, or <code>null</code> if a matching cessione credito could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.CessioneCredito fetchByAnnoAssociatoNumeroFattura(
		int anno, long idAssociato, int numeroFattura)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.bysoftware.ct.model.CessioneCredito fetchByAnnoAssociatoNumeroFattura(
		int anno, long idAssociato, int numeroFattura, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the cessione credito where anno = &#63; and idAssociato = &#63; and numeroFattura = &#63; from the database.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param numeroFattura the numero fattura
	* @return the cessione credito that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.CessioneCredito removeByAnnoAssociatoNumeroFattura(
		int anno, long idAssociato, int numeroFattura)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchCessioneCreditoException;

	/**
	* Returns the number of cessione creditos where anno = &#63; and idAssociato = &#63; and numeroFattura = &#63;.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param numeroFattura the numero fattura
	* @return the number of matching cessione creditos
	* @throws SystemException if a system exception occurred
	*/
	public int countByAnnoAssociatoNumeroFattura(int anno, long idAssociato,
		int numeroFattura)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the cessione credito in the entity cache if it is enabled.
	*
	* @param cessioneCredito the cessione credito
	*/
	public void cacheResult(
		it.bysoftware.ct.model.CessioneCredito cessioneCredito);

	/**
	* Caches the cessione creditos in the entity cache if it is enabled.
	*
	* @param cessioneCreditos the cessione creditos
	*/
	public void cacheResult(
		java.util.List<it.bysoftware.ct.model.CessioneCredito> cessioneCreditos);

	/**
	* Creates a new cessione credito with the primary key. Does not add the cessione credito to the database.
	*
	* @param id the primary key for the new cessione credito
	* @return the new cessione credito
	*/
	public it.bysoftware.ct.model.CessioneCredito create(long id);

	/**
	* Removes the cessione credito with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the cessione credito
	* @return the cessione credito that was removed
	* @throws it.bysoftware.ct.NoSuchCessioneCreditoException if a cessione credito with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.CessioneCredito remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchCessioneCreditoException;

	public it.bysoftware.ct.model.CessioneCredito updateImpl(
		it.bysoftware.ct.model.CessioneCredito cessioneCredito)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cessione credito with the primary key or throws a {@link it.bysoftware.ct.NoSuchCessioneCreditoException} if it could not be found.
	*
	* @param id the primary key of the cessione credito
	* @return the cessione credito
	* @throws it.bysoftware.ct.NoSuchCessioneCreditoException if a cessione credito with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.CessioneCredito findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchCessioneCreditoException;

	/**
	* Returns the cessione credito with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the cessione credito
	* @return the cessione credito, or <code>null</code> if a cessione credito with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.CessioneCredito fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cessione creditos.
	*
	* @return the cessione creditos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.CessioneCredito> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.bysoftware.ct.model.CessioneCredito> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.bysoftware.ct.model.CessioneCredito> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cessione creditos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cessione creditos.
	*
	* @return the number of cessione creditos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
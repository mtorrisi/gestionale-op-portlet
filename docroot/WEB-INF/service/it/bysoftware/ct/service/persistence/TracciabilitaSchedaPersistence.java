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

import it.bysoftware.ct.model.TracciabilitaScheda;

/**
 * The persistence interface for the tracciabilita scheda service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TracciabilitaSchedaPersistenceImpl
 * @see TracciabilitaSchedaUtil
 * @generated
 */
public interface TracciabilitaSchedaPersistence extends BasePersistence<TracciabilitaScheda> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TracciabilitaSchedaUtil} to access the tracciabilita scheda persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the tracciabilita schedas where anno = &#63; and idAssociato = &#63; and numeroDocumento = &#63; and tipoDocumento = &#63;.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param numeroDocumento the numero documento
	* @param tipoDocumento the tipo documento
	* @return the matching tracciabilita schedas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.TracciabilitaScheda> findByAnnoIdAssociatoNDocumento(
		int anno, long idAssociato, long numeroDocumento,
		java.lang.String tipoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tracciabilita schedas where anno = &#63; and idAssociato = &#63; and numeroDocumento = &#63; and tipoDocumento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TracciabilitaSchedaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param numeroDocumento the numero documento
	* @param tipoDocumento the tipo documento
	* @param start the lower bound of the range of tracciabilita schedas
	* @param end the upper bound of the range of tracciabilita schedas (not inclusive)
	* @return the range of matching tracciabilita schedas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.TracciabilitaScheda> findByAnnoIdAssociatoNDocumento(
		int anno, long idAssociato, long numeroDocumento,
		java.lang.String tipoDocumento, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tracciabilita schedas where anno = &#63; and idAssociato = &#63; and numeroDocumento = &#63; and tipoDocumento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TracciabilitaSchedaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param numeroDocumento the numero documento
	* @param tipoDocumento the tipo documento
	* @param start the lower bound of the range of tracciabilita schedas
	* @param end the upper bound of the range of tracciabilita schedas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tracciabilita schedas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.TracciabilitaScheda> findByAnnoIdAssociatoNDocumento(
		int anno, long idAssociato, long numeroDocumento,
		java.lang.String tipoDocumento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tracciabilita scheda in the ordered set where anno = &#63; and idAssociato = &#63; and numeroDocumento = &#63; and tipoDocumento = &#63;.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param numeroDocumento the numero documento
	* @param tipoDocumento the tipo documento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tracciabilita scheda
	* @throws it.bysoftware.ct.NoSuchTracciabilitaSchedaException if a matching tracciabilita scheda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.TracciabilitaScheda findByAnnoIdAssociatoNDocumento_First(
		int anno, long idAssociato, long numeroDocumento,
		java.lang.String tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTracciabilitaSchedaException;

	/**
	* Returns the first tracciabilita scheda in the ordered set where anno = &#63; and idAssociato = &#63; and numeroDocumento = &#63; and tipoDocumento = &#63;.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param numeroDocumento the numero documento
	* @param tipoDocumento the tipo documento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tracciabilita scheda, or <code>null</code> if a matching tracciabilita scheda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.TracciabilitaScheda fetchByAnnoIdAssociatoNDocumento_First(
		int anno, long idAssociato, long numeroDocumento,
		java.lang.String tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last tracciabilita scheda in the ordered set where anno = &#63; and idAssociato = &#63; and numeroDocumento = &#63; and tipoDocumento = &#63;.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param numeroDocumento the numero documento
	* @param tipoDocumento the tipo documento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tracciabilita scheda
	* @throws it.bysoftware.ct.NoSuchTracciabilitaSchedaException if a matching tracciabilita scheda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.TracciabilitaScheda findByAnnoIdAssociatoNDocumento_Last(
		int anno, long idAssociato, long numeroDocumento,
		java.lang.String tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTracciabilitaSchedaException;

	/**
	* Returns the last tracciabilita scheda in the ordered set where anno = &#63; and idAssociato = &#63; and numeroDocumento = &#63; and tipoDocumento = &#63;.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param numeroDocumento the numero documento
	* @param tipoDocumento the tipo documento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tracciabilita scheda, or <code>null</code> if a matching tracciabilita scheda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.TracciabilitaScheda fetchByAnnoIdAssociatoNDocumento_Last(
		int anno, long idAssociato, long numeroDocumento,
		java.lang.String tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tracciabilita schedas before and after the current tracciabilita scheda in the ordered set where anno = &#63; and idAssociato = &#63; and numeroDocumento = &#63; and tipoDocumento = &#63;.
	*
	* @param id the primary key of the current tracciabilita scheda
	* @param anno the anno
	* @param idAssociato the id associato
	* @param numeroDocumento the numero documento
	* @param tipoDocumento the tipo documento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tracciabilita scheda
	* @throws it.bysoftware.ct.NoSuchTracciabilitaSchedaException if a tracciabilita scheda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.TracciabilitaScheda[] findByAnnoIdAssociatoNDocumento_PrevAndNext(
		long id, int anno, long idAssociato, long numeroDocumento,
		java.lang.String tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTracciabilitaSchedaException;

	/**
	* Removes all the tracciabilita schedas where anno = &#63; and idAssociato = &#63; and numeroDocumento = &#63; and tipoDocumento = &#63; from the database.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param numeroDocumento the numero documento
	* @param tipoDocumento the tipo documento
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAnnoIdAssociatoNDocumento(int anno, long idAssociato,
		long numeroDocumento, java.lang.String tipoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tracciabilita schedas where anno = &#63; and idAssociato = &#63; and numeroDocumento = &#63; and tipoDocumento = &#63;.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param numeroDocumento the numero documento
	* @param tipoDocumento the tipo documento
	* @return the number of matching tracciabilita schedas
	* @throws SystemException if a system exception occurred
	*/
	public int countByAnnoIdAssociatoNDocumento(int anno, long idAssociato,
		long numeroDocumento, java.lang.String tipoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tracciabilita scheda where anno = &#63; and idAssociato = &#63; and numeroDocumento = &#63; and tipoDocumento = &#63; and codiceProdotto = &#63; or throws a {@link it.bysoftware.ct.NoSuchTracciabilitaSchedaException} if it could not be found.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param numeroDocumento the numero documento
	* @param tipoDocumento the tipo documento
	* @param codiceProdotto the codice prodotto
	* @return the matching tracciabilita scheda
	* @throws it.bysoftware.ct.NoSuchTracciabilitaSchedaException if a matching tracciabilita scheda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.TracciabilitaScheda findByAnnoIdAssociatoNDocumentoCodiceProdotto(
		int anno, long idAssociato, long numeroDocumento,
		java.lang.String tipoDocumento, java.lang.String codiceProdotto)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTracciabilitaSchedaException;

	/**
	* Returns the tracciabilita scheda where anno = &#63; and idAssociato = &#63; and numeroDocumento = &#63; and tipoDocumento = &#63; and codiceProdotto = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param numeroDocumento the numero documento
	* @param tipoDocumento the tipo documento
	* @param codiceProdotto the codice prodotto
	* @return the matching tracciabilita scheda, or <code>null</code> if a matching tracciabilita scheda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.TracciabilitaScheda fetchByAnnoIdAssociatoNDocumentoCodiceProdotto(
		int anno, long idAssociato, long numeroDocumento,
		java.lang.String tipoDocumento, java.lang.String codiceProdotto)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tracciabilita scheda where anno = &#63; and idAssociato = &#63; and numeroDocumento = &#63; and tipoDocumento = &#63; and codiceProdotto = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param numeroDocumento the numero documento
	* @param tipoDocumento the tipo documento
	* @param codiceProdotto the codice prodotto
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching tracciabilita scheda, or <code>null</code> if a matching tracciabilita scheda could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.TracciabilitaScheda fetchByAnnoIdAssociatoNDocumentoCodiceProdotto(
		int anno, long idAssociato, long numeroDocumento,
		java.lang.String tipoDocumento, java.lang.String codiceProdotto,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the tracciabilita scheda where anno = &#63; and idAssociato = &#63; and numeroDocumento = &#63; and tipoDocumento = &#63; and codiceProdotto = &#63; from the database.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param numeroDocumento the numero documento
	* @param tipoDocumento the tipo documento
	* @param codiceProdotto the codice prodotto
	* @return the tracciabilita scheda that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.TracciabilitaScheda removeByAnnoIdAssociatoNDocumentoCodiceProdotto(
		int anno, long idAssociato, long numeroDocumento,
		java.lang.String tipoDocumento, java.lang.String codiceProdotto)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTracciabilitaSchedaException;

	/**
	* Returns the number of tracciabilita schedas where anno = &#63; and idAssociato = &#63; and numeroDocumento = &#63; and tipoDocumento = &#63; and codiceProdotto = &#63;.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param numeroDocumento the numero documento
	* @param tipoDocumento the tipo documento
	* @param codiceProdotto the codice prodotto
	* @return the number of matching tracciabilita schedas
	* @throws SystemException if a system exception occurred
	*/
	public int countByAnnoIdAssociatoNDocumentoCodiceProdotto(int anno,
		long idAssociato, long numeroDocumento, java.lang.String tipoDocumento,
		java.lang.String codiceProdotto)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the tracciabilita scheda in the entity cache if it is enabled.
	*
	* @param tracciabilitaScheda the tracciabilita scheda
	*/
	public void cacheResult(
		it.bysoftware.ct.model.TracciabilitaScheda tracciabilitaScheda);

	/**
	* Caches the tracciabilita schedas in the entity cache if it is enabled.
	*
	* @param tracciabilitaSchedas the tracciabilita schedas
	*/
	public void cacheResult(
		java.util.List<it.bysoftware.ct.model.TracciabilitaScheda> tracciabilitaSchedas);

	/**
	* Creates a new tracciabilita scheda with the primary key. Does not add the tracciabilita scheda to the database.
	*
	* @param id the primary key for the new tracciabilita scheda
	* @return the new tracciabilita scheda
	*/
	public it.bysoftware.ct.model.TracciabilitaScheda create(long id);

	/**
	* Removes the tracciabilita scheda with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the tracciabilita scheda
	* @return the tracciabilita scheda that was removed
	* @throws it.bysoftware.ct.NoSuchTracciabilitaSchedaException if a tracciabilita scheda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.TracciabilitaScheda remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTracciabilitaSchedaException;

	public it.bysoftware.ct.model.TracciabilitaScheda updateImpl(
		it.bysoftware.ct.model.TracciabilitaScheda tracciabilitaScheda)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tracciabilita scheda with the primary key or throws a {@link it.bysoftware.ct.NoSuchTracciabilitaSchedaException} if it could not be found.
	*
	* @param id the primary key of the tracciabilita scheda
	* @return the tracciabilita scheda
	* @throws it.bysoftware.ct.NoSuchTracciabilitaSchedaException if a tracciabilita scheda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.TracciabilitaScheda findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTracciabilitaSchedaException;

	/**
	* Returns the tracciabilita scheda with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the tracciabilita scheda
	* @return the tracciabilita scheda, or <code>null</code> if a tracciabilita scheda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.TracciabilitaScheda fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tracciabilita schedas.
	*
	* @return the tracciabilita schedas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.TracciabilitaScheda> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tracciabilita schedas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TracciabilitaSchedaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tracciabilita schedas
	* @param end the upper bound of the range of tracciabilita schedas (not inclusive)
	* @return the range of tracciabilita schedas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.TracciabilitaScheda> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tracciabilita schedas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TracciabilitaSchedaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tracciabilita schedas
	* @param end the upper bound of the range of tracciabilita schedas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tracciabilita schedas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.TracciabilitaScheda> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tracciabilita schedas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tracciabilita schedas.
	*
	* @return the number of tracciabilita schedas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
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

import it.bysoftware.ct.model.TracciabilitaScheda;

import java.util.List;

/**
 * The persistence utility for the tracciabilita scheda service. This utility wraps {@link TracciabilitaSchedaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TracciabilitaSchedaPersistence
 * @see TracciabilitaSchedaPersistenceImpl
 * @generated
 */
public class TracciabilitaSchedaUtil {
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
	public static void clearCache(TracciabilitaScheda tracciabilitaScheda) {
		getPersistence().clearCache(tracciabilitaScheda);
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
	public static List<TracciabilitaScheda> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TracciabilitaScheda> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TracciabilitaScheda> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TracciabilitaScheda update(
		TracciabilitaScheda tracciabilitaScheda) throws SystemException {
		return getPersistence().update(tracciabilitaScheda);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TracciabilitaScheda update(
		TracciabilitaScheda tracciabilitaScheda, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(tracciabilitaScheda, serviceContext);
	}

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
	public static java.util.List<it.bysoftware.ct.model.TracciabilitaScheda> findByAnnoIdAssociatoNDocumento(
		int anno, long idAssociato, long numeroDocumento,
		java.lang.String tipoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAnnoIdAssociatoNDocumento(anno, idAssociato,
			numeroDocumento, tipoDocumento);
	}

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
	public static java.util.List<it.bysoftware.ct.model.TracciabilitaScheda> findByAnnoIdAssociatoNDocumento(
		int anno, long idAssociato, long numeroDocumento,
		java.lang.String tipoDocumento, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAnnoIdAssociatoNDocumento(anno, idAssociato,
			numeroDocumento, tipoDocumento, start, end);
	}

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
	public static java.util.List<it.bysoftware.ct.model.TracciabilitaScheda> findByAnnoIdAssociatoNDocumento(
		int anno, long idAssociato, long numeroDocumento,
		java.lang.String tipoDocumento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAnnoIdAssociatoNDocumento(anno, idAssociato,
			numeroDocumento, tipoDocumento, start, end, orderByComparator);
	}

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
	public static it.bysoftware.ct.model.TracciabilitaScheda findByAnnoIdAssociatoNDocumento_First(
		int anno, long idAssociato, long numeroDocumento,
		java.lang.String tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTracciabilitaSchedaException {
		return getPersistence()
				   .findByAnnoIdAssociatoNDocumento_First(anno, idAssociato,
			numeroDocumento, tipoDocumento, orderByComparator);
	}

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
	public static it.bysoftware.ct.model.TracciabilitaScheda fetchByAnnoIdAssociatoNDocumento_First(
		int anno, long idAssociato, long numeroDocumento,
		java.lang.String tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAnnoIdAssociatoNDocumento_First(anno, idAssociato,
			numeroDocumento, tipoDocumento, orderByComparator);
	}

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
	public static it.bysoftware.ct.model.TracciabilitaScheda findByAnnoIdAssociatoNDocumento_Last(
		int anno, long idAssociato, long numeroDocumento,
		java.lang.String tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTracciabilitaSchedaException {
		return getPersistence()
				   .findByAnnoIdAssociatoNDocumento_Last(anno, idAssociato,
			numeroDocumento, tipoDocumento, orderByComparator);
	}

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
	public static it.bysoftware.ct.model.TracciabilitaScheda fetchByAnnoIdAssociatoNDocumento_Last(
		int anno, long idAssociato, long numeroDocumento,
		java.lang.String tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAnnoIdAssociatoNDocumento_Last(anno, idAssociato,
			numeroDocumento, tipoDocumento, orderByComparator);
	}

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
	public static it.bysoftware.ct.model.TracciabilitaScheda[] findByAnnoIdAssociatoNDocumento_PrevAndNext(
		long id, int anno, long idAssociato, long numeroDocumento,
		java.lang.String tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTracciabilitaSchedaException {
		return getPersistence()
				   .findByAnnoIdAssociatoNDocumento_PrevAndNext(id, anno,
			idAssociato, numeroDocumento, tipoDocumento, orderByComparator);
	}

	/**
	* Removes all the tracciabilita schedas where anno = &#63; and idAssociato = &#63; and numeroDocumento = &#63; and tipoDocumento = &#63; from the database.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param numeroDocumento the numero documento
	* @param tipoDocumento the tipo documento
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAnnoIdAssociatoNDocumento(int anno,
		long idAssociato, long numeroDocumento, java.lang.String tipoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByAnnoIdAssociatoNDocumento(anno, idAssociato,
			numeroDocumento, tipoDocumento);
	}

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
	public static int countByAnnoIdAssociatoNDocumento(int anno,
		long idAssociato, long numeroDocumento, java.lang.String tipoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByAnnoIdAssociatoNDocumento(anno, idAssociato,
			numeroDocumento, tipoDocumento);
	}

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
	public static it.bysoftware.ct.model.TracciabilitaScheda findByAnnoIdAssociatoNDocumentoCodiceProdotto(
		int anno, long idAssociato, long numeroDocumento,
		java.lang.String tipoDocumento, java.lang.String codiceProdotto)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTracciabilitaSchedaException {
		return getPersistence()
				   .findByAnnoIdAssociatoNDocumentoCodiceProdotto(anno,
			idAssociato, numeroDocumento, tipoDocumento, codiceProdotto);
	}

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
	public static it.bysoftware.ct.model.TracciabilitaScheda fetchByAnnoIdAssociatoNDocumentoCodiceProdotto(
		int anno, long idAssociato, long numeroDocumento,
		java.lang.String tipoDocumento, java.lang.String codiceProdotto)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAnnoIdAssociatoNDocumentoCodiceProdotto(anno,
			idAssociato, numeroDocumento, tipoDocumento, codiceProdotto);
	}

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
	public static it.bysoftware.ct.model.TracciabilitaScheda fetchByAnnoIdAssociatoNDocumentoCodiceProdotto(
		int anno, long idAssociato, long numeroDocumento,
		java.lang.String tipoDocumento, java.lang.String codiceProdotto,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAnnoIdAssociatoNDocumentoCodiceProdotto(anno,
			idAssociato, numeroDocumento, tipoDocumento, codiceProdotto,
			retrieveFromCache);
	}

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
	public static it.bysoftware.ct.model.TracciabilitaScheda removeByAnnoIdAssociatoNDocumentoCodiceProdotto(
		int anno, long idAssociato, long numeroDocumento,
		java.lang.String tipoDocumento, java.lang.String codiceProdotto)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTracciabilitaSchedaException {
		return getPersistence()
				   .removeByAnnoIdAssociatoNDocumentoCodiceProdotto(anno,
			idAssociato, numeroDocumento, tipoDocumento, codiceProdotto);
	}

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
	public static int countByAnnoIdAssociatoNDocumentoCodiceProdotto(int anno,
		long idAssociato, long numeroDocumento, java.lang.String tipoDocumento,
		java.lang.String codiceProdotto)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByAnnoIdAssociatoNDocumentoCodiceProdotto(anno,
			idAssociato, numeroDocumento, tipoDocumento, codiceProdotto);
	}

	/**
	* Caches the tracciabilita scheda in the entity cache if it is enabled.
	*
	* @param tracciabilitaScheda the tracciabilita scheda
	*/
	public static void cacheResult(
		it.bysoftware.ct.model.TracciabilitaScheda tracciabilitaScheda) {
		getPersistence().cacheResult(tracciabilitaScheda);
	}

	/**
	* Caches the tracciabilita schedas in the entity cache if it is enabled.
	*
	* @param tracciabilitaSchedas the tracciabilita schedas
	*/
	public static void cacheResult(
		java.util.List<it.bysoftware.ct.model.TracciabilitaScheda> tracciabilitaSchedas) {
		getPersistence().cacheResult(tracciabilitaSchedas);
	}

	/**
	* Creates a new tracciabilita scheda with the primary key. Does not add the tracciabilita scheda to the database.
	*
	* @param id the primary key for the new tracciabilita scheda
	* @return the new tracciabilita scheda
	*/
	public static it.bysoftware.ct.model.TracciabilitaScheda create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the tracciabilita scheda with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the tracciabilita scheda
	* @return the tracciabilita scheda that was removed
	* @throws it.bysoftware.ct.NoSuchTracciabilitaSchedaException if a tracciabilita scheda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.TracciabilitaScheda remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTracciabilitaSchedaException {
		return getPersistence().remove(id);
	}

	public static it.bysoftware.ct.model.TracciabilitaScheda updateImpl(
		it.bysoftware.ct.model.TracciabilitaScheda tracciabilitaScheda)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(tracciabilitaScheda);
	}

	/**
	* Returns the tracciabilita scheda with the primary key or throws a {@link it.bysoftware.ct.NoSuchTracciabilitaSchedaException} if it could not be found.
	*
	* @param id the primary key of the tracciabilita scheda
	* @return the tracciabilita scheda
	* @throws it.bysoftware.ct.NoSuchTracciabilitaSchedaException if a tracciabilita scheda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.TracciabilitaScheda findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTracciabilitaSchedaException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the tracciabilita scheda with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the tracciabilita scheda
	* @return the tracciabilita scheda, or <code>null</code> if a tracciabilita scheda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.TracciabilitaScheda fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the tracciabilita schedas.
	*
	* @return the tracciabilita schedas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.TracciabilitaScheda> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<it.bysoftware.ct.model.TracciabilitaScheda> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<it.bysoftware.ct.model.TracciabilitaScheda> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the tracciabilita schedas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tracciabilita schedas.
	*
	* @return the number of tracciabilita schedas
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TracciabilitaSchedaPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TracciabilitaSchedaPersistence)PortletBeanLocatorUtil.locate(it.bysoftware.ct.service.ClpSerializer.getServletContextName(),
					TracciabilitaSchedaPersistence.class.getName());

			ReferenceRegistry.registerReference(TracciabilitaSchedaUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TracciabilitaSchedaPersistence persistence) {
	}

	private static TracciabilitaSchedaPersistence _persistence;
}
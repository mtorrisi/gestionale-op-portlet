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

import it.bysoftware.ct.model.WKRigoDocumento;

import java.util.List;

/**
 * The persistence utility for the w k rigo documento service. This utility wraps {@link WKRigoDocumentoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WKRigoDocumentoPersistence
 * @see WKRigoDocumentoPersistenceImpl
 * @generated
 */
public class WKRigoDocumentoUtil {
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
	public static void clearCache(WKRigoDocumento wkRigoDocumento) {
		getPersistence().clearCache(wkRigoDocumento);
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
	public static List<WKRigoDocumento> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WKRigoDocumento> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WKRigoDocumento> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static WKRigoDocumento update(WKRigoDocumento wkRigoDocumento)
		throws SystemException {
		return getPersistence().update(wkRigoDocumento);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static WKRigoDocumento update(WKRigoDocumento wkRigoDocumento,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(wkRigoDocumento, serviceContext);
	}

	/**
	* Returns all the w k rigo documentos where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	*
	* @param numeroOrdine the numero ordine
	* @param anno the anno
	* @param idAssociato the id associato
	* @param tipoDocumento the tipo documento
	* @return the matching w k rigo documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.WKRigoDocumento> findBynumeroOrdineAnnoAssociato(
		long numeroOrdine, int anno, long idAssociato,
		java.lang.String tipoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBynumeroOrdineAnnoAssociato(numeroOrdine, anno,
			idAssociato, tipoDocumento);
	}

	/**
	* Returns a range of all the w k rigo documentos where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.WKRigoDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param numeroOrdine the numero ordine
	* @param anno the anno
	* @param idAssociato the id associato
	* @param tipoDocumento the tipo documento
	* @param start the lower bound of the range of w k rigo documentos
	* @param end the upper bound of the range of w k rigo documentos (not inclusive)
	* @return the range of matching w k rigo documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.WKRigoDocumento> findBynumeroOrdineAnnoAssociato(
		long numeroOrdine, int anno, long idAssociato,
		java.lang.String tipoDocumento, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBynumeroOrdineAnnoAssociato(numeroOrdine, anno,
			idAssociato, tipoDocumento, start, end);
	}

	/**
	* Returns an ordered range of all the w k rigo documentos where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.WKRigoDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param numeroOrdine the numero ordine
	* @param anno the anno
	* @param idAssociato the id associato
	* @param tipoDocumento the tipo documento
	* @param start the lower bound of the range of w k rigo documentos
	* @param end the upper bound of the range of w k rigo documentos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching w k rigo documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.WKRigoDocumento> findBynumeroOrdineAnnoAssociato(
		long numeroOrdine, int anno, long idAssociato,
		java.lang.String tipoDocumento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBynumeroOrdineAnnoAssociato(numeroOrdine, anno,
			idAssociato, tipoDocumento, start, end, orderByComparator);
	}

	/**
	* Returns the first w k rigo documento in the ordered set where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	*
	* @param numeroOrdine the numero ordine
	* @param anno the anno
	* @param idAssociato the id associato
	* @param tipoDocumento the tipo documento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w k rigo documento
	* @throws it.bysoftware.ct.NoSuchWKRigoDocumentoException if a matching w k rigo documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.WKRigoDocumento findBynumeroOrdineAnnoAssociato_First(
		long numeroOrdine, int anno, long idAssociato,
		java.lang.String tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchWKRigoDocumentoException {
		return getPersistence()
				   .findBynumeroOrdineAnnoAssociato_First(numeroOrdine, anno,
			idAssociato, tipoDocumento, orderByComparator);
	}

	/**
	* Returns the first w k rigo documento in the ordered set where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	*
	* @param numeroOrdine the numero ordine
	* @param anno the anno
	* @param idAssociato the id associato
	* @param tipoDocumento the tipo documento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w k rigo documento, or <code>null</code> if a matching w k rigo documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.WKRigoDocumento fetchBynumeroOrdineAnnoAssociato_First(
		long numeroOrdine, int anno, long idAssociato,
		java.lang.String tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBynumeroOrdineAnnoAssociato_First(numeroOrdine, anno,
			idAssociato, tipoDocumento, orderByComparator);
	}

	/**
	* Returns the last w k rigo documento in the ordered set where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	*
	* @param numeroOrdine the numero ordine
	* @param anno the anno
	* @param idAssociato the id associato
	* @param tipoDocumento the tipo documento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w k rigo documento
	* @throws it.bysoftware.ct.NoSuchWKRigoDocumentoException if a matching w k rigo documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.WKRigoDocumento findBynumeroOrdineAnnoAssociato_Last(
		long numeroOrdine, int anno, long idAssociato,
		java.lang.String tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchWKRigoDocumentoException {
		return getPersistence()
				   .findBynumeroOrdineAnnoAssociato_Last(numeroOrdine, anno,
			idAssociato, tipoDocumento, orderByComparator);
	}

	/**
	* Returns the last w k rigo documento in the ordered set where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	*
	* @param numeroOrdine the numero ordine
	* @param anno the anno
	* @param idAssociato the id associato
	* @param tipoDocumento the tipo documento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w k rigo documento, or <code>null</code> if a matching w k rigo documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.WKRigoDocumento fetchBynumeroOrdineAnnoAssociato_Last(
		long numeroOrdine, int anno, long idAssociato,
		java.lang.String tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBynumeroOrdineAnnoAssociato_Last(numeroOrdine, anno,
			idAssociato, tipoDocumento, orderByComparator);
	}

	/**
	* Returns the w k rigo documentos before and after the current w k rigo documento in the ordered set where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	*
	* @param wkRigoDocumentoPK the primary key of the current w k rigo documento
	* @param numeroOrdine the numero ordine
	* @param anno the anno
	* @param idAssociato the id associato
	* @param tipoDocumento the tipo documento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next w k rigo documento
	* @throws it.bysoftware.ct.NoSuchWKRigoDocumentoException if a w k rigo documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.WKRigoDocumento[] findBynumeroOrdineAnnoAssociato_PrevAndNext(
		it.bysoftware.ct.service.persistence.WKRigoDocumentoPK wkRigoDocumentoPK,
		long numeroOrdine, int anno, long idAssociato,
		java.lang.String tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchWKRigoDocumentoException {
		return getPersistence()
				   .findBynumeroOrdineAnnoAssociato_PrevAndNext(wkRigoDocumentoPK,
			numeroOrdine, anno, idAssociato, tipoDocumento, orderByComparator);
	}

	/**
	* Removes all the w k rigo documentos where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63; from the database.
	*
	* @param numeroOrdine the numero ordine
	* @param anno the anno
	* @param idAssociato the id associato
	* @param tipoDocumento the tipo documento
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBynumeroOrdineAnnoAssociato(long numeroOrdine,
		int anno, long idAssociato, java.lang.String tipoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeBynumeroOrdineAnnoAssociato(numeroOrdine, anno, idAssociato,
			tipoDocumento);
	}

	/**
	* Returns the number of w k rigo documentos where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	*
	* @param numeroOrdine the numero ordine
	* @param anno the anno
	* @param idAssociato the id associato
	* @param tipoDocumento the tipo documento
	* @return the number of matching w k rigo documentos
	* @throws SystemException if a system exception occurred
	*/
	public static int countBynumeroOrdineAnnoAssociato(long numeroOrdine,
		int anno, long idAssociato, java.lang.String tipoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countBynumeroOrdineAnnoAssociato(numeroOrdine, anno,
			idAssociato, tipoDocumento);
	}

	/**
	* Returns all the w k rigo documentos where anno = &#63; and idAssociato = &#63;.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @return the matching w k rigo documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.WKRigoDocumento> findByAnnoAssociato(
		int anno, long idAssociato)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAnnoAssociato(anno, idAssociato);
	}

	/**
	* Returns a range of all the w k rigo documentos where anno = &#63; and idAssociato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.WKRigoDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param start the lower bound of the range of w k rigo documentos
	* @param end the upper bound of the range of w k rigo documentos (not inclusive)
	* @return the range of matching w k rigo documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.WKRigoDocumento> findByAnnoAssociato(
		int anno, long idAssociato, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAnnoAssociato(anno, idAssociato, start, end);
	}

	/**
	* Returns an ordered range of all the w k rigo documentos where anno = &#63; and idAssociato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.WKRigoDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param start the lower bound of the range of w k rigo documentos
	* @param end the upper bound of the range of w k rigo documentos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching w k rigo documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.WKRigoDocumento> findByAnnoAssociato(
		int anno, long idAssociato, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAnnoAssociato(anno, idAssociato, start, end,
			orderByComparator);
	}

	/**
	* Returns the first w k rigo documento in the ordered set where anno = &#63; and idAssociato = &#63;.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w k rigo documento
	* @throws it.bysoftware.ct.NoSuchWKRigoDocumentoException if a matching w k rigo documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.WKRigoDocumento findByAnnoAssociato_First(
		int anno, long idAssociato,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchWKRigoDocumentoException {
		return getPersistence()
				   .findByAnnoAssociato_First(anno, idAssociato,
			orderByComparator);
	}

	/**
	* Returns the first w k rigo documento in the ordered set where anno = &#63; and idAssociato = &#63;.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w k rigo documento, or <code>null</code> if a matching w k rigo documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.WKRigoDocumento fetchByAnnoAssociato_First(
		int anno, long idAssociato,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAnnoAssociato_First(anno, idAssociato,
			orderByComparator);
	}

	/**
	* Returns the last w k rigo documento in the ordered set where anno = &#63; and idAssociato = &#63;.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w k rigo documento
	* @throws it.bysoftware.ct.NoSuchWKRigoDocumentoException if a matching w k rigo documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.WKRigoDocumento findByAnnoAssociato_Last(
		int anno, long idAssociato,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchWKRigoDocumentoException {
		return getPersistence()
				   .findByAnnoAssociato_Last(anno, idAssociato,
			orderByComparator);
	}

	/**
	* Returns the last w k rigo documento in the ordered set where anno = &#63; and idAssociato = &#63;.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w k rigo documento, or <code>null</code> if a matching w k rigo documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.WKRigoDocumento fetchByAnnoAssociato_Last(
		int anno, long idAssociato,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAnnoAssociato_Last(anno, idAssociato,
			orderByComparator);
	}

	/**
	* Returns the w k rigo documentos before and after the current w k rigo documento in the ordered set where anno = &#63; and idAssociato = &#63;.
	*
	* @param wkRigoDocumentoPK the primary key of the current w k rigo documento
	* @param anno the anno
	* @param idAssociato the id associato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next w k rigo documento
	* @throws it.bysoftware.ct.NoSuchWKRigoDocumentoException if a w k rigo documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.WKRigoDocumento[] findByAnnoAssociato_PrevAndNext(
		it.bysoftware.ct.service.persistence.WKRigoDocumentoPK wkRigoDocumentoPK,
		int anno, long idAssociato,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchWKRigoDocumentoException {
		return getPersistence()
				   .findByAnnoAssociato_PrevAndNext(wkRigoDocumentoPK, anno,
			idAssociato, orderByComparator);
	}

	/**
	* Removes all the w k rigo documentos where anno = &#63; and idAssociato = &#63; from the database.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAnnoAssociato(int anno, long idAssociato)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAnnoAssociato(anno, idAssociato);
	}

	/**
	* Returns the number of w k rigo documentos where anno = &#63; and idAssociato = &#63;.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @return the number of matching w k rigo documentos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAnnoAssociato(int anno, long idAssociato)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAnnoAssociato(anno, idAssociato);
	}

	/**
	* Caches the w k rigo documento in the entity cache if it is enabled.
	*
	* @param wkRigoDocumento the w k rigo documento
	*/
	public static void cacheResult(
		it.bysoftware.ct.model.WKRigoDocumento wkRigoDocumento) {
		getPersistence().cacheResult(wkRigoDocumento);
	}

	/**
	* Caches the w k rigo documentos in the entity cache if it is enabled.
	*
	* @param wkRigoDocumentos the w k rigo documentos
	*/
	public static void cacheResult(
		java.util.List<it.bysoftware.ct.model.WKRigoDocumento> wkRigoDocumentos) {
		getPersistence().cacheResult(wkRigoDocumentos);
	}

	/**
	* Creates a new w k rigo documento with the primary key. Does not add the w k rigo documento to the database.
	*
	* @param wkRigoDocumentoPK the primary key for the new w k rigo documento
	* @return the new w k rigo documento
	*/
	public static it.bysoftware.ct.model.WKRigoDocumento create(
		it.bysoftware.ct.service.persistence.WKRigoDocumentoPK wkRigoDocumentoPK) {
		return getPersistence().create(wkRigoDocumentoPK);
	}

	/**
	* Removes the w k rigo documento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wkRigoDocumentoPK the primary key of the w k rigo documento
	* @return the w k rigo documento that was removed
	* @throws it.bysoftware.ct.NoSuchWKRigoDocumentoException if a w k rigo documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.WKRigoDocumento remove(
		it.bysoftware.ct.service.persistence.WKRigoDocumentoPK wkRigoDocumentoPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchWKRigoDocumentoException {
		return getPersistence().remove(wkRigoDocumentoPK);
	}

	public static it.bysoftware.ct.model.WKRigoDocumento updateImpl(
		it.bysoftware.ct.model.WKRigoDocumento wkRigoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(wkRigoDocumento);
	}

	/**
	* Returns the w k rigo documento with the primary key or throws a {@link it.bysoftware.ct.NoSuchWKRigoDocumentoException} if it could not be found.
	*
	* @param wkRigoDocumentoPK the primary key of the w k rigo documento
	* @return the w k rigo documento
	* @throws it.bysoftware.ct.NoSuchWKRigoDocumentoException if a w k rigo documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.WKRigoDocumento findByPrimaryKey(
		it.bysoftware.ct.service.persistence.WKRigoDocumentoPK wkRigoDocumentoPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchWKRigoDocumentoException {
		return getPersistence().findByPrimaryKey(wkRigoDocumentoPK);
	}

	/**
	* Returns the w k rigo documento with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param wkRigoDocumentoPK the primary key of the w k rigo documento
	* @return the w k rigo documento, or <code>null</code> if a w k rigo documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.WKRigoDocumento fetchByPrimaryKey(
		it.bysoftware.ct.service.persistence.WKRigoDocumentoPK wkRigoDocumentoPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(wkRigoDocumentoPK);
	}

	/**
	* Returns all the w k rigo documentos.
	*
	* @return the w k rigo documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.WKRigoDocumento> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the w k rigo documentos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.WKRigoDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of w k rigo documentos
	* @param end the upper bound of the range of w k rigo documentos (not inclusive)
	* @return the range of w k rigo documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.WKRigoDocumento> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the w k rigo documentos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.WKRigoDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of w k rigo documentos
	* @param end the upper bound of the range of w k rigo documentos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of w k rigo documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.WKRigoDocumento> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the w k rigo documentos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of w k rigo documentos.
	*
	* @return the number of w k rigo documentos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static WKRigoDocumentoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (WKRigoDocumentoPersistence)PortletBeanLocatorUtil.locate(it.bysoftware.ct.service.ClpSerializer.getServletContextName(),
					WKRigoDocumentoPersistence.class.getName());

			ReferenceRegistry.registerReference(WKRigoDocumentoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(WKRigoDocumentoPersistence persistence) {
	}

	private static WKRigoDocumentoPersistence _persistence;
}
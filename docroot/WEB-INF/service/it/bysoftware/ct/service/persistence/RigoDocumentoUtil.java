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

import it.bysoftware.ct.model.RigoDocumento;

import java.util.List;

/**
 * The persistence utility for the rigo documento service. This utility wraps {@link RigoDocumentoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RigoDocumentoPersistence
 * @see RigoDocumentoPersistenceImpl
 * @generated
 */
public class RigoDocumentoUtil {
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
	public static void clearCache(RigoDocumento rigoDocumento) {
		getPersistence().clearCache(rigoDocumento);
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
	public static List<RigoDocumento> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RigoDocumento> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RigoDocumento> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static RigoDocumento update(RigoDocumento rigoDocumento)
		throws SystemException {
		return getPersistence().update(rigoDocumento);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static RigoDocumento update(RigoDocumento rigoDocumento,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(rigoDocumento, serviceContext);
	}

	/**
	* Returns all the rigo documentos where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	*
	* @param numeroOrdine the numero ordine
	* @param anno the anno
	* @param idAssociato the id associato
	* @param tipoDocumento the tipo documento
	* @return the matching rigo documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.RigoDocumento> findBynumeroOrdineAnnoAssociato(
		long numeroOrdine, int anno, long idAssociato,
		java.lang.String tipoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBynumeroOrdineAnnoAssociato(numeroOrdine, anno,
			idAssociato, tipoDocumento);
	}

	/**
	* Returns a range of all the rigo documentos where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.RigoDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param numeroOrdine the numero ordine
	* @param anno the anno
	* @param idAssociato the id associato
	* @param tipoDocumento the tipo documento
	* @param start the lower bound of the range of rigo documentos
	* @param end the upper bound of the range of rigo documentos (not inclusive)
	* @return the range of matching rigo documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.RigoDocumento> findBynumeroOrdineAnnoAssociato(
		long numeroOrdine, int anno, long idAssociato,
		java.lang.String tipoDocumento, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBynumeroOrdineAnnoAssociato(numeroOrdine, anno,
			idAssociato, tipoDocumento, start, end);
	}

	/**
	* Returns an ordered range of all the rigo documentos where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.RigoDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param numeroOrdine the numero ordine
	* @param anno the anno
	* @param idAssociato the id associato
	* @param tipoDocumento the tipo documento
	* @param start the lower bound of the range of rigo documentos
	* @param end the upper bound of the range of rigo documentos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rigo documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.RigoDocumento> findBynumeroOrdineAnnoAssociato(
		long numeroOrdine, int anno, long idAssociato,
		java.lang.String tipoDocumento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBynumeroOrdineAnnoAssociato(numeroOrdine, anno,
			idAssociato, tipoDocumento, start, end, orderByComparator);
	}

	/**
	* Returns the first rigo documento in the ordered set where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	*
	* @param numeroOrdine the numero ordine
	* @param anno the anno
	* @param idAssociato the id associato
	* @param tipoDocumento the tipo documento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rigo documento
	* @throws it.bysoftware.ct.NoSuchRigoDocumentoException if a matching rigo documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.RigoDocumento findBynumeroOrdineAnnoAssociato_First(
		long numeroOrdine, int anno, long idAssociato,
		java.lang.String tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchRigoDocumentoException {
		return getPersistence()
				   .findBynumeroOrdineAnnoAssociato_First(numeroOrdine, anno,
			idAssociato, tipoDocumento, orderByComparator);
	}

	/**
	* Returns the first rigo documento in the ordered set where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	*
	* @param numeroOrdine the numero ordine
	* @param anno the anno
	* @param idAssociato the id associato
	* @param tipoDocumento the tipo documento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rigo documento, or <code>null</code> if a matching rigo documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.RigoDocumento fetchBynumeroOrdineAnnoAssociato_First(
		long numeroOrdine, int anno, long idAssociato,
		java.lang.String tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBynumeroOrdineAnnoAssociato_First(numeroOrdine, anno,
			idAssociato, tipoDocumento, orderByComparator);
	}

	/**
	* Returns the last rigo documento in the ordered set where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	*
	* @param numeroOrdine the numero ordine
	* @param anno the anno
	* @param idAssociato the id associato
	* @param tipoDocumento the tipo documento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rigo documento
	* @throws it.bysoftware.ct.NoSuchRigoDocumentoException if a matching rigo documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.RigoDocumento findBynumeroOrdineAnnoAssociato_Last(
		long numeroOrdine, int anno, long idAssociato,
		java.lang.String tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchRigoDocumentoException {
		return getPersistence()
				   .findBynumeroOrdineAnnoAssociato_Last(numeroOrdine, anno,
			idAssociato, tipoDocumento, orderByComparator);
	}

	/**
	* Returns the last rigo documento in the ordered set where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	*
	* @param numeroOrdine the numero ordine
	* @param anno the anno
	* @param idAssociato the id associato
	* @param tipoDocumento the tipo documento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rigo documento, or <code>null</code> if a matching rigo documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.RigoDocumento fetchBynumeroOrdineAnnoAssociato_Last(
		long numeroOrdine, int anno, long idAssociato,
		java.lang.String tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBynumeroOrdineAnnoAssociato_Last(numeroOrdine, anno,
			idAssociato, tipoDocumento, orderByComparator);
	}

	/**
	* Returns the rigo documentos before and after the current rigo documento in the ordered set where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	*
	* @param rigoDocumentoPK the primary key of the current rigo documento
	* @param numeroOrdine the numero ordine
	* @param anno the anno
	* @param idAssociato the id associato
	* @param tipoDocumento the tipo documento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rigo documento
	* @throws it.bysoftware.ct.NoSuchRigoDocumentoException if a rigo documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.RigoDocumento[] findBynumeroOrdineAnnoAssociato_PrevAndNext(
		it.bysoftware.ct.service.persistence.RigoDocumentoPK rigoDocumentoPK,
		long numeroOrdine, int anno, long idAssociato,
		java.lang.String tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchRigoDocumentoException {
		return getPersistence()
				   .findBynumeroOrdineAnnoAssociato_PrevAndNext(rigoDocumentoPK,
			numeroOrdine, anno, idAssociato, tipoDocumento, orderByComparator);
	}

	/**
	* Removes all the rigo documentos where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63; from the database.
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
	* Returns the number of rigo documentos where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	*
	* @param numeroOrdine the numero ordine
	* @param anno the anno
	* @param idAssociato the id associato
	* @param tipoDocumento the tipo documento
	* @return the number of matching rigo documentos
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
	* Returns all the rigo documentos where numeroOrdine = &#63; and anno = &#63; and tipoDocumento = &#63; and codiceArticolo = &#63; and codiceVariante = &#63; and imballo = &#63; and idAssociato = &#63;.
	*
	* @param numeroOrdine the numero ordine
	* @param anno the anno
	* @param tipoDocumento the tipo documento
	* @param codiceArticolo the codice articolo
	* @param codiceVariante the codice variante
	* @param imballo the imballo
	* @param idAssociato the id associato
	* @return the matching rigo documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.RigoDocumento> findBynumeroOrdineAnnoAssociatoArticolo(
		long numeroOrdine, int anno, java.lang.String tipoDocumento,
		java.lang.String codiceArticolo, java.lang.String codiceVariante,
		java.lang.String imballo, long idAssociato)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBynumeroOrdineAnnoAssociatoArticolo(numeroOrdine, anno,
			tipoDocumento, codiceArticolo, codiceVariante, imballo, idAssociato);
	}

	/**
	* Returns a range of all the rigo documentos where numeroOrdine = &#63; and anno = &#63; and tipoDocumento = &#63; and codiceArticolo = &#63; and codiceVariante = &#63; and imballo = &#63; and idAssociato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.RigoDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param numeroOrdine the numero ordine
	* @param anno the anno
	* @param tipoDocumento the tipo documento
	* @param codiceArticolo the codice articolo
	* @param codiceVariante the codice variante
	* @param imballo the imballo
	* @param idAssociato the id associato
	* @param start the lower bound of the range of rigo documentos
	* @param end the upper bound of the range of rigo documentos (not inclusive)
	* @return the range of matching rigo documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.RigoDocumento> findBynumeroOrdineAnnoAssociatoArticolo(
		long numeroOrdine, int anno, java.lang.String tipoDocumento,
		java.lang.String codiceArticolo, java.lang.String codiceVariante,
		java.lang.String imballo, long idAssociato, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBynumeroOrdineAnnoAssociatoArticolo(numeroOrdine, anno,
			tipoDocumento, codiceArticolo, codiceVariante, imballo,
			idAssociato, start, end);
	}

	/**
	* Returns an ordered range of all the rigo documentos where numeroOrdine = &#63; and anno = &#63; and tipoDocumento = &#63; and codiceArticolo = &#63; and codiceVariante = &#63; and imballo = &#63; and idAssociato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.RigoDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param numeroOrdine the numero ordine
	* @param anno the anno
	* @param tipoDocumento the tipo documento
	* @param codiceArticolo the codice articolo
	* @param codiceVariante the codice variante
	* @param imballo the imballo
	* @param idAssociato the id associato
	* @param start the lower bound of the range of rigo documentos
	* @param end the upper bound of the range of rigo documentos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rigo documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.RigoDocumento> findBynumeroOrdineAnnoAssociatoArticolo(
		long numeroOrdine, int anno, java.lang.String tipoDocumento,
		java.lang.String codiceArticolo, java.lang.String codiceVariante,
		java.lang.String imballo, long idAssociato, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBynumeroOrdineAnnoAssociatoArticolo(numeroOrdine, anno,
			tipoDocumento, codiceArticolo, codiceVariante, imballo,
			idAssociato, start, end, orderByComparator);
	}

	/**
	* Returns the first rigo documento in the ordered set where numeroOrdine = &#63; and anno = &#63; and tipoDocumento = &#63; and codiceArticolo = &#63; and codiceVariante = &#63; and imballo = &#63; and idAssociato = &#63;.
	*
	* @param numeroOrdine the numero ordine
	* @param anno the anno
	* @param tipoDocumento the tipo documento
	* @param codiceArticolo the codice articolo
	* @param codiceVariante the codice variante
	* @param imballo the imballo
	* @param idAssociato the id associato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rigo documento
	* @throws it.bysoftware.ct.NoSuchRigoDocumentoException if a matching rigo documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.RigoDocumento findBynumeroOrdineAnnoAssociatoArticolo_First(
		long numeroOrdine, int anno, java.lang.String tipoDocumento,
		java.lang.String codiceArticolo, java.lang.String codiceVariante,
		java.lang.String imballo, long idAssociato,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchRigoDocumentoException {
		return getPersistence()
				   .findBynumeroOrdineAnnoAssociatoArticolo_First(numeroOrdine,
			anno, tipoDocumento, codiceArticolo, codiceVariante, imballo,
			idAssociato, orderByComparator);
	}

	/**
	* Returns the first rigo documento in the ordered set where numeroOrdine = &#63; and anno = &#63; and tipoDocumento = &#63; and codiceArticolo = &#63; and codiceVariante = &#63; and imballo = &#63; and idAssociato = &#63;.
	*
	* @param numeroOrdine the numero ordine
	* @param anno the anno
	* @param tipoDocumento the tipo documento
	* @param codiceArticolo the codice articolo
	* @param codiceVariante the codice variante
	* @param imballo the imballo
	* @param idAssociato the id associato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rigo documento, or <code>null</code> if a matching rigo documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.RigoDocumento fetchBynumeroOrdineAnnoAssociatoArticolo_First(
		long numeroOrdine, int anno, java.lang.String tipoDocumento,
		java.lang.String codiceArticolo, java.lang.String codiceVariante,
		java.lang.String imballo, long idAssociato,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBynumeroOrdineAnnoAssociatoArticolo_First(numeroOrdine,
			anno, tipoDocumento, codiceArticolo, codiceVariante, imballo,
			idAssociato, orderByComparator);
	}

	/**
	* Returns the last rigo documento in the ordered set where numeroOrdine = &#63; and anno = &#63; and tipoDocumento = &#63; and codiceArticolo = &#63; and codiceVariante = &#63; and imballo = &#63; and idAssociato = &#63;.
	*
	* @param numeroOrdine the numero ordine
	* @param anno the anno
	* @param tipoDocumento the tipo documento
	* @param codiceArticolo the codice articolo
	* @param codiceVariante the codice variante
	* @param imballo the imballo
	* @param idAssociato the id associato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rigo documento
	* @throws it.bysoftware.ct.NoSuchRigoDocumentoException if a matching rigo documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.RigoDocumento findBynumeroOrdineAnnoAssociatoArticolo_Last(
		long numeroOrdine, int anno, java.lang.String tipoDocumento,
		java.lang.String codiceArticolo, java.lang.String codiceVariante,
		java.lang.String imballo, long idAssociato,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchRigoDocumentoException {
		return getPersistence()
				   .findBynumeroOrdineAnnoAssociatoArticolo_Last(numeroOrdine,
			anno, tipoDocumento, codiceArticolo, codiceVariante, imballo,
			idAssociato, orderByComparator);
	}

	/**
	* Returns the last rigo documento in the ordered set where numeroOrdine = &#63; and anno = &#63; and tipoDocumento = &#63; and codiceArticolo = &#63; and codiceVariante = &#63; and imballo = &#63; and idAssociato = &#63;.
	*
	* @param numeroOrdine the numero ordine
	* @param anno the anno
	* @param tipoDocumento the tipo documento
	* @param codiceArticolo the codice articolo
	* @param codiceVariante the codice variante
	* @param imballo the imballo
	* @param idAssociato the id associato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rigo documento, or <code>null</code> if a matching rigo documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.RigoDocumento fetchBynumeroOrdineAnnoAssociatoArticolo_Last(
		long numeroOrdine, int anno, java.lang.String tipoDocumento,
		java.lang.String codiceArticolo, java.lang.String codiceVariante,
		java.lang.String imballo, long idAssociato,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBynumeroOrdineAnnoAssociatoArticolo_Last(numeroOrdine,
			anno, tipoDocumento, codiceArticolo, codiceVariante, imballo,
			idAssociato, orderByComparator);
	}

	/**
	* Returns the rigo documentos before and after the current rigo documento in the ordered set where numeroOrdine = &#63; and anno = &#63; and tipoDocumento = &#63; and codiceArticolo = &#63; and codiceVariante = &#63; and imballo = &#63; and idAssociato = &#63;.
	*
	* @param rigoDocumentoPK the primary key of the current rigo documento
	* @param numeroOrdine the numero ordine
	* @param anno the anno
	* @param tipoDocumento the tipo documento
	* @param codiceArticolo the codice articolo
	* @param codiceVariante the codice variante
	* @param imballo the imballo
	* @param idAssociato the id associato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rigo documento
	* @throws it.bysoftware.ct.NoSuchRigoDocumentoException if a rigo documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.RigoDocumento[] findBynumeroOrdineAnnoAssociatoArticolo_PrevAndNext(
		it.bysoftware.ct.service.persistence.RigoDocumentoPK rigoDocumentoPK,
		long numeroOrdine, int anno, java.lang.String tipoDocumento,
		java.lang.String codiceArticolo, java.lang.String codiceVariante,
		java.lang.String imballo, long idAssociato,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchRigoDocumentoException {
		return getPersistence()
				   .findBynumeroOrdineAnnoAssociatoArticolo_PrevAndNext(rigoDocumentoPK,
			numeroOrdine, anno, tipoDocumento, codiceArticolo, codiceVariante,
			imballo, idAssociato, orderByComparator);
	}

	/**
	* Removes all the rigo documentos where numeroOrdine = &#63; and anno = &#63; and tipoDocumento = &#63; and codiceArticolo = &#63; and codiceVariante = &#63; and imballo = &#63; and idAssociato = &#63; from the database.
	*
	* @param numeroOrdine the numero ordine
	* @param anno the anno
	* @param tipoDocumento the tipo documento
	* @param codiceArticolo the codice articolo
	* @param codiceVariante the codice variante
	* @param imballo the imballo
	* @param idAssociato the id associato
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBynumeroOrdineAnnoAssociatoArticolo(
		long numeroOrdine, int anno, java.lang.String tipoDocumento,
		java.lang.String codiceArticolo, java.lang.String codiceVariante,
		java.lang.String imballo, long idAssociato)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeBynumeroOrdineAnnoAssociatoArticolo(numeroOrdine, anno,
			tipoDocumento, codiceArticolo, codiceVariante, imballo, idAssociato);
	}

	/**
	* Returns the number of rigo documentos where numeroOrdine = &#63; and anno = &#63; and tipoDocumento = &#63; and codiceArticolo = &#63; and codiceVariante = &#63; and imballo = &#63; and idAssociato = &#63;.
	*
	* @param numeroOrdine the numero ordine
	* @param anno the anno
	* @param tipoDocumento the tipo documento
	* @param codiceArticolo the codice articolo
	* @param codiceVariante the codice variante
	* @param imballo the imballo
	* @param idAssociato the id associato
	* @return the number of matching rigo documentos
	* @throws SystemException if a system exception occurred
	*/
	public static int countBynumeroOrdineAnnoAssociatoArticolo(
		long numeroOrdine, int anno, java.lang.String tipoDocumento,
		java.lang.String codiceArticolo, java.lang.String codiceVariante,
		java.lang.String imballo, long idAssociato)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countBynumeroOrdineAnnoAssociatoArticolo(numeroOrdine,
			anno, tipoDocumento, codiceArticolo, codiceVariante, imballo,
			idAssociato);
	}

	/**
	* Caches the rigo documento in the entity cache if it is enabled.
	*
	* @param rigoDocumento the rigo documento
	*/
	public static void cacheResult(
		it.bysoftware.ct.model.RigoDocumento rigoDocumento) {
		getPersistence().cacheResult(rigoDocumento);
	}

	/**
	* Caches the rigo documentos in the entity cache if it is enabled.
	*
	* @param rigoDocumentos the rigo documentos
	*/
	public static void cacheResult(
		java.util.List<it.bysoftware.ct.model.RigoDocumento> rigoDocumentos) {
		getPersistence().cacheResult(rigoDocumentos);
	}

	/**
	* Creates a new rigo documento with the primary key. Does not add the rigo documento to the database.
	*
	* @param rigoDocumentoPK the primary key for the new rigo documento
	* @return the new rigo documento
	*/
	public static it.bysoftware.ct.model.RigoDocumento create(
		it.bysoftware.ct.service.persistence.RigoDocumentoPK rigoDocumentoPK) {
		return getPersistence().create(rigoDocumentoPK);
	}

	/**
	* Removes the rigo documento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rigoDocumentoPK the primary key of the rigo documento
	* @return the rigo documento that was removed
	* @throws it.bysoftware.ct.NoSuchRigoDocumentoException if a rigo documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.RigoDocumento remove(
		it.bysoftware.ct.service.persistence.RigoDocumentoPK rigoDocumentoPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchRigoDocumentoException {
		return getPersistence().remove(rigoDocumentoPK);
	}

	public static it.bysoftware.ct.model.RigoDocumento updateImpl(
		it.bysoftware.ct.model.RigoDocumento rigoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(rigoDocumento);
	}

	/**
	* Returns the rigo documento with the primary key or throws a {@link it.bysoftware.ct.NoSuchRigoDocumentoException} if it could not be found.
	*
	* @param rigoDocumentoPK the primary key of the rigo documento
	* @return the rigo documento
	* @throws it.bysoftware.ct.NoSuchRigoDocumentoException if a rigo documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.RigoDocumento findByPrimaryKey(
		it.bysoftware.ct.service.persistence.RigoDocumentoPK rigoDocumentoPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchRigoDocumentoException {
		return getPersistence().findByPrimaryKey(rigoDocumentoPK);
	}

	/**
	* Returns the rigo documento with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param rigoDocumentoPK the primary key of the rigo documento
	* @return the rigo documento, or <code>null</code> if a rigo documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.RigoDocumento fetchByPrimaryKey(
		it.bysoftware.ct.service.persistence.RigoDocumentoPK rigoDocumentoPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(rigoDocumentoPK);
	}

	/**
	* Returns all the rigo documentos.
	*
	* @return the rigo documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.RigoDocumento> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the rigo documentos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.RigoDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rigo documentos
	* @param end the upper bound of the range of rigo documentos (not inclusive)
	* @return the range of rigo documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.RigoDocumento> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the rigo documentos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.RigoDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rigo documentos
	* @param end the upper bound of the range of rigo documentos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of rigo documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.RigoDocumento> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the rigo documentos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of rigo documentos.
	*
	* @return the number of rigo documentos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static RigoDocumentoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (RigoDocumentoPersistence)PortletBeanLocatorUtil.locate(it.bysoftware.ct.service.ClpSerializer.getServletContextName(),
					RigoDocumentoPersistence.class.getName());

			ReferenceRegistry.registerReference(RigoDocumentoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(RigoDocumentoPersistence persistence) {
	}

	private static RigoDocumentoPersistence _persistence;
}
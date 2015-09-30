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

import it.bysoftware.ct.model.RigoDocumento;

/**
 * The persistence interface for the rigo documento service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RigoDocumentoPersistenceImpl
 * @see RigoDocumentoUtil
 * @generated
 */
public interface RigoDocumentoPersistence extends BasePersistence<RigoDocumento> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RigoDocumentoUtil} to access the rigo documento persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

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
	public java.util.List<it.bysoftware.ct.model.RigoDocumento> findBynumeroOrdineAnnoAssociato(
		long numeroOrdine, int anno, long idAssociato,
		java.lang.String tipoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.bysoftware.ct.model.RigoDocumento> findBynumeroOrdineAnnoAssociato(
		long numeroOrdine, int anno, long idAssociato,
		java.lang.String tipoDocumento, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.bysoftware.ct.model.RigoDocumento> findBynumeroOrdineAnnoAssociato(
		long numeroOrdine, int anno, long idAssociato,
		java.lang.String tipoDocumento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.bysoftware.ct.model.RigoDocumento findBynumeroOrdineAnnoAssociato_First(
		long numeroOrdine, int anno, long idAssociato,
		java.lang.String tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchRigoDocumentoException;

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
	public it.bysoftware.ct.model.RigoDocumento fetchBynumeroOrdineAnnoAssociato_First(
		long numeroOrdine, int anno, long idAssociato,
		java.lang.String tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.bysoftware.ct.model.RigoDocumento findBynumeroOrdineAnnoAssociato_Last(
		long numeroOrdine, int anno, long idAssociato,
		java.lang.String tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchRigoDocumentoException;

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
	public it.bysoftware.ct.model.RigoDocumento fetchBynumeroOrdineAnnoAssociato_Last(
		long numeroOrdine, int anno, long idAssociato,
		java.lang.String tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.bysoftware.ct.model.RigoDocumento[] findBynumeroOrdineAnnoAssociato_PrevAndNext(
		it.bysoftware.ct.service.persistence.RigoDocumentoPK rigoDocumentoPK,
		long numeroOrdine, int anno, long idAssociato,
		java.lang.String tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchRigoDocumentoException;

	/**
	* Removes all the rigo documentos where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63; from the database.
	*
	* @param numeroOrdine the numero ordine
	* @param anno the anno
	* @param idAssociato the id associato
	* @param tipoDocumento the tipo documento
	* @throws SystemException if a system exception occurred
	*/
	public void removeBynumeroOrdineAnnoAssociato(long numeroOrdine, int anno,
		long idAssociato, java.lang.String tipoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countBynumeroOrdineAnnoAssociato(long numeroOrdine, int anno,
		long idAssociato, java.lang.String tipoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the rigo documento in the entity cache if it is enabled.
	*
	* @param rigoDocumento the rigo documento
	*/
	public void cacheResult(it.bysoftware.ct.model.RigoDocumento rigoDocumento);

	/**
	* Caches the rigo documentos in the entity cache if it is enabled.
	*
	* @param rigoDocumentos the rigo documentos
	*/
	public void cacheResult(
		java.util.List<it.bysoftware.ct.model.RigoDocumento> rigoDocumentos);

	/**
	* Creates a new rigo documento with the primary key. Does not add the rigo documento to the database.
	*
	* @param rigoDocumentoPK the primary key for the new rigo documento
	* @return the new rigo documento
	*/
	public it.bysoftware.ct.model.RigoDocumento create(
		it.bysoftware.ct.service.persistence.RigoDocumentoPK rigoDocumentoPK);

	/**
	* Removes the rigo documento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rigoDocumentoPK the primary key of the rigo documento
	* @return the rigo documento that was removed
	* @throws it.bysoftware.ct.NoSuchRigoDocumentoException if a rigo documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.RigoDocumento remove(
		it.bysoftware.ct.service.persistence.RigoDocumentoPK rigoDocumentoPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchRigoDocumentoException;

	public it.bysoftware.ct.model.RigoDocumento updateImpl(
		it.bysoftware.ct.model.RigoDocumento rigoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rigo documento with the primary key or throws a {@link it.bysoftware.ct.NoSuchRigoDocumentoException} if it could not be found.
	*
	* @param rigoDocumentoPK the primary key of the rigo documento
	* @return the rigo documento
	* @throws it.bysoftware.ct.NoSuchRigoDocumentoException if a rigo documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.RigoDocumento findByPrimaryKey(
		it.bysoftware.ct.service.persistence.RigoDocumentoPK rigoDocumentoPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchRigoDocumentoException;

	/**
	* Returns the rigo documento with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param rigoDocumentoPK the primary key of the rigo documento
	* @return the rigo documento, or <code>null</code> if a rigo documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.RigoDocumento fetchByPrimaryKey(
		it.bysoftware.ct.service.persistence.RigoDocumentoPK rigoDocumentoPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rigo documentos.
	*
	* @return the rigo documentos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.RigoDocumento> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.bysoftware.ct.model.RigoDocumento> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.bysoftware.ct.model.RigoDocumento> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the rigo documentos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rigo documentos.
	*
	* @return the number of rigo documentos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
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

import it.bysoftware.ct.model.WKTestataDocumento;

/**
 * The persistence interface for the w k testata documento service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WKTestataDocumentoPersistenceImpl
 * @see WKTestataDocumentoUtil
 * @generated
 */
public interface WKTestataDocumentoPersistence extends BasePersistence<WKTestataDocumento> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WKTestataDocumentoUtil} to access the w k testata documento persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the w k testata documentos where anno = &#63; and idAssociato = &#63; and verificato = &#63;.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param verificato the verificato
	* @return the matching w k testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.WKTestataDocumento> findByAnnoAssociatoVerificato(
		int anno, long idAssociato, boolean verificato)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the w k testata documentos where anno = &#63; and idAssociato = &#63; and verificato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.WKTestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param verificato the verificato
	* @param start the lower bound of the range of w k testata documentos
	* @param end the upper bound of the range of w k testata documentos (not inclusive)
	* @return the range of matching w k testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.WKTestataDocumento> findByAnnoAssociatoVerificato(
		int anno, long idAssociato, boolean verificato, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the w k testata documentos where anno = &#63; and idAssociato = &#63; and verificato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.WKTestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param verificato the verificato
	* @param start the lower bound of the range of w k testata documentos
	* @param end the upper bound of the range of w k testata documentos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching w k testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.WKTestataDocumento> findByAnnoAssociatoVerificato(
		int anno, long idAssociato, boolean verificato, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first w k testata documento in the ordered set where anno = &#63; and idAssociato = &#63; and verificato = &#63;.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param verificato the verificato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w k testata documento
	* @throws it.bysoftware.ct.NoSuchWKTestataDocumentoException if a matching w k testata documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.WKTestataDocumento findByAnnoAssociatoVerificato_First(
		int anno, long idAssociato, boolean verificato,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchWKTestataDocumentoException;

	/**
	* Returns the first w k testata documento in the ordered set where anno = &#63; and idAssociato = &#63; and verificato = &#63;.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param verificato the verificato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w k testata documento, or <code>null</code> if a matching w k testata documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.WKTestataDocumento fetchByAnnoAssociatoVerificato_First(
		int anno, long idAssociato, boolean verificato,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last w k testata documento in the ordered set where anno = &#63; and idAssociato = &#63; and verificato = &#63;.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param verificato the verificato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w k testata documento
	* @throws it.bysoftware.ct.NoSuchWKTestataDocumentoException if a matching w k testata documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.WKTestataDocumento findByAnnoAssociatoVerificato_Last(
		int anno, long idAssociato, boolean verificato,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchWKTestataDocumentoException;

	/**
	* Returns the last w k testata documento in the ordered set where anno = &#63; and idAssociato = &#63; and verificato = &#63;.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param verificato the verificato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w k testata documento, or <code>null</code> if a matching w k testata documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.WKTestataDocumento fetchByAnnoAssociatoVerificato_Last(
		int anno, long idAssociato, boolean verificato,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w k testata documentos before and after the current w k testata documento in the ordered set where anno = &#63; and idAssociato = &#63; and verificato = &#63;.
	*
	* @param wkTestataDocumentoPK the primary key of the current w k testata documento
	* @param anno the anno
	* @param idAssociato the id associato
	* @param verificato the verificato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next w k testata documento
	* @throws it.bysoftware.ct.NoSuchWKTestataDocumentoException if a w k testata documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.WKTestataDocumento[] findByAnnoAssociatoVerificato_PrevAndNext(
		it.bysoftware.ct.service.persistence.WKTestataDocumentoPK wkTestataDocumentoPK,
		int anno, long idAssociato, boolean verificato,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchWKTestataDocumentoException;

	/**
	* Removes all the w k testata documentos where anno = &#63; and idAssociato = &#63; and verificato = &#63; from the database.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param verificato the verificato
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAnnoAssociatoVerificato(int anno, long idAssociato,
		boolean verificato)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of w k testata documentos where anno = &#63; and idAssociato = &#63; and verificato = &#63;.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param verificato the verificato
	* @return the number of matching w k testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public int countByAnnoAssociatoVerificato(int anno, long idAssociato,
		boolean verificato)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the w k testata documento in the entity cache if it is enabled.
	*
	* @param wkTestataDocumento the w k testata documento
	*/
	public void cacheResult(
		it.bysoftware.ct.model.WKTestataDocumento wkTestataDocumento);

	/**
	* Caches the w k testata documentos in the entity cache if it is enabled.
	*
	* @param wkTestataDocumentos the w k testata documentos
	*/
	public void cacheResult(
		java.util.List<it.bysoftware.ct.model.WKTestataDocumento> wkTestataDocumentos);

	/**
	* Creates a new w k testata documento with the primary key. Does not add the w k testata documento to the database.
	*
	* @param wkTestataDocumentoPK the primary key for the new w k testata documento
	* @return the new w k testata documento
	*/
	public it.bysoftware.ct.model.WKTestataDocumento create(
		it.bysoftware.ct.service.persistence.WKTestataDocumentoPK wkTestataDocumentoPK);

	/**
	* Removes the w k testata documento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wkTestataDocumentoPK the primary key of the w k testata documento
	* @return the w k testata documento that was removed
	* @throws it.bysoftware.ct.NoSuchWKTestataDocumentoException if a w k testata documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.WKTestataDocumento remove(
		it.bysoftware.ct.service.persistence.WKTestataDocumentoPK wkTestataDocumentoPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchWKTestataDocumentoException;

	public it.bysoftware.ct.model.WKTestataDocumento updateImpl(
		it.bysoftware.ct.model.WKTestataDocumento wkTestataDocumento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w k testata documento with the primary key or throws a {@link it.bysoftware.ct.NoSuchWKTestataDocumentoException} if it could not be found.
	*
	* @param wkTestataDocumentoPK the primary key of the w k testata documento
	* @return the w k testata documento
	* @throws it.bysoftware.ct.NoSuchWKTestataDocumentoException if a w k testata documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.WKTestataDocumento findByPrimaryKey(
		it.bysoftware.ct.service.persistence.WKTestataDocumentoPK wkTestataDocumentoPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchWKTestataDocumentoException;

	/**
	* Returns the w k testata documento with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param wkTestataDocumentoPK the primary key of the w k testata documento
	* @return the w k testata documento, or <code>null</code> if a w k testata documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.WKTestataDocumento fetchByPrimaryKey(
		it.bysoftware.ct.service.persistence.WKTestataDocumentoPK wkTestataDocumentoPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the w k testata documentos.
	*
	* @return the w k testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.WKTestataDocumento> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the w k testata documentos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.WKTestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of w k testata documentos
	* @param end the upper bound of the range of w k testata documentos (not inclusive)
	* @return the range of w k testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.WKTestataDocumento> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the w k testata documentos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.WKTestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of w k testata documentos
	* @param end the upper bound of the range of w k testata documentos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of w k testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.WKTestataDocumento> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the w k testata documentos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of w k testata documentos.
	*
	* @return the number of w k testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
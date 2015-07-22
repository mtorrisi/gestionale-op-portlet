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

import it.bysoftware.ct.model.TestataDocumento;

/**
 * The persistence interface for the testata documento service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TestataDocumentoPersistenceImpl
 * @see TestataDocumentoUtil
 * @generated
 */
public interface TestataDocumentoPersistence extends BasePersistence<TestataDocumento> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TestataDocumentoUtil} to access the testata documento persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the testata documentos where operatore = &#63;.
	*
	* @param operatore the operatore
	* @return the matching testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.TestataDocumento> findByoperatore(
		java.lang.String operatore)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the testata documentos where operatore = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param operatore the operatore
	* @param start the lower bound of the range of testata documentos
	* @param end the upper bound of the range of testata documentos (not inclusive)
	* @return the range of matching testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.TestataDocumento> findByoperatore(
		java.lang.String operatore, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the testata documentos where operatore = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param operatore the operatore
	* @param start the lower bound of the range of testata documentos
	* @param end the upper bound of the range of testata documentos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.TestataDocumento> findByoperatore(
		java.lang.String operatore, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first testata documento in the ordered set where operatore = &#63;.
	*
	* @param operatore the operatore
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching testata documento
	* @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a matching testata documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.TestataDocumento findByoperatore_First(
		java.lang.String operatore,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTestataDocumentoException;

	/**
	* Returns the first testata documento in the ordered set where operatore = &#63;.
	*
	* @param operatore the operatore
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching testata documento, or <code>null</code> if a matching testata documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.TestataDocumento fetchByoperatore_First(
		java.lang.String operatore,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last testata documento in the ordered set where operatore = &#63;.
	*
	* @param operatore the operatore
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching testata documento
	* @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a matching testata documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.TestataDocumento findByoperatore_Last(
		java.lang.String operatore,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTestataDocumentoException;

	/**
	* Returns the last testata documento in the ordered set where operatore = &#63;.
	*
	* @param operatore the operatore
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching testata documento, or <code>null</code> if a matching testata documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.TestataDocumento fetchByoperatore_Last(
		java.lang.String operatore,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the testata documentos before and after the current testata documento in the ordered set where operatore = &#63;.
	*
	* @param testataDocumentoPK the primary key of the current testata documento
	* @param operatore the operatore
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next testata documento
	* @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a testata documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.TestataDocumento[] findByoperatore_PrevAndNext(
		it.bysoftware.ct.service.persistence.TestataDocumentoPK testataDocumentoPK,
		java.lang.String operatore,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTestataDocumentoException;

	/**
	* Removes all the testata documentos where operatore = &#63; from the database.
	*
	* @param operatore the operatore
	* @throws SystemException if a system exception occurred
	*/
	public void removeByoperatore(java.lang.String operatore)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of testata documentos where operatore = &#63;.
	*
	* @param operatore the operatore
	* @return the number of matching testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public int countByoperatore(java.lang.String operatore)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the testata documentos where operatore = &#63; and completo = &#63; and inviato = &#63;.
	*
	* @param operatore the operatore
	* @param completo the completo
	* @param inviato the inviato
	* @return the matching testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.TestataDocumento> findByoperatoreCompletoInviato(
		java.lang.String operatore, java.lang.String completo, int inviato)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the testata documentos where operatore = &#63; and completo = &#63; and inviato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param operatore the operatore
	* @param completo the completo
	* @param inviato the inviato
	* @param start the lower bound of the range of testata documentos
	* @param end the upper bound of the range of testata documentos (not inclusive)
	* @return the range of matching testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.TestataDocumento> findByoperatoreCompletoInviato(
		java.lang.String operatore, java.lang.String completo, int inviato,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the testata documentos where operatore = &#63; and completo = &#63; and inviato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param operatore the operatore
	* @param completo the completo
	* @param inviato the inviato
	* @param start the lower bound of the range of testata documentos
	* @param end the upper bound of the range of testata documentos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.TestataDocumento> findByoperatoreCompletoInviato(
		java.lang.String operatore, java.lang.String completo, int inviato,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first testata documento in the ordered set where operatore = &#63; and completo = &#63; and inviato = &#63;.
	*
	* @param operatore the operatore
	* @param completo the completo
	* @param inviato the inviato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching testata documento
	* @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a matching testata documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.TestataDocumento findByoperatoreCompletoInviato_First(
		java.lang.String operatore, java.lang.String completo, int inviato,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTestataDocumentoException;

	/**
	* Returns the first testata documento in the ordered set where operatore = &#63; and completo = &#63; and inviato = &#63;.
	*
	* @param operatore the operatore
	* @param completo the completo
	* @param inviato the inviato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching testata documento, or <code>null</code> if a matching testata documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.TestataDocumento fetchByoperatoreCompletoInviato_First(
		java.lang.String operatore, java.lang.String completo, int inviato,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last testata documento in the ordered set where operatore = &#63; and completo = &#63; and inviato = &#63;.
	*
	* @param operatore the operatore
	* @param completo the completo
	* @param inviato the inviato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching testata documento
	* @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a matching testata documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.TestataDocumento findByoperatoreCompletoInviato_Last(
		java.lang.String operatore, java.lang.String completo, int inviato,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTestataDocumentoException;

	/**
	* Returns the last testata documento in the ordered set where operatore = &#63; and completo = &#63; and inviato = &#63;.
	*
	* @param operatore the operatore
	* @param completo the completo
	* @param inviato the inviato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching testata documento, or <code>null</code> if a matching testata documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.TestataDocumento fetchByoperatoreCompletoInviato_Last(
		java.lang.String operatore, java.lang.String completo, int inviato,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the testata documentos before and after the current testata documento in the ordered set where operatore = &#63; and completo = &#63; and inviato = &#63;.
	*
	* @param testataDocumentoPK the primary key of the current testata documento
	* @param operatore the operatore
	* @param completo the completo
	* @param inviato the inviato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next testata documento
	* @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a testata documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.TestataDocumento[] findByoperatoreCompletoInviato_PrevAndNext(
		it.bysoftware.ct.service.persistence.TestataDocumentoPK testataDocumentoPK,
		java.lang.String operatore, java.lang.String completo, int inviato,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTestataDocumentoException;

	/**
	* Removes all the testata documentos where operatore = &#63; and completo = &#63; and inviato = &#63; from the database.
	*
	* @param operatore the operatore
	* @param completo the completo
	* @param inviato the inviato
	* @throws SystemException if a system exception occurred
	*/
	public void removeByoperatoreCompletoInviato(java.lang.String operatore,
		java.lang.String completo, int inviato)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of testata documentos where operatore = &#63; and completo = &#63; and inviato = &#63;.
	*
	* @param operatore the operatore
	* @param completo the completo
	* @param inviato the inviato
	* @return the number of matching testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public int countByoperatoreCompletoInviato(java.lang.String operatore,
		java.lang.String completo, int inviato)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the testata documento in the entity cache if it is enabled.
	*
	* @param testataDocumento the testata documento
	*/
	public void cacheResult(
		it.bysoftware.ct.model.TestataDocumento testataDocumento);

	/**
	* Caches the testata documentos in the entity cache if it is enabled.
	*
	* @param testataDocumentos the testata documentos
	*/
	public void cacheResult(
		java.util.List<it.bysoftware.ct.model.TestataDocumento> testataDocumentos);

	/**
	* Creates a new testata documento with the primary key. Does not add the testata documento to the database.
	*
	* @param testataDocumentoPK the primary key for the new testata documento
	* @return the new testata documento
	*/
	public it.bysoftware.ct.model.TestataDocumento create(
		it.bysoftware.ct.service.persistence.TestataDocumentoPK testataDocumentoPK);

	/**
	* Removes the testata documento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param testataDocumentoPK the primary key of the testata documento
	* @return the testata documento that was removed
	* @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a testata documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.TestataDocumento remove(
		it.bysoftware.ct.service.persistence.TestataDocumentoPK testataDocumentoPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTestataDocumentoException;

	public it.bysoftware.ct.model.TestataDocumento updateImpl(
		it.bysoftware.ct.model.TestataDocumento testataDocumento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the testata documento with the primary key or throws a {@link it.bysoftware.ct.NoSuchTestataDocumentoException} if it could not be found.
	*
	* @param testataDocumentoPK the primary key of the testata documento
	* @return the testata documento
	* @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a testata documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.TestataDocumento findByPrimaryKey(
		it.bysoftware.ct.service.persistence.TestataDocumentoPK testataDocumentoPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTestataDocumentoException;

	/**
	* Returns the testata documento with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param testataDocumentoPK the primary key of the testata documento
	* @return the testata documento, or <code>null</code> if a testata documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.TestataDocumento fetchByPrimaryKey(
		it.bysoftware.ct.service.persistence.TestataDocumentoPK testataDocumentoPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the testata documentos.
	*
	* @return the testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.TestataDocumento> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the testata documentos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of testata documentos
	* @param end the upper bound of the range of testata documentos (not inclusive)
	* @return the range of testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.TestataDocumento> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the testata documentos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of testata documentos
	* @param end the upper bound of the range of testata documentos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.TestataDocumento> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the testata documentos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of testata documentos.
	*
	* @return the number of testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
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

import it.bysoftware.ct.model.TestataDocumento;

import java.util.List;

/**
 * The persistence utility for the testata documento service. This utility wraps {@link TestataDocumentoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TestataDocumentoPersistence
 * @see TestataDocumentoPersistenceImpl
 * @generated
 */
public class TestataDocumentoUtil {
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
	public static void clearCache(TestataDocumento testataDocumento) {
		getPersistence().clearCache(testataDocumento);
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
	public static List<TestataDocumento> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TestataDocumento> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TestataDocumento> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TestataDocumento update(TestataDocumento testataDocumento)
		throws SystemException {
		return getPersistence().update(testataDocumento);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TestataDocumento update(TestataDocumento testataDocumento,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(testataDocumento, serviceContext);
	}

	/**
	* Returns all the testata documentos where operatore = &#63;.
	*
	* @param operatore the operatore
	* @return the matching testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.TestataDocumento> findByoperatore(
		java.lang.String operatore)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByoperatore(operatore);
	}

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
	public static java.util.List<it.bysoftware.ct.model.TestataDocumento> findByoperatore(
		java.lang.String operatore, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByoperatore(operatore, start, end);
	}

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
	public static java.util.List<it.bysoftware.ct.model.TestataDocumento> findByoperatore(
		java.lang.String operatore, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByoperatore(operatore, start, end, orderByComparator);
	}

	/**
	* Returns the first testata documento in the ordered set where operatore = &#63;.
	*
	* @param operatore the operatore
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching testata documento
	* @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a matching testata documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.TestataDocumento findByoperatore_First(
		java.lang.String operatore,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTestataDocumentoException {
		return getPersistence()
				   .findByoperatore_First(operatore, orderByComparator);
	}

	/**
	* Returns the first testata documento in the ordered set where operatore = &#63;.
	*
	* @param operatore the operatore
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching testata documento, or <code>null</code> if a matching testata documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.TestataDocumento fetchByoperatore_First(
		java.lang.String operatore,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByoperatore_First(operatore, orderByComparator);
	}

	/**
	* Returns the last testata documento in the ordered set where operatore = &#63;.
	*
	* @param operatore the operatore
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching testata documento
	* @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a matching testata documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.TestataDocumento findByoperatore_Last(
		java.lang.String operatore,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTestataDocumentoException {
		return getPersistence()
				   .findByoperatore_Last(operatore, orderByComparator);
	}

	/**
	* Returns the last testata documento in the ordered set where operatore = &#63;.
	*
	* @param operatore the operatore
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching testata documento, or <code>null</code> if a matching testata documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.TestataDocumento fetchByoperatore_Last(
		java.lang.String operatore,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByoperatore_Last(operatore, orderByComparator);
	}

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
	public static it.bysoftware.ct.model.TestataDocumento[] findByoperatore_PrevAndNext(
		it.bysoftware.ct.service.persistence.TestataDocumentoPK testataDocumentoPK,
		java.lang.String operatore,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTestataDocumentoException {
		return getPersistence()
				   .findByoperatore_PrevAndNext(testataDocumentoPK, operatore,
			orderByComparator);
	}

	/**
	* Removes all the testata documentos where operatore = &#63; from the database.
	*
	* @param operatore the operatore
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByoperatore(java.lang.String operatore)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByoperatore(operatore);
	}

	/**
	* Returns the number of testata documentos where operatore = &#63;.
	*
	* @param operatore the operatore
	* @return the number of matching testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByoperatore(java.lang.String operatore)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByoperatore(operatore);
	}

	/**
	* Returns all the testata documentos where codiceSoggetto = &#63; and operatore = &#63;.
	*
	* @param codiceSoggetto the codice soggetto
	* @param operatore the operatore
	* @return the matching testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.TestataDocumento> findByCodiceSoggettoCodiceOperatore(
		java.lang.String codiceSoggetto, java.lang.String operatore)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCodiceSoggettoCodiceOperatore(codiceSoggetto,
			operatore);
	}

	/**
	* Returns a range of all the testata documentos where codiceSoggetto = &#63; and operatore = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param codiceSoggetto the codice soggetto
	* @param operatore the operatore
	* @param start the lower bound of the range of testata documentos
	* @param end the upper bound of the range of testata documentos (not inclusive)
	* @return the range of matching testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.TestataDocumento> findByCodiceSoggettoCodiceOperatore(
		java.lang.String codiceSoggetto, java.lang.String operatore, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCodiceSoggettoCodiceOperatore(codiceSoggetto,
			operatore, start, end);
	}

	/**
	* Returns an ordered range of all the testata documentos where codiceSoggetto = &#63; and operatore = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param codiceSoggetto the codice soggetto
	* @param operatore the operatore
	* @param start the lower bound of the range of testata documentos
	* @param end the upper bound of the range of testata documentos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.TestataDocumento> findByCodiceSoggettoCodiceOperatore(
		java.lang.String codiceSoggetto, java.lang.String operatore, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCodiceSoggettoCodiceOperatore(codiceSoggetto,
			operatore, start, end, orderByComparator);
	}

	/**
	* Returns the first testata documento in the ordered set where codiceSoggetto = &#63; and operatore = &#63;.
	*
	* @param codiceSoggetto the codice soggetto
	* @param operatore the operatore
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching testata documento
	* @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a matching testata documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.TestataDocumento findByCodiceSoggettoCodiceOperatore_First(
		java.lang.String codiceSoggetto, java.lang.String operatore,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTestataDocumentoException {
		return getPersistence()
				   .findByCodiceSoggettoCodiceOperatore_First(codiceSoggetto,
			operatore, orderByComparator);
	}

	/**
	* Returns the first testata documento in the ordered set where codiceSoggetto = &#63; and operatore = &#63;.
	*
	* @param codiceSoggetto the codice soggetto
	* @param operatore the operatore
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching testata documento, or <code>null</code> if a matching testata documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.TestataDocumento fetchByCodiceSoggettoCodiceOperatore_First(
		java.lang.String codiceSoggetto, java.lang.String operatore,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCodiceSoggettoCodiceOperatore_First(codiceSoggetto,
			operatore, orderByComparator);
	}

	/**
	* Returns the last testata documento in the ordered set where codiceSoggetto = &#63; and operatore = &#63;.
	*
	* @param codiceSoggetto the codice soggetto
	* @param operatore the operatore
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching testata documento
	* @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a matching testata documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.TestataDocumento findByCodiceSoggettoCodiceOperatore_Last(
		java.lang.String codiceSoggetto, java.lang.String operatore,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTestataDocumentoException {
		return getPersistence()
				   .findByCodiceSoggettoCodiceOperatore_Last(codiceSoggetto,
			operatore, orderByComparator);
	}

	/**
	* Returns the last testata documento in the ordered set where codiceSoggetto = &#63; and operatore = &#63;.
	*
	* @param codiceSoggetto the codice soggetto
	* @param operatore the operatore
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching testata documento, or <code>null</code> if a matching testata documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.TestataDocumento fetchByCodiceSoggettoCodiceOperatore_Last(
		java.lang.String codiceSoggetto, java.lang.String operatore,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCodiceSoggettoCodiceOperatore_Last(codiceSoggetto,
			operatore, orderByComparator);
	}

	/**
	* Returns the testata documentos before and after the current testata documento in the ordered set where codiceSoggetto = &#63; and operatore = &#63;.
	*
	* @param testataDocumentoPK the primary key of the current testata documento
	* @param codiceSoggetto the codice soggetto
	* @param operatore the operatore
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next testata documento
	* @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a testata documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.TestataDocumento[] findByCodiceSoggettoCodiceOperatore_PrevAndNext(
		it.bysoftware.ct.service.persistence.TestataDocumentoPK testataDocumentoPK,
		java.lang.String codiceSoggetto, java.lang.String operatore,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTestataDocumentoException {
		return getPersistence()
				   .findByCodiceSoggettoCodiceOperatore_PrevAndNext(testataDocumentoPK,
			codiceSoggetto, operatore, orderByComparator);
	}

	/**
	* Removes all the testata documentos where codiceSoggetto = &#63; and operatore = &#63; from the database.
	*
	* @param codiceSoggetto the codice soggetto
	* @param operatore the operatore
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCodiceSoggettoCodiceOperatore(
		java.lang.String codiceSoggetto, java.lang.String operatore)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCodiceSoggettoCodiceOperatore(codiceSoggetto, operatore);
	}

	/**
	* Returns the number of testata documentos where codiceSoggetto = &#63; and operatore = &#63;.
	*
	* @param codiceSoggetto the codice soggetto
	* @param operatore the operatore
	* @return the number of matching testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCodiceSoggettoCodiceOperatore(
		java.lang.String codiceSoggetto, java.lang.String operatore)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCodiceSoggettoCodiceOperatore(codiceSoggetto,
			operatore);
	}

	/**
	* Returns all the testata documentos where operatore = &#63; and completo = &#63; and inviato = &#63; and tipoDocumento &ne; &#63;.
	*
	* @param operatore the operatore
	* @param completo the completo
	* @param inviato the inviato
	* @param tipoDocumento the tipo documento
	* @return the matching testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.TestataDocumento> findByoperatoreCompletoInviato(
		java.lang.String operatore, java.lang.String completo, int inviato,
		java.lang.String tipoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByoperatoreCompletoInviato(operatore, completo,
			inviato, tipoDocumento);
	}

	/**
	* Returns a range of all the testata documentos where operatore = &#63; and completo = &#63; and inviato = &#63; and tipoDocumento &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param operatore the operatore
	* @param completo the completo
	* @param inviato the inviato
	* @param tipoDocumento the tipo documento
	* @param start the lower bound of the range of testata documentos
	* @param end the upper bound of the range of testata documentos (not inclusive)
	* @return the range of matching testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.TestataDocumento> findByoperatoreCompletoInviato(
		java.lang.String operatore, java.lang.String completo, int inviato,
		java.lang.String tipoDocumento, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByoperatoreCompletoInviato(operatore, completo,
			inviato, tipoDocumento, start, end);
	}

	/**
	* Returns an ordered range of all the testata documentos where operatore = &#63; and completo = &#63; and inviato = &#63; and tipoDocumento &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param operatore the operatore
	* @param completo the completo
	* @param inviato the inviato
	* @param tipoDocumento the tipo documento
	* @param start the lower bound of the range of testata documentos
	* @param end the upper bound of the range of testata documentos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.TestataDocumento> findByoperatoreCompletoInviato(
		java.lang.String operatore, java.lang.String completo, int inviato,
		java.lang.String tipoDocumento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByoperatoreCompletoInviato(operatore, completo,
			inviato, tipoDocumento, start, end, orderByComparator);
	}

	/**
	* Returns the first testata documento in the ordered set where operatore = &#63; and completo = &#63; and inviato = &#63; and tipoDocumento &ne; &#63;.
	*
	* @param operatore the operatore
	* @param completo the completo
	* @param inviato the inviato
	* @param tipoDocumento the tipo documento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching testata documento
	* @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a matching testata documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.TestataDocumento findByoperatoreCompletoInviato_First(
		java.lang.String operatore, java.lang.String completo, int inviato,
		java.lang.String tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTestataDocumentoException {
		return getPersistence()
				   .findByoperatoreCompletoInviato_First(operatore, completo,
			inviato, tipoDocumento, orderByComparator);
	}

	/**
	* Returns the first testata documento in the ordered set where operatore = &#63; and completo = &#63; and inviato = &#63; and tipoDocumento &ne; &#63;.
	*
	* @param operatore the operatore
	* @param completo the completo
	* @param inviato the inviato
	* @param tipoDocumento the tipo documento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching testata documento, or <code>null</code> if a matching testata documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.TestataDocumento fetchByoperatoreCompletoInviato_First(
		java.lang.String operatore, java.lang.String completo, int inviato,
		java.lang.String tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByoperatoreCompletoInviato_First(operatore, completo,
			inviato, tipoDocumento, orderByComparator);
	}

	/**
	* Returns the last testata documento in the ordered set where operatore = &#63; and completo = &#63; and inviato = &#63; and tipoDocumento &ne; &#63;.
	*
	* @param operatore the operatore
	* @param completo the completo
	* @param inviato the inviato
	* @param tipoDocumento the tipo documento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching testata documento
	* @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a matching testata documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.TestataDocumento findByoperatoreCompletoInviato_Last(
		java.lang.String operatore, java.lang.String completo, int inviato,
		java.lang.String tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTestataDocumentoException {
		return getPersistence()
				   .findByoperatoreCompletoInviato_Last(operatore, completo,
			inviato, tipoDocumento, orderByComparator);
	}

	/**
	* Returns the last testata documento in the ordered set where operatore = &#63; and completo = &#63; and inviato = &#63; and tipoDocumento &ne; &#63;.
	*
	* @param operatore the operatore
	* @param completo the completo
	* @param inviato the inviato
	* @param tipoDocumento the tipo documento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching testata documento, or <code>null</code> if a matching testata documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.TestataDocumento fetchByoperatoreCompletoInviato_Last(
		java.lang.String operatore, java.lang.String completo, int inviato,
		java.lang.String tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByoperatoreCompletoInviato_Last(operatore, completo,
			inviato, tipoDocumento, orderByComparator);
	}

	/**
	* Returns the testata documentos before and after the current testata documento in the ordered set where operatore = &#63; and completo = &#63; and inviato = &#63; and tipoDocumento &ne; &#63;.
	*
	* @param testataDocumentoPK the primary key of the current testata documento
	* @param operatore the operatore
	* @param completo the completo
	* @param inviato the inviato
	* @param tipoDocumento the tipo documento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next testata documento
	* @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a testata documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.TestataDocumento[] findByoperatoreCompletoInviato_PrevAndNext(
		it.bysoftware.ct.service.persistence.TestataDocumentoPK testataDocumentoPK,
		java.lang.String operatore, java.lang.String completo, int inviato,
		java.lang.String tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTestataDocumentoException {
		return getPersistence()
				   .findByoperatoreCompletoInviato_PrevAndNext(testataDocumentoPK,
			operatore, completo, inviato, tipoDocumento, orderByComparator);
	}

	/**
	* Removes all the testata documentos where operatore = &#63; and completo = &#63; and inviato = &#63; and tipoDocumento &ne; &#63; from the database.
	*
	* @param operatore the operatore
	* @param completo the completo
	* @param inviato the inviato
	* @param tipoDocumento the tipo documento
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByoperatoreCompletoInviato(
		java.lang.String operatore, java.lang.String completo, int inviato,
		java.lang.String tipoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByoperatoreCompletoInviato(operatore, completo, inviato,
			tipoDocumento);
	}

	/**
	* Returns the number of testata documentos where operatore = &#63; and completo = &#63; and inviato = &#63; and tipoDocumento &ne; &#63;.
	*
	* @param operatore the operatore
	* @param completo the completo
	* @param inviato the inviato
	* @param tipoDocumento the tipo documento
	* @return the number of matching testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByoperatoreCompletoInviato(
		java.lang.String operatore, java.lang.String completo, int inviato,
		java.lang.String tipoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByoperatoreCompletoInviato(operatore, completo,
			inviato, tipoDocumento);
	}

	/**
	* Returns all the testata documentos where anno = &#63; and tipoDocumento = &#63; and idAssociato = &#63;.
	*
	* @param anno the anno
	* @param tipoDocumento the tipo documento
	* @param idAssociato the id associato
	* @return the matching testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.TestataDocumento> findByannoTipoDocumentoIdAssociato(
		int anno, java.lang.String tipoDocumento, long idAssociato)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByannoTipoDocumentoIdAssociato(anno, tipoDocumento,
			idAssociato);
	}

	/**
	* Returns a range of all the testata documentos where anno = &#63; and tipoDocumento = &#63; and idAssociato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param anno the anno
	* @param tipoDocumento the tipo documento
	* @param idAssociato the id associato
	* @param start the lower bound of the range of testata documentos
	* @param end the upper bound of the range of testata documentos (not inclusive)
	* @return the range of matching testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.TestataDocumento> findByannoTipoDocumentoIdAssociato(
		int anno, java.lang.String tipoDocumento, long idAssociato, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByannoTipoDocumentoIdAssociato(anno, tipoDocumento,
			idAssociato, start, end);
	}

	/**
	* Returns an ordered range of all the testata documentos where anno = &#63; and tipoDocumento = &#63; and idAssociato = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param anno the anno
	* @param tipoDocumento the tipo documento
	* @param idAssociato the id associato
	* @param start the lower bound of the range of testata documentos
	* @param end the upper bound of the range of testata documentos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.TestataDocumento> findByannoTipoDocumentoIdAssociato(
		int anno, java.lang.String tipoDocumento, long idAssociato, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByannoTipoDocumentoIdAssociato(anno, tipoDocumento,
			idAssociato, start, end, orderByComparator);
	}

	/**
	* Returns the first testata documento in the ordered set where anno = &#63; and tipoDocumento = &#63; and idAssociato = &#63;.
	*
	* @param anno the anno
	* @param tipoDocumento the tipo documento
	* @param idAssociato the id associato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching testata documento
	* @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a matching testata documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.TestataDocumento findByannoTipoDocumentoIdAssociato_First(
		int anno, java.lang.String tipoDocumento, long idAssociato,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTestataDocumentoException {
		return getPersistence()
				   .findByannoTipoDocumentoIdAssociato_First(anno,
			tipoDocumento, idAssociato, orderByComparator);
	}

	/**
	* Returns the first testata documento in the ordered set where anno = &#63; and tipoDocumento = &#63; and idAssociato = &#63;.
	*
	* @param anno the anno
	* @param tipoDocumento the tipo documento
	* @param idAssociato the id associato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching testata documento, or <code>null</code> if a matching testata documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.TestataDocumento fetchByannoTipoDocumentoIdAssociato_First(
		int anno, java.lang.String tipoDocumento, long idAssociato,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByannoTipoDocumentoIdAssociato_First(anno,
			tipoDocumento, idAssociato, orderByComparator);
	}

	/**
	* Returns the last testata documento in the ordered set where anno = &#63; and tipoDocumento = &#63; and idAssociato = &#63;.
	*
	* @param anno the anno
	* @param tipoDocumento the tipo documento
	* @param idAssociato the id associato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching testata documento
	* @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a matching testata documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.TestataDocumento findByannoTipoDocumentoIdAssociato_Last(
		int anno, java.lang.String tipoDocumento, long idAssociato,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTestataDocumentoException {
		return getPersistence()
				   .findByannoTipoDocumentoIdAssociato_Last(anno,
			tipoDocumento, idAssociato, orderByComparator);
	}

	/**
	* Returns the last testata documento in the ordered set where anno = &#63; and tipoDocumento = &#63; and idAssociato = &#63;.
	*
	* @param anno the anno
	* @param tipoDocumento the tipo documento
	* @param idAssociato the id associato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching testata documento, or <code>null</code> if a matching testata documento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.TestataDocumento fetchByannoTipoDocumentoIdAssociato_Last(
		int anno, java.lang.String tipoDocumento, long idAssociato,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByannoTipoDocumentoIdAssociato_Last(anno,
			tipoDocumento, idAssociato, orderByComparator);
	}

	/**
	* Returns the testata documentos before and after the current testata documento in the ordered set where anno = &#63; and tipoDocumento = &#63; and idAssociato = &#63;.
	*
	* @param testataDocumentoPK the primary key of the current testata documento
	* @param anno the anno
	* @param tipoDocumento the tipo documento
	* @param idAssociato the id associato
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next testata documento
	* @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a testata documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.TestataDocumento[] findByannoTipoDocumentoIdAssociato_PrevAndNext(
		it.bysoftware.ct.service.persistence.TestataDocumentoPK testataDocumentoPK,
		int anno, java.lang.String tipoDocumento, long idAssociato,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTestataDocumentoException {
		return getPersistence()
				   .findByannoTipoDocumentoIdAssociato_PrevAndNext(testataDocumentoPK,
			anno, tipoDocumento, idAssociato, orderByComparator);
	}

	/**
	* Removes all the testata documentos where anno = &#63; and tipoDocumento = &#63; and idAssociato = &#63; from the database.
	*
	* @param anno the anno
	* @param tipoDocumento the tipo documento
	* @param idAssociato the id associato
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByannoTipoDocumentoIdAssociato(int anno,
		java.lang.String tipoDocumento, long idAssociato)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByannoTipoDocumentoIdAssociato(anno, tipoDocumento,
			idAssociato);
	}

	/**
	* Returns the number of testata documentos where anno = &#63; and tipoDocumento = &#63; and idAssociato = &#63;.
	*
	* @param anno the anno
	* @param tipoDocumento the tipo documento
	* @param idAssociato the id associato
	* @return the number of matching testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByannoTipoDocumentoIdAssociato(int anno,
		java.lang.String tipoDocumento, long idAssociato)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByannoTipoDocumentoIdAssociato(anno, tipoDocumento,
			idAssociato);
	}

	/**
	* Caches the testata documento in the entity cache if it is enabled.
	*
	* @param testataDocumento the testata documento
	*/
	public static void cacheResult(
		it.bysoftware.ct.model.TestataDocumento testataDocumento) {
		getPersistence().cacheResult(testataDocumento);
	}

	/**
	* Caches the testata documentos in the entity cache if it is enabled.
	*
	* @param testataDocumentos the testata documentos
	*/
	public static void cacheResult(
		java.util.List<it.bysoftware.ct.model.TestataDocumento> testataDocumentos) {
		getPersistence().cacheResult(testataDocumentos);
	}

	/**
	* Creates a new testata documento with the primary key. Does not add the testata documento to the database.
	*
	* @param testataDocumentoPK the primary key for the new testata documento
	* @return the new testata documento
	*/
	public static it.bysoftware.ct.model.TestataDocumento create(
		it.bysoftware.ct.service.persistence.TestataDocumentoPK testataDocumentoPK) {
		return getPersistence().create(testataDocumentoPK);
	}

	/**
	* Removes the testata documento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param testataDocumentoPK the primary key of the testata documento
	* @return the testata documento that was removed
	* @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a testata documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.TestataDocumento remove(
		it.bysoftware.ct.service.persistence.TestataDocumentoPK testataDocumentoPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTestataDocumentoException {
		return getPersistence().remove(testataDocumentoPK);
	}

	public static it.bysoftware.ct.model.TestataDocumento updateImpl(
		it.bysoftware.ct.model.TestataDocumento testataDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(testataDocumento);
	}

	/**
	* Returns the testata documento with the primary key or throws a {@link it.bysoftware.ct.NoSuchTestataDocumentoException} if it could not be found.
	*
	* @param testataDocumentoPK the primary key of the testata documento
	* @return the testata documento
	* @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a testata documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.TestataDocumento findByPrimaryKey(
		it.bysoftware.ct.service.persistence.TestataDocumentoPK testataDocumentoPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchTestataDocumentoException {
		return getPersistence().findByPrimaryKey(testataDocumentoPK);
	}

	/**
	* Returns the testata documento with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param testataDocumentoPK the primary key of the testata documento
	* @return the testata documento, or <code>null</code> if a testata documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.TestataDocumento fetchByPrimaryKey(
		it.bysoftware.ct.service.persistence.TestataDocumentoPK testataDocumentoPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(testataDocumentoPK);
	}

	/**
	* Returns all the testata documentos.
	*
	* @return the testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.TestataDocumento> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<it.bysoftware.ct.model.TestataDocumento> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<it.bysoftware.ct.model.TestataDocumento> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the testata documentos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of testata documentos.
	*
	* @return the number of testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TestataDocumentoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TestataDocumentoPersistence)PortletBeanLocatorUtil.locate(it.bysoftware.ct.service.ClpSerializer.getServletContextName(),
					TestataDocumentoPersistence.class.getName());

			ReferenceRegistry.registerReference(TestataDocumentoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TestataDocumentoPersistence persistence) {
	}

	private static TestataDocumentoPersistence _persistence;
}
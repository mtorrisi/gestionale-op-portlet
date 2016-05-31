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

import it.bysoftware.ct.model.WKTestataDocumento;

import java.util.List;

/**
 * The persistence utility for the w k testata documento service. This utility wraps {@link WKTestataDocumentoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WKTestataDocumentoPersistence
 * @see WKTestataDocumentoPersistenceImpl
 * @generated
 */
public class WKTestataDocumentoUtil {
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
	public static void clearCache(WKTestataDocumento wkTestataDocumento) {
		getPersistence().clearCache(wkTestataDocumento);
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
	public static List<WKTestataDocumento> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WKTestataDocumento> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WKTestataDocumento> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static WKTestataDocumento update(
		WKTestataDocumento wkTestataDocumento) throws SystemException {
		return getPersistence().update(wkTestataDocumento);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static WKTestataDocumento update(
		WKTestataDocumento wkTestataDocumento, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(wkTestataDocumento, serviceContext);
	}

	/**
	* Returns all the w k testata documentos where anno = &#63; and idAssociato = &#63; and verificato = &#63;.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param verificato the verificato
	* @return the matching w k testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.WKTestataDocumento> findByAnnoAssociatoVerificato(
		int anno, long idAssociato, boolean verificato)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAnnoAssociatoVerificato(anno, idAssociato, verificato);
	}

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
	public static java.util.List<it.bysoftware.ct.model.WKTestataDocumento> findByAnnoAssociatoVerificato(
		int anno, long idAssociato, boolean verificato, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAnnoAssociatoVerificato(anno, idAssociato,
			verificato, start, end);
	}

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
	public static java.util.List<it.bysoftware.ct.model.WKTestataDocumento> findByAnnoAssociatoVerificato(
		int anno, long idAssociato, boolean verificato, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAnnoAssociatoVerificato(anno, idAssociato,
			verificato, start, end, orderByComparator);
	}

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
	public static it.bysoftware.ct.model.WKTestataDocumento findByAnnoAssociatoVerificato_First(
		int anno, long idAssociato, boolean verificato,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchWKTestataDocumentoException {
		return getPersistence()
				   .findByAnnoAssociatoVerificato_First(anno, idAssociato,
			verificato, orderByComparator);
	}

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
	public static it.bysoftware.ct.model.WKTestataDocumento fetchByAnnoAssociatoVerificato_First(
		int anno, long idAssociato, boolean verificato,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAnnoAssociatoVerificato_First(anno, idAssociato,
			verificato, orderByComparator);
	}

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
	public static it.bysoftware.ct.model.WKTestataDocumento findByAnnoAssociatoVerificato_Last(
		int anno, long idAssociato, boolean verificato,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchWKTestataDocumentoException {
		return getPersistence()
				   .findByAnnoAssociatoVerificato_Last(anno, idAssociato,
			verificato, orderByComparator);
	}

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
	public static it.bysoftware.ct.model.WKTestataDocumento fetchByAnnoAssociatoVerificato_Last(
		int anno, long idAssociato, boolean verificato,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAnnoAssociatoVerificato_Last(anno, idAssociato,
			verificato, orderByComparator);
	}

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
	public static it.bysoftware.ct.model.WKTestataDocumento[] findByAnnoAssociatoVerificato_PrevAndNext(
		it.bysoftware.ct.service.persistence.WKTestataDocumentoPK wkTestataDocumentoPK,
		int anno, long idAssociato, boolean verificato,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchWKTestataDocumentoException {
		return getPersistence()
				   .findByAnnoAssociatoVerificato_PrevAndNext(wkTestataDocumentoPK,
			anno, idAssociato, verificato, orderByComparator);
	}

	/**
	* Removes all the w k testata documentos where anno = &#63; and idAssociato = &#63; and verificato = &#63; from the database.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param verificato the verificato
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAnnoAssociatoVerificato(int anno,
		long idAssociato, boolean verificato)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByAnnoAssociatoVerificato(anno, idAssociato, verificato);
	}

	/**
	* Returns the number of w k testata documentos where anno = &#63; and idAssociato = &#63; and verificato = &#63;.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param verificato the verificato
	* @return the number of matching w k testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAnnoAssociatoVerificato(int anno,
		long idAssociato, boolean verificato)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByAnnoAssociatoVerificato(anno, idAssociato, verificato);
	}

	/**
	* Caches the w k testata documento in the entity cache if it is enabled.
	*
	* @param wkTestataDocumento the w k testata documento
	*/
	public static void cacheResult(
		it.bysoftware.ct.model.WKTestataDocumento wkTestataDocumento) {
		getPersistence().cacheResult(wkTestataDocumento);
	}

	/**
	* Caches the w k testata documentos in the entity cache if it is enabled.
	*
	* @param wkTestataDocumentos the w k testata documentos
	*/
	public static void cacheResult(
		java.util.List<it.bysoftware.ct.model.WKTestataDocumento> wkTestataDocumentos) {
		getPersistence().cacheResult(wkTestataDocumentos);
	}

	/**
	* Creates a new w k testata documento with the primary key. Does not add the w k testata documento to the database.
	*
	* @param wkTestataDocumentoPK the primary key for the new w k testata documento
	* @return the new w k testata documento
	*/
	public static it.bysoftware.ct.model.WKTestataDocumento create(
		it.bysoftware.ct.service.persistence.WKTestataDocumentoPK wkTestataDocumentoPK) {
		return getPersistence().create(wkTestataDocumentoPK);
	}

	/**
	* Removes the w k testata documento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wkTestataDocumentoPK the primary key of the w k testata documento
	* @return the w k testata documento that was removed
	* @throws it.bysoftware.ct.NoSuchWKTestataDocumentoException if a w k testata documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.WKTestataDocumento remove(
		it.bysoftware.ct.service.persistence.WKTestataDocumentoPK wkTestataDocumentoPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchWKTestataDocumentoException {
		return getPersistence().remove(wkTestataDocumentoPK);
	}

	public static it.bysoftware.ct.model.WKTestataDocumento updateImpl(
		it.bysoftware.ct.model.WKTestataDocumento wkTestataDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(wkTestataDocumento);
	}

	/**
	* Returns the w k testata documento with the primary key or throws a {@link it.bysoftware.ct.NoSuchWKTestataDocumentoException} if it could not be found.
	*
	* @param wkTestataDocumentoPK the primary key of the w k testata documento
	* @return the w k testata documento
	* @throws it.bysoftware.ct.NoSuchWKTestataDocumentoException if a w k testata documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.WKTestataDocumento findByPrimaryKey(
		it.bysoftware.ct.service.persistence.WKTestataDocumentoPK wkTestataDocumentoPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchWKTestataDocumentoException {
		return getPersistence().findByPrimaryKey(wkTestataDocumentoPK);
	}

	/**
	* Returns the w k testata documento with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param wkTestataDocumentoPK the primary key of the w k testata documento
	* @return the w k testata documento, or <code>null</code> if a w k testata documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.WKTestataDocumento fetchByPrimaryKey(
		it.bysoftware.ct.service.persistence.WKTestataDocumentoPK wkTestataDocumentoPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(wkTestataDocumentoPK);
	}

	/**
	* Returns all the w k testata documentos.
	*
	* @return the w k testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.WKTestataDocumento> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<it.bysoftware.ct.model.WKTestataDocumento> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<it.bysoftware.ct.model.WKTestataDocumento> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the w k testata documentos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of w k testata documentos.
	*
	* @return the number of w k testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static WKTestataDocumentoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (WKTestataDocumentoPersistence)PortletBeanLocatorUtil.locate(it.bysoftware.ct.service.ClpSerializer.getServletContextName(),
					WKTestataDocumentoPersistence.class.getName());

			ReferenceRegistry.registerReference(WKTestataDocumentoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(WKTestataDocumentoPersistence persistence) {
	}

	private static WKTestataDocumentoPersistence _persistence;
}
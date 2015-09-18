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

import it.bysoftware.ct.model.Progressivo;

import java.util.List;

/**
 * The persistence utility for the progressivo service. This utility wraps {@link ProgressivoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgressivoPersistence
 * @see ProgressivoPersistenceImpl
 * @generated
 */
public class ProgressivoUtil {
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
	public static void clearCache(Progressivo progressivo) {
		getPersistence().clearCache(progressivo);
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
	public static List<Progressivo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Progressivo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Progressivo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Progressivo update(Progressivo progressivo)
		throws SystemException {
		return getPersistence().update(progressivo);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Progressivo update(Progressivo progressivo,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(progressivo, serviceContext);
	}

	/**
	* Returns all the progressivos where anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param tipoDocumento the tipo documento
	* @return the matching progressivos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.Progressivo> findByAnnoIdAssociatoTipoDocumento(
		int anno, long idAssociato, int tipoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAnnoIdAssociatoTipoDocumento(anno, idAssociato,
			tipoDocumento);
	}

	/**
	* Returns a range of all the progressivos where anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.ProgressivoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param tipoDocumento the tipo documento
	* @param start the lower bound of the range of progressivos
	* @param end the upper bound of the range of progressivos (not inclusive)
	* @return the range of matching progressivos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.Progressivo> findByAnnoIdAssociatoTipoDocumento(
		int anno, long idAssociato, int tipoDocumento, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAnnoIdAssociatoTipoDocumento(anno, idAssociato,
			tipoDocumento, start, end);
	}

	/**
	* Returns an ordered range of all the progressivos where anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.ProgressivoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param tipoDocumento the tipo documento
	* @param start the lower bound of the range of progressivos
	* @param end the upper bound of the range of progressivos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching progressivos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.Progressivo> findByAnnoIdAssociatoTipoDocumento(
		int anno, long idAssociato, int tipoDocumento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAnnoIdAssociatoTipoDocumento(anno, idAssociato,
			tipoDocumento, start, end, orderByComparator);
	}

	/**
	* Returns the first progressivo in the ordered set where anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param tipoDocumento the tipo documento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching progressivo
	* @throws it.bysoftware.ct.NoSuchProgressivoException if a matching progressivo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Progressivo findByAnnoIdAssociatoTipoDocumento_First(
		int anno, long idAssociato, int tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchProgressivoException {
		return getPersistence()
				   .findByAnnoIdAssociatoTipoDocumento_First(anno, idAssociato,
			tipoDocumento, orderByComparator);
	}

	/**
	* Returns the first progressivo in the ordered set where anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param tipoDocumento the tipo documento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching progressivo, or <code>null</code> if a matching progressivo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Progressivo fetchByAnnoIdAssociatoTipoDocumento_First(
		int anno, long idAssociato, int tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAnnoIdAssociatoTipoDocumento_First(anno,
			idAssociato, tipoDocumento, orderByComparator);
	}

	/**
	* Returns the last progressivo in the ordered set where anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param tipoDocumento the tipo documento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching progressivo
	* @throws it.bysoftware.ct.NoSuchProgressivoException if a matching progressivo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Progressivo findByAnnoIdAssociatoTipoDocumento_Last(
		int anno, long idAssociato, int tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchProgressivoException {
		return getPersistence()
				   .findByAnnoIdAssociatoTipoDocumento_Last(anno, idAssociato,
			tipoDocumento, orderByComparator);
	}

	/**
	* Returns the last progressivo in the ordered set where anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param tipoDocumento the tipo documento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching progressivo, or <code>null</code> if a matching progressivo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Progressivo fetchByAnnoIdAssociatoTipoDocumento_Last(
		int anno, long idAssociato, int tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAnnoIdAssociatoTipoDocumento_Last(anno, idAssociato,
			tipoDocumento, orderByComparator);
	}

	/**
	* Returns the progressivos before and after the current progressivo in the ordered set where anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	*
	* @param progressivoPK the primary key of the current progressivo
	* @param anno the anno
	* @param idAssociato the id associato
	* @param tipoDocumento the tipo documento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next progressivo
	* @throws it.bysoftware.ct.NoSuchProgressivoException if a progressivo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Progressivo[] findByAnnoIdAssociatoTipoDocumento_PrevAndNext(
		it.bysoftware.ct.service.persistence.ProgressivoPK progressivoPK,
		int anno, long idAssociato, int tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchProgressivoException {
		return getPersistence()
				   .findByAnnoIdAssociatoTipoDocumento_PrevAndNext(progressivoPK,
			anno, idAssociato, tipoDocumento, orderByComparator);
	}

	/**
	* Removes all the progressivos where anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63; from the database.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param tipoDocumento the tipo documento
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAnnoIdAssociatoTipoDocumento(int anno,
		long idAssociato, int tipoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByAnnoIdAssociatoTipoDocumento(anno, idAssociato,
			tipoDocumento);
	}

	/**
	* Returns the number of progressivos where anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param tipoDocumento the tipo documento
	* @return the number of matching progressivos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAnnoIdAssociatoTipoDocumento(int anno,
		long idAssociato, int tipoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByAnnoIdAssociatoTipoDocumento(anno, idAssociato,
			tipoDocumento);
	}

	/**
	* Caches the progressivo in the entity cache if it is enabled.
	*
	* @param progressivo the progressivo
	*/
	public static void cacheResult(
		it.bysoftware.ct.model.Progressivo progressivo) {
		getPersistence().cacheResult(progressivo);
	}

	/**
	* Caches the progressivos in the entity cache if it is enabled.
	*
	* @param progressivos the progressivos
	*/
	public static void cacheResult(
		java.util.List<it.bysoftware.ct.model.Progressivo> progressivos) {
		getPersistence().cacheResult(progressivos);
	}

	/**
	* Creates a new progressivo with the primary key. Does not add the progressivo to the database.
	*
	* @param progressivoPK the primary key for the new progressivo
	* @return the new progressivo
	*/
	public static it.bysoftware.ct.model.Progressivo create(
		it.bysoftware.ct.service.persistence.ProgressivoPK progressivoPK) {
		return getPersistence().create(progressivoPK);
	}

	/**
	* Removes the progressivo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param progressivoPK the primary key of the progressivo
	* @return the progressivo that was removed
	* @throws it.bysoftware.ct.NoSuchProgressivoException if a progressivo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Progressivo remove(
		it.bysoftware.ct.service.persistence.ProgressivoPK progressivoPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchProgressivoException {
		return getPersistence().remove(progressivoPK);
	}

	public static it.bysoftware.ct.model.Progressivo updateImpl(
		it.bysoftware.ct.model.Progressivo progressivo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(progressivo);
	}

	/**
	* Returns the progressivo with the primary key or throws a {@link it.bysoftware.ct.NoSuchProgressivoException} if it could not be found.
	*
	* @param progressivoPK the primary key of the progressivo
	* @return the progressivo
	* @throws it.bysoftware.ct.NoSuchProgressivoException if a progressivo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Progressivo findByPrimaryKey(
		it.bysoftware.ct.service.persistence.ProgressivoPK progressivoPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchProgressivoException {
		return getPersistence().findByPrimaryKey(progressivoPK);
	}

	/**
	* Returns the progressivo with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param progressivoPK the primary key of the progressivo
	* @return the progressivo, or <code>null</code> if a progressivo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.Progressivo fetchByPrimaryKey(
		it.bysoftware.ct.service.persistence.ProgressivoPK progressivoPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(progressivoPK);
	}

	/**
	* Returns all the progressivos.
	*
	* @return the progressivos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.Progressivo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the progressivos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.ProgressivoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of progressivos
	* @param end the upper bound of the range of progressivos (not inclusive)
	* @return the range of progressivos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.Progressivo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the progressivos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.ProgressivoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of progressivos
	* @param end the upper bound of the range of progressivos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of progressivos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.Progressivo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the progressivos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of progressivos.
	*
	* @return the number of progressivos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ProgressivoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ProgressivoPersistence)PortletBeanLocatorUtil.locate(it.bysoftware.ct.service.ClpSerializer.getServletContextName(),
					ProgressivoPersistence.class.getName());

			ReferenceRegistry.registerReference(ProgressivoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ProgressivoPersistence persistence) {
	}

	private static ProgressivoPersistence _persistence;
}
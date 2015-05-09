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

import it.bysoftware.ct.model.DestinatariDiversi;

import java.util.List;

/**
 * The persistence utility for the destinatari diversi service. This utility wraps {@link DestinatariDiversiPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DestinatariDiversiPersistence
 * @see DestinatariDiversiPersistenceImpl
 * @generated
 */
public class DestinatariDiversiUtil {
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
	public static void clearCache(DestinatariDiversi destinatariDiversi) {
		getPersistence().clearCache(destinatariDiversi);
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
	public static List<DestinatariDiversi> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DestinatariDiversi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DestinatariDiversi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static DestinatariDiversi update(
		DestinatariDiversi destinatariDiversi) throws SystemException {
		return getPersistence().update(destinatariDiversi);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static DestinatariDiversi update(
		DestinatariDiversi destinatariDiversi, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(destinatariDiversi, serviceContext);
	}

	/**
	* Returns all the destinatari diversis where codiceRiferimento = &#63;.
	*
	* @param codiceRiferimento the codice riferimento
	* @return the matching destinatari diversis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.DestinatariDiversi> findBycodiceRiferimento(
		java.lang.String codiceRiferimento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBycodiceRiferimento(codiceRiferimento);
	}

	/**
	* Returns a range of all the destinatari diversis where codiceRiferimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.DestinatariDiversiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param codiceRiferimento the codice riferimento
	* @param start the lower bound of the range of destinatari diversis
	* @param end the upper bound of the range of destinatari diversis (not inclusive)
	* @return the range of matching destinatari diversis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.DestinatariDiversi> findBycodiceRiferimento(
		java.lang.String codiceRiferimento, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycodiceRiferimento(codiceRiferimento, start, end);
	}

	/**
	* Returns an ordered range of all the destinatari diversis where codiceRiferimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.DestinatariDiversiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param codiceRiferimento the codice riferimento
	* @param start the lower bound of the range of destinatari diversis
	* @param end the upper bound of the range of destinatari diversis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching destinatari diversis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.DestinatariDiversi> findBycodiceRiferimento(
		java.lang.String codiceRiferimento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycodiceRiferimento(codiceRiferimento, start, end,
			orderByComparator);
	}

	/**
	* Returns the first destinatari diversi in the ordered set where codiceRiferimento = &#63;.
	*
	* @param codiceRiferimento the codice riferimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching destinatari diversi
	* @throws it.bysoftware.ct.NoSuchDestinatariDiversiException if a matching destinatari diversi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.DestinatariDiversi findBycodiceRiferimento_First(
		java.lang.String codiceRiferimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchDestinatariDiversiException {
		return getPersistence()
				   .findBycodiceRiferimento_First(codiceRiferimento,
			orderByComparator);
	}

	/**
	* Returns the first destinatari diversi in the ordered set where codiceRiferimento = &#63;.
	*
	* @param codiceRiferimento the codice riferimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching destinatari diversi, or <code>null</code> if a matching destinatari diversi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.DestinatariDiversi fetchBycodiceRiferimento_First(
		java.lang.String codiceRiferimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycodiceRiferimento_First(codiceRiferimento,
			orderByComparator);
	}

	/**
	* Returns the last destinatari diversi in the ordered set where codiceRiferimento = &#63;.
	*
	* @param codiceRiferimento the codice riferimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching destinatari diversi
	* @throws it.bysoftware.ct.NoSuchDestinatariDiversiException if a matching destinatari diversi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.DestinatariDiversi findBycodiceRiferimento_Last(
		java.lang.String codiceRiferimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchDestinatariDiversiException {
		return getPersistence()
				   .findBycodiceRiferimento_Last(codiceRiferimento,
			orderByComparator);
	}

	/**
	* Returns the last destinatari diversi in the ordered set where codiceRiferimento = &#63;.
	*
	* @param codiceRiferimento the codice riferimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching destinatari diversi, or <code>null</code> if a matching destinatari diversi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.DestinatariDiversi fetchBycodiceRiferimento_Last(
		java.lang.String codiceRiferimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycodiceRiferimento_Last(codiceRiferimento,
			orderByComparator);
	}

	/**
	* Returns the destinatari diversis before and after the current destinatari diversi in the ordered set where codiceRiferimento = &#63;.
	*
	* @param codiceAnagrafica the primary key of the current destinatari diversi
	* @param codiceRiferimento the codice riferimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next destinatari diversi
	* @throws it.bysoftware.ct.NoSuchDestinatariDiversiException if a destinatari diversi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.DestinatariDiversi[] findBycodiceRiferimento_PrevAndNext(
		java.lang.String codiceAnagrafica, java.lang.String codiceRiferimento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchDestinatariDiversiException {
		return getPersistence()
				   .findBycodiceRiferimento_PrevAndNext(codiceAnagrafica,
			codiceRiferimento, orderByComparator);
	}

	/**
	* Removes all the destinatari diversis where codiceRiferimento = &#63; from the database.
	*
	* @param codiceRiferimento the codice riferimento
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBycodiceRiferimento(
		java.lang.String codiceRiferimento)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBycodiceRiferimento(codiceRiferimento);
	}

	/**
	* Returns the number of destinatari diversis where codiceRiferimento = &#63;.
	*
	* @param codiceRiferimento the codice riferimento
	* @return the number of matching destinatari diversis
	* @throws SystemException if a system exception occurred
	*/
	public static int countBycodiceRiferimento(
		java.lang.String codiceRiferimento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBycodiceRiferimento(codiceRiferimento);
	}

	/**
	* Caches the destinatari diversi in the entity cache if it is enabled.
	*
	* @param destinatariDiversi the destinatari diversi
	*/
	public static void cacheResult(
		it.bysoftware.ct.model.DestinatariDiversi destinatariDiversi) {
		getPersistence().cacheResult(destinatariDiversi);
	}

	/**
	* Caches the destinatari diversis in the entity cache if it is enabled.
	*
	* @param destinatariDiversis the destinatari diversis
	*/
	public static void cacheResult(
		java.util.List<it.bysoftware.ct.model.DestinatariDiversi> destinatariDiversis) {
		getPersistence().cacheResult(destinatariDiversis);
	}

	/**
	* Creates a new destinatari diversi with the primary key. Does not add the destinatari diversi to the database.
	*
	* @param codiceAnagrafica the primary key for the new destinatari diversi
	* @return the new destinatari diversi
	*/
	public static it.bysoftware.ct.model.DestinatariDiversi create(
		java.lang.String codiceAnagrafica) {
		return getPersistence().create(codiceAnagrafica);
	}

	/**
	* Removes the destinatari diversi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param codiceAnagrafica the primary key of the destinatari diversi
	* @return the destinatari diversi that was removed
	* @throws it.bysoftware.ct.NoSuchDestinatariDiversiException if a destinatari diversi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.DestinatariDiversi remove(
		java.lang.String codiceAnagrafica)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchDestinatariDiversiException {
		return getPersistence().remove(codiceAnagrafica);
	}

	public static it.bysoftware.ct.model.DestinatariDiversi updateImpl(
		it.bysoftware.ct.model.DestinatariDiversi destinatariDiversi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(destinatariDiversi);
	}

	/**
	* Returns the destinatari diversi with the primary key or throws a {@link it.bysoftware.ct.NoSuchDestinatariDiversiException} if it could not be found.
	*
	* @param codiceAnagrafica the primary key of the destinatari diversi
	* @return the destinatari diversi
	* @throws it.bysoftware.ct.NoSuchDestinatariDiversiException if a destinatari diversi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.DestinatariDiversi findByPrimaryKey(
		java.lang.String codiceAnagrafica)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchDestinatariDiversiException {
		return getPersistence().findByPrimaryKey(codiceAnagrafica);
	}

	/**
	* Returns the destinatari diversi with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param codiceAnagrafica the primary key of the destinatari diversi
	* @return the destinatari diversi, or <code>null</code> if a destinatari diversi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.DestinatariDiversi fetchByPrimaryKey(
		java.lang.String codiceAnagrafica)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(codiceAnagrafica);
	}

	/**
	* Returns all the destinatari diversis.
	*
	* @return the destinatari diversis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.DestinatariDiversi> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the destinatari diversis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.DestinatariDiversiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of destinatari diversis
	* @param end the upper bound of the range of destinatari diversis (not inclusive)
	* @return the range of destinatari diversis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.DestinatariDiversi> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the destinatari diversis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.DestinatariDiversiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of destinatari diversis
	* @param end the upper bound of the range of destinatari diversis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of destinatari diversis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.DestinatariDiversi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the destinatari diversis from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of destinatari diversis.
	*
	* @return the number of destinatari diversis
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DestinatariDiversiPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DestinatariDiversiPersistence)PortletBeanLocatorUtil.locate(it.bysoftware.ct.service.ClpSerializer.getServletContextName(),
					DestinatariDiversiPersistence.class.getName());

			ReferenceRegistry.registerReference(DestinatariDiversiUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(DestinatariDiversiPersistence persistence) {
	}

	private static DestinatariDiversiPersistence _persistence;
}
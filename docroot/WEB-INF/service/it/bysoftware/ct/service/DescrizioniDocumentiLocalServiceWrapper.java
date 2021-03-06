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

package it.bysoftware.ct.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DescrizioniDocumentiLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DescrizioniDocumentiLocalService
 * @generated
 */
public class DescrizioniDocumentiLocalServiceWrapper
	implements DescrizioniDocumentiLocalService,
		ServiceWrapper<DescrizioniDocumentiLocalService> {
	public DescrizioniDocumentiLocalServiceWrapper(
		DescrizioniDocumentiLocalService descrizioniDocumentiLocalService) {
		_descrizioniDocumentiLocalService = descrizioniDocumentiLocalService;
	}

	/**
	* Adds the descrizioni documenti to the database. Also notifies the appropriate model listeners.
	*
	* @param descrizioniDocumenti the descrizioni documenti
	* @return the descrizioni documenti that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.DescrizioniDocumenti addDescrizioniDocumenti(
		it.bysoftware.ct.model.DescrizioniDocumenti descrizioniDocumenti)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _descrizioniDocumentiLocalService.addDescrizioniDocumenti(descrizioniDocumenti);
	}

	/**
	* Creates a new descrizioni documenti with the primary key. Does not add the descrizioni documenti to the database.
	*
	* @param codiceDescrizione the primary key for the new descrizioni documenti
	* @return the new descrizioni documenti
	*/
	@Override
	public it.bysoftware.ct.model.DescrizioniDocumenti createDescrizioniDocumenti(
		java.lang.String codiceDescrizione) {
		return _descrizioniDocumentiLocalService.createDescrizioniDocumenti(codiceDescrizione);
	}

	/**
	* Deletes the descrizioni documenti with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param codiceDescrizione the primary key of the descrizioni documenti
	* @return the descrizioni documenti that was removed
	* @throws PortalException if a descrizioni documenti with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.DescrizioniDocumenti deleteDescrizioniDocumenti(
		java.lang.String codiceDescrizione)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _descrizioniDocumentiLocalService.deleteDescrizioniDocumenti(codiceDescrizione);
	}

	/**
	* Deletes the descrizioni documenti from the database. Also notifies the appropriate model listeners.
	*
	* @param descrizioniDocumenti the descrizioni documenti
	* @return the descrizioni documenti that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.DescrizioniDocumenti deleteDescrizioniDocumenti(
		it.bysoftware.ct.model.DescrizioniDocumenti descrizioniDocumenti)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _descrizioniDocumentiLocalService.deleteDescrizioniDocumenti(descrizioniDocumenti);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _descrizioniDocumentiLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _descrizioniDocumentiLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.DescrizioniDocumentiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _descrizioniDocumentiLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.DescrizioniDocumentiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _descrizioniDocumentiLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _descrizioniDocumentiLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _descrizioniDocumentiLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.bysoftware.ct.model.DescrizioniDocumenti fetchDescrizioniDocumenti(
		java.lang.String codiceDescrizione)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _descrizioniDocumentiLocalService.fetchDescrizioniDocumenti(codiceDescrizione);
	}

	/**
	* Returns the descrizioni documenti with the primary key.
	*
	* @param codiceDescrizione the primary key of the descrizioni documenti
	* @return the descrizioni documenti
	* @throws PortalException if a descrizioni documenti with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.DescrizioniDocumenti getDescrizioniDocumenti(
		java.lang.String codiceDescrizione)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _descrizioniDocumentiLocalService.getDescrizioniDocumenti(codiceDescrizione);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _descrizioniDocumentiLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the descrizioni documentis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.DescrizioniDocumentiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of descrizioni documentis
	* @param end the upper bound of the range of descrizioni documentis (not inclusive)
	* @return the range of descrizioni documentis
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.bysoftware.ct.model.DescrizioniDocumenti> getDescrizioniDocumentis(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _descrizioniDocumentiLocalService.getDescrizioniDocumentis(start,
			end);
	}

	/**
	* Returns the number of descrizioni documentis.
	*
	* @return the number of descrizioni documentis
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDescrizioniDocumentisCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _descrizioniDocumentiLocalService.getDescrizioniDocumentisCount();
	}

	/**
	* Updates the descrizioni documenti in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param descrizioniDocumenti the descrizioni documenti
	* @return the descrizioni documenti that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.DescrizioniDocumenti updateDescrizioniDocumenti(
		it.bysoftware.ct.model.DescrizioniDocumenti descrizioniDocumenti)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _descrizioniDocumentiLocalService.updateDescrizioniDocumenti(descrizioniDocumenti);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _descrizioniDocumentiLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_descrizioniDocumentiLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _descrizioniDocumentiLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DescrizioniDocumentiLocalService getWrappedDescrizioniDocumentiLocalService() {
		return _descrizioniDocumentiLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDescrizioniDocumentiLocalService(
		DescrizioniDocumentiLocalService descrizioniDocumentiLocalService) {
		_descrizioniDocumentiLocalService = descrizioniDocumentiLocalService;
	}

	@Override
	public DescrizioniDocumentiLocalService getWrappedService() {
		return _descrizioniDocumentiLocalService;
	}

	@Override
	public void setWrappedService(
		DescrizioniDocumentiLocalService descrizioniDocumentiLocalService) {
		_descrizioniDocumentiLocalService = descrizioniDocumentiLocalService;
	}

	private DescrizioniDocumentiLocalService _descrizioniDocumentiLocalService;
}
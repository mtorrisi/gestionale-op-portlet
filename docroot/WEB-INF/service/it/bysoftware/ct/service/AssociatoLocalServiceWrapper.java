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
 * Provides a wrapper for {@link AssociatoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AssociatoLocalService
 * @generated
 */
public class AssociatoLocalServiceWrapper implements AssociatoLocalService,
	ServiceWrapper<AssociatoLocalService> {
	public AssociatoLocalServiceWrapper(
		AssociatoLocalService associatoLocalService) {
		_associatoLocalService = associatoLocalService;
	}

	/**
	* Adds the associato to the database. Also notifies the appropriate model listeners.
	*
	* @param associato the associato
	* @return the associato that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.Associato addAssociato(
		it.bysoftware.ct.model.Associato associato)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _associatoLocalService.addAssociato(associato);
	}

	/**
	* Creates a new associato with the primary key. Does not add the associato to the database.
	*
	* @param id the primary key for the new associato
	* @return the new associato
	*/
	@Override
	public it.bysoftware.ct.model.Associato createAssociato(long id) {
		return _associatoLocalService.createAssociato(id);
	}

	/**
	* Deletes the associato with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the associato
	* @return the associato that was removed
	* @throws PortalException if a associato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.Associato deleteAssociato(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _associatoLocalService.deleteAssociato(id);
	}

	/**
	* Deletes the associato from the database. Also notifies the appropriate model listeners.
	*
	* @param associato the associato
	* @return the associato that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.Associato deleteAssociato(
		it.bysoftware.ct.model.Associato associato)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _associatoLocalService.deleteAssociato(associato);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _associatoLocalService.dynamicQuery();
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
		return _associatoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AssociatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _associatoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AssociatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _associatoLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _associatoLocalService.dynamicQueryCount(dynamicQuery);
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
		return _associatoLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.bysoftware.ct.model.Associato fetchAssociato(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _associatoLocalService.fetchAssociato(id);
	}

	/**
	* Returns the associato with the primary key.
	*
	* @param id the primary key of the associato
	* @return the associato
	* @throws PortalException if a associato with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.Associato getAssociato(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _associatoLocalService.getAssociato(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _associatoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the associatos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AssociatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of associatos
	* @param end the upper bound of the range of associatos (not inclusive)
	* @return the range of associatos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.bysoftware.ct.model.Associato> getAssociatos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _associatoLocalService.getAssociatos(start, end);
	}

	/**
	* Returns the number of associatos.
	*
	* @return the number of associatos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getAssociatosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _associatoLocalService.getAssociatosCount();
	}

	/**
	* Updates the associato in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param associato the associato
	* @return the associato that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.Associato updateAssociato(
		it.bysoftware.ct.model.Associato associato)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _associatoLocalService.updateAssociato(associato);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _associatoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_associatoLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _associatoLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<it.bysoftware.ct.model.Associato> getAssociatiAttivi()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _associatoLocalService.getAssociatiAttivi();
	}

	@Override
	public java.util.List<it.bysoftware.ct.model.Associato> getAssociatiDisattivati()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _associatoLocalService.getAssociatiDisattivati();
	}

	@Override
	public int countAssociatiAttivi()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _associatoLocalService.countAssociatiAttivi();
	}

	@Override
	public int countAssociatiDisattivati()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _associatoLocalService.countAssociatiDisattivati();
	}

	@Override
	public it.bysoftware.ct.model.Associato findByLiferayId(long idLiferay)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchAssociatoException {
		return _associatoLocalService.findByLiferayId(idLiferay);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AssociatoLocalService getWrappedAssociatoLocalService() {
		return _associatoLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAssociatoLocalService(
		AssociatoLocalService associatoLocalService) {
		_associatoLocalService = associatoLocalService;
	}

	@Override
	public AssociatoLocalService getWrappedService() {
		return _associatoLocalService;
	}

	@Override
	public void setWrappedService(AssociatoLocalService associatoLocalService) {
		_associatoLocalService = associatoLocalService;
	}

	private AssociatoLocalService _associatoLocalService;
}
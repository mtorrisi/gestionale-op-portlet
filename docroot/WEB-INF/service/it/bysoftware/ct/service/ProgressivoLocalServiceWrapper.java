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
 * Provides a wrapper for {@link ProgressivoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProgressivoLocalService
 * @generated
 */
public class ProgressivoLocalServiceWrapper implements ProgressivoLocalService,
	ServiceWrapper<ProgressivoLocalService> {
	public ProgressivoLocalServiceWrapper(
		ProgressivoLocalService progressivoLocalService) {
		_progressivoLocalService = progressivoLocalService;
	}

	/**
	* Adds the progressivo to the database. Also notifies the appropriate model listeners.
	*
	* @param progressivo the progressivo
	* @return the progressivo that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.Progressivo addProgressivo(
		it.bysoftware.ct.model.Progressivo progressivo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _progressivoLocalService.addProgressivo(progressivo);
	}

	/**
	* Creates a new progressivo with the primary key. Does not add the progressivo to the database.
	*
	* @param progressivoPK the primary key for the new progressivo
	* @return the new progressivo
	*/
	@Override
	public it.bysoftware.ct.model.Progressivo createProgressivo(
		it.bysoftware.ct.service.persistence.ProgressivoPK progressivoPK) {
		return _progressivoLocalService.createProgressivo(progressivoPK);
	}

	/**
	* Deletes the progressivo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param progressivoPK the primary key of the progressivo
	* @return the progressivo that was removed
	* @throws PortalException if a progressivo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.Progressivo deleteProgressivo(
		it.bysoftware.ct.service.persistence.ProgressivoPK progressivoPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _progressivoLocalService.deleteProgressivo(progressivoPK);
	}

	/**
	* Deletes the progressivo from the database. Also notifies the appropriate model listeners.
	*
	* @param progressivo the progressivo
	* @return the progressivo that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.Progressivo deleteProgressivo(
		it.bysoftware.ct.model.Progressivo progressivo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _progressivoLocalService.deleteProgressivo(progressivo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _progressivoLocalService.dynamicQuery();
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
		return _progressivoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.ProgressivoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _progressivoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.ProgressivoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _progressivoLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _progressivoLocalService.dynamicQueryCount(dynamicQuery);
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
		return _progressivoLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.bysoftware.ct.model.Progressivo fetchProgressivo(
		it.bysoftware.ct.service.persistence.ProgressivoPK progressivoPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _progressivoLocalService.fetchProgressivo(progressivoPK);
	}

	/**
	* Returns the progressivo with the primary key.
	*
	* @param progressivoPK the primary key of the progressivo
	* @return the progressivo
	* @throws PortalException if a progressivo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.Progressivo getProgressivo(
		it.bysoftware.ct.service.persistence.ProgressivoPK progressivoPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _progressivoLocalService.getProgressivo(progressivoPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _progressivoLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<it.bysoftware.ct.model.Progressivo> getProgressivos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _progressivoLocalService.getProgressivos(start, end);
	}

	/**
	* Returns the number of progressivos.
	*
	* @return the number of progressivos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getProgressivosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _progressivoLocalService.getProgressivosCount();
	}

	/**
	* Updates the progressivo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param progressivo the progressivo
	* @return the progressivo that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.Progressivo updateProgressivo(
		it.bysoftware.ct.model.Progressivo progressivo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _progressivoLocalService.updateProgressivo(progressivo);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _progressivoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_progressivoLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _progressivoLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link it.bysoftware.ct.service.ProgressivoLocalServiceUtil} to access the progressivo local service.
	*/
	@Override
	public java.util.List<it.bysoftware.ct.model.Progressivo> getByAnnoIdAssociatoTipoDocumento(
		int anno, long idAssociato, int tipoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _progressivoLocalService.getByAnnoIdAssociatoTipoDocumento(anno,
			idAssociato, tipoDocumento);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ProgressivoLocalService getWrappedProgressivoLocalService() {
		return _progressivoLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedProgressivoLocalService(
		ProgressivoLocalService progressivoLocalService) {
		_progressivoLocalService = progressivoLocalService;
	}

	@Override
	public ProgressivoLocalService getWrappedService() {
		return _progressivoLocalService;
	}

	@Override
	public void setWrappedService(
		ProgressivoLocalService progressivoLocalService) {
		_progressivoLocalService = progressivoLocalService;
	}

	private ProgressivoLocalService _progressivoLocalService;
}
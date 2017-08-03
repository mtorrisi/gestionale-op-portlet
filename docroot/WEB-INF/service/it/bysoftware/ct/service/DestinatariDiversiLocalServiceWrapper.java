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
 * Provides a wrapper for {@link DestinatariDiversiLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DestinatariDiversiLocalService
 * @generated
 */
public class DestinatariDiversiLocalServiceWrapper
	implements DestinatariDiversiLocalService,
		ServiceWrapper<DestinatariDiversiLocalService> {
	public DestinatariDiversiLocalServiceWrapper(
		DestinatariDiversiLocalService destinatariDiversiLocalService) {
		_destinatariDiversiLocalService = destinatariDiversiLocalService;
	}

	/**
	* Adds the destinatari diversi to the database. Also notifies the appropriate model listeners.
	*
	* @param destinatariDiversi the destinatari diversi
	* @return the destinatari diversi that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.DestinatariDiversi addDestinatariDiversi(
		it.bysoftware.ct.model.DestinatariDiversi destinatariDiversi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _destinatariDiversiLocalService.addDestinatariDiversi(destinatariDiversi);
	}

	/**
	* Creates a new destinatari diversi with the primary key. Does not add the destinatari diversi to the database.
	*
	* @param codiceAnagrafica the primary key for the new destinatari diversi
	* @return the new destinatari diversi
	*/
	@Override
	public it.bysoftware.ct.model.DestinatariDiversi createDestinatariDiversi(
		java.lang.String codiceAnagrafica) {
		return _destinatariDiversiLocalService.createDestinatariDiversi(codiceAnagrafica);
	}

	/**
	* Deletes the destinatari diversi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param codiceAnagrafica the primary key of the destinatari diversi
	* @return the destinatari diversi that was removed
	* @throws PortalException if a destinatari diversi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.DestinatariDiversi deleteDestinatariDiversi(
		java.lang.String codiceAnagrafica)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _destinatariDiversiLocalService.deleteDestinatariDiversi(codiceAnagrafica);
	}

	/**
	* Deletes the destinatari diversi from the database. Also notifies the appropriate model listeners.
	*
	* @param destinatariDiversi the destinatari diversi
	* @return the destinatari diversi that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.DestinatariDiversi deleteDestinatariDiversi(
		it.bysoftware.ct.model.DestinatariDiversi destinatariDiversi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _destinatariDiversiLocalService.deleteDestinatariDiversi(destinatariDiversi);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _destinatariDiversiLocalService.dynamicQuery();
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
		return _destinatariDiversiLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.DestinatariDiversiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _destinatariDiversiLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.DestinatariDiversiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _destinatariDiversiLocalService.dynamicQuery(dynamicQuery,
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
		return _destinatariDiversiLocalService.dynamicQueryCount(dynamicQuery);
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
		return _destinatariDiversiLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.bysoftware.ct.model.DestinatariDiversi fetchDestinatariDiversi(
		java.lang.String codiceAnagrafica)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _destinatariDiversiLocalService.fetchDestinatariDiversi(codiceAnagrafica);
	}

	/**
	* Returns the destinatari diversi with the primary key.
	*
	* @param codiceAnagrafica the primary key of the destinatari diversi
	* @return the destinatari diversi
	* @throws PortalException if a destinatari diversi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.DestinatariDiversi getDestinatariDiversi(
		java.lang.String codiceAnagrafica)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _destinatariDiversiLocalService.getDestinatariDiversi(codiceAnagrafica);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _destinatariDiversiLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<it.bysoftware.ct.model.DestinatariDiversi> getDestinatariDiversis(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _destinatariDiversiLocalService.getDestinatariDiversis(start, end);
	}

	/**
	* Returns the number of destinatari diversis.
	*
	* @return the number of destinatari diversis
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDestinatariDiversisCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _destinatariDiversiLocalService.getDestinatariDiversisCount();
	}

	/**
	* Updates the destinatari diversi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param destinatariDiversi the destinatari diversi
	* @return the destinatari diversi that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.DestinatariDiversi updateDestinatariDiversi(
		it.bysoftware.ct.model.DestinatariDiversi destinatariDiversi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _destinatariDiversiLocalService.updateDestinatariDiversi(destinatariDiversi);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _destinatariDiversiLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_destinatariDiversiLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _destinatariDiversiLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public int countDestinazioniDiverse(java.lang.String codiceRiferimento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _destinatariDiversiLocalService.countDestinazioniDiverse(codiceRiferimento);
	}

	@Override
	public java.util.List<it.bysoftware.ct.model.DestinatariDiversi> getDestinazioni(
		java.lang.String codiceRiferimento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _destinatariDiversiLocalService.getDestinazioni(codiceRiferimento);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link it.bysoftware.ct.service.DestinatariDiversiLocalServiceUtil} to access the destinatari diversi local service.
	*/
	@Override
	public java.util.List<it.bysoftware.ct.model.DestinatariDiversi> getDestinazioni()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _destinatariDiversiLocalService.getDestinazioni();
	}

	@Override
	public java.util.List<it.bysoftware.ct.model.DestinatariDiversi> getDestinazioni(
		java.lang.String codiceRiferimento, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _destinatariDiversiLocalService.getDestinazioni(codiceRiferimento,
			start, end);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DestinatariDiversiLocalService getWrappedDestinatariDiversiLocalService() {
		return _destinatariDiversiLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDestinatariDiversiLocalService(
		DestinatariDiversiLocalService destinatariDiversiLocalService) {
		_destinatariDiversiLocalService = destinatariDiversiLocalService;
	}

	@Override
	public DestinatariDiversiLocalService getWrappedService() {
		return _destinatariDiversiLocalService;
	}

	@Override
	public void setWrappedService(
		DestinatariDiversiLocalService destinatariDiversiLocalService) {
		_destinatariDiversiLocalService = destinatariDiversiLocalService;
	}

	private DestinatariDiversiLocalService _destinatariDiversiLocalService;
}
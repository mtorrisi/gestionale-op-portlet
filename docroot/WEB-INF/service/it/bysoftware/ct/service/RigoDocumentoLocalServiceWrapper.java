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
 * Provides a wrapper for {@link RigoDocumentoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RigoDocumentoLocalService
 * @generated
 */
public class RigoDocumentoLocalServiceWrapper
	implements RigoDocumentoLocalService,
		ServiceWrapper<RigoDocumentoLocalService> {
	public RigoDocumentoLocalServiceWrapper(
		RigoDocumentoLocalService rigoDocumentoLocalService) {
		_rigoDocumentoLocalService = rigoDocumentoLocalService;
	}

	/**
	* Adds the rigo documento to the database. Also notifies the appropriate model listeners.
	*
	* @param rigoDocumento the rigo documento
	* @return the rigo documento that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.RigoDocumento addRigoDocumento(
		it.bysoftware.ct.model.RigoDocumento rigoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rigoDocumentoLocalService.addRigoDocumento(rigoDocumento);
	}

	/**
	* Creates a new rigo documento with the primary key. Does not add the rigo documento to the database.
	*
	* @param rigoDocumentoPK the primary key for the new rigo documento
	* @return the new rigo documento
	*/
	@Override
	public it.bysoftware.ct.model.RigoDocumento createRigoDocumento(
		it.bysoftware.ct.service.persistence.RigoDocumentoPK rigoDocumentoPK) {
		return _rigoDocumentoLocalService.createRigoDocumento(rigoDocumentoPK);
	}

	/**
	* Deletes the rigo documento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rigoDocumentoPK the primary key of the rigo documento
	* @return the rigo documento that was removed
	* @throws PortalException if a rigo documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.RigoDocumento deleteRigoDocumento(
		it.bysoftware.ct.service.persistence.RigoDocumentoPK rigoDocumentoPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rigoDocumentoLocalService.deleteRigoDocumento(rigoDocumentoPK);
	}

	/**
	* Deletes the rigo documento from the database. Also notifies the appropriate model listeners.
	*
	* @param rigoDocumento the rigo documento
	* @return the rigo documento that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.RigoDocumento deleteRigoDocumento(
		it.bysoftware.ct.model.RigoDocumento rigoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rigoDocumentoLocalService.deleteRigoDocumento(rigoDocumento);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _rigoDocumentoLocalService.dynamicQuery();
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
		return _rigoDocumentoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.RigoDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _rigoDocumentoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.RigoDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _rigoDocumentoLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _rigoDocumentoLocalService.dynamicQueryCount(dynamicQuery);
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
		return _rigoDocumentoLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.bysoftware.ct.model.RigoDocumento fetchRigoDocumento(
		it.bysoftware.ct.service.persistence.RigoDocumentoPK rigoDocumentoPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rigoDocumentoLocalService.fetchRigoDocumento(rigoDocumentoPK);
	}

	/**
	* Returns the rigo documento with the primary key.
	*
	* @param rigoDocumentoPK the primary key of the rigo documento
	* @return the rigo documento
	* @throws PortalException if a rigo documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.RigoDocumento getRigoDocumento(
		it.bysoftware.ct.service.persistence.RigoDocumentoPK rigoDocumentoPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rigoDocumentoLocalService.getRigoDocumento(rigoDocumentoPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rigoDocumentoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the rigo documentos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.RigoDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rigo documentos
	* @param end the upper bound of the range of rigo documentos (not inclusive)
	* @return the range of rigo documentos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.bysoftware.ct.model.RigoDocumento> getRigoDocumentos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rigoDocumentoLocalService.getRigoDocumentos(start, end);
	}

	/**
	* Returns the number of rigo documentos.
	*
	* @return the number of rigo documentos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getRigoDocumentosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rigoDocumentoLocalService.getRigoDocumentosCount();
	}

	/**
	* Updates the rigo documento in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param rigoDocumento the rigo documento
	* @return the rigo documento that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.RigoDocumento updateRigoDocumento(
		it.bysoftware.ct.model.RigoDocumento rigoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rigoDocumentoLocalService.updateRigoDocumento(rigoDocumento);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _rigoDocumentoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_rigoDocumentoLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _rigoDocumentoLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<it.bysoftware.ct.model.RigoDocumento> deleteRigoByNumeroOrdineAnnoAssociato(
		long numeroOrdine, int anno, long idAssociato,
		java.lang.String tipoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rigoDocumentoLocalService.deleteRigoByNumeroOrdineAnnoAssociato(numeroOrdine,
			anno, idAssociato, tipoDocumento);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link it.bysoftware.ct.service.RigoDocumentoLocalServiceUtil} to access the rigo documento local service.
	*/
	@Override
	public java.util.List<it.bysoftware.ct.model.RigoDocumento> getDDAByNumeroOrdineAnnoAssociato(
		long numeroOrdine, int anno, long idAssociato)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rigoDocumentoLocalService.getDDAByNumeroOrdineAnnoAssociato(numeroOrdine,
			anno, idAssociato);
	}

	@Override
	public java.util.List<it.bysoftware.ct.model.RigoDocumento> getDDTByNumeroOrdineAnnoAssociato(
		long numeroOrdine, int anno, long idAssociato)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rigoDocumentoLocalService.getDDTByNumeroOrdineAnnoAssociato(numeroOrdine,
			anno, idAssociato);
	}

	@Override
	public java.util.List<it.bysoftware.ct.model.RigoDocumento> getDocumentoByOrdineAnnoAssociato(
		long numeroOrdine, int anno, java.lang.String tipoDocumento,
		java.lang.String codiceArticolo, java.lang.String codiceVariante,
		java.lang.String imballo, long idAssociato)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rigoDocumentoLocalService.getDocumentoByOrdineAnnoAssociato(numeroOrdine,
			anno, tipoDocumento, codiceArticolo, codiceVariante, imballo,
			idAssociato);
	}

	@Override
	public java.util.List<it.bysoftware.ct.model.RigoDocumento> getFatturaByNumeroOrdineAnnoAssociato(
		long numeroOrdine, int anno, long idAssociato,
		java.lang.String tipoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rigoDocumentoLocalService.getFatturaByNumeroOrdineAnnoAssociato(numeroOrdine,
			anno, idAssociato, tipoDocumento);
	}

	@Override
	public java.util.List<it.bysoftware.ct.model.RigoDocumento> getNACByNumeroOrdineAnnoAssociato(
		long numeroOrdine, int anno, long idAssociato,
		java.lang.String tipoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rigoDocumentoLocalService.getNACByNumeroOrdineAnnoAssociato(numeroOrdine,
			anno, idAssociato, tipoDocumento);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public RigoDocumentoLocalService getWrappedRigoDocumentoLocalService() {
		return _rigoDocumentoLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedRigoDocumentoLocalService(
		RigoDocumentoLocalService rigoDocumentoLocalService) {
		_rigoDocumentoLocalService = rigoDocumentoLocalService;
	}

	@Override
	public RigoDocumentoLocalService getWrappedService() {
		return _rigoDocumentoLocalService;
	}

	@Override
	public void setWrappedService(
		RigoDocumentoLocalService rigoDocumentoLocalService) {
		_rigoDocumentoLocalService = rigoDocumentoLocalService;
	}

	private RigoDocumentoLocalService _rigoDocumentoLocalService;
}
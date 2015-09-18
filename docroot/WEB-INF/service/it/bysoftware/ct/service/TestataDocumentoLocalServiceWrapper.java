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
 * Provides a wrapper for {@link TestataDocumentoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TestataDocumentoLocalService
 * @generated
 */
public class TestataDocumentoLocalServiceWrapper
	implements TestataDocumentoLocalService,
		ServiceWrapper<TestataDocumentoLocalService> {
	public TestataDocumentoLocalServiceWrapper(
		TestataDocumentoLocalService testataDocumentoLocalService) {
		_testataDocumentoLocalService = testataDocumentoLocalService;
	}

	/**
	* Adds the testata documento to the database. Also notifies the appropriate model listeners.
	*
	* @param testataDocumento the testata documento
	* @return the testata documento that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.TestataDocumento addTestataDocumento(
		it.bysoftware.ct.model.TestataDocumento testataDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testataDocumentoLocalService.addTestataDocumento(testataDocumento);
	}

	/**
	* Creates a new testata documento with the primary key. Does not add the testata documento to the database.
	*
	* @param testataDocumentoPK the primary key for the new testata documento
	* @return the new testata documento
	*/
	@Override
	public it.bysoftware.ct.model.TestataDocumento createTestataDocumento(
		it.bysoftware.ct.service.persistence.TestataDocumentoPK testataDocumentoPK) {
		return _testataDocumentoLocalService.createTestataDocumento(testataDocumentoPK);
	}

	/**
	* Deletes the testata documento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param testataDocumentoPK the primary key of the testata documento
	* @return the testata documento that was removed
	* @throws PortalException if a testata documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.TestataDocumento deleteTestataDocumento(
		it.bysoftware.ct.service.persistence.TestataDocumentoPK testataDocumentoPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _testataDocumentoLocalService.deleteTestataDocumento(testataDocumentoPK);
	}

	/**
	* Deletes the testata documento from the database. Also notifies the appropriate model listeners.
	*
	* @param testataDocumento the testata documento
	* @return the testata documento that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.TestataDocumento deleteTestataDocumento(
		it.bysoftware.ct.model.TestataDocumento testataDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testataDocumentoLocalService.deleteTestataDocumento(testataDocumento);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _testataDocumentoLocalService.dynamicQuery();
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
		return _testataDocumentoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _testataDocumentoLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _testataDocumentoLocalService.dynamicQuery(dynamicQuery, start,
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
		return _testataDocumentoLocalService.dynamicQueryCount(dynamicQuery);
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
		return _testataDocumentoLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.bysoftware.ct.model.TestataDocumento fetchTestataDocumento(
		it.bysoftware.ct.service.persistence.TestataDocumentoPK testataDocumentoPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testataDocumentoLocalService.fetchTestataDocumento(testataDocumentoPK);
	}

	/**
	* Returns the testata documento with the primary key.
	*
	* @param testataDocumentoPK the primary key of the testata documento
	* @return the testata documento
	* @throws PortalException if a testata documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.TestataDocumento getTestataDocumento(
		it.bysoftware.ct.service.persistence.TestataDocumentoPK testataDocumentoPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _testataDocumentoLocalService.getTestataDocumento(testataDocumentoPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _testataDocumentoLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<it.bysoftware.ct.model.TestataDocumento> getTestataDocumentos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testataDocumentoLocalService.getTestataDocumentos(start, end);
	}

	/**
	* Returns the number of testata documentos.
	*
	* @return the number of testata documentos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTestataDocumentosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testataDocumentoLocalService.getTestataDocumentosCount();
	}

	/**
	* Updates the testata documento in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param testataDocumento the testata documento
	* @return the testata documento that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.bysoftware.ct.model.TestataDocumento updateTestataDocumento(
		it.bysoftware.ct.model.TestataDocumento testataDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testataDocumentoLocalService.updateTestataDocumento(testataDocumento);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _testataDocumentoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_testataDocumentoLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _testataDocumentoLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<it.bysoftware.ct.model.TestataDocumento> getByCodiceOperatore(
		java.lang.String codiceOperatore)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testataDocumentoLocalService.getByCodiceOperatore(codiceOperatore);
	}

	@Override
	public java.util.List<it.bysoftware.ct.model.TestataDocumento> getByCodiceOperatore(
		java.lang.String codiceOperatore, java.lang.String completo, int inviato)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testataDocumentoLocalService.getByCodiceOperatore(codiceOperatore,
			completo, inviato);
	}

	@Override
	public java.util.List<it.bysoftware.ct.model.TestataDocumento> getByCodiceSoggettoCodiceOperatore(
		java.lang.String codiceSoggetto, java.lang.String codiceOperatore)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testataDocumentoLocalService.getByCodiceSoggettoCodiceOperatore(codiceSoggetto,
			codiceOperatore);
	}

	@Override
	public java.util.List<it.bysoftware.ct.model.TestataDocumento> getDocumentiSoggetto(
		int anno, java.lang.String idDocumento, long idAssociato)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testataDocumentoLocalService.getDocumentiSoggetto(anno,
			idDocumento, idAssociato);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TestataDocumentoLocalService getWrappedTestataDocumentoLocalService() {
		return _testataDocumentoLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTestataDocumentoLocalService(
		TestataDocumentoLocalService testataDocumentoLocalService) {
		_testataDocumentoLocalService = testataDocumentoLocalService;
	}

	@Override
	public TestataDocumentoLocalService getWrappedService() {
		return _testataDocumentoLocalService;
	}

	@Override
	public void setWrappedService(
		TestataDocumentoLocalService testataDocumentoLocalService) {
		_testataDocumentoLocalService = testataDocumentoLocalService;
	}

	private TestataDocumentoLocalService _testataDocumentoLocalService;
}
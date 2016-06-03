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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for WKRigoDocumento. This utility wraps
 * {@link it.bysoftware.ct.service.impl.WKRigoDocumentoLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see WKRigoDocumentoLocalService
 * @see it.bysoftware.ct.service.base.WKRigoDocumentoLocalServiceBaseImpl
 * @see it.bysoftware.ct.service.impl.WKRigoDocumentoLocalServiceImpl
 * @generated
 */
public class WKRigoDocumentoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.bysoftware.ct.service.impl.WKRigoDocumentoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the w k rigo documento to the database. Also notifies the appropriate model listeners.
	*
	* @param wkRigoDocumento the w k rigo documento
	* @return the w k rigo documento that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.WKRigoDocumento addWKRigoDocumento(
		it.bysoftware.ct.model.WKRigoDocumento wkRigoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addWKRigoDocumento(wkRigoDocumento);
	}

	/**
	* Creates a new w k rigo documento with the primary key. Does not add the w k rigo documento to the database.
	*
	* @param wkRigoDocumentoPK the primary key for the new w k rigo documento
	* @return the new w k rigo documento
	*/
	public static it.bysoftware.ct.model.WKRigoDocumento createWKRigoDocumento(
		it.bysoftware.ct.service.persistence.WKRigoDocumentoPK wkRigoDocumentoPK) {
		return getService().createWKRigoDocumento(wkRigoDocumentoPK);
	}

	/**
	* Deletes the w k rigo documento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wkRigoDocumentoPK the primary key of the w k rigo documento
	* @return the w k rigo documento that was removed
	* @throws PortalException if a w k rigo documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.WKRigoDocumento deleteWKRigoDocumento(
		it.bysoftware.ct.service.persistence.WKRigoDocumentoPK wkRigoDocumentoPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteWKRigoDocumento(wkRigoDocumentoPK);
	}

	/**
	* Deletes the w k rigo documento from the database. Also notifies the appropriate model listeners.
	*
	* @param wkRigoDocumento the w k rigo documento
	* @return the w k rigo documento that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.WKRigoDocumento deleteWKRigoDocumento(
		it.bysoftware.ct.model.WKRigoDocumento wkRigoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteWKRigoDocumento(wkRigoDocumento);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.WKRigoDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.WKRigoDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static it.bysoftware.ct.model.WKRigoDocumento fetchWKRigoDocumento(
		it.bysoftware.ct.service.persistence.WKRigoDocumentoPK wkRigoDocumentoPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchWKRigoDocumento(wkRigoDocumentoPK);
	}

	/**
	* Returns the w k rigo documento with the primary key.
	*
	* @param wkRigoDocumentoPK the primary key of the w k rigo documento
	* @return the w k rigo documento
	* @throws PortalException if a w k rigo documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.WKRigoDocumento getWKRigoDocumento(
		it.bysoftware.ct.service.persistence.WKRigoDocumentoPK wkRigoDocumentoPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getWKRigoDocumento(wkRigoDocumentoPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the w k rigo documentos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.WKRigoDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of w k rigo documentos
	* @param end the upper bound of the range of w k rigo documentos (not inclusive)
	* @return the range of w k rigo documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.bysoftware.ct.model.WKRigoDocumento> getWKRigoDocumentos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWKRigoDocumentos(start, end);
	}

	/**
	* Returns the number of w k rigo documentos.
	*
	* @return the number of w k rigo documentos
	* @throws SystemException if a system exception occurred
	*/
	public static int getWKRigoDocumentosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWKRigoDocumentosCount();
	}

	/**
	* Updates the w k rigo documento in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wkRigoDocumento the w k rigo documento
	* @return the w k rigo documento that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.WKRigoDocumento updateWKRigoDocumento(
		it.bysoftware.ct.model.WKRigoDocumento wkRigoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateWKRigoDocumento(wkRigoDocumento);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<it.bysoftware.ct.model.WKRigoDocumento> getByNumeroOrdineAnnoAssociatoTipoDocumento(
		long numeroOrdine, int anno, long idAssociato,
		java.lang.String tipoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getByNumeroOrdineAnnoAssociatoTipoDocumento(numeroOrdine,
			anno, idAssociato, tipoDocumento);
	}

	public static java.util.List<it.bysoftware.ct.model.WKRigoDocumento> getByAnnoAssociato(
		int anno, long idAssociato)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByAnnoAssociato(anno, idAssociato);
	}

	public static void clearService() {
		_service = null;
	}

	public static WKRigoDocumentoLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					WKRigoDocumentoLocalService.class.getName());

			if (invokableLocalService instanceof WKRigoDocumentoLocalService) {
				_service = (WKRigoDocumentoLocalService)invokableLocalService;
			}
			else {
				_service = new WKRigoDocumentoLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(WKRigoDocumentoLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(WKRigoDocumentoLocalService service) {
	}

	private static WKRigoDocumentoLocalService _service;
}
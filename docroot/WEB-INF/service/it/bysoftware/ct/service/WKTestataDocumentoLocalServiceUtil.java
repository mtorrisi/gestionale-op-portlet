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
 * Provides the local service utility for WKTestataDocumento. This utility wraps
 * {@link it.bysoftware.ct.service.impl.WKTestataDocumentoLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see WKTestataDocumentoLocalService
 * @see it.bysoftware.ct.service.base.WKTestataDocumentoLocalServiceBaseImpl
 * @see it.bysoftware.ct.service.impl.WKTestataDocumentoLocalServiceImpl
 * @generated
 */
public class WKTestataDocumentoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.bysoftware.ct.service.impl.WKTestataDocumentoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the w k testata documento to the database. Also notifies the appropriate model listeners.
	*
	* @param wkTestataDocumento the w k testata documento
	* @return the w k testata documento that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.WKTestataDocumento addWKTestataDocumento(
		it.bysoftware.ct.model.WKTestataDocumento wkTestataDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addWKTestataDocumento(wkTestataDocumento);
	}

	/**
	* Creates a new w k testata documento with the primary key. Does not add the w k testata documento to the database.
	*
	* @param wkTestataDocumentoPK the primary key for the new w k testata documento
	* @return the new w k testata documento
	*/
	public static it.bysoftware.ct.model.WKTestataDocumento createWKTestataDocumento(
		it.bysoftware.ct.service.persistence.WKTestataDocumentoPK wkTestataDocumentoPK) {
		return getService().createWKTestataDocumento(wkTestataDocumentoPK);
	}

	/**
	* Deletes the w k testata documento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wkTestataDocumentoPK the primary key of the w k testata documento
	* @return the w k testata documento that was removed
	* @throws PortalException if a w k testata documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.WKTestataDocumento deleteWKTestataDocumento(
		it.bysoftware.ct.service.persistence.WKTestataDocumentoPK wkTestataDocumentoPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteWKTestataDocumento(wkTestataDocumentoPK);
	}

	/**
	* Deletes the w k testata documento from the database. Also notifies the appropriate model listeners.
	*
	* @param wkTestataDocumento the w k testata documento
	* @return the w k testata documento that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.WKTestataDocumento deleteWKTestataDocumento(
		it.bysoftware.ct.model.WKTestataDocumento wkTestataDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteWKTestataDocumento(wkTestataDocumento);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.WKTestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.WKTestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.bysoftware.ct.model.WKTestataDocumento fetchWKTestataDocumento(
		it.bysoftware.ct.service.persistence.WKTestataDocumentoPK wkTestataDocumentoPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchWKTestataDocumento(wkTestataDocumentoPK);
	}

	/**
	* Returns the w k testata documento with the primary key.
	*
	* @param wkTestataDocumentoPK the primary key of the w k testata documento
	* @return the w k testata documento
	* @throws PortalException if a w k testata documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.WKTestataDocumento getWKTestataDocumento(
		it.bysoftware.ct.service.persistence.WKTestataDocumentoPK wkTestataDocumentoPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getWKTestataDocumento(wkTestataDocumentoPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<it.bysoftware.ct.model.WKTestataDocumento> getWKTestataDocumentos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWKTestataDocumentos(start, end);
	}

	/**
	* Returns the number of w k testata documentos.
	*
	* @return the number of w k testata documentos
	* @throws SystemException if a system exception occurred
	*/
	public static int getWKTestataDocumentosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWKTestataDocumentosCount();
	}

	/**
	* Updates the w k testata documento in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wkTestataDocumento the w k testata documento
	* @return the w k testata documento that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.bysoftware.ct.model.WKTestataDocumento updateWKTestataDocumento(
		it.bysoftware.ct.model.WKTestataDocumento wkTestataDocumento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateWKTestataDocumento(wkTestataDocumento);
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

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link it.bysoftware.ct.service.WKTestataDocumentoLocalServiceUtil} to access the w k testata documento local service.
	*/
	public static java.util.List<it.bysoftware.ct.model.WKTestataDocumento> getReady(
		int anno, long idAssociato)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getReady(anno, idAssociato);
	}

	public static java.util.List<it.bysoftware.ct.model.WKTestataDocumento> getToCheck(
		int anno, long idAssociato)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getToCheck(anno, idAssociato);
	}

	public static void clearService() {
		_service = null;
	}

	public static WKTestataDocumentoLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					WKTestataDocumentoLocalService.class.getName());

			if (invokableLocalService instanceof WKTestataDocumentoLocalService) {
				_service = (WKTestataDocumentoLocalService)invokableLocalService;
			}
			else {
				_service = new WKTestataDocumentoLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(WKTestataDocumentoLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(WKTestataDocumentoLocalService service) {
	}

	private static WKTestataDocumentoLocalService _service;
}
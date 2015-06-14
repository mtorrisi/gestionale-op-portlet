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

package it.bysoftware.ct.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import it.bysoftware.ct.model.TestataDocumento;
import it.bysoftware.ct.service.TestataDocumentoLocalService;
import it.bysoftware.ct.service.persistence.AnagraficaPersistence;
import it.bysoftware.ct.service.persistence.ArticoliPersistence;
import it.bysoftware.ct.service.persistence.DestinatariDiversiPersistence;
import it.bysoftware.ct.service.persistence.RigoDocumentoPersistence;
import it.bysoftware.ct.service.persistence.TestataDocumentoPK;
import it.bysoftware.ct.service.persistence.TestataDocumentoPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the testata documento local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link it.bysoftware.ct.service.impl.TestataDocumentoLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.impl.TestataDocumentoLocalServiceImpl
 * @see it.bysoftware.ct.service.TestataDocumentoLocalServiceUtil
 * @generated
 */
public abstract class TestataDocumentoLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements TestataDocumentoLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link it.bysoftware.ct.service.TestataDocumentoLocalServiceUtil} to access the testata documento local service.
	 */

	/**
	 * Adds the testata documento to the database. Also notifies the appropriate model listeners.
	 *
	 * @param testataDocumento the testata documento
	 * @return the testata documento that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public TestataDocumento addTestataDocumento(
		TestataDocumento testataDocumento) throws SystemException {
		testataDocumento.setNew(true);

		return testataDocumentoPersistence.update(testataDocumento);
	}

	/**
	 * Creates a new testata documento with the primary key. Does not add the testata documento to the database.
	 *
	 * @param testataDocumentoPK the primary key for the new testata documento
	 * @return the new testata documento
	 */
	@Override
	public TestataDocumento createTestataDocumento(
		TestataDocumentoPK testataDocumentoPK) {
		return testataDocumentoPersistence.create(testataDocumentoPK);
	}

	/**
	 * Deletes the testata documento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param testataDocumentoPK the primary key of the testata documento
	 * @return the testata documento that was removed
	 * @throws PortalException if a testata documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public TestataDocumento deleteTestataDocumento(
		TestataDocumentoPK testataDocumentoPK)
		throws PortalException, SystemException {
		return testataDocumentoPersistence.remove(testataDocumentoPK);
	}

	/**
	 * Deletes the testata documento from the database. Also notifies the appropriate model listeners.
	 *
	 * @param testataDocumento the testata documento
	 * @return the testata documento that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public TestataDocumento deleteTestataDocumento(
		TestataDocumento testataDocumento) throws SystemException {
		return testataDocumentoPersistence.remove(testataDocumento);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(TestataDocumento.class,
			clazz.getClassLoader());
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
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return testataDocumentoPersistence.findWithDynamicQuery(dynamicQuery);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return testataDocumentoPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return testataDocumentoPersistence.findWithDynamicQuery(dynamicQuery,
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return testataDocumentoPersistence.countWithDynamicQuery(dynamicQuery);
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return testataDocumentoPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public TestataDocumento fetchTestataDocumento(
		TestataDocumentoPK testataDocumentoPK) throws SystemException {
		return testataDocumentoPersistence.fetchByPrimaryKey(testataDocumentoPK);
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
	public TestataDocumento getTestataDocumento(
		TestataDocumentoPK testataDocumentoPK)
		throws PortalException, SystemException {
		return testataDocumentoPersistence.findByPrimaryKey(testataDocumentoPK);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return testataDocumentoPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<TestataDocumento> getTestataDocumentos(int start, int end)
		throws SystemException {
		return testataDocumentoPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of testata documentos.
	 *
	 * @return the number of testata documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getTestataDocumentosCount() throws SystemException {
		return testataDocumentoPersistence.countAll();
	}

	/**
	 * Updates the testata documento in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param testataDocumento the testata documento
	 * @return the testata documento that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public TestataDocumento updateTestataDocumento(
		TestataDocumento testataDocumento) throws SystemException {
		return testataDocumentoPersistence.update(testataDocumento);
	}

	/**
	 * Returns the anagrafica local service.
	 *
	 * @return the anagrafica local service
	 */
	public it.bysoftware.ct.service.AnagraficaLocalService getAnagraficaLocalService() {
		return anagraficaLocalService;
	}

	/**
	 * Sets the anagrafica local service.
	 *
	 * @param anagraficaLocalService the anagrafica local service
	 */
	public void setAnagraficaLocalService(
		it.bysoftware.ct.service.AnagraficaLocalService anagraficaLocalService) {
		this.anagraficaLocalService = anagraficaLocalService;
	}

	/**
	 * Returns the anagrafica remote service.
	 *
	 * @return the anagrafica remote service
	 */
	public it.bysoftware.ct.service.AnagraficaService getAnagraficaService() {
		return anagraficaService;
	}

	/**
	 * Sets the anagrafica remote service.
	 *
	 * @param anagraficaService the anagrafica remote service
	 */
	public void setAnagraficaService(
		it.bysoftware.ct.service.AnagraficaService anagraficaService) {
		this.anagraficaService = anagraficaService;
	}

	/**
	 * Returns the anagrafica persistence.
	 *
	 * @return the anagrafica persistence
	 */
	public AnagraficaPersistence getAnagraficaPersistence() {
		return anagraficaPersistence;
	}

	/**
	 * Sets the anagrafica persistence.
	 *
	 * @param anagraficaPersistence the anagrafica persistence
	 */
	public void setAnagraficaPersistence(
		AnagraficaPersistence anagraficaPersistence) {
		this.anagraficaPersistence = anagraficaPersistence;
	}

	/**
	 * Returns the articoli local service.
	 *
	 * @return the articoli local service
	 */
	public it.bysoftware.ct.service.ArticoliLocalService getArticoliLocalService() {
		return articoliLocalService;
	}

	/**
	 * Sets the articoli local service.
	 *
	 * @param articoliLocalService the articoli local service
	 */
	public void setArticoliLocalService(
		it.bysoftware.ct.service.ArticoliLocalService articoliLocalService) {
		this.articoliLocalService = articoliLocalService;
	}

	/**
	 * Returns the articoli remote service.
	 *
	 * @return the articoli remote service
	 */
	public it.bysoftware.ct.service.ArticoliService getArticoliService() {
		return articoliService;
	}

	/**
	 * Sets the articoli remote service.
	 *
	 * @param articoliService the articoli remote service
	 */
	public void setArticoliService(
		it.bysoftware.ct.service.ArticoliService articoliService) {
		this.articoliService = articoliService;
	}

	/**
	 * Returns the articoli persistence.
	 *
	 * @return the articoli persistence
	 */
	public ArticoliPersistence getArticoliPersistence() {
		return articoliPersistence;
	}

	/**
	 * Sets the articoli persistence.
	 *
	 * @param articoliPersistence the articoli persistence
	 */
	public void setArticoliPersistence(ArticoliPersistence articoliPersistence) {
		this.articoliPersistence = articoliPersistence;
	}

	/**
	 * Returns the destinatari diversi local service.
	 *
	 * @return the destinatari diversi local service
	 */
	public it.bysoftware.ct.service.DestinatariDiversiLocalService getDestinatariDiversiLocalService() {
		return destinatariDiversiLocalService;
	}

	/**
	 * Sets the destinatari diversi local service.
	 *
	 * @param destinatariDiversiLocalService the destinatari diversi local service
	 */
	public void setDestinatariDiversiLocalService(
		it.bysoftware.ct.service.DestinatariDiversiLocalService destinatariDiversiLocalService) {
		this.destinatariDiversiLocalService = destinatariDiversiLocalService;
	}

	/**
	 * Returns the destinatari diversi remote service.
	 *
	 * @return the destinatari diversi remote service
	 */
	public it.bysoftware.ct.service.DestinatariDiversiService getDestinatariDiversiService() {
		return destinatariDiversiService;
	}

	/**
	 * Sets the destinatari diversi remote service.
	 *
	 * @param destinatariDiversiService the destinatari diversi remote service
	 */
	public void setDestinatariDiversiService(
		it.bysoftware.ct.service.DestinatariDiversiService destinatariDiversiService) {
		this.destinatariDiversiService = destinatariDiversiService;
	}

	/**
	 * Returns the destinatari diversi persistence.
	 *
	 * @return the destinatari diversi persistence
	 */
	public DestinatariDiversiPersistence getDestinatariDiversiPersistence() {
		return destinatariDiversiPersistence;
	}

	/**
	 * Sets the destinatari diversi persistence.
	 *
	 * @param destinatariDiversiPersistence the destinatari diversi persistence
	 */
	public void setDestinatariDiversiPersistence(
		DestinatariDiversiPersistence destinatariDiversiPersistence) {
		this.destinatariDiversiPersistence = destinatariDiversiPersistence;
	}

	/**
	 * Returns the rigo documento local service.
	 *
	 * @return the rigo documento local service
	 */
	public it.bysoftware.ct.service.RigoDocumentoLocalService getRigoDocumentoLocalService() {
		return rigoDocumentoLocalService;
	}

	/**
	 * Sets the rigo documento local service.
	 *
	 * @param rigoDocumentoLocalService the rigo documento local service
	 */
	public void setRigoDocumentoLocalService(
		it.bysoftware.ct.service.RigoDocumentoLocalService rigoDocumentoLocalService) {
		this.rigoDocumentoLocalService = rigoDocumentoLocalService;
	}

	/**
	 * Returns the rigo documento remote service.
	 *
	 * @return the rigo documento remote service
	 */
	public it.bysoftware.ct.service.RigoDocumentoService getRigoDocumentoService() {
		return rigoDocumentoService;
	}

	/**
	 * Sets the rigo documento remote service.
	 *
	 * @param rigoDocumentoService the rigo documento remote service
	 */
	public void setRigoDocumentoService(
		it.bysoftware.ct.service.RigoDocumentoService rigoDocumentoService) {
		this.rigoDocumentoService = rigoDocumentoService;
	}

	/**
	 * Returns the rigo documento persistence.
	 *
	 * @return the rigo documento persistence
	 */
	public RigoDocumentoPersistence getRigoDocumentoPersistence() {
		return rigoDocumentoPersistence;
	}

	/**
	 * Sets the rigo documento persistence.
	 *
	 * @param rigoDocumentoPersistence the rigo documento persistence
	 */
	public void setRigoDocumentoPersistence(
		RigoDocumentoPersistence rigoDocumentoPersistence) {
		this.rigoDocumentoPersistence = rigoDocumentoPersistence;
	}

	/**
	 * Returns the testata documento local service.
	 *
	 * @return the testata documento local service
	 */
	public it.bysoftware.ct.service.TestataDocumentoLocalService getTestataDocumentoLocalService() {
		return testataDocumentoLocalService;
	}

	/**
	 * Sets the testata documento local service.
	 *
	 * @param testataDocumentoLocalService the testata documento local service
	 */
	public void setTestataDocumentoLocalService(
		it.bysoftware.ct.service.TestataDocumentoLocalService testataDocumentoLocalService) {
		this.testataDocumentoLocalService = testataDocumentoLocalService;
	}

	/**
	 * Returns the testata documento remote service.
	 *
	 * @return the testata documento remote service
	 */
	public it.bysoftware.ct.service.TestataDocumentoService getTestataDocumentoService() {
		return testataDocumentoService;
	}

	/**
	 * Sets the testata documento remote service.
	 *
	 * @param testataDocumentoService the testata documento remote service
	 */
	public void setTestataDocumentoService(
		it.bysoftware.ct.service.TestataDocumentoService testataDocumentoService) {
		this.testataDocumentoService = testataDocumentoService;
	}

	/**
	 * Returns the testata documento persistence.
	 *
	 * @return the testata documento persistence
	 */
	public TestataDocumentoPersistence getTestataDocumentoPersistence() {
		return testataDocumentoPersistence;
	}

	/**
	 * Sets the testata documento persistence.
	 *
	 * @param testataDocumentoPersistence the testata documento persistence
	 */
	public void setTestataDocumentoPersistence(
		TestataDocumentoPersistence testataDocumentoPersistence) {
		this.testataDocumentoPersistence = testataDocumentoPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("it.bysoftware.ct.model.TestataDocumento",
			testataDocumentoLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"it.bysoftware.ct.model.TestataDocumento");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return TestataDocumento.class;
	}

	protected String getModelClassName() {
		return TestataDocumento.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = testataDocumentoPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = it.bysoftware.ct.service.AnagraficaLocalService.class)
	protected it.bysoftware.ct.service.AnagraficaLocalService anagraficaLocalService;
	@BeanReference(type = it.bysoftware.ct.service.AnagraficaService.class)
	protected it.bysoftware.ct.service.AnagraficaService anagraficaService;
	@BeanReference(type = AnagraficaPersistence.class)
	protected AnagraficaPersistence anagraficaPersistence;
	@BeanReference(type = it.bysoftware.ct.service.ArticoliLocalService.class)
	protected it.bysoftware.ct.service.ArticoliLocalService articoliLocalService;
	@BeanReference(type = it.bysoftware.ct.service.ArticoliService.class)
	protected it.bysoftware.ct.service.ArticoliService articoliService;
	@BeanReference(type = ArticoliPersistence.class)
	protected ArticoliPersistence articoliPersistence;
	@BeanReference(type = it.bysoftware.ct.service.DestinatariDiversiLocalService.class)
	protected it.bysoftware.ct.service.DestinatariDiversiLocalService destinatariDiversiLocalService;
	@BeanReference(type = it.bysoftware.ct.service.DestinatariDiversiService.class)
	protected it.bysoftware.ct.service.DestinatariDiversiService destinatariDiversiService;
	@BeanReference(type = DestinatariDiversiPersistence.class)
	protected DestinatariDiversiPersistence destinatariDiversiPersistence;
	@BeanReference(type = it.bysoftware.ct.service.RigoDocumentoLocalService.class)
	protected it.bysoftware.ct.service.RigoDocumentoLocalService rigoDocumentoLocalService;
	@BeanReference(type = it.bysoftware.ct.service.RigoDocumentoService.class)
	protected it.bysoftware.ct.service.RigoDocumentoService rigoDocumentoService;
	@BeanReference(type = RigoDocumentoPersistence.class)
	protected RigoDocumentoPersistence rigoDocumentoPersistence;
	@BeanReference(type = it.bysoftware.ct.service.TestataDocumentoLocalService.class)
	protected it.bysoftware.ct.service.TestataDocumentoLocalService testataDocumentoLocalService;
	@BeanReference(type = it.bysoftware.ct.service.TestataDocumentoService.class)
	protected it.bysoftware.ct.service.TestataDocumentoService testataDocumentoService;
	@BeanReference(type = TestataDocumentoPersistence.class)
	protected TestataDocumentoPersistence testataDocumentoPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private TestataDocumentoLocalServiceClpInvoker _clpInvoker = new TestataDocumentoLocalServiceClpInvoker();
}
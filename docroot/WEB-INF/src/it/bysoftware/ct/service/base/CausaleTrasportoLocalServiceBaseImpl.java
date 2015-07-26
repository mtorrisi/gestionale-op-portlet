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

import it.bysoftware.ct.model.CausaleTrasporto;
import it.bysoftware.ct.service.CausaleTrasportoLocalService;
import it.bysoftware.ct.service.persistence.AnagraficaPersistence;
import it.bysoftware.ct.service.persistence.ArticoliPersistence;
import it.bysoftware.ct.service.persistence.AspettoEsterioreBeniPersistence;
import it.bysoftware.ct.service.persistence.CausaleTrasportoPersistence;
import it.bysoftware.ct.service.persistence.CuraTrasportoPersistence;
import it.bysoftware.ct.service.persistence.DestinatariDiversiPersistence;
import it.bysoftware.ct.service.persistence.PortoPersistence;
import it.bysoftware.ct.service.persistence.RigoDocumentoPersistence;
import it.bysoftware.ct.service.persistence.TestataDocumentoPersistence;
import it.bysoftware.ct.service.persistence.VettoriPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the causale trasporto local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link it.bysoftware.ct.service.impl.CausaleTrasportoLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.impl.CausaleTrasportoLocalServiceImpl
 * @see it.bysoftware.ct.service.CausaleTrasportoLocalServiceUtil
 * @generated
 */
public abstract class CausaleTrasportoLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements CausaleTrasportoLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link it.bysoftware.ct.service.CausaleTrasportoLocalServiceUtil} to access the causale trasporto local service.
	 */

	/**
	 * Adds the causale trasporto to the database. Also notifies the appropriate model listeners.
	 *
	 * @param causaleTrasporto the causale trasporto
	 * @return the causale trasporto that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CausaleTrasporto addCausaleTrasporto(
		CausaleTrasporto causaleTrasporto) throws SystemException {
		causaleTrasporto.setNew(true);

		return causaleTrasportoPersistence.update(causaleTrasporto);
	}

	/**
	 * Creates a new causale trasporto with the primary key. Does not add the causale trasporto to the database.
	 *
	 * @param codiceCausaleTrasporto the primary key for the new causale trasporto
	 * @return the new causale trasporto
	 */
	@Override
	public CausaleTrasporto createCausaleTrasporto(
		String codiceCausaleTrasporto) {
		return causaleTrasportoPersistence.create(codiceCausaleTrasporto);
	}

	/**
	 * Deletes the causale trasporto with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param codiceCausaleTrasporto the primary key of the causale trasporto
	 * @return the causale trasporto that was removed
	 * @throws PortalException if a causale trasporto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CausaleTrasporto deleteCausaleTrasporto(
		String codiceCausaleTrasporto) throws PortalException, SystemException {
		return causaleTrasportoPersistence.remove(codiceCausaleTrasporto);
	}

	/**
	 * Deletes the causale trasporto from the database. Also notifies the appropriate model listeners.
	 *
	 * @param causaleTrasporto the causale trasporto
	 * @return the causale trasporto that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CausaleTrasporto deleteCausaleTrasporto(
		CausaleTrasporto causaleTrasporto) throws SystemException {
		return causaleTrasportoPersistence.remove(causaleTrasporto);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(CausaleTrasporto.class,
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
		return causaleTrasportoPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.CausaleTrasportoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return causaleTrasportoPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.CausaleTrasportoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return causaleTrasportoPersistence.findWithDynamicQuery(dynamicQuery,
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
		return causaleTrasportoPersistence.countWithDynamicQuery(dynamicQuery);
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
		return causaleTrasportoPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public CausaleTrasporto fetchCausaleTrasporto(String codiceCausaleTrasporto)
		throws SystemException {
		return causaleTrasportoPersistence.fetchByPrimaryKey(codiceCausaleTrasporto);
	}

	/**
	 * Returns the causale trasporto with the primary key.
	 *
	 * @param codiceCausaleTrasporto the primary key of the causale trasporto
	 * @return the causale trasporto
	 * @throws PortalException if a causale trasporto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CausaleTrasporto getCausaleTrasporto(String codiceCausaleTrasporto)
		throws PortalException, SystemException {
		return causaleTrasportoPersistence.findByPrimaryKey(codiceCausaleTrasporto);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return causaleTrasportoPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the causale trasportos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.CausaleTrasportoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of causale trasportos
	 * @param end the upper bound of the range of causale trasportos (not inclusive)
	 * @return the range of causale trasportos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CausaleTrasporto> getCausaleTrasportos(int start, int end)
		throws SystemException {
		return causaleTrasportoPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of causale trasportos.
	 *
	 * @return the number of causale trasportos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getCausaleTrasportosCount() throws SystemException {
		return causaleTrasportoPersistence.countAll();
	}

	/**
	 * Updates the causale trasporto in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param causaleTrasporto the causale trasporto
	 * @return the causale trasporto that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CausaleTrasporto updateCausaleTrasporto(
		CausaleTrasporto causaleTrasporto) throws SystemException {
		return causaleTrasportoPersistence.update(causaleTrasporto);
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
	 * Returns the aspetto esteriore beni local service.
	 *
	 * @return the aspetto esteriore beni local service
	 */
	public it.bysoftware.ct.service.AspettoEsterioreBeniLocalService getAspettoEsterioreBeniLocalService() {
		return aspettoEsterioreBeniLocalService;
	}

	/**
	 * Sets the aspetto esteriore beni local service.
	 *
	 * @param aspettoEsterioreBeniLocalService the aspetto esteriore beni local service
	 */
	public void setAspettoEsterioreBeniLocalService(
		it.bysoftware.ct.service.AspettoEsterioreBeniLocalService aspettoEsterioreBeniLocalService) {
		this.aspettoEsterioreBeniLocalService = aspettoEsterioreBeniLocalService;
	}

	/**
	 * Returns the aspetto esteriore beni remote service.
	 *
	 * @return the aspetto esteriore beni remote service
	 */
	public it.bysoftware.ct.service.AspettoEsterioreBeniService getAspettoEsterioreBeniService() {
		return aspettoEsterioreBeniService;
	}

	/**
	 * Sets the aspetto esteriore beni remote service.
	 *
	 * @param aspettoEsterioreBeniService the aspetto esteriore beni remote service
	 */
	public void setAspettoEsterioreBeniService(
		it.bysoftware.ct.service.AspettoEsterioreBeniService aspettoEsterioreBeniService) {
		this.aspettoEsterioreBeniService = aspettoEsterioreBeniService;
	}

	/**
	 * Returns the aspetto esteriore beni persistence.
	 *
	 * @return the aspetto esteriore beni persistence
	 */
	public AspettoEsterioreBeniPersistence getAspettoEsterioreBeniPersistence() {
		return aspettoEsterioreBeniPersistence;
	}

	/**
	 * Sets the aspetto esteriore beni persistence.
	 *
	 * @param aspettoEsterioreBeniPersistence the aspetto esteriore beni persistence
	 */
	public void setAspettoEsterioreBeniPersistence(
		AspettoEsterioreBeniPersistence aspettoEsterioreBeniPersistence) {
		this.aspettoEsterioreBeniPersistence = aspettoEsterioreBeniPersistence;
	}

	/**
	 * Returns the causale trasporto local service.
	 *
	 * @return the causale trasporto local service
	 */
	public it.bysoftware.ct.service.CausaleTrasportoLocalService getCausaleTrasportoLocalService() {
		return causaleTrasportoLocalService;
	}

	/**
	 * Sets the causale trasporto local service.
	 *
	 * @param causaleTrasportoLocalService the causale trasporto local service
	 */
	public void setCausaleTrasportoLocalService(
		it.bysoftware.ct.service.CausaleTrasportoLocalService causaleTrasportoLocalService) {
		this.causaleTrasportoLocalService = causaleTrasportoLocalService;
	}

	/**
	 * Returns the causale trasporto remote service.
	 *
	 * @return the causale trasporto remote service
	 */
	public it.bysoftware.ct.service.CausaleTrasportoService getCausaleTrasportoService() {
		return causaleTrasportoService;
	}

	/**
	 * Sets the causale trasporto remote service.
	 *
	 * @param causaleTrasportoService the causale trasporto remote service
	 */
	public void setCausaleTrasportoService(
		it.bysoftware.ct.service.CausaleTrasportoService causaleTrasportoService) {
		this.causaleTrasportoService = causaleTrasportoService;
	}

	/**
	 * Returns the causale trasporto persistence.
	 *
	 * @return the causale trasporto persistence
	 */
	public CausaleTrasportoPersistence getCausaleTrasportoPersistence() {
		return causaleTrasportoPersistence;
	}

	/**
	 * Sets the causale trasporto persistence.
	 *
	 * @param causaleTrasportoPersistence the causale trasporto persistence
	 */
	public void setCausaleTrasportoPersistence(
		CausaleTrasportoPersistence causaleTrasportoPersistence) {
		this.causaleTrasportoPersistence = causaleTrasportoPersistence;
	}

	/**
	 * Returns the cura trasporto local service.
	 *
	 * @return the cura trasporto local service
	 */
	public it.bysoftware.ct.service.CuraTrasportoLocalService getCuraTrasportoLocalService() {
		return curaTrasportoLocalService;
	}

	/**
	 * Sets the cura trasporto local service.
	 *
	 * @param curaTrasportoLocalService the cura trasporto local service
	 */
	public void setCuraTrasportoLocalService(
		it.bysoftware.ct.service.CuraTrasportoLocalService curaTrasportoLocalService) {
		this.curaTrasportoLocalService = curaTrasportoLocalService;
	}

	/**
	 * Returns the cura trasporto remote service.
	 *
	 * @return the cura trasporto remote service
	 */
	public it.bysoftware.ct.service.CuraTrasportoService getCuraTrasportoService() {
		return curaTrasportoService;
	}

	/**
	 * Sets the cura trasporto remote service.
	 *
	 * @param curaTrasportoService the cura trasporto remote service
	 */
	public void setCuraTrasportoService(
		it.bysoftware.ct.service.CuraTrasportoService curaTrasportoService) {
		this.curaTrasportoService = curaTrasportoService;
	}

	/**
	 * Returns the cura trasporto persistence.
	 *
	 * @return the cura trasporto persistence
	 */
	public CuraTrasportoPersistence getCuraTrasportoPersistence() {
		return curaTrasportoPersistence;
	}

	/**
	 * Sets the cura trasporto persistence.
	 *
	 * @param curaTrasportoPersistence the cura trasporto persistence
	 */
	public void setCuraTrasportoPersistence(
		CuraTrasportoPersistence curaTrasportoPersistence) {
		this.curaTrasportoPersistence = curaTrasportoPersistence;
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
	 * Returns the porto local service.
	 *
	 * @return the porto local service
	 */
	public it.bysoftware.ct.service.PortoLocalService getPortoLocalService() {
		return portoLocalService;
	}

	/**
	 * Sets the porto local service.
	 *
	 * @param portoLocalService the porto local service
	 */
	public void setPortoLocalService(
		it.bysoftware.ct.service.PortoLocalService portoLocalService) {
		this.portoLocalService = portoLocalService;
	}

	/**
	 * Returns the porto remote service.
	 *
	 * @return the porto remote service
	 */
	public it.bysoftware.ct.service.PortoService getPortoService() {
		return portoService;
	}

	/**
	 * Sets the porto remote service.
	 *
	 * @param portoService the porto remote service
	 */
	public void setPortoService(
		it.bysoftware.ct.service.PortoService portoService) {
		this.portoService = portoService;
	}

	/**
	 * Returns the porto persistence.
	 *
	 * @return the porto persistence
	 */
	public PortoPersistence getPortoPersistence() {
		return portoPersistence;
	}

	/**
	 * Sets the porto persistence.
	 *
	 * @param portoPersistence the porto persistence
	 */
	public void setPortoPersistence(PortoPersistence portoPersistence) {
		this.portoPersistence = portoPersistence;
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
	 * Returns the vettori local service.
	 *
	 * @return the vettori local service
	 */
	public it.bysoftware.ct.service.VettoriLocalService getVettoriLocalService() {
		return vettoriLocalService;
	}

	/**
	 * Sets the vettori local service.
	 *
	 * @param vettoriLocalService the vettori local service
	 */
	public void setVettoriLocalService(
		it.bysoftware.ct.service.VettoriLocalService vettoriLocalService) {
		this.vettoriLocalService = vettoriLocalService;
	}

	/**
	 * Returns the vettori remote service.
	 *
	 * @return the vettori remote service
	 */
	public it.bysoftware.ct.service.VettoriService getVettoriService() {
		return vettoriService;
	}

	/**
	 * Sets the vettori remote service.
	 *
	 * @param vettoriService the vettori remote service
	 */
	public void setVettoriService(
		it.bysoftware.ct.service.VettoriService vettoriService) {
		this.vettoriService = vettoriService;
	}

	/**
	 * Returns the vettori persistence.
	 *
	 * @return the vettori persistence
	 */
	public VettoriPersistence getVettoriPersistence() {
		return vettoriPersistence;
	}

	/**
	 * Sets the vettori persistence.
	 *
	 * @param vettoriPersistence the vettori persistence
	 */
	public void setVettoriPersistence(VettoriPersistence vettoriPersistence) {
		this.vettoriPersistence = vettoriPersistence;
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

		PersistedModelLocalServiceRegistryUtil.register("it.bysoftware.ct.model.CausaleTrasporto",
			causaleTrasportoLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"it.bysoftware.ct.model.CausaleTrasporto");
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
		return CausaleTrasporto.class;
	}

	protected String getModelClassName() {
		return CausaleTrasporto.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = causaleTrasportoPersistence.getDataSource();

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
	@BeanReference(type = it.bysoftware.ct.service.AspettoEsterioreBeniLocalService.class)
	protected it.bysoftware.ct.service.AspettoEsterioreBeniLocalService aspettoEsterioreBeniLocalService;
	@BeanReference(type = it.bysoftware.ct.service.AspettoEsterioreBeniService.class)
	protected it.bysoftware.ct.service.AspettoEsterioreBeniService aspettoEsterioreBeniService;
	@BeanReference(type = AspettoEsterioreBeniPersistence.class)
	protected AspettoEsterioreBeniPersistence aspettoEsterioreBeniPersistence;
	@BeanReference(type = it.bysoftware.ct.service.CausaleTrasportoLocalService.class)
	protected it.bysoftware.ct.service.CausaleTrasportoLocalService causaleTrasportoLocalService;
	@BeanReference(type = it.bysoftware.ct.service.CausaleTrasportoService.class)
	protected it.bysoftware.ct.service.CausaleTrasportoService causaleTrasportoService;
	@BeanReference(type = CausaleTrasportoPersistence.class)
	protected CausaleTrasportoPersistence causaleTrasportoPersistence;
	@BeanReference(type = it.bysoftware.ct.service.CuraTrasportoLocalService.class)
	protected it.bysoftware.ct.service.CuraTrasportoLocalService curaTrasportoLocalService;
	@BeanReference(type = it.bysoftware.ct.service.CuraTrasportoService.class)
	protected it.bysoftware.ct.service.CuraTrasportoService curaTrasportoService;
	@BeanReference(type = CuraTrasportoPersistence.class)
	protected CuraTrasportoPersistence curaTrasportoPersistence;
	@BeanReference(type = it.bysoftware.ct.service.DestinatariDiversiLocalService.class)
	protected it.bysoftware.ct.service.DestinatariDiversiLocalService destinatariDiversiLocalService;
	@BeanReference(type = it.bysoftware.ct.service.DestinatariDiversiService.class)
	protected it.bysoftware.ct.service.DestinatariDiversiService destinatariDiversiService;
	@BeanReference(type = DestinatariDiversiPersistence.class)
	protected DestinatariDiversiPersistence destinatariDiversiPersistence;
	@BeanReference(type = it.bysoftware.ct.service.PortoLocalService.class)
	protected it.bysoftware.ct.service.PortoLocalService portoLocalService;
	@BeanReference(type = it.bysoftware.ct.service.PortoService.class)
	protected it.bysoftware.ct.service.PortoService portoService;
	@BeanReference(type = PortoPersistence.class)
	protected PortoPersistence portoPersistence;
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
	@BeanReference(type = it.bysoftware.ct.service.VettoriLocalService.class)
	protected it.bysoftware.ct.service.VettoriLocalService vettoriLocalService;
	@BeanReference(type = it.bysoftware.ct.service.VettoriService.class)
	protected it.bysoftware.ct.service.VettoriService vettoriService;
	@BeanReference(type = VettoriPersistence.class)
	protected VettoriPersistence vettoriPersistence;
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
	private CausaleTrasportoLocalServiceClpInvoker _clpInvoker = new CausaleTrasportoLocalServiceClpInvoker();
}
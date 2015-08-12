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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import it.bysoftware.ct.model.RigoDocumento;
import it.bysoftware.ct.service.RigoDocumentoService;
import it.bysoftware.ct.service.persistence.AnagraficaPersistence;
import it.bysoftware.ct.service.persistence.ArticoliPersistence;
import it.bysoftware.ct.service.persistence.AspettoEsterioreBeniPersistence;
import it.bysoftware.ct.service.persistence.AssociatoPersistence;
import it.bysoftware.ct.service.persistence.CausaleTrasportoPersistence;
import it.bysoftware.ct.service.persistence.CuraTrasportoPersistence;
import it.bysoftware.ct.service.persistence.DestinatariDiversiPersistence;
import it.bysoftware.ct.service.persistence.OrganizzazioneProduttoriPersistence;
import it.bysoftware.ct.service.persistence.PortoPersistence;
import it.bysoftware.ct.service.persistence.RigoDocumentoPersistence;
import it.bysoftware.ct.service.persistence.TestataDocumentoPersistence;
import it.bysoftware.ct.service.persistence.VettoriPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the rigo documento remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link it.bysoftware.ct.service.impl.RigoDocumentoServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.impl.RigoDocumentoServiceImpl
 * @see it.bysoftware.ct.service.RigoDocumentoServiceUtil
 * @generated
 */
public abstract class RigoDocumentoServiceBaseImpl extends BaseServiceImpl
	implements RigoDocumentoService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link it.bysoftware.ct.service.RigoDocumentoServiceUtil} to access the rigo documento remote service.
	 */

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
	 * Returns the associato local service.
	 *
	 * @return the associato local service
	 */
	public it.bysoftware.ct.service.AssociatoLocalService getAssociatoLocalService() {
		return associatoLocalService;
	}

	/**
	 * Sets the associato local service.
	 *
	 * @param associatoLocalService the associato local service
	 */
	public void setAssociatoLocalService(
		it.bysoftware.ct.service.AssociatoLocalService associatoLocalService) {
		this.associatoLocalService = associatoLocalService;
	}

	/**
	 * Returns the associato remote service.
	 *
	 * @return the associato remote service
	 */
	public it.bysoftware.ct.service.AssociatoService getAssociatoService() {
		return associatoService;
	}

	/**
	 * Sets the associato remote service.
	 *
	 * @param associatoService the associato remote service
	 */
	public void setAssociatoService(
		it.bysoftware.ct.service.AssociatoService associatoService) {
		this.associatoService = associatoService;
	}

	/**
	 * Returns the associato persistence.
	 *
	 * @return the associato persistence
	 */
	public AssociatoPersistence getAssociatoPersistence() {
		return associatoPersistence;
	}

	/**
	 * Sets the associato persistence.
	 *
	 * @param associatoPersistence the associato persistence
	 */
	public void setAssociatoPersistence(
		AssociatoPersistence associatoPersistence) {
		this.associatoPersistence = associatoPersistence;
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
	 * Returns the organizzazione produttori local service.
	 *
	 * @return the organizzazione produttori local service
	 */
	public it.bysoftware.ct.service.OrganizzazioneProduttoriLocalService getOrganizzazioneProduttoriLocalService() {
		return organizzazioneProduttoriLocalService;
	}

	/**
	 * Sets the organizzazione produttori local service.
	 *
	 * @param organizzazioneProduttoriLocalService the organizzazione produttori local service
	 */
	public void setOrganizzazioneProduttoriLocalService(
		it.bysoftware.ct.service.OrganizzazioneProduttoriLocalService organizzazioneProduttoriLocalService) {
		this.organizzazioneProduttoriLocalService = organizzazioneProduttoriLocalService;
	}

	/**
	 * Returns the organizzazione produttori remote service.
	 *
	 * @return the organizzazione produttori remote service
	 */
	public it.bysoftware.ct.service.OrganizzazioneProduttoriService getOrganizzazioneProduttoriService() {
		return organizzazioneProduttoriService;
	}

	/**
	 * Sets the organizzazione produttori remote service.
	 *
	 * @param organizzazioneProduttoriService the organizzazione produttori remote service
	 */
	public void setOrganizzazioneProduttoriService(
		it.bysoftware.ct.service.OrganizzazioneProduttoriService organizzazioneProduttoriService) {
		this.organizzazioneProduttoriService = organizzazioneProduttoriService;
	}

	/**
	 * Returns the organizzazione produttori persistence.
	 *
	 * @return the organizzazione produttori persistence
	 */
	public OrganizzazioneProduttoriPersistence getOrganizzazioneProduttoriPersistence() {
		return organizzazioneProduttoriPersistence;
	}

	/**
	 * Sets the organizzazione produttori persistence.
	 *
	 * @param organizzazioneProduttoriPersistence the organizzazione produttori persistence
	 */
	public void setOrganizzazioneProduttoriPersistence(
		OrganizzazioneProduttoriPersistence organizzazioneProduttoriPersistence) {
		this.organizzazioneProduttoriPersistence = organizzazioneProduttoriPersistence;
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
	}

	public void destroy() {
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
		return RigoDocumento.class;
	}

	protected String getModelClassName() {
		return RigoDocumento.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = rigoDocumentoPersistence.getDataSource();

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
	@BeanReference(type = it.bysoftware.ct.service.AssociatoLocalService.class)
	protected it.bysoftware.ct.service.AssociatoLocalService associatoLocalService;
	@BeanReference(type = it.bysoftware.ct.service.AssociatoService.class)
	protected it.bysoftware.ct.service.AssociatoService associatoService;
	@BeanReference(type = AssociatoPersistence.class)
	protected AssociatoPersistence associatoPersistence;
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
	@BeanReference(type = it.bysoftware.ct.service.OrganizzazioneProduttoriLocalService.class)
	protected it.bysoftware.ct.service.OrganizzazioneProduttoriLocalService organizzazioneProduttoriLocalService;
	@BeanReference(type = it.bysoftware.ct.service.OrganizzazioneProduttoriService.class)
	protected it.bysoftware.ct.service.OrganizzazioneProduttoriService organizzazioneProduttoriService;
	@BeanReference(type = OrganizzazioneProduttoriPersistence.class)
	protected OrganizzazioneProduttoriPersistence organizzazioneProduttoriPersistence;
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
	private RigoDocumentoServiceClpInvoker _clpInvoker = new RigoDocumentoServiceClpInvoker();
}
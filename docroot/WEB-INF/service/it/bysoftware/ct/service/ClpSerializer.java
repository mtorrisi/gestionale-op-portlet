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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import it.bysoftware.ct.model.AnagraficaAssociatoOPClp;
import it.bysoftware.ct.model.AnagraficaClp;
import it.bysoftware.ct.model.ArticoliAssociatoOPClp;
import it.bysoftware.ct.model.ArticoliClp;
import it.bysoftware.ct.model.AspettoEsterioreBeniClp;
import it.bysoftware.ct.model.AssociatoClp;
import it.bysoftware.ct.model.BancheAppoggioClp;
import it.bysoftware.ct.model.CMRClp;
import it.bysoftware.ct.model.CausaleTrasportoClp;
import it.bysoftware.ct.model.CessioneCreditoClp;
import it.bysoftware.ct.model.ClientiDatiAggClp;
import it.bysoftware.ct.model.CuraTrasportoClp;
import it.bysoftware.ct.model.DescrizioniDocumentiClp;
import it.bysoftware.ct.model.DescrizioniVariantiClp;
import it.bysoftware.ct.model.DestinatariDiversiClp;
import it.bysoftware.ct.model.FileUploaderClp;
import it.bysoftware.ct.model.IvaClp;
import it.bysoftware.ct.model.OrganizzazioneProduttoriClp;
import it.bysoftware.ct.model.PortoClp;
import it.bysoftware.ct.model.ProgressivoClp;
import it.bysoftware.ct.model.RigoDocumentoClp;
import it.bysoftware.ct.model.TestataDocumentoClp;
import it.bysoftware.ct.model.TracciabilitaGrezziClp;
import it.bysoftware.ct.model.TracciabilitaSchedaClp;
import it.bysoftware.ct.model.VettoriClp;
import it.bysoftware.ct.model.WKRigoDocumentoClp;
import it.bysoftware.ct.model.WKTestataDocumentoClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"gestionale-op-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"gestionale-op-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "gestionale-op-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(AnagraficaClp.class.getName())) {
			return translateInputAnagrafica(oldModel);
		}

		if (oldModelClassName.equals(AnagraficaAssociatoOPClp.class.getName())) {
			return translateInputAnagraficaAssociatoOP(oldModel);
		}

		if (oldModelClassName.equals(ArticoliClp.class.getName())) {
			return translateInputArticoli(oldModel);
		}

		if (oldModelClassName.equals(ArticoliAssociatoOPClp.class.getName())) {
			return translateInputArticoliAssociatoOP(oldModel);
		}

		if (oldModelClassName.equals(AspettoEsterioreBeniClp.class.getName())) {
			return translateInputAspettoEsterioreBeni(oldModel);
		}

		if (oldModelClassName.equals(AssociatoClp.class.getName())) {
			return translateInputAssociato(oldModel);
		}

		if (oldModelClassName.equals(BancheAppoggioClp.class.getName())) {
			return translateInputBancheAppoggio(oldModel);
		}

		if (oldModelClassName.equals(CausaleTrasportoClp.class.getName())) {
			return translateInputCausaleTrasporto(oldModel);
		}

		if (oldModelClassName.equals(CessioneCreditoClp.class.getName())) {
			return translateInputCessioneCredito(oldModel);
		}

		if (oldModelClassName.equals(ClientiDatiAggClp.class.getName())) {
			return translateInputClientiDatiAgg(oldModel);
		}

		if (oldModelClassName.equals(CMRClp.class.getName())) {
			return translateInputCMR(oldModel);
		}

		if (oldModelClassName.equals(CuraTrasportoClp.class.getName())) {
			return translateInputCuraTrasporto(oldModel);
		}

		if (oldModelClassName.equals(DescrizioniDocumentiClp.class.getName())) {
			return translateInputDescrizioniDocumenti(oldModel);
		}

		if (oldModelClassName.equals(DescrizioniVariantiClp.class.getName())) {
			return translateInputDescrizioniVarianti(oldModel);
		}

		if (oldModelClassName.equals(DestinatariDiversiClp.class.getName())) {
			return translateInputDestinatariDiversi(oldModel);
		}

		if (oldModelClassName.equals(FileUploaderClp.class.getName())) {
			return translateInputFileUploader(oldModel);
		}

		if (oldModelClassName.equals(IvaClp.class.getName())) {
			return translateInputIva(oldModel);
		}

		if (oldModelClassName.equals(
					OrganizzazioneProduttoriClp.class.getName())) {
			return translateInputOrganizzazioneProduttori(oldModel);
		}

		if (oldModelClassName.equals(PortoClp.class.getName())) {
			return translateInputPorto(oldModel);
		}

		if (oldModelClassName.equals(ProgressivoClp.class.getName())) {
			return translateInputProgressivo(oldModel);
		}

		if (oldModelClassName.equals(RigoDocumentoClp.class.getName())) {
			return translateInputRigoDocumento(oldModel);
		}

		if (oldModelClassName.equals(TestataDocumentoClp.class.getName())) {
			return translateInputTestataDocumento(oldModel);
		}

		if (oldModelClassName.equals(TracciabilitaGrezziClp.class.getName())) {
			return translateInputTracciabilitaGrezzi(oldModel);
		}

		if (oldModelClassName.equals(TracciabilitaSchedaClp.class.getName())) {
			return translateInputTracciabilitaScheda(oldModel);
		}

		if (oldModelClassName.equals(VettoriClp.class.getName())) {
			return translateInputVettori(oldModel);
		}

		if (oldModelClassName.equals(WKRigoDocumentoClp.class.getName())) {
			return translateInputWKRigoDocumento(oldModel);
		}

		if (oldModelClassName.equals(WKTestataDocumentoClp.class.getName())) {
			return translateInputWKTestataDocumento(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputAnagrafica(BaseModel<?> oldModel) {
		AnagraficaClp oldClpModel = (AnagraficaClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAnagraficaRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputAnagraficaAssociatoOP(
		BaseModel<?> oldModel) {
		AnagraficaAssociatoOPClp oldClpModel = (AnagraficaAssociatoOPClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAnagraficaAssociatoOPRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputArticoli(BaseModel<?> oldModel) {
		ArticoliClp oldClpModel = (ArticoliClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getArticoliRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputArticoliAssociatoOP(
		BaseModel<?> oldModel) {
		ArticoliAssociatoOPClp oldClpModel = (ArticoliAssociatoOPClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getArticoliAssociatoOPRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputAspettoEsterioreBeni(
		BaseModel<?> oldModel) {
		AspettoEsterioreBeniClp oldClpModel = (AspettoEsterioreBeniClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAspettoEsterioreBeniRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputAssociato(BaseModel<?> oldModel) {
		AssociatoClp oldClpModel = (AssociatoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAssociatoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBancheAppoggio(BaseModel<?> oldModel) {
		BancheAppoggioClp oldClpModel = (BancheAppoggioClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBancheAppoggioRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCausaleTrasporto(BaseModel<?> oldModel) {
		CausaleTrasportoClp oldClpModel = (CausaleTrasportoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCausaleTrasportoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCessioneCredito(BaseModel<?> oldModel) {
		CessioneCreditoClp oldClpModel = (CessioneCreditoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCessioneCreditoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputClientiDatiAgg(BaseModel<?> oldModel) {
		ClientiDatiAggClp oldClpModel = (ClientiDatiAggClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getClientiDatiAggRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCMR(BaseModel<?> oldModel) {
		CMRClp oldClpModel = (CMRClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCMRRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCuraTrasporto(BaseModel<?> oldModel) {
		CuraTrasportoClp oldClpModel = (CuraTrasportoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCuraTrasportoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDescrizioniDocumenti(
		BaseModel<?> oldModel) {
		DescrizioniDocumentiClp oldClpModel = (DescrizioniDocumentiClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDescrizioniDocumentiRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDescrizioniVarianti(
		BaseModel<?> oldModel) {
		DescrizioniVariantiClp oldClpModel = (DescrizioniVariantiClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDescrizioniVariantiRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDestinatariDiversi(BaseModel<?> oldModel) {
		DestinatariDiversiClp oldClpModel = (DestinatariDiversiClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDestinatariDiversiRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFileUploader(BaseModel<?> oldModel) {
		FileUploaderClp oldClpModel = (FileUploaderClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFileUploaderRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputIva(BaseModel<?> oldModel) {
		IvaClp oldClpModel = (IvaClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getIvaRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputOrganizzazioneProduttori(
		BaseModel<?> oldModel) {
		OrganizzazioneProduttoriClp oldClpModel = (OrganizzazioneProduttoriClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getOrganizzazioneProduttoriRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPorto(BaseModel<?> oldModel) {
		PortoClp oldClpModel = (PortoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPortoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProgressivo(BaseModel<?> oldModel) {
		ProgressivoClp oldClpModel = (ProgressivoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProgressivoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputRigoDocumento(BaseModel<?> oldModel) {
		RigoDocumentoClp oldClpModel = (RigoDocumentoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getRigoDocumentoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputTestataDocumento(BaseModel<?> oldModel) {
		TestataDocumentoClp oldClpModel = (TestataDocumentoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getTestataDocumentoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputTracciabilitaGrezzi(
		BaseModel<?> oldModel) {
		TracciabilitaGrezziClp oldClpModel = (TracciabilitaGrezziClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getTracciabilitaGrezziRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputTracciabilitaScheda(
		BaseModel<?> oldModel) {
		TracciabilitaSchedaClp oldClpModel = (TracciabilitaSchedaClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getTracciabilitaSchedaRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputVettori(BaseModel<?> oldModel) {
		VettoriClp oldClpModel = (VettoriClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getVettoriRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputWKRigoDocumento(BaseModel<?> oldModel) {
		WKRigoDocumentoClp oldClpModel = (WKRigoDocumentoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getWKRigoDocumentoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputWKTestataDocumento(BaseModel<?> oldModel) {
		WKTestataDocumentoClp oldClpModel = (WKTestataDocumentoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getWKTestataDocumentoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"it.bysoftware.ct.model.impl.AnagraficaImpl")) {
			return translateOutputAnagrafica(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"it.bysoftware.ct.model.impl.AnagraficaAssociatoOPImpl")) {
			return translateOutputAnagraficaAssociatoOP(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("it.bysoftware.ct.model.impl.ArticoliImpl")) {
			return translateOutputArticoli(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"it.bysoftware.ct.model.impl.ArticoliAssociatoOPImpl")) {
			return translateOutputArticoliAssociatoOP(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"it.bysoftware.ct.model.impl.AspettoEsterioreBeniImpl")) {
			return translateOutputAspettoEsterioreBeni(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"it.bysoftware.ct.model.impl.AssociatoImpl")) {
			return translateOutputAssociato(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"it.bysoftware.ct.model.impl.BancheAppoggioImpl")) {
			return translateOutputBancheAppoggio(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"it.bysoftware.ct.model.impl.CausaleTrasportoImpl")) {
			return translateOutputCausaleTrasporto(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"it.bysoftware.ct.model.impl.CessioneCreditoImpl")) {
			return translateOutputCessioneCredito(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"it.bysoftware.ct.model.impl.ClientiDatiAggImpl")) {
			return translateOutputClientiDatiAgg(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("it.bysoftware.ct.model.impl.CMRImpl")) {
			return translateOutputCMR(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"it.bysoftware.ct.model.impl.CuraTrasportoImpl")) {
			return translateOutputCuraTrasporto(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"it.bysoftware.ct.model.impl.DescrizioniDocumentiImpl")) {
			return translateOutputDescrizioniDocumenti(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"it.bysoftware.ct.model.impl.DescrizioniVariantiImpl")) {
			return translateOutputDescrizioniVarianti(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"it.bysoftware.ct.model.impl.DestinatariDiversiImpl")) {
			return translateOutputDestinatariDiversi(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"it.bysoftware.ct.model.impl.FileUploaderImpl")) {
			return translateOutputFileUploader(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("it.bysoftware.ct.model.impl.IvaImpl")) {
			return translateOutputIva(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"it.bysoftware.ct.model.impl.OrganizzazioneProduttoriImpl")) {
			return translateOutputOrganizzazioneProduttori(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("it.bysoftware.ct.model.impl.PortoImpl")) {
			return translateOutputPorto(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"it.bysoftware.ct.model.impl.ProgressivoImpl")) {
			return translateOutputProgressivo(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"it.bysoftware.ct.model.impl.RigoDocumentoImpl")) {
			return translateOutputRigoDocumento(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"it.bysoftware.ct.model.impl.TestataDocumentoImpl")) {
			return translateOutputTestataDocumento(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"it.bysoftware.ct.model.impl.TracciabilitaGrezziImpl")) {
			return translateOutputTracciabilitaGrezzi(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"it.bysoftware.ct.model.impl.TracciabilitaSchedaImpl")) {
			return translateOutputTracciabilitaScheda(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("it.bysoftware.ct.model.impl.VettoriImpl")) {
			return translateOutputVettori(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"it.bysoftware.ct.model.impl.WKRigoDocumentoImpl")) {
			return translateOutputWKRigoDocumento(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"it.bysoftware.ct.model.impl.WKTestataDocumentoImpl")) {
			return translateOutputWKTestataDocumento(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("it.bysoftware.ct.NoSuchAnagraficaException")) {
			return new it.bysoftware.ct.NoSuchAnagraficaException();
		}

		if (className.equals(
					"it.bysoftware.ct.NoSuchAnagraficaAssociatoOPException")) {
			return new it.bysoftware.ct.NoSuchAnagraficaAssociatoOPException();
		}

		if (className.equals("it.bysoftware.ct.NoSuchArticoliException")) {
			return new it.bysoftware.ct.NoSuchArticoliException();
		}

		if (className.equals(
					"it.bysoftware.ct.NoSuchArticoliAssociatoOPException")) {
			return new it.bysoftware.ct.NoSuchArticoliAssociatoOPException();
		}

		if (className.equals(
					"it.bysoftware.ct.NoSuchAspettoEsterioreBeniException")) {
			return new it.bysoftware.ct.NoSuchAspettoEsterioreBeniException();
		}

		if (className.equals("it.bysoftware.ct.NoSuchAssociatoException")) {
			return new it.bysoftware.ct.NoSuchAssociatoException();
		}

		if (className.equals("it.bysoftware.ct.NoSuchBancheAppoggioException")) {
			return new it.bysoftware.ct.NoSuchBancheAppoggioException();
		}

		if (className.equals("it.bysoftware.ct.NoSuchCausaleTrasportoException")) {
			return new it.bysoftware.ct.NoSuchCausaleTrasportoException();
		}

		if (className.equals("it.bysoftware.ct.NoSuchCessioneCreditoException")) {
			return new it.bysoftware.ct.NoSuchCessioneCreditoException();
		}

		if (className.equals("it.bysoftware.ct.NoSuchClientiDatiAggException")) {
			return new it.bysoftware.ct.NoSuchClientiDatiAggException();
		}

		if (className.equals("it.bysoftware.ct.NoSuchCMRException")) {
			return new it.bysoftware.ct.NoSuchCMRException();
		}

		if (className.equals("it.bysoftware.ct.NoSuchCuraTrasportoException")) {
			return new it.bysoftware.ct.NoSuchCuraTrasportoException();
		}

		if (className.equals(
					"it.bysoftware.ct.NoSuchDescrizioniDocumentiException")) {
			return new it.bysoftware.ct.NoSuchDescrizioniDocumentiException();
		}

		if (className.equals(
					"it.bysoftware.ct.NoSuchDescrizioniVariantiException")) {
			return new it.bysoftware.ct.NoSuchDescrizioniVariantiException();
		}

		if (className.equals(
					"it.bysoftware.ct.NoSuchDestinatariDiversiException")) {
			return new it.bysoftware.ct.NoSuchDestinatariDiversiException();
		}

		if (className.equals("it.bysoftware.ct.NoSuchFileUploaderException")) {
			return new it.bysoftware.ct.NoSuchFileUploaderException();
		}

		if (className.equals("it.bysoftware.ct.NoSuchIvaException")) {
			return new it.bysoftware.ct.NoSuchIvaException();
		}

		if (className.equals(
					"it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException")) {
			return new it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException();
		}

		if (className.equals("it.bysoftware.ct.NoSuchPortoException")) {
			return new it.bysoftware.ct.NoSuchPortoException();
		}

		if (className.equals("it.bysoftware.ct.NoSuchProgressivoException")) {
			return new it.bysoftware.ct.NoSuchProgressivoException();
		}

		if (className.equals("it.bysoftware.ct.NoSuchRigoDocumentoException")) {
			return new it.bysoftware.ct.NoSuchRigoDocumentoException();
		}

		if (className.equals("it.bysoftware.ct.NoSuchTestataDocumentoException")) {
			return new it.bysoftware.ct.NoSuchTestataDocumentoException();
		}

		if (className.equals(
					"it.bysoftware.ct.NoSuchTracciabilitaGrezziException")) {
			return new it.bysoftware.ct.NoSuchTracciabilitaGrezziException();
		}

		if (className.equals(
					"it.bysoftware.ct.NoSuchTracciabilitaSchedaException")) {
			return new it.bysoftware.ct.NoSuchTracciabilitaSchedaException();
		}

		if (className.equals("it.bysoftware.ct.NoSuchVettoriException")) {
			return new it.bysoftware.ct.NoSuchVettoriException();
		}

		if (className.equals("it.bysoftware.ct.NoSuchWKRigoDocumentoException")) {
			return new it.bysoftware.ct.NoSuchWKRigoDocumentoException();
		}

		if (className.equals(
					"it.bysoftware.ct.NoSuchWKTestataDocumentoException")) {
			return new it.bysoftware.ct.NoSuchWKTestataDocumentoException();
		}

		return throwable;
	}

	public static Object translateOutputAnagrafica(BaseModel<?> oldModel) {
		AnagraficaClp newModel = new AnagraficaClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAnagraficaRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputAnagraficaAssociatoOP(
		BaseModel<?> oldModel) {
		AnagraficaAssociatoOPClp newModel = new AnagraficaAssociatoOPClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAnagraficaAssociatoOPRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputArticoli(BaseModel<?> oldModel) {
		ArticoliClp newModel = new ArticoliClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setArticoliRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputArticoliAssociatoOP(
		BaseModel<?> oldModel) {
		ArticoliAssociatoOPClp newModel = new ArticoliAssociatoOPClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setArticoliAssociatoOPRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputAspettoEsterioreBeni(
		BaseModel<?> oldModel) {
		AspettoEsterioreBeniClp newModel = new AspettoEsterioreBeniClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAspettoEsterioreBeniRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputAssociato(BaseModel<?> oldModel) {
		AssociatoClp newModel = new AssociatoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAssociatoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBancheAppoggio(BaseModel<?> oldModel) {
		BancheAppoggioClp newModel = new BancheAppoggioClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBancheAppoggioRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCausaleTrasporto(BaseModel<?> oldModel) {
		CausaleTrasportoClp newModel = new CausaleTrasportoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCausaleTrasportoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCessioneCredito(BaseModel<?> oldModel) {
		CessioneCreditoClp newModel = new CessioneCreditoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCessioneCreditoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputClientiDatiAgg(BaseModel<?> oldModel) {
		ClientiDatiAggClp newModel = new ClientiDatiAggClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setClientiDatiAggRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCMR(BaseModel<?> oldModel) {
		CMRClp newModel = new CMRClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCMRRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCuraTrasporto(BaseModel<?> oldModel) {
		CuraTrasportoClp newModel = new CuraTrasportoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCuraTrasportoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDescrizioniDocumenti(
		BaseModel<?> oldModel) {
		DescrizioniDocumentiClp newModel = new DescrizioniDocumentiClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDescrizioniDocumentiRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDescrizioniVarianti(
		BaseModel<?> oldModel) {
		DescrizioniVariantiClp newModel = new DescrizioniVariantiClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDescrizioniVariantiRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDestinatariDiversi(
		BaseModel<?> oldModel) {
		DestinatariDiversiClp newModel = new DestinatariDiversiClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDestinatariDiversiRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFileUploader(BaseModel<?> oldModel) {
		FileUploaderClp newModel = new FileUploaderClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFileUploaderRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputIva(BaseModel<?> oldModel) {
		IvaClp newModel = new IvaClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setIvaRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputOrganizzazioneProduttori(
		BaseModel<?> oldModel) {
		OrganizzazioneProduttoriClp newModel = new OrganizzazioneProduttoriClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setOrganizzazioneProduttoriRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPorto(BaseModel<?> oldModel) {
		PortoClp newModel = new PortoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPortoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProgressivo(BaseModel<?> oldModel) {
		ProgressivoClp newModel = new ProgressivoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProgressivoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputRigoDocumento(BaseModel<?> oldModel) {
		RigoDocumentoClp newModel = new RigoDocumentoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setRigoDocumentoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputTestataDocumento(BaseModel<?> oldModel) {
		TestataDocumentoClp newModel = new TestataDocumentoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setTestataDocumentoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputTracciabilitaGrezzi(
		BaseModel<?> oldModel) {
		TracciabilitaGrezziClp newModel = new TracciabilitaGrezziClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setTracciabilitaGrezziRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputTracciabilitaScheda(
		BaseModel<?> oldModel) {
		TracciabilitaSchedaClp newModel = new TracciabilitaSchedaClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setTracciabilitaSchedaRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputVettori(BaseModel<?> oldModel) {
		VettoriClp newModel = new VettoriClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setVettoriRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputWKRigoDocumento(BaseModel<?> oldModel) {
		WKRigoDocumentoClp newModel = new WKRigoDocumentoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setWKRigoDocumentoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputWKTestataDocumento(
		BaseModel<?> oldModel) {
		WKTestataDocumentoClp newModel = new WKTestataDocumentoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setWKTestataDocumentoRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}
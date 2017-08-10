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
package it.bysoftware.ct.service.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

import it.bysoftware.ct.model.Articoli;
import it.bysoftware.ct.service.ArticoliLocalServiceUtil;
import it.bysoftware.ct.service.base.ArticoliLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * The implementation of the articoli local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link it.bysoftware.ct.service.ArticoliLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.base.ArticoliLocalServiceBaseImpl
 * @see it.bysoftware.ct.service.ArticoliLocalServiceUtil
 */
public class ArticoliLocalServiceImpl extends ArticoliLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * it.bysoftware.ct.service.ArticoliLocalServiceUtil} to access the articoli
	 * local service.
	 */

	public int countArticoli() throws SystemException {
		List<Articoli> list = this.articoliPersistence.findAll();
		return checkArticoli(list).size();
	}

	@Override
	public int countImballaggi() throws SystemException {
		return this.articoliPersistence.countBycategoriaMerceologica("IMB");
	}

	@Override
	public List<Articoli> getArticoli() throws SystemException {
		List<Articoli> list = this.articoliPersistence.findAll();
		return checkArticoli(list);
	}

	@Override
	public List<Articoli> getImballaggi() throws SystemException {
		return this.articoliPersistence.findBycategoriaMerceologica("IMB");
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Articoli> searchArticoli(String codiceArticolo,
			String descrizione, boolean andSearch, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		DynamicQuery dynamicQuery = this.buildArticoliDynamicQuery(
				codiceArticolo, descrizione, andSearch, false);
		try {
			return ArticoliLocalServiceUtil.dynamicQuery(dynamicQuery, start,
					end, orderByComparator);
		} catch (SystemException ex) {
			this.logger.error(ex.getMessage());
			return new ArrayList<Articoli>();
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Articoli> searchImballaggi(String codiceImballaggio,
			boolean andSearch, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		DynamicQuery dynamicQuery = this.buildArticoliDynamicQuery(
				codiceImballaggio, "", andSearch, true);
		try {
			return ArticoliLocalServiceUtil.dynamicQuery(dynamicQuery, start,
					end, orderByComparator);
		} catch (SystemException ex) {
			this.logger.error(ex.getMessage());
			return new ArrayList<Articoli>();
		}
	}

	protected DynamicQuery buildArticoliDynamicQuery(String codiceArticolo,
			String descrizione, boolean andSearch, boolean imballaggio) {
		Junction junction = null;

		if (andSearch) {
			junction = RestrictionsFactoryUtil.conjunction();
		} else {
			junction = RestrictionsFactoryUtil.disjunction();
		}

		if (imballaggio) {
			Property property = PropertyFactoryUtil
					.forName("categoriaMerceologica");
			String value = "IMB";
			junction.add(property.eq(value));
		} else {
			Property property = PropertyFactoryUtil
					.forName("categoriaMerceologica");

			// String value = "AGR"; junction.add(property.eq(value));

			junction.add(property.ne(""));
			junction.add(property.ne("GRE"));
			junction.add(property.ne("IMB"));
			junction.add(property.ne("PDG"));
			junction.add(property.ne("IMG"));
			junction.add(property.ne("IBG"));
		}

		if (Validator.isNotNull(codiceArticolo)) {
			Property property = PropertyFactoryUtil.forName("codiceArticolo");
			String value = (new StringBuilder("%")).append(codiceArticolo)
					.append("%").toString();
			junction.add(property.like(value));
		}

		if (Validator.isNotNull(descrizione)) {
			Property property = PropertyFactoryUtil.forName("descrizione");
			String value = (new StringBuilder("%")).append(descrizione)
					.append("%").toString();
			junction.add(property.like(value));
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
				Articoli.class, getClassLoader());
		return dynamicQuery.add(junction);
	}

	private List<Articoli> checkArticoli(List<Articoli> list) {
		List<Articoli> listArticoli = new ArrayList<Articoli>();

		for (Articoli articolo : list) {
			String categoria = articolo.getCategoriaMerceologica();

			if (!categoria.isEmpty() && !categoria.equals("GRE") &&
				!categoria.equals("PDG") && !categoria.equals("IMG") &&
				!categoria.equals("IMB")) {
				listArticoli.add(articolo);
			}
		}

		return listArticoli;
	}

	/**
	 * Logger object. Based on Liferay logger
	 * {@link com.liferay.portal.kernel.log.Log} commons logging.
	 */
	private Log logger = LogFactoryUtil.getLog(ArticoliLocalServiceImpl.class);

}
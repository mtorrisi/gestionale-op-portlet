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
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import it.bysoftware.ct.model.Articoli;
import it.bysoftware.ct.service.ArticoliLocalServiceUtil;
import it.bysoftware.ct.service.base.ArticoliLocalServiceBaseImpl;
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
     * Never reference this interface directly. Always use {@link it.bysoftware.ct.service.ArticoliLocalServiceUtil} to access the articoli local service.
     */

    public List<Articoli> getImballaggi() throws SystemException {
        return this.articoliPersistence.findBycategoriaMerceologica("IMB");
    }

    public int countImballaggi() throws SystemException {
        return this.articoliPersistence.countBycategoriaMerceologica("IMB");
    }

    public List<Articoli> getArticoli() throws SystemException {
        return this.articoliPersistence.findBycategoriaArticoli("IMB");
    }

    public int countArticoli() throws SystemException {
        return this.articoliPersistence.countBycategoriaArticoli("IMB");
    }

    public List searchArticoli(String codiceArticolo, boolean andSearch, int start, int end, OrderByComparator orderByComparator)
            throws SystemException {
        DynamicQuery dynamicQuery = buildArticoliDynamicQuery(codiceArticolo, andSearch);
        return ArticoliLocalServiceUtil.dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    protected DynamicQuery buildArticoliDynamicQuery(String codiceArticolo, boolean andSearch) {
        Junction junction = null;
        if (andSearch) {
            junction = RestrictionsFactoryUtil.conjunction();
        } else {
            junction = RestrictionsFactoryUtil.disjunction();
        }

        if (Validator.isNotNull(codiceArticolo)) {
            Property property = PropertyFactoryUtil.forName("codiceArticolo");
            String value = (new StringBuilder("%")).append(codiceArticolo).append("%").toString();
            junction.add(property.like(value));
        }
//        if (Validator.isNotNull(lastName)) {
//            Property property = PropertyFactoryUtil.forName("lastName");
//            String value = (new StringBuilder("%")).append(lastName).append("%").toString();
//            junction.add(property.like(value));
//        }
//        if (studentAge > 0) {
//            Property property = PropertyFactoryUtil.forName("studentAge");
//            junction.add(property.eq(Integer.valueOf(studentAge)));
//        }
//        if (studentGender > 0) {
//            Property property = PropertyFactoryUtil.forName("studentGender");
//            junction.add(property.eq(Integer.valueOf(studentGender)));
//        }
//        if (Validator.isNotNull(studentAddress)) {
//            Property property = PropertyFactoryUtil.forName("studentAddress");
//            String value = (new StringBuilder("%")).append(studentAddress).append("%").toString();
//            junction.add(property.like(value));
//        }
        DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Articoli.class, getClassLoader());
        return dynamicQuery.add(junction);
    }
}

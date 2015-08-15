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

import com.liferay.portal.kernel.exception.SystemException;
import it.bysoftware.ct.model.Associato;
import it.bysoftware.ct.service.base.AssociatoLocalServiceBaseImpl;
import java.util.List;

/**
 * The implementation of the associato local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.bysoftware.ct.service.AssociatoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.base.AssociatoLocalServiceBaseImpl
 * @see it.bysoftware.ct.service.AssociatoLocalServiceUtil
 */
public class AssociatoLocalServiceImpl extends AssociatoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.bysoftware.ct.service.AssociatoLocalServiceUtil} to access the associato local service.
	 */
    
    public List<Associato> getAssociatiAttivi() throws SystemException{
        return this.associatoPersistence.findByAssociatiAttivi(true);
    }
    
    public List<Associato> getAssociatiDisattivati() throws SystemException{
        return this.associatoPersistence.findByAssociatiAttivi(false);
    }
    
    public int countAssociatiAttivi() throws SystemException{
        return this.associatoPersistence.findByAssociatiAttivi(true).size();
    }
    
    public int countAssociatiDisattivati() throws SystemException{
        return this.associatoPersistence.findByAssociatiAttivi(false).size();
    }
}
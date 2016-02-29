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
import it.bysoftware.ct.NoSuchTracciabilitaSchedaException;
import it.bysoftware.ct.model.TracciabilitaScheda;
import it.bysoftware.ct.service.base.TracciabilitaSchedaLocalServiceBaseImpl;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The implementation of the tracciabilita scheda local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link it.bysoftware.ct.service.TracciabilitaSchedaLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.base.TracciabilitaSchedaLocalServiceBaseImpl
 * @see it.bysoftware.ct.service.TracciabilitaSchedaLocalServiceUtil
 */
public class TracciabilitaSchedaLocalServiceImpl
        extends TracciabilitaSchedaLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link it.bysoftware.ct.service.TracciabilitaSchedaLocalServiceUtil} to access the tracciabilita scheda local service.
     */

    @Override
    public List<TracciabilitaScheda> getByAnnoIdAssociato(int anno, long numeroDocumento, long idAssociato) throws SystemException {
        return this.tracciabilitaSchedaPersistence.findByAnnoIdAssociatoNDocumento(anno, idAssociato, numeroDocumento,"DDT");
    }
    
    @Override
    public TracciabilitaScheda getByAnnoIdAssociatoCodiceProdotto(int anno, long numeroDocumento, long idAssociato, String codiceProdotto) throws SystemException {
        try {
            return this.tracciabilitaSchedaPersistence.findByAnnoIdAssociatoNDocumentoCodiceProdotto(anno, idAssociato, numeroDocumento,"DDT", codiceProdotto);
        } catch (NoSuchTracciabilitaSchedaException ex) {
            return null;
        }
    }
}

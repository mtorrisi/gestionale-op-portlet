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

import it.bysoftware.ct.NoSuchCMRException;
import it.bysoftware.ct.model.CMR;
import it.bysoftware.ct.service.base.CMRLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the c m r local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link it.bysoftware.ct.service.CMRLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.base.CMRLocalServiceBaseImpl
 * @see it.bysoftware.ct.service.CMRLocalServiceUtil
 */
public class CMRLocalServiceImpl extends CMRLocalServiceBaseImpl {
	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * it.bysoftware.ct.service.CMRLocalServiceUtil} to access the c m r local
	 * service.
	 */

	@Override
	public List<CMR> getCMRByAnnoAssociato(int anno, long idAssociato) throws SystemException {
		return this.cmrPersistence.findByannoAssociato(anno, idAssociato);
	}

	@Override
	public CMR getCMRByAnnoAssociatoDDT(int anno, long idAssociato, long numeroDocumento) {
		try {
			return this.cmrPersistence.findByannoAssociatoDDT(anno, idAssociato, numeroDocumento);
		} catch (NoSuchCMRException | SystemException e) {
			return null;
		}
	}
}
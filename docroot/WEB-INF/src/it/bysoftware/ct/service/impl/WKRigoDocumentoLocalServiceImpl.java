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

import it.bysoftware.ct.model.WKRigoDocumento;
import it.bysoftware.ct.service.base.WKRigoDocumentoLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the w k rigo documento local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.bysoftware.ct.service.WKRigoDocumentoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.base.WKRigoDocumentoLocalServiceBaseImpl
 * @see it.bysoftware.ct.service.WKRigoDocumentoLocalServiceUtil
 */
public class WKRigoDocumentoLocalServiceImpl
	extends WKRigoDocumentoLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.bysoftware.ct.service.WKRigoDocumentoLocalServiceUtil} to access the w k rigo documento local service.
	 */

	@Override
	public List<WKRigoDocumento> getByNumeroOrdineAnnoAssociatoTipoDocumento(long numeroOrdine, int anno, long idAssociato, String tipoDocumento) throws SystemException {
		return this.wkRigoDocumentoPersistence.findBynumeroOrdineAnnoAssociato(numeroOrdine, anno, idAssociato, tipoDocumento);
	}

	@Override
	public List<WKRigoDocumento> getByAnnoAssociato(int anno, long idAssociato) throws SystemException {
		return this.wkRigoDocumentoPersistence.findByAnnoAssociato(anno, idAssociato);
	}
}
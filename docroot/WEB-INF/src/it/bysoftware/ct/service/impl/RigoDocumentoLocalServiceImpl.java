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

import it.bysoftware.ct.model.RigoDocumento;
import it.bysoftware.ct.service.RigoDocumentoLocalServiceUtil;
import it.bysoftware.ct.service.base.RigoDocumentoLocalServiceBaseImpl;
import it.its.ct.gestionaleOP.utils.DocumentType;

import java.util.List;

/**
 * The implementation of the rigo documento local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.bysoftware.ct.service.RigoDocumentoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.base.RigoDocumentoLocalServiceBaseImpl
 * @see it.bysoftware.ct.service.RigoDocumentoLocalServiceUtil
 */
public class RigoDocumentoLocalServiceImpl
	extends RigoDocumentoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.bysoftware.ct.service.RigoDocumentoLocalServiceUtil} to access the rigo documento local service.
	 */
    
	@Override
    public List<RigoDocumento> getDDAByNumeroOrdineAnnoAssociato(long numeroOrdine, int anno, long idAssociato) throws SystemException {
        return this.rigoDocumentoPersistence.findBynumeroOrdineAnnoAssociato(numeroOrdine, anno, idAssociato, DocumentType.DDA.name());
    }
	
    @Override
    public List<RigoDocumento> getDDTByNumeroOrdineAnnoAssociato(long numeroOrdine, int anno, long idAssociato) throws SystemException {
        return this.rigoDocumentoPersistence.findBynumeroOrdineAnnoAssociato(numeroOrdine, anno, idAssociato, DocumentType.DDT.name());
    }
    
    @Override
    public List<RigoDocumento> getFatturaByNumeroOrdineAnnoAssociato(long numeroOrdine, int anno, long idAssociato, String tipoDocumento) throws SystemException {
        return this.rigoDocumentoPersistence.findBynumeroOrdineAnnoAssociato(numeroOrdine, anno, idAssociato, tipoDocumento);
    }
    
    @Override
    public List<RigoDocumento> getNACByNumeroOrdineAnnoAssociato(long numeroOrdine, int anno, long idAssociato, String tipoDocumento) throws SystemException {
        return this.rigoDocumentoPersistence.findBynumeroOrdineAnnoAssociato(numeroOrdine, anno, idAssociato, tipoDocumento);
    }
        
    @Override
    public List<RigoDocumento> deleteRigoByNumeroOrdineAnnoAssociato(long numeroOrdine, int anno, long idAssociato, String tipoDocumento) throws SystemException {
    	List<RigoDocumento> list = getFatturaByNumeroOrdineAnnoAssociato(numeroOrdine, anno, idAssociato, tipoDocumento);
    	for (RigoDocumento rigoDocumento : list) {
			RigoDocumentoLocalServiceUtil.deleteRigoDocumento(rigoDocumento);
		}
    	return list;
    }

	@Override
	public List<RigoDocumento> getDocumentoByOrdineAnnoAssociato(long numeroOrdine,
			int anno, String tipoDocumento, String codiceArticolo,
			String codiceVariante, String imballo, long idAssociato)
			throws SystemException {
		return this.rigoDocumentoPersistence.findBynumeroOrdineAnnoAssociatoArticolo(numeroOrdine, anno, tipoDocumento, codiceArticolo, codiceVariante, imballo, idAssociato);
	}
}
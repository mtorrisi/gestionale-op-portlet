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

import it.bysoftware.ct.model.TestataDocumento;
import it.bysoftware.ct.service.base.TestataDocumentoLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the testata documento local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link it.bysoftware.ct.service.TestataDocumentoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.base.TestataDocumentoLocalServiceBaseImpl
 * @see it.bysoftware.ct.service.TestataDocumentoLocalServiceUtil
 */
public class TestataDocumentoLocalServiceImpl
		extends TestataDocumentoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.bysoftware.ct.service.TestataDocumentoLocalServiceUtil} to access the testata documento local service.
	 */

	@Override
	public int countDocumnetByCodiceOperatore(String codiceOperatore, String completo, int inviato) throws SystemException {
		return this.testataDocumentoPersistence.countByoperatoreCompletoInviato(codiceOperatore, completo, inviato, "DDT");
	}

	@Override
	public List<TestataDocumento> getByCodiceOperatore(String codiceOperatore) throws SystemException {
		return this.testataDocumentoPersistence.findByoperatore(codiceOperatore);
	}

	@Override
	public List<TestataDocumento> getByCodiceOperatore(String codiceOperatore, String completo, int inviato) throws SystemException {
		return this.testataDocumentoPersistence.findByoperatoreCompletoInviato(codiceOperatore, completo, inviato, "DDT");
	}

	@Override
	public List<TestataDocumento> getByCodiceSoggettoCodiceOperatore(String codiceSoggetto, String codiceOperatore) throws SystemException {
		return this.testataDocumentoPersistence.findByCodiceSoggettoCodiceOperatore(codiceSoggetto, codiceOperatore);
	}

	@Override
	public List<TestataDocumento> getDocumentiCollegati(int anno, String tipoDocumento, long idAssociato, String nota2) throws SystemException {
		return this.testataDocumentoPersistence.findByannoTipoDocumentoIdAssociatoRiferimento(anno, tipoDocumento, idAssociato, nota2);
	}

	@Override
	public List<TestataDocumento> getDocumentiSoggetto(int anno, String idDocumento, long idAssociato) throws SystemException {
		return this.testataDocumentoPersistence.findByannoTipoDocumentoIdAssociato(anno, idDocumento, idAssociato);
	}

}
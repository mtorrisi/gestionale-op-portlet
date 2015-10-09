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

package it.bysoftware.ct.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import it.bysoftware.ct.service.AnagraficaLocalServiceUtil;
import it.bysoftware.ct.service.AnagraficaServiceUtil;
import it.bysoftware.ct.service.ArticoliLocalServiceUtil;
import it.bysoftware.ct.service.ArticoliServiceUtil;
import it.bysoftware.ct.service.AspettoEsterioreBeniLocalServiceUtil;
import it.bysoftware.ct.service.AspettoEsterioreBeniServiceUtil;
import it.bysoftware.ct.service.AssociatoLocalServiceUtil;
import it.bysoftware.ct.service.AssociatoServiceUtil;
import it.bysoftware.ct.service.CausaleTrasportoLocalServiceUtil;
import it.bysoftware.ct.service.CausaleTrasportoServiceUtil;
import it.bysoftware.ct.service.ClientiDatiAggLocalServiceUtil;
import it.bysoftware.ct.service.ClientiDatiAggServiceUtil;
import it.bysoftware.ct.service.ClpSerializer;
import it.bysoftware.ct.service.CuraTrasportoLocalServiceUtil;
import it.bysoftware.ct.service.CuraTrasportoServiceUtil;
import it.bysoftware.ct.service.DescrizioniDocumentiLocalServiceUtil;
import it.bysoftware.ct.service.DescrizioniDocumentiServiceUtil;
import it.bysoftware.ct.service.DescrizioniVariantiLocalServiceUtil;
import it.bysoftware.ct.service.DescrizioniVariantiServiceUtil;
import it.bysoftware.ct.service.DestinatariDiversiLocalServiceUtil;
import it.bysoftware.ct.service.DestinatariDiversiServiceUtil;
import it.bysoftware.ct.service.OrganizzazioneProduttoriLocalServiceUtil;
import it.bysoftware.ct.service.OrganizzazioneProduttoriServiceUtil;
import it.bysoftware.ct.service.PortoLocalServiceUtil;
import it.bysoftware.ct.service.PortoServiceUtil;
import it.bysoftware.ct.service.ProgressivoLocalServiceUtil;
import it.bysoftware.ct.service.ProgressivoServiceUtil;
import it.bysoftware.ct.service.RigoDocumentoLocalServiceUtil;
import it.bysoftware.ct.service.RigoDocumentoServiceUtil;
import it.bysoftware.ct.service.TestataDocumentoLocalServiceUtil;
import it.bysoftware.ct.service.TestataDocumentoServiceUtil;
import it.bysoftware.ct.service.VettoriLocalServiceUtil;
import it.bysoftware.ct.service.VettoriServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			AnagraficaLocalServiceUtil.clearService();

			AnagraficaServiceUtil.clearService();
			ArticoliLocalServiceUtil.clearService();

			ArticoliServiceUtil.clearService();
			AspettoEsterioreBeniLocalServiceUtil.clearService();

			AspettoEsterioreBeniServiceUtil.clearService();
			AssociatoLocalServiceUtil.clearService();

			AssociatoServiceUtil.clearService();
			CausaleTrasportoLocalServiceUtil.clearService();

			CausaleTrasportoServiceUtil.clearService();
			ClientiDatiAggLocalServiceUtil.clearService();

			ClientiDatiAggServiceUtil.clearService();
			CuraTrasportoLocalServiceUtil.clearService();

			CuraTrasportoServiceUtil.clearService();
			DescrizioniDocumentiLocalServiceUtil.clearService();

			DescrizioniDocumentiServiceUtil.clearService();
			DescrizioniVariantiLocalServiceUtil.clearService();

			DescrizioniVariantiServiceUtil.clearService();
			DestinatariDiversiLocalServiceUtil.clearService();

			DestinatariDiversiServiceUtil.clearService();
			OrganizzazioneProduttoriLocalServiceUtil.clearService();

			OrganizzazioneProduttoriServiceUtil.clearService();
			PortoLocalServiceUtil.clearService();

			PortoServiceUtil.clearService();
			ProgressivoLocalServiceUtil.clearService();

			ProgressivoServiceUtil.clearService();
			RigoDocumentoLocalServiceUtil.clearService();

			RigoDocumentoServiceUtil.clearService();
			TestataDocumentoLocalServiceUtil.clearService();

			TestataDocumentoServiceUtil.clearService();
			VettoriLocalServiceUtil.clearService();

			VettoriServiceUtil.clearService();
		}
	}
}
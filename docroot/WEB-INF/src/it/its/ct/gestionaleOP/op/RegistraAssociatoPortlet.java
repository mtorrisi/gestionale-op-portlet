/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.its.ct.gestionaleOP.op;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sun.nio.sctp.Association;
import it.bysoftware.ct.model.Associato;
import it.bysoftware.ct.service.AssociatoLocalServiceUtil;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 *
 * @author mario
 */
public class RegistraAssociatoPortlet extends MVCPortlet {

    private final Log _log = LogFactoryUtil.getLog(RegistraAssociatoPortlet.class);

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

        _log.info("doView()");
        super.doView(renderRequest, renderResponse); //To change body of generated methods, choose Tools | Templates.
        try {
            List<Associato> list = AssociatoLocalServiceUtil.getAssociatos(0, AssociatoLocalServiceUtil.getAssociatosCount());
            for (Associato list1 : list) {
                _log.info("ASSOCIATO: " + list1.getEmail());
            }
        } catch (SystemException ex) {
            Logger.getLogger(RegistraAssociatoPortlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}

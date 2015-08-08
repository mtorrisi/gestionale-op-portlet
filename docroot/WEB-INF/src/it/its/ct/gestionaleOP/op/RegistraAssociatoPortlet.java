/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.its.ct.gestionaleOP.op;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import it.bysoftware.ct.model.Associato;
import it.bysoftware.ct.service.AssociatoLocalServiceUtil;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
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
            _log.warn(ex.getLocalizedMessage());
        }

    }

    public void deleteAssociato(ActionRequest areq, ActionResponse ares) {

        try {
            AssociatoLocalServiceUtil.deleteAssociato(ParamUtil.getLong(areq, "id"));
        } catch (PortalException ex) {
            _log.error(ex.getLocalizedMessage());
        } catch (SystemException ex) {
            _log.error(ex.getLocalizedMessage());
        }
    }

    public void editAssociato(ActionRequest areq, ActionResponse ares) {


        _log.info(ParamUtil.getLong(areq, "id"));
                _log.info(areq.getParameter("id"));

        
        try {
            Associato a = null;
            if (ParamUtil.getLong(areq, "id") != 0) {
                a = AssociatoLocalServiceUtil.getAssociato(ParamUtil.getLong(areq, "id"));
            } else {
                a = AssociatoLocalServiceUtil.createAssociato(0);
            }
            
            _log.info(ParamUtil.getString(areq, "ragioneSociale"));
            _log.info(ParamUtil.getString(areq, "centro"));
            _log.info(ParamUtil.getString(areq, "pIVA"));
            _log.info(ParamUtil.getString(areq, "indirizzo"));
            _log.info(ParamUtil.getString(areq, "telefono"));
            _log.info(ParamUtil.getString(areq, "fax"));
            _log.info(ParamUtil.getString(areq, "email"));
            _log.info(ParamUtil.getString(areq, "password"));
//            a.setRagioneSociale(ParamUtil.getString(areq, "ragioneSociale"));
//            a.setCentro(ParamUtil.getString(areq, "centro"));
//            a.setIndirizzo(ParamUtil.getString(areq, "indirizzo"));
//            a.setTelefono(ParamUtil.getString(areq, "telefono"));
//            a.setFax(ParamUtil.getString(areq, "fax"));
//            a.setEmail(ParamUtil.getString(areq, "email"));
            
//            AssociatoLocalServiceUtil.updateAssociato(a);
        } catch (SystemException ex) {
            _log.error(ex.getLocalizedMessage());
        } catch (PortalException ex) {
            _log.error(ex.getLocalizedMessage());
        }
    }

}

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
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.service.UserGroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import it.bysoftware.ct.model.Associato;
import it.bysoftware.ct.model.OrganizzazioneProduttori;
import it.bysoftware.ct.service.AssociatoLocalServiceUtil;
import it.bysoftware.ct.service.OrganizzazioneProduttoriLocalServiceUtil;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
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

    public void toggleAssociato(ActionRequest areq, ActionResponse ares) {

        try {
            Associato associato = AssociatoLocalServiceUtil.getAssociato(ParamUtil.getLong(areq, "id"));
            associato.setAttivo(!associato.getAttivo());
            AssociatoLocalServiceUtil.updateAssociato(associato);
        } catch (PortalException ex) {
            _log.error(ex.getLocalizedMessage());
        } catch (SystemException ex) {
            _log.error(ex.getLocalizedMessage());
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

        try {
            Associato a = AssociatoLocalServiceUtil.createAssociato(0);

            a.setRagioneSociale(ParamUtil.getString(areq, "ragioneSociale"));
            a.setPartitaIVA(ParamUtil.getString(areq, "pIVA"));
            a.setCentro(ParamUtil.getString(areq, "centro"));
            a.setIndirizzo(ParamUtil.getString(areq, "indirizzo"));
            a.setTelefono(ParamUtil.getString(areq, "telefono"));
            a.setFax(ParamUtil.getString(areq, "fax"));
            a.setEmail(ParamUtil.getString(areq, "email"));
            String plainPwd = ParamUtil.getString(areq, "password");
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainPwd.getBytes());
            byte byteData[] = md.digest();

            //convert the byte to hex format method 1
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            a.setPassword(sb.toString());

            User creator = PortalUtil.getUser(areq);
            Role role = RoleServiceUtil.getRole(creator.getCompanyId(), "associato");
            OrganizzazioneProduttori op = OrganizzazioneProduttoriLocalServiceUtil.getOP(creator.getUserId());
            User liferayUser = addLiferayUser(a.getRagioneSociale(), "", a.getEmail(), plainPwd, a.getEmail().substring(0, a.getEmail().indexOf("@")), creator, role.getRoleId());
            _log.info("Inserted Liferay user: " + liferayUser);

            a.setIdOp(op.getId());
            a.setIdLiferay(liferayUser.getUserId());
            a.setAttivo(true);
            _log.info("Inserting or updating: " + a);
            AssociatoLocalServiceUtil.updateAssociato(a);
            
        } catch (SystemException ex) {
            _log.error(ex.getLocalizedMessage());
            SessionErrors.add(areq, "no-registration");
        } catch (NoSuchAlgorithmException ex) {
            _log.error(ex.getLocalizedMessage());
            SessionErrors.add(areq, "no-registration");
        } catch (PortalException ex) {
            _log.error(ex.getLocalizedMessage());
            SessionErrors.add(areq, "no-registration");
        } 
    }

    private User addLiferayUser(String firstName, String lastName, String email, String password, String screenName, User creator, long roleId) throws PortalException, SystemException {

        long[] emptyLong = {};
        long[] rolesId = {roleId};
        User user = UserLocalServiceUtil.addUser(creator.getUserId(), creator.getCompanyId(),
                false, password, password, false, screenName, email, 0, "",
                Locale.ITALIAN, firstName, firstName, "", 0, 0, true, 1, 1, 1970,
                email, emptyLong, emptyLong, rolesId, emptyLong, false, null);

        return user;

    }
}

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
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import it.bysoftware.ct.model.Associato;
import it.bysoftware.ct.model.OrganizzazioneProduttori;
import it.bysoftware.ct.service.AssociatoLocalServiceUtil;
import it.bysoftware.ct.service.OrganizzazioneProduttoriLocalServiceUtil;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
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
//        try {
//            List<Associato> list = AssociatoLocalServiceUtil.getAssociatos(0, AssociatoLocalServiceUtil.getAssociatosCount());
//            for (Associato list1 : list) {
//                _log.info("ASSOCIATO: " + list1.getEmail());
//            }
//        } catch (SystemException ex) {
//            _log.warn(ex.getMessage());
//        }

    }

    public void toggleAssociato(ActionRequest areq, ActionResponse ares) {

        try {
            Associato associato = AssociatoLocalServiceUtil.getAssociato(ParamUtil.getLong(areq, "id"));
            associato.setAttivo(!associato.getAttivo());
            AssociatoLocalServiceUtil.updateAssociato(associato);
            if (associato.getAttivo()) {
                UserLocalServiceUtil.updateStatus(associato.getIdLiferay(), WorkflowConstants.STATUS_APPROVED, new ServiceContext());
            } else {
                UserLocalServiceUtil.updateStatus(associato.getIdLiferay(), WorkflowConstants.STATUS_INACTIVE, new ServiceContext());
            }
        } catch (PortalException ex) {
            _log.error(ex.getMessage());
        } catch (SystemException ex) {
            _log.error(ex.getMessage());
        }
    }

    public void deleteAssociato(ActionRequest areq, ActionResponse ares) {

        try {
            Associato a = AssociatoLocalServiceUtil.getAssociato(ParamUtil.getLong(areq, "id"));
            UserLocalServiceUtil.deleteUser(a.getIdLiferay());
            AssociatoLocalServiceUtil.deleteAssociato(a);
        } catch (PortalException ex) {
            _log.error(ex.getMessage());
        } catch (SystemException ex) {
            _log.error(ex.getMessage());
        }
    }

    public void addAssociato(ActionRequest areq, ActionResponse ares) {

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

            ThemeDisplay themeDisplay = (ThemeDisplay) areq.getAttribute(WebKeys.THEME_DISPLAY);
            DLFolder opFolder = getOpFolder(creator, themeDisplay);
            DLFolder folder = createAssociateFolder(liferayUser, opFolder, themeDisplay);
            _log.info("Created folder: " + folder);

        } catch (SystemException ex) {
            _log.error(ex.getMessage());
            SessionErrors.add(areq, "no-registration");
        } catch (NoSuchAlgorithmException ex) {
            _log.error(ex.getMessage());
            SessionErrors.add(areq, "no-registration");
        } catch (PortalException ex) {
            _log.error(ex.getMessage());
            SessionErrors.add(areq, "no-registration");
        }
    }

    public void editAssociato(ActionRequest areq, ActionResponse ares) {

        try {
            Associato a = AssociatoLocalServiceUtil.getAssociato(ParamUtil.getLong(areq, "id"));

            a.setRagioneSociale(ParamUtil.getString(areq, "ragioneSociale"));
            a.setPartitaIVA(ParamUtil.getString(areq, "pIVA"));
            a.setCentro(ParamUtil.getString(areq, "centro"));
            a.setIndirizzo(ParamUtil.getString(areq, "indirizzo"));
            a.setTelefono(ParamUtil.getString(areq, "telefono"));
            a.setFax(ParamUtil.getString(areq, "fax"));
            String newEmail = ParamUtil.getString(areq, "email");
            if (newEmail != null && !newEmail.equals("") && !newEmail.equals(a.getEmail())) {
                a.setEmail(ParamUtil.getString(areq, "email"));

                User liferayUser = UserLocalServiceUtil.getUser(a.getIdLiferay());
                liferayUser.setEmailAddress(newEmail);

                UserLocalServiceUtil.updateUser(liferayUser);
            }

            AssociatoLocalServiceUtil.updateAssociato(a);
        } catch (PortalException ex) {
            _log.error(ex.getMessage());
            SessionErrors.add(areq, "edit-error");
        } catch (SystemException ex) {
            _log.error(ex.getMessage());
            SessionErrors.add(areq, "edit-error");
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

    private DLFolder getOpFolder(User op, ThemeDisplay themeDisplay) {
        long groupId = themeDisplay.getLayout().getGroupId();
        long repositoryId = themeDisplay.getScopeGroupId();
        DLFolder folder = null;
        try {
            _log.info("Loading OP folder");
            folder = DLFolderLocalServiceUtil.getFolder(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, op.getScreenName());
        } catch (PortalException ex) {
            _log.warn("Cannot find OP root folder. Creating... ");
            try {

                folder = DLFolderLocalServiceUtil.addFolder(op.getUserId(),
                        groupId,
                        repositoryId,
                        false,
                        DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
                        op.getScreenName(),
                        "Directory di" + op.getFirstName(),
                        false,
                        new ServiceContext());
            } catch (PortalException ex1) {
                _log.error(ex.getMessage());
            } catch (SystemException ex1) {
                _log.error(ex.getMessage());
            }
        } catch (SystemException ex) {
            _log.error(ex.getMessage());
        }
        return folder;
    }

    private DLFolder createAssociateFolder(User associate, DLFolder parentFolder, ThemeDisplay themeDisplay) {
        long groupId = themeDisplay.getLayout().getGroupId();
        long repositoryId = themeDisplay.getScopeGroupId();
        DLFolder folder = null;

        try {

            folder = DLFolderLocalServiceUtil.addFolder(associate.getUserId(),
                    groupId,
                    repositoryId,
                    false,
                    parentFolder.getFolderId(),
                    associate.getScreenName(),
                    "Directory di " + associate.getFirstName(),
                    false,
                    new ServiceContext());

            Role associateRole = RoleLocalServiceUtil.getRole(associate.getCompanyId(), "OP");
            String[] actionsRW = new String[]{ActionKeys.VIEW};
//            String[] actionsRW = new String[]{ActionKeys.ACCESS, ActionKeys.ADD_DOCUMENT, ActionKeys.ADD_SUBFOLDER, ActionKeys.DELETE, ActionKeys.UPDATE, ActionKeys.VIEW};

            ResourcePermissionLocalServiceUtil.setResourcePermissions(associate.getCompanyId(),
                    "com.liferay.portlet.documentlibrary.model.DLFolder",
                    ResourceConstants.SCOPE_INDIVIDUAL,
                    "" + folder.getFolderId(),
                    associateRole.getRoleId(),
                    actionsRW);

        } catch (PortalException ex) {
            _log.error(ex.getMessage());
        } catch (SystemException ex) {
            _log.error(ex.getMessage());
        }
        return folder;
    }

}

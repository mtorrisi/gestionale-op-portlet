/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.its.ct.gestionaleOP.op;

import it.bysoftware.ct.model.Associato;
import it.bysoftware.ct.model.ClientiDatiAgg;
import it.bysoftware.ct.model.OrganizzazioneProduttori;
import it.bysoftware.ct.service.AssociatoLocalServiceUtil;
import it.bysoftware.ct.service.ClientiDatiAggLocalServiceUtil;
import it.bysoftware.ct.service.OrganizzazioneProduttoriLocalServiceUtil;
import it.bysoftware.ct.service.persistence.ClientiDatiAggPK;
import it.its.ct.gestionaleOP.utils.DocumentType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

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
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 *
 * @author mario
 */
public class RegistraAssociatoPortlet extends MVCPortlet {

    private final Log _log = LogFactoryUtil.getLog(RegistraAssociatoPortlet.class);

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
            AssociatoLocalServiceUtil.deleteAssociato(a);
            UserLocalServiceUtil.deleteUser(a.getIdLiferay());
        } catch (Exception ex) {
        	_log.error(ex.getMessage());
            SessionErrors.add(areq, "delete-associato");
        }
    }

    public void addAssociato(ActionRequest areq, ActionResponse ares) {

        try {
            Associato a = AssociatoLocalServiceUtil.createAssociato(0);

            a.setRagioneSociale(ParamUtil.getString(areq, "ragioneSociale"));
            a.setPartitaIVA(ParamUtil.getString(areq, "pIVA"));
            a.setCentro(ParamUtil.getString(areq, "centro"));
            a.setIndirizzo(ParamUtil.getString(areq, "indirizzo"));
            a.setComune(ParamUtil.getString(areq, "comune"));
            a.setTelefono(ParamUtil.getString(areq, "telefono"));
            a.setFax(ParamUtil.getString(areq, "fax"));
            a.setEmail(ParamUtil.getString(areq, "email"));
            a.setNomeUtente(ParamUtil.getString(areq, "nome"));
            a.setSezionaleOP(ParamUtil.getString(areq, "sezionale_op", "FIN"));
            String plainPwd = ParamUtil.getString(areq, "password");

            a.setPassword(plainPwd);

            User creator = PortalUtil.getUser(areq);
            Role role = RoleServiceUtil.getRole(creator.getCompanyId(), "associato");
            OrganizzazioneProduttori op = OrganizzazioneProduttoriLocalServiceUtil.getOP(creator.getUserId());

            User liferayUser = addLiferayUser(a.getRagioneSociale(), "", a.getEmail(), plainPwd, a.getNomeUtente(), creator, role.getRoleId());
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
        } catch (PortalException ex) {
            _log.error(ex.getMessage());
            SessionErrors.add(areq, "no-registration");
        }
    }

    public void editAssociato(ActionRequest areq, ActionResponse ares) {

        String[] values = ParamUtil.getParameterValues(areq, "values", new String[0]);

        try {
            Associato a = AssociatoLocalServiceUtil.getAssociato(ParamUtil.getLong(areq, "id"));

            a.setRagioneSociale(ParamUtil.getString(areq, "ragioneSociale"));
            a.setPartitaIVA(ParamUtil.getString(areq, "pIVA"));
            a.setCentro(ParamUtil.getString(areq, "centro"));
            a.setIndirizzo(ParamUtil.getString(areq, "indirizzo"));
            a.setComune(ParamUtil.getString(areq, "comune"));
            a.setTelefono(ParamUtil.getString(areq, "telefono"));
            a.setFax(ParamUtil.getString(areq, "fax"));
            a.setSezionaleOP(ParamUtil.getString(areq, "sezionale_op", "FIN"));
            String newEmail = ParamUtil.getString(areq, "email");
            String newPassword = ParamUtil.getString(areq, "password");
            User liferayUser = UserLocalServiceUtil.getUser(a.getIdLiferay());
            if (newEmail != null && !newEmail.equals("") && !newEmail.equals(a.getEmail())) {
                a.setEmail(ParamUtil.getString(areq, "email"));
                liferayUser.setEmailAddress(newEmail);
                UserLocalServiceUtil.updateUser(liferayUser);
            }

            if (newPassword != null && !newPassword.equals("") && !newPassword.equals(a.getPassword())) {

                a.setPassword(newPassword);
                UserServiceUtil.updatePassword(a.getIdLiferay(), newPassword, newPassword, false);

            }

            AssociatoLocalServiceUtil.updateAssociato(a);

            for (String value : values) {
                ClientiDatiAgg clientiDatiAgg = ClientiDatiAggLocalServiceUtil.getClientiDatiAgg(new ClientiDatiAggPK(value, false));
//                String[] idAssociati = clientiDatiAgg.getAssociati().split(",");
                List<String> idAssociati = new ArrayList<String>(Arrays.asList(clientiDatiAgg.getAssociati().split(",")));
                if (!idAssociati.contains(String.valueOf(a.getIdLiferay()))) {
                    idAssociati.add(String.valueOf(a.getIdLiferay()));
                }
                String tmp = "";
                for (int i = 0; i < idAssociati.size(); i++) {
                    if (i == 0) {
                        tmp += idAssociati.get(i);
                    } else {
                        tmp += "," + idAssociati.get(i);
                    }
                }
                clientiDatiAgg.setAssociati(tmp);
                ClientiDatiAggLocalServiceUtil.updateClientiDatiAgg(clientiDatiAgg);
            }

        } catch (PortalException ex) {
            _log.error(ex.getMessage());
            ex.printStackTrace();
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
        DLFolder associatoFolder = null;

        try {

            associatoFolder = DLFolderLocalServiceUtil.addFolder(associate.getUserId(),
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

            ResourcePermissionLocalServiceUtil.setResourcePermissions(associate.getCompanyId(),
                    "com.liferay.portlet.documentlibrary.model.DLFolder",
                    ResourceConstants.SCOPE_INDIVIDUAL,
                    "" + associatoFolder.getFolderId(),
                    associateRole.getRoleId(),
                    actionsRW);
            
            //Create document subfolders...
            
            DLFolder yearFolder =DLFolderLocalServiceUtil.addFolder(associate.getUserId(),
                    groupId,
                    repositoryId,
                    false,
                    associatoFolder.getFolderId(),
                    String.valueOf(Calendar.getInstance().get(Calendar.YEAR)),
                    "Directory di " + associate.getFirstName(),
                    false,
                    new ServiceContext());
            ResourcePermissionLocalServiceUtil.setResourcePermissions(associate.getCompanyId(),
                    "com.liferay.portlet.documentlibrary.model.DLFolder",
                    ResourceConstants.SCOPE_INDIVIDUAL,
                    "" + yearFolder.getFolderId(),
                    associateRole.getRoleId(),
                    actionsRW);
            _log.debug("Created yearFolder: " + yearFolder);
            for(DocumentType type : DocumentType.values()){
            	
            	switch (type) {
					case DDT:
					case FAC:
					case FAV:
					case NAC:
						DLFolder docFolder = DLFolderLocalServiceUtil.addFolder(associate.getUserId(),
		                        groupId,
		                        repositoryId,
		                        false,
		                        yearFolder.getFolderId(),
		                        type.name(),
		                        "Directory di " + associate.getFirstName(),
		                        false,
		                        new ServiceContext());
		            			ResourcePermissionLocalServiceUtil.setResourcePermissions(associate.getCompanyId(),
		                        "com.liferay.portlet.documentlibrary.model.DLFolder",
		                        ResourceConstants.SCOPE_INDIVIDUAL,
		                        "" + docFolder.getFolderId(),
		                        associateRole.getRoleId(),
		                        actionsRW);
		            	_log.debug("Created docFolder: " + docFolder);
						break;
					default:
						break;
					}
            }
            
        } catch (PortalException ex) {
            _log.error(ex.getMessage());
        } catch (SystemException ex) {
            _log.error(ex.getMessage());
        }
        return associatoFolder;
    }

}

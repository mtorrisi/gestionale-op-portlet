package it.its.ct.gestionaleOP.utils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;

public class Utils {
	public static DLFolder getOpFolder(long groupId, User liferayOp)
			throws PortalException, SystemException {
		return DLFolderLocalServiceUtil.getFolder(groupId,
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
				liferayOp.getScreenName());
	}

	public static DLFolder getAssociatoFolder(long groupId, DLFolder opFolder,
			User liferayAssociato) throws PortalException, SystemException {
		return DLFolderLocalServiceUtil.getFolder(groupId,
				opFolder.getFolderId(), liferayAssociato.getScreenName());
	}

	public static DLFolder getAssociatoYearFolder(long groupId,
			DLFolder associatoFolder, int year) throws PortalException,
			SystemException {
		return DLFolderLocalServiceUtil.getFolder(groupId,
				associatoFolder.getFolderId(), String.valueOf(year));
	}

	public static DLFolder getAssociatoDocumentFolder(long groupId,
			DLFolder yearFolder, String tipoDocumento) throws PortalException, SystemException {
		return DLFolderLocalServiceUtil.getFolder(groupId,
				yearFolder.getFolderId(), tipoDocumento);
	}
}

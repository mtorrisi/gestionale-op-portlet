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

import com.liferay.portal.kernel.util.FileUtil;

import it.bysoftware.ct.service.base.FileUploaderLocalServiceBaseImpl;

import java.io.File;

/**
 * The implementation of the file uploader local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link it.bysoftware.ct.service.FileUploaderLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.base.FileUploaderLocalServiceBaseImpl
 * @see it.bysoftware.ct.service.FileUploaderLocalServiceUtil
 */
public class FileUploaderLocalServiceImpl
		extends FileUploaderLocalServiceBaseImpl {
	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * it.bysoftware.ct.service.FileUploaderLocalServiceUtil} to access the file
	 * uploader local service.
	 */

	public void add(File file) {
		File folder = new File("/opt/glassfish4/data/upload/");

		// This is our final file path.

		File f = new File(folder + file.getName());
		FileUtil.move(file, f);
	}
}
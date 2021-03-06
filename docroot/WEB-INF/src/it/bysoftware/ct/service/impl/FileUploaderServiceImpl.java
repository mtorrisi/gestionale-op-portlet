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

import it.bysoftware.ct.service.base.FileUploaderServiceBaseImpl;

import it.its.ct.gestionaleOP.Azioni;

import java.io.File;

/**
 * The implementation of the file uploader remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link it.bysoftware.ct.service.FileUploaderService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.base.FileUploaderServiceBaseImpl
 * @see it.bysoftware.ct.service.FileUploaderServiceUtil
 */
public class FileUploaderServiceImpl extends FileUploaderServiceBaseImpl {
	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * it.bysoftware.ct.service.FileUploaderServiceUtil} to access the file
	 * uploader remote service.
	 */

	public void add(File file) {
		Thread thread = new Thread(new Azioni(file));
		thread.start();
	}

	public void add(File file, String name) {
		Thread thread = new Thread(new Azioni(file, name));
		thread.start();
	}

}
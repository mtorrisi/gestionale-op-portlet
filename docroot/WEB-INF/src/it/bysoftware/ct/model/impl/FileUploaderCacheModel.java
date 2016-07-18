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

package it.bysoftware.ct.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import it.bysoftware.ct.model.FileUploader;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing FileUploader in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see FileUploader
 * @generated
 */
public class FileUploaderCacheModel implements CacheModel<FileUploader>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{fid=");
		sb.append(fid);
		sb.append(", content=");
		sb.append(content);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FileUploader toEntityModel() {
		FileUploaderImpl fileUploaderImpl = new FileUploaderImpl();

		fileUploaderImpl.setFid(fid);

		if (content == null) {
			fileUploaderImpl.setContent(StringPool.BLANK);
		}
		else {
			fileUploaderImpl.setContent(content);
		}

		fileUploaderImpl.resetOriginalValues();

		return fileUploaderImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		fid = objectInput.readLong();
		content = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(fid);

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}
	}

	public long fid;
	public String content;
}
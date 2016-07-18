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

package it.bysoftware.ct.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.bysoftware.ct.service.http.FileUploaderServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see it.bysoftware.ct.service.http.FileUploaderServiceSoap
 * @generated
 */
public class FileUploaderSoap implements Serializable {
	public static FileUploaderSoap toSoapModel(FileUploader model) {
		FileUploaderSoap soapModel = new FileUploaderSoap();

		soapModel.setFid(model.getFid());
		soapModel.setContent(model.getContent());

		return soapModel;
	}

	public static FileUploaderSoap[] toSoapModels(FileUploader[] models) {
		FileUploaderSoap[] soapModels = new FileUploaderSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FileUploaderSoap[][] toSoapModels(FileUploader[][] models) {
		FileUploaderSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FileUploaderSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FileUploaderSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FileUploaderSoap[] toSoapModels(List<FileUploader> models) {
		List<FileUploaderSoap> soapModels = new ArrayList<FileUploaderSoap>(models.size());

		for (FileUploader model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FileUploaderSoap[soapModels.size()]);
	}

	public FileUploaderSoap() {
	}

	public long getPrimaryKey() {
		return _fid;
	}

	public void setPrimaryKey(long pk) {
		setFid(pk);
	}

	public long getFid() {
		return _fid;
	}

	public void setFid(long fid) {
		_fid = fid;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	private long _fid;
	private String _content;
}
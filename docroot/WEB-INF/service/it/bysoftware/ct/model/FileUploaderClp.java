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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import it.bysoftware.ct.service.ClpSerializer;
import it.bysoftware.ct.service.FileUploaderLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class FileUploaderClp extends BaseModelImpl<FileUploader>
	implements FileUploader {
	public FileUploaderClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return FileUploader.class;
	}

	@Override
	public String getModelClassName() {
		return FileUploader.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _fid;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFid(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _fid;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("fid", getFid());
		attributes.put("content", getContent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long fid = (Long)attributes.get("fid");

		if (fid != null) {
			setFid(fid);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}
	}

	@Override
	public long getFid() {
		return _fid;
	}

	@Override
	public void setFid(long fid) {
		_fid = fid;

		if (_fileUploaderRemoteModel != null) {
			try {
				Class<?> clazz = _fileUploaderRemoteModel.getClass();

				Method method = clazz.getMethod("setFid", long.class);

				method.invoke(_fileUploaderRemoteModel, fid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContent() {
		return _content;
	}

	@Override
	public void setContent(String content) {
		_content = content;

		if (_fileUploaderRemoteModel != null) {
			try {
				Class<?> clazz = _fileUploaderRemoteModel.getClass();

				Method method = clazz.getMethod("setContent", String.class);

				method.invoke(_fileUploaderRemoteModel, content);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFileUploaderRemoteModel() {
		return _fileUploaderRemoteModel;
	}

	public void setFileUploaderRemoteModel(BaseModel<?> fileUploaderRemoteModel) {
		_fileUploaderRemoteModel = fileUploaderRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _fileUploaderRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_fileUploaderRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FileUploaderLocalServiceUtil.addFileUploader(this);
		}
		else {
			FileUploaderLocalServiceUtil.updateFileUploader(this);
		}
	}

	@Override
	public FileUploader toEscapedModel() {
		return (FileUploader)ProxyUtil.newProxyInstance(FileUploader.class.getClassLoader(),
			new Class[] { FileUploader.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FileUploaderClp clone = new FileUploaderClp();

		clone.setFid(getFid());
		clone.setContent(getContent());

		return clone;
	}

	@Override
	public int compareTo(FileUploader fileUploader) {
		long primaryKey = fileUploader.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FileUploaderClp)) {
			return false;
		}

		FileUploaderClp fileUploader = (FileUploaderClp)obj;

		long primaryKey = fileUploader.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{fid=");
		sb.append(getFid());
		sb.append(", content=");
		sb.append(getContent());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("it.bysoftware.ct.model.FileUploader");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>fid</column-name><column-value><![CDATA[");
		sb.append(getFid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _fid;
	private String _content;
	private BaseModel<?> _fileUploaderRemoteModel;
	private Class<?> _clpSerializerClass = it.bysoftware.ct.service.ClpSerializer.class;
}
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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FileUploader}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileUploader
 * @generated
 */
public class FileUploaderWrapper implements FileUploader,
	ModelWrapper<FileUploader> {
	public FileUploaderWrapper(FileUploader fileUploader) {
		_fileUploader = fileUploader;
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

	/**
	* Returns the primary key of this file uploader.
	*
	* @return the primary key of this file uploader
	*/
	@Override
	public long getPrimaryKey() {
		return _fileUploader.getPrimaryKey();
	}

	/**
	* Sets the primary key of this file uploader.
	*
	* @param primaryKey the primary key of this file uploader
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_fileUploader.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the fid of this file uploader.
	*
	* @return the fid of this file uploader
	*/
	@Override
	public long getFid() {
		return _fileUploader.getFid();
	}

	/**
	* Sets the fid of this file uploader.
	*
	* @param fid the fid of this file uploader
	*/
	@Override
	public void setFid(long fid) {
		_fileUploader.setFid(fid);
	}

	/**
	* Returns the content of this file uploader.
	*
	* @return the content of this file uploader
	*/
	@Override
	public java.lang.String getContent() {
		return _fileUploader.getContent();
	}

	/**
	* Sets the content of this file uploader.
	*
	* @param content the content of this file uploader
	*/
	@Override
	public void setContent(java.lang.String content) {
		_fileUploader.setContent(content);
	}

	@Override
	public boolean isNew() {
		return _fileUploader.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_fileUploader.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _fileUploader.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_fileUploader.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _fileUploader.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _fileUploader.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_fileUploader.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _fileUploader.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_fileUploader.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_fileUploader.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_fileUploader.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FileUploaderWrapper((FileUploader)_fileUploader.clone());
	}

	@Override
	public int compareTo(it.bysoftware.ct.model.FileUploader fileUploader) {
		return _fileUploader.compareTo(fileUploader);
	}

	@Override
	public int hashCode() {
		return _fileUploader.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.bysoftware.ct.model.FileUploader> toCacheModel() {
		return _fileUploader.toCacheModel();
	}

	@Override
	public it.bysoftware.ct.model.FileUploader toEscapedModel() {
		return new FileUploaderWrapper(_fileUploader.toEscapedModel());
	}

	@Override
	public it.bysoftware.ct.model.FileUploader toUnescapedModel() {
		return new FileUploaderWrapper(_fileUploader.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _fileUploader.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _fileUploader.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_fileUploader.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FileUploaderWrapper)) {
			return false;
		}

		FileUploaderWrapper fileUploaderWrapper = (FileUploaderWrapper)obj;

		if (Validator.equals(_fileUploader, fileUploaderWrapper._fileUploader)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FileUploader getWrappedFileUploader() {
		return _fileUploader;
	}

	@Override
	public FileUploader getWrappedModel() {
		return _fileUploader;
	}

	@Override
	public void resetOriginalValues() {
		_fileUploader.resetOriginalValues();
	}

	private FileUploader _fileUploader;
}
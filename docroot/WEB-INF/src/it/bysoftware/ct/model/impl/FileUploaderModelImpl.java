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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import it.bysoftware.ct.model.FileUploader;
import it.bysoftware.ct.model.FileUploaderModel;
import it.bysoftware.ct.model.FileUploaderSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the FileUploader service. Represents a row in the &quot;fileuploader&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.bysoftware.ct.model.FileUploaderModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FileUploaderImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileUploaderImpl
 * @see it.bysoftware.ct.model.FileUploader
 * @see it.bysoftware.ct.model.FileUploaderModel
 * @generated
 */
@JSON(strict = true)
public class FileUploaderModelImpl extends BaseModelImpl<FileUploader>
	implements FileUploaderModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a file uploader model instance should use the {@link it.bysoftware.ct.model.FileUploader} interface instead.
	 */
	public static final String TABLE_NAME = "fileuploader";
	public static final Object[][] TABLE_COLUMNS = {
			{ "fid", Types.BIGINT },
			{ "content", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table fileuploader (fid LONG not null primary key,content VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table fileuploader";
	public static final String ORDER_BY_JPQL = " ORDER BY fileUploader.fid ASC";
	public static final String ORDER_BY_SQL = " ORDER BY fileuploader.fid ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.bysoftware.ct.model.FileUploader"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.bysoftware.ct.model.FileUploader"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static FileUploader toModel(FileUploaderSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		FileUploader model = new FileUploaderImpl();

		model.setFid(soapModel.getFid());
		model.setContent(soapModel.getContent());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<FileUploader> toModels(FileUploaderSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<FileUploader> models = new ArrayList<FileUploader>(soapModels.length);

		for (FileUploaderSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.bysoftware.ct.model.FileUploader"));

	public FileUploaderModelImpl() {
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

	@JSON
	@Override
	public long getFid() {
		return _fid;
	}

	@Override
	public void setFid(long fid) {
		_fid = fid;
	}

	@JSON
	@Override
	public String getContent() {
		if (_content == null) {
			return StringPool.BLANK;
		}
		else {
			return _content;
		}
	}

	@Override
	public void setContent(String content) {
		_content = content;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			FileUploader.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public FileUploader toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (FileUploader)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FileUploaderImpl fileUploaderImpl = new FileUploaderImpl();

		fileUploaderImpl.setFid(getFid());
		fileUploaderImpl.setContent(getContent());

		fileUploaderImpl.resetOriginalValues();

		return fileUploaderImpl;
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

		if (!(obj instanceof FileUploader)) {
			return false;
		}

		FileUploader fileUploader = (FileUploader)obj;

		long primaryKey = fileUploader.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<FileUploader> toCacheModel() {
		FileUploaderCacheModel fileUploaderCacheModel = new FileUploaderCacheModel();

		fileUploaderCacheModel.fid = getFid();

		fileUploaderCacheModel.content = getContent();

		String content = fileUploaderCacheModel.content;

		if ((content != null) && (content.length() == 0)) {
			fileUploaderCacheModel.content = null;
		}

		return fileUploaderCacheModel;
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

	private static ClassLoader _classLoader = FileUploader.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			FileUploader.class
		};
	private long _fid;
	private String _content;
	private FileUploader _escapedModel;
}
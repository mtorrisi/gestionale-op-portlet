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

package it.bysoftware.ct.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.bysoftware.ct.NoSuchFileUploaderException;
import it.bysoftware.ct.model.FileUploader;
import it.bysoftware.ct.model.impl.FileUploaderImpl;
import it.bysoftware.ct.model.impl.FileUploaderModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the file uploader service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileUploaderPersistence
 * @see FileUploaderUtil
 * @generated
 */
public class FileUploaderPersistenceImpl extends BasePersistenceImpl<FileUploader>
	implements FileUploaderPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FileUploaderUtil} to access the file uploader persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FileUploaderImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FileUploaderModelImpl.ENTITY_CACHE_ENABLED,
			FileUploaderModelImpl.FINDER_CACHE_ENABLED, FileUploaderImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FileUploaderModelImpl.ENTITY_CACHE_ENABLED,
			FileUploaderModelImpl.FINDER_CACHE_ENABLED, FileUploaderImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FileUploaderModelImpl.ENTITY_CACHE_ENABLED,
			FileUploaderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public FileUploaderPersistenceImpl() {
		setModelClass(FileUploader.class);
	}

	/**
	 * Caches the file uploader in the entity cache if it is enabled.
	 *
	 * @param fileUploader the file uploader
	 */
	@Override
	public void cacheResult(FileUploader fileUploader) {
		EntityCacheUtil.putResult(FileUploaderModelImpl.ENTITY_CACHE_ENABLED,
			FileUploaderImpl.class, fileUploader.getPrimaryKey(), fileUploader);

		fileUploader.resetOriginalValues();
	}

	/**
	 * Caches the file uploaders in the entity cache if it is enabled.
	 *
	 * @param fileUploaders the file uploaders
	 */
	@Override
	public void cacheResult(List<FileUploader> fileUploaders) {
		for (FileUploader fileUploader : fileUploaders) {
			if (EntityCacheUtil.getResult(
						FileUploaderModelImpl.ENTITY_CACHE_ENABLED,
						FileUploaderImpl.class, fileUploader.getPrimaryKey()) == null) {
				cacheResult(fileUploader);
			}
			else {
				fileUploader.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all file uploaders.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FileUploaderImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FileUploaderImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the file uploader.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FileUploader fileUploader) {
		EntityCacheUtil.removeResult(FileUploaderModelImpl.ENTITY_CACHE_ENABLED,
			FileUploaderImpl.class, fileUploader.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FileUploader> fileUploaders) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FileUploader fileUploader : fileUploaders) {
			EntityCacheUtil.removeResult(FileUploaderModelImpl.ENTITY_CACHE_ENABLED,
				FileUploaderImpl.class, fileUploader.getPrimaryKey());
		}
	}

	/**
	 * Creates a new file uploader with the primary key. Does not add the file uploader to the database.
	 *
	 * @param fid the primary key for the new file uploader
	 * @return the new file uploader
	 */
	@Override
	public FileUploader create(long fid) {
		FileUploader fileUploader = new FileUploaderImpl();

		fileUploader.setNew(true);
		fileUploader.setPrimaryKey(fid);

		return fileUploader;
	}

	/**
	 * Removes the file uploader with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fid the primary key of the file uploader
	 * @return the file uploader that was removed
	 * @throws it.bysoftware.ct.NoSuchFileUploaderException if a file uploader with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FileUploader remove(long fid)
		throws NoSuchFileUploaderException, SystemException {
		return remove((Serializable)fid);
	}

	/**
	 * Removes the file uploader with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the file uploader
	 * @return the file uploader that was removed
	 * @throws it.bysoftware.ct.NoSuchFileUploaderException if a file uploader with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FileUploader remove(Serializable primaryKey)
		throws NoSuchFileUploaderException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FileUploader fileUploader = (FileUploader)session.get(FileUploaderImpl.class,
					primaryKey);

			if (fileUploader == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFileUploaderException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(fileUploader);
		}
		catch (NoSuchFileUploaderException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected FileUploader removeImpl(FileUploader fileUploader)
		throws SystemException {
		fileUploader = toUnwrappedModel(fileUploader);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(fileUploader)) {
				fileUploader = (FileUploader)session.get(FileUploaderImpl.class,
						fileUploader.getPrimaryKeyObj());
			}

			if (fileUploader != null) {
				session.delete(fileUploader);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (fileUploader != null) {
			clearCache(fileUploader);
		}

		return fileUploader;
	}

	@Override
	public FileUploader updateImpl(
		it.bysoftware.ct.model.FileUploader fileUploader)
		throws SystemException {
		fileUploader = toUnwrappedModel(fileUploader);

		boolean isNew = fileUploader.isNew();

		Session session = null;

		try {
			session = openSession();

			if (fileUploader.isNew()) {
				session.save(fileUploader);

				fileUploader.setNew(false);
			}
			else {
				session.merge(fileUploader);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(FileUploaderModelImpl.ENTITY_CACHE_ENABLED,
			FileUploaderImpl.class, fileUploader.getPrimaryKey(), fileUploader);

		return fileUploader;
	}

	protected FileUploader toUnwrappedModel(FileUploader fileUploader) {
		if (fileUploader instanceof FileUploaderImpl) {
			return fileUploader;
		}

		FileUploaderImpl fileUploaderImpl = new FileUploaderImpl();

		fileUploaderImpl.setNew(fileUploader.isNew());
		fileUploaderImpl.setPrimaryKey(fileUploader.getPrimaryKey());

		fileUploaderImpl.setFid(fileUploader.getFid());
		fileUploaderImpl.setContent(fileUploader.getContent());

		return fileUploaderImpl;
	}

	/**
	 * Returns the file uploader with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the file uploader
	 * @return the file uploader
	 * @throws it.bysoftware.ct.NoSuchFileUploaderException if a file uploader with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FileUploader findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFileUploaderException, SystemException {
		FileUploader fileUploader = fetchByPrimaryKey(primaryKey);

		if (fileUploader == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFileUploaderException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return fileUploader;
	}

	/**
	 * Returns the file uploader with the primary key or throws a {@link it.bysoftware.ct.NoSuchFileUploaderException} if it could not be found.
	 *
	 * @param fid the primary key of the file uploader
	 * @return the file uploader
	 * @throws it.bysoftware.ct.NoSuchFileUploaderException if a file uploader with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FileUploader findByPrimaryKey(long fid)
		throws NoSuchFileUploaderException, SystemException {
		return findByPrimaryKey((Serializable)fid);
	}

	/**
	 * Returns the file uploader with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the file uploader
	 * @return the file uploader, or <code>null</code> if a file uploader with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FileUploader fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FileUploader fileUploader = (FileUploader)EntityCacheUtil.getResult(FileUploaderModelImpl.ENTITY_CACHE_ENABLED,
				FileUploaderImpl.class, primaryKey);

		if (fileUploader == _nullFileUploader) {
			return null;
		}

		if (fileUploader == null) {
			Session session = null;

			try {
				session = openSession();

				fileUploader = (FileUploader)session.get(FileUploaderImpl.class,
						primaryKey);

				if (fileUploader != null) {
					cacheResult(fileUploader);
				}
				else {
					EntityCacheUtil.putResult(FileUploaderModelImpl.ENTITY_CACHE_ENABLED,
						FileUploaderImpl.class, primaryKey, _nullFileUploader);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FileUploaderModelImpl.ENTITY_CACHE_ENABLED,
					FileUploaderImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return fileUploader;
	}

	/**
	 * Returns the file uploader with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fid the primary key of the file uploader
	 * @return the file uploader, or <code>null</code> if a file uploader with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FileUploader fetchByPrimaryKey(long fid) throws SystemException {
		return fetchByPrimaryKey((Serializable)fid);
	}

	/**
	 * Returns all the file uploaders.
	 *
	 * @return the file uploaders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FileUploader> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the file uploaders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.FileUploaderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of file uploaders
	 * @param end the upper bound of the range of file uploaders (not inclusive)
	 * @return the range of file uploaders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FileUploader> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the file uploaders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.FileUploaderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of file uploaders
	 * @param end the upper bound of the range of file uploaders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of file uploaders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FileUploader> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<FileUploader> list = (List<FileUploader>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FILEUPLOADER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FILEUPLOADER;

				if (pagination) {
					sql = sql.concat(FileUploaderModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FileUploader>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FileUploader>(list);
				}
				else {
					list = (List<FileUploader>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the file uploaders from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FileUploader fileUploader : findAll()) {
			remove(fileUploader);
		}
	}

	/**
	 * Returns the number of file uploaders.
	 *
	 * @return the number of file uploaders
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FILEUPLOADER);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the file uploader persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.bysoftware.ct.model.FileUploader")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FileUploader>> listenersList = new ArrayList<ModelListener<FileUploader>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FileUploader>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(FileUploaderImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FILEUPLOADER = "SELECT fileUploader FROM FileUploader fileUploader";
	private static final String _SQL_COUNT_FILEUPLOADER = "SELECT COUNT(fileUploader) FROM FileUploader fileUploader";
	private static final String _ORDER_BY_ENTITY_ALIAS = "fileUploader.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FileUploader exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FileUploaderPersistenceImpl.class);
	private static FileUploader _nullFileUploader = new FileUploaderImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FileUploader> toCacheModel() {
				return _nullFileUploaderCacheModel;
			}
		};

	private static CacheModel<FileUploader> _nullFileUploaderCacheModel = new CacheModel<FileUploader>() {
			@Override
			public FileUploader toEntityModel() {
				return _nullFileUploader;
			}
		};
}
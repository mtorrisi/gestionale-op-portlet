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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.bysoftware.ct.NoSuchAspettoEsterioreBeniException;
import it.bysoftware.ct.model.AspettoEsterioreBeni;
import it.bysoftware.ct.model.impl.AspettoEsterioreBeniImpl;
import it.bysoftware.ct.model.impl.AspettoEsterioreBeniModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the aspetto esteriore beni service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AspettoEsterioreBeniPersistence
 * @see AspettoEsterioreBeniUtil
 * @generated
 */
public class AspettoEsterioreBeniPersistenceImpl extends BasePersistenceImpl<AspettoEsterioreBeni>
	implements AspettoEsterioreBeniPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AspettoEsterioreBeniUtil} to access the aspetto esteriore beni persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AspettoEsterioreBeniImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AspettoEsterioreBeniModelImpl.ENTITY_CACHE_ENABLED,
			AspettoEsterioreBeniModelImpl.FINDER_CACHE_ENABLED,
			AspettoEsterioreBeniImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AspettoEsterioreBeniModelImpl.ENTITY_CACHE_ENABLED,
			AspettoEsterioreBeniModelImpl.FINDER_CACHE_ENABLED,
			AspettoEsterioreBeniImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AspettoEsterioreBeniModelImpl.ENTITY_CACHE_ENABLED,
			AspettoEsterioreBeniModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public AspettoEsterioreBeniPersistenceImpl() {
		setModelClass(AspettoEsterioreBeni.class);
	}

	/**
	 * Caches the aspetto esteriore beni in the entity cache if it is enabled.
	 *
	 * @param aspettoEsterioreBeni the aspetto esteriore beni
	 */
	@Override
	public void cacheResult(AspettoEsterioreBeni aspettoEsterioreBeni) {
		EntityCacheUtil.putResult(AspettoEsterioreBeniModelImpl.ENTITY_CACHE_ENABLED,
			AspettoEsterioreBeniImpl.class,
			aspettoEsterioreBeni.getPrimaryKey(), aspettoEsterioreBeni);

		aspettoEsterioreBeni.resetOriginalValues();
	}

	/**
	 * Caches the aspetto esteriore benis in the entity cache if it is enabled.
	 *
	 * @param aspettoEsterioreBenis the aspetto esteriore benis
	 */
	@Override
	public void cacheResult(List<AspettoEsterioreBeni> aspettoEsterioreBenis) {
		for (AspettoEsterioreBeni aspettoEsterioreBeni : aspettoEsterioreBenis) {
			if (EntityCacheUtil.getResult(
						AspettoEsterioreBeniModelImpl.ENTITY_CACHE_ENABLED,
						AspettoEsterioreBeniImpl.class,
						aspettoEsterioreBeni.getPrimaryKey()) == null) {
				cacheResult(aspettoEsterioreBeni);
			}
			else {
				aspettoEsterioreBeni.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all aspetto esteriore benis.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AspettoEsterioreBeniImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AspettoEsterioreBeniImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the aspetto esteriore beni.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AspettoEsterioreBeni aspettoEsterioreBeni) {
		EntityCacheUtil.removeResult(AspettoEsterioreBeniModelImpl.ENTITY_CACHE_ENABLED,
			AspettoEsterioreBeniImpl.class, aspettoEsterioreBeni.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AspettoEsterioreBeni> aspettoEsterioreBenis) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AspettoEsterioreBeni aspettoEsterioreBeni : aspettoEsterioreBenis) {
			EntityCacheUtil.removeResult(AspettoEsterioreBeniModelImpl.ENTITY_CACHE_ENABLED,
				AspettoEsterioreBeniImpl.class,
				aspettoEsterioreBeni.getPrimaryKey());
		}
	}

	/**
	 * Creates a new aspetto esteriore beni with the primary key. Does not add the aspetto esteriore beni to the database.
	 *
	 * @param codiceAspettoEsteriore the primary key for the new aspetto esteriore beni
	 * @return the new aspetto esteriore beni
	 */
	@Override
	public AspettoEsterioreBeni create(String codiceAspettoEsteriore) {
		AspettoEsterioreBeni aspettoEsterioreBeni = new AspettoEsterioreBeniImpl();

		aspettoEsterioreBeni.setNew(true);
		aspettoEsterioreBeni.setPrimaryKey(codiceAspettoEsteriore);

		return aspettoEsterioreBeni;
	}

	/**
	 * Removes the aspetto esteriore beni with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param codiceAspettoEsteriore the primary key of the aspetto esteriore beni
	 * @return the aspetto esteriore beni that was removed
	 * @throws it.bysoftware.ct.NoSuchAspettoEsterioreBeniException if a aspetto esteriore beni with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AspettoEsterioreBeni remove(String codiceAspettoEsteriore)
		throws NoSuchAspettoEsterioreBeniException, SystemException {
		return remove((Serializable)codiceAspettoEsteriore);
	}

	/**
	 * Removes the aspetto esteriore beni with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the aspetto esteriore beni
	 * @return the aspetto esteriore beni that was removed
	 * @throws it.bysoftware.ct.NoSuchAspettoEsterioreBeniException if a aspetto esteriore beni with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AspettoEsterioreBeni remove(Serializable primaryKey)
		throws NoSuchAspettoEsterioreBeniException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AspettoEsterioreBeni aspettoEsterioreBeni = (AspettoEsterioreBeni)session.get(AspettoEsterioreBeniImpl.class,
					primaryKey);

			if (aspettoEsterioreBeni == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAspettoEsterioreBeniException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(aspettoEsterioreBeni);
		}
		catch (NoSuchAspettoEsterioreBeniException nsee) {
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
	protected AspettoEsterioreBeni removeImpl(
		AspettoEsterioreBeni aspettoEsterioreBeni) throws SystemException {
		aspettoEsterioreBeni = toUnwrappedModel(aspettoEsterioreBeni);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(aspettoEsterioreBeni)) {
				aspettoEsterioreBeni = (AspettoEsterioreBeni)session.get(AspettoEsterioreBeniImpl.class,
						aspettoEsterioreBeni.getPrimaryKeyObj());
			}

			if (aspettoEsterioreBeni != null) {
				session.delete(aspettoEsterioreBeni);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (aspettoEsterioreBeni != null) {
			clearCache(aspettoEsterioreBeni);
		}

		return aspettoEsterioreBeni;
	}

	@Override
	public AspettoEsterioreBeni updateImpl(
		it.bysoftware.ct.model.AspettoEsterioreBeni aspettoEsterioreBeni)
		throws SystemException {
		aspettoEsterioreBeni = toUnwrappedModel(aspettoEsterioreBeni);

		boolean isNew = aspettoEsterioreBeni.isNew();

		Session session = null;

		try {
			session = openSession();

			if (aspettoEsterioreBeni.isNew()) {
				session.save(aspettoEsterioreBeni);

				aspettoEsterioreBeni.setNew(false);
			}
			else {
				session.merge(aspettoEsterioreBeni);
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

		EntityCacheUtil.putResult(AspettoEsterioreBeniModelImpl.ENTITY_CACHE_ENABLED,
			AspettoEsterioreBeniImpl.class,
			aspettoEsterioreBeni.getPrimaryKey(), aspettoEsterioreBeni);

		return aspettoEsterioreBeni;
	}

	protected AspettoEsterioreBeni toUnwrappedModel(
		AspettoEsterioreBeni aspettoEsterioreBeni) {
		if (aspettoEsterioreBeni instanceof AspettoEsterioreBeniImpl) {
			return aspettoEsterioreBeni;
		}

		AspettoEsterioreBeniImpl aspettoEsterioreBeniImpl = new AspettoEsterioreBeniImpl();

		aspettoEsterioreBeniImpl.setNew(aspettoEsterioreBeni.isNew());
		aspettoEsterioreBeniImpl.setPrimaryKey(aspettoEsterioreBeni.getPrimaryKey());

		aspettoEsterioreBeniImpl.setCodiceAspettoEsteriore(aspettoEsterioreBeni.getCodiceAspettoEsteriore());
		aspettoEsterioreBeniImpl.setDescrizione(aspettoEsterioreBeni.getDescrizione());
		aspettoEsterioreBeniImpl.setCodiceAzienda(aspettoEsterioreBeni.getCodiceAzienda());

		return aspettoEsterioreBeniImpl;
	}

	/**
	 * Returns the aspetto esteriore beni with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the aspetto esteriore beni
	 * @return the aspetto esteriore beni
	 * @throws it.bysoftware.ct.NoSuchAspettoEsterioreBeniException if a aspetto esteriore beni with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AspettoEsterioreBeni findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAspettoEsterioreBeniException, SystemException {
		AspettoEsterioreBeni aspettoEsterioreBeni = fetchByPrimaryKey(primaryKey);

		if (aspettoEsterioreBeni == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAspettoEsterioreBeniException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return aspettoEsterioreBeni;
	}

	/**
	 * Returns the aspetto esteriore beni with the primary key or throws a {@link it.bysoftware.ct.NoSuchAspettoEsterioreBeniException} if it could not be found.
	 *
	 * @param codiceAspettoEsteriore the primary key of the aspetto esteriore beni
	 * @return the aspetto esteriore beni
	 * @throws it.bysoftware.ct.NoSuchAspettoEsterioreBeniException if a aspetto esteriore beni with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AspettoEsterioreBeni findByPrimaryKey(String codiceAspettoEsteriore)
		throws NoSuchAspettoEsterioreBeniException, SystemException {
		return findByPrimaryKey((Serializable)codiceAspettoEsteriore);
	}

	/**
	 * Returns the aspetto esteriore beni with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the aspetto esteriore beni
	 * @return the aspetto esteriore beni, or <code>null</code> if a aspetto esteriore beni with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AspettoEsterioreBeni fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		AspettoEsterioreBeni aspettoEsterioreBeni = (AspettoEsterioreBeni)EntityCacheUtil.getResult(AspettoEsterioreBeniModelImpl.ENTITY_CACHE_ENABLED,
				AspettoEsterioreBeniImpl.class, primaryKey);

		if (aspettoEsterioreBeni == _nullAspettoEsterioreBeni) {
			return null;
		}

		if (aspettoEsterioreBeni == null) {
			Session session = null;

			try {
				session = openSession();

				aspettoEsterioreBeni = (AspettoEsterioreBeni)session.get(AspettoEsterioreBeniImpl.class,
						primaryKey);

				if (aspettoEsterioreBeni != null) {
					cacheResult(aspettoEsterioreBeni);
				}
				else {
					EntityCacheUtil.putResult(AspettoEsterioreBeniModelImpl.ENTITY_CACHE_ENABLED,
						AspettoEsterioreBeniImpl.class, primaryKey,
						_nullAspettoEsterioreBeni);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AspettoEsterioreBeniModelImpl.ENTITY_CACHE_ENABLED,
					AspettoEsterioreBeniImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return aspettoEsterioreBeni;
	}

	/**
	 * Returns the aspetto esteriore beni with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param codiceAspettoEsteriore the primary key of the aspetto esteriore beni
	 * @return the aspetto esteriore beni, or <code>null</code> if a aspetto esteriore beni with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AspettoEsterioreBeni fetchByPrimaryKey(String codiceAspettoEsteriore)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)codiceAspettoEsteriore);
	}

	/**
	 * Returns all the aspetto esteriore benis.
	 *
	 * @return the aspetto esteriore benis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AspettoEsterioreBeni> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the aspetto esteriore benis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AspettoEsterioreBeniModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of aspetto esteriore benis
	 * @param end the upper bound of the range of aspetto esteriore benis (not inclusive)
	 * @return the range of aspetto esteriore benis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AspettoEsterioreBeni> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the aspetto esteriore benis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AspettoEsterioreBeniModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of aspetto esteriore benis
	 * @param end the upper bound of the range of aspetto esteriore benis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of aspetto esteriore benis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AspettoEsterioreBeni> findAll(int start, int end,
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

		List<AspettoEsterioreBeni> list = (List<AspettoEsterioreBeni>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ASPETTOESTERIOREBENI);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ASPETTOESTERIOREBENI;

				if (pagination) {
					sql = sql.concat(AspettoEsterioreBeniModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AspettoEsterioreBeni>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AspettoEsterioreBeni>(list);
				}
				else {
					list = (List<AspettoEsterioreBeni>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the aspetto esteriore benis from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (AspettoEsterioreBeni aspettoEsterioreBeni : findAll()) {
			remove(aspettoEsterioreBeni);
		}
	}

	/**
	 * Returns the number of aspetto esteriore benis.
	 *
	 * @return the number of aspetto esteriore benis
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

				Query q = session.createQuery(_SQL_COUNT_ASPETTOESTERIOREBENI);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the aspetto esteriore beni persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.bysoftware.ct.model.AspettoEsterioreBeni")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AspettoEsterioreBeni>> listenersList = new ArrayList<ModelListener<AspettoEsterioreBeni>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AspettoEsterioreBeni>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AspettoEsterioreBeniImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ASPETTOESTERIOREBENI = "SELECT aspettoEsterioreBeni FROM AspettoEsterioreBeni aspettoEsterioreBeni";
	private static final String _SQL_COUNT_ASPETTOESTERIOREBENI = "SELECT COUNT(aspettoEsterioreBeni) FROM AspettoEsterioreBeni aspettoEsterioreBeni";
	private static final String _ORDER_BY_ENTITY_ALIAS = "aspettoEsterioreBeni.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AspettoEsterioreBeni exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AspettoEsterioreBeniPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"codiceAspettoEsteriore", "descrizione", "codiceAzienda"
			});
	private static AspettoEsterioreBeni _nullAspettoEsterioreBeni = new AspettoEsterioreBeniImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AspettoEsterioreBeni> toCacheModel() {
				return _nullAspettoEsterioreBeniCacheModel;
			}
		};

	private static CacheModel<AspettoEsterioreBeni> _nullAspettoEsterioreBeniCacheModel =
		new CacheModel<AspettoEsterioreBeni>() {
			@Override
			public AspettoEsterioreBeni toEntityModel() {
				return _nullAspettoEsterioreBeni;
			}
		};
}
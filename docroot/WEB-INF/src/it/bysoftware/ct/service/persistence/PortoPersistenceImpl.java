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

import it.bysoftware.ct.NoSuchPortoException;
import it.bysoftware.ct.model.Porto;
import it.bysoftware.ct.model.impl.PortoImpl;
import it.bysoftware.ct.model.impl.PortoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the porto service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PortoPersistence
 * @see PortoUtil
 * @generated
 */
public class PortoPersistenceImpl extends BasePersistenceImpl<Porto>
	implements PortoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PortoUtil} to access the porto persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PortoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PortoModelImpl.ENTITY_CACHE_ENABLED,
			PortoModelImpl.FINDER_CACHE_ENABLED, PortoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PortoModelImpl.ENTITY_CACHE_ENABLED,
			PortoModelImpl.FINDER_CACHE_ENABLED, PortoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PortoModelImpl.ENTITY_CACHE_ENABLED,
			PortoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public PortoPersistenceImpl() {
		setModelClass(Porto.class);
	}

	/**
	 * Caches the porto in the entity cache if it is enabled.
	 *
	 * @param porto the porto
	 */
	@Override
	public void cacheResult(Porto porto) {
		EntityCacheUtil.putResult(PortoModelImpl.ENTITY_CACHE_ENABLED,
			PortoImpl.class, porto.getPrimaryKey(), porto);

		porto.resetOriginalValues();
	}

	/**
	 * Caches the portos in the entity cache if it is enabled.
	 *
	 * @param portos the portos
	 */
	@Override
	public void cacheResult(List<Porto> portos) {
		for (Porto porto : portos) {
			if (EntityCacheUtil.getResult(PortoModelImpl.ENTITY_CACHE_ENABLED,
						PortoImpl.class, porto.getPrimaryKey()) == null) {
				cacheResult(porto);
			}
			else {
				porto.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all portos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PortoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PortoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the porto.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Porto porto) {
		EntityCacheUtil.removeResult(PortoModelImpl.ENTITY_CACHE_ENABLED,
			PortoImpl.class, porto.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Porto> portos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Porto porto : portos) {
			EntityCacheUtil.removeResult(PortoModelImpl.ENTITY_CACHE_ENABLED,
				PortoImpl.class, porto.getPrimaryKey());
		}
	}

	/**
	 * Creates a new porto with the primary key. Does not add the porto to the database.
	 *
	 * @param codicePorto the primary key for the new porto
	 * @return the new porto
	 */
	@Override
	public Porto create(String codicePorto) {
		Porto porto = new PortoImpl();

		porto.setNew(true);
		porto.setPrimaryKey(codicePorto);

		return porto;
	}

	/**
	 * Removes the porto with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param codicePorto the primary key of the porto
	 * @return the porto that was removed
	 * @throws it.bysoftware.ct.NoSuchPortoException if a porto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Porto remove(String codicePorto)
		throws NoSuchPortoException, SystemException {
		return remove((Serializable)codicePorto);
	}

	/**
	 * Removes the porto with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the porto
	 * @return the porto that was removed
	 * @throws it.bysoftware.ct.NoSuchPortoException if a porto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Porto remove(Serializable primaryKey)
		throws NoSuchPortoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Porto porto = (Porto)session.get(PortoImpl.class, primaryKey);

			if (porto == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPortoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(porto);
		}
		catch (NoSuchPortoException nsee) {
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
	protected Porto removeImpl(Porto porto) throws SystemException {
		porto = toUnwrappedModel(porto);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(porto)) {
				porto = (Porto)session.get(PortoImpl.class,
						porto.getPrimaryKeyObj());
			}

			if (porto != null) {
				session.delete(porto);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (porto != null) {
			clearCache(porto);
		}

		return porto;
	}

	@Override
	public Porto updateImpl(it.bysoftware.ct.model.Porto porto)
		throws SystemException {
		porto = toUnwrappedModel(porto);

		boolean isNew = porto.isNew();

		Session session = null;

		try {
			session = openSession();

			if (porto.isNew()) {
				session.save(porto);

				porto.setNew(false);
			}
			else {
				session.merge(porto);
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

		EntityCacheUtil.putResult(PortoModelImpl.ENTITY_CACHE_ENABLED,
			PortoImpl.class, porto.getPrimaryKey(), porto);

		return porto;
	}

	protected Porto toUnwrappedModel(Porto porto) {
		if (porto instanceof PortoImpl) {
			return porto;
		}

		PortoImpl portoImpl = new PortoImpl();

		portoImpl.setNew(porto.isNew());
		portoImpl.setPrimaryKey(porto.getPrimaryKey());

		portoImpl.setCdinco(porto.getCdinco());
		portoImpl.setCodicePorto(porto.getCodicePorto());
		portoImpl.setDescrizione(porto.getDescrizione());
		portoImpl.setIncoterm(porto.getIncoterm());
		portoImpl.setCodiceAzienda(porto.getCodiceAzienda());

		return portoImpl;
	}

	/**
	 * Returns the porto with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the porto
	 * @return the porto
	 * @throws it.bysoftware.ct.NoSuchPortoException if a porto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Porto findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPortoException, SystemException {
		Porto porto = fetchByPrimaryKey(primaryKey);

		if (porto == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPortoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return porto;
	}

	/**
	 * Returns the porto with the primary key or throws a {@link it.bysoftware.ct.NoSuchPortoException} if it could not be found.
	 *
	 * @param codicePorto the primary key of the porto
	 * @return the porto
	 * @throws it.bysoftware.ct.NoSuchPortoException if a porto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Porto findByPrimaryKey(String codicePorto)
		throws NoSuchPortoException, SystemException {
		return findByPrimaryKey((Serializable)codicePorto);
	}

	/**
	 * Returns the porto with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the porto
	 * @return the porto, or <code>null</code> if a porto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Porto fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Porto porto = (Porto)EntityCacheUtil.getResult(PortoModelImpl.ENTITY_CACHE_ENABLED,
				PortoImpl.class, primaryKey);

		if (porto == _nullPorto) {
			return null;
		}

		if (porto == null) {
			Session session = null;

			try {
				session = openSession();

				porto = (Porto)session.get(PortoImpl.class, primaryKey);

				if (porto != null) {
					cacheResult(porto);
				}
				else {
					EntityCacheUtil.putResult(PortoModelImpl.ENTITY_CACHE_ENABLED,
						PortoImpl.class, primaryKey, _nullPorto);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PortoModelImpl.ENTITY_CACHE_ENABLED,
					PortoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return porto;
	}

	/**
	 * Returns the porto with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param codicePorto the primary key of the porto
	 * @return the porto, or <code>null</code> if a porto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Porto fetchByPrimaryKey(String codicePorto)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)codicePorto);
	}

	/**
	 * Returns all the portos.
	 *
	 * @return the portos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Porto> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the portos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.PortoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of portos
	 * @param end the upper bound of the range of portos (not inclusive)
	 * @return the range of portos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Porto> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the portos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.PortoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of portos
	 * @param end the upper bound of the range of portos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of portos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Porto> findAll(int start, int end,
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

		List<Porto> list = (List<Porto>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PORTO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PORTO;

				if (pagination) {
					sql = sql.concat(PortoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Porto>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Porto>(list);
				}
				else {
					list = (List<Porto>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the portos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Porto porto : findAll()) {
			remove(porto);
		}
	}

	/**
	 * Returns the number of portos.
	 *
	 * @return the number of portos
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

				Query q = session.createQuery(_SQL_COUNT_PORTO);

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
	 * Initializes the porto persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.bysoftware.ct.model.Porto")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Porto>> listenersList = new ArrayList<ModelListener<Porto>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Porto>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PortoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PORTO = "SELECT porto FROM Porto porto";
	private static final String _SQL_COUNT_PORTO = "SELECT COUNT(porto) FROM Porto porto";
	private static final String _ORDER_BY_ENTITY_ALIAS = "porto.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Porto exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PortoPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"Cdinco", "codicePorto", "descrizione", "Incoterm",
				"codiceAzienda"
			});
	private static Porto _nullPorto = new PortoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Porto> toCacheModel() {
				return _nullPortoCacheModel;
			}
		};

	private static CacheModel<Porto> _nullPortoCacheModel = new CacheModel<Porto>() {
			@Override
			public Porto toEntityModel() {
				return _nullPorto;
			}
		};
}
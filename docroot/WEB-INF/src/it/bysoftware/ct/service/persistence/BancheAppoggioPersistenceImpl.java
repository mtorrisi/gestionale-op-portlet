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

import it.bysoftware.ct.NoSuchBancheAppoggioException;
import it.bysoftware.ct.model.BancheAppoggio;
import it.bysoftware.ct.model.impl.BancheAppoggioImpl;
import it.bysoftware.ct.model.impl.BancheAppoggioModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the banche appoggio service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BancheAppoggioPersistence
 * @see BancheAppoggioUtil
 * @generated
 */
public class BancheAppoggioPersistenceImpl extends BasePersistenceImpl<BancheAppoggio>
	implements BancheAppoggioPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BancheAppoggioUtil} to access the banche appoggio persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BancheAppoggioImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BancheAppoggioModelImpl.ENTITY_CACHE_ENABLED,
			BancheAppoggioModelImpl.FINDER_CACHE_ENABLED,
			BancheAppoggioImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BancheAppoggioModelImpl.ENTITY_CACHE_ENABLED,
			BancheAppoggioModelImpl.FINDER_CACHE_ENABLED,
			BancheAppoggioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BancheAppoggioModelImpl.ENTITY_CACHE_ENABLED,
			BancheAppoggioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public BancheAppoggioPersistenceImpl() {
		setModelClass(BancheAppoggio.class);
	}

	/**
	 * Caches the banche appoggio in the entity cache if it is enabled.
	 *
	 * @param bancheAppoggio the banche appoggio
	 */
	@Override
	public void cacheResult(BancheAppoggio bancheAppoggio) {
		EntityCacheUtil.putResult(BancheAppoggioModelImpl.ENTITY_CACHE_ENABLED,
			BancheAppoggioImpl.class, bancheAppoggio.getPrimaryKey(),
			bancheAppoggio);

		bancheAppoggio.resetOriginalValues();
	}

	/**
	 * Caches the banche appoggios in the entity cache if it is enabled.
	 *
	 * @param bancheAppoggios the banche appoggios
	 */
	@Override
	public void cacheResult(List<BancheAppoggio> bancheAppoggios) {
		for (BancheAppoggio bancheAppoggio : bancheAppoggios) {
			if (EntityCacheUtil.getResult(
						BancheAppoggioModelImpl.ENTITY_CACHE_ENABLED,
						BancheAppoggioImpl.class, bancheAppoggio.getPrimaryKey()) == null) {
				cacheResult(bancheAppoggio);
			}
			else {
				bancheAppoggio.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all banche appoggios.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BancheAppoggioImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BancheAppoggioImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the banche appoggio.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BancheAppoggio bancheAppoggio) {
		EntityCacheUtil.removeResult(BancheAppoggioModelImpl.ENTITY_CACHE_ENABLED,
			BancheAppoggioImpl.class, bancheAppoggio.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BancheAppoggio> bancheAppoggios) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BancheAppoggio bancheAppoggio : bancheAppoggios) {
			EntityCacheUtil.removeResult(BancheAppoggioModelImpl.ENTITY_CACHE_ENABLED,
				BancheAppoggioImpl.class, bancheAppoggio.getPrimaryKey());
		}
	}

	/**
	 * Creates a new banche appoggio with the primary key. Does not add the banche appoggio to the database.
	 *
	 * @param codiceBanca the primary key for the new banche appoggio
	 * @return the new banche appoggio
	 */
	@Override
	public BancheAppoggio create(String codiceBanca) {
		BancheAppoggio bancheAppoggio = new BancheAppoggioImpl();

		bancheAppoggio.setNew(true);
		bancheAppoggio.setPrimaryKey(codiceBanca);

		return bancheAppoggio;
	}

	/**
	 * Removes the banche appoggio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param codiceBanca the primary key of the banche appoggio
	 * @return the banche appoggio that was removed
	 * @throws it.bysoftware.ct.NoSuchBancheAppoggioException if a banche appoggio with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BancheAppoggio remove(String codiceBanca)
		throws NoSuchBancheAppoggioException, SystemException {
		return remove((Serializable)codiceBanca);
	}

	/**
	 * Removes the banche appoggio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the banche appoggio
	 * @return the banche appoggio that was removed
	 * @throws it.bysoftware.ct.NoSuchBancheAppoggioException if a banche appoggio with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BancheAppoggio remove(Serializable primaryKey)
		throws NoSuchBancheAppoggioException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BancheAppoggio bancheAppoggio = (BancheAppoggio)session.get(BancheAppoggioImpl.class,
					primaryKey);

			if (bancheAppoggio == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBancheAppoggioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(bancheAppoggio);
		}
		catch (NoSuchBancheAppoggioException nsee) {
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
	protected BancheAppoggio removeImpl(BancheAppoggio bancheAppoggio)
		throws SystemException {
		bancheAppoggio = toUnwrappedModel(bancheAppoggio);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bancheAppoggio)) {
				bancheAppoggio = (BancheAppoggio)session.get(BancheAppoggioImpl.class,
						bancheAppoggio.getPrimaryKeyObj());
			}

			if (bancheAppoggio != null) {
				session.delete(bancheAppoggio);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (bancheAppoggio != null) {
			clearCache(bancheAppoggio);
		}

		return bancheAppoggio;
	}

	@Override
	public BancheAppoggio updateImpl(
		it.bysoftware.ct.model.BancheAppoggio bancheAppoggio)
		throws SystemException {
		bancheAppoggio = toUnwrappedModel(bancheAppoggio);

		boolean isNew = bancheAppoggio.isNew();

		Session session = null;

		try {
			session = openSession();

			if (bancheAppoggio.isNew()) {
				session.save(bancheAppoggio);

				bancheAppoggio.setNew(false);
			}
			else {
				session.merge(bancheAppoggio);
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

		EntityCacheUtil.putResult(BancheAppoggioModelImpl.ENTITY_CACHE_ENABLED,
			BancheAppoggioImpl.class, bancheAppoggio.getPrimaryKey(),
			bancheAppoggio);

		return bancheAppoggio;
	}

	protected BancheAppoggio toUnwrappedModel(BancheAppoggio bancheAppoggio) {
		if (bancheAppoggio instanceof BancheAppoggioImpl) {
			return bancheAppoggio;
		}

		BancheAppoggioImpl bancheAppoggioImpl = new BancheAppoggioImpl();

		bancheAppoggioImpl.setNew(bancheAppoggio.isNew());
		bancheAppoggioImpl.setPrimaryKey(bancheAppoggio.getPrimaryKey());

		bancheAppoggioImpl.setCBanca(bancheAppoggio.getCBanca());
		bancheAppoggioImpl.setCodiceABI(bancheAppoggio.getCodiceABI());
		bancheAppoggioImpl.setCodiceAgenzia(bancheAppoggio.getCodiceAgenzia());
		bancheAppoggioImpl.setCodiceBanca(bancheAppoggio.getCodiceBanca());
		bancheAppoggioImpl.setCodiceCAB(bancheAppoggio.getCodiceCAB());
		bancheAppoggioImpl.setDescrizione(bancheAppoggio.getDescrizione());
		bancheAppoggioImpl.setPiazza(bancheAppoggio.getPiazza());
		bancheAppoggioImpl.setCodiceAzienda(bancheAppoggio.getCodiceAzienda());

		return bancheAppoggioImpl;
	}

	/**
	 * Returns the banche appoggio with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the banche appoggio
	 * @return the banche appoggio
	 * @throws it.bysoftware.ct.NoSuchBancheAppoggioException if a banche appoggio with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BancheAppoggio findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBancheAppoggioException, SystemException {
		BancheAppoggio bancheAppoggio = fetchByPrimaryKey(primaryKey);

		if (bancheAppoggio == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBancheAppoggioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return bancheAppoggio;
	}

	/**
	 * Returns the banche appoggio with the primary key or throws a {@link it.bysoftware.ct.NoSuchBancheAppoggioException} if it could not be found.
	 *
	 * @param codiceBanca the primary key of the banche appoggio
	 * @return the banche appoggio
	 * @throws it.bysoftware.ct.NoSuchBancheAppoggioException if a banche appoggio with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BancheAppoggio findByPrimaryKey(String codiceBanca)
		throws NoSuchBancheAppoggioException, SystemException {
		return findByPrimaryKey((Serializable)codiceBanca);
	}

	/**
	 * Returns the banche appoggio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the banche appoggio
	 * @return the banche appoggio, or <code>null</code> if a banche appoggio with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BancheAppoggio fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BancheAppoggio bancheAppoggio = (BancheAppoggio)EntityCacheUtil.getResult(BancheAppoggioModelImpl.ENTITY_CACHE_ENABLED,
				BancheAppoggioImpl.class, primaryKey);

		if (bancheAppoggio == _nullBancheAppoggio) {
			return null;
		}

		if (bancheAppoggio == null) {
			Session session = null;

			try {
				session = openSession();

				bancheAppoggio = (BancheAppoggio)session.get(BancheAppoggioImpl.class,
						primaryKey);

				if (bancheAppoggio != null) {
					cacheResult(bancheAppoggio);
				}
				else {
					EntityCacheUtil.putResult(BancheAppoggioModelImpl.ENTITY_CACHE_ENABLED,
						BancheAppoggioImpl.class, primaryKey,
						_nullBancheAppoggio);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BancheAppoggioModelImpl.ENTITY_CACHE_ENABLED,
					BancheAppoggioImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return bancheAppoggio;
	}

	/**
	 * Returns the banche appoggio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param codiceBanca the primary key of the banche appoggio
	 * @return the banche appoggio, or <code>null</code> if a banche appoggio with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BancheAppoggio fetchByPrimaryKey(String codiceBanca)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)codiceBanca);
	}

	/**
	 * Returns all the banche appoggios.
	 *
	 * @return the banche appoggios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BancheAppoggio> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the banche appoggios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.BancheAppoggioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of banche appoggios
	 * @param end the upper bound of the range of banche appoggios (not inclusive)
	 * @return the range of banche appoggios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BancheAppoggio> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the banche appoggios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.BancheAppoggioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of banche appoggios
	 * @param end the upper bound of the range of banche appoggios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of banche appoggios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BancheAppoggio> findAll(int start, int end,
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

		List<BancheAppoggio> list = (List<BancheAppoggio>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BANCHEAPPOGGIO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BANCHEAPPOGGIO;

				if (pagination) {
					sql = sql.concat(BancheAppoggioModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BancheAppoggio>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BancheAppoggio>(list);
				}
				else {
					list = (List<BancheAppoggio>)QueryUtil.list(q,
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
	 * Removes all the banche appoggios from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BancheAppoggio bancheAppoggio : findAll()) {
			remove(bancheAppoggio);
		}
	}

	/**
	 * Returns the number of banche appoggios.
	 *
	 * @return the number of banche appoggios
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

				Query q = session.createQuery(_SQL_COUNT_BANCHEAPPOGGIO);

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
	 * Initializes the banche appoggio persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.bysoftware.ct.model.BancheAppoggio")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BancheAppoggio>> listenersList = new ArrayList<ModelListener<BancheAppoggio>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BancheAppoggio>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BancheAppoggioImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BANCHEAPPOGGIO = "SELECT bancheAppoggio FROM BancheAppoggio bancheAppoggio";
	private static final String _SQL_COUNT_BANCHEAPPOGGIO = "SELECT COUNT(bancheAppoggio) FROM BancheAppoggio bancheAppoggio";
	private static final String _ORDER_BY_ENTITY_ALIAS = "bancheAppoggio.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BancheAppoggio exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BancheAppoggioPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"cBanca", "codiceABI", "codiceAgenzia", "codiceBanca",
				"codiceCAB", "descrizione", "piazza", "codiceAzienda"
			});
	private static BancheAppoggio _nullBancheAppoggio = new BancheAppoggioImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BancheAppoggio> toCacheModel() {
				return _nullBancheAppoggioCacheModel;
			}
		};

	private static CacheModel<BancheAppoggio> _nullBancheAppoggioCacheModel = new CacheModel<BancheAppoggio>() {
			@Override
			public BancheAppoggio toEntityModel() {
				return _nullBancheAppoggio;
			}
		};
}
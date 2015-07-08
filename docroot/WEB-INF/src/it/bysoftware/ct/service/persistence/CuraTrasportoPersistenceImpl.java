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

import it.bysoftware.ct.NoSuchCuraTrasportoException;
import it.bysoftware.ct.model.CuraTrasporto;
import it.bysoftware.ct.model.impl.CuraTrasportoImpl;
import it.bysoftware.ct.model.impl.CuraTrasportoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the cura trasporto service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CuraTrasportoPersistence
 * @see CuraTrasportoUtil
 * @generated
 */
public class CuraTrasportoPersistenceImpl extends BasePersistenceImpl<CuraTrasporto>
	implements CuraTrasportoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CuraTrasportoUtil} to access the cura trasporto persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CuraTrasportoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CuraTrasportoModelImpl.ENTITY_CACHE_ENABLED,
			CuraTrasportoModelImpl.FINDER_CACHE_ENABLED,
			CuraTrasportoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CuraTrasportoModelImpl.ENTITY_CACHE_ENABLED,
			CuraTrasportoModelImpl.FINDER_CACHE_ENABLED,
			CuraTrasportoImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CuraTrasportoModelImpl.ENTITY_CACHE_ENABLED,
			CuraTrasportoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public CuraTrasportoPersistenceImpl() {
		setModelClass(CuraTrasporto.class);
	}

	/**
	 * Caches the cura trasporto in the entity cache if it is enabled.
	 *
	 * @param curaTrasporto the cura trasporto
	 */
	@Override
	public void cacheResult(CuraTrasporto curaTrasporto) {
		EntityCacheUtil.putResult(CuraTrasportoModelImpl.ENTITY_CACHE_ENABLED,
			CuraTrasportoImpl.class, curaTrasporto.getPrimaryKey(),
			curaTrasporto);

		curaTrasporto.resetOriginalValues();
	}

	/**
	 * Caches the cura trasportos in the entity cache if it is enabled.
	 *
	 * @param curaTrasportos the cura trasportos
	 */
	@Override
	public void cacheResult(List<CuraTrasporto> curaTrasportos) {
		for (CuraTrasporto curaTrasporto : curaTrasportos) {
			if (EntityCacheUtil.getResult(
						CuraTrasportoModelImpl.ENTITY_CACHE_ENABLED,
						CuraTrasportoImpl.class, curaTrasporto.getPrimaryKey()) == null) {
				cacheResult(curaTrasporto);
			}
			else {
				curaTrasporto.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cura trasportos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CuraTrasportoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CuraTrasportoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cura trasporto.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CuraTrasporto curaTrasporto) {
		EntityCacheUtil.removeResult(CuraTrasportoModelImpl.ENTITY_CACHE_ENABLED,
			CuraTrasportoImpl.class, curaTrasporto.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CuraTrasporto> curaTrasportos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CuraTrasporto curaTrasporto : curaTrasportos) {
			EntityCacheUtil.removeResult(CuraTrasportoModelImpl.ENTITY_CACHE_ENABLED,
				CuraTrasportoImpl.class, curaTrasporto.getPrimaryKey());
		}
	}

	/**
	 * Creates a new cura trasporto with the primary key. Does not add the cura trasporto to the database.
	 *
	 * @param codiceCuraTrasporto the primary key for the new cura trasporto
	 * @return the new cura trasporto
	 */
	@Override
	public CuraTrasporto create(String codiceCuraTrasporto) {
		CuraTrasporto curaTrasporto = new CuraTrasportoImpl();

		curaTrasporto.setNew(true);
		curaTrasporto.setPrimaryKey(codiceCuraTrasporto);

		return curaTrasporto;
	}

	/**
	 * Removes the cura trasporto with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param codiceCuraTrasporto the primary key of the cura trasporto
	 * @return the cura trasporto that was removed
	 * @throws it.bysoftware.ct.NoSuchCuraTrasportoException if a cura trasporto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CuraTrasporto remove(String codiceCuraTrasporto)
		throws NoSuchCuraTrasportoException, SystemException {
		return remove((Serializable)codiceCuraTrasporto);
	}

	/**
	 * Removes the cura trasporto with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cura trasporto
	 * @return the cura trasporto that was removed
	 * @throws it.bysoftware.ct.NoSuchCuraTrasportoException if a cura trasporto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CuraTrasporto remove(Serializable primaryKey)
		throws NoSuchCuraTrasportoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CuraTrasporto curaTrasporto = (CuraTrasporto)session.get(CuraTrasportoImpl.class,
					primaryKey);

			if (curaTrasporto == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCuraTrasportoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(curaTrasporto);
		}
		catch (NoSuchCuraTrasportoException nsee) {
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
	protected CuraTrasporto removeImpl(CuraTrasporto curaTrasporto)
		throws SystemException {
		curaTrasporto = toUnwrappedModel(curaTrasporto);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(curaTrasporto)) {
				curaTrasporto = (CuraTrasporto)session.get(CuraTrasportoImpl.class,
						curaTrasporto.getPrimaryKeyObj());
			}

			if (curaTrasporto != null) {
				session.delete(curaTrasporto);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (curaTrasporto != null) {
			clearCache(curaTrasporto);
		}

		return curaTrasporto;
	}

	@Override
	public CuraTrasporto updateImpl(
		it.bysoftware.ct.model.CuraTrasporto curaTrasporto)
		throws SystemException {
		curaTrasporto = toUnwrappedModel(curaTrasporto);

		boolean isNew = curaTrasporto.isNew();

		Session session = null;

		try {
			session = openSession();

			if (curaTrasporto.isNew()) {
				session.save(curaTrasporto);

				curaTrasporto.setNew(false);
			}
			else {
				session.merge(curaTrasporto);
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

		EntityCacheUtil.putResult(CuraTrasportoModelImpl.ENTITY_CACHE_ENABLED,
			CuraTrasportoImpl.class, curaTrasporto.getPrimaryKey(),
			curaTrasporto);

		return curaTrasporto;
	}

	protected CuraTrasporto toUnwrappedModel(CuraTrasporto curaTrasporto) {
		if (curaTrasporto instanceof CuraTrasportoImpl) {
			return curaTrasporto;
		}

		CuraTrasportoImpl curaTrasportoImpl = new CuraTrasportoImpl();

		curaTrasportoImpl.setNew(curaTrasporto.isNew());
		curaTrasportoImpl.setPrimaryKey(curaTrasporto.getPrimaryKey());

		curaTrasportoImpl.setCodiceCuraTrasporto(curaTrasporto.getCodiceCuraTrasporto());
		curaTrasportoImpl.setDescrizione(curaTrasporto.getDescrizione());
		curaTrasportoImpl.setCodiceAzienda(curaTrasporto.getCodiceAzienda());

		return curaTrasportoImpl;
	}

	/**
	 * Returns the cura trasporto with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the cura trasporto
	 * @return the cura trasporto
	 * @throws it.bysoftware.ct.NoSuchCuraTrasportoException if a cura trasporto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CuraTrasporto findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCuraTrasportoException, SystemException {
		CuraTrasporto curaTrasporto = fetchByPrimaryKey(primaryKey);

		if (curaTrasporto == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCuraTrasportoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return curaTrasporto;
	}

	/**
	 * Returns the cura trasporto with the primary key or throws a {@link it.bysoftware.ct.NoSuchCuraTrasportoException} if it could not be found.
	 *
	 * @param codiceCuraTrasporto the primary key of the cura trasporto
	 * @return the cura trasporto
	 * @throws it.bysoftware.ct.NoSuchCuraTrasportoException if a cura trasporto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CuraTrasporto findByPrimaryKey(String codiceCuraTrasporto)
		throws NoSuchCuraTrasportoException, SystemException {
		return findByPrimaryKey((Serializable)codiceCuraTrasporto);
	}

	/**
	 * Returns the cura trasporto with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cura trasporto
	 * @return the cura trasporto, or <code>null</code> if a cura trasporto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CuraTrasporto fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CuraTrasporto curaTrasporto = (CuraTrasporto)EntityCacheUtil.getResult(CuraTrasportoModelImpl.ENTITY_CACHE_ENABLED,
				CuraTrasportoImpl.class, primaryKey);

		if (curaTrasporto == _nullCuraTrasporto) {
			return null;
		}

		if (curaTrasporto == null) {
			Session session = null;

			try {
				session = openSession();

				curaTrasporto = (CuraTrasporto)session.get(CuraTrasportoImpl.class,
						primaryKey);

				if (curaTrasporto != null) {
					cacheResult(curaTrasporto);
				}
				else {
					EntityCacheUtil.putResult(CuraTrasportoModelImpl.ENTITY_CACHE_ENABLED,
						CuraTrasportoImpl.class, primaryKey, _nullCuraTrasporto);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CuraTrasportoModelImpl.ENTITY_CACHE_ENABLED,
					CuraTrasportoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return curaTrasporto;
	}

	/**
	 * Returns the cura trasporto with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param codiceCuraTrasporto the primary key of the cura trasporto
	 * @return the cura trasporto, or <code>null</code> if a cura trasporto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CuraTrasporto fetchByPrimaryKey(String codiceCuraTrasporto)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)codiceCuraTrasporto);
	}

	/**
	 * Returns all the cura trasportos.
	 *
	 * @return the cura trasportos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CuraTrasporto> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cura trasportos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.CuraTrasportoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cura trasportos
	 * @param end the upper bound of the range of cura trasportos (not inclusive)
	 * @return the range of cura trasportos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CuraTrasporto> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cura trasportos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.CuraTrasportoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cura trasportos
	 * @param end the upper bound of the range of cura trasportos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cura trasportos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CuraTrasporto> findAll(int start, int end,
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

		List<CuraTrasporto> list = (List<CuraTrasporto>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CURATRASPORTO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CURATRASPORTO;

				if (pagination) {
					sql = sql.concat(CuraTrasportoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CuraTrasporto>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CuraTrasporto>(list);
				}
				else {
					list = (List<CuraTrasporto>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the cura trasportos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CuraTrasporto curaTrasporto : findAll()) {
			remove(curaTrasporto);
		}
	}

	/**
	 * Returns the number of cura trasportos.
	 *
	 * @return the number of cura trasportos
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

				Query q = session.createQuery(_SQL_COUNT_CURATRASPORTO);

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
	 * Initializes the cura trasporto persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.bysoftware.ct.model.CuraTrasporto")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CuraTrasporto>> listenersList = new ArrayList<ModelListener<CuraTrasporto>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CuraTrasporto>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CuraTrasportoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CURATRASPORTO = "SELECT curaTrasporto FROM CuraTrasporto curaTrasporto";
	private static final String _SQL_COUNT_CURATRASPORTO = "SELECT COUNT(curaTrasporto) FROM CuraTrasporto curaTrasporto";
	private static final String _ORDER_BY_ENTITY_ALIAS = "curaTrasporto.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CuraTrasporto exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CuraTrasportoPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"codiceCuraTrasporto", "descrizione", "codiceAzienda"
			});
	private static CuraTrasporto _nullCuraTrasporto = new CuraTrasportoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CuraTrasporto> toCacheModel() {
				return _nullCuraTrasportoCacheModel;
			}
		};

	private static CacheModel<CuraTrasporto> _nullCuraTrasportoCacheModel = new CacheModel<CuraTrasporto>() {
			@Override
			public CuraTrasporto toEntityModel() {
				return _nullCuraTrasporto;
			}
		};
}
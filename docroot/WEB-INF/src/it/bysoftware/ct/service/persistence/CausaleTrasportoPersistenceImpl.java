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

import it.bysoftware.ct.NoSuchCausaleTrasportoException;
import it.bysoftware.ct.model.CausaleTrasporto;
import it.bysoftware.ct.model.impl.CausaleTrasportoImpl;
import it.bysoftware.ct.model.impl.CausaleTrasportoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the causale trasporto service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CausaleTrasportoPersistence
 * @see CausaleTrasportoUtil
 * @generated
 */
public class CausaleTrasportoPersistenceImpl extends BasePersistenceImpl<CausaleTrasporto>
	implements CausaleTrasportoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CausaleTrasportoUtil} to access the causale trasporto persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CausaleTrasportoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CausaleTrasportoModelImpl.ENTITY_CACHE_ENABLED,
			CausaleTrasportoModelImpl.FINDER_CACHE_ENABLED,
			CausaleTrasportoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CausaleTrasportoModelImpl.ENTITY_CACHE_ENABLED,
			CausaleTrasportoModelImpl.FINDER_CACHE_ENABLED,
			CausaleTrasportoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CausaleTrasportoModelImpl.ENTITY_CACHE_ENABLED,
			CausaleTrasportoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public CausaleTrasportoPersistenceImpl() {
		setModelClass(CausaleTrasporto.class);
	}

	/**
	 * Caches the causale trasporto in the entity cache if it is enabled.
	 *
	 * @param causaleTrasporto the causale trasporto
	 */
	@Override
	public void cacheResult(CausaleTrasporto causaleTrasporto) {
		EntityCacheUtil.putResult(CausaleTrasportoModelImpl.ENTITY_CACHE_ENABLED,
			CausaleTrasportoImpl.class, causaleTrasporto.getPrimaryKey(),
			causaleTrasporto);

		causaleTrasporto.resetOriginalValues();
	}

	/**
	 * Caches the causale trasportos in the entity cache if it is enabled.
	 *
	 * @param causaleTrasportos the causale trasportos
	 */
	@Override
	public void cacheResult(List<CausaleTrasporto> causaleTrasportos) {
		for (CausaleTrasporto causaleTrasporto : causaleTrasportos) {
			if (EntityCacheUtil.getResult(
						CausaleTrasportoModelImpl.ENTITY_CACHE_ENABLED,
						CausaleTrasportoImpl.class,
						causaleTrasporto.getPrimaryKey()) == null) {
				cacheResult(causaleTrasporto);
			}
			else {
				causaleTrasporto.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all causale trasportos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CausaleTrasportoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CausaleTrasportoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the causale trasporto.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CausaleTrasporto causaleTrasporto) {
		EntityCacheUtil.removeResult(CausaleTrasportoModelImpl.ENTITY_CACHE_ENABLED,
			CausaleTrasportoImpl.class, causaleTrasporto.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CausaleTrasporto> causaleTrasportos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CausaleTrasporto causaleTrasporto : causaleTrasportos) {
			EntityCacheUtil.removeResult(CausaleTrasportoModelImpl.ENTITY_CACHE_ENABLED,
				CausaleTrasportoImpl.class, causaleTrasporto.getPrimaryKey());
		}
	}

	/**
	 * Creates a new causale trasporto with the primary key. Does not add the causale trasporto to the database.
	 *
	 * @param codiceCausaleTrasporto the primary key for the new causale trasporto
	 * @return the new causale trasporto
	 */
	@Override
	public CausaleTrasporto create(String codiceCausaleTrasporto) {
		CausaleTrasporto causaleTrasporto = new CausaleTrasportoImpl();

		causaleTrasporto.setNew(true);
		causaleTrasporto.setPrimaryKey(codiceCausaleTrasporto);

		return causaleTrasporto;
	}

	/**
	 * Removes the causale trasporto with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param codiceCausaleTrasporto the primary key of the causale trasporto
	 * @return the causale trasporto that was removed
	 * @throws it.bysoftware.ct.NoSuchCausaleTrasportoException if a causale trasporto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CausaleTrasporto remove(String codiceCausaleTrasporto)
		throws NoSuchCausaleTrasportoException, SystemException {
		return remove((Serializable)codiceCausaleTrasporto);
	}

	/**
	 * Removes the causale trasporto with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the causale trasporto
	 * @return the causale trasporto that was removed
	 * @throws it.bysoftware.ct.NoSuchCausaleTrasportoException if a causale trasporto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CausaleTrasporto remove(Serializable primaryKey)
		throws NoSuchCausaleTrasportoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CausaleTrasporto causaleTrasporto = (CausaleTrasporto)session.get(CausaleTrasportoImpl.class,
					primaryKey);

			if (causaleTrasporto == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCausaleTrasportoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(causaleTrasporto);
		}
		catch (NoSuchCausaleTrasportoException nsee) {
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
	protected CausaleTrasporto removeImpl(CausaleTrasporto causaleTrasporto)
		throws SystemException {
		causaleTrasporto = toUnwrappedModel(causaleTrasporto);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(causaleTrasporto)) {
				causaleTrasporto = (CausaleTrasporto)session.get(CausaleTrasportoImpl.class,
						causaleTrasporto.getPrimaryKeyObj());
			}

			if (causaleTrasporto != null) {
				session.delete(causaleTrasporto);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (causaleTrasporto != null) {
			clearCache(causaleTrasporto);
		}

		return causaleTrasporto;
	}

	@Override
	public CausaleTrasporto updateImpl(
		it.bysoftware.ct.model.CausaleTrasporto causaleTrasporto)
		throws SystemException {
		causaleTrasporto = toUnwrappedModel(causaleTrasporto);

		boolean isNew = causaleTrasporto.isNew();

		Session session = null;

		try {
			session = openSession();

			if (causaleTrasporto.isNew()) {
				session.save(causaleTrasporto);

				causaleTrasporto.setNew(false);
			}
			else {
				session.merge(causaleTrasporto);
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

		EntityCacheUtil.putResult(CausaleTrasportoModelImpl.ENTITY_CACHE_ENABLED,
			CausaleTrasportoImpl.class, causaleTrasporto.getPrimaryKey(),
			causaleTrasporto);

		return causaleTrasporto;
	}

	protected CausaleTrasporto toUnwrappedModel(
		CausaleTrasporto causaleTrasporto) {
		if (causaleTrasporto instanceof CausaleTrasportoImpl) {
			return causaleTrasporto;
		}

		CausaleTrasportoImpl causaleTrasportoImpl = new CausaleTrasportoImpl();

		causaleTrasportoImpl.setNew(causaleTrasporto.isNew());
		causaleTrasportoImpl.setPrimaryKey(causaleTrasporto.getPrimaryKey());

		causaleTrasportoImpl.setCodiceCausaleTrasporto(causaleTrasporto.getCodiceCausaleTrasporto());
		causaleTrasportoImpl.setDescrizione(causaleTrasporto.getDescrizione());
		causaleTrasportoImpl.setCodiceAzienda(causaleTrasporto.getCodiceAzienda());

		return causaleTrasportoImpl;
	}

	/**
	 * Returns the causale trasporto with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the causale trasporto
	 * @return the causale trasporto
	 * @throws it.bysoftware.ct.NoSuchCausaleTrasportoException if a causale trasporto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CausaleTrasporto findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCausaleTrasportoException, SystemException {
		CausaleTrasporto causaleTrasporto = fetchByPrimaryKey(primaryKey);

		if (causaleTrasporto == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCausaleTrasportoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return causaleTrasporto;
	}

	/**
	 * Returns the causale trasporto with the primary key or throws a {@link it.bysoftware.ct.NoSuchCausaleTrasportoException} if it could not be found.
	 *
	 * @param codiceCausaleTrasporto the primary key of the causale trasporto
	 * @return the causale trasporto
	 * @throws it.bysoftware.ct.NoSuchCausaleTrasportoException if a causale trasporto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CausaleTrasporto findByPrimaryKey(String codiceCausaleTrasporto)
		throws NoSuchCausaleTrasportoException, SystemException {
		return findByPrimaryKey((Serializable)codiceCausaleTrasporto);
	}

	/**
	 * Returns the causale trasporto with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the causale trasporto
	 * @return the causale trasporto, or <code>null</code> if a causale trasporto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CausaleTrasporto fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CausaleTrasporto causaleTrasporto = (CausaleTrasporto)EntityCacheUtil.getResult(CausaleTrasportoModelImpl.ENTITY_CACHE_ENABLED,
				CausaleTrasportoImpl.class, primaryKey);

		if (causaleTrasporto == _nullCausaleTrasporto) {
			return null;
		}

		if (causaleTrasporto == null) {
			Session session = null;

			try {
				session = openSession();

				causaleTrasporto = (CausaleTrasporto)session.get(CausaleTrasportoImpl.class,
						primaryKey);

				if (causaleTrasporto != null) {
					cacheResult(causaleTrasporto);
				}
				else {
					EntityCacheUtil.putResult(CausaleTrasportoModelImpl.ENTITY_CACHE_ENABLED,
						CausaleTrasportoImpl.class, primaryKey,
						_nullCausaleTrasporto);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CausaleTrasportoModelImpl.ENTITY_CACHE_ENABLED,
					CausaleTrasportoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return causaleTrasporto;
	}

	/**
	 * Returns the causale trasporto with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param codiceCausaleTrasporto the primary key of the causale trasporto
	 * @return the causale trasporto, or <code>null</code> if a causale trasporto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CausaleTrasporto fetchByPrimaryKey(String codiceCausaleTrasporto)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)codiceCausaleTrasporto);
	}

	/**
	 * Returns all the causale trasportos.
	 *
	 * @return the causale trasportos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CausaleTrasporto> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the causale trasportos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.CausaleTrasportoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of causale trasportos
	 * @param end the upper bound of the range of causale trasportos (not inclusive)
	 * @return the range of causale trasportos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CausaleTrasporto> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the causale trasportos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.CausaleTrasportoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of causale trasportos
	 * @param end the upper bound of the range of causale trasportos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of causale trasportos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CausaleTrasporto> findAll(int start, int end,
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

		List<CausaleTrasporto> list = (List<CausaleTrasporto>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CAUSALETRASPORTO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CAUSALETRASPORTO;

				if (pagination) {
					sql = sql.concat(CausaleTrasportoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CausaleTrasporto>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CausaleTrasporto>(list);
				}
				else {
					list = (List<CausaleTrasporto>)QueryUtil.list(q,
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
	 * Removes all the causale trasportos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CausaleTrasporto causaleTrasporto : findAll()) {
			remove(causaleTrasporto);
		}
	}

	/**
	 * Returns the number of causale trasportos.
	 *
	 * @return the number of causale trasportos
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

				Query q = session.createQuery(_SQL_COUNT_CAUSALETRASPORTO);

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
	 * Initializes the causale trasporto persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.bysoftware.ct.model.CausaleTrasporto")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CausaleTrasporto>> listenersList = new ArrayList<ModelListener<CausaleTrasporto>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CausaleTrasporto>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CausaleTrasportoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CAUSALETRASPORTO = "SELECT causaleTrasporto FROM CausaleTrasporto causaleTrasporto";
	private static final String _SQL_COUNT_CAUSALETRASPORTO = "SELECT COUNT(causaleTrasporto) FROM CausaleTrasporto causaleTrasporto";
	private static final String _ORDER_BY_ENTITY_ALIAS = "causaleTrasporto.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CausaleTrasporto exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CausaleTrasportoPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"codiceCausaleTrasporto", "descrizione", "codiceAzienda"
			});
	private static CausaleTrasporto _nullCausaleTrasporto = new CausaleTrasportoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CausaleTrasporto> toCacheModel() {
				return _nullCausaleTrasportoCacheModel;
			}
		};

	private static CacheModel<CausaleTrasporto> _nullCausaleTrasportoCacheModel = new CacheModel<CausaleTrasporto>() {
			@Override
			public CausaleTrasporto toEntityModel() {
				return _nullCausaleTrasporto;
			}
		};
}
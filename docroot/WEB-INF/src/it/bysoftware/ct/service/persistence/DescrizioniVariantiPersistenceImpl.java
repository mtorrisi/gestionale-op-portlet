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

import it.bysoftware.ct.NoSuchDescrizioniVariantiException;
import it.bysoftware.ct.model.DescrizioniVarianti;
import it.bysoftware.ct.model.impl.DescrizioniVariantiImpl;
import it.bysoftware.ct.model.impl.DescrizioniVariantiModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the descrizioni varianti service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DescrizioniVariantiPersistence
 * @see DescrizioniVariantiUtil
 * @generated
 */
public class DescrizioniVariantiPersistenceImpl extends BasePersistenceImpl<DescrizioniVarianti>
	implements DescrizioniVariantiPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DescrizioniVariantiUtil} to access the descrizioni varianti persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DescrizioniVariantiImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DescrizioniVariantiModelImpl.ENTITY_CACHE_ENABLED,
			DescrizioniVariantiModelImpl.FINDER_CACHE_ENABLED,
			DescrizioniVariantiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DescrizioniVariantiModelImpl.ENTITY_CACHE_ENABLED,
			DescrizioniVariantiModelImpl.FINDER_CACHE_ENABLED,
			DescrizioniVariantiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DescrizioniVariantiModelImpl.ENTITY_CACHE_ENABLED,
			DescrizioniVariantiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public DescrizioniVariantiPersistenceImpl() {
		setModelClass(DescrizioniVarianti.class);
	}

	/**
	 * Caches the descrizioni varianti in the entity cache if it is enabled.
	 *
	 * @param descrizioniVarianti the descrizioni varianti
	 */
	@Override
	public void cacheResult(DescrizioniVarianti descrizioniVarianti) {
		EntityCacheUtil.putResult(DescrizioniVariantiModelImpl.ENTITY_CACHE_ENABLED,
			DescrizioniVariantiImpl.class, descrizioniVarianti.getPrimaryKey(),
			descrizioniVarianti);

		descrizioniVarianti.resetOriginalValues();
	}

	/**
	 * Caches the descrizioni variantis in the entity cache if it is enabled.
	 *
	 * @param descrizioniVariantis the descrizioni variantis
	 */
	@Override
	public void cacheResult(List<DescrizioniVarianti> descrizioniVariantis) {
		for (DescrizioniVarianti descrizioniVarianti : descrizioniVariantis) {
			if (EntityCacheUtil.getResult(
						DescrizioniVariantiModelImpl.ENTITY_CACHE_ENABLED,
						DescrizioniVariantiImpl.class,
						descrizioniVarianti.getPrimaryKey()) == null) {
				cacheResult(descrizioniVarianti);
			}
			else {
				descrizioniVarianti.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all descrizioni variantis.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DescrizioniVariantiImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DescrizioniVariantiImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the descrizioni varianti.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DescrizioniVarianti descrizioniVarianti) {
		EntityCacheUtil.removeResult(DescrizioniVariantiModelImpl.ENTITY_CACHE_ENABLED,
			DescrizioniVariantiImpl.class, descrizioniVarianti.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DescrizioniVarianti> descrizioniVariantis) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DescrizioniVarianti descrizioniVarianti : descrizioniVariantis) {
			EntityCacheUtil.removeResult(DescrizioniVariantiModelImpl.ENTITY_CACHE_ENABLED,
				DescrizioniVariantiImpl.class,
				descrizioniVarianti.getPrimaryKey());
		}
	}

	/**
	 * Creates a new descrizioni varianti with the primary key. Does not add the descrizioni varianti to the database.
	 *
	 * @param codiceVariante the primary key for the new descrizioni varianti
	 * @return the new descrizioni varianti
	 */
	@Override
	public DescrizioniVarianti create(String codiceVariante) {
		DescrizioniVarianti descrizioniVarianti = new DescrizioniVariantiImpl();

		descrizioniVarianti.setNew(true);
		descrizioniVarianti.setPrimaryKey(codiceVariante);

		return descrizioniVarianti;
	}

	/**
	 * Removes the descrizioni varianti with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param codiceVariante the primary key of the descrizioni varianti
	 * @return the descrizioni varianti that was removed
	 * @throws it.bysoftware.ct.NoSuchDescrizioniVariantiException if a descrizioni varianti with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DescrizioniVarianti remove(String codiceVariante)
		throws NoSuchDescrizioniVariantiException, SystemException {
		return remove((Serializable)codiceVariante);
	}

	/**
	 * Removes the descrizioni varianti with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the descrizioni varianti
	 * @return the descrizioni varianti that was removed
	 * @throws it.bysoftware.ct.NoSuchDescrizioniVariantiException if a descrizioni varianti with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DescrizioniVarianti remove(Serializable primaryKey)
		throws NoSuchDescrizioniVariantiException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DescrizioniVarianti descrizioniVarianti = (DescrizioniVarianti)session.get(DescrizioniVariantiImpl.class,
					primaryKey);

			if (descrizioniVarianti == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDescrizioniVariantiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(descrizioniVarianti);
		}
		catch (NoSuchDescrizioniVariantiException nsee) {
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
	protected DescrizioniVarianti removeImpl(
		DescrizioniVarianti descrizioniVarianti) throws SystemException {
		descrizioniVarianti = toUnwrappedModel(descrizioniVarianti);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(descrizioniVarianti)) {
				descrizioniVarianti = (DescrizioniVarianti)session.get(DescrizioniVariantiImpl.class,
						descrizioniVarianti.getPrimaryKeyObj());
			}

			if (descrizioniVarianti != null) {
				session.delete(descrizioniVarianti);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (descrizioniVarianti != null) {
			clearCache(descrizioniVarianti);
		}

		return descrizioniVarianti;
	}

	@Override
	public DescrizioniVarianti updateImpl(
		it.bysoftware.ct.model.DescrizioniVarianti descrizioniVarianti)
		throws SystemException {
		descrizioniVarianti = toUnwrappedModel(descrizioniVarianti);

		boolean isNew = descrizioniVarianti.isNew();

		Session session = null;

		try {
			session = openSession();

			if (descrizioniVarianti.isNew()) {
				session.save(descrizioniVarianti);

				descrizioniVarianti.setNew(false);
			}
			else {
				session.merge(descrizioniVarianti);
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

		EntityCacheUtil.putResult(DescrizioniVariantiModelImpl.ENTITY_CACHE_ENABLED,
			DescrizioniVariantiImpl.class, descrizioniVarianti.getPrimaryKey(),
			descrizioniVarianti);

		return descrizioniVarianti;
	}

	protected DescrizioniVarianti toUnwrappedModel(
		DescrizioniVarianti descrizioniVarianti) {
		if (descrizioniVarianti instanceof DescrizioniVariantiImpl) {
			return descrizioniVarianti;
		}

		DescrizioniVariantiImpl descrizioniVariantiImpl = new DescrizioniVariantiImpl();

		descrizioniVariantiImpl.setNew(descrizioniVarianti.isNew());
		descrizioniVariantiImpl.setPrimaryKey(descrizioniVarianti.getPrimaryKey());

		descrizioniVariantiImpl.setCodiceVariante(descrizioniVarianti.getCodiceVariante());
		descrizioniVariantiImpl.setDescrizioneVariante(descrizioniVarianti.getDescrizioneVariante());
		descrizioniVariantiImpl.setOrdine(descrizioniVarianti.getOrdine());
		descrizioniVariantiImpl.setTipoVariante(descrizioniVarianti.getTipoVariante());
		descrizioniVariantiImpl.setCodiceAzienda(descrizioniVarianti.getCodiceAzienda());

		return descrizioniVariantiImpl;
	}

	/**
	 * Returns the descrizioni varianti with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the descrizioni varianti
	 * @return the descrizioni varianti
	 * @throws it.bysoftware.ct.NoSuchDescrizioniVariantiException if a descrizioni varianti with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DescrizioniVarianti findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDescrizioniVariantiException, SystemException {
		DescrizioniVarianti descrizioniVarianti = fetchByPrimaryKey(primaryKey);

		if (descrizioniVarianti == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDescrizioniVariantiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return descrizioniVarianti;
	}

	/**
	 * Returns the descrizioni varianti with the primary key or throws a {@link it.bysoftware.ct.NoSuchDescrizioniVariantiException} if it could not be found.
	 *
	 * @param codiceVariante the primary key of the descrizioni varianti
	 * @return the descrizioni varianti
	 * @throws it.bysoftware.ct.NoSuchDescrizioniVariantiException if a descrizioni varianti with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DescrizioniVarianti findByPrimaryKey(String codiceVariante)
		throws NoSuchDescrizioniVariantiException, SystemException {
		return findByPrimaryKey((Serializable)codiceVariante);
	}

	/**
	 * Returns the descrizioni varianti with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the descrizioni varianti
	 * @return the descrizioni varianti, or <code>null</code> if a descrizioni varianti with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DescrizioniVarianti fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DescrizioniVarianti descrizioniVarianti = (DescrizioniVarianti)EntityCacheUtil.getResult(DescrizioniVariantiModelImpl.ENTITY_CACHE_ENABLED,
				DescrizioniVariantiImpl.class, primaryKey);

		if (descrizioniVarianti == _nullDescrizioniVarianti) {
			return null;
		}

		if (descrizioniVarianti == null) {
			Session session = null;

			try {
				session = openSession();

				descrizioniVarianti = (DescrizioniVarianti)session.get(DescrizioniVariantiImpl.class,
						primaryKey);

				if (descrizioniVarianti != null) {
					cacheResult(descrizioniVarianti);
				}
				else {
					EntityCacheUtil.putResult(DescrizioniVariantiModelImpl.ENTITY_CACHE_ENABLED,
						DescrizioniVariantiImpl.class, primaryKey,
						_nullDescrizioniVarianti);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DescrizioniVariantiModelImpl.ENTITY_CACHE_ENABLED,
					DescrizioniVariantiImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return descrizioniVarianti;
	}

	/**
	 * Returns the descrizioni varianti with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param codiceVariante the primary key of the descrizioni varianti
	 * @return the descrizioni varianti, or <code>null</code> if a descrizioni varianti with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DescrizioniVarianti fetchByPrimaryKey(String codiceVariante)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)codiceVariante);
	}

	/**
	 * Returns all the descrizioni variantis.
	 *
	 * @return the descrizioni variantis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DescrizioniVarianti> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the descrizioni variantis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.DescrizioniVariantiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of descrizioni variantis
	 * @param end the upper bound of the range of descrizioni variantis (not inclusive)
	 * @return the range of descrizioni variantis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DescrizioniVarianti> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the descrizioni variantis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.DescrizioniVariantiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of descrizioni variantis
	 * @param end the upper bound of the range of descrizioni variantis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of descrizioni variantis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DescrizioniVarianti> findAll(int start, int end,
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

		List<DescrizioniVarianti> list = (List<DescrizioniVarianti>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DESCRIZIONIVARIANTI);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DESCRIZIONIVARIANTI;

				if (pagination) {
					sql = sql.concat(DescrizioniVariantiModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DescrizioniVarianti>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DescrizioniVarianti>(list);
				}
				else {
					list = (List<DescrizioniVarianti>)QueryUtil.list(q,
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
	 * Removes all the descrizioni variantis from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DescrizioniVarianti descrizioniVarianti : findAll()) {
			remove(descrizioniVarianti);
		}
	}

	/**
	 * Returns the number of descrizioni variantis.
	 *
	 * @return the number of descrizioni variantis
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

				Query q = session.createQuery(_SQL_COUNT_DESCRIZIONIVARIANTI);

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
	 * Initializes the descrizioni varianti persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.bysoftware.ct.model.DescrizioniVarianti")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DescrizioniVarianti>> listenersList = new ArrayList<ModelListener<DescrizioniVarianti>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DescrizioniVarianti>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DescrizioniVariantiImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DESCRIZIONIVARIANTI = "SELECT descrizioniVarianti FROM DescrizioniVarianti descrizioniVarianti";
	private static final String _SQL_COUNT_DESCRIZIONIVARIANTI = "SELECT COUNT(descrizioniVarianti) FROM DescrizioniVarianti descrizioniVarianti";
	private static final String _ORDER_BY_ENTITY_ALIAS = "descrizioniVarianti.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DescrizioniVarianti exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DescrizioniVariantiPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"codiceVariante", "descrizioneVariante", "ordine",
				"tipoVariante", "codiceAzienda"
			});
	private static DescrizioniVarianti _nullDescrizioniVarianti = new DescrizioniVariantiImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DescrizioniVarianti> toCacheModel() {
				return _nullDescrizioniVariantiCacheModel;
			}
		};

	private static CacheModel<DescrizioniVarianti> _nullDescrizioniVariantiCacheModel =
		new CacheModel<DescrizioniVarianti>() {
			@Override
			public DescrizioniVarianti toEntityModel() {
				return _nullDescrizioniVarianti;
			}
		};
}
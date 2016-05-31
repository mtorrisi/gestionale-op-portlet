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

import it.bysoftware.ct.NoSuchAnagraficaAssociatoOPException;
import it.bysoftware.ct.model.AnagraficaAssociatoOP;
import it.bysoftware.ct.model.impl.AnagraficaAssociatoOPImpl;
import it.bysoftware.ct.model.impl.AnagraficaAssociatoOPModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the anagrafica associato o p service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnagraficaAssociatoOPPersistence
 * @see AnagraficaAssociatoOPUtil
 * @generated
 */
public class AnagraficaAssociatoOPPersistenceImpl extends BasePersistenceImpl<AnagraficaAssociatoOP>
	implements AnagraficaAssociatoOPPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AnagraficaAssociatoOPUtil} to access the anagrafica associato o p persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AnagraficaAssociatoOPImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AnagraficaAssociatoOPModelImpl.ENTITY_CACHE_ENABLED,
			AnagraficaAssociatoOPModelImpl.FINDER_CACHE_ENABLED,
			AnagraficaAssociatoOPImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AnagraficaAssociatoOPModelImpl.ENTITY_CACHE_ENABLED,
			AnagraficaAssociatoOPModelImpl.FINDER_CACHE_ENABLED,
			AnagraficaAssociatoOPImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AnagraficaAssociatoOPModelImpl.ENTITY_CACHE_ENABLED,
			AnagraficaAssociatoOPModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public AnagraficaAssociatoOPPersistenceImpl() {
		setModelClass(AnagraficaAssociatoOP.class);
	}

	/**
	 * Caches the anagrafica associato o p in the entity cache if it is enabled.
	 *
	 * @param anagraficaAssociatoOP the anagrafica associato o p
	 */
	@Override
	public void cacheResult(AnagraficaAssociatoOP anagraficaAssociatoOP) {
		EntityCacheUtil.putResult(AnagraficaAssociatoOPModelImpl.ENTITY_CACHE_ENABLED,
			AnagraficaAssociatoOPImpl.class,
			anagraficaAssociatoOP.getPrimaryKey(), anagraficaAssociatoOP);

		anagraficaAssociatoOP.resetOriginalValues();
	}

	/**
	 * Caches the anagrafica associato o ps in the entity cache if it is enabled.
	 *
	 * @param anagraficaAssociatoOPs the anagrafica associato o ps
	 */
	@Override
	public void cacheResult(List<AnagraficaAssociatoOP> anagraficaAssociatoOPs) {
		for (AnagraficaAssociatoOP anagraficaAssociatoOP : anagraficaAssociatoOPs) {
			if (EntityCacheUtil.getResult(
						AnagraficaAssociatoOPModelImpl.ENTITY_CACHE_ENABLED,
						AnagraficaAssociatoOPImpl.class,
						anagraficaAssociatoOP.getPrimaryKey()) == null) {
				cacheResult(anagraficaAssociatoOP);
			}
			else {
				anagraficaAssociatoOP.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all anagrafica associato o ps.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AnagraficaAssociatoOPImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AnagraficaAssociatoOPImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the anagrafica associato o p.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AnagraficaAssociatoOP anagraficaAssociatoOP) {
		EntityCacheUtil.removeResult(AnagraficaAssociatoOPModelImpl.ENTITY_CACHE_ENABLED,
			AnagraficaAssociatoOPImpl.class,
			anagraficaAssociatoOP.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AnagraficaAssociatoOP> anagraficaAssociatoOPs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AnagraficaAssociatoOP anagraficaAssociatoOP : anagraficaAssociatoOPs) {
			EntityCacheUtil.removeResult(AnagraficaAssociatoOPModelImpl.ENTITY_CACHE_ENABLED,
				AnagraficaAssociatoOPImpl.class,
				anagraficaAssociatoOP.getPrimaryKey());
		}
	}

	/**
	 * Creates a new anagrafica associato o p with the primary key. Does not add the anagrafica associato o p to the database.
	 *
	 * @param anagraficaAssociatoOPPK the primary key for the new anagrafica associato o p
	 * @return the new anagrafica associato o p
	 */
	@Override
	public AnagraficaAssociatoOP create(
		AnagraficaAssociatoOPPK anagraficaAssociatoOPPK) {
		AnagraficaAssociatoOP anagraficaAssociatoOP = new AnagraficaAssociatoOPImpl();

		anagraficaAssociatoOP.setNew(true);
		anagraficaAssociatoOP.setPrimaryKey(anagraficaAssociatoOPPK);

		return anagraficaAssociatoOP;
	}

	/**
	 * Removes the anagrafica associato o p with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param anagraficaAssociatoOPPK the primary key of the anagrafica associato o p
	 * @return the anagrafica associato o p that was removed
	 * @throws it.bysoftware.ct.NoSuchAnagraficaAssociatoOPException if a anagrafica associato o p with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnagraficaAssociatoOP remove(
		AnagraficaAssociatoOPPK anagraficaAssociatoOPPK)
		throws NoSuchAnagraficaAssociatoOPException, SystemException {
		return remove((Serializable)anagraficaAssociatoOPPK);
	}

	/**
	 * Removes the anagrafica associato o p with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the anagrafica associato o p
	 * @return the anagrafica associato o p that was removed
	 * @throws it.bysoftware.ct.NoSuchAnagraficaAssociatoOPException if a anagrafica associato o p with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnagraficaAssociatoOP remove(Serializable primaryKey)
		throws NoSuchAnagraficaAssociatoOPException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AnagraficaAssociatoOP anagraficaAssociatoOP = (AnagraficaAssociatoOP)session.get(AnagraficaAssociatoOPImpl.class,
					primaryKey);

			if (anagraficaAssociatoOP == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAnagraficaAssociatoOPException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(anagraficaAssociatoOP);
		}
		catch (NoSuchAnagraficaAssociatoOPException nsee) {
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
	protected AnagraficaAssociatoOP removeImpl(
		AnagraficaAssociatoOP anagraficaAssociatoOP) throws SystemException {
		anagraficaAssociatoOP = toUnwrappedModel(anagraficaAssociatoOP);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(anagraficaAssociatoOP)) {
				anagraficaAssociatoOP = (AnagraficaAssociatoOP)session.get(AnagraficaAssociatoOPImpl.class,
						anagraficaAssociatoOP.getPrimaryKeyObj());
			}

			if (anagraficaAssociatoOP != null) {
				session.delete(anagraficaAssociatoOP);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (anagraficaAssociatoOP != null) {
			clearCache(anagraficaAssociatoOP);
		}

		return anagraficaAssociatoOP;
	}

	@Override
	public AnagraficaAssociatoOP updateImpl(
		it.bysoftware.ct.model.AnagraficaAssociatoOP anagraficaAssociatoOP)
		throws SystemException {
		anagraficaAssociatoOP = toUnwrappedModel(anagraficaAssociatoOP);

		boolean isNew = anagraficaAssociatoOP.isNew();

		Session session = null;

		try {
			session = openSession();

			if (anagraficaAssociatoOP.isNew()) {
				session.save(anagraficaAssociatoOP);

				anagraficaAssociatoOP.setNew(false);
			}
			else {
				session.merge(anagraficaAssociatoOP);
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

		EntityCacheUtil.putResult(AnagraficaAssociatoOPModelImpl.ENTITY_CACHE_ENABLED,
			AnagraficaAssociatoOPImpl.class,
			anagraficaAssociatoOP.getPrimaryKey(), anagraficaAssociatoOP);

		return anagraficaAssociatoOP;
	}

	protected AnagraficaAssociatoOP toUnwrappedModel(
		AnagraficaAssociatoOP anagraficaAssociatoOP) {
		if (anagraficaAssociatoOP instanceof AnagraficaAssociatoOPImpl) {
			return anagraficaAssociatoOP;
		}

		AnagraficaAssociatoOPImpl anagraficaAssociatoOPImpl = new AnagraficaAssociatoOPImpl();

		anagraficaAssociatoOPImpl.setNew(anagraficaAssociatoOP.isNew());
		anagraficaAssociatoOPImpl.setPrimaryKey(anagraficaAssociatoOP.getPrimaryKey());

		anagraficaAssociatoOPImpl.setIdAssociato(anagraficaAssociatoOP.getIdAssociato());
		anagraficaAssociatoOPImpl.setCodiceSogettoAssociato(anagraficaAssociatoOP.getCodiceSogettoAssociato());
		anagraficaAssociatoOPImpl.setCodiceSogettoOP(anagraficaAssociatoOP.getCodiceSogettoOP());

		return anagraficaAssociatoOPImpl;
	}

	/**
	 * Returns the anagrafica associato o p with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the anagrafica associato o p
	 * @return the anagrafica associato o p
	 * @throws it.bysoftware.ct.NoSuchAnagraficaAssociatoOPException if a anagrafica associato o p with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnagraficaAssociatoOP findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAnagraficaAssociatoOPException, SystemException {
		AnagraficaAssociatoOP anagraficaAssociatoOP = fetchByPrimaryKey(primaryKey);

		if (anagraficaAssociatoOP == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAnagraficaAssociatoOPException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return anagraficaAssociatoOP;
	}

	/**
	 * Returns the anagrafica associato o p with the primary key or throws a {@link it.bysoftware.ct.NoSuchAnagraficaAssociatoOPException} if it could not be found.
	 *
	 * @param anagraficaAssociatoOPPK the primary key of the anagrafica associato o p
	 * @return the anagrafica associato o p
	 * @throws it.bysoftware.ct.NoSuchAnagraficaAssociatoOPException if a anagrafica associato o p with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnagraficaAssociatoOP findByPrimaryKey(
		AnagraficaAssociatoOPPK anagraficaAssociatoOPPK)
		throws NoSuchAnagraficaAssociatoOPException, SystemException {
		return findByPrimaryKey((Serializable)anagraficaAssociatoOPPK);
	}

	/**
	 * Returns the anagrafica associato o p with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the anagrafica associato o p
	 * @return the anagrafica associato o p, or <code>null</code> if a anagrafica associato o p with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnagraficaAssociatoOP fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		AnagraficaAssociatoOP anagraficaAssociatoOP = (AnagraficaAssociatoOP)EntityCacheUtil.getResult(AnagraficaAssociatoOPModelImpl.ENTITY_CACHE_ENABLED,
				AnagraficaAssociatoOPImpl.class, primaryKey);

		if (anagraficaAssociatoOP == _nullAnagraficaAssociatoOP) {
			return null;
		}

		if (anagraficaAssociatoOP == null) {
			Session session = null;

			try {
				session = openSession();

				anagraficaAssociatoOP = (AnagraficaAssociatoOP)session.get(AnagraficaAssociatoOPImpl.class,
						primaryKey);

				if (anagraficaAssociatoOP != null) {
					cacheResult(anagraficaAssociatoOP);
				}
				else {
					EntityCacheUtil.putResult(AnagraficaAssociatoOPModelImpl.ENTITY_CACHE_ENABLED,
						AnagraficaAssociatoOPImpl.class, primaryKey,
						_nullAnagraficaAssociatoOP);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AnagraficaAssociatoOPModelImpl.ENTITY_CACHE_ENABLED,
					AnagraficaAssociatoOPImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return anagraficaAssociatoOP;
	}

	/**
	 * Returns the anagrafica associato o p with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param anagraficaAssociatoOPPK the primary key of the anagrafica associato o p
	 * @return the anagrafica associato o p, or <code>null</code> if a anagrafica associato o p with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnagraficaAssociatoOP fetchByPrimaryKey(
		AnagraficaAssociatoOPPK anagraficaAssociatoOPPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)anagraficaAssociatoOPPK);
	}

	/**
	 * Returns all the anagrafica associato o ps.
	 *
	 * @return the anagrafica associato o ps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnagraficaAssociatoOP> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the anagrafica associato o ps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AnagraficaAssociatoOPModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of anagrafica associato o ps
	 * @param end the upper bound of the range of anagrafica associato o ps (not inclusive)
	 * @return the range of anagrafica associato o ps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnagraficaAssociatoOP> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the anagrafica associato o ps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AnagraficaAssociatoOPModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of anagrafica associato o ps
	 * @param end the upper bound of the range of anagrafica associato o ps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of anagrafica associato o ps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnagraficaAssociatoOP> findAll(int start, int end,
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

		List<AnagraficaAssociatoOP> list = (List<AnagraficaAssociatoOP>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ANAGRAFICAASSOCIATOOP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ANAGRAFICAASSOCIATOOP;

				if (pagination) {
					sql = sql.concat(AnagraficaAssociatoOPModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AnagraficaAssociatoOP>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AnagraficaAssociatoOP>(list);
				}
				else {
					list = (List<AnagraficaAssociatoOP>)QueryUtil.list(q,
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
	 * Removes all the anagrafica associato o ps from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (AnagraficaAssociatoOP anagraficaAssociatoOP : findAll()) {
			remove(anagraficaAssociatoOP);
		}
	}

	/**
	 * Returns the number of anagrafica associato o ps.
	 *
	 * @return the number of anagrafica associato o ps
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

				Query q = session.createQuery(_SQL_COUNT_ANAGRAFICAASSOCIATOOP);

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
	 * Initializes the anagrafica associato o p persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.bysoftware.ct.model.AnagraficaAssociatoOP")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AnagraficaAssociatoOP>> listenersList = new ArrayList<ModelListener<AnagraficaAssociatoOP>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AnagraficaAssociatoOP>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AnagraficaAssociatoOPImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ANAGRAFICAASSOCIATOOP = "SELECT anagraficaAssociatoOP FROM AnagraficaAssociatoOP anagraficaAssociatoOP";
	private static final String _SQL_COUNT_ANAGRAFICAASSOCIATOOP = "SELECT COUNT(anagraficaAssociatoOP) FROM AnagraficaAssociatoOP anagraficaAssociatoOP";
	private static final String _ORDER_BY_ENTITY_ALIAS = "anagraficaAssociatoOP.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AnagraficaAssociatoOP exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AnagraficaAssociatoOPPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"idAssociato", "codiceSogettoAssociato", "codiceSogettoOP"
			});
	private static AnagraficaAssociatoOP _nullAnagraficaAssociatoOP = new AnagraficaAssociatoOPImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AnagraficaAssociatoOP> toCacheModel() {
				return _nullAnagraficaAssociatoOPCacheModel;
			}
		};

	private static CacheModel<AnagraficaAssociatoOP> _nullAnagraficaAssociatoOPCacheModel =
		new CacheModel<AnagraficaAssociatoOP>() {
			@Override
			public AnagraficaAssociatoOP toEntityModel() {
				return _nullAnagraficaAssociatoOP;
			}
		};
}
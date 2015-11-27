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
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.bysoftware.ct.NoSuchClientiDatiAggException;
import it.bysoftware.ct.model.ClientiDatiAgg;
import it.bysoftware.ct.model.impl.ClientiDatiAggImpl;
import it.bysoftware.ct.model.impl.ClientiDatiAggModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the clienti dati agg service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClientiDatiAggPersistence
 * @see ClientiDatiAggUtil
 * @generated
 */
public class ClientiDatiAggPersistenceImpl extends BasePersistenceImpl<ClientiDatiAgg>
	implements ClientiDatiAggPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ClientiDatiAggUtil} to access the clienti dati agg persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ClientiDatiAggImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ClientiDatiAggModelImpl.ENTITY_CACHE_ENABLED,
			ClientiDatiAggModelImpl.FINDER_CACHE_ENABLED,
			ClientiDatiAggImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ClientiDatiAggModelImpl.ENTITY_CACHE_ENABLED,
			ClientiDatiAggModelImpl.FINDER_CACHE_ENABLED,
			ClientiDatiAggImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ClientiDatiAggModelImpl.ENTITY_CACHE_ENABLED,
			ClientiDatiAggModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_CODICEANAGRAFICA = new FinderPath(ClientiDatiAggModelImpl.ENTITY_CACHE_ENABLED,
			ClientiDatiAggModelImpl.FINDER_CACHE_ENABLED,
			ClientiDatiAggImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCodiceAnagrafica", new String[] { String.class.getName() },
			ClientiDatiAggModelImpl.CODICEANAGRAFICA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODICEANAGRAFICA = new FinderPath(ClientiDatiAggModelImpl.ENTITY_CACHE_ENABLED,
			ClientiDatiAggModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCodiceAnagrafica", new String[] { String.class.getName() });

	/**
	 * Returns the clienti dati agg where codiceAnagrafica = &#63; or throws a {@link it.bysoftware.ct.NoSuchClientiDatiAggException} if it could not be found.
	 *
	 * @param codiceAnagrafica the codice anagrafica
	 * @return the matching clienti dati agg
	 * @throws it.bysoftware.ct.NoSuchClientiDatiAggException if a matching clienti dati agg could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClientiDatiAgg findByCodiceAnagrafica(String codiceAnagrafica)
		throws NoSuchClientiDatiAggException, SystemException {
		ClientiDatiAgg clientiDatiAgg = fetchByCodiceAnagrafica(codiceAnagrafica);

		if (clientiDatiAgg == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("codiceAnagrafica=");
			msg.append(codiceAnagrafica);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchClientiDatiAggException(msg.toString());
		}

		return clientiDatiAgg;
	}

	/**
	 * Returns the clienti dati agg where codiceAnagrafica = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codiceAnagrafica the codice anagrafica
	 * @return the matching clienti dati agg, or <code>null</code> if a matching clienti dati agg could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClientiDatiAgg fetchByCodiceAnagrafica(String codiceAnagrafica)
		throws SystemException {
		return fetchByCodiceAnagrafica(codiceAnagrafica, true);
	}

	/**
	 * Returns the clienti dati agg where codiceAnagrafica = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codiceAnagrafica the codice anagrafica
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching clienti dati agg, or <code>null</code> if a matching clienti dati agg could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClientiDatiAgg fetchByCodiceAnagrafica(String codiceAnagrafica,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { codiceAnagrafica };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CODICEANAGRAFICA,
					finderArgs, this);
		}

		if (result instanceof ClientiDatiAgg) {
			ClientiDatiAgg clientiDatiAgg = (ClientiDatiAgg)result;

			if (!Validator.equals(codiceAnagrafica,
						clientiDatiAgg.getCodiceAnagrafica())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CLIENTIDATIAGG_WHERE);

			boolean bindCodiceAnagrafica = false;

			if (codiceAnagrafica == null) {
				query.append(_FINDER_COLUMN_CODICEANAGRAFICA_CODICEANAGRAFICA_1);
			}
			else if (codiceAnagrafica.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODICEANAGRAFICA_CODICEANAGRAFICA_3);
			}
			else {
				bindCodiceAnagrafica = true;

				query.append(_FINDER_COLUMN_CODICEANAGRAFICA_CODICEANAGRAFICA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCodiceAnagrafica) {
					qPos.add(codiceAnagrafica);
				}

				List<ClientiDatiAgg> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODICEANAGRAFICA,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ClientiDatiAggPersistenceImpl.fetchByCodiceAnagrafica(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ClientiDatiAgg clientiDatiAgg = list.get(0);

					result = clientiDatiAgg;

					cacheResult(clientiDatiAgg);

					if ((clientiDatiAgg.getCodiceAnagrafica() == null) ||
							!clientiDatiAgg.getCodiceAnagrafica()
											   .equals(codiceAnagrafica)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODICEANAGRAFICA,
							finderArgs, clientiDatiAgg);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODICEANAGRAFICA,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ClientiDatiAgg)result;
		}
	}

	/**
	 * Removes the clienti dati agg where codiceAnagrafica = &#63; from the database.
	 *
	 * @param codiceAnagrafica the codice anagrafica
	 * @return the clienti dati agg that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClientiDatiAgg removeByCodiceAnagrafica(String codiceAnagrafica)
		throws NoSuchClientiDatiAggException, SystemException {
		ClientiDatiAgg clientiDatiAgg = findByCodiceAnagrafica(codiceAnagrafica);

		return remove(clientiDatiAgg);
	}

	/**
	 * Returns the number of clienti dati aggs where codiceAnagrafica = &#63;.
	 *
	 * @param codiceAnagrafica the codice anagrafica
	 * @return the number of matching clienti dati aggs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCodiceAnagrafica(String codiceAnagrafica)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CODICEANAGRAFICA;

		Object[] finderArgs = new Object[] { codiceAnagrafica };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CLIENTIDATIAGG_WHERE);

			boolean bindCodiceAnagrafica = false;

			if (codiceAnagrafica == null) {
				query.append(_FINDER_COLUMN_CODICEANAGRAFICA_CODICEANAGRAFICA_1);
			}
			else if (codiceAnagrafica.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODICEANAGRAFICA_CODICEANAGRAFICA_3);
			}
			else {
				bindCodiceAnagrafica = true;

				query.append(_FINDER_COLUMN_CODICEANAGRAFICA_CODICEANAGRAFICA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCodiceAnagrafica) {
					qPos.add(codiceAnagrafica);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CODICEANAGRAFICA_CODICEANAGRAFICA_1 =
		"clientiDatiAgg.codiceAnagrafica IS NULL";
	private static final String _FINDER_COLUMN_CODICEANAGRAFICA_CODICEANAGRAFICA_2 =
		"clientiDatiAgg.codiceAnagrafica = ?";
	private static final String _FINDER_COLUMN_CODICEANAGRAFICA_CODICEANAGRAFICA_3 =
		"(clientiDatiAgg.codiceAnagrafica IS NULL OR clientiDatiAgg.codiceAnagrafica = '')";

	public ClientiDatiAggPersistenceImpl() {
		setModelClass(ClientiDatiAgg.class);
	}

	/**
	 * Caches the clienti dati agg in the entity cache if it is enabled.
	 *
	 * @param clientiDatiAgg the clienti dati agg
	 */
	@Override
	public void cacheResult(ClientiDatiAgg clientiDatiAgg) {
		EntityCacheUtil.putResult(ClientiDatiAggModelImpl.ENTITY_CACHE_ENABLED,
			ClientiDatiAggImpl.class, clientiDatiAgg.getPrimaryKey(),
			clientiDatiAgg);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODICEANAGRAFICA,
			new Object[] { clientiDatiAgg.getCodiceAnagrafica() },
			clientiDatiAgg);

		clientiDatiAgg.resetOriginalValues();
	}

	/**
	 * Caches the clienti dati aggs in the entity cache if it is enabled.
	 *
	 * @param clientiDatiAggs the clienti dati aggs
	 */
	@Override
	public void cacheResult(List<ClientiDatiAgg> clientiDatiAggs) {
		for (ClientiDatiAgg clientiDatiAgg : clientiDatiAggs) {
			if (EntityCacheUtil.getResult(
						ClientiDatiAggModelImpl.ENTITY_CACHE_ENABLED,
						ClientiDatiAggImpl.class, clientiDatiAgg.getPrimaryKey()) == null) {
				cacheResult(clientiDatiAgg);
			}
			else {
				clientiDatiAgg.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all clienti dati aggs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ClientiDatiAggImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ClientiDatiAggImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the clienti dati agg.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ClientiDatiAgg clientiDatiAgg) {
		EntityCacheUtil.removeResult(ClientiDatiAggModelImpl.ENTITY_CACHE_ENABLED,
			ClientiDatiAggImpl.class, clientiDatiAgg.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(clientiDatiAgg);
	}

	@Override
	public void clearCache(List<ClientiDatiAgg> clientiDatiAggs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ClientiDatiAgg clientiDatiAgg : clientiDatiAggs) {
			EntityCacheUtil.removeResult(ClientiDatiAggModelImpl.ENTITY_CACHE_ENABLED,
				ClientiDatiAggImpl.class, clientiDatiAgg.getPrimaryKey());

			clearUniqueFindersCache(clientiDatiAgg);
		}
	}

	protected void cacheUniqueFindersCache(ClientiDatiAgg clientiDatiAgg) {
		if (clientiDatiAgg.isNew()) {
			Object[] args = new Object[] { clientiDatiAgg.getCodiceAnagrafica() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODICEANAGRAFICA,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODICEANAGRAFICA,
				args, clientiDatiAgg);
		}
		else {
			ClientiDatiAggModelImpl clientiDatiAggModelImpl = (ClientiDatiAggModelImpl)clientiDatiAgg;

			if ((clientiDatiAggModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CODICEANAGRAFICA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						clientiDatiAgg.getCodiceAnagrafica()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODICEANAGRAFICA,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODICEANAGRAFICA,
					args, clientiDatiAgg);
			}
		}
	}

	protected void clearUniqueFindersCache(ClientiDatiAgg clientiDatiAgg) {
		ClientiDatiAggModelImpl clientiDatiAggModelImpl = (ClientiDatiAggModelImpl)clientiDatiAgg;

		Object[] args = new Object[] { clientiDatiAgg.getCodiceAnagrafica() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODICEANAGRAFICA, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODICEANAGRAFICA, args);

		if ((clientiDatiAggModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CODICEANAGRAFICA.getColumnBitmask()) != 0) {
			args = new Object[] {
					clientiDatiAggModelImpl.getOriginalCodiceAnagrafica()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODICEANAGRAFICA,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODICEANAGRAFICA,
				args);
		}
	}

	/**
	 * Creates a new clienti dati agg with the primary key. Does not add the clienti dati agg to the database.
	 *
	 * @param codiceAnagrafica the primary key for the new clienti dati agg
	 * @return the new clienti dati agg
	 */
	@Override
	public ClientiDatiAgg create(String codiceAnagrafica) {
		ClientiDatiAgg clientiDatiAgg = new ClientiDatiAggImpl();

		clientiDatiAgg.setNew(true);
		clientiDatiAgg.setPrimaryKey(codiceAnagrafica);

		return clientiDatiAgg;
	}

	/**
	 * Removes the clienti dati agg with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param codiceAnagrafica the primary key of the clienti dati agg
	 * @return the clienti dati agg that was removed
	 * @throws it.bysoftware.ct.NoSuchClientiDatiAggException if a clienti dati agg with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClientiDatiAgg remove(String codiceAnagrafica)
		throws NoSuchClientiDatiAggException, SystemException {
		return remove((Serializable)codiceAnagrafica);
	}

	/**
	 * Removes the clienti dati agg with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the clienti dati agg
	 * @return the clienti dati agg that was removed
	 * @throws it.bysoftware.ct.NoSuchClientiDatiAggException if a clienti dati agg with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClientiDatiAgg remove(Serializable primaryKey)
		throws NoSuchClientiDatiAggException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ClientiDatiAgg clientiDatiAgg = (ClientiDatiAgg)session.get(ClientiDatiAggImpl.class,
					primaryKey);

			if (clientiDatiAgg == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchClientiDatiAggException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(clientiDatiAgg);
		}
		catch (NoSuchClientiDatiAggException nsee) {
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
	protected ClientiDatiAgg removeImpl(ClientiDatiAgg clientiDatiAgg)
		throws SystemException {
		clientiDatiAgg = toUnwrappedModel(clientiDatiAgg);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(clientiDatiAgg)) {
				clientiDatiAgg = (ClientiDatiAgg)session.get(ClientiDatiAggImpl.class,
						clientiDatiAgg.getPrimaryKeyObj());
			}

			if (clientiDatiAgg != null) {
				session.delete(clientiDatiAgg);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (clientiDatiAgg != null) {
			clearCache(clientiDatiAgg);
		}

		return clientiDatiAgg;
	}

	@Override
	public ClientiDatiAgg updateImpl(
		it.bysoftware.ct.model.ClientiDatiAgg clientiDatiAgg)
		throws SystemException {
		clientiDatiAgg = toUnwrappedModel(clientiDatiAgg);

		boolean isNew = clientiDatiAgg.isNew();

		Session session = null;

		try {
			session = openSession();

			if (clientiDatiAgg.isNew()) {
				session.save(clientiDatiAgg);

				clientiDatiAgg.setNew(false);
			}
			else {
				session.merge(clientiDatiAgg);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ClientiDatiAggModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(ClientiDatiAggModelImpl.ENTITY_CACHE_ENABLED,
			ClientiDatiAggImpl.class, clientiDatiAgg.getPrimaryKey(),
			clientiDatiAgg);

		clearUniqueFindersCache(clientiDatiAgg);
		cacheUniqueFindersCache(clientiDatiAgg);

		return clientiDatiAgg;
	}

	protected ClientiDatiAgg toUnwrappedModel(ClientiDatiAgg clientiDatiAgg) {
		if (clientiDatiAgg instanceof ClientiDatiAggImpl) {
			return clientiDatiAgg;
		}

		ClientiDatiAggImpl clientiDatiAggImpl = new ClientiDatiAggImpl();

		clientiDatiAggImpl.setNew(clientiDatiAgg.isNew());
		clientiDatiAggImpl.setPrimaryKey(clientiDatiAgg.getPrimaryKey());

		clientiDatiAggImpl.setCodiceAnagrafica(clientiDatiAgg.getCodiceAnagrafica());
		clientiDatiAggImpl.setAssociati(clientiDatiAgg.getAssociati());
		clientiDatiAggImpl.setCodiceAliquota(clientiDatiAgg.getCodiceAliquota());

		return clientiDatiAggImpl;
	}

	/**
	 * Returns the clienti dati agg with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the clienti dati agg
	 * @return the clienti dati agg
	 * @throws it.bysoftware.ct.NoSuchClientiDatiAggException if a clienti dati agg with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClientiDatiAgg findByPrimaryKey(Serializable primaryKey)
		throws NoSuchClientiDatiAggException, SystemException {
		ClientiDatiAgg clientiDatiAgg = fetchByPrimaryKey(primaryKey);

		if (clientiDatiAgg == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchClientiDatiAggException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return clientiDatiAgg;
	}

	/**
	 * Returns the clienti dati agg with the primary key or throws a {@link it.bysoftware.ct.NoSuchClientiDatiAggException} if it could not be found.
	 *
	 * @param codiceAnagrafica the primary key of the clienti dati agg
	 * @return the clienti dati agg
	 * @throws it.bysoftware.ct.NoSuchClientiDatiAggException if a clienti dati agg with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClientiDatiAgg findByPrimaryKey(String codiceAnagrafica)
		throws NoSuchClientiDatiAggException, SystemException {
		return findByPrimaryKey((Serializable)codiceAnagrafica);
	}

	/**
	 * Returns the clienti dati agg with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the clienti dati agg
	 * @return the clienti dati agg, or <code>null</code> if a clienti dati agg with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClientiDatiAgg fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ClientiDatiAgg clientiDatiAgg = (ClientiDatiAgg)EntityCacheUtil.getResult(ClientiDatiAggModelImpl.ENTITY_CACHE_ENABLED,
				ClientiDatiAggImpl.class, primaryKey);

		if (clientiDatiAgg == _nullClientiDatiAgg) {
			return null;
		}

		if (clientiDatiAgg == null) {
			Session session = null;

			try {
				session = openSession();

				clientiDatiAgg = (ClientiDatiAgg)session.get(ClientiDatiAggImpl.class,
						primaryKey);

				if (clientiDatiAgg != null) {
					cacheResult(clientiDatiAgg);
				}
				else {
					EntityCacheUtil.putResult(ClientiDatiAggModelImpl.ENTITY_CACHE_ENABLED,
						ClientiDatiAggImpl.class, primaryKey,
						_nullClientiDatiAgg);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ClientiDatiAggModelImpl.ENTITY_CACHE_ENABLED,
					ClientiDatiAggImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return clientiDatiAgg;
	}

	/**
	 * Returns the clienti dati agg with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param codiceAnagrafica the primary key of the clienti dati agg
	 * @return the clienti dati agg, or <code>null</code> if a clienti dati agg with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClientiDatiAgg fetchByPrimaryKey(String codiceAnagrafica)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)codiceAnagrafica);
	}

	/**
	 * Returns all the clienti dati aggs.
	 *
	 * @return the clienti dati aggs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ClientiDatiAgg> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the clienti dati aggs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.ClientiDatiAggModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of clienti dati aggs
	 * @param end the upper bound of the range of clienti dati aggs (not inclusive)
	 * @return the range of clienti dati aggs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ClientiDatiAgg> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the clienti dati aggs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.ClientiDatiAggModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of clienti dati aggs
	 * @param end the upper bound of the range of clienti dati aggs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of clienti dati aggs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ClientiDatiAgg> findAll(int start, int end,
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

		List<ClientiDatiAgg> list = (List<ClientiDatiAgg>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CLIENTIDATIAGG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CLIENTIDATIAGG;

				if (pagination) {
					sql = sql.concat(ClientiDatiAggModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ClientiDatiAgg>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ClientiDatiAgg>(list);
				}
				else {
					list = (List<ClientiDatiAgg>)QueryUtil.list(q,
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
	 * Removes all the clienti dati aggs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ClientiDatiAgg clientiDatiAgg : findAll()) {
			remove(clientiDatiAgg);
		}
	}

	/**
	 * Returns the number of clienti dati aggs.
	 *
	 * @return the number of clienti dati aggs
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

				Query q = session.createQuery(_SQL_COUNT_CLIENTIDATIAGG);

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
	 * Initializes the clienti dati agg persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.bysoftware.ct.model.ClientiDatiAgg")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ClientiDatiAgg>> listenersList = new ArrayList<ModelListener<ClientiDatiAgg>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ClientiDatiAgg>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ClientiDatiAggImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CLIENTIDATIAGG = "SELECT clientiDatiAgg FROM ClientiDatiAgg clientiDatiAgg";
	private static final String _SQL_SELECT_CLIENTIDATIAGG_WHERE = "SELECT clientiDatiAgg FROM ClientiDatiAgg clientiDatiAgg WHERE ";
	private static final String _SQL_COUNT_CLIENTIDATIAGG = "SELECT COUNT(clientiDatiAgg) FROM ClientiDatiAgg clientiDatiAgg";
	private static final String _SQL_COUNT_CLIENTIDATIAGG_WHERE = "SELECT COUNT(clientiDatiAgg) FROM ClientiDatiAgg clientiDatiAgg WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "clientiDatiAgg.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ClientiDatiAgg exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ClientiDatiAgg exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ClientiDatiAggPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"codiceAnagrafica", "associati", "codiceAliquota"
			});
	private static ClientiDatiAgg _nullClientiDatiAgg = new ClientiDatiAggImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ClientiDatiAgg> toCacheModel() {
				return _nullClientiDatiAggCacheModel;
			}
		};

	private static CacheModel<ClientiDatiAgg> _nullClientiDatiAggCacheModel = new CacheModel<ClientiDatiAgg>() {
			@Override
			public ClientiDatiAgg toEntityModel() {
				return _nullClientiDatiAgg;
			}
		};
}
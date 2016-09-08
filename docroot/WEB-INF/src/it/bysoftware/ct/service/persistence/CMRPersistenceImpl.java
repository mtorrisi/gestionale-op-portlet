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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.bysoftware.ct.NoSuchCMRException;
import it.bysoftware.ct.model.CMR;
import it.bysoftware.ct.model.impl.CMRImpl;
import it.bysoftware.ct.model.impl.CMRModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the c m r service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CMRPersistence
 * @see CMRUtil
 * @generated
 */
public class CMRPersistenceImpl extends BasePersistenceImpl<CMR>
	implements CMRPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CMRUtil} to access the c m r persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CMRImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CMRModelImpl.ENTITY_CACHE_ENABLED,
			CMRModelImpl.FINDER_CACHE_ENABLED, CMRImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CMRModelImpl.ENTITY_CACHE_ENABLED,
			CMRModelImpl.FINDER_CACHE_ENABLED, CMRImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CMRModelImpl.ENTITY_CACHE_ENABLED,
			CMRModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_PROGRESSIVO = new FinderPath(CMRModelImpl.ENTITY_CACHE_ENABLED,
			CMRModelImpl.FINDER_CACHE_ENABLED, CMRImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByprogressivo",
			new String[] { Integer.class.getName(), Integer.class.getName() },
			CMRModelImpl.ANNO_COLUMN_BITMASK |
			CMRModelImpl.IDASSOCIATO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROGRESSIVO = new FinderPath(CMRModelImpl.ENTITY_CACHE_ENABLED,
			CMRModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByprogressivo",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	/**
	 * Returns the c m r where anno = &#63; and idAssociato = &#63; or throws a {@link it.bysoftware.ct.NoSuchCMRException} if it could not be found.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @return the matching c m r
	 * @throws it.bysoftware.ct.NoSuchCMRException if a matching c m r could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CMR findByprogressivo(int anno, int idAssociato)
		throws NoSuchCMRException, SystemException {
		CMR cmr = fetchByprogressivo(anno, idAssociato);

		if (cmr == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("anno=");
			msg.append(anno);

			msg.append(", idAssociato=");
			msg.append(idAssociato);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCMRException(msg.toString());
		}

		return cmr;
	}

	/**
	 * Returns the c m r where anno = &#63; and idAssociato = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @return the matching c m r, or <code>null</code> if a matching c m r could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CMR fetchByprogressivo(int anno, int idAssociato)
		throws SystemException {
		return fetchByprogressivo(anno, idAssociato, true);
	}

	/**
	 * Returns the c m r where anno = &#63; and idAssociato = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching c m r, or <code>null</code> if a matching c m r could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CMR fetchByprogressivo(int anno, int idAssociato,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { anno, idAssociato };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PROGRESSIVO,
					finderArgs, this);
		}

		if (result instanceof CMR) {
			CMR cmr = (CMR)result;

			if ((anno != cmr.getAnno()) ||
					(idAssociato != cmr.getIdAssociato())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CMR_WHERE);

			query.append(_FINDER_COLUMN_PROGRESSIVO_ANNO_2);

			query.append(_FINDER_COLUMN_PROGRESSIVO_IDASSOCIATO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(anno);

				qPos.add(idAssociato);

				List<CMR> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROGRESSIVO,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CMRPersistenceImpl.fetchByprogressivo(int, int, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					CMR cmr = list.get(0);

					result = cmr;

					cacheResult(cmr);

					if ((cmr.getAnno() != anno) ||
							(cmr.getIdAssociato() != idAssociato)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROGRESSIVO,
							finderArgs, cmr);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROGRESSIVO,
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
			return (CMR)result;
		}
	}

	/**
	 * Removes the c m r where anno = &#63; and idAssociato = &#63; from the database.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @return the c m r that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CMR removeByprogressivo(int anno, int idAssociato)
		throws NoSuchCMRException, SystemException {
		CMR cmr = findByprogressivo(anno, idAssociato);

		return remove(cmr);
	}

	/**
	 * Returns the number of c m rs where anno = &#63; and idAssociato = &#63;.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @return the number of matching c m rs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByprogressivo(int anno, int idAssociato)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROGRESSIVO;

		Object[] finderArgs = new Object[] { anno, idAssociato };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CMR_WHERE);

			query.append(_FINDER_COLUMN_PROGRESSIVO_ANNO_2);

			query.append(_FINDER_COLUMN_PROGRESSIVO_IDASSOCIATO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(anno);

				qPos.add(idAssociato);

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

	private static final String _FINDER_COLUMN_PROGRESSIVO_ANNO_2 = "cmr.id.anno = ? AND ";
	private static final String _FINDER_COLUMN_PROGRESSIVO_IDASSOCIATO_2 = "cmr.id.idAssociato = ?";

	public CMRPersistenceImpl() {
		setModelClass(CMR.class);
	}

	/**
	 * Caches the c m r in the entity cache if it is enabled.
	 *
	 * @param cmr the c m r
	 */
	@Override
	public void cacheResult(CMR cmr) {
		EntityCacheUtil.putResult(CMRModelImpl.ENTITY_CACHE_ENABLED,
			CMRImpl.class, cmr.getPrimaryKey(), cmr);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROGRESSIVO,
			new Object[] { cmr.getAnno(), cmr.getIdAssociato() }, cmr);

		cmr.resetOriginalValues();
	}

	/**
	 * Caches the c m rs in the entity cache if it is enabled.
	 *
	 * @param cmrs the c m rs
	 */
	@Override
	public void cacheResult(List<CMR> cmrs) {
		for (CMR cmr : cmrs) {
			if (EntityCacheUtil.getResult(CMRModelImpl.ENTITY_CACHE_ENABLED,
						CMRImpl.class, cmr.getPrimaryKey()) == null) {
				cacheResult(cmr);
			}
			else {
				cmr.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all c m rs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CMRImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CMRImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the c m r.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CMR cmr) {
		EntityCacheUtil.removeResult(CMRModelImpl.ENTITY_CACHE_ENABLED,
			CMRImpl.class, cmr.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(cmr);
	}

	@Override
	public void clearCache(List<CMR> cmrs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CMR cmr : cmrs) {
			EntityCacheUtil.removeResult(CMRModelImpl.ENTITY_CACHE_ENABLED,
				CMRImpl.class, cmr.getPrimaryKey());

			clearUniqueFindersCache(cmr);
		}
	}

	protected void cacheUniqueFindersCache(CMR cmr) {
		if (cmr.isNew()) {
			Object[] args = new Object[] { cmr.getAnno(), cmr.getIdAssociato() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROGRESSIVO, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROGRESSIVO, args,
				cmr);
		}
		else {
			CMRModelImpl cmrModelImpl = (CMRModelImpl)cmr;

			if ((cmrModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PROGRESSIVO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { cmr.getAnno(), cmr.getIdAssociato() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROGRESSIVO,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROGRESSIVO,
					args, cmr);
			}
		}
	}

	protected void clearUniqueFindersCache(CMR cmr) {
		CMRModelImpl cmrModelImpl = (CMRModelImpl)cmr;

		Object[] args = new Object[] { cmr.getAnno(), cmr.getIdAssociato() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROGRESSIVO, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROGRESSIVO, args);

		if ((cmrModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PROGRESSIVO.getColumnBitmask()) != 0) {
			args = new Object[] {
					cmrModelImpl.getOriginalAnno(),
					cmrModelImpl.getOriginalIdAssociato()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROGRESSIVO, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROGRESSIVO, args);
		}
	}

	/**
	 * Creates a new c m r with the primary key. Does not add the c m r to the database.
	 *
	 * @param cmrPK the primary key for the new c m r
	 * @return the new c m r
	 */
	@Override
	public CMR create(CMRPK cmrPK) {
		CMR cmr = new CMRImpl();

		cmr.setNew(true);
		cmr.setPrimaryKey(cmrPK);

		return cmr;
	}

	/**
	 * Removes the c m r with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cmrPK the primary key of the c m r
	 * @return the c m r that was removed
	 * @throws it.bysoftware.ct.NoSuchCMRException if a c m r with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CMR remove(CMRPK cmrPK) throws NoSuchCMRException, SystemException {
		return remove((Serializable)cmrPK);
	}

	/**
	 * Removes the c m r with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the c m r
	 * @return the c m r that was removed
	 * @throws it.bysoftware.ct.NoSuchCMRException if a c m r with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CMR remove(Serializable primaryKey)
		throws NoSuchCMRException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CMR cmr = (CMR)session.get(CMRImpl.class, primaryKey);

			if (cmr == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCMRException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(cmr);
		}
		catch (NoSuchCMRException nsee) {
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
	protected CMR removeImpl(CMR cmr) throws SystemException {
		cmr = toUnwrappedModel(cmr);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cmr)) {
				cmr = (CMR)session.get(CMRImpl.class, cmr.getPrimaryKeyObj());
			}

			if (cmr != null) {
				session.delete(cmr);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (cmr != null) {
			clearCache(cmr);
		}

		return cmr;
	}

	@Override
	public CMR updateImpl(it.bysoftware.ct.model.CMR cmr)
		throws SystemException {
		cmr = toUnwrappedModel(cmr);

		boolean isNew = cmr.isNew();

		Session session = null;

		try {
			session = openSession();

			if (cmr.isNew()) {
				session.save(cmr);

				cmr.setNew(false);
			}
			else {
				session.merge(cmr);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CMRModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(CMRModelImpl.ENTITY_CACHE_ENABLED,
			CMRImpl.class, cmr.getPrimaryKey(), cmr);

		clearUniqueFindersCache(cmr);
		cacheUniqueFindersCache(cmr);

		return cmr;
	}

	protected CMR toUnwrappedModel(CMR cmr) {
		if (cmr instanceof CMRImpl) {
			return cmr;
		}

		CMRImpl cmrImpl = new CMRImpl();

		cmrImpl.setNew(cmr.isNew());
		cmrImpl.setPrimaryKey(cmr.getPrimaryKey());

		cmrImpl.setAnno(cmr.getAnno());
		cmrImpl.setNumeroDocumento(cmr.getNumeroDocumento());
		cmrImpl.setIdAssociato(cmr.getIdAssociato());
		cmrImpl.setRiserve(cmr.getRiserve());
		cmrImpl.setAllegati(cmr.getAllegati());
		cmrImpl.setClasse(cmr.getClasse());
		cmrImpl.setCifra(cmr.getCifra());
		cmrImpl.setLettera(cmr.getLettera());
		cmrImpl.setAdr(cmr.getAdr());
		cmrImpl.setIstruzioni(cmr.getIstruzioni());
		cmrImpl.setConvenzioni(cmr.getConvenzioni());
		cmrImpl.setRimborso(cmr.getRimborso());

		return cmrImpl;
	}

	/**
	 * Returns the c m r with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the c m r
	 * @return the c m r
	 * @throws it.bysoftware.ct.NoSuchCMRException if a c m r with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CMR findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCMRException, SystemException {
		CMR cmr = fetchByPrimaryKey(primaryKey);

		if (cmr == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCMRException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return cmr;
	}

	/**
	 * Returns the c m r with the primary key or throws a {@link it.bysoftware.ct.NoSuchCMRException} if it could not be found.
	 *
	 * @param cmrPK the primary key of the c m r
	 * @return the c m r
	 * @throws it.bysoftware.ct.NoSuchCMRException if a c m r with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CMR findByPrimaryKey(CMRPK cmrPK)
		throws NoSuchCMRException, SystemException {
		return findByPrimaryKey((Serializable)cmrPK);
	}

	/**
	 * Returns the c m r with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the c m r
	 * @return the c m r, or <code>null</code> if a c m r with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CMR fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CMR cmr = (CMR)EntityCacheUtil.getResult(CMRModelImpl.ENTITY_CACHE_ENABLED,
				CMRImpl.class, primaryKey);

		if (cmr == _nullCMR) {
			return null;
		}

		if (cmr == null) {
			Session session = null;

			try {
				session = openSession();

				cmr = (CMR)session.get(CMRImpl.class, primaryKey);

				if (cmr != null) {
					cacheResult(cmr);
				}
				else {
					EntityCacheUtil.putResult(CMRModelImpl.ENTITY_CACHE_ENABLED,
						CMRImpl.class, primaryKey, _nullCMR);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CMRModelImpl.ENTITY_CACHE_ENABLED,
					CMRImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return cmr;
	}

	/**
	 * Returns the c m r with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cmrPK the primary key of the c m r
	 * @return the c m r, or <code>null</code> if a c m r with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CMR fetchByPrimaryKey(CMRPK cmrPK) throws SystemException {
		return fetchByPrimaryKey((Serializable)cmrPK);
	}

	/**
	 * Returns all the c m rs.
	 *
	 * @return the c m rs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CMR> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c m rs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.CMRModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of c m rs
	 * @param end the upper bound of the range of c m rs (not inclusive)
	 * @return the range of c m rs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CMR> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the c m rs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.CMRModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of c m rs
	 * @param end the upper bound of the range of c m rs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of c m rs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CMR> findAll(int start, int end,
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

		List<CMR> list = (List<CMR>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CMR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CMR;

				if (pagination) {
					sql = sql.concat(CMRModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CMR>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CMR>(list);
				}
				else {
					list = (List<CMR>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Removes all the c m rs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CMR cmr : findAll()) {
			remove(cmr);
		}
	}

	/**
	 * Returns the number of c m rs.
	 *
	 * @return the number of c m rs
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

				Query q = session.createQuery(_SQL_COUNT_CMR);

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
	 * Initializes the c m r persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.bysoftware.ct.model.CMR")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CMR>> listenersList = new ArrayList<ModelListener<CMR>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CMR>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CMRImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CMR = "SELECT cmr FROM CMR cmr";
	private static final String _SQL_SELECT_CMR_WHERE = "SELECT cmr FROM CMR cmr WHERE ";
	private static final String _SQL_COUNT_CMR = "SELECT COUNT(cmr) FROM CMR cmr";
	private static final String _SQL_COUNT_CMR_WHERE = "SELECT COUNT(cmr) FROM CMR cmr WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cmr.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CMR exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CMR exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CMRPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"numeroDocumento", "idAssociato", "adr"
			});
	private static CMR _nullCMR = new CMRImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CMR> toCacheModel() {
				return _nullCMRCacheModel;
			}
		};

	private static CacheModel<CMR> _nullCMRCacheModel = new CacheModel<CMR>() {
			@Override
			public CMR toEntityModel() {
				return _nullCMR;
			}
		};
}
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

import it.bysoftware.ct.NoSuchCessioneCreditoException;
import it.bysoftware.ct.model.CessioneCredito;
import it.bysoftware.ct.model.impl.CessioneCreditoImpl;
import it.bysoftware.ct.model.impl.CessioneCreditoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the cessione credito service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CessioneCreditoPersistence
 * @see CessioneCreditoUtil
 * @generated
 */
public class CessioneCreditoPersistenceImpl extends BasePersistenceImpl<CessioneCredito>
	implements CessioneCreditoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CessioneCreditoUtil} to access the cessione credito persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CessioneCreditoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CessioneCreditoModelImpl.ENTITY_CACHE_ENABLED,
			CessioneCreditoModelImpl.FINDER_CACHE_ENABLED,
			CessioneCreditoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CessioneCreditoModelImpl.ENTITY_CACHE_ENABLED,
			CessioneCreditoModelImpl.FINDER_CACHE_ENABLED,
			CessioneCreditoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CessioneCreditoModelImpl.ENTITY_CACHE_ENABLED,
			CessioneCreditoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_ANNOASSOCIATONUMEROFATTURA =
		new FinderPath(CessioneCreditoModelImpl.ENTITY_CACHE_ENABLED,
			CessioneCreditoModelImpl.FINDER_CACHE_ENABLED,
			CessioneCreditoImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByAnnoAssociatoNumeroFattura",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			CessioneCreditoModelImpl.ANNO_COLUMN_BITMASK |
			CessioneCreditoModelImpl.IDASSOCIATO_COLUMN_BITMASK |
			CessioneCreditoModelImpl.NUMEROFATTURA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ANNOASSOCIATONUMEROFATTURA =
		new FinderPath(CessioneCreditoModelImpl.ENTITY_CACHE_ENABLED,
			CessioneCreditoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAnnoAssociatoNumeroFattura",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns the cessione credito where anno = &#63; and idAssociato = &#63; and numeroFattura = &#63; or throws a {@link it.bysoftware.ct.NoSuchCessioneCreditoException} if it could not be found.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param numeroFattura the numero fattura
	 * @return the matching cessione credito
	 * @throws it.bysoftware.ct.NoSuchCessioneCreditoException if a matching cessione credito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CessioneCredito findByAnnoAssociatoNumeroFattura(int anno,
		long idAssociato, int numeroFattura)
		throws NoSuchCessioneCreditoException, SystemException {
		CessioneCredito cessioneCredito = fetchByAnnoAssociatoNumeroFattura(anno,
				idAssociato, numeroFattura);

		if (cessioneCredito == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("anno=");
			msg.append(anno);

			msg.append(", idAssociato=");
			msg.append(idAssociato);

			msg.append(", numeroFattura=");
			msg.append(numeroFattura);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCessioneCreditoException(msg.toString());
		}

		return cessioneCredito;
	}

	/**
	 * Returns the cessione credito where anno = &#63; and idAssociato = &#63; and numeroFattura = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param numeroFattura the numero fattura
	 * @return the matching cessione credito, or <code>null</code> if a matching cessione credito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CessioneCredito fetchByAnnoAssociatoNumeroFattura(int anno,
		long idAssociato, int numeroFattura) throws SystemException {
		return fetchByAnnoAssociatoNumeroFattura(anno, idAssociato,
			numeroFattura, true);
	}

	/**
	 * Returns the cessione credito where anno = &#63; and idAssociato = &#63; and numeroFattura = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param numeroFattura the numero fattura
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching cessione credito, or <code>null</code> if a matching cessione credito could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CessioneCredito fetchByAnnoAssociatoNumeroFattura(int anno,
		long idAssociato, int numeroFattura, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { anno, idAssociato, numeroFattura };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ANNOASSOCIATONUMEROFATTURA,
					finderArgs, this);
		}

		if (result instanceof CessioneCredito) {
			CessioneCredito cessioneCredito = (CessioneCredito)result;

			if ((anno != cessioneCredito.getAnno()) ||
					(idAssociato != cessioneCredito.getIdAssociato()) ||
					(numeroFattura != cessioneCredito.getNumeroFattura())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_CESSIONECREDITO_WHERE);

			query.append(_FINDER_COLUMN_ANNOASSOCIATONUMEROFATTURA_ANNO_2);

			query.append(_FINDER_COLUMN_ANNOASSOCIATONUMEROFATTURA_IDASSOCIATO_2);

			query.append(_FINDER_COLUMN_ANNOASSOCIATONUMEROFATTURA_NUMEROFATTURA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(anno);

				qPos.add(idAssociato);

				qPos.add(numeroFattura);

				List<CessioneCredito> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ANNOASSOCIATONUMEROFATTURA,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CessioneCreditoPersistenceImpl.fetchByAnnoAssociatoNumeroFattura(int, long, int, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					CessioneCredito cessioneCredito = list.get(0);

					result = cessioneCredito;

					cacheResult(cessioneCredito);

					if ((cessioneCredito.getAnno() != anno) ||
							(cessioneCredito.getIdAssociato() != idAssociato) ||
							(cessioneCredito.getNumeroFattura() != numeroFattura)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ANNOASSOCIATONUMEROFATTURA,
							finderArgs, cessioneCredito);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ANNOASSOCIATONUMEROFATTURA,
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
			return (CessioneCredito)result;
		}
	}

	/**
	 * Removes the cessione credito where anno = &#63; and idAssociato = &#63; and numeroFattura = &#63; from the database.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param numeroFattura the numero fattura
	 * @return the cessione credito that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CessioneCredito removeByAnnoAssociatoNumeroFattura(int anno,
		long idAssociato, int numeroFattura)
		throws NoSuchCessioneCreditoException, SystemException {
		CessioneCredito cessioneCredito = findByAnnoAssociatoNumeroFattura(anno,
				idAssociato, numeroFattura);

		return remove(cessioneCredito);
	}

	/**
	 * Returns the number of cessione creditos where anno = &#63; and idAssociato = &#63; and numeroFattura = &#63;.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param numeroFattura the numero fattura
	 * @return the number of matching cessione creditos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAnnoAssociatoNumeroFattura(int anno, long idAssociato,
		int numeroFattura) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ANNOASSOCIATONUMEROFATTURA;

		Object[] finderArgs = new Object[] { anno, idAssociato, numeroFattura };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CESSIONECREDITO_WHERE);

			query.append(_FINDER_COLUMN_ANNOASSOCIATONUMEROFATTURA_ANNO_2);

			query.append(_FINDER_COLUMN_ANNOASSOCIATONUMEROFATTURA_IDASSOCIATO_2);

			query.append(_FINDER_COLUMN_ANNOASSOCIATONUMEROFATTURA_NUMEROFATTURA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(anno);

				qPos.add(idAssociato);

				qPos.add(numeroFattura);

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

	private static final String _FINDER_COLUMN_ANNOASSOCIATONUMEROFATTURA_ANNO_2 =
		"cessioneCredito.anno = ? AND ";
	private static final String _FINDER_COLUMN_ANNOASSOCIATONUMEROFATTURA_IDASSOCIATO_2 =
		"cessioneCredito.idAssociato = ? AND ";
	private static final String _FINDER_COLUMN_ANNOASSOCIATONUMEROFATTURA_NUMEROFATTURA_2 =
		"cessioneCredito.numeroFattura = ?";

	public CessioneCreditoPersistenceImpl() {
		setModelClass(CessioneCredito.class);
	}

	/**
	 * Caches the cessione credito in the entity cache if it is enabled.
	 *
	 * @param cessioneCredito the cessione credito
	 */
	@Override
	public void cacheResult(CessioneCredito cessioneCredito) {
		EntityCacheUtil.putResult(CessioneCreditoModelImpl.ENTITY_CACHE_ENABLED,
			CessioneCreditoImpl.class, cessioneCredito.getPrimaryKey(),
			cessioneCredito);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ANNOASSOCIATONUMEROFATTURA,
			new Object[] {
				cessioneCredito.getAnno(), cessioneCredito.getIdAssociato(),
				cessioneCredito.getNumeroFattura()
			}, cessioneCredito);

		cessioneCredito.resetOriginalValues();
	}

	/**
	 * Caches the cessione creditos in the entity cache if it is enabled.
	 *
	 * @param cessioneCreditos the cessione creditos
	 */
	@Override
	public void cacheResult(List<CessioneCredito> cessioneCreditos) {
		for (CessioneCredito cessioneCredito : cessioneCreditos) {
			if (EntityCacheUtil.getResult(
						CessioneCreditoModelImpl.ENTITY_CACHE_ENABLED,
						CessioneCreditoImpl.class,
						cessioneCredito.getPrimaryKey()) == null) {
				cacheResult(cessioneCredito);
			}
			else {
				cessioneCredito.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cessione creditos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CessioneCreditoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CessioneCreditoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cessione credito.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CessioneCredito cessioneCredito) {
		EntityCacheUtil.removeResult(CessioneCreditoModelImpl.ENTITY_CACHE_ENABLED,
			CessioneCreditoImpl.class, cessioneCredito.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(cessioneCredito);
	}

	@Override
	public void clearCache(List<CessioneCredito> cessioneCreditos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CessioneCredito cessioneCredito : cessioneCreditos) {
			EntityCacheUtil.removeResult(CessioneCreditoModelImpl.ENTITY_CACHE_ENABLED,
				CessioneCreditoImpl.class, cessioneCredito.getPrimaryKey());

			clearUniqueFindersCache(cessioneCredito);
		}
	}

	protected void cacheUniqueFindersCache(CessioneCredito cessioneCredito) {
		if (cessioneCredito.isNew()) {
			Object[] args = new Object[] {
					cessioneCredito.getAnno(), cessioneCredito.getIdAssociato(),
					cessioneCredito.getNumeroFattura()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ANNOASSOCIATONUMEROFATTURA,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ANNOASSOCIATONUMEROFATTURA,
				args, cessioneCredito);
		}
		else {
			CessioneCreditoModelImpl cessioneCreditoModelImpl = (CessioneCreditoModelImpl)cessioneCredito;

			if ((cessioneCreditoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ANNOASSOCIATONUMEROFATTURA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cessioneCredito.getAnno(),
						cessioneCredito.getIdAssociato(),
						cessioneCredito.getNumeroFattura()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ANNOASSOCIATONUMEROFATTURA,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ANNOASSOCIATONUMEROFATTURA,
					args, cessioneCredito);
			}
		}
	}

	protected void clearUniqueFindersCache(CessioneCredito cessioneCredito) {
		CessioneCreditoModelImpl cessioneCreditoModelImpl = (CessioneCreditoModelImpl)cessioneCredito;

		Object[] args = new Object[] {
				cessioneCredito.getAnno(), cessioneCredito.getIdAssociato(),
				cessioneCredito.getNumeroFattura()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ANNOASSOCIATONUMEROFATTURA,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ANNOASSOCIATONUMEROFATTURA,
			args);

		if ((cessioneCreditoModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ANNOASSOCIATONUMEROFATTURA.getColumnBitmask()) != 0) {
			args = new Object[] {
					cessioneCreditoModelImpl.getOriginalAnno(),
					cessioneCreditoModelImpl.getOriginalIdAssociato(),
					cessioneCreditoModelImpl.getOriginalNumeroFattura()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ANNOASSOCIATONUMEROFATTURA,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ANNOASSOCIATONUMEROFATTURA,
				args);
		}
	}

	/**
	 * Creates a new cessione credito with the primary key. Does not add the cessione credito to the database.
	 *
	 * @param id the primary key for the new cessione credito
	 * @return the new cessione credito
	 */
	@Override
	public CessioneCredito create(long id) {
		CessioneCredito cessioneCredito = new CessioneCreditoImpl();

		cessioneCredito.setNew(true);
		cessioneCredito.setPrimaryKey(id);

		return cessioneCredito;
	}

	/**
	 * Removes the cessione credito with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the cessione credito
	 * @return the cessione credito that was removed
	 * @throws it.bysoftware.ct.NoSuchCessioneCreditoException if a cessione credito with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CessioneCredito remove(long id)
		throws NoSuchCessioneCreditoException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the cessione credito with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cessione credito
	 * @return the cessione credito that was removed
	 * @throws it.bysoftware.ct.NoSuchCessioneCreditoException if a cessione credito with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CessioneCredito remove(Serializable primaryKey)
		throws NoSuchCessioneCreditoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CessioneCredito cessioneCredito = (CessioneCredito)session.get(CessioneCreditoImpl.class,
					primaryKey);

			if (cessioneCredito == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCessioneCreditoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(cessioneCredito);
		}
		catch (NoSuchCessioneCreditoException nsee) {
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
	protected CessioneCredito removeImpl(CessioneCredito cessioneCredito)
		throws SystemException {
		cessioneCredito = toUnwrappedModel(cessioneCredito);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cessioneCredito)) {
				cessioneCredito = (CessioneCredito)session.get(CessioneCreditoImpl.class,
						cessioneCredito.getPrimaryKeyObj());
			}

			if (cessioneCredito != null) {
				session.delete(cessioneCredito);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (cessioneCredito != null) {
			clearCache(cessioneCredito);
		}

		return cessioneCredito;
	}

	@Override
	public CessioneCredito updateImpl(
		it.bysoftware.ct.model.CessioneCredito cessioneCredito)
		throws SystemException {
		cessioneCredito = toUnwrappedModel(cessioneCredito);

		boolean isNew = cessioneCredito.isNew();

		Session session = null;

		try {
			session = openSession();

			if (cessioneCredito.isNew()) {
				session.save(cessioneCredito);

				cessioneCredito.setNew(false);
			}
			else {
				session.merge(cessioneCredito);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CessioneCreditoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(CessioneCreditoModelImpl.ENTITY_CACHE_ENABLED,
			CessioneCreditoImpl.class, cessioneCredito.getPrimaryKey(),
			cessioneCredito);

		clearUniqueFindersCache(cessioneCredito);
		cacheUniqueFindersCache(cessioneCredito);

		return cessioneCredito;
	}

	protected CessioneCredito toUnwrappedModel(CessioneCredito cessioneCredito) {
		if (cessioneCredito instanceof CessioneCreditoImpl) {
			return cessioneCredito;
		}

		CessioneCreditoImpl cessioneCreditoImpl = new CessioneCreditoImpl();

		cessioneCreditoImpl.setNew(cessioneCredito.isNew());
		cessioneCreditoImpl.setPrimaryKey(cessioneCredito.getPrimaryKey());

		cessioneCreditoImpl.setId(cessioneCredito.getId());
		cessioneCreditoImpl.setData(cessioneCredito.getData());
		cessioneCreditoImpl.setCodiceSoggetto(cessioneCredito.getCodiceSoggetto());
		cessioneCreditoImpl.setIdAssociato(cessioneCredito.getIdAssociato());
		cessioneCreditoImpl.setIdFile(cessioneCredito.getIdFile());
		cessioneCreditoImpl.setAnno(cessioneCredito.getAnno());
		cessioneCreditoImpl.setNumeroFattura(cessioneCredito.getNumeroFattura());
		cessioneCreditoImpl.setTotale(cessioneCredito.getTotale());
		cessioneCreditoImpl.setNote(cessioneCredito.getNote());

		return cessioneCreditoImpl;
	}

	/**
	 * Returns the cessione credito with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the cessione credito
	 * @return the cessione credito
	 * @throws it.bysoftware.ct.NoSuchCessioneCreditoException if a cessione credito with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CessioneCredito findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCessioneCreditoException, SystemException {
		CessioneCredito cessioneCredito = fetchByPrimaryKey(primaryKey);

		if (cessioneCredito == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCessioneCreditoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return cessioneCredito;
	}

	/**
	 * Returns the cessione credito with the primary key or throws a {@link it.bysoftware.ct.NoSuchCessioneCreditoException} if it could not be found.
	 *
	 * @param id the primary key of the cessione credito
	 * @return the cessione credito
	 * @throws it.bysoftware.ct.NoSuchCessioneCreditoException if a cessione credito with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CessioneCredito findByPrimaryKey(long id)
		throws NoSuchCessioneCreditoException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the cessione credito with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cessione credito
	 * @return the cessione credito, or <code>null</code> if a cessione credito with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CessioneCredito fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CessioneCredito cessioneCredito = (CessioneCredito)EntityCacheUtil.getResult(CessioneCreditoModelImpl.ENTITY_CACHE_ENABLED,
				CessioneCreditoImpl.class, primaryKey);

		if (cessioneCredito == _nullCessioneCredito) {
			return null;
		}

		if (cessioneCredito == null) {
			Session session = null;

			try {
				session = openSession();

				cessioneCredito = (CessioneCredito)session.get(CessioneCreditoImpl.class,
						primaryKey);

				if (cessioneCredito != null) {
					cacheResult(cessioneCredito);
				}
				else {
					EntityCacheUtil.putResult(CessioneCreditoModelImpl.ENTITY_CACHE_ENABLED,
						CessioneCreditoImpl.class, primaryKey,
						_nullCessioneCredito);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CessioneCreditoModelImpl.ENTITY_CACHE_ENABLED,
					CessioneCreditoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return cessioneCredito;
	}

	/**
	 * Returns the cessione credito with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the cessione credito
	 * @return the cessione credito, or <code>null</code> if a cessione credito with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CessioneCredito fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the cessione creditos.
	 *
	 * @return the cessione creditos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CessioneCredito> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cessione creditos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.CessioneCreditoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cessione creditos
	 * @param end the upper bound of the range of cessione creditos (not inclusive)
	 * @return the range of cessione creditos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CessioneCredito> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cessione creditos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.CessioneCreditoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cessione creditos
	 * @param end the upper bound of the range of cessione creditos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cessione creditos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CessioneCredito> findAll(int start, int end,
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

		List<CessioneCredito> list = (List<CessioneCredito>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CESSIONECREDITO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CESSIONECREDITO;

				if (pagination) {
					sql = sql.concat(CessioneCreditoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CessioneCredito>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CessioneCredito>(list);
				}
				else {
					list = (List<CessioneCredito>)QueryUtil.list(q,
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
	 * Removes all the cessione creditos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CessioneCredito cessioneCredito : findAll()) {
			remove(cessioneCredito);
		}
	}

	/**
	 * Returns the number of cessione creditos.
	 *
	 * @return the number of cessione creditos
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

				Query q = session.createQuery(_SQL_COUNT_CESSIONECREDITO);

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
	 * Initializes the cessione credito persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.bysoftware.ct.model.CessioneCredito")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CessioneCredito>> listenersList = new ArrayList<ModelListener<CessioneCredito>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CessioneCredito>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CessioneCreditoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CESSIONECREDITO = "SELECT cessioneCredito FROM CessioneCredito cessioneCredito";
	private static final String _SQL_SELECT_CESSIONECREDITO_WHERE = "SELECT cessioneCredito FROM CessioneCredito cessioneCredito WHERE ";
	private static final String _SQL_COUNT_CESSIONECREDITO = "SELECT COUNT(cessioneCredito) FROM CessioneCredito cessioneCredito";
	private static final String _SQL_COUNT_CESSIONECREDITO_WHERE = "SELECT COUNT(cessioneCredito) FROM CessioneCredito cessioneCredito WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cessioneCredito.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CessioneCredito exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CessioneCredito exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CessioneCreditoPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"codiceSoggetto", "idAssociato", "idFile", "numeroFattura"
			});
	private static CessioneCredito _nullCessioneCredito = new CessioneCreditoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CessioneCredito> toCacheModel() {
				return _nullCessioneCreditoCacheModel;
			}
		};

	private static CacheModel<CessioneCredito> _nullCessioneCreditoCacheModel = new CacheModel<CessioneCredito>() {
			@Override
			public CessioneCredito toEntityModel() {
				return _nullCessioneCredito;
			}
		};
}
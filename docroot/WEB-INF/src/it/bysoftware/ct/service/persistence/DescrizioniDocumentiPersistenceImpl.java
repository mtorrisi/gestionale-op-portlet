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

import it.bysoftware.ct.NoSuchDescrizioniDocumentiException;
import it.bysoftware.ct.model.DescrizioniDocumenti;
import it.bysoftware.ct.model.impl.DescrizioniDocumentiImpl;
import it.bysoftware.ct.model.impl.DescrizioniDocumentiModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the descrizioni documenti service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DescrizioniDocumentiPersistence
 * @see DescrizioniDocumentiUtil
 * @generated
 */
public class DescrizioniDocumentiPersistenceImpl extends BasePersistenceImpl<DescrizioniDocumenti>
	implements DescrizioniDocumentiPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DescrizioniDocumentiUtil} to access the descrizioni documenti persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DescrizioniDocumentiImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DescrizioniDocumentiModelImpl.ENTITY_CACHE_ENABLED,
			DescrizioniDocumentiModelImpl.FINDER_CACHE_ENABLED,
			DescrizioniDocumentiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DescrizioniDocumentiModelImpl.ENTITY_CACHE_ENABLED,
			DescrizioniDocumentiModelImpl.FINDER_CACHE_ENABLED,
			DescrizioniDocumentiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DescrizioniDocumentiModelImpl.ENTITY_CACHE_ENABLED,
			DescrizioniDocumentiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public DescrizioniDocumentiPersistenceImpl() {
		setModelClass(DescrizioniDocumenti.class);
	}

	/**
	 * Caches the descrizioni documenti in the entity cache if it is enabled.
	 *
	 * @param descrizioniDocumenti the descrizioni documenti
	 */
	@Override
	public void cacheResult(DescrizioniDocumenti descrizioniDocumenti) {
		EntityCacheUtil.putResult(DescrizioniDocumentiModelImpl.ENTITY_CACHE_ENABLED,
			DescrizioniDocumentiImpl.class,
			descrizioniDocumenti.getPrimaryKey(), descrizioniDocumenti);

		descrizioniDocumenti.resetOriginalValues();
	}

	/**
	 * Caches the descrizioni documentis in the entity cache if it is enabled.
	 *
	 * @param descrizioniDocumentis the descrizioni documentis
	 */
	@Override
	public void cacheResult(List<DescrizioniDocumenti> descrizioniDocumentis) {
		for (DescrizioniDocumenti descrizioniDocumenti : descrizioniDocumentis) {
			if (EntityCacheUtil.getResult(
						DescrizioniDocumentiModelImpl.ENTITY_CACHE_ENABLED,
						DescrizioniDocumentiImpl.class,
						descrizioniDocumenti.getPrimaryKey()) == null) {
				cacheResult(descrizioniDocumenti);
			}
			else {
				descrizioniDocumenti.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all descrizioni documentis.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DescrizioniDocumentiImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DescrizioniDocumentiImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the descrizioni documenti.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DescrizioniDocumenti descrizioniDocumenti) {
		EntityCacheUtil.removeResult(DescrizioniDocumentiModelImpl.ENTITY_CACHE_ENABLED,
			DescrizioniDocumentiImpl.class, descrizioniDocumenti.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DescrizioniDocumenti> descrizioniDocumentis) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DescrizioniDocumenti descrizioniDocumenti : descrizioniDocumentis) {
			EntityCacheUtil.removeResult(DescrizioniDocumentiModelImpl.ENTITY_CACHE_ENABLED,
				DescrizioniDocumentiImpl.class,
				descrizioniDocumenti.getPrimaryKey());
		}
	}

	/**
	 * Creates a new descrizioni documenti with the primary key. Does not add the descrizioni documenti to the database.
	 *
	 * @param codiceDescrizione the primary key for the new descrizioni documenti
	 * @return the new descrizioni documenti
	 */
	@Override
	public DescrizioniDocumenti create(String codiceDescrizione) {
		DescrizioniDocumenti descrizioniDocumenti = new DescrizioniDocumentiImpl();

		descrizioniDocumenti.setNew(true);
		descrizioniDocumenti.setPrimaryKey(codiceDescrizione);

		return descrizioniDocumenti;
	}

	/**
	 * Removes the descrizioni documenti with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param codiceDescrizione the primary key of the descrizioni documenti
	 * @return the descrizioni documenti that was removed
	 * @throws it.bysoftware.ct.NoSuchDescrizioniDocumentiException if a descrizioni documenti with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DescrizioniDocumenti remove(String codiceDescrizione)
		throws NoSuchDescrizioniDocumentiException, SystemException {
		return remove((Serializable)codiceDescrizione);
	}

	/**
	 * Removes the descrizioni documenti with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the descrizioni documenti
	 * @return the descrizioni documenti that was removed
	 * @throws it.bysoftware.ct.NoSuchDescrizioniDocumentiException if a descrizioni documenti with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DescrizioniDocumenti remove(Serializable primaryKey)
		throws NoSuchDescrizioniDocumentiException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DescrizioniDocumenti descrizioniDocumenti = (DescrizioniDocumenti)session.get(DescrizioniDocumentiImpl.class,
					primaryKey);

			if (descrizioniDocumenti == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDescrizioniDocumentiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(descrizioniDocumenti);
		}
		catch (NoSuchDescrizioniDocumentiException nsee) {
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
	protected DescrizioniDocumenti removeImpl(
		DescrizioniDocumenti descrizioniDocumenti) throws SystemException {
		descrizioniDocumenti = toUnwrappedModel(descrizioniDocumenti);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(descrizioniDocumenti)) {
				descrizioniDocumenti = (DescrizioniDocumenti)session.get(DescrizioniDocumentiImpl.class,
						descrizioniDocumenti.getPrimaryKeyObj());
			}

			if (descrizioniDocumenti != null) {
				session.delete(descrizioniDocumenti);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (descrizioniDocumenti != null) {
			clearCache(descrizioniDocumenti);
		}

		return descrizioniDocumenti;
	}

	@Override
	public DescrizioniDocumenti updateImpl(
		it.bysoftware.ct.model.DescrizioniDocumenti descrizioniDocumenti)
		throws SystemException {
		descrizioniDocumenti = toUnwrappedModel(descrizioniDocumenti);

		boolean isNew = descrizioniDocumenti.isNew();

		Session session = null;

		try {
			session = openSession();

			if (descrizioniDocumenti.isNew()) {
				session.save(descrizioniDocumenti);

				descrizioniDocumenti.setNew(false);
			}
			else {
				session.merge(descrizioniDocumenti);
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

		EntityCacheUtil.putResult(DescrizioniDocumentiModelImpl.ENTITY_CACHE_ENABLED,
			DescrizioniDocumentiImpl.class,
			descrizioniDocumenti.getPrimaryKey(), descrizioniDocumenti);

		return descrizioniDocumenti;
	}

	protected DescrizioniDocumenti toUnwrappedModel(
		DescrizioniDocumenti descrizioniDocumenti) {
		if (descrizioniDocumenti instanceof DescrizioniDocumentiImpl) {
			return descrizioniDocumenti;
		}

		DescrizioniDocumentiImpl descrizioniDocumentiImpl = new DescrizioniDocumentiImpl();

		descrizioniDocumentiImpl.setNew(descrizioniDocumenti.isNew());
		descrizioniDocumentiImpl.setPrimaryKey(descrizioniDocumenti.getPrimaryKey());

		descrizioniDocumentiImpl.setCodiceDescrizione(descrizioniDocumenti.getCodiceDescrizione());
		descrizioniDocumentiImpl.setCodiceIVA(descrizioniDocumenti.getCodiceIVA());
		descrizioniDocumentiImpl.setDescrizione(descrizioniDocumenti.getDescrizione());
		descrizioniDocumentiImpl.setDescrizioneFiscale(descrizioniDocumenti.getDescrizioneFiscale());
		descrizioniDocumentiImpl.setCodiceAzienda(descrizioniDocumenti.getCodiceAzienda());

		return descrizioniDocumentiImpl;
	}

	/**
	 * Returns the descrizioni documenti with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the descrizioni documenti
	 * @return the descrizioni documenti
	 * @throws it.bysoftware.ct.NoSuchDescrizioniDocumentiException if a descrizioni documenti with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DescrizioniDocumenti findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDescrizioniDocumentiException, SystemException {
		DescrizioniDocumenti descrizioniDocumenti = fetchByPrimaryKey(primaryKey);

		if (descrizioniDocumenti == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDescrizioniDocumentiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return descrizioniDocumenti;
	}

	/**
	 * Returns the descrizioni documenti with the primary key or throws a {@link it.bysoftware.ct.NoSuchDescrizioniDocumentiException} if it could not be found.
	 *
	 * @param codiceDescrizione the primary key of the descrizioni documenti
	 * @return the descrizioni documenti
	 * @throws it.bysoftware.ct.NoSuchDescrizioniDocumentiException if a descrizioni documenti with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DescrizioniDocumenti findByPrimaryKey(String codiceDescrizione)
		throws NoSuchDescrizioniDocumentiException, SystemException {
		return findByPrimaryKey((Serializable)codiceDescrizione);
	}

	/**
	 * Returns the descrizioni documenti with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the descrizioni documenti
	 * @return the descrizioni documenti, or <code>null</code> if a descrizioni documenti with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DescrizioniDocumenti fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DescrizioniDocumenti descrizioniDocumenti = (DescrizioniDocumenti)EntityCacheUtil.getResult(DescrizioniDocumentiModelImpl.ENTITY_CACHE_ENABLED,
				DescrizioniDocumentiImpl.class, primaryKey);

		if (descrizioniDocumenti == _nullDescrizioniDocumenti) {
			return null;
		}

		if (descrizioniDocumenti == null) {
			Session session = null;

			try {
				session = openSession();

				descrizioniDocumenti = (DescrizioniDocumenti)session.get(DescrizioniDocumentiImpl.class,
						primaryKey);

				if (descrizioniDocumenti != null) {
					cacheResult(descrizioniDocumenti);
				}
				else {
					EntityCacheUtil.putResult(DescrizioniDocumentiModelImpl.ENTITY_CACHE_ENABLED,
						DescrizioniDocumentiImpl.class, primaryKey,
						_nullDescrizioniDocumenti);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DescrizioniDocumentiModelImpl.ENTITY_CACHE_ENABLED,
					DescrizioniDocumentiImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return descrizioniDocumenti;
	}

	/**
	 * Returns the descrizioni documenti with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param codiceDescrizione the primary key of the descrizioni documenti
	 * @return the descrizioni documenti, or <code>null</code> if a descrizioni documenti with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DescrizioniDocumenti fetchByPrimaryKey(String codiceDescrizione)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)codiceDescrizione);
	}

	/**
	 * Returns all the descrizioni documentis.
	 *
	 * @return the descrizioni documentis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DescrizioniDocumenti> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the descrizioni documentis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.DescrizioniDocumentiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of descrizioni documentis
	 * @param end the upper bound of the range of descrizioni documentis (not inclusive)
	 * @return the range of descrizioni documentis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DescrizioniDocumenti> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the descrizioni documentis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.DescrizioniDocumentiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of descrizioni documentis
	 * @param end the upper bound of the range of descrizioni documentis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of descrizioni documentis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DescrizioniDocumenti> findAll(int start, int end,
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

		List<DescrizioniDocumenti> list = (List<DescrizioniDocumenti>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DESCRIZIONIDOCUMENTI);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DESCRIZIONIDOCUMENTI;

				if (pagination) {
					sql = sql.concat(DescrizioniDocumentiModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DescrizioniDocumenti>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DescrizioniDocumenti>(list);
				}
				else {
					list = (List<DescrizioniDocumenti>)QueryUtil.list(q,
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
	 * Removes all the descrizioni documentis from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DescrizioniDocumenti descrizioniDocumenti : findAll()) {
			remove(descrizioniDocumenti);
		}
	}

	/**
	 * Returns the number of descrizioni documentis.
	 *
	 * @return the number of descrizioni documentis
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

				Query q = session.createQuery(_SQL_COUNT_DESCRIZIONIDOCUMENTI);

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
	 * Initializes the descrizioni documenti persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.bysoftware.ct.model.DescrizioniDocumenti")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DescrizioniDocumenti>> listenersList = new ArrayList<ModelListener<DescrizioniDocumenti>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DescrizioniDocumenti>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DescrizioniDocumentiImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DESCRIZIONIDOCUMENTI = "SELECT descrizioniDocumenti FROM DescrizioniDocumenti descrizioniDocumenti";
	private static final String _SQL_COUNT_DESCRIZIONIDOCUMENTI = "SELECT COUNT(descrizioniDocumenti) FROM DescrizioniDocumenti descrizioniDocumenti";
	private static final String _ORDER_BY_ENTITY_ALIAS = "descrizioniDocumenti.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DescrizioniDocumenti exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DescrizioniDocumentiPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"codiceDescrizione", "codiceIVA", "descrizione",
				"descrizioneFiscale", "codiceAzienda"
			});
	private static DescrizioniDocumenti _nullDescrizioniDocumenti = new DescrizioniDocumentiImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DescrizioniDocumenti> toCacheModel() {
				return _nullDescrizioniDocumentiCacheModel;
			}
		};

	private static CacheModel<DescrizioniDocumenti> _nullDescrizioniDocumentiCacheModel =
		new CacheModel<DescrizioniDocumenti>() {
			@Override
			public DescrizioniDocumenti toEntityModel() {
				return _nullDescrizioniDocumenti;
			}
		};
}
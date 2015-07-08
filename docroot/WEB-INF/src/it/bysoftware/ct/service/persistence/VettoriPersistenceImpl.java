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

import it.bysoftware.ct.NoSuchVettoriException;
import it.bysoftware.ct.model.Vettori;
import it.bysoftware.ct.model.impl.VettoriImpl;
import it.bysoftware.ct.model.impl.VettoriModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the vettori service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VettoriPersistence
 * @see VettoriUtil
 * @generated
 */
public class VettoriPersistenceImpl extends BasePersistenceImpl<Vettori>
	implements VettoriPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VettoriUtil} to access the vettori persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VettoriImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VettoriModelImpl.ENTITY_CACHE_ENABLED,
			VettoriModelImpl.FINDER_CACHE_ENABLED, VettoriImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VettoriModelImpl.ENTITY_CACHE_ENABLED,
			VettoriModelImpl.FINDER_CACHE_ENABLED, VettoriImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VettoriModelImpl.ENTITY_CACHE_ENABLED,
			VettoriModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public VettoriPersistenceImpl() {
		setModelClass(Vettori.class);
	}

	/**
	 * Caches the vettori in the entity cache if it is enabled.
	 *
	 * @param vettori the vettori
	 */
	@Override
	public void cacheResult(Vettori vettori) {
		EntityCacheUtil.putResult(VettoriModelImpl.ENTITY_CACHE_ENABLED,
			VettoriImpl.class, vettori.getPrimaryKey(), vettori);

		vettori.resetOriginalValues();
	}

	/**
	 * Caches the vettoris in the entity cache if it is enabled.
	 *
	 * @param vettoris the vettoris
	 */
	@Override
	public void cacheResult(List<Vettori> vettoris) {
		for (Vettori vettori : vettoris) {
			if (EntityCacheUtil.getResult(
						VettoriModelImpl.ENTITY_CACHE_ENABLED,
						VettoriImpl.class, vettori.getPrimaryKey()) == null) {
				cacheResult(vettori);
			}
			else {
				vettori.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vettoris.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VettoriImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VettoriImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vettori.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Vettori vettori) {
		EntityCacheUtil.removeResult(VettoriModelImpl.ENTITY_CACHE_ENABLED,
			VettoriImpl.class, vettori.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Vettori> vettoris) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Vettori vettori : vettoris) {
			EntityCacheUtil.removeResult(VettoriModelImpl.ENTITY_CACHE_ENABLED,
				VettoriImpl.class, vettori.getPrimaryKey());
		}
	}

	/**
	 * Creates a new vettori with the primary key. Does not add the vettori to the database.
	 *
	 * @param codiceVettore the primary key for the new vettori
	 * @return the new vettori
	 */
	@Override
	public Vettori create(String codiceVettore) {
		Vettori vettori = new VettoriImpl();

		vettori.setNew(true);
		vettori.setPrimaryKey(codiceVettore);

		return vettori;
	}

	/**
	 * Removes the vettori with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param codiceVettore the primary key of the vettori
	 * @return the vettori that was removed
	 * @throws it.bysoftware.ct.NoSuchVettoriException if a vettori with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vettori remove(String codiceVettore)
		throws NoSuchVettoriException, SystemException {
		return remove((Serializable)codiceVettore);
	}

	/**
	 * Removes the vettori with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vettori
	 * @return the vettori that was removed
	 * @throws it.bysoftware.ct.NoSuchVettoriException if a vettori with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vettori remove(Serializable primaryKey)
		throws NoSuchVettoriException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Vettori vettori = (Vettori)session.get(VettoriImpl.class, primaryKey);

			if (vettori == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVettoriException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vettori);
		}
		catch (NoSuchVettoriException nsee) {
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
	protected Vettori removeImpl(Vettori vettori) throws SystemException {
		vettori = toUnwrappedModel(vettori);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vettori)) {
				vettori = (Vettori)session.get(VettoriImpl.class,
						vettori.getPrimaryKeyObj());
			}

			if (vettori != null) {
				session.delete(vettori);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vettori != null) {
			clearCache(vettori);
		}

		return vettori;
	}

	@Override
	public Vettori updateImpl(it.bysoftware.ct.model.Vettori vettori)
		throws SystemException {
		vettori = toUnwrappedModel(vettori);

		boolean isNew = vettori.isNew();

		Session session = null;

		try {
			session = openSession();

			if (vettori.isNew()) {
				session.save(vettori);

				vettori.setNew(false);
			}
			else {
				session.merge(vettori);
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

		EntityCacheUtil.putResult(VettoriModelImpl.ENTITY_CACHE_ENABLED,
			VettoriImpl.class, vettori.getPrimaryKey(), vettori);

		return vettori;
	}

	protected Vettori toUnwrappedModel(Vettori vettori) {
		if (vettori instanceof VettoriImpl) {
			return vettori;
		}

		VettoriImpl vettoriImpl = new VettoriImpl();

		vettoriImpl.setNew(vettori.isNew());
		vettoriImpl.setPrimaryKey(vettori.getPrimaryKey());

		vettoriImpl.setAlbo(vettori.getAlbo());
		vettoriImpl.setCAP(vettori.getCAP());
		vettoriImpl.setCodiceVettore(vettori.getCodiceVettore());
		vettoriImpl.setCodiceFiscale(vettori.getCodiceFiscale());
		vettoriImpl.setCodiceRiferimento(vettori.getCodiceRiferimento());
		vettoriImpl.setComune(vettori.getComune());
		vettoriImpl.setIndirizzo(vettori.getIndirizzo());
		vettoriImpl.setNote(vettori.getNote());
		vettoriImpl.setPartitaIVA(vettori.getPartitaIVA());
		vettoriImpl.setRagioneSociale(vettori.getRagioneSociale());
		vettoriImpl.setRagioneSociale2(vettori.getRagioneSociale2());
		vettoriImpl.setProvincia(vettori.getProvincia());
		vettoriImpl.setStato(vettori.getStato());
		vettoriImpl.setTipoAnagrafica(vettori.getTipoAnagrafica());
		vettoriImpl.setCodiceAzienda(vettori.getCodiceAzienda());

		return vettoriImpl;
	}

	/**
	 * Returns the vettori with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vettori
	 * @return the vettori
	 * @throws it.bysoftware.ct.NoSuchVettoriException if a vettori with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vettori findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVettoriException, SystemException {
		Vettori vettori = fetchByPrimaryKey(primaryKey);

		if (vettori == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVettoriException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return vettori;
	}

	/**
	 * Returns the vettori with the primary key or throws a {@link it.bysoftware.ct.NoSuchVettoriException} if it could not be found.
	 *
	 * @param codiceVettore the primary key of the vettori
	 * @return the vettori
	 * @throws it.bysoftware.ct.NoSuchVettoriException if a vettori with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vettori findByPrimaryKey(String codiceVettore)
		throws NoSuchVettoriException, SystemException {
		return findByPrimaryKey((Serializable)codiceVettore);
	}

	/**
	 * Returns the vettori with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vettori
	 * @return the vettori, or <code>null</code> if a vettori with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vettori fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Vettori vettori = (Vettori)EntityCacheUtil.getResult(VettoriModelImpl.ENTITY_CACHE_ENABLED,
				VettoriImpl.class, primaryKey);

		if (vettori == _nullVettori) {
			return null;
		}

		if (vettori == null) {
			Session session = null;

			try {
				session = openSession();

				vettori = (Vettori)session.get(VettoriImpl.class, primaryKey);

				if (vettori != null) {
					cacheResult(vettori);
				}
				else {
					EntityCacheUtil.putResult(VettoriModelImpl.ENTITY_CACHE_ENABLED,
						VettoriImpl.class, primaryKey, _nullVettori);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VettoriModelImpl.ENTITY_CACHE_ENABLED,
					VettoriImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return vettori;
	}

	/**
	 * Returns the vettori with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param codiceVettore the primary key of the vettori
	 * @return the vettori, or <code>null</code> if a vettori with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vettori fetchByPrimaryKey(String codiceVettore)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)codiceVettore);
	}

	/**
	 * Returns all the vettoris.
	 *
	 * @return the vettoris
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Vettori> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vettoris.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.VettoriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vettoris
	 * @param end the upper bound of the range of vettoris (not inclusive)
	 * @return the range of vettoris
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Vettori> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vettoris.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.VettoriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vettoris
	 * @param end the upper bound of the range of vettoris (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vettoris
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Vettori> findAll(int start, int end,
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

		List<Vettori> list = (List<Vettori>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VETTORI);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VETTORI;

				if (pagination) {
					sql = sql.concat(VettoriModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Vettori>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Vettori>(list);
				}
				else {
					list = (List<Vettori>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the vettoris from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Vettori vettori : findAll()) {
			remove(vettori);
		}
	}

	/**
	 * Returns the number of vettoris.
	 *
	 * @return the number of vettoris
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

				Query q = session.createQuery(_SQL_COUNT_VETTORI);

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
	 * Initializes the vettori persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.bysoftware.ct.model.Vettori")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Vettori>> listenersList = new ArrayList<ModelListener<Vettori>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Vettori>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VettoriImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VETTORI = "SELECT vettori FROM Vettori vettori";
	private static final String _SQL_COUNT_VETTORI = "SELECT COUNT(vettori) FROM Vettori vettori";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vettori.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Vettori exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VettoriPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"albo", "CAP", "codiceVettore", "codiceFiscale",
				"codiceRiferimento", "comune", "indirizzo", "note", "partitaIVA",
				"ragioneSociale", "ragioneSociale2", "provincia", "stato",
				"tipoAnagrafica", "codiceAzienda"
			});
	private static Vettori _nullVettori = new VettoriImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Vettori> toCacheModel() {
				return _nullVettoriCacheModel;
			}
		};

	private static CacheModel<Vettori> _nullVettoriCacheModel = new CacheModel<Vettori>() {
			@Override
			public Vettori toEntityModel() {
				return _nullVettori;
			}
		};
}
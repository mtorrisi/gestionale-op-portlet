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

import it.bysoftware.ct.NoSuchIvaException;
import it.bysoftware.ct.model.Iva;
import it.bysoftware.ct.model.impl.IvaImpl;
import it.bysoftware.ct.model.impl.IvaModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the iva service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IvaPersistence
 * @see IvaUtil
 * @generated
 */
public class IvaPersistenceImpl extends BasePersistenceImpl<Iva>
	implements IvaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link IvaUtil} to access the iva persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = IvaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(IvaModelImpl.ENTITY_CACHE_ENABLED,
			IvaModelImpl.FINDER_CACHE_ENABLED, IvaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(IvaModelImpl.ENTITY_CACHE_ENABLED,
			IvaModelImpl.FINDER_CACHE_ENABLED, IvaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(IvaModelImpl.ENTITY_CACHE_ENABLED,
			IvaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public IvaPersistenceImpl() {
		setModelClass(Iva.class);
	}

	/**
	 * Caches the iva in the entity cache if it is enabled.
	 *
	 * @param iva the iva
	 */
	@Override
	public void cacheResult(Iva iva) {
		EntityCacheUtil.putResult(IvaModelImpl.ENTITY_CACHE_ENABLED,
			IvaImpl.class, iva.getPrimaryKey(), iva);

		iva.resetOriginalValues();
	}

	/**
	 * Caches the ivas in the entity cache if it is enabled.
	 *
	 * @param ivas the ivas
	 */
	@Override
	public void cacheResult(List<Iva> ivas) {
		for (Iva iva : ivas) {
			if (EntityCacheUtil.getResult(IvaModelImpl.ENTITY_CACHE_ENABLED,
						IvaImpl.class, iva.getPrimaryKey()) == null) {
				cacheResult(iva);
			}
			else {
				iva.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ivas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(IvaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(IvaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the iva.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Iva iva) {
		EntityCacheUtil.removeResult(IvaModelImpl.ENTITY_CACHE_ENABLED,
			IvaImpl.class, iva.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Iva> ivas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Iva iva : ivas) {
			EntityCacheUtil.removeResult(IvaModelImpl.ENTITY_CACHE_ENABLED,
				IvaImpl.class, iva.getPrimaryKey());
		}
	}

	/**
	 * Creates a new iva with the primary key. Does not add the iva to the database.
	 *
	 * @param codiceIva the primary key for the new iva
	 * @return the new iva
	 */
	@Override
	public Iva create(String codiceIva) {
		Iva iva = new IvaImpl();

		iva.setNew(true);
		iva.setPrimaryKey(codiceIva);

		return iva;
	}

	/**
	 * Removes the iva with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param codiceIva the primary key of the iva
	 * @return the iva that was removed
	 * @throws it.bysoftware.ct.NoSuchIvaException if a iva with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Iva remove(String codiceIva)
		throws NoSuchIvaException, SystemException {
		return remove((Serializable)codiceIva);
	}

	/**
	 * Removes the iva with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the iva
	 * @return the iva that was removed
	 * @throws it.bysoftware.ct.NoSuchIvaException if a iva with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Iva remove(Serializable primaryKey)
		throws NoSuchIvaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Iva iva = (Iva)session.get(IvaImpl.class, primaryKey);

			if (iva == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchIvaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(iva);
		}
		catch (NoSuchIvaException nsee) {
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
	protected Iva removeImpl(Iva iva) throws SystemException {
		iva = toUnwrappedModel(iva);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(iva)) {
				iva = (Iva)session.get(IvaImpl.class, iva.getPrimaryKeyObj());
			}

			if (iva != null) {
				session.delete(iva);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (iva != null) {
			clearCache(iva);
		}

		return iva;
	}

	@Override
	public Iva updateImpl(it.bysoftware.ct.model.Iva iva)
		throws SystemException {
		iva = toUnwrappedModel(iva);

		boolean isNew = iva.isNew();

		Session session = null;

		try {
			session = openSession();

			if (iva.isNew()) {
				session.save(iva);

				iva.setNew(false);
			}
			else {
				session.merge(iva);
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

		EntityCacheUtil.putResult(IvaModelImpl.ENTITY_CACHE_ENABLED,
			IvaImpl.class, iva.getPrimaryKey(), iva);

		return iva;
	}

	protected Iva toUnwrappedModel(Iva iva) {
		if (iva instanceof IvaImpl) {
			return iva;
		}

		IvaImpl ivaImpl = new IvaImpl();

		ivaImpl.setNew(iva.isNew());
		ivaImpl.setPrimaryKey(iva.getPrimaryKey());

		ivaImpl.setCodiceIva(iva.getCodiceIva());
		ivaImpl.setDescrizione(iva.getDescrizione());
		ivaImpl.setDescrizioneDocumento(iva.getDescrizioneDocumento());
		ivaImpl.setAliquota(iva.getAliquota());

		return ivaImpl;
	}

	/**
	 * Returns the iva with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the iva
	 * @return the iva
	 * @throws it.bysoftware.ct.NoSuchIvaException if a iva with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Iva findByPrimaryKey(Serializable primaryKey)
		throws NoSuchIvaException, SystemException {
		Iva iva = fetchByPrimaryKey(primaryKey);

		if (iva == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchIvaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return iva;
	}

	/**
	 * Returns the iva with the primary key or throws a {@link it.bysoftware.ct.NoSuchIvaException} if it could not be found.
	 *
	 * @param codiceIva the primary key of the iva
	 * @return the iva
	 * @throws it.bysoftware.ct.NoSuchIvaException if a iva with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Iva findByPrimaryKey(String codiceIva)
		throws NoSuchIvaException, SystemException {
		return findByPrimaryKey((Serializable)codiceIva);
	}

	/**
	 * Returns the iva with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the iva
	 * @return the iva, or <code>null</code> if a iva with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Iva fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Iva iva = (Iva)EntityCacheUtil.getResult(IvaModelImpl.ENTITY_CACHE_ENABLED,
				IvaImpl.class, primaryKey);

		if (iva == _nullIva) {
			return null;
		}

		if (iva == null) {
			Session session = null;

			try {
				session = openSession();

				iva = (Iva)session.get(IvaImpl.class, primaryKey);

				if (iva != null) {
					cacheResult(iva);
				}
				else {
					EntityCacheUtil.putResult(IvaModelImpl.ENTITY_CACHE_ENABLED,
						IvaImpl.class, primaryKey, _nullIva);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(IvaModelImpl.ENTITY_CACHE_ENABLED,
					IvaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return iva;
	}

	/**
	 * Returns the iva with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param codiceIva the primary key of the iva
	 * @return the iva, or <code>null</code> if a iva with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Iva fetchByPrimaryKey(String codiceIva) throws SystemException {
		return fetchByPrimaryKey((Serializable)codiceIva);
	}

	/**
	 * Returns all the ivas.
	 *
	 * @return the ivas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Iva> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ivas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.IvaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ivas
	 * @param end the upper bound of the range of ivas (not inclusive)
	 * @return the range of ivas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Iva> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ivas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.IvaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ivas
	 * @param end the upper bound of the range of ivas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ivas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Iva> findAll(int start, int end,
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

		List<Iva> list = (List<Iva>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_IVA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_IVA;

				if (pagination) {
					sql = sql.concat(IvaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Iva>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Iva>(list);
				}
				else {
					list = (List<Iva>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Removes all the ivas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Iva iva : findAll()) {
			remove(iva);
		}
	}

	/**
	 * Returns the number of ivas.
	 *
	 * @return the number of ivas
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

				Query q = session.createQuery(_SQL_COUNT_IVA);

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
	 * Initializes the iva persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.bysoftware.ct.model.Iva")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Iva>> listenersList = new ArrayList<ModelListener<Iva>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Iva>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(IvaImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_IVA = "SELECT iva FROM Iva iva";
	private static final String _SQL_COUNT_IVA = "SELECT COUNT(iva) FROM Iva iva";
	private static final String _ORDER_BY_ENTITY_ALIAS = "iva.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Iva exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(IvaPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"codiceIva", "descrizione", "descrizioneDocumento", "aliquota"
			});
	private static Iva _nullIva = new IvaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Iva> toCacheModel() {
				return _nullIvaCacheModel;
			}
		};

	private static CacheModel<Iva> _nullIvaCacheModel = new CacheModel<Iva>() {
			@Override
			public Iva toEntityModel() {
				return _nullIva;
			}
		};
}
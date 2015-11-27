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

import it.bysoftware.ct.NoSuchVociIvaException;
import it.bysoftware.ct.model.VociIva;
import it.bysoftware.ct.model.impl.VociIvaImpl;
import it.bysoftware.ct.model.impl.VociIvaModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the voci iva service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VociIvaPersistence
 * @see VociIvaUtil
 * @generated
 */
public class VociIvaPersistenceImpl extends BasePersistenceImpl<VociIva>
	implements VociIvaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VociIvaUtil} to access the voci iva persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VociIvaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VociIvaModelImpl.ENTITY_CACHE_ENABLED,
			VociIvaModelImpl.FINDER_CACHE_ENABLED, VociIvaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VociIvaModelImpl.ENTITY_CACHE_ENABLED,
			VociIvaModelImpl.FINDER_CACHE_ENABLED, VociIvaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VociIvaModelImpl.ENTITY_CACHE_ENABLED,
			VociIvaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public VociIvaPersistenceImpl() {
		setModelClass(VociIva.class);
	}

	/**
	 * Caches the voci iva in the entity cache if it is enabled.
	 *
	 * @param vociIva the voci iva
	 */
	@Override
	public void cacheResult(VociIva vociIva) {
		EntityCacheUtil.putResult(VociIvaModelImpl.ENTITY_CACHE_ENABLED,
			VociIvaImpl.class, vociIva.getPrimaryKey(), vociIva);

		vociIva.resetOriginalValues();
	}

	/**
	 * Caches the voci ivas in the entity cache if it is enabled.
	 *
	 * @param vociIvas the voci ivas
	 */
	@Override
	public void cacheResult(List<VociIva> vociIvas) {
		for (VociIva vociIva : vociIvas) {
			if (EntityCacheUtil.getResult(
						VociIvaModelImpl.ENTITY_CACHE_ENABLED,
						VociIvaImpl.class, vociIva.getPrimaryKey()) == null) {
				cacheResult(vociIva);
			}
			else {
				vociIva.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all voci ivas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VociIvaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VociIvaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the voci iva.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VociIva vociIva) {
		EntityCacheUtil.removeResult(VociIvaModelImpl.ENTITY_CACHE_ENABLED,
			VociIvaImpl.class, vociIva.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VociIva> vociIvas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VociIva vociIva : vociIvas) {
			EntityCacheUtil.removeResult(VociIvaModelImpl.ENTITY_CACHE_ENABLED,
				VociIvaImpl.class, vociIva.getPrimaryKey());
		}
	}

	/**
	 * Creates a new voci iva with the primary key. Does not add the voci iva to the database.
	 *
	 * @param codiceIva the primary key for the new voci iva
	 * @return the new voci iva
	 */
	@Override
	public VociIva create(String codiceIva) {
		VociIva vociIva = new VociIvaImpl();

		vociIva.setNew(true);
		vociIva.setPrimaryKey(codiceIva);

		return vociIva;
	}

	/**
	 * Removes the voci iva with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param codiceIva the primary key of the voci iva
	 * @return the voci iva that was removed
	 * @throws it.bysoftware.ct.NoSuchVociIvaException if a voci iva with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VociIva remove(String codiceIva)
		throws NoSuchVociIvaException, SystemException {
		return remove((Serializable)codiceIva);
	}

	/**
	 * Removes the voci iva with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the voci iva
	 * @return the voci iva that was removed
	 * @throws it.bysoftware.ct.NoSuchVociIvaException if a voci iva with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VociIva remove(Serializable primaryKey)
		throws NoSuchVociIvaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VociIva vociIva = (VociIva)session.get(VociIvaImpl.class, primaryKey);

			if (vociIva == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVociIvaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vociIva);
		}
		catch (NoSuchVociIvaException nsee) {
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
	protected VociIva removeImpl(VociIva vociIva) throws SystemException {
		vociIva = toUnwrappedModel(vociIva);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vociIva)) {
				vociIva = (VociIva)session.get(VociIvaImpl.class,
						vociIva.getPrimaryKeyObj());
			}

			if (vociIva != null) {
				session.delete(vociIva);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vociIva != null) {
			clearCache(vociIva);
		}

		return vociIva;
	}

	@Override
	public VociIva updateImpl(it.bysoftware.ct.model.VociIva vociIva)
		throws SystemException {
		vociIva = toUnwrappedModel(vociIva);

		boolean isNew = vociIva.isNew();

		Session session = null;

		try {
			session = openSession();

			if (vociIva.isNew()) {
				session.save(vociIva);

				vociIva.setNew(false);
			}
			else {
				session.merge(vociIva);
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

		EntityCacheUtil.putResult(VociIvaModelImpl.ENTITY_CACHE_ENABLED,
			VociIvaImpl.class, vociIva.getPrimaryKey(), vociIva);

		return vociIva;
	}

	protected VociIva toUnwrappedModel(VociIva vociIva) {
		if (vociIva instanceof VociIvaImpl) {
			return vociIva;
		}

		VociIvaImpl vociIvaImpl = new VociIvaImpl();

		vociIvaImpl.setNew(vociIva.isNew());
		vociIvaImpl.setPrimaryKey(vociIva.getPrimaryKey());

		vociIvaImpl.setCodiceIva(vociIva.getCodiceIva());
		vociIvaImpl.setDescrizione(vociIva.getDescrizione());
		vociIvaImpl.setDescrizioneDocumento(vociIva.getDescrizioneDocumento());
		vociIvaImpl.setAliquota(vociIva.getAliquota());

		return vociIvaImpl;
	}

	/**
	 * Returns the voci iva with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the voci iva
	 * @return the voci iva
	 * @throws it.bysoftware.ct.NoSuchVociIvaException if a voci iva with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VociIva findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVociIvaException, SystemException {
		VociIva vociIva = fetchByPrimaryKey(primaryKey);

		if (vociIva == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVociIvaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return vociIva;
	}

	/**
	 * Returns the voci iva with the primary key or throws a {@link it.bysoftware.ct.NoSuchVociIvaException} if it could not be found.
	 *
	 * @param codiceIva the primary key of the voci iva
	 * @return the voci iva
	 * @throws it.bysoftware.ct.NoSuchVociIvaException if a voci iva with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VociIva findByPrimaryKey(String codiceIva)
		throws NoSuchVociIvaException, SystemException {
		return findByPrimaryKey((Serializable)codiceIva);
	}

	/**
	 * Returns the voci iva with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the voci iva
	 * @return the voci iva, or <code>null</code> if a voci iva with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VociIva fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VociIva vociIva = (VociIva)EntityCacheUtil.getResult(VociIvaModelImpl.ENTITY_CACHE_ENABLED,
				VociIvaImpl.class, primaryKey);

		if (vociIva == _nullVociIva) {
			return null;
		}

		if (vociIva == null) {
			Session session = null;

			try {
				session = openSession();

				vociIva = (VociIva)session.get(VociIvaImpl.class, primaryKey);

				if (vociIva != null) {
					cacheResult(vociIva);
				}
				else {
					EntityCacheUtil.putResult(VociIvaModelImpl.ENTITY_CACHE_ENABLED,
						VociIvaImpl.class, primaryKey, _nullVociIva);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VociIvaModelImpl.ENTITY_CACHE_ENABLED,
					VociIvaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return vociIva;
	}

	/**
	 * Returns the voci iva with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param codiceIva the primary key of the voci iva
	 * @return the voci iva, or <code>null</code> if a voci iva with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VociIva fetchByPrimaryKey(String codiceIva)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)codiceIva);
	}

	/**
	 * Returns all the voci ivas.
	 *
	 * @return the voci ivas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VociIva> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the voci ivas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.VociIvaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of voci ivas
	 * @param end the upper bound of the range of voci ivas (not inclusive)
	 * @return the range of voci ivas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VociIva> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the voci ivas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.VociIvaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of voci ivas
	 * @param end the upper bound of the range of voci ivas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of voci ivas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VociIva> findAll(int start, int end,
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

		List<VociIva> list = (List<VociIva>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VOCIIVA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VOCIIVA;

				if (pagination) {
					sql = sql.concat(VociIvaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VociIva>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VociIva>(list);
				}
				else {
					list = (List<VociIva>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the voci ivas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VociIva vociIva : findAll()) {
			remove(vociIva);
		}
	}

	/**
	 * Returns the number of voci ivas.
	 *
	 * @return the number of voci ivas
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

				Query q = session.createQuery(_SQL_COUNT_VOCIIVA);

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
	 * Initializes the voci iva persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.bysoftware.ct.model.VociIva")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VociIva>> listenersList = new ArrayList<ModelListener<VociIva>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VociIva>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VociIvaImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VOCIIVA = "SELECT vociIva FROM VociIva vociIva";
	private static final String _SQL_COUNT_VOCIIVA = "SELECT COUNT(vociIva) FROM VociIva vociIva";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vociIva.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VociIva exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VociIvaPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"codiceIva", "descrizione", "descrizioneDocumento", "aliquota"
			});
	private static VociIva _nullVociIva = new VociIvaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VociIva> toCacheModel() {
				return _nullVociIvaCacheModel;
			}
		};

	private static CacheModel<VociIva> _nullVociIvaCacheModel = new CacheModel<VociIva>() {
			@Override
			public VociIva toEntityModel() {
				return _nullVociIva;
			}
		};
}
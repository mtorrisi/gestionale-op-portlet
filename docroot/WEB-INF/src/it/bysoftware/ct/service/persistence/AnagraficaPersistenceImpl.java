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

import it.bysoftware.ct.NoSuchAnagraficaException;
import it.bysoftware.ct.model.Anagrafica;
import it.bysoftware.ct.model.impl.AnagraficaImpl;
import it.bysoftware.ct.model.impl.AnagraficaModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the anagrafica service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnagraficaPersistence
 * @see AnagraficaUtil
 * @generated
 */
public class AnagraficaPersistenceImpl extends BasePersistenceImpl<Anagrafica>
	implements AnagraficaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AnagraficaUtil} to access the anagrafica persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AnagraficaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AnagraficaModelImpl.ENTITY_CACHE_ENABLED,
			AnagraficaModelImpl.FINDER_CACHE_ENABLED, AnagraficaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AnagraficaModelImpl.ENTITY_CACHE_ENABLED,
			AnagraficaModelImpl.FINDER_CACHE_ENABLED, AnagraficaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AnagraficaModelImpl.ENTITY_CACHE_ENABLED,
			AnagraficaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TIPOSOGGETTO =
		new FinderPath(AnagraficaModelImpl.ENTITY_CACHE_ENABLED,
			AnagraficaModelImpl.FINDER_CACHE_ENABLED, AnagraficaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBytipoSoggetto",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIPOSOGGETTO =
		new FinderPath(AnagraficaModelImpl.ENTITY_CACHE_ENABLED,
			AnagraficaModelImpl.FINDER_CACHE_ENABLED, AnagraficaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBytipoSoggetto",
			new String[] { String.class.getName() },
			AnagraficaModelImpl.TIPOSOGGETTO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TIPOSOGGETTO = new FinderPath(AnagraficaModelImpl.ENTITY_CACHE_ENABLED,
			AnagraficaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytipoSoggetto",
			new String[] { String.class.getName() });

	/**
	 * Returns all the anagraficas where tipoSoggetto = &#63;.
	 *
	 * @param tipoSoggetto the tipo soggetto
	 * @return the matching anagraficas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Anagrafica> findBytipoSoggetto(String tipoSoggetto)
		throws SystemException {
		return findBytipoSoggetto(tipoSoggetto, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the anagraficas where tipoSoggetto = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AnagraficaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipoSoggetto the tipo soggetto
	 * @param start the lower bound of the range of anagraficas
	 * @param end the upper bound of the range of anagraficas (not inclusive)
	 * @return the range of matching anagraficas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Anagrafica> findBytipoSoggetto(String tipoSoggetto, int start,
		int end) throws SystemException {
		return findBytipoSoggetto(tipoSoggetto, start, end, null);
	}

	/**
	 * Returns an ordered range of all the anagraficas where tipoSoggetto = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AnagraficaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipoSoggetto the tipo soggetto
	 * @param start the lower bound of the range of anagraficas
	 * @param end the upper bound of the range of anagraficas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching anagraficas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Anagrafica> findBytipoSoggetto(String tipoSoggetto, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIPOSOGGETTO;
			finderArgs = new Object[] { tipoSoggetto };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TIPOSOGGETTO;
			finderArgs = new Object[] {
					tipoSoggetto,
					
					start, end, orderByComparator
				};
		}

		List<Anagrafica> list = (List<Anagrafica>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Anagrafica anagrafica : list) {
				if (!Validator.equals(tipoSoggetto, anagrafica.getTipoSoggetto())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ANAGRAFICA_WHERE);

			boolean bindTipoSoggetto = false;

			if (tipoSoggetto == null) {
				query.append(_FINDER_COLUMN_TIPOSOGGETTO_TIPOSOGGETTO_1);
			}
			else if (tipoSoggetto.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TIPOSOGGETTO_TIPOSOGGETTO_3);
			}
			else {
				bindTipoSoggetto = true;

				query.append(_FINDER_COLUMN_TIPOSOGGETTO_TIPOSOGGETTO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AnagraficaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTipoSoggetto) {
					qPos.add(tipoSoggetto);
				}

				if (!pagination) {
					list = (List<Anagrafica>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Anagrafica>(list);
				}
				else {
					list = (List<Anagrafica>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first anagrafica in the ordered set where tipoSoggetto = &#63;.
	 *
	 * @param tipoSoggetto the tipo soggetto
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching anagrafica
	 * @throws it.bysoftware.ct.NoSuchAnagraficaException if a matching anagrafica could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Anagrafica findBytipoSoggetto_First(String tipoSoggetto,
		OrderByComparator orderByComparator)
		throws NoSuchAnagraficaException, SystemException {
		Anagrafica anagrafica = fetchBytipoSoggetto_First(tipoSoggetto,
				orderByComparator);

		if (anagrafica != null) {
			return anagrafica;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tipoSoggetto=");
		msg.append(tipoSoggetto);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnagraficaException(msg.toString());
	}

	/**
	 * Returns the first anagrafica in the ordered set where tipoSoggetto = &#63;.
	 *
	 * @param tipoSoggetto the tipo soggetto
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching anagrafica, or <code>null</code> if a matching anagrafica could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Anagrafica fetchBytipoSoggetto_First(String tipoSoggetto,
		OrderByComparator orderByComparator) throws SystemException {
		List<Anagrafica> list = findBytipoSoggetto(tipoSoggetto, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last anagrafica in the ordered set where tipoSoggetto = &#63;.
	 *
	 * @param tipoSoggetto the tipo soggetto
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching anagrafica
	 * @throws it.bysoftware.ct.NoSuchAnagraficaException if a matching anagrafica could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Anagrafica findBytipoSoggetto_Last(String tipoSoggetto,
		OrderByComparator orderByComparator)
		throws NoSuchAnagraficaException, SystemException {
		Anagrafica anagrafica = fetchBytipoSoggetto_Last(tipoSoggetto,
				orderByComparator);

		if (anagrafica != null) {
			return anagrafica;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tipoSoggetto=");
		msg.append(tipoSoggetto);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnagraficaException(msg.toString());
	}

	/**
	 * Returns the last anagrafica in the ordered set where tipoSoggetto = &#63;.
	 *
	 * @param tipoSoggetto the tipo soggetto
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching anagrafica, or <code>null</code> if a matching anagrafica could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Anagrafica fetchBytipoSoggetto_Last(String tipoSoggetto,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBytipoSoggetto(tipoSoggetto);

		if (count == 0) {
			return null;
		}

		List<Anagrafica> list = findBytipoSoggetto(tipoSoggetto, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the anagraficas before and after the current anagrafica in the ordered set where tipoSoggetto = &#63;.
	 *
	 * @param codiceAnagrafica the primary key of the current anagrafica
	 * @param tipoSoggetto the tipo soggetto
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next anagrafica
	 * @throws it.bysoftware.ct.NoSuchAnagraficaException if a anagrafica with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Anagrafica[] findBytipoSoggetto_PrevAndNext(
		String codiceAnagrafica, String tipoSoggetto,
		OrderByComparator orderByComparator)
		throws NoSuchAnagraficaException, SystemException {
		Anagrafica anagrafica = findByPrimaryKey(codiceAnagrafica);

		Session session = null;

		try {
			session = openSession();

			Anagrafica[] array = new AnagraficaImpl[3];

			array[0] = getBytipoSoggetto_PrevAndNext(session, anagrafica,
					tipoSoggetto, orderByComparator, true);

			array[1] = anagrafica;

			array[2] = getBytipoSoggetto_PrevAndNext(session, anagrafica,
					tipoSoggetto, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Anagrafica getBytipoSoggetto_PrevAndNext(Session session,
		Anagrafica anagrafica, String tipoSoggetto,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ANAGRAFICA_WHERE);

		boolean bindTipoSoggetto = false;

		if (tipoSoggetto == null) {
			query.append(_FINDER_COLUMN_TIPOSOGGETTO_TIPOSOGGETTO_1);
		}
		else if (tipoSoggetto.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TIPOSOGGETTO_TIPOSOGGETTO_3);
		}
		else {
			bindTipoSoggetto = true;

			query.append(_FINDER_COLUMN_TIPOSOGGETTO_TIPOSOGGETTO_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AnagraficaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTipoSoggetto) {
			qPos.add(tipoSoggetto);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(anagrafica);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Anagrafica> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the anagraficas where tipoSoggetto = &#63; from the database.
	 *
	 * @param tipoSoggetto the tipo soggetto
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBytipoSoggetto(String tipoSoggetto)
		throws SystemException {
		for (Anagrafica anagrafica : findBytipoSoggetto(tipoSoggetto,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(anagrafica);
		}
	}

	/**
	 * Returns the number of anagraficas where tipoSoggetto = &#63;.
	 *
	 * @param tipoSoggetto the tipo soggetto
	 * @return the number of matching anagraficas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBytipoSoggetto(String tipoSoggetto)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TIPOSOGGETTO;

		Object[] finderArgs = new Object[] { tipoSoggetto };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ANAGRAFICA_WHERE);

			boolean bindTipoSoggetto = false;

			if (tipoSoggetto == null) {
				query.append(_FINDER_COLUMN_TIPOSOGGETTO_TIPOSOGGETTO_1);
			}
			else if (tipoSoggetto.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TIPOSOGGETTO_TIPOSOGGETTO_3);
			}
			else {
				bindTipoSoggetto = true;

				query.append(_FINDER_COLUMN_TIPOSOGGETTO_TIPOSOGGETTO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTipoSoggetto) {
					qPos.add(tipoSoggetto);
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

	private static final String _FINDER_COLUMN_TIPOSOGGETTO_TIPOSOGGETTO_1 = "anagrafica.tipoSoggetto IS NULL";
	private static final String _FINDER_COLUMN_TIPOSOGGETTO_TIPOSOGGETTO_2 = "anagrafica.tipoSoggetto = ?";
	private static final String _FINDER_COLUMN_TIPOSOGGETTO_TIPOSOGGETTO_3 = "(anagrafica.tipoSoggetto IS NULL OR anagrafica.tipoSoggetto = '')";

	public AnagraficaPersistenceImpl() {
		setModelClass(Anagrafica.class);
	}

	/**
	 * Caches the anagrafica in the entity cache if it is enabled.
	 *
	 * @param anagrafica the anagrafica
	 */
	@Override
	public void cacheResult(Anagrafica anagrafica) {
		EntityCacheUtil.putResult(AnagraficaModelImpl.ENTITY_CACHE_ENABLED,
			AnagraficaImpl.class, anagrafica.getPrimaryKey(), anagrafica);

		anagrafica.resetOriginalValues();
	}

	/**
	 * Caches the anagraficas in the entity cache if it is enabled.
	 *
	 * @param anagraficas the anagraficas
	 */
	@Override
	public void cacheResult(List<Anagrafica> anagraficas) {
		for (Anagrafica anagrafica : anagraficas) {
			if (EntityCacheUtil.getResult(
						AnagraficaModelImpl.ENTITY_CACHE_ENABLED,
						AnagraficaImpl.class, anagrafica.getPrimaryKey()) == null) {
				cacheResult(anagrafica);
			}
			else {
				anagrafica.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all anagraficas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AnagraficaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AnagraficaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the anagrafica.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Anagrafica anagrafica) {
		EntityCacheUtil.removeResult(AnagraficaModelImpl.ENTITY_CACHE_ENABLED,
			AnagraficaImpl.class, anagrafica.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Anagrafica> anagraficas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Anagrafica anagrafica : anagraficas) {
			EntityCacheUtil.removeResult(AnagraficaModelImpl.ENTITY_CACHE_ENABLED,
				AnagraficaImpl.class, anagrafica.getPrimaryKey());
		}
	}

	/**
	 * Creates a new anagrafica with the primary key. Does not add the anagrafica to the database.
	 *
	 * @param codiceAnagrafica the primary key for the new anagrafica
	 * @return the new anagrafica
	 */
	@Override
	public Anagrafica create(String codiceAnagrafica) {
		Anagrafica anagrafica = new AnagraficaImpl();

		anagrafica.setNew(true);
		anagrafica.setPrimaryKey(codiceAnagrafica);

		return anagrafica;
	}

	/**
	 * Removes the anagrafica with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param codiceAnagrafica the primary key of the anagrafica
	 * @return the anagrafica that was removed
	 * @throws it.bysoftware.ct.NoSuchAnagraficaException if a anagrafica with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Anagrafica remove(String codiceAnagrafica)
		throws NoSuchAnagraficaException, SystemException {
		return remove((Serializable)codiceAnagrafica);
	}

	/**
	 * Removes the anagrafica with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the anagrafica
	 * @return the anagrafica that was removed
	 * @throws it.bysoftware.ct.NoSuchAnagraficaException if a anagrafica with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Anagrafica remove(Serializable primaryKey)
		throws NoSuchAnagraficaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Anagrafica anagrafica = (Anagrafica)session.get(AnagraficaImpl.class,
					primaryKey);

			if (anagrafica == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAnagraficaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(anagrafica);
		}
		catch (NoSuchAnagraficaException nsee) {
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
	protected Anagrafica removeImpl(Anagrafica anagrafica)
		throws SystemException {
		anagrafica = toUnwrappedModel(anagrafica);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(anagrafica)) {
				anagrafica = (Anagrafica)session.get(AnagraficaImpl.class,
						anagrafica.getPrimaryKeyObj());
			}

			if (anagrafica != null) {
				session.delete(anagrafica);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (anagrafica != null) {
			clearCache(anagrafica);
		}

		return anagrafica;
	}

	@Override
	public Anagrafica updateImpl(it.bysoftware.ct.model.Anagrafica anagrafica)
		throws SystemException {
		anagrafica = toUnwrappedModel(anagrafica);

		boolean isNew = anagrafica.isNew();

		AnagraficaModelImpl anagraficaModelImpl = (AnagraficaModelImpl)anagrafica;

		Session session = null;

		try {
			session = openSession();

			if (anagrafica.isNew()) {
				session.save(anagrafica);

				anagrafica.setNew(false);
			}
			else {
				session.merge(anagrafica);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AnagraficaModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((anagraficaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIPOSOGGETTO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						anagraficaModelImpl.getOriginalTipoSoggetto()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TIPOSOGGETTO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIPOSOGGETTO,
					args);

				args = new Object[] { anagraficaModelImpl.getTipoSoggetto() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TIPOSOGGETTO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIPOSOGGETTO,
					args);
			}
		}

		EntityCacheUtil.putResult(AnagraficaModelImpl.ENTITY_CACHE_ENABLED,
			AnagraficaImpl.class, anagrafica.getPrimaryKey(), anagrafica);

		return anagrafica;
	}

	protected Anagrafica toUnwrappedModel(Anagrafica anagrafica) {
		if (anagrafica instanceof AnagraficaImpl) {
			return anagrafica;
		}

		AnagraficaImpl anagraficaImpl = new AnagraficaImpl();

		anagraficaImpl.setNew(anagrafica.isNew());
		anagraficaImpl.setPrimaryKey(anagrafica.getPrimaryKey());

		anagraficaImpl.setAttivoEC(anagrafica.getAttivoEC());
		anagraficaImpl.setCap(anagrafica.getCap());
		anagraficaImpl.setCodiceAnagrafica(anagrafica.getCodiceAnagrafica());
		anagraficaImpl.setCodiceFiscale(anagrafica.getCodiceFiscale());
		anagraficaImpl.setCodiceMne(anagrafica.getCodiceMne());
		anagraficaImpl.setComune(anagrafica.getComune());
		anagraficaImpl.setIndirizzo(anagrafica.getIndirizzo());
		anagraficaImpl.setNote(anagrafica.getNote());
		anagraficaImpl.setPartitaIVA(anagrafica.getPartitaIVA());
		anagraficaImpl.setRagioneSociale(anagrafica.getRagioneSociale());
		anagraficaImpl.setRagioneSocialeAlternativa(anagrafica.getRagioneSocialeAlternativa());
		anagraficaImpl.setProvincia(anagrafica.getProvincia());
		anagraficaImpl.setStato(anagrafica.getStato());
		anagraficaImpl.setTepefi(anagrafica.getTepefi());
		anagraficaImpl.setTipoSoggetto(anagrafica.getTipoSoggetto());
		anagraficaImpl.setTipsol(anagrafica.getTipsol());
		anagraficaImpl.setCodiceAzienda(anagrafica.getCodiceAzienda());

		return anagraficaImpl;
	}

	/**
	 * Returns the anagrafica with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the anagrafica
	 * @return the anagrafica
	 * @throws it.bysoftware.ct.NoSuchAnagraficaException if a anagrafica with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Anagrafica findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAnagraficaException, SystemException {
		Anagrafica anagrafica = fetchByPrimaryKey(primaryKey);

		if (anagrafica == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAnagraficaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return anagrafica;
	}

	/**
	 * Returns the anagrafica with the primary key or throws a {@link it.bysoftware.ct.NoSuchAnagraficaException} if it could not be found.
	 *
	 * @param codiceAnagrafica the primary key of the anagrafica
	 * @return the anagrafica
	 * @throws it.bysoftware.ct.NoSuchAnagraficaException if a anagrafica with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Anagrafica findByPrimaryKey(String codiceAnagrafica)
		throws NoSuchAnagraficaException, SystemException {
		return findByPrimaryKey((Serializable)codiceAnagrafica);
	}

	/**
	 * Returns the anagrafica with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the anagrafica
	 * @return the anagrafica, or <code>null</code> if a anagrafica with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Anagrafica fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Anagrafica anagrafica = (Anagrafica)EntityCacheUtil.getResult(AnagraficaModelImpl.ENTITY_CACHE_ENABLED,
				AnagraficaImpl.class, primaryKey);

		if (anagrafica == _nullAnagrafica) {
			return null;
		}

		if (anagrafica == null) {
			Session session = null;

			try {
				session = openSession();

				anagrafica = (Anagrafica)session.get(AnagraficaImpl.class,
						primaryKey);

				if (anagrafica != null) {
					cacheResult(anagrafica);
				}
				else {
					EntityCacheUtil.putResult(AnagraficaModelImpl.ENTITY_CACHE_ENABLED,
						AnagraficaImpl.class, primaryKey, _nullAnagrafica);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AnagraficaModelImpl.ENTITY_CACHE_ENABLED,
					AnagraficaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return anagrafica;
	}

	/**
	 * Returns the anagrafica with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param codiceAnagrafica the primary key of the anagrafica
	 * @return the anagrafica, or <code>null</code> if a anagrafica with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Anagrafica fetchByPrimaryKey(String codiceAnagrafica)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)codiceAnagrafica);
	}

	/**
	 * Returns all the anagraficas.
	 *
	 * @return the anagraficas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Anagrafica> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the anagraficas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AnagraficaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of anagraficas
	 * @param end the upper bound of the range of anagraficas (not inclusive)
	 * @return the range of anagraficas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Anagrafica> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the anagraficas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AnagraficaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of anagraficas
	 * @param end the upper bound of the range of anagraficas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of anagraficas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Anagrafica> findAll(int start, int end,
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

		List<Anagrafica> list = (List<Anagrafica>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ANAGRAFICA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ANAGRAFICA;

				if (pagination) {
					sql = sql.concat(AnagraficaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Anagrafica>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Anagrafica>(list);
				}
				else {
					list = (List<Anagrafica>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the anagraficas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Anagrafica anagrafica : findAll()) {
			remove(anagrafica);
		}
	}

	/**
	 * Returns the number of anagraficas.
	 *
	 * @return the number of anagraficas
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

				Query q = session.createQuery(_SQL_COUNT_ANAGRAFICA);

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
	 * Initializes the anagrafica persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.bysoftware.ct.model.Anagrafica")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Anagrafica>> listenersList = new ArrayList<ModelListener<Anagrafica>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Anagrafica>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AnagraficaImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ANAGRAFICA = "SELECT anagrafica FROM Anagrafica anagrafica";
	private static final String _SQL_SELECT_ANAGRAFICA_WHERE = "SELECT anagrafica FROM Anagrafica anagrafica WHERE ";
	private static final String _SQL_COUNT_ANAGRAFICA = "SELECT COUNT(anagrafica) FROM Anagrafica anagrafica";
	private static final String _SQL_COUNT_ANAGRAFICA_WHERE = "SELECT COUNT(anagrafica) FROM Anagrafica anagrafica WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "anagrafica.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Anagrafica exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Anagrafica exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AnagraficaPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"attivoEC", "cap", "codiceAnagrafica", "codiceFiscale",
				"codiceMne", "comune", "Indirizzo", "note", "partitaIVA",
				"ragioneSociale", "ragioneSocialeAlternativa", "provincia",
				"stato", "tepefi", "tipoSoggetto", "tipsol", "codiceAzienda"
			});
	private static Anagrafica _nullAnagrafica = new AnagraficaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Anagrafica> toCacheModel() {
				return _nullAnagraficaCacheModel;
			}
		};

	private static CacheModel<Anagrafica> _nullAnagraficaCacheModel = new CacheModel<Anagrafica>() {
			@Override
			public Anagrafica toEntityModel() {
				return _nullAnagrafica;
			}
		};
}
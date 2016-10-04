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

import it.bysoftware.ct.NoSuchTracciabilitaGrezziException;
import it.bysoftware.ct.model.TracciabilitaGrezzi;
import it.bysoftware.ct.model.impl.TracciabilitaGrezziImpl;
import it.bysoftware.ct.model.impl.TracciabilitaGrezziModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the tracciabilita grezzi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TracciabilitaGrezziPersistence
 * @see TracciabilitaGrezziUtil
 * @generated
 */
public class TracciabilitaGrezziPersistenceImpl extends BasePersistenceImpl<TracciabilitaGrezzi>
	implements TracciabilitaGrezziPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TracciabilitaGrezziUtil} to access the tracciabilita grezzi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TracciabilitaGrezziImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TracciabilitaGrezziModelImpl.ENTITY_CACHE_ENABLED,
			TracciabilitaGrezziModelImpl.FINDER_CACHE_ENABLED,
			TracciabilitaGrezziImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TracciabilitaGrezziModelImpl.ENTITY_CACHE_ENABLED,
			TracciabilitaGrezziModelImpl.FINDER_CACHE_ENABLED,
			TracciabilitaGrezziImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TracciabilitaGrezziModelImpl.ENTITY_CACHE_ENABLED,
			TracciabilitaGrezziModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SCHEDATRACCIABILITA =
		new FinderPath(TracciabilitaGrezziModelImpl.ENTITY_CACHE_ENABLED,
			TracciabilitaGrezziModelImpl.FINDER_CACHE_ENABLED,
			TracciabilitaGrezziImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBySchedaTracciabilita",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCHEDATRACCIABILITA =
		new FinderPath(TracciabilitaGrezziModelImpl.ENTITY_CACHE_ENABLED,
			TracciabilitaGrezziModelImpl.FINDER_CACHE_ENABLED,
			TracciabilitaGrezziImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBySchedaTracciabilita", new String[] { Long.class.getName() },
			TracciabilitaGrezziModelImpl.IDSCHEDATRACCIABILTA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SCHEDATRACCIABILITA = new FinderPath(TracciabilitaGrezziModelImpl.ENTITY_CACHE_ENABLED,
			TracciabilitaGrezziModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySchedaTracciabilita", new String[] { Long.class.getName() });

	/**
	 * Returns all the tracciabilita grezzis where idSchedaTracciabilta = &#63;.
	 *
	 * @param idSchedaTracciabilta the id scheda tracciabilta
	 * @return the matching tracciabilita grezzis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TracciabilitaGrezzi> findBySchedaTracciabilita(
		long idSchedaTracciabilta) throws SystemException {
		return findBySchedaTracciabilita(idSchedaTracciabilta,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tracciabilita grezzis where idSchedaTracciabilta = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TracciabilitaGrezziModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idSchedaTracciabilta the id scheda tracciabilta
	 * @param start the lower bound of the range of tracciabilita grezzis
	 * @param end the upper bound of the range of tracciabilita grezzis (not inclusive)
	 * @return the range of matching tracciabilita grezzis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TracciabilitaGrezzi> findBySchedaTracciabilita(
		long idSchedaTracciabilta, int start, int end)
		throws SystemException {
		return findBySchedaTracciabilita(idSchedaTracciabilta, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tracciabilita grezzis where idSchedaTracciabilta = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TracciabilitaGrezziModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idSchedaTracciabilta the id scheda tracciabilta
	 * @param start the lower bound of the range of tracciabilita grezzis
	 * @param end the upper bound of the range of tracciabilita grezzis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tracciabilita grezzis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TracciabilitaGrezzi> findBySchedaTracciabilita(
		long idSchedaTracciabilta, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCHEDATRACCIABILITA;
			finderArgs = new Object[] { idSchedaTracciabilta };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SCHEDATRACCIABILITA;
			finderArgs = new Object[] {
					idSchedaTracciabilta,
					
					start, end, orderByComparator
				};
		}

		List<TracciabilitaGrezzi> list = (List<TracciabilitaGrezzi>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TracciabilitaGrezzi tracciabilitaGrezzi : list) {
				if ((idSchedaTracciabilta != tracciabilitaGrezzi.getIdSchedaTracciabilta())) {
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

			query.append(_SQL_SELECT_TRACCIABILITAGREZZI_WHERE);

			query.append(_FINDER_COLUMN_SCHEDATRACCIABILITA_IDSCHEDATRACCIABILTA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TracciabilitaGrezziModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(idSchedaTracciabilta);

				if (!pagination) {
					list = (List<TracciabilitaGrezzi>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TracciabilitaGrezzi>(list);
				}
				else {
					list = (List<TracciabilitaGrezzi>)QueryUtil.list(q,
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
	 * Returns the first tracciabilita grezzi in the ordered set where idSchedaTracciabilta = &#63;.
	 *
	 * @param idSchedaTracciabilta the id scheda tracciabilta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tracciabilita grezzi
	 * @throws it.bysoftware.ct.NoSuchTracciabilitaGrezziException if a matching tracciabilita grezzi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TracciabilitaGrezzi findBySchedaTracciabilita_First(
		long idSchedaTracciabilta, OrderByComparator orderByComparator)
		throws NoSuchTracciabilitaGrezziException, SystemException {
		TracciabilitaGrezzi tracciabilitaGrezzi = fetchBySchedaTracciabilita_First(idSchedaTracciabilta,
				orderByComparator);

		if (tracciabilitaGrezzi != null) {
			return tracciabilitaGrezzi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idSchedaTracciabilta=");
		msg.append(idSchedaTracciabilta);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTracciabilitaGrezziException(msg.toString());
	}

	/**
	 * Returns the first tracciabilita grezzi in the ordered set where idSchedaTracciabilta = &#63;.
	 *
	 * @param idSchedaTracciabilta the id scheda tracciabilta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tracciabilita grezzi, or <code>null</code> if a matching tracciabilita grezzi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TracciabilitaGrezzi fetchBySchedaTracciabilita_First(
		long idSchedaTracciabilta, OrderByComparator orderByComparator)
		throws SystemException {
		List<TracciabilitaGrezzi> list = findBySchedaTracciabilita(idSchedaTracciabilta,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tracciabilita grezzi in the ordered set where idSchedaTracciabilta = &#63;.
	 *
	 * @param idSchedaTracciabilta the id scheda tracciabilta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tracciabilita grezzi
	 * @throws it.bysoftware.ct.NoSuchTracciabilitaGrezziException if a matching tracciabilita grezzi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TracciabilitaGrezzi findBySchedaTracciabilita_Last(
		long idSchedaTracciabilta, OrderByComparator orderByComparator)
		throws NoSuchTracciabilitaGrezziException, SystemException {
		TracciabilitaGrezzi tracciabilitaGrezzi = fetchBySchedaTracciabilita_Last(idSchedaTracciabilta,
				orderByComparator);

		if (tracciabilitaGrezzi != null) {
			return tracciabilitaGrezzi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("idSchedaTracciabilta=");
		msg.append(idSchedaTracciabilta);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTracciabilitaGrezziException(msg.toString());
	}

	/**
	 * Returns the last tracciabilita grezzi in the ordered set where idSchedaTracciabilta = &#63;.
	 *
	 * @param idSchedaTracciabilta the id scheda tracciabilta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tracciabilita grezzi, or <code>null</code> if a matching tracciabilita grezzi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TracciabilitaGrezzi fetchBySchedaTracciabilita_Last(
		long idSchedaTracciabilta, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBySchedaTracciabilita(idSchedaTracciabilta);

		if (count == 0) {
			return null;
		}

		List<TracciabilitaGrezzi> list = findBySchedaTracciabilita(idSchedaTracciabilta,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tracciabilita grezzis before and after the current tracciabilita grezzi in the ordered set where idSchedaTracciabilta = &#63;.
	 *
	 * @param id the primary key of the current tracciabilita grezzi
	 * @param idSchedaTracciabilta the id scheda tracciabilta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tracciabilita grezzi
	 * @throws it.bysoftware.ct.NoSuchTracciabilitaGrezziException if a tracciabilita grezzi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TracciabilitaGrezzi[] findBySchedaTracciabilita_PrevAndNext(
		long id, long idSchedaTracciabilta, OrderByComparator orderByComparator)
		throws NoSuchTracciabilitaGrezziException, SystemException {
		TracciabilitaGrezzi tracciabilitaGrezzi = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TracciabilitaGrezzi[] array = new TracciabilitaGrezziImpl[3];

			array[0] = getBySchedaTracciabilita_PrevAndNext(session,
					tracciabilitaGrezzi, idSchedaTracciabilta,
					orderByComparator, true);

			array[1] = tracciabilitaGrezzi;

			array[2] = getBySchedaTracciabilita_PrevAndNext(session,
					tracciabilitaGrezzi, idSchedaTracciabilta,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TracciabilitaGrezzi getBySchedaTracciabilita_PrevAndNext(
		Session session, TracciabilitaGrezzi tracciabilitaGrezzi,
		long idSchedaTracciabilta, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRACCIABILITAGREZZI_WHERE);

		query.append(_FINDER_COLUMN_SCHEDATRACCIABILITA_IDSCHEDATRACCIABILTA_2);

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
			query.append(TracciabilitaGrezziModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(idSchedaTracciabilta);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tracciabilitaGrezzi);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TracciabilitaGrezzi> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tracciabilita grezzis where idSchedaTracciabilta = &#63; from the database.
	 *
	 * @param idSchedaTracciabilta the id scheda tracciabilta
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySchedaTracciabilita(long idSchedaTracciabilta)
		throws SystemException {
		for (TracciabilitaGrezzi tracciabilitaGrezzi : findBySchedaTracciabilita(
				idSchedaTracciabilta, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(tracciabilitaGrezzi);
		}
	}

	/**
	 * Returns the number of tracciabilita grezzis where idSchedaTracciabilta = &#63;.
	 *
	 * @param idSchedaTracciabilta the id scheda tracciabilta
	 * @return the number of matching tracciabilita grezzis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySchedaTracciabilita(long idSchedaTracciabilta)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SCHEDATRACCIABILITA;

		Object[] finderArgs = new Object[] { idSchedaTracciabilta };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRACCIABILITAGREZZI_WHERE);

			query.append(_FINDER_COLUMN_SCHEDATRACCIABILITA_IDSCHEDATRACCIABILTA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(idSchedaTracciabilta);

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

	private static final String _FINDER_COLUMN_SCHEDATRACCIABILITA_IDSCHEDATRACCIABILTA_2 =
		"tracciabilitaGrezzi.idSchedaTracciabilta = ?";

	public TracciabilitaGrezziPersistenceImpl() {
		setModelClass(TracciabilitaGrezzi.class);
	}

	/**
	 * Caches the tracciabilita grezzi in the entity cache if it is enabled.
	 *
	 * @param tracciabilitaGrezzi the tracciabilita grezzi
	 */
	@Override
	public void cacheResult(TracciabilitaGrezzi tracciabilitaGrezzi) {
		EntityCacheUtil.putResult(TracciabilitaGrezziModelImpl.ENTITY_CACHE_ENABLED,
			TracciabilitaGrezziImpl.class, tracciabilitaGrezzi.getPrimaryKey(),
			tracciabilitaGrezzi);

		tracciabilitaGrezzi.resetOriginalValues();
	}

	/**
	 * Caches the tracciabilita grezzis in the entity cache if it is enabled.
	 *
	 * @param tracciabilitaGrezzis the tracciabilita grezzis
	 */
	@Override
	public void cacheResult(List<TracciabilitaGrezzi> tracciabilitaGrezzis) {
		for (TracciabilitaGrezzi tracciabilitaGrezzi : tracciabilitaGrezzis) {
			if (EntityCacheUtil.getResult(
						TracciabilitaGrezziModelImpl.ENTITY_CACHE_ENABLED,
						TracciabilitaGrezziImpl.class,
						tracciabilitaGrezzi.getPrimaryKey()) == null) {
				cacheResult(tracciabilitaGrezzi);
			}
			else {
				tracciabilitaGrezzi.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tracciabilita grezzis.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TracciabilitaGrezziImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TracciabilitaGrezziImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tracciabilita grezzi.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TracciabilitaGrezzi tracciabilitaGrezzi) {
		EntityCacheUtil.removeResult(TracciabilitaGrezziModelImpl.ENTITY_CACHE_ENABLED,
			TracciabilitaGrezziImpl.class, tracciabilitaGrezzi.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TracciabilitaGrezzi> tracciabilitaGrezzis) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TracciabilitaGrezzi tracciabilitaGrezzi : tracciabilitaGrezzis) {
			EntityCacheUtil.removeResult(TracciabilitaGrezziModelImpl.ENTITY_CACHE_ENABLED,
				TracciabilitaGrezziImpl.class,
				tracciabilitaGrezzi.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tracciabilita grezzi with the primary key. Does not add the tracciabilita grezzi to the database.
	 *
	 * @param id the primary key for the new tracciabilita grezzi
	 * @return the new tracciabilita grezzi
	 */
	@Override
	public TracciabilitaGrezzi create(long id) {
		TracciabilitaGrezzi tracciabilitaGrezzi = new TracciabilitaGrezziImpl();

		tracciabilitaGrezzi.setNew(true);
		tracciabilitaGrezzi.setPrimaryKey(id);

		return tracciabilitaGrezzi;
	}

	/**
	 * Removes the tracciabilita grezzi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the tracciabilita grezzi
	 * @return the tracciabilita grezzi that was removed
	 * @throws it.bysoftware.ct.NoSuchTracciabilitaGrezziException if a tracciabilita grezzi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TracciabilitaGrezzi remove(long id)
		throws NoSuchTracciabilitaGrezziException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the tracciabilita grezzi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tracciabilita grezzi
	 * @return the tracciabilita grezzi that was removed
	 * @throws it.bysoftware.ct.NoSuchTracciabilitaGrezziException if a tracciabilita grezzi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TracciabilitaGrezzi remove(Serializable primaryKey)
		throws NoSuchTracciabilitaGrezziException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TracciabilitaGrezzi tracciabilitaGrezzi = (TracciabilitaGrezzi)session.get(TracciabilitaGrezziImpl.class,
					primaryKey);

			if (tracciabilitaGrezzi == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTracciabilitaGrezziException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tracciabilitaGrezzi);
		}
		catch (NoSuchTracciabilitaGrezziException nsee) {
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
	protected TracciabilitaGrezzi removeImpl(
		TracciabilitaGrezzi tracciabilitaGrezzi) throws SystemException {
		tracciabilitaGrezzi = toUnwrappedModel(tracciabilitaGrezzi);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tracciabilitaGrezzi)) {
				tracciabilitaGrezzi = (TracciabilitaGrezzi)session.get(TracciabilitaGrezziImpl.class,
						tracciabilitaGrezzi.getPrimaryKeyObj());
			}

			if (tracciabilitaGrezzi != null) {
				session.delete(tracciabilitaGrezzi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tracciabilitaGrezzi != null) {
			clearCache(tracciabilitaGrezzi);
		}

		return tracciabilitaGrezzi;
	}

	@Override
	public TracciabilitaGrezzi updateImpl(
		it.bysoftware.ct.model.TracciabilitaGrezzi tracciabilitaGrezzi)
		throws SystemException {
		tracciabilitaGrezzi = toUnwrappedModel(tracciabilitaGrezzi);

		boolean isNew = tracciabilitaGrezzi.isNew();

		TracciabilitaGrezziModelImpl tracciabilitaGrezziModelImpl = (TracciabilitaGrezziModelImpl)tracciabilitaGrezzi;

		Session session = null;

		try {
			session = openSession();

			if (tracciabilitaGrezzi.isNew()) {
				session.save(tracciabilitaGrezzi);

				tracciabilitaGrezzi.setNew(false);
			}
			else {
				session.merge(tracciabilitaGrezzi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TracciabilitaGrezziModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tracciabilitaGrezziModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCHEDATRACCIABILITA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tracciabilitaGrezziModelImpl.getOriginalIdSchedaTracciabilta()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SCHEDATRACCIABILITA,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCHEDATRACCIABILITA,
					args);

				args = new Object[] {
						tracciabilitaGrezziModelImpl.getIdSchedaTracciabilta()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SCHEDATRACCIABILITA,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCHEDATRACCIABILITA,
					args);
			}
		}

		EntityCacheUtil.putResult(TracciabilitaGrezziModelImpl.ENTITY_CACHE_ENABLED,
			TracciabilitaGrezziImpl.class, tracciabilitaGrezzi.getPrimaryKey(),
			tracciabilitaGrezzi);

		return tracciabilitaGrezzi;
	}

	protected TracciabilitaGrezzi toUnwrappedModel(
		TracciabilitaGrezzi tracciabilitaGrezzi) {
		if (tracciabilitaGrezzi instanceof TracciabilitaGrezziImpl) {
			return tracciabilitaGrezzi;
		}

		TracciabilitaGrezziImpl tracciabilitaGrezziImpl = new TracciabilitaGrezziImpl();

		tracciabilitaGrezziImpl.setNew(tracciabilitaGrezzi.isNew());
		tracciabilitaGrezziImpl.setPrimaryKey(tracciabilitaGrezzi.getPrimaryKey());

		tracciabilitaGrezziImpl.setId(tracciabilitaGrezzi.getId());
		tracciabilitaGrezziImpl.setLottoGrezzo(tracciabilitaGrezzi.getLottoGrezzo());
		tracciabilitaGrezziImpl.setProdotto(tracciabilitaGrezzi.getProdotto());
		tracciabilitaGrezziImpl.setKg(tracciabilitaGrezzi.getKg());
		tracciabilitaGrezziImpl.setProduttore(tracciabilitaGrezzi.getProduttore());
		tracciabilitaGrezziImpl.setFoglio(tracciabilitaGrezzi.getFoglio());
		tracciabilitaGrezziImpl.setParticella(tracciabilitaGrezzi.getParticella());
		tracciabilitaGrezziImpl.setNote(tracciabilitaGrezzi.getNote());
		tracciabilitaGrezziImpl.setNumeroColli(tracciabilitaGrezzi.getNumeroColli());
		tracciabilitaGrezziImpl.setKgScarto(tracciabilitaGrezzi.getKgScarto());
		tracciabilitaGrezziImpl.setIdSchedaTracciabilta(tracciabilitaGrezzi.getIdSchedaTracciabilta());

		return tracciabilitaGrezziImpl;
	}

	/**
	 * Returns the tracciabilita grezzi with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tracciabilita grezzi
	 * @return the tracciabilita grezzi
	 * @throws it.bysoftware.ct.NoSuchTracciabilitaGrezziException if a tracciabilita grezzi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TracciabilitaGrezzi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTracciabilitaGrezziException, SystemException {
		TracciabilitaGrezzi tracciabilitaGrezzi = fetchByPrimaryKey(primaryKey);

		if (tracciabilitaGrezzi == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTracciabilitaGrezziException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tracciabilitaGrezzi;
	}

	/**
	 * Returns the tracciabilita grezzi with the primary key or throws a {@link it.bysoftware.ct.NoSuchTracciabilitaGrezziException} if it could not be found.
	 *
	 * @param id the primary key of the tracciabilita grezzi
	 * @return the tracciabilita grezzi
	 * @throws it.bysoftware.ct.NoSuchTracciabilitaGrezziException if a tracciabilita grezzi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TracciabilitaGrezzi findByPrimaryKey(long id)
		throws NoSuchTracciabilitaGrezziException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the tracciabilita grezzi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tracciabilita grezzi
	 * @return the tracciabilita grezzi, or <code>null</code> if a tracciabilita grezzi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TracciabilitaGrezzi fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TracciabilitaGrezzi tracciabilitaGrezzi = (TracciabilitaGrezzi)EntityCacheUtil.getResult(TracciabilitaGrezziModelImpl.ENTITY_CACHE_ENABLED,
				TracciabilitaGrezziImpl.class, primaryKey);

		if (tracciabilitaGrezzi == _nullTracciabilitaGrezzi) {
			return null;
		}

		if (tracciabilitaGrezzi == null) {
			Session session = null;

			try {
				session = openSession();

				tracciabilitaGrezzi = (TracciabilitaGrezzi)session.get(TracciabilitaGrezziImpl.class,
						primaryKey);

				if (tracciabilitaGrezzi != null) {
					cacheResult(tracciabilitaGrezzi);
				}
				else {
					EntityCacheUtil.putResult(TracciabilitaGrezziModelImpl.ENTITY_CACHE_ENABLED,
						TracciabilitaGrezziImpl.class, primaryKey,
						_nullTracciabilitaGrezzi);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TracciabilitaGrezziModelImpl.ENTITY_CACHE_ENABLED,
					TracciabilitaGrezziImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tracciabilitaGrezzi;
	}

	/**
	 * Returns the tracciabilita grezzi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the tracciabilita grezzi
	 * @return the tracciabilita grezzi, or <code>null</code> if a tracciabilita grezzi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TracciabilitaGrezzi fetchByPrimaryKey(long id)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the tracciabilita grezzis.
	 *
	 * @return the tracciabilita grezzis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TracciabilitaGrezzi> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tracciabilita grezzis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TracciabilitaGrezziModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tracciabilita grezzis
	 * @param end the upper bound of the range of tracciabilita grezzis (not inclusive)
	 * @return the range of tracciabilita grezzis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TracciabilitaGrezzi> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tracciabilita grezzis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TracciabilitaGrezziModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tracciabilita grezzis
	 * @param end the upper bound of the range of tracciabilita grezzis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tracciabilita grezzis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TracciabilitaGrezzi> findAll(int start, int end,
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

		List<TracciabilitaGrezzi> list = (List<TracciabilitaGrezzi>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TRACCIABILITAGREZZI);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TRACCIABILITAGREZZI;

				if (pagination) {
					sql = sql.concat(TracciabilitaGrezziModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TracciabilitaGrezzi>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TracciabilitaGrezzi>(list);
				}
				else {
					list = (List<TracciabilitaGrezzi>)QueryUtil.list(q,
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
	 * Removes all the tracciabilita grezzis from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TracciabilitaGrezzi tracciabilitaGrezzi : findAll()) {
			remove(tracciabilitaGrezzi);
		}
	}

	/**
	 * Returns the number of tracciabilita grezzis.
	 *
	 * @return the number of tracciabilita grezzis
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

				Query q = session.createQuery(_SQL_COUNT_TRACCIABILITAGREZZI);

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
	 * Initializes the tracciabilita grezzi persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.bysoftware.ct.model.TracciabilitaGrezzi")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TracciabilitaGrezzi>> listenersList = new ArrayList<ModelListener<TracciabilitaGrezzi>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TracciabilitaGrezzi>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TracciabilitaGrezziImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TRACCIABILITAGREZZI = "SELECT tracciabilitaGrezzi FROM TracciabilitaGrezzi tracciabilitaGrezzi";
	private static final String _SQL_SELECT_TRACCIABILITAGREZZI_WHERE = "SELECT tracciabilitaGrezzi FROM TracciabilitaGrezzi tracciabilitaGrezzi WHERE ";
	private static final String _SQL_COUNT_TRACCIABILITAGREZZI = "SELECT COUNT(tracciabilitaGrezzi) FROM TracciabilitaGrezzi tracciabilitaGrezzi";
	private static final String _SQL_COUNT_TRACCIABILITAGREZZI_WHERE = "SELECT COUNT(tracciabilitaGrezzi) FROM TracciabilitaGrezzi tracciabilitaGrezzi WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tracciabilitaGrezzi.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TracciabilitaGrezzi exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TracciabilitaGrezzi exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TracciabilitaGrezziPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"lottoGrezzo", "numeroColli", "kgScarto", "idSchedaTracciabilta"
			});
	private static TracciabilitaGrezzi _nullTracciabilitaGrezzi = new TracciabilitaGrezziImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TracciabilitaGrezzi> toCacheModel() {
				return _nullTracciabilitaGrezziCacheModel;
			}
		};

	private static CacheModel<TracciabilitaGrezzi> _nullTracciabilitaGrezziCacheModel =
		new CacheModel<TracciabilitaGrezzi>() {
			@Override
			public TracciabilitaGrezzi toEntityModel() {
				return _nullTracciabilitaGrezzi;
			}
		};
}
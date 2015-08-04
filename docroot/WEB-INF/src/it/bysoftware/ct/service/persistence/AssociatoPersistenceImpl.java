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
import com.liferay.portal.kernel.util.CharPool;
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

import it.bysoftware.ct.NoSuchAssociatoException;
import it.bysoftware.ct.model.Associato;
import it.bysoftware.ct.model.impl.AssociatoImpl;
import it.bysoftware.ct.model.impl.AssociatoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the associato service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssociatoPersistence
 * @see AssociatoUtil
 * @generated
 */
public class AssociatoPersistenceImpl extends BasePersistenceImpl<Associato>
	implements AssociatoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AssociatoUtil} to access the associato persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AssociatoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AssociatoModelImpl.ENTITY_CACHE_ENABLED,
			AssociatoModelImpl.FINDER_CACHE_ENABLED, AssociatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AssociatoModelImpl.ENTITY_CACHE_ENABLED,
			AssociatoModelImpl.FINDER_CACHE_ENABLED, AssociatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AssociatoModelImpl.ENTITY_CACHE_ENABLED,
			AssociatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RAGIONESOCIALE =
		new FinderPath(AssociatoModelImpl.ENTITY_CACHE_ENABLED,
			AssociatoModelImpl.FINDER_CACHE_ENABLED, AssociatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRagioneSociale",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_RAGIONESOCIALE =
		new FinderPath(AssociatoModelImpl.ENTITY_CACHE_ENABLED,
			AssociatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByRagioneSociale",
			new String[] { String.class.getName() });

	/**
	 * Returns all the associatos where ragioneSociale LIKE &#63;.
	 *
	 * @param ragioneSociale the ragione sociale
	 * @return the matching associatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associato> findByRagioneSociale(String ragioneSociale)
		throws SystemException {
		return findByRagioneSociale(ragioneSociale, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the associatos where ragioneSociale LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AssociatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ragioneSociale the ragione sociale
	 * @param start the lower bound of the range of associatos
	 * @param end the upper bound of the range of associatos (not inclusive)
	 * @return the range of matching associatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associato> findByRagioneSociale(String ragioneSociale,
		int start, int end) throws SystemException {
		return findByRagioneSociale(ragioneSociale, start, end, null);
	}

	/**
	 * Returns an ordered range of all the associatos where ragioneSociale LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AssociatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ragioneSociale the ragione sociale
	 * @param start the lower bound of the range of associatos
	 * @param end the upper bound of the range of associatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching associatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associato> findByRagioneSociale(String ragioneSociale,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RAGIONESOCIALE;
		finderArgs = new Object[] { ragioneSociale, start, end, orderByComparator };

		List<Associato> list = (List<Associato>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Associato associato : list) {
				if (!StringUtil.wildcardMatches(associato.getRagioneSociale(),
							ragioneSociale, CharPool.UNDERLINE,
							CharPool.PERCENT, CharPool.BACK_SLASH, true)) {
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

			query.append(_SQL_SELECT_ASSOCIATO_WHERE);

			boolean bindRagioneSociale = false;

			if (ragioneSociale == null) {
				query.append(_FINDER_COLUMN_RAGIONESOCIALE_RAGIONESOCIALE_1);
			}
			else if (ragioneSociale.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RAGIONESOCIALE_RAGIONESOCIALE_3);
			}
			else {
				bindRagioneSociale = true;

				query.append(_FINDER_COLUMN_RAGIONESOCIALE_RAGIONESOCIALE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AssociatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRagioneSociale) {
					qPos.add(ragioneSociale);
				}

				if (!pagination) {
					list = (List<Associato>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Associato>(list);
				}
				else {
					list = (List<Associato>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first associato in the ordered set where ragioneSociale LIKE &#63;.
	 *
	 * @param ragioneSociale the ragione sociale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching associato
	 * @throws it.bysoftware.ct.NoSuchAssociatoException if a matching associato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associato findByRagioneSociale_First(String ragioneSociale,
		OrderByComparator orderByComparator)
		throws NoSuchAssociatoException, SystemException {
		Associato associato = fetchByRagioneSociale_First(ragioneSociale,
				orderByComparator);

		if (associato != null) {
			return associato;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ragioneSociale=");
		msg.append(ragioneSociale);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAssociatoException(msg.toString());
	}

	/**
	 * Returns the first associato in the ordered set where ragioneSociale LIKE &#63;.
	 *
	 * @param ragioneSociale the ragione sociale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching associato, or <code>null</code> if a matching associato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associato fetchByRagioneSociale_First(String ragioneSociale,
		OrderByComparator orderByComparator) throws SystemException {
		List<Associato> list = findByRagioneSociale(ragioneSociale, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last associato in the ordered set where ragioneSociale LIKE &#63;.
	 *
	 * @param ragioneSociale the ragione sociale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching associato
	 * @throws it.bysoftware.ct.NoSuchAssociatoException if a matching associato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associato findByRagioneSociale_Last(String ragioneSociale,
		OrderByComparator orderByComparator)
		throws NoSuchAssociatoException, SystemException {
		Associato associato = fetchByRagioneSociale_Last(ragioneSociale,
				orderByComparator);

		if (associato != null) {
			return associato;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ragioneSociale=");
		msg.append(ragioneSociale);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAssociatoException(msg.toString());
	}

	/**
	 * Returns the last associato in the ordered set where ragioneSociale LIKE &#63;.
	 *
	 * @param ragioneSociale the ragione sociale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching associato, or <code>null</code> if a matching associato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associato fetchByRagioneSociale_Last(String ragioneSociale,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRagioneSociale(ragioneSociale);

		if (count == 0) {
			return null;
		}

		List<Associato> list = findByRagioneSociale(ragioneSociale, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the associatos before and after the current associato in the ordered set where ragioneSociale LIKE &#63;.
	 *
	 * @param id the primary key of the current associato
	 * @param ragioneSociale the ragione sociale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next associato
	 * @throws it.bysoftware.ct.NoSuchAssociatoException if a associato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associato[] findByRagioneSociale_PrevAndNext(long id,
		String ragioneSociale, OrderByComparator orderByComparator)
		throws NoSuchAssociatoException, SystemException {
		Associato associato = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Associato[] array = new AssociatoImpl[3];

			array[0] = getByRagioneSociale_PrevAndNext(session, associato,
					ragioneSociale, orderByComparator, true);

			array[1] = associato;

			array[2] = getByRagioneSociale_PrevAndNext(session, associato,
					ragioneSociale, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Associato getByRagioneSociale_PrevAndNext(Session session,
		Associato associato, String ragioneSociale,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ASSOCIATO_WHERE);

		boolean bindRagioneSociale = false;

		if (ragioneSociale == null) {
			query.append(_FINDER_COLUMN_RAGIONESOCIALE_RAGIONESOCIALE_1);
		}
		else if (ragioneSociale.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_RAGIONESOCIALE_RAGIONESOCIALE_3);
		}
		else {
			bindRagioneSociale = true;

			query.append(_FINDER_COLUMN_RAGIONESOCIALE_RAGIONESOCIALE_2);
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
			query.append(AssociatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindRagioneSociale) {
			qPos.add(ragioneSociale);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(associato);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Associato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the associatos where ragioneSociale LIKE &#63; from the database.
	 *
	 * @param ragioneSociale the ragione sociale
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRagioneSociale(String ragioneSociale)
		throws SystemException {
		for (Associato associato : findByRagioneSociale(ragioneSociale,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(associato);
		}
	}

	/**
	 * Returns the number of associatos where ragioneSociale LIKE &#63;.
	 *
	 * @param ragioneSociale the ragione sociale
	 * @return the number of matching associatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRagioneSociale(String ragioneSociale)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_RAGIONESOCIALE;

		Object[] finderArgs = new Object[] { ragioneSociale };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ASSOCIATO_WHERE);

			boolean bindRagioneSociale = false;

			if (ragioneSociale == null) {
				query.append(_FINDER_COLUMN_RAGIONESOCIALE_RAGIONESOCIALE_1);
			}
			else if (ragioneSociale.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RAGIONESOCIALE_RAGIONESOCIALE_3);
			}
			else {
				bindRagioneSociale = true;

				query.append(_FINDER_COLUMN_RAGIONESOCIALE_RAGIONESOCIALE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRagioneSociale) {
					qPos.add(ragioneSociale);
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

	private static final String _FINDER_COLUMN_RAGIONESOCIALE_RAGIONESOCIALE_1 = "associato.ragioneSociale LIKE NULL";
	private static final String _FINDER_COLUMN_RAGIONESOCIALE_RAGIONESOCIALE_2 = "associato.ragioneSociale LIKE ?";
	private static final String _FINDER_COLUMN_RAGIONESOCIALE_RAGIONESOCIALE_3 = "(associato.ragioneSociale IS NULL OR associato.ragioneSociale LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARTITAIVA =
		new FinderPath(AssociatoModelImpl.ENTITY_CACHE_ENABLED,
			AssociatoModelImpl.FINDER_CACHE_ENABLED, AssociatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPartitaIVA",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_PARTITAIVA =
		new FinderPath(AssociatoModelImpl.ENTITY_CACHE_ENABLED,
			AssociatoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByPartitaIVA",
			new String[] { String.class.getName() });

	/**
	 * Returns all the associatos where partitaIVA LIKE &#63;.
	 *
	 * @param partitaIVA the partita i v a
	 * @return the matching associatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associato> findByPartitaIVA(String partitaIVA)
		throws SystemException {
		return findByPartitaIVA(partitaIVA, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the associatos where partitaIVA LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AssociatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param partitaIVA the partita i v a
	 * @param start the lower bound of the range of associatos
	 * @param end the upper bound of the range of associatos (not inclusive)
	 * @return the range of matching associatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associato> findByPartitaIVA(String partitaIVA, int start,
		int end) throws SystemException {
		return findByPartitaIVA(partitaIVA, start, end, null);
	}

	/**
	 * Returns an ordered range of all the associatos where partitaIVA LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AssociatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param partitaIVA the partita i v a
	 * @param start the lower bound of the range of associatos
	 * @param end the upper bound of the range of associatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching associatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associato> findByPartitaIVA(String partitaIVA, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARTITAIVA;
		finderArgs = new Object[] { partitaIVA, start, end, orderByComparator };

		List<Associato> list = (List<Associato>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Associato associato : list) {
				if (!StringUtil.wildcardMatches(associato.getPartitaIVA(),
							partitaIVA, CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true)) {
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

			query.append(_SQL_SELECT_ASSOCIATO_WHERE);

			boolean bindPartitaIVA = false;

			if (partitaIVA == null) {
				query.append(_FINDER_COLUMN_PARTITAIVA_PARTITAIVA_1);
			}
			else if (partitaIVA.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PARTITAIVA_PARTITAIVA_3);
			}
			else {
				bindPartitaIVA = true;

				query.append(_FINDER_COLUMN_PARTITAIVA_PARTITAIVA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AssociatoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPartitaIVA) {
					qPos.add(partitaIVA);
				}

				if (!pagination) {
					list = (List<Associato>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Associato>(list);
				}
				else {
					list = (List<Associato>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first associato in the ordered set where partitaIVA LIKE &#63;.
	 *
	 * @param partitaIVA the partita i v a
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching associato
	 * @throws it.bysoftware.ct.NoSuchAssociatoException if a matching associato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associato findByPartitaIVA_First(String partitaIVA,
		OrderByComparator orderByComparator)
		throws NoSuchAssociatoException, SystemException {
		Associato associato = fetchByPartitaIVA_First(partitaIVA,
				orderByComparator);

		if (associato != null) {
			return associato;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("partitaIVA=");
		msg.append(partitaIVA);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAssociatoException(msg.toString());
	}

	/**
	 * Returns the first associato in the ordered set where partitaIVA LIKE &#63;.
	 *
	 * @param partitaIVA the partita i v a
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching associato, or <code>null</code> if a matching associato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associato fetchByPartitaIVA_First(String partitaIVA,
		OrderByComparator orderByComparator) throws SystemException {
		List<Associato> list = findByPartitaIVA(partitaIVA, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last associato in the ordered set where partitaIVA LIKE &#63;.
	 *
	 * @param partitaIVA the partita i v a
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching associato
	 * @throws it.bysoftware.ct.NoSuchAssociatoException if a matching associato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associato findByPartitaIVA_Last(String partitaIVA,
		OrderByComparator orderByComparator)
		throws NoSuchAssociatoException, SystemException {
		Associato associato = fetchByPartitaIVA_Last(partitaIVA,
				orderByComparator);

		if (associato != null) {
			return associato;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("partitaIVA=");
		msg.append(partitaIVA);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAssociatoException(msg.toString());
	}

	/**
	 * Returns the last associato in the ordered set where partitaIVA LIKE &#63;.
	 *
	 * @param partitaIVA the partita i v a
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching associato, or <code>null</code> if a matching associato could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associato fetchByPartitaIVA_Last(String partitaIVA,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPartitaIVA(partitaIVA);

		if (count == 0) {
			return null;
		}

		List<Associato> list = findByPartitaIVA(partitaIVA, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the associatos before and after the current associato in the ordered set where partitaIVA LIKE &#63;.
	 *
	 * @param id the primary key of the current associato
	 * @param partitaIVA the partita i v a
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next associato
	 * @throws it.bysoftware.ct.NoSuchAssociatoException if a associato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associato[] findByPartitaIVA_PrevAndNext(long id, String partitaIVA,
		OrderByComparator orderByComparator)
		throws NoSuchAssociatoException, SystemException {
		Associato associato = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Associato[] array = new AssociatoImpl[3];

			array[0] = getByPartitaIVA_PrevAndNext(session, associato,
					partitaIVA, orderByComparator, true);

			array[1] = associato;

			array[2] = getByPartitaIVA_PrevAndNext(session, associato,
					partitaIVA, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Associato getByPartitaIVA_PrevAndNext(Session session,
		Associato associato, String partitaIVA,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ASSOCIATO_WHERE);

		boolean bindPartitaIVA = false;

		if (partitaIVA == null) {
			query.append(_FINDER_COLUMN_PARTITAIVA_PARTITAIVA_1);
		}
		else if (partitaIVA.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PARTITAIVA_PARTITAIVA_3);
		}
		else {
			bindPartitaIVA = true;

			query.append(_FINDER_COLUMN_PARTITAIVA_PARTITAIVA_2);
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
			query.append(AssociatoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindPartitaIVA) {
			qPos.add(partitaIVA);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(associato);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Associato> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the associatos where partitaIVA LIKE &#63; from the database.
	 *
	 * @param partitaIVA the partita i v a
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPartitaIVA(String partitaIVA) throws SystemException {
		for (Associato associato : findByPartitaIVA(partitaIVA,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(associato);
		}
	}

	/**
	 * Returns the number of associatos where partitaIVA LIKE &#63;.
	 *
	 * @param partitaIVA the partita i v a
	 * @return the number of matching associatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPartitaIVA(String partitaIVA) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_PARTITAIVA;

		Object[] finderArgs = new Object[] { partitaIVA };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ASSOCIATO_WHERE);

			boolean bindPartitaIVA = false;

			if (partitaIVA == null) {
				query.append(_FINDER_COLUMN_PARTITAIVA_PARTITAIVA_1);
			}
			else if (partitaIVA.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PARTITAIVA_PARTITAIVA_3);
			}
			else {
				bindPartitaIVA = true;

				query.append(_FINDER_COLUMN_PARTITAIVA_PARTITAIVA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPartitaIVA) {
					qPos.add(partitaIVA);
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

	private static final String _FINDER_COLUMN_PARTITAIVA_PARTITAIVA_1 = "associato.partitaIVA LIKE NULL";
	private static final String _FINDER_COLUMN_PARTITAIVA_PARTITAIVA_2 = "associato.partitaIVA LIKE ?";
	private static final String _FINDER_COLUMN_PARTITAIVA_PARTITAIVA_3 = "(associato.partitaIVA IS NULL OR associato.partitaIVA LIKE '')";

	public AssociatoPersistenceImpl() {
		setModelClass(Associato.class);
	}

	/**
	 * Caches the associato in the entity cache if it is enabled.
	 *
	 * @param associato the associato
	 */
	@Override
	public void cacheResult(Associato associato) {
		EntityCacheUtil.putResult(AssociatoModelImpl.ENTITY_CACHE_ENABLED,
			AssociatoImpl.class, associato.getPrimaryKey(), associato);

		associato.resetOriginalValues();
	}

	/**
	 * Caches the associatos in the entity cache if it is enabled.
	 *
	 * @param associatos the associatos
	 */
	@Override
	public void cacheResult(List<Associato> associatos) {
		for (Associato associato : associatos) {
			if (EntityCacheUtil.getResult(
						AssociatoModelImpl.ENTITY_CACHE_ENABLED,
						AssociatoImpl.class, associato.getPrimaryKey()) == null) {
				cacheResult(associato);
			}
			else {
				associato.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all associatos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AssociatoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AssociatoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the associato.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Associato associato) {
		EntityCacheUtil.removeResult(AssociatoModelImpl.ENTITY_CACHE_ENABLED,
			AssociatoImpl.class, associato.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Associato> associatos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Associato associato : associatos) {
			EntityCacheUtil.removeResult(AssociatoModelImpl.ENTITY_CACHE_ENABLED,
				AssociatoImpl.class, associato.getPrimaryKey());
		}
	}

	/**
	 * Creates a new associato with the primary key. Does not add the associato to the database.
	 *
	 * @param id the primary key for the new associato
	 * @return the new associato
	 */
	@Override
	public Associato create(long id) {
		Associato associato = new AssociatoImpl();

		associato.setNew(true);
		associato.setPrimaryKey(id);

		return associato;
	}

	/**
	 * Removes the associato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the associato
	 * @return the associato that was removed
	 * @throws it.bysoftware.ct.NoSuchAssociatoException if a associato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associato remove(long id)
		throws NoSuchAssociatoException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the associato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the associato
	 * @return the associato that was removed
	 * @throws it.bysoftware.ct.NoSuchAssociatoException if a associato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associato remove(Serializable primaryKey)
		throws NoSuchAssociatoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Associato associato = (Associato)session.get(AssociatoImpl.class,
					primaryKey);

			if (associato == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAssociatoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(associato);
		}
		catch (NoSuchAssociatoException nsee) {
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
	protected Associato removeImpl(Associato associato)
		throws SystemException {
		associato = toUnwrappedModel(associato);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(associato)) {
				associato = (Associato)session.get(AssociatoImpl.class,
						associato.getPrimaryKeyObj());
			}

			if (associato != null) {
				session.delete(associato);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (associato != null) {
			clearCache(associato);
		}

		return associato;
	}

	@Override
	public Associato updateImpl(it.bysoftware.ct.model.Associato associato)
		throws SystemException {
		associato = toUnwrappedModel(associato);

		boolean isNew = associato.isNew();

		Session session = null;

		try {
			session = openSession();

			if (associato.isNew()) {
				session.save(associato);

				associato.setNew(false);
			}
			else {
				session.merge(associato);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AssociatoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(AssociatoModelImpl.ENTITY_CACHE_ENABLED,
			AssociatoImpl.class, associato.getPrimaryKey(), associato);

		return associato;
	}

	protected Associato toUnwrappedModel(Associato associato) {
		if (associato instanceof AssociatoImpl) {
			return associato;
		}

		AssociatoImpl associatoImpl = new AssociatoImpl();

		associatoImpl.setNew(associato.isNew());
		associatoImpl.setPrimaryKey(associato.getPrimaryKey());

		associatoImpl.setId(associato.getId());
		associatoImpl.setCentro(associato.getCentro());
		associatoImpl.setRagioneSociale(associato.getRagioneSociale());
		associatoImpl.setPartitaIVA(associato.getPartitaIVA());
		associatoImpl.setIndirizzo(associato.getIndirizzo());
		associatoImpl.setTelefono(associato.getTelefono());
		associatoImpl.setFax(associato.getFax());
		associatoImpl.setEmail(associato.getEmail());
		associatoImpl.setPassword(associato.getPassword());
		associatoImpl.setIdLiferay(associato.getIdLiferay());
		associatoImpl.setIdOp(associato.getIdOp());

		return associatoImpl;
	}

	/**
	 * Returns the associato with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the associato
	 * @return the associato
	 * @throws it.bysoftware.ct.NoSuchAssociatoException if a associato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associato findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAssociatoException, SystemException {
		Associato associato = fetchByPrimaryKey(primaryKey);

		if (associato == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAssociatoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return associato;
	}

	/**
	 * Returns the associato with the primary key or throws a {@link it.bysoftware.ct.NoSuchAssociatoException} if it could not be found.
	 *
	 * @param id the primary key of the associato
	 * @return the associato
	 * @throws it.bysoftware.ct.NoSuchAssociatoException if a associato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associato findByPrimaryKey(long id)
		throws NoSuchAssociatoException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the associato with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the associato
	 * @return the associato, or <code>null</code> if a associato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associato fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Associato associato = (Associato)EntityCacheUtil.getResult(AssociatoModelImpl.ENTITY_CACHE_ENABLED,
				AssociatoImpl.class, primaryKey);

		if (associato == _nullAssociato) {
			return null;
		}

		if (associato == null) {
			Session session = null;

			try {
				session = openSession();

				associato = (Associato)session.get(AssociatoImpl.class,
						primaryKey);

				if (associato != null) {
					cacheResult(associato);
				}
				else {
					EntityCacheUtil.putResult(AssociatoModelImpl.ENTITY_CACHE_ENABLED,
						AssociatoImpl.class, primaryKey, _nullAssociato);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AssociatoModelImpl.ENTITY_CACHE_ENABLED,
					AssociatoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return associato;
	}

	/**
	 * Returns the associato with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the associato
	 * @return the associato, or <code>null</code> if a associato with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Associato fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the associatos.
	 *
	 * @return the associatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associato> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the associatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AssociatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of associatos
	 * @param end the upper bound of the range of associatos (not inclusive)
	 * @return the range of associatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associato> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the associatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.AssociatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of associatos
	 * @param end the upper bound of the range of associatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of associatos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Associato> findAll(int start, int end,
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

		List<Associato> list = (List<Associato>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ASSOCIATO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ASSOCIATO;

				if (pagination) {
					sql = sql.concat(AssociatoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Associato>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Associato>(list);
				}
				else {
					list = (List<Associato>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the associatos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Associato associato : findAll()) {
			remove(associato);
		}
	}

	/**
	 * Returns the number of associatos.
	 *
	 * @return the number of associatos
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

				Query q = session.createQuery(_SQL_COUNT_ASSOCIATO);

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
	 * Initializes the associato persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.bysoftware.ct.model.Associato")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Associato>> listenersList = new ArrayList<ModelListener<Associato>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Associato>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AssociatoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ASSOCIATO = "SELECT associato FROM Associato associato";
	private static final String _SQL_SELECT_ASSOCIATO_WHERE = "SELECT associato FROM Associato associato WHERE ";
	private static final String _SQL_COUNT_ASSOCIATO = "SELECT COUNT(associato) FROM Associato associato";
	private static final String _SQL_COUNT_ASSOCIATO_WHERE = "SELECT COUNT(associato) FROM Associato associato WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "associato.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Associato exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Associato exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AssociatoPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"ragioneSociale", "partitaIVA", "idLiferay", "idOp"
			});
	private static Associato _nullAssociato = new AssociatoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Associato> toCacheModel() {
				return _nullAssociatoCacheModel;
			}
		};

	private static CacheModel<Associato> _nullAssociatoCacheModel = new CacheModel<Associato>() {
			@Override
			public Associato toEntityModel() {
				return _nullAssociato;
			}
		};
}
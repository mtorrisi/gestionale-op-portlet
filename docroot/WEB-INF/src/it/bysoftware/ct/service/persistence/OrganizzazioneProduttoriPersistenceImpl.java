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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException;
import it.bysoftware.ct.model.OrganizzazioneProduttori;
import it.bysoftware.ct.model.impl.OrganizzazioneProduttoriImpl;
import it.bysoftware.ct.model.impl.OrganizzazioneProduttoriModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the organizzazione produttori service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizzazioneProduttoriPersistence
 * @see OrganizzazioneProduttoriUtil
 * @generated
 */
public class OrganizzazioneProduttoriPersistenceImpl extends BasePersistenceImpl<OrganizzazioneProduttori>
	implements OrganizzazioneProduttoriPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OrganizzazioneProduttoriUtil} to access the organizzazione produttori persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OrganizzazioneProduttoriImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OrganizzazioneProduttoriModelImpl.ENTITY_CACHE_ENABLED,
			OrganizzazioneProduttoriModelImpl.FINDER_CACHE_ENABLED,
			OrganizzazioneProduttoriImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OrganizzazioneProduttoriModelImpl.ENTITY_CACHE_ENABLED,
			OrganizzazioneProduttoriModelImpl.FINDER_CACHE_ENABLED,
			OrganizzazioneProduttoriImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OrganizzazioneProduttoriModelImpl.ENTITY_CACHE_ENABLED,
			OrganizzazioneProduttoriModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RAGIONESOCIALE =
		new FinderPath(OrganizzazioneProduttoriModelImpl.ENTITY_CACHE_ENABLED,
			OrganizzazioneProduttoriModelImpl.FINDER_CACHE_ENABLED,
			OrganizzazioneProduttoriImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRagioneSociale",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_RAGIONESOCIALE =
		new FinderPath(OrganizzazioneProduttoriModelImpl.ENTITY_CACHE_ENABLED,
			OrganizzazioneProduttoriModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByRagioneSociale",
			new String[] { String.class.getName() });

	/**
	 * Returns all the organizzazione produttoris where ragioneSociale LIKE &#63;.
	 *
	 * @param ragioneSociale the ragione sociale
	 * @return the matching organizzazione produttoris
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrganizzazioneProduttori> findByRagioneSociale(
		String ragioneSociale) throws SystemException {
		return findByRagioneSociale(ragioneSociale, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organizzazione produttoris where ragioneSociale LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.OrganizzazioneProduttoriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ragioneSociale the ragione sociale
	 * @param start the lower bound of the range of organizzazione produttoris
	 * @param end the upper bound of the range of organizzazione produttoris (not inclusive)
	 * @return the range of matching organizzazione produttoris
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrganizzazioneProduttori> findByRagioneSociale(
		String ragioneSociale, int start, int end) throws SystemException {
		return findByRagioneSociale(ragioneSociale, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organizzazione produttoris where ragioneSociale LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.OrganizzazioneProduttoriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ragioneSociale the ragione sociale
	 * @param start the lower bound of the range of organizzazione produttoris
	 * @param end the upper bound of the range of organizzazione produttoris (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organizzazione produttoris
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrganizzazioneProduttori> findByRagioneSociale(
		String ragioneSociale, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RAGIONESOCIALE;
		finderArgs = new Object[] { ragioneSociale, start, end, orderByComparator };

		List<OrganizzazioneProduttori> list = (List<OrganizzazioneProduttori>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (OrganizzazioneProduttori organizzazioneProduttori : list) {
				if (!StringUtil.wildcardMatches(
							organizzazioneProduttori.getRagioneSociale(),
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

			query.append(_SQL_SELECT_ORGANIZZAZIONEPRODUTTORI_WHERE);

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
				query.append(OrganizzazioneProduttoriModelImpl.ORDER_BY_JPQL);
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
					list = (List<OrganizzazioneProduttori>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OrganizzazioneProduttori>(list);
				}
				else {
					list = (List<OrganizzazioneProduttori>)QueryUtil.list(q,
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
	 * Returns the first organizzazione produttori in the ordered set where ragioneSociale LIKE &#63;.
	 *
	 * @param ragioneSociale the ragione sociale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organizzazione produttori
	 * @throws it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException if a matching organizzazione produttori could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizzazioneProduttori findByRagioneSociale_First(
		String ragioneSociale, OrderByComparator orderByComparator)
		throws NoSuchOrganizzazioneProduttoriException, SystemException {
		OrganizzazioneProduttori organizzazioneProduttori = fetchByRagioneSociale_First(ragioneSociale,
				orderByComparator);

		if (organizzazioneProduttori != null) {
			return organizzazioneProduttori;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ragioneSociale=");
		msg.append(ragioneSociale);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizzazioneProduttoriException(msg.toString());
	}

	/**
	 * Returns the first organizzazione produttori in the ordered set where ragioneSociale LIKE &#63;.
	 *
	 * @param ragioneSociale the ragione sociale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organizzazione produttori, or <code>null</code> if a matching organizzazione produttori could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizzazioneProduttori fetchByRagioneSociale_First(
		String ragioneSociale, OrderByComparator orderByComparator)
		throws SystemException {
		List<OrganizzazioneProduttori> list = findByRagioneSociale(ragioneSociale,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organizzazione produttori in the ordered set where ragioneSociale LIKE &#63;.
	 *
	 * @param ragioneSociale the ragione sociale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organizzazione produttori
	 * @throws it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException if a matching organizzazione produttori could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizzazioneProduttori findByRagioneSociale_Last(
		String ragioneSociale, OrderByComparator orderByComparator)
		throws NoSuchOrganizzazioneProduttoriException, SystemException {
		OrganizzazioneProduttori organizzazioneProduttori = fetchByRagioneSociale_Last(ragioneSociale,
				orderByComparator);

		if (organizzazioneProduttori != null) {
			return organizzazioneProduttori;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ragioneSociale=");
		msg.append(ragioneSociale);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizzazioneProduttoriException(msg.toString());
	}

	/**
	 * Returns the last organizzazione produttori in the ordered set where ragioneSociale LIKE &#63;.
	 *
	 * @param ragioneSociale the ragione sociale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organizzazione produttori, or <code>null</code> if a matching organizzazione produttori could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizzazioneProduttori fetchByRagioneSociale_Last(
		String ragioneSociale, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByRagioneSociale(ragioneSociale);

		if (count == 0) {
			return null;
		}

		List<OrganizzazioneProduttori> list = findByRagioneSociale(ragioneSociale,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organizzazione produttoris before and after the current organizzazione produttori in the ordered set where ragioneSociale LIKE &#63;.
	 *
	 * @param id the primary key of the current organizzazione produttori
	 * @param ragioneSociale the ragione sociale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organizzazione produttori
	 * @throws it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException if a organizzazione produttori with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizzazioneProduttori[] findByRagioneSociale_PrevAndNext(
		long id, String ragioneSociale, OrderByComparator orderByComparator)
		throws NoSuchOrganizzazioneProduttoriException, SystemException {
		OrganizzazioneProduttori organizzazioneProduttori = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			OrganizzazioneProduttori[] array = new OrganizzazioneProduttoriImpl[3];

			array[0] = getByRagioneSociale_PrevAndNext(session,
					organizzazioneProduttori, ragioneSociale,
					orderByComparator, true);

			array[1] = organizzazioneProduttori;

			array[2] = getByRagioneSociale_PrevAndNext(session,
					organizzazioneProduttori, ragioneSociale,
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

	protected OrganizzazioneProduttori getByRagioneSociale_PrevAndNext(
		Session session, OrganizzazioneProduttori organizzazioneProduttori,
		String ragioneSociale, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ORGANIZZAZIONEPRODUTTORI_WHERE);

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
			query.append(OrganizzazioneProduttoriModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(organizzazioneProduttori);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OrganizzazioneProduttori> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organizzazione produttoris where ragioneSociale LIKE &#63; from the database.
	 *
	 * @param ragioneSociale the ragione sociale
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRagioneSociale(String ragioneSociale)
		throws SystemException {
		for (OrganizzazioneProduttori organizzazioneProduttori : findByRagioneSociale(
				ragioneSociale, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(organizzazioneProduttori);
		}
	}

	/**
	 * Returns the number of organizzazione produttoris where ragioneSociale LIKE &#63;.
	 *
	 * @param ragioneSociale the ragione sociale
	 * @return the number of matching organizzazione produttoris
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

			query.append(_SQL_COUNT_ORGANIZZAZIONEPRODUTTORI_WHERE);

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

	private static final String _FINDER_COLUMN_RAGIONESOCIALE_RAGIONESOCIALE_1 = "organizzazioneProduttori.ragioneSociale LIKE NULL";
	private static final String _FINDER_COLUMN_RAGIONESOCIALE_RAGIONESOCIALE_2 = "organizzazioneProduttori.ragioneSociale LIKE ?";
	private static final String _FINDER_COLUMN_RAGIONESOCIALE_RAGIONESOCIALE_3 = "(organizzazioneProduttori.ragioneSociale IS NULL OR organizzazioneProduttori.ragioneSociale LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARTITAIVA =
		new FinderPath(OrganizzazioneProduttoriModelImpl.ENTITY_CACHE_ENABLED,
			OrganizzazioneProduttoriModelImpl.FINDER_CACHE_ENABLED,
			OrganizzazioneProduttoriImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPartitaIVA",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_PARTITAIVA =
		new FinderPath(OrganizzazioneProduttoriModelImpl.ENTITY_CACHE_ENABLED,
			OrganizzazioneProduttoriModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByPartitaIVA",
			new String[] { String.class.getName() });

	/**
	 * Returns all the organizzazione produttoris where partitaIVA LIKE &#63;.
	 *
	 * @param partitaIVA the partita i v a
	 * @return the matching organizzazione produttoris
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrganizzazioneProduttori> findByPartitaIVA(String partitaIVA)
		throws SystemException {
		return findByPartitaIVA(partitaIVA, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organizzazione produttoris where partitaIVA LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.OrganizzazioneProduttoriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param partitaIVA the partita i v a
	 * @param start the lower bound of the range of organizzazione produttoris
	 * @param end the upper bound of the range of organizzazione produttoris (not inclusive)
	 * @return the range of matching organizzazione produttoris
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrganizzazioneProduttori> findByPartitaIVA(String partitaIVA,
		int start, int end) throws SystemException {
		return findByPartitaIVA(partitaIVA, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organizzazione produttoris where partitaIVA LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.OrganizzazioneProduttoriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param partitaIVA the partita i v a
	 * @param start the lower bound of the range of organizzazione produttoris
	 * @param end the upper bound of the range of organizzazione produttoris (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organizzazione produttoris
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrganizzazioneProduttori> findByPartitaIVA(String partitaIVA,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARTITAIVA;
		finderArgs = new Object[] { partitaIVA, start, end, orderByComparator };

		List<OrganizzazioneProduttori> list = (List<OrganizzazioneProduttori>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (OrganizzazioneProduttori organizzazioneProduttori : list) {
				if (!StringUtil.wildcardMatches(
							organizzazioneProduttori.getPartitaIVA(),
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

			query.append(_SQL_SELECT_ORGANIZZAZIONEPRODUTTORI_WHERE);

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
				query.append(OrganizzazioneProduttoriModelImpl.ORDER_BY_JPQL);
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
					list = (List<OrganizzazioneProduttori>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OrganizzazioneProduttori>(list);
				}
				else {
					list = (List<OrganizzazioneProduttori>)QueryUtil.list(q,
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
	 * Returns the first organizzazione produttori in the ordered set where partitaIVA LIKE &#63;.
	 *
	 * @param partitaIVA the partita i v a
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organizzazione produttori
	 * @throws it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException if a matching organizzazione produttori could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizzazioneProduttori findByPartitaIVA_First(String partitaIVA,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizzazioneProduttoriException, SystemException {
		OrganizzazioneProduttori organizzazioneProduttori = fetchByPartitaIVA_First(partitaIVA,
				orderByComparator);

		if (organizzazioneProduttori != null) {
			return organizzazioneProduttori;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("partitaIVA=");
		msg.append(partitaIVA);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizzazioneProduttoriException(msg.toString());
	}

	/**
	 * Returns the first organizzazione produttori in the ordered set where partitaIVA LIKE &#63;.
	 *
	 * @param partitaIVA the partita i v a
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organizzazione produttori, or <code>null</code> if a matching organizzazione produttori could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizzazioneProduttori fetchByPartitaIVA_First(String partitaIVA,
		OrderByComparator orderByComparator) throws SystemException {
		List<OrganizzazioneProduttori> list = findByPartitaIVA(partitaIVA, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organizzazione produttori in the ordered set where partitaIVA LIKE &#63;.
	 *
	 * @param partitaIVA the partita i v a
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organizzazione produttori
	 * @throws it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException if a matching organizzazione produttori could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizzazioneProduttori findByPartitaIVA_Last(String partitaIVA,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizzazioneProduttoriException, SystemException {
		OrganizzazioneProduttori organizzazioneProduttori = fetchByPartitaIVA_Last(partitaIVA,
				orderByComparator);

		if (organizzazioneProduttori != null) {
			return organizzazioneProduttori;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("partitaIVA=");
		msg.append(partitaIVA);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizzazioneProduttoriException(msg.toString());
	}

	/**
	 * Returns the last organizzazione produttori in the ordered set where partitaIVA LIKE &#63;.
	 *
	 * @param partitaIVA the partita i v a
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organizzazione produttori, or <code>null</code> if a matching organizzazione produttori could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizzazioneProduttori fetchByPartitaIVA_Last(String partitaIVA,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPartitaIVA(partitaIVA);

		if (count == 0) {
			return null;
		}

		List<OrganizzazioneProduttori> list = findByPartitaIVA(partitaIVA,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organizzazione produttoris before and after the current organizzazione produttori in the ordered set where partitaIVA LIKE &#63;.
	 *
	 * @param id the primary key of the current organizzazione produttori
	 * @param partitaIVA the partita i v a
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organizzazione produttori
	 * @throws it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException if a organizzazione produttori with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizzazioneProduttori[] findByPartitaIVA_PrevAndNext(long id,
		String partitaIVA, OrderByComparator orderByComparator)
		throws NoSuchOrganizzazioneProduttoriException, SystemException {
		OrganizzazioneProduttori organizzazioneProduttori = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			OrganizzazioneProduttori[] array = new OrganizzazioneProduttoriImpl[3];

			array[0] = getByPartitaIVA_PrevAndNext(session,
					organizzazioneProduttori, partitaIVA, orderByComparator,
					true);

			array[1] = organizzazioneProduttori;

			array[2] = getByPartitaIVA_PrevAndNext(session,
					organizzazioneProduttori, partitaIVA, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected OrganizzazioneProduttori getByPartitaIVA_PrevAndNext(
		Session session, OrganizzazioneProduttori organizzazioneProduttori,
		String partitaIVA, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ORGANIZZAZIONEPRODUTTORI_WHERE);

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
			query.append(OrganizzazioneProduttoriModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(organizzazioneProduttori);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OrganizzazioneProduttori> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organizzazione produttoris where partitaIVA LIKE &#63; from the database.
	 *
	 * @param partitaIVA the partita i v a
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPartitaIVA(String partitaIVA) throws SystemException {
		for (OrganizzazioneProduttori organizzazioneProduttori : findByPartitaIVA(
				partitaIVA, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(organizzazioneProduttori);
		}
	}

	/**
	 * Returns the number of organizzazione produttoris where partitaIVA LIKE &#63;.
	 *
	 * @param partitaIVA the partita i v a
	 * @return the number of matching organizzazione produttoris
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

			query.append(_SQL_COUNT_ORGANIZZAZIONEPRODUTTORI_WHERE);

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

	private static final String _FINDER_COLUMN_PARTITAIVA_PARTITAIVA_1 = "organizzazioneProduttori.partitaIVA LIKE NULL";
	private static final String _FINDER_COLUMN_PARTITAIVA_PARTITAIVA_2 = "organizzazioneProduttori.partitaIVA LIKE ?";
	private static final String _FINDER_COLUMN_PARTITAIVA_PARTITAIVA_3 = "(organizzazioneProduttori.partitaIVA IS NULL OR organizzazioneProduttori.partitaIVA LIKE '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_IDLIFERAY = new FinderPath(OrganizzazioneProduttoriModelImpl.ENTITY_CACHE_ENABLED,
			OrganizzazioneProduttoriModelImpl.FINDER_CACHE_ENABLED,
			OrganizzazioneProduttoriImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByIdLiferay", new String[] { Long.class.getName() },
			OrganizzazioneProduttoriModelImpl.IDLIFERAY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IDLIFERAY = new FinderPath(OrganizzazioneProduttoriModelImpl.ENTITY_CACHE_ENABLED,
			OrganizzazioneProduttoriModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIdLiferay",
			new String[] { Long.class.getName() });

	/**
	 * Returns the organizzazione produttori where idLiferay = &#63; or throws a {@link it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException} if it could not be found.
	 *
	 * @param idLiferay the id liferay
	 * @return the matching organizzazione produttori
	 * @throws it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException if a matching organizzazione produttori could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizzazioneProduttori findByIdLiferay(long idLiferay)
		throws NoSuchOrganizzazioneProduttoriException, SystemException {
		OrganizzazioneProduttori organizzazioneProduttori = fetchByIdLiferay(idLiferay);

		if (organizzazioneProduttori == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("idLiferay=");
			msg.append(idLiferay);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchOrganizzazioneProduttoriException(msg.toString());
		}

		return organizzazioneProduttori;
	}

	/**
	 * Returns the organizzazione produttori where idLiferay = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param idLiferay the id liferay
	 * @return the matching organizzazione produttori, or <code>null</code> if a matching organizzazione produttori could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizzazioneProduttori fetchByIdLiferay(long idLiferay)
		throws SystemException {
		return fetchByIdLiferay(idLiferay, true);
	}

	/**
	 * Returns the organizzazione produttori where idLiferay = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param idLiferay the id liferay
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching organizzazione produttori, or <code>null</code> if a matching organizzazione produttori could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizzazioneProduttori fetchByIdLiferay(long idLiferay,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { idLiferay };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_IDLIFERAY,
					finderArgs, this);
		}

		if (result instanceof OrganizzazioneProduttori) {
			OrganizzazioneProduttori organizzazioneProduttori = (OrganizzazioneProduttori)result;

			if ((idLiferay != organizzazioneProduttori.getIdLiferay())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ORGANIZZAZIONEPRODUTTORI_WHERE);

			query.append(_FINDER_COLUMN_IDLIFERAY_IDLIFERAY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(idLiferay);

				List<OrganizzazioneProduttori> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDLIFERAY,
						finderArgs, list);
				}
				else {
					OrganizzazioneProduttori organizzazioneProduttori = list.get(0);

					result = organizzazioneProduttori;

					cacheResult(organizzazioneProduttori);

					if ((organizzazioneProduttori.getIdLiferay() != idLiferay)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDLIFERAY,
							finderArgs, organizzazioneProduttori);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_IDLIFERAY,
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
			return (OrganizzazioneProduttori)result;
		}
	}

	/**
	 * Removes the organizzazione produttori where idLiferay = &#63; from the database.
	 *
	 * @param idLiferay the id liferay
	 * @return the organizzazione produttori that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizzazioneProduttori removeByIdLiferay(long idLiferay)
		throws NoSuchOrganizzazioneProduttoriException, SystemException {
		OrganizzazioneProduttori organizzazioneProduttori = findByIdLiferay(idLiferay);

		return remove(organizzazioneProduttori);
	}

	/**
	 * Returns the number of organizzazione produttoris where idLiferay = &#63;.
	 *
	 * @param idLiferay the id liferay
	 * @return the number of matching organizzazione produttoris
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByIdLiferay(long idLiferay) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_IDLIFERAY;

		Object[] finderArgs = new Object[] { idLiferay };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ORGANIZZAZIONEPRODUTTORI_WHERE);

			query.append(_FINDER_COLUMN_IDLIFERAY_IDLIFERAY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(idLiferay);

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

	private static final String _FINDER_COLUMN_IDLIFERAY_IDLIFERAY_2 = "organizzazioneProduttori.idLiferay = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_EMAIL = new FinderPath(OrganizzazioneProduttoriModelImpl.ENTITY_CACHE_ENABLED,
			OrganizzazioneProduttoriModelImpl.FINDER_CACHE_ENABLED,
			OrganizzazioneProduttoriImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByEmail", new String[] { String.class.getName() },
			OrganizzazioneProduttoriModelImpl.EMAIL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAIL = new FinderPath(OrganizzazioneProduttoriModelImpl.ENTITY_CACHE_ENABLED,
			OrganizzazioneProduttoriModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmail",
			new String[] { String.class.getName() });

	/**
	 * Returns the organizzazione produttori where email = &#63; or throws a {@link it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException} if it could not be found.
	 *
	 * @param email the email
	 * @return the matching organizzazione produttori
	 * @throws it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException if a matching organizzazione produttori could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizzazioneProduttori findByEmail(String email)
		throws NoSuchOrganizzazioneProduttoriException, SystemException {
		OrganizzazioneProduttori organizzazioneProduttori = fetchByEmail(email);

		if (organizzazioneProduttori == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("email=");
			msg.append(email);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchOrganizzazioneProduttoriException(msg.toString());
		}

		return organizzazioneProduttori;
	}

	/**
	 * Returns the organizzazione produttori where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param email the email
	 * @return the matching organizzazione produttori, or <code>null</code> if a matching organizzazione produttori could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizzazioneProduttori fetchByEmail(String email)
		throws SystemException {
		return fetchByEmail(email, true);
	}

	/**
	 * Returns the organizzazione produttori where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param email the email
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching organizzazione produttori, or <code>null</code> if a matching organizzazione produttori could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizzazioneProduttori fetchByEmail(String email,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { email };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EMAIL,
					finderArgs, this);
		}

		if (result instanceof OrganizzazioneProduttori) {
			OrganizzazioneProduttori organizzazioneProduttori = (OrganizzazioneProduttori)result;

			if (!Validator.equals(email, organizzazioneProduttori.getEmail())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ORGANIZZAZIONEPRODUTTORI_WHERE);

			boolean bindEmail = false;

			if (email == null) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
			}
			else if (email.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmail) {
					qPos.add(email);
				}

				List<OrganizzazioneProduttori> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAIL,
						finderArgs, list);
				}
				else {
					OrganizzazioneProduttori organizzazioneProduttori = list.get(0);

					result = organizzazioneProduttori;

					cacheResult(organizzazioneProduttori);

					if ((organizzazioneProduttori.getEmail() == null) ||
							!organizzazioneProduttori.getEmail().equals(email)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAIL,
							finderArgs, organizzazioneProduttori);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAIL,
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
			return (OrganizzazioneProduttori)result;
		}
	}

	/**
	 * Removes the organizzazione produttori where email = &#63; from the database.
	 *
	 * @param email the email
	 * @return the organizzazione produttori that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizzazioneProduttori removeByEmail(String email)
		throws NoSuchOrganizzazioneProduttoriException, SystemException {
		OrganizzazioneProduttori organizzazioneProduttori = findByEmail(email);

		return remove(organizzazioneProduttori);
	}

	/**
	 * Returns the number of organizzazione produttoris where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching organizzazione produttoris
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEmail(String email) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAIL;

		Object[] finderArgs = new Object[] { email };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ORGANIZZAZIONEPRODUTTORI_WHERE);

			boolean bindEmail = false;

			if (email == null) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
			}
			else if (email.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmail) {
					qPos.add(email);
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

	private static final String _FINDER_COLUMN_EMAIL_EMAIL_1 = "organizzazioneProduttori.email IS NULL";
	private static final String _FINDER_COLUMN_EMAIL_EMAIL_2 = "organizzazioneProduttori.email = ?";
	private static final String _FINDER_COLUMN_EMAIL_EMAIL_3 = "(organizzazioneProduttori.email IS NULL OR organizzazioneProduttori.email = '')";

	public OrganizzazioneProduttoriPersistenceImpl() {
		setModelClass(OrganizzazioneProduttori.class);
	}

	/**
	 * Caches the organizzazione produttori in the entity cache if it is enabled.
	 *
	 * @param organizzazioneProduttori the organizzazione produttori
	 */
	@Override
	public void cacheResult(OrganizzazioneProduttori organizzazioneProduttori) {
		EntityCacheUtil.putResult(OrganizzazioneProduttoriModelImpl.ENTITY_CACHE_ENABLED,
			OrganizzazioneProduttoriImpl.class,
			organizzazioneProduttori.getPrimaryKey(), organizzazioneProduttori);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDLIFERAY,
			new Object[] { organizzazioneProduttori.getIdLiferay() },
			organizzazioneProduttori);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAIL,
			new Object[] { organizzazioneProduttori.getEmail() },
			organizzazioneProduttori);

		organizzazioneProduttori.resetOriginalValues();
	}

	/**
	 * Caches the organizzazione produttoris in the entity cache if it is enabled.
	 *
	 * @param organizzazioneProduttoris the organizzazione produttoris
	 */
	@Override
	public void cacheResult(
		List<OrganizzazioneProduttori> organizzazioneProduttoris) {
		for (OrganizzazioneProduttori organizzazioneProduttori : organizzazioneProduttoris) {
			if (EntityCacheUtil.getResult(
						OrganizzazioneProduttoriModelImpl.ENTITY_CACHE_ENABLED,
						OrganizzazioneProduttoriImpl.class,
						organizzazioneProduttori.getPrimaryKey()) == null) {
				cacheResult(organizzazioneProduttori);
			}
			else {
				organizzazioneProduttori.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all organizzazione produttoris.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OrganizzazioneProduttoriImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OrganizzazioneProduttoriImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the organizzazione produttori.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OrganizzazioneProduttori organizzazioneProduttori) {
		EntityCacheUtil.removeResult(OrganizzazioneProduttoriModelImpl.ENTITY_CACHE_ENABLED,
			OrganizzazioneProduttoriImpl.class,
			organizzazioneProduttori.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(organizzazioneProduttori);
	}

	@Override
	public void clearCache(
		List<OrganizzazioneProduttori> organizzazioneProduttoris) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OrganizzazioneProduttori organizzazioneProduttori : organizzazioneProduttoris) {
			EntityCacheUtil.removeResult(OrganizzazioneProduttoriModelImpl.ENTITY_CACHE_ENABLED,
				OrganizzazioneProduttoriImpl.class,
				organizzazioneProduttori.getPrimaryKey());

			clearUniqueFindersCache(organizzazioneProduttori);
		}
	}

	protected void cacheUniqueFindersCache(
		OrganizzazioneProduttori organizzazioneProduttori) {
		if (organizzazioneProduttori.isNew()) {
			Object[] args = new Object[] { organizzazioneProduttori.getIdLiferay() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_IDLIFERAY, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDLIFERAY, args,
				organizzazioneProduttori);

			args = new Object[] { organizzazioneProduttori.getEmail() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAIL, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAIL, args,
				organizzazioneProduttori);
		}
		else {
			OrganizzazioneProduttoriModelImpl organizzazioneProduttoriModelImpl = (OrganizzazioneProduttoriModelImpl)organizzazioneProduttori;

			if ((organizzazioneProduttoriModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_IDLIFERAY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						organizzazioneProduttori.getIdLiferay()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_IDLIFERAY, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDLIFERAY, args,
					organizzazioneProduttori);
			}

			if ((organizzazioneProduttoriModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EMAIL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { organizzazioneProduttori.getEmail() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAIL, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAIL, args,
					organizzazioneProduttori);
			}
		}
	}

	protected void clearUniqueFindersCache(
		OrganizzazioneProduttori organizzazioneProduttori) {
		OrganizzazioneProduttoriModelImpl organizzazioneProduttoriModelImpl = (OrganizzazioneProduttoriModelImpl)organizzazioneProduttori;

		Object[] args = new Object[] { organizzazioneProduttori.getIdLiferay() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDLIFERAY, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_IDLIFERAY, args);

		if ((organizzazioneProduttoriModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_IDLIFERAY.getColumnBitmask()) != 0) {
			args = new Object[] {
					organizzazioneProduttoriModelImpl.getOriginalIdLiferay()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDLIFERAY, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_IDLIFERAY, args);
		}

		args = new Object[] { organizzazioneProduttori.getEmail() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAIL, args);

		if ((organizzazioneProduttoriModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMAIL.getColumnBitmask()) != 0) {
			args = new Object[] {
					organizzazioneProduttoriModelImpl.getOriginalEmail()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAIL, args);
		}
	}

	/**
	 * Creates a new organizzazione produttori with the primary key. Does not add the organizzazione produttori to the database.
	 *
	 * @param id the primary key for the new organizzazione produttori
	 * @return the new organizzazione produttori
	 */
	@Override
	public OrganizzazioneProduttori create(long id) {
		OrganizzazioneProduttori organizzazioneProduttori = new OrganizzazioneProduttoriImpl();

		organizzazioneProduttori.setNew(true);
		organizzazioneProduttori.setPrimaryKey(id);

		return organizzazioneProduttori;
	}

	/**
	 * Removes the organizzazione produttori with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the organizzazione produttori
	 * @return the organizzazione produttori that was removed
	 * @throws it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException if a organizzazione produttori with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizzazioneProduttori remove(long id)
		throws NoSuchOrganizzazioneProduttoriException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the organizzazione produttori with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the organizzazione produttori
	 * @return the organizzazione produttori that was removed
	 * @throws it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException if a organizzazione produttori with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizzazioneProduttori remove(Serializable primaryKey)
		throws NoSuchOrganizzazioneProduttoriException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OrganizzazioneProduttori organizzazioneProduttori = (OrganizzazioneProduttori)session.get(OrganizzazioneProduttoriImpl.class,
					primaryKey);

			if (organizzazioneProduttori == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrganizzazioneProduttoriException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(organizzazioneProduttori);
		}
		catch (NoSuchOrganizzazioneProduttoriException nsee) {
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
	protected OrganizzazioneProduttori removeImpl(
		OrganizzazioneProduttori organizzazioneProduttori)
		throws SystemException {
		organizzazioneProduttori = toUnwrappedModel(organizzazioneProduttori);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(organizzazioneProduttori)) {
				organizzazioneProduttori = (OrganizzazioneProduttori)session.get(OrganizzazioneProduttoriImpl.class,
						organizzazioneProduttori.getPrimaryKeyObj());
			}

			if (organizzazioneProduttori != null) {
				session.delete(organizzazioneProduttori);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (organizzazioneProduttori != null) {
			clearCache(organizzazioneProduttori);
		}

		return organizzazioneProduttori;
	}

	@Override
	public OrganizzazioneProduttori updateImpl(
		it.bysoftware.ct.model.OrganizzazioneProduttori organizzazioneProduttori)
		throws SystemException {
		organizzazioneProduttori = toUnwrappedModel(organizzazioneProduttori);

		boolean isNew = organizzazioneProduttori.isNew();

		Session session = null;

		try {
			session = openSession();

			if (organizzazioneProduttori.isNew()) {
				session.save(organizzazioneProduttori);

				organizzazioneProduttori.setNew(false);
			}
			else {
				session.merge(organizzazioneProduttori);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !OrganizzazioneProduttoriModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(OrganizzazioneProduttoriModelImpl.ENTITY_CACHE_ENABLED,
			OrganizzazioneProduttoriImpl.class,
			organizzazioneProduttori.getPrimaryKey(), organizzazioneProduttori);

		clearUniqueFindersCache(organizzazioneProduttori);
		cacheUniqueFindersCache(organizzazioneProduttori);

		return organizzazioneProduttori;
	}

	protected OrganizzazioneProduttori toUnwrappedModel(
		OrganizzazioneProduttori organizzazioneProduttori) {
		if (organizzazioneProduttori instanceof OrganizzazioneProduttoriImpl) {
			return organizzazioneProduttori;
		}

		OrganizzazioneProduttoriImpl organizzazioneProduttoriImpl = new OrganizzazioneProduttoriImpl();

		organizzazioneProduttoriImpl.setNew(organizzazioneProduttori.isNew());
		organizzazioneProduttoriImpl.setPrimaryKey(organizzazioneProduttori.getPrimaryKey());

		organizzazioneProduttoriImpl.setId(organizzazioneProduttori.getId());
		organizzazioneProduttoriImpl.setRagioneSociale(organizzazioneProduttori.getRagioneSociale());
		organizzazioneProduttoriImpl.setPartitaIVA(organizzazioneProduttori.getPartitaIVA());
		organizzazioneProduttoriImpl.setIndirizzo(organizzazioneProduttori.getIndirizzo());
		organizzazioneProduttoriImpl.setTelefono(organizzazioneProduttori.getTelefono());
		organizzazioneProduttoriImpl.setFax(organizzazioneProduttori.getFax());
		organizzazioneProduttoriImpl.setSitoWeb(organizzazioneProduttori.getSitoWeb());
		organizzazioneProduttoriImpl.setEmail(organizzazioneProduttori.getEmail());
		organizzazioneProduttoriImpl.setPassword(organizzazioneProduttori.getPassword());
		organizzazioneProduttoriImpl.setIdLiferay(organizzazioneProduttori.getIdLiferay());

		return organizzazioneProduttoriImpl;
	}

	/**
	 * Returns the organizzazione produttori with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the organizzazione produttori
	 * @return the organizzazione produttori
	 * @throws it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException if a organizzazione produttori with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizzazioneProduttori findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOrganizzazioneProduttoriException, SystemException {
		OrganizzazioneProduttori organizzazioneProduttori = fetchByPrimaryKey(primaryKey);

		if (organizzazioneProduttori == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOrganizzazioneProduttoriException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return organizzazioneProduttori;
	}

	/**
	 * Returns the organizzazione produttori with the primary key or throws a {@link it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException} if it could not be found.
	 *
	 * @param id the primary key of the organizzazione produttori
	 * @return the organizzazione produttori
	 * @throws it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException if a organizzazione produttori with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizzazioneProduttori findByPrimaryKey(long id)
		throws NoSuchOrganizzazioneProduttoriException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the organizzazione produttori with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the organizzazione produttori
	 * @return the organizzazione produttori, or <code>null</code> if a organizzazione produttori with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizzazioneProduttori fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		OrganizzazioneProduttori organizzazioneProduttori = (OrganizzazioneProduttori)EntityCacheUtil.getResult(OrganizzazioneProduttoriModelImpl.ENTITY_CACHE_ENABLED,
				OrganizzazioneProduttoriImpl.class, primaryKey);

		if (organizzazioneProduttori == _nullOrganizzazioneProduttori) {
			return null;
		}

		if (organizzazioneProduttori == null) {
			Session session = null;

			try {
				session = openSession();

				organizzazioneProduttori = (OrganizzazioneProduttori)session.get(OrganizzazioneProduttoriImpl.class,
						primaryKey);

				if (organizzazioneProduttori != null) {
					cacheResult(organizzazioneProduttori);
				}
				else {
					EntityCacheUtil.putResult(OrganizzazioneProduttoriModelImpl.ENTITY_CACHE_ENABLED,
						OrganizzazioneProduttoriImpl.class, primaryKey,
						_nullOrganizzazioneProduttori);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(OrganizzazioneProduttoriModelImpl.ENTITY_CACHE_ENABLED,
					OrganizzazioneProduttoriImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return organizzazioneProduttori;
	}

	/**
	 * Returns the organizzazione produttori with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the organizzazione produttori
	 * @return the organizzazione produttori, or <code>null</code> if a organizzazione produttori with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrganizzazioneProduttori fetchByPrimaryKey(long id)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the organizzazione produttoris.
	 *
	 * @return the organizzazione produttoris
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrganizzazioneProduttori> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organizzazione produttoris.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.OrganizzazioneProduttoriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of organizzazione produttoris
	 * @param end the upper bound of the range of organizzazione produttoris (not inclusive)
	 * @return the range of organizzazione produttoris
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrganizzazioneProduttori> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the organizzazione produttoris.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.OrganizzazioneProduttoriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of organizzazione produttoris
	 * @param end the upper bound of the range of organizzazione produttoris (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of organizzazione produttoris
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrganizzazioneProduttori> findAll(int start, int end,
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

		List<OrganizzazioneProduttori> list = (List<OrganizzazioneProduttori>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ORGANIZZAZIONEPRODUTTORI);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ORGANIZZAZIONEPRODUTTORI;

				if (pagination) {
					sql = sql.concat(OrganizzazioneProduttoriModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<OrganizzazioneProduttori>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OrganizzazioneProduttori>(list);
				}
				else {
					list = (List<OrganizzazioneProduttori>)QueryUtil.list(q,
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
	 * Removes all the organizzazione produttoris from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (OrganizzazioneProduttori organizzazioneProduttori : findAll()) {
			remove(organizzazioneProduttori);
		}
	}

	/**
	 * Returns the number of organizzazione produttoris.
	 *
	 * @return the number of organizzazione produttoris
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

				Query q = session.createQuery(_SQL_COUNT_ORGANIZZAZIONEPRODUTTORI);

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
	 * Initializes the organizzazione produttori persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.bysoftware.ct.model.OrganizzazioneProduttori")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OrganizzazioneProduttori>> listenersList = new ArrayList<ModelListener<OrganizzazioneProduttori>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OrganizzazioneProduttori>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OrganizzazioneProduttoriImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ORGANIZZAZIONEPRODUTTORI = "SELECT organizzazioneProduttori FROM OrganizzazioneProduttori organizzazioneProduttori";
	private static final String _SQL_SELECT_ORGANIZZAZIONEPRODUTTORI_WHERE = "SELECT organizzazioneProduttori FROM OrganizzazioneProduttori organizzazioneProduttori WHERE ";
	private static final String _SQL_COUNT_ORGANIZZAZIONEPRODUTTORI = "SELECT COUNT(organizzazioneProduttori) FROM OrganizzazioneProduttori organizzazioneProduttori";
	private static final String _SQL_COUNT_ORGANIZZAZIONEPRODUTTORI_WHERE = "SELECT COUNT(organizzazioneProduttori) FROM OrganizzazioneProduttori organizzazioneProduttori WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "organizzazioneProduttori.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OrganizzazioneProduttori exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No OrganizzazioneProduttori exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OrganizzazioneProduttoriPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"ragioneSociale", "partitaIVA", "sitoWeb", "idLiferay"
			});
	private static OrganizzazioneProduttori _nullOrganizzazioneProduttori = new OrganizzazioneProduttoriImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<OrganizzazioneProduttori> toCacheModel() {
				return _nullOrganizzazioneProduttoriCacheModel;
			}
		};

	private static CacheModel<OrganizzazioneProduttori> _nullOrganizzazioneProduttoriCacheModel =
		new CacheModel<OrganizzazioneProduttori>() {
			@Override
			public OrganizzazioneProduttori toEntityModel() {
				return _nullOrganizzazioneProduttori;
			}
		};
}
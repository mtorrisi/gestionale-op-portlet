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

import it.bysoftware.ct.NoSuchArticoliException;
import it.bysoftware.ct.model.Articoli;
import it.bysoftware.ct.model.impl.ArticoliImpl;
import it.bysoftware.ct.model.impl.ArticoliModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the articoli service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ArticoliPersistence
 * @see ArticoliUtil
 * @generated
 */
public class ArticoliPersistenceImpl extends BasePersistenceImpl<Articoli>
	implements ArticoliPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ArticoliUtil} to access the articoli persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ArticoliImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ArticoliModelImpl.ENTITY_CACHE_ENABLED,
			ArticoliModelImpl.FINDER_CACHE_ENABLED, ArticoliImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ArticoliModelImpl.ENTITY_CACHE_ENABLED,
			ArticoliModelImpl.FINDER_CACHE_ENABLED, ArticoliImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ArticoliModelImpl.ENTITY_CACHE_ENABLED,
			ArticoliModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORIAMERCEOLOGICA =
		new FinderPath(ArticoliModelImpl.ENTITY_CACHE_ENABLED,
			ArticoliModelImpl.FINDER_CACHE_ENABLED, ArticoliImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBycategoriaMerceologica",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORIAMERCEOLOGICA =
		new FinderPath(ArticoliModelImpl.ENTITY_CACHE_ENABLED,
			ArticoliModelImpl.FINDER_CACHE_ENABLED, ArticoliImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBycategoriaMerceologica",
			new String[] { String.class.getName() },
			ArticoliModelImpl.CATEGORIAMERCEOLOGICA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORIAMERCEOLOGICA = new FinderPath(ArticoliModelImpl.ENTITY_CACHE_ENABLED,
			ArticoliModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBycategoriaMerceologica",
			new String[] { String.class.getName() });

	/**
	 * Returns all the articolis where categoriaMerceologica = &#63;.
	 *
	 * @param categoriaMerceologica the categoria merceologica
	 * @return the matching articolis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Articoli> findBycategoriaMerceologica(
		String categoriaMerceologica) throws SystemException {
		return findBycategoriaMerceologica(categoriaMerceologica,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the articolis where categoriaMerceologica = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.ArticoliModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoriaMerceologica the categoria merceologica
	 * @param start the lower bound of the range of articolis
	 * @param end the upper bound of the range of articolis (not inclusive)
	 * @return the range of matching articolis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Articoli> findBycategoriaMerceologica(
		String categoriaMerceologica, int start, int end)
		throws SystemException {
		return findBycategoriaMerceologica(categoriaMerceologica, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the articolis where categoriaMerceologica = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.ArticoliModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoriaMerceologica the categoria merceologica
	 * @param start the lower bound of the range of articolis
	 * @param end the upper bound of the range of articolis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching articolis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Articoli> findBycategoriaMerceologica(
		String categoriaMerceologica, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORIAMERCEOLOGICA;
			finderArgs = new Object[] { categoriaMerceologica };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORIAMERCEOLOGICA;
			finderArgs = new Object[] {
					categoriaMerceologica,
					
					start, end, orderByComparator
				};
		}

		List<Articoli> list = (List<Articoli>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Articoli articoli : list) {
				if (!Validator.equals(categoriaMerceologica,
							articoli.getCategoriaMerceologica())) {
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

			query.append(_SQL_SELECT_ARTICOLI_WHERE);

			boolean bindCategoriaMerceologica = false;

			if (categoriaMerceologica == null) {
				query.append(_FINDER_COLUMN_CATEGORIAMERCEOLOGICA_CATEGORIAMERCEOLOGICA_1);
			}
			else if (categoriaMerceologica.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATEGORIAMERCEOLOGICA_CATEGORIAMERCEOLOGICA_3);
			}
			else {
				bindCategoriaMerceologica = true;

				query.append(_FINDER_COLUMN_CATEGORIAMERCEOLOGICA_CATEGORIAMERCEOLOGICA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ArticoliModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCategoriaMerceologica) {
					qPos.add(categoriaMerceologica);
				}

				if (!pagination) {
					list = (List<Articoli>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Articoli>(list);
				}
				else {
					list = (List<Articoli>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first articoli in the ordered set where categoriaMerceologica = &#63;.
	 *
	 * @param categoriaMerceologica the categoria merceologica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching articoli
	 * @throws it.bysoftware.ct.NoSuchArticoliException if a matching articoli could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Articoli findBycategoriaMerceologica_First(
		String categoriaMerceologica, OrderByComparator orderByComparator)
		throws NoSuchArticoliException, SystemException {
		Articoli articoli = fetchBycategoriaMerceologica_First(categoriaMerceologica,
				orderByComparator);

		if (articoli != null) {
			return articoli;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoriaMerceologica=");
		msg.append(categoriaMerceologica);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticoliException(msg.toString());
	}

	/**
	 * Returns the first articoli in the ordered set where categoriaMerceologica = &#63;.
	 *
	 * @param categoriaMerceologica the categoria merceologica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching articoli, or <code>null</code> if a matching articoli could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Articoli fetchBycategoriaMerceologica_First(
		String categoriaMerceologica, OrderByComparator orderByComparator)
		throws SystemException {
		List<Articoli> list = findBycategoriaMerceologica(categoriaMerceologica,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last articoli in the ordered set where categoriaMerceologica = &#63;.
	 *
	 * @param categoriaMerceologica the categoria merceologica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching articoli
	 * @throws it.bysoftware.ct.NoSuchArticoliException if a matching articoli could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Articoli findBycategoriaMerceologica_Last(
		String categoriaMerceologica, OrderByComparator orderByComparator)
		throws NoSuchArticoliException, SystemException {
		Articoli articoli = fetchBycategoriaMerceologica_Last(categoriaMerceologica,
				orderByComparator);

		if (articoli != null) {
			return articoli;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoriaMerceologica=");
		msg.append(categoriaMerceologica);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticoliException(msg.toString());
	}

	/**
	 * Returns the last articoli in the ordered set where categoriaMerceologica = &#63;.
	 *
	 * @param categoriaMerceologica the categoria merceologica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching articoli, or <code>null</code> if a matching articoli could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Articoli fetchBycategoriaMerceologica_Last(
		String categoriaMerceologica, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBycategoriaMerceologica(categoriaMerceologica);

		if (count == 0) {
			return null;
		}

		List<Articoli> list = findBycategoriaMerceologica(categoriaMerceologica,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the articolis before and after the current articoli in the ordered set where categoriaMerceologica = &#63;.
	 *
	 * @param codiceArticolo the primary key of the current articoli
	 * @param categoriaMerceologica the categoria merceologica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next articoli
	 * @throws it.bysoftware.ct.NoSuchArticoliException if a articoli with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Articoli[] findBycategoriaMerceologica_PrevAndNext(
		String codiceArticolo, String categoriaMerceologica,
		OrderByComparator orderByComparator)
		throws NoSuchArticoliException, SystemException {
		Articoli articoli = findByPrimaryKey(codiceArticolo);

		Session session = null;

		try {
			session = openSession();

			Articoli[] array = new ArticoliImpl[3];

			array[0] = getBycategoriaMerceologica_PrevAndNext(session,
					articoli, categoriaMerceologica, orderByComparator, true);

			array[1] = articoli;

			array[2] = getBycategoriaMerceologica_PrevAndNext(session,
					articoli, categoriaMerceologica, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Articoli getBycategoriaMerceologica_PrevAndNext(Session session,
		Articoli articoli, String categoriaMerceologica,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ARTICOLI_WHERE);

		boolean bindCategoriaMerceologica = false;

		if (categoriaMerceologica == null) {
			query.append(_FINDER_COLUMN_CATEGORIAMERCEOLOGICA_CATEGORIAMERCEOLOGICA_1);
		}
		else if (categoriaMerceologica.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CATEGORIAMERCEOLOGICA_CATEGORIAMERCEOLOGICA_3);
		}
		else {
			bindCategoriaMerceologica = true;

			query.append(_FINDER_COLUMN_CATEGORIAMERCEOLOGICA_CATEGORIAMERCEOLOGICA_2);
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
			query.append(ArticoliModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCategoriaMerceologica) {
			qPos.add(categoriaMerceologica);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(articoli);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Articoli> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the articolis where categoriaMerceologica = &#63; from the database.
	 *
	 * @param categoriaMerceologica the categoria merceologica
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBycategoriaMerceologica(String categoriaMerceologica)
		throws SystemException {
		for (Articoli articoli : findBycategoriaMerceologica(
				categoriaMerceologica, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(articoli);
		}
	}

	/**
	 * Returns the number of articolis where categoriaMerceologica = &#63;.
	 *
	 * @param categoriaMerceologica the categoria merceologica
	 * @return the number of matching articolis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBycategoriaMerceologica(String categoriaMerceologica)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORIAMERCEOLOGICA;

		Object[] finderArgs = new Object[] { categoriaMerceologica };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ARTICOLI_WHERE);

			boolean bindCategoriaMerceologica = false;

			if (categoriaMerceologica == null) {
				query.append(_FINDER_COLUMN_CATEGORIAMERCEOLOGICA_CATEGORIAMERCEOLOGICA_1);
			}
			else if (categoriaMerceologica.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATEGORIAMERCEOLOGICA_CATEGORIAMERCEOLOGICA_3);
			}
			else {
				bindCategoriaMerceologica = true;

				query.append(_FINDER_COLUMN_CATEGORIAMERCEOLOGICA_CATEGORIAMERCEOLOGICA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCategoriaMerceologica) {
					qPos.add(categoriaMerceologica);
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

	private static final String _FINDER_COLUMN_CATEGORIAMERCEOLOGICA_CATEGORIAMERCEOLOGICA_1 =
		"articoli.categoriaMerceologica IS NULL";
	private static final String _FINDER_COLUMN_CATEGORIAMERCEOLOGICA_CATEGORIAMERCEOLOGICA_2 =
		"articoli.categoriaMerceologica = ?";
	private static final String _FINDER_COLUMN_CATEGORIAMERCEOLOGICA_CATEGORIAMERCEOLOGICA_3 =
		"(articoli.categoriaMerceologica IS NULL OR articoli.categoriaMerceologica = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORIAARTICOLI =
		new FinderPath(ArticoliModelImpl.ENTITY_CACHE_ENABLED,
			ArticoliModelImpl.FINDER_CACHE_ENABLED, ArticoliImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycategoriaArticoli",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CATEGORIAARTICOLI =
		new FinderPath(ArticoliModelImpl.ENTITY_CACHE_ENABLED,
			ArticoliModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countBycategoriaArticoli",
			new String[] { String.class.getName() });

	/**
	 * Returns all the articolis where categoriaMerceologica &ne; &#63;.
	 *
	 * @param categoriaMerceologica the categoria merceologica
	 * @return the matching articolis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Articoli> findBycategoriaArticoli(String categoriaMerceologica)
		throws SystemException {
		return findBycategoriaArticoli(categoriaMerceologica,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the articolis where categoriaMerceologica &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.ArticoliModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoriaMerceologica the categoria merceologica
	 * @param start the lower bound of the range of articolis
	 * @param end the upper bound of the range of articolis (not inclusive)
	 * @return the range of matching articolis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Articoli> findBycategoriaArticoli(
		String categoriaMerceologica, int start, int end)
		throws SystemException {
		return findBycategoriaArticoli(categoriaMerceologica, start, end, null);
	}

	/**
	 * Returns an ordered range of all the articolis where categoriaMerceologica &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.ArticoliModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoriaMerceologica the categoria merceologica
	 * @param start the lower bound of the range of articolis
	 * @param end the upper bound of the range of articolis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching articolis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Articoli> findBycategoriaArticoli(
		String categoriaMerceologica, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORIAARTICOLI;
		finderArgs = new Object[] {
				categoriaMerceologica,
				
				start, end, orderByComparator
			};

		List<Articoli> list = (List<Articoli>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Articoli articoli : list) {
				if (Validator.equals(categoriaMerceologica,
							articoli.getCategoriaMerceologica())) {
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

			query.append(_SQL_SELECT_ARTICOLI_WHERE);

			boolean bindCategoriaMerceologica = false;

			if (categoriaMerceologica == null) {
				query.append(_FINDER_COLUMN_CATEGORIAARTICOLI_CATEGORIAMERCEOLOGICA_1);
			}
			else if (categoriaMerceologica.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATEGORIAARTICOLI_CATEGORIAMERCEOLOGICA_3);
			}
			else {
				bindCategoriaMerceologica = true;

				query.append(_FINDER_COLUMN_CATEGORIAARTICOLI_CATEGORIAMERCEOLOGICA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ArticoliModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCategoriaMerceologica) {
					qPos.add(categoriaMerceologica);
				}

				if (!pagination) {
					list = (List<Articoli>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Articoli>(list);
				}
				else {
					list = (List<Articoli>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first articoli in the ordered set where categoriaMerceologica &ne; &#63;.
	 *
	 * @param categoriaMerceologica the categoria merceologica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching articoli
	 * @throws it.bysoftware.ct.NoSuchArticoliException if a matching articoli could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Articoli findBycategoriaArticoli_First(
		String categoriaMerceologica, OrderByComparator orderByComparator)
		throws NoSuchArticoliException, SystemException {
		Articoli articoli = fetchBycategoriaArticoli_First(categoriaMerceologica,
				orderByComparator);

		if (articoli != null) {
			return articoli;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoriaMerceologica=");
		msg.append(categoriaMerceologica);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticoliException(msg.toString());
	}

	/**
	 * Returns the first articoli in the ordered set where categoriaMerceologica &ne; &#63;.
	 *
	 * @param categoriaMerceologica the categoria merceologica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching articoli, or <code>null</code> if a matching articoli could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Articoli fetchBycategoriaArticoli_First(
		String categoriaMerceologica, OrderByComparator orderByComparator)
		throws SystemException {
		List<Articoli> list = findBycategoriaArticoli(categoriaMerceologica, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last articoli in the ordered set where categoriaMerceologica &ne; &#63;.
	 *
	 * @param categoriaMerceologica the categoria merceologica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching articoli
	 * @throws it.bysoftware.ct.NoSuchArticoliException if a matching articoli could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Articoli findBycategoriaArticoli_Last(String categoriaMerceologica,
		OrderByComparator orderByComparator)
		throws NoSuchArticoliException, SystemException {
		Articoli articoli = fetchBycategoriaArticoli_Last(categoriaMerceologica,
				orderByComparator);

		if (articoli != null) {
			return articoli;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoriaMerceologica=");
		msg.append(categoriaMerceologica);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticoliException(msg.toString());
	}

	/**
	 * Returns the last articoli in the ordered set where categoriaMerceologica &ne; &#63;.
	 *
	 * @param categoriaMerceologica the categoria merceologica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching articoli, or <code>null</code> if a matching articoli could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Articoli fetchBycategoriaArticoli_Last(
		String categoriaMerceologica, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBycategoriaArticoli(categoriaMerceologica);

		if (count == 0) {
			return null;
		}

		List<Articoli> list = findBycategoriaArticoli(categoriaMerceologica,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the articolis before and after the current articoli in the ordered set where categoriaMerceologica &ne; &#63;.
	 *
	 * @param codiceArticolo the primary key of the current articoli
	 * @param categoriaMerceologica the categoria merceologica
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next articoli
	 * @throws it.bysoftware.ct.NoSuchArticoliException if a articoli with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Articoli[] findBycategoriaArticoli_PrevAndNext(
		String codiceArticolo, String categoriaMerceologica,
		OrderByComparator orderByComparator)
		throws NoSuchArticoliException, SystemException {
		Articoli articoli = findByPrimaryKey(codiceArticolo);

		Session session = null;

		try {
			session = openSession();

			Articoli[] array = new ArticoliImpl[3];

			array[0] = getBycategoriaArticoli_PrevAndNext(session, articoli,
					categoriaMerceologica, orderByComparator, true);

			array[1] = articoli;

			array[2] = getBycategoriaArticoli_PrevAndNext(session, articoli,
					categoriaMerceologica, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Articoli getBycategoriaArticoli_PrevAndNext(Session session,
		Articoli articoli, String categoriaMerceologica,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ARTICOLI_WHERE);

		boolean bindCategoriaMerceologica = false;

		if (categoriaMerceologica == null) {
			query.append(_FINDER_COLUMN_CATEGORIAARTICOLI_CATEGORIAMERCEOLOGICA_1);
		}
		else if (categoriaMerceologica.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CATEGORIAARTICOLI_CATEGORIAMERCEOLOGICA_3);
		}
		else {
			bindCategoriaMerceologica = true;

			query.append(_FINDER_COLUMN_CATEGORIAARTICOLI_CATEGORIAMERCEOLOGICA_2);
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
			query.append(ArticoliModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCategoriaMerceologica) {
			qPos.add(categoriaMerceologica);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(articoli);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Articoli> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the articolis where categoriaMerceologica &ne; &#63; from the database.
	 *
	 * @param categoriaMerceologica the categoria merceologica
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBycategoriaArticoli(String categoriaMerceologica)
		throws SystemException {
		for (Articoli articoli : findBycategoriaArticoli(
				categoriaMerceologica, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(articoli);
		}
	}

	/**
	 * Returns the number of articolis where categoriaMerceologica &ne; &#63;.
	 *
	 * @param categoriaMerceologica the categoria merceologica
	 * @return the number of matching articolis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBycategoriaArticoli(String categoriaMerceologica)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_CATEGORIAARTICOLI;

		Object[] finderArgs = new Object[] { categoriaMerceologica };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ARTICOLI_WHERE);

			boolean bindCategoriaMerceologica = false;

			if (categoriaMerceologica == null) {
				query.append(_FINDER_COLUMN_CATEGORIAARTICOLI_CATEGORIAMERCEOLOGICA_1);
			}
			else if (categoriaMerceologica.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATEGORIAARTICOLI_CATEGORIAMERCEOLOGICA_3);
			}
			else {
				bindCategoriaMerceologica = true;

				query.append(_FINDER_COLUMN_CATEGORIAARTICOLI_CATEGORIAMERCEOLOGICA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCategoriaMerceologica) {
					qPos.add(categoriaMerceologica);
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

	private static final String _FINDER_COLUMN_CATEGORIAARTICOLI_CATEGORIAMERCEOLOGICA_1 =
		"articoli.categoriaMerceologica IS NOT NULL";
	private static final String _FINDER_COLUMN_CATEGORIAARTICOLI_CATEGORIAMERCEOLOGICA_2 =
		"articoli.categoriaMerceologica != ?";
	private static final String _FINDER_COLUMN_CATEGORIAARTICOLI_CATEGORIAMERCEOLOGICA_3 =
		"(articoli.categoriaMerceologica IS NULL OR articoli.categoriaMerceologica != '')";

	public ArticoliPersistenceImpl() {
		setModelClass(Articoli.class);
	}

	/**
	 * Caches the articoli in the entity cache if it is enabled.
	 *
	 * @param articoli the articoli
	 */
	@Override
	public void cacheResult(Articoli articoli) {
		EntityCacheUtil.putResult(ArticoliModelImpl.ENTITY_CACHE_ENABLED,
			ArticoliImpl.class, articoli.getPrimaryKey(), articoli);

		articoli.resetOriginalValues();
	}

	/**
	 * Caches the articolis in the entity cache if it is enabled.
	 *
	 * @param articolis the articolis
	 */
	@Override
	public void cacheResult(List<Articoli> articolis) {
		for (Articoli articoli : articolis) {
			if (EntityCacheUtil.getResult(
						ArticoliModelImpl.ENTITY_CACHE_ENABLED,
						ArticoliImpl.class, articoli.getPrimaryKey()) == null) {
				cacheResult(articoli);
			}
			else {
				articoli.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all articolis.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ArticoliImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ArticoliImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the articoli.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Articoli articoli) {
		EntityCacheUtil.removeResult(ArticoliModelImpl.ENTITY_CACHE_ENABLED,
			ArticoliImpl.class, articoli.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Articoli> articolis) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Articoli articoli : articolis) {
			EntityCacheUtil.removeResult(ArticoliModelImpl.ENTITY_CACHE_ENABLED,
				ArticoliImpl.class, articoli.getPrimaryKey());
		}
	}

	/**
	 * Creates a new articoli with the primary key. Does not add the articoli to the database.
	 *
	 * @param codiceArticolo the primary key for the new articoli
	 * @return the new articoli
	 */
	@Override
	public Articoli create(String codiceArticolo) {
		Articoli articoli = new ArticoliImpl();

		articoli.setNew(true);
		articoli.setPrimaryKey(codiceArticolo);

		return articoli;
	}

	/**
	 * Removes the articoli with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param codiceArticolo the primary key of the articoli
	 * @return the articoli that was removed
	 * @throws it.bysoftware.ct.NoSuchArticoliException if a articoli with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Articoli remove(String codiceArticolo)
		throws NoSuchArticoliException, SystemException {
		return remove((Serializable)codiceArticolo);
	}

	/**
	 * Removes the articoli with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the articoli
	 * @return the articoli that was removed
	 * @throws it.bysoftware.ct.NoSuchArticoliException if a articoli with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Articoli remove(Serializable primaryKey)
		throws NoSuchArticoliException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Articoli articoli = (Articoli)session.get(ArticoliImpl.class,
					primaryKey);

			if (articoli == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchArticoliException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(articoli);
		}
		catch (NoSuchArticoliException nsee) {
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
	protected Articoli removeImpl(Articoli articoli) throws SystemException {
		articoli = toUnwrappedModel(articoli);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(articoli)) {
				articoli = (Articoli)session.get(ArticoliImpl.class,
						articoli.getPrimaryKeyObj());
			}

			if (articoli != null) {
				session.delete(articoli);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (articoli != null) {
			clearCache(articoli);
		}

		return articoli;
	}

	@Override
	public Articoli updateImpl(it.bysoftware.ct.model.Articoli articoli)
		throws SystemException {
		articoli = toUnwrappedModel(articoli);

		boolean isNew = articoli.isNew();

		ArticoliModelImpl articoliModelImpl = (ArticoliModelImpl)articoli;

		Session session = null;

		try {
			session = openSession();

			if (articoli.isNew()) {
				session.save(articoli);

				articoli.setNew(false);
			}
			else {
				session.merge(articoli);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ArticoliModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((articoliModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORIAMERCEOLOGICA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						articoliModelImpl.getOriginalCategoriaMerceologica()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORIAMERCEOLOGICA,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORIAMERCEOLOGICA,
					args);

				args = new Object[] { articoliModelImpl.getCategoriaMerceologica() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORIAMERCEOLOGICA,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORIAMERCEOLOGICA,
					args);
			}
		}

		EntityCacheUtil.putResult(ArticoliModelImpl.ENTITY_CACHE_ENABLED,
			ArticoliImpl.class, articoli.getPrimaryKey(), articoli);

		return articoli;
	}

	protected Articoli toUnwrappedModel(Articoli articoli) {
		if (articoli instanceof ArticoliImpl) {
			return articoli;
		}

		ArticoliImpl articoliImpl = new ArticoliImpl();

		articoliImpl.setNew(articoli.isNew());
		articoliImpl.setPrimaryKey(articoli.getPrimaryKey());

		articoliImpl.setCodiceArticolo(articoli.getCodiceArticolo());
		articoliImpl.setCategoriaMerceologica(articoli.getCategoriaMerceologica());
		articoliImpl.setDescrizione(articoli.getDescrizione());
		articoliImpl.setDescrizioneDocumento(articoli.getDescrizioneDocumento());
		articoliImpl.setDescrizioneFiscale(articoli.getDescrizioneFiscale());

		return articoliImpl;
	}

	/**
	 * Returns the articoli with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the articoli
	 * @return the articoli
	 * @throws it.bysoftware.ct.NoSuchArticoliException if a articoli with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Articoli findByPrimaryKey(Serializable primaryKey)
		throws NoSuchArticoliException, SystemException {
		Articoli articoli = fetchByPrimaryKey(primaryKey);

		if (articoli == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchArticoliException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return articoli;
	}

	/**
	 * Returns the articoli with the primary key or throws a {@link it.bysoftware.ct.NoSuchArticoliException} if it could not be found.
	 *
	 * @param codiceArticolo the primary key of the articoli
	 * @return the articoli
	 * @throws it.bysoftware.ct.NoSuchArticoliException if a articoli with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Articoli findByPrimaryKey(String codiceArticolo)
		throws NoSuchArticoliException, SystemException {
		return findByPrimaryKey((Serializable)codiceArticolo);
	}

	/**
	 * Returns the articoli with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the articoli
	 * @return the articoli, or <code>null</code> if a articoli with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Articoli fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Articoli articoli = (Articoli)EntityCacheUtil.getResult(ArticoliModelImpl.ENTITY_CACHE_ENABLED,
				ArticoliImpl.class, primaryKey);

		if (articoli == _nullArticoli) {
			return null;
		}

		if (articoli == null) {
			Session session = null;

			try {
				session = openSession();

				articoli = (Articoli)session.get(ArticoliImpl.class, primaryKey);

				if (articoli != null) {
					cacheResult(articoli);
				}
				else {
					EntityCacheUtil.putResult(ArticoliModelImpl.ENTITY_CACHE_ENABLED,
						ArticoliImpl.class, primaryKey, _nullArticoli);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ArticoliModelImpl.ENTITY_CACHE_ENABLED,
					ArticoliImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return articoli;
	}

	/**
	 * Returns the articoli with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param codiceArticolo the primary key of the articoli
	 * @return the articoli, or <code>null</code> if a articoli with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Articoli fetchByPrimaryKey(String codiceArticolo)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)codiceArticolo);
	}

	/**
	 * Returns all the articolis.
	 *
	 * @return the articolis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Articoli> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the articolis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.ArticoliModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of articolis
	 * @param end the upper bound of the range of articolis (not inclusive)
	 * @return the range of articolis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Articoli> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the articolis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.ArticoliModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of articolis
	 * @param end the upper bound of the range of articolis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of articolis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Articoli> findAll(int start, int end,
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

		List<Articoli> list = (List<Articoli>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ARTICOLI);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ARTICOLI;

				if (pagination) {
					sql = sql.concat(ArticoliModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Articoli>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Articoli>(list);
				}
				else {
					list = (List<Articoli>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the articolis from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Articoli articoli : findAll()) {
			remove(articoli);
		}
	}

	/**
	 * Returns the number of articolis.
	 *
	 * @return the number of articolis
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

				Query q = session.createQuery(_SQL_COUNT_ARTICOLI);

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
	 * Initializes the articoli persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.bysoftware.ct.model.Articoli")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Articoli>> listenersList = new ArrayList<ModelListener<Articoli>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Articoli>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ArticoliImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ARTICOLI = "SELECT articoli FROM Articoli articoli";
	private static final String _SQL_SELECT_ARTICOLI_WHERE = "SELECT articoli FROM Articoli articoli WHERE ";
	private static final String _SQL_COUNT_ARTICOLI = "SELECT COUNT(articoli) FROM Articoli articoli";
	private static final String _SQL_COUNT_ARTICOLI_WHERE = "SELECT COUNT(articoli) FROM Articoli articoli WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "articoli.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Articoli exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Articoli exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ArticoliPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"codiceArticolo", "categoriaMerceologica", "descrizione",
				"descrizioneDocumento", "descrizioneFiscale"
			});
	private static Articoli _nullArticoli = new ArticoliImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Articoli> toCacheModel() {
				return _nullArticoliCacheModel;
			}
		};

	private static CacheModel<Articoli> _nullArticoliCacheModel = new CacheModel<Articoli>() {
			@Override
			public Articoli toEntityModel() {
				return _nullArticoli;
			}
		};
}
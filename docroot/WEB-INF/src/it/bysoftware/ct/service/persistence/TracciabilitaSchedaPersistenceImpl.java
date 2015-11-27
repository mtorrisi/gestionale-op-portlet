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

import it.bysoftware.ct.NoSuchTracciabilitaSchedaException;
import it.bysoftware.ct.model.TracciabilitaScheda;
import it.bysoftware.ct.model.impl.TracciabilitaSchedaImpl;
import it.bysoftware.ct.model.impl.TracciabilitaSchedaModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the tracciabilita scheda service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TracciabilitaSchedaPersistence
 * @see TracciabilitaSchedaUtil
 * @generated
 */
public class TracciabilitaSchedaPersistenceImpl extends BasePersistenceImpl<TracciabilitaScheda>
	implements TracciabilitaSchedaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TracciabilitaSchedaUtil} to access the tracciabilita scheda persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TracciabilitaSchedaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TracciabilitaSchedaModelImpl.ENTITY_CACHE_ENABLED,
			TracciabilitaSchedaModelImpl.FINDER_CACHE_ENABLED,
			TracciabilitaSchedaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TracciabilitaSchedaModelImpl.ENTITY_CACHE_ENABLED,
			TracciabilitaSchedaModelImpl.FINDER_CACHE_ENABLED,
			TracciabilitaSchedaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TracciabilitaSchedaModelImpl.ENTITY_CACHE_ENABLED,
			TracciabilitaSchedaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ANNOIDASSOCIATONDOCUMENTO =
		new FinderPath(TracciabilitaSchedaModelImpl.ENTITY_CACHE_ENABLED,
			TracciabilitaSchedaModelImpl.FINDER_CACHE_ENABLED,
			TracciabilitaSchedaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByAnnoIdAssociatoNDocumento",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANNOIDASSOCIATONDOCUMENTO =
		new FinderPath(TracciabilitaSchedaModelImpl.ENTITY_CACHE_ENABLED,
			TracciabilitaSchedaModelImpl.FINDER_CACHE_ENABLED,
			TracciabilitaSchedaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAnnoIdAssociatoNDocumento",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				Long.class.getName(), String.class.getName()
			},
			TracciabilitaSchedaModelImpl.ANNO_COLUMN_BITMASK |
			TracciabilitaSchedaModelImpl.IDASSOCIATO_COLUMN_BITMASK |
			TracciabilitaSchedaModelImpl.NUMERODOCUMENTO_COLUMN_BITMASK |
			TracciabilitaSchedaModelImpl.TIPODOCUMENTO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ANNOIDASSOCIATONDOCUMENTO =
		new FinderPath(TracciabilitaSchedaModelImpl.ENTITY_CACHE_ENABLED,
			TracciabilitaSchedaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAnnoIdAssociatoNDocumento",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				Long.class.getName(), String.class.getName()
			});

	/**
	 * Returns all the tracciabilita schedas where anno = &#63; and idAssociato = &#63; and numeroDocumento = &#63; and tipoDocumento = &#63;.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param numeroDocumento the numero documento
	 * @param tipoDocumento the tipo documento
	 * @return the matching tracciabilita schedas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TracciabilitaScheda> findByAnnoIdAssociatoNDocumento(int anno,
		long idAssociato, long numeroDocumento, String tipoDocumento)
		throws SystemException {
		return findByAnnoIdAssociatoNDocumento(anno, idAssociato,
			numeroDocumento, tipoDocumento, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tracciabilita schedas where anno = &#63; and idAssociato = &#63; and numeroDocumento = &#63; and tipoDocumento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TracciabilitaSchedaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param numeroDocumento the numero documento
	 * @param tipoDocumento the tipo documento
	 * @param start the lower bound of the range of tracciabilita schedas
	 * @param end the upper bound of the range of tracciabilita schedas (not inclusive)
	 * @return the range of matching tracciabilita schedas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TracciabilitaScheda> findByAnnoIdAssociatoNDocumento(int anno,
		long idAssociato, long numeroDocumento, String tipoDocumento,
		int start, int end) throws SystemException {
		return findByAnnoIdAssociatoNDocumento(anno, idAssociato,
			numeroDocumento, tipoDocumento, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tracciabilita schedas where anno = &#63; and idAssociato = &#63; and numeroDocumento = &#63; and tipoDocumento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TracciabilitaSchedaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param numeroDocumento the numero documento
	 * @param tipoDocumento the tipo documento
	 * @param start the lower bound of the range of tracciabilita schedas
	 * @param end the upper bound of the range of tracciabilita schedas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tracciabilita schedas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TracciabilitaScheda> findByAnnoIdAssociatoNDocumento(int anno,
		long idAssociato, long numeroDocumento, String tipoDocumento,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANNOIDASSOCIATONDOCUMENTO;
			finderArgs = new Object[] {
					anno, idAssociato, numeroDocumento, tipoDocumento
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ANNOIDASSOCIATONDOCUMENTO;
			finderArgs = new Object[] {
					anno, idAssociato, numeroDocumento, tipoDocumento,
					
					start, end, orderByComparator
				};
		}

		List<TracciabilitaScheda> list = (List<TracciabilitaScheda>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TracciabilitaScheda tracciabilitaScheda : list) {
				if ((anno != tracciabilitaScheda.getAnno()) ||
						(idAssociato != tracciabilitaScheda.getIdAssociato()) ||
						(numeroDocumento != tracciabilitaScheda.getNumeroDocumento()) ||
						!Validator.equals(tipoDocumento,
							tracciabilitaScheda.getTipoDocumento())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_TRACCIABILITASCHEDA_WHERE);

			query.append(_FINDER_COLUMN_ANNOIDASSOCIATONDOCUMENTO_ANNO_2);

			query.append(_FINDER_COLUMN_ANNOIDASSOCIATONDOCUMENTO_IDASSOCIATO_2);

			query.append(_FINDER_COLUMN_ANNOIDASSOCIATONDOCUMENTO_NUMERODOCUMENTO_2);

			boolean bindTipoDocumento = false;

			if (tipoDocumento == null) {
				query.append(_FINDER_COLUMN_ANNOIDASSOCIATONDOCUMENTO_TIPODOCUMENTO_1);
			}
			else if (tipoDocumento.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ANNOIDASSOCIATONDOCUMENTO_TIPODOCUMENTO_3);
			}
			else {
				bindTipoDocumento = true;

				query.append(_FINDER_COLUMN_ANNOIDASSOCIATONDOCUMENTO_TIPODOCUMENTO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TracciabilitaSchedaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(anno);

				qPos.add(idAssociato);

				qPos.add(numeroDocumento);

				if (bindTipoDocumento) {
					qPos.add(tipoDocumento);
				}

				if (!pagination) {
					list = (List<TracciabilitaScheda>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TracciabilitaScheda>(list);
				}
				else {
					list = (List<TracciabilitaScheda>)QueryUtil.list(q,
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
	 * Returns the first tracciabilita scheda in the ordered set where anno = &#63; and idAssociato = &#63; and numeroDocumento = &#63; and tipoDocumento = &#63;.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param numeroDocumento the numero documento
	 * @param tipoDocumento the tipo documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tracciabilita scheda
	 * @throws it.bysoftware.ct.NoSuchTracciabilitaSchedaException if a matching tracciabilita scheda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TracciabilitaScheda findByAnnoIdAssociatoNDocumento_First(int anno,
		long idAssociato, long numeroDocumento, String tipoDocumento,
		OrderByComparator orderByComparator)
		throws NoSuchTracciabilitaSchedaException, SystemException {
		TracciabilitaScheda tracciabilitaScheda = fetchByAnnoIdAssociatoNDocumento_First(anno,
				idAssociato, numeroDocumento, tipoDocumento, orderByComparator);

		if (tracciabilitaScheda != null) {
			return tracciabilitaScheda;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("anno=");
		msg.append(anno);

		msg.append(", idAssociato=");
		msg.append(idAssociato);

		msg.append(", numeroDocumento=");
		msg.append(numeroDocumento);

		msg.append(", tipoDocumento=");
		msg.append(tipoDocumento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTracciabilitaSchedaException(msg.toString());
	}

	/**
	 * Returns the first tracciabilita scheda in the ordered set where anno = &#63; and idAssociato = &#63; and numeroDocumento = &#63; and tipoDocumento = &#63;.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param numeroDocumento the numero documento
	 * @param tipoDocumento the tipo documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tracciabilita scheda, or <code>null</code> if a matching tracciabilita scheda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TracciabilitaScheda fetchByAnnoIdAssociatoNDocumento_First(
		int anno, long idAssociato, long numeroDocumento, String tipoDocumento,
		OrderByComparator orderByComparator) throws SystemException {
		List<TracciabilitaScheda> list = findByAnnoIdAssociatoNDocumento(anno,
				idAssociato, numeroDocumento, tipoDocumento, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tracciabilita scheda in the ordered set where anno = &#63; and idAssociato = &#63; and numeroDocumento = &#63; and tipoDocumento = &#63;.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param numeroDocumento the numero documento
	 * @param tipoDocumento the tipo documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tracciabilita scheda
	 * @throws it.bysoftware.ct.NoSuchTracciabilitaSchedaException if a matching tracciabilita scheda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TracciabilitaScheda findByAnnoIdAssociatoNDocumento_Last(int anno,
		long idAssociato, long numeroDocumento, String tipoDocumento,
		OrderByComparator orderByComparator)
		throws NoSuchTracciabilitaSchedaException, SystemException {
		TracciabilitaScheda tracciabilitaScheda = fetchByAnnoIdAssociatoNDocumento_Last(anno,
				idAssociato, numeroDocumento, tipoDocumento, orderByComparator);

		if (tracciabilitaScheda != null) {
			return tracciabilitaScheda;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("anno=");
		msg.append(anno);

		msg.append(", idAssociato=");
		msg.append(idAssociato);

		msg.append(", numeroDocumento=");
		msg.append(numeroDocumento);

		msg.append(", tipoDocumento=");
		msg.append(tipoDocumento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTracciabilitaSchedaException(msg.toString());
	}

	/**
	 * Returns the last tracciabilita scheda in the ordered set where anno = &#63; and idAssociato = &#63; and numeroDocumento = &#63; and tipoDocumento = &#63;.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param numeroDocumento the numero documento
	 * @param tipoDocumento the tipo documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tracciabilita scheda, or <code>null</code> if a matching tracciabilita scheda could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TracciabilitaScheda fetchByAnnoIdAssociatoNDocumento_Last(int anno,
		long idAssociato, long numeroDocumento, String tipoDocumento,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAnnoIdAssociatoNDocumento(anno, idAssociato,
				numeroDocumento, tipoDocumento);

		if (count == 0) {
			return null;
		}

		List<TracciabilitaScheda> list = findByAnnoIdAssociatoNDocumento(anno,
				idAssociato, numeroDocumento, tipoDocumento, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tracciabilita schedas before and after the current tracciabilita scheda in the ordered set where anno = &#63; and idAssociato = &#63; and numeroDocumento = &#63; and tipoDocumento = &#63;.
	 *
	 * @param id the primary key of the current tracciabilita scheda
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param numeroDocumento the numero documento
	 * @param tipoDocumento the tipo documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tracciabilita scheda
	 * @throws it.bysoftware.ct.NoSuchTracciabilitaSchedaException if a tracciabilita scheda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TracciabilitaScheda[] findByAnnoIdAssociatoNDocumento_PrevAndNext(
		long id, int anno, long idAssociato, long numeroDocumento,
		String tipoDocumento, OrderByComparator orderByComparator)
		throws NoSuchTracciabilitaSchedaException, SystemException {
		TracciabilitaScheda tracciabilitaScheda = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TracciabilitaScheda[] array = new TracciabilitaSchedaImpl[3];

			array[0] = getByAnnoIdAssociatoNDocumento_PrevAndNext(session,
					tracciabilitaScheda, anno, idAssociato, numeroDocumento,
					tipoDocumento, orderByComparator, true);

			array[1] = tracciabilitaScheda;

			array[2] = getByAnnoIdAssociatoNDocumento_PrevAndNext(session,
					tracciabilitaScheda, anno, idAssociato, numeroDocumento,
					tipoDocumento, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TracciabilitaScheda getByAnnoIdAssociatoNDocumento_PrevAndNext(
		Session session, TracciabilitaScheda tracciabilitaScheda, int anno,
		long idAssociato, long numeroDocumento, String tipoDocumento,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRACCIABILITASCHEDA_WHERE);

		query.append(_FINDER_COLUMN_ANNOIDASSOCIATONDOCUMENTO_ANNO_2);

		query.append(_FINDER_COLUMN_ANNOIDASSOCIATONDOCUMENTO_IDASSOCIATO_2);

		query.append(_FINDER_COLUMN_ANNOIDASSOCIATONDOCUMENTO_NUMERODOCUMENTO_2);

		boolean bindTipoDocumento = false;

		if (tipoDocumento == null) {
			query.append(_FINDER_COLUMN_ANNOIDASSOCIATONDOCUMENTO_TIPODOCUMENTO_1);
		}
		else if (tipoDocumento.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ANNOIDASSOCIATONDOCUMENTO_TIPODOCUMENTO_3);
		}
		else {
			bindTipoDocumento = true;

			query.append(_FINDER_COLUMN_ANNOIDASSOCIATONDOCUMENTO_TIPODOCUMENTO_2);
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
			query.append(TracciabilitaSchedaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(anno);

		qPos.add(idAssociato);

		qPos.add(numeroDocumento);

		if (bindTipoDocumento) {
			qPos.add(tipoDocumento);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tracciabilitaScheda);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TracciabilitaScheda> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tracciabilita schedas where anno = &#63; and idAssociato = &#63; and numeroDocumento = &#63; and tipoDocumento = &#63; from the database.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param numeroDocumento the numero documento
	 * @param tipoDocumento the tipo documento
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAnnoIdAssociatoNDocumento(int anno, long idAssociato,
		long numeroDocumento, String tipoDocumento) throws SystemException {
		for (TracciabilitaScheda tracciabilitaScheda : findByAnnoIdAssociatoNDocumento(
				anno, idAssociato, numeroDocumento, tipoDocumento,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(tracciabilitaScheda);
		}
	}

	/**
	 * Returns the number of tracciabilita schedas where anno = &#63; and idAssociato = &#63; and numeroDocumento = &#63; and tipoDocumento = &#63;.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param numeroDocumento the numero documento
	 * @param tipoDocumento the tipo documento
	 * @return the number of matching tracciabilita schedas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAnnoIdAssociatoNDocumento(int anno, long idAssociato,
		long numeroDocumento, String tipoDocumento) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ANNOIDASSOCIATONDOCUMENTO;

		Object[] finderArgs = new Object[] {
				anno, idAssociato, numeroDocumento, tipoDocumento
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_TRACCIABILITASCHEDA_WHERE);

			query.append(_FINDER_COLUMN_ANNOIDASSOCIATONDOCUMENTO_ANNO_2);

			query.append(_FINDER_COLUMN_ANNOIDASSOCIATONDOCUMENTO_IDASSOCIATO_2);

			query.append(_FINDER_COLUMN_ANNOIDASSOCIATONDOCUMENTO_NUMERODOCUMENTO_2);

			boolean bindTipoDocumento = false;

			if (tipoDocumento == null) {
				query.append(_FINDER_COLUMN_ANNOIDASSOCIATONDOCUMENTO_TIPODOCUMENTO_1);
			}
			else if (tipoDocumento.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ANNOIDASSOCIATONDOCUMENTO_TIPODOCUMENTO_3);
			}
			else {
				bindTipoDocumento = true;

				query.append(_FINDER_COLUMN_ANNOIDASSOCIATONDOCUMENTO_TIPODOCUMENTO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(anno);

				qPos.add(idAssociato);

				qPos.add(numeroDocumento);

				if (bindTipoDocumento) {
					qPos.add(tipoDocumento);
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

	private static final String _FINDER_COLUMN_ANNOIDASSOCIATONDOCUMENTO_ANNO_2 = "tracciabilitaScheda.anno = ? AND ";
	private static final String _FINDER_COLUMN_ANNOIDASSOCIATONDOCUMENTO_IDASSOCIATO_2 =
		"tracciabilitaScheda.idAssociato = ? AND ";
	private static final String _FINDER_COLUMN_ANNOIDASSOCIATONDOCUMENTO_NUMERODOCUMENTO_2 =
		"tracciabilitaScheda.numeroDocumento = ? AND ";
	private static final String _FINDER_COLUMN_ANNOIDASSOCIATONDOCUMENTO_TIPODOCUMENTO_1 =
		"tracciabilitaScheda.tipoDocumento IS NULL";
	private static final String _FINDER_COLUMN_ANNOIDASSOCIATONDOCUMENTO_TIPODOCUMENTO_2 =
		"tracciabilitaScheda.tipoDocumento = ?";
	private static final String _FINDER_COLUMN_ANNOIDASSOCIATONDOCUMENTO_TIPODOCUMENTO_3 =
		"(tracciabilitaScheda.tipoDocumento IS NULL OR tracciabilitaScheda.tipoDocumento = '')";

	public TracciabilitaSchedaPersistenceImpl() {
		setModelClass(TracciabilitaScheda.class);
	}

	/**
	 * Caches the tracciabilita scheda in the entity cache if it is enabled.
	 *
	 * @param tracciabilitaScheda the tracciabilita scheda
	 */
	@Override
	public void cacheResult(TracciabilitaScheda tracciabilitaScheda) {
		EntityCacheUtil.putResult(TracciabilitaSchedaModelImpl.ENTITY_CACHE_ENABLED,
			TracciabilitaSchedaImpl.class, tracciabilitaScheda.getPrimaryKey(),
			tracciabilitaScheda);

		tracciabilitaScheda.resetOriginalValues();
	}

	/**
	 * Caches the tracciabilita schedas in the entity cache if it is enabled.
	 *
	 * @param tracciabilitaSchedas the tracciabilita schedas
	 */
	@Override
	public void cacheResult(List<TracciabilitaScheda> tracciabilitaSchedas) {
		for (TracciabilitaScheda tracciabilitaScheda : tracciabilitaSchedas) {
			if (EntityCacheUtil.getResult(
						TracciabilitaSchedaModelImpl.ENTITY_CACHE_ENABLED,
						TracciabilitaSchedaImpl.class,
						tracciabilitaScheda.getPrimaryKey()) == null) {
				cacheResult(tracciabilitaScheda);
			}
			else {
				tracciabilitaScheda.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tracciabilita schedas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TracciabilitaSchedaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TracciabilitaSchedaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tracciabilita scheda.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TracciabilitaScheda tracciabilitaScheda) {
		EntityCacheUtil.removeResult(TracciabilitaSchedaModelImpl.ENTITY_CACHE_ENABLED,
			TracciabilitaSchedaImpl.class, tracciabilitaScheda.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TracciabilitaScheda> tracciabilitaSchedas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TracciabilitaScheda tracciabilitaScheda : tracciabilitaSchedas) {
			EntityCacheUtil.removeResult(TracciabilitaSchedaModelImpl.ENTITY_CACHE_ENABLED,
				TracciabilitaSchedaImpl.class,
				tracciabilitaScheda.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tracciabilita scheda with the primary key. Does not add the tracciabilita scheda to the database.
	 *
	 * @param id the primary key for the new tracciabilita scheda
	 * @return the new tracciabilita scheda
	 */
	@Override
	public TracciabilitaScheda create(long id) {
		TracciabilitaScheda tracciabilitaScheda = new TracciabilitaSchedaImpl();

		tracciabilitaScheda.setNew(true);
		tracciabilitaScheda.setPrimaryKey(id);

		return tracciabilitaScheda;
	}

	/**
	 * Removes the tracciabilita scheda with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the tracciabilita scheda
	 * @return the tracciabilita scheda that was removed
	 * @throws it.bysoftware.ct.NoSuchTracciabilitaSchedaException if a tracciabilita scheda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TracciabilitaScheda remove(long id)
		throws NoSuchTracciabilitaSchedaException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the tracciabilita scheda with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tracciabilita scheda
	 * @return the tracciabilita scheda that was removed
	 * @throws it.bysoftware.ct.NoSuchTracciabilitaSchedaException if a tracciabilita scheda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TracciabilitaScheda remove(Serializable primaryKey)
		throws NoSuchTracciabilitaSchedaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TracciabilitaScheda tracciabilitaScheda = (TracciabilitaScheda)session.get(TracciabilitaSchedaImpl.class,
					primaryKey);

			if (tracciabilitaScheda == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTracciabilitaSchedaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tracciabilitaScheda);
		}
		catch (NoSuchTracciabilitaSchedaException nsee) {
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
	protected TracciabilitaScheda removeImpl(
		TracciabilitaScheda tracciabilitaScheda) throws SystemException {
		tracciabilitaScheda = toUnwrappedModel(tracciabilitaScheda);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tracciabilitaScheda)) {
				tracciabilitaScheda = (TracciabilitaScheda)session.get(TracciabilitaSchedaImpl.class,
						tracciabilitaScheda.getPrimaryKeyObj());
			}

			if (tracciabilitaScheda != null) {
				session.delete(tracciabilitaScheda);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tracciabilitaScheda != null) {
			clearCache(tracciabilitaScheda);
		}

		return tracciabilitaScheda;
	}

	@Override
	public TracciabilitaScheda updateImpl(
		it.bysoftware.ct.model.TracciabilitaScheda tracciabilitaScheda)
		throws SystemException {
		tracciabilitaScheda = toUnwrappedModel(tracciabilitaScheda);

		boolean isNew = tracciabilitaScheda.isNew();

		TracciabilitaSchedaModelImpl tracciabilitaSchedaModelImpl = (TracciabilitaSchedaModelImpl)tracciabilitaScheda;

		Session session = null;

		try {
			session = openSession();

			if (tracciabilitaScheda.isNew()) {
				session.save(tracciabilitaScheda);

				tracciabilitaScheda.setNew(false);
			}
			else {
				session.merge(tracciabilitaScheda);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TracciabilitaSchedaModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tracciabilitaSchedaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANNOIDASSOCIATONDOCUMENTO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tracciabilitaSchedaModelImpl.getOriginalAnno(),
						tracciabilitaSchedaModelImpl.getOriginalIdAssociato(),
						tracciabilitaSchedaModelImpl.getOriginalNumeroDocumento(),
						tracciabilitaSchedaModelImpl.getOriginalTipoDocumento()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ANNOIDASSOCIATONDOCUMENTO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANNOIDASSOCIATONDOCUMENTO,
					args);

				args = new Object[] {
						tracciabilitaSchedaModelImpl.getAnno(),
						tracciabilitaSchedaModelImpl.getIdAssociato(),
						tracciabilitaSchedaModelImpl.getNumeroDocumento(),
						tracciabilitaSchedaModelImpl.getTipoDocumento()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ANNOIDASSOCIATONDOCUMENTO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANNOIDASSOCIATONDOCUMENTO,
					args);
			}
		}

		EntityCacheUtil.putResult(TracciabilitaSchedaModelImpl.ENTITY_CACHE_ENABLED,
			TracciabilitaSchedaImpl.class, tracciabilitaScheda.getPrimaryKey(),
			tracciabilitaScheda);

		return tracciabilitaScheda;
	}

	protected TracciabilitaScheda toUnwrappedModel(
		TracciabilitaScheda tracciabilitaScheda) {
		if (tracciabilitaScheda instanceof TracciabilitaSchedaImpl) {
			return tracciabilitaScheda;
		}

		TracciabilitaSchedaImpl tracciabilitaSchedaImpl = new TracciabilitaSchedaImpl();

		tracciabilitaSchedaImpl.setNew(tracciabilitaScheda.isNew());
		tracciabilitaSchedaImpl.setPrimaryKey(tracciabilitaScheda.getPrimaryKey());

		tracciabilitaSchedaImpl.setId(tracciabilitaScheda.getId());
		tracciabilitaSchedaImpl.setCodiceProdotto(tracciabilitaScheda.getCodiceProdotto());
		tracciabilitaSchedaImpl.setProdottoVenduto(tracciabilitaScheda.getProdottoVenduto());
		tracciabilitaSchedaImpl.setKgVenduti(tracciabilitaScheda.getKgVenduti());
		tracciabilitaSchedaImpl.setLottoVendita(tracciabilitaScheda.getLottoVendita());
		tracciabilitaSchedaImpl.setAnno(tracciabilitaScheda.getAnno());
		tracciabilitaSchedaImpl.setNumeroDocumento(tracciabilitaScheda.getNumeroDocumento());
		tracciabilitaSchedaImpl.setRigoOrdine(tracciabilitaScheda.getRigoOrdine());
		tracciabilitaSchedaImpl.setTipoDocumento(tracciabilitaScheda.getTipoDocumento());
		tracciabilitaSchedaImpl.setIdAssociato(tracciabilitaScheda.getIdAssociato());

		return tracciabilitaSchedaImpl;
	}

	/**
	 * Returns the tracciabilita scheda with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tracciabilita scheda
	 * @return the tracciabilita scheda
	 * @throws it.bysoftware.ct.NoSuchTracciabilitaSchedaException if a tracciabilita scheda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TracciabilitaScheda findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTracciabilitaSchedaException, SystemException {
		TracciabilitaScheda tracciabilitaScheda = fetchByPrimaryKey(primaryKey);

		if (tracciabilitaScheda == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTracciabilitaSchedaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tracciabilitaScheda;
	}

	/**
	 * Returns the tracciabilita scheda with the primary key or throws a {@link it.bysoftware.ct.NoSuchTracciabilitaSchedaException} if it could not be found.
	 *
	 * @param id the primary key of the tracciabilita scheda
	 * @return the tracciabilita scheda
	 * @throws it.bysoftware.ct.NoSuchTracciabilitaSchedaException if a tracciabilita scheda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TracciabilitaScheda findByPrimaryKey(long id)
		throws NoSuchTracciabilitaSchedaException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the tracciabilita scheda with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tracciabilita scheda
	 * @return the tracciabilita scheda, or <code>null</code> if a tracciabilita scheda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TracciabilitaScheda fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TracciabilitaScheda tracciabilitaScheda = (TracciabilitaScheda)EntityCacheUtil.getResult(TracciabilitaSchedaModelImpl.ENTITY_CACHE_ENABLED,
				TracciabilitaSchedaImpl.class, primaryKey);

		if (tracciabilitaScheda == _nullTracciabilitaScheda) {
			return null;
		}

		if (tracciabilitaScheda == null) {
			Session session = null;

			try {
				session = openSession();

				tracciabilitaScheda = (TracciabilitaScheda)session.get(TracciabilitaSchedaImpl.class,
						primaryKey);

				if (tracciabilitaScheda != null) {
					cacheResult(tracciabilitaScheda);
				}
				else {
					EntityCacheUtil.putResult(TracciabilitaSchedaModelImpl.ENTITY_CACHE_ENABLED,
						TracciabilitaSchedaImpl.class, primaryKey,
						_nullTracciabilitaScheda);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TracciabilitaSchedaModelImpl.ENTITY_CACHE_ENABLED,
					TracciabilitaSchedaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tracciabilitaScheda;
	}

	/**
	 * Returns the tracciabilita scheda with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the tracciabilita scheda
	 * @return the tracciabilita scheda, or <code>null</code> if a tracciabilita scheda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TracciabilitaScheda fetchByPrimaryKey(long id)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the tracciabilita schedas.
	 *
	 * @return the tracciabilita schedas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TracciabilitaScheda> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tracciabilita schedas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TracciabilitaSchedaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tracciabilita schedas
	 * @param end the upper bound of the range of tracciabilita schedas (not inclusive)
	 * @return the range of tracciabilita schedas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TracciabilitaScheda> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tracciabilita schedas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TracciabilitaSchedaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tracciabilita schedas
	 * @param end the upper bound of the range of tracciabilita schedas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tracciabilita schedas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TracciabilitaScheda> findAll(int start, int end,
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

		List<TracciabilitaScheda> list = (List<TracciabilitaScheda>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TRACCIABILITASCHEDA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TRACCIABILITASCHEDA;

				if (pagination) {
					sql = sql.concat(TracciabilitaSchedaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TracciabilitaScheda>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TracciabilitaScheda>(list);
				}
				else {
					list = (List<TracciabilitaScheda>)QueryUtil.list(q,
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
	 * Removes all the tracciabilita schedas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TracciabilitaScheda tracciabilitaScheda : findAll()) {
			remove(tracciabilitaScheda);
		}
	}

	/**
	 * Returns the number of tracciabilita schedas.
	 *
	 * @return the number of tracciabilita schedas
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

				Query q = session.createQuery(_SQL_COUNT_TRACCIABILITASCHEDA);

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
	 * Initializes the tracciabilita scheda persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.bysoftware.ct.model.TracciabilitaScheda")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TracciabilitaScheda>> listenersList = new ArrayList<ModelListener<TracciabilitaScheda>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TracciabilitaScheda>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TracciabilitaSchedaImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TRACCIABILITASCHEDA = "SELECT tracciabilitaScheda FROM TracciabilitaScheda tracciabilitaScheda";
	private static final String _SQL_SELECT_TRACCIABILITASCHEDA_WHERE = "SELECT tracciabilitaScheda FROM TracciabilitaScheda tracciabilitaScheda WHERE ";
	private static final String _SQL_COUNT_TRACCIABILITASCHEDA = "SELECT COUNT(tracciabilitaScheda) FROM TracciabilitaScheda tracciabilitaScheda";
	private static final String _SQL_COUNT_TRACCIABILITASCHEDA_WHERE = "SELECT COUNT(tracciabilitaScheda) FROM TracciabilitaScheda tracciabilitaScheda WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tracciabilitaScheda.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TracciabilitaScheda exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TracciabilitaScheda exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TracciabilitaSchedaPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"codiceProdotto", "prodottoVenduto", "kgVenduti", "lottoVendita",
				"numeroDocumento", "rigoOrdine", "tipoDocumento", "idAssociato"
			});
	private static TracciabilitaScheda _nullTracciabilitaScheda = new TracciabilitaSchedaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TracciabilitaScheda> toCacheModel() {
				return _nullTracciabilitaSchedaCacheModel;
			}
		};

	private static CacheModel<TracciabilitaScheda> _nullTracciabilitaSchedaCacheModel =
		new CacheModel<TracciabilitaScheda>() {
			@Override
			public TracciabilitaScheda toEntityModel() {
				return _nullTracciabilitaScheda;
			}
		};
}
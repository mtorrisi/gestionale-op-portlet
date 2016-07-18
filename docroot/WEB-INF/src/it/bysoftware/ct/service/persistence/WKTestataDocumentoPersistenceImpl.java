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

import it.bysoftware.ct.NoSuchWKTestataDocumentoException;
import it.bysoftware.ct.model.WKTestataDocumento;
import it.bysoftware.ct.model.impl.WKTestataDocumentoImpl;
import it.bysoftware.ct.model.impl.WKTestataDocumentoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the w k testata documento service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WKTestataDocumentoPersistence
 * @see WKTestataDocumentoUtil
 * @generated
 */
public class WKTestataDocumentoPersistenceImpl extends BasePersistenceImpl<WKTestataDocumento>
	implements WKTestataDocumentoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WKTestataDocumentoUtil} to access the w k testata documento persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WKTestataDocumentoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WKTestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			WKTestataDocumentoModelImpl.FINDER_CACHE_ENABLED,
			WKTestataDocumentoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WKTestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			WKTestataDocumentoModelImpl.FINDER_CACHE_ENABLED,
			WKTestataDocumentoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WKTestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			WKTestataDocumentoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ANNOASSOCIATOVERIFICATO =
		new FinderPath(WKTestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			WKTestataDocumentoModelImpl.FINDER_CACHE_ENABLED,
			WKTestataDocumentoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByAnnoAssociatoVerificato",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANNOASSOCIATOVERIFICATO =
		new FinderPath(WKTestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			WKTestataDocumentoModelImpl.FINDER_CACHE_ENABLED,
			WKTestataDocumentoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAnnoAssociatoVerificato",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			WKTestataDocumentoModelImpl.ANNO_COLUMN_BITMASK |
			WKTestataDocumentoModelImpl.IDASSOCIATO_COLUMN_BITMASK |
			WKTestataDocumentoModelImpl.VERIFICATO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ANNOASSOCIATOVERIFICATO = new FinderPath(WKTestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			WKTestataDocumentoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAnnoAssociatoVerificato",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns all the w k testata documentos where anno = &#63; and idAssociato = &#63; and verificato = &#63;.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param verificato the verificato
	 * @return the matching w k testata documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WKTestataDocumento> findByAnnoAssociatoVerificato(int anno,
		long idAssociato, boolean verificato) throws SystemException {
		return findByAnnoAssociatoVerificato(anno, idAssociato, verificato,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the w k testata documentos where anno = &#63; and idAssociato = &#63; and verificato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.WKTestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param verificato the verificato
	 * @param start the lower bound of the range of w k testata documentos
	 * @param end the upper bound of the range of w k testata documentos (not inclusive)
	 * @return the range of matching w k testata documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WKTestataDocumento> findByAnnoAssociatoVerificato(int anno,
		long idAssociato, boolean verificato, int start, int end)
		throws SystemException {
		return findByAnnoAssociatoVerificato(anno, idAssociato, verificato,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the w k testata documentos where anno = &#63; and idAssociato = &#63; and verificato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.WKTestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param verificato the verificato
	 * @param start the lower bound of the range of w k testata documentos
	 * @param end the upper bound of the range of w k testata documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching w k testata documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WKTestataDocumento> findByAnnoAssociatoVerificato(int anno,
		long idAssociato, boolean verificato, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANNOASSOCIATOVERIFICATO;
			finderArgs = new Object[] { anno, idAssociato, verificato };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ANNOASSOCIATOVERIFICATO;
			finderArgs = new Object[] {
					anno, idAssociato, verificato,
					
					start, end, orderByComparator
				};
		}

		List<WKTestataDocumento> list = (List<WKTestataDocumento>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WKTestataDocumento wkTestataDocumento : list) {
				if ((anno != wkTestataDocumento.getAnno()) ||
						(idAssociato != wkTestataDocumento.getIdAssociato()) ||
						(verificato != wkTestataDocumento.getVerificato())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_WKTESTATADOCUMENTO_WHERE);

			query.append(_FINDER_COLUMN_ANNOASSOCIATOVERIFICATO_ANNO_2);

			query.append(_FINDER_COLUMN_ANNOASSOCIATOVERIFICATO_IDASSOCIATO_2);

			query.append(_FINDER_COLUMN_ANNOASSOCIATOVERIFICATO_VERIFICATO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WKTestataDocumentoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(anno);

				qPos.add(idAssociato);

				qPos.add(verificato);

				if (!pagination) {
					list = (List<WKTestataDocumento>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WKTestataDocumento>(list);
				}
				else {
					list = (List<WKTestataDocumento>)QueryUtil.list(q,
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
	 * Returns the first w k testata documento in the ordered set where anno = &#63; and idAssociato = &#63; and verificato = &#63;.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param verificato the verificato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w k testata documento
	 * @throws it.bysoftware.ct.NoSuchWKTestataDocumentoException if a matching w k testata documento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WKTestataDocumento findByAnnoAssociatoVerificato_First(int anno,
		long idAssociato, boolean verificato,
		OrderByComparator orderByComparator)
		throws NoSuchWKTestataDocumentoException, SystemException {
		WKTestataDocumento wkTestataDocumento = fetchByAnnoAssociatoVerificato_First(anno,
				idAssociato, verificato, orderByComparator);

		if (wkTestataDocumento != null) {
			return wkTestataDocumento;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("anno=");
		msg.append(anno);

		msg.append(", idAssociato=");
		msg.append(idAssociato);

		msg.append(", verificato=");
		msg.append(verificato);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWKTestataDocumentoException(msg.toString());
	}

	/**
	 * Returns the first w k testata documento in the ordered set where anno = &#63; and idAssociato = &#63; and verificato = &#63;.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param verificato the verificato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w k testata documento, or <code>null</code> if a matching w k testata documento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WKTestataDocumento fetchByAnnoAssociatoVerificato_First(int anno,
		long idAssociato, boolean verificato,
		OrderByComparator orderByComparator) throws SystemException {
		List<WKTestataDocumento> list = findByAnnoAssociatoVerificato(anno,
				idAssociato, verificato, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last w k testata documento in the ordered set where anno = &#63; and idAssociato = &#63; and verificato = &#63;.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param verificato the verificato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w k testata documento
	 * @throws it.bysoftware.ct.NoSuchWKTestataDocumentoException if a matching w k testata documento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WKTestataDocumento findByAnnoAssociatoVerificato_Last(int anno,
		long idAssociato, boolean verificato,
		OrderByComparator orderByComparator)
		throws NoSuchWKTestataDocumentoException, SystemException {
		WKTestataDocumento wkTestataDocumento = fetchByAnnoAssociatoVerificato_Last(anno,
				idAssociato, verificato, orderByComparator);

		if (wkTestataDocumento != null) {
			return wkTestataDocumento;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("anno=");
		msg.append(anno);

		msg.append(", idAssociato=");
		msg.append(idAssociato);

		msg.append(", verificato=");
		msg.append(verificato);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWKTestataDocumentoException(msg.toString());
	}

	/**
	 * Returns the last w k testata documento in the ordered set where anno = &#63; and idAssociato = &#63; and verificato = &#63;.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param verificato the verificato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w k testata documento, or <code>null</code> if a matching w k testata documento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WKTestataDocumento fetchByAnnoAssociatoVerificato_Last(int anno,
		long idAssociato, boolean verificato,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAnnoAssociatoVerificato(anno, idAssociato, verificato);

		if (count == 0) {
			return null;
		}

		List<WKTestataDocumento> list = findByAnnoAssociatoVerificato(anno,
				idAssociato, verificato, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the w k testata documentos before and after the current w k testata documento in the ordered set where anno = &#63; and idAssociato = &#63; and verificato = &#63;.
	 *
	 * @param wkTestataDocumentoPK the primary key of the current w k testata documento
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param verificato the verificato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next w k testata documento
	 * @throws it.bysoftware.ct.NoSuchWKTestataDocumentoException if a w k testata documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WKTestataDocumento[] findByAnnoAssociatoVerificato_PrevAndNext(
		WKTestataDocumentoPK wkTestataDocumentoPK, int anno, long idAssociato,
		boolean verificato, OrderByComparator orderByComparator)
		throws NoSuchWKTestataDocumentoException, SystemException {
		WKTestataDocumento wkTestataDocumento = findByPrimaryKey(wkTestataDocumentoPK);

		Session session = null;

		try {
			session = openSession();

			WKTestataDocumento[] array = new WKTestataDocumentoImpl[3];

			array[0] = getByAnnoAssociatoVerificato_PrevAndNext(session,
					wkTestataDocumento, anno, idAssociato, verificato,
					orderByComparator, true);

			array[1] = wkTestataDocumento;

			array[2] = getByAnnoAssociatoVerificato_PrevAndNext(session,
					wkTestataDocumento, anno, idAssociato, verificato,
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

	protected WKTestataDocumento getByAnnoAssociatoVerificato_PrevAndNext(
		Session session, WKTestataDocumento wkTestataDocumento, int anno,
		long idAssociato, boolean verificato,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WKTESTATADOCUMENTO_WHERE);

		query.append(_FINDER_COLUMN_ANNOASSOCIATOVERIFICATO_ANNO_2);

		query.append(_FINDER_COLUMN_ANNOASSOCIATOVERIFICATO_IDASSOCIATO_2);

		query.append(_FINDER_COLUMN_ANNOASSOCIATOVERIFICATO_VERIFICATO_2);

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
			query.append(WKTestataDocumentoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(anno);

		qPos.add(idAssociato);

		qPos.add(verificato);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wkTestataDocumento);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WKTestataDocumento> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the w k testata documentos where anno = &#63; and idAssociato = &#63; and verificato = &#63; from the database.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param verificato the verificato
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAnnoAssociatoVerificato(int anno, long idAssociato,
		boolean verificato) throws SystemException {
		for (WKTestataDocumento wkTestataDocumento : findByAnnoAssociatoVerificato(
				anno, idAssociato, verificato, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(wkTestataDocumento);
		}
	}

	/**
	 * Returns the number of w k testata documentos where anno = &#63; and idAssociato = &#63; and verificato = &#63;.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param verificato the verificato
	 * @return the number of matching w k testata documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAnnoAssociatoVerificato(int anno, long idAssociato,
		boolean verificato) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ANNOASSOCIATOVERIFICATO;

		Object[] finderArgs = new Object[] { anno, idAssociato, verificato };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_WKTESTATADOCUMENTO_WHERE);

			query.append(_FINDER_COLUMN_ANNOASSOCIATOVERIFICATO_ANNO_2);

			query.append(_FINDER_COLUMN_ANNOASSOCIATOVERIFICATO_IDASSOCIATO_2);

			query.append(_FINDER_COLUMN_ANNOASSOCIATOVERIFICATO_VERIFICATO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(anno);

				qPos.add(idAssociato);

				qPos.add(verificato);

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

	private static final String _FINDER_COLUMN_ANNOASSOCIATOVERIFICATO_ANNO_2 = "wkTestataDocumento.id.anno = ? AND ";
	private static final String _FINDER_COLUMN_ANNOASSOCIATOVERIFICATO_IDASSOCIATO_2 =
		"wkTestataDocumento.id.idAssociato = ? AND ";
	private static final String _FINDER_COLUMN_ANNOASSOCIATOVERIFICATO_VERIFICATO_2 =
		"wkTestataDocumento.verificato = ?";

	public WKTestataDocumentoPersistenceImpl() {
		setModelClass(WKTestataDocumento.class);
	}

	/**
	 * Caches the w k testata documento in the entity cache if it is enabled.
	 *
	 * @param wkTestataDocumento the w k testata documento
	 */
	@Override
	public void cacheResult(WKTestataDocumento wkTestataDocumento) {
		EntityCacheUtil.putResult(WKTestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			WKTestataDocumentoImpl.class, wkTestataDocumento.getPrimaryKey(),
			wkTestataDocumento);

		wkTestataDocumento.resetOriginalValues();
	}

	/**
	 * Caches the w k testata documentos in the entity cache if it is enabled.
	 *
	 * @param wkTestataDocumentos the w k testata documentos
	 */
	@Override
	public void cacheResult(List<WKTestataDocumento> wkTestataDocumentos) {
		for (WKTestataDocumento wkTestataDocumento : wkTestataDocumentos) {
			if (EntityCacheUtil.getResult(
						WKTestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
						WKTestataDocumentoImpl.class,
						wkTestataDocumento.getPrimaryKey()) == null) {
				cacheResult(wkTestataDocumento);
			}
			else {
				wkTestataDocumento.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all w k testata documentos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WKTestataDocumentoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WKTestataDocumentoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the w k testata documento.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WKTestataDocumento wkTestataDocumento) {
		EntityCacheUtil.removeResult(WKTestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			WKTestataDocumentoImpl.class, wkTestataDocumento.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<WKTestataDocumento> wkTestataDocumentos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WKTestataDocumento wkTestataDocumento : wkTestataDocumentos) {
			EntityCacheUtil.removeResult(WKTestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
				WKTestataDocumentoImpl.class, wkTestataDocumento.getPrimaryKey());
		}
	}

	/**
	 * Creates a new w k testata documento with the primary key. Does not add the w k testata documento to the database.
	 *
	 * @param wkTestataDocumentoPK the primary key for the new w k testata documento
	 * @return the new w k testata documento
	 */
	@Override
	public WKTestataDocumento create(WKTestataDocumentoPK wkTestataDocumentoPK) {
		WKTestataDocumento wkTestataDocumento = new WKTestataDocumentoImpl();

		wkTestataDocumento.setNew(true);
		wkTestataDocumento.setPrimaryKey(wkTestataDocumentoPK);

		return wkTestataDocumento;
	}

	/**
	 * Removes the w k testata documento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param wkTestataDocumentoPK the primary key of the w k testata documento
	 * @return the w k testata documento that was removed
	 * @throws it.bysoftware.ct.NoSuchWKTestataDocumentoException if a w k testata documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WKTestataDocumento remove(WKTestataDocumentoPK wkTestataDocumentoPK)
		throws NoSuchWKTestataDocumentoException, SystemException {
		return remove((Serializable)wkTestataDocumentoPK);
	}

	/**
	 * Removes the w k testata documento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the w k testata documento
	 * @return the w k testata documento that was removed
	 * @throws it.bysoftware.ct.NoSuchWKTestataDocumentoException if a w k testata documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WKTestataDocumento remove(Serializable primaryKey)
		throws NoSuchWKTestataDocumentoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			WKTestataDocumento wkTestataDocumento = (WKTestataDocumento)session.get(WKTestataDocumentoImpl.class,
					primaryKey);

			if (wkTestataDocumento == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWKTestataDocumentoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(wkTestataDocumento);
		}
		catch (NoSuchWKTestataDocumentoException nsee) {
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
	protected WKTestataDocumento removeImpl(
		WKTestataDocumento wkTestataDocumento) throws SystemException {
		wkTestataDocumento = toUnwrappedModel(wkTestataDocumento);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(wkTestataDocumento)) {
				wkTestataDocumento = (WKTestataDocumento)session.get(WKTestataDocumentoImpl.class,
						wkTestataDocumento.getPrimaryKeyObj());
			}

			if (wkTestataDocumento != null) {
				session.delete(wkTestataDocumento);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (wkTestataDocumento != null) {
			clearCache(wkTestataDocumento);
		}

		return wkTestataDocumento;
	}

	@Override
	public WKTestataDocumento updateImpl(
		it.bysoftware.ct.model.WKTestataDocumento wkTestataDocumento)
		throws SystemException {
		wkTestataDocumento = toUnwrappedModel(wkTestataDocumento);

		boolean isNew = wkTestataDocumento.isNew();

		WKTestataDocumentoModelImpl wkTestataDocumentoModelImpl = (WKTestataDocumentoModelImpl)wkTestataDocumento;

		Session session = null;

		try {
			session = openSession();

			if (wkTestataDocumento.isNew()) {
				session.save(wkTestataDocumento);

				wkTestataDocumento.setNew(false);
			}
			else {
				session.merge(wkTestataDocumento);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !WKTestataDocumentoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((wkTestataDocumentoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANNOASSOCIATOVERIFICATO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wkTestataDocumentoModelImpl.getOriginalAnno(),
						wkTestataDocumentoModelImpl.getOriginalIdAssociato(),
						wkTestataDocumentoModelImpl.getOriginalVerificato()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ANNOASSOCIATOVERIFICATO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANNOASSOCIATOVERIFICATO,
					args);

				args = new Object[] {
						wkTestataDocumentoModelImpl.getAnno(),
						wkTestataDocumentoModelImpl.getIdAssociato(),
						wkTestataDocumentoModelImpl.getVerificato()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ANNOASSOCIATOVERIFICATO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANNOASSOCIATOVERIFICATO,
					args);
			}
		}

		EntityCacheUtil.putResult(WKTestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			WKTestataDocumentoImpl.class, wkTestataDocumento.getPrimaryKey(),
			wkTestataDocumento);

		return wkTestataDocumento;
	}

	protected WKTestataDocumento toUnwrappedModel(
		WKTestataDocumento wkTestataDocumento) {
		if (wkTestataDocumento instanceof WKTestataDocumentoImpl) {
			return wkTestataDocumento;
		}

		WKTestataDocumentoImpl wkTestataDocumentoImpl = new WKTestataDocumentoImpl();

		wkTestataDocumentoImpl.setNew(wkTestataDocumento.isNew());
		wkTestataDocumentoImpl.setPrimaryKey(wkTestataDocumento.getPrimaryKey());

		wkTestataDocumentoImpl.setAnno(wkTestataDocumento.getAnno());
		wkTestataDocumentoImpl.setNumeroOrdine(wkTestataDocumento.getNumeroOrdine());
		wkTestataDocumentoImpl.setCodiceSoggetto(wkTestataDocumento.getCodiceSoggetto());
		wkTestataDocumentoImpl.setDataOrdine(wkTestataDocumento.getDataOrdine());
		wkTestataDocumentoImpl.setDataConsegna(wkTestataDocumento.getDataConsegna());
		wkTestataDocumentoImpl.setDestinazione(wkTestataDocumento.getDestinazione());
		wkTestataDocumentoImpl.setCodiceDestinazione(wkTestataDocumento.getCodiceDestinazione());
		wkTestataDocumentoImpl.setRagioneSociale(wkTestataDocumento.getRagioneSociale());
		wkTestataDocumentoImpl.setCompleto(wkTestataDocumento.getCompleto());
		wkTestataDocumentoImpl.setOperatore(wkTestataDocumento.getOperatore());
		wkTestataDocumentoImpl.setVisto(wkTestataDocumento.getVisto());
		wkTestataDocumentoImpl.setInviato(wkTestataDocumento.getInviato());
		wkTestataDocumentoImpl.setLotto(wkTestataDocumento.getLotto());
		wkTestataDocumentoImpl.setTipoDocumento(wkTestataDocumento.getTipoDocumento());
		wkTestataDocumentoImpl.setVettore(wkTestataDocumento.getVettore());
		wkTestataDocumentoImpl.setAutista(wkTestataDocumento.getAutista());
		wkTestataDocumentoImpl.setTelefono(wkTestataDocumento.getTelefono());
		wkTestataDocumentoImpl.setCentro(wkTestataDocumento.getCentro());
		wkTestataDocumentoImpl.setPalletCaricati(wkTestataDocumento.getPalletCaricati());
		wkTestataDocumentoImpl.setPalletScaricati(wkTestataDocumento.getPalletScaricati());
		wkTestataDocumentoImpl.setCodiceVettore(wkTestataDocumento.getCodiceVettore());
		wkTestataDocumentoImpl.setDestinazioneVettore(wkTestataDocumento.getDestinazioneVettore());
		wkTestataDocumentoImpl.setNota1(wkTestataDocumento.getNota1());
		wkTestataDocumentoImpl.setNota2(wkTestataDocumento.getNota2());
		wkTestataDocumentoImpl.setRigoDescrittivo(wkTestataDocumento.getRigoDescrittivo());
		wkTestataDocumentoImpl.setVettore2(wkTestataDocumento.getVettore2());
		wkTestataDocumentoImpl.setCuraTrasporto(wkTestataDocumento.getCuraTrasporto());
		wkTestataDocumentoImpl.setAspettoEsteriore(wkTestataDocumento.getAspettoEsteriore());
		wkTestataDocumentoImpl.setCausaleTrasporto(wkTestataDocumento.getCausaleTrasporto());
		wkTestataDocumentoImpl.setPorto(wkTestataDocumento.getPorto());
		wkTestataDocumentoImpl.setOrigine(wkTestataDocumento.getOrigine());
		wkTestataDocumentoImpl.setNumeroPedaneEuro(wkTestataDocumento.getNumeroPedaneEuro());
		wkTestataDocumentoImpl.setNumeroPedaneNormali(wkTestataDocumento.getNumeroPedaneNormali());
		wkTestataDocumentoImpl.setCostoTrasporto(wkTestataDocumento.getCostoTrasporto());
		wkTestataDocumentoImpl.setTotalePedaneOrdine(wkTestataDocumento.getTotalePedaneOrdine());
		wkTestataDocumentoImpl.setTargaCamion(wkTestataDocumento.getTargaCamion());
		wkTestataDocumentoImpl.setTargaRimorchio(wkTestataDocumento.getTargaRimorchio());
		wkTestataDocumentoImpl.setIdAssociato(wkTestataDocumento.getIdAssociato());
		wkTestataDocumentoImpl.setVerificato(wkTestataDocumento.isVerificato());

		return wkTestataDocumentoImpl;
	}

	/**
	 * Returns the w k testata documento with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the w k testata documento
	 * @return the w k testata documento
	 * @throws it.bysoftware.ct.NoSuchWKTestataDocumentoException if a w k testata documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WKTestataDocumento findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWKTestataDocumentoException, SystemException {
		WKTestataDocumento wkTestataDocumento = fetchByPrimaryKey(primaryKey);

		if (wkTestataDocumento == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWKTestataDocumentoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return wkTestataDocumento;
	}

	/**
	 * Returns the w k testata documento with the primary key or throws a {@link it.bysoftware.ct.NoSuchWKTestataDocumentoException} if it could not be found.
	 *
	 * @param wkTestataDocumentoPK the primary key of the w k testata documento
	 * @return the w k testata documento
	 * @throws it.bysoftware.ct.NoSuchWKTestataDocumentoException if a w k testata documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WKTestataDocumento findByPrimaryKey(
		WKTestataDocumentoPK wkTestataDocumentoPK)
		throws NoSuchWKTestataDocumentoException, SystemException {
		return findByPrimaryKey((Serializable)wkTestataDocumentoPK);
	}

	/**
	 * Returns the w k testata documento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the w k testata documento
	 * @return the w k testata documento, or <code>null</code> if a w k testata documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WKTestataDocumento fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		WKTestataDocumento wkTestataDocumento = (WKTestataDocumento)EntityCacheUtil.getResult(WKTestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
				WKTestataDocumentoImpl.class, primaryKey);

		if (wkTestataDocumento == _nullWKTestataDocumento) {
			return null;
		}

		if (wkTestataDocumento == null) {
			Session session = null;

			try {
				session = openSession();

				wkTestataDocumento = (WKTestataDocumento)session.get(WKTestataDocumentoImpl.class,
						primaryKey);

				if (wkTestataDocumento != null) {
					cacheResult(wkTestataDocumento);
				}
				else {
					EntityCacheUtil.putResult(WKTestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
						WKTestataDocumentoImpl.class, primaryKey,
						_nullWKTestataDocumento);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(WKTestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
					WKTestataDocumentoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return wkTestataDocumento;
	}

	/**
	 * Returns the w k testata documento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param wkTestataDocumentoPK the primary key of the w k testata documento
	 * @return the w k testata documento, or <code>null</code> if a w k testata documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WKTestataDocumento fetchByPrimaryKey(
		WKTestataDocumentoPK wkTestataDocumentoPK) throws SystemException {
		return fetchByPrimaryKey((Serializable)wkTestataDocumentoPK);
	}

	/**
	 * Returns all the w k testata documentos.
	 *
	 * @return the w k testata documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WKTestataDocumento> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the w k testata documentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.WKTestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of w k testata documentos
	 * @param end the upper bound of the range of w k testata documentos (not inclusive)
	 * @return the range of w k testata documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WKTestataDocumento> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the w k testata documentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.WKTestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of w k testata documentos
	 * @param end the upper bound of the range of w k testata documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of w k testata documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WKTestataDocumento> findAll(int start, int end,
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

		List<WKTestataDocumento> list = (List<WKTestataDocumento>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WKTESTATADOCUMENTO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WKTESTATADOCUMENTO;

				if (pagination) {
					sql = sql.concat(WKTestataDocumentoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WKTestataDocumento>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WKTestataDocumento>(list);
				}
				else {
					list = (List<WKTestataDocumento>)QueryUtil.list(q,
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
	 * Removes all the w k testata documentos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (WKTestataDocumento wkTestataDocumento : findAll()) {
			remove(wkTestataDocumento);
		}
	}

	/**
	 * Returns the number of w k testata documentos.
	 *
	 * @return the number of w k testata documentos
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

				Query q = session.createQuery(_SQL_COUNT_WKTESTATADOCUMENTO);

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
	 * Initializes the w k testata documento persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.bysoftware.ct.model.WKTestataDocumento")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<WKTestataDocumento>> listenersList = new ArrayList<ModelListener<WKTestataDocumento>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<WKTestataDocumento>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(WKTestataDocumentoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_WKTESTATADOCUMENTO = "SELECT wkTestataDocumento FROM WKTestataDocumento wkTestataDocumento";
	private static final String _SQL_SELECT_WKTESTATADOCUMENTO_WHERE = "SELECT wkTestataDocumento FROM WKTestataDocumento wkTestataDocumento WHERE ";
	private static final String _SQL_COUNT_WKTESTATADOCUMENTO = "SELECT COUNT(wkTestataDocumento) FROM WKTestataDocumento wkTestataDocumento";
	private static final String _SQL_COUNT_WKTESTATADOCUMENTO_WHERE = "SELECT COUNT(wkTestataDocumento) FROM WKTestataDocumento wkTestataDocumento WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "wkTestataDocumento.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WKTestataDocumento exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WKTestataDocumento exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WKTestataDocumentoPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"anno", "numeroOrdine", "codiceSoggetto", "dataOrdine",
				"dataConsegna", "destinazione", "codiceDestinazione",
				"ragioneSociale", "completo", "operatore", "visto", "inviato",
				"lotto", "tipoDocumento", "vettore", "autista", "telefono",
				"centro", "palletCaricati", "palletScaricati", "codiceVettore",
				"destinazioneVettore", "nota1", "nota2", "rigoDescrittivo",
				"vettore2", "curaTrasporto", "aspettoEsteriore",
				"causaleTrasporto", "origine", "numeroPedaneEuro",
				"numeroPedaneNormali", "costoTrasporto", "totalePedaneOrdine",
				"targaCamion", "targaRimorchio", "idAssociato"
			});
	private static WKTestataDocumento _nullWKTestataDocumento = new WKTestataDocumentoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<WKTestataDocumento> toCacheModel() {
				return _nullWKTestataDocumentoCacheModel;
			}
		};

	private static CacheModel<WKTestataDocumento> _nullWKTestataDocumentoCacheModel =
		new CacheModel<WKTestataDocumento>() {
			@Override
			public WKTestataDocumento toEntityModel() {
				return _nullWKTestataDocumento;
			}
		};
}
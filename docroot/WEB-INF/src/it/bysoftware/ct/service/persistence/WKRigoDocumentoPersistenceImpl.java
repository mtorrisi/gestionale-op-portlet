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

import it.bysoftware.ct.NoSuchWKRigoDocumentoException;
import it.bysoftware.ct.model.WKRigoDocumento;
import it.bysoftware.ct.model.impl.WKRigoDocumentoImpl;
import it.bysoftware.ct.model.impl.WKRigoDocumentoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the w k rigo documento service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WKRigoDocumentoPersistence
 * @see WKRigoDocumentoUtil
 * @generated
 */
public class WKRigoDocumentoPersistenceImpl extends BasePersistenceImpl<WKRigoDocumento>
	implements WKRigoDocumentoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WKRigoDocumentoUtil} to access the w k rigo documento persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WKRigoDocumentoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WKRigoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			WKRigoDocumentoModelImpl.FINDER_CACHE_ENABLED,
			WKRigoDocumentoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WKRigoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			WKRigoDocumentoModelImpl.FINDER_CACHE_ENABLED,
			WKRigoDocumentoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WKRigoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			WKRigoDocumentoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NUMEROORDINEANNOASSOCIATO =
		new FinderPath(WKRigoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			WKRigoDocumentoModelImpl.FINDER_CACHE_ENABLED,
			WKRigoDocumentoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBynumeroOrdineAnnoAssociato",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMEROORDINEANNOASSOCIATO =
		new FinderPath(WKRigoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			WKRigoDocumentoModelImpl.FINDER_CACHE_ENABLED,
			WKRigoDocumentoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBynumeroOrdineAnnoAssociato",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Long.class.getName(), String.class.getName()
			},
			WKRigoDocumentoModelImpl.NUMEROORDINE_COLUMN_BITMASK |
			WKRigoDocumentoModelImpl.ANNO_COLUMN_BITMASK |
			WKRigoDocumentoModelImpl.IDASSOCIATO_COLUMN_BITMASK |
			WKRigoDocumentoModelImpl.TIPODOCUMENTO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NUMEROORDINEANNOASSOCIATO =
		new FinderPath(WKRigoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			WKRigoDocumentoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBynumeroOrdineAnnoAssociato",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Long.class.getName(), String.class.getName()
			});

	/**
	 * Returns all the w k rigo documentos where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	 *
	 * @param numeroOrdine the numero ordine
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param tipoDocumento the tipo documento
	 * @return the matching w k rigo documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WKRigoDocumento> findBynumeroOrdineAnnoAssociato(
		long numeroOrdine, int anno, long idAssociato, String tipoDocumento)
		throws SystemException {
		return findBynumeroOrdineAnnoAssociato(numeroOrdine, anno, idAssociato,
			tipoDocumento, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the w k rigo documentos where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.WKRigoDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param numeroOrdine the numero ordine
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param tipoDocumento the tipo documento
	 * @param start the lower bound of the range of w k rigo documentos
	 * @param end the upper bound of the range of w k rigo documentos (not inclusive)
	 * @return the range of matching w k rigo documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WKRigoDocumento> findBynumeroOrdineAnnoAssociato(
		long numeroOrdine, int anno, long idAssociato, String tipoDocumento,
		int start, int end) throws SystemException {
		return findBynumeroOrdineAnnoAssociato(numeroOrdine, anno, idAssociato,
			tipoDocumento, start, end, null);
	}

	/**
	 * Returns an ordered range of all the w k rigo documentos where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.WKRigoDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param numeroOrdine the numero ordine
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param tipoDocumento the tipo documento
	 * @param start the lower bound of the range of w k rigo documentos
	 * @param end the upper bound of the range of w k rigo documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching w k rigo documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WKRigoDocumento> findBynumeroOrdineAnnoAssociato(
		long numeroOrdine, int anno, long idAssociato, String tipoDocumento,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMEROORDINEANNOASSOCIATO;
			finderArgs = new Object[] {
					numeroOrdine, anno, idAssociato, tipoDocumento
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NUMEROORDINEANNOASSOCIATO;
			finderArgs = new Object[] {
					numeroOrdine, anno, idAssociato, tipoDocumento,
					
					start, end, orderByComparator
				};
		}

		List<WKRigoDocumento> list = (List<WKRigoDocumento>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WKRigoDocumento wkRigoDocumento : list) {
				if ((numeroOrdine != wkRigoDocumento.getNumeroOrdine()) ||
						(anno != wkRigoDocumento.getAnno()) ||
						(idAssociato != wkRigoDocumento.getIdAssociato()) ||
						!Validator.equals(tipoDocumento,
							wkRigoDocumento.getTipoDocumento())) {
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

			query.append(_SQL_SELECT_WKRIGODOCUMENTO_WHERE);

			query.append(_FINDER_COLUMN_NUMEROORDINEANNOASSOCIATO_NUMEROORDINE_2);

			query.append(_FINDER_COLUMN_NUMEROORDINEANNOASSOCIATO_ANNO_2);

			query.append(_FINDER_COLUMN_NUMEROORDINEANNOASSOCIATO_IDASSOCIATO_2);

			boolean bindTipoDocumento = false;

			if (tipoDocumento == null) {
				query.append(_FINDER_COLUMN_NUMEROORDINEANNOASSOCIATO_TIPODOCUMENTO_1);
			}
			else if (tipoDocumento.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NUMEROORDINEANNOASSOCIATO_TIPODOCUMENTO_3);
			}
			else {
				bindTipoDocumento = true;

				query.append(_FINDER_COLUMN_NUMEROORDINEANNOASSOCIATO_TIPODOCUMENTO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WKRigoDocumentoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(numeroOrdine);

				qPos.add(anno);

				qPos.add(idAssociato);

				if (bindTipoDocumento) {
					qPos.add(tipoDocumento);
				}

				if (!pagination) {
					list = (List<WKRigoDocumento>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WKRigoDocumento>(list);
				}
				else {
					list = (List<WKRigoDocumento>)QueryUtil.list(q,
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
	 * Returns the first w k rigo documento in the ordered set where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	 *
	 * @param numeroOrdine the numero ordine
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param tipoDocumento the tipo documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w k rigo documento
	 * @throws it.bysoftware.ct.NoSuchWKRigoDocumentoException if a matching w k rigo documento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WKRigoDocumento findBynumeroOrdineAnnoAssociato_First(
		long numeroOrdine, int anno, long idAssociato, String tipoDocumento,
		OrderByComparator orderByComparator)
		throws NoSuchWKRigoDocumentoException, SystemException {
		WKRigoDocumento wkRigoDocumento = fetchBynumeroOrdineAnnoAssociato_First(numeroOrdine,
				anno, idAssociato, tipoDocumento, orderByComparator);

		if (wkRigoDocumento != null) {
			return wkRigoDocumento;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("numeroOrdine=");
		msg.append(numeroOrdine);

		msg.append(", anno=");
		msg.append(anno);

		msg.append(", idAssociato=");
		msg.append(idAssociato);

		msg.append(", tipoDocumento=");
		msg.append(tipoDocumento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWKRigoDocumentoException(msg.toString());
	}

	/**
	 * Returns the first w k rigo documento in the ordered set where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	 *
	 * @param numeroOrdine the numero ordine
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param tipoDocumento the tipo documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w k rigo documento, or <code>null</code> if a matching w k rigo documento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WKRigoDocumento fetchBynumeroOrdineAnnoAssociato_First(
		long numeroOrdine, int anno, long idAssociato, String tipoDocumento,
		OrderByComparator orderByComparator) throws SystemException {
		List<WKRigoDocumento> list = findBynumeroOrdineAnnoAssociato(numeroOrdine,
				anno, idAssociato, tipoDocumento, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last w k rigo documento in the ordered set where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	 *
	 * @param numeroOrdine the numero ordine
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param tipoDocumento the tipo documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w k rigo documento
	 * @throws it.bysoftware.ct.NoSuchWKRigoDocumentoException if a matching w k rigo documento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WKRigoDocumento findBynumeroOrdineAnnoAssociato_Last(
		long numeroOrdine, int anno, long idAssociato, String tipoDocumento,
		OrderByComparator orderByComparator)
		throws NoSuchWKRigoDocumentoException, SystemException {
		WKRigoDocumento wkRigoDocumento = fetchBynumeroOrdineAnnoAssociato_Last(numeroOrdine,
				anno, idAssociato, tipoDocumento, orderByComparator);

		if (wkRigoDocumento != null) {
			return wkRigoDocumento;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("numeroOrdine=");
		msg.append(numeroOrdine);

		msg.append(", anno=");
		msg.append(anno);

		msg.append(", idAssociato=");
		msg.append(idAssociato);

		msg.append(", tipoDocumento=");
		msg.append(tipoDocumento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWKRigoDocumentoException(msg.toString());
	}

	/**
	 * Returns the last w k rigo documento in the ordered set where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	 *
	 * @param numeroOrdine the numero ordine
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param tipoDocumento the tipo documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w k rigo documento, or <code>null</code> if a matching w k rigo documento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WKRigoDocumento fetchBynumeroOrdineAnnoAssociato_Last(
		long numeroOrdine, int anno, long idAssociato, String tipoDocumento,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBynumeroOrdineAnnoAssociato(numeroOrdine, anno,
				idAssociato, tipoDocumento);

		if (count == 0) {
			return null;
		}

		List<WKRigoDocumento> list = findBynumeroOrdineAnnoAssociato(numeroOrdine,
				anno, idAssociato, tipoDocumento, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the w k rigo documentos before and after the current w k rigo documento in the ordered set where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	 *
	 * @param wkRigoDocumentoPK the primary key of the current w k rigo documento
	 * @param numeroOrdine the numero ordine
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param tipoDocumento the tipo documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next w k rigo documento
	 * @throws it.bysoftware.ct.NoSuchWKRigoDocumentoException if a w k rigo documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WKRigoDocumento[] findBynumeroOrdineAnnoAssociato_PrevAndNext(
		WKRigoDocumentoPK wkRigoDocumentoPK, long numeroOrdine, int anno,
		long idAssociato, String tipoDocumento,
		OrderByComparator orderByComparator)
		throws NoSuchWKRigoDocumentoException, SystemException {
		WKRigoDocumento wkRigoDocumento = findByPrimaryKey(wkRigoDocumentoPK);

		Session session = null;

		try {
			session = openSession();

			WKRigoDocumento[] array = new WKRigoDocumentoImpl[3];

			array[0] = getBynumeroOrdineAnnoAssociato_PrevAndNext(session,
					wkRigoDocumento, numeroOrdine, anno, idAssociato,
					tipoDocumento, orderByComparator, true);

			array[1] = wkRigoDocumento;

			array[2] = getBynumeroOrdineAnnoAssociato_PrevAndNext(session,
					wkRigoDocumento, numeroOrdine, anno, idAssociato,
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

	protected WKRigoDocumento getBynumeroOrdineAnnoAssociato_PrevAndNext(
		Session session, WKRigoDocumento wkRigoDocumento, long numeroOrdine,
		int anno, long idAssociato, String tipoDocumento,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WKRIGODOCUMENTO_WHERE);

		query.append(_FINDER_COLUMN_NUMEROORDINEANNOASSOCIATO_NUMEROORDINE_2);

		query.append(_FINDER_COLUMN_NUMEROORDINEANNOASSOCIATO_ANNO_2);

		query.append(_FINDER_COLUMN_NUMEROORDINEANNOASSOCIATO_IDASSOCIATO_2);

		boolean bindTipoDocumento = false;

		if (tipoDocumento == null) {
			query.append(_FINDER_COLUMN_NUMEROORDINEANNOASSOCIATO_TIPODOCUMENTO_1);
		}
		else if (tipoDocumento.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NUMEROORDINEANNOASSOCIATO_TIPODOCUMENTO_3);
		}
		else {
			bindTipoDocumento = true;

			query.append(_FINDER_COLUMN_NUMEROORDINEANNOASSOCIATO_TIPODOCUMENTO_2);
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
			query.append(WKRigoDocumentoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(numeroOrdine);

		qPos.add(anno);

		qPos.add(idAssociato);

		if (bindTipoDocumento) {
			qPos.add(tipoDocumento);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wkRigoDocumento);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WKRigoDocumento> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the w k rigo documentos where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63; from the database.
	 *
	 * @param numeroOrdine the numero ordine
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param tipoDocumento the tipo documento
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBynumeroOrdineAnnoAssociato(long numeroOrdine, int anno,
		long idAssociato, String tipoDocumento) throws SystemException {
		for (WKRigoDocumento wkRigoDocumento : findBynumeroOrdineAnnoAssociato(
				numeroOrdine, anno, idAssociato, tipoDocumento,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wkRigoDocumento);
		}
	}

	/**
	 * Returns the number of w k rigo documentos where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	 *
	 * @param numeroOrdine the numero ordine
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param tipoDocumento the tipo documento
	 * @return the number of matching w k rigo documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBynumeroOrdineAnnoAssociato(long numeroOrdine, int anno,
		long idAssociato, String tipoDocumento) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NUMEROORDINEANNOASSOCIATO;

		Object[] finderArgs = new Object[] {
				numeroOrdine, anno, idAssociato, tipoDocumento
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_WKRIGODOCUMENTO_WHERE);

			query.append(_FINDER_COLUMN_NUMEROORDINEANNOASSOCIATO_NUMEROORDINE_2);

			query.append(_FINDER_COLUMN_NUMEROORDINEANNOASSOCIATO_ANNO_2);

			query.append(_FINDER_COLUMN_NUMEROORDINEANNOASSOCIATO_IDASSOCIATO_2);

			boolean bindTipoDocumento = false;

			if (tipoDocumento == null) {
				query.append(_FINDER_COLUMN_NUMEROORDINEANNOASSOCIATO_TIPODOCUMENTO_1);
			}
			else if (tipoDocumento.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NUMEROORDINEANNOASSOCIATO_TIPODOCUMENTO_3);
			}
			else {
				bindTipoDocumento = true;

				query.append(_FINDER_COLUMN_NUMEROORDINEANNOASSOCIATO_TIPODOCUMENTO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(numeroOrdine);

				qPos.add(anno);

				qPos.add(idAssociato);

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

	private static final String _FINDER_COLUMN_NUMEROORDINEANNOASSOCIATO_NUMEROORDINE_2 =
		"wkRigoDocumento.id.numeroOrdine = ? AND ";
	private static final String _FINDER_COLUMN_NUMEROORDINEANNOASSOCIATO_ANNO_2 = "wkRigoDocumento.id.anno = ? AND ";
	private static final String _FINDER_COLUMN_NUMEROORDINEANNOASSOCIATO_IDASSOCIATO_2 =
		"wkRigoDocumento.id.idAssociato = ? AND ";
	private static final String _FINDER_COLUMN_NUMEROORDINEANNOASSOCIATO_TIPODOCUMENTO_1 =
		"wkRigoDocumento.id.tipoDocumento IS NULL";
	private static final String _FINDER_COLUMN_NUMEROORDINEANNOASSOCIATO_TIPODOCUMENTO_2 =
		"wkRigoDocumento.id.tipoDocumento = ?";
	private static final String _FINDER_COLUMN_NUMEROORDINEANNOASSOCIATO_TIPODOCUMENTO_3 =
		"(wkRigoDocumento.id.tipoDocumento IS NULL OR wkRigoDocumento.id.tipoDocumento = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ANNOASSOCIATO =
		new FinderPath(WKRigoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			WKRigoDocumentoModelImpl.FINDER_CACHE_ENABLED,
			WKRigoDocumentoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByAnnoAssociato",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANNOASSOCIATO =
		new FinderPath(WKRigoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			WKRigoDocumentoModelImpl.FINDER_CACHE_ENABLED,
			WKRigoDocumentoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAnnoAssociato",
			new String[] { Integer.class.getName(), Long.class.getName() },
			WKRigoDocumentoModelImpl.ANNO_COLUMN_BITMASK |
			WKRigoDocumentoModelImpl.IDASSOCIATO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ANNOASSOCIATO = new FinderPath(WKRigoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			WKRigoDocumentoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAnnoAssociato",
			new String[] { Integer.class.getName(), Long.class.getName() });

	/**
	 * Returns all the w k rigo documentos where anno = &#63; and idAssociato = &#63;.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @return the matching w k rigo documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WKRigoDocumento> findByAnnoAssociato(int anno, long idAssociato)
		throws SystemException {
		return findByAnnoAssociato(anno, idAssociato, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the w k rigo documentos where anno = &#63; and idAssociato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.WKRigoDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param start the lower bound of the range of w k rigo documentos
	 * @param end the upper bound of the range of w k rigo documentos (not inclusive)
	 * @return the range of matching w k rigo documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WKRigoDocumento> findByAnnoAssociato(int anno,
		long idAssociato, int start, int end) throws SystemException {
		return findByAnnoAssociato(anno, idAssociato, start, end, null);
	}

	/**
	 * Returns an ordered range of all the w k rigo documentos where anno = &#63; and idAssociato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.WKRigoDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param start the lower bound of the range of w k rigo documentos
	 * @param end the upper bound of the range of w k rigo documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching w k rigo documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WKRigoDocumento> findByAnnoAssociato(int anno,
		long idAssociato, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANNOASSOCIATO;
			finderArgs = new Object[] { anno, idAssociato };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ANNOASSOCIATO;
			finderArgs = new Object[] {
					anno, idAssociato,
					
					start, end, orderByComparator
				};
		}

		List<WKRigoDocumento> list = (List<WKRigoDocumento>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WKRigoDocumento wkRigoDocumento : list) {
				if ((anno != wkRigoDocumento.getAnno()) ||
						(idAssociato != wkRigoDocumento.getIdAssociato())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_WKRIGODOCUMENTO_WHERE);

			query.append(_FINDER_COLUMN_ANNOASSOCIATO_ANNO_2);

			query.append(_FINDER_COLUMN_ANNOASSOCIATO_IDASSOCIATO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WKRigoDocumentoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(anno);

				qPos.add(idAssociato);

				if (!pagination) {
					list = (List<WKRigoDocumento>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WKRigoDocumento>(list);
				}
				else {
					list = (List<WKRigoDocumento>)QueryUtil.list(q,
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
	 * Returns the first w k rigo documento in the ordered set where anno = &#63; and idAssociato = &#63;.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w k rigo documento
	 * @throws it.bysoftware.ct.NoSuchWKRigoDocumentoException if a matching w k rigo documento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WKRigoDocumento findByAnnoAssociato_First(int anno,
		long idAssociato, OrderByComparator orderByComparator)
		throws NoSuchWKRigoDocumentoException, SystemException {
		WKRigoDocumento wkRigoDocumento = fetchByAnnoAssociato_First(anno,
				idAssociato, orderByComparator);

		if (wkRigoDocumento != null) {
			return wkRigoDocumento;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("anno=");
		msg.append(anno);

		msg.append(", idAssociato=");
		msg.append(idAssociato);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWKRigoDocumentoException(msg.toString());
	}

	/**
	 * Returns the first w k rigo documento in the ordered set where anno = &#63; and idAssociato = &#63;.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w k rigo documento, or <code>null</code> if a matching w k rigo documento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WKRigoDocumento fetchByAnnoAssociato_First(int anno,
		long idAssociato, OrderByComparator orderByComparator)
		throws SystemException {
		List<WKRigoDocumento> list = findByAnnoAssociato(anno, idAssociato, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last w k rigo documento in the ordered set where anno = &#63; and idAssociato = &#63;.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w k rigo documento
	 * @throws it.bysoftware.ct.NoSuchWKRigoDocumentoException if a matching w k rigo documento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WKRigoDocumento findByAnnoAssociato_Last(int anno, long idAssociato,
		OrderByComparator orderByComparator)
		throws NoSuchWKRigoDocumentoException, SystemException {
		WKRigoDocumento wkRigoDocumento = fetchByAnnoAssociato_Last(anno,
				idAssociato, orderByComparator);

		if (wkRigoDocumento != null) {
			return wkRigoDocumento;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("anno=");
		msg.append(anno);

		msg.append(", idAssociato=");
		msg.append(idAssociato);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWKRigoDocumentoException(msg.toString());
	}

	/**
	 * Returns the last w k rigo documento in the ordered set where anno = &#63; and idAssociato = &#63;.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w k rigo documento, or <code>null</code> if a matching w k rigo documento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WKRigoDocumento fetchByAnnoAssociato_Last(int anno,
		long idAssociato, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByAnnoAssociato(anno, idAssociato);

		if (count == 0) {
			return null;
		}

		List<WKRigoDocumento> list = findByAnnoAssociato(anno, idAssociato,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the w k rigo documentos before and after the current w k rigo documento in the ordered set where anno = &#63; and idAssociato = &#63;.
	 *
	 * @param wkRigoDocumentoPK the primary key of the current w k rigo documento
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next w k rigo documento
	 * @throws it.bysoftware.ct.NoSuchWKRigoDocumentoException if a w k rigo documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WKRigoDocumento[] findByAnnoAssociato_PrevAndNext(
		WKRigoDocumentoPK wkRigoDocumentoPK, int anno, long idAssociato,
		OrderByComparator orderByComparator)
		throws NoSuchWKRigoDocumentoException, SystemException {
		WKRigoDocumento wkRigoDocumento = findByPrimaryKey(wkRigoDocumentoPK);

		Session session = null;

		try {
			session = openSession();

			WKRigoDocumento[] array = new WKRigoDocumentoImpl[3];

			array[0] = getByAnnoAssociato_PrevAndNext(session, wkRigoDocumento,
					anno, idAssociato, orderByComparator, true);

			array[1] = wkRigoDocumento;

			array[2] = getByAnnoAssociato_PrevAndNext(session, wkRigoDocumento,
					anno, idAssociato, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WKRigoDocumento getByAnnoAssociato_PrevAndNext(Session session,
		WKRigoDocumento wkRigoDocumento, int anno, long idAssociato,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WKRIGODOCUMENTO_WHERE);

		query.append(_FINDER_COLUMN_ANNOASSOCIATO_ANNO_2);

		query.append(_FINDER_COLUMN_ANNOASSOCIATO_IDASSOCIATO_2);

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
			query.append(WKRigoDocumentoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(anno);

		qPos.add(idAssociato);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wkRigoDocumento);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WKRigoDocumento> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the w k rigo documentos where anno = &#63; and idAssociato = &#63; from the database.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAnnoAssociato(int anno, long idAssociato)
		throws SystemException {
		for (WKRigoDocumento wkRigoDocumento : findByAnnoAssociato(anno,
				idAssociato, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(wkRigoDocumento);
		}
	}

	/**
	 * Returns the number of w k rigo documentos where anno = &#63; and idAssociato = &#63;.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @return the number of matching w k rigo documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAnnoAssociato(int anno, long idAssociato)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ANNOASSOCIATO;

		Object[] finderArgs = new Object[] { anno, idAssociato };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_WKRIGODOCUMENTO_WHERE);

			query.append(_FINDER_COLUMN_ANNOASSOCIATO_ANNO_2);

			query.append(_FINDER_COLUMN_ANNOASSOCIATO_IDASSOCIATO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(anno);

				qPos.add(idAssociato);

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

	private static final String _FINDER_COLUMN_ANNOASSOCIATO_ANNO_2 = "wkRigoDocumento.id.anno = ? AND ";
	private static final String _FINDER_COLUMN_ANNOASSOCIATO_IDASSOCIATO_2 = "wkRigoDocumento.id.idAssociato = ?";

	public WKRigoDocumentoPersistenceImpl() {
		setModelClass(WKRigoDocumento.class);
	}

	/**
	 * Caches the w k rigo documento in the entity cache if it is enabled.
	 *
	 * @param wkRigoDocumento the w k rigo documento
	 */
	@Override
	public void cacheResult(WKRigoDocumento wkRigoDocumento) {
		EntityCacheUtil.putResult(WKRigoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			WKRigoDocumentoImpl.class, wkRigoDocumento.getPrimaryKey(),
			wkRigoDocumento);

		wkRigoDocumento.resetOriginalValues();
	}

	/**
	 * Caches the w k rigo documentos in the entity cache if it is enabled.
	 *
	 * @param wkRigoDocumentos the w k rigo documentos
	 */
	@Override
	public void cacheResult(List<WKRigoDocumento> wkRigoDocumentos) {
		for (WKRigoDocumento wkRigoDocumento : wkRigoDocumentos) {
			if (EntityCacheUtil.getResult(
						WKRigoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
						WKRigoDocumentoImpl.class,
						wkRigoDocumento.getPrimaryKey()) == null) {
				cacheResult(wkRigoDocumento);
			}
			else {
				wkRigoDocumento.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all w k rigo documentos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WKRigoDocumentoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WKRigoDocumentoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the w k rigo documento.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WKRigoDocumento wkRigoDocumento) {
		EntityCacheUtil.removeResult(WKRigoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			WKRigoDocumentoImpl.class, wkRigoDocumento.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<WKRigoDocumento> wkRigoDocumentos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WKRigoDocumento wkRigoDocumento : wkRigoDocumentos) {
			EntityCacheUtil.removeResult(WKRigoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
				WKRigoDocumentoImpl.class, wkRigoDocumento.getPrimaryKey());
		}
	}

	/**
	 * Creates a new w k rigo documento with the primary key. Does not add the w k rigo documento to the database.
	 *
	 * @param wkRigoDocumentoPK the primary key for the new w k rigo documento
	 * @return the new w k rigo documento
	 */
	@Override
	public WKRigoDocumento create(WKRigoDocumentoPK wkRigoDocumentoPK) {
		WKRigoDocumento wkRigoDocumento = new WKRigoDocumentoImpl();

		wkRigoDocumento.setNew(true);
		wkRigoDocumento.setPrimaryKey(wkRigoDocumentoPK);

		return wkRigoDocumento;
	}

	/**
	 * Removes the w k rigo documento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param wkRigoDocumentoPK the primary key of the w k rigo documento
	 * @return the w k rigo documento that was removed
	 * @throws it.bysoftware.ct.NoSuchWKRigoDocumentoException if a w k rigo documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WKRigoDocumento remove(WKRigoDocumentoPK wkRigoDocumentoPK)
		throws NoSuchWKRigoDocumentoException, SystemException {
		return remove((Serializable)wkRigoDocumentoPK);
	}

	/**
	 * Removes the w k rigo documento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the w k rigo documento
	 * @return the w k rigo documento that was removed
	 * @throws it.bysoftware.ct.NoSuchWKRigoDocumentoException if a w k rigo documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WKRigoDocumento remove(Serializable primaryKey)
		throws NoSuchWKRigoDocumentoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			WKRigoDocumento wkRigoDocumento = (WKRigoDocumento)session.get(WKRigoDocumentoImpl.class,
					primaryKey);

			if (wkRigoDocumento == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWKRigoDocumentoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(wkRigoDocumento);
		}
		catch (NoSuchWKRigoDocumentoException nsee) {
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
	protected WKRigoDocumento removeImpl(WKRigoDocumento wkRigoDocumento)
		throws SystemException {
		wkRigoDocumento = toUnwrappedModel(wkRigoDocumento);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(wkRigoDocumento)) {
				wkRigoDocumento = (WKRigoDocumento)session.get(WKRigoDocumentoImpl.class,
						wkRigoDocumento.getPrimaryKeyObj());
			}

			if (wkRigoDocumento != null) {
				session.delete(wkRigoDocumento);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (wkRigoDocumento != null) {
			clearCache(wkRigoDocumento);
		}

		return wkRigoDocumento;
	}

	@Override
	public WKRigoDocumento updateImpl(
		it.bysoftware.ct.model.WKRigoDocumento wkRigoDocumento)
		throws SystemException {
		wkRigoDocumento = toUnwrappedModel(wkRigoDocumento);

		boolean isNew = wkRigoDocumento.isNew();

		WKRigoDocumentoModelImpl wkRigoDocumentoModelImpl = (WKRigoDocumentoModelImpl)wkRigoDocumento;

		Session session = null;

		try {
			session = openSession();

			if (wkRigoDocumento.isNew()) {
				session.save(wkRigoDocumento);

				wkRigoDocumento.setNew(false);
			}
			else {
				session.merge(wkRigoDocumento);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !WKRigoDocumentoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((wkRigoDocumentoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMEROORDINEANNOASSOCIATO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wkRigoDocumentoModelImpl.getOriginalNumeroOrdine(),
						wkRigoDocumentoModelImpl.getOriginalAnno(),
						wkRigoDocumentoModelImpl.getOriginalIdAssociato(),
						wkRigoDocumentoModelImpl.getOriginalTipoDocumento()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NUMEROORDINEANNOASSOCIATO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMEROORDINEANNOASSOCIATO,
					args);

				args = new Object[] {
						wkRigoDocumentoModelImpl.getNumeroOrdine(),
						wkRigoDocumentoModelImpl.getAnno(),
						wkRigoDocumentoModelImpl.getIdAssociato(),
						wkRigoDocumentoModelImpl.getTipoDocumento()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NUMEROORDINEANNOASSOCIATO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMEROORDINEANNOASSOCIATO,
					args);
			}

			if ((wkRigoDocumentoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANNOASSOCIATO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wkRigoDocumentoModelImpl.getOriginalAnno(),
						wkRigoDocumentoModelImpl.getOriginalIdAssociato()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ANNOASSOCIATO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANNOASSOCIATO,
					args);

				args = new Object[] {
						wkRigoDocumentoModelImpl.getAnno(),
						wkRigoDocumentoModelImpl.getIdAssociato()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ANNOASSOCIATO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANNOASSOCIATO,
					args);
			}
		}

		EntityCacheUtil.putResult(WKRigoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			WKRigoDocumentoImpl.class, wkRigoDocumento.getPrimaryKey(),
			wkRigoDocumento);

		return wkRigoDocumento;
	}

	protected WKRigoDocumento toUnwrappedModel(WKRigoDocumento wkRigoDocumento) {
		if (wkRigoDocumento instanceof WKRigoDocumentoImpl) {
			return wkRigoDocumento;
		}

		WKRigoDocumentoImpl wkRigoDocumentoImpl = new WKRigoDocumentoImpl();

		wkRigoDocumentoImpl.setNew(wkRigoDocumento.isNew());
		wkRigoDocumentoImpl.setPrimaryKey(wkRigoDocumento.getPrimaryKey());

		wkRigoDocumentoImpl.setAnno(wkRigoDocumento.getAnno());
		wkRigoDocumentoImpl.setNumeroOrdine(wkRigoDocumento.getNumeroOrdine());
		wkRigoDocumentoImpl.setRigoOrdine(wkRigoDocumento.getRigoOrdine());
		wkRigoDocumentoImpl.setCodiceVariante(wkRigoDocumento.getCodiceVariante());
		wkRigoDocumentoImpl.setDescrizioneVariante(wkRigoDocumento.getDescrizioneVariante());
		wkRigoDocumentoImpl.setCodiceArticolo(wkRigoDocumento.getCodiceArticolo());
		wkRigoDocumentoImpl.setDescrizione(wkRigoDocumento.getDescrizione());
		wkRigoDocumentoImpl.setUnitaMisura(wkRigoDocumento.getUnitaMisura());
		wkRigoDocumentoImpl.setColli(wkRigoDocumento.getColli());
		wkRigoDocumentoImpl.setPesoLordo(wkRigoDocumento.getPesoLordo());
		wkRigoDocumentoImpl.setTara(wkRigoDocumento.getTara());
		wkRigoDocumentoImpl.setPesoNetto(wkRigoDocumento.getPesoNetto());
		wkRigoDocumentoImpl.setPrezzo(wkRigoDocumento.getPrezzo());
		wkRigoDocumentoImpl.setPedane(wkRigoDocumento.getPedane());
		wkRigoDocumentoImpl.setNote(wkRigoDocumento.getNote());
		wkRigoDocumentoImpl.setTotalePesata(wkRigoDocumento.getTotalePesata());
		wkRigoDocumentoImpl.setImballo(wkRigoDocumento.getImballo());
		wkRigoDocumentoImpl.setGestioneReti(wkRigoDocumento.isGestioneReti());
		wkRigoDocumentoImpl.setRtxCl(wkRigoDocumento.getRtxCl());
		wkRigoDocumentoImpl.setKgRete(wkRigoDocumento.getKgRete());
		wkRigoDocumentoImpl.setLotto(wkRigoDocumento.getLotto());
		wkRigoDocumentoImpl.setPassaporto(wkRigoDocumento.getPassaporto());
		wkRigoDocumentoImpl.setProgressivo(wkRigoDocumento.getProgressivo());
		wkRigoDocumentoImpl.setRiferimentoBolla(wkRigoDocumento.getRiferimentoBolla());
		wkRigoDocumentoImpl.setSconto1(wkRigoDocumento.getSconto1());
		wkRigoDocumentoImpl.setSconto2(wkRigoDocumento.getSconto2());
		wkRigoDocumentoImpl.setSconto3(wkRigoDocumento.getSconto3());
		wkRigoDocumentoImpl.setTipoDocumento(wkRigoDocumento.getTipoDocumento());
		wkRigoDocumentoImpl.setIdAssociato(wkRigoDocumento.getIdAssociato());
		wkRigoDocumentoImpl.setVerificato(wkRigoDocumento.isVerificato());

		return wkRigoDocumentoImpl;
	}

	/**
	 * Returns the w k rigo documento with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the w k rigo documento
	 * @return the w k rigo documento
	 * @throws it.bysoftware.ct.NoSuchWKRigoDocumentoException if a w k rigo documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WKRigoDocumento findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWKRigoDocumentoException, SystemException {
		WKRigoDocumento wkRigoDocumento = fetchByPrimaryKey(primaryKey);

		if (wkRigoDocumento == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWKRigoDocumentoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return wkRigoDocumento;
	}

	/**
	 * Returns the w k rigo documento with the primary key or throws a {@link it.bysoftware.ct.NoSuchWKRigoDocumentoException} if it could not be found.
	 *
	 * @param wkRigoDocumentoPK the primary key of the w k rigo documento
	 * @return the w k rigo documento
	 * @throws it.bysoftware.ct.NoSuchWKRigoDocumentoException if a w k rigo documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WKRigoDocumento findByPrimaryKey(WKRigoDocumentoPK wkRigoDocumentoPK)
		throws NoSuchWKRigoDocumentoException, SystemException {
		return findByPrimaryKey((Serializable)wkRigoDocumentoPK);
	}

	/**
	 * Returns the w k rigo documento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the w k rigo documento
	 * @return the w k rigo documento, or <code>null</code> if a w k rigo documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WKRigoDocumento fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		WKRigoDocumento wkRigoDocumento = (WKRigoDocumento)EntityCacheUtil.getResult(WKRigoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
				WKRigoDocumentoImpl.class, primaryKey);

		if (wkRigoDocumento == _nullWKRigoDocumento) {
			return null;
		}

		if (wkRigoDocumento == null) {
			Session session = null;

			try {
				session = openSession();

				wkRigoDocumento = (WKRigoDocumento)session.get(WKRigoDocumentoImpl.class,
						primaryKey);

				if (wkRigoDocumento != null) {
					cacheResult(wkRigoDocumento);
				}
				else {
					EntityCacheUtil.putResult(WKRigoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
						WKRigoDocumentoImpl.class, primaryKey,
						_nullWKRigoDocumento);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(WKRigoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
					WKRigoDocumentoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return wkRigoDocumento;
	}

	/**
	 * Returns the w k rigo documento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param wkRigoDocumentoPK the primary key of the w k rigo documento
	 * @return the w k rigo documento, or <code>null</code> if a w k rigo documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WKRigoDocumento fetchByPrimaryKey(
		WKRigoDocumentoPK wkRigoDocumentoPK) throws SystemException {
		return fetchByPrimaryKey((Serializable)wkRigoDocumentoPK);
	}

	/**
	 * Returns all the w k rigo documentos.
	 *
	 * @return the w k rigo documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WKRigoDocumento> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the w k rigo documentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.WKRigoDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of w k rigo documentos
	 * @param end the upper bound of the range of w k rigo documentos (not inclusive)
	 * @return the range of w k rigo documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WKRigoDocumento> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the w k rigo documentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.WKRigoDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of w k rigo documentos
	 * @param end the upper bound of the range of w k rigo documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of w k rigo documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WKRigoDocumento> findAll(int start, int end,
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

		List<WKRigoDocumento> list = (List<WKRigoDocumento>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WKRIGODOCUMENTO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WKRIGODOCUMENTO;

				if (pagination) {
					sql = sql.concat(WKRigoDocumentoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WKRigoDocumento>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WKRigoDocumento>(list);
				}
				else {
					list = (List<WKRigoDocumento>)QueryUtil.list(q,
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
	 * Removes all the w k rigo documentos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (WKRigoDocumento wkRigoDocumento : findAll()) {
			remove(wkRigoDocumento);
		}
	}

	/**
	 * Returns the number of w k rigo documentos.
	 *
	 * @return the number of w k rigo documentos
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

				Query q = session.createQuery(_SQL_COUNT_WKRIGODOCUMENTO);

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
	 * Initializes the w k rigo documento persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.bysoftware.ct.model.WKRigoDocumento")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<WKRigoDocumento>> listenersList = new ArrayList<ModelListener<WKRigoDocumento>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<WKRigoDocumento>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(WKRigoDocumentoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_WKRIGODOCUMENTO = "SELECT wkRigoDocumento FROM WKRigoDocumento wkRigoDocumento";
	private static final String _SQL_SELECT_WKRIGODOCUMENTO_WHERE = "SELECT wkRigoDocumento FROM WKRigoDocumento wkRigoDocumento WHERE ";
	private static final String _SQL_COUNT_WKRIGODOCUMENTO = "SELECT COUNT(wkRigoDocumento) FROM WKRigoDocumento wkRigoDocumento";
	private static final String _SQL_COUNT_WKRIGODOCUMENTO_WHERE = "SELECT COUNT(wkRigoDocumento) FROM WKRigoDocumento wkRigoDocumento WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "wkRigoDocumento.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WKRigoDocumento exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WKRigoDocumento exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WKRigoDocumentoPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"anno", "numeroOrdine", "rigoOrdine", "codiceVariante",
				"descrizioneVariante", "codiceArticolo", "descrizione",
				"unitaMisura", "colli", "pesoLordo", "tara", "pesoNetto",
				"prezzo", "pedane", "note", "totalePesata", "imballo",
				"gestioneReti", "RtxCl", "kgRete", "lotto", "passaporto",
				"progressivo", "riferimentoBolla", "tipoDocumento",
				"idAssociato"
			});
	private static WKRigoDocumento _nullWKRigoDocumento = new WKRigoDocumentoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<WKRigoDocumento> toCacheModel() {
				return _nullWKRigoDocumentoCacheModel;
			}
		};

	private static CacheModel<WKRigoDocumento> _nullWKRigoDocumentoCacheModel = new CacheModel<WKRigoDocumento>() {
			@Override
			public WKRigoDocumento toEntityModel() {
				return _nullWKRigoDocumento;
			}
		};
}
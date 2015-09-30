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

import it.bysoftware.ct.NoSuchRigoDocumentoException;
import it.bysoftware.ct.model.RigoDocumento;
import it.bysoftware.ct.model.impl.RigoDocumentoImpl;
import it.bysoftware.ct.model.impl.RigoDocumentoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the rigo documento service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RigoDocumentoPersistence
 * @see RigoDocumentoUtil
 * @generated
 */
public class RigoDocumentoPersistenceImpl extends BasePersistenceImpl<RigoDocumento>
	implements RigoDocumentoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RigoDocumentoUtil} to access the rigo documento persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RigoDocumentoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RigoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			RigoDocumentoModelImpl.FINDER_CACHE_ENABLED,
			RigoDocumentoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RigoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			RigoDocumentoModelImpl.FINDER_CACHE_ENABLED,
			RigoDocumentoImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RigoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			RigoDocumentoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NUMEROORDINEANNOASSOCIATO =
		new FinderPath(RigoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			RigoDocumentoModelImpl.FINDER_CACHE_ENABLED,
			RigoDocumentoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBynumeroOrdineAnnoAssociato",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMEROORDINEANNOASSOCIATO =
		new FinderPath(RigoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			RigoDocumentoModelImpl.FINDER_CACHE_ENABLED,
			RigoDocumentoImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBynumeroOrdineAnnoAssociato",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Long.class.getName(), String.class.getName()
			},
			RigoDocumentoModelImpl.NUMEROORDINE_COLUMN_BITMASK |
			RigoDocumentoModelImpl.ANNO_COLUMN_BITMASK |
			RigoDocumentoModelImpl.IDASSOCIATO_COLUMN_BITMASK |
			RigoDocumentoModelImpl.TIPODOCUMENTO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NUMEROORDINEANNOASSOCIATO =
		new FinderPath(RigoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			RigoDocumentoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBynumeroOrdineAnnoAssociato",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Long.class.getName(), String.class.getName()
			});

	/**
	 * Returns all the rigo documentos where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	 *
	 * @param numeroOrdine the numero ordine
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param tipoDocumento the tipo documento
	 * @return the matching rigo documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RigoDocumento> findBynumeroOrdineAnnoAssociato(
		long numeroOrdine, int anno, long idAssociato, String tipoDocumento)
		throws SystemException {
		return findBynumeroOrdineAnnoAssociato(numeroOrdine, anno, idAssociato,
			tipoDocumento, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rigo documentos where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.RigoDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param numeroOrdine the numero ordine
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param tipoDocumento the tipo documento
	 * @param start the lower bound of the range of rigo documentos
	 * @param end the upper bound of the range of rigo documentos (not inclusive)
	 * @return the range of matching rigo documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RigoDocumento> findBynumeroOrdineAnnoAssociato(
		long numeroOrdine, int anno, long idAssociato, String tipoDocumento,
		int start, int end) throws SystemException {
		return findBynumeroOrdineAnnoAssociato(numeroOrdine, anno, idAssociato,
			tipoDocumento, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rigo documentos where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.RigoDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param numeroOrdine the numero ordine
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param tipoDocumento the tipo documento
	 * @param start the lower bound of the range of rigo documentos
	 * @param end the upper bound of the range of rigo documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rigo documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RigoDocumento> findBynumeroOrdineAnnoAssociato(
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

		List<RigoDocumento> list = (List<RigoDocumento>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RigoDocumento rigoDocumento : list) {
				if ((numeroOrdine != rigoDocumento.getNumeroOrdine()) ||
						(anno != rigoDocumento.getAnno()) ||
						(idAssociato != rigoDocumento.getIdAssociato()) ||
						!Validator.equals(tipoDocumento,
							rigoDocumento.getTipoDocumento())) {
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

			query.append(_SQL_SELECT_RIGODOCUMENTO_WHERE);

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
				query.append(RigoDocumentoModelImpl.ORDER_BY_JPQL);
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
					list = (List<RigoDocumento>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RigoDocumento>(list);
				}
				else {
					list = (List<RigoDocumento>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rigo documento in the ordered set where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	 *
	 * @param numeroOrdine the numero ordine
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param tipoDocumento the tipo documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rigo documento
	 * @throws it.bysoftware.ct.NoSuchRigoDocumentoException if a matching rigo documento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RigoDocumento findBynumeroOrdineAnnoAssociato_First(
		long numeroOrdine, int anno, long idAssociato, String tipoDocumento,
		OrderByComparator orderByComparator)
		throws NoSuchRigoDocumentoException, SystemException {
		RigoDocumento rigoDocumento = fetchBynumeroOrdineAnnoAssociato_First(numeroOrdine,
				anno, idAssociato, tipoDocumento, orderByComparator);

		if (rigoDocumento != null) {
			return rigoDocumento;
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

		throw new NoSuchRigoDocumentoException(msg.toString());
	}

	/**
	 * Returns the first rigo documento in the ordered set where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	 *
	 * @param numeroOrdine the numero ordine
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param tipoDocumento the tipo documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rigo documento, or <code>null</code> if a matching rigo documento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RigoDocumento fetchBynumeroOrdineAnnoAssociato_First(
		long numeroOrdine, int anno, long idAssociato, String tipoDocumento,
		OrderByComparator orderByComparator) throws SystemException {
		List<RigoDocumento> list = findBynumeroOrdineAnnoAssociato(numeroOrdine,
				anno, idAssociato, tipoDocumento, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rigo documento in the ordered set where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	 *
	 * @param numeroOrdine the numero ordine
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param tipoDocumento the tipo documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rigo documento
	 * @throws it.bysoftware.ct.NoSuchRigoDocumentoException if a matching rigo documento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RigoDocumento findBynumeroOrdineAnnoAssociato_Last(
		long numeroOrdine, int anno, long idAssociato, String tipoDocumento,
		OrderByComparator orderByComparator)
		throws NoSuchRigoDocumentoException, SystemException {
		RigoDocumento rigoDocumento = fetchBynumeroOrdineAnnoAssociato_Last(numeroOrdine,
				anno, idAssociato, tipoDocumento, orderByComparator);

		if (rigoDocumento != null) {
			return rigoDocumento;
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

		throw new NoSuchRigoDocumentoException(msg.toString());
	}

	/**
	 * Returns the last rigo documento in the ordered set where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	 *
	 * @param numeroOrdine the numero ordine
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param tipoDocumento the tipo documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rigo documento, or <code>null</code> if a matching rigo documento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RigoDocumento fetchBynumeroOrdineAnnoAssociato_Last(
		long numeroOrdine, int anno, long idAssociato, String tipoDocumento,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBynumeroOrdineAnnoAssociato(numeroOrdine, anno,
				idAssociato, tipoDocumento);

		if (count == 0) {
			return null;
		}

		List<RigoDocumento> list = findBynumeroOrdineAnnoAssociato(numeroOrdine,
				anno, idAssociato, tipoDocumento, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rigo documentos before and after the current rigo documento in the ordered set where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	 *
	 * @param rigoDocumentoPK the primary key of the current rigo documento
	 * @param numeroOrdine the numero ordine
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param tipoDocumento the tipo documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rigo documento
	 * @throws it.bysoftware.ct.NoSuchRigoDocumentoException if a rigo documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RigoDocumento[] findBynumeroOrdineAnnoAssociato_PrevAndNext(
		RigoDocumentoPK rigoDocumentoPK, long numeroOrdine, int anno,
		long idAssociato, String tipoDocumento,
		OrderByComparator orderByComparator)
		throws NoSuchRigoDocumentoException, SystemException {
		RigoDocumento rigoDocumento = findByPrimaryKey(rigoDocumentoPK);

		Session session = null;

		try {
			session = openSession();

			RigoDocumento[] array = new RigoDocumentoImpl[3];

			array[0] = getBynumeroOrdineAnnoAssociato_PrevAndNext(session,
					rigoDocumento, numeroOrdine, anno, idAssociato,
					tipoDocumento, orderByComparator, true);

			array[1] = rigoDocumento;

			array[2] = getBynumeroOrdineAnnoAssociato_PrevAndNext(session,
					rigoDocumento, numeroOrdine, anno, idAssociato,
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

	protected RigoDocumento getBynumeroOrdineAnnoAssociato_PrevAndNext(
		Session session, RigoDocumento rigoDocumento, long numeroOrdine,
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

		query.append(_SQL_SELECT_RIGODOCUMENTO_WHERE);

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
			query.append(RigoDocumentoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(rigoDocumento);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RigoDocumento> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rigo documentos where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63; from the database.
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
		for (RigoDocumento rigoDocumento : findBynumeroOrdineAnnoAssociato(
				numeroOrdine, anno, idAssociato, tipoDocumento,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(rigoDocumento);
		}
	}

	/**
	 * Returns the number of rigo documentos where numeroOrdine = &#63; and anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	 *
	 * @param numeroOrdine the numero ordine
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param tipoDocumento the tipo documento
	 * @return the number of matching rigo documentos
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

			query.append(_SQL_COUNT_RIGODOCUMENTO_WHERE);

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
		"rigoDocumento.id.numeroOrdine = ? AND ";
	private static final String _FINDER_COLUMN_NUMEROORDINEANNOASSOCIATO_ANNO_2 = "rigoDocumento.id.anno = ? AND ";
	private static final String _FINDER_COLUMN_NUMEROORDINEANNOASSOCIATO_IDASSOCIATO_2 =
		"rigoDocumento.id.idAssociato = ? AND ";
	private static final String _FINDER_COLUMN_NUMEROORDINEANNOASSOCIATO_TIPODOCUMENTO_1 =
		"rigoDocumento.id.tipoDocumento IS NULL";
	private static final String _FINDER_COLUMN_NUMEROORDINEANNOASSOCIATO_TIPODOCUMENTO_2 =
		"rigoDocumento.id.tipoDocumento = ?";
	private static final String _FINDER_COLUMN_NUMEROORDINEANNOASSOCIATO_TIPODOCUMENTO_3 =
		"(rigoDocumento.id.tipoDocumento IS NULL OR rigoDocumento.id.tipoDocumento = '')";

	public RigoDocumentoPersistenceImpl() {
		setModelClass(RigoDocumento.class);
	}

	/**
	 * Caches the rigo documento in the entity cache if it is enabled.
	 *
	 * @param rigoDocumento the rigo documento
	 */
	@Override
	public void cacheResult(RigoDocumento rigoDocumento) {
		EntityCacheUtil.putResult(RigoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			RigoDocumentoImpl.class, rigoDocumento.getPrimaryKey(),
			rigoDocumento);

		rigoDocumento.resetOriginalValues();
	}

	/**
	 * Caches the rigo documentos in the entity cache if it is enabled.
	 *
	 * @param rigoDocumentos the rigo documentos
	 */
	@Override
	public void cacheResult(List<RigoDocumento> rigoDocumentos) {
		for (RigoDocumento rigoDocumento : rigoDocumentos) {
			if (EntityCacheUtil.getResult(
						RigoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
						RigoDocumentoImpl.class, rigoDocumento.getPrimaryKey()) == null) {
				cacheResult(rigoDocumento);
			}
			else {
				rigoDocumento.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rigo documentos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RigoDocumentoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RigoDocumentoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rigo documento.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RigoDocumento rigoDocumento) {
		EntityCacheUtil.removeResult(RigoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			RigoDocumentoImpl.class, rigoDocumento.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RigoDocumento> rigoDocumentos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RigoDocumento rigoDocumento : rigoDocumentos) {
			EntityCacheUtil.removeResult(RigoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
				RigoDocumentoImpl.class, rigoDocumento.getPrimaryKey());
		}
	}

	/**
	 * Creates a new rigo documento with the primary key. Does not add the rigo documento to the database.
	 *
	 * @param rigoDocumentoPK the primary key for the new rigo documento
	 * @return the new rigo documento
	 */
	@Override
	public RigoDocumento create(RigoDocumentoPK rigoDocumentoPK) {
		RigoDocumento rigoDocumento = new RigoDocumentoImpl();

		rigoDocumento.setNew(true);
		rigoDocumento.setPrimaryKey(rigoDocumentoPK);

		return rigoDocumento;
	}

	/**
	 * Removes the rigo documento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rigoDocumentoPK the primary key of the rigo documento
	 * @return the rigo documento that was removed
	 * @throws it.bysoftware.ct.NoSuchRigoDocumentoException if a rigo documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RigoDocumento remove(RigoDocumentoPK rigoDocumentoPK)
		throws NoSuchRigoDocumentoException, SystemException {
		return remove((Serializable)rigoDocumentoPK);
	}

	/**
	 * Removes the rigo documento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rigo documento
	 * @return the rigo documento that was removed
	 * @throws it.bysoftware.ct.NoSuchRigoDocumentoException if a rigo documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RigoDocumento remove(Serializable primaryKey)
		throws NoSuchRigoDocumentoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			RigoDocumento rigoDocumento = (RigoDocumento)session.get(RigoDocumentoImpl.class,
					primaryKey);

			if (rigoDocumento == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRigoDocumentoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(rigoDocumento);
		}
		catch (NoSuchRigoDocumentoException nsee) {
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
	protected RigoDocumento removeImpl(RigoDocumento rigoDocumento)
		throws SystemException {
		rigoDocumento = toUnwrappedModel(rigoDocumento);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rigoDocumento)) {
				rigoDocumento = (RigoDocumento)session.get(RigoDocumentoImpl.class,
						rigoDocumento.getPrimaryKeyObj());
			}

			if (rigoDocumento != null) {
				session.delete(rigoDocumento);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rigoDocumento != null) {
			clearCache(rigoDocumento);
		}

		return rigoDocumento;
	}

	@Override
	public RigoDocumento updateImpl(
		it.bysoftware.ct.model.RigoDocumento rigoDocumento)
		throws SystemException {
		rigoDocumento = toUnwrappedModel(rigoDocumento);

		boolean isNew = rigoDocumento.isNew();

		RigoDocumentoModelImpl rigoDocumentoModelImpl = (RigoDocumentoModelImpl)rigoDocumento;

		Session session = null;

		try {
			session = openSession();

			if (rigoDocumento.isNew()) {
				session.save(rigoDocumento);

				rigoDocumento.setNew(false);
			}
			else {
				session.merge(rigoDocumento);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RigoDocumentoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((rigoDocumentoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMEROORDINEANNOASSOCIATO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rigoDocumentoModelImpl.getOriginalNumeroOrdine(),
						rigoDocumentoModelImpl.getOriginalAnno(),
						rigoDocumentoModelImpl.getOriginalIdAssociato(),
						rigoDocumentoModelImpl.getOriginalTipoDocumento()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NUMEROORDINEANNOASSOCIATO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMEROORDINEANNOASSOCIATO,
					args);

				args = new Object[] {
						rigoDocumentoModelImpl.getNumeroOrdine(),
						rigoDocumentoModelImpl.getAnno(),
						rigoDocumentoModelImpl.getIdAssociato(),
						rigoDocumentoModelImpl.getTipoDocumento()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NUMEROORDINEANNOASSOCIATO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NUMEROORDINEANNOASSOCIATO,
					args);
			}
		}

		EntityCacheUtil.putResult(RigoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			RigoDocumentoImpl.class, rigoDocumento.getPrimaryKey(),
			rigoDocumento);

		return rigoDocumento;
	}

	protected RigoDocumento toUnwrappedModel(RigoDocumento rigoDocumento) {
		if (rigoDocumento instanceof RigoDocumentoImpl) {
			return rigoDocumento;
		}

		RigoDocumentoImpl rigoDocumentoImpl = new RigoDocumentoImpl();

		rigoDocumentoImpl.setNew(rigoDocumento.isNew());
		rigoDocumentoImpl.setPrimaryKey(rigoDocumento.getPrimaryKey());

		rigoDocumentoImpl.setAnno(rigoDocumento.getAnno());
		rigoDocumentoImpl.setNumeroOrdine(rigoDocumento.getNumeroOrdine());
		rigoDocumentoImpl.setRigoOrdine(rigoDocumento.getRigoOrdine());
		rigoDocumentoImpl.setDescrizioneVariante(rigoDocumento.getDescrizioneVariante());
		rigoDocumentoImpl.setCodiceArticolo(rigoDocumento.getCodiceArticolo());
		rigoDocumentoImpl.setDescrizione(rigoDocumento.getDescrizione());
		rigoDocumentoImpl.setUnitaMisura(rigoDocumento.getUnitaMisura());
		rigoDocumentoImpl.setColli(rigoDocumento.getColli());
		rigoDocumentoImpl.setPesoLordo(rigoDocumento.getPesoLordo());
		rigoDocumentoImpl.setTara(rigoDocumento.getTara());
		rigoDocumentoImpl.setPesoNetto(rigoDocumento.getPesoNetto());
		rigoDocumentoImpl.setPrezzo(rigoDocumento.getPrezzo());
		rigoDocumentoImpl.setPedane(rigoDocumento.getPedane());
		rigoDocumentoImpl.setNote(rigoDocumento.getNote());
		rigoDocumentoImpl.setTotalePesata(rigoDocumento.getTotalePesata());
		rigoDocumentoImpl.setImballo(rigoDocumento.getImballo());
		rigoDocumentoImpl.setGestioneReti(rigoDocumento.isGestioneReti());
		rigoDocumentoImpl.setRtxCl(rigoDocumento.getRtxCl());
		rigoDocumentoImpl.setKgRete(rigoDocumento.getKgRete());
		rigoDocumentoImpl.setLotto(rigoDocumento.getLotto());
		rigoDocumentoImpl.setPassaporto(rigoDocumento.getPassaporto());
		rigoDocumentoImpl.setProgressivo(rigoDocumento.getProgressivo());
		rigoDocumentoImpl.setSconto1(rigoDocumento.getSconto1());
		rigoDocumentoImpl.setSconto2(rigoDocumento.getSconto2());
		rigoDocumentoImpl.setSconto3(rigoDocumento.getSconto3());
		rigoDocumentoImpl.setTipoDocumento(rigoDocumento.getTipoDocumento());
		rigoDocumentoImpl.setIdAssociato(rigoDocumento.getIdAssociato());

		return rigoDocumentoImpl;
	}

	/**
	 * Returns the rigo documento with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the rigo documento
	 * @return the rigo documento
	 * @throws it.bysoftware.ct.NoSuchRigoDocumentoException if a rigo documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RigoDocumento findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRigoDocumentoException, SystemException {
		RigoDocumento rigoDocumento = fetchByPrimaryKey(primaryKey);

		if (rigoDocumento == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRigoDocumentoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return rigoDocumento;
	}

	/**
	 * Returns the rigo documento with the primary key or throws a {@link it.bysoftware.ct.NoSuchRigoDocumentoException} if it could not be found.
	 *
	 * @param rigoDocumentoPK the primary key of the rigo documento
	 * @return the rigo documento
	 * @throws it.bysoftware.ct.NoSuchRigoDocumentoException if a rigo documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RigoDocumento findByPrimaryKey(RigoDocumentoPK rigoDocumentoPK)
		throws NoSuchRigoDocumentoException, SystemException {
		return findByPrimaryKey((Serializable)rigoDocumentoPK);
	}

	/**
	 * Returns the rigo documento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rigo documento
	 * @return the rigo documento, or <code>null</code> if a rigo documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RigoDocumento fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		RigoDocumento rigoDocumento = (RigoDocumento)EntityCacheUtil.getResult(RigoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
				RigoDocumentoImpl.class, primaryKey);

		if (rigoDocumento == _nullRigoDocumento) {
			return null;
		}

		if (rigoDocumento == null) {
			Session session = null;

			try {
				session = openSession();

				rigoDocumento = (RigoDocumento)session.get(RigoDocumentoImpl.class,
						primaryKey);

				if (rigoDocumento != null) {
					cacheResult(rigoDocumento);
				}
				else {
					EntityCacheUtil.putResult(RigoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
						RigoDocumentoImpl.class, primaryKey, _nullRigoDocumento);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RigoDocumentoModelImpl.ENTITY_CACHE_ENABLED,
					RigoDocumentoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return rigoDocumento;
	}

	/**
	 * Returns the rigo documento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rigoDocumentoPK the primary key of the rigo documento
	 * @return the rigo documento, or <code>null</code> if a rigo documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RigoDocumento fetchByPrimaryKey(RigoDocumentoPK rigoDocumentoPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)rigoDocumentoPK);
	}

	/**
	 * Returns all the rigo documentos.
	 *
	 * @return the rigo documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RigoDocumento> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rigo documentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.RigoDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rigo documentos
	 * @param end the upper bound of the range of rigo documentos (not inclusive)
	 * @return the range of rigo documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RigoDocumento> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rigo documentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.RigoDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rigo documentos
	 * @param end the upper bound of the range of rigo documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rigo documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RigoDocumento> findAll(int start, int end,
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

		List<RigoDocumento> list = (List<RigoDocumento>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RIGODOCUMENTO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RIGODOCUMENTO;

				if (pagination) {
					sql = sql.concat(RigoDocumentoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RigoDocumento>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RigoDocumento>(list);
				}
				else {
					list = (List<RigoDocumento>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the rigo documentos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (RigoDocumento rigoDocumento : findAll()) {
			remove(rigoDocumento);
		}
	}

	/**
	 * Returns the number of rigo documentos.
	 *
	 * @return the number of rigo documentos
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

				Query q = session.createQuery(_SQL_COUNT_RIGODOCUMENTO);

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
	 * Initializes the rigo documento persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.bysoftware.ct.model.RigoDocumento")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<RigoDocumento>> listenersList = new ArrayList<ModelListener<RigoDocumento>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<RigoDocumento>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RigoDocumentoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RIGODOCUMENTO = "SELECT rigoDocumento FROM RigoDocumento rigoDocumento";
	private static final String _SQL_SELECT_RIGODOCUMENTO_WHERE = "SELECT rigoDocumento FROM RigoDocumento rigoDocumento WHERE ";
	private static final String _SQL_COUNT_RIGODOCUMENTO = "SELECT COUNT(rigoDocumento) FROM RigoDocumento rigoDocumento";
	private static final String _SQL_COUNT_RIGODOCUMENTO_WHERE = "SELECT COUNT(rigoDocumento) FROM RigoDocumento rigoDocumento WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "rigoDocumento.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RigoDocumento exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RigoDocumento exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RigoDocumentoPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"anno", "numeroOrdine", "rigoOrdine", "descrizioneVariante",
				"codiceArticolo", "descrizione", "unitaMisura", "colli",
				"pesoLordo", "tara", "pesoNetto", "prezzo", "pedane", "note",
				"totalePesata", "imballo", "gestioneReti", "RtxCl", "kgRete",
				"lotto", "passaporto", "progressivo", "tipoDocumento",
				"idAssociato"
			});
	private static RigoDocumento _nullRigoDocumento = new RigoDocumentoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RigoDocumento> toCacheModel() {
				return _nullRigoDocumentoCacheModel;
			}
		};

	private static CacheModel<RigoDocumento> _nullRigoDocumentoCacheModel = new CacheModel<RigoDocumento>() {
			@Override
			public RigoDocumento toEntityModel() {
				return _nullRigoDocumento;
			}
		};
}
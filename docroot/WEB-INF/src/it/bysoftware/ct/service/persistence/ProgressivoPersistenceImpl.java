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

import it.bysoftware.ct.NoSuchProgressivoException;
import it.bysoftware.ct.model.Progressivo;
import it.bysoftware.ct.model.impl.ProgressivoImpl;
import it.bysoftware.ct.model.impl.ProgressivoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the progressivo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgressivoPersistence
 * @see ProgressivoUtil
 * @generated
 */
public class ProgressivoPersistenceImpl extends BasePersistenceImpl<Progressivo>
	implements ProgressivoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProgressivoUtil} to access the progressivo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProgressivoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProgressivoModelImpl.ENTITY_CACHE_ENABLED,
			ProgressivoModelImpl.FINDER_CACHE_ENABLED, ProgressivoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProgressivoModelImpl.ENTITY_CACHE_ENABLED,
			ProgressivoModelImpl.FINDER_CACHE_ENABLED, ProgressivoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProgressivoModelImpl.ENTITY_CACHE_ENABLED,
			ProgressivoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ANNOIDASSOCIATOTIPODOCUMENTO =
		new FinderPath(ProgressivoModelImpl.ENTITY_CACHE_ENABLED,
			ProgressivoModelImpl.FINDER_CACHE_ENABLED, ProgressivoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByAnnoIdAssociatoTipoDocumento",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANNOIDASSOCIATOTIPODOCUMENTO =
		new FinderPath(ProgressivoModelImpl.ENTITY_CACHE_ENABLED,
			ProgressivoModelImpl.FINDER_CACHE_ENABLED, ProgressivoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAnnoIdAssociatoTipoDocumento",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			ProgressivoModelImpl.ANNO_COLUMN_BITMASK |
			ProgressivoModelImpl.IDASSOCIATO_COLUMN_BITMASK |
			ProgressivoModelImpl.TIPODOCUMENTO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ANNOIDASSOCIATOTIPODOCUMENTO =
		new FinderPath(ProgressivoModelImpl.ENTITY_CACHE_ENABLED,
			ProgressivoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAnnoIdAssociatoTipoDocumento",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns all the progressivos where anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param tipoDocumento the tipo documento
	 * @return the matching progressivos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Progressivo> findByAnnoIdAssociatoTipoDocumento(int anno,
		long idAssociato, int tipoDocumento) throws SystemException {
		return findByAnnoIdAssociatoTipoDocumento(anno, idAssociato,
			tipoDocumento, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the progressivos where anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.ProgressivoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param tipoDocumento the tipo documento
	 * @param start the lower bound of the range of progressivos
	 * @param end the upper bound of the range of progressivos (not inclusive)
	 * @return the range of matching progressivos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Progressivo> findByAnnoIdAssociatoTipoDocumento(int anno,
		long idAssociato, int tipoDocumento, int start, int end)
		throws SystemException {
		return findByAnnoIdAssociatoTipoDocumento(anno, idAssociato,
			tipoDocumento, start, end, null);
	}

	/**
	 * Returns an ordered range of all the progressivos where anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.ProgressivoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param tipoDocumento the tipo documento
	 * @param start the lower bound of the range of progressivos
	 * @param end the upper bound of the range of progressivos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progressivos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Progressivo> findByAnnoIdAssociatoTipoDocumento(int anno,
		long idAssociato, int tipoDocumento, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANNOIDASSOCIATOTIPODOCUMENTO;
			finderArgs = new Object[] { anno, idAssociato, tipoDocumento };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ANNOIDASSOCIATOTIPODOCUMENTO;
			finderArgs = new Object[] {
					anno, idAssociato, tipoDocumento,
					
					start, end, orderByComparator
				};
		}

		List<Progressivo> list = (List<Progressivo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Progressivo progressivo : list) {
				if ((anno != progressivo.getAnno()) ||
						(idAssociato != progressivo.getIdAssociato()) ||
						(tipoDocumento != progressivo.getTipoDocumento())) {
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

			query.append(_SQL_SELECT_PROGRESSIVO_WHERE);

			query.append(_FINDER_COLUMN_ANNOIDASSOCIATOTIPODOCUMENTO_ANNO_2);

			query.append(_FINDER_COLUMN_ANNOIDASSOCIATOTIPODOCUMENTO_IDASSOCIATO_2);

			query.append(_FINDER_COLUMN_ANNOIDASSOCIATOTIPODOCUMENTO_TIPODOCUMENTO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProgressivoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(anno);

				qPos.add(idAssociato);

				qPos.add(tipoDocumento);

				if (!pagination) {
					list = (List<Progressivo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Progressivo>(list);
				}
				else {
					list = (List<Progressivo>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first progressivo in the ordered set where anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param tipoDocumento the tipo documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progressivo
	 * @throws it.bysoftware.ct.NoSuchProgressivoException if a matching progressivo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Progressivo findByAnnoIdAssociatoTipoDocumento_First(int anno,
		long idAssociato, int tipoDocumento, OrderByComparator orderByComparator)
		throws NoSuchProgressivoException, SystemException {
		Progressivo progressivo = fetchByAnnoIdAssociatoTipoDocumento_First(anno,
				idAssociato, tipoDocumento, orderByComparator);

		if (progressivo != null) {
			return progressivo;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("anno=");
		msg.append(anno);

		msg.append(", idAssociato=");
		msg.append(idAssociato);

		msg.append(", tipoDocumento=");
		msg.append(tipoDocumento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProgressivoException(msg.toString());
	}

	/**
	 * Returns the first progressivo in the ordered set where anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param tipoDocumento the tipo documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progressivo, or <code>null</code> if a matching progressivo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Progressivo fetchByAnnoIdAssociatoTipoDocumento_First(int anno,
		long idAssociato, int tipoDocumento, OrderByComparator orderByComparator)
		throws SystemException {
		List<Progressivo> list = findByAnnoIdAssociatoTipoDocumento(anno,
				idAssociato, tipoDocumento, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last progressivo in the ordered set where anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param tipoDocumento the tipo documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progressivo
	 * @throws it.bysoftware.ct.NoSuchProgressivoException if a matching progressivo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Progressivo findByAnnoIdAssociatoTipoDocumento_Last(int anno,
		long idAssociato, int tipoDocumento, OrderByComparator orderByComparator)
		throws NoSuchProgressivoException, SystemException {
		Progressivo progressivo = fetchByAnnoIdAssociatoTipoDocumento_Last(anno,
				idAssociato, tipoDocumento, orderByComparator);

		if (progressivo != null) {
			return progressivo;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("anno=");
		msg.append(anno);

		msg.append(", idAssociato=");
		msg.append(idAssociato);

		msg.append(", tipoDocumento=");
		msg.append(tipoDocumento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProgressivoException(msg.toString());
	}

	/**
	 * Returns the last progressivo in the ordered set where anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param tipoDocumento the tipo documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progressivo, or <code>null</code> if a matching progressivo could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Progressivo fetchByAnnoIdAssociatoTipoDocumento_Last(int anno,
		long idAssociato, int tipoDocumento, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByAnnoIdAssociatoTipoDocumento(anno, idAssociato,
				tipoDocumento);

		if (count == 0) {
			return null;
		}

		List<Progressivo> list = findByAnnoIdAssociatoTipoDocumento(anno,
				idAssociato, tipoDocumento, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the progressivos before and after the current progressivo in the ordered set where anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	 *
	 * @param progressivoPK the primary key of the current progressivo
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param tipoDocumento the tipo documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progressivo
	 * @throws it.bysoftware.ct.NoSuchProgressivoException if a progressivo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Progressivo[] findByAnnoIdAssociatoTipoDocumento_PrevAndNext(
		ProgressivoPK progressivoPK, int anno, long idAssociato,
		int tipoDocumento, OrderByComparator orderByComparator)
		throws NoSuchProgressivoException, SystemException {
		Progressivo progressivo = findByPrimaryKey(progressivoPK);

		Session session = null;

		try {
			session = openSession();

			Progressivo[] array = new ProgressivoImpl[3];

			array[0] = getByAnnoIdAssociatoTipoDocumento_PrevAndNext(session,
					progressivo, anno, idAssociato, tipoDocumento,
					orderByComparator, true);

			array[1] = progressivo;

			array[2] = getByAnnoIdAssociatoTipoDocumento_PrevAndNext(session,
					progressivo, anno, idAssociato, tipoDocumento,
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

	protected Progressivo getByAnnoIdAssociatoTipoDocumento_PrevAndNext(
		Session session, Progressivo progressivo, int anno, long idAssociato,
		int tipoDocumento, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROGRESSIVO_WHERE);

		query.append(_FINDER_COLUMN_ANNOIDASSOCIATOTIPODOCUMENTO_ANNO_2);

		query.append(_FINDER_COLUMN_ANNOIDASSOCIATOTIPODOCUMENTO_IDASSOCIATO_2);

		query.append(_FINDER_COLUMN_ANNOIDASSOCIATOTIPODOCUMENTO_TIPODOCUMENTO_2);

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
			query.append(ProgressivoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(anno);

		qPos.add(idAssociato);

		qPos.add(tipoDocumento);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(progressivo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Progressivo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the progressivos where anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63; from the database.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param tipoDocumento the tipo documento
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAnnoIdAssociatoTipoDocumento(int anno,
		long idAssociato, int tipoDocumento) throws SystemException {
		for (Progressivo progressivo : findByAnnoIdAssociatoTipoDocumento(
				anno, idAssociato, tipoDocumento, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(progressivo);
		}
	}

	/**
	 * Returns the number of progressivos where anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	 *
	 * @param anno the anno
	 * @param idAssociato the id associato
	 * @param tipoDocumento the tipo documento
	 * @return the number of matching progressivos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAnnoIdAssociatoTipoDocumento(int anno, long idAssociato,
		int tipoDocumento) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ANNOIDASSOCIATOTIPODOCUMENTO;

		Object[] finderArgs = new Object[] { anno, idAssociato, tipoDocumento };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_PROGRESSIVO_WHERE);

			query.append(_FINDER_COLUMN_ANNOIDASSOCIATOTIPODOCUMENTO_ANNO_2);

			query.append(_FINDER_COLUMN_ANNOIDASSOCIATOTIPODOCUMENTO_IDASSOCIATO_2);

			query.append(_FINDER_COLUMN_ANNOIDASSOCIATOTIPODOCUMENTO_TIPODOCUMENTO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(anno);

				qPos.add(idAssociato);

				qPos.add(tipoDocumento);

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

	private static final String _FINDER_COLUMN_ANNOIDASSOCIATOTIPODOCUMENTO_ANNO_2 =
		"progressivo.id.anno = ? AND ";
	private static final String _FINDER_COLUMN_ANNOIDASSOCIATOTIPODOCUMENTO_IDASSOCIATO_2 =
		"progressivo.id.idAssociato = ? AND ";
	private static final String _FINDER_COLUMN_ANNOIDASSOCIATOTIPODOCUMENTO_TIPODOCUMENTO_2 =
		"progressivo.id.tipoDocumento = ?";

	public ProgressivoPersistenceImpl() {
		setModelClass(Progressivo.class);
	}

	/**
	 * Caches the progressivo in the entity cache if it is enabled.
	 *
	 * @param progressivo the progressivo
	 */
	@Override
	public void cacheResult(Progressivo progressivo) {
		EntityCacheUtil.putResult(ProgressivoModelImpl.ENTITY_CACHE_ENABLED,
			ProgressivoImpl.class, progressivo.getPrimaryKey(), progressivo);

		progressivo.resetOriginalValues();
	}

	/**
	 * Caches the progressivos in the entity cache if it is enabled.
	 *
	 * @param progressivos the progressivos
	 */
	@Override
	public void cacheResult(List<Progressivo> progressivos) {
		for (Progressivo progressivo : progressivos) {
			if (EntityCacheUtil.getResult(
						ProgressivoModelImpl.ENTITY_CACHE_ENABLED,
						ProgressivoImpl.class, progressivo.getPrimaryKey()) == null) {
				cacheResult(progressivo);
			}
			else {
				progressivo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all progressivos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ProgressivoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ProgressivoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the progressivo.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Progressivo progressivo) {
		EntityCacheUtil.removeResult(ProgressivoModelImpl.ENTITY_CACHE_ENABLED,
			ProgressivoImpl.class, progressivo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Progressivo> progressivos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Progressivo progressivo : progressivos) {
			EntityCacheUtil.removeResult(ProgressivoModelImpl.ENTITY_CACHE_ENABLED,
				ProgressivoImpl.class, progressivo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new progressivo with the primary key. Does not add the progressivo to the database.
	 *
	 * @param progressivoPK the primary key for the new progressivo
	 * @return the new progressivo
	 */
	@Override
	public Progressivo create(ProgressivoPK progressivoPK) {
		Progressivo progressivo = new ProgressivoImpl();

		progressivo.setNew(true);
		progressivo.setPrimaryKey(progressivoPK);

		return progressivo;
	}

	/**
	 * Removes the progressivo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param progressivoPK the primary key of the progressivo
	 * @return the progressivo that was removed
	 * @throws it.bysoftware.ct.NoSuchProgressivoException if a progressivo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Progressivo remove(ProgressivoPK progressivoPK)
		throws NoSuchProgressivoException, SystemException {
		return remove((Serializable)progressivoPK);
	}

	/**
	 * Removes the progressivo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the progressivo
	 * @return the progressivo that was removed
	 * @throws it.bysoftware.ct.NoSuchProgressivoException if a progressivo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Progressivo remove(Serializable primaryKey)
		throws NoSuchProgressivoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Progressivo progressivo = (Progressivo)session.get(ProgressivoImpl.class,
					primaryKey);

			if (progressivo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProgressivoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(progressivo);
		}
		catch (NoSuchProgressivoException nsee) {
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
	protected Progressivo removeImpl(Progressivo progressivo)
		throws SystemException {
		progressivo = toUnwrappedModel(progressivo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(progressivo)) {
				progressivo = (Progressivo)session.get(ProgressivoImpl.class,
						progressivo.getPrimaryKeyObj());
			}

			if (progressivo != null) {
				session.delete(progressivo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (progressivo != null) {
			clearCache(progressivo);
		}

		return progressivo;
	}

	@Override
	public Progressivo updateImpl(
		it.bysoftware.ct.model.Progressivo progressivo)
		throws SystemException {
		progressivo = toUnwrappedModel(progressivo);

		boolean isNew = progressivo.isNew();

		ProgressivoModelImpl progressivoModelImpl = (ProgressivoModelImpl)progressivo;

		Session session = null;

		try {
			session = openSession();

			if (progressivo.isNew()) {
				session.save(progressivo);

				progressivo.setNew(false);
			}
			else {
				session.merge(progressivo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ProgressivoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((progressivoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANNOIDASSOCIATOTIPODOCUMENTO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						progressivoModelImpl.getOriginalAnno(),
						progressivoModelImpl.getOriginalIdAssociato(),
						progressivoModelImpl.getOriginalTipoDocumento()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ANNOIDASSOCIATOTIPODOCUMENTO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANNOIDASSOCIATOTIPODOCUMENTO,
					args);

				args = new Object[] {
						progressivoModelImpl.getAnno(),
						progressivoModelImpl.getIdAssociato(),
						progressivoModelImpl.getTipoDocumento()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ANNOIDASSOCIATOTIPODOCUMENTO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANNOIDASSOCIATOTIPODOCUMENTO,
					args);
			}
		}

		EntityCacheUtil.putResult(ProgressivoModelImpl.ENTITY_CACHE_ENABLED,
			ProgressivoImpl.class, progressivo.getPrimaryKey(), progressivo);

		return progressivo;
	}

	protected Progressivo toUnwrappedModel(Progressivo progressivo) {
		if (progressivo instanceof ProgressivoImpl) {
			return progressivo;
		}

		ProgressivoImpl progressivoImpl = new ProgressivoImpl();

		progressivoImpl.setNew(progressivo.isNew());
		progressivoImpl.setPrimaryKey(progressivo.getPrimaryKey());

		progressivoImpl.setAnno(progressivo.getAnno());
		progressivoImpl.setIdAssociato(progressivo.getIdAssociato());
		progressivoImpl.setCodiceCentro(progressivo.getCodiceCentro());
		progressivoImpl.setCodiceDeposito(progressivo.getCodiceDeposito());
		progressivoImpl.setDataRegistrazione(progressivo.getDataRegistrazione());
		progressivoImpl.setNumeroBolla(progressivo.getNumeroBolla());
		progressivoImpl.setTipoDocumento(progressivo.getTipoDocumento());
		progressivoImpl.setNumeroProgressivo(progressivo.getNumeroProgressivo());
		progressivoImpl.setTipoCon(progressivo.getTipoCon());
		progressivoImpl.setCodiceAzienda(progressivo.getCodiceAzienda());

		return progressivoImpl;
	}

	/**
	 * Returns the progressivo with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the progressivo
	 * @return the progressivo
	 * @throws it.bysoftware.ct.NoSuchProgressivoException if a progressivo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Progressivo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProgressivoException, SystemException {
		Progressivo progressivo = fetchByPrimaryKey(primaryKey);

		if (progressivo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProgressivoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return progressivo;
	}

	/**
	 * Returns the progressivo with the primary key or throws a {@link it.bysoftware.ct.NoSuchProgressivoException} if it could not be found.
	 *
	 * @param progressivoPK the primary key of the progressivo
	 * @return the progressivo
	 * @throws it.bysoftware.ct.NoSuchProgressivoException if a progressivo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Progressivo findByPrimaryKey(ProgressivoPK progressivoPK)
		throws NoSuchProgressivoException, SystemException {
		return findByPrimaryKey((Serializable)progressivoPK);
	}

	/**
	 * Returns the progressivo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the progressivo
	 * @return the progressivo, or <code>null</code> if a progressivo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Progressivo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Progressivo progressivo = (Progressivo)EntityCacheUtil.getResult(ProgressivoModelImpl.ENTITY_CACHE_ENABLED,
				ProgressivoImpl.class, primaryKey);

		if (progressivo == _nullProgressivo) {
			return null;
		}

		if (progressivo == null) {
			Session session = null;

			try {
				session = openSession();

				progressivo = (Progressivo)session.get(ProgressivoImpl.class,
						primaryKey);

				if (progressivo != null) {
					cacheResult(progressivo);
				}
				else {
					EntityCacheUtil.putResult(ProgressivoModelImpl.ENTITY_CACHE_ENABLED,
						ProgressivoImpl.class, primaryKey, _nullProgressivo);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ProgressivoModelImpl.ENTITY_CACHE_ENABLED,
					ProgressivoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return progressivo;
	}

	/**
	 * Returns the progressivo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param progressivoPK the primary key of the progressivo
	 * @return the progressivo, or <code>null</code> if a progressivo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Progressivo fetchByPrimaryKey(ProgressivoPK progressivoPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)progressivoPK);
	}

	/**
	 * Returns all the progressivos.
	 *
	 * @return the progressivos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Progressivo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the progressivos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.ProgressivoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of progressivos
	 * @param end the upper bound of the range of progressivos (not inclusive)
	 * @return the range of progressivos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Progressivo> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the progressivos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.ProgressivoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of progressivos
	 * @param end the upper bound of the range of progressivos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of progressivos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Progressivo> findAll(int start, int end,
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

		List<Progressivo> list = (List<Progressivo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PROGRESSIVO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROGRESSIVO;

				if (pagination) {
					sql = sql.concat(ProgressivoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Progressivo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Progressivo>(list);
				}
				else {
					list = (List<Progressivo>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the progressivos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Progressivo progressivo : findAll()) {
			remove(progressivo);
		}
	}

	/**
	 * Returns the number of progressivos.
	 *
	 * @return the number of progressivos
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

				Query q = session.createQuery(_SQL_COUNT_PROGRESSIVO);

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
	 * Initializes the progressivo persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.bysoftware.ct.model.Progressivo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Progressivo>> listenersList = new ArrayList<ModelListener<Progressivo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Progressivo>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ProgressivoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PROGRESSIVO = "SELECT progressivo FROM Progressivo progressivo";
	private static final String _SQL_SELECT_PROGRESSIVO_WHERE = "SELECT progressivo FROM Progressivo progressivo WHERE ";
	private static final String _SQL_COUNT_PROGRESSIVO = "SELECT COUNT(progressivo) FROM Progressivo progressivo";
	private static final String _SQL_COUNT_PROGRESSIVO_WHERE = "SELECT COUNT(progressivo) FROM Progressivo progressivo WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "progressivo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Progressivo exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Progressivo exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ProgressivoPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"anno", "idAssociato", "codiceCentro", "codiceDeposito",
				"dataRegistrazione", "numeroBolla", "tipoDocumento",
				"numeroProgressivo", "tipoCon", "codiceAzienda"
			});
	private static Progressivo _nullProgressivo = new ProgressivoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Progressivo> toCacheModel() {
				return _nullProgressivoCacheModel;
			}
		};

	private static CacheModel<Progressivo> _nullProgressivoCacheModel = new CacheModel<Progressivo>() {
			@Override
			public Progressivo toEntityModel() {
				return _nullProgressivo;
			}
		};
}
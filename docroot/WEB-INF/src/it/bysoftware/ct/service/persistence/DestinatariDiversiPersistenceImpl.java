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

import it.bysoftware.ct.NoSuchDestinatariDiversiException;
import it.bysoftware.ct.model.DestinatariDiversi;
import it.bysoftware.ct.model.impl.DestinatariDiversiImpl;
import it.bysoftware.ct.model.impl.DestinatariDiversiModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the destinatari diversi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DestinatariDiversiPersistence
 * @see DestinatariDiversiUtil
 * @generated
 */
public class DestinatariDiversiPersistenceImpl extends BasePersistenceImpl<DestinatariDiversi>
	implements DestinatariDiversiPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DestinatariDiversiUtil} to access the destinatari diversi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DestinatariDiversiImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DestinatariDiversiModelImpl.ENTITY_CACHE_ENABLED,
			DestinatariDiversiModelImpl.FINDER_CACHE_ENABLED,
			DestinatariDiversiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DestinatariDiversiModelImpl.ENTITY_CACHE_ENABLED,
			DestinatariDiversiModelImpl.FINDER_CACHE_ENABLED,
			DestinatariDiversiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DestinatariDiversiModelImpl.ENTITY_CACHE_ENABLED,
			DestinatariDiversiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CODICERIFERIMENTO =
		new FinderPath(DestinatariDiversiModelImpl.ENTITY_CACHE_ENABLED,
			DestinatariDiversiModelImpl.FINDER_CACHE_ENABLED,
			DestinatariDiversiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycodiceRiferimento",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODICERIFERIMENTO =
		new FinderPath(DestinatariDiversiModelImpl.ENTITY_CACHE_ENABLED,
			DestinatariDiversiModelImpl.FINDER_CACHE_ENABLED,
			DestinatariDiversiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBycodiceRiferimento", new String[] { String.class.getName() },
			DestinatariDiversiModelImpl.CODICERIFERIMENTO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODICERIFERIMENTO = new FinderPath(DestinatariDiversiModelImpl.ENTITY_CACHE_ENABLED,
			DestinatariDiversiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBycodiceRiferimento", new String[] { String.class.getName() });

	/**
	 * Returns all the destinatari diversis where codiceRiferimento = &#63;.
	 *
	 * @param codiceRiferimento the codice riferimento
	 * @return the matching destinatari diversis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DestinatariDiversi> findBycodiceRiferimento(
		String codiceRiferimento) throws SystemException {
		return findBycodiceRiferimento(codiceRiferimento, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the destinatari diversis where codiceRiferimento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.DestinatariDiversiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param codiceRiferimento the codice riferimento
	 * @param start the lower bound of the range of destinatari diversis
	 * @param end the upper bound of the range of destinatari diversis (not inclusive)
	 * @return the range of matching destinatari diversis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DestinatariDiversi> findBycodiceRiferimento(
		String codiceRiferimento, int start, int end) throws SystemException {
		return findBycodiceRiferimento(codiceRiferimento, start, end, null);
	}

	/**
	 * Returns an ordered range of all the destinatari diversis where codiceRiferimento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.DestinatariDiversiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param codiceRiferimento the codice riferimento
	 * @param start the lower bound of the range of destinatari diversis
	 * @param end the upper bound of the range of destinatari diversis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching destinatari diversis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DestinatariDiversi> findBycodiceRiferimento(
		String codiceRiferimento, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODICERIFERIMENTO;
			finderArgs = new Object[] { codiceRiferimento };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CODICERIFERIMENTO;
			finderArgs = new Object[] {
					codiceRiferimento,
					
					start, end, orderByComparator
				};
		}

		List<DestinatariDiversi> list = (List<DestinatariDiversi>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DestinatariDiversi destinatariDiversi : list) {
				if (!Validator.equals(codiceRiferimento,
							destinatariDiversi.getCodiceRiferimento())) {
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

			query.append(_SQL_SELECT_DESTINATARIDIVERSI_WHERE);

			boolean bindCodiceRiferimento = false;

			if (codiceRiferimento == null) {
				query.append(_FINDER_COLUMN_CODICERIFERIMENTO_CODICERIFERIMENTO_1);
			}
			else if (codiceRiferimento.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODICERIFERIMENTO_CODICERIFERIMENTO_3);
			}
			else {
				bindCodiceRiferimento = true;

				query.append(_FINDER_COLUMN_CODICERIFERIMENTO_CODICERIFERIMENTO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DestinatariDiversiModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCodiceRiferimento) {
					qPos.add(codiceRiferimento);
				}

				if (!pagination) {
					list = (List<DestinatariDiversi>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DestinatariDiversi>(list);
				}
				else {
					list = (List<DestinatariDiversi>)QueryUtil.list(q,
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
	 * Returns the first destinatari diversi in the ordered set where codiceRiferimento = &#63;.
	 *
	 * @param codiceRiferimento the codice riferimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinatari diversi
	 * @throws it.bysoftware.ct.NoSuchDestinatariDiversiException if a matching destinatari diversi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DestinatariDiversi findBycodiceRiferimento_First(
		String codiceRiferimento, OrderByComparator orderByComparator)
		throws NoSuchDestinatariDiversiException, SystemException {
		DestinatariDiversi destinatariDiversi = fetchBycodiceRiferimento_First(codiceRiferimento,
				orderByComparator);

		if (destinatariDiversi != null) {
			return destinatariDiversi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("codiceRiferimento=");
		msg.append(codiceRiferimento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDestinatariDiversiException(msg.toString());
	}

	/**
	 * Returns the first destinatari diversi in the ordered set where codiceRiferimento = &#63;.
	 *
	 * @param codiceRiferimento the codice riferimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching destinatari diversi, or <code>null</code> if a matching destinatari diversi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DestinatariDiversi fetchBycodiceRiferimento_First(
		String codiceRiferimento, OrderByComparator orderByComparator)
		throws SystemException {
		List<DestinatariDiversi> list = findBycodiceRiferimento(codiceRiferimento,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last destinatari diversi in the ordered set where codiceRiferimento = &#63;.
	 *
	 * @param codiceRiferimento the codice riferimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinatari diversi
	 * @throws it.bysoftware.ct.NoSuchDestinatariDiversiException if a matching destinatari diversi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DestinatariDiversi findBycodiceRiferimento_Last(
		String codiceRiferimento, OrderByComparator orderByComparator)
		throws NoSuchDestinatariDiversiException, SystemException {
		DestinatariDiversi destinatariDiversi = fetchBycodiceRiferimento_Last(codiceRiferimento,
				orderByComparator);

		if (destinatariDiversi != null) {
			return destinatariDiversi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("codiceRiferimento=");
		msg.append(codiceRiferimento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDestinatariDiversiException(msg.toString());
	}

	/**
	 * Returns the last destinatari diversi in the ordered set where codiceRiferimento = &#63;.
	 *
	 * @param codiceRiferimento the codice riferimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching destinatari diversi, or <code>null</code> if a matching destinatari diversi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DestinatariDiversi fetchBycodiceRiferimento_Last(
		String codiceRiferimento, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBycodiceRiferimento(codiceRiferimento);

		if (count == 0) {
			return null;
		}

		List<DestinatariDiversi> list = findBycodiceRiferimento(codiceRiferimento,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the destinatari diversis before and after the current destinatari diversi in the ordered set where codiceRiferimento = &#63;.
	 *
	 * @param codiceAnagrafica the primary key of the current destinatari diversi
	 * @param codiceRiferimento the codice riferimento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next destinatari diversi
	 * @throws it.bysoftware.ct.NoSuchDestinatariDiversiException if a destinatari diversi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DestinatariDiversi[] findBycodiceRiferimento_PrevAndNext(
		String codiceAnagrafica, String codiceRiferimento,
		OrderByComparator orderByComparator)
		throws NoSuchDestinatariDiversiException, SystemException {
		DestinatariDiversi destinatariDiversi = findByPrimaryKey(codiceAnagrafica);

		Session session = null;

		try {
			session = openSession();

			DestinatariDiversi[] array = new DestinatariDiversiImpl[3];

			array[0] = getBycodiceRiferimento_PrevAndNext(session,
					destinatariDiversi, codiceRiferimento, orderByComparator,
					true);

			array[1] = destinatariDiversi;

			array[2] = getBycodiceRiferimento_PrevAndNext(session,
					destinatariDiversi, codiceRiferimento, orderByComparator,
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

	protected DestinatariDiversi getBycodiceRiferimento_PrevAndNext(
		Session session, DestinatariDiversi destinatariDiversi,
		String codiceRiferimento, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DESTINATARIDIVERSI_WHERE);

		boolean bindCodiceRiferimento = false;

		if (codiceRiferimento == null) {
			query.append(_FINDER_COLUMN_CODICERIFERIMENTO_CODICERIFERIMENTO_1);
		}
		else if (codiceRiferimento.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CODICERIFERIMENTO_CODICERIFERIMENTO_3);
		}
		else {
			bindCodiceRiferimento = true;

			query.append(_FINDER_COLUMN_CODICERIFERIMENTO_CODICERIFERIMENTO_2);
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
			query.append(DestinatariDiversiModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCodiceRiferimento) {
			qPos.add(codiceRiferimento);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(destinatariDiversi);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DestinatariDiversi> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the destinatari diversis where codiceRiferimento = &#63; from the database.
	 *
	 * @param codiceRiferimento the codice riferimento
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBycodiceRiferimento(String codiceRiferimento)
		throws SystemException {
		for (DestinatariDiversi destinatariDiversi : findBycodiceRiferimento(
				codiceRiferimento, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(destinatariDiversi);
		}
	}

	/**
	 * Returns the number of destinatari diversis where codiceRiferimento = &#63;.
	 *
	 * @param codiceRiferimento the codice riferimento
	 * @return the number of matching destinatari diversis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBycodiceRiferimento(String codiceRiferimento)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CODICERIFERIMENTO;

		Object[] finderArgs = new Object[] { codiceRiferimento };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DESTINATARIDIVERSI_WHERE);

			boolean bindCodiceRiferimento = false;

			if (codiceRiferimento == null) {
				query.append(_FINDER_COLUMN_CODICERIFERIMENTO_CODICERIFERIMENTO_1);
			}
			else if (codiceRiferimento.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODICERIFERIMENTO_CODICERIFERIMENTO_3);
			}
			else {
				bindCodiceRiferimento = true;

				query.append(_FINDER_COLUMN_CODICERIFERIMENTO_CODICERIFERIMENTO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCodiceRiferimento) {
					qPos.add(codiceRiferimento);
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

	private static final String _FINDER_COLUMN_CODICERIFERIMENTO_CODICERIFERIMENTO_1 =
		"destinatariDiversi.codiceRiferimento IS NULL";
	private static final String _FINDER_COLUMN_CODICERIFERIMENTO_CODICERIFERIMENTO_2 =
		"destinatariDiversi.codiceRiferimento = ?";
	private static final String _FINDER_COLUMN_CODICERIFERIMENTO_CODICERIFERIMENTO_3 =
		"(destinatariDiversi.codiceRiferimento IS NULL OR destinatariDiversi.codiceRiferimento = '')";

	public DestinatariDiversiPersistenceImpl() {
		setModelClass(DestinatariDiversi.class);
	}

	/**
	 * Caches the destinatari diversi in the entity cache if it is enabled.
	 *
	 * @param destinatariDiversi the destinatari diversi
	 */
	@Override
	public void cacheResult(DestinatariDiversi destinatariDiversi) {
		EntityCacheUtil.putResult(DestinatariDiversiModelImpl.ENTITY_CACHE_ENABLED,
			DestinatariDiversiImpl.class, destinatariDiversi.getPrimaryKey(),
			destinatariDiversi);

		destinatariDiversi.resetOriginalValues();
	}

	/**
	 * Caches the destinatari diversis in the entity cache if it is enabled.
	 *
	 * @param destinatariDiversis the destinatari diversis
	 */
	@Override
	public void cacheResult(List<DestinatariDiversi> destinatariDiversis) {
		for (DestinatariDiversi destinatariDiversi : destinatariDiversis) {
			if (EntityCacheUtil.getResult(
						DestinatariDiversiModelImpl.ENTITY_CACHE_ENABLED,
						DestinatariDiversiImpl.class,
						destinatariDiversi.getPrimaryKey()) == null) {
				cacheResult(destinatariDiversi);
			}
			else {
				destinatariDiversi.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all destinatari diversis.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DestinatariDiversiImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DestinatariDiversiImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the destinatari diversi.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DestinatariDiversi destinatariDiversi) {
		EntityCacheUtil.removeResult(DestinatariDiversiModelImpl.ENTITY_CACHE_ENABLED,
			DestinatariDiversiImpl.class, destinatariDiversi.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DestinatariDiversi> destinatariDiversis) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DestinatariDiversi destinatariDiversi : destinatariDiversis) {
			EntityCacheUtil.removeResult(DestinatariDiversiModelImpl.ENTITY_CACHE_ENABLED,
				DestinatariDiversiImpl.class, destinatariDiversi.getPrimaryKey());
		}
	}

	/**
	 * Creates a new destinatari diversi with the primary key. Does not add the destinatari diversi to the database.
	 *
	 * @param codiceAnagrafica the primary key for the new destinatari diversi
	 * @return the new destinatari diversi
	 */
	@Override
	public DestinatariDiversi create(String codiceAnagrafica) {
		DestinatariDiversi destinatariDiversi = new DestinatariDiversiImpl();

		destinatariDiversi.setNew(true);
		destinatariDiversi.setPrimaryKey(codiceAnagrafica);

		return destinatariDiversi;
	}

	/**
	 * Removes the destinatari diversi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param codiceAnagrafica the primary key of the destinatari diversi
	 * @return the destinatari diversi that was removed
	 * @throws it.bysoftware.ct.NoSuchDestinatariDiversiException if a destinatari diversi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DestinatariDiversi remove(String codiceAnagrafica)
		throws NoSuchDestinatariDiversiException, SystemException {
		return remove((Serializable)codiceAnagrafica);
	}

	/**
	 * Removes the destinatari diversi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the destinatari diversi
	 * @return the destinatari diversi that was removed
	 * @throws it.bysoftware.ct.NoSuchDestinatariDiversiException if a destinatari diversi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DestinatariDiversi remove(Serializable primaryKey)
		throws NoSuchDestinatariDiversiException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DestinatariDiversi destinatariDiversi = (DestinatariDiversi)session.get(DestinatariDiversiImpl.class,
					primaryKey);

			if (destinatariDiversi == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDestinatariDiversiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(destinatariDiversi);
		}
		catch (NoSuchDestinatariDiversiException nsee) {
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
	protected DestinatariDiversi removeImpl(
		DestinatariDiversi destinatariDiversi) throws SystemException {
		destinatariDiversi = toUnwrappedModel(destinatariDiversi);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(destinatariDiversi)) {
				destinatariDiversi = (DestinatariDiversi)session.get(DestinatariDiversiImpl.class,
						destinatariDiversi.getPrimaryKeyObj());
			}

			if (destinatariDiversi != null) {
				session.delete(destinatariDiversi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (destinatariDiversi != null) {
			clearCache(destinatariDiversi);
		}

		return destinatariDiversi;
	}

	@Override
	public DestinatariDiversi updateImpl(
		it.bysoftware.ct.model.DestinatariDiversi destinatariDiversi)
		throws SystemException {
		destinatariDiversi = toUnwrappedModel(destinatariDiversi);

		boolean isNew = destinatariDiversi.isNew();

		DestinatariDiversiModelImpl destinatariDiversiModelImpl = (DestinatariDiversiModelImpl)destinatariDiversi;

		Session session = null;

		try {
			session = openSession();

			if (destinatariDiversi.isNew()) {
				session.save(destinatariDiversi);

				destinatariDiversi.setNew(false);
			}
			else {
				session.merge(destinatariDiversi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DestinatariDiversiModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((destinatariDiversiModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODICERIFERIMENTO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						destinatariDiversiModelImpl.getOriginalCodiceRiferimento()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODICERIFERIMENTO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODICERIFERIMENTO,
					args);

				args = new Object[] {
						destinatariDiversiModelImpl.getCodiceRiferimento()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODICERIFERIMENTO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODICERIFERIMENTO,
					args);
			}
		}

		EntityCacheUtil.putResult(DestinatariDiversiModelImpl.ENTITY_CACHE_ENABLED,
			DestinatariDiversiImpl.class, destinatariDiversi.getPrimaryKey(),
			destinatariDiversi);

		return destinatariDiversi;
	}

	protected DestinatariDiversi toUnwrappedModel(
		DestinatariDiversi destinatariDiversi) {
		if (destinatariDiversi instanceof DestinatariDiversiImpl) {
			return destinatariDiversi;
		}

		DestinatariDiversiImpl destinatariDiversiImpl = new DestinatariDiversiImpl();

		destinatariDiversiImpl.setNew(destinatariDiversi.isNew());
		destinatariDiversiImpl.setPrimaryKey(destinatariDiversi.getPrimaryKey());

		destinatariDiversiImpl.setCodiceAnagrafica(destinatariDiversi.getCodiceAnagrafica());
		destinatariDiversiImpl.setCodiceRiferimento(destinatariDiversi.getCodiceRiferimento());
		destinatariDiversiImpl.setCAP(destinatariDiversi.getCAP());
		destinatariDiversiImpl.setComune(destinatariDiversi.getComune());
		destinatariDiversiImpl.setIndirizzo(destinatariDiversi.getIndirizzo());
		destinatariDiversiImpl.setProvincia(destinatariDiversi.getProvincia());
		destinatariDiversiImpl.setStato(destinatariDiversi.getStato());
		destinatariDiversiImpl.setTipoAnagrafica(destinatariDiversi.getTipoAnagrafica());

		return destinatariDiversiImpl;
	}

	/**
	 * Returns the destinatari diversi with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the destinatari diversi
	 * @return the destinatari diversi
	 * @throws it.bysoftware.ct.NoSuchDestinatariDiversiException if a destinatari diversi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DestinatariDiversi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDestinatariDiversiException, SystemException {
		DestinatariDiversi destinatariDiversi = fetchByPrimaryKey(primaryKey);

		if (destinatariDiversi == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDestinatariDiversiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return destinatariDiversi;
	}

	/**
	 * Returns the destinatari diversi with the primary key or throws a {@link it.bysoftware.ct.NoSuchDestinatariDiversiException} if it could not be found.
	 *
	 * @param codiceAnagrafica the primary key of the destinatari diversi
	 * @return the destinatari diversi
	 * @throws it.bysoftware.ct.NoSuchDestinatariDiversiException if a destinatari diversi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DestinatariDiversi findByPrimaryKey(String codiceAnagrafica)
		throws NoSuchDestinatariDiversiException, SystemException {
		return findByPrimaryKey((Serializable)codiceAnagrafica);
	}

	/**
	 * Returns the destinatari diversi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the destinatari diversi
	 * @return the destinatari diversi, or <code>null</code> if a destinatari diversi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DestinatariDiversi fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DestinatariDiversi destinatariDiversi = (DestinatariDiversi)EntityCacheUtil.getResult(DestinatariDiversiModelImpl.ENTITY_CACHE_ENABLED,
				DestinatariDiversiImpl.class, primaryKey);

		if (destinatariDiversi == _nullDestinatariDiversi) {
			return null;
		}

		if (destinatariDiversi == null) {
			Session session = null;

			try {
				session = openSession();

				destinatariDiversi = (DestinatariDiversi)session.get(DestinatariDiversiImpl.class,
						primaryKey);

				if (destinatariDiversi != null) {
					cacheResult(destinatariDiversi);
				}
				else {
					EntityCacheUtil.putResult(DestinatariDiversiModelImpl.ENTITY_CACHE_ENABLED,
						DestinatariDiversiImpl.class, primaryKey,
						_nullDestinatariDiversi);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DestinatariDiversiModelImpl.ENTITY_CACHE_ENABLED,
					DestinatariDiversiImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return destinatariDiversi;
	}

	/**
	 * Returns the destinatari diversi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param codiceAnagrafica the primary key of the destinatari diversi
	 * @return the destinatari diversi, or <code>null</code> if a destinatari diversi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DestinatariDiversi fetchByPrimaryKey(String codiceAnagrafica)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)codiceAnagrafica);
	}

	/**
	 * Returns all the destinatari diversis.
	 *
	 * @return the destinatari diversis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DestinatariDiversi> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the destinatari diversis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.DestinatariDiversiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of destinatari diversis
	 * @param end the upper bound of the range of destinatari diversis (not inclusive)
	 * @return the range of destinatari diversis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DestinatariDiversi> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the destinatari diversis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.DestinatariDiversiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of destinatari diversis
	 * @param end the upper bound of the range of destinatari diversis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of destinatari diversis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DestinatariDiversi> findAll(int start, int end,
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

		List<DestinatariDiversi> list = (List<DestinatariDiversi>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DESTINATARIDIVERSI);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DESTINATARIDIVERSI;

				if (pagination) {
					sql = sql.concat(DestinatariDiversiModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DestinatariDiversi>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DestinatariDiversi>(list);
				}
				else {
					list = (List<DestinatariDiversi>)QueryUtil.list(q,
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
	 * Removes all the destinatari diversis from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DestinatariDiversi destinatariDiversi : findAll()) {
			remove(destinatariDiversi);
		}
	}

	/**
	 * Returns the number of destinatari diversis.
	 *
	 * @return the number of destinatari diversis
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

				Query q = session.createQuery(_SQL_COUNT_DESTINATARIDIVERSI);

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
	 * Initializes the destinatari diversi persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.bysoftware.ct.model.DestinatariDiversi")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DestinatariDiversi>> listenersList = new ArrayList<ModelListener<DestinatariDiversi>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DestinatariDiversi>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DestinatariDiversiImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DESTINATARIDIVERSI = "SELECT destinatariDiversi FROM DestinatariDiversi destinatariDiversi";
	private static final String _SQL_SELECT_DESTINATARIDIVERSI_WHERE = "SELECT destinatariDiversi FROM DestinatariDiversi destinatariDiversi WHERE ";
	private static final String _SQL_COUNT_DESTINATARIDIVERSI = "SELECT COUNT(destinatariDiversi) FROM DestinatariDiversi destinatariDiversi";
	private static final String _SQL_COUNT_DESTINATARIDIVERSI_WHERE = "SELECT COUNT(destinatariDiversi) FROM DestinatariDiversi destinatariDiversi WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "destinatariDiversi.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DestinatariDiversi exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DestinatariDiversi exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DestinatariDiversiPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"codiceAnagrafica", "codiceRiferimento", "CAP", "comune",
				"indirizzo", "provincia", "stato", "tipoAnagrafica"
			});
	private static DestinatariDiversi _nullDestinatariDiversi = new DestinatariDiversiImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DestinatariDiversi> toCacheModel() {
				return _nullDestinatariDiversiCacheModel;
			}
		};

	private static CacheModel<DestinatariDiversi> _nullDestinatariDiversiCacheModel =
		new CacheModel<DestinatariDiversi>() {
			@Override
			public DestinatariDiversi toEntityModel() {
				return _nullDestinatariDiversi;
			}
		};
}
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

import it.bysoftware.ct.NoSuchTestataDocumentoException;
import it.bysoftware.ct.model.TestataDocumento;
import it.bysoftware.ct.model.impl.TestataDocumentoImpl;
import it.bysoftware.ct.model.impl.TestataDocumentoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the testata documento service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TestataDocumentoPersistence
 * @see TestataDocumentoUtil
 * @generated
 */
public class TestataDocumentoPersistenceImpl extends BasePersistenceImpl<TestataDocumento>
	implements TestataDocumentoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TestataDocumentoUtil} to access the testata documento persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TestataDocumentoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			TestataDocumentoModelImpl.FINDER_CACHE_ENABLED,
			TestataDocumentoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			TestataDocumentoModelImpl.FINDER_CACHE_ENABLED,
			TestataDocumentoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			TestataDocumentoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OPERATORE =
		new FinderPath(TestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			TestataDocumentoModelImpl.FINDER_CACHE_ENABLED,
			TestataDocumentoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByoperatore",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPERATORE =
		new FinderPath(TestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			TestataDocumentoModelImpl.FINDER_CACHE_ENABLED,
			TestataDocumentoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByoperatore",
			new String[] { String.class.getName() },
			TestataDocumentoModelImpl.OPERATORE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OPERATORE = new FinderPath(TestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			TestataDocumentoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByoperatore",
			new String[] { String.class.getName() });

	/**
	 * Returns all the testata documentos where operatore = &#63;.
	 *
	 * @param operatore the operatore
	 * @return the matching testata documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TestataDocumento> findByoperatore(String operatore)
		throws SystemException {
		return findByoperatore(operatore, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the testata documentos where operatore = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param operatore the operatore
	 * @param start the lower bound of the range of testata documentos
	 * @param end the upper bound of the range of testata documentos (not inclusive)
	 * @return the range of matching testata documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TestataDocumento> findByoperatore(String operatore, int start,
		int end) throws SystemException {
		return findByoperatore(operatore, start, end, null);
	}

	/**
	 * Returns an ordered range of all the testata documentos where operatore = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param operatore the operatore
	 * @param start the lower bound of the range of testata documentos
	 * @param end the upper bound of the range of testata documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching testata documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TestataDocumento> findByoperatore(String operatore, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPERATORE;
			finderArgs = new Object[] { operatore };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OPERATORE;
			finderArgs = new Object[] { operatore, start, end, orderByComparator };
		}

		List<TestataDocumento> list = (List<TestataDocumento>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TestataDocumento testataDocumento : list) {
				if (!Validator.equals(operatore, testataDocumento.getOperatore())) {
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

			query.append(_SQL_SELECT_TESTATADOCUMENTO_WHERE);

			boolean bindOperatore = false;

			if (operatore == null) {
				query.append(_FINDER_COLUMN_OPERATORE_OPERATORE_1);
			}
			else if (operatore.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OPERATORE_OPERATORE_3);
			}
			else {
				bindOperatore = true;

				query.append(_FINDER_COLUMN_OPERATORE_OPERATORE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TestataDocumentoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOperatore) {
					qPos.add(operatore);
				}

				if (!pagination) {
					list = (List<TestataDocumento>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TestataDocumento>(list);
				}
				else {
					list = (List<TestataDocumento>)QueryUtil.list(q,
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
	 * Returns the first testata documento in the ordered set where operatore = &#63;.
	 *
	 * @param operatore the operatore
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching testata documento
	 * @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a matching testata documento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestataDocumento findByoperatore_First(String operatore,
		OrderByComparator orderByComparator)
		throws NoSuchTestataDocumentoException, SystemException {
		TestataDocumento testataDocumento = fetchByoperatore_First(operatore,
				orderByComparator);

		if (testataDocumento != null) {
			return testataDocumento;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("operatore=");
		msg.append(operatore);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTestataDocumentoException(msg.toString());
	}

	/**
	 * Returns the first testata documento in the ordered set where operatore = &#63;.
	 *
	 * @param operatore the operatore
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching testata documento, or <code>null</code> if a matching testata documento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestataDocumento fetchByoperatore_First(String operatore,
		OrderByComparator orderByComparator) throws SystemException {
		List<TestataDocumento> list = findByoperatore(operatore, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last testata documento in the ordered set where operatore = &#63;.
	 *
	 * @param operatore the operatore
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching testata documento
	 * @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a matching testata documento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestataDocumento findByoperatore_Last(String operatore,
		OrderByComparator orderByComparator)
		throws NoSuchTestataDocumentoException, SystemException {
		TestataDocumento testataDocumento = fetchByoperatore_Last(operatore,
				orderByComparator);

		if (testataDocumento != null) {
			return testataDocumento;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("operatore=");
		msg.append(operatore);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTestataDocumentoException(msg.toString());
	}

	/**
	 * Returns the last testata documento in the ordered set where operatore = &#63;.
	 *
	 * @param operatore the operatore
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching testata documento, or <code>null</code> if a matching testata documento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestataDocumento fetchByoperatore_Last(String operatore,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByoperatore(operatore);

		if (count == 0) {
			return null;
		}

		List<TestataDocumento> list = findByoperatore(operatore, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the testata documentos before and after the current testata documento in the ordered set where operatore = &#63;.
	 *
	 * @param testataDocumentoPK the primary key of the current testata documento
	 * @param operatore the operatore
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next testata documento
	 * @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a testata documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestataDocumento[] findByoperatore_PrevAndNext(
		TestataDocumentoPK testataDocumentoPK, String operatore,
		OrderByComparator orderByComparator)
		throws NoSuchTestataDocumentoException, SystemException {
		TestataDocumento testataDocumento = findByPrimaryKey(testataDocumentoPK);

		Session session = null;

		try {
			session = openSession();

			TestataDocumento[] array = new TestataDocumentoImpl[3];

			array[0] = getByoperatore_PrevAndNext(session, testataDocumento,
					operatore, orderByComparator, true);

			array[1] = testataDocumento;

			array[2] = getByoperatore_PrevAndNext(session, testataDocumento,
					operatore, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TestataDocumento getByoperatore_PrevAndNext(Session session,
		TestataDocumento testataDocumento, String operatore,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TESTATADOCUMENTO_WHERE);

		boolean bindOperatore = false;

		if (operatore == null) {
			query.append(_FINDER_COLUMN_OPERATORE_OPERATORE_1);
		}
		else if (operatore.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_OPERATORE_OPERATORE_3);
		}
		else {
			bindOperatore = true;

			query.append(_FINDER_COLUMN_OPERATORE_OPERATORE_2);
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
			query.append(TestataDocumentoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindOperatore) {
			qPos.add(operatore);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(testataDocumento);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TestataDocumento> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the testata documentos where operatore = &#63; from the database.
	 *
	 * @param operatore the operatore
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByoperatore(String operatore) throws SystemException {
		for (TestataDocumento testataDocumento : findByoperatore(operatore,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(testataDocumento);
		}
	}

	/**
	 * Returns the number of testata documentos where operatore = &#63;.
	 *
	 * @param operatore the operatore
	 * @return the number of matching testata documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByoperatore(String operatore) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OPERATORE;

		Object[] finderArgs = new Object[] { operatore };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TESTATADOCUMENTO_WHERE);

			boolean bindOperatore = false;

			if (operatore == null) {
				query.append(_FINDER_COLUMN_OPERATORE_OPERATORE_1);
			}
			else if (operatore.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OPERATORE_OPERATORE_3);
			}
			else {
				bindOperatore = true;

				query.append(_FINDER_COLUMN_OPERATORE_OPERATORE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOperatore) {
					qPos.add(operatore);
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

	private static final String _FINDER_COLUMN_OPERATORE_OPERATORE_1 = "testataDocumento.operatore IS NULL";
	private static final String _FINDER_COLUMN_OPERATORE_OPERATORE_2 = "testataDocumento.operatore = ?";
	private static final String _FINDER_COLUMN_OPERATORE_OPERATORE_3 = "(testataDocumento.operatore IS NULL OR testataDocumento.operatore = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CODICESOGGETTOCODICEOPERATORE =
		new FinderPath(TestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			TestataDocumentoModelImpl.FINDER_CACHE_ENABLED,
			TestataDocumentoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCodiceSoggettoCodiceOperatore",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODICESOGGETTOCODICEOPERATORE =
		new FinderPath(TestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			TestataDocumentoModelImpl.FINDER_CACHE_ENABLED,
			TestataDocumentoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCodiceSoggettoCodiceOperatore",
			new String[] { String.class.getName(), String.class.getName() },
			TestataDocumentoModelImpl.CODICESOGGETTO_COLUMN_BITMASK |
			TestataDocumentoModelImpl.OPERATORE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODICESOGGETTOCODICEOPERATORE =
		new FinderPath(TestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			TestataDocumentoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCodiceSoggettoCodiceOperatore",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the testata documentos where codiceSoggetto = &#63; and operatore = &#63;.
	 *
	 * @param codiceSoggetto the codice soggetto
	 * @param operatore the operatore
	 * @return the matching testata documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TestataDocumento> findByCodiceSoggettoCodiceOperatore(
		String codiceSoggetto, String operatore) throws SystemException {
		return findByCodiceSoggettoCodiceOperatore(codiceSoggetto, operatore,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the testata documentos where codiceSoggetto = &#63; and operatore = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param codiceSoggetto the codice soggetto
	 * @param operatore the operatore
	 * @param start the lower bound of the range of testata documentos
	 * @param end the upper bound of the range of testata documentos (not inclusive)
	 * @return the range of matching testata documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TestataDocumento> findByCodiceSoggettoCodiceOperatore(
		String codiceSoggetto, String operatore, int start, int end)
		throws SystemException {
		return findByCodiceSoggettoCodiceOperatore(codiceSoggetto, operatore,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the testata documentos where codiceSoggetto = &#63; and operatore = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param codiceSoggetto the codice soggetto
	 * @param operatore the operatore
	 * @param start the lower bound of the range of testata documentos
	 * @param end the upper bound of the range of testata documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching testata documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TestataDocumento> findByCodiceSoggettoCodiceOperatore(
		String codiceSoggetto, String operatore, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODICESOGGETTOCODICEOPERATORE;
			finderArgs = new Object[] { codiceSoggetto, operatore };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CODICESOGGETTOCODICEOPERATORE;
			finderArgs = new Object[] {
					codiceSoggetto, operatore,
					
					start, end, orderByComparator
				};
		}

		List<TestataDocumento> list = (List<TestataDocumento>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TestataDocumento testataDocumento : list) {
				if (!Validator.equals(codiceSoggetto,
							testataDocumento.getCodiceSoggetto()) ||
						!Validator.equals(operatore,
							testataDocumento.getOperatore())) {
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

			query.append(_SQL_SELECT_TESTATADOCUMENTO_WHERE);

			boolean bindCodiceSoggetto = false;

			if (codiceSoggetto == null) {
				query.append(_FINDER_COLUMN_CODICESOGGETTOCODICEOPERATORE_CODICESOGGETTO_1);
			}
			else if (codiceSoggetto.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODICESOGGETTOCODICEOPERATORE_CODICESOGGETTO_3);
			}
			else {
				bindCodiceSoggetto = true;

				query.append(_FINDER_COLUMN_CODICESOGGETTOCODICEOPERATORE_CODICESOGGETTO_2);
			}

			boolean bindOperatore = false;

			if (operatore == null) {
				query.append(_FINDER_COLUMN_CODICESOGGETTOCODICEOPERATORE_OPERATORE_1);
			}
			else if (operatore.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODICESOGGETTOCODICEOPERATORE_OPERATORE_3);
			}
			else {
				bindOperatore = true;

				query.append(_FINDER_COLUMN_CODICESOGGETTOCODICEOPERATORE_OPERATORE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TestataDocumentoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCodiceSoggetto) {
					qPos.add(codiceSoggetto);
				}

				if (bindOperatore) {
					qPos.add(operatore);
				}

				if (!pagination) {
					list = (List<TestataDocumento>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TestataDocumento>(list);
				}
				else {
					list = (List<TestataDocumento>)QueryUtil.list(q,
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
	 * Returns the first testata documento in the ordered set where codiceSoggetto = &#63; and operatore = &#63;.
	 *
	 * @param codiceSoggetto the codice soggetto
	 * @param operatore the operatore
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching testata documento
	 * @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a matching testata documento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestataDocumento findByCodiceSoggettoCodiceOperatore_First(
		String codiceSoggetto, String operatore,
		OrderByComparator orderByComparator)
		throws NoSuchTestataDocumentoException, SystemException {
		TestataDocumento testataDocumento = fetchByCodiceSoggettoCodiceOperatore_First(codiceSoggetto,
				operatore, orderByComparator);

		if (testataDocumento != null) {
			return testataDocumento;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("codiceSoggetto=");
		msg.append(codiceSoggetto);

		msg.append(", operatore=");
		msg.append(operatore);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTestataDocumentoException(msg.toString());
	}

	/**
	 * Returns the first testata documento in the ordered set where codiceSoggetto = &#63; and operatore = &#63;.
	 *
	 * @param codiceSoggetto the codice soggetto
	 * @param operatore the operatore
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching testata documento, or <code>null</code> if a matching testata documento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestataDocumento fetchByCodiceSoggettoCodiceOperatore_First(
		String codiceSoggetto, String operatore,
		OrderByComparator orderByComparator) throws SystemException {
		List<TestataDocumento> list = findByCodiceSoggettoCodiceOperatore(codiceSoggetto,
				operatore, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last testata documento in the ordered set where codiceSoggetto = &#63; and operatore = &#63;.
	 *
	 * @param codiceSoggetto the codice soggetto
	 * @param operatore the operatore
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching testata documento
	 * @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a matching testata documento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestataDocumento findByCodiceSoggettoCodiceOperatore_Last(
		String codiceSoggetto, String operatore,
		OrderByComparator orderByComparator)
		throws NoSuchTestataDocumentoException, SystemException {
		TestataDocumento testataDocumento = fetchByCodiceSoggettoCodiceOperatore_Last(codiceSoggetto,
				operatore, orderByComparator);

		if (testataDocumento != null) {
			return testataDocumento;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("codiceSoggetto=");
		msg.append(codiceSoggetto);

		msg.append(", operatore=");
		msg.append(operatore);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTestataDocumentoException(msg.toString());
	}

	/**
	 * Returns the last testata documento in the ordered set where codiceSoggetto = &#63; and operatore = &#63;.
	 *
	 * @param codiceSoggetto the codice soggetto
	 * @param operatore the operatore
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching testata documento, or <code>null</code> if a matching testata documento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestataDocumento fetchByCodiceSoggettoCodiceOperatore_Last(
		String codiceSoggetto, String operatore,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCodiceSoggettoCodiceOperatore(codiceSoggetto,
				operatore);

		if (count == 0) {
			return null;
		}

		List<TestataDocumento> list = findByCodiceSoggettoCodiceOperatore(codiceSoggetto,
				operatore, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the testata documentos before and after the current testata documento in the ordered set where codiceSoggetto = &#63; and operatore = &#63;.
	 *
	 * @param testataDocumentoPK the primary key of the current testata documento
	 * @param codiceSoggetto the codice soggetto
	 * @param operatore the operatore
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next testata documento
	 * @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a testata documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestataDocumento[] findByCodiceSoggettoCodiceOperatore_PrevAndNext(
		TestataDocumentoPK testataDocumentoPK, String codiceSoggetto,
		String operatore, OrderByComparator orderByComparator)
		throws NoSuchTestataDocumentoException, SystemException {
		TestataDocumento testataDocumento = findByPrimaryKey(testataDocumentoPK);

		Session session = null;

		try {
			session = openSession();

			TestataDocumento[] array = new TestataDocumentoImpl[3];

			array[0] = getByCodiceSoggettoCodiceOperatore_PrevAndNext(session,
					testataDocumento, codiceSoggetto, operatore,
					orderByComparator, true);

			array[1] = testataDocumento;

			array[2] = getByCodiceSoggettoCodiceOperatore_PrevAndNext(session,
					testataDocumento, codiceSoggetto, operatore,
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

	protected TestataDocumento getByCodiceSoggettoCodiceOperatore_PrevAndNext(
		Session session, TestataDocumento testataDocumento,
		String codiceSoggetto, String operatore,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TESTATADOCUMENTO_WHERE);

		boolean bindCodiceSoggetto = false;

		if (codiceSoggetto == null) {
			query.append(_FINDER_COLUMN_CODICESOGGETTOCODICEOPERATORE_CODICESOGGETTO_1);
		}
		else if (codiceSoggetto.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CODICESOGGETTOCODICEOPERATORE_CODICESOGGETTO_3);
		}
		else {
			bindCodiceSoggetto = true;

			query.append(_FINDER_COLUMN_CODICESOGGETTOCODICEOPERATORE_CODICESOGGETTO_2);
		}

		boolean bindOperatore = false;

		if (operatore == null) {
			query.append(_FINDER_COLUMN_CODICESOGGETTOCODICEOPERATORE_OPERATORE_1);
		}
		else if (operatore.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CODICESOGGETTOCODICEOPERATORE_OPERATORE_3);
		}
		else {
			bindOperatore = true;

			query.append(_FINDER_COLUMN_CODICESOGGETTOCODICEOPERATORE_OPERATORE_2);
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
			query.append(TestataDocumentoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCodiceSoggetto) {
			qPos.add(codiceSoggetto);
		}

		if (bindOperatore) {
			qPos.add(operatore);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(testataDocumento);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TestataDocumento> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the testata documentos where codiceSoggetto = &#63; and operatore = &#63; from the database.
	 *
	 * @param codiceSoggetto the codice soggetto
	 * @param operatore the operatore
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCodiceSoggettoCodiceOperatore(String codiceSoggetto,
		String operatore) throws SystemException {
		for (TestataDocumento testataDocumento : findByCodiceSoggettoCodiceOperatore(
				codiceSoggetto, operatore, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(testataDocumento);
		}
	}

	/**
	 * Returns the number of testata documentos where codiceSoggetto = &#63; and operatore = &#63;.
	 *
	 * @param codiceSoggetto the codice soggetto
	 * @param operatore the operatore
	 * @return the number of matching testata documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCodiceSoggettoCodiceOperatore(String codiceSoggetto,
		String operatore) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CODICESOGGETTOCODICEOPERATORE;

		Object[] finderArgs = new Object[] { codiceSoggetto, operatore };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TESTATADOCUMENTO_WHERE);

			boolean bindCodiceSoggetto = false;

			if (codiceSoggetto == null) {
				query.append(_FINDER_COLUMN_CODICESOGGETTOCODICEOPERATORE_CODICESOGGETTO_1);
			}
			else if (codiceSoggetto.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODICESOGGETTOCODICEOPERATORE_CODICESOGGETTO_3);
			}
			else {
				bindCodiceSoggetto = true;

				query.append(_FINDER_COLUMN_CODICESOGGETTOCODICEOPERATORE_CODICESOGGETTO_2);
			}

			boolean bindOperatore = false;

			if (operatore == null) {
				query.append(_FINDER_COLUMN_CODICESOGGETTOCODICEOPERATORE_OPERATORE_1);
			}
			else if (operatore.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODICESOGGETTOCODICEOPERATORE_OPERATORE_3);
			}
			else {
				bindOperatore = true;

				query.append(_FINDER_COLUMN_CODICESOGGETTOCODICEOPERATORE_OPERATORE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCodiceSoggetto) {
					qPos.add(codiceSoggetto);
				}

				if (bindOperatore) {
					qPos.add(operatore);
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

	private static final String _FINDER_COLUMN_CODICESOGGETTOCODICEOPERATORE_CODICESOGGETTO_1 =
		"testataDocumento.codiceSoggetto IS NULL AND ";
	private static final String _FINDER_COLUMN_CODICESOGGETTOCODICEOPERATORE_CODICESOGGETTO_2 =
		"testataDocumento.codiceSoggetto = ? AND ";
	private static final String _FINDER_COLUMN_CODICESOGGETTOCODICEOPERATORE_CODICESOGGETTO_3 =
		"(testataDocumento.codiceSoggetto IS NULL OR testataDocumento.codiceSoggetto = '') AND ";
	private static final String _FINDER_COLUMN_CODICESOGGETTOCODICEOPERATORE_OPERATORE_1 =
		"testataDocumento.operatore IS NULL";
	private static final String _FINDER_COLUMN_CODICESOGGETTOCODICEOPERATORE_OPERATORE_2 =
		"testataDocumento.operatore = ?";
	private static final String _FINDER_COLUMN_CODICESOGGETTOCODICEOPERATORE_OPERATORE_3 =
		"(testataDocumento.operatore IS NULL OR testataDocumento.operatore = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OPERATORECOMPLETOINVIATO =
		new FinderPath(TestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			TestataDocumentoModelImpl.FINDER_CACHE_ENABLED,
			TestataDocumentoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByoperatoreCompletoInviato",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_OPERATORECOMPLETOINVIATO =
		new FinderPath(TestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			TestataDocumentoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByoperatoreCompletoInviato",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), String.class.getName()
			});

	/**
	 * Returns all the testata documentos where operatore = &#63; and completo = &#63; and inviato = &#63; and tipoDocumento &ne; &#63;.
	 *
	 * @param operatore the operatore
	 * @param completo the completo
	 * @param inviato the inviato
	 * @param tipoDocumento the tipo documento
	 * @return the matching testata documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TestataDocumento> findByoperatoreCompletoInviato(
		String operatore, String completo, int inviato, String tipoDocumento)
		throws SystemException {
		return findByoperatoreCompletoInviato(operatore, completo, inviato,
			tipoDocumento, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the testata documentos where operatore = &#63; and completo = &#63; and inviato = &#63; and tipoDocumento &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param operatore the operatore
	 * @param completo the completo
	 * @param inviato the inviato
	 * @param tipoDocumento the tipo documento
	 * @param start the lower bound of the range of testata documentos
	 * @param end the upper bound of the range of testata documentos (not inclusive)
	 * @return the range of matching testata documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TestataDocumento> findByoperatoreCompletoInviato(
		String operatore, String completo, int inviato, String tipoDocumento,
		int start, int end) throws SystemException {
		return findByoperatoreCompletoInviato(operatore, completo, inviato,
			tipoDocumento, start, end, null);
	}

	/**
	 * Returns an ordered range of all the testata documentos where operatore = &#63; and completo = &#63; and inviato = &#63; and tipoDocumento &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param operatore the operatore
	 * @param completo the completo
	 * @param inviato the inviato
	 * @param tipoDocumento the tipo documento
	 * @param start the lower bound of the range of testata documentos
	 * @param end the upper bound of the range of testata documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching testata documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TestataDocumento> findByoperatoreCompletoInviato(
		String operatore, String completo, int inviato, String tipoDocumento,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OPERATORECOMPLETOINVIATO;
		finderArgs = new Object[] {
				operatore, completo, inviato, tipoDocumento,
				
				start, end, orderByComparator
			};

		List<TestataDocumento> list = (List<TestataDocumento>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TestataDocumento testataDocumento : list) {
				if (!Validator.equals(operatore, testataDocumento.getOperatore()) ||
						!Validator.equals(completo,
							testataDocumento.getCompleto()) ||
						(inviato != testataDocumento.getInviato()) ||
						Validator.equals(tipoDocumento,
							testataDocumento.getTipoDocumento())) {
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

			query.append(_SQL_SELECT_TESTATADOCUMENTO_WHERE);

			boolean bindOperatore = false;

			if (operatore == null) {
				query.append(_FINDER_COLUMN_OPERATORECOMPLETOINVIATO_OPERATORE_1);
			}
			else if (operatore.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OPERATORECOMPLETOINVIATO_OPERATORE_3);
			}
			else {
				bindOperatore = true;

				query.append(_FINDER_COLUMN_OPERATORECOMPLETOINVIATO_OPERATORE_2);
			}

			boolean bindCompleto = false;

			if (completo == null) {
				query.append(_FINDER_COLUMN_OPERATORECOMPLETOINVIATO_COMPLETO_1);
			}
			else if (completo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OPERATORECOMPLETOINVIATO_COMPLETO_3);
			}
			else {
				bindCompleto = true;

				query.append(_FINDER_COLUMN_OPERATORECOMPLETOINVIATO_COMPLETO_2);
			}

			query.append(_FINDER_COLUMN_OPERATORECOMPLETOINVIATO_INVIATO_2);

			boolean bindTipoDocumento = false;

			if (tipoDocumento == null) {
				query.append(_FINDER_COLUMN_OPERATORECOMPLETOINVIATO_TIPODOCUMENTO_1);
			}
			else if (tipoDocumento.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OPERATORECOMPLETOINVIATO_TIPODOCUMENTO_3);
			}
			else {
				bindTipoDocumento = true;

				query.append(_FINDER_COLUMN_OPERATORECOMPLETOINVIATO_TIPODOCUMENTO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TestataDocumentoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOperatore) {
					qPos.add(operatore);
				}

				if (bindCompleto) {
					qPos.add(completo);
				}

				qPos.add(inviato);

				if (bindTipoDocumento) {
					qPos.add(tipoDocumento);
				}

				if (!pagination) {
					list = (List<TestataDocumento>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TestataDocumento>(list);
				}
				else {
					list = (List<TestataDocumento>)QueryUtil.list(q,
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
	 * Returns the first testata documento in the ordered set where operatore = &#63; and completo = &#63; and inviato = &#63; and tipoDocumento &ne; &#63;.
	 *
	 * @param operatore the operatore
	 * @param completo the completo
	 * @param inviato the inviato
	 * @param tipoDocumento the tipo documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching testata documento
	 * @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a matching testata documento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestataDocumento findByoperatoreCompletoInviato_First(
		String operatore, String completo, int inviato, String tipoDocumento,
		OrderByComparator orderByComparator)
		throws NoSuchTestataDocumentoException, SystemException {
		TestataDocumento testataDocumento = fetchByoperatoreCompletoInviato_First(operatore,
				completo, inviato, tipoDocumento, orderByComparator);

		if (testataDocumento != null) {
			return testataDocumento;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("operatore=");
		msg.append(operatore);

		msg.append(", completo=");
		msg.append(completo);

		msg.append(", inviato=");
		msg.append(inviato);

		msg.append(", tipoDocumento=");
		msg.append(tipoDocumento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTestataDocumentoException(msg.toString());
	}

	/**
	 * Returns the first testata documento in the ordered set where operatore = &#63; and completo = &#63; and inviato = &#63; and tipoDocumento &ne; &#63;.
	 *
	 * @param operatore the operatore
	 * @param completo the completo
	 * @param inviato the inviato
	 * @param tipoDocumento the tipo documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching testata documento, or <code>null</code> if a matching testata documento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestataDocumento fetchByoperatoreCompletoInviato_First(
		String operatore, String completo, int inviato, String tipoDocumento,
		OrderByComparator orderByComparator) throws SystemException {
		List<TestataDocumento> list = findByoperatoreCompletoInviato(operatore,
				completo, inviato, tipoDocumento, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last testata documento in the ordered set where operatore = &#63; and completo = &#63; and inviato = &#63; and tipoDocumento &ne; &#63;.
	 *
	 * @param operatore the operatore
	 * @param completo the completo
	 * @param inviato the inviato
	 * @param tipoDocumento the tipo documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching testata documento
	 * @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a matching testata documento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestataDocumento findByoperatoreCompletoInviato_Last(
		String operatore, String completo, int inviato, String tipoDocumento,
		OrderByComparator orderByComparator)
		throws NoSuchTestataDocumentoException, SystemException {
		TestataDocumento testataDocumento = fetchByoperatoreCompletoInviato_Last(operatore,
				completo, inviato, tipoDocumento, orderByComparator);

		if (testataDocumento != null) {
			return testataDocumento;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("operatore=");
		msg.append(operatore);

		msg.append(", completo=");
		msg.append(completo);

		msg.append(", inviato=");
		msg.append(inviato);

		msg.append(", tipoDocumento=");
		msg.append(tipoDocumento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTestataDocumentoException(msg.toString());
	}

	/**
	 * Returns the last testata documento in the ordered set where operatore = &#63; and completo = &#63; and inviato = &#63; and tipoDocumento &ne; &#63;.
	 *
	 * @param operatore the operatore
	 * @param completo the completo
	 * @param inviato the inviato
	 * @param tipoDocumento the tipo documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching testata documento, or <code>null</code> if a matching testata documento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestataDocumento fetchByoperatoreCompletoInviato_Last(
		String operatore, String completo, int inviato, String tipoDocumento,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByoperatoreCompletoInviato(operatore, completo,
				inviato, tipoDocumento);

		if (count == 0) {
			return null;
		}

		List<TestataDocumento> list = findByoperatoreCompletoInviato(operatore,
				completo, inviato, tipoDocumento, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the testata documentos before and after the current testata documento in the ordered set where operatore = &#63; and completo = &#63; and inviato = &#63; and tipoDocumento &ne; &#63;.
	 *
	 * @param testataDocumentoPK the primary key of the current testata documento
	 * @param operatore the operatore
	 * @param completo the completo
	 * @param inviato the inviato
	 * @param tipoDocumento the tipo documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next testata documento
	 * @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a testata documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestataDocumento[] findByoperatoreCompletoInviato_PrevAndNext(
		TestataDocumentoPK testataDocumentoPK, String operatore,
		String completo, int inviato, String tipoDocumento,
		OrderByComparator orderByComparator)
		throws NoSuchTestataDocumentoException, SystemException {
		TestataDocumento testataDocumento = findByPrimaryKey(testataDocumentoPK);

		Session session = null;

		try {
			session = openSession();

			TestataDocumento[] array = new TestataDocumentoImpl[3];

			array[0] = getByoperatoreCompletoInviato_PrevAndNext(session,
					testataDocumento, operatore, completo, inviato,
					tipoDocumento, orderByComparator, true);

			array[1] = testataDocumento;

			array[2] = getByoperatoreCompletoInviato_PrevAndNext(session,
					testataDocumento, operatore, completo, inviato,
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

	protected TestataDocumento getByoperatoreCompletoInviato_PrevAndNext(
		Session session, TestataDocumento testataDocumento, String operatore,
		String completo, int inviato, String tipoDocumento,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TESTATADOCUMENTO_WHERE);

		boolean bindOperatore = false;

		if (operatore == null) {
			query.append(_FINDER_COLUMN_OPERATORECOMPLETOINVIATO_OPERATORE_1);
		}
		else if (operatore.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_OPERATORECOMPLETOINVIATO_OPERATORE_3);
		}
		else {
			bindOperatore = true;

			query.append(_FINDER_COLUMN_OPERATORECOMPLETOINVIATO_OPERATORE_2);
		}

		boolean bindCompleto = false;

		if (completo == null) {
			query.append(_FINDER_COLUMN_OPERATORECOMPLETOINVIATO_COMPLETO_1);
		}
		else if (completo.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_OPERATORECOMPLETOINVIATO_COMPLETO_3);
		}
		else {
			bindCompleto = true;

			query.append(_FINDER_COLUMN_OPERATORECOMPLETOINVIATO_COMPLETO_2);
		}

		query.append(_FINDER_COLUMN_OPERATORECOMPLETOINVIATO_INVIATO_2);

		boolean bindTipoDocumento = false;

		if (tipoDocumento == null) {
			query.append(_FINDER_COLUMN_OPERATORECOMPLETOINVIATO_TIPODOCUMENTO_1);
		}
		else if (tipoDocumento.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_OPERATORECOMPLETOINVIATO_TIPODOCUMENTO_3);
		}
		else {
			bindTipoDocumento = true;

			query.append(_FINDER_COLUMN_OPERATORECOMPLETOINVIATO_TIPODOCUMENTO_2);
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
			query.append(TestataDocumentoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindOperatore) {
			qPos.add(operatore);
		}

		if (bindCompleto) {
			qPos.add(completo);
		}

		qPos.add(inviato);

		if (bindTipoDocumento) {
			qPos.add(tipoDocumento);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(testataDocumento);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TestataDocumento> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the testata documentos where operatore = &#63; and completo = &#63; and inviato = &#63; and tipoDocumento &ne; &#63; from the database.
	 *
	 * @param operatore the operatore
	 * @param completo the completo
	 * @param inviato the inviato
	 * @param tipoDocumento the tipo documento
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByoperatoreCompletoInviato(String operatore,
		String completo, int inviato, String tipoDocumento)
		throws SystemException {
		for (TestataDocumento testataDocumento : findByoperatoreCompletoInviato(
				operatore, completo, inviato, tipoDocumento, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(testataDocumento);
		}
	}

	/**
	 * Returns the number of testata documentos where operatore = &#63; and completo = &#63; and inviato = &#63; and tipoDocumento &ne; &#63;.
	 *
	 * @param operatore the operatore
	 * @param completo the completo
	 * @param inviato the inviato
	 * @param tipoDocumento the tipo documento
	 * @return the number of matching testata documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByoperatoreCompletoInviato(String operatore,
		String completo, int inviato, String tipoDocumento)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_OPERATORECOMPLETOINVIATO;

		Object[] finderArgs = new Object[] {
				operatore, completo, inviato, tipoDocumento
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_TESTATADOCUMENTO_WHERE);

			boolean bindOperatore = false;

			if (operatore == null) {
				query.append(_FINDER_COLUMN_OPERATORECOMPLETOINVIATO_OPERATORE_1);
			}
			else if (operatore.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OPERATORECOMPLETOINVIATO_OPERATORE_3);
			}
			else {
				bindOperatore = true;

				query.append(_FINDER_COLUMN_OPERATORECOMPLETOINVIATO_OPERATORE_2);
			}

			boolean bindCompleto = false;

			if (completo == null) {
				query.append(_FINDER_COLUMN_OPERATORECOMPLETOINVIATO_COMPLETO_1);
			}
			else if (completo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OPERATORECOMPLETOINVIATO_COMPLETO_3);
			}
			else {
				bindCompleto = true;

				query.append(_FINDER_COLUMN_OPERATORECOMPLETOINVIATO_COMPLETO_2);
			}

			query.append(_FINDER_COLUMN_OPERATORECOMPLETOINVIATO_INVIATO_2);

			boolean bindTipoDocumento = false;

			if (tipoDocumento == null) {
				query.append(_FINDER_COLUMN_OPERATORECOMPLETOINVIATO_TIPODOCUMENTO_1);
			}
			else if (tipoDocumento.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OPERATORECOMPLETOINVIATO_TIPODOCUMENTO_3);
			}
			else {
				bindTipoDocumento = true;

				query.append(_FINDER_COLUMN_OPERATORECOMPLETOINVIATO_TIPODOCUMENTO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOperatore) {
					qPos.add(operatore);
				}

				if (bindCompleto) {
					qPos.add(completo);
				}

				qPos.add(inviato);

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

	private static final String _FINDER_COLUMN_OPERATORECOMPLETOINVIATO_OPERATORE_1 =
		"testataDocumento.operatore IS NULL AND ";
	private static final String _FINDER_COLUMN_OPERATORECOMPLETOINVIATO_OPERATORE_2 =
		"testataDocumento.operatore = ? AND ";
	private static final String _FINDER_COLUMN_OPERATORECOMPLETOINVIATO_OPERATORE_3 =
		"(testataDocumento.operatore IS NULL OR testataDocumento.operatore = '') AND ";
	private static final String _FINDER_COLUMN_OPERATORECOMPLETOINVIATO_COMPLETO_1 =
		"testataDocumento.completo IS NULL AND ";
	private static final String _FINDER_COLUMN_OPERATORECOMPLETOINVIATO_COMPLETO_2 =
		"testataDocumento.completo = ? AND ";
	private static final String _FINDER_COLUMN_OPERATORECOMPLETOINVIATO_COMPLETO_3 =
		"(testataDocumento.completo IS NULL OR testataDocumento.completo = '') AND ";
	private static final String _FINDER_COLUMN_OPERATORECOMPLETOINVIATO_INVIATO_2 =
		"testataDocumento.inviato = ? AND ";
	private static final String _FINDER_COLUMN_OPERATORECOMPLETOINVIATO_TIPODOCUMENTO_1 =
		"testataDocumento.id.tipoDocumento IS NOT NULL";
	private static final String _FINDER_COLUMN_OPERATORECOMPLETOINVIATO_TIPODOCUMENTO_2 =
		"testataDocumento.id.tipoDocumento != ?";
	private static final String _FINDER_COLUMN_OPERATORECOMPLETOINVIATO_TIPODOCUMENTO_3 =
		"(testataDocumento.id.tipoDocumento IS NULL OR testataDocumento.id.tipoDocumento != '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ANNOTIPODOCUMENTOIDASSOCIATO =
		new FinderPath(TestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			TestataDocumentoModelImpl.FINDER_CACHE_ENABLED,
			TestataDocumentoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByannoTipoDocumentoIdAssociato",
			new String[] {
				Integer.class.getName(), String.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANNOTIPODOCUMENTOIDASSOCIATO =
		new FinderPath(TestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			TestataDocumentoModelImpl.FINDER_CACHE_ENABLED,
			TestataDocumentoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByannoTipoDocumentoIdAssociato",
			new String[] {
				Integer.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			TestataDocumentoModelImpl.ANNO_COLUMN_BITMASK |
			TestataDocumentoModelImpl.TIPODOCUMENTO_COLUMN_BITMASK |
			TestataDocumentoModelImpl.IDASSOCIATO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ANNOTIPODOCUMENTOIDASSOCIATO =
		new FinderPath(TestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			TestataDocumentoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByannoTipoDocumentoIdAssociato",
			new String[] {
				Integer.class.getName(), String.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the testata documentos where anno = &#63; and tipoDocumento = &#63; and idAssociato = &#63;.
	 *
	 * @param anno the anno
	 * @param tipoDocumento the tipo documento
	 * @param idAssociato the id associato
	 * @return the matching testata documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TestataDocumento> findByannoTipoDocumentoIdAssociato(int anno,
		String tipoDocumento, long idAssociato) throws SystemException {
		return findByannoTipoDocumentoIdAssociato(anno, tipoDocumento,
			idAssociato, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the testata documentos where anno = &#63; and tipoDocumento = &#63; and idAssociato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param anno the anno
	 * @param tipoDocumento the tipo documento
	 * @param idAssociato the id associato
	 * @param start the lower bound of the range of testata documentos
	 * @param end the upper bound of the range of testata documentos (not inclusive)
	 * @return the range of matching testata documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TestataDocumento> findByannoTipoDocumentoIdAssociato(int anno,
		String tipoDocumento, long idAssociato, int start, int end)
		throws SystemException {
		return findByannoTipoDocumentoIdAssociato(anno, tipoDocumento,
			idAssociato, start, end, null);
	}

	/**
	 * Returns an ordered range of all the testata documentos where anno = &#63; and tipoDocumento = &#63; and idAssociato = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param anno the anno
	 * @param tipoDocumento the tipo documento
	 * @param idAssociato the id associato
	 * @param start the lower bound of the range of testata documentos
	 * @param end the upper bound of the range of testata documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching testata documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TestataDocumento> findByannoTipoDocumentoIdAssociato(int anno,
		String tipoDocumento, long idAssociato, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANNOTIPODOCUMENTOIDASSOCIATO;
			finderArgs = new Object[] { anno, tipoDocumento, idAssociato };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ANNOTIPODOCUMENTOIDASSOCIATO;
			finderArgs = new Object[] {
					anno, tipoDocumento, idAssociato,
					
					start, end, orderByComparator
				};
		}

		List<TestataDocumento> list = (List<TestataDocumento>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TestataDocumento testataDocumento : list) {
				if ((anno != testataDocumento.getAnno()) ||
						!Validator.equals(tipoDocumento,
							testataDocumento.getTipoDocumento()) ||
						(idAssociato != testataDocumento.getIdAssociato())) {
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

			query.append(_SQL_SELECT_TESTATADOCUMENTO_WHERE);

			query.append(_FINDER_COLUMN_ANNOTIPODOCUMENTOIDASSOCIATO_ANNO_2);

			boolean bindTipoDocumento = false;

			if (tipoDocumento == null) {
				query.append(_FINDER_COLUMN_ANNOTIPODOCUMENTOIDASSOCIATO_TIPODOCUMENTO_1);
			}
			else if (tipoDocumento.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ANNOTIPODOCUMENTOIDASSOCIATO_TIPODOCUMENTO_3);
			}
			else {
				bindTipoDocumento = true;

				query.append(_FINDER_COLUMN_ANNOTIPODOCUMENTOIDASSOCIATO_TIPODOCUMENTO_2);
			}

			query.append(_FINDER_COLUMN_ANNOTIPODOCUMENTOIDASSOCIATO_IDASSOCIATO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TestataDocumentoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(anno);

				if (bindTipoDocumento) {
					qPos.add(tipoDocumento);
				}

				qPos.add(idAssociato);

				if (!pagination) {
					list = (List<TestataDocumento>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TestataDocumento>(list);
				}
				else {
					list = (List<TestataDocumento>)QueryUtil.list(q,
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
	 * Returns the first testata documento in the ordered set where anno = &#63; and tipoDocumento = &#63; and idAssociato = &#63;.
	 *
	 * @param anno the anno
	 * @param tipoDocumento the tipo documento
	 * @param idAssociato the id associato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching testata documento
	 * @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a matching testata documento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestataDocumento findByannoTipoDocumentoIdAssociato_First(int anno,
		String tipoDocumento, long idAssociato,
		OrderByComparator orderByComparator)
		throws NoSuchTestataDocumentoException, SystemException {
		TestataDocumento testataDocumento = fetchByannoTipoDocumentoIdAssociato_First(anno,
				tipoDocumento, idAssociato, orderByComparator);

		if (testataDocumento != null) {
			return testataDocumento;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("anno=");
		msg.append(anno);

		msg.append(", tipoDocumento=");
		msg.append(tipoDocumento);

		msg.append(", idAssociato=");
		msg.append(idAssociato);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTestataDocumentoException(msg.toString());
	}

	/**
	 * Returns the first testata documento in the ordered set where anno = &#63; and tipoDocumento = &#63; and idAssociato = &#63;.
	 *
	 * @param anno the anno
	 * @param tipoDocumento the tipo documento
	 * @param idAssociato the id associato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching testata documento, or <code>null</code> if a matching testata documento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestataDocumento fetchByannoTipoDocumentoIdAssociato_First(
		int anno, String tipoDocumento, long idAssociato,
		OrderByComparator orderByComparator) throws SystemException {
		List<TestataDocumento> list = findByannoTipoDocumentoIdAssociato(anno,
				tipoDocumento, idAssociato, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last testata documento in the ordered set where anno = &#63; and tipoDocumento = &#63; and idAssociato = &#63;.
	 *
	 * @param anno the anno
	 * @param tipoDocumento the tipo documento
	 * @param idAssociato the id associato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching testata documento
	 * @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a matching testata documento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestataDocumento findByannoTipoDocumentoIdAssociato_Last(int anno,
		String tipoDocumento, long idAssociato,
		OrderByComparator orderByComparator)
		throws NoSuchTestataDocumentoException, SystemException {
		TestataDocumento testataDocumento = fetchByannoTipoDocumentoIdAssociato_Last(anno,
				tipoDocumento, idAssociato, orderByComparator);

		if (testataDocumento != null) {
			return testataDocumento;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("anno=");
		msg.append(anno);

		msg.append(", tipoDocumento=");
		msg.append(tipoDocumento);

		msg.append(", idAssociato=");
		msg.append(idAssociato);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTestataDocumentoException(msg.toString());
	}

	/**
	 * Returns the last testata documento in the ordered set where anno = &#63; and tipoDocumento = &#63; and idAssociato = &#63;.
	 *
	 * @param anno the anno
	 * @param tipoDocumento the tipo documento
	 * @param idAssociato the id associato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching testata documento, or <code>null</code> if a matching testata documento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestataDocumento fetchByannoTipoDocumentoIdAssociato_Last(int anno,
		String tipoDocumento, long idAssociato,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByannoTipoDocumentoIdAssociato(anno, tipoDocumento,
				idAssociato);

		if (count == 0) {
			return null;
		}

		List<TestataDocumento> list = findByannoTipoDocumentoIdAssociato(anno,
				tipoDocumento, idAssociato, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the testata documentos before and after the current testata documento in the ordered set where anno = &#63; and tipoDocumento = &#63; and idAssociato = &#63;.
	 *
	 * @param testataDocumentoPK the primary key of the current testata documento
	 * @param anno the anno
	 * @param tipoDocumento the tipo documento
	 * @param idAssociato the id associato
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next testata documento
	 * @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a testata documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestataDocumento[] findByannoTipoDocumentoIdAssociato_PrevAndNext(
		TestataDocumentoPK testataDocumentoPK, int anno, String tipoDocumento,
		long idAssociato, OrderByComparator orderByComparator)
		throws NoSuchTestataDocumentoException, SystemException {
		TestataDocumento testataDocumento = findByPrimaryKey(testataDocumentoPK);

		Session session = null;

		try {
			session = openSession();

			TestataDocumento[] array = new TestataDocumentoImpl[3];

			array[0] = getByannoTipoDocumentoIdAssociato_PrevAndNext(session,
					testataDocumento, anno, tipoDocumento, idAssociato,
					orderByComparator, true);

			array[1] = testataDocumento;

			array[2] = getByannoTipoDocumentoIdAssociato_PrevAndNext(session,
					testataDocumento, anno, tipoDocumento, idAssociato,
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

	protected TestataDocumento getByannoTipoDocumentoIdAssociato_PrevAndNext(
		Session session, TestataDocumento testataDocumento, int anno,
		String tipoDocumento, long idAssociato,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TESTATADOCUMENTO_WHERE);

		query.append(_FINDER_COLUMN_ANNOTIPODOCUMENTOIDASSOCIATO_ANNO_2);

		boolean bindTipoDocumento = false;

		if (tipoDocumento == null) {
			query.append(_FINDER_COLUMN_ANNOTIPODOCUMENTOIDASSOCIATO_TIPODOCUMENTO_1);
		}
		else if (tipoDocumento.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ANNOTIPODOCUMENTOIDASSOCIATO_TIPODOCUMENTO_3);
		}
		else {
			bindTipoDocumento = true;

			query.append(_FINDER_COLUMN_ANNOTIPODOCUMENTOIDASSOCIATO_TIPODOCUMENTO_2);
		}

		query.append(_FINDER_COLUMN_ANNOTIPODOCUMENTOIDASSOCIATO_IDASSOCIATO_2);

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
			query.append(TestataDocumentoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(anno);

		if (bindTipoDocumento) {
			qPos.add(tipoDocumento);
		}

		qPos.add(idAssociato);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(testataDocumento);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TestataDocumento> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the testata documentos where anno = &#63; and tipoDocumento = &#63; and idAssociato = &#63; from the database.
	 *
	 * @param anno the anno
	 * @param tipoDocumento the tipo documento
	 * @param idAssociato the id associato
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByannoTipoDocumentoIdAssociato(int anno,
		String tipoDocumento, long idAssociato) throws SystemException {
		for (TestataDocumento testataDocumento : findByannoTipoDocumentoIdAssociato(
				anno, tipoDocumento, idAssociato, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(testataDocumento);
		}
	}

	/**
	 * Returns the number of testata documentos where anno = &#63; and tipoDocumento = &#63; and idAssociato = &#63;.
	 *
	 * @param anno the anno
	 * @param tipoDocumento the tipo documento
	 * @param idAssociato the id associato
	 * @return the number of matching testata documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByannoTipoDocumentoIdAssociato(int anno,
		String tipoDocumento, long idAssociato) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ANNOTIPODOCUMENTOIDASSOCIATO;

		Object[] finderArgs = new Object[] { anno, tipoDocumento, idAssociato };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TESTATADOCUMENTO_WHERE);

			query.append(_FINDER_COLUMN_ANNOTIPODOCUMENTOIDASSOCIATO_ANNO_2);

			boolean bindTipoDocumento = false;

			if (tipoDocumento == null) {
				query.append(_FINDER_COLUMN_ANNOTIPODOCUMENTOIDASSOCIATO_TIPODOCUMENTO_1);
			}
			else if (tipoDocumento.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ANNOTIPODOCUMENTOIDASSOCIATO_TIPODOCUMENTO_3);
			}
			else {
				bindTipoDocumento = true;

				query.append(_FINDER_COLUMN_ANNOTIPODOCUMENTOIDASSOCIATO_TIPODOCUMENTO_2);
			}

			query.append(_FINDER_COLUMN_ANNOTIPODOCUMENTOIDASSOCIATO_IDASSOCIATO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(anno);

				if (bindTipoDocumento) {
					qPos.add(tipoDocumento);
				}

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

	private static final String _FINDER_COLUMN_ANNOTIPODOCUMENTOIDASSOCIATO_ANNO_2 =
		"testataDocumento.id.anno = ? AND ";
	private static final String _FINDER_COLUMN_ANNOTIPODOCUMENTOIDASSOCIATO_TIPODOCUMENTO_1 =
		"testataDocumento.id.tipoDocumento IS NULL AND ";
	private static final String _FINDER_COLUMN_ANNOTIPODOCUMENTOIDASSOCIATO_TIPODOCUMENTO_2 =
		"testataDocumento.id.tipoDocumento = ? AND ";
	private static final String _FINDER_COLUMN_ANNOTIPODOCUMENTOIDASSOCIATO_TIPODOCUMENTO_3 =
		"(testataDocumento.id.tipoDocumento IS NULL OR testataDocumento.id.tipoDocumento = '') AND ";
	private static final String _FINDER_COLUMN_ANNOTIPODOCUMENTOIDASSOCIATO_IDASSOCIATO_2 =
		"testataDocumento.id.idAssociato = ?";

	public TestataDocumentoPersistenceImpl() {
		setModelClass(TestataDocumento.class);
	}

	/**
	 * Caches the testata documento in the entity cache if it is enabled.
	 *
	 * @param testataDocumento the testata documento
	 */
	@Override
	public void cacheResult(TestataDocumento testataDocumento) {
		EntityCacheUtil.putResult(TestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			TestataDocumentoImpl.class, testataDocumento.getPrimaryKey(),
			testataDocumento);

		testataDocumento.resetOriginalValues();
	}

	/**
	 * Caches the testata documentos in the entity cache if it is enabled.
	 *
	 * @param testataDocumentos the testata documentos
	 */
	@Override
	public void cacheResult(List<TestataDocumento> testataDocumentos) {
		for (TestataDocumento testataDocumento : testataDocumentos) {
			if (EntityCacheUtil.getResult(
						TestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
						TestataDocumentoImpl.class,
						testataDocumento.getPrimaryKey()) == null) {
				cacheResult(testataDocumento);
			}
			else {
				testataDocumento.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all testata documentos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TestataDocumentoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TestataDocumentoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the testata documento.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TestataDocumento testataDocumento) {
		EntityCacheUtil.removeResult(TestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			TestataDocumentoImpl.class, testataDocumento.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TestataDocumento> testataDocumentos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TestataDocumento testataDocumento : testataDocumentos) {
			EntityCacheUtil.removeResult(TestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
				TestataDocumentoImpl.class, testataDocumento.getPrimaryKey());
		}
	}

	/**
	 * Creates a new testata documento with the primary key. Does not add the testata documento to the database.
	 *
	 * @param testataDocumentoPK the primary key for the new testata documento
	 * @return the new testata documento
	 */
	@Override
	public TestataDocumento create(TestataDocumentoPK testataDocumentoPK) {
		TestataDocumento testataDocumento = new TestataDocumentoImpl();

		testataDocumento.setNew(true);
		testataDocumento.setPrimaryKey(testataDocumentoPK);

		return testataDocumento;
	}

	/**
	 * Removes the testata documento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param testataDocumentoPK the primary key of the testata documento
	 * @return the testata documento that was removed
	 * @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a testata documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestataDocumento remove(TestataDocumentoPK testataDocumentoPK)
		throws NoSuchTestataDocumentoException, SystemException {
		return remove((Serializable)testataDocumentoPK);
	}

	/**
	 * Removes the testata documento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the testata documento
	 * @return the testata documento that was removed
	 * @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a testata documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestataDocumento remove(Serializable primaryKey)
		throws NoSuchTestataDocumentoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TestataDocumento testataDocumento = (TestataDocumento)session.get(TestataDocumentoImpl.class,
					primaryKey);

			if (testataDocumento == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTestataDocumentoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(testataDocumento);
		}
		catch (NoSuchTestataDocumentoException nsee) {
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
	protected TestataDocumento removeImpl(TestataDocumento testataDocumento)
		throws SystemException {
		testataDocumento = toUnwrappedModel(testataDocumento);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(testataDocumento)) {
				testataDocumento = (TestataDocumento)session.get(TestataDocumentoImpl.class,
						testataDocumento.getPrimaryKeyObj());
			}

			if (testataDocumento != null) {
				session.delete(testataDocumento);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (testataDocumento != null) {
			clearCache(testataDocumento);
		}

		return testataDocumento;
	}

	@Override
	public TestataDocumento updateImpl(
		it.bysoftware.ct.model.TestataDocumento testataDocumento)
		throws SystemException {
		testataDocumento = toUnwrappedModel(testataDocumento);

		boolean isNew = testataDocumento.isNew();

		TestataDocumentoModelImpl testataDocumentoModelImpl = (TestataDocumentoModelImpl)testataDocumento;

		Session session = null;

		try {
			session = openSession();

			if (testataDocumento.isNew()) {
				session.save(testataDocumento);

				testataDocumento.setNew(false);
			}
			else {
				session.merge(testataDocumento);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TestataDocumentoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((testataDocumentoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPERATORE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						testataDocumentoModelImpl.getOriginalOperatore()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OPERATORE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPERATORE,
					args);

				args = new Object[] { testataDocumentoModelImpl.getOperatore() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OPERATORE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPERATORE,
					args);
			}

			if ((testataDocumentoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODICESOGGETTOCODICEOPERATORE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						testataDocumentoModelImpl.getOriginalCodiceSoggetto(),
						testataDocumentoModelImpl.getOriginalOperatore()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODICESOGGETTOCODICEOPERATORE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODICESOGGETTOCODICEOPERATORE,
					args);

				args = new Object[] {
						testataDocumentoModelImpl.getCodiceSoggetto(),
						testataDocumentoModelImpl.getOperatore()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODICESOGGETTOCODICEOPERATORE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODICESOGGETTOCODICEOPERATORE,
					args);
			}

			if ((testataDocumentoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANNOTIPODOCUMENTOIDASSOCIATO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						testataDocumentoModelImpl.getOriginalAnno(),
						testataDocumentoModelImpl.getOriginalTipoDocumento(),
						testataDocumentoModelImpl.getOriginalIdAssociato()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ANNOTIPODOCUMENTOIDASSOCIATO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANNOTIPODOCUMENTOIDASSOCIATO,
					args);

				args = new Object[] {
						testataDocumentoModelImpl.getAnno(),
						testataDocumentoModelImpl.getTipoDocumento(),
						testataDocumentoModelImpl.getIdAssociato()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ANNOTIPODOCUMENTOIDASSOCIATO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANNOTIPODOCUMENTOIDASSOCIATO,
					args);
			}
		}

		EntityCacheUtil.putResult(TestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
			TestataDocumentoImpl.class, testataDocumento.getPrimaryKey(),
			testataDocumento);

		return testataDocumento;
	}

	protected TestataDocumento toUnwrappedModel(
		TestataDocumento testataDocumento) {
		if (testataDocumento instanceof TestataDocumentoImpl) {
			return testataDocumento;
		}

		TestataDocumentoImpl testataDocumentoImpl = new TestataDocumentoImpl();

		testataDocumentoImpl.setNew(testataDocumento.isNew());
		testataDocumentoImpl.setPrimaryKey(testataDocumento.getPrimaryKey());

		testataDocumentoImpl.setAnno(testataDocumento.getAnno());
		testataDocumentoImpl.setNumeroOrdine(testataDocumento.getNumeroOrdine());
		testataDocumentoImpl.setCodiceSoggetto(testataDocumento.getCodiceSoggetto());
		testataDocumentoImpl.setDataOrdine(testataDocumento.getDataOrdine());
		testataDocumentoImpl.setDataConsegna(testataDocumento.getDataConsegna());
		testataDocumentoImpl.setDestinazione(testataDocumento.getDestinazione());
		testataDocumentoImpl.setCodiceDestinazione(testataDocumento.getCodiceDestinazione());
		testataDocumentoImpl.setRagioneSociale(testataDocumento.getRagioneSociale());
		testataDocumentoImpl.setCompleto(testataDocumento.getCompleto());
		testataDocumentoImpl.setOperatore(testataDocumento.getOperatore());
		testataDocumentoImpl.setVisto(testataDocumento.getVisto());
		testataDocumentoImpl.setInviato(testataDocumento.getInviato());
		testataDocumentoImpl.setLotto(testataDocumento.getLotto());
		testataDocumentoImpl.setTipoDocumento(testataDocumento.getTipoDocumento());
		testataDocumentoImpl.setVettore(testataDocumento.getVettore());
		testataDocumentoImpl.setAutista(testataDocumento.getAutista());
		testataDocumentoImpl.setTelefono(testataDocumento.getTelefono());
		testataDocumentoImpl.setCentro(testataDocumento.getCentro());
		testataDocumentoImpl.setPalletCaricati(testataDocumento.getPalletCaricati());
		testataDocumentoImpl.setPalletScaricati(testataDocumento.getPalletScaricati());
		testataDocumentoImpl.setCodiceVettore(testataDocumento.getCodiceVettore());
		testataDocumentoImpl.setDestinazioneVettore(testataDocumento.getDestinazioneVettore());
		testataDocumentoImpl.setNota1(testataDocumento.getNota1());
		testataDocumentoImpl.setNota2(testataDocumento.getNota2());
		testataDocumentoImpl.setRigoDescrittivo(testataDocumento.getRigoDescrittivo());
		testataDocumentoImpl.setVettore2(testataDocumento.getVettore2());
		testataDocumentoImpl.setCuraTrasporto(testataDocumento.getCuraTrasporto());
		testataDocumentoImpl.setAspettoEsteriore(testataDocumento.getAspettoEsteriore());
		testataDocumentoImpl.setCausaleTrasporto(testataDocumento.getCausaleTrasporto());
		testataDocumentoImpl.setPorto(testataDocumento.getPorto());
		testataDocumentoImpl.setOrigine(testataDocumento.getOrigine());
		testataDocumentoImpl.setNumeroPedaneEuro(testataDocumento.getNumeroPedaneEuro());
		testataDocumentoImpl.setNumeroPedaneNormali(testataDocumento.getNumeroPedaneNormali());
		testataDocumentoImpl.setCostoTrasporto(testataDocumento.getCostoTrasporto());
		testataDocumentoImpl.setTotalePedaneOrdine(testataDocumento.getTotalePedaneOrdine());
		testataDocumentoImpl.setTargaCamion(testataDocumento.getTargaCamion());
		testataDocumentoImpl.setTargaRimorchio(testataDocumento.getTargaRimorchio());
		testataDocumentoImpl.setIdAssociato(testataDocumento.getIdAssociato());

		return testataDocumentoImpl;
	}

	/**
	 * Returns the testata documento with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the testata documento
	 * @return the testata documento
	 * @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a testata documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestataDocumento findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTestataDocumentoException, SystemException {
		TestataDocumento testataDocumento = fetchByPrimaryKey(primaryKey);

		if (testataDocumento == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTestataDocumentoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return testataDocumento;
	}

	/**
	 * Returns the testata documento with the primary key or throws a {@link it.bysoftware.ct.NoSuchTestataDocumentoException} if it could not be found.
	 *
	 * @param testataDocumentoPK the primary key of the testata documento
	 * @return the testata documento
	 * @throws it.bysoftware.ct.NoSuchTestataDocumentoException if a testata documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestataDocumento findByPrimaryKey(
		TestataDocumentoPK testataDocumentoPK)
		throws NoSuchTestataDocumentoException, SystemException {
		return findByPrimaryKey((Serializable)testataDocumentoPK);
	}

	/**
	 * Returns the testata documento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the testata documento
	 * @return the testata documento, or <code>null</code> if a testata documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestataDocumento fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TestataDocumento testataDocumento = (TestataDocumento)EntityCacheUtil.getResult(TestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
				TestataDocumentoImpl.class, primaryKey);

		if (testataDocumento == _nullTestataDocumento) {
			return null;
		}

		if (testataDocumento == null) {
			Session session = null;

			try {
				session = openSession();

				testataDocumento = (TestataDocumento)session.get(TestataDocumentoImpl.class,
						primaryKey);

				if (testataDocumento != null) {
					cacheResult(testataDocumento);
				}
				else {
					EntityCacheUtil.putResult(TestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
						TestataDocumentoImpl.class, primaryKey,
						_nullTestataDocumento);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TestataDocumentoModelImpl.ENTITY_CACHE_ENABLED,
					TestataDocumentoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return testataDocumento;
	}

	/**
	 * Returns the testata documento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param testataDocumentoPK the primary key of the testata documento
	 * @return the testata documento, or <code>null</code> if a testata documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestataDocumento fetchByPrimaryKey(
		TestataDocumentoPK testataDocumentoPK) throws SystemException {
		return fetchByPrimaryKey((Serializable)testataDocumentoPK);
	}

	/**
	 * Returns all the testata documentos.
	 *
	 * @return the testata documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TestataDocumento> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the testata documentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of testata documentos
	 * @param end the upper bound of the range of testata documentos (not inclusive)
	 * @return the range of testata documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TestataDocumento> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the testata documentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.bysoftware.ct.model.impl.TestataDocumentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of testata documentos
	 * @param end the upper bound of the range of testata documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of testata documentos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TestataDocumento> findAll(int start, int end,
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

		List<TestataDocumento> list = (List<TestataDocumento>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TESTATADOCUMENTO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TESTATADOCUMENTO;

				if (pagination) {
					sql = sql.concat(TestataDocumentoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TestataDocumento>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TestataDocumento>(list);
				}
				else {
					list = (List<TestataDocumento>)QueryUtil.list(q,
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
	 * Removes all the testata documentos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TestataDocumento testataDocumento : findAll()) {
			remove(testataDocumento);
		}
	}

	/**
	 * Returns the number of testata documentos.
	 *
	 * @return the number of testata documentos
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

				Query q = session.createQuery(_SQL_COUNT_TESTATADOCUMENTO);

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
	 * Initializes the testata documento persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.bysoftware.ct.model.TestataDocumento")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TestataDocumento>> listenersList = new ArrayList<ModelListener<TestataDocumento>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TestataDocumento>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TestataDocumentoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TESTATADOCUMENTO = "SELECT testataDocumento FROM TestataDocumento testataDocumento";
	private static final String _SQL_SELECT_TESTATADOCUMENTO_WHERE = "SELECT testataDocumento FROM TestataDocumento testataDocumento WHERE ";
	private static final String _SQL_COUNT_TESTATADOCUMENTO = "SELECT COUNT(testataDocumento) FROM TestataDocumento testataDocumento";
	private static final String _SQL_COUNT_TESTATADOCUMENTO_WHERE = "SELECT COUNT(testataDocumento) FROM TestataDocumento testataDocumento WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "testataDocumento.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TestataDocumento exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TestataDocumento exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TestataDocumentoPersistenceImpl.class);
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
	private static TestataDocumento _nullTestataDocumento = new TestataDocumentoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TestataDocumento> toCacheModel() {
				return _nullTestataDocumentoCacheModel;
			}
		};

	private static CacheModel<TestataDocumento> _nullTestataDocumentoCacheModel = new CacheModel<TestataDocumento>() {
			@Override
			public TestataDocumento toEntityModel() {
				return _nullTestataDocumento;
			}
		};
}
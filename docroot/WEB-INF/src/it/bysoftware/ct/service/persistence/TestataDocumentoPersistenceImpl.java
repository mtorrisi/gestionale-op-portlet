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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
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

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
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
		testataDocumentoImpl.setCompleto(testataDocumento.getCompleto());
		testataDocumentoImpl.setOperatore(testataDocumento.getOperatore());
		testataDocumentoImpl.setVisto(testataDocumento.getVisto());
		testataDocumentoImpl.setInviato(testataDocumento.getInviato());
		testataDocumentoImpl.setLotto(testataDocumento.getLotto());
		testataDocumentoImpl.setTipoDocumeto(testataDocumento.getTipoDocumeto());
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
		testataDocumentoImpl.setCuraTrasoirto(testataDocumento.getCuraTrasoirto());
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
	private static final String _SQL_COUNT_TESTATADOCUMENTO = "SELECT COUNT(testataDocumento) FROM TestataDocumento testataDocumento";
	private static final String _ORDER_BY_ENTITY_ALIAS = "testataDocumento.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TestataDocumento exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TestataDocumentoPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"anno", "numeroOrdine", "codiceSoggetto", "dataOrdine",
				"dataConsegna", "destinazione", "codiceDestinazione", "completo",
				"operatore", "visto", "inviato", "lotto", "tipoDocumeto",
				"vettore", "autista", "telefono", "centro", "palletCaricati",
				"palletScaricati", "codiceVettore", "destinazioneVettore",
				"nota1", "nota2", "rigoDescrittivo", "vettore2", "curaTrasoirto",
				"aspettoEsteriore", "causaleTrasporto", "origine",
				"numeroPedaneEuro", "numeroPedaneNormali", "costoTrasporto",
				"totalePedaneOrdine", "targaCamion", "targaRimorchio"
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
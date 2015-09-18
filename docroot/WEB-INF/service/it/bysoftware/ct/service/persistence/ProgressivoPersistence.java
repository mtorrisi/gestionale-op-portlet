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

import com.liferay.portal.service.persistence.BasePersistence;

import it.bysoftware.ct.model.Progressivo;

/**
 * The persistence interface for the progressivo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgressivoPersistenceImpl
 * @see ProgressivoUtil
 * @generated
 */
public interface ProgressivoPersistence extends BasePersistence<Progressivo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProgressivoUtil} to access the progressivo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the progressivos where anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param tipoDocumento the tipo documento
	* @return the matching progressivos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.Progressivo> findByAnnoIdAssociatoTipoDocumento(
		int anno, long idAssociato, int tipoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.bysoftware.ct.model.Progressivo> findByAnnoIdAssociatoTipoDocumento(
		int anno, long idAssociato, int tipoDocumento, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.bysoftware.ct.model.Progressivo> findByAnnoIdAssociatoTipoDocumento(
		int anno, long idAssociato, int tipoDocumento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.bysoftware.ct.model.Progressivo findByAnnoIdAssociatoTipoDocumento_First(
		int anno, long idAssociato, int tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchProgressivoException;

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
	public it.bysoftware.ct.model.Progressivo fetchByAnnoIdAssociatoTipoDocumento_First(
		int anno, long idAssociato, int tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.bysoftware.ct.model.Progressivo findByAnnoIdAssociatoTipoDocumento_Last(
		int anno, long idAssociato, int tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchProgressivoException;

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
	public it.bysoftware.ct.model.Progressivo fetchByAnnoIdAssociatoTipoDocumento_Last(
		int anno, long idAssociato, int tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.bysoftware.ct.model.Progressivo[] findByAnnoIdAssociatoTipoDocumento_PrevAndNext(
		it.bysoftware.ct.service.persistence.ProgressivoPK progressivoPK,
		int anno, long idAssociato, int tipoDocumento,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchProgressivoException;

	/**
	* Removes all the progressivos where anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63; from the database.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param tipoDocumento the tipo documento
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAnnoIdAssociatoTipoDocumento(int anno,
		long idAssociato, int tipoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of progressivos where anno = &#63; and idAssociato = &#63; and tipoDocumento = &#63;.
	*
	* @param anno the anno
	* @param idAssociato the id associato
	* @param tipoDocumento the tipo documento
	* @return the number of matching progressivos
	* @throws SystemException if a system exception occurred
	*/
	public int countByAnnoIdAssociatoTipoDocumento(int anno, long idAssociato,
		int tipoDocumento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the progressivo in the entity cache if it is enabled.
	*
	* @param progressivo the progressivo
	*/
	public void cacheResult(it.bysoftware.ct.model.Progressivo progressivo);

	/**
	* Caches the progressivos in the entity cache if it is enabled.
	*
	* @param progressivos the progressivos
	*/
	public void cacheResult(
		java.util.List<it.bysoftware.ct.model.Progressivo> progressivos);

	/**
	* Creates a new progressivo with the primary key. Does not add the progressivo to the database.
	*
	* @param progressivoPK the primary key for the new progressivo
	* @return the new progressivo
	*/
	public it.bysoftware.ct.model.Progressivo create(
		it.bysoftware.ct.service.persistence.ProgressivoPK progressivoPK);

	/**
	* Removes the progressivo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param progressivoPK the primary key of the progressivo
	* @return the progressivo that was removed
	* @throws it.bysoftware.ct.NoSuchProgressivoException if a progressivo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Progressivo remove(
		it.bysoftware.ct.service.persistence.ProgressivoPK progressivoPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchProgressivoException;

	public it.bysoftware.ct.model.Progressivo updateImpl(
		it.bysoftware.ct.model.Progressivo progressivo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the progressivo with the primary key or throws a {@link it.bysoftware.ct.NoSuchProgressivoException} if it could not be found.
	*
	* @param progressivoPK the primary key of the progressivo
	* @return the progressivo
	* @throws it.bysoftware.ct.NoSuchProgressivoException if a progressivo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Progressivo findByPrimaryKey(
		it.bysoftware.ct.service.persistence.ProgressivoPK progressivoPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.bysoftware.ct.NoSuchProgressivoException;

	/**
	* Returns the progressivo with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param progressivoPK the primary key of the progressivo
	* @return the progressivo, or <code>null</code> if a progressivo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.bysoftware.ct.model.Progressivo fetchByPrimaryKey(
		it.bysoftware.ct.service.persistence.ProgressivoPK progressivoPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the progressivos.
	*
	* @return the progressivos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.bysoftware.ct.model.Progressivo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.bysoftware.ct.model.Progressivo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.bysoftware.ct.model.Progressivo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the progressivos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of progressivos.
	*
	* @return the number of progressivos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
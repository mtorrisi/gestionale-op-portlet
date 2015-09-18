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

package it.bysoftware.ct.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import it.bysoftware.ct.model.Progressivo;
import it.bysoftware.ct.service.ProgressivoLocalServiceUtil;

/**
 * The extended model base implementation for the Progressivo service. Represents a row in the &quot;ProgAnnFor&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProgressivoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgressivoImpl
 * @see it.bysoftware.ct.model.Progressivo
 * @generated
 */
public abstract class ProgressivoBaseImpl extends ProgressivoModelImpl
	implements Progressivo {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a progressivo model instance should use the {@link Progressivo} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ProgressivoLocalServiceUtil.addProgressivo(this);
		}
		else {
			ProgressivoLocalServiceUtil.updateProgressivo(this);
		}
	}
}
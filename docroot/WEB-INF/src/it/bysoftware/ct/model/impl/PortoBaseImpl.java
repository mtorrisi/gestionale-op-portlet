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

import it.bysoftware.ct.model.Porto;
import it.bysoftware.ct.service.PortoLocalServiceUtil;

/**
 * The extended model base implementation for the Porto service. Represents a row in the &quot;Porto&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PortoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PortoImpl
 * @see it.bysoftware.ct.model.Porto
 * @generated
 */
public abstract class PortoBaseImpl extends PortoModelImpl implements Porto {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a porto model instance should use the {@link Porto} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PortoLocalServiceUtil.addPorto(this);
		}
		else {
			PortoLocalServiceUtil.updatePorto(this);
		}
	}
}
/*******************************************************************************
 * Copyright (c) 2016 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package io.github.shimada666.packagedrone.plus;

import java.util.Optional;

public interface ReadableHeader<T extends RpmBaseTag>
{
    /**
     * Get the value from a header structure
     *
     * @param tag
     *            the tag
     * @return the optional value
     */
    public Optional<Object> getValue ( T tag );
}

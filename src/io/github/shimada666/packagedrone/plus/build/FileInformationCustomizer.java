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
package io.github.shimada666.packagedrone.plus.build;

import java.io.IOException;

@FunctionalInterface
public interface FileInformationCustomizer<T>
{
    public void perform ( T object, FileInformation information ) throws IOException;
}
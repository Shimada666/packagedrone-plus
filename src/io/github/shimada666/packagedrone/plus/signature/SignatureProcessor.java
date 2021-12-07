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
package io.github.shimada666.packagedrone.plus.signature;

import java.nio.ByteBuffer;

import io.github.shimada666.packagedrone.plus.RpmSignatureTag;
import io.github.shimada666.packagedrone.plus.header.Header;

/**
 * Process data for creating a signature
 * <p>
 * The call flow is like this:
 * </p>
 * <ul>
 * <li>one call to {@link #init(long)}</li>
 * <li>one call to {@link #feedHeader(ByteBuffer)}</li>
 * <li>zero or more calls to {@link #feedPayloadData(ByteBuffer)}, feeding the
 * full, compressed, payload stream</li>
 * <li>one call to {@link #finish(Header)}</li>
 * </ul>
 */
public interface SignatureProcessor
{
    /**
     * initialize the processor
     *
     * @param archiveSize
     *            the size of the uncompressed payload archive
     */
    public default void init ( final long archiveSize )
    {
    }

    public void feedHeader ( ByteBuffer header );

    public void feedPayloadData ( ByteBuffer data );

    public void finish ( Header<RpmSignatureTag> signature );
}

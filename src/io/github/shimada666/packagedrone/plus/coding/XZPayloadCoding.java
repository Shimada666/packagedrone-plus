/*******************************************************************************
 * Copyright (c) 2018 Red Hat Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat Inc - initial API and implementation
 *******************************************************************************/
package io.github.shimada666.packagedrone.plus.coding;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Optional;
import java.util.function.Consumer;

import org.apache.commons.compress.compressors.xz.XZCompressorInputStream;
import org.apache.commons.compress.compressors.xz.XZCompressorOutputStream;
import io.github.shimada666.packagedrone.plus.deps.Dependency;
import io.github.shimada666.packagedrone.plus.deps.RpmDependencyFlags;
import org.tukaani.xz.LZMA2Options;

public class XZPayloadCoding implements PayloadCodingProvider
{
    protected XZPayloadCoding ()
    {
    }

    @Override
    public String getCoding ()
    {
        return "xz";
    }

    @Override
    public void fillRequirements ( final Consumer<Dependency> requirementsConsumer )
    {
        requirementsConsumer.accept ( new Dependency ( "PayloadIsXz", "5.2-1", RpmDependencyFlags.LESS, RpmDependencyFlags.EQUAL, RpmDependencyFlags.RPMLIB ) );
    }

    @Override
    public InputStream createInputStream ( final InputStream in ) throws IOException
    {
        return new XZCompressorInputStream ( in );
    }

    @Override
    public OutputStream createOutputStream ( final OutputStream out, final Optional<String> optionalFlags ) throws IOException
    {
        final String flags;
        final int preset;

        if ( optionalFlags.isPresent () && ( flags = optionalFlags.get () ).length () > 0 )
        {
            preset = Integer.parseInt ( flags.substring ( 0, 1 ) );
        }
        else
        {
            preset = LZMA2Options.PRESET_DEFAULT;
        }

        return new XZCompressorOutputStream ( out, preset );
    }
}

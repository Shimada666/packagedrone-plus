/*******************************************************************************
 * Copyright (c) 2016 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *     Red Hat Inc - Allow the use of the target name
 *******************************************************************************/
package org.corgi.packagedrone.plus.build;

import java.io.IOException;
import java.nio.file.Path;
import java.time.Instant;

final class Defaults
{
    private Defaults ()
    {
    }

    static final FileInformationProvider<Object> SIMPLE_FILE_PROVIDER = BuilderContext.simpleProvider ( 0644 );

    static final FileInformationProvider<BuilderContext.Directory> SIMPLE_DIRECTORY_PROVIDER = BuilderContext.simpleProvider ( 0755 );

    static final FileInformationProvider<BuilderContext.SymbolicLink> SIMPLE_SYMBOLIC_LINK = BuilderContext.simpleProvider ( 0644 );

    static final FileInformationProvider<Object> DEFAULT_MULTI_PROVIDER = BuilderContext.multiProvider ( SIMPLE_FILE_PROVIDER, new ProviderRule<?>[] { //
            new ProviderRule<> ( BuilderContext.Directory.class, SIMPLE_DIRECTORY_PROVIDER ), //
            new ProviderRule<> ( BuilderContext.SymbolicLink.class, SIMPLE_SYMBOLIC_LINK ) //
    } );

    static final FileInformationProvider<Path> PATH_PROVIDER = new FileInformationProvider<Path> () {

        @Override
        public FileInformation provide ( final String targetName, final Path path, final PayloadEntryType type ) throws IOException
        {
            return new FileInformation ();
        }
    }.customize ( BuilderContext.pathCustomizer () );

    static final SimpleFileInformationCustomizer NOW_TIMESTAMP_CUSTOMIZER = new SimpleFileInformationCustomizer () {

        @Override
        public void perform ( final FileInformation information )
        {
            information.setTimestamp ( Instant.now () );
        }
    };

}

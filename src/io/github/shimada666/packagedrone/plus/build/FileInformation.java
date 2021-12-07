/*******************************************************************************
 * Copyright (c) 2016, 2018 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *     Red Hat Inc
 *******************************************************************************/
package io.github.shimada666.packagedrone.plus.build;

import java.time.Instant;
import java.util.EnumSet;
import java.util.Set;

import io.github.shimada666.packagedrone.plus.FileFlags;

public class FileInformation
{
    private Instant timestamp = Instant.now ();

    private String user = BuilderContext.DEFAULT_USER;

    private String group = BuilderContext.DEFAULT_GROUP;

    private Set<FileFlags> fileFlags = EnumSet.noneOf ( FileFlags.class );

    private short mode = 0644;

    public void setTimestamp ( final Instant timestamp )
    {
        this.timestamp = timestamp;
    }

    public Instant getTimestamp ()
    {
        return this.timestamp;
    }

    @Deprecated
    public void setConfiguration ( final boolean configuration )
    {
        if ( configuration == true )
        {
            this.fileFlags.add ( FileFlags.CONFIGURATION );
        }
        else
        {
            this.fileFlags.remove ( FileFlags.CONFIGURATION );
        }
    }

    @Deprecated
    public boolean isConfiguration ()
    {
        return this.fileFlags.contains ( FileFlags.CONFIGURATION );
    }

    public void setFileFlags ( final Set<FileFlags> fileFlags )
    {
        if ( fileFlags.isEmpty () )
        {
            this.fileFlags = EnumSet.noneOf ( FileFlags.class );
        }
        else
        {
            this.fileFlags = EnumSet.copyOf ( fileFlags );
        }
    }

    public Set<FileFlags> getFileFlags ()
    {
        return this.fileFlags;
    }

    public void setUser ( final String user )
    {
        this.user = user;
    }

    public String getUser ()
    {
        return this.user;
    }

    public void setGroup ( final String group )
    {
        this.group = group;
    }

    public String getGroup ()
    {
        return this.group;
    }

    public void setMode ( final short mode )
    {
        this.mode = mode;
    }

    public short getMode ()
    {
        return this.mode;
    }

    @Override
    public String toString ()
    {
        return String.format ( "[FileInformation - user: %s, group: %s, mode: 0%04o, flags: %s]", this.user, this.group, this.mode, this.fileFlags );
    }
}

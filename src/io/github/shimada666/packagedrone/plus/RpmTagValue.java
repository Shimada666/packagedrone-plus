/*******************************************************************************
 * Copyright (c) 2015 IBH SYSTEMS GmbH.
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

public class RpmTagValue
{
    private final Object value;

    public RpmTagValue ( final Object value )
    {
        this.value = value;
    }

    public Object getValue ()
    {
        return this.value;
    }

    public Optional<String[]> asStringArray ()
    {
        if ( this.value == null )
        {
            return Optional.empty ();
        }

        if ( this.value instanceof String )
        {
            return Optional.of ( new String[] { (String)this.value } );
        }
        if ( this.value instanceof String[] )
        {
            return Optional.of ( (String[])this.value );
        }

        return Optional.empty ();
    }

    public Optional<String> asString ()
    {
        if ( this.value == null )
        {
            return Optional.empty ();
        }

        if ( this.value instanceof String )
        {
            return Optional.of ( (String)this.value );
        }

        if ( this.value instanceof String[] )
        {
            final String[] arr = (String[])this.value;
            if ( arr.length > 0 )
            {
                return Optional.of ( arr[0] );
            }
            else
            {
                return Optional.empty ();
            }
        }

        return Optional.empty ();
    }

    public Optional<Integer[]> asIntegerArray ()
    {
        if ( this.value == null )
        {
            return Optional.empty ();
        }

        if ( this.value instanceof Integer )
        {
            return Optional.of ( new Integer[] { (Integer)this.value } );
        }
        if ( this.value instanceof Integer[] )
        {
            return Optional.of ( (Integer[])this.value );
        }

        return Optional.empty ();
    }

    public Optional<Integer> asInteger ()
    {
        if ( this.value == null )
        {
            return Optional.empty ();
        }

        if ( this.value instanceof Integer )
        {
            return Optional.of ( (Integer)this.value );
        }

        if ( this.value instanceof Integer[] )
        {
            final Integer[] arr = (Integer[])this.value;
            if ( arr.length > 0 )
            {
                return Optional.of ( arr[0] );
            }
            else
            {
                return Optional.empty ();
            }
        }

        return Optional.empty ();
    }

    public Optional<Long[]> asLongArray ()
    {
        if ( this.value == null )
        {
            return Optional.empty ();
        }

        if ( this.value instanceof Long )
        {
            return Optional.of ( new Long[] { (Long)this.value } );
        }
        if ( this.value instanceof Long[] )
        {
            return Optional.of ( (Long[])this.value );
        }

        return Optional.empty ();
    }

    public Optional<Long> asLong ()
    {
        if ( this.value == null )
        {
            return Optional.empty ();
        }

        if ( this.value instanceof Long )
        {
            return Optional.of ( ( (Long)this.value ).longValue () );
        }

        if ( this.value instanceof Long[] )
        {
            final Long[] arr = (Long[])this.value;
            if ( arr.length > 0 )
            {
                return Optional.of ( arr[0] );
            }
            else
            {
                return Optional.empty ();
            }
        }

        return Optional.empty ();
    }
}

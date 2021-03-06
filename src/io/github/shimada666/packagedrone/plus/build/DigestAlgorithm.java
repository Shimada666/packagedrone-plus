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
package io.github.shimada666.packagedrone.plus.build;

import java.io.IOException;

import org.bouncycastle.bcpg.HashAlgorithmTags;

public enum DigestAlgorithm
{
    MD5 ( "MD5", HashAlgorithmTags.MD5 ),
    SHA1 ( "SHA", HashAlgorithmTags.SHA1 ),
    RIPEMD160 ( "RIPE-MD160", HashAlgorithmTags.RIPEMD160 ),
    DOUBLE_SHA ( "Double-SHA", HashAlgorithmTags.DOUBLE_SHA ),
    MD2 ( "MD2", HashAlgorithmTags.MD2 ),
    TIGER_192 ( "Tiger-192", HashAlgorithmTags.TIGER_192 ),
    HAVAL_5_160 ( "Haval-5-160", HashAlgorithmTags.HAVAL_5_160 ),
    SHA256 ( "SHA-256", HashAlgorithmTags.SHA256 ),
    SHA384 ( "SHA-384", HashAlgorithmTags.SHA384 ),
    SHA512 ( "SHA-512", HashAlgorithmTags.SHA512 ),
    SHA224 ( "SHA-224", HashAlgorithmTags.SHA224 );

    private String algorithm;

    private int tag;

    private DigestAlgorithm ( final String algorithm, final int tag )
    {
        this.algorithm = algorithm;
        this.tag = tag;
    }

    public String getAlgorithm ()
    {
        return algorithm;
    }

    public int getTag ()
    {
        return tag;
    }

    public static DigestAlgorithm fromTag ( final int tag ) throws IOException
    {
        for ( DigestAlgorithm digestAlgorithm : DigestAlgorithm.values () )
        {
            if ( tag == digestAlgorithm.getTag () )
            {
                return digestAlgorithm;
            }
        }

        throw new IOException ( String.format ( "Unknown tag: %d", tag ) );
    }
}

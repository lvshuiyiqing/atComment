/*
 * Copyright 2003-2004 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.collections.primitives.adapters;

import java.io.Serializable;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.apache.commons.collections.BulkTest;
import org.apache.commons.collections.primitives.ArrayByteList;
import org.apache.commons.collections.primitives.RandomAccessByteList;

/**
 * @version $Revision: 1.5 $ $Date: 2004/02/25 20:46:29 $
 * @author Rodney Waldhoff
 */
public class TestByteListList extends BaseTestList {

    // conventional
    // ------------------------------------------------------------------------

    public TestByteListList(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = BulkTest.makeSuite(TestByteListList.class);
        return suite;
    }

    // collections testing framework
    // ------------------------------------------------------------------------

    public List makeEmptyList() {
        return new ByteListList(new ArrayByteList());
    }
        
    public Object[] getFullElements() {
        Byte[] elts = new Byte[10];
        for(int i=0;i<elts.length;i++) {
            elts[i] = new Byte((byte)i);
        }
        return elts;
    }

    public Object[] getOtherElements() {
        Byte[] elts = new Byte[10];
        for(int i=0;i<elts.length;i++) {
            elts[i] = new Byte((byte)(10 + i));
        }
        return elts;
    }

    // tests
    // ------------------------------------------------------------------------

    /** @TODO need to add serialized form to cvs */

    public void testCanonicalEmptyCollectionExists() {
        // XXX FIX ME XXX
        // need to add a serialized form to cvs
    }

    public void testCanonicalFullCollectionExists() {
        // XXX FIX ME XXX
        // need to add a serialized form to cvs
    }

    public void testEmptyListCompatibility() {
        // XXX FIX ME XXX
        // need to add a serialized form to cvs
    }

    public void testFullListCompatibility() {
        // XXX FIX ME XXX
        // need to add a serialized form to cvs
    }

    public void testWrapNull() {
        assertNull(ByteListList.wrap(null));
    }
    
    public void testWrapSerializable() {
        List list = ByteListList.wrap(new ArrayByteList());
        assertNotNull(list);
        assertTrue(list instanceof Serializable);
    }
    
    public void testWrapNonSerializable() {
        List list = ByteListList.wrap(new RandomAccessByteList() { 
            public byte get(int i) { throw new IndexOutOfBoundsException(); } 
            public int size() { return 0; } 
        });
        assertNotNull(list);
        assertTrue(!(list instanceof Serializable));
    }
}

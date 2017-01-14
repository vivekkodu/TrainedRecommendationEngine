package com.home24.recommendation.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Created by VIVEK VERMA on 1/14/2017.
 */
public class BinaryHeapTest extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public BinaryHeapTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( BinaryHeapTest.class );
    }

    public void testHeapification() {
        BinaryMinHeap<TestHeapObject> heap = new BinaryMinHeap(3, TestHeapObject.class);
        heap.insert(new TestHeapObject(4));
        assertEquals(1, heap.getHeapSize());
        assertEquals(4, heap.findMin().value);
        heap.insert(new TestHeapObject(5));
        assertEquals(2, heap.getHeapSize());
        assertEquals(4, heap.findMin().value);
        heap.insert(new TestHeapObject(3));
        assertEquals(3, heap.getHeapSize());
        assertEquals(3, heap.findMin().value);
        heap.insert(new TestHeapObject(3));
        assertEquals(3, heap.getHeapSize());
        assertEquals(3, heap.findMin().value);
        heap.insert(new TestHeapObject(4));
        assertEquals(3, heap.getHeapSize());
        assertEquals(4, heap.findMin().value);

        heap = new BinaryMinHeap(3, TestHeapObject.class);
        heap.insert(new TestHeapObject(15));
        assertEquals(1, heap.getHeapSize());
        assertEquals(15, heap.findMin().value);
        heap.insert(new TestHeapObject(10));
        assertEquals(2, heap.getHeapSize());
        assertEquals(10, heap.findMin().value);
        heap.insert(new TestHeapObject(20));
        assertEquals(3, heap.getHeapSize());
        assertEquals(10, heap.findMin().value);
        heap.insert(new TestHeapObject(17));
        assertEquals(3, heap.getHeapSize());
        assertEquals(15, heap.findMin().value);
    }

}

class TestHeapObject implements Comparable<TestHeapObject> {

    int value;

    TestHeapObject(int value){
        this.value = value;
    }

    public int compareTo(TestHeapObject o) {
        return this.value - o.value;
    }
}

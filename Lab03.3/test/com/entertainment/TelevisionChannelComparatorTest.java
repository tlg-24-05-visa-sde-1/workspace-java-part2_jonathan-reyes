package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionChannelComparatorTest {
    Television tv1;
    Television tv2;
    TelevisionChannelComparator tvComparator;

    //you need 3 things in the fixture
    //tv1
    //tv2
    // a comparator

    //in your assertion, you'll call compare() directly
    //comparator.compare(tv1,tv2)

    @Before
    public void setUp() {
        tv1=new Television();
        tv2=new Television();
        tvComparator=new TelevisionChannelComparator();
    }

    @Test
    public void testShouldReturnTrue_sameChannel() throws InvalidChannelException {
        tv1.changeChannel(1);
        tv2.changeChannel(1);
        assertEquals(0,tvComparator.compare(tv1,tv2));
    }
    @Test
    public void testShouldReturnFalse_differentChannel() throws InvalidChannelException {
        tv1.changeChannel(1);
        tv2.changeChannel(50);
        assertNotEquals(0,tvComparator.compare(tv1,tv2));
    }

}
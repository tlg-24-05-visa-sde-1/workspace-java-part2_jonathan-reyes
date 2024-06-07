package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionChannelComparatorTest {
    private Television tv1;
    private Television tv2;
    private TelevisionChannelComparator tvComparator;

    @Before
    public void setUp() {
        tv1=new Television();
        tv2=new Television();
        tvComparator=new TelevisionChannelComparator();
    }

    @Test
    public void testShouldReturnZero_sameChannel() throws InvalidChannelException {
        tv1.changeChannel(1);
        tv2.changeChannel(1);
        assertEquals(0,tvComparator.compare(tv1,tv2));
    }
    @Test
    public void testShouldReturnNonZeroNumber_differentChannel() throws InvalidChannelException {
        //Postive Number test
        tv1.changeChannel(50);
        tv2.changeChannel(1);
        assertTrue(tvComparator.compare(tv1,tv2)>0);

        //Negative Number test
        tv1.changeChannel(1);
        tv2.changeChannel(50);
        assertTrue(tvComparator.compare(tv1,tv2)<0);
    }

}
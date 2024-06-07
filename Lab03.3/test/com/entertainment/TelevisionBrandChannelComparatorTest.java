package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionBrandChannelComparatorTest {
    private Television tv1, tv2;
    private TelevisionBrandChannelComparator tbc1;

    @Before
    public void setUp() {
        tv1=new Television();
        tv2=new Television();
        tbc1=new TelevisionBrandChannelComparator();
    }

    @Test
    public void testCompareInComparator_returns0_sameBrandSameChannel() throws InvalidChannelException{
        tv1.setBrand("Sony");   //default channel is 3
        tv2.setBrand("Sony");   //default channel is 3
        assertEquals(0,tbc1.compare(tv1, tv2));
    }
    @Test
    public void testCompareInComparator_returnsNonZeroNumber_differentBrandSameChannel() throws InvalidChannelException{
        //Sorted Key is Brand, Natural order on brand
        //Positive Number Check
        tv1.setBrand("Sony");   //default channel is 3
        tv2.setBrand("Apple");   //default channel is 3
        assertTrue(tbc1.compare(tv1,tv2)>0);

        //Negative Number Check
        tv1.setBrand("Sony");   //default channel is 3
        tv2.setBrand("Zenith");   //default channel is 3
        assertTrue(tbc1.compare(tv1,tv2)<0);
    }

    @Test
    public void testCompareInComparator_returnsNonZeroNumber_sameBrandDifferentChannel() throws InvalidChannelException{
        //Sorted Key is Brand, Natural order on brand

        //Positive Number Check
        tv1.setBrand("Apple");
        tv1.changeChannel(5);                        //setting TV1 to Channel 5
        tv2.setBrand("Apple");
        tv2.changeChannel(1);                          //setting TV2 to Channel 1
        assertTrue(tbc1.compare(tv1,tv2)>0);

        //Negative Number Check
        tv1.setBrand("Apple");
        tv1.changeChannel(1);                        //setting TV1 to Channel 1
        tv2.setBrand("Apple");
        tv2.changeChannel(5);                          //setting TV2 to Channel 5
        assertTrue(tbc1.compare(tv1,tv2)<0);
    }
}
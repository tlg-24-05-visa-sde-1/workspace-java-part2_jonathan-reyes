package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


/*
   BVT:
    Volume
      -1, 0 and 100, 101
*/


public class TelevisionTest {
    Television tv;

    @Before
    public void setUp() {
        tv = new Television();
    }

    /*checking SetVolume*/
    @Test
    public void setVolume_shouldStoreValue_validInput_lowerBound() {
        tv.setVolume(0);
        assertEquals(0, tv.getVolume());
    }
    @Test
    public void setVolume_shouldStoreValue_validInput_upperBound() {
        tv.setVolume(100);
        assertEquals(100, tv.getVolume());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_invalidInput_lowerBound() {
        tv.setVolume(-1);
        assertEquals(-1, tv.getVolume()); //should trigger an exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_invalidInput_upperBound() {
        tv.setVolume(101);
        assertEquals(101, tv.getVolume()); //should trigger an exception
    }


    /*checking changeChannel*/

    @Test            //checked exception - must always throw Exception even with valid parameters
    public void changeChannel_shouldStoreValue_validInput_lowerBound() throws InvalidChannelException{
        tv.changeChannel(1);
        assertEquals(1,tv.getCurrentChannel());
    }
    @Test
    public void changeChannel_shouldStoreValue_validInput_upperBound() throws InvalidChannelException{
        tv.changeChannel(999);
        assertEquals(999,tv.getCurrentChannel());
    }

    //Checking InvalidExceptionThrown
    /*@Test(expected = InvalidChannelException.class)
    public void changeChannel_shouldThrowInvalidChannelException_invalidInput_lowerBound()  //checked exception must put throws the exception
    throws InvalidChannelException{
            tv.changeChannel(0);
    }

    @Test(expected = InvalidChannelException.class)
    public void changeChannel_shouldThrowInvalidChannelException_invalidInput_upperBound() throws InvalidChannelException{
        tv.changeChannel(1000);
    }*/

    @Test
    public void changeChannel_shouldThrowInvalidChannelException_invalidInput_lowerBound()  //checked exception must put throws the exception
            throws InvalidChannelException{
       try{
           tv.changeChannel(0);
       }
       catch(InvalidChannelException e){
           assertEquals("Invalid channel: 0. Allowed range: [1,999].", e.getMessage());
       }

    }

    @Test
    public void changeChannel_shouldThrowInvalidChannelException_invalidInput_upperBound() throws InvalidChannelException{
        try{
            tv.changeChannel(1000);
        }
        catch(InvalidChannelException e){
            assertEquals("Invalid channel: 1000. Allowed range: [1,999].", e.getMessage());
        }
    }


    /*compareTo() Tests*/
    // natural order defined by brand only( alphabetical on brand)
    @Test
    public void testCompareTo_shouldReturnTrue_brandsSame() {
        Television tv1 = new Television("Sony");
        Television tv2 = new Television("Sony");
        assertTrue(tv1.compareTo(tv2) == 0);
    }

    @Test
    public void testCompareTo_shouldReturnPositive() {
        Television tv1 = new Television("Sony");
        Television tv2 = new Television("FireTV");
        assertTrue(tv1.compareTo(tv2) > 0);
    }

    @Test
    public void testCompareTo_shouldReturnNegative() {
        Television tv1 = new Television("Apple");
        Television tv2 = new Television("FireTV");
        assertTrue(tv1.compareTo(tv2) < 0);
    }


    /*TestingHashCode*/
    @Test
    public void testHashCode_shouldReturnTrue_allPropertiesSame() {
        Television tv1 = new Television("Sony",50,DisplayType.LCD);
        Television tv2 = new Television("Sony",50,DisplayType.LCD);
        assertTrue(tv1.equals(tv2));
    }
    @Test
    public void testHashCode_shouldReturnNotEquals_differentProperties() {
        Television tv1 = new Television("Sony",50,DisplayType.LCD);
        Television tv2 = new Television("Apple",50,DisplayType.LCD);
        Television tv3 = new Television("Sony",75,DisplayType.LCD);
        Television tv4 = new Television("Sony",50,DisplayType.LED);
        //Different brand
        assertNotEquals(tv1.hashCode(), tv2.hashCode());
        //Different Volume
        assertNotEquals(tv1.hashCode(), tv3.hashCode());
        //Different DisplayType
        assertNotEquals(tv1.hashCode(), tv4.hashCode());
    }

    /*Testing equals()*/
    @Test
    public void testEquals_shouldReturnTrue_allPropertiesSame() {
        Television tv1 = new Television("Sony",50,DisplayType.LCD);
        Television tv2 = new Television("Sony",50,DisplayType.LCD);
        assertTrue(tv1.equals(tv2));
    }
    @Test
    public void testEquals_shouldReturnFalse_propertiesDiffer() {
        Television tv1 = new Television("Sony",50,DisplayType.LCD);
        Television tv2 = new Television("Apple",50,DisplayType.LCD);
        Television tv3 = new Television("Sony",75,DisplayType.LCD);
        Television tv4 = new Television("Sony",50,DisplayType.LED);
        //Different brand
        assertFalse(tv1.equals(tv2));
        //Different Volume
        assertFalse(tv1.equals(tv3));
        //Different DisplayType
        assertFalse(tv1.equals(tv4));
    }

    //hashcode comparison
    //assertEquals(tv1.hashCode(), tv2.hashCode())

}
/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.compare;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;

public class StringSortTest {

    private final List<String> names = Arrays.asList("Jason", "Martin", "Jack", "Mary", "Jill", "Frederick", "Laurie", "Ed"); //remember fixed length, cant add/remove

    @Test
    public void testStringListSort() {
        System.out.println("Order will be added to following list:");
        System.out.println(names + "\n");

        System.out.println("Natural order:");
        names.sort(null);
        System.out.println(names + "\n");

        System.out.println("Increasing length - Comparator class:");
        names.sort(new StringLengthComparator());
        System.out.println(names + "\n");


        System.out.println("Increasing length - lambda:");
        names.sort((str1,str2)->Integer.compare(str1.length(),str2.length()));
        System.out.println(names + "\n");

        //flipping the name causes a decrease in the order
        System.out.println("Decreasing length - lambda:");
        names.sort((str1,str2)->Integer.compare(str2.length(), str1.length()));
        System.out.println(names + "\n");

    }
}
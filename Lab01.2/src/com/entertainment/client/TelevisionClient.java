package com.entertainment.client;

import com.entertainment.Television;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class TelevisionClient {

    public static void main(String[] args) {
       //Review of Java1
        /* Television tv1 = new Television();
        Television tv2 = new Television("RCA", 10);
        System.out.println(tv1);

        //changing the channel
        tv2.changeChannel(9);
        System.out.println(tv2);
*/

        Television tvA = new Television("Sony", 50);
        Television tvB = new Television("Sony", 50);
        Television tvC = new Television("Samsung", 32);
        Television tvD = new Television("LG", 12);

        System.out.println(tvA.hashCode());
        System.out.println(tvB.hashCode());

        //use ==to show if tvA and tvB are "equal"
        System.out.println("tvA == tvB: "+ (tvA == tvB));

        //use equals() to show if tvA and TvB are "equal"
        System.out.println("tvA.equals(tvB): "+ (tvA.equals(tvB)));
        System.out.println();

        Set<Television> tvs = new TreeSet<>();
        tvs.add(tvA);
        tvs.add(tvB);
        tvs.add(tvC);
        tvs.add(tvD);
        System.out.println("The size of the Set is " + tvs.size());     //should be 3- no duplicates

        System.out.println("Tree Order of the Set is ");
        for (Television tv : tvs) {
            System.out.println(tv);
        }

    }
}
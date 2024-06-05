package com.entertainment.client;

import com.entertainment.Television;
import java.util.HashSet;
import java.util.Set;

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

        System.out.println(tvA.hashCode());
        System.out.println(tvB.hashCode());

        //use ==to show if tvA and tvB are "equal"
        System.out.println("tvA == tvB: "+ (tvA == tvB));

        //use equals() to show if tvA and TvB are "equal"
        System.out.println("tvA.equals(tvB): "+ (tvA.equals(tvB)));
        System.out.println();

        Set<Television> tvs = new HashSet<>();
        tvs.add(tvA);
        tvs.add(tvB);
        System.out.println("The size of the Set is " + tvs.size());     //should be 1

    }
}
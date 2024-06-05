package com.crisp;

import java.util.ArrayList;
import java.util.List;

class RadishSortTest {

    public static void main(String[] args) {
        List<Radish> radishes = new ArrayList<>();

        //color, size, tailLength, guysOnTop
        radishes.add(new Radish("white", 1.5, 2.5, 5));
        radishes.add(new Radish("black", 1.0, 0.0, 0));
        radishes.add(new Radish("red", 2.7, 5.5, 0));
        radishes.add(new Radish("pink", 0.9, 0.0, 6));


        dump(radishes);

        //sort by natural order ( passing null means natural order)
        System.out.println("Sort by Natural Order(size)");
        radishes.sort(null);
        dump(radishes);

        System.out.println("Sort by (color) via RadishColorComparator class");
        radishes.sort(new RadishColorComparator());
        dump(radishes);

        System.out.println("Sort by (guysOnTop) via RadishGuyOnTopComparator class");
        radishes.sort(new RadishGuysOnTopComparator());
        dump(radishes);

    }

    private static void dump(List<Radish> radishes) {
        for (Radish r : radishes) {
            System.out.println(r);
        }
        System.out.println();
    }
}
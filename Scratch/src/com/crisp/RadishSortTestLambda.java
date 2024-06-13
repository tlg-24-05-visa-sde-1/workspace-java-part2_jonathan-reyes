package com.crisp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
class RadishSortTestLambda {

    public static void main(String[] args) {
        List<Radish> radishes = new ArrayList<>();

        //color, size, tailLength, guysOnTop
        radishes.add(new Radish("white", 1.5, 2.5, 5));
        radishes.add(new Radish("black", 1.0, 0.0, 0));
        radishes.add(new Radish("red", 2.7, 5.5, 0));
        radishes.add(new Radish("pink", 0.9, 0.0, 6));


        dump(radishes);

        //sort by natural order ( passing null means natural order) - Comparable
        System.out.println("Sort by Natural Order(size)");
        radishes.sort(null);
        dump(radishes);

        //Comparator
        System.out.println("Sort by (color) via lambda");
        //radishes.sort((r1,r2) -> r1.getColor().compareTo(r2.getColor()) );
        radishes.sort(Comparator.comparing(Radish::getColor));              //using method references
        dump(radishes);

        System.out.println("Sort by (guysOnTop) via lambda");
        //radishes.sort((r1,r2)->Integer.compare(r1.getGuysOnTop(), r2.getGuysOnTop()));
        radishes.sort(Comparator.comparingDouble(Radish::getGuysOnTop));    //using method references
        dump(radishes);

        System.out.println("Sort by (size) via lambda");
        //radishes.sort((r1,r2)->Double.compare(r1.getSize(), r2.getSize()));
        radishes.sort(Comparator.comparingDouble(Radish::getSize));         //using method references
        dump(radishes);

        System.out.println("Sort by (tail length) via lambda");
        //radishes.sort((r1,r2)->Double.compare(r1.getTailLength(), r2.getTailLength()));
        radishes.sort(Comparator.comparingDouble(Radish::getTailLength));   //using method references
        dump(radishes);
    }

    private static void dump(List<Radish> radishes) {
        for (Radish r : radishes) {
            System.out.println(r);
        }
        System.out.println();
    }

}
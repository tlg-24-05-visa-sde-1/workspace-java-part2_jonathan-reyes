/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.catalog.test;

import com.javatunes.catalog.Catalog;
import com.javatunes.catalog.InMemoryCatalog;
import com.javatunes.catalog.MusicCategory;
import com.javatunes.catalog.MusicItem;

import java.util.ArrayList;
import java.util.Collection;


class InMemoryCatalogTest {

    /*
     * One by one, complete each test method below, and then "activate" it by
     * uncommenting the call to that method in main().
     *
     * Once you see that the test method verifies the corresponding business method
     * works correctly, you can comment out that call in main() and proceed to the next one.
     */
    public static void main(String[] args) {
        // testFindById();
        // testFindByKeyword();
        // testFindByCategory();
        // testSize();
        // testGetAll();
        // testCheapRock();
        // testFindSelfTitledAlbums();
        // testFindCheapRock();
       //  testFindGenreCount();

    }

    private static void testFindGenreCount() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        //testing finding a with a positive result
        int resultFound = catalog.findGenreCount(MusicCategory.ROCK);
        System.out.println("Genre count: " + resultFound);

        //testing finding a negative result
        int resultNotFound = catalog.findGenreCount(MusicCategory.JAZZ);
        System.out.println("Genre count: " + resultNotFound);
    }

    private static void testFindCheapRock() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        //testing finding a positive result
        Collection<MusicItem> resultFound = new ArrayList<>();
        resultFound = catalog.findCheapRock(11.97);
        dump(resultFound);

        //testing finding a negative result
        Collection<MusicItem> resultNotFound = new ArrayList<MusicItem>();
        resultNotFound = catalog.findCheapRock(5.00);
        System.out.println("Negative Result :" + resultNotFound.isEmpty());
    }

    private static void testFindSelfTitledAlbums() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        //testing finding a positive result
        Collection<MusicItem> resultFound;
        resultFound = catalog.findSelfTitledAlbums();
        dump(resultFound);

    }

    private static void testCheapRock() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        //testing finding a positive result
        Collection<MusicItem> resultFound = new ArrayList<>();
        resultFound = catalog.findCheapRock(11.97);
        dump(resultFound);

        //testing finding a negative result
        Collection<MusicItem> resultNotFound = new ArrayList<MusicItem>();
        resultNotFound = catalog.findCheapRock(5.00);
        System.out.println("Negative Result :" + resultNotFound.isEmpty());
    }

    private static void testFindById() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        //testing found item
        MusicItem found = catalog.findById(6L);
        System.out.println(found);

        //testing not found item =null
        MusicItem notFound = catalog.findById(100L);
        System.out.println(notFound);
    }

    private static void testFindByKeyword() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        //testing finding a positive result
        Collection<MusicItem> resultFound = new ArrayList<>();
        resultFound = catalog.findByKeyword("to");
        dump(resultFound);

        //testing finding a negative result
        Collection<MusicItem> resultNotFound = new ArrayList<MusicItem>();
        resultNotFound = catalog.findByKeyword("stop");
        System.out.println("Negative Result :" + resultNotFound.isEmpty());
    }

    private static void testFindByCategory() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        //testing finding a category with a result
        Collection<MusicItem> resultFound = new ArrayList<MusicItem>();
        resultFound = catalog.findByCategory(MusicCategory.ROCK);
        dump(resultFound);

        //testing finding a category without a result
        Collection<MusicItem> resultNotFound = new ArrayList<MusicItem>();
        resultNotFound = catalog.findByCategory(MusicCategory.JAZZ);
        System.out.println("Music Category not found: " + resultNotFound.isEmpty());
    }

    private static void testSize() {
    }

    private static void testGetAll() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        Collection<MusicItem> testedCollection = new ArrayList<>();
        testedCollection = catalog.getAll();
        dump(testedCollection);

    }

    private static void dump(Collection<MusicItem> items){
        for(MusicItem item : items){
            System.out.println(item);
        }
    }
}
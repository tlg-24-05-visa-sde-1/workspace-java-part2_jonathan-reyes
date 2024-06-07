/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import static org.junit.Assert.*;
import java.util.Collection;
import java.util.Map;

import org.junit.Test;
import com.entertainment.Television;

public class CatalogTest {

    @Test
    public void testFindByBrands_returnsEmptyMap_NoMatches() {
        Map<String,Collection<Television>> tvMap = Catalog.findByBrands("No-Matches", "NOT-FOUND");
        assertNotNull(tvMap);
        assertEquals(2,tvMap.size());

        Collection<Television> notMatchesTVs= tvMap.get("No-Matches");
        assertTrue(notMatchesTVs.isEmpty());

        Collection<Television> notFoundTVs= tvMap.get("NOT-FOUND");
        assertTrue(notFoundTVs.isEmpty());
    }

    @Test
    public void testFindByBrands_returnsPopulatedMap_MatchesFound() {
        Map<String,Collection<Television>> tvMap = Catalog.findByBrands("Sony","NOT-FOUND");
        assertEquals(2,tvMap.size());

        Collection<Television> sonyTVs= tvMap.get("Sony");
        assertEquals(7, sonyTVs.size());
        for (Television tv : sonyTVs) {
            assertEquals("Sony", tv.getBrand());
        }

        Collection<Television> notFoundTVs= tvMap.get("NOT-FOUND");
        assertTrue(notFoundTVs.isEmpty());

    }
    /**
     * Contract: a no-matches result should be an empty collection (not null).
     */
    @Test
    public void testFindByBrand_returnsEmptyCollection_NoMatches() {
        Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");
        assertNotNull(tvs);
        assertTrue(tvs.isEmpty());
    }

    @Test
    public void testFindByBrand_returnsPopulatedCollection_MatchesFound() {
        Collection<Television> tvs = Catalog.findByBrand("Sony");
        assertNotNull(tvs);
        assertEquals(7, tvs.size());
        for (Television tv : tvs) {
            assertEquals("Sony", tv.getBrand());
        }
    }

}
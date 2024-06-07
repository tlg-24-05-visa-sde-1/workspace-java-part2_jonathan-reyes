package com.javatunes.catalog;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class InMemoryCatalogTest {
    private InMemoryCatalog catalog;

    @Before
    public void setUp() {
        catalog = new InMemoryCatalog();
    }

    /*
    public void findByCategory_shouldReturnPopulatedCollection_categoryFound() {
        Collection<MusicItem> popItems =catalog.findByCategory(MusicCategory.POP);
        assertEquals(4,popItems.size());
        for(MusicItem mi : popItems){
            assertEquals(MusicCategory.POP,mi.getMusicCategory());
        }
    }

    @Test
    public void findByCategory_shouldReturnEmptyCollection_categoryNotFound() {
        Collection<MusicItem> jazzItems =catalog.findByCategory(MusicCategory.JAZZ);

        assertNotNull(jazzItems);

        assertEquals(0,jazzItems.size());

        assertTrue(jazzItems.isEmpty());
    }*/
    /*Testing findSelfTitledAlbums*/
    @Test
    public void findSelfTitledAlbums_shouldReturnPopulatedCollection() {
        Collection<MusicItem> sfItems =catalog.findSelfTitledAlbums();
        assertEquals(2,sfItems.size());
        for(MusicItem mi : sfItems){
            assertEquals(mi.getTitle(),mi.getArtist());
        }
    }

    /*Testing findByCategory*/
    @Test
    public void findByCategory_shouldReturnPopulatedCollection_categoryFound() {
        Collection<MusicItem> popItems =catalog.findByCategory(MusicCategory.POP);
        assertEquals(4,popItems.size());
        for(MusicItem mi : popItems){
            assertEquals(MusicCategory.POP,mi.getMusicCategory());
        }

    }
    @Test
    public void findByCategory_shouldReturnEmptyCollection_categoryNotFound() {
        Collection<MusicItem> jazzItems =catalog.findByCategory(MusicCategory.JAZZ);

        assertNotNull(jazzItems);

        assertEquals(0,jazzItems.size());

        assertTrue(jazzItems.isEmpty());
    }

    /*Testing findById()*/
    @Test
    public void findById_shouldReturnMusicItem_MatchingID() {
        MusicItem item = catalog.findById(1L);
        assertNotNull(item);
        assertEquals(1L,(long)item.getId());
        //assertEquals(6L, item.getId().longValue());
    }
    @Test
    public void findById_shouldReturnNull_idNotFound() {
        MusicItem item = catalog.findById(101L);
        assertNull(item);

    }
}
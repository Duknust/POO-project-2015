/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import base.CountriesData;
import base.Data;
import base.Position;
import caches.Cache;
import caches.Log;
import caches.Traditional;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.TreeMap;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author MrFabio
 */
public class UserTest {

    static User u1;
    static Reviewer r1;
    static Admin a1;
    static Data data;
    static Position p1;
    static Position p2;
    static Traditional tc1;
    static Traditional tc2;

    public UserTest() {
    }

    @BeforeClass
    public static void setUpClass() {

        data = new Data();
        u1 = new User("x@x.com", "12345", "Ulisses", "M", "rua", new GregorianCalendar(), false, 0, null, null, data);
        r1 = new Reviewer("x1@x.com", "12345", "Rickon", "M", "rua", new GregorianCalendar(), false, 0, null, null, data);
        a1 = new Admin("x2@x.com", "12345", "Aemon", "M", "rua", new GregorianCalendar(), false, 0, null, null, data);

        data.getAllUsers().put(u1.getName(), u1);
        data.getAllUsers().put(r1.getName(), r1);
        data.getAllUsers().put(a1.getName(), a1);

        p1 = CountriesData.portugal;
        p2 = new Position(41.57238, -8.47875, 1.5f);
        tc1 = new Traditional(new GregorianCalendar(), "some info", "New in Lisbon", 2, 2.5f, p1, "under the rock", new TreeMap<GregorianCalendar, Log>(), new ArrayList<>());
        tc2 = new Traditional(new GregorianCalendar(), "more info", "Em Braga", 4, 1.0f, p2, "under the bench", new TreeMap<GregorianCalendar, Log>(), new ArrayList<>());

    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of createCache method, of class User.
     */
    @Test
    public void testCreateCache() {
        System.out.println("createCache");
        u1.createCache(tc1);
        u1.createCache(tc2);

        assertEquals(u1.getCaches().get(tc1.getCacheID()).getCacheID(), tc1.getCacheID());
        assertEquals(u1.getCaches().get(tc2.getCacheID()).getCacheID(), tc2.getCacheID());

    }

    /**
     * Test of giveMeCache method, of class Reviewer.
     */
    @Test
    public void testGiveMeCache() {
        System.out.println("giveMeCache");

        Data datat = new Data();

        User usr = new User("x@x.com", "12345", "Ulisses", "M", "rua", new GregorianCalendar(), false, 0, null, null, datat);
        Reviewer rev = new Reviewer("x1@x.com", "12345", "Rickon", "M", "rua", new GregorianCalendar(), false, 0, null, null, datat);

        datat.getAllUsers().put(usr.getName(), usr);
        datat.getAllUsers().put(rev.getName(), rev);

        Traditional tca1 = new Traditional(new GregorianCalendar(), "some info", "New in Lisbon", 2, 2.5f, p1, "under the rock", new TreeMap<GregorianCalendar, Log>(), new ArrayList<>());

        usr.createCache(tca1);

        assertTrue(rev.getAssignedCaches().isEmpty());
        rev.giveMeCache();
        assertTrue(rev.getAssignedCaches().size() > 0);
    }

    /**
     * Test of getAssignedCaches method, of class Reviewer.
     */
    @Test
    public void testGetAssignedCaches() {
        System.out.println("getAssignedCaches");
        Data datat = new Data();

        User usr = new User("x@x.com", "12345", "Ulisses", "M", "rua", new GregorianCalendar(), false, 0, null, null, datat);
        Reviewer rev = new Reviewer("x1@x.com", "12345", "Rickon", "M", "rua", new GregorianCalendar(), false, 0, null, null, datat);

        datat.getAllUsers().put(usr.getName(), usr);
        datat.getAllUsers().put(rev.getName(), rev);

        Traditional tca1 = new Traditional(new GregorianCalendar(), "some info", "New in Lisbon", 2, 2.5f, p1, "under the rock", new TreeMap<GregorianCalendar, Log>(), new ArrayList<>());
        Traditional tca2 = new Traditional(new GregorianCalendar(), "more info", "Em Braga", 4, 1.0f, p2, "under the bench", new TreeMap<GregorianCalendar, Log>(), new ArrayList<>());

        usr.createCache(tca1);
        usr.createCache(tca2);

        assertTrue(rev.getAssignedCaches().isEmpty());
        rev.giveMeCache();
        assertTrue(rev.getAssignedCaches().size() > 0);
    }

    /**
     * Test of publishCache method, of class Reviewer.
     */
    @Test
    public void testPublishCache() {
        System.out.println("publishCache");

        Data datat = new Data();

        User usr = new User("x@x.com", "12345", "Ulisses", "M", "rua", new GregorianCalendar(), false, 0, null, null, datat);
        Reviewer rev = new Reviewer("x1@x.com", "12345", "Rickon", "M", "rua", new GregorianCalendar(), false, 0, null, null, datat);

        datat.getAllUsers().put(usr.getName(), usr);
        datat.getAllUsers().put(rev.getName(), rev);

        Traditional tca1 = new Traditional(new GregorianCalendar(), "some info", "New in Lisbon", 2, 2.5f, p1, "under the rock", new TreeMap<GregorianCalendar, Log>(), new ArrayList<>());
        Traditional tca2 = new Traditional(new GregorianCalendar(), "more info", "Em Braga", 4, 1.0f, p2, "under the bench", new TreeMap<GregorianCalendar, Log>(), new ArrayList<>());

        usr.createCache(tca1);
        usr.createCache(tca2);

        Cache c1 = rev.giveMeCache(tca1);
        Cache c2 = rev.giveMeCache(tca2);
        Cache c3 = rev.giveMeCache();

        assertTrue(rev.publishCache(c1));
        assertTrue(rev.publishCache(c2));
        assertFalse(rev.publishCache(c3));
    }

    /**
     * Test of archiveCache and enableCache methods, of class User.
     */
    @Test
    public void testArchiveEnableCache() {
        System.out.println("archiveCache");

        Data datat = new Data();

        User usr1 = new User("x@x.com", "12345", "Ulisses", "M", "rua", new GregorianCalendar(), false, 0, null, null, datat);
        User usr2 = new User("x@x.com", "12345", "Ulisses", "M", "rua", new GregorianCalendar(), false, 0, null, null, datat);
        Reviewer rev = new Reviewer("x1@x.com", "12345", "Rickon", "M", "rua", new GregorianCalendar(), false, 0, null, null, datat);
        Admin adm = new Admin("x2@x.com", "12345", "Aemon", "M", "rua", new GregorianCalendar(), false, 0, null, null, datat);

        datat.getAllUsers().put(usr1.getName(), usr1);
        datat.getAllUsers().put(rev.getName(), rev);
        datat.getAllUsers().put(adm.getName(), adm);

        Traditional tca1 = new Traditional(new GregorianCalendar(), "some info", "New in Lisbon", 2, 2.5f, p1, "under the rock", new TreeMap<GregorianCalendar, Log>(), new ArrayList<>());
        Traditional tca2 = new Traditional(new GregorianCalendar(), "more info", "Em Braga", 4, 1.0f, p2, "under the bench", new TreeMap<GregorianCalendar, Log>(), new ArrayList<>());

        usr1.createCache(tca1);
        usr1.createCache(tca2);

        Cache cc = rev.giveMeCache(tca1);
        rev.publishCache(cc);

        // assert
        // Admin enabling
        assertFalse(adm.enableCache(tca1)); // already published
        assertFalse(adm.enableCache(tca2)); // not published

        // Admin archiving
        assertTrue(adm.archiveCache(tca1));
        assertTrue(adm.archiveCache(tca2));

        // Admin enabling
        assertTrue(adm.enableCache(tca1));
        assertFalse(adm.enableCache(tca2));

        // Users archiving
        assertTrue(usr1.archiveCache(tca1)); // archiving owned
        assertFalse(usr2.archiveCache(tca1)); //archiving not owned

        // Users enabling
        assertTrue(usr1.enableCache(tca1)); // enabling owned
        assertFalse(usr2.enableCache(tca2)); //enabling not owned

        // Reviewers enabling and archiving
        assertTrue(rev.archiveCache(tca1));
        assertFalse(rev.archiveCache(tca2));

        assertTrue(rev.enableCache(tca1));
    }

}

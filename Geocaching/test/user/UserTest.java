/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import base.Data;
import base.Position;
import caches.Cache;
import caches.Log;
import caches.Traditional;
import dataCreation.CountriesData;
import java.util.GregorianCalendar;
import java.util.TreeSet;
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
    static CountriesData cd;

    public UserTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        cd = new CountriesData();
        data = new Data();
        u1 = new User("x@x.com", "12345", "Ulisses", "M", "rua", new GregorianCalendar(), false, 0, null, null, data);
        r1 = new Reviewer("x1@x.com", "12345", "Rickon", "M", "rua", new GregorianCalendar(), data);
        a1 = new Admin("x2@x.com", "12345", "Aemon", "M", "rua", new GregorianCalendar(), data);

        data.getAllUsers().put(u1.getEmail(), u1);
        data.getAllUsers().put(r1.getEmail(), r1);
        data.getAllUsers().put(a1.getEmail(), a1);

        p1 = cd.getCountryByName("Portugal", "Europe");
        p2 = new Position(41.57238, -8.47875, 1.5f);
        tc1 = new Traditional(new GregorianCalendar(), "some info", "New in Lisbon", 2, 2.5f, p1, "under the rock", new TreeSet<Log>(), data);
        tc2 = new Traditional(new GregorianCalendar(), "more info", "Em Braga", 4, 1.0f, p2, "under the bench", new TreeSet<Log>(), data);

    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of createEvent method, of class User.
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
     * Test of logCache method, of class User.
     */
    @Test
    public void testLogCache() {
        System.out.println("logCache");

        Data datat = new Data();

        User usr1 = new User("x@x.com", "12345", "Ulisses", "M", "rua", new GregorianCalendar(), false, 0, null, null, datat);
        User usr2 = new User("y@y.com", "12345", "Unter", "M", "rua", new GregorianCalendar(), false, 0, null, null, datat);
        Reviewer rev = new Reviewer("x1@x.com", "12345", "Rickon", "M", "rua", new GregorianCalendar(), datat);
        Admin adm = new Admin("x2@x.com", "12345", "Aemon", "M", "rua", new GregorianCalendar(), datat);

        datat.getAllUsers().put(usr1.getEmail(), usr1);
        datat.getAllUsers().put(usr1.getEmail(), usr2);
        datat.getAllUsers().put(rev.getEmail(), rev);
        datat.getAllUsers().put(adm.getEmail(), adm);

        Traditional tca1 = new Traditional(new GregorianCalendar(), "some info", "New in Lisbon", 2, 2.5f, p1, "under the rock", new TreeSet<Log>(), datat);
        Traditional tca2 = new Traditional(new GregorianCalendar(), "more info", "Em Braga", 4, 1.0f, p2, "under the bench", new TreeSet<Log>(), datat);

        usr1.createCache(tca1);
        usr1.createCache(tca2);

        Log log1 = new Log("FTF!", new GregorianCalendar(), Log.Log_Type.FOUND_IT);
        Log log2 = new Log("STF!", new GregorianCalendar(), Log.Log_Type.FOUND_IT);
        Log log3 = new Log("YEAH, got it!", new GregorianCalendar(), Log.Log_Type.FOUND_IT);
        Log log4 = new Log("Just a note!", new GregorianCalendar(), Log.Log_Type.NOTE);
        Log log5 = new Log("DNF, too much difficult!", new GregorianCalendar(), Log.Log_Type.DNF);
        Log log6 = new Log("A Note!", new GregorianCalendar(), Log.Log_Type.NOTE);
        Log log7 = new Log("Rev Note!", new GregorianCalendar(), Log.Log_Type.REVIEWER_NOTE);
        Log log8 = new Log("Another Note!", new GregorianCalendar(), Log.Log_Type.NOTE);
        Log log9 = new Log("Rev Note important!", new GregorianCalendar(), Log.Log_Type.REVIEWER_NOTE);

        Cache cc = rev.giveMeCache(tca1);
        rev.publishCache(cc);

        // tca1 enabled
        // tca2 unpublished
        assertTrue(usr1.logCache(log1, tca1));
        assertTrue(usr2.logCache(log2, tca1));

        assertFalse(usr1.logCache(log3, tca2));
        assertFalse(usr2.logCache(log4, tca2));
        assertFalse(usr2.logCache(log7, tca2));
        assertTrue(rev.logCache(log7, tca2));

        adm.archiveCache(tca1);
        // tca1 archived
        // tca2 unpublished
        assertTrue(usr1.logCache(log6, tca1));
        assertFalse(usr1.logCache(log5, tca1));
        assertFalse(usr2.logCache(log9, tca1));
        assertTrue(usr2.logCache(log8, tca1));

    }

    /**
     * Test of giveMeCache method, of class Reviewer.
     */
    @Test
    public void testGiveMeCache() {
        System.out.println("giveMeCache");

        Data datat = new Data();

        User usr = new User("x@x.com", "12345", "Ulisses", "M", "rua", new GregorianCalendar(), false, 0, null, null, datat);
        Reviewer rev = new Reviewer("x1@x.com", "12345", "Rickon", "M", "rua", new GregorianCalendar(), datat);

        datat.getAllUsers().put(usr.getEmail(), usr);
        datat.getAllUsers().put(rev.getEmail(), rev);

        Traditional tca1 = new Traditional(new GregorianCalendar(), "some info", "New in Lisbon", 2, 2.5f, p1, "under the rock", new TreeSet<Log>(), datat);

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
        Reviewer rev = new Reviewer("x1@x.com", "12345", "Rickon", "M", "rua", new GregorianCalendar(), datat);

        datat.getAllUsers().put(usr.getEmail(), usr);
        datat.getAllUsers().put(rev.getEmail(), rev);

        Traditional tca1 = new Traditional(new GregorianCalendar(), "some info", "New in Lisbon", 2, 2.5f, p1, "under the rock", new TreeSet<Log>(), datat);
        Traditional tca2 = new Traditional(new GregorianCalendar(), "more info", "Em Braga", 4, 1.0f, p2, "under the bench", new TreeSet<Log>(), datat);

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
        Reviewer rev = new Reviewer("x1@x.com", "12345", "Rickon", "M", "rua", new GregorianCalendar(), datat);

        datat.getAllUsers().put(usr.getEmail(), usr);
        datat.getAllUsers().put(rev.getEmail(), rev);

        Traditional tca1 = new Traditional(new GregorianCalendar(), "some info", "New in Lisbon", 2, 2.5f, p1, "under the rock", new TreeSet<Log>(), datat);
        Traditional tca2 = new Traditional(new GregorianCalendar(), "more info", "Em Braga", 4, 1.0f, p2, "under the bench", new TreeSet<Log>(), datat);

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
        User usr2 = new User("y@y.com", "12345", "Unter", "M", "rua", new GregorianCalendar(), false, 0, null, null, datat);
        Reviewer rev = new Reviewer("x1@x.com", "12345", "Rickon", "M", "rua", new GregorianCalendar(), datat);
        Admin adm = new Admin("x2@x.com", "12345", "Aemon", "M", "rua", new GregorianCalendar(), datat);

        datat.getAllUsers().put(usr1.getEmail(), usr1);
        datat.getAllUsers().put(rev.getEmail(), rev);
        datat.getAllUsers().put(adm.getEmail(), adm);

        Traditional tca1 = new Traditional(new GregorianCalendar(), "some info", "New in Lisbon", 2, 2.5f, p1, "under the rock", new TreeSet<Log>(), datat);
        Traditional tca2 = new Traditional(new GregorianCalendar(), "more info", "Em Braga", 4, 1.0f, p2, "under the bench", new TreeSet<Log>(), datat);

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

    /**
     * Test of login method, of class User.
     */
    @Test
    public void testLogin() {
        System.out.println("testLogin");

        String email = "mail@m.com";
        String password = "12345";
        User usr1 = new User(email, password, "Ulisses", "M", "rua", new GregorianCalendar(), false, 0, null, null, null);
        assertFalse(usr1.login("fake", "fake"));
        assertFalse(usr1.login(null, "fake"));
        assertFalse(usr1.login("fake", null));
        assertFalse(usr1.login(null, null));
        assertFalse(usr1.login(email, "fake"));
        assertFalse(usr1.login("fake", password));
        assertTrue(usr1.login(email, password));

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import base.CountriesData;
import base.Position;
import caches.Log;
import caches.Traditional;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.TreeMap;
import user.Admin;
import user.Reviewer;
import user.User;

/**
 *
 * @author MrFabio
 */
public class test1 {

    public static void main(String[] args) {

        User u1 = new User("x@x.com", "12345", "John", "M", "rua", new GregorianCalendar(), false, 0, "", null, null, null);
        Reviewer r1 = new Reviewer("x@x.com", "12345", "John", "M", "rua", new GregorianCalendar(), false, 0, "", null, null, null);
        Admin a1 = new Admin("x@x.com", "12345", "John", "M", "rua", new GregorianCalendar(), false, 0, "", null, null, null);

        Position p1 = CountriesData.portugal;
        Traditional tc1 = new Traditional(new GregorianCalendar(), "some info", "New in Lisbon", 2, 2.5f, p1, "under the rock", new TreeMap<GregorianCalendar, Log>(), new ArrayList<>());
        Traditional tc2 = new Traditional(new GregorianCalendar(), "more info", "Second in Lisbon", 4, 1.5f, p1, "under the bench", new TreeMap<GregorianCalendar, Log>(), new ArrayList<>());

        u1.createCache(tc1);
        u1.createCache(tc2);

        Log l1 = new Log(u1, "FTF!!!", "", Log.Trackable_State.NONE, new GregorianCalendar());
        Log l2 = new Log(u1, "FTF AGAIN!!!", "TR12312A", Log.Trackable_State.DROPPED, new GregorianCalendar());

        u1.logCache(l1, tc1);
        u1.logCache(l2, tc2);

        System.out.println(u1.toString());

    }

}

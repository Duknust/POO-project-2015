/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import base.CountriesData;
import base.Data;
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
        Data data = new Data();
        User u1 = new User("x@x.com", "12345", "Ulisses", "M", "rua", new GregorianCalendar(), false, 0, "", null, null, data);
        Reviewer r1 = new Reviewer("x1@x.com", "12345", "Rickon", "M", "rua", new GregorianCalendar(), false, 0, "", null, null, data);
        Admin a1 = new Admin("x2@x.com", "12345", "Aemon", "Wall", "rua", new GregorianCalendar(), false, 0, "", null, null, data);

        data.getAllUsers().put(u1.getName(), u1);
        data.getAllUsers().put(r1.getName(), r1);
        data.getAllUsers().put(a1.getName(), a1);

        Position p1 = CountriesData.portugal;
        Position p2 = new Position(41.57238, -8.47875, 1.5f);
        Traditional tc1 = new Traditional(new GregorianCalendar(), "some info", "New in Lisbon", 2, 2.5f, p1, "under the rock", new TreeMap<GregorianCalendar, Log>(), new ArrayList<>());
        Traditional tc2 = new Traditional(new GregorianCalendar(), "more info", "Em Braga", 4, 1.0f, p2, "under the bench", new TreeMap<GregorianCalendar, Log>(), new ArrayList<>());

        u1.createCache(tc1);
        u1.createCache(tc2);

        Log l1 = new Log(u1, "FTF!!!", "", Log.Trackable_State.NONE, new GregorianCalendar(), Log.Log_Type.FOUND_IT);
        Log l2 = new Log(u1, "FTF AGAIN!!!", "TR12312A", Log.Trackable_State.DROPPED, new GregorianCalendar(), Log.Log_Type.FOUND_IT);

        u1.logCache(l1, tc1);
        u1.logCache(l2, tc2);

        r1.giveMeCache();
        r1.publishCache(r1.getAssignedCaches().first());

        System.out.println(a1.archiveCache(tc2));
        System.out.println(a1.archiveCache(tc1));
        System.out.println(u1.archiveCache(tc1));
        System.out.println(r1.enableCache(tc1));

        System.out.println(u1.toString());

    }

}

package user;

import activity.Activity;
import base.Data;
import caches.Cache;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class Reviewer extends User {

    TreeSet<Cache> assignedCaches;

    // Constructors
    public Reviewer(String email, String password, String name, String gender, String address, GregorianCalendar birthDate, boolean premium, int totalFound, String tb, HashMap<String, Cache> caches, HashMap<String, User> friends, Data data) {
        super(email, password, name, gender, address, birthDate, premium, totalFound, tb, caches, friends, data);
        this.assignedCaches = new TreeSet<>();
    }

    public Reviewer(String email, String password, String name, String gender, String address, GregorianCalendar birthDate, boolean premium, int totalFound, String tb, HashMap<String, Cache> caches, HashMap<String, User> friends, Data data, TreeSet<Cache> assignedCaches) {
        super(email, password, name, gender, address, birthDate, premium, totalFound, tb, caches, friends, data);
        this.assignedCaches = assignedCaches;
    }

    // Getters and Setters
    public TreeSet<Cache> getAssignedCaches() {
        return assignedCaches;
    }

    // Methods
    public Cache giveMeCache() {
        Cache c = null;
        Iterator<Cache> it = super.getData().getUnpublishedCaches().values().iterator();

        while (it.hasNext()) {
            c = it.next();
            if (c.getReviewer() == null) {
                c.setReviewer(this);
                this.assignedCaches.add(c);
                return c;
            }
        }
        return c;
    }

    public void publishCache(Cache c) {
        c.enable();
        c.setPublishDate(new GregorianCalendar()); // Set the Published Date
        super.getData().getEnabledCaches().put(c.getCacheID(), c); // Move it from Unpublished to Published
        super.getData().getUnpublishedCaches().remove(c.getCacheID(), c);

        Activity act = new Activity(new GregorianCalendar(), Activity.Type.NEW_CACHE, c, c.getOwner()); // Create Activity
        super.getData().addActivity(act);
    }

}

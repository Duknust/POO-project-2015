package user;

import activity.Activity;
import base.Data;
import caches.Cache;
import caches.Log;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TreeSet;

public class Reviewer extends UserAbstract implements BasicCacheMethodsInterface, Serializable {

	private TreeSet<Cache> assignedCaches;

    // Constructors
    public Reviewer(String email, String password, String name, String gender,
            String address, GregorianCalendar birthDate, Data data) {
        super(email, password, name, gender, address, birthDate, data);
        this.assignedCaches = new TreeSet<>();
    }

    public Reviewer(String email, String password, String name, String gender,
            String address, GregorianCalendar birthDate, Data data,
            TreeSet<Cache> assignedCaches) {
        super(email, password, name, gender, address, birthDate, data);

        if (assignedCaches == null) {
            this.assignedCaches = new TreeSet<>();
        } else {
            this.assignedCaches = assignedCaches;
        }
    }

    // Getters and Setters
    public TreeSet<Cache> getAssignedCaches() {
        return assignedCaches;
    }

    // Methods
    @Override
    public boolean disableCache(Cache c) {

        if (c.getReviewer() == null) {
            return false;
        }
        // If I am the reviewer
        if (c.getReviewer().equals(this) == false) {
            return false;
        }

        if (c.getCacheStatus() != Cache.Status.ENABLED) // Can only disable a enabled cache
        {
            return false;
        }

        super.getData().getEnabledCaches().remove(c.getCacheID(), c);
        c.setCacheState(Cache.Status.DISABLED); // Disable it
        super.getData().getDisabledCaches().put(c.getCacheID(), c);

        Activity act = new Activity(new GregorianCalendar(), Activity.Type.DISABLED_CACHE, c, this); // Create Activity
        super.getData().addActivity(act);

        return true;
    }

    @Override
    public boolean archiveCache(Cache c) {

        if (c.getReviewer() == null) {
            return false;
        }
        if (c.getReviewer().equals(this) == false) { // If I am the reviewer
            return false;
        }

        switch (c.getCacheStatus()) // Can only disable a enabled cache
        {
            case ARCHIVED: // Already archived
                return false;

            case UNPUBLISHED:
                super.getData().getUnpublishedCaches().remove(c.getCacheID(), c);
                c.setCacheState(Cache.Status.ARCHIVED);
                super.getData().getArchivedCaches().put(c.getCacheID(), c);
                break;
            case ENABLED:

                super.getData().getEnabledCaches().remove(c.getCacheID(), c);
                c.setCacheState(Cache.Status.ARCHIVED);
                super.getData().getArchivedCaches().put(c.getCacheID(), c);
                break;
            case DISABLED:

                super.getData().getDisabledCaches().remove(c.getCacheID(), c);
                c.setCacheState(Cache.Status.ARCHIVED);
                super.getData().getArchivedCaches().put(c.getCacheID(), c);
                break;
        }

        Activity act = new Activity(new GregorianCalendar(), Activity.Type.ARCHIVED_CACHE, c, this); // Create Activity
        super.getData().addActivity(act);

        return true;
    }

    @Override
    public boolean enableCache(Cache c) {

        if (c.getReviewer() == null) {
            return false;
        }
        if (c.getReviewer().equals(this) == false) { // If I am the reviewer
            return false;
        }

        switch (c.getCacheStatus()) // Can only disable a enabled cache
        {
            case ENABLED: // Already enabled
            case UNPUBLISHED: // Not published, if reviewer he should use publishCache
                return false;

            case ARCHIVED:
                if (c.getPublishDate() == null) {
                    return false; // Can't enable a cache that is unpublished and archived
                }
                super.getData().getArchivedCaches().remove(c.getCacheID(), c);
                c.setCacheState(Cache.Status.ENABLED);
                super.getData().getEnabledCaches().put(c.getCacheID(), c);
                break;

            case DISABLED:
                super.getData().getDisabledCaches().remove(c.getCacheID(), c);
                c.setCacheState(Cache.Status.ENABLED);
                super.getData().getEnabledCaches().put(c.getCacheID(), c);
                break;
        }

        Activity act = new Activity(new GregorianCalendar(), Activity.Type.ENABLED_CACHE, c, this); // Create Activity
        super.getData().addActivity(act);

        return true;
    }

    @Override
    public boolean logCache(Log l, Cache c) {

        if (c == null) {
            return false;
        }
        if (l == null) {
            return false;
        }

        switch (l.getLogType()) {
            case DNF:
            case FOUND_IT:
                return false;

        }

        if (c.logCache(this, l) == false) {
            return false;
        }

        return true;
    }

    // Only Reviewer
    public boolean publishCache(Cache c) {

        if (c == null) {
            return false;
        }

        if (c.getPublishDate() != null) {
            return false; // Already Published
        }

        // obviously not an User
        if (c.getReviewer() == null) {
            return false;
        } else if (c.getReviewer().equals(this) == false) { // and not the assigned reviewer
            return false;
        }

        // Remove all the logs
        c.clearLogs();

        //c.logCache(this, new Log("Enabled Listing", new GregorianCalendar(), Log.Log_Type.ENABLED));
        c.setPublishDate(new GregorianCalendar()); // Set the Published Date
        c.enable();
        super.getData().getEnabledCaches().put(c.getCacheID(), c); // Move it from Unpublished to Published
        super.getData().getUnpublishedCaches().remove(c.getCacheID(), c);

        Activity act = new Activity(new GregorianCalendar(),
                Activity.Type.NEW_CACHE, c, this); // Create Activity
        super.getData().addActivity(act);
        return true;
    }

    public Cache giveMeCache() {
        Cache c = null;
        Iterator<Cache> it = super.getData().getUnpublishedCaches().values()
                .iterator();

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

    public Cache giveMeCache(Cache c) {
        if (c == null) {
            return c;
        }

        if (super.getData().getUnpublishedCaches().values().contains(c)) {
            c = super.getData().getUnpublishedCaches().get(c.getCacheID());
            c.setReviewer(this);
            this.assignedCaches.add(c);
            return c;
        } else {
            return null;
        }
    }

    @Override
    public Role getRole() {
        return Role.REVIEWER;
    }

    @Override
    public int nFindFromType(Cache.Type type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // toString
    @Override
    public String toString() {
        return super.getName() + " - " + getRole();
    }

    @Override
    public String toStringTotal() {
        return "E-Mail - " + super.getEmail()
                + "\nName - " + super.getName()
                + "\nGender - " + super.getGender()
                + "\nAddress - " + super.getAddress()
                + "\nBirth Date - " + formatDate(super.getBirthDate())
                + "\nRole - " + getRole();
    }

}

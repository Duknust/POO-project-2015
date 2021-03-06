package user;

import activity.Activity;
import base.Data;
import caches.Cache;
import caches.Event;
import caches.Log;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Admin extends UserAbstract implements BasicCacheMethodsInterface, Serializable {

    private HashMap<String, Event> events = null;

    public Admin(String email, String password, String name, String gender, String address, GregorianCalendar birthDate, Data data) {
        super(email, password, name, gender, address, birthDate, data);
        this.events = new HashMap<>();
    }

    public Admin(String email, String password, String name, String gender, String address, GregorianCalendar birthDate, Data data, HashMap<String, Event> events) {
        super(email, password, name, gender, address, birthDate, data);
        this.events = events;
    }

    public HashMap<String, Event> getEvents() {
        return events;
    }

    void deleteLog(Log l, Cache c) {
        c.getCache_Logs().remove(l);
    }

    @Override
    public boolean disableCache(Cache c) {

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

    public boolean createEvent(Event event) {
        if (event.getType() != Cache.Type.EVENT) {
            return false;
        }
        HashMap<String, Cache> map = super.getData().getAllCachesAndUnpublished();
        if (map == null) {
            return false;
        }

        if (map.containsKey(event.getCacheID()) == true) {
            return false;
        }
        event.setCacheID(event.genID(6));
        event.setOwner(this);
        event.setCacheState(Cache.Status.UNPUBLISHED);
        super.getData().getUnpublishedCaches().put(event.getCacheID(), event);
        this.events.put(event.getCacheID(), event);
        //Activity ac = new Activity(new GregorianCalendar(), Activity.Type.NEW_CACHE, cache, this);
        //super.getData().addActivity(ac);

        return true;
    }

    @Override
    public Role getRole() {
        return Role.ADMIN;
    }

    @Override
    public int nFindFromType(Cache.Type type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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

    @Override
    public String toStringOthers() {
        return "Name - " + super.getName()
                + "\nGender - " + super.getGender()
                + "\nRole - " + getRole();
    }
}

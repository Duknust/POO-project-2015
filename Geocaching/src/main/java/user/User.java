package user;

import activity.Activity;
import base.Data;
import caches.Cache;
import caches.Log;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class User extends UserAbstract implements Serializable {

    private HashMap<String, Cache> caches = null;
    private HashMap<String, User> friends = null;
    private Data data = new Data();

    // Constructors
    public User(String email, String password, String name, String gender, String address, GregorianCalendar birthDate, boolean premium, int totalFound, HashMap<String, Cache> caches, HashMap<String, User> friends, Data data) {
        super(email, password, name, gender, address, birthDate, premium, totalFound);

        if (caches == null) {
            this.caches = new HashMap<String, Cache>();
        } else {
            this.caches = caches;
        }

        if (friends == null) {
            this.friends = new HashMap<String, User>();
        } else {
            this.friends = friends;
        }

        this.data = data;
    }

    // Getters and Setters
    public String getEmail() {
        return super.getEmail();
    }
    /*
     public void setEmail(String email) {
     super.setEmail(email);
     }*/

    public byte[] getPassword() {
        return super.getPassword();
    }

    public void setPassword(String password) {
        super.setPassword(password);
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public String getGender() {
        return super.getGender();
    }

    public void setGender(String gender) {
        super.setGender(gender);
    }

    public String getAddress() {
        return super.getAddress();
    }

    public void setAddress(String address) {
        super.setAddress(address);
    }

    public GregorianCalendar getBirthDate() {
        return super.getBirthDate();
    }

    public void setBirthDate(GregorianCalendar birthDate) {
        super.setBirthDate(birthDate);
    }

    public HashMap<String, Cache> getCaches() {
        return this.caches;
    }

    public void setCaches(HashMap<String, Cache> caches) {
        this.setCaches(caches);
    }

    public HashMap<String, User> getFriends() {
        return this.friends;
    }

    public void setFriends(HashMap<String, User> friends) {
        this.friends = friends;
    }

    public boolean isPremium() {
        return super.isPremium();
    }

    public void setPremium(boolean premium) {
        super.setPremium(premium);
    }

    public int getTotalFound() {
        return super.getTotalFound();
    }

    public void setTotalFound(int totalFound) {
        super.setTotalFound(totalFound);
    }

    public Data getData() {
        return this.data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    // Methods
    public boolean createCache(Cache cache) {
        HashMap<String, Cache> map = this.data.getAllCaches();
        if (map == null) {
            return false;
        }

        if (map.containsKey(cache.getCacheID()) == true) {
            return false;
        }
        cache.setCacheID(cache.genID(6));
        cache.setOwner(this);
        cache.setCacheState(Cache.Status.UNPUBLISHED);
        this.data.getUnpublishedCaches().put(cache.getCacheID(), cache);
        this.caches.put(cache.getCacheID(), cache);
        return true;
    }

    public boolean disableCache(Cache c) {

        if (this instanceof Admin == true)
            ; else if (this instanceof Reviewer) {
            if (c.getReviewer() == null) {
                return false;
            }
            if (c.getReviewer().equals(this) == false) { // If I am the reviewer
                return false;
            }

        } else if (this instanceof User) {
            if (c.getOwner().equals(this) == false) { // If I am not the owner
                return false;
            }
        }

        if (c.getCacheStatus() != Cache.Status.ENABLED) // Can only disable a enabled cache
        {
            return false;
        }

        this.data.getEnabledCaches().remove(c.getCacheID(), c);
        c.setCacheState(Cache.Status.DISABLED); // Disable it
        this.data.getDisabledCaches().put(c.getCacheID(), c);

        Activity act = new Activity(new GregorianCalendar(), Activity.Type.DISABLED_CACHE, c, c.getOwner()); // Create Activity
        this.data.addActivity(act);

        return true;
    }

    public boolean archiveCache(Cache c) {

        if (this instanceof Admin == true)
            ; else if (this instanceof Reviewer) {
            if (c.getReviewer() == null) {
                return false;
            }
            if (c.getReviewer().equals(this) == false) { // If I am the reviewer
                return false;
            }

        } else if (this instanceof User) {
            if (c.getOwner().equals(this) == false) { // If I am not the owner
                return false;
            }
        }

        switch (c.getCacheStatus()) // Can only disable a enabled cache
        {
            case ARCHIVED: // Already archived
                return false;

            case UNPUBLISHED:
                this.data.getUnpublishedCaches().remove(c.getCacheID(), c);
                c.setCacheState(Cache.Status.ARCHIVED);
                this.data.getArchivedCaches().put(c.getCacheID(), c);
                break;
            case ENABLED:

                this.data.getEnabledCaches().remove(c.getCacheID(), c);
                c.setCacheState(Cache.Status.ARCHIVED);
                this.data.getArchivedCaches().put(c.getCacheID(), c);
                break;
            case DISABLED:

                this.data.getDisabledCaches().remove(c.getCacheID(), c);
                c.setCacheState(Cache.Status.ARCHIVED);
                this.data.getArchivedCaches().put(c.getCacheID(), c);
                break;
        }

        Activity act = new Activity(new GregorianCalendar(), Activity.Type.ARCHIVED_CACHE, c, c.getOwner()); // Create Activity
        this.data.addActivity(act);

        return true;
    }

    public boolean enableCache(Cache c) {

        if (this instanceof Admin == true)
            ; else if (this instanceof Reviewer) {
            if (c.getReviewer() == null) {
                return false;
            }
            if (c.getReviewer().equals(this) == false) { // If I am the reviewer
                return false;
            }

        } else if (this instanceof User) {
            if (c.getOwner().equals(this) == false) { // If I am not the owner
                return false;
            }
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
                this.data.getArchivedCaches().remove(c.getCacheID(), c);
                c.setCacheState(Cache.Status.ENABLED);
                this.data.getEnabledCaches().put(c.getCacheID(), c);
                break;

            case DISABLED:
                this.data.getDisabledCaches().remove(c.getCacheID(), c);
                c.setCacheState(Cache.Status.ENABLED);
                this.data.getEnabledCaches().put(c.getCacheID(), c);
                break;
        }

        Activity act = new Activity(new GregorianCalendar(), Activity.Type.ENABLED_CACHE, c, c.getOwner()); // Create Activity
        this.data.addActivity(act);

        return true;
    }

    public boolean logCache(Log l, Cache c) {

        if (c == null) {
            return false;
        }
        if (l == null) {
            return false;
        }

        l.setUser(this); // Assign this user to the log

        if (c.logCache(this, l) == false) {
            return false;
        }

        if (l.getLogType() == Log.Log_Type.FOUND_IT) {
            this.incFounds(1);
        }
        return true;
    }

    // toString
    @Override
    public String toString() {
        return "User:\n" + super.toString();
    }

    // Increment by number the Number of Founds
    private void incFounds(int number) {
        this.setTotalFound(this.getTotalFound() + number);
    }
}

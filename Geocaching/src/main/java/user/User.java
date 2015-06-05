package user;

import activity.Activity;
import base.Data;
import caches.Cache;
import caches.Log;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class User extends UserAbstract implements BasicCacheMethodsInterface, Serializable {

    private HashMap<String, Cache> caches = null;
    private HashMap<String, User> friends = null;
    private int totalFound;

    // Constructors
    public User(String email, String password, String name, String gender, String address, GregorianCalendar birthDate, boolean premium, int totalFound, HashMap<String, Cache> caches, HashMap<String, User> friends, Data data) {
        super(email, password, name, gender, address, birthDate, premium, data);

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

        this.totalFound = totalFound;

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
        return totalFound;
    }

    public void setTotalFound(int totalFound) {
        this.totalFound = totalFound;
    }

    // Methods
    public boolean createCache(Cache cache) {
        HashMap<String, Cache> map = super.getData().getAllCachesAndUnpublished();
        if (map == null) {
            return false;
        }

        if (map.containsKey(cache.getCacheID()) == true) {
            return false;
        }
        cache.setCacheID(cache.genID(6));
        cache.setOwner(this);
        cache.setCacheState(Cache.Status.UNPUBLISHED);
        super.getData().getUnpublishedCaches().put(cache.getCacheID(), cache);
        this.caches.put(cache.getCacheID(), cache);
        //Activity ac = new Activity(new GregorianCalendar(), Activity.Type.NEW_CACHE, cache, this);
        //super.getData().addActivity(ac);

        return true;
    }

    @Override
    public boolean disableCache(Cache c) {

        // If I am not the owner
        if (c.getOwner().equals(this) == false) {
            return false;
        }

        if (c.getCacheStatus() != Cache.Status.ENABLED) // Can only disable a enabled cache
        {
            return false;
        }

        super.getData().getEnabledCaches().remove(c.getCacheID(), c);
        c.setCacheState(Cache.Status.DISABLED); // Disable it
        super.getData().getDisabledCaches().put(c.getCacheID(), c);

        Activity act = new Activity(new GregorianCalendar(), Activity.Type.DISABLED_CACHE, c, c.getOwner()); // Create Activity
        super.getData().addActivity(act);

        return true;
    }

    @Override
    public boolean archiveCache(Cache c) {

        if (c.getOwner().equals(this) == false) { // If I am not the owner
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

        Activity act = new Activity(new GregorianCalendar(), Activity.Type.ARCHIVED_CACHE, c, c.getOwner()); // Create Activity
        super.getData().addActivity(act);

        return true;
    }

    @Override
    public boolean enableCache(Cache c) {

        if (c.getOwner().equals(this) == false) { // If I am not the owner
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

        Activity act = new Activity(new GregorianCalendar(), Activity.Type.ENABLED_CACHE, c, c.getOwner()); // Create Activity
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

        if (c.logCache(this, l) == false) {
            return false;
        }

        if (l.getLogType() == Log.Log_Type.FOUND_IT) {
            this.incFounds(1);
        }
        return true;
    }

    public void newFriendship(User u2) {
        this.friends.put(u2.getEmail(), u2);
        u2.friends.put(this.getEmail(), this);

        Activity ac = new Activity(new GregorianCalendar(), Activity.Type.FRIENDS_WITH, this, u2);
        super.getData().addActivity(ac);
    }

    public void removeFriendship(User u2) {
        this.friends.remove(u2.getEmail(), u2);
        u2.friends.remove(this.getEmail(), this);

        Activity ac = new Activity(new GregorianCalendar(), Activity.Type.NOT_FRIENDS_WITH, this, u2);
        super.getData().addActivity(ac);
    }

    public void incTotalFound() {
        this.totalFound++;
    }

    public void decTotalFound() {
        this.totalFound--;
    }

    // toString
    @Override
    public String toString() {
        return super.getName() + " (" + totalFound + ")" + (super.isPremium() ? " Premium" : "");
    }

    @Override
    public String toStringTotal() {
        return "E-Mail - " + super.getEmail()
                + "\nName - " + super.getName()
                + "\nGender - " + super.getGender()
                + "\nAddress - " + super.getAddress()
                + "\nBirth Date - " + formatDate(super.getBirthDate())
                + "\nPremium - " + super.isPremium()
                + "\nTotal Found - " + totalFound;
    }

    @Override
    public String toStringOthers() {
        return "Name - " + super.getName()
                + "\nGender - " + super.getGender()
                + "\nPremium - " + super.isPremium()
                + "\nTotal Found - " + totalFound
                + "\nTotal Owned Caches - " + this.caches.size()
                + "\nFriends - " + this.friends.size() + "\n";
    }

    public String friendsToString() {
        StringBuilder sb = new StringBuilder();
        for (UserAbstract u : this.friends.values()) {
            sb.append("\t" + u.toString() + "\n");
        }
        return sb.toString();
    }

    public ArrayList<User> getFriendsArray() {

        ArrayList<User> array = new ArrayList<User>();

        for (User u : this.getFriends().values()) {
            array.add(u);
        }
        return array;
    }

    public ArrayList<Cache> getCachesArray() {

        ArrayList<Cache> array = new ArrayList<Cache>();

        for (Cache c : this.getCaches().values()) {
            array.add(c);
        }
        return array;
    }

    public ArrayList<Cache> getCachesArrayPremiumCheck(UserAbstract userOnline) {
        ArrayList<Cache> array = new ArrayList<Cache>();

        for (Cache c : this.getCaches().values()) {
            if (c.isPremiumOnly() == false || (c.isPremiumOnly() == true && userOnline.isPremium() == true)) // Check for Premium Only Caches
            {
                array.add(c);
            }

        }
        return array;
    }

    // Increment by number the Number of Founds
    private void incFounds(int number) {
        this.setTotalFound(this.getTotalFound() + number);
    }

    @Override
    public Role getRole() {
        return Role.USER;
    }

    public boolean isFriendsWith(User friend) {
        return this.friends.containsKey(friend.getEmail());
    }

    @Override
    public int nFindFromType(Cache.Type type) {
        int res = 0;
        for (Cache c : this.caches.values()) {
            if (c.getType() == type) {
                res++;
            }
        }
        return res;
    }

}

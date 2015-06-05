package base;

import activity.Activity;
import caches.Cache;
import caches.Event;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import user.User;
import user.UserAbstract;

public class Data implements Serializable {

    HashMap<String, Cache> enabledCaches = null; // The published ones
    HashMap<String, Cache> disabledCaches = null;
    HashMap<String, Cache> unpublishedCaches = null;
    HashMap<String, Cache> archivedCaches = null;

    HashMap<String, Event> enabledEvents = null;
    HashMap<String, Event> pastEvents = null;

    HashMap<String, UserAbstract> allUsers = null;
    TreeMap<GregorianCalendar, Activity> allActivities = null;

    TreeMap<String, Position> allPositions = null;

    public Data() {
        enabledCaches = new HashMap<>();
        disabledCaches = new HashMap<>();
        unpublishedCaches = new HashMap<>();
        archivedCaches = new HashMap<>();
        allUsers = new HashMap<>();
        allActivities = new TreeMap<>(new ComparatorActivity());
        allPositions = new TreeMap<>();

        enabledEvents = new HashMap<String, Event>();
        pastEvents = new HashMap<String, Event>();
    }

    // Getters and Setters
    public HashMap<String, Event> getEnabledEvents() {
        return enabledEvents;
    }

    public HashMap<String, Event> getPastEvents() {
        return pastEvents;
    }

    public HashMap<String, Cache> getEnabledCaches() {
        return enabledCaches;
    }

    public void setEnabledCaches(HashMap<String, Cache> enabledCaches) {
        this.enabledCaches = enabledCaches;
    }

    public HashMap<String, Cache> getDisabledCaches() {
        return disabledCaches;
    }

    public void setDisabledCaches(HashMap<String, Cache> disabledCaches) {
        this.disabledCaches = disabledCaches;
    }

    public HashMap<String, Cache> getUnpublishedCaches() {
        return unpublishedCaches;
    }

    public void setUnpublishedCaches(HashMap<String, Cache> unpublishedCaches) {
        this.unpublishedCaches = unpublishedCaches;
    }

    public HashMap<String, Cache> getArchivedCaches() {
        return archivedCaches;
    }

    public void setArchivedCaches(HashMap<String, Cache> archivedCaches) {
        this.archivedCaches = archivedCaches;
    }

    public HashMap<String, UserAbstract> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(HashMap<String, UserAbstract> allUsers) {
        this.allUsers = allUsers;
    }

    public TreeMap<GregorianCalendar, Activity> getAllActivities() {
        return allActivities;
    }

    public void setAllActivities(TreeMap<GregorianCalendar, Activity> allActivities) {
        this.allActivities = allActivities;
    }

    public TreeMap<String, Position> getAllPositions() {
        return allPositions;
    }

    public void setAllPositions(TreeMap<String, Position> allPositions) {
        this.allPositions = allPositions;
    }

    // Methods
    public HashMap<String, Cache> getAllCaches() {

        HashMap<String, Cache> allCaches = new HashMap<>();

        allCaches.putAll(archivedCaches);
        allCaches.putAll(enabledCaches);
        allCaches.putAll(disabledCaches);
        return allCaches;
    }

    public HashMap<String, Cache> getAllCachesAndUnpublished() {

        HashMap<String, Cache> allCaches = new HashMap<>();

        allCaches.putAll(archivedCaches);
        allCaches.putAll(enabledCaches);
        allCaches.putAll(disabledCaches);
        allCaches.putAll(unpublishedCaches);
        return allCaches;
    }

    public void addActivity(Activity act) {
        if (act == null) {
            return;
        }
        while (this.allActivities.containsKey(act.getDate()) == true) {
            act.incMs();
        }

        this.allActivities.put(act.getDate(), act);
    }

    public SortedSet<Cache> getCachesFrom(User u) {

        SortedSet<Cache> list = new TreeSet<>(compareCachePubDate());

        HashMap<String, Cache> allCaches = getAllCaches();

        for (Cache c : allCaches.values()) {
            if (c.getOwner().equals(u)) {
                list.add(c);
            }
        }

        return list;
    }

    public SortedSet<Cache> getCachesFoundFrom(User u) {

        SortedSet<Cache> list = new TreeSet<>(compareCachePubDate());

        HashMap<String, Cache> allCaches = getAllCaches();

        for (Cache c : allCaches.values()) {
            if (c.hasFound(u)) {
                list.add(c);
            }
        }

        return list;
    }

    public Comparator<Cache> compareCachePubDate() {
        return new Comparator<Cache>() {
            public int compare(Cache o1, Cache o2) {
                return -1 * o1.getPublishDate().compareTo(o2.getPublishDate());
            }
        };
    }

    public Comparator<Event> compareEventAppDate() {
        return new Comparator<Event>() {
            public int compare(Event o1, Event o2) {
                return -1 * o1.getDateEndApplications().compareTo(o2.getDateEndApplications());
            }
        };
    }

    public Comparator<Event> compareEventDate() {
        return new Comparator<Event>() {
            public int compare(Event o1, Event o2) {
                return -1 * o1.getDateEvent().compareTo(o2.getDateEvent());
            }
        };
    }

    public HashMap<String, Cache> getByPosition(Position p, int nCaches) {

        double dist[] = new double[nCaches];
        Cache auxCache, caches[] = new Cache[nCaches];
        GeoTools geo = new GeoTools();
        double auxDist, aux;
        int i, added = 0;

        for (Cache c : this.enabledCaches.values()) {
            auxDist = geo.calcDistance(p, c.getPosition());
            i = 0;

            while (i < added) {
                if (auxDist > dist[i]) {
                    break;
                }
                i++;
            }

            if (i < nCaches) {
                while (i < nCaches) {
                    aux = dist[i];
                    dist[i] = auxDist;
                    auxDist = aux;

                    auxCache = caches[i];
                    caches[i] = c;
                    c = auxCache;

                    i++;
                }
                if (added < nCaches) {
                    added++;
                }
            }
        }

        HashMap<String, Cache> inHash = new HashMap<String, Cache>();
        for (i = 0; i < added; i++) {
            inHash.put(caches[i].getCacheID(), caches[i]);
        }

        return inHash;
    }

    ArrayList<Activity> getActivitiesArray(UserAbstract user, int total) {
        int i = 0;
        ArrayList<Activity> array = new ArrayList<Activity>();

        for (Activity c : this.getAllActivities().values()) {
            if (c.aboutWithCache(user)) {
                array.add(c);
                i++;
                if (i >= total) {
                    break;
                }
            }
        }
        return array;
    }

    // Timeline with myself
    ArrayList<Activity> getActivitiesFriendsArray(User user, int total) {
        int i = 0;
        ArrayList<Activity> array = new ArrayList<>();
        ArrayList<User> userlist = user.getFriendsArray();
        //userlist.add(user); // add the user to the list
        for (Activity c : this.getAllActivities().values()) {
            for (User f : userlist) {
                if (c.about(f)) { // Only user related
                    if (array.contains(c) == false) { // Check Duplicates like 'friends with'
                        array.add(c);
                        i++;
                        if (i >= total) {
                            return array;
                        }
                    }
                }
            }

            if (c.aboutWithCache(user)) { // now including user's cache related
                if (array.contains(c) == false) { // Check Duplicates like 'friends with'
                    array.add(c);
                    i++;
                    if (i >= total) {
                        return array;
                    }
                }
            }
        }
        return array;
    }

    // Has to be a class in order to be serializable with TreeMap
    private class ComparatorActivity implements Serializable, Comparator<GregorianCalendar> {

        @Override
        public int compare(GregorianCalendar a1, GregorianCalendar a2) {
            if (a1.before(a2)) {
                return 1;
            } else if (a1.after(a2)) {
                return -1;
            }
            return 0;
        }
    }
}

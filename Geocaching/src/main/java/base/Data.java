package base;

import activity.Activity;
import caches.Cache;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.TreeMap;
import user.UserAbstract;

public class Data implements Serializable {

    HashMap<String, Cache> enabledCaches = null; // The published ones
    HashMap<String, Cache> disabledCaches = null;
    HashMap<String, Cache> unpublishedCaches = null;
    HashMap<String, Cache> archivedCaches = null;

    HashMap<String, UserAbstract> allUsers = null;
    TreeMap<GregorianCalendar, Activity> allActivities = null;

    TreeMap<String, Position> allPositions = null;

    public Data() {
        enabledCaches = new HashMap<>();
        disabledCaches = new HashMap<>();
        unpublishedCaches = new HashMap<>();
        archivedCaches = new HashMap<>();
        allUsers = new HashMap<>();
        allActivities = new TreeMap<>();
        allPositions = new TreeMap<>();
    }

    // Getters and Setters
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
        allCaches.putAll(unpublishedCaches);
        return allCaches;
    }

    public void addActivity(Activity act) {
        this.allActivities.put(act.getDate(), act);
    }

}

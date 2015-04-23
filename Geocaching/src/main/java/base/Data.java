package base;

import activity.Activity;
import caches.Cache;
import java.io.Serializable;
import java.util.HashMap;
import java.util.TreeMap;
import user.User;

public class Data implements Serializable {

    HashMap<String, Cache> enabledCaches = null;
    HashMap<String, Cache> disabledCaches = null;
    HashMap<String, Cache> unpublishedCaches = null;
    HashMap<String, Cache> archivedCaches = null;

    HashMap<String, User> allUsers = null;
    TreeMap<String, Activity> allActivities = null;

    public Data() {
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

    public HashMap<String, User> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(HashMap<String, User> allUsers) {
        this.allUsers = allUsers;
    }

    public TreeMap<String, Activity> getAllActivities() {
        return allActivities;
    }

    public void setAllActivities(TreeMap<String, Activity> allActivities) {
        this.allActivities = allActivities;
    }

    public HashMap<String, Cache> getAllCaches() {

        HashMap<String, Cache> allCaches = new HashMap<>();

        allCaches.putAll(archivedCaches);
        allCaches.putAll(enabledCaches);
        allCaches.putAll(disabledCaches);
        allCaches.putAll(unpublishedCaches);
        return allCaches;
    }

}

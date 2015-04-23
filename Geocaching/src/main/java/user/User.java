package user;

import base.Data;
import caches.Cache;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

public abstract class User implements Serializable {

    private String email;
    private String password;
    private String name;
    private String gender;
    private String address;
    private GregorianCalendar birthDate;
    private boolean premium;
    private int totalFound;
    private String trackable;

    private ArrayList<Cache> caches = null;
    private HashMap<String, User> friends = null;
    private Data data = null;

    // Constructors
    public User(String email, String password, String name, String gender, String address, GregorianCalendar birthDate, boolean premium, int totalFound, String tb, ArrayList<Cache> caches, HashMap<String, User> friends, Data data) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.birthDate = birthDate;
        this.premium = premium;
        this.totalFound = totalFound;
        this.trackable = tb;
        this.caches = caches;
        this.friends = friends;
        this.data = data;
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public GregorianCalendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(GregorianCalendar birthDate) {
        this.birthDate = birthDate;
    }

    public ArrayList<Cache> getCaches() {
        return caches;
    }

    public void setCaches(ArrayList<Cache> caches) {
        this.caches = caches;
    }

    public HashMap<String, User> getFriends() {
        return friends;
    }

    public void setFriends(HashMap<String, User> friends) {
        this.friends = friends;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public int getTotalFound() {
        return totalFound;
    }

    public void setTotalFound(int totalFound) {
        this.totalFound = totalFound;
    }

    public String getTrackable() {
        return trackable;
    }

    public void setTb(String tb) {
        this.trackable = tb;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    // Methods
    public void removeTb() {
        this.trackable = "";
    }

    public boolean createCache(Cache cache) {
        if (this.data.getAllCaches().containsKey(cache.getCacheID()) == false) {
            return false;
        }
        cache.setCacheID(cache.genID(6));
        cache.setOwner(this);
        cache.setCacheState(Cache.Status.UNPUBLISHED);
        this.data.getUnpublishedCaches().put(cache.getCacheID(), cache);
        return true;
    }

    // toString
    @Override
    public String toString() {
        return "'" + name + " (" + totalFound + ")'" + (premium ? " Premium" : "");
    }
}

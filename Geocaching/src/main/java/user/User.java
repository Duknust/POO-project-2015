package user;

import base.Data;
import caches.Cache;
import caches.Log;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class User extends UserAbstract implements Serializable {

    private HashMap<String, Cache> caches = null;
    private HashMap<String, User> friends = null;
    private Data data = null;

    // Constructors
    public User(String email, String password, String name, String gender, String address, GregorianCalendar birthDate, boolean premium, int totalFound, String tb, HashMap<String, Cache> caches, HashMap<String, User> friends, Data data) {
        super(email, password, name, gender, address, birthDate, premium, totalFound, tb);
        this.caches = caches;
        this.friends = friends;
        this.data = data;
    }

    // Getters and Setters
    public String getEmail() {
        return super.getEmail();
    }

    public void setEmail(String email) {
        super.setEmail(email);
    }

    public String getPassword() {
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
        return this.getCaches();
    }

    public void setCaches(HashMap<String, Cache> caches) {
        this.setCaches(caches);
    }

    public HashMap<String, User> getFriends() {
        return this.getFriends();
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

    public String getTrackable() {
        return super.getTrackable();
    }

    public void setTb(String tb) {
        super.setTb(tb);
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    // Methods
    public void removeTb() {
        super.setTb("");
    }

    public boolean createCache(Cache cache) {
        if (this.data.getAllCaches().containsKey(cache.getCacheID()) == true) {
            return false;
        }
        cache.setCacheID(cache.genID(6));
        cache.setOwner(this);
        cache.setCacheState(Cache.Status.UNPUBLISHED);
        this.data.getUnpublishedCaches().put(cache.getCacheID(), cache);
        return true;
    }

    public void logCache(Log l, Cache c) {
        c.logCache(this, l);
    }

    // toString
    @Override
    public String toString() {
        return "User:\n" + super.toString();
    }
}

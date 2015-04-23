package user;

import caches.Cache;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

public abstract class User {

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

	// Constructors
    public User(String email, String password, String name, String gender, String address, GregorianCalendar birthDate, boolean premium, int totalFound, String tb, ArrayList<Cache> caches, HashMap<String, User> friends) {
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

	// Methods
    public void removeTb() {
        this.trackable = "";
    }

	// toString
    @Override
    public String toString() {
        return "'" + name + " (" + totalFound + ")'" + (premium ? " Premium" : "");
    }
}

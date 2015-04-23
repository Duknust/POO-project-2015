package caches;

import base.Position;
import caches.Log.Trackable_State;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Objects;
import user.User;

public abstract class Cache implements Serializable, Comparable<Cache> {

    public enum Status {

        UNPUBLISHED, ENABLED, DISABLED, ARCHIVED;

        @Override
        public String toString() {
            switch (this) {
                case UNPUBLISHED:
                    return "Unpublished";
                case ENABLED:
                    return "Enabled";
                case DISABLED:
                    return "Disabled";
                case ARCHIVED:
                    return "Archived";
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    private GregorianCalendar publishDate; // Date cache was published
    private GregorianCalendar creationDate; // Date cache was created
    private String cacheID; // Cache ID number
    private boolean premiumOnly; // Cache Premium
    private String description; // Cache description
    private Status cacheState; // Cache Status
    private String cacheTitle; // Cache name
    private User owner; // Who placed the cache
    private int cacheSize; // Type of container
    private float difficulty; // How difficult is it to find the cache
    private Position position;
    private String hint; // Hints to find the cache
    private ArrayList<Log> cache_Logs; // Cache logs
    private ArrayList<String> travel_bugs; // Travel bugs in cache container

    // Constructors
    public Cache(GregorianCalendar creationDate, String cacheID, String description, Status cacheState, String cacheTitle, User owner, int cacheSize, float difficulty, Position position, String hint, ArrayList<Log> cache_Logs, ArrayList<String> travel_bugs) {
        this.creationDate = creationDate;
        this.cacheID = cacheID;
        this.description = description;
        this.cacheState = cacheState;
        this.cacheTitle = cacheTitle;
        this.owner = owner;
        this.cacheSize = cacheSize;
        this.difficulty = difficulty;
        this.position = position;
        this.hint = hint;
        this.cache_Logs = cache_Logs;
        this.travel_bugs = travel_bugs;
    }

    // w/o ID
    public Cache(GregorianCalendar creationDate, String description, String cacheTitle, int cacheSize, float difficulty, Position position, String hint, ArrayList<Log> cache_Logs, ArrayList<String> travel_bugs) {
        this.creationDate = creationDate;
        this.description = description;
        this.cacheState = Status.UNPUBLISHED;
        this.cacheTitle = cacheTitle;
        this.cacheSize = cacheSize;
        this.difficulty = difficulty;
        this.position = position;
        this.hint = hint;
        this.cache_Logs = cache_Logs;
        this.travel_bugs = travel_bugs;
    }

    // Getters and Setters
    public GregorianCalendar getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(GregorianCalendar publishDate) {
        this.publishDate = publishDate;
    }

    public GregorianCalendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(GregorianCalendar creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isPremiumOnly() {
        return premiumOnly;
    }

    public void setPremiumOnly(boolean premiumOnly) {
        this.premiumOnly = premiumOnly;
    }

    public String getCacheID() {
        return cacheID;
    }

    public void setCacheID(String cacheID) {
        this.cacheID = cacheID;
    }

    public Status getCacheState() {
        return cacheState;
    }

    public void setCacheState(Status cacheState) {
        this.cacheState = cacheState;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCacheTitle() {
        return cacheTitle;
    }

    public void setCacheTitle(String cacheTitle) {
        this.cacheTitle = cacheTitle;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public int getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public float getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(float difficulty) {
        this.difficulty = difficulty;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public ArrayList<Log> getCache_Logs() {
        return cache_Logs;
    }

    public void setCache_Logs(ArrayList<Log> cache_Logs) {
        this.cache_Logs = cache_Logs;
    }

    public ArrayList<String> getTravel_bugs() {
        return travel_bugs;
    }

    public void setTravel_bugs(ArrayList<String> travel_bugs) {
        this.travel_bugs = travel_bugs;
    }

    // Methods
    public void disable() {
        this.cacheState = Status.DISABLED;
    }

    public void enable() {
        this.cacheState = Status.ENABLED;
    }

    public void logCache(User user, String logUser, Trackable_State dropTb, GregorianCalendar date) {
        Log log;

        log = new Log(user, logUser, user.getTrackable(), dropTb, date);
        user.removeTb();
        this.cache_Logs.add(log);
    }

    public String genID(int size) {
        return Long.toHexString(Double.doubleToLongBits(Math.random())).substring(15 - size, 15).toUpperCase();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cache other = (Cache) obj;
        if (!Objects.equals(this.cacheID, other.cacheID)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Cache other) {
        // compareTo should return < 0 if this is supposed to be
        // less than other, > 0 if this is supposed to be greater than
        // other and 0 if they are supposed to be equal
        return this.cacheID.compareTo(other.cacheID);

    }

    // ToString
    @Override
    public String toString() {
        return "Cache{"
                + "publishDate=" + publishDate
                + ", cacheID='" + cacheID + '\''
                + ", description='" + description + '\''
                + ", cacheState=" + cacheState
                + ", cacheTitle='" + cacheTitle + '\''
                + ", premiumOnly='" + premiumOnly + '\''
                + ", owner=" + owner
                + ", cacheSize=" + cacheSize
                + ", difficulty=" + difficulty
                + ", position=" + position
                + ", hint='" + hint + '\''
                + ", travel_bugs=" + travel_bugs
                + ", cache_Logs=" + cache_Logs
                + '}';
    }

    public String toListing(String type) {
        return "\nTitle = '" + cacheTitle + '\''
                + "\nType = " + type
                + "\nPublishing Date = " + publishDate
                + "\nCache ID = '" + cacheID + '\''
                + "\nCacheState = " + cacheState
                + "\nOwner = " + owner
                + "\nSize = " + cacheSize
                + "\nDifficulty = " + difficulty
                + position.toListing()
                + "\nTravel bugs (" + travel_bugs.size() + ")  =  " + travel_bugs
                + "\nDescription = '" + description + '\''
                + "\nHint = '" + hint + '\'';
    }

    public String toLogsListing() {
        return "\nCache Log = " + cache_Logs;
    }
}

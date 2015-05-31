package caches;

import base.Position;
import caches.Log.Log_Type;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.TreeSet;

import user.Admin;
import user.Reviewer;
import user.User;
import user.UserAbstract;

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

    public enum Type {

        CITO, EARTH, EVENT, LETTERBOX, MYSTERY, MULTI, TRADITIONAL, DEFAULT;

        @Override
        public String toString() {
            switch (this) {
                case CITO:
                    return "CITO";
                case EARTH:
                    return "Earth";
                case EVENT:
                    return "Event";
                case LETTERBOX:
                    return "Letterbox";
                case MYSTERY:
                    return "Mystery";
                case MULTI:
                    return "Multi";
                case TRADITIONAL:
                    return "Traditional";
                case DEFAULT:
                    return "";
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
    private UserAbstract owner; // Who placed the cache
    private int cacheSize; // Type of container
    private float difficulty; // How difficult is it to find the cache
    private Position position;
    private String hint; // Hints to find the cache
    private TreeSet<Log> cache_Logs; // Cache logs
    private Reviewer reviewer = null; // Reviewer responsible

    // Constructors
    public Cache(GregorianCalendar publishDate, GregorianCalendar creationDate, String cacheID, boolean premiumOnly, String description, Status cacheState, String cacheTitle, UserAbstract owner, int cacheSize, float difficulty, Position position, String hint, TreeSet<Log> cache_Logs, Reviewer reviewer) {
        this.publishDate = publishDate;
        this.creationDate = creationDate;
        this.cacheID = cacheID;
        this.premiumOnly = premiumOnly;
        this.description = description;
        this.cacheState = cacheState;
        this.cacheTitle = cacheTitle;
        this.owner = owner;
        this.cacheSize = cacheSize;
        this.difficulty = difficulty;
        this.position = position;
        this.hint = hint;
        this.cache_Logs = cache_Logs;
        this.reviewer = reviewer;
    }

    // w/o ID
    public Cache(GregorianCalendar creationDate, String description, String cacheTitle, int cacheSize, float difficulty, Position position, String hint, TreeSet<Log> cache_Logs, Reviewer reviewer) {
        this.creationDate = creationDate;
        this.description = description;
        this.cacheState = Status.UNPUBLISHED;
        this.cacheTitle = cacheTitle;
        this.cacheSize = cacheSize;
        this.difficulty = difficulty;
        this.position = position;
        this.hint = hint;
        this.cache_Logs = cache_Logs;
        this.reviewer = reviewer;
    }

    // w/o ID and Reviewer
    public Cache(GregorianCalendar creationDate, String description, String cacheTitle, int cacheSize, float difficulty, Position position, String hint, TreeSet<Log> cache_Logs) {
        this.creationDate = creationDate;
        this.description = description;
        this.cacheState = Status.UNPUBLISHED;
        this.cacheTitle = cacheTitle;
        this.cacheSize = cacheSize;
        this.difficulty = difficulty;
        this.position = position;
        this.hint = hint;
        this.cache_Logs = cache_Logs;
    }
    
 // w/o ID && Reviewer && Hint && Difficulty && CacheSize && Cache-Logs
    public Cache(GregorianCalendar creationDate, String description, String cacheTitle, Position position, UserAbstract owner) {
        this.creationDate = creationDate;
        this.owner = owner;
        this.cacheTitle = cacheTitle;
        this.description = description;
        this.cacheState = Status.UNPUBLISHED;
        this.cacheSize = 0;
        this.difficulty = 0;
        this.position = position;
        this.hint = "No Hint";
        this.cache_Logs =  new TreeSet<Log>();
        this.premiumOnly = false;
        this.cacheID = genID(6);
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

    public Status getCacheStatus() {
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

    public UserAbstract getOwner() {
        return owner;
    }

    public void setOwner(UserAbstract owner) {
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

    public TreeSet<Log> getCache_Logs() {
        return cache_Logs;
    }

    public void setCache_Logs(TreeSet<Log> cache_Logs) {
        this.cache_Logs = cache_Logs;
    }

    public Reviewer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }

    // Methods
    public void disable() {
        this.cacheState = Status.DISABLED;
    }

    public void enable() {
        if (getPublishDate() != null) {// Only Enable if was Published before
            this.cacheState = Status.ENABLED;
        }
    }

    public boolean logCache(User user, Log log) {// CHECK THIS , STUFF MISSING !!!

        switch (this.getCacheStatus()) {
            case UNPUBLISHED:
                // If Reviewer
                if (user instanceof Reviewer == true) {
                    if (this.reviewer == null) {
                        return false; // No Reviewer No Log
                    } else if (this.reviewer.equals(user) == false) {
                        return false; // If this Reviewer is not assigned, No Log
                    }
                    if (log.getLogType() != Log.Log_Type.REVIEWER_NOTE) { // Check Log Type
                        return false;
                    }

                } else if (user instanceof Admin == true) {
                    if (log.getLogType() != Log.Log_Type.REVIEWER_NOTE) { // Check Log Type
                        return false;
                    }
                } else // User
                {
                    if (this.getOwner().equals(user)) // If he is the Owner
                    {
                        if (log.getLogType() != Log.Log_Type.REVIEWER_NOTE) { // Check Log Type
                            return false;
                        }
                    } else // Not the Owner
                    {
                        return false;
                    }
                }
                break;

            case DISABLED:
                // Everyone can log
                if (log.getLogType() != Log.Log_Type.NOTE) { // Check Log Type
                    return false;
                }
                break;

            case ARCHIVED:
                // Everyone can log
                if (log.getLogType() != Log.Log_Type.NOTE) { // Check Log Type
                    return false;
                }
                break;

            case ENABLED:
                // Everyone can log
                if (log.getLogType() == Log.Log_Type.ARCHIVED || log.getLogType() == Log.Log_Type.DISABLED
                        || log.getLogType() == Log.Log_Type.ENABLED) { // Check Log Type
                    return false;
                } else if (log.getLogType() == Log.Log_Type.REVIEWER_NOTE) {
                    if (user instanceof Reviewer == true) {
                        if (user.equals(this.getReviewer()) == false) {
                            return false; // Not the assigned Reviewer
                        }
                    } else {
                        return false;
                    }
                }
                break;

        }

        log.setUser(user);
        if (log.getLogType() == Log_Type.FOUND_IT) {// If the User Found It
            user.incTotalFound(); // Then increment by 1 the Total Founds
        }
        this.cache_Logs.add(log);
        return true;
    }

    public String genID(int size) {
        return "GC" + Long.toHexString(Double.doubleToLongBits(Math.random())).substring(15 - size, 15).toUpperCase();
    }

    public void clearLogs() {
        this.cache_Logs.clear();
    }

    public static String formatDateTime(GregorianCalendar calendar) {
        if (calendar == null) {
            return "-/-/-";
        }
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        fmt.setCalendar(calendar);
        return fmt.format(calendar.getTime());
    }

    public boolean hasFound(User user) {
        for (Log l : this.cache_Logs) {
            if (l.getUser().equals(user) && l.getLogType() == Log.Log_Type.FOUND_IT) { // If User has a 'Found It' Log
                return true; // Then he Found it !
            }
        }
        return false;
    }

    public TreeSet<Log> getLogs(User user) {
        TreeSet<Log> list = new TreeSet<>();
        for (Log l : this.cache_Logs) {
            if (l.getUser().equals(user)) {
                list.add(l);
            }
        }
        return list;
    }

    private int getTotalType(Log_Type type) {
        int total = 0;
        for (Log l : this.cache_Logs) {
            if (l.getLogType() == type) {
                total++;
            }
        }
        return total;
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

    public boolean deleteLog(Log log) {
        return this.cache_Logs.remove(log);
    }

    @Override
    public int compareTo(Cache other) {
        // compareTo should return < 0 if this is supposed to be
        // less than other, > 0 if this is supposed to be greater than
        // other and 0 if they are supposed to be equal
        return this.cacheID.compareTo(other.cacheID);

    }

    // Should be Overrided
    public Type getType() {
        return Type.DEFAULT;
    }

    // ToString
    @Override
    public String toString() {
        return "Cache{"
                + "publishDate=" + formatDateTime(publishDate)
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
                + ", cache_Logs=" + cache_Logs
                + '}';
    }

    public String toListing() {
        return "\nTitle = '" + cacheTitle + '\''
                + "\nType = " + getType()
                + "\nCreation Date = " + formatDateTime(creationDate)
                + "\nPublishing Date = " + formatDateTime(publishDate)
                + "\nCache ID = '" + cacheID + '\''
                + "\nCacheState = " + cacheState
                + "\nOwner = " + owner
                + "\nSize = " + cacheSize
                + "\nDifficulty = " + difficulty + "\n"
                + position.toListing()
                + "\nDescription = '" + description + '\''
                + "\nHint = '" + hint + '\''
                + "\nTotal Founds= " + getTotalType(Log_Type.FOUND_IT)
                + "\nTotal Not Founds= " + getTotalType(Log_Type.DNF);
    }

    public String toSimpleListing() {
        return cacheID
                + " '" + cacheTitle + '\''
                + " (" + getType() + ")"
                + " D " + difficulty
                + " / T " + position.getDifficulty()
                + " (" + formatDateTime(publishDate) + ")";
    }

    public String toLogsListing() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nCache Logs = \n");

        for (Log log : cache_Logs) {
            sb.append(log.toLogListing() + "\n\n");
        }

        return sb.toString();
    }
}

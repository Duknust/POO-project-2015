package activity;

import caches.Cache;
import java.io.Serializable;
import java.util.GregorianCalendar;
import user.UserAbstract;

public class Activity implements Comparable<Activity>, Serializable {

    public enum Type {

        NEW_CACHE, FOUND_CACHE, NOT_FOUND_CACHE, ARCHIVED_CACHE, DISABLED_CACHE, ENABLED_CACHE
    }

    private GregorianCalendar date;
    private Type type;
    private Cache cache;
    private UserAbstract user;

    public Activity(GregorianCalendar date, Type type, Cache cache, UserAbstract user) {
        this.date = date;
        this.type = type;
        this.cache = cache;
        this.user = user;
    }

    @Override
    public int compareTo(Activity other) {
        // compareTo should return < 0 if this is supposed to be
        // less than other, > 0 if this is supposed to be greater than
        // other and 0 if they are supposed to be equal
        if (this.date.before(other.getDate())) {
            return 1;
        } else if (this.date.after(other.getDate())) {
            return -1;
        }
        return 0;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public Type getType() {
        return type;
    }

    public Cache getCache() {
        return cache;
    }

    @Override
    public String toString() {
        String res = "";
        switch (this.type) {
            case NEW_CACHE:
                res = this.cache.getOwner().getName() + " published \""
                        + this.cache.getCacheTitle() + "\" "
                        + this.cache.getClass().getSimpleName() + " cache";
                break;
            case FOUND_CACHE:
                res = this.user.getName() + " found \""
                        + this.cache.getCacheTitle() + "\"";
                break;
            case NOT_FOUND_CACHE:
                res = this.user.getName() + " didn't found \""
                        + this.cache.getCacheTitle() + "\"";
                break;
            case ARCHIVED_CACHE:
                res = "\"" + this.cache.getCacheTitle() + "\" has been archived by " + this.user.getName();
                break;
            case DISABLED_CACHE:
                res = "\"" + this.cache.getCacheTitle() + "\" has been disabled by " + this.user.getName();
                break;
            case ENABLED_CACHE:
                res = "\"" + this.cache.getCacheTitle() + "\" has been enabled by " + this.user.getName();
                break;
            default:
                break;
        }
        return res + "[" + this.date.toString() + "]";
    }
}

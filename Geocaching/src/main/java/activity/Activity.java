package activity;

import java.io.Serializable;
import java.util.GregorianCalendar;

import user.User;
import caches.Cache;

public abstract class Activity implements Comparable<Activity>, Serializable {

	public enum Type {

		NEW_CACHE, FOUND_CACHE, NOT_FOUND_CACHE, ARCHIVED_CACHE
	}

	private GregorianCalendar date;
	private Type type;
	private Cache cache;
	private User user;

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
			res = "\"" + this.cache.getCacheTitle() + "\" has been archived";
			break;
		default:
			break;
		}
		return res + "[" + this.date.toString() + "]";
	}
}

package activity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;

import user.UserAbstract;
import caches.Cache;
import caches.Log;

public class Activity implements Comparable<Activity>, Serializable {

	public enum Type {

		NEW_CACHE, FOUND_CACHE, DIDNT_FIND_CACHE, ARCHIVED_CACHE, DISABLED_CACHE, ENABLED_CACHE, UPDATED_LOG_TYPE, FRIENDS_WITH, NOT_FRIENDS_WITH, REV_NOTE, NOTE
	}

	private GregorianCalendar date;
	private Type type;
	private Cache cache;
	private UserAbstract user1, user2;
	private Log log;

	public Activity(GregorianCalendar date, Type type, Cache cache,
			UserAbstract user, Log log) {
		this.date = date;
		this.type = type;
		this.cache = cache;
		this.user1 = user;
		this.log = log;
	}

	public Activity(GregorianCalendar date, Type type, Cache cache,
			UserAbstract user) {
		this.date = date;
		this.type = type;
		this.cache = cache;
		this.user1 = user;
	}

	public Activity(GregorianCalendar date, Type type, UserAbstract user1,
			UserAbstract user2) {
		this.date = date;
		this.type = type;
		this.user1 = user1;
		this.user2 = user2;
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

	public static Comparator<GregorianCalendar> compareActivityDate() {
		return (GregorianCalendar a1, GregorianCalendar a2) -> {
			if (a1.before(a2)) {
				return 1;
			} else if (a1.after(a2)) {
				return -1;
			}
			return 0;
		};
	}

	public void incMs() {
		this.date.add(Calendar.MILLISECOND, 1);
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

	public UserAbstract getUser1() {
		return user1;
	}

	public UserAbstract getUser2() {
		return user2;
	}

	public Log getLog() {
		return log;
	}

	// Methods
	public static String formatDateTime(GregorianCalendar calendar) {
		if (calendar == null) {
			return "-/-/-";
		}
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		fmt.setCalendar(calendar);
		return fmt.format(calendar.getTime());
	}

	public boolean about(UserAbstract user) {

		if (this.user1.equals(user)) {
			return true;
		}

		if (this.user2 != null) {
			if (this.user2.equals(user)) {
				return true;
			}
		}

		return false;
	}

	public boolean aboutWithCache(UserAbstract user) {

		if (this.user1.equals(user)) {
			return true;
		}

		if (this.user2 != null) {
			if (this.user2.equals(user)) {
				return true;
			}
		}

		if (this.cache != null) {
			if (cache.getOwner().equals(user)
					&& (this.user1.getRole() == UserAbstract.Role.REVIEWER)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String toString() {
		String res = "";
		switch (this.type) {
		case NEW_CACHE:
			res = this.user1.getName() + " published \""
					+ this.cache.getCacheTitle() + "\" "
					+ this.cache.getClass().getSimpleName() + " cache from "
					+ this.cache.getOwner().getName();
			break;
		case FOUND_CACHE:
			res = this.user1.getName() + " Found \""
					+ this.cache.getCacheTitle() + "\"";
			break;
		case DIDNT_FIND_CACHE:
			res = this.user1.getName() + " didn't Find \""
					+ this.cache.getCacheTitle() + "\"";
			break;
		case REV_NOTE:
			res = this.user1.getName() + " posted a Reviewer Note on \""
					+ this.cache.getCacheTitle() + "\"";
			break;
		case NOTE:
			res = this.user1.getName() + " posted a Note on \""
					+ this.cache.getCacheTitle() + "\"";
			break;
		case ARCHIVED_CACHE:
			res = "\"" + this.cache.getCacheTitle() + "\" from "
					+ this.cache.getOwner().getName()
					+ " has been Archived by " + this.user1.getName();
			break;
		case DISABLED_CACHE:
			res = "\"" + this.cache.getCacheTitle() + "\" from "
					+ this.cache.getOwner().getName()
					+ " has been Disabled by " + this.user1.getName();
			break;
		case ENABLED_CACHE:
			res = "\"" + this.cache.getCacheTitle() + "\" from "
					+ this.cache.getOwner().getName() + " has been Enabled by "
					+ this.user1.getName();
			break;
		case UPDATED_LOG_TYPE:
			res = "The " + this.user1.getName() + "'s log from \""
					+ this.cache.getCacheTitle() + "\" has been updated to "
					+ this.log.getLogType();
			break;
		case FRIENDS_WITH:
			res = this.user1.getName() + " is now Friends with "
					+ this.user2.getName();
			break;
		case NOT_FRIENDS_WITH:
			res = this.user1.getName() + " is no longer Friends with "
					+ this.user2.getName();
			break;
		default:
			break;
		}
		return res + " [" + formatDateTime(this.date) + "]";
	}

}

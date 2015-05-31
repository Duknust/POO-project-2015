package user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

import activity.Activity;
import base.Data;
import caches.Cache;
import caches.Log;

public class User extends UserAbstract implements Serializable, UserInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 946492540751758063L;
	private HashMap<String, Cache> caches = null;
	private HashMap<String, User> friends = null;
	private Data data = new Data();

	// Constructors
	public User(String email, String password, String name, String gender,
			String address, GregorianCalendar birthDate, boolean premium,
			int totalFound, HashMap<String, Cache> caches,
			HashMap<String, User> friends, Data data) {
		super(email, password, name, gender, address, birthDate, premium,
				totalFound);

		if (caches == null) {
			this.caches = new HashMap<String, Cache>();
		} else {
			this.caches = caches;
		}

		if (friends == null) {
			this.friends = new HashMap<String, User>();
		} else {
			this.friends = friends;
		}

		this.data = data;
	}

	// Getters and Setters
	@Override
	public String getEmail() {
		return super.getEmail();
	}

	/*
	 * public void setEmail(String email) { super.setEmail(email); }
	 */

	@Override
	public byte[] getPassword() {
		return super.getPassword();
	}

	@Override
	public void setPassword(String password) {
		super.setPassword(password);
	}

	@Override
	public String getName() {
		return super.getName();
	}

	@Override
	public void setName(String name) {
		super.setName(name);
	}

	@Override
	public String getGender() {
		return super.getGender();
	}

	@Override
	public void setGender(String gender) {
		super.setGender(gender);
	}

	@Override
	public String getAddress() {
		return super.getAddress();
	}

	@Override
	public void setAddress(String address) {
		super.setAddress(address);
	}

	@Override
	public GregorianCalendar getBirthDate() {
		return super.getBirthDate();
	}

	@Override
	public void setBirthDate(GregorianCalendar birthDate) {
		super.setBirthDate(birthDate);
	}

	public HashMap<String, Cache> getCaches() {
		return this.caches;
	}

	public void setCaches(HashMap<String, Cache> caches) {
		this.setCaches(caches);
	}

	public HashMap<String, User> getFriends() {
		return this.friends;
	}

	public void setFriends(HashMap<String, User> friends) {
		this.friends = friends;
	}

	@Override
	public boolean isPremium() {
		return super.isPremium();
	}

	@Override
	public void setPremium(boolean premium) {
		super.setPremium(premium);
	}

	@Override
	public int getTotalFound() {
		return super.getTotalFound();
	}

	@Override
	public void setTotalFound(int totalFound) {
		super.setTotalFound(totalFound);
	}

	public Data getData() {
		return this.data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	// Methods
	public boolean createCache(Cache cache) {
		HashMap<String, Cache> map = this.data.getAllCachesAndUnpublished();
		if (map == null) {
			return false;
		}

		if (map.containsKey(cache.getCacheID()) == true) {
			return false;
		}
		cache.setCacheID(cache.genID(6));
		cache.setOwner(this);
		cache.setCacheState(Cache.Status.UNPUBLISHED);
		this.data.getUnpublishedCaches().put(cache.getCacheID(), cache);
		this.caches.put(cache.getCacheID(), cache);
		return true;
	}

	public boolean disableCache(Cache c) {

		if (this instanceof Admin == true)
			;
		else if (this instanceof Reviewer) {
			if (c.getReviewer() == null) {
				return false;
			}
			if (c.getReviewer().equals(this) == false) { // If I am the reviewer
				return false;
			}

		} else if (this instanceof User) {
			if (c.getOwner().equals(this) == false) { // If I am not the owner
				return false;
			}
		}

		if (c.getCacheStatus() != Cache.Status.ENABLED) // Can only disable a
														// enabled cache
		{
			return false;
		}

		this.data.getEnabledCaches().remove(c.getCacheID(), c);
		c.setCacheState(Cache.Status.DISABLED); // Disable it
		this.data.getDisabledCaches().put(c.getCacheID(), c);

		Activity act = new Activity(new GregorianCalendar(),
				Activity.Type.DISABLED_CACHE, c, c.getOwner()); // Create
																// Activity
		this.data.addActivity(act);

		return true;
	}

	public boolean archiveCache(Cache c) {

		if (this instanceof Admin == true)
			;
		else if (this instanceof Reviewer) {
			if (c.getReviewer() == null) {
				return false;
			}
			if (c.getReviewer().equals(this) == false) { // If I am the reviewer
				return false;
			}

		} else if (this instanceof User) {
			if (c.getOwner().equals(this) == false) { // If I am not the owner
				return false;
			}
		}

		switch (c.getCacheStatus()) // Can only disable a enabled cache
		{
		case ARCHIVED: // Already archived
			return false;

		case UNPUBLISHED:
			this.data.getUnpublishedCaches().remove(c.getCacheID(), c);
			c.setCacheState(Cache.Status.ARCHIVED);
			this.data.getArchivedCaches().put(c.getCacheID(), c);
			break;
		case ENABLED:

			this.data.getEnabledCaches().remove(c.getCacheID(), c);
			c.setCacheState(Cache.Status.ARCHIVED);
			this.data.getArchivedCaches().put(c.getCacheID(), c);
			break;
		case DISABLED:

			this.data.getDisabledCaches().remove(c.getCacheID(), c);
			c.setCacheState(Cache.Status.ARCHIVED);
			this.data.getArchivedCaches().put(c.getCacheID(), c);
			break;
		}

		Activity act = new Activity(new GregorianCalendar(),
				Activity.Type.ARCHIVED_CACHE, c, c.getOwner()); // Create
																// Activity
		this.data.addActivity(act);

		return true;
	}

	public boolean enableCache(Cache c) {

		if (this instanceof Admin == true)
			;
		else if (this instanceof Reviewer) {
			if (c.getReviewer() == null) {
				return false;
			}
			if (c.getReviewer().equals(this) == false) { // If I am the reviewer
				return false;
			}

		} else if (this instanceof User) {
			if (c.getOwner().equals(this) == false) { // If I am not the owner
				return false;
			}
		}

		switch (c.getCacheStatus()) // Can only disable a enabled cache
		{
		case ENABLED: // Already enabled
		case UNPUBLISHED: // Not published, if reviewer he should use
							// publishCache
			return false;

		case ARCHIVED:
			if (c.getPublishDate() == null) {
				return false; // Can't enable a cache that is unpublished and
								// archived
			}
			this.data.getArchivedCaches().remove(c.getCacheID(), c);
			c.setCacheState(Cache.Status.ENABLED);
			this.data.getEnabledCaches().put(c.getCacheID(), c);
			break;

		case DISABLED:
			this.data.getDisabledCaches().remove(c.getCacheID(), c);
			c.setCacheState(Cache.Status.ENABLED);
			this.data.getEnabledCaches().put(c.getCacheID(), c);
			break;
		}

		Activity act = new Activity(new GregorianCalendar(),
				Activity.Type.ENABLED_CACHE, c, c.getOwner()); // Create
																// Activity
		this.data.addActivity(act);

		return true;
	}

	public boolean logCache(Log l, Cache c) {

		if (c == null) {
			return false;
		}
		if (l == null) {
			return false;
		}

		l.setUser(this); // Assign this user to the log

		if (c.logCache(this, l) == false) {
			return false;
		}

		if (l.getLogType() == Log.Log_Type.FOUND_IT) {
			this.incFounds(1);
		}
		return true;
	}

	public void newFriendship(User u2) {
		this.friends.put(u2.getEmail(), u2);
		u2.friends.put(this.getEmail(), this);
	}

	public void removeFriendship(User u2) {
		this.friends.remove(u2.getEmail(), u2);
		u2.friends.remove(this.getEmail(), this);
	}

	// toString
	@Override
	public String toString() {
		return super.toString();
	}

	public String friendsToString() {
		StringBuilder sb = new StringBuilder();
		for (UserAbstract u : this.friends.values()) {
			sb.append("\t" + u.toString() + "\n");
		}
		return sb.toString();
	}

	public ArrayList<User> getFriendsArray() {

		ArrayList<User> array = new ArrayList<User>();

		for (User u : this.getFriends().values()) {
			array.add(u);
		}
		return array;
	}

	public ArrayList<Cache> getCachesArray() {

		ArrayList<Cache> array = new ArrayList<Cache>();

		for (Cache c : this.getCaches().values()) {
			array.add(c);
		}
		return array;
	}

	public ArrayList<Cache> getCachesArrayPremiumCheck(UserAbstract userOnline) {
		ArrayList<Cache> array = new ArrayList<Cache>();

		for (Cache c : this.getCaches().values()) {
			if (c.isPremiumOnly() == false
					|| (c.isPremiumOnly() == true && userOnline.isPremium() == true)) // Check
																						// for
																						// Premium
																						// Only
																						// Caches
			{
				array.add(c);
			}

		}
		return array;
	}

	@Override
	public String toStringTotal() {
		return "E-Mail - " + super.getEmail() + "\nName - " + super.getName()
				+ "\nGender - " + super.getGender() + "\nAddress - "
				+ super.getAddress() + "\nBirth Date - "
				+ super.formatDate(super.getBirthDate()) + "\nPremium - "
				+ super.isPremium() + "\nTotal Found - "
				+ super.getTotalFound() + "\nTotal Owned Caches - "
				+ this.caches.size() + "\nFriends - " + this.friends.size()
				+ "\n" + this.friendsToString();
	}

	public String toStringFriend() {
		return "Name - " + super.getName() + "\nGender - " + super.getGender()
				+ "\nPremium - " + super.isPremium() + "\nTotal Found - "
				+ super.getTotalFound() + "\nTotal Owned Caches - "
				+ this.caches.size() + "\nFriends - " + this.friends.size()
				+ "\n" + this.friendsToString();
	}

	// Increment by number the Number of Founds
	private void incFounds(int number) {
		this.setTotalFound(this.getTotalFound() + number);
	}

	@Override
	public Role getRole() {
		return Role.USER;
	}

}

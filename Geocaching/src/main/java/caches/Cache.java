package caches;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import user.User;
import base.Position;

public abstract class Cache {

	public enum Status {
		UNPUBLISHED,PUBLISHED,ARCHIVED
	}

	private GregorianCalendar publishDate; // Date cache was placed
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
	private Logs cache_Logs; // Cache logs
	private ArrayList<String> travel_bugs; // Travel bugs in cache container

	// Constructors
	public Cache(GregorianCalendar publishDate, String cacheID, String description, Status cacheState, String cacheTitle, User owner, int cacheSize, float difficulty, Position position, String hint, Logs cache_Logs, ArrayList<String> travel_bugs) {
		this.publishDate = publishDate;
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


	// Getters and Setters
	public GregorianCalendar getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(GregorianCalendar publishDate) {
		this.publishDate = publishDate;
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

	public String getDescription() {return description;}

	public void setDescription(String description) {this.description = description;}

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

	public Logs getCache_Logs() {
		return cache_Logs;
	}

	public void setCache_Logs(Logs cache_Logs) {
		this.cache_Logs = cache_Logs;
	}

	public ArrayList<String> getTravel_bugs() {return travel_bugs;}

	public void setTravel_bugs(ArrayList<String> travel_bugs) {this.travel_bugs = travel_bugs;}

	// ToString


	@Override
	public String toString() {
		return "Cache{" +
				"publishDate=" + publishDate +
				", cacheID='" + cacheID + '\'' +
				", description='" + description + '\'' +
				", cacheState=" + cacheState +
				", cacheTitle='" + cacheTitle + '\'' +
				", premiumOnly='" + premiumOnly + '\'' +
				", owner=" + owner +
				", cacheSize=" + cacheSize +
				", difficulty=" + difficulty +
				", position=" + position +
				", hint='" + hint + '\'' +
				", travel_bugs=" + travel_bugs +
				", cache_Logs=" + cache_Logs +
				'}';
	}

	public String toListing() {
		return  "\nTitle = '" + cacheTitle + '\'' +
				"\nPublishing Date = " + publishDate +
				"\nCache ID = '" + cacheID + '\'' +
				//"\nCacheState = " + cacheState +
				"\nOwner = " + owner +
				"\nSize = " + cacheSize +
				"\nDifficulty = " + difficulty +
				position.toListing() +
				"\nTravel bugs ("+ travel_bugs.size()+")  =  " + travel_bugs +
				"\nDescription = '" + description + '\'' +
				"\nHint = '" + hint + '\'';
	}

	public String toLogsListing() {
		return  "\nCache Logs = " + cache_Logs;
	}
}
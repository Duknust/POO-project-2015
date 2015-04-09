package caches;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import user.User;
import base.Position;

public abstract class Cache {
	private GregorianCalendar publishDate; // Date cache was placed
	private String cacheID; // Cache ID number
	private String description; // Cache description
	private boolean cacheArchived; // Is cache archived
	private String cacheTitle; // Cache name
	private User owner; // Who placed the cache
	private int cacheSize; // Type of container
	private float difficulty; // How difficult is it to find the cache
	private Position position;
	private String hints; // Hints to find the cache
	private Logs cache_Logs; // Cache logs
	private ArrayList<String> travel_bugs; // Travel bugs in cache container

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCacheArchived() {
		return cacheArchived;
	}

	public void setCacheArchived(boolean cacheArchived) {
		this.cacheArchived = cacheArchived;
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

	public String getHints() {
		return hints;
	}

	public void setHints(String hints) {
		this.hints = hints;
	}

	public Logs getCache_Logs() {
		return cache_Logs;
	}

	public void setCache_Logs(Logs cache_Logs) {
		this.cache_Logs = cache_Logs;
	}

	public ArrayList<String> getTravel_bugs() {
		return travel_bugs;
	}

	public void setTravel_bugs(ArrayList<String> travel_bugs) {
		this.travel_bugs = travel_bugs;
	}

}
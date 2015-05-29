package caches;

import base.Position;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.TreeSet;
import user.Reviewer;
import user.UserAbstract;

public class Event extends Cache {

    /*
     * An Event Cache is a gathering of local geocachers or geocaching
     * organizations. The Event Cache page specifies a time for the event and
     * provides coordinates to its location. After the event has ended, it is
     * archived.
     */
    HashMap<String, UserAbstract> participants;
    HashMap<String, Cache> caches;
    GregorianCalendar dateEvent, dateEndAplications;
    int maxParticipants;

    // Constructors
    public Event(GregorianCalendar publishDate, GregorianCalendar creationDate, GregorianCalendar dateEndApp, GregorianCalendar dateEvent, String cacheID, String cacheTitle, String description, String hint, Position position, float difficulty, int maxParticipants, int cacheSize, boolean premiumOnly, Status cacheState, UserAbstract owner, TreeSet<Log> cache_Logs, HashMap<String, Cache> caches, Reviewer reviewer) {
        super(publishDate, creationDate, cacheID, premiumOnly, description, cacheState, cacheTitle, owner, cacheSize, difficulty, position, hint, cache_Logs, reviewer);
        this.maxParticipants = maxParticipants;
        this.caches = caches;
        this.dateEndAplications = dateEndApp;
        this.dateEvent = dateEvent;
    }

    public Event(GregorianCalendar creationDate, GregorianCalendar dateEndApp, GregorianCalendar dateEvent, String cacheTitle, String description, String hint, Position position, float difficulty, int maxParticipants, TreeSet<Log> cache_Logs) {
        super(creationDate, description, cacheTitle, 0, difficulty, position, hint, cache_Logs);
        this.maxParticipants = maxParticipants;
        this.caches = new HashMap<String,Cache>();
        this.dateEndAplications = dateEndApp;
        this.dateEvent = dateEvent;
    }

    // Getters and Setters
    public HashMap<String, UserAbstract> getParticipants() {
        return participants;
    }

    public void setParticipants(HashMap<String, UserAbstract> participants) {
        this.participants = participants;
    }
    
    public void setDateEvent(GregorianCalendar date){
    	this.dateEvent = date;
    }
    
    public GregorianCalendar getDateEvent(){
    	return this.dateEvent;
    }
    
    public void setDateEndApplications(GregorianCalendar date){
    	this.dateEndAplications = date;
    }
    
    public GregorianCalendar getDateEndApplications(){
    	return this.dateEndAplications;
    }
    
    public void setMaxP(int  max){
    	this.maxParticipants = max;
    }
    
    public int getMaxP(){
    	return this.maxParticipants;
    }
    

    // Methods
    public boolean addParticipant(UserAbstract user) {
    	if(this.participants.containsKey(user.getName()))
    		return false;
    		
        this.participants.put(user.getName(), user);
    	return true;
    }

    public boolean remParticipant(UserAbstract user) {
    	if(!this.participants.containsKey(user.getName()))
    		return false;
    	
        this.participants.remove(user.getName());
        return true;
    }
    
    public boolean addCache(Cache cache) {
    	if(this.caches.containsKey(cache.getCacheID()))
    		return false;
    		
        this.caches.put(cache.getCacheID(), cache);
    	return true;
    }

    public boolean remCache(String cacheID) {
    	if(!this.caches.containsKey(cacheID))
    		return false;
    	
        this.caches.remove(cacheID);
        return true;
    }


    @Override
    public Type getType() {
        return Type.EVENT;
    }

    // toString
    @Override
    public String toString() {
        return "Event - " + super.getCacheTitle() + " - " + dateEvent.toString()
                + "\nOrganizer: " + super.getOwner().toString()
                + "\nDescription:\n" + super.getDescription()
                + "\nTotal participants:" + this.participants.size()
                + "\nparticipants:\n" + participants.toString();
    }
}

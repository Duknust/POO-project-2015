package caches;

import base.GeoTools;
import base.Position;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.TreeSet;

import com.sun.javafx.css.CalculatedValue;

import user.Reviewer;
import user.User;
import user.UserAbstract;

public class Event extends Cache {

    /*
     * An Event Cache is a gathering of local geocachers or geocaching
     * organizations. The Event Cache page specifies a time for the event and
     * provides coordinates to its location. After the event has ended, it is
     * archived.
     */
    HashMap<String, UserAbstract> participants;
    HashMap<String, Integer> points;
    HashMap<String, Cache> caches;
    GregorianCalendar dateEvent, dateEndAplications;
    int maxParticipants;

    // Constructors
    public Event(GregorianCalendar creationDate, GregorianCalendar dateEndApp, GregorianCalendar dateEvent, String cacheTitle, String description, Position position, int maxParticipants, UserAbstract owner, HashMap<String, Cache> caches) {
        super(creationDate, description, cacheTitle, position, owner);
        this.participants = new HashMap<String,UserAbstract>();
        this.points = new HashMap<String,Integer>();
        this.maxParticipants = maxParticipants;
        this.caches = caches;
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
    
    public int getPointsByUser(UserAbstract user){
    	return  points.get(user.getEmail());
    }
    

    // Methods
    public boolean addParticipant(UserAbstract user) {
    	if(this.participants.containsKey(user.getEmail()))
    		return false;
    		
        this.participants.put(user.getEmail(), user);
        this.points.put(user.getEmail(), 0);
    	return true;
    }

    public boolean remParticipant(UserAbstract user) {
    	if(!this.participants.containsKey(user.getEmail()))
    		return false;
    	
        this.participants.remove(user.getEmail());
        this.points.remove(user.getEmail());
        return true;
    }
    
    public int getNRegistrations(){
    	return this.participants.size();
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
    
    
    public float timeToFind(UserAbstract user, Cache cache){
    	
    	//Base time
    	float dist, time = 10; 
    	int aux;
    	
    	
    	//Specialized in the type    	
    	aux = user.nFindFromType(cache.getType());
    	if(aux<7) //He is new in the type
    		time += 20;
    	else if(aux < 15) //Some experience
    		time += 15;
    	else	//An expert
    		time += 10;
    	
    	
    	//Distance
    	GeoTools calcD = new GeoTools();
    	dist = (float)calcD.calcDistance(this.getPosition(), cache.getPosition());
    	if(aux<7) //Near of base local
    		time += 10;
    	else if(aux < 15) //Medium 
    		time += 15;
    	else	//Far from base local
    		time += 20;
    	
    	
    	
    	
    	return time;
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

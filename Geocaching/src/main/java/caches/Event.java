package caches;

import base.Data;
import base.GeoTools;
import base.Position;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Random;

import meteo.Meteo;
import user.User;
import user.UserAbstract;

public class Event extends Cache {

    /*
     * An Event Cache is a gathering of local geocachers or geocaching
     * organizations. The Event Cache page specifies a time for the event and
     * provides coordinates to its location. After the event has ended, it is
     * archived.
     */
	private HashMap<String, User> participants;
	private HashMap<String, Float> points;
	private HashMap<String, Float> times;
	private HashMap<String, Cache> caches;
	private GregorianCalendar dateEvent, dateEndAplications;
	private int maxParticipants;

    // Constructors
    public Event(GregorianCalendar creationDate, GregorianCalendar dateEndApp, GregorianCalendar dateEvent, String cacheTitle, String description, Position position, int maxParticipants, UserAbstract owner, HashMap<String, Cache> caches, Data data) {
        super(creationDate, description, cacheTitle, position, owner, data);
        this.participants = new HashMap<String, User>();
        this.points = new HashMap<String, Float>();
        this.times = new HashMap<String, Float>();
        this.maxParticipants = maxParticipants;
        this.caches = caches;
        this.dateEndAplications = dateEndApp;
        this.dateEvent = dateEvent;
    }

    // Getters and Setters
    public HashMap<String, User> getParticipants() {
        return participants;
    }

    public void setParticipants(HashMap<String, User> participants) {
        this.participants = participants;
    }

    public void setDateEvent(GregorianCalendar date) {
        this.dateEvent = date;
    }

    public GregorianCalendar getDateEvent() {
        return this.dateEvent;
    }

    public void setDateEndApplications(GregorianCalendar date) {
        this.dateEndAplications = date;
    }

    public GregorianCalendar getDateEndApplications() {
        return this.dateEndAplications;
    }

    public void setMaxP(int max) {
        this.maxParticipants = max;
    }

    public int getMaxP() {
        return this.maxParticipants;
    }

    public float getPointsByUser(UserAbstract user) {
        return points.get(user.getEmail());
    }

    public HashMap<String, Cache> getCaches() {
        return this.caches;
    }

    // Methods
    public boolean addParticipant(User user) {
        if (this.participants.containsKey(user.getEmail())) {
            return false;
        }

        this.participants.put(user.getEmail(), user);
        this.points.put(user.getEmail(), (float) 0);
        return true;
    }

    public boolean remParticipant(UserAbstract user) {
        if (!this.participants.containsKey(user.getEmail())) {
            return false;
        }

        this.participants.remove(user.getEmail());
        this.points.remove(user.getEmail());
        return true;
    }

    public boolean checkParticipation(UserAbstract user) {
        for (UserAbstract u : this.participants.values()) {
            if (user.equals(u)) {
                return true;
            }
        }
        return false;
    }

    public int getNRegistrations() {
        return this.participants.size();
    }

    public boolean addCache(Cache cache) {
        if (this.caches.containsKey(cache.getCacheID())) {
            return false;
        }

        this.caches.put(cache.getCacheID(), cache);
        return true;
    }

    public boolean remCache(String cacheID) {
        if (!this.caches.containsKey(cacheID)) {
            return false;
        }

        this.caches.remove(cacheID);
        return true;
    }

    public int timeToFind(User user, Cache cache) {

        //Base time
        float dist;
        int time = 10, aux;

        //Specialized in the type
        aux = user.nFindFromType(cache.getType());
        if (aux < 7) //He is new in the type
        {
            time += 20;
        } else if (aux < 15) //Some experience
        {
            time += 15;
        } else //An expert
        {
            time += 10;
        }

        //Distance
        GeoTools calcD = new GeoTools();
        dist = (float) calcD.calcDistance(this.getPosition(), cache.getPosition());
        if (aux < 7) //Near of base local
        {
            time += 10;
        } else if (aux < 15) //Medium
        {
            time += 15;
        } else //Far from base local
        {
            time += 20;
        }
        
        //Meteo
        
        Meteo meteo = new Meteo();
        Meteo auxMeteo = meteo.staticMeteo(this.dateEvent.get(GregorianCalendar.DAY_OF_YEAR),cache.getPosition());
        
        float rainProb = auxMeteo.getRainProbability();
        float temperature = auxMeteo.getTemperature();
        
        int nTemp = user.getNumberByTemperature(temperature);
        int nRain = user.getNumberByRain(rainProb);
        
        //Temperature
        if(nTemp < 5){ 
    		time += 20;
    		
    	} else if (nTemp < 10){
    		time += 15;
    		
    	} else { 
    		time += 10;
    	}
    	
        //Rain
        if(nRain < 5){ 
    		time += 20;
    		
    	} else if (nTemp < 10){
    		time += 15;
    		
    	} else { 
    		time += 10;
    	}
        
        return time;
    }
    
    public void simulation(){
    	Random r = new Random();
    	int rounds = this.getNRegistrations() * (Math.abs(r.nextInt()) %caches.size());
    	Object[] aCaches = caches.values().toArray();
    	Object[] aPart = participants.values().toArray();
    	float[] sTimes = new float[participants.size()];
    	float[] sPoints = new float[participants.size()];
    	Cache cache = null;
    	User user;
    	int i, idUser, idCache;
    	
    	
    	while(rounds>0){
    		rounds--;
    		idUser = Math.abs(r.nextInt()%caches.size());
    		idCache = Math.abs(r.nextInt()%participants.size());
    		
    		cache = (Cache)aCaches[idCache];
    		user = (User)aPart[idUser];
    		
    		int aux = timeToFind(user,cache);
    		sTimes[idUser] +=  aux;
    		sPoints[idUser] +=  cache.getDifficulty() * cache.getPosition().getDifficulty();
    	}
    	
    	for(i=0; i<aPart.length; i++){
    		user = (User)aPart[i];
    		points.put(user.getEmail(),sPoints[i]);
    		times.put(user.getEmail(),sTimes[i]);
    	}
    	
    	printResults();
    }
    
    public void printResults(){
    	
    	System.out.println("User || Points || Total Time");
    	for(User u: participants.values()){
    		System.out.format("%s || %f || %f\n", u.getEmail(), points.get(u.getEmail()), times.get(u.getEmail()) );
    	}
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

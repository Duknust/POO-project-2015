package caches;

import base.Position;
import user.User;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Event extends Cache {

    /*
    An Event Cache is a gathering of local geocachers or geocaching organizations.
    The Event Cache page specifies a time for the event and provides coordinates to its location.
    After the event has ended, it is archived.
     */
    HashMap<String, User> participants;
    GregorianCalendar date;
    int maxParticipants;

    // Constructors
    public Event(GregorianCalendar publishDate, String cacheID, String description, Status cacheState, String cacheTitle, User owner, int cacheSize, float difficulty, Position position, String hints, Logs cache_Logs, ArrayList<String> travel_bugs) {
        super(publishDate, cacheID, description, cacheState, cacheTitle, owner, cacheSize, difficulty, position, hints, cache_Logs, travel_bugs);
    }


    public Event(GregorianCalendar publishDate, String cacheID, String description, Status cacheState, String cacheTitle, User owner, int cacheSize, float difficulty, Position position, String hints, Logs cache_Logs, ArrayList<String> travel_bugs,HashMap<String, User> users) {
        super(publishDate, cacheID, description, cacheState, cacheTitle, owner, cacheSize, difficulty, position, hints, cache_Logs, travel_bugs);
        this.participants = users;
    }

    // Getters and Setters


    public HashMap<String, User> getParticipants() {
        return participants;
    }

    public void setParticipants(HashMap<String, User> participants) {
        this.participants = participants;
    }


    @Override
    public String toString() {
        return "Event - "+super.getCacheTitle() + " - " + date.toString() +"\nOrganizer: "+super.getOwner().toString()+ "\nDescription:\n"+super.getDescription()+"\nTotal Participants:"+this.participants.size()+"\nParticipants:\n"+participants.toString();
    }
}

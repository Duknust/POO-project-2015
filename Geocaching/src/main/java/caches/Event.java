package caches;

import base.Position;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.TreeMap;
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
    GregorianCalendar date;
    int maxParticipants;

    // Constructors
    public Event(HashMap<String, UserAbstract> participants, GregorianCalendar date, int maxParticipants, GregorianCalendar publishDate, GregorianCalendar creationDate, String cacheID, boolean premiumOnly, String description, Status cacheState, String cacheTitle, UserAbstract owner, int cacheSize, float difficulty, Position position, String hint, TreeMap<GregorianCalendar, Log> cache_Logs, ArrayList<String> travel_bugs, Reviewer reviewer) {
        super(publishDate, creationDate, cacheID, premiumOnly, description, cacheState, cacheTitle, owner, cacheSize, difficulty, position, hint, cache_Logs, travel_bugs, reviewer);
        this.participants = participants;
        this.date = date;
        this.maxParticipants = maxParticipants;
    }

    public Event(GregorianCalendar creationDate, String description, String cacheTitle, int cacheSize, float difficulty, Position position, String hint, TreeMap<GregorianCalendar, Log> cache_Logs, ArrayList<String> travel_bugs, HashMap<String, UserAbstract> participants, GregorianCalendar date, int maxParticipants) {
        super(creationDate, description, cacheTitle, cacheSize, difficulty, position, hint, cache_Logs, travel_bugs);
        this.participants = participants;
        this.date = date;
        this.maxParticipants = maxParticipants;
    }

    // Getters and Setters
    public HashMap<String, UserAbstract> getParticipants() {
        return participants;
    }

    public void setParticipants(HashMap<String, UserAbstract> participants) {
        this.participants = participants;
    }

    // Methods
    public void addParticipant(UserAbstract user) {
        this.participants.put(user.getName(), user);
    }

    public void remParticipant(UserAbstract user) {
        this.participants.remove(user.getName());
    }

    // toString
    @Override
    public String toString() {
        return "Event - " + super.getCacheTitle() + " - " + date.toString()
                + "\nOrganizer: " + super.getOwner().toString()
                + "\nDescription:\n" + super.getDescription()
                + "\nTotal participants:" + this.participants.size()
                + "\nparticipants:\n" + participants.toString();
    }
}

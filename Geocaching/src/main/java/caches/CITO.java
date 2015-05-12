package caches;

import base.Position;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.TreeMap;
import user.Reviewer;
import user.UserAbstract;

public class CITO extends Cache {
    /*
     * Cache In Trash Out is the environmental initiative supported by the
     * geocaching community. The main aim of this program is to clean up and
     * preserve the natural areas that we enjoy while geocaching. These events
     * are larger gatherings of geocachers that focus on litter clean-up,
     * removal of invasive species, planting trees and vegetation and trail
     * building.
     */

    GregorianCalendar date;
    HashMap<String, UserAbstract> participants;

    // Constructors
    public CITO(GregorianCalendar publishDate, GregorianCalendar creationDate, String cacheID, boolean premiumOnly, String description, Status cacheState, String cacheTitle, UserAbstract owner, int cacheSize, float difficulty, Position position, String hint, TreeMap<GregorianCalendar, Log> cache_Logs, ArrayList<String> travel_bugs, Reviewer reviewer) {
        super(publishDate, creationDate, cacheID, premiumOnly, description, cacheState, cacheTitle, owner, cacheSize, difficulty, position, hint, cache_Logs, travel_bugs, reviewer);
        this.date = date;
        this.participants = participants;
    }

    public CITO(GregorianCalendar creationDate, String description, String cacheTitle, int cacheSize, float difficulty, Position position, String hint, TreeMap<GregorianCalendar, Log> cache_Logs, ArrayList<String> travel_bugs, GregorianCalendar date, HashMap<String, UserAbstract> participants) {
        super(creationDate, description, cacheTitle, cacheSize, difficulty, position, hint, cache_Logs, travel_bugs);
        this.date = date;
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
        return "CITO Event- " + date.toString() + "\nOrganizer: "
                + super.getOwner().toString() + "\nDescription:\n"
                + super.getDescription() + "\nTotal participants:"
                + this.participants.size() + "\nparticipants:\n"
                + participants.toString();
    }
}

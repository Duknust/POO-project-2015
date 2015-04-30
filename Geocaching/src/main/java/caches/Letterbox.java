package caches;

import base.Position;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.TreeMap;
import user.Reviewer;
import user.UserAbstract;

public class Letterbox extends Cache {

    /*
     * Letterboxing is another form of treasure hunting that uses clues instead
     * of coordinates. In some cases, the letterbox owner has made their
     * container both a letterbox and a geocache and posted its coordinates on
     * Geocaching.com. These types of geocaches will contain a stamp that is
     * meant to remain in the box and is used by letterboxers to record their
     * visit.
     */
    // Can have 0 stages
    ArrayList<Stage> stages;

    // Constructors
    public Letterbox(ArrayList<Stage> stages, GregorianCalendar publishDate, GregorianCalendar creationDate, String cacheID, boolean premiumOnly, String description, Status cacheState, String cacheTitle, UserAbstract owner, int cacheSize, float difficulty, Position position, String hint, TreeMap<GregorianCalendar, Log> cache_Logs, ArrayList<String> travel_bugs, Reviewer reviewer) {
        super(publishDate, creationDate, cacheID, premiumOnly, description, cacheState,
                cacheTitle, owner, cacheSize, difficulty, position, hint, cache_Logs, travel_bugs, reviewer);
        this.stages = stages;
    }

    public Letterbox(GregorianCalendar creationDate, String description, String cacheTitle, int cacheSize, float difficulty, Position position, String hint, TreeMap<GregorianCalendar, Log> cache_Logs, ArrayList<String> travel_bugs, ArrayList<Stage> stages) {
        super(creationDate, description, cacheTitle, cacheSize, difficulty, position, hint, cache_Logs, travel_bugs);
        this.stages = stages;
    }

    @Override
    public String toString() {
        return "Letterbox Cache\n" + super.toListing("Letterbox")
                + this.stages.toString() + super.toLogsListing();
    }

    public void AddStage(double lati, double longi, String description) {
        Stage st = new Stage(lati, longi, description, this.stages.size() + 1);
        this.stages.add(st);
    }

    public String ListStages(boolean user) {
        StringBuilder text = new StringBuilder();
        text.append(stages.size() + " Stages ----\n");

        if (user)// If regular user
        {
            text.append(stages);
        } else // If Admin or Reviewer
        {
            for (Stage s : stages) {
                text.append(s.toStringFull()); // List Full Coordinates
            }
        }

        return text.toString();
    }
}

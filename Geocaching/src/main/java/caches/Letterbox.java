package caches;

import base.Data;
import base.Position;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.TreeSet;

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
    public Letterbox(ArrayList<Stage> stages, GregorianCalendar publishDate, GregorianCalendar creationDate, String cacheID, boolean premiumOnly, String description, Status cacheState, String cacheTitle, UserAbstract owner, int cacheSize, float difficulty, Position position, String hint, TreeSet<Log> cache_Logs, Reviewer reviewer, Data data) {
        super(publishDate, creationDate, cacheID, premiumOnly, description, cacheState,
                cacheTitle, owner, cacheSize, difficulty, position, hint, cache_Logs, reviewer, data);
        this.stages = stages;
    }

    public Letterbox(GregorianCalendar creationDate, String description, String cacheTitle, int cacheSize, float difficulty, Position position, String hint, TreeSet<Log> cache_Logs, ArrayList<Stage> stages, Data data) {
        super(creationDate, description, cacheTitle, cacheSize, difficulty, position, hint, cache_Logs, data);
        this.stages = stages;
    }

    public Letterbox(GregorianCalendar creationDate, String description, String cacheTitle, int cacheSize, float difficulty, Position position, String hint, boolean premium, ArrayList<Stage> stages, UserAbstract owner, Data data){
    	super(creationDate, description, cacheTitle, cacheSize, difficulty, position, hint, premium, owner, data);
    	this.stages = stages;
    }
  
    
    @Override
    public String toString() {
        return "Letterbox Cache\n" + super.toListing()
                + this.stages.toString() + super.toLogsListing();
    }

    @Override
    public Type getType() {
        return Type.LETTERBOX;
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

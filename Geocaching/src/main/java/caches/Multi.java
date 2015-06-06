package caches;

import base.Data;
import base.Position;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.TreeSet;

import user.Reviewer;
import user.UserAbstract;

public class Multi extends Cache {

    /*
     * These geocaches involve two or more locations, with the final location
     * being a physical container with a logbook inside. There are many
     * variations, but typically once you�re at the first stage, you will
     * receive a clue to the whereabouts of the second stage. The second stage
     * will have a clue for the third, and so on.
     */
    // At least One Stage
    ArrayList<Stage> stages;

    // Constructors
    public Multi(ArrayList<Stage> stages, GregorianCalendar publishDate, GregorianCalendar creationDate, String cacheID, boolean premiumOnly, String description, Status cacheState, String cacheTitle, UserAbstract owner, int cacheSize, float difficulty, Position position, String hint, TreeSet<Log> cache_Logs, Reviewer reviewer, Data data) {
        super(publishDate, creationDate, cacheID, premiumOnly, description, cacheState,
                cacheTitle, owner, cacheSize, difficulty, position, hint, cache_Logs, reviewer, data);
        this.stages = stages;
    }

    public Multi(GregorianCalendar creationDate, String description, String cacheTitle, int cacheSize, float difficulty, Position position, String hint, TreeSet<Log> cache_Logs, ArrayList<Stage> stages, Data data) {
        super(creationDate, description, cacheTitle, cacheSize, difficulty, position, hint, cache_Logs, data);
        this.stages = stages;
    }
    
    public Multi(GregorianCalendar creationDate, String description, String cacheTitle, int cacheSize, float difficulty, Position position, String hint, boolean premium, ArrayList<Stage> stages, UserAbstract owner, Data data) {
    	super(creationDate, description, cacheTitle, cacheSize, difficulty, position, hint, premium, owner, data);
    	this.stages = stages;
    }

    public ArrayList<Stage> getStages(){
    	return this.stages;
    }
    
    @Override
    public String toString() {
        return super.toListing() + this.stages.toString()
                + super.toLogsListing();
    }

    @Override
    public Type getType() {
        return Type.MULTI;
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

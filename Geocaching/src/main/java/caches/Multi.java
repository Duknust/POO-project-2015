package caches;

import base.Position;
import javafx.geometry.Pos;
import user.User;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Multi extends Cache {

    /*
    These geocaches involve two or more locations, with the final location being a
     physical container with a logbook inside.
    There are many variations, but typically once you’re at the first stage,
     you will receive a clue to the whereabouts of the second stage.
    The second stage will have a clue for the third, and so on.
     */


    // Represents a Stage
    class Stage extends Position{

        private String description="";

        public Stage(double lati, double longi, String description) {
            super(lati, longi);
            this.description = description;
        }
    }

    ArrayList<Stage> stages;

    public Multi(GregorianCalendar publishDate, String cacheID, String description, Status cacheState, String cacheTitle, User owner, int cacheSize, float difficulty, Position position, String hints, Logs cache_Logs, ArrayList<String> travel_bugs,ArrayList<Stage> stages) {
        super(publishDate, cacheID, description, cacheState, cacheTitle, owner, cacheSize, difficulty, position, hints, cache_Logs, travel_bugs);
        this.stages = stages;
    }


    @Override
    public String toString() {
        return "Multi Cache\n"+super.toListing() + this.stages.toString() + super.toLogsListing();
    }

    public void AddStage(double lati, double longi, String description){
        Stage st = new Stage(lati,longi,description);
        this.stages.add(st);
    }

}

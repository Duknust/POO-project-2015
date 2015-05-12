package caches;

import base.Position;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.TreeMap;
import user.Reviewer;
import user.UserAbstract;

public class Mistery extends Cache {

    /*
     * The "catch-all" of geocache types, this type may involve complicated
     * puzzles that you will first need to solve to determine the correct
     * coordinates. Mystery/Puzzle Caches often become the staging ground for
     * new and unique geocaches that do not fit in another category.
     */
    private Position finalPos = null;

    // Constructors
    public Mistery(GregorianCalendar publishDate, GregorianCalendar creationDate, String cacheID, boolean premiumOnly, String description, Status cacheState, String cacheTitle, UserAbstract owner, int cacheSize, float difficulty, Position position, String hint, TreeMap<GregorianCalendar, Log> cache_Logs, ArrayList<String> travel_bugs, Reviewer reviewer) {
        super(publishDate, creationDate, cacheID, premiumOnly, description, cacheState,
                cacheTitle, owner, cacheSize, difficulty, position, hint, cache_Logs, travel_bugs, reviewer);
    }

    public Mistery(GregorianCalendar creationDate, String description, String cacheTitle, int cacheSize, float difficulty, Position position, String hint, TreeMap<GregorianCalendar, Log> cache_Logs, ArrayList<String> travel_bugs, Position pos) {
        super(creationDate, description, cacheTitle, cacheSize, difficulty, position, hint, cache_Logs, travel_bugs);
        this.finalPos = pos;
    }

    // Getters and Setters
    public Position getFinalPos() {
        return finalPos;
    }

    public void setFinalPos(Position finalPos) {
        this.finalPos = finalPos;
    }

    // Methods
    // toString
    @Override
    public String toString() {
        return super.toListing("Mystery") + super.toLogsListing();
    }

    public String Listing(boolean user) {

        if (user)// If regular user
        {
            return super.toListing("Mystery") + super.toLogsListing();
        } else // If Admin or Reviewer
        {
            return super.toListing("Mystery") + finalPos.getCoords()
                    + super.toLogsListing(); // List Full Coordinates
        }
    }
}

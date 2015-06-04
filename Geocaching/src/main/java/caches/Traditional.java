package caches;

import base.Data;
import base.Position;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.TreeSet;
import user.Reviewer;
import user.UserAbstract;

public class Traditional extends Cache {
    /*
     * This is the original type of geocache and the most straightforward. These
     * geocaches will be a container at the given coordinates. The size may
     * vary, but at minimum, all of these geocaches will have a logbook. Larger
     * containers may contain items for trade and trackables.
     */

    // Constructors
    public Traditional(GregorianCalendar publishDate, GregorianCalendar creationDate, String cacheID, boolean premiumOnly, String description, Status cacheState, String cacheTitle, UserAbstract owner, int cacheSize, float difficulty, Position position, String hint, TreeSet<Log> cache_Logs, Reviewer reviewer, Data data) {
        super(publishDate, creationDate, cacheID, premiumOnly, description, cacheState,
                cacheTitle, owner, cacheSize, difficulty, position, hint, cache_Logs, reviewer, data);
    }

    public Traditional(GregorianCalendar creationDate, String description, String cacheTitle, int cacheSize, float difficulty, Position position, String hint, TreeSet<Log> cache_Logs, ArrayList<String> travel_bugs, Data data) {
        super(creationDate, description, cacheTitle, cacheSize, difficulty, position, hint, cache_Logs, data);
    }

    // toString
    @Override
    public String toString() {
        return super.toListing() + super.toLogsListing();
    }

    @Override
    public Type getType() {
        return Type.TRADITIONAL;
    }

}

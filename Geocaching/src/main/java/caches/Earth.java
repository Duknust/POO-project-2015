package caches;

import base.Position;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.TreeMap;
import user.Reviewer;
import user.UserAbstract;

public class Earth extends Cache {

    /*
     * An EarthCache is a special geological location people can visit to learn
     * about a unique feature of the Earth. EarthCache pages include a set of
     * educational notes along with coordinates. Visitors to EarthCaches can see
     * how our planet has been shaped by geological processes, how we manage its
     * resources and how scientists gather evidence. Typically, to log an
     * EarthCache, you will have to provide answers to questions by observing
     * the geological location.
     */
    // Constructors
    public Earth(GregorianCalendar publishDate, GregorianCalendar creationDate, String cacheID, boolean premiumOnly, String description, Status cacheState, String cacheTitle, UserAbstract owner, int cacheSize, float difficulty, Position position, String hint, TreeMap<GregorianCalendar, Log> cache_Logs, Reviewer reviewer) {
        super(publishDate, creationDate, cacheID, premiumOnly, description, cacheState, cacheTitle, owner, cacheSize, difficulty, position, hint, cache_Logs, reviewer);
    }

    public Earth(GregorianCalendar creationDate, String description, String cacheTitle, int cacheSize, float difficulty, Position position, String hint, TreeMap<GregorianCalendar, Log> cache_Logs, ArrayList<String> travel_bugs) {
        super(creationDate, description, cacheTitle, cacheSize, difficulty, position, hint, cache_Logs);
    }

    // toString
    @Override
    public String toString() {
        return super.toListing("Earth") + super.toLogsListing();
    }
}

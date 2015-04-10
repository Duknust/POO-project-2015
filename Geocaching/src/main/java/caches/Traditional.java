package caches;

import base.Position;
import user.User;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Traditional extends Cache {
    /*
    This is the original type of geocache and the most straightforward.
    These geocaches will be a container at the given coordinates. The size may vary, but at minimum,
     all of these geocaches will have a logbook.
    Larger containers may contain items for trade and trackables.
     */

    public Traditional(GregorianCalendar publishDate, String cacheID, String description, Status cacheState, String cacheTitle, User owner, int cacheSize, float difficulty, Position position, String hints, Logs cache_Logs, ArrayList<String> travel_bugs) {
        super(publishDate, cacheID, description, cacheState, cacheTitle, owner, cacheSize, difficulty, position, hints, cache_Logs, travel_bugs);
    }
}

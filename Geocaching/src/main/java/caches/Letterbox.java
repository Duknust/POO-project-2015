package caches;

import base.Position;
import user.User;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Letterbox extends Cache {

    /*
    Letterboxing is another form of treasure hunting that uses clues instead of coordinates.
    In some cases, the letterbox owner has made their container both a letterbox
     and a geocache and posted its coordinates on Geocaching.com.
    These types of geocaches will contain a stamp that is meant to
     remain in the box and is used by letterboxers to record their visit.
     */
    public Letterbox(GregorianCalendar publishDate, String cacheID, String description, Status cacheState, String cacheTitle, User owner, int cacheSize, float difficulty, Position position, String hints, Logs cache_Logs, ArrayList<String> travel_bugs) {
        super(publishDate, cacheID, description, cacheState, cacheTitle, owner, cacheSize, difficulty, position, hints, cache_Logs, travel_bugs);
    }
}

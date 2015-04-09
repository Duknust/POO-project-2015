package caches;

import base.Position;
import user.User;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Letterbox extends Cache {

    public Letterbox(GregorianCalendar publishDate, String cacheID, String description, Status cacheState, String cacheTitle, User owner, int cacheSize, float difficulty, Position position, String hints, Logs cache_Logs, ArrayList<String> travel_bugs) {
        super(publishDate, cacheID, description, cacheState, cacheTitle, owner, cacheSize, difficulty, position, hints, cache_Logs, travel_bugs);
    }
}

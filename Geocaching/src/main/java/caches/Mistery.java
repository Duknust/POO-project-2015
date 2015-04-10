package caches;

import base.Position;
import user.User;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Mistery extends Cache {

    /*
    The "catch-all" of geocache types, this type may involve complicated puzzles that you will
     first need to solve to determine the correct coordinates.
    Mystery/Puzzle Caches often become the staging ground for new and unique geocaches
     that do not fit in another category.
     */


    public Mistery(GregorianCalendar publishDate, String cacheID, String description, Status cacheState, String cacheTitle, User owner, int cacheSize, float difficulty, Position position, String hints, Logs cache_Logs, ArrayList<String> travel_bugs) {
        super(publishDate, cacheID, description, cacheState, cacheTitle, owner, cacheSize, difficulty, position, hints, cache_Logs, travel_bugs);
    }
}

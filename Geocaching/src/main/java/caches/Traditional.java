package caches;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import user.User;
import base.Position;

public class Traditional extends Cache {
	/*
	 * This is the original type of geocache and the most straightforward. These
	 * geocaches will be a container at the given coordinates. The size may
	 * vary, but at minimum, all of these geocaches will have a logbook. Larger
	 * containers may contain items for trade and trackables.
	 */

	public Traditional(GregorianCalendar publishDate, String cacheID,
			String description, Status cacheState, String cacheTitle,
			User owner, int cacheSize, float difficulty, Position position,
			String hints, ArrayList<Log> cache_Log,
			ArrayList<String> travel_bugs) {
		super(publishDate, cacheID, description, cacheState, cacheTitle, owner,
				cacheSize, difficulty, position, hints, cache_Log, travel_bugs);
	}

	// toString
	@Override
	public String toString() {
		return super.toListing("Traditional") + super.toLogsListing();
	}
}

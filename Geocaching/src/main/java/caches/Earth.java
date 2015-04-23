package caches;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import user.User;
import base.Position;

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
	public Earth(GregorianCalendar publishDate, String cacheID,
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
		return super.toListing("Earth") + super.toLogsListing();
	}
}

package caches;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

import user.User;
import base.Position;

public class CITO extends Cache {
	/*
	 * Cache In Trash Out is the environmental initiative supported by the
	 * geocaching community. The main aim of this program is to clean up and
	 * preserve the natural areas that we enjoy while geocaching. These events
	 * are larger gatherings of geocachers that focus on litter clean-up,
	 * removal of invasive species, planting trees and vegetation and trail
	 * building.
	 */

	GregorianCalendar date;
	HashMap<String, User> participants;

	public CITO(GregorianCalendar publishDate, String cacheID,
			String description, Status cacheState, String cacheTitle,
			User owner, int cacheSize, float difficulty, Position position,
			String hints, ArrayList<Log> cache_Log,
			ArrayList<String> travel_bugs, GregorianCalendar date) {
		super(publishDate, cacheID, description, cacheState, cacheTitle, owner,
				cacheSize, difficulty, position, hints, cache_Log, travel_bugs);
		this.date = date;
	}

	// Methods
	public void addParticipant(User user) {
		this.participants.put(user.getName(), user);
	}

	public void remParticipant(User user) {
		this.participants.remove(user.getName());
	}

	// toString
	@Override
	public String toString() {
		return "CITO Event- " + date.toString() + "\nOrganizer: "
				+ super.getOwner().toString() + "\nDescription:\n"
				+ super.getDescription() + "\nTotal participants:"
				+ this.participants.size() + "\nparticipants:\n"
				+ participants.toString();
	}
}

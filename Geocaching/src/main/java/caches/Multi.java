package caches;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import user.User;
import base.Position;

public class Multi extends Cache {

	/*
	 * These geocaches involve two or more locations, with the final location
	 * being a physical container with a logbook inside. There are many
	 * variations, but typically once you�re at the first stage, you will
	 * receive a clue to the whereabouts of the second stage. The second stage
	 * will have a clue for the third, and so on.
	 */
	// At least One Stage
	ArrayList<Stage> stages;

	public Multi(GregorianCalendar publishDate, String cacheID,
			String description, Status cacheState, String cacheTitle,
			User owner, int cacheSize, float difficulty, Position position,
			String hints, ArrayList<Log> cache_Log,
			ArrayList<String> travel_bugs, ArrayList<Stage> stages) {
		super(publishDate, cacheID, description, cacheState, cacheTitle, owner,
				cacheSize, difficulty, position, hints, cache_Log, travel_bugs);
		this.stages = stages;
	}

	@Override
	public String toString() {
		return super.toListing("Multi") + this.stages.toString()
				+ super.toLogsListing();
	}

	public void AddStage(double lati, double longi, String description) {
		Stage st = new Stage(lati, longi, description, this.stages.size() + 1);
		this.stages.add(st);
	}

	public String ListStages(boolean user) {
		StringBuilder text = new StringBuilder();
		text.append(stages.size() + " Stages ----\n");

		if (user)// If regular user
		{
			text.append(stages);
		} else // If Admin or Reviewer
		{
			for (Stage s : stages) {
				text.append(s.toStringFull()); // List Full Coordinates
			}
		}

		return text.toString();
	}

}

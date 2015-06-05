package dataCreation;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeSet;

import user.UserAbstract;
import base.Data;
import base.Position;
import base.Utilities;
import caches.CITO;
import caches.Cache;
import caches.Earth;
import caches.Letterbox;
import caches.Log;
import caches.Multi;
import caches.Mystery;
import caches.Stage;
import caches.Traditional;

public class CachesData {

	Data data = null;

	public CachesData(Data data) {
		this.data = data;
	}

	public Cache generateRandomCache() {
		Random randomno = new Random();
		float probArea = randomno.nextFloat() * 8;
		Cache res = null;

		Position position = new CountriesData().getRandomPosition();
		float difficulty = Utilities.getValueToDifficulty();
		GregorianCalendar creationDate = new GregorianCalendar();
		String description = "Auto generated cache";
		String cacheTitle = "AutoCache " + System.currentTimeMillis();
		String hint = "none";

		TreeSet<Log> cache_Logs = new TreeSet<Log>();
		int cacheSize = randomno.nextInt() % 5;
		ArrayList<Stage> stages = new ArrayList<Stage>();
		ArrayList<String> travel_bugs = new ArrayList<String>();

		HashMap<String, UserAbstract> participants = new HashMap<String, UserAbstract>();

		if (probArea < 1) {
			res = new CITO(creationDate, description, cacheTitle, cacheSize,
					difficulty, position, hint, cache_Logs, creationDate,
					participants, this.data);
		} else if (probArea < 2) {
			res = new Earth(creationDate, description, cacheTitle, cacheSize,
					difficulty, position, hint, cache_Logs, travel_bugs,
					this.data);
		} else if (probArea < 3) {
			res = new Letterbox(creationDate, description, cacheTitle,
					cacheSize, difficulty, position, hint, cache_Logs, stages,
					this.data);
		} else if (probArea < 4) {
			res = new Multi(creationDate, description, cacheTitle, cacheSize,
					difficulty, position, hint, cache_Logs, stages, this.data);
		} else if (probArea < 5) {
			res = new Mystery(creationDate, description, cacheTitle, cacheSize,
					difficulty, position, hint, cache_Logs, position, "non",
					this.data);
		} else {
			res = new Traditional(creationDate, description, cacheTitle,
					cacheSize, difficulty, position, hint, cache_Logs,
					travel_bugs, this.data);
		}
		return res;
	}
}

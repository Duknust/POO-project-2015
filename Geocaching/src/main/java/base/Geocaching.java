package base;

import java.util.HashMap;
import java.util.TreeMap;

import com.github.dvdme.ForecastIOLib.ForecastIO;
import user.User;
import activity.Activity;
import caches.Cache;

public class Geocaching {

	HashMap<String, Cache> allCaches = null;
	HashMap<String, User> allUsers = null;
	TreeMap<String, Activity> allActivities = null;

	public static void main(String[] args) {
		System.out.println("Welcome to Geocaching");
	}

}

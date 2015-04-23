package user;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

import caches.Cache;

public class Admin extends User {

	public Admin(String email, String password, String name, String gender,
			String address, GregorianCalendar birthDate, boolean premium,
			int totalFound, String tb, ArrayList<Cache> caches,
			HashMap<String, User> friends) {
		super(email, password, name, gender, address, birthDate, premium,
				totalFound, tb, caches, friends);
	}

}

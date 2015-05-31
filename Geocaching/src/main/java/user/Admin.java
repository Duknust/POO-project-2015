package user;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashMap;

import base.Data;
import caches.Cache;
import caches.Log;

public class Admin extends Reviewer implements Serializable, UserInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8314417983224728083L;

	public Admin(String email, String password, String name, String gender,
			String address, GregorianCalendar birthDate, boolean premium,
			int totalFound, HashMap<String, Cache> caches,
			HashMap<String, User> friends, Data data) {
		super(email, password, name, gender, address, birthDate, premium,
				totalFound, caches, friends, data);
	}

	void deleteLog(Log l, Cache c) {
		c.getCache_Logs().remove(l.getDate(), l);
	}

	@Override
	public Role getRole() {
		return Role.ADMIN;
	}
}

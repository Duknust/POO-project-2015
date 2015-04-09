package user;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

import caches.Cache;

public abstract class User {
	private String email;
	private String password;
	private String name;
	private String gender;
	private String address;
	private GregorianCalendar birthDate;
	private boolean premium;

	private ArrayList<Cache> caches = null;
	private HashMap<String, User> friends = null;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public GregorianCalendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(GregorianCalendar birthDate) {
		this.birthDate = birthDate;
	}

	public ArrayList<Cache> getCaches() {
		return caches;
	}

	public void setCaches(ArrayList<Cache> caches) {
		this.caches = caches;
	}

	public HashMap<String, User> getFriends() {
		return friends;
	}

	public void setFriends(HashMap<String, User> friends) {
		this.friends = friends;
	}

	public boolean isPremium() {return premium;}

	public void setPremium(boolean premium) {this.premium = premium;}

	// Methods


	@Override
	public String toString() {
		return "'" + name + " (" + caches.size()+")'";
	}
}

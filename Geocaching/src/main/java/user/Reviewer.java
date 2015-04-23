package user;

import caches.Cache;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Reviewer extends User {

    public Reviewer(String email, String password, String name, String gender, String address, GregorianCalendar birthDate, boolean premium, int totalFound, String tb, ArrayList<Cache> caches, HashMap<String, User> friends) {
        super(email, password, name, gender, address, birthDate, premium, totalFound, tb, caches, friends);
    }

}

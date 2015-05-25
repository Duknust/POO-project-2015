package user;

import base.Data;
import caches.Cache;
import caches.Log;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Admin extends Reviewer {

    public Admin(String email, String password, String name, String gender, String address, GregorianCalendar birthDate, boolean premium, int totalFound, HashMap<String, Cache> caches, HashMap<String, User> friends, Data data) {
        super(email, password, name, gender, address, birthDate, premium, totalFound, caches, friends, data);
    }

    void deleteLog(Log l, Cache c) {
        c.getCache_Logs().remove(l.getDate(), l);
    }

    @Override
    public Role getRole() {
        return Role.ADMIN;
    }
}

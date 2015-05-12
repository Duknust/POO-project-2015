package base;

import activity.Activity;
import caches.Cache;
import java.util.HashMap;
import java.util.TreeMap;
import user.UserAbstract;

public class Geocaching {

    HashMap<String, Cache> allCaches = null;
    HashMap<String, UserAbstract> allUsers = null;
    TreeMap<String, Activity> allActivities = null;
    static Data data = null;

    public static void main(String[] args) {
        System.out.println("Welcome to Geocaching");
        /*
         * Position p1 = new Position(41.5503200, -8.4200500); Position p2 = new
         * Position(41.6503200, -8.4200500); GeoTools gt = new GeoTools();
         * System.out.println(gt.calcDistance(p1, p2));
         *
         * MeteoOnline mo = new MeteoOnline(); Meteo m = mo.getOnlineWeather(new
         * Position(41.5503200, -8.4200500));
         *
         * System.out.println(m.toString());
         */
        CountriesData cd = new CountriesData();
        data = new Data();
        System.out.println(cd.getCountryFromEurope(true));

    }

    public static Data getData() {
        return data;
    }

}

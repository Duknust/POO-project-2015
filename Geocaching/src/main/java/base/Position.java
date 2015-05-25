package base;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Position implements Serializable {

    private double lati = 0.0;
    private double longi = 0.0;
    private String continent = "";
    private String country = "";
    private String city = "";
    private float difficulty = 0;

    public Position() {

    }

    public Position(double lati, double longi) {
        this.lati = lati;
        this.longi = longi;
    }

    public Position(double lati, double longi, float difficulty) {
        this.lati = lati;
        this.longi = longi;
        this.difficulty = difficulty;
    }

    public Position(double lati, double longi, String continent,
            String country, String city, float difficulty) {
        this.lati = lati;
        this.longi = longi;
        this.continent = continent;
        this.country = country;
        this.city = city;
        this.difficulty = difficulty;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public double getLongi() {
        return longi;
    }

    public void setLongi(double longi) {
        this.longi = longi;
    }

    public double getLati() {
        return lati;
    }

    public void setLati(double lati) {
        this.lati = lati;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(float difficulty) {
        this.difficulty = difficulty;
    }

    // ToString
    @Override
    public String toString() {
        return "Position{" + "lati=" + lati + ", longi=" + longi
                + ", country='" + country + '\'' + ", city='" + city + '\''
                + ", difficulty=" + difficulty + '}';
    }

    public String toListing() {
        return "Terrain = " + this.difficulty + "\nPosition = " + lati + " , "
                + longi;
    }

    public String getCoords() {
        return this.lati + "," + longi;
    }

    public int getSeason(boolean northHemisphere, GregorianCalendar date) {// 0-winter;
        // 1-spring;
        // 2-summer; 3-autumn
        int res;
        int weeks = date.getWeekYear();
        if (northHemisphere) {
            if (weeks < 13) {
                res = 0;
            } else if (weeks < 26) {
                res = 1;
            } else if (weeks < 39) {
                res = 2;
            } else {
                res = 3;
            }
        } else {
            if (weeks < 13) {
                res = 2;
            } else if (weeks < 26) {
                res = 3;
            } else if (weeks < 39) {
                res = 0;
            } else {
                res = 1;
            }
        }
        return res;
    }
}

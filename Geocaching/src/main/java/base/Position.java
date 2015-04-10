package base;

public class Position {
	private double lati = 0.0;
	private double longi = 0.0;
	private String country = "";
	private String city = "";
	private float difficulty = 0;

    public Position() {

    }

    public Position(double lati, double longi) {
        this.lati = lati;
        this.longi = longi;
    }

    public Position(double lati, double longi, String country, String city, float difficulty) {
        this.lati = lati;
        this.longi = longi;
        this.country = country;
        this.city = city;
        this.difficulty = difficulty;
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
        return "Position{" +
                "lati=" + lati +
                ", longi=" + longi +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", difficulty=" + difficulty +
                '}';
    }

    public String toListing() {
        return "Terrain = "+this.difficulty+"\nPosition = " + lati + " , " + longi;
    }

}

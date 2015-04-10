package main.java.base;

import java.util.HashMap;
import java.util.Random;

public final class CountriesData {
<<<<<<< HEAD
	// europe
	public static final Position portugal = new Position(38.736946, -9.142685,
			"Europe", "Portugal", "Lisbon", 3);
	public static final Position spain = new Position(40.415363, -3.707398,
			"Europe", "Spain", "Madrid", 2);
	public static final Position italy = new Position(41.890251, 12.492373,
			"Europe", "Italy", "Rome", 2);
	public static final Position france = new Position(48.858093, 2.294694,
			"Europe", "Frace", "Paris", 3);
	public static final Position england = new Position(51.508530, -0.076132,
			"Europe", "England", "London", 2);
	public static final Position germany = new Position(52.518623, 13.376198,
			"Europe", "Germany", "Berlin", 2);
	public static final Position poland = new Position(52.237049, 21.017532,
			"Europe", "Poland", "Warsaw", 3);
	public static final Position sweden = new Position(57.708870, 11.974560,
			"Europe", "Sweden", "Gothenburg", 4);
	public static final Position ireland = new Position(53.350140, -6.266155,
			"Europe", "Ireland", "Dublin", 1);
	public static final Position belgium = new Position(51.260197, 4.402771,
			"Europe", "Belgium", "Antwerp", 1);
	public static final Position austria = new Position(48.210033, 16.363449,
			"Europe", "Austria", "Vienna", 3);
	public static final Position norway = new Position(59.924484, 10.705147,
			"Europe", "Norway", "Oslo", 5);
	public static final Position finland = new Position(60.192059, 24.945831,
			"Europe", "Finland", "Helsinki", 4);
	public static final Position greece = new Position(37.732384, 26.696503,
			"Europe", "Greece", "Marathokampos", 5);
	public static final Position turkey = new Position(39.925533, 32.866287,
			"Europe", "Turkey", "Ankara", 2);
	// north america
	public static final Position canada = new Position(43.750546, -79.716408,
			"North America", "Canada", "Ontario", 1);
	public static final Position usa_L = new Position(37.733795, -122.446747,
			"North America", "USA", "San Francisco", 2);
	public static final Position usa_C = new Position(38.848934, -92.431839,
			"North America", "USA", "Columbia", 2);
	public static final Position usa_R = new Position(29.080168, -81.046669,
			"North America", "USA", "Florida", 3);
	public static final Position mexico = new Position(21.470518, -97.225510,
			"North America", "Mexico", "Veracruz", 5);
	public static final Position guatemala = new Position(14.628434,
			-90.522713, "North America", "Guatemala", "Guatemala City", 4);
	// south america
	public static final Position brazil = new Position(-22.729958, -47.334938,
			"South America", "Brazil", "São Paulo", 4);
	public static final Position argentina = new Position(-34.603722,
			-58.381592, "South America", "Argentina", "Buenos Aires", 3);
	public static final Position uruguay = new Position(-34.901112, -56.164532,
			"South America", "Uruguay", "Montevideo", 2);
	public static final Position colombia = new Position(4.624335, -74.063644,
			"South America", "Colombia", "Bogota", 5);
	public static final Position venezuela = new Position(10.500000,
			-66.916664, "South America", "Venezuela", "Caracas", 5);
	public static final Position peru = new Position(-12.117880, -77.033043,
			"South America", "Peru", "Miraflores", 3);
	public static final Position ecuador = new Position(-0.208946, -78.507751,
			"South America", "Ecuador", "Quito Canton", 4);
	// africa
	public static final Position algeria = new Position(31.700001, 6.066667,
			"Africa", "Algeria", "Hassi Messaoud", 2);
	public static final Position libya = new Position(32.885353, 13.180161,
			"Africa", "Libya", "Tripoli", 5);
	public static final Position egypt = new Position(25.687243, 32.639637,
			"Africa", "Egypt", "Luxor City", 2);
	public static final Position mali = new Position(16.956232, -0.344245,
			"Africa", "Mali", "Bourem", 3);
	public static final Position kenya = new Position(0.182304, 34.296658,
			"Africa", "Kenya", "Ugunja", 3);
	public static final Position angola = new Position(-8.847503, 13.234813,
			"Africa", "Angola", "Luanda", 2);
	public static final Position mozambique = new Position(-12.973203,
			40.517799, "Africa", "Mozambique", "Pemba", 2);
	public static final Position southAfrica = new Position(-26.195246,
			28.034088, "Africa", "South Africa", "Johannesburg", 2);
	// asia
	public static final Position iran = new Position(35.715298, 51.404343,
			"Asia", "Iran", "Tehran", 4);
	public static final Position iraq = new Position(36.741390, 43.893333,
			"Asia", "Iraq", "Akre", 4);
	public static final Position pakistan = new Position(29.266741, 61.564339,
			"Asia", "Pakistan", "Saindak", 3);
	public static final Position china = new Position(39.935539, 116.405640,
			"Asia", "China", "Beijing", 3);
	public static final Position mongolia = new Position(48.078335, 114.535004,
			"Asia", "Mongolia", "Choibalsan", 2);
	public static final Position thailand = new Position(13.736717, 100.523186,
			"Asia", "Thailand", "Bangkok", 1);
	public static final Position malaysia = new Position(1.934400, 103.358727,
			"Asia", "Malaysia", "Johor", 1);
	public static final Position japan = new Position(35.685360, 139.753372,
			"Asia", "Japan", "Tokyo", 5);
	public static final Position northKorea = new Position(37.907639,
			126.160469, "Asia", "North Korea", "South Hwanghae", 5);
	public static final Position southKorea = new Position(37.532600,
			127.024612, "Asia", "South Korea", "Seoul", 2);
	// oceanie
	public static final Position australia = new Position(-27.529953,
			152.407181, "Oceanie", "Australia", "Queensland", 2);
	public static final Position newZealand = new Position(-43.525650,
			172.639847, "Oceanie", "New Zealand", "Christchurch", 2);
	public static final Position samoa = new Position(-13.759029, -172.104629,
			"Oceanie", "Samoa", "Samoa", 4);

	public static final int numbLocalizationsInEurope = 15;
	public static final int numbLocalizationsInNorthAmerica = 6;
	public static final int numbLocalizationsInSouthAmerica = 7;
	public static final int numbLocalizationsInAfrica = 8;
	public static final int numbLocalizationsInAsia = 10;
	public static final int numbLocalizationsInOceanie = 3;

	public static HashMap<String, Position> localizationsInEurope = null;
	public static HashMap<String, Position> localizationsInNorthAmerica = null;
	public static HashMap<String, Position> localizationsInSouthAmerica = null;
	public static HashMap<String, Position> localizationsInAfrica = null;
	public static HashMap<String, Position> localizationsInAsia = null;
	public static HashMap<String, Position> localizationsInOceanie = null;

	public CountriesData() {
		localizationsInEurope = new HashMap<String, Position>();
		localizationsInNorthAmerica = new HashMap<String, Position>();
		localizationsInSouthAmerica = new HashMap<String, Position>();
		localizationsInAfrica = new HashMap<String, Position>();
		localizationsInAsia = new HashMap<String, Position>();
		localizationsInOceanie = new HashMap<String, Position>();

		localizationsInEurope.put(portugal.getCountry(), portugal);
		localizationsInEurope.put(spain.getCountry(), spain);
		localizationsInEurope.put(italy.getCountry(), italy);
		localizationsInEurope.put(france.getCountry(), france);
		localizationsInEurope.put(england.getCountry(), england);
		localizationsInEurope.put(germany.getCountry(), germany);
		localizationsInEurope.put(poland.getCountry(), poland);
		localizationsInEurope.put(sweden.getCountry(), sweden);
		localizationsInEurope.put(ireland.getCountry(), ireland);
		localizationsInEurope.put(belgium.getCountry(), belgium);
		localizationsInEurope.put(austria.getCountry(), austria);
		localizationsInEurope.put(norway.getCountry(), norway);
		localizationsInEurope.put(finland.getCountry(), finland);
		localizationsInEurope.put(greece.getCountry(), greece);
		localizationsInEurope.put(turkey.getCountry(), turkey);

		localizationsInNorthAmerica.put(canada.getCountry(), canada);
		localizationsInNorthAmerica.put(usa_L.getCountry(), usa_L);
		localizationsInNorthAmerica.put(usa_C.getCountry(), usa_C);
		localizationsInNorthAmerica.put(usa_R.getCountry(), usa_R);
		localizationsInNorthAmerica.put(mexico.getCountry(), mexico);
		localizationsInNorthAmerica.put(guatemala.getCountry(), guatemala);

		localizationsInSouthAmerica.put(brazil.getCountry(), brazil);
		localizationsInSouthAmerica.put(argentina.getCountry(), argentina);
		localizationsInSouthAmerica.put(uruguay.getCountry(), uruguay);
		localizationsInSouthAmerica.put(colombia.getCountry(), colombia);
		localizationsInSouthAmerica.put(venezuela.getCountry(), venezuela);
		localizationsInSouthAmerica.put(peru.getCountry(), peru);
		localizationsInSouthAmerica.put(ecuador.getCountry(), ecuador);

		localizationsInAfrica.put(algeria.getCountry(), algeria);
		localizationsInAfrica.put(libya.getCountry(), libya);
		localizationsInAfrica.put(egypt.getCountry(), egypt);
		localizationsInAfrica.put(mali.getCountry(), mali);
		localizationsInAfrica.put(kenya.getCountry(), kenya);
		localizationsInAfrica.put(angola.getCountry(), angola);
		localizationsInAfrica.put(mozambique.getCountry(), mozambique);
		localizationsInAfrica.put(southAfrica.getCountry(), southAfrica);

		localizationsInAsia.put(iran.getCountry(), iran);
		localizationsInAsia.put(iraq.getCountry(), iraq);
		localizationsInAsia.put(pakistan.getCountry(), pakistan);
		localizationsInAsia.put(china.getCountry(), china);
		localizationsInAsia.put(mongolia.getCountry(), mongolia);
		localizationsInAsia.put(thailand.getCountry(), thailand);
		localizationsInAsia.put(malaysia.getCountry(), malaysia);
		localizationsInAsia.put(japan.getCountry(), japan);
		localizationsInAsia.put(northKorea.getCountry(), northKorea);
		localizationsInAsia.put(southKorea.getCountry(), southKorea);

		localizationsInOceanie.put(australia.getCountry(), australia);
		localizationsInOceanie.put(newZealand.getCountry(), newZealand);
		localizationsInOceanie.put(samoa.getCountry(), samoa);
	}

	public Position getRandomPosition() {
		Position res = null;
		Random randomno = new Random();
		float probArea = randomno.nextFloat() * 100;
		if (probArea < 100 / 6) {
			res = getCountryFromEurope();
		} else if (probArea < (100 / 6) * 2) {
			res = getCountryFromNorthAmerica();
		} else if (probArea < (100 / 6) * 3) {
			res = getCountryFromSouthAmerica();
		} else if (probArea < (100 / 6) * 4) {
			res = getCountryFromAfrica();
		} else if (probArea < (100 / 6) * 5) {
			res = getCountryFromAsia();
		} else {
			res = getCountryFromOceania();
		}
		return res;
	}

	public Position getCountryFromEurope() {
		Position res = null;
		Random randomno = new Random();
		float prob = randomno.nextFloat() * 100;
		int i = 0;
		for (String key : localizationsInEurope.keySet()) {
			if (i * 100 / numbLocalizationsInEurope < prob
					&& (i + 1) * 100 / numbLocalizationsInEurope > prob) {
				res = localizationsInEurope.get(key);
				break;
			}
			i++;
		}
		return res;
	}

	public Position getCountryFromNorthAmerica() {
		Position res = null;
		Random randomno = new Random();
		float prob = randomno.nextFloat() * 100;
		int i = 0;
		for (String key : localizationsInNorthAmerica.keySet()) {
			if (i * 100 / numbLocalizationsInNorthAmerica < prob
					&& (i + 1) * 100 / numbLocalizationsInNorthAmerica > prob) {
				res = localizationsInNorthAmerica.get(key);
				break;
			}
			i++;
		}
		return res;
	}

	public Position getCountryFromSouthAmerica() {
		Position res = null;
		Random randomno = new Random();
		float prob = randomno.nextFloat() * 100;
		int i = 0;
		for (String key : localizationsInSouthAmerica.keySet()) {
			if (i * 100 / numbLocalizationsInSouthAmerica < prob
					&& (i + 1) * 100 / numbLocalizationsInSouthAmerica > prob) {
				res = localizationsInSouthAmerica.get(key);
				break;
			}
			i++;
		}
		return res;
	}

	public Position getCountryFromAfrica() {
		Position res = null;
		Random randomno = new Random();
		float prob = randomno.nextFloat() * 100;
		int i = 0;
		for (String key : localizationsInAfrica.keySet()) {
			if (i * 100 / numbLocalizationsInAfrica < prob
					&& (i + 1) * 100 / numbLocalizationsInAfrica > prob) {
				res = localizationsInAfrica.get(key);
				break;
			}
			i++;
		}
		return res;
	}

	public Position getCountryFromAsia() {
		Position res = null;
		Random randomno = new Random();
		float prob = randomno.nextFloat() * 100;
		int i = 0;
		for (String key : localizationsInAsia.keySet()) {
			if (i * 100 / numbLocalizationsInAsia < prob
					&& (i + 1) * 100 / numbLocalizationsInAsia > prob) {
				res = localizationsInAsia.get(key);
				break;
			}
			i++;
		}
		return res;
	}

	public Position getCountryFromOceania() {
		Position res = null;
		Random randomno = new Random();
		float prob = randomno.nextFloat() * 100;
		int i = 0;
		for (String key : localizationsInOceanie.keySet()) {
			if (i * 100 / numbLocalizationsInOceanie < prob
					&& (i + 1) * 100 / numbLocalizationsInOceanie > prob) {
				res = localizationsInOceanie.get(key);
				break;
			}
			i++;
		}
		return res;
	}
=======

    //europe
    public static final Position portugal = new Position(38.736946, -9.142685);
    public static final Position spain = new Position(40.415363, -3.707398);
    public static final Position italy = new Position(41.890251, 12.492373);
    public static final Position france = new Position(,);
    public static final Position england = new Position(,);
    public static final Position germany = new Position(,);
    public static final Position poland = new Position(,);
    public static final Position sweden = new Position(,);
    public static final Position ireland = new Position(,);
    public static final Position belgium = new Position(,);
    public static final Position austria = new Position(,);
    public static final Position norway = new Position(,);
    public static final Position finland = new Position(,);
    public static final Position greece = new Position(,);
    public static final Position turkey = new Position(,);
    //north america
    public static final Position canada = new Position(,);
    public static final Position usa_L = new Position(,);
    public static final Position usa_C = new Position(,);
    public static final Position usa_R = new Position(,);
    public static final Position mexico = new Position(,);
    public static final Position guatemala = new Position(,);
    public static final Position cuba = new Position(,);
    //south america
    public static final Position brazil = new Position(,);
    public static final Position argentina = new Position(,);
    public static final Position uruguay = new Position(,);
    public static final Position colombia = new Position(,);
    public static final Position venezuela = new Position(,);
    public static final Position peru = new Position(,);
    public static final Position ecuador = new Position(,);
    //africa
    public static final Position algeria = new Position(,);
    public static final Position libya = new Position(,);
    public static final Position egypt = new Position(,);
    public static final Position mali = new Position(,);
    public static final Position kenya = new Position(,);
    public static final Position angola = new Position(,);
    public static final Position mozambique = new Position(,);
    public static final Position southAfrica = new Position(,);
    //asia
    public static final Position iran = new Position(,);
    public static final Position iraq = new Position(,);
    public static final Position pakistan = new Position(,);
    public static final Position china = new Position(,);
    public static final Position mongolia = new Position(,);
    public static final Position thailand = new Position(,);
    public static final Position malaysia = new Position(,);
    public static final Position japan = new Position(,);
    public static final Position northKorea = new Position(,);
    public static final Position southKorea = new Position(,);
    //oceanie
    public static final Position australia = new Position(,);
    public static final Position newZealand = new Position(,);
    public static final Position samoa = new Position(,);

    public static final int numbLocalizationsInEurope = 15;
    public static final int numbLocalizationsInNorthAmerica = 7;
    public static final int numbLocalizationsInSouthAmerica = 7;
    public static final int numbLocalizationsInAfrica = 8;
    public static final int numbLocalizationsInAsia = 10;
    public static final int numbLocalizationsInOceanie = 3;

    public static HashMap<String, Position> localizationsInEurope = null;
    public static HashMap<String, Position> localizationsInNorthAmerica = null;
    public static HashMap<String, Position> localizationsInSouthAmerica = null;
    public static HashMap<String, Position> localizationsInAfrica = null;
    public static HashMap<String, Position> localizationsInAsia = null;
    public static HashMap<String, Position> localizationsInOceanie = null;

    public CountriesData() {
        localizationsInEurope = new HashMap<String, Position>();
        localizationsInNorthAmerica = new HashMap<String, Position>();
        localizationsInSouthAmerica = new HashMap<String, Position>();
        localizationsInAfrica = new HashMap<String, Position>();
        localizationsInAsia = new HashMap<String, Position>();
        localizationsInOceanie = new HashMap<String, Position>();

        localizationsInEurope.put(portugal.getCountry(), portugal);
        localizationsInEurope.put(spain.getCountry(), spain);
        localizationsInEurope.put(italy.getCountry(), italy);
        localizationsInEurope.put(france.getCountry(), france);
        localizationsInEurope.put(england.getCountry(), england);
        localizationsInEurope.put(germany.getCountry(), germany);
        localizationsInEurope.put(poland.getCountry(), poland);
        localizationsInEurope.put(sweden.getCountry(), sweden);
        localizationsInEurope.put(ireland.getCountry(), ireland);
        localizationsInEurope.put(belgium.getCountry(), belgium);
        localizationsInEurope.put(austria.getCountry(), austria);
        localizationsInEurope.put(norway.getCountry(), norway);
        localizationsInEurope.put(finland.getCountry(), finland);
        localizationsInEurope.put(greece.getCountry(), greece);
        localizationsInEurope.put(turkey.getCountry(), turkey);
    }

    public Position getRandomPosition() {
        return null;
    }

    public Position getCountryFromEurope() {
        return null;
    }

    public Position getCountryFromNorthAmerica() {
        return null;
    }

    public Position getCountryFromSouthAmerica() {
        return null;
    }

    public Position getCountryFromAfrica() {
        return null;
    }

    public Position getCountryFromAsia() {
        return null;
    }

    public Position getCountryFromOceania() {
        Position res = null;
        Random randomno = new Random();
        float prob = randomno.nextFloat() * 100;
        if prob
	  {

        }
    }
>>>>>>> 22c5438facafb9a5bc004b73b0ec38b2c40094e3
}

package dataCreation;

import java.util.HashMap;
import java.util.Random;

import base.Position;
import base.Utilities;

public final class CountriesData {

	// europe
	private static final Position portugal = new Position(38.736946, -9.142685,
			"Europe", "Portugal", "Lisbon", 3);
	private static final Position spain = new Position(40.415363, -3.707398,
			"Europe", "Spain", "Madrid", 2);
	private static final Position italy = new Position(41.890251, 12.492373,
			"Europe", "Italy", "Rome", 2);
	private static final Position france = new Position(48.858093, 2.294694,
			"Europe", "Frace", "Paris", 3);
	private static final Position england = new Position(51.508530, -0.076132,
			"Europe", "England", "London", 2);
	private static final Position germany = new Position(52.518623, 13.376198,
			"Europe", "Germany", "Berlin", 2);
	private static final Position poland = new Position(52.237049, 21.017532,
			"Europe", "Poland", "Warsaw", 3);
	private static final Position sweden = new Position(57.708870, 11.974560,
			"Europe", "Sweden", "Gothenburg", 4);
	private static final Position ireland = new Position(53.350140, -6.266155,
			"Europe", "Ireland", "Dublin", 1);
	private static final Position belgium = new Position(51.260197, 4.402771,
			"Europe", "Belgium", "Antwerp", 1);
	private static final Position austria = new Position(48.210033, 16.363449,
			"Europe", "Austria", "Vienna", 3);
	private static final Position norway = new Position(59.924484, 10.705147,
			"Europe", "Norway", "Oslo", 5);
	private static final Position finland = new Position(60.192059, 24.945831,
			"Europe", "Finland", "Helsinki", 4);
	private static final Position greece = new Position(37.732384, 26.696503,
			"Europe", "Greece", "Marathokampos", 5);
	private static final Position turkey = new Position(39.925533, 32.866287,
			"Europe", "Turkey", "Ankara", 2);
	// north america
	private static final Position canada = new Position(43.750546, -79.716408,
			"North America", "Canada", "Ontario", 1);
	private static final Position usa_L = new Position(37.733795, -122.446747,
			"North America", "USA", "San Francisco", 2);
	private static final Position usa_C = new Position(38.848934, -92.431839,
			"North America", "USA", "Columbia", 2);
	private static final Position usa_R = new Position(29.080168, -81.046669,
			"North America", "USA", "Florida", 3);
	private static final Position mexico = new Position(21.470518, -97.225510,
			"North America", "Mexico", "Veracruz", 5);
	private static final Position guatemala = new Position(14.628434,
			-90.522713, "North America", "Guatemala", "Guatemala City", 4);
	// south america
	private static final Position brazil = new Position(-22.729958, -47.334938,
			"South America", "Brazil", "São Paulo", 4);
	private static final Position argentina = new Position(-34.603722,
			-58.381592, "South America", "Argentina", "Buenos Aires", 3);
	private static final Position uruguay = new Position(-34.901112,
			-56.164532, "South America", "Uruguay", "Montevideo", 2);
	private static final Position colombia = new Position(4.624335, -74.063644,
			"South America", "Colombia", "Bogota", 5);
	private static final Position venezuela = new Position(10.500000,
			-66.916664, "South America", "Venezuela", "Caracas", 5);
	private static final Position peru = new Position(-12.117880, -77.033043,
			"South America", "Peru", "Miraflores", 3);
	private static final Position ecuador = new Position(-0.208946, -78.507751,
			"South America", "Ecuador", "Quito Canton", 4);
	// africa
	private static final Position algeria = new Position(31.700001, 6.066667,
			"Africa", "Algeria", "Hassi Messaoud", 2);
	private static final Position libya = new Position(32.885353, 13.180161,
			"Africa", "Libya", "Tripoli", 5);
	private static final Position egypt = new Position(25.687243, 32.639637,
			"Africa", "Egypt", "Luxor City", 2);
	private static final Position mali = new Position(16.956232, -0.344245,
			"Africa", "Mali", "Bourem", 3);
	private static final Position kenya = new Position(0.182304, 34.296658,
			"Africa", "Kenya", "Ugunja", 3);
	private static final Position angola = new Position(-8.847503, 13.234813,
			"Africa", "Angola", "Luanda", 2);
	private static final Position mozambique = new Position(-12.973203,
			40.517799, "Africa", "Mozambique", "Pemba", 2);
	private static final Position southAfrica = new Position(-26.195246,
			28.034088, "Africa", "South Africa", "Johannesburg", 2);
	// asia
	private static final Position iran = new Position(35.715298, 51.404343,
			"Asia", "Iran", "Tehran", 4);
	private static final Position iraq = new Position(36.741390, 43.893333,
			"Asia", "Iraq", "Akre", 4);
	private static final Position pakistan = new Position(29.266741, 61.564339,
			"Asia", "Pakistan", "Saindak", 3);
	private static final Position china = new Position(39.935539, 116.405640,
			"Asia", "China", "Beijing", 3);
	private static final Position mongolia = new Position(48.078335,
			114.535004, "Asia", "Mongolia", "Choibalsan", 2);
	private static final Position thailand = new Position(13.736717,
			100.523186, "Asia", "Thailand", "Bangkok", 1);
	private static final Position malaysia = new Position(1.934400, 103.358727,
			"Asia", "Malaysia", "Johor", 1);
	private static final Position japan = new Position(35.685360, 139.753372,
			"Asia", "Japan", "Tokyo", 5);
	private static final Position northKorea = new Position(37.907639,
			126.160469, "Asia", "North Korea", "South Hwanghae", 5);
	private static final Position southKorea = new Position(37.532600,
			127.024612, "Asia", "South Korea", "Seoul", 2);
	// oceanie
	private static final Position australia = new Position(-27.529953,
			152.407181, "Oceanie", "Australia", "Queensland", 2);
	private static final Position newZealand = new Position(-43.525650,
			172.639847, "Oceanie", "New Zealand", "Christchurch", 2);
	private static final Position samoa = new Position(-13.759029, -172.104629,
			"Oceanie", "Samoa", "Samoa", 4);
	private static final Position antartica = new Position(-66.652935,
			53.021466, "Antartica", "Antartica", "Antartica", 5);

	private static final int numbLocalizationsInEurope = 15;
	private static final int numbLocalizationsInNorthAmerica = 6;
	private static final int numbLocalizationsInSouthAmerica = 7;
	private static final int numbLocalizationsInAfrica = 8;
	private static final int numbLocalizationsInAsia = 10;
	private static final int numbLocalizationsInOceanie = 3;

	private static HashMap<String, Position> localizationsInEurope = null;
	private static HashMap<String, Position> localizationsInNorthAmerica = null;
	private static HashMap<String, Position> localizationsInSouthAmerica = null;
	private static HashMap<String, Position> localizationsInAfrica = null;
	private static HashMap<String, Position> localizationsInAsia = null;
	private static HashMap<String, Position> localizationsInOceanie = null;
	private static HashMap<String, Position> localizationsInAntartica = null;

	public CountriesData() {
		localizationsInEurope = new HashMap<>();
		localizationsInNorthAmerica = new HashMap<>();
		localizationsInSouthAmerica = new HashMap<>();
		localizationsInAfrica = new HashMap<>();
		localizationsInAsia = new HashMap<>();
		localizationsInOceanie = new HashMap<>();
		localizationsInAntartica = new HashMap<>();

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

		localizationsInAntartica.put(samoa.getCountry(), samoa);
	}

	public Position getRandomPosition() {
		Position res;
		Random randomno = new Random();
		float probArea = randomno.nextFloat() * 100;
		if (probArea < 100 / 6) {
			res = getCountryFromEurope(true);
		} else if (probArea < (100 / 6) * 2) {
			res = getCountryFromNorthAmerica(true);
		} else if (probArea < (100 / 6) * 3) {
			res = getCountryFromSouthAmerica(true);
		} else if (probArea < (100 / 6) * 4) {
			res = getCountryFromAfrica(true);
		} else if (probArea < (100 / 6) * 5) {
			res = getCountryFromAsia(true);
		} else {
			res = getCountryFromOceania(true);
		}
		return res;
	}

	public Position getCountryFromEurope(Boolean generateDiff) {
		Position res = null;
		Random randomno = new Random();
		float prob = randomno.nextFloat() * 100;
		int i = 0;
		for (String key : localizationsInEurope.keySet()) {
			if (i * 100 / numbLocalizationsInEurope < prob
					&& (i + 1) * 100 / numbLocalizationsInEurope > prob) {
				res = localizationsInEurope.get(key);
				if (generateDiff) {
					res.setDifficulty(Utilities.getValueToDifficulty());
				}
				break;
			}
			i++;
		}
		return res;
	}

	public Position getCountryFromNorthAmerica(Boolean generateDiff) {
		Position res = null;
		Random randomno = new Random();
		float prob = randomno.nextFloat() * 100;
		int i = 0;
		for (String key : localizationsInNorthAmerica.keySet()) {
			if (i * 100 / numbLocalizationsInNorthAmerica < prob
					&& (i + 1) * 100 / numbLocalizationsInNorthAmerica > prob) {
				res = localizationsInNorthAmerica.get(key);
				if (generateDiff) {
					res.setDifficulty(Utilities.getValueToDifficulty());
				}
				break;
			}
			i++;
		}
		return res;
	}

	public Position getCountryFromSouthAmerica(Boolean generateDiff) {
		Position res = null;
		Random randomno = new Random();
		float prob = randomno.nextFloat() * 100;
		int i = 0;
		for (String key : localizationsInSouthAmerica.keySet()) {
			if (i * 100 / numbLocalizationsInSouthAmerica < prob
					&& (i + 1) * 100 / numbLocalizationsInSouthAmerica > prob) {
				res = localizationsInSouthAmerica.get(key);
				if (generateDiff) {
					res.setDifficulty(Utilities.getValueToDifficulty());
				}
				break;
			}
			i++;
		}
		return res;
	}

	public Position getCountryFromAfrica(Boolean generateDiff) {
		Position res = null;
		Random randomno = new Random();
		float prob = randomno.nextFloat() * 100;
		int i = 0;
		for (String key : localizationsInAfrica.keySet()) {
			if (i * 100 / numbLocalizationsInAfrica < prob
					&& (i + 1) * 100 / numbLocalizationsInAfrica > prob) {
				res = localizationsInAfrica.get(key);
				if (generateDiff) {
					res.setDifficulty(Utilities.getValueToDifficulty());
				}
				break;
			}
			i++;
		}
		return res;
	}

	public Position getCountryFromAsia(Boolean generateDiff) {
		Position res = null;
		Random randomno = new Random();
		float prob = randomno.nextFloat() * 100;
		int i = 0;
		for (String key : localizationsInAsia.keySet()) {
			if (i * 100 / numbLocalizationsInAsia < prob
					&& (i + 1) * 100 / numbLocalizationsInAsia > prob) {
				res = localizationsInAsia.get(key);
				if (generateDiff) {
					res.setDifficulty(Utilities.getValueToDifficulty());
				}
				break;
			}
			i++;
		}
		return res;
	}

	public Position getCountryFromOceania(Boolean generateDiff) {
		Position res = null;
		Random randomno = new Random();
		float prob = randomno.nextFloat() * 100;
		int i = 0;
		for (String key : localizationsInOceanie.keySet()) {
			if (i * 100 / numbLocalizationsInOceanie < prob
					&& (i + 1) * 100 / numbLocalizationsInOceanie > prob) {
				res = localizationsInOceanie.get(key);
				if (generateDiff) {
					res.setDifficulty(Utilities.getValueToDifficulty());
				}
				break;
			}
			i++;
		}
		return res;
	}

	public Position getCountryByName(String country, String continent) {
		Position res = null;
		continent = Utilities.firstLetterCapital(continent);
		if (continent.equals("Europe")) {
			res = localizationsInEurope.get(country);
		} else if (continent.equals("NorthAmerica")) {
			res = localizationsInEurope.get(country);
		} else if (continent.equals("SouthAmerica")) {
			res = localizationsInEurope.get(country);
		} else if (continent.equals("Africa")) {
			res = localizationsInEurope.get(country);
		} else if (continent.equals("Asia")) {
			res = localizationsInEurope.get(country);
		} else if (continent.equals("Oceanie")) {
			res = localizationsInEurope.get(country);
		}

		return res;
	}
}

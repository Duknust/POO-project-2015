package dataCreation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import user.User;

public final class UsersData {
	String emailDomain = "@bananacorp-geo.com";

	// europe
	public static final ArrayList<String> portugalNames = new ArrayList<String>();
	public static final ArrayList<String> portugalSurnames = new ArrayList<String>();
	public static final ArrayList<String> spainNames = new ArrayList<String>();
	public static final ArrayList<String> spainSurnames = new ArrayList<String>();
	public static final ArrayList<String> italyNames = new ArrayList<String>();
	public static final ArrayList<String> italySurnames = new ArrayList<String>();
	public static final ArrayList<String> franceNames = new ArrayList<String>();
	public static final ArrayList<String> franceSurnames = new ArrayList<String>();
	public static final ArrayList<String> englandNames = new ArrayList<String>();
	public static final ArrayList<String> englandSurnames = new ArrayList<String>();
	public static final ArrayList<String> germanyNames = new ArrayList<String>();
	public static final ArrayList<String> germanySurnames = new ArrayList<String>();
	public static final ArrayList<String> polandNames = new ArrayList<String>();
	public static final ArrayList<String> polandSurnames = new ArrayList<String>();
	public static final ArrayList<String> swedenNames = new ArrayList<String>();
	public static final ArrayList<String> swedenSurnames = new ArrayList<String>();
	public static final ArrayList<String> irelandNames = new ArrayList<String>();
	public static final ArrayList<String> irelandSurnames = new ArrayList<String>();
	public static final ArrayList<String> belgiumNames = new ArrayList<String>();
	public static final ArrayList<String> belgiumSurnames = new ArrayList<String>();
	public static final ArrayList<String> austriaNames = new ArrayList<String>();
	public static final ArrayList<String> austriaSurnames = new ArrayList<String>();
	public static final ArrayList<String> norwayNames = new ArrayList<String>();
	public static final ArrayList<String> norwaySurnames = new ArrayList<String>();
	public static final ArrayList<String> finlandNames = new ArrayList<String>();
	public static final ArrayList<String> finlandSurnames = new ArrayList<String>();
	public static final ArrayList<String> greeceNames = new ArrayList<String>();
	public static final ArrayList<String> greeceSurnames = new ArrayList<String>();
	public static final ArrayList<String> turkeyNames = new ArrayList<String>();
	public static final ArrayList<String> turkeySurnames = new ArrayList<String>();

	// north america
	public static final ArrayList<String> canadaNames = new ArrayList<String>();
	public static final ArrayList<String> canadaSurnames = new ArrayList<String>();
	public static final ArrayList<String> usaNames = new ArrayList<String>();
	public static final ArrayList<String> usaSurnames = new ArrayList<String>();
	public static final ArrayList<String> mexicoNames = new ArrayList<String>();
	public static final ArrayList<String> mexicoSurnames = new ArrayList<String>();
	public static final ArrayList<String> guatemalaNames = new ArrayList<String>();
	public static final ArrayList<String> guatemalaSurnames = new ArrayList<String>();

	// south america
	public static final ArrayList<String> brazilNames = new ArrayList<String>();
	public static final ArrayList<String> brazilSurnames = new ArrayList<String>();
	public static final ArrayList<String> argentinaNames = new ArrayList<String>();
	public static final ArrayList<String> argentinaSurnames = new ArrayList<String>();
	public static final ArrayList<String> uruguayNames = new ArrayList<String>();
	public static final ArrayList<String> uruguaySurnames = new ArrayList<String>();
	public static final ArrayList<String> colombiaNames = new ArrayList<String>();
	public static final ArrayList<String> colombiaSurnames = new ArrayList<String>();
	public static final ArrayList<String> venezuelaNames = new ArrayList<String>();
	public static final ArrayList<String> venezuelaSurnames = new ArrayList<String>();
	public static final ArrayList<String> peruNames = new ArrayList<String>();
	public static final ArrayList<String> peruSurnames = new ArrayList<String>();
	public static final ArrayList<String> ecuadorNames = new ArrayList<String>();
	public static final ArrayList<String> ecuadorSurnames = new ArrayList<String>();

	// africa
	public static final ArrayList<String> algeriaNames = new ArrayList<String>();
	public static final ArrayList<String> algeriaSurnames = new ArrayList<String>();
	public static final ArrayList<String> libyaNames = new ArrayList<String>();
	public static final ArrayList<String> libyaSurnames = new ArrayList<String>();
	public static final ArrayList<String> egyptNames = new ArrayList<String>();
	public static final ArrayList<String> egyptSurnames = new ArrayList<String>();
	public static final ArrayList<String> maliNames = new ArrayList<String>();
	public static final ArrayList<String> maliSurnames = new ArrayList<String>();
	public static final ArrayList<String> kenyaNames = new ArrayList<String>();
	public static final ArrayList<String> kenyaSurnames = new ArrayList<String>();
	public static final ArrayList<String> angolaNames = new ArrayList<String>();
	public static final ArrayList<String> angolaSurnames = new ArrayList<String>();
	public static final ArrayList<String> mozambiqueNames = new ArrayList<String>();
	public static final ArrayList<String> mozambiqueSurnames = new ArrayList<String>();
	public static final ArrayList<String> southAfricaNames = new ArrayList<String>();
	public static final ArrayList<String> southAfricaSurnames = new ArrayList<String>();

	// asia
	public static final ArrayList<String> iranNames = new ArrayList<String>();
	public static final ArrayList<String> iranSurnames = new ArrayList<String>();
	public static final ArrayList<String> pakistanNames = new ArrayList<String>();
	public static final ArrayList<String> pakistanSurnames = new ArrayList<String>();
	public static final ArrayList<String> chinaNames = new ArrayList<String>();
	public static final ArrayList<String> chinaSurnames = new ArrayList<String>();
	public static final ArrayList<String> mongoliaNames = new ArrayList<String>();
	public static final ArrayList<String> mongoliaSurnames = new ArrayList<String>();
	public static final ArrayList<String> thailandNames = new ArrayList<String>();
	public static final ArrayList<String> thailandSurnames = new ArrayList<String>();
	public static final ArrayList<String> malaysiaNames = new ArrayList<String>();
	public static final ArrayList<String> malaysiaSurnames = new ArrayList<String>();
	public static final ArrayList<String> japanNames = new ArrayList<String>();
	public static final ArrayList<String> japanSurnames = new ArrayList<String>();
	public static final ArrayList<String> northKoreaNames = new ArrayList<String>();
	public static final ArrayList<String> northKoreaSurnames = new ArrayList<String>();
	public static final ArrayList<String> southKoreaNames = new ArrayList<String>();
	public static final ArrayList<String> southKoreaSurnames = new ArrayList<String>();

	// oceanie
	public static final ArrayList<String> australiaNames = new ArrayList<String>();
	public static final ArrayList<String> australiaSurnames = new ArrayList<String>();
	public static final ArrayList<String> newZealandNames = new ArrayList<String>();
	public static final ArrayList<String> newZealandSurnames = new ArrayList<String>();
	public static final ArrayList<String> samoaNames = new ArrayList<String>();
	public static final ArrayList<String> samoaSurnames = new ArrayList<String>();

	public static final int numbLocalizationsInEurope = 15;
	public static final int numbLocalizationsInNorthAmerica = 6;
	public static final int numbLocalizationsInSouthAmerica = 7;
	public static final int numbLocalizationsInAfrica = 8;
	public static final int numbLocalizationsInAsia = 10;
	public static final int numbLocalizationsInOceanie = 3;

	public static HashMap<String, ArrayList<ArrayList<String>>> countriesInEurope = null;
	public static HashMap<String, ArrayList<ArrayList<String>>> countriesInNorthAmerica = null;
	public static HashMap<String, ArrayList<ArrayList<String>>> localizationsInSouthAmerica = null;
	public static HashMap<String, ArrayList<ArrayList<String>>> localizationsInAfrica = null;
	public static HashMap<String, ArrayList<ArrayList<String>>> localizationsInAsia = null;
	public static HashMap<String, ArrayList<ArrayList<String>>> localizationsInOceanie = null;

	public UsersData() {
		populateEurope();
		populateNorthAmerica();
		populateSouthAmerica();
		populateAfrica();
		populateAsia();
		populateOceanie();

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

	private void populateOceanie() {
		// TODO Auto-generated method stub

	}

	private void populateAsia() {
		// TODO Auto-generated method stub

	}

	private void populateAfrica() {
		// TODO Auto-generated method stub

	}

	private void populateSouthAmerica() {
		// TODO Auto-generated method stub

	}

	private void populateNorthAmerica() {
		// TODO Auto-generated method stub

	}

	private void populateEurope() {
		// portugal
		// names
		portugalNames.add("João");
		portugalNames.add("Afonso");
		portugalNames.add("Duarte");
		portugalNames.add("Nuno");
		portugalNames.add("Fábio");
		portugalNames.add("André");
		portugalNames.add("Hélder");
		portugalNames.add("José");
		// surnames
		portugalSurnames.add("Xistra");
		portugalNames.add("Pereira");
		portugalNames.add("Duarte");
		portugalNames.add("Ferreira");
		portugalNames.add("Gomes");
		portugalNames.add("Araújo");
		portugalNames.add("Gonçalves");
		portugalNames.add("Alves");

		// spain
		// names

	}

	public User getRandomUser() {
		User res;
		Random randomno = new Random();
		float probArea = randomno.nextFloat() * 100;
		if (probArea < 100 / 6) {
			res = getUserFromEurope(true);
		} else if (probArea < (100 / 6) * 2) {
			res = getUserFromNorthAmerica(true);
		} else if (probArea < (100 / 6) * 3) {
			res = getUserFromSouthAmerica(true);
		} else if (probArea < (100 / 6) * 4) {
			res = getUserFromAfrica(true);
		} else if (probArea < (100 / 6) * 5) {
			res = getUserFromAsia(true);
		} else {
			res = getUserFromOceania(true);
		}
		return res;
	}

	public User getUserFromEurope() {
		User res = null;
		Random randomno = new Random();
		float prob = randomno.nextFloat() * 100;
		int i = 0;
		for (String key : countriesInEurope.keySet()) {
			if (i * 100 / numbCountriesInEurope < prob
					&& (i + 1) * 100 / numbCountriesInEurope > prob) {
				String tmp = countriesInEurope.get(key);

				res = countriesInEurope.get(tmp); // ENCONTRAR

				break;
			}
			i++;
		}
		return res;
	}

}

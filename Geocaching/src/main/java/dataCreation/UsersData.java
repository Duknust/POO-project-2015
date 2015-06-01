package dataCreation;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Random;

import user.User;
import base.Utilities;

public final class UsersData {
	String emailDomain = "@bananacorp-geo.com";

	// europe
	private static ArrayList<String> portugalNamesM = new ArrayList<String>();
	private static ArrayList<String> portugalNamesF = new ArrayList<String>();
	private static ArrayList<String> portugalSurnames = new ArrayList<String>();
	private static ArrayList<String> spainNamesM = new ArrayList<String>();
	private static ArrayList<String> spainNamesF = new ArrayList<String>();
	private static ArrayList<String> spainSurnames = new ArrayList<String>();
	private static ArrayList<String> italyNamesM = new ArrayList<String>();
	private static ArrayList<String> italyNamesF = new ArrayList<String>();
	private static ArrayList<String> italySurnames = new ArrayList<String>();
	private static ArrayList<String> franceNamesM = new ArrayList<String>();
	private static ArrayList<String> franceNamesF = new ArrayList<String>();
	private static ArrayList<String> franceSurnames = new ArrayList<String>();
	private static ArrayList<String> englandNamesM = new ArrayList<String>();
	private static ArrayList<String> englandNamesF = new ArrayList<String>();
	private static ArrayList<String> englandSurnames = new ArrayList<String>();
	private static ArrayList<String> germanyNamesM = new ArrayList<String>();
	private static ArrayList<String> germanyNamesF = new ArrayList<String>();
	private static ArrayList<String> germanySurnames = new ArrayList<String>();
	private static ArrayList<String> polandNamesM = new ArrayList<String>();
	private static ArrayList<String> polandNamesF = new ArrayList<String>();
	private static ArrayList<String> polandSurnames = new ArrayList<String>();
	private static ArrayList<String> swedenNamesM = new ArrayList<String>();
	private static ArrayList<String> swedenNamesF = new ArrayList<String>();
	private static ArrayList<String> swedenSurnames = new ArrayList<String>();
	private static ArrayList<String> irelandNamesM = new ArrayList<String>();
	private static ArrayList<String> irelandNamesF = new ArrayList<String>();
	private static ArrayList<String> irelandSurnames = new ArrayList<String>();
	private static ArrayList<String> belgiumNamesM = new ArrayList<String>();
	private static ArrayList<String> belgiumNamesF = new ArrayList<String>();
	private static ArrayList<String> belgiumSurnames = new ArrayList<String>();
	private static ArrayList<String> austriaNamesM = new ArrayList<String>();
	private static ArrayList<String> austriaNamesF = new ArrayList<String>();
	private static ArrayList<String> austriaSurnames = new ArrayList<String>();
	private static ArrayList<String> norwayNamesM = new ArrayList<String>();
	private static ArrayList<String> norwayNamesF = new ArrayList<String>();
	private static ArrayList<String> norwaySurnames = new ArrayList<String>();
	private static ArrayList<String> finlandNamesM = new ArrayList<String>();
	private static ArrayList<String> finlandNamesF = new ArrayList<String>();
	private static ArrayList<String> finlandSurnames = new ArrayList<String>();
	private static ArrayList<String> greeceNamesM = new ArrayList<String>();
	private static ArrayList<String> greeceNamesF = new ArrayList<String>();
	private static ArrayList<String> greeceSurnames = new ArrayList<String>();
	private static ArrayList<String> turkeyNamesM = new ArrayList<String>();
	private static ArrayList<String> turkeyNamesF = new ArrayList<String>();
	private static ArrayList<String> turkeySurnames = new ArrayList<String>();

	// north america
	private static ArrayList<String> canadaNamesM = new ArrayList<String>();
	private static ArrayList<String> canadaNamesF = new ArrayList<String>();
	private static ArrayList<String> canadaSurnames = new ArrayList<String>();
	private static ArrayList<String> usaNamesM = new ArrayList<String>();
	private static ArrayList<String> usaNamesF = new ArrayList<String>();
	private static ArrayList<String> usaSurnames = new ArrayList<String>();
	private static ArrayList<String> mexicoNamesM = new ArrayList<String>();
	private static ArrayList<String> mexicoNamesF = new ArrayList<String>();
	private static ArrayList<String> mexicoSurnames = new ArrayList<String>();
	private static ArrayList<String> guatemalaNamesM = new ArrayList<String>();
	private static ArrayList<String> guatemalaNamesF = new ArrayList<String>();
	private static ArrayList<String> guatemalaSurnames = new ArrayList<String>();

	// south america
	private static ArrayList<String> brazilNamesM = new ArrayList<String>();
	private static ArrayList<String> brazilNamesF = new ArrayList<String>();
	private static ArrayList<String> brazilSurnames = new ArrayList<String>();
	private static ArrayList<String> argentinaNamesM = new ArrayList<String>();
	private static ArrayList<String> argentinaNamesF = new ArrayList<String>();
	private static ArrayList<String> argentinaSurnames = new ArrayList<String>();
	private static ArrayList<String> uruguayNamesM = new ArrayList<String>();
	private static ArrayList<String> uruguayNamesF = new ArrayList<String>();
	private static ArrayList<String> uruguaySurnames = new ArrayList<String>();
	private static ArrayList<String> colombiaNamesM = new ArrayList<String>();
	private static ArrayList<String> colombiaNamesF = new ArrayList<String>();
	private static ArrayList<String> colombiaSurnames = new ArrayList<String>();
	private static ArrayList<String> venezuelaNamesM = new ArrayList<String>();
	private static ArrayList<String> venezuelaNamesF = new ArrayList<String>();
	private static ArrayList<String> venezuelaSurnames = new ArrayList<String>();
	private static ArrayList<String> peruNamesM = new ArrayList<String>();
	private static ArrayList<String> peruNamesF = new ArrayList<String>();
	private static ArrayList<String> peruSurnames = new ArrayList<String>();
	private static ArrayList<String> ecuadorNamesM = new ArrayList<String>();
	private static ArrayList<String> ecuadorNamesF = new ArrayList<String>();
	private static ArrayList<String> ecuadorSurnames = new ArrayList<String>();

	// africa
	private static ArrayList<String> algeriaNamesM = new ArrayList<String>();
	private static ArrayList<String> algeriaNamesF = new ArrayList<String>();
	private static ArrayList<String> algeriaSurnames = new ArrayList<String>();
	private static ArrayList<String> libyaNamesM = new ArrayList<String>();
	private static ArrayList<String> libyaNamesF = new ArrayList<String>();
	private static ArrayList<String> libyaSurnames = new ArrayList<String>();
	private static ArrayList<String> egyptNamesM = new ArrayList<String>();
	private static ArrayList<String> egyptNamesF = new ArrayList<String>();
	private static ArrayList<String> egyptSurnames = new ArrayList<String>();
	private static ArrayList<String> maliNamesM = new ArrayList<String>();
	private static ArrayList<String> maliNamesF = new ArrayList<String>();
	private static ArrayList<String> maliSurnames = new ArrayList<String>();
	private static ArrayList<String> kenyaNamesM = new ArrayList<String>();
	private static ArrayList<String> kenyaNamesF = new ArrayList<String>();
	private static ArrayList<String> kenyaSurnames = new ArrayList<String>();
	private static ArrayList<String> angolaNamesM = new ArrayList<String>();
	private static ArrayList<String> angolaNamesF = new ArrayList<String>();
	private static ArrayList<String> angolaSurnames = new ArrayList<String>();
	private static ArrayList<String> mozambiqueNamesM = new ArrayList<String>();
	private static ArrayList<String> mozambiqueNamesF = new ArrayList<String>();
	private static ArrayList<String> mozambiqueSurnames = new ArrayList<String>();
	private static ArrayList<String> southAfricaNamesM = new ArrayList<String>();
	private static ArrayList<String> southAfricaNamesF = new ArrayList<String>();
	private static ArrayList<String> southAfricaSurnames = new ArrayList<String>();

	// asia
	private static ArrayList<String> iranNamesM = new ArrayList<String>();
	private static ArrayList<String> iranNamesF = new ArrayList<String>();
	private static ArrayList<String> iranSurnames = new ArrayList<String>();
	private static ArrayList<String> iraqNamesM = new ArrayList<String>();
	private static ArrayList<String> iraqNamesF = new ArrayList<String>();
	private static ArrayList<String> iraqSurnames = new ArrayList<String>();
	private static ArrayList<String> pakistanNamesM = new ArrayList<String>();
	private static ArrayList<String> pakistanNamesF = new ArrayList<String>();
	private static ArrayList<String> pakistanSurnames = new ArrayList<String>();
	private static ArrayList<String> chinaNamesM = new ArrayList<String>();
	private static ArrayList<String> chinaNamesF = new ArrayList<String>();
	private static ArrayList<String> chinaSurnames = new ArrayList<String>();
	private static ArrayList<String> mongoliaNamesM = new ArrayList<String>();
	private static ArrayList<String> mongoliaNamesF = new ArrayList<String>();
	private static ArrayList<String> mongoliaSurnames = new ArrayList<String>();
	private static ArrayList<String> thailandNamesM = new ArrayList<String>();
	private static ArrayList<String> thailandNamesF = new ArrayList<String>();
	private static ArrayList<String> thailandSurnames = new ArrayList<String>();
	private static ArrayList<String> japanNamesM = new ArrayList<String>();
	private static ArrayList<String> japanNamesF = new ArrayList<String>();
	private static ArrayList<String> japanSurnames = new ArrayList<String>();
	private static ArrayList<String> northKoreaNamesM = new ArrayList<String>();
	private static ArrayList<String> northKoreaNamesF = new ArrayList<String>();
	private static ArrayList<String> northKoreaSurnames = new ArrayList<String>();
	private static ArrayList<String> southKoreaNamesM = new ArrayList<String>();
	private static ArrayList<String> southKoreaNamesF = new ArrayList<String>();
	private static ArrayList<String> southKoreaSurnames = new ArrayList<String>();

	// oceanie
	private static ArrayList<String> australiaNamesM = new ArrayList<String>();
	private static ArrayList<String> australiaNamesF = new ArrayList<String>();
	private static ArrayList<String> australiaSurnames = new ArrayList<String>();
	private static ArrayList<String> newZealandNamesM = new ArrayList<String>();
	private static ArrayList<String> newZealandNamesF = new ArrayList<String>();
	private static ArrayList<String> newZealandSurnames = new ArrayList<String>();
	private static ArrayList<String> samoaNamesM = new ArrayList<String>();
	private static ArrayList<String> samoaNamesF = new ArrayList<String>();
	private static ArrayList<String> samoaSurnames = new ArrayList<String>();

	private static final int numbLocalizationsInEurope = 15;
	private static final int numbLocalizationsInNorthAmerica = 4;
	private static final int numbLocalizationsInSouthAmerica = 7;
	private static final int numbLocalizationsInAfrica = 8;
	private static final int numbLocalizationsInAsia = 9;
	private static final int numbLocalizationsInOceanie = 3;

	private static HashMap<String, ArrayList<ArrayList<String>>> countriesInEurope = null;
	private static HashMap<String, ArrayList<ArrayList<String>>> countriesInNorthAmerica = null;
	private static HashMap<String, ArrayList<ArrayList<String>>> countriesInSouthAmerica = null;
	private static HashMap<String, ArrayList<ArrayList<String>>> countriesInAfrica = null;
	private static HashMap<String, ArrayList<ArrayList<String>>> countriesInAsia = null;
	private static HashMap<String, ArrayList<ArrayList<String>>> countriesInOceanie = null;

	private static HashMap<String, CountryInContinent> europe;
	private static HashMap<String, CountryInContinent> northAmerica;
	private static HashMap<String, CountryInContinent> southAmerica;
	private static HashMap<String, CountryInContinent> africa;
	private static HashMap<String, CountryInContinent> asia;
	private static HashMap<String, CountryInContinent> oceanie;

	public UsersData() {
		populateEurope();
		populateNorthAmerica();
		populateSouthAmerica();
		populateAfrica();
		populateAsia();
		populateOceanie();
	}

	private void populateOceanie() {
		oceanie = new HashMap<String, CountryInContinent>();

		// australia
		// names male
		australiaNamesM.add("William");
		australiaNamesM.add("Lucas");
		australiaNamesM.add("Oliver");
		australiaNamesM.add("Noah");
		australiaNamesM.add("Jack");
		australiaNamesM.add("Ethan");
		australiaNamesM.add("Thomas");
		australiaNamesM.add("Lachlan");
		// names female
		australiaNamesF.add("Emily");
		australiaNamesF.add("Emma");
		australiaNamesF.add("Jessica");
		australiaNamesF.add("Chloe");
		australiaNamesF.add("Hannah");
		australiaNamesF.add("Georgia");
		australiaNamesF.add("Amy");
		australiaNamesF.add("Lucy");
		// surnames
		australiaSurnames.add("Queen");
		australiaSurnames.add("Smith");
		australiaSurnames.add("Jones");
		australiaSurnames.add("Williams");
		australiaSurnames.add("Brown");
		australiaSurnames.add("Wilson");
		australiaSurnames.add("Taylor");
		australiaSurnames.add("Nguyen");

		CountryInContinent australia = new CountryInContinent("Australia",
				australiaNamesM, australiaNamesF, australiaSurnames);
		oceanie.put(australia.getCountry(), australia);

		// newZealand
		// names male
		newZealandNamesM.add("Cooper");
		newZealandNamesM.add("Daniel");
		newZealandNamesM.add("Blake");
		newZealandNamesM.add("Benjamin");
		newZealandNamesM.add("Joshua");
		newZealandNamesM.add("Max");
		newZealandNamesM.add("Ryan");
		newZealandNamesM.add("Hunter");
		// names female
		newZealandNamesF.add("Charlotte");
		newZealandNamesF.add("Olivia");
		newZealandNamesF.add("Isla");
		newZealandNamesF.add("Sophie");
		newZealandNamesF.add("Amelia");
		newZealandNamesF.add("Ruby");
		newZealandNamesF.add("Harper");
		newZealandNamesF.add("Ella");
		// surnames
		newZealandSurnames.add("Anderson");
		newZealandSurnames.add("Thompson");
		newZealandSurnames.add("Campbell");
		newZealandSurnames.add("Johnson");
		newZealandSurnames.add("King");
		newZealandSurnames.add("Clark");
		newZealandSurnames.add("Scott");
		newZealandSurnames.add("Martin");

		CountryInContinent newZealand = new CountryInContinent("NewZealand",
				newZealandNamesM, newZealandNamesF, newZealandSurnames);
		oceanie.put(newZealand.getCountry(), newZealand);

		// samoa
		// names male
		samoaNamesM.add("Afa");
		samoaNamesM.add("Fata");
		samoaNamesM.add("Gaugakao");
		samoaNamesM.add("Iosefo");
		samoaNamesM.add("Issac");
		samoaNamesM.add("Jason");
		samoaNamesM.add("Kalolo");
		samoaNamesM.add("Kerisiano");
		// names female
		samoaNamesF.add("Teuila");
		samoaNamesF.add("Lanuola");
		samoaNamesF.add("Elei");
		samoaNamesF.add("Natia");
		samoaNamesF.add("La'ei");
		samoaNamesF.add("Masina");
		samoaNamesF.add("Manaia");
		samoaNamesF.add("Tausa'afia");
		// surnames
		samoaSurnames.add("Savea");
		samoaSurnames.add("Faamoana");
		samoaSurnames.add("Tui");
		samoaSurnames.add("Saluni");
		samoaSurnames.add("Afamasaga");
		samoaSurnames.add("Lotomau");
		samoaSurnames.add("Stowers");
		samoaSurnames.add("Leniu");

		CountryInContinent samoa = new CountryInContinent("Samoa", samoaNamesM,
				samoaNamesF, samoaSurnames);
		oceanie.put(samoa.getCountry(), samoa);
	}

	private void populateAsia() {
		asia = new HashMap<String, CountryInContinent>();

		// iran
		// names male
		iranNamesM.add("Aapeli");
		iranNamesM.add("Babajide");
		iranNamesM.add("Cade");
		iranNamesM.add("Da");
		iranNamesM.add("Gabor");
		iranNamesM.add("Hackett");
		iranNamesM.add("Lachie");
		iranNamesM.add("Obasi");
		// names female
		iranNamesF.add("Aaliyah");
		iranNamesF.add("Babette");
		iranNamesF.add("Cadence");
		iranNamesF.add("Dabria");
		iranNamesF.add("Ealasaid");
		iranNamesF.add("Hadassah");
		iranNamesF.add("Ladonna");
		iranNamesF.add("Octavia");
		// surnames
		iranSurnames.add("Mohammadi");
		iranSurnames.add("Akhtar");
		iranSurnames.add("Balkhi");
		iranSurnames.add("Darvish");
		iranSurnames.add("Ghaznavi");
		iranSurnames.add("Haghighi");
		iranSurnames.add("Makhmalbaf");
		iranSurnames.add("Rouhani");

		CountryInContinent iran = new CountryInContinent("Iran", iranNamesM,
				iranNamesF, iranSurnames);
		asia.put(iran.getCountry(), iran);

		// iraq
		// names male
		iraqNamesM.add("Ali");
		iraqNamesM.add("Akram");
		iraqNamesM.add("Jahmir");
		iraqNamesM.add("Mohammad");
		iraqNamesM.add("Chakvan");
		iraqNamesM.add("Middleeastman");
		iraqNamesM.add("Anshu");
		iraqNamesM.add("Zamanlabib");
		// names female
		iraqNamesF.add("Zainab");
		iraqNamesF.add("Caroline");
		iraqNamesF.add("Melody");
		iraqNamesF.add("Rukia");
		iraqNamesF.add("Dleen");
		iraqNamesF.add("Estabraq");
		iraqNamesF.add("Sham");
		iraqNamesF.add("Allen");
		// surnames
		iraqSurnames.add("Ahmad");
		iraqSurnames.add("Alghafari");
		iraqSurnames.add("Hamade");
		iraqSurnames.add("Husseini");
		iraqSurnames.add("Jaffer");
		iraqSurnames.add("Malaki");
		iraqSurnames.add("Masri");
		iraqSurnames.add("Mustafa");

		CountryInContinent iraq = new CountryInContinent("Iraq", iraqNamesM,
				iraqNamesF, iraqSurnames);
		asia.put(iraq.getCountry(), iraq);

		// pakistan
		// names male
		pakistanNamesM.add("Ali");
		pakistanNamesM.add("Bilal");
		pakistanNamesM.add("Abdul");
		pakistanNamesM.add("Mohammad");
		pakistanNamesM.add("Tariq");
		pakistanNamesM.add("Adnan");
		pakistanNamesM.add("Waqas");
		pakistanNamesM.add("Ibrahim");
		// names female
		pakistanNamesF.add("Noor");
		pakistanNamesF.add("Anam");
		pakistanNamesF.add("Mahnoor");
		pakistanNamesF.add("Javeria");
		pakistanNamesF.add("Sarah");
		pakistanNamesF.add("Mariam");
		pakistanNamesF.add("Faiza");
		pakistanNamesF.add("Komal");
		// surnames
		pakistanSurnames.add("Ahmedani");
		pakistanSurnames.add("Bahawalanzai");
		pakistanSurnames.add("Chutani");
		pakistanSurnames.add("Damanis");
		pakistanSurnames.add("Dasti");
		pakistanSurnames.add("Kenagzai");
		pakistanSurnames.add("Qaisrani");
		pakistanSurnames.add("Rind");

		CountryInContinent pakistan = new CountryInContinent("Pakistan",
				pakistanNamesM, pakistanNamesF, pakistanSurnames);
		asia.put(pakistan.getCountry(), pakistan);

		// china
		// names male
		chinaNamesM.add("Chang");
		chinaNamesM.add("Da");
		chinaNamesM.add("Feng");
		chinaNamesM.add("Ho");
		chinaNamesM.add("Jiao-long");
		chinaNamesM.add("Jing-sheng");
		chinaNamesM.add("Kun");
		chinaNamesM.add("Xiao-ping");
		// names female
		chinaNamesF.add("Ai");
		chinaNamesF.add("Fen");
		chinaNamesF.add("Hua");
		chinaNamesF.add("Ju");
		chinaNamesF.add("Liling");
		chinaNamesF.add("Liang");
		chinaNamesF.add("Mei");
		chinaNamesF.add("Nuo");
		// surnames
		chinaSurnames.add("Wang");
		chinaSurnames.add("Zhang");
		chinaSurnames.add("Liú");
		chinaSurnames.add("Chén");
		chinaSurnames.add("Yang");
		chinaSurnames.add("Huang");
		chinaSurnames.add("Zhao");
		chinaSurnames.add("Wu");

		CountryInContinent china = new CountryInContinent("China", chinaNamesM,
				chinaNamesF, chinaSurnames);
		asia.put(china.getCountry(), china);

		// mongolia
		// names male
		mongoliaNamesM.add("Bat-Erdene");
		mongoliaNamesM.add("Otgonbayar");
		mongoliaNamesM.add("Batbayar");
		mongoliaNamesM.add("Gantulga");
		mongoliaNamesM.add("Ganbold");
		mongoliaNamesM.add("Purevsuren");
		mongoliaNamesM.add("Monkhbat");
		mongoliaNamesM.add("Monkh-Erdene");
		// names female
		mongoliaNamesF.add("Balormaa");
		mongoliaNamesF.add("Monkhtsetseg");
		mongoliaNamesF.add("Erdenechimeg");
		mongoliaNamesF.add("Lkhagvasuren");
		mongoliaNamesF.add("Enkhtuyaa");
		mongoliaNamesF.add("Purevsuren");
		mongoliaNamesF.add("Nergui");
		mongoliaNamesF.add("Oyuunchimeg");
		// surnames
		mongoliaSurnames.add("Zaya");
		mongoliaSurnames.add("Mandukhai");
		mongoliaSurnames.add("Chinbat");
		mongoliaSurnames.add("Bilguun");
		mongoliaSurnames.add("Temuujin");
		mongoliaSurnames.add("Lkhagvasuren");
		mongoliaSurnames.add("Gantumur");
		mongoliaSurnames.add("Tsogt");

		CountryInContinent mongolia = new CountryInContinent("Mongolia",
				mongoliaNamesM, mongoliaNamesF, mongoliaSurnames);
		asia.put(mongolia.getCountry(), mongolia);

		// thailand
		// names male
		thailandNamesM.add("Aat");
		thailandNamesM.add("Boon-Mee");
		thailandNamesM.add("Chai Son");
		thailandNamesM.add("Decha");
		thailandNamesM.add("Kamnan");
		thailandNamesM.add("Lek");
		thailandNamesM.add("Mee Noi");
		thailandNamesM.add("Paitoon");
		// names female
		thailandNamesF.add("Aawut");
		thailandNamesF.add("Benjakalyani");
		thailandNamesF.add("Chaem Choi");
		thailandNamesF.add("Dao");
		thailandNamesF.add("Fa Ying");
		thailandNamesF.add("Han");
		thailandNamesF.add("Isra");
		thailandNamesF.add("Kamlai");
		// surnames
		thailandSurnames.add("Metharom");
		thailandSurnames.add("Boonliang");
		thailandSurnames.add("Jainukul");
		thailandSurnames.add("Suttikul");
		thailandSurnames.add("Praphasirirat");
		thailandSurnames.add("Santisakul");
		thailandSurnames.add("Wattanapanit");
		thailandSurnames.add("Mookjai");

		CountryInContinent thailand = new CountryInContinent("Thailand",
				thailandNamesM, thailandNamesF, thailandSurnames);
		asia.put(thailand.getCountry(), thailand);

		// japan
		// names male
		japanNamesM.add("Akihito");
		japanNamesM.add("Daichi");
		japanNamesM.add("Gaku");
		japanNamesM.add("Mahito");
		japanNamesM.add("Mitsuno");
		japanNamesM.add("Riichi");
		japanNamesM.add("Taiki");
		japanNamesM.add("Yasuhiro");
		// names female
		japanNamesF.add("Benika");
		japanNamesF.add("Ichie");
		japanNamesF.add("June");
		japanNamesF.add("Kae");
		japanNamesF.add("Kasumi");
		japanNamesF.add("Okimi");
		japanNamesF.add("Saaya");
		japanNamesF.add("Tae");
		// surnames
		japanSurnames.add("Sato");
		japanSurnames.add("Suzuki");
		japanSurnames.add("Takahashi");
		japanSurnames.add("Tanaka");
		japanSurnames.add("Watanabe");
		japanSurnames.add("Ito");
		japanSurnames.add("Nakamura");
		japanSurnames.add("Kobyashi");

		CountryInContinent japan = new CountryInContinent("Japan", japanNamesM,
				japanNamesF, japanSurnames);
		asia.put(japan.getCountry(), japan);

		// northKorea
		// names male
		northKoreaNamesM.add("Chul");
		northKoreaNamesM.add("Eun");
		northKoreaNamesM.add("Gun");
		northKoreaNamesM.add("Haneul");
		northKoreaNamesM.add("Hyuk");
		northKoreaNamesM.add("Jae");
		northKoreaNamesM.add("Joon");
		northKoreaNamesM.add("Kwan");
		// names female
		northKoreaNamesF.add("Areum");
		northKoreaNamesF.add("Gi");
		northKoreaNamesF.add("Hye");
		northKoreaNamesF.add("Jong");
		northKoreaNamesF.add("Jung");
		northKoreaNamesF.add("Iseul");
		northKoreaNamesF.add("Nari");
		northKoreaNamesF.add("Ok");
		// surnames
		northKoreaSurnames.add("Kim");
		northKoreaSurnames.add("Lee");
		northKoreaSurnames.add("Park");
		northKoreaSurnames.add("Choi");
		northKoreaSurnames.add("Jeong");
		northKoreaSurnames.add("Kang");
		northKoreaSurnames.add("Cho");
		northKoreaSurnames.add("Yoon");

		CountryInContinent northKorea = new CountryInContinent("NorthKorea",
				northKoreaNamesM, northKoreaNamesF, northKoreaSurnames);
		asia.put(northKorea.getCountry(), northKorea);

		// southKorea
		// names male
		southKoreaNamesM.add("Kwang");
		southKoreaNamesM.add("Kyung");
		southKoreaNamesM.add("Myung");
		southKoreaNamesM.add("Suk");
		southKoreaNamesM.add("Yeong");
		southKoreaNamesM.add("Young");
		southKoreaNamesM.add("Ki");
		southKoreaNamesM.add("Myeong");
		// names female
		southKoreaNamesF.add("Seong");
		southKoreaNamesF.add("Sung");
		southKoreaNamesF.add("Wook");
		southKoreaNamesF.add("Uk");
		southKoreaNamesF.add("Myung");
		southKoreaNamesF.add("Hyeon");
		southKoreaNamesF.add("Iseul");
		southKoreaNamesF.add("Jeong");
		// surnames
		southKoreaSurnames.add("Jang");
		southKoreaSurnames.add("Lim");
		southKoreaSurnames.add("Han");
		southKoreaSurnames.add("O");
		southKoreaSurnames.add("Shin");
		southKoreaSurnames.add("Seo");
		southKoreaSurnames.add("Kwon");
		southKoreaSurnames.add("Song");

		CountryInContinent southKorea = new CountryInContinent("SouthKorea",
				southKoreaNamesM, southKoreaNamesF, southKoreaSurnames);
		asia.put(southKorea.getCountry(), southKorea);
	}

	private void populateAfrica() {
		africa = new HashMap<String, CountryInContinent>();

		// algeria
		// names male
		algeriaNamesM.add("Mohamed");
		algeriaNamesM.add("Amine");
		algeriaNamesM.add("Karim");
		algeriaNamesM.add("Yacine");
		algeriaNamesM.add("Ahmed");
		algeriaNamesM.add("Mehdi");
		algeriaNamesM.add("Hakim");
		algeriaNamesM.add("Ali");
		// names female
		algeriaNamesF.add("Amina");
		algeriaNamesF.add("Yasmine");
		algeriaNamesF.add("Imene");
		algeriaNamesF.add("Amel");
		algeriaNamesF.add("Meriem");
		algeriaNamesF.add("Amira");
		algeriaNamesF.add("Lina");
		algeriaNamesF.add("Rania");
		// surnames
		algeriaSurnames.add("Ben Bella");
		algeriaSurnames.add("Hecini");
		algeriaSurnames.add("Louahla");
		algeriaSurnames.add("Bourrouag");
		algeriaSurnames.add("Diop");
		algeriaSurnames.add("Klouchi");
		algeriaSurnames.add("Sahnine");
		algeriaSurnames.add("Zidane");

		CountryInContinent algeria = new CountryInContinent("Algeria",
				algeriaNamesM, algeriaNamesF, algeriaSurnames);
		africa.put(algeria.getCountry(), algeria);

		// libya
		// names male
		libyaNamesM.add("Abu");
		libyaNamesM.add("Idris");
		libyaNamesM.add("Minyar");
		libyaNamesM.add("Mu'ammar");
		libyaNamesM.add("Muhammed");
		libyaNamesM.add("Ibn");
		libyaNamesM.add("Ahmed");
		libyaNamesM.add("Muhammad");
		// names female
		libyaNamesF.add("Sameea");
		libyaNamesF.add("Najiyya");
		libyaNamesF.add("Reem");
		libyaNamesF.add("Aleisha");
		libyaNamesF.add("Rania");
		libyaNamesF.add("Aamira");
		libyaNamesF.add("Fatin");
		libyaNamesF.add("Inaya");
		// surnames
		libyaSurnames.add("al-Ajdabi");
		libyaSurnames.add("al-Sanussi");
		libyaSurnames.add("al-Qadhafi");
		libyaSurnames.add("Shennib");
		libyaSurnames.add("al-Bouri");
		libyaSurnames.add("al-Muntasir");
		libyaSurnames.add("al-Talhi");
		libyaSurnames.add("Finiki");

		CountryInContinent libya = new CountryInContinent("Libya", libyaNamesM,
				libyaNamesF, libyaSurnames);
		africa.put(libya.getCountry(), libya);

		// egypt
		// names male
		egyptNamesM.add("Alheib");
		egyptNamesM.add("Gaballah");
		egyptNamesM.add("Boutros");
		egyptNamesM.add("Duridar");
		egyptNamesM.add("Hosni");
		egyptNamesM.add("Roushdy");
		egyptNamesM.add("Omar");
		egyptNamesM.add("Tewfik");
		// names female
		egyptNamesF.add("Halima");
		egyptNamesF.add("Mahasin");
		egyptNamesF.add("Maha");
		egyptNamesF.add("Nadine");
		egyptNamesF.add("Samira");
		egyptNamesF.add("Rasha");
		egyptNamesF.add("Shaheen");
		egyptNamesF.add("Zabeya");
		// surnames
		egyptSurnames.add("Al-Sadat");
		egyptSurnames.add("Fahim");
		egyptSurnames.add("El Sayed");
		egyptSurnames.add("Ghandour");
		egyptSurnames.add("Nabih");
		egyptSurnames.add("Saadauri");
		egyptSurnames.add("Zein");
		egyptSurnames.add("Tantawi");

		CountryInContinent egypt = new CountryInContinent("Egypt", egyptNamesM,
				egyptNamesF, egyptSurnames);
		africa.put(egypt.getCountry(), egypt);

		// mali
		// names male
		maliNamesM.add("Alpha");
		maliNamesM.add("Amadou");
		maliNamesM.add("Modibo");
		maliNamesM.add("Mossa");
		maliNamesM.add("Moussa");
		maliNamesM.add("Oumar");
		maliNamesM.add("Ousmane");
		maliNamesM.add("Toumani");
		// names female
		maliNamesF.add("Aminata");
		maliNamesF.add("Fanta");
		maliNamesF.add("Sara");
		maliNamesF.add("Rokia");
		maliNamesF.add("Sidi");
		maliNamesF.add("Sakura");
		maliNamesF.add("Gao");
		maliNamesF.add("Maghan");
		// surnames
		maliSurnames.add("Deo");
		maliSurnames.add("Diarra");
		maliSurnames.add("Keita");
		maliSurnames.add("Konare");
		maliSurnames.add("Toure");
		maliSurnames.add("Traoré");
		maliSurnames.add("M'Bodji");
		maliSurnames.add("et Mariam");

		CountryInContinent mali = new CountryInContinent("Mali", maliNamesM,
				maliNamesF, maliSurnames);
		africa.put(mali.getCountry(), mali);

		// kenya
		// names male
		kenyaNamesM.add("Ajuma");
		kenyaNamesM.add("Kinara");
		kenyaNamesM.add("Lusala");
		kenyaNamesM.add("Ndila");
		kenyaNamesM.add("Osano");
		kenyaNamesM.add("Wamochia");
		kenyaNamesM.add("Yaw");
		kenyaNamesM.add("Mwangi");
		// names female
		kenyaNamesF.add("Chanya");
		kenyaNamesF.add("Kalititi");
		kenyaNamesF.add("Modiba");
		kenyaNamesF.add("Sundiata");
		kenyaNamesF.add("Lelo");
		kenyaNamesF.add("Guedado");
		kenyaNamesF.add("Jebet");
		kenyaNamesF.add("Meja");
		// surnames
		kenyaSurnames.add("Abol");
		kenyaSurnames.add("Biwott");
		kenyaSurnames.add("Gichonga");
		kenyaSurnames.add("Kariuki");
		kenyaSurnames.add("Lorupe");
		kenyaSurnames.add("Ngotho");
		kenyaSurnames.add("Semenya");
		kenyaSurnames.add("Wekessa");

		CountryInContinent kenya = new CountryInContinent("Kenya", kenyaNamesM,
				kenyaNamesF, kenyaSurnames);
		africa.put(kenya.getCountry(), kenya);

		// angola
		// names male
		angolaNamesM.add("Alioune");
		angolaNamesM.add("Ari");
		angolaNamesM.add("Lucala");
		angolaNamesM.add("Adrien");
		angolaNamesM.add("Helder");
		angolaNamesM.add("Adriano");
		angolaNamesM.add("Nelson");
		angolaNamesM.add("Geraldo");
		// names female
		angolaNamesF.add("Jinga");
		angolaNamesF.add("Kifunji");
		angolaNamesF.add("Moena");
		angolaNamesF.add("Monenga");
		angolaNamesF.add("Mukumdu");
		angolaNamesF.add("Zhinga");
		angolaNamesF.add("Sakura");
		angolaNamesF.add("Zulaika");
		// surnames
		angolaSurnames.add("Beye");
		angolaSurnames.add("Jaga");
		angolaSurnames.add("Kasanje");
		angolaSurnames.add("Mbandi");
		angolaSurnames.add("Savimbi");
		angolaSurnames.add("Braga");
		angolaSurnames.add("Bonga");
		angolaSurnames.add("Flores");

		CountryInContinent angola = new CountryInContinent("Angola",
				angolaNamesM, angolaNamesF, angolaSurnames);
		africa.put(angola.getCountry(), angola);

		// mozambique
		// names male
		mozambiqueNamesM.add("Maputo");
		mozambiqueNamesM.add("Nuagobe");
		mozambiqueNamesM.add("Samora");
		mozambiqueNamesM.add("Yaya");
		mozambiqueNamesM.add("Adney");
		mozambiqueNamesM.add("Faizal");
		mozambiqueNamesM.add("Halid");
		mozambiqueNamesM.add("Ivania");
		// names female
		mozambiqueNamesF.add("Isaia");
		mozambiqueNamesF.add("Leia");
		mozambiqueNamesF.add("Abiba");
		mozambiqueNamesF.add("Faiza");
		mozambiqueNamesF.add("Hallyscha");
		mozambiqueNamesF.add("Jannat");
		mozambiqueNamesF.add("Kayleen");
		mozambiqueNamesF.add("Laurene");
		// surnames
		mozambiqueSurnames.add("Chichuana");
		mozambiqueSurnames.add("Chissano");
		mozambiqueSurnames.add("Machel");
		mozambiqueSurnames.add("Mbazia");
		mozambiqueSurnames.add("Rusere");
		mozambiqueSurnames.add("Sarea");
		mozambiqueSurnames.add("Vashko");
		mozambiqueSurnames.add("Zeca");

		CountryInContinent mozambique = new CountryInContinent("Mozambique",
				mozambiqueNamesM, mozambiqueNamesF, mozambiqueSurnames);
		africa.put(mozambique.getCountry(), mozambique);

		// southAfrica
		// names male
		southAfricaNamesM.add("Anuiyelewa");
		southAfricaNamesM.add("Es'kia");
		southAfricaNamesM.add("Makhaya");
		southAfricaNamesM.add("Mpilo");
		southAfricaNamesM.add("Nyathi");
		southAfricaNamesM.add("Simphiwe");
		southAfricaNamesM.add("Thulani");
		southAfricaNamesM.add("Vusumuzi");
		// names female
		southAfricaNamesF.add("Didi");
		southAfricaNamesF.add("Inah");
		southAfricaNamesF.add("Matlakala");
		southAfricaNamesF.add("Moshidi");
		southAfricaNamesF.add("Mpho");
		southAfricaNamesF.add("Mphonyana");
		southAfricaNamesF.add("Nolitha");
		southAfricaNamesF.add("Nthati");
		// surnames
		southAfricaSurnames.add("Grumede");
		southAfricaSurnames.add("Fazzie");
		southAfricaSurnames.add("Dingake");
		southAfricaSurnames.add("Madi");
		southAfricaSurnames.add("Mahlambeni");
		southAfricaSurnames.add("Ngidi");
		southAfricaSurnames.add("Raptula");
		southAfricaSurnames.add("Tyamzashe");

		CountryInContinent southAfrica = new CountryInContinent("SouthAfrica",
				southAfricaNamesM, southAfricaNamesF, southAfricaSurnames);
		africa.put(southAfrica.getCountry(), southAfrica);
	}

	private void populateSouthAmerica() {
		southAmerica = new HashMap<String, CountryInContinent>();

		// brazil
		// names male
		brazilNamesM.add("Lucas");
		brazilNamesM.add("Gabriel");
		brazilNamesM.add("Matheus");
		brazilNamesM.add("Felipe");
		brazilNamesM.add("Leonardo");
		brazilNamesM.add("Luiz");
		brazilNamesM.add("Vinicius");
		brazilNamesM.add("Rafael");
		// names female
		brazilNamesF.add("Armanda");
		brazilNamesF.add("Julia");
		brazilNamesF.add("Mariana");
		brazilNamesF.add("Gabriela");
		brazilNamesF.add("Fernanda");
		brazilNamesF.add("Ana");
		brazilNamesF.add("Thais");
		brazilNamesF.add("Larissa");
		// surnames
		brazilSurnames.add("Silva");
		brazilSurnames.add("Santos");
		brazilSurnames.add("Souza");
		brazilSurnames.add("Oliveira");
		brazilSurnames.add("Pereira");
		brazilSurnames.add("Lima");
		brazilSurnames.add("Carvalho");
		brazilSurnames.add("Rodrigues");

		CountryInContinent brazil = new CountryInContinent("Brazil",
				brazilNamesM, brazilNamesF, brazilSurnames);
		southAmerica.put(brazil.getCountry(), brazil);

		// argentina
		// names male
		argentinaNamesM.add("Santiago");
		argentinaNamesM.add("Franco");
		argentinaNamesM.add("Nicolás");
		argentinaNamesM.add("Lucas");
		argentinaNamesM.add("Juan");
		argentinaNamesM.add("Matias");
		argentinaNamesM.add("Marcos");
		argentinaNamesM.add("Agustin");
		// names female
		argentinaNamesF.add("Agustina");
		argentinaNamesF.add("Rocio");
		argentinaNamesF.add("Camila");
		argentinaNamesF.add("Romina");
		argentinaNamesF.add("Sofia");
		argentinaNamesF.add("Micaela");
		argentinaNamesF.add("Sara");
		argentinaNamesF.add("Belen");
		// surnames
		argentinaSurnames.add("Fernández");
		argentinaSurnames.add("Rodriguez");
		argentinaSurnames.add("González");
		argentinaSurnames.add("Garcia");
		argentinaSurnames.add("López");
		argentinaSurnames.add("Martinez");
		argentinaSurnames.add("Álvarez");
		argentinaSurnames.add("Diaz");

		CountryInContinent argentina = new CountryInContinent("Argentina",
				argentinaNamesM, argentinaNamesF, argentinaSurnames);
		southAmerica.put(argentina.getCountry(), argentina);

		// uruguay
		// names male
		uruguayNamesM.add("Ignacio");
		uruguayNamesM.add("Maximiliano");
		uruguayNamesM.add("Camilo");
		uruguayNamesM.add("Francisco");
		uruguayNamesM.add("Alejandro");
		uruguayNamesM.add("Lukas");
		uruguayNamesM.add("Bruno");
		uruguayNamesM.add("Favio");
		// names female
		uruguayNamesF.add("Florencia");
		uruguayNamesF.add("Maria José");
		uruguayNamesF.add("Lucia");
		uruguayNamesF.add("Sofia");
		uruguayNamesF.add("Milay");
		uruguayNamesF.add("Daniela");
		uruguayNamesF.add("Regina");
		uruguayNamesF.add("Carolina");
		// surnames
		uruguaySurnames.add("Abana");
		uruguaySurnames.add("Arce");
		uruguaySurnames.add("Capello");
		uruguaySurnames.add("Campos");
		uruguaySurnames.add("Casales");
		uruguaySurnames.add("Espinosa");
		uruguaySurnames.add("Estevez");
		uruguaySurnames.add("Félix");

		CountryInContinent uruguay = new CountryInContinent("Uruguay",
				uruguayNamesM, uruguayNamesF, uruguaySurnames);
		southAmerica.put(uruguay.getCountry(), uruguay);

		// colombia
		// names male
		colombiaNamesM.add("Andres");
		colombiaNamesM.add("Diego");
		colombiaNamesM.add("Juan");
		colombiaNamesM.add("David");
		colombiaNamesM.add("Sebastian");
		colombiaNamesM.add("Camilo");
		colombiaNamesM.add("Cristian");
		colombiaNamesM.add("Jaime");
		// names female
		colombiaNamesF.add("Laura");
		colombiaNamesF.add("Maria");
		colombiaNamesF.add("Angie");
		colombiaNamesF.add("Daniela");
		colombiaNamesF.add("Paula");
		colombiaNamesF.add("Camila");
		colombiaNamesF.add("Lorena");
		colombiaNamesF.add("Diana");
		// surnames
		colombiaSurnames.add("Rodriguez");
		colombiaSurnames.add("Gómez");
		colombiaSurnames.add("González");
		colombiaSurnames.add("Garcia");
		colombiaSurnames.add("Ramirez");
		colombiaSurnames.add("Muñoz");
		colombiaSurnames.add("Rojas");
		colombiaSurnames.add("Moreno");

		CountryInContinent colombia = new CountryInContinent("Colombia",
				colombiaNamesM, colombiaNamesF, colombiaSurnames);
		southAmerica.put(colombia.getCountry(), colombia);

		// venezuela
		// names male
		venezuelaNamesM.add("Luis");
		venezuelaNamesM.add("Jesus");
		venezuelaNamesM.add("Edwin");
		venezuelaNamesM.add("Juan");
		venezuelaNamesM.add("Christian");
		venezuelaNamesM.add("Enyilber");
		venezuelaNamesM.add("Javier");
		venezuelaNamesM.add("Edson");
		// names female
		venezuelaNamesF.add("Noely");
		venezuelaNamesF.add("Andreina");
		venezuelaNamesF.add("Alejandra");
		venezuelaNamesF.add("Genesis");
		venezuelaNamesF.add("Carla");
		venezuelaNamesF.add("Patricia");
		venezuelaNamesF.add("Claudia");
		venezuelaNamesF.add("Tey");
		// surnames
		venezuelaSurnames.add("Ramirez");
		venezuelaSurnames.add("Sanchez");
		venezuelaSurnames.add("Contreras");
		venezuelaSurnames.add("Garcia");
		venezuelaSurnames.add("Salazar");
		venezuelaSurnames.add("Martinez");
		venezuelaSurnames.add("Hernandez");
		venezuelaSurnames.add("Tarinos");

		CountryInContinent venezuela = new CountryInContinent("Venezuela",
				venezuelaNamesM, venezuelaNamesF, venezuelaSurnames);
		southAmerica.put(venezuela.getCountry(), venezuela);

		// peru
		// names male
		peruNamesM.add("Daniel");
		peruNamesM.add("Piero");
		peruNamesM.add("Carlos");
		peruNamesM.add("Juan");
		peruNamesM.add("Jose");
		peruNamesM.add("Jesus");
		peruNamesM.add("Juan Carlos");
		peruNamesM.add("Diego");
		// names female
		peruNamesF.add("Andrea");
		peruNamesF.add("Maria");
		peruNamesF.add("Milagros");
		peruNamesF.add("Karen");
		peruNamesF.add("Sandra");
		peruNamesF.add("Liz");
		peruNamesF.add("Angelica");
		peruNamesF.add("Yessica");
		// surnames
		peruSurnames.add("Quispe");
		peruSurnames.add("Flores");
		peruSurnames.add("Rojas");
		peruSurnames.add("Chávez");
		peruSurnames.add("Torres");
		peruSurnames.add("Mendoza");
		peruSurnames.add("Ramos");
		peruSurnames.add("Castillo");

		CountryInContinent peru = new CountryInContinent("Peru", peruNamesM,
				peruNamesF, peruSurnames);
		southAmerica.put(peru.getCountry(), peru);

		// ecuador
		// names male
		ecuadorNamesM.add("Carlos");
		ecuadorNamesM.add("Daniel");
		ecuadorNamesM.add("Jonathan");
		ecuadorNamesM.add("Erick");
		ecuadorNamesM.add("David");
		ecuadorNamesM.add("Edison");
		ecuadorNamesM.add("Josue");
		ecuadorNamesM.add("Diego");
		// names female
		ecuadorNamesF.add("Daniela");
		ecuadorNamesF.add("Andrea");
		ecuadorNamesF.add("Samantha");
		ecuadorNamesF.add("Gabriela");
		ecuadorNamesF.add("Alexandra");
		ecuadorNamesF.add("Karen");
		ecuadorNamesF.add("Mayta");
		ecuadorNamesF.add("Genesis");
		// surnames
		ecuadorSurnames.add("Ecuador");
		ecuadorSurnames.add("Corsino");
		ecuadorSurnames.add("Memé");
		ecuadorSurnames.add("Yepez");
		ecuadorSurnames.add("Espinoza");
		ecuadorSurnames.add("Estevez");
		ecuadorSurnames.add("Freire");
		ecuadorSurnames.add("Franco Cortéz");

		CountryInContinent ecuador = new CountryInContinent("Ecuador",
				ecuadorNamesM, ecuadorNamesF, ecuadorSurnames);
		southAmerica.put(ecuador.getCountry(), ecuador);
	}

	private void populateNorthAmerica() {
		northAmerica = new HashMap<String, CountryInContinent>();

		// canada
		// names male
		canadaNamesM.add("Liam");
		canadaNamesM.add("Jacob");
		canadaNamesM.add("William");
		canadaNamesM.add("Nathan");
		canadaNamesM.add("Samuel");
		canadaNamesM.add("Olivier");
		canadaNamesM.add("Lucas");
		canadaNamesM.add("Noah");
		// names female
		canadaNamesF.add("Emma");
		canadaNamesF.add("Olivia");
		canadaNamesF.add("Sophia");
		canadaNamesF.add("Zoey");
		canadaNamesF.add("Maya");
		canadaNamesF.add("Emilie");
		canadaNamesF.add("Chloe");
		canadaNamesF.add("Leah");
		// surnames
		canadaSurnames.add("Tremblay");
		canadaSurnames.add("Gagnon");
		canadaSurnames.add("Roy");
		canadaSurnames.add("Cote");
		canadaSurnames.add("Bouchard");
		canadaSurnames.add("Gauthier");
		canadaSurnames.add("Morin");
		canadaSurnames.add("Lavoie");

		CountryInContinent canada = new CountryInContinent("Canada",
				canadaNamesM, canadaNamesF, canadaSurnames);
		northAmerica.put(canada.getCountry(), canada);

		// usa
		// names male
		usaNamesM.add("James");
		usaNamesM.add("John");
		usaNamesM.add("Robert");
		usaNamesM.add("Michael");
		usaNamesM.add("William");
		usaNamesM.add("David");
		usaNamesM.add("Richard");
		usaNamesM.add("Charles");
		// names female
		usaNamesF.add("Mary");
		usaNamesF.add("Patricia");
		usaNamesF.add("Linda");
		usaNamesF.add("Barbara");
		usaNamesF.add("Elizabeth");
		usaNamesF.add("Jennifer");
		usaNamesF.add("Maria");
		usaNamesF.add("Susan");
		// surnames
		usaSurnames.add("Smith");
		usaSurnames.add("Johnson");
		usaSurnames.add("Williams");
		usaSurnames.add("Brown");
		usaSurnames.add("Jones");
		usaSurnames.add("Miller");
		usaSurnames.add("Davis");
		usaSurnames.add("Garcia");

		CountryInContinent usa = new CountryInContinent("Usa", usaNamesM,
				usaNamesF, usaSurnames);
		northAmerica.put(usa.getCountry(), usa);

		// mexico
		// names male
		mexicoNamesM.add("José Luis");
		mexicoNamesM.add("Juan");
		mexicoNamesM.add("Miguel Ángel");
		mexicoNamesM.add("José");
		mexicoNamesM.add("Francisco");
		mexicoNamesM.add("Jesús");
		mexicoNamesM.add("Antonio");
		mexicoNamesM.add("Alejandro");
		// names female
		mexicoNamesF.add("Maria Guadalupe");
		mexicoNamesF.add("Maria");
		mexicoNamesF.add("Juana");
		mexicoNamesF.add("Maria del Carmen");
		mexicoNamesF.add("Margarita");
		mexicoNamesF.add("Verónica");
		mexicoNamesF.add("Alejandra");
		mexicoNamesF.add("Leticia");
		// surnames
		mexicoSurnames.add("Garcia");
		mexicoSurnames.add("Rodriguez");
		mexicoSurnames.add("Martinez");
		mexicoSurnames.add("Hernandez");
		mexicoSurnames.add("Lopez");
		mexicoSurnames.add("Gonzalez");
		mexicoSurnames.add("Perez");
		mexicoSurnames.add("Sanchez");

		CountryInContinent mexico = new CountryInContinent("Mexico",
				mexicoNamesM, mexicoNamesF, mexicoSurnames);
		northAmerica.put(mexico.getCountry(), mexico);

		// guatemala
		// names male
		guatemalaNamesM.add("Carlos");
		guatemalaNamesM.add("Mario");
		guatemalaNamesM.add("Ernesto");
		guatemalaNamesM.add("Daniel Leal");
		guatemalaNamesM.add("Adrian");
		guatemalaNamesM.add("Byron");
		guatemalaNamesM.add("Nelson");
		guatemalaNamesM.add("Eliseo");
		// names female
		guatemalaNamesF.add("Ella");
		guatemalaNamesF.add("Andrea");
		guatemalaNamesF.add("Juliza");
		guatemalaNamesF.add("Mita");
		guatemalaNamesF.add("Nina");
		guatemalaNamesF.add("Corina");
		guatemalaNamesF.add("Ximena");
		guatemalaNamesF.add("Eva");
		// surnames
		guatemalaSurnames.add("Carrillo");
		guatemalaSurnames.add("Sánchez");
		guatemalaSurnames.add("Zacapa");
		guatemalaSurnames.add("Luna");
		guatemalaSurnames.add("Ortiz");
		guatemalaSurnames.add("Figuaroe");
		guatemalaSurnames.add("Vásquez");
		guatemalaSurnames.add("Blanco");

		CountryInContinent guatemala = new CountryInContinent("Guatemala",
				guatemalaNamesM, guatemalaNamesF, guatemalaSurnames);
		northAmerica.put(guatemala.getCountry(), guatemala);
	}

	private void populateEurope() {
		europe = new HashMap<String, CountryInContinent>();

		// portugal
		// names male
		portugalNamesM.add("João");
		portugalNamesM.add("Afonso");
		portugalNamesM.add("Duarte");
		portugalNamesM.add("Nuno");
		portugalNamesM.add("Fábio");
		portugalNamesM.add("André");
		portugalNamesM.add("Hélder");
		portugalNamesM.add("José");
		// names female
		portugalNamesF.add("Joana");
		portugalNamesF.add("Diana");
		portugalNamesF.add("Bárbara");
		portugalNamesF.add("Rita");
		portugalNamesF.add("Ana");
		portugalNamesF.add("Raquel");
		portugalNamesF.add("Maria");
		portugalNamesF.add("Helena");
		// surnames
		portugalSurnames.add("Xistra");
		portugalSurnames.add("Pereira");
		portugalSurnames.add("Duarte");
		portugalSurnames.add("Ferreira");
		portugalSurnames.add("Gomes");
		portugalSurnames.add("Araújo");
		portugalSurnames.add("Gonçalves");
		portugalSurnames.add("Alves");

		CountryInContinent portugal = new CountryInContinent("Portugal",
				portugalNamesM, portugalNamesF, portugalSurnames);
		europe.put(portugal.getCountry(), portugal);

		// spain
		// names male
		spainNamesM.add("Adán");
		spainNamesM.add("Adrián");
		spainNamesM.add("Bakar");
		spainNamesM.add("Bartolomeu");
		spainNamesM.add("Benito");
		spainNamesM.add("Joaquim");
		spainNamesM.add("Didac");
		spainNamesM.add("Diego");
		// names female
		spainNamesF.add("Adela");
		spainNamesF.add("Agata");
		spainNamesF.add("Beatriz");
		spainNamesF.add("Bienvenida");
		spainNamesF.add("Celestina");
		spainNamesF.add("Diana");
		spainNamesF.add("Domitila");
		spainNamesF.add("Ivette");
		// surnames
		spainSurnames.add("Abaloso");
		spainSurnames.add("Macías");
		spainSurnames.add("Martell");
		spainSurnames.add("Márquez");
		spainSurnames.add("Peláez");
		spainSurnames.add("Sanchez");
		spainSurnames.add("Sandoval");
		spainSurnames.add("Villa");

		CountryInContinent spain = new CountryInContinent("Spain", spainNamesM,
				spainNamesF, spainSurnames);
		europe.put(spain.getCountry(), spain);

		// italy
		// names male
		italyNamesM.add("Achille");
		italyNamesM.add("Bertoldo");
		italyNamesM.add("Ciro");
		italyNamesM.add("Donatello");
		italyNamesM.add("Enzo");
		italyNamesM.add("Ferruccio");
		italyNamesM.add("Giambattista");
		italyNamesM.add("Ignazio");
		// names female
		italyNamesF.add("Anastasia");
		italyNamesF.add("Bettina");
		italyNamesF.add("Bianca");
		italyNamesF.add("Claretta");
		italyNamesF.add("Dorotea");
		italyNamesF.add("Ermelinda");
		italyNamesF.add("Fiammetta");
		italyNamesF.add("Giada");
		// surnames
		italySurnames.add("Abangelo");
		italySurnames.add("Bondesan");
		italySurnames.add("Cisternino");
		italySurnames.add("Pirlo");
		italySurnames.add("Donati");
		italySurnames.add("Goretti");
		italySurnames.add("Manfredonia");
		italySurnames.add("Neri");

		CountryInContinent italy = new CountryInContinent("Italy", italyNamesM,
				italyNamesF, italySurnames);
		europe.put(italy.getCountry(), italy);

		// france
		// names male
		franceNamesM.add("Adolphe");
		franceNamesM.add("Aglaé");
		franceNamesM.add("François");
		franceNamesM.add("Gaspard");
		franceNamesM.add("Joachim");
		franceNamesM.add("Loup");
		franceNamesM.add("Marius");
		franceNamesM.add("Odilon");
		// names female
		franceNamesF.add("Adrienne");
		franceNamesF.add("Agnes");
		franceNamesF.add("Apolline");
		franceNamesF.add("Geneviére");
		franceNamesF.add("Héléne");
		franceNamesF.add("Lucette");
		franceNamesF.add("Marine");
		franceNamesF.add("Noelle");
		// surnames
		franceSurnames.add("Beaumont");
		franceSurnames.add("Belrose");
		franceSurnames.add("Deschamps");
		franceSurnames.add("Girard");
		franceSurnames.add("Martel");
		franceSurnames.add("Samson");
		franceSurnames.add("Satre");
		franceSurnames.add("Vipond");

		CountryInContinent france = new CountryInContinent("France",
				franceNamesM, franceNamesF, franceSurnames);
		europe.put(france.getCountry(), france);

		// england
		// names male
		englandNamesM.add("Albert");
		englandNamesM.add("Baldric");
		englandNamesM.add("Braxton");
		englandNamesM.add("Dave");
		englandNamesM.add("Dorian");
		englandNamesM.add("Emmet");
		englandNamesM.add("Gale");
		englandNamesM.add("Greg");
		// names female
		englandNamesF.add("Amy");
		englandNamesF.add("Anne");
		englandNamesF.add("Betty");
		englandNamesF.add("Candice");
		englandNamesF.add("Dayna");
		englandNamesF.add("Haley");
		englandNamesF.add("Jane");
		englandNamesF.add("Jess");
		// surnames
		englandSurnames.add("Abrahams");
		englandSurnames.add("Barlow");
		englandSurnames.add("Bowman");
		englandSurnames.add("Conner");
		englandSurnames.add("Frost");
		englandSurnames.add("Haywood");
		englandSurnames.add("Holmes");
		englandSurnames.add("Merrill");

		CountryInContinent england = new CountryInContinent("England",
				englandNamesM, englandNamesF, englandSurnames);
		europe.put(england.getCountry(), england);

		// germany
		// names male
		germanyNamesM.add("Baldur");
		germanyNamesM.add("Falk");
		germanyNamesM.add("Gert");
		germanyNamesM.add("Gerulf");
		germanyNamesM.add("Isidor");
		germanyNamesM.add("Karl");
		germanyNamesM.add("Leon");
		germanyNamesM.add("Luitger");
		// names female
		germanyNamesF.add("Alena");
		germanyNamesF.add("Brunhild");
		germanyNamesF.add("Cathrin");
		germanyNamesF.add("Franka");
		germanyNamesF.add("Gertrude");
		germanyNamesF.add("Gisa");
		germanyNamesF.add("Henriette");
		germanyNamesF.add("Hilda");
		// surnames
		germanySurnames.add("Ballack");
		germanySurnames.add("Ackermann");
		germanySurnames.add("Bursch");
		germanySurnames.add("Jollenbeck");
		germanySurnames.add("Krantz");
		germanySurnames.add("Messmann");
		germanySurnames.add("Schroeder");
		germanySurnames.add("Sommer");

		CountryInContinent germany = new CountryInContinent("Germany",
				germanyNamesM, germanyNamesF, germanySurnames);
		europe.put(germany.getCountry(), germany);

		// poland
		// names male
		polandNamesM.add("Apolinary");
		polandNamesM.add("Bartek");
		polandNamesM.add("Bronislaw");
		polandNamesM.add("Henryk");
		polandNamesM.add("Leopold");
		polandNamesM.add("Leslaw");
		polandNamesM.add("Milosz");
		polandNamesM.add("Olaf");
		// names female
		polandNamesF.add("Basia");
		polandNamesF.add("Bazyli");
		polandNamesF.add("Emilia");
		polandNamesF.add("Jozefa");
		polandNamesF.add("Jozafat");
		polandNamesF.add("Ludwika");
		polandNamesF.add("Maja");
		polandNamesF.add("Oliwia");
		// surnames
		polandSurnames.add("Bartosz");
		polandSurnames.add("Koziol");
		polandSurnames.add("Marek");
		polandSurnames.add("Miazga");
		polandSurnames.add("Miemec");
		polandSurnames.add("Rudaski");
		polandSurnames.add("Zielinski");
		polandSurnames.add("Zuraw");

		CountryInContinent poland = new CountryInContinent("Poland",
				polandNamesM, polandNamesF, polandSurnames);
		europe.put(poland.getCountry(), poland);

		// sweden
		// names male
		swedenNamesM.add("Anders");
		swedenNamesM.add("Kasper");
		swedenNamesM.add("Enok");
		swedenNamesM.add("Fritjof");
		swedenNamesM.add("Gjord");
		swedenNamesM.add("Greger");
		swedenNamesM.add("Hildegard");
		swedenNamesM.add("Jan");
		// names female
		swedenNamesF.add("Annelie");
		swedenNamesF.add("Dagmar");
		swedenNamesF.add("Elsa");
		swedenNamesF.add("Erika");
		swedenNamesF.add("Frida");
		swedenNamesF.add("Gry");
		swedenNamesF.add("Gudrun");
		swedenNamesF.add("Helga");
		// surnames
		swedenSurnames.add("Abramsson");
		swedenSurnames.add("Einarsson");
		swedenSurnames.add("Eklund");
		swedenSurnames.add("Mardh");
		swedenSurnames.add("Markusson");
		swedenSurnames.add("Pilkvist");
		swedenSurnames.add("Svenson");
		swedenSurnames.add("Westerberg");

		CountryInContinent sweden = new CountryInContinent("Sweden",
				swedenNamesM, swedenNamesF, swedenSurnames);
		europe.put(sweden.getCountry(), sweden);

		// ireland
		// names male
		irelandNamesM.add("Aodh");
		irelandNamesM.add("Braden");
		irelandNamesM.add("Byrne");
		irelandNamesM.add("Finnian");
		irelandNamesM.add("Gilroy");
		irelandNamesM.add("Jannon");
		irelandNamesM.add("Kiernan");
		irelandNamesM.add("Peadar");
		// names female
		irelandNamesF.add("Birgitta");
		irelandNamesF.add("Brita");
		irelandNamesF.add("Finola");
		irelandNamesF.add("Keira");
		irelandNamesF.add("Kelly");
		irelandNamesF.add("Piritta");
		irelandNamesF.add("Sine");
		irelandNamesF.add("Slaine");
		// surnames
		irelandSurnames.add("Beirne");
		irelandSurnames.add("Boyle");
		irelandSurnames.add("Coughlin");
		irelandSurnames.add("Hearn");
		irelandSurnames.add("Mac Alastair");
		irelandSurnames.add("McCrae");
		irelandSurnames.add("Murphy");
		irelandSurnames.add("O'Brien");

		CountryInContinent ireland = new CountryInContinent("Ireland",
				irelandNamesM, irelandNamesF, irelandSurnames);
		europe.put(ireland.getCountry(), ireland);

		// belgium
		// names male
		belgiumNamesM.add("Nicolas");
		belgiumNamesM.add("Dylan");
		belgiumNamesM.add("Jens");
		belgiumNamesM.add("Guillaume");
		belgiumNamesM.add("Quentin");
		belgiumNamesM.add("Hugo");
		belgiumNamesM.add("Axel");
		belgiumNamesM.add("Loic");
		// names female
		belgiumNamesF.add("Lucie");
		belgiumNamesF.add("Ellen");
		belgiumNamesF.add("Céline");
		belgiumNamesF.add("Chloé");
		belgiumNamesF.add("Camille");
		belgiumNamesF.add("Louise");
		belgiumNamesF.add("Marie");
		belgiumNamesF.add("Emma");
		// surnames
		belgiumSurnames.add("Willems");
		belgiumSurnames.add("Jacobs");
		belgiumSurnames.add("Claes");
		belgiumSurnames.add("Wouters");
		belgiumSurnames.add("Vermeulen");
		belgiumSurnames.add("De Clercq");
		belgiumSurnames.add("Desmet");
		belgiumSurnames.add("Van Damme");

		CountryInContinent belgium = new CountryInContinent("Belgium",
				belgiumNamesM, belgiumNamesF, belgiumSurnames);
		europe.put(belgium.getCountry(), belgium);

		// austria
		// names male
		austriaNamesM.add("Lukas");
		austriaNamesM.add("Tobias");
		austriaNamesM.add("Maximilian");
		austriaNamesM.add("Luca");
		austriaNamesM.add("Felix");
		austriaNamesM.add("Alexander");
		austriaNamesM.add("Moritz");
		austriaNamesM.add("Matthias");
		// names female
		austriaNamesF.add("Hannah");
		austriaNamesF.add("Lena");
		austriaNamesF.add("Sarah");
		austriaNamesF.add("Valentina");
		austriaNamesF.add("Katherina");
		austriaNamesF.add("Johanna");
		austriaNamesF.add("Magdalena");
		austriaNamesF.add("Viktoria");
		// surnames
		austriaSurnames.add("Beelek");
		austriaSurnames.add("Kolesar");
		austriaSurnames.add("Manz");
		austriaSurnames.add("Sandmeier");
		austriaSurnames.add("Lewandosky");
		austriaSurnames.add("Schwachofer");
		austriaSurnames.add("Vogl");
		austriaSurnames.add("Weisman");

		CountryInContinent austria = new CountryInContinent("Austria",
				austriaNamesM, austriaNamesF, austriaSurnames);
		europe.put(austria.getCountry(), austria);

		// norway
		// names male
		norwayNamesM.add("Aage");
		norwayNamesM.add("Aleksander");
		norwayNamesM.add("Ragnar");
		norwayNamesM.add("Christen");
		norwayNamesM.add("Christoffer");
		norwayNamesM.add("Gerd");
		norwayNamesM.add("Godtfred");
		norwayNamesM.add("Halvdan");
		// names female
		norwayNamesF.add("Amanda");
		norwayNamesF.add("Anja");
		norwayNamesF.add("Bente");
		norwayNamesF.add("Bergljot");
		norwayNamesF.add("Ea");
		norwayNamesF.add("Grethe");
		norwayNamesF.add("Hege");
		norwayNamesF.add("Heidi");
		// surnames
		norwaySurnames.add("Abramsen");
		norwaySurnames.add("Jakobsen");
		norwaySurnames.add("Knustsen");
		norwaySurnames.add("Lange");
		norwaySurnames.add("Losnedahl");
		norwaySurnames.add("Nielsen");
		norwaySurnames.add("Swenhaugen");
		norwaySurnames.add("Wolff");

		CountryInContinent norway = new CountryInContinent("Norway",
				norwayNamesM, norwayNamesF, norwaySurnames);
		europe.put(norway.getCountry(), norway);

		// finland
		// names male
		finlandNamesM.add("Aatu");
		finlandNamesM.add("Edvard");
		finlandNamesM.add("Eemil");
		finlandNamesM.add("Eerik");
		finlandNamesM.add("Hermanni");
		finlandNamesM.add("Juha");
		finlandNamesM.add("Kari");
		finlandNamesM.add("Maire");
		// names female
		finlandNamesF.add("Aada");
		finlandNamesF.add("Dagmar");
		finlandNamesF.add("Fanni");
		finlandNamesF.add("Evellina");
		finlandNamesF.add("Ilona");
		finlandNamesF.add("Kaarina");
		finlandNamesF.add("Kirsti");
		finlandNamesF.add("Matilda");
		// surnames
		finlandSurnames.add("Harmaajarvi");
		finlandSurnames.add("Jokela");
		finlandSurnames.add("Partnen");
		finlandSurnames.add("Ruoho");
		finlandSurnames.add("Seppa");
		finlandSurnames.add("Toivonen");
		finlandSurnames.add("Virtanen");
		finlandSurnames.add("Wuopio");

		CountryInContinent finland = new CountryInContinent("finland",
				finlandNamesM, finlandNamesF, finlandSurnames);
		europe.put(finland.getCountry(), finland);

		// greece
		// names male
		greeceNamesM.add("Achaikos");
		greeceNamesM.add("Eutropius");
		greeceNamesM.add("Galenos");
		greeceNamesM.add("Heliodoros");
		greeceNamesM.add("Karpos");
		greeceNamesM.add("Kassandros");
		greeceNamesM.add("Meliton");
		greeceNamesM.add("Myrrine");
		// names female
		greeceNamesF.add("Agape");
		greeceNamesF.add("Aspasia");
		greeceNamesF.add("Eunike");
		greeceNamesF.add("Euphrasia");
		greeceNamesF.add("Gaiane");
		greeceNamesF.add("Helena");
		greeceNamesF.add("Kleopatra");
		greeceNamesF.add("Phoibe");
		// surnames
		greeceSurnames.add("Argyris");
		greeceSurnames.add("Demetriou");
		greeceSurnames.add("Giannopoulos");
		greeceSurnames.add("Michelakakis");
		greeceSurnames.add("Pachis");
		greeceSurnames.add("Papadopoulos");
		greeceSurnames.add("Sanna");
		greeceSurnames.add("Zabat");

		CountryInContinent greece = new CountryInContinent("Greece",
				greeceNamesM, greeceNamesF, greeceSurnames);
		europe.put(greece.getCountry(), greece);

		// turkey
		// names male
		turkeyNamesM.add("Abdulhamit");
		turkeyNamesM.add("Burhan");
		turkeyNamesM.add("Erol");
		turkeyNamesM.add("Hursit");
		turkeyNamesM.add("Kagan");
		turkeyNamesM.add("Kasim");
		turkeyNamesM.add("Melik");
		turkeyNamesM.add("Mehmet");
		// names female
		turkeyNamesF.add("Adalet");
		turkeyNamesF.add("Çagatay");
		turkeyNamesF.add("Canan");
		turkeyNamesF.add("Esra");
		turkeyNamesF.add("Gulizar");
		turkeyNamesF.add("Kerem");
		turkeyNamesF.add("Merve");
		turkeyNamesF.add("Mert");
		// surnames
		turkeySurnames.add("Arap");
		turkeySurnames.add("Dermirci");
		turkeySurnames.add("Ekmekçi");
		turkeySurnames.add("Katirci");
		turkeySurnames.add("Macar");
		turkeySurnames.add("Kundakçi");
		turkeySurnames.add("Terzi");
		turkeySurnames.add("Yilmaz");

		CountryInContinent turkey = new CountryInContinent("Turkey",
				turkeyNamesM, turkeyNamesF, turkeySurnames);
		europe.put(turkey.getCountry(), turkey);

	}

	public User getRandomUser(boolean male) {
		User res;
		Random randomno = new Random();
		float probArea = randomno.nextFloat() * 100;
		if (probArea < 100 / 6) {
			res = getUserFromEurope(male);
		} else if (probArea < (100 / 6) * 2) {
			res = getUserFromNorthAmerica(male);
		} else if (probArea < (100 / 6) * 3) {
			res = getUserFromSouthAmerica(male);
		} else if (probArea < (100 / 6) * 4) {
			res = getUserFromAfrica(male);
		} else if (probArea < (100 / 6) * 5) {
			res = getUserFromAsia(male);
		} else {
			res = getUserFromOceanie(male);
		}
		return res;
	}

	public User getUserFromEurope(boolean male) {
		User res = null;
		Random randomno = new Random();
		int countryNumb = Math.abs(randomno.nextInt()
				% numbLocalizationsInEurope);
		int it = 0;
		String countryName = "Portugal";

		for (String cn : europe.keySet()) {
			if (countryNumb == it) {
				countryName = cn;
				break;
			} else {
				it++;
			}
		}

		int nameNumb = Math.abs(randomno.nextInt() % 8);
		int surnameNumb = Math.abs(randomno.nextInt() % 8);
		String name = "";

		CountryInContinent cic = europe.get(countryName);
		if (male) {
			name = cic.getNamesM().get(nameNumb) + " ";

		} else {
			name = cic.getNamesF().get(nameNumb) + " ";
		}

		name = name + cic.getSurnames().get(surnameNumb);

		int yearDif = Math.abs(randomno.nextInt() % 50);
		int year = 2000 - yearDif;
		int month = Math.abs(randomno.nextInt() % 11);
		int day = Math.abs(randomno.nextInt() % 27);

		String email = Utilities.fromNameToEmail(name, this.emailDomain);

		res = new User(email, "pass", name, male ? "male" : "female", "home",
				new GregorianCalendar(year, month, day), false, 0, null, null,
				null);

		return res;
	}

	public User getUserFromNorthAmerica(boolean male) {
		User res = null;
		Random randomno = new Random();
		int countryNumb = Math.abs(randomno.nextInt()
				% numbLocalizationsInNorthAmerica);
		int it = 0;
		String countryName = "Canada";

		for (String cn : northAmerica.keySet()) {
			if (countryNumb == it) {
				countryName = cn;
				break;
			} else {
				it++;
			}
		}

		int nameNumb = Math.abs(randomno.nextInt() % 8);
		int surnameNumb = Math.abs(randomno.nextInt() % 8);
		String name = "";

		CountryInContinent cic = northAmerica.get(countryName);
		if (male) {
			name = cic.getNamesM().get(nameNumb) + " ";

		} else {
			name = cic.getNamesF().get(nameNumb) + " ";
		}

		name = name + cic.getSurnames().get(surnameNumb);

		int yearDif = Math.abs(randomno.nextInt() % 50);
		int year = 2000 - yearDif;
		int month = Math.abs(randomno.nextInt() % 11);
		int day = Math.abs(randomno.nextInt() % 27);

		String email = Utilities.fromNameToEmail(name, this.emailDomain);

		res = new User(email, "pass", name, male ? "male" : "female", "home",
				new GregorianCalendar(year, month, day), false, 0, null, null,
				null);

		return res;
	}

	public User getUserFromSouthAmerica(boolean male) {
		User res = null;
		Random randomno = new Random();
		int countryNumb = Math.abs(randomno.nextInt()
				% numbLocalizationsInSouthAmerica);
		int it = 0;
		String countryName = "Brazil";

		for (String cn : southAmerica.keySet()) {
			if (countryNumb == it) {
				countryName = cn;
				break;
			} else {
				it++;
			}
		}

		int nameNumb = Math.abs(randomno.nextInt() % 8);
		int surnameNumb = Math.abs(randomno.nextInt() % 8);
		String name = "";

		CountryInContinent cic = southAmerica.get(countryName);
		if (male) {
			name = cic.getNamesM().get(nameNumb) + " ";

		} else {
			name = cic.getNamesF().get(nameNumb) + " ";
		}

		name = name + cic.getSurnames().get(surnameNumb);

		int yearDif = Math.abs(randomno.nextInt() % 50);
		int year = 2000 - yearDif;
		int month = Math.abs(randomno.nextInt() % 11);
		int day = Math.abs(randomno.nextInt() % 27);

		String email = Utilities.fromNameToEmail(name, this.emailDomain);

		res = new User(email, "pass", name, male ? "male" : "female", "home",
				new GregorianCalendar(year, month, day), false, 0, null, null,
				null);

		return res;
	}

	public User getUserFromAfrica(boolean male) {
		User res = null;
		Random randomno = new Random();
		int countryNumb = Math.abs(randomno.nextInt()
				% numbLocalizationsInAfrica);
		int it = 0;
		String countryName = "Angola";

		for (String cn : africa.keySet()) {
			if (countryNumb == it) {
				countryName = cn;
				break;
			} else {
				it++;
			}
		}

		int nameNumb = Math.abs(randomno.nextInt() % 8);
		int surnameNumb = Math.abs(randomno.nextInt() % 8);
		String name = "";

		CountryInContinent cic = africa.get(countryName);
		if (male) {
			name = cic.getNamesM().get(nameNumb) + " ";

		} else {
			name = cic.getNamesF().get(nameNumb) + " ";
		}

		name = name + cic.getSurnames().get(surnameNumb);

		int yearDif = Math.abs(randomno.nextInt() % 50);
		int year = 2000 - yearDif;
		int month = Math.abs(randomno.nextInt() % 11);
		int day = Math.abs(randomno.nextInt() % 27);

		String email = Utilities.fromNameToEmail(name, this.emailDomain);

		res = new User(email, "pass", name, male ? "male" : "female", "home",
				new GregorianCalendar(year, month, day), false, 0, null, null,
				null);

		return res;
	}

	public User getUserFromAsia(boolean male) {
		User res = null;
		Random randomno = new Random();
		int countryNumb = Math
				.abs(randomno.nextInt() % numbLocalizationsInAsia);
		int it = 0;
		String countryName = "China";

		for (String cn : asia.keySet()) {
			if (countryNumb == it) {
				countryName = cn;
				break;
			} else {
				it++;
			}
		}

		int nameNumb = Math.abs(randomno.nextInt() % 8);
		int surnameNumb = Math.abs(randomno.nextInt() % 8);
		String name = "";

		CountryInContinent cic = asia.get(countryName);
		if (male) {
			name = cic.getNamesM().get(nameNumb) + " ";

		} else {
			name = cic.getNamesF().get(nameNumb) + " ";
		}

		name = name + cic.getSurnames().get(surnameNumb);

		int yearDif = Math.abs(randomno.nextInt() % 50);
		int year = 2000 - yearDif;
		int month = Math.abs(randomno.nextInt() % 11);
		int day = Math.abs(randomno.nextInt() % 27);

		String email = Utilities.fromNameToEmail(name, this.emailDomain);

		res = new User(email, "pass", name, male ? "male" : "female", "home",
				new GregorianCalendar(year, month, day), false, 0, null, null,
				null);

		return res;
	}

	public User getUserFromOceanie(boolean male) {
		User res = null;
		Random randomno = new Random();
		int countryNumb = Math.abs(randomno.nextInt()
				% numbLocalizationsInOceanie);
		int it = 0;
		String countryName = "Australia";

		for (String cn : oceanie.keySet()) {
			if (countryNumb == it) {
				countryName = cn;
				break;
			} else {
				it++;
			}
		}

		int nameNumb = Math.abs(randomno.nextInt() % 8);
		int surnameNumb = Math.abs(randomno.nextInt() % 8);
		String name = "";

		CountryInContinent cic = oceanie.get(countryName);
		if (male) {
			name = cic.getNamesM().get(nameNumb) + " ";

		} else {
			name = cic.getNamesF().get(nameNumb) + " ";
		}

		name = name + cic.getSurnames().get(surnameNumb);

		int yearDif = Math.abs(randomno.nextInt() % 50);
		int year = 2000 - yearDif;
		int month = Math.abs(randomno.nextInt() % 11);
		int day = Math.abs(randomno.nextInt() % 27);

		String email = Utilities.fromNameToEmail(name, this.emailDomain);

		res = new User(email, "pass", name, male ? "male" : "female", "home",
				new GregorianCalendar(year, month, day), false, 0, null, null,
				null);

		return res;
	}

	public User newUser() {
		User user = null;
		boolean male;

		Random randomno = new Random();
		int toBeMale = Math.abs(randomno.nextInt() % 100) + 1;
		if (toBeMale > 50) {
			male = true;
		} else {
			male = false;
		}

		int continent = Math.abs(randomno.nextInt() % 6) + 1;
		switch (continent) {
		case 1:
			user = getUserFromEurope(male);
			break;
		case 2:
			user = getUserFromNorthAmerica(male);
			break;
		case 3:
			user = getUserFromSouthAmerica(male);
			break;
		case 4:
			user = getUserFromAfrica(male);
			break;
		case 5:
			user = getUserFromAsia(male);
			break;
		case 6:
			user = getUserFromOceanie(male);
			break;
		default:
			break;
		}
		return user;
	}
}

class CountryInContinent {
	String country;
	ArrayList<String> namesM;
	ArrayList<String> namesF;
	ArrayList<String> surnames;

	public CountryInContinent(String country, ArrayList<String> namesM,
			ArrayList<String> namesF, ArrayList<String> surnames) {
		this.country = country;
		this.namesM = namesM;
		this.namesF = namesF;
		this.surnames = surnames;
	}

	public String getRandomName(String gender) {
		Random randomno = new Random();
		int nameHit = Math.abs(randomno.nextInt() % this.namesM.size()) + 1;
		int surnameHit = Math.abs(randomno.nextInt() % this.namesM.size()) + 1;
		if (gender.equals("male")) {
			return this.namesM.get(nameHit) + " "
					+ this.surnames.get(surnameHit);
		} else {
			return this.namesF.get(nameHit) + " "
					+ this.surnames.get(surnameHit);
		}
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public ArrayList<String> getNamesM() {
		return namesM;
	}

	public void setNamesM(ArrayList<String> namesM) {
		this.namesM = namesM;
	}

	public ArrayList<String> getNamesF() {
		return namesF;
	}

	public void setNamesF(ArrayList<String> namesF) {
		this.namesF = namesF;
	}

	public ArrayList<String> getSurnames() {
		return surnames;
	}

	public void setSurnames(ArrayList<String> surnames) {
		this.surnames = surnames;
	}

}

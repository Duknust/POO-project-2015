package base;

import java.util.HashMap;
import java.util.Random;

public final class CountriesData {
	//europe
	public static final final Position portugal = new Position(38.736946, -9.142685);
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
		localizationsInNorthAmerica= new HashMap<String, Position>();
		localizationsInSouthAmerica= new HashMap<String, Position>();
		localizationsInAfrica= new HashMap<String, Position>();
		localizationsInAsia= new HashMap<String, Position>();
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

	public Position getRandomPosition(){
		return null;
	}
	
	public Position getCountryFromEurope(){
		return null;
	}
	
	public Position getCountryFromNorthAmerica(){
		return null;
	}
	
	public Position getCountryFromSouthAmerica(){
		return null;
	}
	
	public Position getCountryFromAfrica(){
		return null;
	}
	
	public Position getCountryFromAsia(){
		return null;
	}
	
	public Position getCountryFromOceania(){
		Position res = null;
		Random randomno = new Random();
		float prob = randomno.nextFloat()*100;
		if prob
	}
}

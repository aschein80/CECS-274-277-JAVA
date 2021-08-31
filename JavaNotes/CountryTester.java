package Demos;

import java.util.ArrayList;
import java.util.Collections;

public class CountryTester {

	public static void main(String[] args) {
		
	//	ArrayList<Country> countries = new ArrayList<Country>();
	//	Country[] countries2 = {new Country(), new Country ("South Korea", 234900), new Country("Albania, 20)}
		
		Country country1 = new Country();
		Country country2;
		Country country3 = null;
		
		country1.setName("USA");
		//country2.setName("Canada");
		//country3.setName("Mexico");
		
		System.out.println(Country.getWorldPop());
		
//		countries.add(new Country("USA", 3000000));
//		
//		countries.add(new Country("NZ", 400));
//		
//		countries.add(new Country("Canada", 4000000));
//		
//		System.out.println(countries);
//		
//		Collections.sort(countries);
//		
//		System.out.println(countries);
		//System.out.println(Arrays.toString(countries2));
		//collections.sort(countries2);
		//System.out.println(Arrays.toString(countries2));
		
	}
}

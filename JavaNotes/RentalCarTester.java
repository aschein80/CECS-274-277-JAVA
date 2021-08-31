package Demos;

public class RentalCarTester {
	   public static void main(String[] args)

	   {

	      System.out.println(check(12));

	      System.out.println("Expected: 7 5");

	      System.out.println(check(13));

	      System.out.println("Expected: 15 10");

	      System.out.println(check(14));

	      System.out.println("Expected: 24 15");

	      System.out.println(check(15));

	      System.out.println("Expected: 33 21");

	   }

	   

	   public static String check(int n)

	   {

	      RentalCar[] cars = new RentalCar[n];

	      for (int i = 0; i < n; i++) 

	      {

	         cars[i] = new RentalCar();

	      }

	      for (int i = 0; i < n; i = i + 2)

	      {

	         cars[i].rentCar();

	      }

	      for (int i = 0; i < n; i = i + 3)

	      {

	         cars[i].rentCar();

	      }

	      for (int i = 0; i < n; i = i + 4)

	      {

	         cars[i].returnCar();

	      }

	      return RentalCar.numAvailable() + " " + RentalCar.numRented();

	   }     

}

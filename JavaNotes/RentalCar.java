package Demos;

public class RentalCar {
	   
	   private boolean rented;

	   private static int available;

	   private static int rents;

	   

	   /**

	      Constructs a rental car.

	   */

	   public RentalCar()

	   { 

	      available ++;
	      this.rented = false;

	   }

	   

	   /**

	      Get number of cars available.

	      @return count of cars that are available

	   */

	   public static int numAvailable() 

	   {

	      return available;

	   }

	   

	   /**

	      Get number of cars rented.

	      @return count of cars that are rented

	   */

	   public static int numRented() 
	   {

	      return rents;
	   }

	   

	   /**

	      Try to rent this car.

	      @return true if the car was successfully rented, false if it was already

	      rented.

	   */

	   public boolean rentCar(){
		   
		   if (rented) {
			   return false;
			   
		   }
		   else {
			   rented = true;
			   rents++;
			   available--;
			   return rented;
		   }
	   }

	   

	   /**

	      Return rented car.
		  @return true if the car was previously rented and is now returned,false if it was not previously rented.
		  */

	   public boolean returnCar()

	   {

	      if(rented) {
	    	  rents--;
	    	  available++;
	    	  return true;
	      }
	      else {
	    	  return false;
	      }

	   }

	}

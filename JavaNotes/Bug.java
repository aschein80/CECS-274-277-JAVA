package demos;

public class Bug {

	//Implement a class Bug that models a bug climbing up a pole. Each time the up method is called, 
	//the bug climbs 10 cm. Whenever it reaches the top of the pole (at 100 cm), it slides back to the 
	//bottom. Provide a method getPosition that returns the current position.  
	//You must document your class using the Javadoc Utility.  Demo before the end of the lab session to 
	//get a code from me.
	
	private String name;
	private int position = 0;
	/**
	 * setting the position to 0
	 */
	
	
	public Bug() {
		name = "N/A";
		/**
		 * constructing a new bug object with default value N/A for name
		 */
		
		
	}
	
	public void up(){
		position += 10;
		if (position == 100) {
			position = 0;
					
		}
		/**
		 * if position == 100, the position is reset 
		 */
		
	}
	public int getPosition(){
		return position;
		
		/*
		 * returning the position of the bug
		 */
		
	}
}

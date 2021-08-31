package Demos;

public class Country implements Comparable

{
	
	private String name;
	private int pop;
	
	/**
	 * This creates a default Country object with name "N/A"
	 * and population 0.
	 */
	public Country() {
		name = "N/A";
		pop = 0;
		
	}
	/**
	 * this creates a Country Object with given name and pop 0
	 * @param newName - a string representing the name of the country
	 */
	public Country(String newName) {
		name = newName;
		pop = 0;
	}
	
	/**
	 * this creates a Country object with given name and initial pop
	 * @param newName - a string representing the name of the country
	 * @param iniPop - initial population
	 */
	public Country(String newName, int iniPop) {
		name = newName;
		pop = iniPop;
		
	}
	
	/**
	 * Sets the name of this object to the given name
	 * @param newName - name of the country
	 */
	public void setName(String newName) {
		this.name = newName;
		this.pop = 0;
		
	}
	
	/**
	 * sets the population of this country
	 * @param newPop - the population as an integer
	 */
	public void setPop(int newPop) {
		pop = newPop;
		
	}
	
	/**
	 * returns the name and population as a string
	 */
	public String toString() {
		return "Name: " + name + "\n" +"\nPopulation: " + pop;
	}
	
	public int compareTo(Object o) {
		Country other = (Country) o; //Typecasting object o from a generic to Country
		//return name.compareTo(other.name);
		if(this.pop > other.pop) //This is case when the current name is "larger" in an alphabetical sense
							//e.g. this = "Mexico" other = "America"
		{
			return 1;
		}
		
		else if (this.pop < other.pop) // this is the case when the current name comes before the other country name
		{
			return -1;
		}
		else {
			return 0;
		}
	}
	
	public static int getWorldPop() {
		return 8000;
		
	}

}

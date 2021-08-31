package demos;

public class BugTester {

	public static void main(String[] args) {
	      Bug bugsy = new Bug();

	      Bug itsyBitsy = new Bug();

	      bugsy.up();
	      bugsy.up();

	      System.out.println(bugsy.getPosition());
	      System.out.println("Expected: 20");

	      itsyBitsy.up();
	      itsyBitsy.up();
	      itsyBitsy.up();

	      System.out.println(itsyBitsy.getPosition());
	      System.out.println("Expected: 30");

	      for (int i = 1; i <= 8; i++) { bugsy.up(); }

	      System.out.println(bugsy.getPosition());
	      System.out.println("Expected: 0");

	      bugsy.up();

	      System.out.println(bugsy.getPosition());
	      System.out.println("Expected: 10");
	}
	
}

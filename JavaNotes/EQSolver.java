package demos;

import java.util.ArrayList;

public class EQSolver {
	
	public static void solve(EQPartialSolutionBoard b) {
		ArrayList <EQPartialSolutionBoard> fullSolutions = new ArrayList <EQPartialSolutionBoard>();
		
		int e = b.examine();
		
		//if e == 1: add b to the list of full solutions
		//otherwise if e != -1 then extend the board b, I.E. get & extensions, and solve each of those & boards
		//recursively
		
		for (EQPartialSolutionBoard s: fullSolutions) {
			
			System.out.println(s);
			
		}
	}

}

package demos;

import java.util.Arrays;

public class EQPartialSolutionBoard {
		
	private Queen[] queens;
		
	public EQPartialSolutionBoard(int numQ) {
		queens = new Queen[numQ];
		}
		
	/**
	* checks whether the board is a full solution, a partial solution, or not a solution.
	* @return - 1 if the board is a solution, 0 if the board is a partial solution,
	* -1 if the board is not a solution
	*/
	public int examine(){
		//CASE 1: Check whether the queens attack each other if they do, return -1
		if ();
			
		//CASE 2: Check the size of queens if it is 8, then return 1 because this is a full solution,
		//otherwise return 0
	}
		
	public EQPartialSolutionBoard[] extend() {
		EQPartialSolutionBoard[] extensions = new EQPartialSolutionBoard[8];
			
		for (int i = 0; i < 8; i++) {
			EQPartialSolutionBoard newBoard = new EQPartialSolutionBoard(queens.length + 1);
			//1.Copy the queens from this board to newBoard
			//2.Add a new queen(where?)
			//3.Add the newBoard to the array
		}
		return extensions;
	}

	public String toString() {
		return Arrays.toString(queens);
	}
	
}

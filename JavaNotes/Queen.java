package demos;

public class Queen {
	
	private int row;
	private int col;
	
	public Queen(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	/**
	 * 
	 * @param other
	 * @return
	 */
	public boolean attacks(Queen other) {
		boolean attacks = false;
		
		
		return attacks;
	}
	
	public String toString() {
		return Integer.toString(row + 1) + "abcdefgh".charAt(col);
	}

}


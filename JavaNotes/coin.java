package Classes;

public class coin {
	private double value;
	
	public coin() {
		this.value = 0;
	}
	
	public coin(double value) {
		this.value = value;
	}
	
	public double getValue() {
		return this.value;
	}
	
	public String toString() {
		return String.format("$%.2f", this.value);
	}
}

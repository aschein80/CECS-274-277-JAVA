package demo;

public class FibonnacciDemo {
	
	public static int fib(int n) {
		//BASE CASES:
		if (n <= 1) {return 1;}
		//Recursive CASE:
		else {
			return fib(n-1) + fib(n-2);
			
		}

}
	public static void main(String[] args) {
		for(int i=0; i <= 43; i++) {
			System.out.println("Fib"  + i+ ": "+ fib(i));
			
		}
	}
	
	
}
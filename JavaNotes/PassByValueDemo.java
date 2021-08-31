package demos;

import java.util.Arrays;

public class PassByValueDemo {
	
	public static void tripleIn(int a) {
		a = a * 3;
		}
	
	public static void doubleIn(int[] a) {
		int[] b = new int[a.length];
		
		
		for (int i =0; i < a.length; i++) {
			b[i] = a[i]*2;	//modification was made
			//to avid edits to the orignal data
			
		}
	}

	public static void main(String[] args) {
		
		int c = 5;
		tripleIn(c);
		//we are expecting 5 because Java is pass by value
		//i.e. the original date is not manipulated, a copy is.
		System.out.println(c);
		
		
		int[] d = {1,2,3,4};
		doubleIn(d);
		System.out.println(Arrays.toString(d));
	}
}

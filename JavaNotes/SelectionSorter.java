package demos;

import java.util.Arrays;

public class SelectionSorter {
	/**
	 * sorts an array of objects in increasing order
	 * using the selection sort algorithm
	 * @param a- an array of Object data 
	 */
	public static void sort(Object[] a) 
	{
		for (int i = 0; i < a.length; i++) {
			int minP = ArrayUtil.minPosition(a, i);  //LOOKING FOR MIN EVEN AT THE CURRENT POSITION
			if (((Comparable) a[minP]).compareTo(a[i])< 0 ) { //if the min at the tail is
				//smaller than what is at the current position, then swap
				ArrayUtil.swap(a,  minP, i);				
			} 
	
		}	
	}

	public static void main(String [] args) {
		
		Object [] a;
		StopWatch s = new StopWatch ();
		
		for(int i = 1; i <= 8; i++) {
			int size =  i * 10000;
			a = ArrayUtil.generateIntArray(size, 2 * size);
			
			s.start();
			sort(a);
			s.stop();
			System.out.println("size = " + size + ":" + s.getMilliSecondsElapsed() + "milisecs");
			s.reset();
			
		}
		
//		Object[] a = {5,4,3, 2, 1};
//		Object [] b = {"z", "y", "u", "a"};
//		System.out.println("Before sort: " + Arrays.toString(a));
//		sort(a);
//		System.out.println("After sort:" + Arrays.toString(a));
//		System.out.println("Before Sort: " + Arrays.toString(b));
//		sort(b);
//		System.out.println("After sort"+ Arrays.toString(b));
	}
}

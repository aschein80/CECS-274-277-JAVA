package demos;

import java.util.Arrays;


public class MergeSorter {
	/**
	 * sorts an array using merge-sort algorithm
	 * @param a - an array of Object data
	 */
	public static void sort(Object[] a) {
		int n = a.length;
		if (n <= 1)//
		{
			return;
			
		}
		else {
			Object[] first = new Object[n/2];
			
			Object[] second = new Object[n- first.length];
			
			//Copy the elements of a
			for (int i = 0; i<first.length; i++) {
				first[i] = a[i];
			}
			
			for (int i = 0; i<second.length; i++) {
				second[i] = a[i+ first.length];
		}
			
		sort(first);
		sort(second);
		merge(first, second, a);
		
	}

}
	/**
	 * merges two given arrays so that the resulting array is in increasing order
	 * @param a - the first array to merge
	 * @param b- the second array to merge
	 * @param c- the resulting merged array (larger)
	 */
	public static void merge(Object[] a, Object[] b, Object[] c) {
		
		int i = 0; //index iterator for array a
		int j = 0; //index iterator for array b
		int k = 0;//index iterator for c
		
		while (i < a.length && j < b.length) {
			
			if(((Comparable) a[i]).compareTo(b[j])<0) {//if the element in the 
				//first half is smaller, then copy it into the array
				c[k] = a[i];
				i++;
			
			}
			else {//otherwise, copy tthe one from the second half
				c[k] = b[j];
				j++;
			}
			k++;
		}
		//We still need to copy any leftovers into the array
		while(i < a.length) 
		{
			c[k] = a[i];
			i++;
			k++;
			
	    }
		
		while (j < b.length)//
		{
			c[k] = b[j];
			j++;
			k++;
		}
		
	}
	
	public static void main(String[] args) {
//		Object[] f = {1,3,4,7,8};
//		Object[] s = {2,5,6,7};
//		Object[] a = new Object[f.length+s.length];
//		
//		merge (f,s,a);
//		System.out.println(Arrays.toString(a));
//		
//		a = ArrayUtil.generateIntArray(10, 15);
//		System.out.println(Arrays.toString(a));
//		sort(a);
//		System.out.println(Arrays.toString(a));
		
		StopWatch s = new StopWatch();
		Object[] a;
		
		for(int i = 0; i <= 8; i++) {
			int size = i * 100;
			a = ArrayUtil.generateIntArray(size, 2*size);
			s.start();
			sort(a);
			s.stop();
			System.out.println("size: " + size +  "\ttime elapsed: " + s.getMilliSecondsElapsed()+ "millisecs");
			s.reset();
		
		}
		
	}
	
	
}

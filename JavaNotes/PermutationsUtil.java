package demo;

import java.util.ArrayList;

public class PermutationsUtil {
	
	public static ArrayList<String> permute(String word){
		
		ArrayList<String> permutations = new ArrayList<String>();
		
		//BASE CASES
		if (word.length() <= 1) {
			permutations.add(word);
			return permutations;
			
		}
		else {
			for (int i =0; i < word.length(); i++) {
				String shorter = word.substring(0, i) + word.substring(i+1);
				
				ArrayList<String> permShorter = permute(shorter); //recursive call
				
				for (String p: permShorter) {
					permutations.add(word.charAt(i) + p); //this is adding to the list of permutations the permutation
					//beginning with letter charAt(i)
				}
				
			}
			return permutations;
		}
		
		}
		public static void main(String[] args){
		ArrayList<String> permutations = permute("eat");
		System.out.println(permutations);
		System.out.println(permutations.size());
	}

}

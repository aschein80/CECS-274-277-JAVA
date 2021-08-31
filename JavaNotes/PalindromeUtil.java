package demo;

public class PalindromeUtil {
	
	public static boolean isPalindrome(String text, int start, int end) {
		
		/**
		 * determines whether a given text is a palindrome
		 * @param text - the text to check 
		 * @return a boolean, if text is a palindrome, false otherwise
		 */
		
		public static boolean isPalindrome(String text) {
			return isPalindrome(text, 0, text.length()-1 ); //not a recursive method
			
		}
		// private recursive helper method: can not be called by the user
	
		private static boolean isPalindrome(String text, int start, int end) {
		//BASE CASES
			int n = next.length();
			if (text.length() <= 1) {return true;}
			else {
				char first = Character.toLowerCase(text.charAt(start);
				char last = Character.toLowerCase(text.charAt(end)); //recursive call
			
			//CASE: Both characters are Letters
			if (first == last        ) {
			return isPalindrome(text.substring(1,  n-1));
		}
		else {
			return false;
		}
	}
		//CASE: First character is not a letter
		else if(!Character.isLetter(first)) {
			return isPalindrome(text, start +1, end -1);
			
		}
	
	
	
	
	
	
	

//	public static boolean isPalindrome(String text) {
//		//Base Cases:
//		if (text.length() <= 1) {return true;}
//		else {
//			char first = Character.toLowerCase(text.charAt(0));
//			char last = Character.toLowerCase(text.charAt(n-1));
//			
//		//CASE: Both characters are Letters
//		if (first == last) {
//			return isPalindrome(text.substring(1,  n-1));
//		}
//		else {
//			return false;
//			
//			
//		}
//		
//		//CASE: First character is not a letter
//		else if (!Character.isLetter(first)) {
//		
//	}
}

package demos;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PatternMatcherDemo {
	
	public static void main(String[] args) {
		
		//GOAL: To match one string to the regex we created
		
		//STEP 1: Create the regex (test it before using it in regex101.com)
		String regex = "([\\w | \\s]+)\\s[.]+\\s([\\d|-]+)";
		
		//STEP 2: Create a Pattern object using the regex 
		Pattern p = Pattern.compile(regex);
		
		//Step 3: Create the String that you wish to match the pattern with
		String str = "Institute for Scientific Analysis ........ 1-800-441-7680";
		
		//STEP 4: Create a Matcher object to match the pattern to your string
		Matcher m = p.matcher(str);
		
		if (m.find()) { //if the matcher finds groups that match the given regex
			System.out.println(m.group(1));
			System.out.println(m.group(2));
		}
	}

}

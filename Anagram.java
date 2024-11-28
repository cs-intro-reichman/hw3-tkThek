import java.util.Arrays;
import java.util.Random;

/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		char[] a = preProcess(str1).toCharArray();
		char[] b = preProcess(str2).toCharArray();

		Arrays.sort(a);
		Arrays.sort(b);

		if (Arrays.equals(a, b)) return true;
		else return false;

	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String strLowerCase = str.toLowerCase();
		String cleanedString = "";
		for (int i = 0; i < str.length(); i++) {
			char c = strLowerCase.charAt(i);
			if (Character.isLetterOrDigit(c)) {
				cleanedString += c;
			}
		}
		return cleanedString;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		char[] characters =  preProcess(str).toCharArray();

		// Create a Random object for generating random indices
		Random random = new Random();

		// Shuffle the array of characters using the Fisher-Yates shuffle algorithm
		for (int i = characters.length - 1; i > 0; i--) {
			// Generate a random index from 0 to i
			int j = random.nextInt(i + 1);

			// Swap characters at index i and j
			char temp = characters[i];
			characters[i] = characters[j];
			characters[j] = temp;
		}

		// Return the shuffled array as a new string
		return new String(characters);
	}
}

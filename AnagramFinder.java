// quick file to unscramble possible words based on given letters and 
// length of possible words - for game WordLink

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;



public class AnagramFinder {

	public static Set<String> generatedWords;
	public static Set<String> dictionary;

	public static void main(String[] args) throws FileNotFoundException {
		// dictionary from https://github.com/dwyl/english-words
		dictionary = getDictionary();
		String[] letters = getLetters();
		// turn this into a set and do a loop to find out the highest value for a max
		Set<Integer> lengths = getLengths();	
		int maxLength = Collections.max(lengths);
		// ArrayList<String> generatedWords = getListOfPossibleWords(letters, lengths, maxLength);
		generatedWords = new HashSet<String>();
		generateListOfWords(letters, lengths, maxLength);
		System.out.println(generatedWords);
	}

	public static Set<String> getDictionary()  {
		Set<String> dictionary = new HashSet<String>();
		try {
			Scanner scanner = new Scanner(new File("words_alpha.txt"));
			while(scanner.hasNext()) {
				dictionary.add(scanner.nextLine().toLowerCase());
			}
		} catch(FileNotFoundException ex) {
			System.out.println("wasn't able to read in dictionary");
		}
		return dictionary;
	}

	public static String[] getLetters() {
		Console console = System.console();
		System.out.print("Enter all letters to be matched: ");
		String input = console.readLine();
		input = input.replaceAll(" ", "");
		return input.split("");
	}

	public static Set<Integer> getLengths() {
		Console console = System.console();
		System.out.print("Enter possible number of letters in word (separated by spaces): ");
		String input = console.readLine();
		String[] inputLengthsStrings = input.split(" ");
		Set<Integer> inputLengths = new HashSet<Integer>();
		// add some error checking here and when reading in intially
		for (int i = 0; i < inputLengthsStrings.length; i++) {
			inputLengths.add(Integer.parseInt(inputLengthsStrings[i]));
		}
		return inputLengths;
	}

	// helper function to set up recursive method of finding possible words
	public static void generateListOfWords(String[] letters, Set<Integer> lengths, int maxLength) {
		for (int i = 0; i < letters.length; i++) {
			generateWords(letters, lengths, maxLength, i, "");
		}
	}

	public static void generateWords(String[] letters, Set<Integer> lengths, int maxLength, int idx, String curWord) {
		// add word to possible words if it is in our english dictionary
		curWord = curWord + letters[idx];
		if (curWord.length() > maxLength) {		// see if we can make word bigger
			return;
		}
		if (lengths.contains(curWord.length()) && dictionary.contains(curWord)) {
			generatedWords.add(curWord);
		} 
		letters = removeLetter(letters, idx);
		for (int i = 0; i < letters.length; i++) {
			generateWords(letters, lengths, maxLength, i, curWord);
		}

	}

	public static String[] removeLetter(String[] letters, int idx) {
		String[] newLetters = new String[letters.length - 1];
		for (int i = 0, j = 0; i < (letters.length - 1); i++, j++) {
			if (j == idx) {
				j++;
			}
			newLetters[i] = letters[j];
		}
		return newLetters;
	}
}











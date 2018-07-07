// quick file to unscramble possible words based on given letters and 
// length of possible words - for game WordLink

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;


public class AnagramFinder {
	public static void main(String[] args) throws FileNotFoundException {
		// dictionary from https://github.com/dwyl/english-words
		Set<String> dictionary = getDictionary();
		String[] letters = getLetters();
		int[] lengths = getLengths();

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

	public static int[] getLengths() {
		Console console = System.console();
		// rewrite directions for this line - confusing
		System.out.print("Enter possible number of letters in word (separated by spaces: ");
		String input = console.readLine();
		String[] inputLengthsStrings = input.split(" ");
		// can change later to lamda expression to change String[] to int[]
		int[] inputLengths = new int[inputLengthsStrings.length];
		// add some error checking here and when reading in intially
		for (int i = 0; i < inputLengthsStrings.length; i++) {
			inputLengths[i] = Integer.parseInt(inputLengthsStrings[i]);
		}
		return inputLengths;
	}
}


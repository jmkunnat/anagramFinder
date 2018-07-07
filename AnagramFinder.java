// quick file to unscramble possible words based on given letters and 
// length of possible words - for game WordLink

import java.io.Console;
import java.util.Arrays;

public class AnagramFinder {
	public static void main(String[] args) {
		// have letters and numbers in command line args
		String[] letters = getLetters();
		int[] lengths = getLengths();
		System.out.println(Arrays.toString(letters));
		System.out.println(Arrays.toString(lengths));
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


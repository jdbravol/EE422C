/* WORD LADDER Main.java
 * EE422C Project 3 submission by
 * Replace <...> with your actual data.
 * <Student1 Name>
 * <Student1 EID>
 * <Student1 5-digit Unique No.>
 * <Student2 Name>
 * <Student2 EID>
 * <Student2 5-digit Unique No.>
 * Slip days used: <0>
 * Git URL:
 * Fall 2016
 */

package assignment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static ArrayList<String> dict = new ArrayList<String>();
	static ArrayList<String> ladder = new ArrayList<String>();
	static ArrayList<Character> alphabet = new ArrayList<Character>();
	static int count;
	static ArrayList<String> words = new ArrayList<String>();
	// static variables and constants only here.

	public static void main(String[] args) throws Exception {

		Scanner kb; // input Scanner for commands
		PrintStream ps; // output file
		// If arguments are specified, read/write from/to files instead of Std
		// IO.
		if (args.length != 0) {
			kb = new Scanner(new File(args[0]));
			ps = new PrintStream(new File(args[1]));
			System.setOut(ps); // redirect output to ps
		} else {
			kb = new Scanner(System.in);// default from Stdin
			ps = System.out; // default to Stdout
		}
		words = parse(kb);
		initialize();
		getWordLadderDFS(words.get(0),words.get(1));
		printLadder(ladder);
		kb.close();

		// TODO methods to read in words, output ladder
	}

	public static void initialize() {
		// initialize your static variables or constants here.
		// We will call this method before running our JUNIT tests. So call it
		// only once at the start of main.
		dict = makeDictionary();
		alphabet.add('a');
		alphabet.add('b');
		alphabet.add('c');
		alphabet.add('d');
		alphabet.add('e');
		alphabet.add('f');
		alphabet.add('g');
		alphabet.add('h');
		alphabet.add('i');
		alphabet.add('j');
		alphabet.add('k');
		alphabet.add('l');
		alphabet.add('m');
		alphabet.add('n');
		alphabet.add('o');
		alphabet.add('p');
		alphabet.add('q');
		alphabet.add('r');
		alphabet.add('s');
		alphabet.add('t');
		alphabet.add('u');
		alphabet.add('v');
		alphabet.add('w');
		alphabet.add('x');
		alphabet.add('y');
		alphabet.add('z');

	}

	/**
	 * @param keyboard
	 *            Scanner connected to System.in
	 * @return ArrayList of 2 Strings containing start word and end word. If
	 *         command is /quit, return empty ArrayList.
	 */
	public static ArrayList<String> parse(Scanner keyboard) {
		ArrayList<String> words = new ArrayList<String>();
		if (keyboard.equals("/quit")) {
			System.exit(0);
		} else {
			words.add(keyboard.next().toLowerCase());
			words.add(keyboard.next().toLowerCase());
		}
		return words;
	}

	public static ArrayList<String> recursionDFS(String start, String end, int index, int aindex) {
		ArrayList<String> newladder = new ArrayList<String>();
		if (end.equals(start)) { // recursive case
			return ladder;
		} else if (aindex != 26) {
			int newindex = aindex + 1;
			int firstlet = alphabet.indexOf(start.charAt(index));
			String newWord = new String();
			StringBuilder newString = new StringBuilder(start);
			newString.setCharAt(index, alphabet.get((firstlet + aindex) % 26));
			newWord = newString.toString();
			if (dict.contains(newWord) && !ladder.contains(newWord)) {
				ladder.add(newWord);
				newladder = recursionDFS(newWord, end, 0, 0);
				if (newladder == null){
					ladder.remove(newWord);
					newladder = recursionDFS(start, end, (index+1)%5, 0);
				}
			} else {
				newladder = recursionDFS(start, end, index, newindex);
				if (newladder == null){
					ladder.remove(newWord);
					newladder = recursionDFS(start, end, (index+1)%5, newindex);
				}
			}
		} else if (index != start.length() - 1) {
			newladder = recursionDFS(start, end, index + 1, 0);
		} else {
			return null;
		}
		return newladder;
	}

	public static ArrayList<String> getWordLadderDFS(String start, String end) {
		ArrayList<String> newladder = new ArrayList<String>();
		if (start.equals(end)) {
			return null; // later
		} else {
			newladder = recursionDFS(start, end, 0, 0);
		}
		// Returned list should be ordered start to end. Include start and end.
		// Return empty list if no ladder.
		// TODO some code

		// TODO more code

		return newladder; // replace this line later with real return
	}

	public static ArrayList<String> getWordLadderBFS(String start, String end) {

		int letterindex;
		int alphabetindex;
		for (letterindex = 0; letterindex<5;letterindex++){
			for(alphabetindex = 0; alphabetindex<26;alphabetindex++){
				
			}
		}

		return null; // replace this line later with real return
	}

	public static ArrayList<String> makeDictionary() {
		ArrayList<String> words = new ArrayList<String>();
		Scanner infile = null;
		try {
			infile = new Scanner(new File("five_letter_words.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Dictionary File not Found!");
			e.printStackTrace();
			System.exit(1);
		}
		while (infile.hasNext()) {
			words.add(infile.next().toLowerCase());
		}
		return words;
	}

	public static void printLadder(ArrayList<String> ladder) {
		System.out.println("a " + count + "-rung word ladder exists between " + words.get(0).toString() + " and "
				+ words.get(1).toString() + ". ");
		for (int i = 0; i < ladder.size(); i++) {
			System.out.println(ladder.get(i).toString());
		}
	}
	// TODO
	// Other private static methods here
}

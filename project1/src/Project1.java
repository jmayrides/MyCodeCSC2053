/**
 * 
 * @author Jack Mayrides
 * 
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Project1 {

	public static void main(String[] args) {

		System.out.println(mostCommonLetters("tom-sawyer.txt"));
		System.out.println();

		System.out.println(mostCommonWords("tom-sawyer.txt"));
		System.out.println();

		System.out.println(mostCommonWordsExcludingStopList("tom-sawyer.txt"));
		System.out.println();

		System.out.println(howManyExlamationsAndQuestions("tom-sawyer.txt"));

	}

	public static String mostCommonLetters(String fileName) {

		//initializing variables
		FileReader fin = null;
		HashMap<Character, Integer> letters = new HashMap<>();

		//adding letters to hashmap and setting values to 0
		for(int i = 97; i <= 122; i++) {

			letters.put(((char)i), 0);

		}

		try {

			//reading in the file
			fin = new FileReader(fileName);

			//saving the file one character at a time
			int curr = 0;

			try {

				curr = fin.read();

				while(curr != -1) {

					//converting upper case letters to lower case
					if(curr >= 65 && curr <= 90)
						curr += 32;

					if(curr >= 97 && curr <= 122) {

						//if the current character is a letter, incrementing value attached to the character in the hashmap
						int temp = letters.get((char)curr);
						letters.put((char)curr, temp + 1);

					}

					curr = fin.read();

				}

				fin.close();

				//looping through the map to find the 10 characters with the highest keys
				HashMap<Character, Integer> maxLetters = new HashMap<>();
				char c = '0';
				int max = 0;

				for (int i = 0; i < 10; i++) {

					max = Collections.max(letters.values());

					for (char element : letters.keySet()) {

						if (letters.get(element) == max) {

							maxLetters.put(element, max);
							c = element;

						}

					}

					letters.remove(c);

				}

				//return statement with results
				return("The most common letters used in this file are: " + maxLetters.entrySet().toString());

			} catch (IOException e) {

				return("Error reading file.");

			}

		} catch (FileNotFoundException e) {

			return("File not found.");

		}

	}

	public static String mostCommonWords(String fileName) {

		//declaring variables
		HashMap<String, Integer> words = new HashMap<>();
		File text = new File(fileName);
		FileReader fin = null;
		String currWord = "";
		int currChar = 0;
		int tempVal = 0;

		try {

			//reading in the file
			fin = new FileReader(text);

			try {

				//adding characters to a temp string holding current word if the current character is a letter
				currChar = fin.read();

				while(currChar != -1) {

					if(currChar >= 65 && currChar <= 90)
						currChar += 32;

					if((currChar < 96 || currChar > 122) && currWord != "") {

						if(words.containsKey(currWord)) {

							tempVal = words.get(currWord);
							words.replace(currWord, tempVal + 1);

						} else {

							words.put(currWord, 1);

						}

						currWord = "";

					}

					if((currChar >= 97 && currChar <= 122) || currChar == 39)
						currWord += Character.toString((char)currChar);

					currChar = fin.read();

				}

				fin.close();

				//looping through the map to find the 10 words with the highest keys
				HashMap<String, Integer> maxWords = new HashMap<>();
				String s = "";
				int max = 0;

				for (int i = 0; i < 10; i++) {

					max = Collections.max(words.values());

					for (String element : words.keySet()) {

						if (words.get(element) == max) {

							maxWords.put(element, max);
							s = element;

						}

					}

					words.replace(s, 0);

				}

				//return statement with results
				return("The most common words used in this file are: " + maxWords.entrySet().toString());

			} catch (IOException e) {

				return("Error reading file.");

			}

		} catch (FileNotFoundException e) {

			return("File not found.");

		}

	}

	public static String mostCommonWordsExcludingStopList(String fileName) {

		//declaring variables
		HashMap<String, Integer> words = new HashMap<>();
		File text = new File(fileName);
		File stopListFile = new File("stop-list.txt");
		FileReader fin = null;
		String currWord = "";
		int currChar = 0;
		int tempVal = 0;


		ArrayList<String> stopList = new ArrayList<>();

		BufferedReader br = null;;
		try {
			br = new BufferedReader(new FileReader(stopListFile));

			try {

				while (br.ready()) {

					stopList.add(br.readLine());

				}

				br.close();

			} catch (IOException e1) {

				return("Error reading file.");

			}

		} catch (FileNotFoundException e1) {

			return("File not found.");

		}

		try {

			//reading in the file
			fin = new FileReader(text);

			try {

				//adding characters to a temp string holding current word if the current character is a letter
				currChar = fin.read();

				while(currChar != -1) {

					if(currChar >= 65 && currChar <= 90)
						currChar += 32;

					if(((currChar < 96 || currChar > 122) && currChar != 39) && currWord != "") {

						if(words.containsKey(currWord)) {

							tempVal = words.get(currWord);
							words.replace(currWord, tempVal + 1);

						} else {

							words.put(currWord, 1);

						}

						currWord = "";

					}

					if((currChar >= 97 && currChar <= 122) || currChar == 39)
						currWord += Character.toString((char)currChar);

					currChar = fin.read();

				}

				fin.close();

				//looping through the map to find the 10 words with the highest keys
				HashMap<String, Integer> maxWords = new HashMap<>();
				String s = "";
				int max = 0;

				//for (int i = 0; i < 10; i++) {

				while(maxWords.size() < 10) {

					max = Collections.max(words.values());

					for (String element : words.keySet()) {

						if (words.get(element) == max) {

							if(stopList.contains(element)) {

								words.replace(element, 0);

							} else {

								maxWords.put(element, max);
								s = element;

							}

						}

					}

					words.replace(s, 0);

				}

				//return statement with results
				return("The most common words used in this file that are not included in the stop list are: " + maxWords.entrySet().toString());

			} catch (IOException e) {

				return("Error reading file.");

			}

		} catch (FileNotFoundException e) {

			return("File not found.");

		}

	}

	public static String howManyExlamationsAndQuestions(String fileName) {

		//initializing variables
		FileReader fin = null;
		HashMap<Character, Integer> eAndQ = new HashMap<>();
		eAndQ.put('!', 0);
		eAndQ.put('?', 0);
		
		try {

			//reading in the file
			fin = new FileReader(fileName);

			//searching the file one character at a time
			int curr = 0;

			try {

				curr = fin.read();

				while(curr != -1) {

					//checking if current character is an exclamation mark or question mark
					if(curr == 33 || curr == 63) {

						//if the current character is one of those, incrementing value attached to the character in the hashmap
						int temp = eAndQ.get((char)curr);
						eAndQ.replace((char)curr, temp + 1);

					}

					curr = fin.read();

				}

				fin.close();

				//return statement with results
				return("The numbers of exclamtion and question marks in this file are: " + eAndQ.entrySet().toString());

			} catch (IOException e) {

				return("Error reading file.");

			}

		} catch (FileNotFoundException e) {

			return("File not found.");

		}

		

	}

}

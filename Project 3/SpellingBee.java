import java.io.*;
import java.util.*;

public class SpellingBee {
	//List to store user input
    static List<String> inputWordList = new ArrayList<>();
	
	//List to store valid words
	static List<String> validWordList = new ArrayList<>();
	
	//Score
	static int score = 0;
		
    public static void main(String[] args) {
		String[] validWords = getWordsFromPath("words.txt");
		
		//Add all validWords array data to class variable list to use in other function
		validWordList.addAll(Arrays.asList(validWords));
		
		//pick first seven letter word for game play
		String shuffledWord = pickSevenLetterWord(validWords);
		System.out.println(shuffledWord);
		gamePlay(shuffledWord);
		
        
    }
	
	/*
	 Main function for the game play logic
	*/
	public static void gamePlay(String shuffledWord) {
		Scanner input = new Scanner(System.in);
		String inputText = input.nextLine();
		if (inputText.equals("mix")){
			mix(shuffledWord);
			return;
		}
		
		if (inputText.equals("ls")) {
			ls(shuffledWord);
			return;
		}
		
		if (inputText.equals("bye")){
			bye();
			//end the game here
			return;
		}
		
	
		if (validWordList.contains(inputText.trim())) {
			boolean isRepeatedWord = false;
			//repeated input check
			if (inputWordList.size() > 0 && inputWordList.contains(inputText.trim())) {
				isRepeatedWord = true;
			}
			
			if (!isRepeatedWord) {
				//increase score by 1 if length is 4
				if (inputText.trim().length() == 4) {
					score = score + 1;
				}
				
				//increase score by the length of word if word consists of more than 4 characters
				if (inputText.trim().length() > 4) {
					score = score + inputText.trim().length();
				}
			}
			
		}
		inputWordList.add(inputText);
		System.out.println("Score: " + score);
		
		// repeat the game until 'bye' is entered
		gamePlay(shuffledWord);
		
	}
	
	/*
	 Function to get all words from words.txt file.
	 Returns array of valid words.
	*/
	public static String[] getWordsFromPath(String filePath) {

        //Store words in Array
        List<String> wordsList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Split each line by commas
                String[] words = line.split(",");

                // Trim spaces and add to the list
                for (String word : words) {
                    wordsList.add(word.trim());
                }
            }
			

        } catch (IOException e) {
            System.out.println("Error reading words.txt: " + e.getMessage());
        }
		
		// Convert list to array
		String[] wordsArray = wordsList.toArray(new String[0]);
		
		return wordsArray;
	}
	
	/*
	 Function to pick first seven letter word from the array of valid words.
	 Returns shuffled seven letter word.
	*/
	public static String pickSevenLetterWord(String [] wordArray) {

        String sevenLetterWord = null;
        for (String word : wordArray) {
            if (word.length() == 7) {
                sevenLetterWord = word;
                break; // stop after the first 7-letter word
            }
        }

        // Shuffle the letters of that word
        String shuffledWord = shuffleWord(sevenLetterWord);
		
        return shuffledWord;
	}
	
	/*
	 Function to shuffle the letters in word in random order.
	 Returns shuffled word.
	*/
	public static String shuffleWord(String word) {
        List<Character> letters = new ArrayList<>();
        for (char c : word.toCharArray()) {
            letters.add(c);
        }
		
		// randomly reorder the letters
        Collections.shuffle(letters); 

        StringBuilder shuffled = new StringBuilder();
        for (char c : letters) {
            shuffled.append(c);
        }

        return shuffled.toString();
    }
	
	/*
	 Function to re-shuffle the given word and repeat the game play.
	*/
	public static void mix(String word) {
		String shuffledWord = shuffleWord(word);
		System.out.println(shuffledWord);
		System.out.println("Score: " + score);
		gamePlay(shuffledWord);
	}
	
	/*
	 Function to list all the input given by the user
	*/
	public static void ls(String shuffledWord){
		String[] inputWordsArray = inputWordList.toArray(new String[0]);
		for (String word : inputWordsArray) {
			System.out.println(word);
		}
		System.out.println("Score: " + score);
		gamePlay(shuffledWord);
	}
	
	/*
	 Function to end the game
	*/
	public static void bye() {
		System.out.println("Thank you for playing!");
	}
	
	
}

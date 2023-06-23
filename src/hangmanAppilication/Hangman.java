package hangmanAppilication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Hangman {
	
	String mysteryWord;
	StringBuilder currentGuess;
	ArrayList<Character> previousGuess = new ArrayList<>();

	int maxTries = 6;
	int currentTry = 0;
	
	ArrayList<String> dictionary = new ArrayList<>();
	private static FileReader reader;
	private static BufferedReader bufferedfileReader;
	
	
	public Hangman() throws IOException{
		initilizeStreams();
		mysteryWord = picWord();
		currentGuess = initilizeCurrentGuess();
	}


	public void initilizeStreams() throws IOException{
		try {
			File infile = new File("C:\\Users\\Navdeep\\OneDrive\\Desktop\\words.txt");
			reader = new FileReader(infile);
			bufferedfileReader = new BufferedReader(reader);
			String currentLine = bufferedfileReader.readLine();
			while(currentLine != null) {
				dictionary.add(currentLine);
				currentLine = bufferedfileReader.readLine();
			}
			bufferedfileReader.close();
			reader.close();
		}
		catch(IOException e){
			System.out.println("Could not find");
		}
	}
	
	public String picWord() {
		Random rand = new Random();
		int wordIndex = Math.abs(rand.nextInt()) % dictionary.size();
		return dictionary.get(wordIndex);
	}
	
	public StringBuilder initilizeCurrentGuess() {
		StringBuilder current = new StringBuilder();
		for(int i=0;i<mysteryWord.length()*2;i++) {
			if(i%2==0) {
				current.append("_");
			}
			else {
				current.append(" ");
			}
		}
		return current;
	} 
	
	public String getFormalCurrentGuess() {
		return "Current Guess: "+ currentGuess.toString();
	}
	
	public boolean gameOver() {
		if(weWin()) {
			System.out.println("Congrats....you guess right words");
			return true;
		}else if(weLose()) {
			System.out.println("Sorry you lost.............you use all your tries");
			return true;
		}
		return false;
	}
	
	public boolean weWin() {
		String guess = getcCondensedCurrentGuess();
		return guess.equals(mysteryWord);
	}
	public boolean weLose() {
		return currentTry>= maxTries;
	}
	
	public String getcCondensedCurrentGuess() {
		String guess = currentGuess.toString();
		return guess.replace(" ", "");
	}
	
	public boolean isGuessAlerady(char guess) {
		return previousGuess.contains(guess);
	}
	
	public boolean playGuess(char guess) {
		boolean isItAGoodGuess = false;
		for(int i=0;i<mysteryWord.length();i++) {
			if(mysteryWord.charAt(i)== guess) {
				currentGuess.setCharAt(i* 2, guess);
				isItAGoodGuess = true;
				previousGuess.add(guess);
			}
		}
		if(!isItAGoodGuess) {
			currentTry++;
		}return isItAGoodGuess;
	}
	
	public String drawPicture() {
		switch(currentTry) {
			case 0: return noPersonDraw();
			case 1: return addHeadDraw();
			case 2: return addBodyDraw();
			case 3: return addArmDraw();
			case 4: return addSecondDraw();
			case 5 : return addFirstLegDraw();
			default : return fullPersonDraw();
		}
	}

	private String noPersonDraw() {
		// TODO Auto-generated method stub
		return  " - - - - -\n"+
				"|        |\n"+
				"|        \n" +
				"|         \n"+
				"|        \n" +
				"|        \n" +
				"|\n" +
				"|\n";
	}
	
	private String addHeadDraw() {
		// TODO Auto-generated method stub
		return  " - - - - -\n"+
				"|        |\n"+
				"|        O\n" +
				"|      	 \n"+
				"|       	 \n" +
				"|      	  \n" +
				"|\n" +
				"|\n";
	}


	private String addBodyDraw() {
		// TODO Auto-generated method stub
		return  " - - - - -\n"+
				"|        |\n"+
				"|        O\n" +
				"|        |  \n"+
				"|        \n" +
				"|         \n" +
				"|\n" +
				"|\n";
	}


	private String addArmDraw() {
		// TODO Auto-generated method stub
		return" - - - - -\n"+
				"|        |\n"+
				"|        O\n" +
				"|      / |  \n"+
				"|        \n" +
				"|       \n" +
				"|\n" +
				"|\n";
	}


	private String addSecondDraw() {
		// TODO Auto-generated method stub
		return  " - - - - -\n"+
				"|        |\n"+
				"|        O\n" +
				"|      / | \\ \n"+
				"|        \n" +
				"|       \n" +
				"|\n" +
				"|\n";
	}
	
	private String addFirstLegDraw() {
		return " - - - - -\n"+
				"|        |\n"+
				"|        O\n" +
				"|      / | \\ \n"+
				"|        |\n" +
				"|       /  \n" +
				"|\n" +
				"|\n";
	}

	private String fullPersonDraw() {
		// TODO Auto-generated method stub
		return	" - - - - -\n"+
				"|        |\n"+
				"|        O\n" +
				"|      / | \\ \n"+
				"|        |\n" +
				"|       / \\ \n" +
				"|\n" +
				"|\n";
	}





	
	
	
	
}

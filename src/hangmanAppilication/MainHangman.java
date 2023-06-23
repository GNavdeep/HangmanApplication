package hangmanAppilication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainHangman {

	public static void main(String[] args) throws IOException {
	
		// HANGMAN APPLICATION
		Scanner sc = new Scanner(System.in);
		
		//HOW IT WORKS    
		System.out.println();
		System.out.println("The Hangman Game.........HOW IT WORKS!");
		System.out.println();
		System.out.println("Guess the given word before the character is completed. \nif the stick man is complete"
				+ " before you complete the words you loose."
				+ "if you guees the word wrong the character is gonna add to hangmam."
				+ "if you guessed the words right before the stickman is complete you win.");
		
	/*	" - - - - -\n"+
		"|        |\n"+
		"|        O\n" +
		"|      / | \\ \n"+
		"|        |\n" +
		"|       / \\ \n" +
		"|\n" +
		"|\n";  */
			
			
		// Do you want to play
			boolean doYouWantPlay = true;
			while (doYouWantPlay) {
			System.out.println("Lets play");
			System.out.println("Hi");
			Hangman game = new Hangman();
			System.out.println("Hi");
		//	System.out.println(game.drawPicture());
			//System.out.println("Hi");
			do{
				System.out.println();
				System.out.println(game.drawPicture());
				System.out.println();
				System.out.println(game.getFormalCurrentGuess());
				System.out.println(game.mysteryWord);
				System.out.println();
				System.out.println("Enter a character");
				char guess = (sc.next().toLowerCase()).charAt(0);
				System.out.println();
				
				while(game.isGuessAlerady(guess)) {
					System.out.println("Try again, you already gueesed!");
					guess = (sc.next().toLowerCase()).charAt(0);
				}
				
				if(game.playGuess(guess)) {
					System.out.println("its a good guess");
				}else {
					System.out.println("its a bad guess");
				}
			}
		   //Allow multiple games
	
				
				
				while(!game.gameOver()) ;
				
				System.out.println();
				System.out.println("do you want to play another game. enter Y to start");
				Character response = (sc.next().toUpperCase()).charAt(0);
				doYouWantPlay = (response == 'Y');
				
			}
			
		//setting up the game
			
		//playing the game
			
			
		// play again or not
		
	}
}

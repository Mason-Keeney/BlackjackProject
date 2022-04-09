package com.skilldistillery.blackjack;

import java.util.Scanner;

import com.skilldistillery.blackjack.abstractclasses.Contestant;
import com.skilldistillery.blackjack.abstractclasses.Player;
import com.skilldistillery.blackjack.entities.BlackjackDealer;
import com.skilldistillery.blackjack.entities.BlackjackPlayer;
import com.skilldistillery.blackjack.entities.BlackjackTable;

public class BlackjackApp {
	private boolean isRunning = true;
	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
		while(app.isRunning) {
			app.run();
			
		}
	}

	public void run() {
		BlackjackTable table = new BlackjackTable();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Would you like to play Blackjack?");
		boolean isPlaying = continuePlay(sc.nextLine(), sc);
		
		if(isPlaying) {
			System.out.println("What is your name?");
			BlackjackPlayer temp = (BlackjackPlayer)table.getContestants().get(0);
			table.setPlayer(sc.nextLine(), temp);
			table.setUpGame();
			System.out.println(temp.getHand());
		} else {
			isRunning = false;
		}
		while(isPlaying) {
			while(!table.hasWinner()) {
				
				int selection;
			for (Contestant contestant : table.getContestants()) {
				if (contestant instanceof Player) {
					table.printTurnMenu();
					selection = table.turnSwitch(sc.nextLine(), sc);
					table.turn(selection, contestant);
					BlackjackPlayer temp = (BlackjackPlayer)contestant;
					System.out.println(((BlackjackPlayer)contestant).getName()+ " " + temp.getHand());
					if (table.hasWinner()) {
						continue;
					}
				} else {
					selection = table.dealerSwitch();
					table.turn(selection, contestant);
					BlackjackDealer tempDealer = (BlackjackDealer)contestant;
					System.out.println("Dealer " + tempDealer.cardsShowing());
					if (table.hasWinner()) {
						continue;
					}
				}
			}
			}
			isPlaying = false;
			
		}
		
		
	}

	public boolean continuePlay(String input, Scanner sc) {
		String inputLowCase;
		boolean isSelecting = true;
		while (isSelecting) {
			inputLowCase = input.toLowerCase();
			switch (inputLowCase) {
			case "y":
			case "yes":
			case "yeah":
			case "play":
			case "play on":
				return true;
			case "n":
			case "no":
			case "finished":
			case "quit":
			case "exit":
				return false;
			default:
				System.out.println("Please enter a valid option: ");
				input = sc.nextLine();
				continue;
			
			}
		}
		return false;
	}



	public void setUp(Scanner sc) {
		

	}

}

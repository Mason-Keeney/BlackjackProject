package com.skilldistillery.blackjack.entities;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.blackjack.abstractclasses.Contestant;
import com.skilldistillery.blackjack.abstractclasses.Dealer;
import com.skilldistillery.blackjack.abstractclasses.Player;
import com.skilldistillery.blackjack.abstractclasses.Table;

public class BlackjackTable extends Table {

	public BlackjackTable() {
		dealer = new BlackjackDealer();
		players = new LinkedList<>();
		Player you = new BlackjackPlayer("You");
		players.add((Contestant) you);
		players.add((Contestant) dealer);
		hasWinner = false;
	}

	public Contestant assessStayWinner() {
		Contestant winner = null;
		int winningValue = 0;
		
		for (Contestant player : players) {
			if (player.getHandValue() > winningValue) {
				winningValue = player.getHandValue();
				winner = player;
			}
		}
		
		hasWinner = true;
		return winner;
	}
	
	public boolean hasWinner() {
		return hasWinner;
	}
	
	public List<Contestant> getContestants(){
		return players;
	}

	public void setPlayer(String name, Player player) {
		player.setName(name);
	}


	

	public void playerWins(Contestant contestant) {

		if (contestant instanceof Player) {
			System.out.println(((Player) contestant).getName() + " Wins!");
			System.out.println(((Player) contestant).getHand());
			hasWinner = true;
		} else {
			System.out.println("The house wins.");
			System.out.println("Dealer won with: " + ((BlackjackDealer)contestant).getHand());
			hasWinner = true;
		}
		
	}

	private void playerBusts(Contestant contestant) {
		System.out.println("Bust!");
		players.remove(contestant);
		Contestant winner = assessBoard();
		if (winner != null) {
			playerWins(winner);
		}
	}

	private Contestant assessBoard() {
		Contestant player = null;
		if (players.size() == 1) {
			player = players.get(0);
		}
		return player;

	}

	public boolean allContestantsHold() {
		for (Contestant contestant : players) {
			if (!contestant.isHolding()) {
				return false;
			}
		}
		return true;
	}

	public boolean turn(int selection, Contestant contestant) {
		switch (selection) {
		case 1:
			((BlackjackDealer) dealer).dealCard(contestant);
			
			boolean wins = contestant.hasWinningHand();
			if (wins) {
				playerWins(contestant);
			}
			
			boolean busts = contestant.hasLosingHand();
			if(busts) {
				playerBusts(contestant);
			}
			break;
			
		case 2:
			if (contestant instanceof Player) {
				((BlackjackPlayer) contestant).setHolding(true);
			}
			if (contestant instanceof Dealer) {
				if (allContestantsHold()) {
					Contestant winner = assessStayWinner();
					if (winner != null) {
						playerWins(winner);
					}
				}
			}
			break;
		case 3:
			players.remove(contestant);
			Contestant winner = assessBoard();
			if (winner != null) {
				playerWins(winner);
			}
			break;
		
		}

		return hasWinner;
	}

	public int turnSwitch(String input, Scanner sc) {
		boolean isSelecting = true;
		while (isSelecting) {
			switch (input) {
			case "1":
			case "hit":
				return 1;
				
			case "2":
			case "stay":
			case "hold":
				return 2;
				
			case "3":
			case "quit":
			case "surrender":
				return 3;

			default:
				System.out.println("Please enter a valid number: ");
				input = sc.nextLine();
				continue;
			}
		}

		return 0;
	}
	
	public int dealerSwitch() {
		if (((BlackjackDealer)dealer).isHolding()) {
			return 2;
		}
		return 1;
	}
	
	public void printTurnMenu() {
		System.out.println("Please choose an option:");
		System.out.println("1: Hit Me!");
		System.out.println("2: Stay");
		System.out.println("3: Surrender");
	}
	
	public void setUpGame() {
		for(Contestant contestant : players) {
			((BlackjackDealer)dealer).dealHand(contestant);
		}
		for(Contestant contestant : players) {
			boolean wins = contestant.hasWinningHand();
			if(wins) {
				playerWins(contestant);
			}
		}
	}

}

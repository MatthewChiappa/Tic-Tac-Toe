import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

public class Game implements ActionListener {
	
	private int[] board = new int[9];
	static Game newGame = new Game();
	private int turnCount = 0;
	private int count = 9;
	
	private JFrame window = new JFrame("Tic-Tac-Toe");
	private JButton[] buttons = new JButton[9];
	
	public Game() {
		
		window.setSize(300,300);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new GridLayout(3,3));

		for(int i = 0; i < buttons.length; i++){
			buttons[i] = new JButton("");
			buttons[i].setFont(new Font("Arial", Font.BOLD, 40));
			window.add(buttons[i]);
			buttons[i].addActionListener(this);
		}

		window.setVisible(true);
		
	}

	public static void main(String[] args) {
		
		new Game();
		newGame.startTheGame();

	}
	
	public void startTheGame() {
		
		Random rand = new Random();
		int randNum = rand.nextInt(2);
		if(randNum == 1) {
			JOptionPane.showMessageDialog(window, "Welcome to Tic-Tac-Toe\nYou will make the first move");
			turnCount = 0;
		}
		else {
			JOptionPane.showMessageDialog(window, "Welcome to Tic-Tac-Toe\nThe Computer will make the first move");
			turnCount = 1;
			computerTurn();
		}
		
	}
	
	public void newGame(){
		
		board = new int[9];
		for(int i = 0; i < buttons.length; i++) {
			buttons[i].setText("");
		}
		turnCount = 0;
		count = 9;
		newGame.startTheGame();
	}
	
	public boolean checkForWin() {
		
		int zeroCount = 0;
		
		if (board[0] == 1 && board[1] == 1 && board[2] == 1 ||
				board[3] == 1 && board[4] == 1 && board[5] == 1 ||
					board[6] == 1 && board[7] == 1 && board[8] == 1){
			JOptionPane.showMessageDialog(window, "You have won the game!!");
			return true;
		}
		else if (board[0] == 1 && board[3] == 1 && board[6] == 1 ||
					board[1] == 1 && board[4] == 1 && board[7] == 1 ||
						board[2] == 1 && board[5] == 1 && board[8] == 1){
			JOptionPane.showMessageDialog(window, "You have won the game!!");
			return true;
		}
		else if(board[0] == 1 && board[4] == 1 && board[8] == 1 ||
					board[2] == 1 && board[4] == 1 && board[6] == 1){
			JOptionPane.showMessageDialog(window, "You have won the game!!");
			return true;
		}
		
		if (board[0] == 2 && board[1] == 2 && board[2] == 2 ||
				board[3] == 2 && board[4] == 2 && board[5] == 2 ||
					board[6] == 2 && board[7] == 2 && board[8] == 2){
			JOptionPane.showMessageDialog(window, "Sorry, you have lost the game.");
			return true;
		}
		else if (board[0] == 2 && board[3] == 2 && board[6] == 2 ||
					board[1] == 2 && board[4] == 2 && board[5] == 2 ||
						board[2] == 2 && board[5] == 2 && board[8] == 2){
			JOptionPane.showMessageDialog(window, "Sorry, you have lost the game.");
			return true;
		}
		else if(board[0] == 2 && board[4] == 2 && board[8] == 2 ||
					board[2] == 2 && board[4] == 2 && board[6] == 2){
			JOptionPane.showMessageDialog(window, "Sorry, you have lost the game.");
			return true;
		}
		
		for (int i = 0; i < board.length; i++) {
			if (board[i] == 0)
				zeroCount++;
		}
		
		if (zeroCount == 0){
			JOptionPane.showMessageDialog(window, "The game has ended in a tie.");
			return true;
		}
		
		return false;
		
	}
	
	public void computerTurn() {
		
		Random rand = new Random();
		int randNum = rand.nextInt(count);
		if (randNum == board.length+1)
			randNum = 0;
		while (board[randNum] != 0)
			randNum = rand.nextInt(8);
		buttons[randNum].setForeground(Color.red);
		buttons[randNum].setText("O");
		board[randNum] = 2;
		count--;
		
		turnCount++;
		if(checkForWin())
			newGame();
		
	}

	public void actionPerformed(ActionEvent a) {
		
		if(isPlayerTurn()) {
			for(int i = 0; i < buttons.length; i++) {
				if(a.getSource() == buttons[i]) {
					if (board[i] != 1)
						turnCount++;
					buttons[i].setForeground(Color.blue);
					buttons[i].setText("X");
					board[i] = 1;
				}
			}
		}
		if(!checkForWin())
			computerTurn();
		else
			newGame();
		
	}
	
	public boolean isPlayerTurn(){
		if(turnCount % 2 == 0)
			return true;
		else
			return false;
	}
	
}

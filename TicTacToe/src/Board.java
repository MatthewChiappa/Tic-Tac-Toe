import java.util.*;

public class Board extends Game {

	int[][] board = new int[3][3];
	
	public Board() {
		for(int i = 0; i < 3; i++) {
			for(int n = 0; n < 3; n++){
				board[i][n] = 0;
			}
		}
	}
	
	public void displayBoard(){
		for(int i = 0; i < 3; i++) {
			for(int n = 0; n < 3; n++){
				board[i][n] = 0;
				if(board[i][n] == 0)
					System.out.printf(" ");
				else
					//System.out.printf("%c", move);
				System.out.printf("|");
			}
			System.out.println();
		}
	}
	
}

import java.io.*;
class Main  {
  public static void main(String args[]) throws IOException {

	  // prints board
	  Checkers game = new Checkers();
	  game.printBoard();
	
	  // Loop until game is over
  	while (!game.gameOver()) {
	     //Execute a move and print the board out afterwards.
	     game.getNextMove();
	      game.printBoard();
	  }
	  // winner
  	System.out.println("The winner is " + game.winnerIs());
    }
}

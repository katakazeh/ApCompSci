import java.io.*;
import java.util.*;

public class Checkers {

    private final static int SIZE = 8;
    private char[][] board; // Board
    private int redcheckers; // Number of red checkers on the board
    private int blackcheckers; // Number of black checkers on the board
    private char playermove; // player's turn


    public Checkers() {
	
	board = new char[SIZE][SIZE];
	redcheckers = 12;
	blackcheckers = 12;
	playermove = 'r';

	// putting pieces in original position

	int i,j;
	for (i=0;i<SIZE;i++)
	    for (j=0;j<SIZE;j++)
		board[i][j] = '_';

	for (i=1;i<SIZE;i+=2) {
	    board[i][1] = 'r';
	    board[i][5] = 'b';
	    board[i][7] = 'b';
	}
	for (i=0;i<SIZE;i+=2) {
	    board[i][0] = 'r';
	    board[i][2] = 'r';
	    board[i][6] = 'b';
	}
    }

   //checkerboard
    public void printBoard() {
	int i,j;
	System.out.println("  1 2 3 4 5 6 7 8 x");
	for (i=0;i<SIZE;i++) {
	    System.out.print((i+1) + " ");
	    for (j=0;j<SIZE;j++) {
		System.out.print(board[j][i] + " ");
	    }
	    System.out.println();
	}
	System.out.println("y");
    }

    // Move
    public void getNextMove() throws IOException {
	
	Scanner stdin = new Scanner(System.in);

	if (playermove=='r')
	    System.out.println("It is your turn, red.");
	else
	    System.out.println("It is your turn, black.");

	boolean moved = false;
	while (!moved) {
	    // Move from and where to
	    System.out.println("Enter from the square you would like to move from.");
	    System.out.print("Enter 2 digit number to show were you would like to move");
	    int movefrom = stdin.nextInt();

	    System.out.print("Enter from the square you would like to move to, ");
	    System.out.println("using the same convention.");
	    int moveto = stdin.nextInt();

	    // Checks to see if move is valid
	    if (validMove(movefrom,moveto)) {
		executeMove(movefrom,moveto);
		moved = true;
	    }
	    else
		System.out.println("That was an invalid move, try again.");
	}

	// Update whose move it is.
	if (playermove == 'r')
	    playermove = 'b';
	else
	    playermove = 'r';
    }

    // Checks if a move is valid.
    public boolean validMove(int movefrom, int moveto) {

	// Gets array spots corresponding to move
	int xfrom = movefrom/10 - 1;
	int yfrom = movefrom%10 - 1;
	int xto = moveto/10 - 1;
	int yto = moveto%10 - 1;
	
	// check if in range
	if (xfrom < 0 || xfrom > 7 || yfrom < 0 || yfrom > 7 ||
	    xto < 0 || xto > 7 || yto < 0 || yto > 7) 
	    return false;

	// Check to see if you are moving your piece to a blank square.
	else if (board[xfrom][yfrom]==playermove && board[xto][yto]=='_') {

	    // Checks case of simple move
	    if (Math.abs(xfrom-xto)==1) {
		if ((playermove == 'r') && (yto - yfrom == 1))
		    return true;
		else if ((playermove == 'b') && (yto - yfrom == -1))
		    return true;
	    }
	    
	    // jumps
	    else if (Math.abs(xfrom-xto)==2) {
		if (playermove == 'r' && (yto - yfrom == 2) && 
		    board[(xfrom+xto)/2][(yfrom+yto)/2] == 'b')
		    return true;
		else if (playermove == 'b' && (yto - yfrom == -2) && 
		    board[(xfrom+xto)/2][(yfrom+yto)/2] == 'r')
		    return true;
	    }
	}
	// illegal move with jumps
	return false;
    }

    // Executes a move.
    public void executeMove(int movefrom, int moveto) {
	// Gets array spots corresponding to move
	int xfrom = movefrom/10 - 1;
	int yfrom = movefrom%10 - 1;
	int xto = moveto/10 - 1;
	int yto = moveto%10 - 1;
	

	board[xfrom][yfrom] = '_';
	board[xto][yto] = playermove;
	if (Math.abs(xto - xfrom) == 2) {
	    board[(xfrom+xto)/2][(yfrom+yto)/2] = '_';
	    if (playermove == 'r')
		redcheckers--;
	    else
		blackcheckers--;
	}

    }

    // Checks to see if game is over
    public boolean gameOver() {
	return (redcheckers == 0 || blackcheckers == 0);
    }

    // Returns color of the winner.
    public String winnerIs() {
	if (blackcheckers == 0)
	    return "red";
	else
	    return "black";
    }
}

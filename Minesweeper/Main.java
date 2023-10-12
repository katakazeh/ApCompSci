import java.util.Scanner;
class Main {
  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = 30;
        int columns = 16;
        int mines = 99;

        System.out.println("");
        MinesweeperGame game = new MinesweeperGame(rows, columns, mines); // Starts board
        System.out.println("");
          System.out.println("");
          System.out.println("Please enter row then column (Index based)");
          int inputRow = sc.nextInt();
          int inputColumn = sc.nextInt();
          int y = game.playerInteract(inputRow, inputColumn); // User input to select square
          if (y == 2) { // Tells you whether you hit, win, or miss
              System.out.println("");
              System.out.println("You have hit a mine!");
              System.out.println("");
              game.getBoard();
              System.exit(0); // Exits after the game is complete
          }
          if (y == 1) {
              System.out.println("");
              System.out.println("You won!");
              System.out.println("");
               game.getBoard();
               System.exit(0); // Exits after the game is complete
          }
          if (y == 0) {
              System.out.println("");
              System.out.println("Next board");
               System.out.println("");
               game.getVisibleBoard(); // Continues if the game has not been completed. 
           }
       }
   }

/*This code is based around the game, Mastermind.*/

import java.util.*;
import java.lang.Math;

  public class mastermind{


    public static int numberofplayer;

    public static String inputanswer() { //function to generate the master answer
    //System.in is a standard input stream 
         String masteranswer;
        char[] array = {'r','b','y','g','w','p','h'};
        char[] newa = new char[4];
if (numberofplayer()==1) {          
        for(int m = 0; m<4; m++)//generate random letters and store them into a seperate array
        {
          int int_random = (int)(Math.random()*(7));
          newa[m]=array[int_random];
        }
        String str2 = String.valueOf(newa);     
        masteranswer=str2;
            
      } else {
          Scanner sc = new Scanner(System.in);
          System.out.print("Enter a string as master answer: ");  
          masteranswer= sc.nextLine();              //reads string  
        }
      
        return masteranswer;
    }
   
    public static int numberofplayer() { //function to ask for number of players
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
        System.out.print("Enter number of player (max 2): ");  
         numberofplayer= sc.nextInt();              //reads int from user  
        System.out.print("No of players: "+numberofplayer +"\n");
       
        return numberofplayer;
    }
    
    public static void compare(String answer) { //compares the player answer with the master answer
        int numberofright=0;
        int numberofwrong=0;
        boolean playercharinmaster;
        boolean playercharincheck;
        boolean playercharwrongrepeat;
        int playername=1;
        int looptimes=10;
   
        if (numberofplayer == 2) { //if the total player is 2 then the rounds will be doubled
            looptimes = 20;
        }

        for(int l = 1; l < looptimes; l++) //changes players
        {
            playername = 1;
            if (numberofplayer ==1) {
                playername = 1;
            } else {
            if ((l ^ 1) == l + 1) {//if the rounds are a even number then it will be player 2's turn
                playername = 2;
            }
            }
           
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
        System.out.print("Player" + playername +" , please enter your answer: ");  
        String playeranswer= sc.nextLine();              //reads string  
        System.out.print("Player entered: "+playeranswer+ "\n");

   
        numberofright=0;
        numberofwrong=0;
        char[] master = answer.toUpperCase().toCharArray();
        char[] player = playeranswer.toUpperCase().toCharArray();
        char[] checked = new char[master.length];
        char[] checkedwrong = new char[master.length];
       
        for(int i = 0; i < master.length; i++) //if the player character matches with the master character, it increments the numberofright by 1
        {
            if (master[i] == player[i]) {
                numberofright++;
                checked[i] = player[i];
            }
        }
               
        for(int k=0; k <master.length; k++) //Defaults all booleans to false
        {
                playercharinmaster = false;
                playercharincheck = false;
                playercharwrongrepeat = false;
            for(int j=0; j < master.length; j++)
            {

                if(player[k] == master[j]) { //If the player character is in the mastery answer then the boolean becomes true
                    playercharinmaster = true;
                }
                if(player[k] == checked[j]) {//If the player character is in the right spot
                    playercharincheck = true;
                }
                if(player[k] == checkedwrong[j]) {//If the wrong player character is repeated
                    playercharwrongrepeat = true;
                }
                 
            }
                if (playercharincheck == false && (playercharinmaster ==true && playercharwrongrepeat == false)) { //goes through all three conditions to increment numberofwrong by 1
                    numberofwrong++;
                    checkedwrong[k] = player[k];
                }
               
        }
          //print number of right and wrong and whether you win or lose
        System.out.print("No. of right: " +numberofright +"\n");
        System.out.print("No. of wrong spot: " +numberofwrong +"\n");
       
        if (numberofright == 4) {//if all 4 character are right, then you win!
            System.out.print("Player" +playername + " You win" + "\n");
            System.exit(0);
        }
        }
  
  System.out.println("You lose");//could not guess with all the tries
    }
}

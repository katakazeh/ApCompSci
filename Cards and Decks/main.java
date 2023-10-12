import java.util.Scanner;
import java.lang.Math;

class Main {
  public static void main(String[] args) {
    Deck playerDeck = new Deck(); 
    Deck eledeck = new Deck();
    playerDeck.createDeck();
    playerDeck.shuffle();
    playerDeck.elevencards();

    eledeck.createDeck();
    eledeck.shuffle();
    eledeck.elevencards();

    while (playerDeck.size() > 0){
      System.out.print(eledeck.toString());
      Scanner myObj = new Scanner(System.in);
      System.out.println("Enter the cards that equal 11 - in numbers");
      int ok = myObj.nextInt();
      for (int p=0; p<11; p++){
        for (int i=0; i<11; i ++){
        if ((playerDeck.listCard.get(p).returnValue() == ok) && playerDeck.listCard.get(p).returnValue()==eledeck.listCard.get(i).returnValue()){
          playerDeck.listCard.remove(p);
          if (playerDeck.listCard.get(p).isFaceCard()==true){
            if (playerDeck.listCard.get(p).returnValue()==10){
              for (int z = 0; z<11; z++){
                
              }
            }
          }
          eledeck.listCard.remove(i);
        }
      }
        }
    }

  
  }
}

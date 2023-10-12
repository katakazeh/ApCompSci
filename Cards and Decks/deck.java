import java.util.*;
import java.util.Random;
import java.lang.Math;


public class Deck{
    
  
  public ArrayList<card> listCard = new ArrayList<card>();
  public card newestof;

    public void createDeck(){
      for (int i = 0; i<4; i++){
        for (int c = 1; c<14; c++){
          card newestof = new card(i,c);
          //newestof=newestof.cardcons(i,c);
          //card lastly = (card)newestof.getCard();
          listCard.add(newestof);
      }
      }
      }

    public Object getCard(){
      
      return listCard.remove(1);
    }

    public void elevencards(){
      for (int i = 0; i<2; i++){
        listCard.remove(Math.random());
           }
    }

    public void shuffle(){

      Collections.shuffle(listCard);
      //int n = listCard.size();
      //Random random = new Random();
      //random.nextInt();
      //for (int i = 0; i<n; i++){
       //int change = i + random.nextInt(n-1);
       // int helper = listCard.get(i);
       // listCard.set(i,listCard.get(change));
       // listCard.set(change,helper);
      }
    //}
    
      
    public String toString(){
      return (listCard.toString());
    }

    public int size(){
      return (listCard.size());
    }
  








  
}

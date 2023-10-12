public class card{

  public String namesuit;
  public String namekind;

 String suits[] = {"Hearts","Diamond","Spade","Club"};
  String kind[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13"};

//determine the suit 
  card(int x, int k){
    if ( x == 0){
      namesuit=suits[0];
    }
    if (x == 1){
      namesuit=suits[1];
    }
    if (x == 2){
      namesuit=suits[2];
    }
    if (x == 3){
      namesuit=suits[3];
    }
    
//determine the kind
    
    if (k == 1){
      namekind="Ace";
    }
    else if (k == 11){
      namekind="Jack";
    }
    else if (k==12){
      namekind="Queen";
    }
    else if (k == 13){
      namekind="King";
    }
      
    else if (1<k && k<11){
      namekind=kind[k-1];
    }
    }

  public Object getCard(){
    return new Object[]{namesuit, namekind};
    
  }

  public boolean isFaceCard(){
    return (namekind=="Jack" || namekind=="Queen" || namekind=="King");
  }

  public boolean isAce(){
    return (namekind=="Ace");
  }

  public int returnValue(){
    if (namekind.equals("Ace")){
      return 1;
    }
    else if (namekind.equals("Jack")){
      return 10;
    }
    else if (namekind.equals("Queen")){
      return 10;
    }
    else if (namekind.equals("King")){
      return 10;
    }
      
    else {
      int pow = Integer.parseInt(namekind);
      return pow;
                }
    }

  public String toString(){
    return (namekind + " of " + namesuit);
  }
}
 


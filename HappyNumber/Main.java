import java.util.Scanner; 

class Main {
  public static void main(String[] args) {
     
     
   Scanner sc = new Scanner(System.in);
   int n = sc.nextInt();
    
    System.out.print(Happy.sum);
    if (Happy.isHappynumber(n))
        System.out.println(n +
        " is a Happy number");
      else
        System.out.println(n +
        " is not a Happy number");
}
}

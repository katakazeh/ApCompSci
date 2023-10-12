import java.util.ArrayList;
 
class Happy{

  static ArrayList<Integer> sum = new ArrayList<Integer>();
  
static int numSquareSum(int n)
{
    int squareSum = 0;
    while (n!= 0)
    {
        squareSum += (n % 10) * (n % 10);
        n /= 10;

        sum.add(squareSum);
    }
    return squareSum;
}
  
static boolean isHappynumber(int n)
{
    int slow, fast;
  

    slow = fast = n;
    do
    {

        slow = numSquareSum(slow);

        fast = numSquareSum(numSquareSum(fast));
  
    }
    while (slow != fast);

    return (slow == 1);
}
}

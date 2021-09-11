import java.util.Arrays;
import java.util.Scanner;

public class CoinTF {

  public static void main(String[] args) {
// intro things
    
    Scanner input = new Scanner(System.in);
    if(!input.hasNextInt()) {
      input.close();
      return;
    }
    
    // get number of Coins
    int numCoins = input.nextInt();
    input.nextLine();
    
    // build coin array
    int[] coins = new int[numCoins];
    
    for(int i = 0; i < numCoins; i++) {
      coins[i] = input.nextInt(); 
      input.nextLine();
    }
    
    // if sum is not even then print F
    int sum = 0;
    for(int i = 0; i < numCoins; i++) {
      sum += coins[i];
    }
    
    if (sum % 2 == 1) {
      System.out.print("F");
      return;
    }
    
    Arrays.sort(coins);
    
    int tempSum = 0;
    int key = sum/2;
    int index = coins.length - 1;
    while(tempSum != key && index != 1) {
      tempSum += coins[index];
      if(tempSum == key) {
        break;
      }
      if(tempSum > key) {
        tempSum -= coins[index];
      }
      index--;
    }
    
    if(tempSum == key)
      System.out.print("T");
    else {
      System.out.print("F");
    }
    
  }

}

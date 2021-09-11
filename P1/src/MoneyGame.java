// Joe O'Connell
// CS 577

import java.util.Scanner;

public class MoneyGame {
  
  public static void main(String[] args) {
    
    // intro things
    
    Scanner input = new Scanner(System.in);
    if(!input.hasNextInt()) {
      input.close();
      return;
    }
  
    // get number of elements
    int numElements = input.nextInt();
    input.nextLine();
    
    // variables for loop
    int tempValue = 0;
    int tempMoney = 0;
    int maxMoney = 0;
    
    // enter main loop
    for(int i = 0; i < numElements; i++) {
      // get value
      tempValue = input.nextInt();
      input.nextLine();
      
      // add to temp value
      tempMoney += tempValue;
      
      // if tempMoney is negative, reset bank back to zero and reset startIndex to next
      if(tempMoney <= 0) {
        tempMoney = 0;
        continue;
      }
      
      // if current is greater, replace the maxMoney with current
      if(tempMoney > maxMoney) {
        maxMoney = tempMoney;
      }
    }
    
    // close scanner and print
    input.close();
    System.out.print(maxMoney);
  }

}

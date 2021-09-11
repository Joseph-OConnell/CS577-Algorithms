import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class nutsNbolts {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    if(!input.hasNextInt()) {
      input.close();
      return;
    }
    
    // get number of Coins
    int numNuts = input.nextInt();
    int numBolts = input.nextInt();
    input.nextLine();
    
    // build coin array
    int[][] interaction = new int[numNuts][numBolts];
    // loop vars
    int tempVal = 0;
    int rowCount = 0;
    ArrayList<Row> order = new ArrayList<Row>();
    LinkedList<Integer> indices = new LinkedList<Integer>();
    for(int i = 0; i < numNuts; i++) {
      for(int j = 0; j < numBolts; j++) {
        tempVal = input.nextInt();
        interaction[i][j] = tempVal;
        if(tempVal == 1) {
          indices.add(j);
          rowCount++;
        }
      }
      order.add(new Row(rowCount, i, indices));
      rowCount = 0;
      indices = new LinkedList<Integer>();
      input.nextLine();
    }
    
    order.sort(null);
    
    // loop vars
    int[] taken = new int[numBolts];  
    int success = 0;
    for(int i = 0; i < numNuts; i++) {
      for(int j = 0; j < order.get(i).rowCount; j++) {
        if(taken[order.get(i).indices.get(j)] != 1) {
          success++;
          taken[order.get(i).indices.get(j)] = 1;
          break;
        }
      }      
    }
    System.out.print(success);
    input.close();
  }

}

// Joe O'Connell
// CS 577

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class IntersectionCount {
  // number of intersections to print c
  
  private static ArrayPair intersectionCounter(ArrayPair pair) {
    
    // Base case
    if(pair.p.length == 1)
      return pair;
    
    // Recursive case
    // make new ArrayPair variables
    int middle = (pair.p.length + 1)/2;
    
    // loop variables
    int[] frontP = new int[middle];
    for(int i = 0; i < middle; i++) {
      frontP[i] = pair.p[i];
    }
    
    // loop variables
    int[] backP = new int[pair.p.length - middle];
    for(int i = 0 ; i < pair.p.length - middle; i++) {
      backP[i] = pair.p[i + middle];
    }
    
    // make new ArrayPairs
    ArrayPair frontPair = new ArrayPair(frontP, 0);
    ArrayPair backPair = new ArrayPair(backP, 0);
    
    // Make recursive calls
    ArrayPair frontSort = intersectionCounter(frontPair);
    ArrayPair backSort = intersectionCounter(backPair);
    
    
    // Combine
    
    ArrayPair merger = merge(frontSort, backSort);
    
    ArrayPair total = new ArrayPair(merger.p,  merger.c + frontSort.c + backSort.c);
    
    return total;
  }
  
  private static ArrayPair merge(ArrayPair left, ArrayPair right) {

    // some boolean variables to help keep track
    // true = min on left
    // false = min on right
    boolean P = false;
    
    // array to return & intersect counter
    int[] newP = new int[(left.p.length + right.p.length)];
    int intersections = 0;
    
    // indexes
    int a = 0; // left p
    int b = 0; // right p
    
    for(int i = 0; i < (left.p.length + right.p.length); i++){
      // find mins      
      if(left.p.length == a)
        P = false;
      else if(right.p.length == b)
        P = true;
      else if(Math.min(left.p[a], right.p[b]) == left.p[a])
        P = true;
      else 
        P = false;
      // TWO CASES
      // mins on left
      if(P) {
        newP[i] = left.p[a];
        a++;
        continue;
      }
      // mins on right
      else {
        newP[i] = right.p[b];
        b++;
        intersections = intersections + (left.p.length - a);
        continue;
      }
    }
    
    ArrayPair mergedPair = new ArrayPair(newP, intersections);
    return mergedPair;
    
  }

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
    
    // build two arrays
    int[] q = new int[numElements];
    int[] p = new int[numElements];

    // variables for loop
    int tempValue = 0;
    
    // read data into array q
    for(int i = 0; i < numElements; i++) {
      // get value
      tempValue = input.nextInt();
      input.nextLine();
      q[i] = tempValue;
    }
    
    // read data into array p
    for(int i = 0; i < numElements; i++) {
      // get value
      tempValue = input.nextInt();
      input.nextLine();
      p[i] = tempValue;
    }
    
    ArrayList<Pair> mainList = new ArrayList<Pair>();
    
    for(int i = 0; i < q.length; i++) {
      mainList.add(new Pair(q[i],p[i]));
    }
    
    Collections.sort(mainList);
    
    int[] invertList = new int[mainList.size()];
    
    for(int i = 0; i < mainList.size(); i++) {
      invertList[i] = mainList.get(i).p;
    }
    
  
    ArrayPair mainArray = new ArrayPair(invertList, 0);

    ArrayPair sortedArray = intersectionCounter(mainArray);
    
    long count = sortedArray.c;
    System.out.print(count);
    input.close();
  }

}

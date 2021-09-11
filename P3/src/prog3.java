import java.util.Scanner;
import java.util.Stack;

public class prog3 {
  
//  private static int[] findSix(int[][] adj, int[] sixCities, int current) {
//    //BFS Search
//    return null;
//  }
// 
//  
//  private static void findEnd(int[][] adj) {
//    
//    // call fcn to find points 6 roads away
//    // loop vars
//    boolean escape = false;
//    int weeks = 0;
//    int[] sixCities = new int[adj.length]; //pre-existing cities reached by six
//    int currentCity = 1;
//    while(!escape) {
//      
//      int[] sixAway = findSix(adj, sixCities, currentCity);
//      
//      // test to see if there is one
//      for(int i = 0; i < sixAway.length; i++) {
//        if(sixAway[i] != 0) {
//          break;
//        }
//      }
//      
//      //
//      
//    }
//    System.out.print(weeks);
//  }

  public static void main(String[] args) {
// intro things
    
    Scanner input = new Scanner(System.in);
    if(!input.hasNextInt()) {
      input.close();
      return;
    }
    
    // get number of elements
    int N = input.nextInt();
    int M = input.nextInt();
    input.nextLine();
    
    // build 2D array
    int[][] adj = new int[N+1][N+1];
    
    // loop vars
    int road1;
    int road2;
    
    for(int i = 0; i < M; i++) {
      road1 = input.nextInt();
      road2 = input.nextInt();
      input.nextLine();
      adj[road1][road2] = 1;
      adj[road2][road1] = 1;
    }
    
    if(N < 6) {
      System.out.println(-1);
    }
    
    int[] visited = new int[adj.length];
    
    int current = 1;
    int cities = 1;
    int currentBefore = 0;
    
    while(current != N) {
      currentBefore = current;
      for(int i = 1; i <= N; i++) {
        if(adj[current][i] == 1 && visited[i] == 0) {
          visited[current] = 1;
          cities++;
          current = i;
        }
      }
      if(currentBefore == current) {
        break;
      }
      
    }
    
    if(cities == N) {
      if(cities % 6 == 0)
        System.out.print(cities/6);
      else {
        System.out.print(cities/6 + 1);
      }
    }
    else {
      System.out.print(-1);
    }
    
//    findEnd(adj);
    
    input.close();
  }

}

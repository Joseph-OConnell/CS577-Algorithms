import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class VaccineDistribution {
  public static void main(String[] args) {
    // intro things
    
    Scanner input = new Scanner(System.in);
    if(!input.hasNextInt()) {
      input.close();
      return;
    }
    
    // get number of elements
    int nodes = input.nextInt();
    int prod = input.nextInt();
    int edges = input.nextInt();
    input.nextLine();
    
    // build 2D array
    int[][] adj = new int[nodes + 1][nodes + 1];
    
    // loop vars
    int start;
    int end;
    int cost;
    
    for(int i = 0; i < edges; i++) {
      start = input.nextInt(); 
      end = input.nextInt(); 
      cost = input.nextInt();
      input.nextLine();
      adj[start][end] = cost;
      adj[end][start] = cost;
    }
    // prim's algo priority queue
    
    PriorityQueue<pair> queue = new PriorityQueue<pair>();
    
    // to start, add everything connected to 1
    for(int i = 1; i < nodes + 1; i++) {
      if(adj[1][i] != 0) {
        queue.add(new pair(1, i, adj[1][i]));
 //       System.out.println("hi");
      }
    }
    
    // array to keep track of all the edge values we add
    int[] minSpan = new int[nodes];
    
    // array to keep track of visited nodes; visited == 1
    int[] visited = new int[nodes + 1];
    
    // counter int to keep track of how many nodes visited
    int count = 0;
    
    // temp pair var
    pair temp;
    
    //manually do this for pt 1;
    visited[1] = 1;
    count++;
    // prim's algo loop   
    while(!queue.isEmpty() && count != nodes) {
      temp = queue.remove();
      if(visited[temp.end] == 1) {
        continue;
      }
      // haven't visited node if here
      // add to minimum span list
      minSpan[count - 1] = temp.cost;
      // add to visited list
      visited[temp.end] = 1;
      // increment counter
      count++;
      
      // add new nodes to Queue that are connected to end and not visited
      for(int i = 1; i < nodes + 1; i++) {
        if(visited[i] == 0 && adj[temp.end][i] != 0) {
          queue.add(new pair(temp.end, i, adj[temp.end][i]));
        }
      }
      
    }
    // Sort Array
    Arrays.sort(minSpan);
    // for each production center over 1, remove the max edge
    int maxEdge = minSpan[nodes-1];
    for(int i = 1; i < prod; i++) {
      maxEdge = minSpan[(nodes-1) - i];
    }
    // print answer
    System.out.print(maxEdge);
    input.close();
  }
}

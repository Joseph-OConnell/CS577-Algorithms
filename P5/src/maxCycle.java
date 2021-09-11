import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class maxCycle {

  public static void main(String[] args) {
// intro things
    
    Scanner input = new Scanner(System.in);
    if(!input.hasNextInt()) {
      input.close();
      return;
    }
    
    // get number of Coins
    int nodes = input.nextInt();
    int edges = input.nextInt();
    input.nextLine();
    
    // build coin array
    @SuppressWarnings("unchecked")
    LinkedList<Exchange>[] adj = new LinkedList[nodes];
    
    // var for loop
    String start = "";
    String end = "";
    double val;
    LinkedList<Exchange> tempList;
    for(int i = 0; i < edges; i++) {
      start = input.next(); 
      end = input.next(); 
      val = -1*Math.log((input.nextDouble() / 100));
      // Add to adj list
      for(int j = 0; j < nodes; j++) {
        // if entry is null, make new linked list and add
        if(adj[j] == null) {
          tempList = new LinkedList<Exchange>();
          tempList.add(new Exchange(start,0));
          tempList.add(new Exchange(end,val));
          adj[j] = tempList;
          break;
        }
        // if string matches one of the existing start nodes
        if(adj[j].get(0).end.equals(start)) {
          adj[j].add(new Exchange(end,val));
          break;
        }
      }
      input.nextLine();
    }
    for(int j = 0; j < nodes; j++) {
      System.out.println(adj[j]);
    }

    // built the adjacency matrix.  Run DFS on each one and find shortest cycle on each
    // add each cycle to a Linked List
    for(int i = 0; i < nodes; i++) {
      int[] visited = new int[nodes];
      visited[i] = 0;
      int counter = nodes - 1;
      Queue<Exchange> mainQueue = new LinkedList<>();
      // add all the connected nodes of i to queue
      for(int j = 1; j < adj[i].size(); j++) {
        mainQueue.add(adj[i].get(j));
      }
      
      // loop vars
      Exchange currentNode;
      // enter main loop
      while(!mainQueue.isEmpty()) {
        currentNode = mainQueue.remove();
        // check to make sure it hasn't been visited
        // get index of the current
      }
    }
  }
}

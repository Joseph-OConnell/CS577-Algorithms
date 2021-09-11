
public class pair implements Comparable<pair>{
  // variables
  int start;
  int end;
  int cost;
  
  public pair(int start, int end, int cost) {
    this.start = start;
    this.end = end;
    this.cost = cost;
  }
  
  public String toString() {
    return "[" + start + ", " + end + ", " + cost + "]";
  }
  
  public int compareTo(pair pair2) {
    if(this.cost > pair2.cost) {
      return this.cost - pair2.cost;
    }
    
    else if(this.cost < pair2.cost) {
      return this.cost - pair2.cost;
    }

    else {
      // do tiebreakers
      int u = Math.min(this.start, this.end);
      int v = Math.max(this.start, this.end);
      int r = Math.min(pair2.start, pair2.end);
      int s = Math.max(pair2.start, pair2.end);
      
      if(u < r) {
        return 1;
      }
      else if(u > r) {
        return -1;
      }
      else {
        if(v < s) {
          return 1;
        }
        else {
          return -1;
        }
      }
    }
  }

}

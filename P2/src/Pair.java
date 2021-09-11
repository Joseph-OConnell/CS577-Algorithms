// Joe O'Connell
// CS 577

public class Pair implements Comparable<Pair> {
  int q;
  int p;
  
  public Pair(int q, int p) {
    this.q = q;
    this.p = p;
  }

  @Override
  public int compareTo(Pair pair2) {
    return this.q - pair2.q;
  }
  
  public String toString(Pair pair) {
    String output = "(" + q + ", " + p + ")";
    return output;
  }
}

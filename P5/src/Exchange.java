
public class Exchange {
  String end;
  double weight;
  
  public Exchange(String end, double weight) {
    this.end = end;
    this.weight = weight;
  }
  
  public String toString() {
    return end + ", " + weight;
  }
}

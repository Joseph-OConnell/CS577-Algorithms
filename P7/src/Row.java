import java.util.LinkedList;

public class Row implements Comparable<Row>{
  int rowCount;
  int index;
  LinkedList<Integer> indices;
  
  public Row (int rowCount, int index, LinkedList<Integer> indices) {
    this.index = index;
    this.rowCount = rowCount;
    this.indices = indices;
  }
  
  @Override
  public int compareTo(Row obj2) {
    return this.rowCount - obj2.rowCount;
  }

}

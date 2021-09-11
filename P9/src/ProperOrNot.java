import java.util.Scanner;

public class ProperOrNot {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    if(!input.hasNextInt()) {
      input.close();
      return;
    }
    
    // get number of locations
    int numVert = input.nextInt();
    int numEdg = input.nextInt();
    int numk = input.nextInt();
    input.nextLine();
    
    // loop vars
    int[][] adjMat = new int[numVert + 1][numVert + 1];
    int tempInd1 = 0;
    int tempInd2 = 0;
    // make adj matrix
    for(int i = 0; i < numEdg; i++) {
      tempInd1 = input.nextInt();
      tempInd2 = input.nextInt();
      adjMat[tempInd1][tempInd2] = 1;
      adjMat[tempInd2][tempInd1] = 1;
      if(i != numEdg - 1) {
        input.nextLine();
      }
    }
    
    // loop through all vertices and assign colors until it breaks or finishes
    // loop vars
    int[] colors = new int[numVert + 1];
    int[] colorWheel;
    int tempColor = 0;
    
    
    for(int i = 1; i <= numVert; i++) {
      colorWheel = new int[numk + 1];
    // loop through the vertex and figure out which colors are taken
    // remove those colors
      for(int j = 1; j <= numVert; j++) {
        if(adjMat[i][j] == 1 && colors[j] != 0) {
          tempColor = colors[j];
          colorWheel[tempColor] = 1;
        }
      }
      
    // loop through index of colors and see which are remaining
      for(int j = 1; j <= numk; j++) {
        if(colorWheel[j] == 0) {
          colors[i] = j;
          break;
        }
        if(j == numk) {
          System.out.print("False");
          input.close();
          return;
        }
      }
    }
    
    System.out.print("True");    
    input.close();
  }
}

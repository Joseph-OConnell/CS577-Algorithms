import java.util.Scanner;

public class BuriedTreasure {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    if(!input.hasNextInt()) {
      input.close();
      return;
    }
    
    // get number of locations
    int numLoc = input.nextInt();
    int numPre = input.nextInt();
    input.nextLine();
    
    // read in values
    int[] vals = new int[numLoc];
    for(int i = 0; i < numLoc; i++) {
      vals[i] = input.nextInt();
    }
    input.nextLine();
    
    // create dummy prereq objects assuming everthing is already unlocked
    // put in array
    PreReq[] paths = new PreReq[numPre];
    for(int i = 0; i < numPre; i++) {
      paths[i] = new PreReq()
    }
    
    // read in pre reqs
    
    

  }

}

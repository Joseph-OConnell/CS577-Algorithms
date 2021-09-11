import java.util.Scanner;

public class AverageCell {
  public static void main(String[] args) {
    // intro things
     
     Scanner input = new Scanner(System.in);
     if(!input.hasNextInt()) {
       input.close();
       return;
     }
     
     // get height of tree
     int height = input.nextInt();
     input.nextLine();
     
     // build first array
     node[] points = new node[(int) Math.pow(2, height)];
     // fix the scanner
     input.useDelimiter("");
     for(int i = 0; i < points.length; i++) {
       points[i] = new node(Integer.parseInt(input.next()), 1); 
     }
     
     // depending on even or odd height determines starting and/or logic
     // true is and, false is or
     boolean start = true;
     if(height % 2 == 0) {
       start = false;
     }
     
     // loop variables
     node[] nextArray = new node[points.length/2];
     
     // enter loop
     while(nextArray.length != 1) {
       // redefine new array
       nextArray = new node[points.length/2];
       
       // loop vars
       int logic1;
       int logic2;
       int logicOut;
       double weight1;
       double weight2;
       double weightOutL;
       double weightOutR;
       double weightOut;
       // iterate through points array and take 2 nodes at a time
       for(int i = 0; i < points.length -1; i = i+2) {
         // logic calcs
         logic1 = points[i].logic;
         logic2 = points[i+1].logic;
         // ANDs
         if(start) {
           if(logic1 == 1 && logic2 == 1) {
             logicOut = 1;
           }
           else {
             logicOut = 0;
           }
         }
         // ORs
         else {
           if(logic1 == 1 || logic2 == 1) {
             logicOut = 1;
           }
           else {
             logicOut = 0;
           }
         }
         
         // weight calculations
         weight1 = points[i].weight;
         weight2 = points[i+1].weight;
         // ANDs
         if(start) {
           // left node calculation first
           if(logic1 == 0) {
             weightOutL = weight1;
           }
           else {
             weightOutL = weight1 + weight2;
           }
           // right node calculation next
           if(logic2 == 0) {
             weightOutR = weight2;
           }
           else {
             weightOutR = weight1 + weight2;
           }
           weightOut = weightOutL/2 + weightOutR/2;
         }
         // ORs
         else {
             // left node calculation first
             if(logic1 == 1) {
               weightOutL = weight1;
             }
             else {
               weightOutL = weight1 + weight2;
             }
             // right node calculation next
             if(logic2 == 1) {
               weightOutR = weight2;
             }
             else {
               weightOutR = weight1 + weight2;
             }
             weightOut = weightOutL/2 + weightOutR/2;
           }       
         
         // make new nodes and add to new array
         nextArray[i/2] = new node(logicOut, weightOut);
       }
       start = !start;
       points = nextArray;
     }
     
     System.out.print(points[0].weight);
     input.close();
  }
}

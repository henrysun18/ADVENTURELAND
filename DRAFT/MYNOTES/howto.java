/*
template   Dwite_IN_out_java.java
*/
import java.io.*;
import java.util.*;

class Dwite_IN_out_java {
  public static void main (String [] args) throws IOException {

    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("quest1.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("quest1.out")));

    String s = f.readLine();     // gets entire line
   
    int fr_num = Integer.parseInt(s);
  
    out.write(""+  fr_num  + "\n" );  


    f.close();
    out.close();                // close the output file
    System.exit(0);             // don't omit this!

  
   } // end main




}//end class
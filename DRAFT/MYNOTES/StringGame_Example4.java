
/*
In this example we
- generate desh word by using a secret word and a for loop
-  ask user with char should be replaced with char 'x' (for example) 
- replace this desh with 'x'

*/
import java.util.Scanner;
import java.io.*;


public class StringGame_Example4{
	public static void main (String[] args) throws Exception{     // you need to add "throws Exception" this to tell java that you don't care about the errors
		String secret="apple";
		String desh="";
		 for (int i=0; i<secret.length(); i++){
		   desh=desh+"-";
		 }
		 System.out.print("desh  "  + desh );
		 
		System.out.print("\n\n-------------new desh--------  \n\n");	
		for (int i=0; i<desh.length(); i++){
		    System.out.print(desh.charAt(i)+" " );
		}
		
	} 
}
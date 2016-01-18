/*
In this example the user choses the file to open from the menue, and 
according to the choice we open the  file, read lines and display them on the screen
We should know in advance how many words are in the file in order to use it in the for loop

*/
import java.util.Scanner;
import java.io.*;


public class StringGame_Example1{
	public static void main (String[] args) throws Exception{     // you need to add "throws Exception" this to tell java that you don't care about the errors
		String in;
		int choice;
		String fileName="";
		Scanner sc = new Scanner(System.in);   // to read from the screen the use choice
		
		System.out.println("Pick from the list: ");
		System.out.println("1. Vegitables");
		System.out.println("2. Fruits");
		
		choice=sc.nextInt();  
		fileName="WordFile" + choice +".txt";
		
		Scanner scFile = new Scanner(new File(fileName));      // read from the file instead of the screen

		for(int i=0;i<15;i++){
		      in=scFile.nextLine();                //read the line and assign the value to variable in
		      System.out.println( in);               
		}
		
		sc.close();
		scFile.close();
	} 
}
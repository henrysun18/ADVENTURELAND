
/*
In this example we chose a random word from the file "WordFile1.txt" and display it on the screen
We should know in advance how many words are in the file in order to generate a random number from 1 to the number
Every time we run the programm, a random number is generated and a word is displayed
*/
import java.util.Scanner;
import java.io.*;


public class StringGame_Example2{
	public static void main (String[] args) throws Exception{     // you need to add "throws Exception" this to tell java that you don't care about the errors
		String in="";
		int rndWordNum=1;
		
		rndWordNum =(int)(Math.random()*15)+1;  //number from 1 to 15 because I know that there is 15 words in the file
		Scanner scFile = new Scanner(new File("WordFile1.txt"));      // read from the file instead of the screen

		for(int i=0;i<rndWordNum;i++)
		      in=scFile.nextLine();                //keep reading till we get to the desired line
		
		System.out.println("The number is: " + rndWordNum);   
		System.out.println( in);               

		scFile.close();
	} 
}
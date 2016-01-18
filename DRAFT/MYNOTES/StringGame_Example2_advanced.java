
/*
In this example we chose a random word from the file "WordFile1.txt" and display it on the screen
We don't need to know how many words are in the file. We open the file first, count how many lines are there and
use this number in order to generate a random number from 1 to the number
Every time we run the programm, a random number is generated and a word is displayed
*/
import java.util.Scanner;
import java.io.*;


public class StringGame_Example2_advanced{
	public static void main (String[] args) throws Exception{     // you need to add "throws Exception" this to tell java that you don't care about the errors
		String in="";
		int rndWordNum=1;
		int cnt=0;
		
		
		Scanner scFileCnt = new Scanner(new File("WordFile1.txt"));      // read from the file instead of the screen

		while(scFileCnt.hasNext()){
		    in=scFileCnt.nextLine();
		    cnt++;                    // open file and count how many line in there. 
		}	
		scFileCnt.close();    //close the scanner and the file.
		System.out.println("There are " + cnt + " lines in the file");
		
		rndWordNum =(int)(Math.random()*cnt)+1;  //number from 1 to cnt because I know that there are cnt words in the file
		
		Scanner scFile = new Scanner(new File("WordFile1.txt"));      // open the file again

		for(int i=0;i<rndWordNum;i++)
		      in=scFile.nextLine();                //keep reading till we get to the desired line
		
		System.out.println("The random number is: " + rndWordNum); 
		System.out.println( in);               

		scFile.close();
	} 
}
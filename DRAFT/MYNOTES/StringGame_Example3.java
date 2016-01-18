
/*
In this example we check if the letter is a file letter word existing in our dictionary
The dictionary file doesn't have a new line character, it is one long-long line.
This allows us to use indexOf() method, which returns positive number if the word exists and -1, if it doesn't
We use spaces arrond the word in order to make sure that we dont accept a part of a word

*/
import java.util.Scanner;
import java.io.*;


public class StringGame_Example3{
	public static void main (String[] args) throws Exception{     // you need to add "throws Exception" this to tell java that you don't care about the errors
		String in="", userWord="";
		int rndWordNum=1;
		int cnt=0;
		
		Scanner sc = new Scanner(System.in);   // to read from screen
		Scanner scFile = new Scanner(new File("dict.txt"));      // to read from file
		
		System.out.print("Please enter a five letter word: ");
		userWord=sc.nextLine();    // read the word from the user
		userWord=userWord.trim();    // erase allleading and trailing spaces( just in case)
		
		
		if (userWord.length()!=5)
		   System.out.print("Too short or too long.");
		else{
		   in=scFile.nextLine();     //read the dictionary
		   System.out.print(in);
		   if (in.indexOf(" " + userWord + " ") ==-1){
		       System.out.print("Sorry, the word in not in our dictionary");
			}
			else{
			  System.out.print("You have entered: " + userWord);
			  System.out.print("It is a five letter word which exists in our dicitonary file");
			}  
			  
        }// end of else 			
           
       
        scFile.close();
		sc.close();
	} 
}
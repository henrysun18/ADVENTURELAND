/*replace in case i do get it
			else if (menuChoice.equals("2")){ 
				System.out.println("\n--------------------------HOW TO PLAY---------------------------\n");
				System.out.println("ADVENTURELAND is a single-player adventure game where a brave King Ganon is captured by the \nbandits of Balrog Empire and is left stranded in the middle of nowhere. \nGanon must travel far and wide to find and reunite with his beautiful Queen Daisy.");
				System.out.println("The player must be ready for constant challenges that require word knowledge and common sense.");
				System.out.println("Are you ready for ADVENTURELAND? Prepare for the ADVENTURE of a LIFETIME...");
				System.out.println("\nThe RULES: ");
				System.out.println("When prompted to enter a word, only the first word entered is taken by computer.");
				System.out.println("\nThe SCORING: ");
				System.out.println("Your score is determined by how fast you complete the adventure as well as your remaining lives.");
				System.out.println("Each extra life remaining reduces your score by 5 seconds");
				System.out.println("The lower your score, the higher you will be on the high scores list.");
				System.out.println("That's all."); 
				System.out.println("\n\nGOOD LUCK AND ENJOY THE ADVENTURE!!!");
				System.out.println("\n----------------------------------------------------------------\n");
				System.out.print("Input anything to continue: ");
				userEntry=in.next();
				menuChoice="goback";
			}
			*/
			
			
import java.util.Scanner;
import java.io.*;

class highscorestest{
	public static void main(String[]args)throws Exception{//HIGHSCORES top 5
		Scanner in=new Scanner(System.in);
		//create file
		BufferedReader inScores=new BufferedReader(new FileReader("highscores.txt"));
		//VERY IMPORTANT - temporary store ScoresLog
		String Scores=inScores.readLine();
		//VERY IMPORTANT - define current high scores from temporary Scores
		String hname1=Scores.substring(0,3);
		String hname2=Scores.substring(3,6);
		String hname3=Scores.substring(6,9);
		String hname4=Scores.substring(9,12);
		String hname5=Scores.substring(12,15);
		String hscore1=Scores.substring(15,18); //hscore must be long as it comes from measuring TimeMillis
		String hscore2=Scores.substring(18,21);
		String hscore3=Scores.substring(21,24);
		String hscore4=Scores.substring(24,27);
		String hscore5=Scores.substring(27,30);
		inScores.close();
		//printwriter comes in after Scores temporary log is stored
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("highscores.txt")));
		//variables for high scores
		String userName="";
		long score;
		String stringScore; //convert long into String for easier display
		
		
		//=============================HIGH SCORES *=======================================
			System.out.print("good job, 1st place. enter name:");
			userName=in.next(); //name result simulation
			score=100; //timemillis result simulation
			stringScore=Long.toString(score);
			
			
			//determine whether to save in 1st, 2nd, 3rd, 4th or 5th row
			if (stringScore.compareTo(hscore5)<0){//if rank compared to highscores >5
				if (stringScore.compareTo(hscore4)<0){//if rank compared to highscores >4
					if (stringScore.compareTo(hscore3)<0){//if rank compared to highscores >3
						if (stringScore.compareTo(hscore2)<0){//if rank compared to highscores >2
							if (stringScore.compareTo(hscore1)<0){//if rank compared to highscores >1
								hname5=hname4;
								hname4=hname3;
								hname3=hname2;
								hname2=hname1;
								hname1=userName;
								hscore5=hscore4;
								hscore4=hscore3;
								hscore3=hscore2;
								hscore2=hscore1;
								hscore1=stringScore;
							}
							else{//if rank compared to highscores is ONLY >2
								hname5=hname4;
								hname4=hname3;
								hname3=hname2;
								hname2=userName;
								hscore5=hscore4;
								hscore4=hscore3;
								hscore3=hscore2;
								hscore2=stringScore;
							}
						}
						else{//if rank compared to highscores is ONLY >3
							hname5=hname4;
							hname4=hname3;
							hname3=userName;
							hscore5=hscore4;
							hscore4=hscore3;
							hscore3=stringScore;
						}
					}
					else {//if rank compared to highscores is ONLY >4
					hscore5=hscore4;
					hscore4=stringScore;
					hname5=hname4;
					hname4=userName;
					}
				}
				else {//if rank compared to highscores is ONLY >5
					hscore5=stringScore;
					hname5=userName;
				}
			}
			Scores=(hname1+hname2+hname3+hname4+hname5+hscore1+hscore2+hscore3+hscore4+hscore5);
			out.write(Scores); 
			out.close();
			
			
			{ 
			 //display 3 digit score newScore.substring(newScore.length()-3); //display 3 digit score
				System.out.println("\n\n---------TOP 5 HIGH SCORES---------\n\n");
				System.out.println("    POSITION      PLAYER     TIME");
				System.out.println(" ---------------------------------"); //high scores top enclosure
				System.out.format("%15s %-3s %-2s %3s %-3s %-3s ", "|   1st  Place   |", hname1, "|", "|", hscore1, "|");
				System.out.println("\n ---------------------------------");
				
				System.out.format("%15s %-3s %-2s %3s %-3s %-3s ", "|   2nd  Place   |", hname2, "|", "|", hscore2, "|");
				System.out.println("\n ---------------------------------");
				
				System.out.format("%15s %-3s %-2s %3s %-3s %-3s ", "|   3rd  Place   |", hname3, "|", "|", hscore3, "|");
				System.out.println("\n ---------------------------------");
				
				System.out.format("%15s %-3s %-2s %3s %-3s %-3s ", "|   4th  Place   |", hname4, "|", "|", hscore4, "|");
				System.out.println("\n ---------------------------------");
				
				System.out.format("%15s %-3s %-2s %3s %-3s %-3s ", "|   5th  Place   |", hname5, "|", "|", hscore5, "|");
				System.out.println("\n ---------------------------------"); //high scores bottom enclosure
			}
			
		
		
}}
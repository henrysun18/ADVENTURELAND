	
			
import java.util.Scanner;
import java.io.*;
//restrict name to 3 letters (use break; for the five if's)
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
		String userEntry;
		
		
		//=============================HIGH SCORES *=======================================
			System.out.print("good job, 1st place. enter name:");
			userName=in.next(); //name result simulation
			score=454; //timemillis result simulation
			stringScore=Long.toString(score);
			
			
			//determine whether to save in 1st, 2nd, 3rd, 4th or 5th row
			if (stringScore.compareTo(hscore5)<0){//if rank compared to highscores >5
				if (stringScore.compareTo(hscore4)<0){//if rank compared to highscores >4
					if (stringScore.compareTo(hscore3)<0){//if rank compared to highscores >3
						if (stringScore.compareTo(hscore2)<0){//if rank compared to highscores >2
							if (stringScore.compareTo(hscore1)<0){//if rank compared to highscores >1
								do{
									System.out.print("\nEnter your name (3 characters): ");
									userName=in.next();
								}while (userName.length()!=3);
								System.out.println("              .-=========-.");
								System.out.println("              \\'-=======-'/");
								System.out.println("              _|   .=.   |_");
								System.out.println("             ( |  { 1 }  | )");
								System.out.println("              \\|   /|\\   |/");
								System.out.println("               \\__ '`' __/");
								System.out.println("                 _`) (`_");
								System.out.println("               /___"+userName+"___\\"); //trophy to display as soon as user wins
								System.out.println("              /__KING OF__\\");	//the display (menuChoice=10) trophy is hname1
								System.out.println("             /ADVENTURELAND\\");
								System.out.println("            /_______________\\");
								System.out.println("CONGRATULATIONS! You're the new KING of ADVENTURELAND! (1st place)");
								
								//changes to high score below
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
								//changes to high score above
								System.out.println("Be sure to check the high scores for your high score!");
								System.out.print("\nInput anything to continue: ");
								userEntry=in.next();
							}
							else{//if rank compared to highscores is ONLY >2
								do{
									System.out.print("\nEnter your name (3 characters): ");
									userName=in.next();
								}while (userName.length()!=3);
								System.out.println("ALMOST THERE! KEEP GOING! You're in 2nd place.");
								
								//changes to high score below
								hname5=hname4;
								hname4=hname3;
								hname3=hname2;
								hname2=userName;
								hscore5=hscore4;
								hscore4=hscore3;
								hscore3=hscore2;
								hscore2=stringScore;
								//changes to high score above
								System.out.println("Be sure to check the high scores for your high score!");
								System.out.print("\nInput anything to continue: ");
								userEntry=in.next();
							}
						}
						else{//if rank compared to highscores is ONLY >3
							do{
								System.out.print("\nEnter your name (3 characters): ");
								userName=in.next();
							}while (userName.length()!=3);
							System.out.println("Pretty good! You're in 3rd place.");
							//changes to high score below
							hname5=hname4;
							hname4=hname3;
							hname3=userName;
							hscore5=hscore4;
							hscore4=hscore3;
							hscore3=stringScore;
							//changes to high score above
							System.out.println("Be sure to check the high scores for your high score!");
							System.out.print("\nInput anything to continue: ");
							userEntry=in.next();
						}
					}
					else {//if rank compared to highscores is ONLY >4
						do{
							System.out.print("\nEnter your name (3 characters): ");
							userName=in.next();
						}while (userName.length()!=3);
						System.out.println("Not too bad. You're in 4th place.");
						//changes to high score below
						hscore5=hscore4;
						hscore4=stringScore;
						hname5=hname4;
						hname4=userName;
						//changes to high score above
						System.out.println("Be sure to check the high scores for your high score!");
						System.out.print("\nInput anything to continue: ");
						userEntry=in.next();
					}
				}
				else {//if rank compared to highscores is ONLY >5
					do{
						System.out.print("\nEnter your name (3 characters): ");
						userName=in.next();
					}while (userName.length()!=3);
					System.out.println("Eh, could be better. You're in 5th place.");
					//changes to high score below
					hscore5=stringScore;
					hname5=userName;
					//changes to high score above
					System.out.println("Be sure to check the high scores for your high score!");
					System.out.print("\nInput anything to continue: ");
					userEntry=in.next();
				}
			}
			else {
				do{
					System.out.print("\nEnter your name (3 characters): ");
					userName=in.next();
				}while (userName.length()!=3);
				System.out.println("Sorry. You did not qualify for the highscores' top 5. Better luck next time");
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
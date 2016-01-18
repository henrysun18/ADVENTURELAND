/*Henry Sun
Mrs. S ICS3U-01
Dropped: November 06, 2012

	String Game
*/

import java.util.Scanner;
import java.io.*;
//NO HIGH SCORES
class ADVENTURELAND{
	public static void main(String[]args)throws Exception{
	
		//set scanner
		Scanner in=new Scanner(System.in);
		Scanner inDict = new Scanner(new File("5letterwords.txt"));      // to read from file
		
		////////////GAME VARIABLES
		String menuChoice;
		String userEntry;
		String situation="";
		String causeOfDeath=""; //display if user loses all lives
		int distanceFromEmpire;
		int randomSituation; 
		int randomKmWalked;
		int randomChallenge;
		int num; //random number generated throughout most games
		int livesRemaining=2; //You have 3 lives (2 backup lives or livesRemaining=2)
		int timesChallenged=0; //counter starting from 0 at beginning of each game
		
		//game 3 dedicated variables
		String randomText="";
		int randomTextSelection;
		
		//game 4 dedicated variables
		String fiveLetterDict=inDict.nextLine();
		String fiveLetterWord=""; 
		String anotherWord="";
		char character; 
		char isAlphabetical; 
		int vowelCount=0; 
		
		////////////HIGH SCORES VARIABLES
		//open file
		BufferedReader inScores=new BufferedReader(new FileReader("highscores.txt"));
		//VERY IMPORTANT - temporary store ScoresLog (full text from highscores.txt
		String Scores=inScores.readLine();
		//VERY IMPORTANT - define current high scores from temporary Scores
		String userName=""; //name of user (5 characters) will be inputted after game
		String hname1=Scores.substring(0,5);
		String hname2=Scores.substring(5,10);
		String hname3=Scores.substring(10,15);
		String hname4=Scores.substring(15,20);
		String hname5=Scores.substring(20,25);
		long startTime;
		long endTime;
		long score; //count time it takes + get final score after bonus lives
		String stringScore; //convert long into String for easier comparison to hscore(#)
		String hscore1=Scores.substring(25,28); //hscore(#) is string for easier display
		String hscore2=Scores.substring(28,31); 
		String hscore3=Scores.substring(31,34);
		String hscore4=Scores.substring(34,37);
		String hscore5=Scores.substring(37,40);
		inScores.close();
		//printwriter ONLY encloses Scores=... & out.write(Scores);
		//Skip to Line 478: PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("highscores.txt")));
	
		
		
		//user input to confirm quit or continue
		String quit; 
		
			//@@@@@@@@@@@@@@@@@@@@ Menu @@@@@@@@@@@@@@@@@@@@@@@@
		do { //used for continue & quit
			System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n	_______________________________________________\n");
			System.out.println("\n	 	  A D V E N T U R E L A N D");
			System.out.print("	_______________________________________________\n");
			System.out.println("\n			By: Henry Sun");
			System.out.println("\n			1 - PLAY");
			System.out.println("\n			2 - HOW TO PLAY");
			System.out.println("\n			3 - HIGH SCORES");
			System.out.println("\n			4 - QUIT GAME");
			System.out.println("\n\n\n	     9 - THE KING OF ADVENTURELAND IS...");
			System.out.println("\n	_______________________________________________");
			//select menu
			System.out.print("\n\nWhat would you like to do today? (1-4,9): ");
			menuChoice=in.next();
			
				//@@@@@@@@@@@@@@@@@@@@ Menu Choices @@@@@@@@@@@@@@@@@@@@@@@@
				
					//==============================PLAY GAME==========================================
			//reset variables
			timesChallenged=0;
			livesRemaining=2;
			
			if (menuChoice.equals("1")){ 
				
				//begin story
				distanceFromEmpire=(int)(Math.random()*6)+18; //random distance 18~23 km away from kingdom
				randomSituation=(int)(Math.random()*3)+1; //random situation that Ganon finds himself in
				switch (randomSituation){
					case 1: situation=", beat you up, and whipped you down."; break;
					case 2: situation=", tied you down, and fed you only with bread(untoasted)."; break;
					case 3: situation=" and shoved 18 mL of Robitussin Extra Strength into you.";
				}
				System.out.println("\n----------------------------------------------------------------");
				System.out.println("You, King Ganon, find yourself stranded "+distanceFromEmpire+" km away from Balrog Empire.\nYou recall that the bandits captured you"+situation+"\nYou must travel back to Queen Daisy to once again feel the warmth of her love that you once took for granted.\nTry not to die in the process. Good luck!");
				System.out.println("----------------------------------------------------------------\n");
				System.out.print("Input anything to continue: ");
				userEntry=in.next();
				//begin counting time after the little intro
				startTime=System.currentTimeMillis();
				while (distanceFromEmpire>0){ //journey to King Ganon's destination (includes walking and challenges)
				
					//WALK + DISTANCE FROM EMPIRE
					randomKmWalked=(int)(Math.random()*5)+1;
					distanceFromEmpire=distanceFromEmpire-randomKmWalked; //shows new distance from empire (after walking)
					if (distanceFromEmpire<=0){ 
						distanceFromEmpire=distanceFromEmpire+randomKmWalked; //brings distance back to remaining km (you can't say "3 km remaining, you walked 5 km, congratulations")
						System.out.println("\n----------------------------------------------------------------");
						System.out.println("You walked the remaining "+distanceFromEmpire+" km. You have reached Balrog Empire. Congratulations!"); //prepares to skip to score / conclusion
						distanceFromEmpire=0; //after displaying remaining distance, you reach destination
						System.out.println("----------------------------------------------------------------\n");
						System.out.print("Input anything to continue: ");
						userEntry=in.next();
						}
					else{
						System.out.println("\n----------------------------------------------------------------");
						System.out.println("You walked "+randomKmWalked+" km. You are now "+(distanceFromEmpire)+" km from the empire");
						System.out.println("----------------------------------------------------------------\n");
						System.out.print("Input anything to continue: ");
						userEntry=in.next();
						}
					//RANDOMLY PICK A POTENTIAL OBSTACLE
					randomChallenge=(int)(Math.random()*4)+1;
					//FIRST CHECK IF GANON REACHED DESTINATION (EMPIRE)
					if (distanceFromEmpire<=0)
						break; //after congratulations message, skip to score / conclusion

					//GAME ONE - length officers
					else if (randomChallenge==1){
						num=(int)(Math.random()*18)+10;
						System.out.println("\n----------------------------------------------------------------");
						System.out.println("OH NO! It's the length officers!\nEnter anything "+num+" characters long!");
						System.out.print("\nEntry: ");
						userEntry=in.next();
							if (userEntry.length()==num)
								System.out.println("\nPhew, it seems that we've evaded the length officers. That was a close call.");
							else {
								if (livesRemaining>0){
									System.out.println("\nSorry, that is incorrect. You lose a life.");
									livesRemaining--;
									}
								else{
									System.out.println("Sorry, YOU LOST YOUR FINAL LIFE.");
									System.out.print("\nInput anything to continue: ");
									userEntry=in.next();
									distanceFromEmpire=-1;
									causeOfDeath="being ambushed by the length officers.";
									break; //end story as you have died (lose all 3 lives)
									}
								}
						System.out.println("Reserve lives remaining: "+livesRemaining);
						System.out.println("----------------------------------------------------------------\n");
						System.out.print("Input anything to continue: ");
						userEntry=in.next();
						
						timesChallenged++;
					}
					
					//GAME TWO - Hardest Challenge
					else if(randomChallenge==2){
						System.out.println("\n----------------------------------------------------------------");
						System.out.println("PREPARE YOURSELF! HERE'S THE HARDEST CHALLENGE IN ALL OF ADVENTURELAND");
						System.out.println("TYPE THE ALPHABET BACKWARDS - this will cause the storm to leave.");
						System.out.print("\nEntry: ");
						userEntry=in.next();
						userEntry=userEntry.toLowerCase();
						if (userEntry.equals("zyxwvutsrqponmlkjihgfedcba"))
								System.out.println("\nNice! Your amazing command of the keyboard scared the storm off elsewhere.");
						else {
								if (livesRemaining>0){
									System.out.println("\nSorry, that is incorrect. You lose a life.");
									livesRemaining--;
									}
								else{
									System.out.println("Sorry, YOU LOST YOUR FINAL LIFE.");
									System.out.print("\nInput anything to continue: ");
									userEntry=in.next();
									distanceFromEmpire=-1;
									causeOfDeath="being torn up by an angry storm.";
									break; //end story as you have died (lose all 3 lives)
									}
								}
						System.out.println("----------------------------------------------------------------\n");
						System.out.print("Input anything to continue: ");
						userEntry=in.next();
						
						timesChallenged++;
					}

					//GAME THREE - Charismatic Character Checker
					else if(randomChallenge==3){
						num=(int)(Math.random()*9)+11;
						System.out.println("\n----------------------------------------------------------------");
						System.out.println("Uh oh, it's the Charismatic Character Checker!");
						System.out.println("What is the "+num+"th character of the following 25-character text?");
						System.out.println("WARNING: CASE-SENSITIVE");
						//make a random 25-character text
						randomTextSelection=(int)(Math.random()*3)+1;
						switch (randomTextSelection){
							case 1: randomText="SADjkh12jlsADJK/1ro3jasfd"; break;
							case 2: randomText="ALSKjd2iha(*29183598DS)[]"; break;
							case 3: randomText="%#80HenrySun%IsDaBest-/3*";
						}
						System.out.println(randomText);
						System.out.print("\nEntry: ");
						userEntry=in.next();
							if (userEntry.charAt(0)==(randomText.charAt(num-1))) //make userEntry primitive to compare with answer
								System.out.println("\nVery impressive indeed. It must've taken you a while to figure this one out.");
							else {
								if (livesRemaining>0){
									System.out.println("\nSorry, that is incorrect. You lose a life.");
									livesRemaining--;
									}
								else{
									System.out.println("Sorry, YOU LOST YOUR FINAL LIFE.");
									System.out.print("\nInput anything to continue: ");
									userEntry=in.next();
									distanceFromEmpire=-1;
									causeOfDeath="being overwhelmed by the\n Charismatic Character Checker.";
									break; //end story as you have died (lose all 3 lives)
									}
								}
						System.out.println("Reserve lives remaining: "+livesRemaining);
						System.out.println("----------------------------------------------------------------\n");
						System.out.print("Input anything to continue: ");
						userEntry=in.next();
						
						timesChallenged++;
					}
					
					//GAME FOUR - KING OF K(OMPAR)ING (very inefficient because I want to sleep and we're not getting marked on efficiency)
					else{
						vowelCount=0;
						num=(int)(Math.random()*8937)*6; //8938 words (5 chars+1 space=6 chars)
						fiveLetterWord=fiveLetterDict.substring(num,num+5);//READ A FIVE LETTER WORD FROM DICTIONARY
						num=(int)(Math.random()*8937)*6; //for another word
						anotherWord=fiveLetterDict.substring(num,num+5);
						System.out.println("\n----------------------------------------------------------------");
						System.out.println("You've been spotted by the King of K(ompar)ing. Brace yourself.");
						System.out.println("King of K(ompar)ing: HOW MANY VOWELS ARE IN THE WORD: "+fiveLetterWord+"?");
						for (int v=0; v<=4; v++){ //go through string from first index(0) to last index 
							character=fiveLetterWord.charAt(v); //character = index or (v) of vowelsInput
							if (character=='a'||character=='e'||character=='i'||character=='o'||character=='u'){
								vowelCount++;
								}
						}
						System.out.print("\nEntry (0-5): ");
						userEntry=in.next();
						while (!userEntry.equals("0")&&!userEntry.equals("1")&&!userEntry.equals("2")&&!userEntry.equals("3")&&!userEntry.equals("4")&&!userEntry.equals("5")){ // removes error from inputting signs or letters
							System.out.println("\nIncorrect choice, please enter a correct choice.");
							System.out.println("King of K(ompar)ing: HOW MANY VOWELS ARE IN THE WORD: "+fiveLetterWord+"?");
							System.out.print("Entry (0-5): ");
							userEntry=in.next();
						}
				
						
						if (Integer.parseInt(userEntry)==vowelCount){ //make comparable
							System.out.println("\nCongrats on beating the first round. Three more to go..");
							for (int i=0; i<3; i++){ //ALPHABETICAL SUB-GAME

								System.out.println("\n\nIs this in alphabetical order? "+fiveLetterWord+" then "+anotherWord);
								if (fiveLetterWord.compareTo(anotherWord)<0) //give computer answer
									isAlphabetical='y';
								else
									isAlphabetical='n';
								System.out.print("Entry (Y/N): ");
								userEntry=in.next();
								while (userEntry.charAt(0)!=('y')&&userEntry.charAt(0)!=('n')){ //only use if user inputs NOT y or n
										System.out.println("\nIncorrect choice, please enter a correct choice.");
										System.out.println("\n\nIs this in alphabetical order? "+fiveLetterWord+" then "+anotherWord);
										System.out.print("Entry (Y/N): ");
										userEntry=in.next();
									}
								
								if (userEntry.charAt(0)==isAlphabetical){ //if user is correct
									System.out.println("Good job");
									num=(int)(Math.random()*8937)*6;
									fiveLetterWord=fiveLetterDict.substring(num,num+5); //re-randomize
									num=(int)(Math.random()*8937)*6;
									anotherWord=fiveLetterDict.substring(num,num+5); //re-randomize
									}
								else{ //if you fail...
									if (livesRemaining>0){
										System.out.println("\nSorry, that is incorrect. You lose a life.");
										livesRemaining--; 
										System.out.println("Reserve lives remaining: "+livesRemaining);
										System.out.println("----------------------------------------------------------------\n");
										System.out.print("Input anything to continue: ");
										userEntry=in.next();
										break;
										}
									else{
										System.out.println("Sorry, YOU LOST YOUR FINAL LIFE.");
										System.out.print("\nInput anything to continue: ");
										userEntry=in.next();
										distanceFromEmpire=-1;
										causeOfDeath="being defeated by the King of K(ompar)ing.";
										break; //end story as you have died (lose all 3 lives)
									}
								}
							}
						}
						else {
							if (livesRemaining>0){ //only because previous LOST FINAL LIFE break; doesn't skip this
								System.out.println("\nSorry, that is incorrect. You lose a life.");
								livesRemaining--;
								System.out.println("Reserve lives remaining: "+livesRemaining);
								System.out.println("----------------------------------------------------------------\n");
								System.out.print("Input anything to continue: ");
								userEntry=in.next();
								
								timesChallenged++;
							}
							else{
								System.out.println("Sorry, YOU LOST YOUR FINAL LIFE.");
								System.out.print("\nInput anything to continue: ");
								userEntry=in.next();
								distanceFromEmpire=-1;
								causeOfDeath="being defeated by the King of K(ompar)ing.";
								break; //end story as you have died (lose all 3 lives)
							}
						}
					}


				} //repeat walk+challenges if Ganon is still on his journey back to Empire
				
				
				//////////END STORY & RECORD SCORE (from break;)
				if (distanceFromEmpire==0){
					//record score when distance is 0
					endTime=System.currentTimeMillis();
					score=(endTime-startTime)/1000;
					if (score-livesRemaining*5<Integer.parseInt(hscore1)){
					System.out.println("\n----------------------------------------------------------------");
					System.out.println("THE BEST(!!!!) ENDING: \n");
					System.out.println("GOOD JOB! You've easily conquered ("+timesChallenged+") challenges throughout your journey in ADVENTURELAND.\nA very special prize awaits you...");
					System.out.println("----------------------------------------------------------------\n");
					System.out.print("Input anything to continue: ");
					userEntry=in.next();
					}
					else{
					System.out.println("\n----------------------------------------------------------------");
					System.out.println("THE GOOD ENDING: \n");
					System.out.println("And so, Ganon struggled through countless challenges ("+timesChallenged+") along his journey and finally reached his destination.\nAs of today, King Ganon and Queen Daisy are peacefully living in the wonderful Balrog Empire.\nNow, King Ganon finally began to appreciate the Queen's company. ");
					System.out.println("----------------------------------------------------------------\n");
					System.out.print("Input anything to continue: ");
					userEntry=in.next();
					}
					//stores user score in HIGH SCORE format (3 digit)
					System.out.println("\n----------------------------------------------------------------");
					System.out.println("The time you took to complete the adventure is: "+score+" seconds");
					System.out.println("You have "+livesRemaining+" extra reserve lives remaining. Bonus: -"+livesRemaining*5+" seconds."); 
					System.out.println("Your final score is: "+(score-(livesRemaining*5)));
					System.out.println("----------------------------------------------------------------\n");
					score=score-(livesRemaining*5);
					stringScore=Long.toString(score);
					if (stringScore.length()<3){ //make sure score is 3 characters long!!!
						if (stringScore.length()==1){
							stringScore="00"+stringScore;
						}
						stringScore="0"+stringScore;
					}
					//determine whether to save in 1st, 2nd, 3rd, 4th or 5th row
					if (stringScore.compareTo(hscore5)<0){//if rank compared to highscores >5
						if (stringScore.compareTo(hscore4)<0){//if rank compared to highscores >4
							if (stringScore.compareTo(hscore3)<0){//if rank compared to highscores >3
								if (stringScore.compareTo(hscore2)<0){//if rank compared to highscores >2
									if (stringScore.compareTo(hscore1)<0){//if rank compared to highscores >1
										do{
											System.out.print("\nEnter your name (5 characters): ");
											userName=in.next();
										}while (userName.length()!=5);
										System.out.println("              .-=========-.");
										System.out.println("              \\'-=======-'/");
										System.out.println("              _|   .=.   |_");
										System.out.println("             ( |  { 1 }  | )");
										System.out.println("              \\|   /|\\   |/");
										System.out.println("               \\__ '`' __/");
										System.out.println("                 _`) (`_");
										System.out.println("               /__"+userName+"__\\"); //trophy to display as soon as user wins
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
											System.out.print("\nEnter your name (5 characters): ");
											userName=in.next();
										}while (userName.length()!=5);
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
										System.out.print("\nEnter your name (5 characters): ");
										userName=in.next();
									}while (userName.length()!=5);
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
									System.out.print("\nEnter your name (5 characters): ");
									userName=in.next();
								}while (userName.length()!=5);
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
								System.out.print("\nEnter your name (5 characters): ");
								userName=in.next();
							}while (userName.length()!=5);
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
							System.out.print("\nEnter your name (5 characters): ");
							userName=in.next();
						}while (userName.length()!=5);
						System.out.println("Sorry. You did not qualify for the highscores' top 5. Better luck next time");
						}
					PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("highscores.txt")));
					Scores=(hname1+hname2+hname3+hname4+hname5+hscore1+hscore2+hscore3+hscore4+hscore5);
					out.write(Scores); 
					out.close();
				}
				else{ //distance is set to -1 after death
					System.out.println("\n----------------------------------------------------------------");
					System.out.println("THE BAD ENDING: \n");
					System.out.println("In the end, the bandits were successful in their attempt to cause disharmony \nwithin Balrog Empire.");
					System.out.println("All over Balrog Empire, news had spread about Ganon's death from "+causeOfDeath);
					System.out.println("Knowing this, Queen Daisy said her good-byes to the Empire as well hoping to once again encounter Ganon...in Heaven.");
					System.out.println("To this date, Balrog Empire has been in Chaos and in desperate need of a reliable King.");
					System.out.print("\n\n			GAME OVER\n\n");
					System.out.println("----------------------------------------------------------------\n");
					}

					//CONTINUE?
				System.out.print("\n\n\nCONTINUE? (go back to main menu) (Y/N): ");
				quit=in.next();
				quit=quit.toLowerCase(); //makes it easier for if else
				while (menuChoice.equals("1")){ //menuChoice was originally inputted as 1 (to play game)
					if (quit.equals("y")){
						menuChoice="goback";
						}
					else if (quit.equals("n")){
						menuChoice="quit";
						}
					else{
						System.out.println("\nIncorrect choice, please enter a correct choice.");
						System.out.print("CONTINUE? (go back to main menu) (Y/N): ");
						quit=in.next();
						quit=quit.toLowerCase();
						//menuChoice=1 is maintained
					}
				}
			}
			
					//=============================HOW TO PLAY=======================================
			else if (menuChoice.equals("2")){ 
				System.out.println("\n--------------------------HOW TO PLAY---------------------------\n");
				System.out.println("ADVENTURELAND is a single-player adventure game where a brave King Ganon is captured by the \nbandits of Balrog Empire and is left stranded in the middle of nowhere. \nGanon must travel far and wide to find and reunite with his beautiful Queen Daisy.");
				System.out.println("The player must be ready for constant challenges that require word knowledge and common sense.");
				System.out.println("Are you ready for ADVENTURELAND? Prepare for the ADVENTURE of a LIFETIME...");
				System.out.println("\nThe RULES: ");
				System.out.println("When prompted to enter a word, only the first word entered is taken by computer.");
				System.out.println("\nThe SCORING: ");
				System.out.println("Your score is determined by how fast you complete the adventure as well as your remaining lives.");
				System.out.println("Each extra life remaining reduces your score by 5 seconds.");
				System.out.println("The lower your score, the higher you will be on the high scores list.");
				System.out.println("NOTE: If two high scores are tied, whoever got it first will be higher on the list.");
				System.out.println("\nThat's all."); 
				System.out.println("\n\nGOOD LUCK AND ENJOY THE ADVENTURE!!!");
				System.out.println("\n----------------------------------------------------------------\n");
				System.out.print("Input anything to continue: ");
				userEntry=in.next();
				menuChoice="goback";
			}
			else if (menuChoice.equals("3")){
				//display 3 digit score newScore.substring(newScore.length()-3); //display 3 digit score
				System.out.println("\n\n---------TOP 5 HIGH SCORES---------\n\n");
				System.out.println("    POSITION      PLAYER       TIME");
				////i realize i could have just typed instead of using .format (-.-)
				System.out.println(" -----------------------------------"); //high scores top enclosure
				System.out.format("%15s %-5s %-2s %3s %-3s %-3s ", "|   1st  Place   |", hname1, "|", "|", hscore1, "|");
				System.out.println("\n -----------------------------------");
				
				System.out.format("%15s %-5s %-2s %3s %-3s %-3s ", "|   2nd  Place   |", hname2, "|", "|", hscore2, "|");
				System.out.println("\n -----------------------------------");
				
				System.out.format("%15s %-5s %-2s %3s %-3s %-3s ", "|   3rd  Place   |", hname3, "|", "|", hscore3, "|");
				System.out.println("\n -----------------------------------");
				
				System.out.format("%15s %-5s %-2s %3s %-3s %-3s ", "|   4th  Place   |", hname4, "|", "|", hscore4, "|");
				System.out.println("\n -----------------------------------");
				
				System.out.format("%15s %-5s %-2s %3s %-3s %-3s ", "|   5th  Place   |", hname5, "|", "|", hscore5, "|");
				System.out.println("\n -----------------------------------"); //high scores bottom enclosure
				
				System.out.print("\n\nInput anything to continue: ");
				userEntry=in.next();
				menuChoice="goback";
			}
					
					//=============================QUIT GAME=======================================
			else if (menuChoice.equals("4")){ 
				System.out.print("\nAre you sure you want to quit? (Y/N): ");
				quit=in.next();
				quit=quit.toLowerCase(); //makes it easier for if else
								
				while (menuChoice.equals("4")){ //menuChoice was originally inputted as 4 (to select quit)
				if (quit.equals("y")){
					System.exit(0);
					}
				else if (quit.equals("n"))
					menuChoice="goback";
				else{
					System.out.println("\nIncorrect choice, please enter a correct choice.");
					System.out.print("Are you sure you want to quit? (Y/N): ");
					quit=in.next();
					quit=quit.toLowerCase();
					}
				}
			}
					//=============================KING OF ADVENTURELAND=======================================
			else if (menuChoice.equals("9")){
				System.out.println("\n\n                   .-=========-.");
				System.out.println("                   \\'-=======-'/");
				System.out.println("                   _|   .=.   |_");
				System.out.println("                  ( |  { 1 }  | )");
				System.out.println("                   \\|   /|\\   |/");
				System.out.println("                    \\__ '`' __/");
				System.out.println("                      _`) (`_");
				System.out.println("                    /__"+hname1+"__\\"); 
				System.out.println("                   /__KING OF__\\");	//the display (menuChoice=9) trophy is hname1
				System.out.println("                  /ADVENTURELAND\\");
				System.out.println("                 /_______________\\\n\n");
				System.out.print("Input anything to continue: ");
				userEntry=in.next();
				menuChoice="goback";
			}
			else 
				menuChoice="goback";

			//allow only 1-4
		} while (menuChoice.equals("goback")); //return menu if correct choice not chosen
}}
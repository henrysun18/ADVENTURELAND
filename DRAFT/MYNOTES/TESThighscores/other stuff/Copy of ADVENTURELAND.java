import java.util.Scanner;
import java.io.*;

class highscoretest{
	public static void main(String[]args)throws Exception{
	
		//set scanner
		Scanner in=new Scanner(System.in);
		Scanner inFile = new Scanner(new File("5letterwords.txt"));      // to read from file
		
		//declare variables
		String menuChoice;
		String userEntry;
		int distanceFromEmpire;
		int randomSituation; 
		int randomKmWalked;
		int randomChallenge;
		int num; //random number generated mid-game
		int livesRemaining=2; //You have 3 lives (2 backup lives or livesRemaining=2)
		String causeOfDeath=""; //display if user loses all lives
		int timesChallenged=0;
		int randomTextSelection;//game 3
		String randomText=""; //game 3
		String fiveLetterDict=inFile.nextLine();
		String fiveLetterWord=""; //game 4
		String anotherWord=""; //game 4
		char character; //game 4
		int vowelCount=0; //game 4
		int isAlphabetical; //game 4
		String situation="";
		String challenge;
		
		//user input to confirm quit or continue
		String quit; 
		
		//HIGHSCORES top 5
		//create file
		FileWriter highscores = new FileWriter("highscores.txt");
		BufferedWriter out = new BufferedWriter(highscores);
		//variables for high scores
		String userName="";
		String stringScore; //convert long into String for easier display
		String hname1="___";
		String hname2="___";
		String hname3="___";
		String hname4="___";
		String hname5="___";
		String hscore1="___"; //hscore must be long as it comes from measuring TimeMillis
		String hscore2="___";
		String hscore3="___";
		String hscore4="___";
		String hscore5="___";
        	
		
			//@@@@@@@@@@@@@@@@@@@@ Menu @@@@@@@@@@@@@@@@@@@@@@@@
		do {
			System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n	________________________________\n");
			System.out.println("\n		ADVENTURELAND");
			System.out.println("\n\n\nCHECK THE FORMATTING AND MAKE SURE SENTENCES DONT GET CUT OFF\n\n\n");
			System.out.println("		By: Henry Sun");
			System.out.println("\n		1 - PLAY");
			System.out.println("\n		2 - HOW TO PLAY");
			System.out.println("\n		3 - HIGH SCORES");
			System.out.println("\n		4 - QUIT GAME");
			System.out.println("\n	________________________________");
			//select menu
			System.out.print("\n\nWhat would you like to do today? (choice 1-4): ");
			menuChoice=in.next();
			
				//@@@@@@@@@@@@@@@@@@@@ Menu Choices @@@@@@@@@@@@@@@@@@@@@@@@
				
					//==============================PLAY GAME==========================================
			//reset variables
			timesChallenged=0;
			livesRemaining=2;
			
			//Begin Story
			if (menuChoice.equals("1")){ 
				long startTime=System.currentTimeMillis();
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
					
					//GAME TWO
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
									causeOfDeath="being torn up by a tornado.";
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
									causeOfDeath="being overwhelmed by the Charismatic Character Checker.";
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
						System.out.print("\nEntry: ");
						userEntry=in.next();
						if (Integer.parseInt(userEntry)==vowelCount){ //make comparable
							System.out.println("\nCongrats on beating the first round. Three more to go..");
							for (int i=0; i<3; i++){ //ALPHABETICAL SUB-GAME
								System.out.println("\n\nIs this in alphabetical order? "+fiveLetterWord+" then "+anotherWord);
								if (fiveLetterWord.compareTo(anotherWord)<0) //give computer answer
									isAlphabetical=1;
								else
									isAlphabetical=0;
									
								System.out.print("\nEntry: ");
								userEntry=in.next();
								if (Integer.parseInt(userEntry)==isAlphabetical){ //if user is correct
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
						else 
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


				} //repeat walk+challenges if Ganon is still on his journey back to Empire
				
				
				//END STORY & RECORD SCORE (from break;)
				if (distanceFromEmpire==0){
					//record score when distance is 0
					long endTime=System.currentTimeMillis();
					long score=(endTime-startTime)/1000;
					System.out.println("\n----------------------------------------------------------------");
					System.out.println("THE GOOD ENDING: \n");
					System.out.println("And so, Ganon struggled through countless challenges ("+timesChallenged+") along his journey and finally reached his destination.\nAs of today, King Ganon and Queen Daisy are peacefully living in the wonderful Balrog Empire.\nNow, King Ganon finally began to appreciate the Queen's company. ");
					System.out.println("----------------------------------------------------------------\n");
					System.out.print("Input anything to continue: ");
					userEntry=in.next();
					
					//stores user score in HIGH SCORE format (3 digit)
					System.out.println("\n----------------------------------------------------------------");
					System.out.println("The time you took to complete the adventure is: "+score+" seconds");
					System.out.println("You have "+livesRemaining+" extra reserve lives remaining. Bonus: -"+livesRemaining*5+" seconds."); 
					System.out.println("Your final score is: "+(score-(livesRemaining*5)));
					System.out.println("----------------------------------------------------------------\n");
					score=score-(livesRemaining*5);
					stringScore=""+score; //easier storage of high scores (3 digit format)
					//check if score belongs in top 5
					if (stringScore.compareTo(hscore1)<0)
						System.out.println("Good job, you're in first place.");
						System.out.print("Enter your name (three characters): ");
						userName=in.next();
						while (userName.length()!=3){
							System.out.print("\n\nYour name must be three characters: ");
							userName=in.next();
						}
						out.write(userName+" "+stringScore);
						out.close();
					}
				else{ //distance is set to -1 after death
					System.out.println("\n----------------------------------------------------------------");
					System.out.println("THE BAD ENDING: \n");
					System.out.println("In the end, the bandits proved successful in their attempt to cause disharmony within Balrog Empire.");
					System.out.println("All over Balrog Empire, there's been news about Ganon's death from "+causeOfDeath);
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
			
					//=============================HOW TO PLAY *=======================================
			else if (menuChoice.equals("2")){ 
				System.out.println("\n--------------------------HOW TO PLAY---------------------------\n");
				System.out.println("ADVENTURELAND is a single-player adventure game where a brave King Ganon is captured by the \nbandits of Balrog Empire and is left stranded in the middle of nowhere. \nGanon must travel far and wide to find and reunite with his beautiful Queen Daisy.");
				System.out.println("The player must be ready for constant challenges that require word knowledge, common sense and logic.");
				System.out.println("Are you ready for ADVENTURELAND? Prepare for the ADVENTURE of a LIFETIME...");
				System.out.println("\nThe RULES: ");
				System.out.println("When prompted to enter a word, only the first word entered is taken by computer.");
				System.out.println("The SCORING: ");
				System.out.println("Your score is determined by how fast you complete the adventure as well as the lives you have remaining.");
				System.out.println("Each extra life remaining reduces your score by 5 seconds");
				System.out.println("The lower your score, the higher you will be on the high scores list.");
				System.out.println("That's all."); 
				System.out.println("GOOD LUCK AND ENJOY THE ADVENTURE!!!");
				System.out.println("\n----------------------------------------------------------------\n");
				System.out.print("Input anything to continue: ");
				userEntry=in.next();
				menuChoice="goback";
			}
			
					//=============================HIGH SCORES *=======================================
			else if (menuChoice.equals("3")){ 
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
			
					//=============================QUIT GAME **=======================================
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
			
			else 
				menuChoice="goback";

			//allow only 1-4
		} while (menuChoice.equals("goback")); //return menu if correct choice not chosen
		
}}
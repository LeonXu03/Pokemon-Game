package finalProject;
import java.util.Scanner;
import java.io.*;
public class FinalProjectGUI {

	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		//Declaring Variables
		int round = 1; //round number
		boolean itemphase = false; //item selection screen check. If this is true, move on to item selection phase 
		boolean selectionphase = false; //pokemon selection screen check. If this is true, move on to pokemon selection phase
		boolean valid1 = false; //check if first pokemon entry by user is valid 
		boolean valid2 = false; //check if second pokemon entry by user is valid 
		boolean valid3 = false; //check if third pokemon entry by user is valid 
		boolean itemvalid1 = false; //check if first user selected item is valid 
		boolean itemvalid2 = false; //check if second user selected item is valid 
		boolean itemvalid3 = false;//check if third user selected item is valid 
		int itemselection1 = -5; //what is the index of the item selected by the user
		int itemselection2 = -5; //what is the index of the item selected by the user
		int itemselection3 = -5; //what is the index of the item selected by the user
		int userchoice1 = -5; //what first pokemon is selected by the user
		int userchoice2 = -5; //what second pokemon is selected by the user
		int userchoice3 = -5;//what third pokemon is selected by the user
		String [] stats = new String [10]; //Reference stats for all 10 Pokemon
		String [] Pokemon_user_stats = new String [3]; //Stats for what 3 Pokemon the user selected
		String [] stats_computer = new String [3]; //Stats for what 3 Pokemon the computer randomly selected
		String [] Pokemon = new String [10]; //All Pokemon names and type for 10 Pokemon 
		String [] Pokemon_user = new String [3]; //Pokemon names and types for 3 Pokemon the user selected
		String [] Pokemon_computer = new String [3]; //Pokemon names and types for 3 Pokemon the computer randomly selected
		String [] moves = new String [10]; //moves for all 10 Pokemon
		String [] moves_user = new String [3]; //moves for 3 Pokemon user selected
		String [] moves_computer = new String [3]; //moves for 3 pokemon computer selected
		String [] move_type = new String [10]; //All 10 Pokemon move types
		String [] move_type_user = new String [3]; //Move types for 3 Pokemon user selected
		String [] moves_type_computer = new String [3]; //move types for 3 pokemon computer selected
		String [] moves_dmg = new String [10]; //damage of moves for all 10 Pokemon
		String [] moves_dmg_user = new String [3]; //damage of moves for 3 Pokemon user selected
		String [] moves_dmg_computer = new String [3]; //damage of moves for 3 pokemon the computer randomly selected
		String [] moves_accuracy = new String [10]; //moves accuracy for all 10 Pokemon
		String [] moves_accuracy_user = new String [3]; //moves accuracy for 3 user selected Pokemon
		String [] moves_accuracy_computer = new String [3]; //moves accuracy for 3 computer selected pokemon
		String [] items = new String [5]; //Names of all 5 items that can be selected
		String [] items_user = new String [3]; //Name of 3 items that the user selected
		String [] items_computer = new String [3]; //Name of 3 items that the computer randomly selected
		int [] status_user = {0,0,0};
		int [] status_computer = {0,0,0};
		int [] aliveordeaduser = {1,1,1};
		int [] aliveordeadcomputer = {1,1,1};

		//Stats for Pokemon ("HP, attack, defense, Sp. attack, Sp. def, speed")
		stats[0] = "266,155,144,200,157,184"; //Charizard
		stats[1] = "270,152,153,184,184,148"; //Venusaur
		stats[2] = "268,153,184,157,193,144"; //Blastoise
		stats[3] = "430,202,121,121,202,58"; //Snorlax
		stats[4] = "230,121,112,238,139,202"; //Gengar
		stats[5] = "250,202,130,211,130,166"; //Lucario
		stats[6] = "326,238,175,148,157,188"; //Garchomp
		stats[7] = "292,245,175,184,184,150"; //Dragonite
		stats[8] = "220,94,85,247,175,220"; //Alakazam
		stats[9] = "270,247,238,175,166,130"; //Metagross

		//Names and type(s) for all 10 Pokemon
		Pokemon[0] = "Charizard,fire,flying"; 
		Pokemon[1] = "Venusaur,grass,poison";
		Pokemon[2] = "Blastoise,water";
		Pokemon[3] = "Snorlax,normal";
		Pokemon[4] = "Gengar,poison,ghost";
		Pokemon[5] = "Lucario,fighting,steel";
		Pokemon[6] = "Garchomp,dragon,ground";
		Pokemon[7] = "Dragonite,dragon,flying";
		Pokemon[8] = "Alakazam,psychic";
		Pokemon[9] = "Metagross,steel,psychic";

		//Move types for all 10 Pokemon
		move_type[0] = "ground,fire,dark,fighting";
		move_type[1] = "normal,grass,poison,fire";
		move_type[2] = "water,dragon,normal,ice";
		move_type[3] = "normal,normal,normal,dark";
		move_type[4] = "ghost,grass,electric,psychic";
		move_type[5] = "fighting,psychic,steel,dark";
		move_type[6] = "ground,rock,dragon,normal";
		move_type[7] = "dragon,water,ground,dragon";
		move_type[8] = "grass,psychic,ghost,fire";
		move_type[9] = "steel,ground,psychic,ice";


		//Moves for all 10 Pokemon
		moves[0] = "Earthquake,Fire Punch,Crunch,Brick Break";
		moves[1] = "Growth,Solarbeam,Sludge Bomb,Hidden Power[Fire]";
		moves[2] = "Scald,Dragon Tail,Rapid Spin,Ice Beam";
		moves[3] = "Double-Edge,Rest,Sleep Talk,Crunch";
		moves[4] = "Shadow Ball,Energy Ball,Thunderbolt,Psychic";
		moves[5] = "Aura Sphere,Calm Mind,Flash Cannon,Dark Pulse";
		moves[6] = "Earthquake,Stone Edge,Outrage,Sword Dance";
		moves[7] = "Dragon Claw,Waterfall,Earthquake,Dragon Dance";
		moves[8] = "Energy Ball,Psyshock,Shadow Ball,Hidden Power[Fire]";
		moves[9] = "Bullet Punch,Earthquake,Zen Headbutt,Ice Punch";

		//Accuracy of all 10 Pokemons' moves
		moves_accuracy[0] = "100,100,100,100";
		moves_accuracy[1] = "0,100,100,100";
		moves_accuracy[2] = "100,90,100,100";
		moves_accuracy[3] = "100,100,100,100";
		moves_accuracy[4] = "100,100,100,100";
		moves_accuracy[5] = "100,100,100,100";
		moves_accuracy[6] = "100,80,100,100";
		moves_accuracy[7] = "100,100,100,100";
		moves_accuracy[8] = "100,100,100,100";
		moves_accuracy[9] = "100,100,90,100";

		//Damage values for all 10 Pokemons' moves
		moves_dmg[0] = "100,75,80,75";
		moves_dmg[1] = "0,120,90,60";
		moves_dmg[2] = "80,60,50,90";
		moves_dmg[3] = "120,0,85,80";
		moves_dmg[4] = "80,90,90,90";
		moves_dmg[5] = "80,0,80,80";
		moves_dmg[6] = "100,100,120,0";
		moves_dmg[7] = "80,80,100,0";
		moves_dmg[8] = "90,80,80,60";
		moves_dmg[9] = "40,100,80,75";

		//Item names for all 5 Pokemon items
		items[0] = "Potion";
		items[1] = "Awakening";
		items[2] = "Ice Heal";
		items[3] = "Parlyz Heal";
		items[4] = "Burn Heal";

		//Display welcome and instructions messages
		System.out.println("Welcome to the Pokemon Game!" + "\n\nInstructions ");
		System.out.println(" 1.) The User will select three Pokemon");
		System.out.println(" 2.) The Computer will select three Pokemon");
		System.out.println(" 3.) Each Pokemon has special stats and moves that can be beneficial or determental to your battle depending on you and your opponent's Pokemon type");
		System.out.println(" 4.) The User will select three consumable items");
		System.out.println(" 5.) The Computer will select three consumable items");
		System.out.println(" 6.) Consumbles can be used to heal or remove status effects on Pokemon");
		System.out.println(" 7.) Duplicate items and Pokemon are allowed");
		System.out.println(" 8.) The battle phase starts!");
		System.out.println(" 9.) The User and Computer will choose to either attack using moves or heal using consumables each round");
		System.out.println("10.) If a Pokemon's health reaches 0, they faint and cannot be used again");
		System.out.println("11.) The player who loses all three  of their Pokemon lose the battle");
		System.out.println("12.) Player scores are recorded in the end and the overall high score on the computer is displayed");
		System.out.println("13.) Duplicate items and Pokemon are allowed");

		/*
		 * Stats Selection Screen Coding
		 */
		//while loop keeps the user locked in as long as the User wants to look at Pokemon stats or enters an invalid answer
		while(selectionphase==false) {//condition to move on to next screen (pokemon selection screen)
			System.out.println("\nWould you like to look at the stats of each Pokemon? (yes/no) ");
			String check = input.next(); 
			if(check.equals("yes")) {//if user says yes to looking at Pokemon stats
				statsDisplay(stats,Pokemon,moves,move_type,moves_dmg,moves_accuracy); //Method call with actual parameters. Used to display all Pokemon stats, moves, types, etc.
			}
			else if(check.equals("no")) {//if user says no they move on to next screen
				selectionphase=true; 
			}
			else { //if the answer is invalid restart the loop
				System.out.println("Enter a valid answer");
			}
		}

		/*
		 * Pokemon selection screen coding
		 */
		System.out.println("Pokemon Selection Time!");
		while(itemphase==false) { //Loop that locks the User in as long as the User enters an invalid answer or doesn't confirm their selection
			System.out.println();
			System.out.format("%-10s %8s", "Pokemon", "Selection Number");
			System.out.println();
			//Print and isolates all of the 10 Pokemon's names in the Pokemon array. Prints out Pokemon names and index number
			for(int i = 0; i<Pokemon.length; i++) {
				String PokemonLine = Pokemon[i]; //Puts the line of data into a variable
				String PokemonName = PokemonLine.split(",")[0]; //Isolates for Pokemon name in line
				System.out.format("%-10s %8s", PokemonName, i);  //Prints out Pokemon name and selection number
				System.out.println();
			}
			System.out.println("Choose 3 Pokemon!");
			//Asks the user for their three Pokemon choices
			while(valid1==false) { //loop used to lock user if they enter invalid number for selection 1
				System.out.print("First Choice: "); //asks user for first selection
				userchoice1 = input.nextInt(); 
				if(userchoice1>=0 && userchoice1<=9) { //if the user selection is valid, while loop exits
					valid1=true;
				}
				else {
					System.out.println("Enter a valid entry!"); //if the entry is not valid, displays appropriate message and while loop repeats
				}
			}
			while(valid2==false) { //loop used to lock user if they enter invalid number for selection 2
				System.out.print("Second Choice: "); //asks user for second selection
				userchoice2 = input.nextInt(); 
				if(userchoice2>=0 && userchoice2<=9) { //if the user selection is valid, while loop exits
					valid2=true;
				}
				else {
					System.out.println("Enter a valid entry!"); //if the entry is not valid, displays appropriate message and while loop repeats
				}
			}
			while(valid3==false) { //loop used to lock user if they enter invalid number for selection 3
				System.out.print("Third Choice: "); //asks user for third selection
				userchoice3 = input.nextInt(); 
				if(userchoice3>=0 && userchoice3<=9) { //if the user selection is valid, while loop exits
					valid3=true;
				}
				else {
					System.out.println("Enter a valid entry!"); //if the entry is not valid, displays appropriate message and while loop repeats
				}
			}
			//Assigns all the stats, moves, data, etc to the User's unique array. Depends on their Pokemon selection.
			for(int i = 0; i<3; i++) {
				if(i==0) {
					Pokemon_user[i] = Pokemon[userchoice1];
					moves_user[i] = moves[userchoice1];
					move_type_user[i] = move_type[userchoice1];
					moves_dmg_user [i] = moves_dmg[userchoice1];
					moves_accuracy_user[i] = moves_accuracy[userchoice1];
					Pokemon_user_stats[i] = stats[userchoice1];
				}
				if(i==1) {
					Pokemon_user[i] = Pokemon[userchoice2];
					moves_user[i] = moves[userchoice2];
					move_type_user[i] = move_type[userchoice2];
					moves_dmg_user [i] = moves_dmg[userchoice2];
					moves_accuracy_user[i] = moves_accuracy[userchoice2];
					Pokemon_user_stats[i] = stats[userchoice2];
				}
				if(i==2) {
					Pokemon_user[i] = Pokemon[userchoice3];
					moves_user[i] = moves[userchoice3];
					move_type_user[i] = move_type[userchoice3];
					moves_dmg_user [i] = moves_dmg[userchoice3];
					moves_accuracy_user[i] = moves_accuracy[userchoice3];
					Pokemon_user_stats[i] = stats[userchoice3];
				}
			}
			//Using random number generation, 3 Pokemon will be selected for the Computer. 
			int computerselection1 = (int)(Math.random()*(9-0+1)+0);
			int computerselection2 = (int)(Math.random()*(9-0+1)+0);
			int computerselection3 = (int)(Math.random()*(9-0+1)+0);
			//Stats, moves, move types, etc. will be assigned to the Computer's unique arrays.
			for(int i = 0; i<3; i++) {
				if(i==0) {
					stats_computer[i] = stats[computerselection1];
					Pokemon_computer[i] = Pokemon[computerselection1];
					moves_computer[i] = moves[computerselection1];
					moves_type_computer[i] = move_type[computerselection1];
					moves_dmg_computer[i] = moves_dmg[computerselection1];
					moves_accuracy_computer[i] = moves_accuracy[computerselection1];
				}
				if(i==1) {
					stats_computer[i] = stats[computerselection2];
					Pokemon_computer[i] = Pokemon[computerselection2];
					moves_computer[i] = moves[computerselection2];
					moves_type_computer[i] = move_type[computerselection2];
					moves_dmg_computer[i] = moves_dmg[computerselection2];
					moves_accuracy_computer[i] = moves_accuracy[computerselection2];
				}
				if(i==2) {
					stats_computer[i] = stats[computerselection3];
					Pokemon_computer[i] = Pokemon[computerselection3];
					moves_computer[i] = moves[computerselection3];
					moves_type_computer[i] = move_type[computerselection3];
					moves_dmg_computer[i] = moves_dmg[computerselection3];
					moves_accuracy_computer[i] = moves_accuracy[computerselection3];
				}
			}
			//Displays 3 Pokemon selected by User
			System.out.println();
			System.out.println("First Pokemon Selected: " + Pokemon_user[0].split(",")[0]);
			System.out.println("Second Pokemon Selected: " + Pokemon_user[1].split(",")[0]);
			System.out.println("Third Pokemon Selected: " + Pokemon_user[2].split(",")[0]);
			System.out.println();
			System.out.print("Confirm Selection? (yes/no) "); //Asks user to finalize their choice
			String selectionconfirmation = input.next();
			//if statements that determine whether or not the next screen, "itemphase", should be entered. If the User answers yes, item selection begins. Otherwise, repeat Pokemon selection menu.
			if(selectionconfirmation.equals("yes")) { //if the user writes yes, next screen will happen
				itemphase = true;
			}
			else if(selectionconfirmation.equals("no")) { //if the user writes no, repeat Pokemon selection screen
				itemphase = false;
				valid1=false;
				valid2=false;
				valid3=false;
			}
			else { //if the user gives an invalid answer, display appropriate message and repeat Pokemon selection screen
				System.out.println("Enter a valid answer!");
				itemphase = false;
				valid1=false;
				valid2=false;
				valid3=false;
			}
		}//itemphase loop bracket

		/*
		 * Consumble items selection screen
		 */
		System.out.println("\nSelect three consumables from the list below");
		for(int i = 0; i<items.length; i++) { //For loop used to display all the item names and index numbers
			if(i!=3) {
				System.out.format(" %-10s %10s",items[i],i); //prints out item names and indexes
				System.out.println();
			}
			else {
				System.out.format("%-10s %10s",items[i],i); //special display for Paralyz Heal because it is longer than the other items
				System.out.println();
			}
		}
		System.out.println();
		while(itemvalid1==false) { //while loop locks the user in until they enter a valid answer
			System.out.print("First Selection: "); //ask user for first item selection
			itemselection1 = input.nextInt();
			if(itemselection1>=0 && itemselection1<=4) { //if the user enters a valid answer, while loop breaks
				itemvalid1=true;
			}
		}
		while(itemvalid2==false) { //while loop locks the user in until they enter a valid answer
			System.out.print("Second Selection: "); //ask user for first item selection
			itemselection2 = input.nextInt();
			if(itemselection2>=0 && itemselection2<=4) { //if the user enters a valid answer, while loop breaks
				itemvalid2=true;
			}
		}
		while(itemvalid3==false) { //while loop locks the user in until they enter a valid answer
			System.out.print("Third Selection: "); //ask user for first item selection
			itemselection3 = input.nextInt();
			if(itemselection3>=0 && itemselection3<=4) { //if the user enters a valid answer, while loop breaks
				itemvalid3=true;
			}
		}
		//Assigns user selections to their unique array
		items_user[0] = items[itemselection1] + ",ready";
		items_user[1] = items[itemselection2] + ",ready";
		items_user[2] = items[itemselection3] + ",ready";
		//Randomly generates a number between 0 and 4. Acts as the Computer's random selection 
		int itemselectioncomputer1 = (int)(Math.random()*(4-0+1)+0);
		int itemselectioncomputer2 = (int)(Math.random()*(4-0+1)+0);
		int itemselectioncomputer3 = (int)(Math.random()*(4-0+1)+0);
		//Assigns computer selection to unique array
		items_computer[0] = items[itemselectioncomputer1] + ",ready";
		items_computer[1] = items[itemselectioncomputer2] + ",ready";
		items_computer[2] = items[itemselectioncomputer3] + ",ready";

		/*
		 * Battlephase coding
		 */
		int activeindexuser = 0;
		int activeindexcomputer = 0;
		int [] uses = {0}; //item uses
		int [] uses_computer = {0}; //item uses
		boolean userlose = false;
		boolean computerlose = false;
		while(userlose==false && computerlose==false) {
			boolean messagecomputer = false;
			String active_pokemon_computer = "test";
			String active_pokemon_user = "test";
			//Prints out the Pokemon that the user selected
			System.out.println("\nUser Pokemon: " + Pokemon_user[0].split(",")[0] + " " + Pokemon_user[1].split(",")[0] + " " + Pokemon_user[2].split(",")[0]);
			//Prints out the Pokemon that the computer selected
			System.out.println("Computer Pokemon: " + Pokemon_computer[0].split(",")[0] + " " + Pokemon_computer[1].split(",")[0] + " " + Pokemon_computer[2].split(",")[0]);
			//If statement for if the first Pokemon for the computer has two types or not. Sets String active_pokemon_computer accordingly.
			if(Pokemon_computer[activeindexcomputer].split(",")[0].equals("Charizard")||Pokemon_computer[activeindexcomputer].split(",")[0].equals("Venusaur")||Pokemon_computer[activeindexcomputer].split(",")[0].equals("Gengar")||Pokemon_computer[activeindexcomputer].split(",")[0].equals("Lucario")||Pokemon_computer[activeindexcomputer].split(",")[0].equals("Garchomp")||Pokemon_computer[activeindexcomputer].split(",")[0].equals("Dragonite")||Pokemon_computer[activeindexcomputer].split(",")[0].equals("Metagross")) {
				active_pokemon_computer = Pokemon_computer[activeindexcomputer].split(",")[0] + "," + stats_computer[activeindexcomputer].split(",")[0] + "," + Pokemon_computer[activeindexcomputer].split(",")[1] + " " +  Pokemon_computer[activeindexcomputer].split(",")[2];
			}
			else {
				active_pokemon_computer = Pokemon_computer[activeindexcomputer].split(",")[0] + "," + stats_computer[activeindexcomputer].split(",")[0] + "," + Pokemon_computer[activeindexcomputer].split(",")[1];
			}
			//If statment or if the first Pokemon of the User has two types or not. Sets String active_pokemon_user accordingly.
			if(Pokemon_user[activeindexuser].split(",")[0].equals("Charizard")||Pokemon_user[activeindexuser].split(",")[0].equals("Venusaur")||Pokemon_user[activeindexuser].split(",")[0].equals("Gengar")||Pokemon_user[activeindexuser].split(",")[0].equals("Lucario")||Pokemon_user[activeindexuser].split(",")[0].equals("Garchomp")||Pokemon_user[activeindexuser].split(",")[0].equals("Dragonite")||Pokemon_user[activeindexuser].split(",")[0].equals("Metagross")) {
				active_pokemon_user = Pokemon_user[activeindexuser].split(",")[0] + "," + Pokemon_user_stats[activeindexuser].split(",")[0] + "," + Pokemon_user[activeindexuser].split(",")[1] + " " + Pokemon_user[activeindexuser].split(",")[2];
			}
			else {
				active_pokemon_user = Pokemon_user[activeindexuser].split(",")[0] + "," + Pokemon_user_stats[activeindexuser].split(",")[0] + "," + Pokemon_user[activeindexuser].split(",")[1];
			}
			battleScreen(active_pokemon_user,active_pokemon_computer,round,status_user,status_computer,activeindexuser,activeindexcomputer); //method call, actual parameters
			activeindexuser=battle(Pokemon_user,Pokemon_computer,Pokemon_user_stats,stats_computer,moves_user,moves_computer,move_type_user,moves_type_computer,moves_dmg_user,moves_dmg_computer,moves_accuracy_user,moves_accuracy_computer,activeindexuser,activeindexcomputer,items_user,items_computer, uses, status_user, status_computer,aliveordeaduser);
			if(Integer.parseInt(Pokemon_user_stats[activeindexuser].split(",")[0])<=0) {
				aliveordeaduser[activeindexuser] = 0;
				if(aliveordeaduser[0]==1 || aliveordeaduser[1]==1 || aliveordeaduser[1]==1) {
					System.out.println("Your Pokemon has fained! Switch with: ");
					for(int x = 0; x<3; x++) {
						if(x==activeindexuser) {	
						}
						else if(aliveordeaduser[x]==0) {
						}
						else if(aliveordeaduser[x]==1){
							System.out.format("%-10s %8s", Pokemon_user[x].split(",")[0],x);
							System.out.println();
						}
					}
					System.out.print("Enter choice: ");
					activeindexuser = input.nextInt();
					System.out.println();
					if(aliveordeaduser[0]==1 || aliveordeaduser[1]==1 || aliveordeaduser[2]==1) {
						while(aliveordeaduser[activeindexuser]==0) {
							System.out.print("Enter a valid choice: ");
							activeindexuser = input.nextInt();
							System.out.println();
						}
					}
				}
				else {
					System.out.println("Your Pokemon as fainted!");
					userlose=true;
					break;
				}
			}
			if(Integer.parseInt(stats_computer[activeindexcomputer].split(",")[0])<=0) {
				aliveordeadcomputer[activeindexcomputer] = 0;
				if(messagecomputer==false) {
					System.out.println("Computer Pokemon " + Pokemon_computer[activeindexcomputer].split(",")[0] + " has fainted! ");
					messagecomputer=true;
				}
				if(aliveordeadcomputer[0]==1 || aliveordeadcomputer[1]==1 || aliveordeadcomputer[2]==1) {
					int newpokemon = (int)(Math.random()*(2-0+1)+0);
					activeindexcomputer = newpokemon;
					if(aliveordeadcomputer[0]==1 || aliveordeadcomputer[1]==1 || aliveordeadcomputer[2]==1) {
						while(aliveordeadcomputer[activeindexcomputer]==0) {
							newpokemon = (int)(Math.random()*(2-0+1)+0);
							activeindexcomputer = newpokemon;
						}
						activeindexcomputer = newpokemon;
						System.out.println("Computer Switched Pokemon to " + Pokemon_computer[activeindexcomputer].split(",")[0]);
					}
				}
				else {
					computerlose=true;
					break;
				}
			}
			if(aliveordeaduser[0]==0 && aliveordeaduser[1]==0 && aliveordeaduser[2]==0) {
				userlose = true;
				break;
			}
			if(aliveordeadcomputer[0]==0 && aliveordeadcomputer[1]==0 && aliveordeadcomputer[2]==0) {
				computerlose = true;
				break;
			}
			activeindexcomputer=battlecomputer(Pokemon_user,Pokemon_computer,Pokemon_user_stats,stats_computer,moves_user,moves_computer,move_type_user,moves_type_computer,moves_dmg_user,moves_dmg_computer,moves_accuracy_user,moves_accuracy_computer,activeindexuser,activeindexcomputer,items_user,items_computer, uses_computer, status_user, status_computer,aliveordeadcomputer);
			if(Integer.parseInt(Pokemon_user_stats[activeindexuser].split(",")[0])<=0) {
				aliveordeaduser[activeindexuser] = 0;
				if(aliveordeaduser[0] == 1 || aliveordeaduser[1]==1 || aliveordeaduser[2]==1) {
					System.out.println("Your Pokemon has fained! Switch with: ");
					for(int x = 0; x<3; x++) {
						if(x==activeindexuser) {	
						}
						else if(aliveordeaduser[x]==0) {
						}
						else if(aliveordeaduser[x]==1){
							System.out.format("%-10s %8s", Pokemon_user[x].split(",")[0],x);
							System.out.println();
						}
					}
					System.out.print("Enter choice: ");
					activeindexuser = input.nextInt();
					System.out.println();
					if(aliveordeaduser[0]==1 || aliveordeaduser[1]==1 ||aliveordeaduser[2]==1) {
						while(aliveordeaduser[activeindexuser]==0) {
							System.out.print("Enter a valid choice: ");
							activeindexuser = input.nextInt();
							System.out.println();
						}
					}
				}
				else {
					System.out.println("Your Pokemon as fainted!");
					userlose=true;
					break;
				}
			}
			if(Integer.parseInt(stats_computer[activeindexcomputer].split(",")[0])<=0) {
				aliveordeadcomputer[activeindexcomputer] = 0;
				if(messagecomputer=false) {
					System.out.println("Computer Pokemon " + Pokemon_computer[activeindexcomputer].split(",")[0] + " has fainted! ");
					messagecomputer=true;
				}
				if(aliveordeadcomputer[0]==1 || aliveordeadcomputer[1]==1 || aliveordeadcomputer[2]==1) {
					int newpokemon = (int)(Math.random()*(2-0+1)+0);
					activeindexcomputer = newpokemon;
					if(aliveordeadcomputer[0]==1 || aliveordeadcomputer[1]==1 || aliveordeadcomputer[2]==1) {
						while(aliveordeadcomputer[activeindexcomputer]==0) {
							newpokemon = (int)(Math.random()*(2-0+1)+0);
							activeindexcomputer = newpokemon;
						}
						activeindexcomputer = newpokemon;
						System.out.println("Computer Switched Pokemon to " + Pokemon_computer[activeindexcomputer].split(",")[0]);
					}
				}
				else {
					computerlose=true;
					break;
				}
			}
			if(aliveordeaduser[0]==0 && aliveordeaduser[1]==0 && aliveordeaduser[2]==0) {
				userlose = true;
				break;
			}
			if(aliveordeadcomputer[0]==0 && aliveordeadcomputer[1]==0 && aliveordeadcomputer[2]==0) {
				computerlose = true;
				break;
			}
			round++;
		}
		System.out.println("Game Over!");
		if(userlose==true) {
			System.out.print("The Computer won this Pokemon Battle!");
		}
		if(computerlose==true) {
			System.out.print("The User won this Pokemon Battle!");
		}
		System.out.println("\nThis battle took " + round + " rounds!");
	} //main bracket
	/*
	 * void method statsDisplay displays the crucial stats tied to all of the 10 Pokemon
	 * Pre: 6 String arrays that contain the information of each Pokemon's stats, moves, name, typing, etc.
	 * Post: N/A
	 */
	public static void statsDisplay(String [] stats, String [] Pokemon, String [] moves, String [] moves_type, String [] moves_dmg, String [] moves_accuracy) { //method header, formal parameters
		String individualStats; //string that will be used to print out each Pokemon's individual stats
		String individualMoves; //string that will be used to print out each Pokemon's individual move names
		int k=0; //variable used to update Pokemon array
		System.out.println();
		System.out.println("Name         HP        Att.      Def.      Sp.Att    Sp.Def    Speed"); //displays the headings for each Pokemon's stats
		for(int i = 0; i<Pokemon.length; i++) {
			String PokemonLine = Pokemon[i]; //Puts the line of data into a variable
			String PokemonName = PokemonLine.split(",")[0]; //Isolates for Pokemon name in line
			System.out.format("%-10s   ", PokemonName);  //Prints out Pokemon name 
			for(int x = 0; x<6; x++) { //for loop used to print out the stats in a line for each Pokemon
				individualStats = stats[i].split(",")[x]; //The string individual stats gets updated in this nested loop to display each of the Pokemon's stats
				System.out.format("%-10s", individualStats); //Prints out the individual stats like HP, attack, defense, etc.
			}
			System.out.print("Moves: "); 
			for(int x = 0; x<4; x++) { //for loop used to print out each Pokemon's moves
				individualMoves = moves[i].split(",")[x]; //String individualMoves gets udpated so that it represents each Pokemon's moves
				System.out.format("%-15s", individualMoves); //prints out each Pokemon's four moves in a line
			}
			String PokeLine = Pokemon[k]; //sets PokeLine to Pokemon array [k]
			String PokeName = PokemonLine.split(",")[0]; //sets PokeName to the name of the Pokemon in the Pokemon array
			if(PokeName.equals("Charizard")||PokeName.equals("Venusaur")||PokeName.equals("Gengar")||PokeName.equals("Lucario")||PokeName.equals("Garchomp")||PokeName.equals("Dragonite")||PokeName.equals("Metagross")) { //All these Pokemon have 2 types so they are seperated
				if(PokeName.equals("Venusaur")){
					System.out.format("   %-5s %-5s %-5s", "Types:", PokeLine.split(",")[1], PokeLine.split(",")[2]); //venusaur gets isolated because his moves are too long in length. Displays this Pokemon's type.
				}
				else {
					System.out.format("      %-5s %-5s %-5s", "Types:", PokeLine.split(",")[1], PokeLine.split(",")[2]); //Prints out the types for these Pokemon with two types.
				}
			}
			else { //if the Pokemon only has one type, print out their type.
				if(PokeName.equals("Blastoise")||PokeName.equals("Snorlax")) {
					System.out.print("      Type: " + PokemonLine.split(",")[1]);
				}
				else {
					System.out.print("   Type: " + PokemonLine.split(",")[1]);
				}
			}
			k++; //update Pokemon array by one to switch Pokemon
			System.out.println();
		}
	} 
	/*
	 * battleScreen method prints out the current conditions of the battlefield. Prints out the names, HP, and types of both Pokemon on the field in a box.
	 * Pre: 2 Strings that represent the Pokemon name, HP, and type for both computer and USer pokemons. Also 1 int that represents the round of the battle.
	 * Post: N/A  
	 */
	public static void battleScreen (String ActivePokemonUser, String ActivePokemonComputer, int round, int [] status_user, int [] status_computer,int activeindexuser,int activeindexcomputer) {
		String ComputerPokemonName = ActivePokemonComputer.split(",")[0];
		int spaces = ComputerPokemonName.length();
		spaces = 69-spaces-45;
		int healthLength = ActivePokemonComputer.split(",")[1].length() + 4;
		healthLength = 69-healthLength-45;
		int typeLength = ActivePokemonComputer.split(",")[2].length() + 9;
		typeLength = 69-typeLength-45;
		String UserPokemonName = ActivePokemonUser.split(",")[0];
		int spacesUser = UserPokemonName.length();
		spacesUser = 69-spacesUser-5;
		int healthLengthUser = ActivePokemonUser.split(",")[1].length()+4;
		healthLengthUser = 69-healthLengthUser-5;
		int typeLengthUser = ActivePokemonUser.split(",")[2].length()+9;
		typeLengthUser = 69-typeLengthUser-5;
		String healthuser = "OK";
		String healthcomputer = "OK";
		if(status_user[activeindexuser]==1 ) {
			healthuser = "Poisoned";
		}
		if(status_user[activeindexuser]==2 ) {
			healthuser = "Paralysis";
		}
		if(status_user[activeindexuser]==3 ) {
			healthuser = "Frozen";
		}
		if(status_user[activeindexuser]==4 ) {
			healthuser = "Asleep";
		}
		if(status_user[activeindexuser]==5 ) {
			healthuser = "Burn";
		}
		if(status_computer[activeindexcomputer]==1 ) {
			healthcomputer = "Poisoned";
		}
		if(status_computer[activeindexcomputer]==2 ) {
			healthcomputer = "Paralysis";
		}
		if(status_computer[activeindexcomputer]==3 ) {
			healthcomputer = "Frozen";
		}
		if(status_computer[activeindexcomputer]==4 ) {
			healthcomputer = "Asleep";
		}
		if(status_computer[activeindexcomputer]==5 ) {
			healthcomputer = "Burn";
		}
		int statuscomputerlength = healthcomputer.length();
		statuscomputerlength = 69-statuscomputerlength-45;
		int statususerlength = healthuser.length();
		statususerlength = 69-statususerlength-5;
		System.out.println();
		System.out.println("************************************************************************");
		System.out.println("*                                                                      *");
		System.out.print("*                                             ");
		System.out.print(ComputerPokemonName);
		for(int i = 0; i<=spaces; i++) {
			System.out.print(" ");
		}
		System.out.println("*");
		System.out.print("*                                             ");
		System.out.print("HP: " + ActivePokemonComputer.split(",")[1]);
		for(int i = 0; i<=healthLength; i++) {
			System.out.print(" ");
		}
		System.out.println("*");
		System.out.print("*                                             ");
		System.out.print("Type(s): " + ActivePokemonComputer.split(",")[2]);
		for(int i = 0; i<=typeLength; i++) {
			System.out.print(" ");
		}
		System.out.println("*");
		System.out.print("*                                             ");
		System.out.print(healthcomputer);
		for(int i = 0; i<=statuscomputerlength; i++) {
			System.out.print(" ");
		}
		System.out.println("*");
		System.out.println("*                                                                      ***************");
		System.out.println("*                                                                      *              ***********");
		System.out.println("*                                                                      *   Round " + round + "               *********");
		System.out.println("*                                                                      *              ***********");
		System.out.println("*                                                                      ***************");
		System.out.print("*     ");
		System.out.print(UserPokemonName);
		for(int i = 0; i<=spacesUser; i++) {
			System.out.print(" ");
		}
		System.out.println("*");
		System.out.print("*     ");
		System.out.print("HP: " + ActivePokemonUser.split(",")[1]);
		for(int i = 0; i<=healthLengthUser; i++) {
			System.out.print(" ");
		}
		System.out.println("*");
		System.out.print("*     ");
		System.out.print("Type(s): " + ActivePokemonUser.split(",")[2]);
		for(int i = 0; i<=typeLengthUser; i++) {
			System.out.print(" ");
		}
		System.out.println("*");
		System.out.print("*     ");
		System.out.print(healthuser);
		for(int i = 0; i<=statususerlength; i++) {
			System.out.print(" ");
		}
		System.out.println("*");
		System.out.println("*                                                                      *");
		System.out.println("************************************************************************");
	}
	public static int battle(String [] Pokemon_user, String [] Pokemon_computer, String [] Pokemon_user_stats, String [] stats_computer, String [] moves_user, String [] moves_computer, String [] move_type_user, String [] moves_type_computer, String [] moves_dmg_user, String [] moves_dmg_computer, String [] moves_accuracy_user, String [] moves_accuracy_computer, int activeindexuser, int activeindexcomputer, String [] items_user, String [] items_computer, int [] uses, int [] status_user, int [] status_computer, int [] aliveordeaduser) {
		int itemsused = uses[0]; //how many items like potions have been used
		int userChoice = -1; //user menu choice
		int a = activeindexuser; //assign a to active pokemon index
		boolean turnfinished = false; //if turnfinished, exit loop
		Scanner input = new Scanner(System.in); 
		String ActiveUserPokemonName = Pokemon_user[activeindexuser].split(",")[0]; //assign activeuserpokemonname to the name of the active pokemon
		while(turnfinished==false) { //while the turn isn't complete. Only becomes true if the user switches Pokemon, attacks, uses items.
			if(userChoice==-1) {
				a=activeindexuser; //sets active pokemon index to a
				System.out.println("What will " + ActiveUserPokemonName + " do?"); //prints out options 
				System.out.format("%-10s %8s", "Switch", "0\n");
				System.out.format("%-10s %8s", "Bag", "1\n");
				System.out.format("%-10s %8s", "Attack", "2\n");
				System.out.print("Enter Choice: ");
				userChoice = input.nextInt(); //menu choice is saved to variable userChoice
				while(userChoice<-1 || userChoice>2) { //while the user choice is out of bounds, ask the user to reenter choice
					System.out.print("Enter A Valid Choice: ");
					userChoice = input.nextInt();
					System.out.println();
				}
			}
			if(userChoice==0) { //Switch options. First menu choice.
				System.out.print(ActiveUserPokemonName + " will switch with?");
				System.out.println();
				for(int i = 0; i<3; i++) { //prints out the Pokemon that the User can switch with
					if(aliveordeaduser[i]==0) {
					}
					else if(i==a) {	
					}
					else {
						System.out.format("%-10s %8s", Pokemon_user[i].split(",")[0],i);
						System.out.println();
					}
				}
				System.out.format("%-10s  %8s", "Main Menu", " -1\n"); //prints out return to menu option
				System.out.println();
				System.out.print("Enter Choice: ");
				a = input.nextInt(); //a is assigned to user choice
				if(a==-1) { //if user selects the return to menu option, returns to menu
					userChoice=-1;
					turnfinished=false;
				}
				else { //if the user does not select the return to menu option, a switch occurs 
					while(aliveordeaduser[a]==0 && a==activeindexuser) { //while the Pokemon that the user selects is dead or the current Pokemon the user has out, the user will be asked to reenter their choice
						System.out.print("Enter Valid Choice: ");
						a = input.nextInt();
					}
					ActiveUserPokemonName = Pokemon_user[a].split(",")[0];
					System.out.println("------------------------------------------------------------");
					System.out.println("User switched Pokemon to " + ActiveUserPokemonName);
					return a;
				}
			} //switch option last bracket
			if(userChoice==1) { //Bag options
				//Bag options
				if(itemsused<3) { //if statement that stops the user from using extra items they don't own. IF they used all three items, can't access potion page.
					int itemchoice = -5;
					System.out.println("What Item will be used?");
					if(items_user[0].split(",") [1].equals("ready")) {
						System.out.format("%-10s %8s", items_user[0].split(",")[0]," 0");
					}
					System.out.println();
					if(items_user[1].split(",") [1].equals("ready")) {
						System.out.format("%-10s %8s", items_user[1].split(",")[0]," 1");
					}
					System.out.println();
					if(items_user[2].split(",") [1].equals("ready")) {
						System.out.format("%-10s  %8s", items_user[2].split(",")[0]," 2\n");
					}
					System.out.format("%-10s %8s", "Main Menu","-1");
					System.out.println();
					System.out.print("Enter Choice: ");
					itemchoice = input.nextInt();
					System.out.println(itemchoice);
					if(itemchoice==-1) { //if the user wants to return to the main menu
						userChoice=-1;
					}
					else {
						while(itemchoice<0||itemchoice>2||items_user[itemchoice].split(",")[1].contentEquals("used")) {//as long as the user's choice item has been used or is out of bounds, ask them to reenter value
							System.out.print("Enter a Valid Choice (Item already used or invalid entry): ");
							itemchoice = input.nextInt();
						}
						System.out.println("------------------------------------------------------------");
						if(items_user[itemchoice].split(",")[0].equals("Potion")) { //if user uses potion
							int HP = (int)(Integer.parseInt(Pokemon_user_stats[activeindexuser].split(",")[0]) + 50); //increase health by 50 HP.
							Pokemon_user_stats[a] = HP + "," + Pokemon_user_stats[a].split(",")[1] + "," + Pokemon_user_stats[a].split(",")[2] + "," + Pokemon_user_stats[a].split(",")[3] + "," + Pokemon_user_stats[a].split(",")[4] + "," + Pokemon_user_stats[a].split(",")[5];   
							System.out.println("User used Potion! " + Pokemon_user[activeindexuser].split(",")[0] + " gained 50 HP!");
							turnfinished=true; //finish turn
						}
						if(items_user[itemchoice].split(",")[0].equals("Awakening")) { //if user uses awakening
							if(status_user[a]==4) { //if the user pokemon is actually asleep, display a unique message
								status_user[a] = 0;
								System.out.println("User used Awaken! " + Pokemon_user[activeindexuser].split(",")[0] + " woke from his sleep!");
								turnfinished=true;
							}
							else { //tell the user that the awakening potion was used
								System.out.println("User used Awaken! However, " + Pokemon_user[activeindexuser].split(",")[0] + " was not asleep!");
								turnfinished=true;
							}
						}
						if(items_user[itemchoice].split(",")[0].equals("Ice Heal")) { //if ice heal potion is used
							if(status_user[a]==3) {//if the user pokemon is actually frozen, display an appropriate message
								status_user[a] = 0;
								System.out.println("User used Ice Heal! " + Pokemon_user[activeindexuser].split(",")[0] + " thawed out!");
								turnfinished=true;
							}
							else {//tell the user that the ice heal potion was used
								System.out.println("User used Ice Heal! However, " + Pokemon_user[activeindexuser].split(",")[0] + " was not frozen"); 
								turnfinished=true;
							}
						}
						if(items_user[itemchoice].split(",")[0].equals("Paralyz Heal")) { //if paralysis potion is used
							if(status_user[a]==2) { //if the user pokemon was actually paralyzed, display an appropriate message
								status_user[a] = 0;
								System.out.println("User used Paralyze Heal! " + Pokemon_user[activeindexuser].split(",")[0] + " no longer has paralysis!");
								turnfinished=true;
							}
							else {
								System.out.println("User used Paralyze Heal! However, " + Pokemon_user[activeindexuser].split(",")[0] + " was not paralyzed!");
								turnfinished=true;
							}
						}
						if(items_user[itemchoice].split(",")[0].equals("Burn Heal")) { //if the burn heal is used
							if(status_user[a]==4) { //if the user pokemon was actually burning, display an appropriate message
								status_user[a] = 0;
								System.out.println("User used Burn Heal! " + Pokemon_user[activeindexuser].split(",")[0] + " no longer has burn!");
								turnfinished=true;
							}
							else {
								System.out.println("User used Burn Heal! However, " + Pokemon_user[activeindexuser].split(",")[0] + " did not have burn!");
								turnfinished=true;
							}
						}
						items_user[itemchoice] = items_user[itemchoice].split(",")[0] + ",used"; //change items used index to add "used"
						uses[0] = uses[0] + 1; //add a use to the array. Max is 3.
						turnfinished=true; //finish turn
					}
				}
				else { //if item is used more than 3 times, tell them that all items have been used
					System.out.println("All items used");
					turnfinished=false;
					userChoice=-1;
				}
			}//end of item selection screen (userChoice == 1)
			if(userChoice==2) { //Attack options
				boolean skip = false; 
				System.out.println();
				//prints out the move of the active pokemon, the damage of this move, the accuracy, and selection number
				System.out.println("Move:                    Dmg.      Acc.    Selection Number");
				for(int x = 0; x<4; x++) {
					int movelength = moves_user[a].split(",")[x].length();
					movelength = 25-movelength; //how long the move's name is
					int digitlength = moves_dmg_user[a].split(",")[x].length();
					digitlength = 10-digitlength; // how long the accuracy is in terms of characters
					System.out.print(moves_user[a].split(",")[x]); //prints out move name
					for(int i = 0; i<movelength; i++) {
						System.out.print(" ");
					}
					System.out.print(moves_dmg_user[a].split(",")[x]); //prints out damage
					for(int i = 0; i<digitlength; i++) {
						System.out.print(" ");
					}
					System.out.print(moves_accuracy_user[a].split(",")[x]); //Prints out accuracy
					if(moves_accuracy_user[a].split(",")[x].length()==2) {
						System.out.print("      " + x);
					}
					else if(moves_accuracy_user[a].split(",")[x].length()==1){
					System.out.print("       " + x);
					}
					else {
						System.out.print("     " + x);
					}
					System.out.println();
				}
				System.out.println("Main Menu                                 -1");
				//asks user what attack they want to use
				System.out.print("Enter Choice: ");
				System.out.println();
				int attackchoice = input.nextInt(); //if the user selects main menu, they will return to main menu
				if(attackchoice==-1) {
					userChoice=-1;
					turnfinished = false;
				}
				else { //if the user does not select -1
					while(attackchoice<0 || attackchoice>3) { //if the user enters an invalid entry
						System.out.print("Enter A Valid Choice: ");
						attackchoice = input.nextInt();
					}
					System.out.println("------------------------------------------------------------");
					int activepokemonuserstatus = status_user[activeindexuser]; //set active pokemon status
					if(activepokemonuserstatus==1) { //If the active pokemon has poison, it deals 15 damage
						int HP = (int)(Integer.parseInt(Pokemon_user_stats[activeindexuser].split(",")[0]) - 15); //increase health by 50 HP.
						Pokemon_user_stats[a] = HP + "," + Pokemon_user_stats[a].split(",")[1] + "," + Pokemon_user_stats[a].split(",")[2] + "," + Pokemon_user_stats[a].split(",")[3] + "," + Pokemon_user_stats[a].split(",")[4] + "," + Pokemon_user_stats[a].split(",")[5]; 
						System.out.println("User's " + Pokemon_user[a].split(",")[0] + " took 15 damage from its burn");
					}
					if(activepokemonuserstatus==2) { //If the active pokemon has paralysis, there is a 25% chance it loses it's turn
						int chance = (int)(Math.random()*(100-1+1)+1);
						if(chance<=25) {
							skip = true;
							System.out.println("User Pokemon couldn't move because it is paralyzed!");
						}
					}
					if(activepokemonuserstatus==3) { //If the active pokemon is frozen, it skips its turn. 15% chance to break out
						skip = true;
						int chance = (int)(Math.random()*(100-1+1)+1);
						if(chance<=15) {
							skip = false;
							status_user[a] = 0;
							System.out.println("User Pokemon has thawed out!");
						}
						else {
							System.out.println("User Pokemon couldn't move because it is frozen!");
						}
					}
					if(activepokemonuserstatus==4) { //If the active pokemon is asleep, it skips its turn. 33% chance to wake up
						skip = true;
						int chance = (int)(Math.random()*(100-1+1)+1);
						if(chance<=33) {
							skip = false;
							System.out.println("User Pokemon woke up");
							status_user[a] = 0;
						}
						else {
							System.out.println("User Pokemon is still asleep");
						}
						if(activepokemonuserstatus==4 && moves_user[a].split(",")[attackchoice].equals("Sleep Talk")) { //If the active pokemon is asleep, and the move the user uses is sleep talk, deal damage
							double modifier = 1; //modifies damage done based on type effectiveness
							double attackpower = Integer.parseInt(moves_dmg_user[a].split(",")[attackchoice]); //attack power of the move used
							double attack = Integer.parseInt(Pokemon_user_stats[a].split(",")[1]); //attack stat of the Pokemon
							double defense = Integer.parseInt(stats_computer[activeindexcomputer].split(",")[2]); //defense stat of the computer pokemon
							//if the active computer pokemon has one type, modifier1 method will be used 
							if(Pokemon_computer[activeindexcomputer].split(",")[0].equals("Blastoise")||Pokemon_computer[activeindexcomputer].split(",")[0].equals("Snorlax")||Pokemon_computer[activeindexcomputer].split(",")[0].equals("Alakazam")) {
								modifier = modifier1(move_type_user[activeindexuser].split(",")[attackchoice],Pokemon_computer[activeindexcomputer].split(",")[1]);
							}
							//if the active computer pokemon has two types, modifier2 will be used
							else {
								modifier = modifier2(move_type_user[activeindexuser].split(",")[attackchoice],Pokemon_computer[activeindexcomputer].split(",")[1], Pokemon_computer[activeindexcomputer].split(",")[2]);
							}
							double damagetest = 0.5*attackpower*(attack/defense)*modifier; //damage done by the move
							int damagebyuser = (int)(damagetest); //convert this damage number to int
							String s = Integer.parseInt(stats_computer[activeindexcomputer].split(",")[0])-damagebyuser + "," + stats_computer[activeindexcomputer].split(",")[1] + "," + stats_computer[activeindexcomputer].split(",")[2] + "," + stats_computer[activeindexcomputer].split(",")[3] + "," + stats_computer[activeindexcomputer].split(",")[4] + "," + stats_computer[activeindexcomputer].split(",")[5];
							int accuracy = (int)(Math.random()*(100-1+1)+1); //roll from 1-100. If the number is under the accuracy of the move used, the damage will be done to the computer 
							if(accuracy<=Integer.parseInt(moves_accuracy_user[activeindexuser].split(",")[attackchoice])) { //If the number is under the accuracy of the move used, the damage will be done to the computer 
								stats_computer[activeindexcomputer] = s; 
								if(modifier>1) {
									System.out.println("User's " + Pokemon_user[activeindexuser].split(",")[0] + " used Sleep Talk on " + Pokemon_computer[activeindexcomputer].split(",")[0] + "! It did " + damagebyuser + " damage. Super Effective!");
								}
								else if(modifier==1) {
									System.out.println("User's " + Pokemon_user[activeindexuser].split(",")[0] + " used Sleep Talk on " + Pokemon_computer[activeindexcomputer].split(",")[0] + "! It did " + damagebyuser + " damage.");
								}
								else {
									System.out.println("User's " + Pokemon_user[activeindexuser].split(",")[0] + " used Sleep Talk on " + Pokemon_computer[activeindexcomputer].split(",")[0] + "! It did " + damagebyuser + " damage. Not Very Effective!");
								}
								turnfinished=true;
							}
							else {
								System.out.println("User's " + Pokemon_user[activeindexuser].split(",")[0] + " used Sleep Talk on " + Pokemon_computer[activeindexcomputer].split(",")[0] + " but it missed!");
								turnfinished=true;
							}
							turnfinished=true;
						}
						else if(activepokemonuserstatus!=4 && moves_user[a].split(",")[attackchoice].equals("Sleep Talk")) {  //if the user pokemon wakes up and tries to use sleep talk, it will fail
							System.out.println("User's Snorlax woke up! Sleep Talk Failed");
							turnfinished=true;
						}
					}
					if(activepokemonuserstatus==5) { //If the user's pokemon has burn, it will take 15 damage
						int HP = (int)(Integer.parseInt(Pokemon_user_stats[activeindexuser].split(",")[0]) - 15); //increase health by 50 HP.
						Pokemon_user_stats[a] = HP + "," + Pokemon_user_stats[a].split(",")[1] + "," + Pokemon_user_stats[a].split(",")[2] + "," + Pokemon_user_stats[a].split(",")[3] + "," + Pokemon_user_stats[a].split(",")[4] + "," + Pokemon_user_stats[a].split(",")[5]; 
						System.out.println("User's " + Pokemon_user[a].split(",")[0] + " took 15 damage from its poison");
					}
					if(skip==false) { //if the user can attack (isn't hindered by status), the following attacks will be executed
						String attackname = moves_user[a].split(",")[attackchoice]; //name of attack assigned to attackname
						//Buff moves that don't do damage is isolated
						if(attackname.contentEquals("Growth") || attackname.contentEquals("Rest") || attackname.contentEquals("Calm Mind") || attackname.contentEquals("Sleep Talk") || attackname.contentEquals("Sword Dance") || attackname.contentEquals("Dragon Dance")) {
							if(attackname.contentEquals("Growth")) { //if growth is used
								int newattack = (int)(Integer.parseInt(Pokemon_user_stats[activeindexuser].split(",")[1])*1.5); //attack is buffed
								int newspecialattack = (int)(Integer.parseInt(Pokemon_user_stats[activeindexuser].split(",")[3])*1.5); //special attack is buffed
								Pokemon_user_stats[activeindexuser] = Pokemon_user_stats[activeindexuser].split(",")[0] + "," + newattack + "," + Pokemon_user_stats[activeindexuser].split(",")[2] + "," + newspecialattack + "," + Pokemon_user_stats[activeindexuser].split(",")[4] + "," + Pokemon_user_stats[activeindexuser].split(",")[5]; //new stats are assigned to user pokemon
								System.out.println("User's " + Pokemon_user[activeindexuser].split(",")[0] + " used Growth! Attack and special attack raised!");
								turnfinished=true;
							}
							if(attackname.contentEquals("Rest")) { //if rest is used
								int newhp = (int)(Integer.parseInt(Pokemon_user_stats[activeindexuser].split(",")[0]) + 150); //hp is increased by 150
								Pokemon_user_stats[activeindexuser] = newhp + "," + Pokemon_user_stats[activeindexuser].split(",")[1] + "," + Pokemon_user_stats[activeindexuser].split(",")[2] + "," + Pokemon_user_stats[activeindexuser].split(",")[3] + "," + Pokemon_user_stats[activeindexuser].split(",")[4] + "," +Pokemon_user_stats[activeindexuser].split(",")[5]; //new stats are assigned to user pokemon
								status_user[activeindexuser] = 4; //User pokemon is now asleep
								System.out.println("User's " + Pokemon_user[activeindexuser].split(",")[0] + " used Rest! It gained 150HP!");
								turnfinished=true;
							}
							if(attackname.contentEquals("Calm Mind")) { //if calm mind is used
								int newspecialattack = (int)(Integer.parseInt(Pokemon_user_stats[activeindexuser].split(",")[3]) *1.5); //special attack stat is raised
								int newspecialdefense  = (int)(Integer.parseInt(Pokemon_user_stats[activeindexuser].split(",")[4]) *1.5); //special defense stat is raised
								Pokemon_user_stats[activeindexuser] = Pokemon_user_stats[activeindexuser].split(",")[0] + "," + Pokemon_user_stats[activeindexuser].split(",")[1] + "," + Pokemon_user_stats[activeindexuser].split(",")[2] + "," + newspecialattack + "," + newspecialdefense + "," +Pokemon_user_stats[activeindexuser].split(",")[5]; //new stats are assigned to user pokemon
								System.out.println("User's " + Pokemon_user[activeindexuser].split(",")[0] + " used Calm Mind! Special attack and special defense raised!");
								turnfinished=true;
							}
							if(attackname.equals("Sword Dance")) { //if sword dance is used
								int newattack = (int)(Integer.parseInt(Pokemon_user_stats[activeindexuser].split(",")[1]) *1.5); //attack stat for user is doubled
								Pokemon_user_stats[activeindexuser] = Pokemon_user_stats[activeindexuser].split(",")[0] + "," + newattack + "," + Pokemon_user_stats[activeindexuser].split(",")[2] + "," + Pokemon_user_stats[activeindexuser].split(",")[3] + "," + Pokemon_user_stats[activeindexuser].split(",")[4] + "," +Pokemon_user_stats[activeindexuser].split(",")[5]; //assigns new stats to user pokemon
								System.out.println("User's " + Pokemon_user[activeindexuser].split(",")[0] + " used Sword Dance! Attack sharply raised!");
								turnfinished=true;
							}
							if(attackname.contentEquals("Dragon Dance")) { //if growth is used
								int newattack = (int)(Integer.parseInt(Pokemon_user_stats[activeindexuser].split(",")[1])*2); //attack is buffed
								Pokemon_user_stats[activeindexuser] = Pokemon_user_stats[activeindexuser].split(",")[0] + "," + newattack + "," + Pokemon_user_stats[activeindexuser].split(",")[2] + "," + Pokemon_user_stats[activeindexuser].split(",")[3] + "," + Pokemon_user_stats[activeindexuser].split(",")[4] + "," + Pokemon_user_stats[activeindexuser].split(",")[5]; //new stats are assigned to user pokemon
								System.out.println("User's " + Pokemon_user[activeindexuser].split(",")[0] + " used Dragon Dance! Attack sharply raised!");
								System.out.println(Pokemon_user_stats[activeindexuser]);
								turnfinished=true;
							}
						} //buff moves bracket
						else {
							String attacktype = PhysicalOrSpecial(moves_user[a].split(",")[attackchoice]); //attacktype is determined by going to method physical or special. Tells us if the attack is a physical or special attack
							if(attacktype.equals("Special")) { //if the move is special, it takes into account special attack and special defense stats
								double modifier = 1; //modifier based on type effectiveness
								double attackpower = Integer.parseInt(moves_dmg_user[a].split(",")[attackchoice]); //attack power of move
								double specialattack =  Integer.parseInt(Pokemon_user_stats[a].split(",")[3]); //special attack of user
								double specialdefense = Integer.parseInt(stats_computer[activeindexcomputer].split(",")[4]); //special defense of computer
								//if the computer pokemon is one typed, modifier1 is used. Determines type effectiveness between move and opponent type.
								if(Pokemon_computer[activeindexcomputer].split(",")[0].equals("Blastoise")||Pokemon_computer[activeindexcomputer].split(",")[0].equals("Snorlax")||Pokemon_computer[activeindexcomputer].split(",")[0].equals("Alakazam")) {
									modifier = modifier1(move_type_user[activeindexuser].split(",")[attackchoice],Pokemon_computer[activeindexcomputer].split(",")[1]);
								}
								//if the computer pokemon is two typed, modifier2 is used. Determined type effectiveness between move and oponent type.
								else {
									modifier = modifier2(move_type_user[activeindexuser].split(",")[attackchoice],Pokemon_computer[activeindexcomputer].split(",")[1], Pokemon_computer[activeindexcomputer].split(",")[2]);
								}
								double damagetest = 0.5*attackpower*(specialattack/specialdefense)*modifier;//damage calculation
								int damagebyuser = (int) (damagetest); //turns damage into an int
								String s = Integer.parseInt(stats_computer[activeindexcomputer].split(",")[0])-damagebyuser + "," + stats_computer[activeindexcomputer].split(",")[1] + "," + stats_computer[activeindexcomputer].split(",")[2] + "," + stats_computer[activeindexcomputer].split(",")[3] + "," + stats_computer[activeindexcomputer].split(",")[4] + "," + stats_computer[activeindexcomputer].split(",")[5]; //assigns damage to computer hp stat
								int accuracy = (int)(Math.random()*(100-0+1)+0); //1-100 roll
								if(accuracy<=Integer.parseInt(moves_accuracy_user[activeindexuser].split(",")[attackchoice])) {//if roll is under accuracy of the move, the move will hit
									stats_computer[activeindexcomputer] = s; //deal damage to the computer pokemon 
									//Display appropriate message
									if(modifier>1) {
										System.out.println("User's " + Pokemon_user[activeindexuser].split(",")[0] + " used " + moves_user[activeindexuser].split(",")[attackchoice] + " on " + Pokemon_computer[activeindexcomputer].split(",")[0] +". It did " + damagebyuser + " damage. Super Effective!");
									}
									if(modifier==1) {
										System.out.println("User's " + Pokemon_user[activeindexuser].split(",")[0] + " used " + moves_user[activeindexuser].split(",")[attackchoice] + " on " + Pokemon_computer[activeindexcomputer].split(",")[0] +". It did " + damagebyuser + " damage.");
									}
									else if(modifier<1){
										System.out.println("User's " + Pokemon_user[activeindexuser].split(",")[0] + " used " + moves_user[activeindexuser].split(",")[attackchoice] + " on " + Pokemon_computer[activeindexcomputer].split(",")[0] +". It did " + damagebyuser + " damage. Not Very Effective!");
									}
								}
								else {
									System.out.println("User's " + Pokemon_user[activeindexuser].split(",")[0] + " tried to use " + moves_user[activeindexuser].split(",")[attackchoice] + " but it missed");
								}
								turnfinished=true;
							}
							else {
								//same comments as lines 926-959. Only difference is that sp. attack and sp. def stats are used instead of attack and defense stats.
								double modifier = 1; 
								double attackpower = Integer.parseInt(moves_dmg_user[a].split(",")[attackchoice]);
								double attack = Integer.parseInt(Pokemon_user_stats[a].split(",")[1]);
								double defense = Integer.parseInt(stats_computer[activeindexcomputer].split(",")[2]);
								if(Pokemon_computer[activeindexcomputer].split(",")[0].equals("Blastoise")||Pokemon_computer[activeindexcomputer].split(",")[0].equals("Snorlax")||Pokemon_computer[activeindexcomputer].split(",")[0].equals("Alakazam")) {
									modifier = modifier1(move_type_user[activeindexuser].split(",")[attackchoice],Pokemon_computer[activeindexcomputer].split(",")[1]);
								}
								else {
									modifier = modifier2(move_type_user[activeindexuser].split(",")[attackchoice],Pokemon_computer[activeindexcomputer].split(",")[1], Pokemon_computer[activeindexcomputer].split(",")[2]);
								}
								double damagetest = 0.5*attackpower*(attack/defense)*modifier;
								int damagebyuser = (int)(damagetest);
								String s = Integer.parseInt(stats_computer[activeindexcomputer].split(",")[0])-damagebyuser + "," + stats_computer[activeindexcomputer].split(",")[1] + "," + stats_computer[activeindexcomputer].split(",")[2] + "," + stats_computer[activeindexcomputer].split(",")[3] + "," + stats_computer[activeindexcomputer].split(",")[4] + "," + stats_computer[activeindexcomputer].split(",")[5];
								int accuracy = (int)(Math.random()*(100-0+1)+0);
								if(accuracy<=Integer.parseInt(moves_accuracy_user[activeindexuser].split(",")[attackchoice])) {
									stats_computer[activeindexcomputer] = s;
									if(modifier>1) {
										System.out.println("User's " + Pokemon_user[activeindexuser].split(",")[0] + " used " + moves_user[activeindexuser].split(",")[attackchoice] + " on " + Pokemon_computer[activeindexcomputer].split(",")[0] +". It did " + damagebyuser + " damage. It was Super Effective!");
									}
									if(modifier==1) {
										System.out.println("User's " + Pokemon_user[activeindexuser].split(",")[0] + " used " + moves_user[activeindexuser].split(",")[attackchoice] + " on " + Pokemon_computer[activeindexcomputer].split(",")[0] +". It did " + damagebyuser + " damage.");
									}
									else if(modifier<1){
										System.out.println("User's " + Pokemon_user[activeindexuser].split(",")[0] + " used " + moves_user[activeindexuser].split(",")[attackchoice] + " on " + Pokemon_computer[activeindexcomputer].split(",")[0] +". It did " + damagebyuser + " damage. It was Not Very Effective!");
									}
									//certain moves will have certain effects. For example some moves will cause burn, paralysis, etc.
									if(attackname.contentEquals("Firepunch")) { //if the user uses fire punch, there is a chance that they will burn the opposing pokemon
										int burnchance = (int)(Math.random()*(100-1+1)+1);
										if(burnchance<=10) { //10% chance it burns other Pokemon
											status_computer[activeindexcomputer]=5;
											System.out.println(Pokemon_computer[activeindexcomputer].split(",")[0] + " is burning");
										}
									}
									if(attackname.contentEquals("Hidden Power[Fire]")) { //if the user uses hidden power[fire], there is a chance that they will burn the opposing pokemon
										int burnchance = (int)(Math.random()*(100-1+1)+1);
										if(burnchance<=10) { //10% chance it burns other Pokemon
											status_computer[activeindexcomputer]=5;
											System.out.println(Pokemon_computer[activeindexcomputer].split(",")[0] + " is burning");
										}
									}
									if(attackname.contentEquals("Scald")) { //if the user uses scald, there is a chance that they will burn the opposing pokemon
										int burnchance = (int)(Math.random()*(100-1+1)+1);
										if(burnchance<=10) { //10% chance it burns the other pokemon
											status_computer[activeindexcomputer]=5;
											System.out.println(Pokemon_computer[activeindexcomputer].split(",")[0] + " is burning");
										}
									}
									if(attackname.contentEquals("Ice Beam")) {//if the user uses ice beam, there is a chance that they will freeze the opponent's pokemon
										int freezechance = (int)(Math.random()*(100-1+1)+1);
										if(freezechance<=10) { //10% chance it freezes the other pokemon
											status_computer[activeindexcomputer]=3;
											System.out.println(Pokemon_computer[activeindexcomputer].split(",")[0] + " is frozen");
										}
									}
									if(attackname.contentEquals("Thunderbolt")) {//if the user uses thunderbolt there is a chance that they will paralyze the opponent's pokemon
										int parachance = (int)(Math.random()*(100-1+1)+1);
										if(parachance<=10) { //10% chance it paralyzises the other pokemon
											status_computer[activeindexcomputer]=2;
											System.out.println(Pokemon_computer[activeindexcomputer].split(",")[0] + " is paralyzed");
										}
									}
								}
								else {
									System.out.println("User's " + Pokemon_user[activeindexuser].split(",")[0] + " used " + moves_user[activeindexuser].split(",")[attackchoice] + " but it missed!");
								}
								turnfinished=true;
							}
						}
					}
					turnfinished = true;
				}
			} //menu marker
		}
		return a;
	}
	/*
	 * PhysicalOrSpecial method returns either "Special" or "Physical" depending on the name of the attack
	 * Pre: 1 String representing the name of the attack
	 * Return: 1 string attack representing the type of the attack
	 */
	public static String PhysicalOrSpecial (String attack) {
		if(attack.equals("Fire Punch")||attack.equals("Crunch")||attack.equals("Growth")||attack.equals("Solarbeam")||attack.equals("Sludge Bomb")||attack.equals("Hidden Power[Fire]")||attack.equals("Scald")||attack.equals("Dragon Tail")||attack.equals("Ice Beam")||attack.equals("Shadow Ball")||attack.equals("Energy Ball")||attack.equals("Thunderbolt")||attack.equals("Psychic")||attack.equals("Calm Mind")||attack.equals("Flash Cannon")||attack.equals("Dark Pulse")||attack.equals("Sword Dance")||attack.equals("Waterfall")||attack.equals("Dragon Dance")||attack.equals("Psyshock")||attack.equals("Shadow Ball")||attack.equals("Zen Headbutt")||attack.equals("Ice Punch")) {
			attack = "Special";
		}
		else {
			attack = "Physical";
		}
		return attack;
	}
	/*
	 * modifier1 method returns a modifying number depending on how effective the move is on the opponent's particular type
	 * Pre: 2 Strings representing the type of the move and the type of the opposing pokemon
	 * Post: 1 double "a" which represents how much to modify the damage done
	 */
	public static double modifier1 (String movetype, String computertype1) {
		double a = 1;
		if(movetype.equals("dark") && computertype1.equals("ghost")||movetype.equals("dark") && computertype1.equals("psychic")) {
			a=a*2;
		}
		if(movetype.equals("dragon") && computertype1.equals("dragon")) {
			a=a*2;
		}
		if(movetype.equals("electric") && computertype1.equals("flying")||movetype.equals("electric") && computertype1.equals("water")) {
			a=a*2;
		}
		if(movetype.equals("fighting") && computertype1.equals("dark")||movetype.equals("fighting") && computertype1.equals("ice")||movetype.equals("fighting") && computertype1.equals("normal")||movetype.equals("fighting") && computertype1.equals("rock")||movetype.equals("fighting") && computertype1.equals("steel")) {
			a=a*2;
		}
		if(movetype.equals("fire") && computertype1.equals("bug")||movetype.equals("fire") && computertype1.equals("grass")||movetype.equals("fire") && computertype1.equals("ice")||movetype.equals("fire") && computertype1.equals("steel")) {
			a=a*2;
		}
		if(movetype.equals("ghost") && computertype1.equals("ghost")||movetype.equals("ghost") && computertype1.equals("psychic")) {
			a=a*2;
		}
		if(movetype.equals("grass") && computertype1.equals("ground")||movetype.equals("grass") && computertype1.equals("rock")||movetype.equals("grass") && computertype1.equals("water")) {
			a=a*2;
		}
		if(movetype.equals("ground") && computertype1.equals("electric")||movetype.equals("ground") && computertype1.equals("fire")||movetype.equals("ground") && computertype1.equals("poison")||movetype.equals("ground") && computertype1.equals("rock")||movetype.equals("ground") && computertype1.equals("steel")) {
			a=a*2;
		}
		if(movetype.contentEquals("ice") && computertype1.contentEquals("dragon")||movetype.contentEquals("ice") && computertype1.contentEquals("flying")||movetype.contentEquals("ice") && computertype1.contentEquals("grass")||movetype.contentEquals("ice") && computertype1.contentEquals("ground")) {
			a=a*2;
		}
		if(movetype.equals("poison") && computertype1.contentEquals("grass")) {
			a=a*2;
		}
		if(movetype.equals("psychic") && computertype1.contentEquals("fighting")||movetype.equals("psychic") && computertype1.contentEquals("poison")) {
			a=a*2;
		}
		if(movetype.equals("rock") && computertype1.contentEquals("bug")||movetype.equals("rock") && computertype1.contentEquals("fire")||movetype.equals("rock") && computertype1.contentEquals("flying")||movetype.equals("rock") && computertype1.contentEquals("ice")) {
			a=a*2;
		}
		if(movetype.equals("steel") && computertype1.contentEquals("fairy")||movetype.equals("steel") && computertype1.contentEquals("ice")||movetype.equals("steel") && computertype1.contentEquals("rock")) {
			a=a*2;
		}
		if(movetype.contentEquals("normal") && computertype1.contentEquals("rock") || movetype.contentEquals("normal") && computertype1.contentEquals("steel")) {
			a=a/2;
		}
		if(movetype.equals("normal") && computertype1.equals("ghost")) {
			a=0;
		}
		if(movetype.contentEquals("water") && computertype1.contentEquals("fire") || movetype.contentEquals("water") && computertype1.contentEquals("ground") || movetype.contentEquals("water") && computertype1.contentEquals("rock")) {
			a=a*2;
		}
		if(movetype.contentEquals("ground") && computertype1.contentEquals("flying")) {
			a=0;
		}
		if(movetype.contentEquals("normal") && computertype1.contentEquals("rock")||movetype.contentEquals("normal") && computertype1.contentEquals("ghost")||movetype.contentEquals("normal") && computertype1.contentEquals("steel")) {
			a=a/2;
		}
		if(movetype.contentEquals("fighting") && computertype1.contentEquals("flying") || movetype.contentEquals("fighting") && computertype1.contentEquals("poison") || movetype.contentEquals("fighting") && computertype1.contentEquals("psychic")|| movetype.contentEquals("fighting") && computertype1.contentEquals("bug") || movetype.contentEquals("fighting") && computertype1.contentEquals("ghost")) {
			a=a/2;
		}
		if(movetype.equals("poison") && computertype1.contentEquals("poison") || movetype.equals("poison") && computertype1.contentEquals("ground")||movetype.equals("poison") && computertype1.contentEquals("rock")||movetype.equals("poison") && computertype1.contentEquals("ghost")||movetype.equals("poison") && computertype1.contentEquals("steel")) {
			a=a/2;
		}
		if(movetype.contentEquals("ground") && computertype1.contentEquals("flying")||movetype.contentEquals("ground") && computertype1.contentEquals("bug")||movetype.contentEquals("ground") && computertype1.contentEquals("grass")) {
			a=a/2;
		}
		if(movetype.equals("rock") && computertype1.contentEquals("fighting")||movetype.equals("rock") && computertype1.contentEquals("ground")|| movetype.equals("rock") && computertype1.contentEquals("steel")) {
			a=a/2;
		}

		if(movetype.contentEquals("bug") && computertype1.contentEquals("fire") || movetype.contentEquals("bug") && computertype1.contentEquals("fighting") || movetype.contentEquals("bug") && computertype1.contentEquals("flying")|| movetype.contentEquals("bug") && computertype1.contentEquals("poison")|| movetype.contentEquals("bug") && computertype1.contentEquals("ghost")|| movetype.contentEquals("bug") && computertype1.contentEquals("steel")) {
			a=a/2;
		}
		if(movetype.equals("ghost") && computertype1.contentEquals("normal") || movetype.equals("ghost") && computertype1.contentEquals("dark")) {
			a=a/2;
		}
		if(movetype.equals("steel") && computertype1.equals("steel") || movetype.equals("steel") && computertype1.equals("fire") ||movetype.equals("steel") && computertype1.equals("water") ||movetype.equals("steel") && computertype1.equals("electric")) {
			a=a/2;
		}
		if(movetype.equals("fire") && computertype1.equals("rock")|| movetype.equals("fire") && computertype1.equals("fire") || movetype.equals("fire") && computertype1.equals("water") || movetype.equals("fire") && computertype1.equals("dragon")) {
			a=a/2;
		}
		if(movetype.contentEquals("water") && computertype1.contentEquals("water")|| movetype.contentEquals("water") && computertype1.contentEquals("grass")||movetype.contentEquals("water") && computertype1.contentEquals("dragon")) {
			a=a/2;
		}
		if(movetype.equals("grass") && computertype1.contentEquals("flying") ||movetype.equals("grass") && computertype1.contentEquals("poison") ||movetype.equals("grass") && computertype1.contentEquals("bug") ||movetype.equals("grass") && computertype1.contentEquals("steel") ||movetype.equals("grass") && computertype1.contentEquals("fire") ||movetype.equals("grass") && computertype1.contentEquals("grass") ||movetype.equals("grass") && computertype1.contentEquals("dragon")) {
			a=a/2;
		}
		if(movetype.equals("electric") && computertype1.equals("ground") ||movetype.equals("electric") && computertype1.equals("grass") ||movetype.equals("electric") && computertype1.equals("electric")||movetype.equals("electric") && computertype1.equals("dragon")) {
			a=a/2;
		}
		if(movetype.equals("psychic") && computertype1.equals("steel") ||movetype.equals("psychic") && computertype1.equals("psychic")||movetype.equals("psychic") && computertype1.equals("dark")) {
			a=a/2;
		}
		if(movetype.equals("ice") && computertype1.equals("steel") || movetype.equals("ice") && computertype1.equals("fire")||movetype.equals("ice") && computertype1.equals("water")||movetype.equals("ice") && computertype1.equals("ice")) {
			a=a/2;
		}
		if(movetype.equals("dragon") && computertype1.equals("steel")) {
			a=a/2;
		}
		if(movetype.contentEquals("dark") && computertype1.contentEquals("fighting") || movetype.contentEquals("dark") && computertype1.contentEquals("dark")) {
			a=a/2;
		}
		return a;
	}
	/*
	 * modifier2 method returns a modifying number depending on how effective the move is on the opponent's particular types
	 * Pre: 3 Strings representing the type of the move and the two types of the opposing pokemon
	 * Post: 1 double "a" which represents how much to modify the damage done
	 */
	public static double modifier2 (String movetype, String computertype1, String computertype2) {
		double a = 1;
		if(movetype.equals("dark") && computertype1.equals("ghost")||movetype.equals("dark") && computertype1.equals("psychic")) {
			a=a*2;
		}
		if(movetype.equals("dragon") && computertype1.equals("dragon")) {
			a=a*2;
		}
		if(movetype.equals("electric") && computertype1.equals("flying")||movetype.equals("electric") && computertype1.equals("water")) {
			a=a*2;
		}
		if(movetype.equals("fighting") && computertype1.equals("dark")||movetype.equals("fighting") && computertype1.equals("ice")||movetype.equals("fighting") && computertype1.equals("normal")||movetype.equals("fighting") && computertype1.equals("rock")||movetype.equals("fighting") && computertype1.equals("steel")) {
			a=a*2;
		}
		if(movetype.equals("fire") && computertype1.equals("bug")||movetype.equals("fire") && computertype1.equals("grass")||movetype.equals("fire") && computertype1.equals("ice")||movetype.equals("fire") && computertype1.equals("steel")) {
			a=a*2;
		}
		if(movetype.equals("ghost") && computertype1.equals("ghost")||movetype.equals("ghost") && computertype1.equals("psychic")) {
			a=a*2;
		}
		if(movetype.equals("grass") && computertype1.equals("ground")||movetype.equals("grass") && computertype1.equals("rock")||movetype.equals("grass") && computertype1.equals("water")) {
			a=a*2;
		}
		if(movetype.equals("ground") && computertype1.equals("electric")||movetype.equals("ground") && computertype1.equals("fire")||movetype.equals("ground") && computertype1.equals("poison")||movetype.equals("ground") && computertype1.equals("rock")||movetype.equals("ground") && computertype1.equals("steel")) {
			a=a*2;
		}
		if(movetype.contentEquals("ice") && computertype1.contentEquals("dragon")||movetype.contentEquals("ice") && computertype1.contentEquals("flying")||movetype.contentEquals("ice") && computertype1.contentEquals("grass")||movetype.contentEquals("ice") && computertype1.contentEquals("ground")) {
			a=a*2;
		}
		if(movetype.equals("poison") && computertype1.contentEquals("grass")) {
			a=a*2;
		}
		if(movetype.equals("psychic") && computertype1.contentEquals("fighting")||movetype.equals("psychic") && computertype1.contentEquals("poison")) {
			a=a*2;
		}
		if(movetype.equals("rock") && computertype1.contentEquals("bug")||movetype.equals("rock") && computertype1.contentEquals("fire")||movetype.equals("rock") && computertype1.contentEquals("flying")||movetype.equals("rock") && computertype1.contentEquals("ice")) {
			a=a*2;
		}
		if(movetype.equals("steel") && computertype1.contentEquals("fairy")||movetype.equals("steel") && computertype1.contentEquals("ice")||movetype.equals("steel") && computertype1.contentEquals("rock")) {
			a=a*2;
		}
		if(movetype.contentEquals("water") && computertype1.contentEquals("fire") || movetype.contentEquals("water") && computertype1.contentEquals("ground") || movetype.contentEquals("water") && computertype1.contentEquals("rock")) {
			a=a*2;
		}
		if(movetype.contentEquals("normal") && computertype1.contentEquals("rock") || movetype.contentEquals("normal") && computertype1.contentEquals("steel")) {
			a=a/2;
		}
		if(movetype.equals("normal") && computertype1.equals("ghost")) {
			a=0;
		}
		if(movetype.contentEquals("ground") && computertype1.contentEquals("flying")) {
			a=0;
		}
		//bruh
		if(movetype.contentEquals("normal") && computertype2.contentEquals("rock") || movetype.contentEquals("normal") && computertype2.contentEquals("steel")) {
			a=a/2;
		}
		if(movetype.contentEquals("ground") && computertype2.contentEquals("flying")) {
			a=0;
		}
		if(movetype.equals("normal") && computertype2.equals("ghost")) {
			a=0;
		}
		if(movetype.equals("dark") && computertype2.equals("ghost")||movetype.equals("dark") && computertype2.equals("psychic")) {
			a=a*2;
		}
		if(movetype.equals("dragon") && computertype2.equals("dragon")) {
			a=a*2;
		}
		if(movetype.equals("electric") && computertype2.equals("flying")||movetype.equals("electric") && computertype2.equals("water")) {
			a=a*2;
		}
		if(movetype.equals("fighting") && computertype2.equals("dark")||movetype.equals("fighting") && computertype2.equals("ice")||movetype.equals("fighting") && computertype2.equals("normal")||movetype.equals("fighting") && computertype2.equals("rock")||movetype.equals("fighting") && computertype2.equals("steel")) {
			a=a*2;
		}
		if(movetype.equals("fire") && computertype2.equals("bug")||movetype.equals("fire") && computertype2.equals("grass")||movetype.equals("fire") && computertype2.equals("ice")||movetype.equals("fire") && computertype2.equals("steel")) {
			a=a*2;
		}
		if(movetype.equals("ghost") && computertype2.equals("ghost")||movetype.equals("ghost") && computertype2.equals("psychic")) {
			a=a*2;
		}
		if(movetype.equals("grass") && computertype2.equals("ground")||movetype.equals("grass") && computertype2.equals("rock")||movetype.equals("grass") && computertype2.equals("water")) {
			a=a*2;
		}
		if(movetype.equals("ground") && computertype2.equals("electric")||movetype.equals("ground") && computertype2.equals("fire")||movetype.equals("ground") && computertype2.equals("poison")||movetype.equals("ground") && computertype2.equals("rock")||movetype.equals("ground") && computertype2.equals("steel")) {
			a=a*2;
		}
		if(movetype.contentEquals("ice") && computertype2.contentEquals("dragon")||movetype.contentEquals("ice") && computertype2.contentEquals("flying")||movetype.contentEquals("ice") && computertype2.contentEquals("grass")||movetype.contentEquals("ice") && computertype2.contentEquals("ground")) {
			a=a*2;
		}
		if(movetype.equals("poison") && computertype2.contentEquals("grass")) {
			a=a*2;
		}
		if(movetype.equals("psychic") && computertype2.contentEquals("fighting")||movetype.equals("psychic") && computertype2.contentEquals("poison")) {
			a=a*2;
		}
		if(movetype.equals("rock") && computertype2.contentEquals("bug")||movetype.equals("rock") && computertype2.contentEquals("fire")||movetype.equals("rock") && computertype2.contentEquals("flying")||movetype.equals("rock") && computertype2.contentEquals("ice")) {
			a=a*2;
		}
		if(movetype.equals("steel") && computertype2.contentEquals("fairy")||movetype.equals("steel") && computertype2.contentEquals("ice")||movetype.equals("steel") && computertype2.contentEquals("rock")) {
			a=a*2;
		}
		if(movetype.contentEquals("water") && computertype2.contentEquals("fire") || movetype.contentEquals("water") && computertype2.contentEquals("ground") || movetype.contentEquals("water") && computertype2.contentEquals("rock")) {
			a=a*2;
		}
		//bruh
		if(movetype.contentEquals("normal") && computertype1.contentEquals("rock")||movetype.contentEquals("normal") && computertype1.contentEquals("ghost")||movetype.contentEquals("normal") && computertype1.contentEquals("steel")) {
			a=a/2;
		}
		if(movetype.contentEquals("fighting") && computertype1.contentEquals("flying") || movetype.contentEquals("fighting") && computertype1.contentEquals("poison") || movetype.contentEquals("fighting") && computertype1.contentEquals("psychic")|| movetype.contentEquals("fighting") && computertype1.contentEquals("bug") || movetype.contentEquals("fighting") && computertype1.contentEquals("ghost")) {
			a=a/2;
		}
		if(movetype.equals("poison") && computertype1.contentEquals("poison") || movetype.equals("poison") && computertype1.contentEquals("ground")||movetype.equals("poison") && computertype1.contentEquals("rock")||movetype.equals("poison") && computertype1.contentEquals("ghost")||movetype.equals("poison") && computertype1.contentEquals("steel")) {
			a=a/2;
		}
		if(movetype.contentEquals("ground") && computertype1.contentEquals("flying")||movetype.contentEquals("ground") && computertype1.contentEquals("bug")||movetype.contentEquals("ground") && computertype1.contentEquals("grass")) {
			a=a/2;
		}
		if(movetype.equals("rock") && computertype1.contentEquals("fighting")||movetype.equals("rock") && computertype1.contentEquals("ground")|| movetype.equals("rock") && computertype1.contentEquals("steel")) {
			a=a/2;
		}

		if(movetype.contentEquals("bug") && computertype1.contentEquals("fire") || movetype.contentEquals("bug") && computertype1.contentEquals("fighting") || movetype.contentEquals("bug") && computertype1.contentEquals("flying")|| movetype.contentEquals("bug") && computertype1.contentEquals("poison")|| movetype.contentEquals("bug") && computertype1.contentEquals("ghost")|| movetype.contentEquals("bug") && computertype1.contentEquals("steel")) {
			a=a/2;
		}
		if(movetype.equals("ghost") && computertype1.contentEquals("normal") || movetype.equals("ghost") && computertype1.contentEquals("dark")) {
			a=a/2;
		}
		if(movetype.equals("steel") && computertype1.equals("steel") || movetype.equals("steel") && computertype1.equals("fire") ||movetype.equals("steel") && computertype1.equals("water") ||movetype.equals("steel") && computertype1.equals("electric")) {
			a=a/2;
		}
		if(movetype.equals("fire") && computertype1.equals("rock")|| movetype.equals("fire") && computertype1.equals("fire") || movetype.equals("fire") && computertype1.equals("water") || movetype.equals("fire") && computertype1.equals("ground")) {
			a=a/2;
		}
		if(movetype.contentEquals("water") && computertype1.contentEquals("water")|| movetype.contentEquals("water") && computertype1.contentEquals("grass")||movetype.contentEquals("water") && computertype1.contentEquals("dragon")) {
			a=a/2;
		}
		if(movetype.equals("grass") && computertype1.contentEquals("flying") ||movetype.equals("grass") && computertype1.contentEquals("poison") ||movetype.equals("grass") && computertype1.contentEquals("bug") ||movetype.equals("grass") && computertype1.contentEquals("steel") ||movetype.equals("grass") && computertype1.contentEquals("fire") ||movetype.equals("grass") && computertype1.contentEquals("grass") ||movetype.equals("grass") && computertype1.contentEquals("dragon")) {
			a=a/2;
		}
		if(movetype.equals("electric") && computertype1.equals("ground") ||movetype.equals("electric") && computertype1.equals("grass") ||movetype.equals("electric") && computertype1.equals("electric")||movetype.equals("electric") && computertype1.equals("dragon")) {
			a=a/2;
		}
		if(movetype.equals("psychic") && computertype1.equals("steel") ||movetype.equals("psychic") && computertype1.equals("psychic")||movetype.equals("psychic") && computertype1.equals("dark")) {
			a=a/2;
		}
		if(movetype.equals("ice") && computertype1.equals("steel") || movetype.equals("ice") && computertype1.equals("fire")||movetype.equals("ice") && computertype1.equals("water")||movetype.equals("ice") && computertype1.equals("ice")) {
			a=a/2;
		}
		if(movetype.equals("dragon") && computertype1.equals("steel")) {
			a=a/2;
		}
		if(movetype.contentEquals("dark") && computertype1.contentEquals("fighting") || movetype.contentEquals("dark") && computertype1.contentEquals("dark")) {
			a=a/2;
		}
		//bruh
		if(movetype.contentEquals("normal") && computertype2.contentEquals("rock")||movetype.contentEquals("normal") && computertype2.contentEquals("ghost")||movetype.contentEquals("normal") && computertype2.contentEquals("steel")) {
			a=a/2;
		}
		if(movetype.contentEquals("fighting") && computertype2.contentEquals("flying") || movetype.contentEquals("fighting") && computertype2.contentEquals("poison") || movetype.contentEquals("fighting") && computertype2.contentEquals("psychic")|| movetype.contentEquals("fighting") && computertype2.contentEquals("bug") || movetype.contentEquals("fighting") && computertype2.contentEquals("ghost")) {
			a=a/2;
		}
		if(movetype.equals("poison") && computertype2.contentEquals("poison") || movetype.equals("poison") && computertype2.contentEquals("ground")||movetype.equals("poison") && computertype2.contentEquals("rock")||movetype.equals("poison") && computertype2.contentEquals("ghost")||movetype.equals("poison") && computertype2.contentEquals("steel")) {
			a=a/2;
		}
		if(movetype.contentEquals("ground") && computertype2.contentEquals("flying")||movetype.contentEquals("ground") && computertype2.contentEquals("bug")||movetype.contentEquals("ground") && computertype2.contentEquals("grass")) {
			a=a/2;
		}
		if(movetype.equals("rock") && computertype2.contentEquals("fighting")||movetype.equals("rock") && computertype2.contentEquals("ground")|| movetype.equals("rock") && computertype2.contentEquals("steel")) {
			a=a/2;
		}

		if(movetype.contentEquals("bug") && computertype2.contentEquals("fire") || movetype.contentEquals("bug") && computertype2.contentEquals("fighting") || movetype.contentEquals("bug") && computertype2.contentEquals("flying")|| movetype.contentEquals("bug") && computertype2.contentEquals("poison")|| movetype.contentEquals("bug") && computertype2.contentEquals("ghost")|| movetype.contentEquals("bug") && computertype2.contentEquals("steel")) {
			a=a/2;
		}
		if(movetype.equals("ghost") && computertype2.contentEquals("normal") || movetype.equals("ghost") && computertype2.contentEquals("dark")) {
			a=a/2;
		}
		if(movetype.equals("steel") && computertype2.equals("steel") || movetype.equals("steel") && computertype2.equals("fire") ||movetype.equals("steel") && computertype2.equals("water") ||movetype.equals("steel") && computertype2.equals("electric")) {
			a=a/2;
		}
		if(movetype.equals("fire") && computertype2.equals("rock")|| movetype.equals("fire") && computertype2.equals("fire") || movetype.equals("fire") && computertype2.equals("water") || movetype.equals("fire") && computertype2.equals("dragon")) {
			a=a/2;
		}
		if(movetype.contentEquals("water") && computertype2.contentEquals("water")|| movetype.contentEquals("water") && computertype2.contentEquals("grass")||movetype.contentEquals("water") && computertype2.contentEquals("dragon")) {
			a=a/2;
		}
		if(movetype.equals("grass") && computertype2.contentEquals("flying") ||movetype.equals("grass") && computertype2.contentEquals("poison") ||movetype.equals("grass") && computertype2.contentEquals("bug") ||movetype.equals("grass") && computertype2.contentEquals("steel") ||movetype.equals("grass") && computertype2.contentEquals("fire") ||movetype.equals("grass") && computertype2.contentEquals("grass") ||movetype.equals("grass") && computertype2.contentEquals("dragon")) {
			a=a/2;
		}
		if(movetype.equals("electric") && computertype2.equals("ground") ||movetype.equals("electric") && computertype2.equals("grass") ||movetype.equals("electric") && computertype2.equals("electric")||movetype.equals("electric") && computertype2.equals("dragon")) {
			a=a/2;
		}
		if(movetype.equals("psychic") && computertype2.equals("steel") ||movetype.equals("psychic") && computertype2.equals("psychic")||movetype.equals("psychic") && computertype2.equals("dark")) {
			a=a/2;
		}
		if(movetype.equals("ice") && computertype2.equals("steel") || movetype.equals("ice") && computertype2.equals("fire")||movetype.equals("ice") && computertype2.equals("water")||movetype.equals("ice") && computertype2.equals("ice")) {
			a=a/2;
		}
		if(movetype.equals("dragon") && computertype2.equals("steel")) {
			a=a/2;
		}
		if(movetype.contentEquals("dark") && computertype2.contentEquals("fighting") || movetype.contentEquals("dark") && computertype2.contentEquals("dark")) {
			a=a/2;
		}
		return a;
	}
	/*
	 * battlecomputer includes all the parts of the comptuer playing against you
	 */
	public static int battlecomputer (String [] Pokemon_user, String [] Pokemon_computer, String [] Pokemon_user_stats, String [] stats_computer, String [] moves_user, String [] moves_computer, String [] move_type_user, String [] moves_type_computer, String [] moves_dmg_user, String [] moves_dmg_computer, String [] moves_accuracy_user, String [] moves_accuracy_computer, int activeindexuser, int activeindexcomputer, String [] items_user, String [] items_computer, int [] uses, int [] status_user, int [] status_computer, int [] aliveordeadcomputer) {
		boolean skip = false; //for status moves
		boolean turnfinished = false; 
		int itemsused = uses[0]; //counts how many items used
		int b = activeindexcomputer; //b represents index of the active pokemon
		int activecomputerpokemonstatus = status_computer[b]; //represents computer pokemon's status
		int randomattack = (int)(Math.random()*(3-0+1)+0); //generates a random number for the attack it will use if it gets there
		int random = (int)(Math.random()*(10-1+1)+1); //generates a random number to either attack, switch, use item, etc.
		int newpokemon=0;
		System.out.println(random);
		while(turnfinished==false) {
			random = (int)(Math.random()*(10-1+1)+1); //generates a random thing to do as previously mentioned
			if(random>7 && random<=9) {//Computer will switch pokemon
				if(aliveordeadcomputer[0]==1 && aliveordeadcomputer[1]==1 ||aliveordeadcomputer[0]==1 && aliveordeadcomputer[2]==1 || aliveordeadcomputer[1]==1 && aliveordeadcomputer[0]==1 || aliveordeadcomputer[1]==1 && aliveordeadcomputer[2]==1 || aliveordeadcomputer[2]==1 && aliveordeadcomputer[0]==1 || aliveordeadcomputer[2]==1 && aliveordeadcomputer[1]==1) {
					newpokemon = (int)(Math.random()*(2-0+1)+0);
					while(newpokemon==b) { //if the pokemon that the user randomly generates is dead or already in play, generates it again
						newpokemon = (int)(Math.random()*(2-0+1)+0);
					}
					while(aliveordeadcomputer[newpokemon]==0) {
						newpokemon = (int)(Math.random()*(2-0+1)+0);
					}
					b=newpokemon; //updates active computer index (thus switching pokemon)
					System.out.println("Computer Switched Pokemon to " + Pokemon_computer[b].split(",")[0]);
					System.out.println("------------------------------------------------------------");
					return b; //returns active computer index (thus switching pokemon)
				}
				else {
					random = (int)(Math.random()*(10-1+1)+1);
					turnfinished=false;
				}
			}
			if(random>9) { //item use
				if(itemsused<3) {
					int randomitem = (int)(Math.random()*(2-0+1)+0);
					while(items_computer[randomitem].split(",")[1].equals("used")) {
						randomitem = (int)(Math.random()*(2-0+1)+0);
					}
					if(items_computer[randomitem].split(",")[0].equals("Potion")) {//if random selection is potion
						int HP = (int)(Integer.parseInt(stats_computer[activeindexcomputer].split(",")[0]) + 50); //heal computer hp by 50
						stats_computer[b] = HP + "," + stats_computer[b].split(",")[1] + "," + stats_computer[b].split(",")[2] + "," + stats_computer[b].split(",")[3] + "," + stats_computer[b].split(",")[4] + "," + stats_computer[b].split(",")[5];   
						System.out.println("Computer used Potion on " + Pokemon_computer[activeindexcomputer].split(",")[0]);
					}
					if(items_computer[randomitem].split(",")[0].equals("Awakening")) {
						if(status_computer[b]==4) {
							status_computer[b] = 0;
							System.out.println("Computer used Awaken! " + Pokemon_computer[activeindexcomputer].split(",")[0] + " woke up from its sleep!");
						}
						else {
							System.out.println("Computer used Awaken! However, " + Pokemon_computer[activeindexcomputer].split(",")[0] + " was not asleep!");
						}
					}
					if(items_computer[randomitem].split(",")[0].equals("Ice Heal")) {
						if(status_computer[b]==3) {
							status_computer[b] = 0;
							System.out.println("Computer used Ice Heal! " + Pokemon_computer[activeindexcomputer].split(",")[0] + " thawed out!");
						}
						else {
							System.out.println("Computer used Ice Heal! However, " + Pokemon_computer[activeindexcomputer].split(",")[0] + " was not frozen!");
						}
					}
					if(items_computer[randomitem].split(",")[0].equals("Paralyz Heal")) {
						if(status_computer[b]==2) {
							status_computer[b] = 0;
							System.out.println("Computer used Paralyz Heal! " + Pokemon_computer[activeindexcomputer].split(",")[0] + " is no longer paralyzed!");
						}
						else {
							System.out.println("Computer used Paralyz Heal! However, " + Pokemon_computer[activeindexcomputer].split(",")[0] + " was not paralyzed!");
						}
					}
					if(items_computer[randomitem].split(",")[0].equals("Burn Heal")) {
						if(status_computer[b]==4) {
							status_computer[b] = 0;
							System.out.println("Computer used Burn Heal! " + Pokemon_computer[activeindexcomputer].split(",")[0] + " stopped burning!");
						}
						else {
							System.out.println("Computer used Burn Heal! However, " + Pokemon_computer[activeindexcomputer].split(",")[0] + " was not burning!");
						}
					}
					System.out.println("------------------------------------------------------------");
					items_computer[randomitem] = items_user[randomitem].split(",")[0] + ",used"; 
					uses[0] = uses[0] + 1;
					turnfinished=true;
				}
				else {
					turnfinished=false;
				}
			}
			if(random<=7) { //attack
				if(activecomputerpokemonstatus==1) { //poison
					int HP = (int)(Integer.parseInt(stats_computer[b].split(",")[0]) - 15); //deal 15 damage to health
					stats_computer[b] = HP + "," + stats_computer[b].split(",")[1] + "," + stats_computer[b].split(",")[2] + "," + stats_computer[b].split(",")[3] + "," + stats_computer[b].split(",")[4] + "," + stats_computer[b].split(",")[5]; 
					System.out.println("Computer's " + Pokemon_computer[b].split(",")[0] + " took 15 damage from its poison");
				}
				if(activecomputerpokemonstatus==2) { //paralysis
					int chance = (int)(Math.random()*(100-1+1)+1);
					if(chance<=25) {
						skip = true;
						System.out.println("Computer's " + Pokemon_computer[b].split(",")[0] + " is paralyzed and can't move!");
					}
					else {
					}
				}
				if(activecomputerpokemonstatus==3) { //frozen
					skip = true;
					int chance = (int)(Math.random()*(100-1+1)+1);
					if(chance<=15) {
						skip = false;
						status_computer[b] = 0;
						System.out.println("Computer's " + Pokemon_computer[b].split(",")[0] + " thawed out!");
					}
					else {
						System.out.println("Computer's " + Pokemon_computer[b].split(",")[0] + " is frozen and can't move!");
					}
				}
				if(activecomputerpokemonstatus==4) { //sleep
					skip = true;
					int chance = (int)(Math.random()*(100-1+1)+1);
					if(chance<=33) {
						skip = false;
						System.out.println("Computer's " + Pokemon_computer[b].split(",")[0] + " woke up!");
						status_computer[b] = 0;
					}
					else {
						System.out.println("Computer's " + Pokemon_computer[b].split(",")[0] + " is asleep!");
					}
					if(activecomputerpokemonstatus==4 && moves_computer[b].split(",")[randomattack].equals("Sleep Talk")) {
						double modifier = 1; 
						double attackpower = Integer.parseInt(moves_dmg_computer[b].split(",")[randomattack]);
						double attack = Integer.parseInt(stats_computer[b].split(",")[1]);
						double defense = Integer.parseInt(Pokemon_user_stats[activeindexuser].split(",")[2]);
						if(Pokemon_user[activeindexuser].split(",")[0].equals("Blastoise")||Pokemon_user[activeindexuser].split(",")[0].equals("Snorlax")||Pokemon_user[activeindexuser].split(",")[0].equals("Alakazam")) {
							modifier = modifier1(moves_type_computer[activeindexcomputer].split(",")[randomattack],Pokemon_user[activeindexuser].split(",")[1]);
						}
						else {
							modifier = modifier2(moves_type_computer[activeindexcomputer].split(",")[randomattack],Pokemon_user[activeindexuser].split(",")[1], Pokemon_user[activeindexuser].split(",")[2]);
						}
						double damagetest = 0.5*attackpower*(attack/defense)*modifier;
						int damagebycomputer = (int)(damagetest);
						String s = Integer.parseInt(Pokemon_user_stats[activeindexuser].split(",")[0])- damagebycomputer + "," + Pokemon_user_stats[activeindexuser].split(",")[1] + "," + Pokemon_user_stats[activeindexuser].split(",")[2] + "," + Pokemon_user_stats[activeindexuser].split(",")[3] + "," + Pokemon_user_stats[activeindexuser].split(",")[4] + "," + Pokemon_user_stats[activeindexuser].split(",")[5];
						int accuracy = (int)(Math.random()*(100-0+1)+0);
						if(accuracy<=Integer.parseInt(moves_accuracy_computer[activeindexcomputer].split(",")[randomattack])) {
							Pokemon_user_stats[activeindexuser]=s;
							if(modifier>1) {
								System.out.println("Computer's " + Pokemon_computer[b].split(",")[0] + " used sleep talk! It did " + damagebycomputer + " damage! It was Super Effective!");
							}
							if(modifier==1) {
								System.out.println("Computer's " + Pokemon_computer[b].split(",")[0] + " used sleep talk! It did " + damagebycomputer + " damage!");
							}
							if(modifier<1) {
								System.out.println("Computer's " + Pokemon_computer[b].split(",")[0] + " used sleep talk! It did " + damagebycomputer + " damage! It was Not Very Effective!");
							}
						}
						else {
							System.out.println("Computer's " + Pokemon_computer[b].split(",")[0] + " used sleep talk! However, it missed! ");
						}
						turnfinished=true;
					}
					if(activecomputerpokemonstatus!=4 && moves_computer[b].split(",")[randomattack].equals("Sleep Talk")) {
						System.out.println("Computer's Snorlax woke up! Sleep Talk Failed");
					}
				}
				if(activecomputerpokemonstatus==5) { //burn
					int HP = (int)(Integer.parseInt(stats_computer[b].split(",")[0]) - 15); //deal 15 damage from burn
					stats_computer[b] = HP + "," + stats_computer[b].split(",")[1] + "," + stats_computer[b].split(",")[2] + "," + stats_computer[b].split(",")[3] + "," + stats_computer[b].split(",")[4] + "," + stats_computer[b].split(",")[5]; 
					System.out.println("Computer's " + Pokemon_computer[b].split(",")[0] + " took 15 damage from its burn");
				}
				if(skip==false) {
					String attackname = moves_computer[b].split(",")[randomattack];
					if(attackname.contentEquals("Growth") || attackname.contentEquals("Rest") || attackname.contentEquals("Calm Mind") || attackname.contentEquals("Sleep Talk") || attackname.contentEquals("Sword Dance") || attackname.contentEquals("Dragon Dance")) {
						if(attackname.contentEquals("Growth")) {
							int newattack = (int)(Integer.parseInt(stats_computer[b].split(",")[1])*1.5);
							int newspecialattack = (int)(Integer.parseInt(stats_computer[b].split(",")[3])*1.5);
							stats_computer[b] = stats_computer[b].split(",")[0] + "," + newattack + "," + stats_computer[b].split(",")[2] + "," + newspecialattack + "," + stats_computer[b].split(",")[4] + "," + stats_computer[b].split(",")[5];
							System.out.println("Computer used Growth!");
							turnfinished=true;
						}
						if(attackname.contentEquals("Rest")) {
							int newhp = (int)(Integer.parseInt(stats_computer[b].split(",")[0]) + 150);
							stats_computer[b] = newhp + "," + stats_computer[b].split(",")[1] + "," + stats_computer[b].split(",")[2] + "," + stats_computer[b].split(",")[3] + "," + stats_computer[b].split(",")[4] + "," +stats_computer[b].split(",")[5];
							status_computer[b] = 4;
							System.out.println("Computer used Rest!");
							turnfinished=true;

						}
						if(attackname.contentEquals("Calm Mind")) {
							int newspecialattack = (int)(Integer.parseInt(stats_computer[b].split(",")[3]) *1.5);
							int newspecialdefense  = (int)(Integer.parseInt(stats_computer[b].split(",")[4]) *1.5);
							stats_computer[b] = stats_computer[b].split(",")[0] + "," + stats_computer[b].split(",")[1] + "," + stats_computer[b].split(",")[2] + "," + newspecialattack + "," + newspecialdefense + "," +stats_computer[b].split(",")[5];
							System.out.println("Computer used Calm Mind!");
							turnfinished=true;
						}
						if(attackname.equals("Sword Dance")) {
							int newattack = (int)(Integer.parseInt(stats_computer[b].split(",")[1]) *1.5);
							stats_computer[b] = stats_computer[b].split(",")[0] + "," + newattack + "," + stats_computer[b].split(",")[2] + "," + stats_computer[b].split(",")[3] + "," + stats_computer[b].split(",")[4] + "," +stats_computer[b].split(",")[5];
							System.out.println("Computer used Sword Dance!");
							turnfinished=true;
						}
						if(attackname.contentEquals("Dragon Dance")) { //if growth is used
							int newattack = (int)(Integer.parseInt(stats_computer[b].split(",")[1])*2); //attack is buffed
							stats_computer[b] = stats_computer[b].split(",")[0] + "," + newattack + "," + stats_computer[b].split(",")[2] + "," + stats_computer[b].split(",")[3] + "," + stats_computer[b].split(",")[4] + "," + stats_computer[b].split(",")[5]; //new stats are assigned to user pokemon
							System.out.println("Computer's " + Pokemon_computer[b].split(",")[0] + " used Dragon Dance! Attack sharply raised!");
							turnfinished=true;
						}
					} 
					else {
						String attacktype = PhysicalOrSpecial(moves_computer[b].split(",")[randomattack]);
						if(attacktype.equals("Special")) {
							double modifier = 1;
							double attackpower = Integer.parseInt(moves_dmg_computer[b].split(",")[randomattack]);
							double specialattack =  Integer.parseInt(stats_computer[b].split(",")[3]);
							double specialdefense = Integer.parseInt(Pokemon_user_stats[activeindexuser].split(",")[4]);
							if(Pokemon_user[activeindexuser].split(",")[0].equals("Blastoise")||Pokemon_user[activeindexuser].split(",")[0].equals("Snorlax")||Pokemon_user[activeindexuser].split(",")[0].equals("Alakazam")) {
								modifier = modifier1(moves_type_computer[b].split(",")[randomattack],Pokemon_user[activeindexuser].split(",")[1]);
							}
							else {
								modifier = modifier2(moves_type_computer[b].split(",")[randomattack],Pokemon_user[activeindexuser].split(",")[1], Pokemon_user[activeindexuser].split(",")[2]);
							}
							double damagetest = 0.5*attackpower*(specialattack/specialdefense)*modifier;
							int damagebycomputer = (int) (damagetest);
							String s = Integer.parseInt(Pokemon_user_stats[activeindexuser].split(",")[0])-damagebycomputer + "," + Pokemon_user_stats[activeindexuser].split(",")[1] + "," + Pokemon_user_stats[activeindexuser].split(",")[2] + "," + Pokemon_user_stats[activeindexuser].split(",")[3] + "," + Pokemon_user_stats[activeindexuser].split(",")[4] + "," + Pokemon_user_stats[activeindexuser].split(",")[5];
							int accuracy = (int)(Math.random()*(100-0+1)+0);
							if(accuracy<=Integer.parseInt(moves_accuracy_computer[b].split(",")[randomattack])) {
								Pokemon_user_stats[activeindexuser] = s;
								if(modifier>1) {
									System.out.println(Pokemon_computer[activeindexcomputer].split(",")[0] + " used " + moves_computer[activeindexcomputer].split(",")[randomattack] + " on " + Pokemon_user[activeindexuser].split(",")[0] + ". It did " + damagebycomputer + " damage. It was Super Effective!");
								}
								if(modifier==1) {
									System.out.println(Pokemon_computer[activeindexcomputer].split(",")[0] + " used " + moves_computer[activeindexcomputer].split(",")[randomattack] + " on " + Pokemon_user[activeindexuser].split(",")[0] + ". It did " + damagebycomputer + " damage.");
								}
								if(modifier<1) {
									System.out.println(Pokemon_computer[activeindexcomputer].split(",")[0] + " used " + moves_computer[activeindexcomputer].split(",")[randomattack] + " on " + Pokemon_user[activeindexuser].split(",")[0] + ". It did " + damagebycomputer + " damage. It was not Very Effective!");
								}
								if(attackname.contentEquals("Firepunch")) {
									int burnchance = (int)(Math.random()*(100-1+1)+1);
									if(burnchance<=10) {
										status_user[activeindexuser]=5;
										System.out.println(Pokemon_user[activeindexuser].split(",")[0] + " is burning");
									}
								}
								if(attackname.contentEquals("Hidden Power[Fire]")) {
									int burnchance = (int)(Math.random()*(100-1+1)+1);
									if(burnchance<=10) {
										status_user[activeindexuser]=5;
										System.out.println(Pokemon_user[activeindexuser].split(",")[0] + " is burning");
									}
								}
								if(attackname.contentEquals("Scald")) {
									int burnchance = (int)(Math.random()*(100-1+1)+1);
									if(burnchance<=10) {
										status_user[activeindexuser]=5;
										System.out.println(Pokemon_user[activeindexuser].split(",")[0] + " is burning");
									}
								}
								if(attackname.contentEquals("Ice Beam")) {
									int freezechance = (int)(Math.random()*(100-1+1)+1);
									if(freezechance<=10) {
										status_user[activeindexuser]=3;
										System.out.println(Pokemon_user[activeindexuser].split(",")[0] + " is frozen");
									}
								}
								if(attackname.contentEquals("Thunderbolt")) {
									int parachance = (int)(Math.random()*(100-1+1)+1);
									if(parachance<=10) {
										status_user[activeindexuser]=2;
										System.out.println(Pokemon_user[activeindexuser].split(",")[0] + " is paralyzed");
									}
								}
							}
							else {
								System.out.println("Computer tried to use " + attackname + " but it missed!");
								turnfinished=true;
							}
							turnfinished=true;
						}
						else {
							double modifier = 1; 
							double attackpower = Integer.parseInt(moves_dmg_computer[b].split(",")[randomattack]);
							double attack = Integer.parseInt(stats_computer[b].split(",")[1]);
							double defense = Integer.parseInt(Pokemon_user_stats[activeindexuser].split(",")[2]);
							if(Pokemon_user[activeindexuser].split(",")[0].equals("Blastoise")||Pokemon_user[activeindexuser].split(",")[0].equals("Snorlax")||Pokemon_user[activeindexuser].split(",")[0].equals("Alakazam")) {
								modifier = modifier1(moves_type_computer[b].split(",")[randomattack],Pokemon_user[activeindexuser].split(",")[1]);
							}
							else {
								modifier = modifier2(moves_type_computer[b].split(",")[randomattack],Pokemon_user[activeindexuser].split(",")[1], Pokemon_user[activeindexuser].split(",")[2]);
							}
							double damagetest = 0.5*attackpower*(attack/defense)*modifier;
							int damagebycomputer = (int)(damagetest);
							String s = Integer.parseInt(Pokemon_user_stats[activeindexuser].split(",")[0])-damagebycomputer + "," + Pokemon_user_stats[activeindexuser].split(",")[1] + "," + Pokemon_user_stats[activeindexuser].split(",")[2] + "," + Pokemon_user_stats[activeindexuser].split(",")[3] + "," + Pokemon_user_stats[activeindexuser].split(",")[4] + "," + Pokemon_user_stats[activeindexuser].split(",")[5];
							int accuracy = (int)(Math.random()*(100-0+1)+0);
							if(accuracy<=Integer.parseInt(moves_accuracy_computer[b].split(",")[randomattack])) {
								Pokemon_user_stats[activeindexuser] = s;
								if(modifier>1) {
									System.out.println(Pokemon_computer[activeindexcomputer].split(",")[0] + " used " + moves_computer[activeindexcomputer].split(",")[randomattack] + " on " + Pokemon_user[activeindexuser].split(",")[0] + ". It did " + damagebycomputer + " damage. It was Super Effective!");
								}
								if(modifier==1) {
									System.out.println(Pokemon_computer[activeindexcomputer].split(",")[0] + " used " + moves_computer[activeindexcomputer].split(",")[randomattack] + " on " + Pokemon_user[activeindexuser].split(",")[0] + ". It did " + damagebycomputer + " damage.");
								}
								if(modifier<1) {
									System.out.println(Pokemon_computer[activeindexcomputer].split(",")[0] + " used " + moves_computer[activeindexcomputer].split(",")[randomattack] + " on " + Pokemon_user[activeindexuser].split(",")[0] + ". It did " + damagebycomputer + " damage. It was not Very Effective!");
								}
							}
							else {
								System.out.println("Computer tried to use " + attackname + " but it missed");
								turnfinished=true;
							}
							turnfinished=true;
						}
					}
				}
				System.out.println("------------------------------------------------------------");
				turnfinished=true;
			}
		}
		return b;
	}
	}

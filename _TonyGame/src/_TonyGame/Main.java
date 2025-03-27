	package _TonyGame;
	import java.util.Scanner;
	import java.util.Random;
	
	public class Main {
		public static void main(String[] args) {
			//This will be my attempt at a short game. It will be console driven.
			
			//Here, I initialize all the variables I will be using in this program.
			
			Scanner scanner = new Scanner(System.in);
			Random random = new Random();
			
			int itemA = 0;
			int itemB = 0;
			int itemC = 0;
			int itemD = 0;
			int isRightWay = 0;
			int totalDamage = 0;
			int bossHealth = random.nextInt(10, 15+1);
			
			boolean isInWoods = false;
			boolean north = false;
			boolean south = false;
			boolean east = false;
			boolean west = false;
			boolean itemAClaimed = false;
			boolean itemBClaimed = false;
			boolean itemCClaimed = false;
			boolean itemDClaimed = false;
			boolean hasStartedGame = false;
			
			boolean choseCorrectly = false;
			
			boolean pickUp = false;
			
			String direction = "";
			String inputDirection = "";
			String action = "";
			String isReadyForBoss = "";
			
//This is where I start randomizing item numbers for unique item damages.
			
			itemA = random.nextInt(1, 10+1);
			itemB = random.nextInt(1, 10+1);
			itemC = random.nextInt(1, 10+1);
			itemD = random.nextInt(1, 10+1);
			isRightWay = random.nextInt(1, 4+1);
			
//The 'correct' direction is created.
			if(isRightWay == 1) {
				direction = "north";
				north = true;
			}
			else if(isRightWay == 2) {
				direction = "south";
				south = true;
			}
			else if(isRightWay == 3) {
				direction = "east";
				east = true;	
			}
			else if(isRightWay == 4) {
				direction = "west";
				west = true;
			}
//ensures all the items are different in terms of damage. if all the items are different, you may start the game.
			System.out.println(direction);	
			
			if(itemA == itemB || itemB == itemA || itemC == itemA || itemD == itemA || itemD == itemB || itemD == itemC) {
				do {
					itemA = random.nextInt(1, 10+1);
					itemB = random.nextInt(1, 10+1);
					itemC = random.nextInt(1, 10+1);
					itemD = random.nextInt(1, 10+1);
				} while(itemA == itemB || itemB == itemA || itemC == itemA || itemD == itemA || itemD == itemB || itemD == itemC);
				System.out.print("Please enter 'start' to begin the game... ");
			}
			else {
				 System.out.print("Please enter 'start' to begin the game... ");
			}
			
			inputDirection = scanner.nextLine();
			inputDirection = inputDirection.toLowerCase();
			
//checks if the player is ready to begin
			if(inputDirection.contains("start")) {
				hasStartedGame = true;
			}
			else {
				do {
					System.out.print("Please enter 'start' to begin: ");
					inputDirection = scanner.nextLine();
					inputDirection = inputDirection.toLowerCase();
					hasStartedGame = true;
				}while(!inputDirection.contains("start"));
			}
//here is the beginning of the code after starting the game.
		if(hasStartedGame) {	
			do {
			do {
				inputDirection = "";
				System.out.println("You wake up in the woods. Enter a direction (north, south, east, west). ");
				inputDirection = scanner.nextLine();
				inputDirection = inputDirection.toLowerCase();
				if(!inputDirection.contains("north") && !inputDirection.contains("south") && !inputDirection.contains("east") && !inputDirection.contains("west")) {
				
					do {
//ensures user enters a valid direction. if the user doesn't enter a valid direction, then it prompts for a valid user entry.						
						System.out.print("Please enter a valid direction: ");
						inputDirection = scanner.nextLine();
						inputDirection = inputDirection.toLowerCase();
						
					}while(!inputDirection.contains("north") && !inputDirection.contains("south") && !inputDirection.contains("east") && !inputDirection.contains("west"));
				}

				do {
					
					
//user inputs the direction, if it is 'correct' then you proceed to the boss					
					if(north && inputDirection.contains("north")) {
							System.out.println("You chose right");
							System.out.println("Are you ready for the boss? (Y/N): ");
							choseCorrectly = true;
					}
					else if(south && inputDirection.contains("south")) {
							System.out.println("You chose right");
							System.out.println("Are you ready for the boss? (Y/N): ");
							choseCorrectly = true;
					}
					else if(east && inputDirection.contains("east")) {
							System.out.println("You chose right");
							System.out.println("Are you ready for the boss? (Y/N): ");
							choseCorrectly = true;
					}
					else if(west && inputDirection.contains("west")) {
							System.out.println("You chose correctly");
							System.out.println("Are you ready for the boss? (Y/N): ");
							choseCorrectly = true;
					}
//if the user doesn't choose correctly, then you still go that direction to pick up a damage value that is added to your damage total.
//north				
					if(!inputDirection.contains("north") && !inputDirection.contains("south") && !inputDirection.contains("east") && !inputDirection.contains("west") && !isInWoods) {
						do {
					
							System.out.println("Please enter a direction: ");
							inputDirection = "";
							inputDirection = scanner.nextLine();
							inputDirection = inputDirection.toLowerCase();
							isInWoods = true;
						}while(!inputDirection.contains("north") && !inputDirection.contains("south") && !inputDirection.contains("east") && !inputDirection.contains("west"));
					}
					else if(isInWoods) {
						
						System.out.print("Please enter a direction. (North, south, east west).: ");
						inputDirection = scanner.nextLine();
						inputDirection = inputDirection.toLowerCase();
						isInWoods = false;
					}
					
					if(!north && inputDirection.contains("north") && !isInWoods) {
							System.out.print("This is not where you want to be, however, you find a " + itemA + ". Do you want to pick it up? (Y/N): ");
							choseCorrectly = false;
							action = scanner.nextLine();
							action = action.toLowerCase();
							if(action.contains("y")) {
							do {
								
								if(action.contains("y") && itemAClaimed == false) {
									System.out.println("You picked up the " + itemA);
									totalDamage = totalDamage + itemA;
									itemAClaimed = true;
								}
								else if(action.contains("y") && itemAClaimed == true) {
									System.out.println("You have already picked up this item!");
								}
								else if(action.contains("n")) {
									System.out.println("You did not pick up the " + itemA);
								}
								else {
									do {
										System.out.print("Please enter a valid user input: (Y/N)");
										action = scanner.nextLine();
										action = action.toLowerCase();
										
									}while(!action.contains("y"));
									
								}
								System.out.print("Are you ready to leave? (Y/N): ");
								action = scanner.nextLine();
								action = action.toLowerCase();
								if(action.contains("n")) {
									do {
										action = "";
										System.out.println("Please enter 'y' when you're ready to leave...: ");
										action = scanner.nextLine();
										action = action.toLowerCase();
										
									}while(!action.contains("y"));
									
								}
							}while(!action.contains("y"));
							}
							action = "";
							System.out.println("Would you like to go to the last tile? (Y/N): ");
							action = scanner.nextLine();
							action = action.toLowerCase();
							do {
								if(action.contains("y")) {
									System.out.println("You return to the main woods.");
									action = "";
									inputDirection = "";
								}
								else if(action.contains("n")) {
									System.out.println("You chose to stay.");
									System.out.print("Please inform me when you would like to go back: ");
									action = scanner.nextLine();
									action = action.toLowerCase();
								}
							}while(action.contains("n"));
							
						}
					
//south
					else if(!south && inputDirection.contains("south")) {
						System.out.print("This is not where you want to be, however, you find a " + itemB + ". Do you want to pick it up? (Y/N): ");
						choseCorrectly = false;
						action = scanner.nextLine();
						action = action.toLowerCase();
						
						do {
							
							
							if(action.contains("y") && itemBClaimed == false) {
								System.out.println("You picked up the " + itemB);
								totalDamage = totalDamage + itemB;
								itemBClaimed = true;
							}
							else if(action.contains("y") && itemBClaimed == true) {
								System.out.println("You have already picked up this item!");
							}
							else if(action.contains("n")) {
								System.out.println("You did not pick up the " + itemB);
							}
							else {
								do {
									System.out.print("Please enter a valid user input: (Y/N)");
									action = scanner.nextLine();
									action = action.toLowerCase();
								}while(!action.contains("y") && !action.contains("n"));
								
							}
							System.out.print("Are you ready to leave? (Y/N): ");
							action = scanner.nextLine();
							action = action.toLowerCase();
							if(action.contains("n")) {
								do {
									action = "";
									System.out.println("Please enter 'y' when you're ready to leave...: ");
									action = scanner.nextLine();
									action = action.toLowerCase();
									
								}while(!action.contains("y"));
								
							}
							
						}while(!action.contains("y"));
						action = "";
						System.out.println("Would you like to go to the last tile? (Y/N): ");
						action = scanner.nextLine();
						action = action.toLowerCase();
						do {
							if(action.contains("y")) {
								System.out.println("You return to the main woods.");
								action = "";
								inputDirection = "";
							}
							else if(action.contains("n")) {
								System.out.println("You chose to stay.");
								System.out.print("Please inform me when you would like to go back: ");
								action = scanner.nextLine();
								action = action.toLowerCase();
							}
						}while(action.contains("n"));
//east						
					}else if(!east && inputDirection.contains("east")) {
						System.out.print("This is not where you want to be, however, you find a " + itemC + ". Do you want to pick it up? (Y/N): ");
						choseCorrectly = false;
						action = scanner.nextLine();
						action = action.toLowerCase();
						
						do {
							if(action.contains("y") && itemCClaimed == false) {
								System.out.println("You picked up the " + itemC);
								totalDamage = totalDamage + itemC;
								itemCClaimed = true;
								action = "";
							}
							else if(itemCClaimed == true && action.contains("y")) {
								System.out.println("You have already picked up this item!");
							}
							else if(action.contains("n")) {
								System.out.println("You did not pick up the " + itemC);
							}
							else {
								do {
									System.out.print("Please enter a valid user input: (Y/N)");
									action = scanner.nextLine();
									action = action.toLowerCase();
								}while(!action.contains("y") && !action.contains("n"));
								action = "";
							}
							System.out.print("Are you ready to leave? (Y/N): ");
							action = scanner.nextLine();
							action = action.toLowerCase();
							if(action.contains("n")) {
								do {
									action = "";
									System.out.println("Please enter 'y' when you're ready to leave...: ");
									action = scanner.nextLine();
									action = action.toLowerCase();
									
								}while(!action.contains("y"));
								
							}
							
							
						}while(!action.contains("y"));
						action = "";
						System.out.println("Would you like to go to the last tile? (Y/N): ");
						action = scanner.nextLine();
						action = action.toLowerCase();
						do {
							if(action.contains("y")) {
								System.out.println("You return to the main woods.");
								action = "";
								inputDirection = "";
							}
							else if(action.contains("n")) {
								System.out.println("You chose to stay.");
								System.out.print("Please inform me when you would like to go back: ");
								action = scanner.nextLine();
								action = action.toLowerCase();
							}
						}while(action.contains("n"));
//west						
					}else if(!west && inputDirection.contains("west")) {
						System.out.print("This is not where you want to be, however, you find a " + itemD + ". Do you want to pick it up? (Y/N): ");
						choseCorrectly = false;
						action = "";
						action = scanner.nextLine();
						action = action.toLowerCase();
						
						do {
							
							
							
							if(action.contains("y") && itemDClaimed == false) {
								System.out.println("You picked up the " + itemD);
								totalDamage = totalDamage + itemD;
								itemDClaimed = true;
							}
							else if(action.contains("y") && itemDClaimed == true) {
								System.out.println("You have already picked up this item!");
							}
							else if(action.contains("n")) {
								System.out.println("You did not pick up the " + itemD);
							}
							else {
								do {
									System.out.print("Please enter a valid user input: (Y/N)");
									action = scanner.nextLine();
									action = action.toLowerCase();
								}while(!action.contains("y") || !action.contains("n"));
								action = "";
							}
							System.out.print("Are you ready to leave? (Y/N): ");
							action = scanner.nextLine();
							action = action.toLowerCase();
							if(action.contains("n")) {
								do {
									action = "";
									System.out.println("Please enter 'y' when you're ready to leave...: ");
									action = scanner.nextLine();
									action = action.toLowerCase();
									
								}while(!action.contains("y"));
								
							}
										
								}while(!action.contains("y") || action.contains("n"));
								action = "";
								System.out.println("Would you like to go to the last tile? (Y/N): ");
								action = scanner.nextLine();
								action = action.toLowerCase();
								do {
									if(action.contains("y")) {
										System.out.println("You return to the main woods.");
										action = "";
										inputDirection = "";
									}
									else if(action.contains("n")) {
										System.out.println("You chose to stay.");
										System.out.print("Please inform me when you would like to go back: ");
										action = scanner.nextLine();
										action = action.toLowerCase();
									}
								}while(action.contains("n"));
								
							}
							}while(!choseCorrectly);
						
						System.out.print("You have a damage value of " + totalDamage +", are you sure you're ready? (Y/N): ");
						isReadyForBoss = scanner.nextLine();
						isReadyForBoss = isReadyForBoss.toLowerCase();
						
					}while(!choseCorrectly && isReadyForBoss.contains("y"));
		
				}while(isReadyForBoss.contains("n") && !choseCorrectly);
		}
				else {
					do {
					System.out.print("Please enter a valid user input (Start)");
					inputDirection = scanner.nextLine();
					inputDirection = inputDirection.toLowerCase();
					}while(!inputDirection.contains("start"));
					hasStartedGame = true;
				}
			if(choseCorrectly && isReadyForBoss.contains("y")) {
				System.out.print("The boss has " + bossHealth + " health.");
				if(bossHealth > totalDamage) {
					System.out.println("You lost!!!");
				}
				else {
					System.out.println("You Won! Congrats!!!");
				}
			}
			scanner.close();
			scanner.close();
		}
	}
		

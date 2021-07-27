/**
 *
 * @author  Joe McAdams
 * @email   joedmcadams@gmail.com
 * @date    7/27/21
 * @purpose Rock paper scissors assessment for Java bootcamp
 */

package com.jdm.rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        boolean exit = false;
        int playerChoice, rounds, ties, playerWins, compWins, result;
        String playAgain;
        
        do{
            //Statistic variable initialization
            playerWins = 0;
            compWins = 0;
            ties = 0;
            
            System.out.println("How many rounds would you like to play? ");
            
            //Input and validation
            try{
                rounds = Integer.parseInt(scanner.nextLine());
            }
            catch(NumberFormatException ex){
                System.out.println("That's not a number.");
                continue;
            }
            
            //Round limit validation
            if(rounds < 1 || rounds > 10){
                System.out.println("That is an invalid number of rounds. Range is 1-10. Quitting.");
                break;
            }
            
            //Play game
            else{
                for(int i = 0; i < rounds; i++){
                    System.out.println("Choose your \"hand\", 1 = rock, 2 = paper, 3 = scissors");
                    
                    //Input and validation
                    try{
                        playerChoice = Integer.parseInt(scanner.nextLine());
                    }
                    catch(NumberFormatException ex){
                        System.out.println("That's not a number.");
                        i--;
                        continue;
                    }
                    
                    //Legal hand validation
                    if(playerChoice < 1 || playerChoice > 3){
                        System.out.println("That's not a valid hand choice.");
                        i--;
                        continue;
                    }
                    
                    else{
                        result = playRound(playerChoice);
                        switch(result){
                            case 1: playerWins++;
                                    System.out.println("You won this round!");
                                    break;
                            case 2: compWins++;
                                    System.out.println("Computer won this round.");
                                    break;
                            case 3: ties++;
                                    System.out.println("This round was a draw.");
                                    break;
                        }
                        System.out.println();
                    }
                }
                
                //Output statistics for all rounds and calculate winner
                System.out.println("Player wins: " + playerWins + ", Computer wins: " + compWins + ", Ties: " + ties);
                if(playerWins > compWins){
                    System.out.println("You won!");
                }
                else if(playerWins == compWins){
                    System.out.println("You tied!");
                }
                else{
                    System.out.println("The computer won.");
                }
                
                //Play again?
                System.out.println();
                System.out.println("Would you like to play again? Type \"n\" or \"no\" to exit or anything else to play again.");
                playAgain = scanner.nextLine();
                if(playAgain.toLowerCase().equals("n") || playAgain.toLowerCase().equals("no")){
                    System.out.println("Thanks for playing!");
                    exit = true;
                }
            }
        }while(!exit);
    }
    
    public static int playRound(int playerChoice){
        Random rng = new Random();
        int result, compChoice; //1 = player win, 2 = computer win, 3 = tie
        
        compChoice = rng.nextInt(2) + 1;
        if(compChoice == 1){
            System.out.println("Computer chose rock");
        }
        else if(compChoice == 2){
            System.out.println("Computer chose paper");
        }
        else{
            System.out.println("Computer chose scissors");
        }
                                                            //player vs comp
        if(playerChoice == 1 && compChoice == 3){           //rock vs scissors
            result = 1;
        }
        else if(playerChoice == 1 && compChoice == 2){      //rock vs paper
            result = 2;
        }
        else if(playerChoice == 2 && compChoice == 1){      //paper vs rock
            result = 1;
        }
        else if(playerChoice == 2 && compChoice == 3){      //paper vs scissors
            result = 2;
        }
        else if(playerChoice == 3 && compChoice == 1){      //scissors vs rock
            result = 2;
        }
        else if(playerChoice == 3 && compChoice == 2){      //scissors vs paper
            result = 1;
        }
        else{                                               //Tie                                                             
            result = 3;
        }
        
        return result;
    }
}

package com.duckrace.app;

import com.duckrace.Board;
import com.duckrace.Reward;

import java.util.Scanner;

/*
 * Application Controller. Directs overall flow of the application . and prompts user for inputs, then "passes"
 * those inputs into the system.
 *
 * This is not Running the Race, this is just updating the board
 */


public class DuckRaceApp {
    private Board board = new Board();
    private Scanner scanner = new Scanner(System.in);   //System.in - console for input vs system.out that that is output to the scanner

    //Directing the flow of the application
    public void execute() {
        welcome();      //will just welcome the user to the duckrace application
        showBoard();    //will show the board in its current state
        int id = promptForId(); // will go over and over in the prompt method until you get only a number from 1 through 16 ( duck racers)
        Reward reward = promptForReward(); // what reward will be chosen? Prizes or Debit Card
        updateBoard(id, reward);              //pass the info into the system to update the board
        showBoard();
    }

    private void updateBoard(int id, Reward reward) {
        board.update(id, reward);
    }

    private Reward promptForReward() {
        Reward reward = null;
        boolean validInput = false;
        while(!validInput){
            System.out.print("Please enter [D]ebit card or [P]rizes: ");
            String input = scanner.nextLine().trim().toUpperCase(); // making it uppercase automatically
           if(input.matches("D|P" )){      //WARNING: Dont say "D | P" for readabilit, will not match "D " or  " P"
                validInput = true;
                reward = input.equals("D") ? Reward.DEBIT_CARD : Reward.PRIZES;

               /*if(input.matches("D")){
                    reward = Reward.DEBIT_CARD;
                }
                else{
                    reward = Reward.PRIZES;
                }
                validInput = true;*/
            }

        }

        return reward;
    }

    private int promptForId() {
        int id = 0;

        boolean validInput = false;
        while (!validInput) {
            System.out.print("Please enter ID of the winner [1-16]: ");   //Dont hardcode the 16
            String input = scanner.nextLine().trim();  //BLOCKS for input, i.e. the Enter Key, trim() will trim off any leading or trailing spaces
            if(input.matches("\\d{1,2}") ){                  //if code matches any digit, one or two times
                int digit = Integer.parseInt(input);
                if(digit>0 && (digit <=16)){
                    id = digit;
                    validInput = true;
                }
            }
        }

        return id;
    }

    private void showBoard() {
        board.show();
    }

    private void welcome() {
        System.out.println("\n");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(" W E L C O M E   T O   T H E   D U C K R A C E   A P P L I C A T I O N ! ");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("\n");
    }

}
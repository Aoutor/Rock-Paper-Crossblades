/*
Rock, Paper, Crossblades

Alexander Zubchenko
#1195577
Block 1-2
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int rock = 1;
        final int paper = 2;
        final int crossblades = 3;
        int p_choice = 0;
        int c_choice = 0;
        boolean playing = true;
        int win = 0;
        /*
        Win = 0 (Lose)
        Win = 1 (Win)
        Win = 2 (Tie)
         */
        String players = "";
        String computer = "";
        Scanner player = new Scanner(System.in);
        System.out.println("Human, let’s have an epic game of Rock, Paper, Crossblades! \nChoose a move: ");
        String choice1 = player.nextLine();
        if (choice1.length()>=0){
            if (choice1.toLowerCase().lastIndexOf("rock") == choice1.length()-4){
                p_choice = rock;
            } else if (choice1.toLowerCase().lastIndexOf("paper") == choice1.length()-5) {
                p_choice = paper;
            } else if (choice1.toLowerCase().lastIndexOf("crossblades") == choice1.length()-11) {
                p_choice = crossblades;
            }
        } else {
            System.out.println("Error");
            playing = false;
        }
        if (choice1.length()<=50 && playing){
            //Makes player lose if move is under 50 characters
            if (p_choice == rock){
                c_choice = paper;
            }
            if (p_choice == paper){
                c_choice = crossblades;
            }
            if (p_choice == crossblades){
                c_choice = rock;
            }

            win = 0;

        } else if (choice1.length()>=50 && playing){
            c_choice = (int)(Math.random()*3 + 1);
            if (c_choice == p_choice){
                //Tie
                win = 2;
            }
            if (c_choice == rock && p_choice == crossblades){
                //Lose
                win = 0;
            }
            if (c_choice == rock && p_choice == paper){
                //Win
                win = 1;
            }
            if (c_choice == paper && p_choice == crossblades){
                //win
                win = 1;
            }
            if (c_choice == crossblades && p_choice == rock){
                //win
                win = 1;
            }
        }
        //--------------------
        if (p_choice == rock){
            players = "rock";
        }
        if (p_choice == paper){
            players = "paper";
        }
        if (p_choice == crossblades){
            players = "crossblades";
        }
        if (c_choice == rock){
            computer = "rock";
        }
        if (c_choice == paper){
            computer = "paper";
        }
        if (c_choice == crossblades){
            computer = "crossblades";
        }
        //--------------------
        if (win == 0){
            System.out.println("You chose: " + players + "\nComputer chose: " + computer + "\nYou lose! Hahahahaha, the kingdom is mine!");
        } else if (win == 1){
            System.out.println("You chose: " + players + "\nComputer chose: " + computer + "\nYou win! The day has been saved!");
        } else if (win == 2){
            System.out.println("You chose: " + players + "\nComputer chose: " + computer + "\nYou tied! Impossible!");
        } else {
            System.out.println("Error");
        }
    }
}

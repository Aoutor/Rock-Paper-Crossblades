/*
Rock, Paper, Crossblades

Alexander Zubchenko
#1195577
Block 1-2
 */

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final String[] moves = {"rock", "paper", "crossblades"};
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Choose rock, paper, or crossblades:");
        String playerMove = scanner.nextLine().toLowerCase().trim();
        int playerChoice = getChoice(playerMove, moves);

        if (playerChoice == -1) {
            System.out.println("Invalid input, please try again.");
            return;
        }

        int computerChoice = random.nextInt(3);
        System.out.println("Computer chose: " + moves[computerChoice]);

        int result = determineWinner(playerChoice, computerChoice);
        printResult(result);
    }

    private static int getChoice(String move, String[] moves) {
        for (int i = 0; i < moves.length; i++) {
            if (moves[i].equals(move)) {
                return i;
            }
        }
        return -1; // Invalid choice
    }

    private static int determineWinner(int player, int computer) {
        if (player == computer) return 2; // Tie
        if ((player == 0 && computer == 1) || 
            (player == 1 && computer == 2) || 
            (player == 2 && computer == 0)) return 0; // Loss
        return 1; // Win
    }

    private static void printResult(int result) {
        switch (result) {
            case 0 -> System.out.println("You lose!");
            case 1 -> System.out.println("You win!");
            case 2 -> System.out.println("It's a tie!");
        }
    }
}


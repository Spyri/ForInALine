package Game;

import Players.HumanPlayerFIAL;
import Players.Player;

import java.security.cert.TrustAnchor;
import java.util.Scanner;

public class FIALPlayersList {
    public Player[] players;
    private char alreadyChosenSymbol;

    public FIALPlayersList() {
        Player player1 = createHumanPlayer();
        Player player2 = createHumanPlayer();
        this.players = new Player[]{player1, player2};
    }

    public Player createHumanPlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type in your Name: ");
        String name = scanner.next();
        System.out.println();
        while (true) {
            System.out.print("Type in the Symbol you want to use: ");
            String c = scanner.next();
            if (c.length() != 1) {
                char chosenChar = c.charAt(0);
                if (chosenChar == ' ') {
                    System.out.println("This Symbol is already taken. Try again.");
                    continue;
                }
                if (this.alreadyChosenSymbol != chosenChar) {
                    this.alreadyChosenSymbol = chosenChar;
                    return new HumanPlayerFIAL(name, chosenChar);
                }
                else {
                    System.out.println("This Symbol is already taken. Try again.");
                }
            }
            else {
                System.out.println("Input is invalid. Try again");
            }

        }
    }
}

package Game;

import Board.BoardManager;
import Players.HumanPlayerFIAL;
import Players.Player;

import java.security.cert.TrustAnchor;
import java.util.Scanner;

public class FIALPlayersList {
    public Player[] players;
    private char alreadyChosenSymbol;

    private BoardManager boardManager;

    public FIALPlayersList(BoardManager boardManager) {
        this.boardManager = boardManager;
        System.out.println("--- Player 1: Please type in your name and the symbol that you want to use. ---");
        Player player1 = createHumanPlayer();
        System.out.println("--- Player 2: Please type in your name and the symbol that you want to use. ---");
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
            if (c.length() == 1) {
                char chosenChar = c.charAt(0);
                if (chosenChar == ' ') {
                    System.out.println("This Symbol is already taken. Try again.");
                    continue;
                }
                if (this.alreadyChosenSymbol != chosenChar) {
                    this.alreadyChosenSymbol = chosenChar;
                    return new HumanPlayerFIAL(name, chosenChar, this.boardManager);
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

package Players;

import Board.BoardManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayerFIAL extends Player{
    public HumanPlayerFIAL(String name, char pieceSymbol, BoardManager boardManager){
        this.name = name;
        this.pieceSymbol = pieceSymbol;
        this.boardManager = boardManager;
    }


    @Override
    public void executeMove() {
        System.out.println("--- Player " + this.name + " is playing ---");
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        int row = 0;
        while (!validInput){
            System.out.print("Please choose the row you want to place your stone: ");
            try {
                scanner.reset();
                row = scanner.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("Input invalid. Try again.");
                scanner.next();
                continue;
            }
            if (this.boardManager.setPieceAt(this.pieceSymbol, row)) {
                validInput = true;
            }
            else {
                validInput = false;
            }
        }
    }
}

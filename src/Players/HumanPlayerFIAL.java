package Players;

import Board.BoardManager;
import IO.InputOutput;

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
        boolean validInput = false;
        int row;
        while (!validInput){
            String message = "Please choose the row you want to place your stone: ";
            row = InputOutput.printAndScanInt(message);
            validInput = this.boardManager.setPieceAt(this.pieceSymbol, row);
        }
    }
}

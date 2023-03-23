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
    public int executeMove() {
        System.out.println("--- Player " + this.name + " is playing ---");
        boolean validInput = false;
        int row = -1;
        while (!validInput){
            String message = "Please choose the row you want to place your stone: ";
            row = InputOutput.printAndScanInt(message);
            --row;
            if (this.boardManager.pieceSetter.checkBoundAndRowOutput(0,row)){
                validInput = this.boardManager.setPieceAt(this.pieceSymbol, row);
            }
        }
        return row;
    }
}

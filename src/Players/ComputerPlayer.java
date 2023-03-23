package Players;

import Board.BoardManager;

import java.util.Random;

public class ComputerPlayer extends Player{
    public ComputerPlayer(String name, char pieceSymbol, BoardManager boardManager) {
        this.boardManager = boardManager;
        this. pieceSymbol = pieceSymbol;
        this.name = name;
    }
    @Override
    public int executeMove() {
        Random random = new Random();
        int ran = random.nextInt(this.boardManager.board.getMaxRow());
        while (!this.boardManager.pieceSetter.checkBoundAndRowWithoutOutput(0, ran)) {
            ran = random.nextInt(this.boardManager.board.getMaxRow());
        }
        this.boardManager.setPieceAt(this.pieceSymbol, ran);
        return ran;
    }
}

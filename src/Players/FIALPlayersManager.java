package Players;

import Board.Board;
import Board.CheckWinFIAL;
import Game.FIALPlayersList;

public class FIALPlayersManager {
    private final FIALPlayersList players;
    public final CheckWinFIAL checkWinFIAL;
    private final Board board;
    public Player currentPlayer;
    public int round;
    public int lastRow;

    public boolean gameWon;

    public FIALPlayersManager(FIALPlayersList players, Board board) {
        this.players = players;
        this.round = 0;
        this.currentPlayer = players.players[round];
        this.checkWinFIAL = new CheckWinFIAL(board);
        this.board = board;
    }

    public void executeCurrentPlayerMove() {
        this.lastRow = currentPlayer.executeMove();
        this.gameWon = checkWinFIAL.checkWin(lastRow, currentPlayer.pieceSymbol);
    }

    public boolean changePlayer() {
        round++;
        if(round == this.board.getAreaOfBoard()) {
            return false;
        }
        currentPlayer = players.players[round % 2];
        return true;
    }
}

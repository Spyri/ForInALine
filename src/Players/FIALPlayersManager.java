package Players;

import Board.CheckWinFIAL;
import Game.FIALPlayersList;

public class FIALPlayersManager {
    private final FIALPlayersList players;
    public final CheckWinFIAL checkWinFIAL;
    public Player currentPlayer;
    public int round;
    public int lastRow;

    public boolean gameWon;

    public FIALPlayersManager(FIALPlayersList players) {
        this.players = players;
        this.round = 0;
        this.currentPlayer = players.players[round];
        this.checkWinFIAL = new CheckWinFIAL(this.currentPlayer.boardManager.board);
    }

    public void executeCurrentPlayerMove() {
        this.lastRow = currentPlayer.executeMove();
        this.gameWon = checkWinFIAL.checkWin(lastRow, currentPlayer.pieceSymbol);
    }

    public void changePlayer() {
        round++;
        currentPlayer = players.players[round % 2];
    }
}

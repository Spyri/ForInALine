package Players;

import Game.FIALPlayersList;

public class FIALPlayersManager {
    private final FIALPlayersList players;
    public Player currentPlayer;
    public int round;
    public int lastRow;

    public FIALPlayersManager(FIALPlayersList players) {
        this.players = players;
        round = 0;
        currentPlayer = players.players[round];
    }

    public void executeCurrentPlayerMove() {
        this.lastRow = currentPlayer.executeMove();
    }

    public void changePlayer() {
        round++;
        currentPlayer = players.players[round % 2];
    }
}

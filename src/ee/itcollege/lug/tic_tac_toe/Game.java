package ee.itcollege.lug.tic_tac_toe;

import java.util.ArrayList;

/**
 * The logic of a single game.
 */
public class Game {

    /*Because there is no reason to show these variable outside this class
     and changing them can break the game, they are private. */
    private boolean isGameOver = false;
    private ArrayList<Player> players = new ArrayList<Player>();
    private Grid grid;

    /**
     * Constructor method.
     */
    public Game(Player player1, Player player2, Grid grid) {
        this.players.add(player1);
        this.players.add(player2);
        this.grid = grid;
    }

    /**
     * Does what is necessary for next move.
     */
    public void nextMove(int turnNr) throws SpaceNotAvailableException {
        if (turnNr == 8) {
            isGameOver = true;
        }
        int index;
        if (turnNr % 2 == 0) {
            index = 1;
        } else {
            index = 0;
        }
        Player player = players.get(index);
        Space chosenSpace = player.chooseSpace();
        grid.markSpace(player, chosenSpace);
    }

    /**
     * Is this game over?
     */
    public boolean isOver() {
        return isGameOver;
    }

    /**
     * Check if someone has won the game.
     */
    public boolean checkForWin() {
        //ToDo
        return false;
    }
}

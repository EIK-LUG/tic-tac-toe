package ee.itcollege.lug.tic_tac_toe.game;

import ee.itcollege.lug.tic_tac_toe.playing_field.Grid;
import ee.itcollege.lug.tic_tac_toe.player.Player;
import ee.itcollege.lug.tic_tac_toe.playing_field.Space;
import ee.itcollege.lug.tic_tac_toe.playing_field.SpaceNotAvailableException;

/**
 * The logic of a single game.
 */
public class Game {

    /*Because there is no reason to show these variable outside this class
     and changing them can break the game, they are private. */
    private boolean isGameOver = false;
    private Player player1;
    private Player player2;
    private Grid grid;

    /**
     * Constructor method.
     */
    public Game(Player player1, Player player2, Grid grid) {
        this.player1 = player1;
        this.player2 = player2;
        this.grid = grid;
    }

    /**
     * Does what is necessary for next move.
     */
    public void nextMove(int turnNr) throws SpaceNotAvailableException {
        if (turnNr == 9) {
            isGameOver = true;
        }
        Player currentPlayer;
        if (turnNr % 2 == 0) {
            currentPlayer = this.player2;
        } else {
            currentPlayer = this.player1;
        }
        Space chosenSpace = currentPlayer.chooseSpace();
        grid.markSpace(currentPlayer, chosenSpace);
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

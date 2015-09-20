package ee.itcollege.lug.tic_tac_toe.game;

import ee.itcollege.lug.tic_tac_toe.playing_field.Grid;
import ee.itcollege.lug.tic_tac_toe.player.Player;
import ee.itcollege.lug.tic_tac_toe.playing_field.Space;
import ee.itcollege.lug.tic_tac_toe.playing_field.SpaceNotAvailableException;

import java.util.ArrayList;

/**
 * The logic of a single game.
 */
public class Game {

    /*Because there is no reason to show these variable outside this class
     and changing them can break the game, they are private. */
    private boolean isGameOver = false;
    private Player[] players = new Player[2];
    private Grid grid;


    /**
     * Constructor method.
     */
    public Game(Player player1, Player player2, Grid grid) {
        this.players[0] = player1;
        this.players[1] = player2;
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
        Player player = players[index];
        Space chosenSpace = player.chooseSpace();
        grid.markSpace(player, chosenSpace);
    }

    /**
     * Is this game over?
     */
    public boolean isOver() {
        return isGameOver;
    }
    //TODO if checkForWin == true then return isGameOver=true; , end game & sout winner name
    /**
     * Check if someone has won the game.
     */
    public boolean checkForWin() {
        //ToDo
        return false;
    }
}

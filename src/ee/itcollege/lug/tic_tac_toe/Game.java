package ee.itcollege.lug.tic_tac_toe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The logic of a single game.
 */
public class Game {

    /*Because there is no reason to show these variable outside this class
     and changing them can break the game, they are private. */
    private boolean isGameOver = false;
    private LinkedList<Player> players = new LinkedList<Player>();
    private Grid grid;
    private int turn;

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
    public void nextMove() {
        Player player = players.getFirst();
        Space chosenSpace = player.chooseSpace();
        if (grid.isSpaceFree(chosenSpace)) {
            grid.markSpace(player, chosenSpace);
        } else {
            players.addFirst(player);
            nextMove();
        }
        turn++;
    }

    /**
     * Is this game over?
     */
    public boolean isOver() {
        return isGameOver;
    }
}

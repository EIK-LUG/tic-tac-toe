package ee.itcollege.lug.tic_tac_toe.playing_field;

import ee.itcollege.lug.tic_tac_toe.player.Player;

import java.util.NoSuchElementException;

/**
 * A wrapper class for a matrix of Spaces.
 */
public class Grid {

    private Space[][] representation = new Space[3][3];

    /**
     * On creation make a matrix of Space object instances.
     */
    public Grid() {
        for (int i = 0; i < 3; i++) {
            representation[i] = new Space[3];
            for (int j = 0; j < 3; j++) {
                representation[i][j] = new Space(i, j);
            }
        }
    }

    /**
     * A space is marked by a player.
     */
    public void markSpace(Player player, Space space) throws SpaceNotAvailableException {
        findSpace(space).takeSpace(player);
    }

    /**
     *  Find space in this grid. If this space does not exist, throw exception.
     */
    private Space findSpace(Space space) {
        for (Space[] al : representation) {
            for (Space spc : al) {
                if (space.equals(spc)) return spc;
            }
        }
        throw new NoSuchElementException();
    }

    /**
     * Returns a string representation of this Grid.
     */
    public String toString() {
        String rep = "\n";

        for (Space[] al : representation) {
            for (Space spc : al) {
                rep += spc.toString();
            }
            rep += "\n";
        }

        return rep;
    }

    /**
     * Not used, will probably be useful for checking win.
     */
    public Space[][] getRepresentation() {
        return this.representation;
    }

}

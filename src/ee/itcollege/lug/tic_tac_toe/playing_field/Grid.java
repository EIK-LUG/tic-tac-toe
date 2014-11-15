package ee.itcollege.lug.tic_tac_toe.playing_field;

import ee.itcollege.lug.tic_tac_toe.player.Player;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * A wrapper class for a matrix of Spaces.
 */
public class Grid {

    ArrayList<ArrayList<Space>> representation = new ArrayList<ArrayList<Space>>();

    /**
     * On creation make a matrix of Space object instances.
     */
    public Grid() {
        for (int i = 0; i < 3; i++) {
            representation.add(new ArrayList<Space>());
            for (int j = 0; j < 3; j++) {
                representation.get(i).add(new Space(i, j));
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
        for (ArrayList<Space> al : representation) {
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

        for (ArrayList<Space> al : representation) {
            for (Space spc : al) {
                rep += spc.toString();
            }
            rep += "\n";
        }

        return rep;
    }

    /**
     * Returns whether this space is free.
     */
    public boolean isSpaceFree(Space chosenSpace) {
        return findSpace(chosenSpace).isNotTaken();
    }
}

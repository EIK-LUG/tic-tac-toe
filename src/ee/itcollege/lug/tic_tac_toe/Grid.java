package ee.itcollege.lug.tic_tac_toe;

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
     *
     * @param player A player.
     */
    public void markSpace(Player player, Space space) {
        try {
            findSpace(space).takeSpace(player);
        } catch (NoSuchElementException e) {
            System.out.println("Invalid space.");
            throw new NoSuchElementException();
        } catch (SpaceNotAvailableException) {
            System.out.println("");
            throw new
        }
    }

    /**
     *  Find space in this grid.
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
     * @return A string representation of this Grid.
     */
    public String toString() {
        String rep = "";

        for (ArrayList<Space> al : representation) {
            for (Space spc : al) {
                rep += spc.toString();
            }
            rep += "\n";
        }

        return rep;
    }

    /**
     *
     *
     * @param chosenSpace
     * @return
     */
    public boolean isSpaceFree(Space chosenSpace) {
        if (!findSpace(chosenSpace).isNotTaken()) {
            System.out.println("This space is already taken!");
            return true;
        } else {
            return false;
        }
    }
}

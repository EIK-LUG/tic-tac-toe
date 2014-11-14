package ee.itcollege.lug.tic_tac_toe;

import java.security.InvalidParameterException;

/**
 * A simple exception, only for detecting a certain error.
 */
class SpaceNotAvailableException extends Exception {

}

/**
 * A space on the grid.
 */
public class Space {

    /* Private to keep anyone from changing these values directly. */
    private boolean taken = false;
    private int position[] = {0, 0};
    public Player owner;

    /**
     * Constructor method.
     */
    public Space(int x, int y) {
        try {
            assert x <= 2 && y <= 2 && x >= 0 && y >= 0;
            this.position[0] = x;
            this.position[1] = y;
        } catch (AssertionError e) {
            throw new InvalidParameterException();
        }


    }

    /**
     * Is this Space taken.
     */
    public boolean isNotTaken() {
        return taken;
    }

    /**
     * Take this space.
     */
    public void takeSpace(Player player) throws SpaceNotAvailableException {
        if (!taken) {
            owner = player;
            taken = true;
        } else {
            throw new SpaceNotAvailableException();
        }
    }

    /**
     * Returns the position of this Space.
     */
    public int[] getPosition() {
        return position;
    }

    /**
     * Overriding objects equals method. Defines equality operations behaviour for all Objects.
     */
    @Override
    public boolean equals(Object other) {
        try {
            Space tmp = (Space)other;
            return tmp.getPosition()[0] == this.getPosition()[0] && tmp.getPosition()[1] == this.getPosition()[1];
        } catch (ClassCastException e) {
            return false;
        }
    }

    /**
     * Overriding objects toString method. This is what every objects calls with System.out.println(Object);
     */
    @Override
    public String toString() {
        try {
            return owner.toString();
        } catch (NullPointerException e) {
            return "[ ]";
        }
    }
}

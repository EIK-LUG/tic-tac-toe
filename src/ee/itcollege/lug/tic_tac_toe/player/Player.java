package ee.itcollege.lug.tic_tac_toe.player;

import ee.itcollege.lug.tic_tac_toe.playing_field.Space;

import java.util.Scanner;

/**
 * A player.
 */
public class Player {

    //Private to keep programmers from inadvertently accessing and changing these values.
    private static boolean firstPlayer = true;
    private enum mark {X, O}
    private mark playerMark;

    /**
     * Constructor method.
     */
    public Player() {
        if (firstPlayer) {
            this.playerMark = mark.O;
            firstPlayer = false;
        } else {
            this.playerMark = mark.X;
        }
    }

    /**
     * Lets the user choose a space.
     */
    public Space chooseSpace() {
        return getUserInput();
    }

    /**
     * Deals with getting proper user input.
     */
    private Space getUserInput() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Player " + playerMark);
        System.out.println("Where do you want to make your play?");

        System.out.print("Row: ");
        int i = sc.nextInt();
        System.out.print("Column: ");
        int j = sc.nextInt();

        // added -1 for better UX
        return new Space(i-1, j-1);
    }

    /**
     * Overriding objects toString method. This is what every objects calls with System.out.println(Object);
     */
    @Override
    public String toString() {
        return "[" + String.valueOf(playerMark) + "]";
    }
}

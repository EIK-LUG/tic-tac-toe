package ee.itcollege.lug.tic_tac_toe;

import java.security.InvalidParameterException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A player.
 */
public class Player {

    private static boolean firstPlayer = true;
    private enum mark {X, O}
    private mark playerMark;

    /**
     * Character creation.
     */
    public Player() {
        if (firstPlayer) {
            this.playerMark = mark.O;
            firstPlayer = false;
        } else {
            this.playerMark = mark.X;
        }
    }

    public Space chooseSpace() {
        return getUserInput();
    }

    /**
     * Deals with getting proper user input.
     *
     * @return The user selected Space.
     */
    private Space getUserInput() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Player " + playerMark);
                System.out.println("Where do you want to make your play? (i, j)");

                int i = sc.nextInt();
                int j = sc.nextInt();

                try {
                    return new Space(i, j);
                } catch(InvalidParameterException e) {
                    System.out.println("Sorry, this move is illegal..");
                    sc.nextLine();
                }

            } catch (InputMismatchException e) {
                System.out.println("Sorry, invalid input type. Try again.");
                sc.nextLine();
            }
        }
    }

    /**
     * To string.
     */
    public String toString() {
        return "[" + String.valueOf(playerMark) + "]";
    }
}

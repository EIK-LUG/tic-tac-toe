package ee.itcollege.lug.tic_tac_toe;

import ee.itcollege.lug.tic_tac_toe.game.Game;
import ee.itcollege.lug.tic_tac_toe.player.Player;
import ee.itcollege.lug.tic_tac_toe.playing_field.Grid;
import ee.itcollege.lug.tic_tac_toe.playing_field.SpaceNotAvailableException;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to tic-tac-toe! \n Let's get started!");

        Player player1 = new Player();
        Player player2 = new Player();
        Grid grid = new Grid();

        Game game = new Game(player1, player2, grid);

        int turn = 0;

        while (!game.isOver()) {
            System.out.println(grid);
            try {
                game.nextMove(turn);
                turn++;
            } catch (InputMismatchException e) {
                System.out.println("Invalid format of input!");
            } catch (SpaceNotAvailableException e) {
                System.out.println("This space is already taken!");
            } catch (NoSuchElementException e) {
                System.out.println("This is not a valid space!");
            } catch (Exception e) {
                System.out.println("Unhandled exception..");
                System.out.println(e);
            }
        }

        System.out.println("This is the last state of the game: \n\n" + grid);
        System.out.println("Thanks for playing!");
    }
}

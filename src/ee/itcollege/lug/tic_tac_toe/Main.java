package ee.itcollege.lug.tic_tac_toe;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to tic-tac-toe! \n Let's get started!");

        Player player1 = new Player();
        Player player2 = new Player();
        Grid grid = new Grid();

        Game game = new Game(player1, player2, grid);

        while (!game.isOver()) {
            System.out.println(grid);
            try {
                game.nextMove();
            } catch () {

            } catch () {

            } catch () {

            }

        }

        System.out.println("Thanks for playing!");
    }
}

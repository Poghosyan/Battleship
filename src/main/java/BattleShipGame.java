import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BattleShipGame {
    /*
        The BattleshipGame class is the ”main” class–that is, it contains a main method.
        In this class you will set up the game;
        accept ”shots” from the user;
        display the results; print final scores;
        and ask the user if he/she wants to play again.

        All input/output is done here (although some of it is done by calling a print() method
        in the Ocean class.) All computation will be done in the Ocean class and the various Ship classes. Note that you
        want to accept 5 shots from the user. So you need to ensure that you have a well defined format for this.
        For example you can provide an instruction to the user as follows:
        The input format should look like this: 1, 1; 0, 3; 7, 3; 9, 11; 12, 17
    */
    public static void Main(String[] args) {
        Ocean ocean = new Ocean();
        Scanner in = new Scanner(System.in);
        int[][] inputArray = new int[5][2];

        while(!isGameOver(ocean)) {
            inputArray = getInput(in);
        }
    }

    //TODO learn streams and use stream to get correct format of user input in coordinates
    static int[][] getInput(Scanner in) {
        System.out.println("Please input the 5 positions you would like to shop at.");
        System.out.println("Input format should look like so: 1, 1; 0, 3; 7, 3; 9, 11; 12, 17");
        String input = in.nextLine();
        Pattern.compile(";")
                .splitAsStream(input)
                .map(s -> new int[] {Integer.parseInt(s.charAt(0), Integer.parseInt(s.(3)));
        return null;
    }

    static boolean isGameOver(Ocean ocean) {
        return ocean.shipsSunk == ocean.SHIP_COUNT;
    }
}

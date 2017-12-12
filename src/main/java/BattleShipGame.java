import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
    public static void main(String[] args) {
        Ocean ocean = new Ocean();
        Scanner in = new Scanner(System.in);
        List<String> inputArray = new ArrayList<>();
        boolean hitShip;

        start:
        {
            setUpShips(ocean);

            while (!isGameOver(ocean)) {
                inputArray = getInput(in);

                for (String s : inputArray) {
                    hitShip = ocean.shootAt(Integer.parseInt(s.substring(0, 1)), Integer.parseInt(s.substring(3)));
                    displayHitResult(hitShip);
                    ocean.print();
                }
            }

            System.out.println("The game is over!");
            System.out.println("There were " + ocean.getShotsFired() + " shots fired");

            System.out.println("Would you like to play again? (Y/N)");
            String restart = in.next();

            if (restart.equals("Y") || restart.equals("y")) {
                ocean = new Ocean();
                break start;
            } else {
                System.out.println("Thank you for playing.");
            }
        }
    }

    private static void displayHitResult(boolean hitShip) {
        if (hitShip) {
            System.out.println("Hit");
        } else {
            System.out.println("Miss");
        }
    }

    private static void setUpShips(Ocean ocean) {
        ocean.placeAllShipsRandomly();
    }

    private static List<String> getInput(Scanner in) {
        System.out.println("Please input the 5 positions you would like to shop at.");
        System.out.println("Input format should look like so: 1, 1; 0, 3; 7, 3; 9, 11; 12, 17");
        String input = in.nextLine();
        List<String> coordinates = Pattern.compile(";")
                .splitAsStream(input)
                .collect(Collectors.toList());
        return coordinates;
    }

    private static boolean isGameOver(Ocean ocean) {
        return ocean.shipsSunk == ocean.SHIP_COUNT;
    }
}

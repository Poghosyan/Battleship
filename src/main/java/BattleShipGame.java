import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BattleShipGame {
    //TODO Can we make this prettier?
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> inputArray = new ArrayList<>();
        boolean hitShip;

        start:
        {
            Ocean ocean = new Ocean();
            ocean.placeAllShipsRandomly();

            while (!ocean.isGameOver()) {
                System.out.println("Please input the 5 positions you would like to shop at.");
                System.out.println("Input format should look like so: 1, 1; 0, 3; 7, 3; 9, 11; 12, 17");
                //TODO Check inputs
                inputArray = getInput(in);
                for (String s : inputArray) {
                    String[] points = s.split(",");
                    hitShip = ocean.shootAt(Integer.parseInt(points[0].trim()), Integer.parseInt(points[1].trim()));
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

    //TODO Throw exception when user input doesn't match correct input, how should that case be handled?
    private static List<String> getInput(Scanner in) {
        String input = in.nextLine();
        List<String> coordinates = Pattern.compile(";")
                .splitAsStream(input)
                .map(String::trim)
                .collect(Collectors.toList());
        return coordinates;
    }
}

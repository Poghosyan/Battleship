import java.util.Random;

public class Ocean {
    public static final int SHIP_COUNT = 13;
    private final int BOARD_DIMENSION = 20;
    Ship[][] ships = new Ship[BOARD_DIMENSION][BOARD_DIMENSION];
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;

    /**
     * The constructor. Creates an ”empty” ocean (fills the ships array with a bunch of EmptySea instances).
     * Also initializes any game variables, such as how many shots have been fired.
     */
    Ocean() {
        shotsFired = 0;
        hitCount = 0;
        shipsSunk = 0;
        for (int i = 0; i < BOARD_DIMENSION; ++i) {
            for (int j = 0; j < BOARD_DIMENSION; ++j) {
                ships[i][j] = new EmptySea();
            }
        }
    }

    /**
     * Place all randomly on the (initially empty) ocean. Place larger ships before smaller ones, or you may end up
     * with no legal place to put a large ship. You will want to use the Random class in the java.util package,
     * so look that up in the Java API.
     *
     */
    void placeAllShipsRandomly() {
        Random random = new Random();
        Ship[] shipsToPlace = initializeShips();
        for (Ship ship : shipsToPlace) {
            int row = random.nextInt(20);
            int column = random.nextInt(20);
            boolean horizontal = random.nextBoolean();

            while (!ship.okToPlaceShipAt(row, column, horizontal, this)) {
                row = random.nextInt(20);
                column = random.nextInt(20);
                horizontal = random.nextBoolean();
            }

            ship.placeShipAt(row, column, horizontal, this);
        }
    }

    private Ship[] initializeShips() {
        Ship[] shipsToPlace = new Ship[SHIP_COUNT];
        shipsToPlace[0] = new BattleShip();
        shipsToPlace[1] = new BattleCruiser();
        shipsToPlace[2] = new Cruiser();
        shipsToPlace[3] = new Cruiser();
        shipsToPlace[4] = new LightCruiser();
        shipsToPlace[5] = new LightCruiser();
        shipsToPlace[6] = new Destroyer();
        shipsToPlace[7] = new Destroyer();
        shipsToPlace[8] = new Destroyer();
        shipsToPlace[9] = new Submarine();
        shipsToPlace[10] = new Submarine();
        shipsToPlace[11] = new Submarine();
        shipsToPlace[12] = new Submarine();
        return shipsToPlace;
    }

    /**
     * Returns true if the given location contains a ship, false if it does not.
     *
     * @param row
     * @param column
     * @return
     */
    boolean isOccupied(int row, int column) {
        return ships[row][column].getLength() != 1;
    }

    /**
     * Returns true if the given location contains a ”real” ship, still afloat, (not an EmptySea), false if it does not.
     * In addition, this method updates the number of shots that have been fired, and the number of hits. Note: If a
     * location contains a ”real” ship, shootAt should return true every time the user shoots at that same location.
     * Once a ship has been ”sunk”, additional shots at its location should return false.
     *
     * @param row
     * @param column
     * @return
     */
    boolean shootAt(int row, int column) {
        shotsFired++;
        if (ships[row][column].shootAt(row, column)) {
            if (ships[row][column].isSunk()) {
                shipsSunk++;
            }
            hitCount++;
            return true;
        }
        return false;
    }

    /**
     * @return Returns the number of shots fired (in this game).
     */
    int getShotsFired() {
        return shotsFired;
    }

    /**
     * Returns the number of hits recorded (in this game). All hits are counted, not just the first time a given square
     * is hit.
     *
     * @return
     */
    int getHitCount() {
        return hitCount;
    }

    /**
     * @return Returns the number of ships sunk (in this game).
     */
    int getShipsSunk() {
        return shipsSunk;
    }

    /**
     * @return Returns true if all ships have been sunk, otherwise false.
     */
    boolean isGameOver() {
        return shipsSunk == SHIP_COUNT;
    }

    /**
     * Returns the 20x20 array of ships. The methods in the Ship class that take an Ocean parameter really need to be
     * able to look at the contents of this array; the placeShipAt method even needs to modify it. While it is
     * undesirable to allow methods in one class to directly access instance variables in another class, sometimes
     * there is just no good alternative.
     *
     * @return
     */
    Ship[][] getShipArray() {
        return this.ships;
    }

    /**
     * Prints the ocean. To aid the user, row numbers should be displayed along the left edge of the array, and column
     * numbers should be displayed along the top. Numbers should be 00 to 19, not 1 to 20.
     * The top left corner square should be 0, 0.
     * <p>
     * Use ’S’ to indicate a location that you have fired upon and hit a (real) ship,
     * ’-’ to indicate a location that you have fired upon and found nothing there,
     * ’x’ to indicate a location containing a sunken ship,
     * and ’.’ (a period) to indicate a location that you have never fired upon.
     * <p>
     * This is the only method in the Ocean class that does any input/output, and it is never called from within the
     * Ocean class (except possibly during debugging), only from the BattleshipGame class.
     */
    void print() {
        for (int i = 0; i < BOARD_DIMENSION; ++i) {
            for (int j = 0; j < BOARD_DIMENSION; ++j) {
                System.out.print(" " + ships[i][j]);
            }
            System.out.println();
        }
    }
}

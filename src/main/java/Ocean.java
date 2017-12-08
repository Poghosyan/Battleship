public class Ocean {
    public static final int SHIP_COUNT = 13;
    private final int BOARD_DIMENSION = 20;
    Ship[][] ships = new Ship[BOARD_DIMENSION][BOARD_DIMENSION];
    int shotsFired;
    int hitCount;
    int shipsSunk;

    /**
     * The constructor. Creates an ”empty” ocean (fills the ships array with a bunch of EmptySea instances).
     * Also initializes any game variables, such as how many shots have been fired.
     */
    Ocean() {

    }

    /**
     * Place all randomly on the (initially empty) ocean. Place larger ships before smaller ones, or you may end up
     * with no legal place to put a large ship. You will want to use the Random class in the java.util package,
     * so look that up in the Java API.
     */
    void placeAllShipsRandomly() {

    }

    /**
     * Returns true if the given location contains a ship, false if it does not.
     * @param row
     * @param column
     * @return
     */
    boolean isOccupied(int row, int column) {
        return false;
    }

    /**
     * Returns true if the given location contains a ”real” ship, still afloat, (not an EmptySea), false if it does not.
     * In addition, this method updates the number of shots that have been fired, and the number of hits. Note: If a
     * location contains a ”real” ship, shootAt should return true every time the user shoots at that same location.
     * Once a ship has been ”sunk”, additional shots at its location should return false.
     * @param row
     * @param column
     * @return
     */
    boolean shootAt(int row, int column) {
        return false;
    }

    /**
     * @return Returns the number of shots fired (in this game).
     */
    int getShotsFired() {
        return 0;
    }

    /**
     * Returns the number of hits recorded (in this game). All hits are counted, not just the first time a given square
     * is hit.
     * @return
     */
    int getHitCount() {
        return 0;
    }

    /**
     * @return Returns the number of ships sunk (in this game).
     */
    int getShipsSunk() {
        return 0;
    }

    /**
     * @return Returns true if all ships have been sunk, otherwise false.
     */
    boolean isGameOver() {
        return false;
    }

    /**
     * Returns the 20x20 array of ships. The methods in the Ship class that take an Ocean parameter really need to be
     * able to look at the contents of this array; the placeShipAt method even needs to modify it. While it is
     * undesirable to allow methods in one class to directly access instance variables in another class, sometimes
     * there is just no good alternative.
     * @return
     */
    Ship[][] getShipArray() {
        return new Ship[][] {};
    }

    /**
     * Prints the ocean. To aid the user, row numbers should be displayed along the left edge of the array, and column
     * numbers should be displayed along the top. Numbers should be 00 to 19, not 1 to 20.
     * The top left corner square should be 0, 0.
     *
     * Use ’S’ to indicate a location that you have fired upon and hit a (real) ship,
     * ’-’ to indicate a location that you have fired upon and found nothing there,
     * ’x’ to indicate a location containing a sunken ship,
     * and ’.’ (a period) to indicate a location that you have never fired upon.
     *
     * This is the only method in the Ocean class that does any input/output, and it is never called from within the
     * Ocean class (except possibly during debugging), only from the BattleshipGame class.
     */
    void print() {
        System.out.println("Please complete the methods");
    }
}

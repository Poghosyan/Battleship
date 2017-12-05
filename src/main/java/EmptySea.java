public class EmptySea extends Ship {
    private final int LENGTH = 1;

    public EmptySea() {
        this.setLength(LENGTH);
    }

    /**
     * This method overrides shootAt(int row, int column) that is inherited from Ship, and always returns false to
     * indicate that nothing was hit.
     * @param row
     * @param column
     * @return always false
     */
    @Override
    boolean shootAt(int row, int column) {
        return false;
    }

    /**
     * This method overrides isSunk() that is inherited from Ship, and always returns false to indicate that
     * you didn’t sink anything.
     * @return false
     */
    @Override
    boolean isSunk() {
        return false;
    }

    @Override
    public String toString() {
        return "~~";
    }

    String getShipType() {
        return "empty";
    }
}

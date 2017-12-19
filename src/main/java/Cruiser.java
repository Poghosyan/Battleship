public class Cruiser extends Ship {
    private final int LENGTH = 6;

    public Cruiser() {
        this.setLength(LENGTH);
    }

    String getShipType() {
        return "Cruiser";
    }
}

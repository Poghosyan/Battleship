public class Cruiser extends Ship {
    private final int LENGTH = 6;

    public Cruiser() {
        this.setLength(LENGTH);
        this.hit = new boolean[LENGTH];
    }

    String getShipType() {
        return "Cruiser";
    }
}

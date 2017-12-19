public class Submarine extends Ship {
    private final int LENGTH = 3;

    public Submarine() {
        this.setLength(LENGTH);
    }

    String getShipType() {
        return "Submarine";
    }
}

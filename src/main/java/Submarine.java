public class Submarine extends Ship {
    private final int LENGTH = 3;

    public Submarine() {
        this.setLength(LENGTH);
        this.hit = new boolean[LENGTH];
    }

    String getShipType() {
        return "Submarine";
    }
}

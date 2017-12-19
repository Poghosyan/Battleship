public class Destroyer extends Ship {
    private final int LENGTH = 4;

    public Destroyer() {
        this.setLength(LENGTH);
    }

    String getShipType() {
        return "Destroyer";
    }
}

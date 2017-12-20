public class LightCruiser extends Ship {
    private final int LENGTH = 5;

    public LightCruiser() {
        this.setLength(LENGTH);
        this.hit = new boolean[LENGTH];
    }

    String getShipType() {
        return "LightCruiser";
    }
}

public class LightCruiser extends Ship {
    private final int LENGTH = 5;

    public LightCruiser() {
        this.setLength(LENGTH);
    }

    String getShipType() {
        return "LightCruiser";
    }
}

public class BattleCruiser extends Ship {
    private final int LENGTH = 7;

    BattleCruiser() {
        this.setLength(LENGTH);
        this.hit = new boolean[LENGTH];
    }

    String getShipType() {
        return "BattleCruiser";
    }
}

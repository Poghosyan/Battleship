public class BattleShip extends Ship {
    private final int LENGTH = 8;

    public BattleShip() {
        this.setLength(LENGTH);
    }

    String getShipType() {
        return "BattleShip";
    }
}

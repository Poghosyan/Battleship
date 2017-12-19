import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OceanTest {
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void placeAllShipsRandomly() throws Exception {
        Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();
        Ship[][] ships = ocean.getShipArray();
        for (int i = 0; i < ships.length; ++i) {
            for (int j = 0; j < ships.length; ++j) {
                if (!ships[i][j].getShipType().equals("empty")) {
                    Ship current = ships[i][j];
                    if (!ships[i][j].isHorizontal()) {
                        if (i != ships.length - 1) {
                            Ship nextBlock = ships[i + 1][j];
                            assertTrue(checkNextBlockEmptyOrSameShip(current, nextBlock));
                        }
                        if (j != ships.length - 1) {
                            assertTrue(ships[i][j + 1].getShipType().equals("empty"));
                        }
                    } else {
                        if (j != ships.length - 1) {
                            Ship nextBlock = ships[i][j + 1];
                            assertTrue(checkNextBlockEmptyOrSameShip(current, nextBlock));
                        }
                        if (i != ships.length - 1) {
                            assertTrue(ships[i + 1][j].getShipType().equals("empty"));
                        }
                    }

                    if (j != ships.length - 1 && i != ships.length - 1) {
                        assertTrue(ships[i + 1][j + 1].getShipType().equals("empty"));
                    }

                    if (j != 0 && i != 0) {
                        assertTrue(ships[i + 1][j - 1].getShipType().equals("empty"));
                    }
                }
            }
        }
    }

    private boolean checkNextBlockEmptyOrSameShip(Ship current, Ship nextBlock) {
        return nextBlock.getBowColumn() == current.getBowColumn() && nextBlock.getBowRow() == current.getBowRow()
                || nextBlock.getShipType().equals("empty");
    }

    @Test
    public void isOccupied() throws Exception {
    }

    @Test
    public void shootAt() throws Exception {
    }

    @Test
    public void getShotsFired() throws Exception {
    }

    @Test
    public void getHitCount() throws Exception {
    }

    @Test
    public void getShipsSunk() throws Exception {
    }

    @Test
    public void isGameOver() throws Exception {
    }

    @Test
    public void getShipArray() throws Exception {
    }

    @Test
    public void print() throws Exception {
    }

}
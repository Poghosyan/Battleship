import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OceanTest {
    private Ocean ocean;

    @Before
    public void setUp() throws Exception {
        this.ocean = new Ocean();
    }

    @Test
    public void placeAllShipsRandomly() throws Exception {
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
        Ship[][] board = ocean.ships;

        boolean occupied = ocean.isOccupied(0,0);
        assertFalse(occupied);

        board[0][1] = new Submarine();
        occupied = ocean.isOccupied(0, 1);
        assertTrue(occupied);
    }

    @Test
    public void shootAt() throws Exception {
        Ship[][] board = ocean.ships;

        boolean occupied = ocean.shootAt(0,0);
        assertFalse(occupied);
        assertEquals(1, ocean.getShotsFired());

        Ship sub = new Submarine();
        sub.placeShipAt(0, 1, true, ocean);
        occupied = ocean.shootAt(0, 1);
        assertTrue(occupied);
        assertEquals(2, ocean.getShotsFired());
        assertEquals(1, ocean.getHitCount());

        occupied = ocean.shootAt(0, 2);
        occupied = ocean.shootAt(0, 3);
        assertEquals(4, ocean.getShotsFired());
        assertEquals(3, ocean.getHitCount());
        assertEquals(1, ocean.getShipsSunk());
    }
}
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
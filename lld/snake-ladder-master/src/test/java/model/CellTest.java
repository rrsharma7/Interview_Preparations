package model;

import exception.InvalidPositionException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class CellTest {

//    @Test(expected = InvalidPositionException.class)
//    public void testInvalidMove() throws InvalidPositionException {
//        new Cell(2, new Snake(4));
//    }

    @Test
    public void testValidMove() throws InvalidPositionException {
        Cell cell = new Cell(12, new Snake(4));
        Snake move = new Snake(4);
//        Assert.assertEquals(move, cell.getMove());
    }

    @Test
    public void testGreenSnake() {
        Cell cell = new Cell(11, new GreenSnake(1));
        Assert.assertEquals(1, cell.nextPosition());

    }

}
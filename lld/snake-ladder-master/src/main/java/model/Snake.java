package model;

import exception.InvalidPositionException;

public class Snake extends Move {
    public Snake(int nextPosition) {
        super(nextPosition);
    }

    @Override
    public boolean isValidPosition(int cellPosition) throws InvalidPositionException {
        if (cellPosition > nextPosition)
            return true;
        else throw new InvalidPositionException("cell position always greater than next position of snake");
    }

}

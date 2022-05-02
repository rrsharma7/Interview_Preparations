package model;

import exception.InvalidPositionException;

public class GreenSnake extends Move {
    private boolean canMove = true;

    public GreenSnake(int nextPosition) {
        super(nextPosition);
    }

    @Override
    public boolean isValidPosition(int cellPosition) throws InvalidPositionException {
        return false;
    }

    @Override
    public int getNextPosition() {
        int next = nextPosition;
        if (canMove) {
            nextPosition = 0;
            canMove = false;
        }
        return next;
    }
}

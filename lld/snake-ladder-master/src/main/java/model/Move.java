package model;

import exception.InvalidPositionException;

public abstract class Move {
    protected int nextPosition;

    public Move(int nextPosition) {
        this.nextPosition = nextPosition;
    }

    public int getNextPosition() {
        return nextPosition;
    }

    public abstract boolean isValidPosition(int cellPosition) throws InvalidPositionException;
}

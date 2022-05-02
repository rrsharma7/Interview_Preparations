package strategy;

import strategy.Dice;

public class MockDice implements Dice {
    @Override
    public int rollDice() {
        return 25;
    }
}

import exception.InvalidPlayerException;
import model.Board;
import model.Cell;
import model.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import strategy.Dice;
import strategy.MockDice;
import strategy.NormalDice;

import java.util.ArrayList;
import java.util.List;

import static model.BoardTest.getCells;

public class PlayerTest {

    private Game game;
    List<Player> playerList;
    Board board;
    Dice dice;

    @Before
    public void before() {
        playerList = new ArrayList<>();
        playerList.add(new Player(1, "A"));
        playerList.add(new Player(1, "B"));
        List<Cell> cells = getCells(100);
        board = new Board(cells);
        dice = new NormalDice();
        game = new Game(playerList, board, dice);
    }

    @Test
    public void playerPositionTest() throws InvalidPlayerException {
        Player p = new Player(1, "Test");
        game.setDice(new MockDice());
        game.play(p);
        Assert.assertEquals(p.getPosition(), 26);
    }
}

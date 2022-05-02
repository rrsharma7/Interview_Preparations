import exception.GameOverException;
import exception.InvalidPlayerException;
import model.Board;
import model.Cell;
import model.DefaultMove;
import model.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import strategy.Dice;
import strategy.MockDice;

import java.util.ArrayList;
import java.util.List;

public class GameTest {
    private Game game;
    List<Player> playerList;
    Board board;
    Dice dice;

    @Before
    public void before() {
        playerList = new ArrayList<>();
        playerList.add(new Player(0, "A"));
        playerList.add(new Player(0, "B"));
        List<Cell> cells = getCells(100);
        board = new Board(cells);
        dice = new MockDice();
        game = new Game(playerList, board, dice);
    }

    @Test
    public void playTest() throws InvalidPlayerException {
        Player p = new Player(1, "Test");
        game.setDice(new MockDice());
        game.play(p);
        Assert.assertEquals(p.getPosition(), 26);
    }

    @Test
    public void endToEndTest() throws InvalidPlayerException, GameOverException {
        Player p1 = playerList.get(0);
        Player p2 = playerList.get(1);
        game.play(game.getNextPlayerToPlay());
        Assert.assertEquals(25, p1.getPosition());
        game.play(game.getNextPlayerToPlay());
        Assert.assertEquals(25, p2.getPosition());
        game.play(game.getNextPlayerToPlay());
        Assert.assertEquals(50, p1.getPosition());
        game.play(game.getNextPlayerToPlay());
        Assert.assertEquals(50, p2.getPosition());
        game.play(game.getNextPlayerToPlay());
        Assert.assertEquals(75, p1.getPosition());
        game.play(game.getNextPlayerToPlay());
        Assert.assertEquals(75, p2.getPosition());
        game.play(game.getNextPlayerToPlay());
        Assert.assertEquals(100, p1.getPosition());
        Assert.assertEquals(p1, game.getRes().get(1));
        p1.setPosition(0);
        p2.setPosition(0);
        game.getPlayerQueue().add(p1);
    }

    @Test(expected = GameOverException.class)
    public void testGameOver() throws InvalidPlayerException, GameOverException {
        Player p1 = game.getNextPlayerToPlay();
        p1.setPosition(75);
        game.play(p1);
        game.getNextPlayerToPlay();
    }

    @Test(expected = InvalidPlayerException.class)
    public void testInvalidPlayerPlay() throws InvalidPlayerException {
        Player player = new Player(1, "Test");
        player.setPosition(100);
        game.play(player);
    }

    public static List<Cell> getCells(int numberOfCells) {
        List<Cell> cells = new ArrayList<>();
        for (int i = 1; i <= numberOfCells; i++) {
            cells.add(new Cell(i, new DefaultMove()));
        }
        return cells;
    }
}

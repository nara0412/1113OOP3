import static org.junit.Assert.*;
import org.junit.Test;

public class TicTacToeTest {

    @Test
    public void testOWin() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0, 'O');
        game.set(0, 1, 'O');
        game.set(0, 2, 'O');
        assertEquals("O", game.evaluate());
    }

    @Test
    public void testXWinDiagonal() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0, 'X');
        game.set(1, 1, 'X');
        game.set(2, 2, 'X');
        assertEquals("X", game.evaluate());
    }

    @Test
    public void testTie() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0, 'X');
        game.set(0, 1, 'O');
        game.set(0, 2, 'X');

        game.set(1, 0, 'O');
        game.set(1, 1, 'X');
        game.set(1, 2, 'O');

        game.set(2, 0, 'O');
        game.set(2, 1, 'X');
        game.set(2, 2, 'O');

        assertEquals("Tie", game.evaluate());
    }

    @Test
    public void testContinue() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0, 'X');
        assertEquals("Continue", game.evaluate());
    }

    @Test
    public void testInvalidMove() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0, 'X');
        assertFalse(game.set(0, 0, 'O'));
    }
}

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class gameTest {

    @Test
    public void shouldPlayer1wins() {
        Game game = new Game();
        Player player1 = new Player(1, "Ivan", 5);
        Player player2 = new Player(2, "Vadim", 4);
        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Ivan", "Vadim");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPlayer2wins() {
        Game game = new Game();
        Player player1 = new Player(1, "Ivan", 2);
        Player player2 = new Player(2, "Vadim", 4);
        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Ivan", "Vadim");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDraw() {
        Game game = new Game();
        Player player1 = new Player(1, "Ivan", 6);
        Player player2 = new Player(2, "Vadim", 6);
        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Ivan", "Vadim");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionIfBothIsUnregistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Kirill", 6);
        Player player2 = new Player(2, "Alexey", 6);
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Ivan", "Vadim");
        });
    }

    @Test
    public void shouldThrowExceptionIfFirstPlayerIsUnregistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Kirill", 6);
        Player player2 = new Player(2, "Vadim", 6);
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Ivan", "Vadim");
        });
    }

    @Test
    public void shouldThrowExceptionIfSecondPlayerIsUnregistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Ivan", 6);
        Player player2 = new Player(2, "Denis", 6);
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Ivan", "Vadim");
        });
    }

}

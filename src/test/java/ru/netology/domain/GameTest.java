package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.data.Player;
import ru.netology.exception.NotRegisteredException;

public class GameTest {
    Game game = new Game();

    Player player1 = new Player(1, "Name1", 500);
    Player player2 = new Player(2, "Name2", 100);
    Player player3 = new Player(3, "Name3", 400);
    Player player4 = new Player(4, "Name4", 100);


    @Test
    public void shouldBeADraw() {
        game.register(player2);
        game.register(player4);

        int expected = 0;
        int actual = game.round(player2.getName(), player4.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinTheFirstPlayer() {
        game.register(player1);
        game.register(player3);

        int expected = 1;
        int actual = game.round(player1.getName(), player3.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinTheSecondPlayer() {
        game.register(player2);
        game.register(player3);

        int expected = 2;
        int actual = game.round(player2.getName(), player3.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldShowAnErrorThatFirstPlayerAreNotRegistered() {
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player1.getName(), player3.getName());
        });
    }

    @Test
    public void shouldShowAnErrorThatSecondPlayerAreNotRegistered() {
        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player1.getName(), player3.getName());
        });
    }
}

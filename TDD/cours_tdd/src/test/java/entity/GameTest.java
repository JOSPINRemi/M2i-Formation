package entity;

import org.example.entity.Dice;
import org.example.entity.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GameTest {
    private Game game;
    @Mock
    private Dice dice;

    @Test
    void testPlayMethodWinResult(){
//        Game game = new Game(new WinFakeDice());
        game = new Game(dice);
        Mockito.when(dice.getValue()).thenReturn(4);
        Assertions.assertTrue(game.play());
    }

    @Test
    void testPlayMethodLoseResult(){
//        Game game = new Game(new LoseFakeDice());
        game = new Game(dice);
        Mockito.when(dice.getValue()).thenReturn(3);
        Assertions.assertFalse(game.play());
    }
}

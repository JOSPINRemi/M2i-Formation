package entity;

import org.example.entity.HangMan;
import org.example.entity.WordGenerator;
import org.example.exception.LoseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HangManTest {
    @Mock
    private WordGenerator wordGenerator;
    private HangMan hangMan;

    @BeforeEach
    void initHangMan() {
        Mockito.when(wordGenerator.getRandomWord()).thenReturn("test");
        hangMan = new HangMan(wordGenerator);
        hangMan.generateMask();
    }

    @Test
    void givenWhenGenerateMaskThenMask() {
        /*Mockito.when(wordGenerator.getRandomWord()).thenReturn("test");
        hangMan.generateMask();*/
        Assertions.assertEquals("____", hangMan.getMask());
    }

    @Test
    void givenGoodCharWhenTryCharThenTrue() {
        boolean result = hangMan.tryChar('t');
        Assertions.assertTrue(result);
    }

    @Test
    void givenWrongCharWhenTryCharThenFalse() {
        boolean result = hangMan.tryChar('z');
        Assertions.assertFalse(result);
    }

    @Test
    void givenGoodCharWhenTryCharThenNotUpdateTryValue() {
        int tryNumber = hangMan.getTryNumber();
        hangMan.tryChar('t');
        Assertions.assertEquals(tryNumber, hangMan.getTryNumber());
    }

    @Test
    void givenWrongCharWhenTryCharThenNotDecreaseTryValue() {
        int tryNumber = hangMan.getTryNumber();
        hangMan.tryChar('z');
        Assertions.assertEquals(tryNumber - 1, hangMan.getTryNumber());
    }

    @Test
    void givenGoodCharWhenTryCharThenUpdateMask() {
        hangMan.tryChar('t');
        Assertions.assertEquals("t__t", hangMan.getMask());
    }

    @Test
    void givenWrongCharWhenTryCharThenNotUpdateMask() {
        hangMan.tryChar('z');
        Assertions.assertEquals("____", hangMan.getMask());
    }

    @Test
    void givenGoodMaskWhenCheckVictoryThenTrue() {
        hangMan.tryChar('t');
        hangMan.tryChar('e');
        hangMan.tryChar('s');
        Assertions.assertTrue(hangMan.checkVictory());
    }

    @Test
    void givenWrongMaskWhenCheckVictoryThenFalse() {
        hangMan.tryChar('a');
        Assertions.assertFalse(hangMan.checkVictory());
    }

    @Test
    void givenTryNumber0WhenTryCharThenRaiseLoseException(){
        hangMan.tryChar('a');
        hangMan.tryChar('a');
        hangMan.tryChar('a');
        hangMan.tryChar('a');
        hangMan.tryChar('a');
        hangMan.tryChar('a');
        hangMan.tryChar('a');
        hangMan.tryChar('a');
        hangMan.tryChar('a');
        hangMan.tryChar('a');

        Assertions.assertThrowsExactly(LoseException.class, () -> hangMan.tryChar('a'));
    }

    @Test
    void givenTryNumber0WhenCheckVictoryThenRaiseLoseException(){
        hangMan.tryChar('a');
        hangMan.tryChar('a');
        hangMan.tryChar('a');
        hangMan.tryChar('a');
        hangMan.tryChar('a');
        hangMan.tryChar('a');
        hangMan.tryChar('a');
        hangMan.tryChar('a');
        hangMan.tryChar('a');
        hangMan.tryChar('a');

        Assertions.assertThrowsExactly(LoseException.class, () -> hangMan.checkVictory());
    }
}

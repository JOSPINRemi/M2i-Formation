package entity;

import org.example.entity.HangMan;
import org.example.entity.WordGenerator;
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
    void initHangMan(){
        Mockito.when(wordGenerator.getRandomWord()).thenReturn("test");
        hangMan = new HangMan(wordGenerator);
        hangMan.generateMask();
    }

    @Test
    void givenWhenGenerateMaskThenMask(){
        /*Mockito.when(wordGenerator.getRandomWord()).thenReturn("test");
        hangMan.generateMask();*/
        Assertions.assertEquals("____", hangMan.getMask());
    }

    @Test
    void givenGoodCharWhenTryCharThenTrue(){
//        Mockito.when(wordGenerator.getRandomWord()).thenReturn("test");
        boolean result = hangMan.tryChar('t');
        Assertions.assertTrue(result);
    }

    @Test
    void givenWrongCharWhenTryCharThenFalse(){
//        Mockito.when(wordGenerator.getRandomWord()).thenReturn("test");
        boolean result = hangMan.tryChar('z');
        Assertions.assertFalse(result);
    }
}

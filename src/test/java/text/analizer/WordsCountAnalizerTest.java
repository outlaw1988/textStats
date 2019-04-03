package text.analizer;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class WordsCountAnalizerTest {

    private static Analizer analizer;

    @Before
    public void before() {
        analizer = new WordsCountAnalizer();
    }

    @Test
    @Parameters({"Ala ma kota, 3", "Ala ma kota a kot ma AIDS, 7", "a b c d, 4"})
    public void testSimple(String text, Integer numOfWords) {
        assertThat(analizer.analize(text)).isEqualTo(numOfWords);
    }

    @Test
    public void testLongText() {
        String text = "Konie przepłynęły trzecią część rzeki, ale woda znosiła je w dół coraz silniej. " +
                "Widocznie poczęły tracić siły, z wolna też zanurzały się coraz głębiej.";
        assertThat(analizer.analize(text)).isEqualTo(24);
    }

    @Test
    public void testWithPunctuation1() {
        String text = "This is, test, message; with some punctuation.";
        assertThat(analizer.analize(text)).isEqualTo(7);
    }

    @Test
    public void testWithPunctuation2() {
        String text = "This is , test , message; with some punctuation.";
        assertThat(analizer.analize(text)).isEqualTo(7);
    }

    @Test
    public void testWithDigits() {
        String text = "Test 111 message with 222 digits.";
        assertThat(analizer.analize(text)).isEqualTo(6);
    }

    @Test
    public void testEmpty() {
        assertThat(analizer.analize("")).isEqualTo(0);
    }

    @Test
    public void testNull() {
        assertThat(analizer.analize(null)).isEqualTo(0);
    }

}
package text.analizer;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class TenMostPopularWordsAnalizerTest {

    private Analizer analizer;

    @Before
    public void before() {
        analizer = new TenMostPopularWordsAnalizer();
    }

    @Test
    public void testSimple() {
        String text = "karol karol karol ewa ewa staszek";
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("karol");
        expectedResult.add("ewa");
        expectedResult.add("staszek");
        List<String> actualResult = (List<String>) analizer.analize(text);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void testFull() {
        String text = "karol karol karol karol karol karol karol karol karol karol 10 ewa ewa ewa ewa ewa ewa ewa ewa" +
                " " +
                "ewa 9 adam adam adam adam adam adam adam adam 8 jerzy jerzy jerzy jerzy jerzy jerzy jerzy 7 " +
                "marta marta marta marta marta marta 6 romek romek romek romek romek 5 stefan stefan stefan stefan 4 " +
                "marek marek marek 3 józef józef 2 radek 1 marian 1 ada 1";
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("karol");  // 10
        expectedResult.add("ewa");    // 9
        expectedResult.add("adam");   // 8
        expectedResult.add("jerzy");  // 7
        expectedResult.add("marta");  // 6
        expectedResult.add("romek");  // 5
        expectedResult.add("stefan"); // 4
        expectedResult.add("marek");  // 3
        expectedResult.add("józef");  // 2
        expectedResult.add("ada");    // 1
        List<String> actualResult = (List<String>) analizer.analize(text);
        assertThat(actualResult).isEqualTo(expectedResult);
        //System.out.println(analizer.interpret());
    }

    @Test
    public void testUpperCase() {
        String text = "MARIAN marian Marian Ewa ewa staszek";
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("marian");
        expectedResult.add("ewa");
        expectedResult.add("staszek");
        List<String> actualResult = (List<String>) analizer.analize(text);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void testSameResults() {
        String text = "Stefan stefan stefan marek marek jerzy jerzy adam adam stanisław ola";
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("stefan");
        expectedResult.add("adam");
        expectedResult.add("jerzy");
        expectedResult.add("marek");
        expectedResult.add("ola");
        expectedResult.add("stanisław");
        List<String> actualResult = (List<String>) analizer.analize(text);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void testWithPunctuation1() {
        String text = "Stefan, stefan; stefan: marek; marek: jerzy: jerzy\" adam\' (adam) [stanisław] :ola:";
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("stefan");
        expectedResult.add("adam");
        expectedResult.add("jerzy");
        expectedResult.add("marek");
        expectedResult.add("ola");
        expectedResult.add("stanisław");
        List<String> actualResult = (List<String>) analizer.analize(text);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void testWithPunctuation2() {
        String text = "Stefan , stefan ; stefan : marek ; marek : jerzy : jerzy \" adam \' (adam) [stanisław] :ola.";
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("stefan");
        expectedResult.add("adam");
        expectedResult.add("jerzy");
        expectedResult.add("marek");
        expectedResult.add("ola");
        expectedResult.add("stanisław");
        List<String> actualResult = (List<String>) analizer.analize(text);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void testWithDigits1() {
        String text = "Stefan 111 Stefan 222 Jerzy";
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("stefan");
        expectedResult.add("jerzy");
        List<String> actualResult = (List<String>) analizer.analize(text);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void testWithDigits2() {
        String text = "Ste111fan Ste111fan 222 Jerzy555";
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("ste111fan");
        expectedResult.add("jerzy555");
        List<String> actualResult = (List<String>) analizer.analize(text);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void testEmpty() {
        String text = "";
        List<String> expectedResult = new ArrayList<>();
        List<String> actualResult = (List<String>) analizer.analize(text);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

}
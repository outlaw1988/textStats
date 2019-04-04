package text.analizer;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class TenLongestWordsAppearOnceTest {

    private Analizer analizer;

    @Before
    public void before() {
        analizer = new TenLongestWordsAppearOnce();
    }

    @Test
    public void testSimple1() {
        String text = "Karol Brzęczyszczykiewicz Rewolwerowiec";
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("brzęczyszczykiewicz");
        expectedResult.add("rewolwerowiec");
        expectedResult.add("karol");
        List<String> actualResult = (List<String>) analizer.analize(text);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void testSimple2() {
        String text = "Karol 5 1 Brzęczyszczykiewicz 20 2 Rewolwerowiec 13 3 Wyrewolwerowany 15 4 " +
                "adam 4 5 kajak 5 6 tata 4 7 mama 4 8 mak 3 9 tu 2 10 az 2 11 dk 2 12";
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("brzęczyszczykiewicz"); // 1
        expectedResult.add("wyrewolwerowany");     // 2
        expectedResult.add("rewolwerowiec");       // 3
        expectedResult.add("kajak");               // 4
        expectedResult.add("karol");               // 5
        expectedResult.add("adam");                // 6
        expectedResult.add("mama");                // 7
        expectedResult.add("tata");                // 8
        expectedResult.add("mak");                 // 9
        expectedResult.add("az");                  // 10
        List<String> actualResult = (List<String>) analizer.analize(text);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void testSameWordAppears() {
        String text = "Karol Brzęczyszczykiewicz Rewolwerowiec adam adam";
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("brzęczyszczykiewicz");
        expectedResult.add("rewolwerowiec");
        expectedResult.add("karol");
        List<String> actualResult = (List<String>) analizer.analize(text);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void testPunctuation1() {
        String text = "Karol, Brzęczyszczykiewicz; :Rewolwerowiec: \'adam\', \"adam\"";
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("brzęczyszczykiewicz");
        expectedResult.add("rewolwerowiec");
        expectedResult.add("karol");
        List<String> actualResult = (List<String>) analizer.analize(text);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void testPunctuation2() {
        String text = "Karol , Brzęczyszczykiewicz ; : Rewolwerowiec : \' adam \', \" adam \"";
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("brzęczyszczykiewicz");
        expectedResult.add("rewolwerowiec");
        expectedResult.add("karol");
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

    @Test
    public void testNull() {
        String text = null;
        List<String> expectedResult = new ArrayList<>();
        List<String> actualResult = (List<String>) analizer.analize(text);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

}
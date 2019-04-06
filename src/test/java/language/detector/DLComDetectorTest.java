package language.detector;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class DLComDetectorTest {

    private Detector detector;

    @Before
    public void before() {
        detector = new DLComDetector();
    }

    @Test
    public void testPolish() {
        String text = "Konie przepłynęły trzecią część rzeki, ale woda znosiła je w dół coraz silniej. Widocznie " +
                "poczęły tracić siły, z wolna też zanurzały się coraz głębiej. Po chwili siedzący na nich mołojcy " +
                "byli już do pasa w wodzie. Przeszedł czas jakiś. Nadbiegli chłopi z Szelepuchy patrzyć, co się dzieje: " +
                "już tylko łby końskie wyglądały nad falą, a mołojcom woda dochodziła do piersi. Ale też przepłynęli " +
                "już pół rzeki. Nagle jeden łeb i jeden mołojec zniknął pod wodą, za nim drugi, trzeci, czwarty, " +
                "piąty… liczba płynących zmniejszała się coraz bardziej. Po obu stronach rzeki zapanowało w tłumach " +
                "głuche milczenie, ale szli wszyscy z biegiem wody, żeby widzieć, co się stanie. Już dwie trzecie " +
                "rzeki przebyte, liczba płynących zmniejszyła się jeszcze, ale słychać już ciężkie chrapanie koni i " +
                "głosy zachęcające mołojców; już widać, że niektórzy dopłyną.";
        assertThat(detector.detect(text)).isEqualTo("pl");
    }

    @Test
    public void testEnglish() {
        String text = "In 1935, Davis received his first trumpet as a gift from John Eubanks, a friend of his father." +
                "[16] He took lessons from Elwood Buchanan, a teacher and musician who was a patient of his father." +
                "[12] His mother wanted him to play violin instead.[17] Against the fashion of the time, Buchanan " +
                "stressed the importance of playing without vibrato and encouraged him to use a clear, mid-range tone. " +
                "Davis said that whenever he started playing with heavy vibrato, Buchanan slapped his knuckles.[17]" +
                "[12][18] In later years Davis said, \"I prefer a round sound with no attitude in it, like a round " +
                "voice with not too much tremolo and not too much bass. Just right in the middle. If I can't get that " +
                "sound I can't play anything.\"[19] In 1939, the family moved to 1701 Kansas Avenue in East St. Louis. " +
                "On his thirteenth birthday his father bought him a new trumpet,[16] and Davis began to play in local " +
                "bands. He took additional trumpet lessons from Joseph Gustat, principal trumpeter of the St. Louis " +
                "Symphony Orchestra.";
        assertThat(detector.detect(text)).isEqualTo("en");
    }

    @Test
    public void testGerman() {
        String text = "Während seiner Zeit an der High School, wo die Atmosphäre deutlicher als in seinem Wohnumfeld " +
                "von sozialer Ausgrenzung geprägt war, freundete sich Davis mit Clark Terry an.[5] Das selbstsichere, " +
                "coole Auftreten und der Trompetenstil des sechs Jahre älteren Mannes hatten großen Einfluss auf den " +
                "jungen Miles Davis. Mit sechzehn Jahren trat Davis in die Musikergewerkschaft ein. Um das Jahr 1942 " +
                "begann auch seine Beziehung zu Irene Birth, die auf dieselbe High School ging. Mit siebzehn spielte " +
                "er ein Jahr lang bei Eddie Randles Blue Devils in St. Louis und der näheren Umgebung. Während dieser " +
                "Zeit bekam er das Angebot, mit der Tiny-Bradshaw-Band auf Tour zu gehen, doch seine Mutter bestand " +
                "auf einen High School-Abschluss.[6] Im Jahr 1944, mit achtzehn Jahren, bekam seine Freundin Irene " +
                "die erste Tochter Cheryl. Da Irene noch andere Liebschaften hatte, war sich Miles Davis nicht sicher, " +
                "ob Cheryl sein Kind war. Er übernahm dessen ungeachtet die finanzielle Verantwortung für sie.[7] Davis " +
                "hatte mit Irene Birth insgesamt drei Kinder, heiratete sie aber nie. draußen";
        assertThat(detector.detect(text)).isEqualTo("de");
    }

}
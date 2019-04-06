package text.analizer;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MichalAnalizerTest {

    private Analizer analizer;

    @Before
    public void before() {
        analizer = new MichalAnalizer();
    }

    @Test
    public void testPanTadeusz() {
        String text = "Konie przepłynęły trzecią część rzeki, ale woda znosiła je w dół coraz silniej. " +
                "Widocznie poczęły tracić siły, z wolna też zanurzały się coraz głębiej.";
        assertThat(analizer.analize(text)).isEqualTo(24);
    }

    @Test
    public void testPanTadeusz2() {
        String text = " Telimena ku lewej izbie obrócona\n" +
                "Wachlując batystową chusteczką ramiona:\n" +
                "«Jak mamę kocham — rzekła — Hrabia się nie myli.\n" +
                "Znam ja dobrze Rosyją. Państwo nie wierzyli,\n" +
                "Gdy im nieraz mówiłam, jak tam z wielu względów\n" +
                "Godna pochwały czujność i srogość urzędów.\n" +
                "Byłam ja w Petersburku, nie raz, nie dwa razy!\n" +
                "Miłe wspomnienia! wdzięczne przeszłości obrazy!\n" +
                "Co za miasto! Nikt z panów nie był w Petersburku?\n" +
                "Chcecie może plan widzieć? Mam plan miasta w biurku.\n" +
                "Latem świat petersburski zwykł mieszkać na daczy,\n" +
                "To jest w pałacach wiejskich (dacza wioskę znaczy).\n" +
                "Mieszkałam w pałacyku, tuż nad Newą rzeką,\n" +
                "Niezbyt blisko od miasta i niezbyt daleko,\n" +
                "Na niewielkim, umyślnie sypanym pagórku:\n" +
                "Ach, co to był za domek! Plan mam dotąd w biurku.\n" +
                "Otóż, na me nieszczęście, najął dom w sąsiedztwie\n" +
                "Jakiś mały czynownik siedzący na śledztwie;\n" +
                "Trzymał kilkoro chartów: co to za męczarnie,\n" +
                "Gdy blisko mieszka mały czynownik i psiarnie!\n" +
                "Ilekroć z książką wyszłam sobie do ogrodu,\n" +
                "Użyć księżyca blasku, wieczornego chłodu\n" +
                "Zaraz i pies przyleciał, i kręcił ogonem,\n" +
                "I strzygł uszami, właśnie jakby był szalonym.\n" +
                "Nieraz się nalękałam. Serce mi wróżyło\n" +
                "Z tych psów jakieś nieszczęście: tak się też zdarzyło.\n" +
                "Bo gdym szła do ogrodu pewnego poranka,\n" +
                "Chart u nóg mych zadławił mojego kochanka\n" +
                "Bonończyka! Ach, była to rozkoszna psina,\n" +
                "Miałam ją w podarunku od księcia Sukina\n" +
                "Na pamiątkę; rozumna, żywa jak wiewiórka:\n" +
                "Mam jej portrecik, tylko nie chcę iść do biurka.\n" +
                "Widząc ją zadławioną, z wielkiej alteracji\n" +
                "Dostałam mdłości, spazmów, serca palpitacji.\n" +
                "Może by gorzej jeszcze z moim zdrowiem było;\n" +
                "Szczęściem, nadjechał właśnie z wizytą Kiryło\n" +
                "Gawrylicz Kozodusin, wielki łowczy dworu.\n" +
                "Pyta się o przyczynę tak złego humoru,\n" +
                "Każe wnet urzędnika przyciągnąć za uszy;\n" +
                "Staje pobladły, drżący i prawie bez duszy.\n" +
                "»Jak śmiesz — krzyknął Kiryło piorunowym głosem —\n" +
                "Szczuć wiosną łanię kotną tuż pod carskim nosem?«\n" +
                "Osłupiały czynownik darmo się zaklinał,\n" +
                "Że polowania dotąd jeszcze nie zaczynał,\n" +
                "Że z wielkiego łowczego wielkim pozwoleniem,\n" +
                "Zwierz uszczuty zda mu się być psem, nie jeleniem.\n" +
                "»Jak to? — krzyknął Kiryło — to śmiałbyś, hultaju,\n" +
                "Znać się lepiej na łowach i zwierząt rodzaju\n" +
                "Niźli ja, Kozodusin, carski jegermajster?\n" +
                "Niechajże nas rozsądzi zaraz policmajster!«\n" +
                "Wołają policmajstra, każą spisać śledztwo.\n" +
                "»Ja — rzecze Kozodusin — wydaję świadectwo,\n" +
                "Że to łania; on plecie, że to pies domowy:\n" +
                "Rozsądź nas, kto zna lepiej zwierzynę i łowy!«\n" +
                "Policmajster powinność służby swej rozumiał:\n" +
                "Bardzo się nad zuchwalstwem czynownika zdumiał\n" +
                "I odwiódłszy na stronę po bratersku radził,\n" +
                "By przyznał się do winy i tym grzech swój zgładził.\n" +
                "Łowczy udobruchany przyrzekł, że się wstawi\n" +
                "Do cesarza i wyrok nieco ułaskawi.\n" +
                "Skończyło się, że charty poszły na powrozy,\n" +
                "A czynownik na cztery tygodnie do kozy.\n" +
                "Zabawiła nas cały wieczór ta pustota;\n" +
                "Zrobiła się nazajutrz z tego anegdota,\n" +
                "Że w sądy o mym piesku wielki łowczy wdał się:\n" +
                "I nawet wiem z pewnością, że sam cesarz śmiał się».";
        assertThat(analizer.analize(text)).isEqualTo(456);
    }

}
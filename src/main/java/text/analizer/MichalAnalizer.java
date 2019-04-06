package text.analizer;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class MichalAnalizer implements  Analizer {
    @Override
    public Integer analize(String text) {
        Map<String, Long> map = getWordsMap(text);
        Long sum =map.values().stream()
                .reduce(0L, Long::sum);
        return sum.intValue();
    }

    private static Map<String,Long> getWordsMap(String text) {
        return Arrays.stream(text
                .toLowerCase()
                .split("[/. -]|\\r?\\n"))
                .map(x->x.replaceAll("[^\\p{LD}\\s]",""))
                .filter(x->!x.matches(""))
                .collect(Collectors.groupingBy(x->x, Collectors.counting()));
    }

    @Override
    public String interpret() {
        return null;
    }
}

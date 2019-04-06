package text.analizer;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface Analizer<T> {
    T analize(String text);
    String interpret();

    static Map<String, Long> getWordsMap(String text) {
        return Arrays.stream(text.split("[/. -]|\\r?\\n"))
                .filter(word -> word.matches("\\S*[\\p{L}]+\\S*"))
                .map(String::toLowerCase)
                .map(word -> word.replaceAll("[-@#$%&*+.^:,;()/'\"\\[\\]!?]",""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}

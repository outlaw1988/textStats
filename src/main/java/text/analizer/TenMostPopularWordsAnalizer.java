package text.analizer;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TenMostPopularWordsAnalizer implements Analizer {

    private List<String> topTenWords;

    @Override
    public List<String> analize(String text) {

        Map<String, Long> map = Arrays.stream(text.split(" "))
                .filter(word -> word.matches("\\S*[\\p{L}]+\\S*"))
                .map(String::toLowerCase)
                .map(word -> word.replaceAll("[-+.^:,;()'\"\\[\\]]",""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        topTenWords = map.entrySet().stream()
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return topTenWords;
    }

    @Override
    public String interpret() {
        return "Top ten words are: " + topTenWords;
    }
}

package text.analizer;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TenLongestWordsAppearOnce implements Analizer {

    private List<String> topTenLongestWords;

    @Override
    public List<String> analize(String text) {

        if (text == null || text.isEmpty()) return new ArrayList<>();

        topTenLongestWords = Arrays.stream(text.split(" "))
                .filter(word -> word.matches("\\S*[\\p{L}]+\\S*"))
                .map(String::toLowerCase)
                .map(word -> word.replaceAll("[-+.^:,;()'\"\\[\\]]",""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue().equals(1L))
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getKey().toCharArray().length))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                         .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                         (oldValue, newValue) -> oldValue, LinkedHashMap::new))
                .entrySet()
                .stream()
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return topTenLongestWords;
    }

    @Override
    public String interpret() {
        return "Longest words which appear only once: " + topTenLongestWords;
    }
}

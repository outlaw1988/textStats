package text.analizer;

import java.util.*;
import java.util.stream.Collectors;

public class TenLongestWordsAppearOnce implements Analizer {

    private List<String> topTenLongestWords;

    @Override
    public List<String> analize(String text) {

        if (text == null || text.isEmpty()) return new ArrayList<>();

        topTenLongestWords = Analizer.getWordsMap(text)
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

        StringBuilder sb = new StringBuilder();
        sb.append("LONGEST WORDS WHICH APPEAR ONLY ONCE: ");

        for(String word : topTenLongestWords) {
            sb.append(word).append(", ");
        }

        sb.setLength(sb.length() - 2);
        return sb.toString();
    }
}

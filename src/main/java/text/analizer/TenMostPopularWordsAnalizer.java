package text.analizer;

import java.util.*;
import java.util.stream.Collectors;

public class TenMostPopularWordsAnalizer implements Analizer {

    private List<String> topTenWords;

    @Override
    public List<String> analize(String text) {

        return Analizer.getWordsMap(text)
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public String interpret() {
        StringBuilder sb = new StringBuilder();
        sb.append("TOP TEN WORDS ARE: ");

        for(String word : topTenWords) {
            sb.append(word).append(", ");
        }

        sb.setLength(sb.length() - 2);
        return sb.toString();
    }
}

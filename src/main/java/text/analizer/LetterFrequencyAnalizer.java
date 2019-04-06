package text.analizer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LetterFrequencyAnalizer implements Analizer {

    private Map<Character, Double> lettersFrequency;

    @Override
    public Map<Character, Double> analize(String text) {

        if (text == null || text.isEmpty()) return new HashMap<>();

        Map<String, Long> lettersHistogram = text.chars()
                .mapToObj(c -> (char) c)
                .map(c -> c.toString().toLowerCase())
                .filter(c -> c.matches("\\p{L}"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        double totalAmount = lettersHistogram.values().stream().reduce(0L, Long::sum).doubleValue();

        lettersFrequency = lettersHistogram.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey().charAt(0),
                        e -> (e.getValue().doubleValue()/totalAmount) * 100.0))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        return lettersFrequency;
    }

    @Override
    public String interpret() {
        StringBuilder sb = new StringBuilder();
        sb.append("CHARACTERS FREQUENCY:\n");

        for (Map.Entry<Character, Double> entry : lettersFrequency.entrySet()) {
            sb
                .append("|")
                .append(entry.getKey())
                .append("|")
                .append("\t")
                .append(entry.getValue())
                .append("\n");
        }

        return sb.toString();
    }
}

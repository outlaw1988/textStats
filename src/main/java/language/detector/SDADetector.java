package language.detector;

import text.analizer.LetterFrequencyAnalizer;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static language.detector.LanguagesData.*;

public class SDADetector implements Detector {

    private Map<Map<Character, LetterStat>, String> languages;
    private final double bonusSpecial = -10.0;
    private final double penaltySpecial = 5;

    private String detectedLanguage;

    public SDADetector() {
        initializeMap();
    }

    @Override
    public String detect(String text) {
        if (text == null || text.isEmpty()) return null;

        Map<Character, Double> lettersFrequency = new LetterFrequencyAnalizer().analize(text);
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<Map<Character, LetterStat>, String> entry : languages.entrySet()) {
            String language = entry.getValue();
            double sum = entry.getKey().entrySet().stream()
                    .map(e -> {
                        if (lettersFrequency.get(e.getKey()) != null) {
                            if (e.getValue().getType().equals(LetterType.SPECIAL)) {
                                return bonusSpecial;
                            }
                            return Math.abs(e.getValue().getPercent() - lettersFrequency.get(e.getKey()));
                        } else {
                            if (e.getValue().getType().equals(LetterType.SPECIAL)) {
                                return penaltySpecial;
                            }
                            return e.getValue().getPercent();
                        }
                    } )
                    .reduce(0.0, Double::sum);

            resultMap.put(language, sum);
            //System.out.println("Language " + language + " sum is: " + sum);
        }

        detectedLanguage = resultMap.entrySet().stream()
                .min(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .get();

        return detectedLanguage;
    }

    @Override
    public String interpret() {
        return String.format("DETECTED LANGUAGE BY SDA DETECTOR IS: %s", detectedLanguage);
    }

    private void initializeMap() {
        languages = new HashMap<>();
        languages.put(polishMap, "Polish");
        languages.put(englishMap, "English");
        languages.put(germanMap, "German");
        languages.put(spanishMap, "Spanish");
        languages.put(frenchhMap, "French");
    }
}

package text.analizer;

import java.util.Arrays;

public class WordsCountAnalizer implements Analizer {

    private Integer numOfWords;

    @Override
    public Integer analize(String text) {
        if (text == null || text.isEmpty()) numOfWords = 0;
        else {
            numOfWords = (int)
            Arrays.stream(text.split("[/. -]|\\r?\\n"))
                    .filter(word -> word.matches("\\S*[\\p{L}]+\\S*"))
                    .count();
        }
        return numOfWords;
    }

    @Override
    public String interpret() {
        return String.format("TEXT CONTAINS: \t%d word(s)", numOfWords);
    }
}

import language.detector.Detector;
import language.detector.SDADetector;
import picocli.CommandLine;
import picocli.CommandLine.*;
import text.analizer.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    @Option(names = { "-f", "--file" }, description = "Text file path", required = true)
    private static String fileName;

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Display this help and exit")
    private static boolean help;

    public static void main(String[] args) {

        Main app = CommandLine.populateCommand(new Main(), args);

        if (help || args.length == 0) {
            CommandLine.usage(new Main(), System.out);
            return;
        }

        String text = FileReader.getText(fileName);

        List<Analizer> analizers = new ArrayList<>();
        analizers.add(new WordsCountAnalizer());
        analizers.add(new TenMostPopularWordsAnalizer());
        analizers.add(new LetterFrequencyAnalizer());
        analizers.add(new TenLongestWordsAppearOnce());

        MultiAnalizer multiAnalizer = new MultiAnalizer(analizers);
        multiAnalizer.performAnalyzis(text);

        Detector detector = new SDADetector();
        detector.detect(text);
        System.out.println(detector.interpret());
    }

}

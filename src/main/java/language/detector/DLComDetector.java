package language.detector;

import com.detectlanguage.DetectLanguage;
import com.detectlanguage.Result;
import com.detectlanguage.errors.APIError;

import java.util.List;

public class DLComDetector implements Detector {

    private String detectedLanguage;
    private DetectLanguage dl;

    public DLComDetector() {
        dl.apiKey = "8e0cd7e37524e665535e55795c4c6d05";
    }

    @Override
    public String detect(String text) {

        try {
            List<Result> results = dl.detect(text);
            detectedLanguage = results.get(0).language;
        } catch (APIError apiError) {
            apiError.printStackTrace();
        }

        return detectedLanguage;
    }

    @Override
    public String interpret() {
        return String.format("Detected language by DLCom detector is %s", detectedLanguage);
    }
}

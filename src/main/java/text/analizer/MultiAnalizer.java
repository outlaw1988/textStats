package text.analizer;

import java.util.List;

public class MultiAnalizer {

    private final List<Analizer> analizers;

    MultiAnalizer(List<Analizer> analizers){
        this.analizers = analizers;
    }

    public void performAnalyzis(String text) {

        for(Analizer analizer: analizers){
            analizer.analize(text);
        }

    }

}

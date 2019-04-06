package text.analizer;

public interface Analizer<T> {
    T analize(String text);
    String interpret();
}

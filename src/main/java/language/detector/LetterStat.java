package language.detector;

public class LetterStat {

    private double percent;
    private LetterType type;

    public LetterStat(double percent, LetterType type) {
        this.percent = percent;
        this.type = type;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public LetterType getType() {
        return type;
    }

    public void setType(LetterType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "LetterStat{" +
                "percent=" + percent +
                ", type=" + type +
                '}';
    }
}

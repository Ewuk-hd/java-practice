public class DayTime {
    int totalSeconds;

    public DayTime(int totalSeconds) {
        this.totalSeconds = totalSeconds;
    }

    public String toString() {
        int secondsInDay = totalSeconds % 86400;
        int h = secondsInDay / 3600;
        int m = (secondsInDay % 3600) / 60;
        int s = secondsInDay % 60;
        return String.format("%d:%02d:%02d", h, m, s);
    }
}

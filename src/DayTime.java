public class DayTime {
    int totalSeconds;

    public DayTime(int totalSeconds) {
        this.totalSeconds = totalSeconds;
    }

    @Override
    public String toString() {
        int secondsInDay = totalSeconds % 86400;
        int h = secondsInDay / 3600;
        int m = (secondsInDay % 3600) / 60;
        int s = secondsInDay % 60;
        return h + ":" + (m < 10 ? "0" : "") + m + ":" + (s < 10 ? "0" : "") + s;
    }
}

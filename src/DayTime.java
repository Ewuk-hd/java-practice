public class DayTime {
    private int totalSeconds;

    public DayTime(int totalSeconds) {
        if (totalSeconds < 0) {
            throw new IllegalArgumentException("Время не может быть отрицательным: " + totalSeconds);
        }
        this.totalSeconds = totalSeconds;
    }

    public int getTotalSeconds() {
        return totalSeconds;
    }

    public void setTotalSeconds(int totalSeconds) {
        if (totalSeconds < 0) {
            throw new IllegalArgumentException("Время не может быть отрицательным: " + totalSeconds);
        }
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

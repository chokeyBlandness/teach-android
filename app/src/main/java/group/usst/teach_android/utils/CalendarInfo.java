package group.usst.teach_android.utils;

public class CalendarInfo {
    private int day;
    private int status;

    public CalendarInfo(int day, int status) {
        this.day = day;
        this.status = status;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

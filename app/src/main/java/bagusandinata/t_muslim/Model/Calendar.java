package bagusandinata.t_muslim.Model;

public class Calendar {

    private int date;
    private int month;
    private int year;
    private String activities;

    public Calendar() {
    }

    public Calendar(int date, int month, int year, String activities) {
        this.date = date;
        this.month = month;
        this.year = year;
        this.activities = activities;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }
}

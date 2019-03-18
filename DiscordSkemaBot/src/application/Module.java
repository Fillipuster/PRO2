package application;

import java.time.LocalDateTime;

public class Module {

    private int id;
    private LocalDateTime start;
    private LocalDateTime end;
    private String summary;

    public Module(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getStart() {
        return this.start;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getDiscordBlock() {
        String startHour = (start.getHour() < 10) ? "0" + start.getHour() : start.getHour() + "";
        String startMinute = (start.getMinute() < 10) ? "0" + start.getMinute() : start.getMinute() + "";

        String endHour = (end.getHour() < 10) ? "0" + end.getHour() : end.getHour() + "";
        String endMinute = (end.getMinute() < 10) ? "0" + end.getMinute() : end.getMinute() + "";

        return summary + "\n" + startHour + ":" + startMinute + " - " + endHour + ":" + endMinute;
    }

}

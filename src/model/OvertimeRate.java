package model;

public class OvertimeRate {
    private Integer id;
    private Integer hour;
    private float percentage;

    public OvertimeRate(Integer id, Integer hour, float percentage) {
        this.id = id;
        this.hour = hour;
        this.percentage = percentage;
    }

    public Integer getId() {
        return id;
    }

    public Integer getHour() {
        return hour;
    }

    public float getPercentage() {
        return percentage;
    }
}

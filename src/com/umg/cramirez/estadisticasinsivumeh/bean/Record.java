package com.umg.cramirez.estadisticasinsivumeh.bean;

/**
 * Created by Cristian Ramírez on 3/03/2017.
 * UMG
 * cristianramirezgt@gmail.com
 */
public class Record {
    private int day;
    private String month;
    private String hour;
    private String pressure;
    private String temperature;

    public Record() {
    }

    public Record(int day, String month, String hour, String pressure, String temperature) {
        this.day = day;
        this.month = month;
        this.hour = hour;
        this.pressure = pressure;
        this.temperature = temperature;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}

package lab3ee.Model;

import java.util.Date;


public class Exam {

    private String name;
    private Date startingTime;
    private String duration;

    public Exam() {

    }

    public Exam(String name) {
        this.name = name;
    }

    public Exam(String name, Date startingTime, String duration) {
        this.name = name;
        this.startingTime = startingTime;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Date startingTime) {
        this.startingTime = startingTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "name='" + name + '\'' +
                ", startingTime=" + startingTime +
                ", duration='" + duration + '\'' +
                '}';
    }
}

package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.Objects;

public class TimeEntry {
    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

    public TimeEntry(TimeEntry timeEntry) {
        this.id= timeEntry.id;
        this.projectId=timeEntry.projectId;
        this.userId=timeEntry.userId;
        this.date=timeEntry.date;
        this.hours=timeEntry.hours;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public long getId() {
        return id;
    }

    public TimeEntry(long timeEntryId, long projectId, long userId, LocalDate localDate, int hrs) {
        this.id= timeEntryId;
        this.projectId=projectId;
        this.userId=userId;
        this.date=localDate;
        this.hours=hrs;
    }

    public TimeEntry(long projectId, long userId, LocalDate localDate, int hrs) {
        this.projectId=projectId;
        this.userId=userId;
        this.date= localDate;
        this.hours=hrs;
    }

    public TimeEntry()
    {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeEntry timeEntry = (TimeEntry) o;
        return id == timeEntry.id &&
                projectId == timeEntry.projectId &&
                userId == timeEntry.userId &&
                hours == timeEntry.hours &&
                date.equals(timeEntry.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectId, userId, date, hours);
    }


}

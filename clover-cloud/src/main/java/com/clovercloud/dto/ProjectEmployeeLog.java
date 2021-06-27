package com.clovercloud.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class ProjectEmployeeLog {

    private Integer logId;
    private String projectName;
    private String categoryName;
    private String firstName;
    LocalDateTime timestamp;
    private double timeSpent;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public double getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(double timeSpent) {
        this.timeSpent = timeSpent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectEmployeeLog that = (ProjectEmployeeLog) o;
        return Double.compare(that.timeSpent, timeSpent) == 0 && Objects.equals(logId, that.logId) && Objects.equals(projectName, that.projectName) && Objects.equals(categoryName, that.categoryName) && Objects.equals(firstName, that.firstName) && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logId, projectName, categoryName, firstName, timestamp, timeSpent);
    }

    @Override
    public String toString() {
        return "ProjectEmployeeLog{" +
                "logId=" + logId +
                ", projectName='" + projectName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", timestamp=" + timestamp +
                ", timeSpent=" + timeSpent +
                '}';
    }
}



package com.clovercloud.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name ="log")

public class Log implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer logId;
    private Integer projectId;
    private String categoryName;
    private Integer employeeId;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    LocalDateTime timestamp;

    private double timeSpent;

    public Log(Integer logId, Integer projectId, String categoryName, Integer employeeId, LocalDateTime timestamp, double timeSpent) {
        this.logId = logId;
        this.projectId = projectId;
        this.categoryName = categoryName;
        this.employeeId = employeeId;
        this.timestamp = timestamp;
        this.timeSpent = timeSpent;
    }

    public Log() {
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
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
        Log log = (Log) o;
        return Double.compare(log.timeSpent, timeSpent) == 0 && Objects.equals(logId, log.logId) && Objects.equals(projectId, log.projectId) && Objects.equals(categoryName, log.categoryName) && Objects.equals(employeeId, log.employeeId) && Objects.equals(timestamp, log.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logId, projectId, categoryName, employeeId, timestamp, timeSpent);
    }

    @Override
    public String toString() {
        return "Log{" +
                "logId=" + logId +
                ", projectId=" + projectId +
                ", categoryName='" + categoryName + '\'' +
                ", employeeId=" + employeeId +
                ", timestamp=" + timestamp +
                ", timeSpent=" + timeSpent +
                '}';
    }
}

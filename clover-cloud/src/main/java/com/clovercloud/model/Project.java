package com.clovercloud.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name ="project")

public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer projectId;
    private String projectName;
    private Integer hoursPlanned;
    private String projectStatus;

    public Project(Integer projectId, String projectName, Integer hoursPlanned, String projectStatus) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.hoursPlanned = hoursPlanned;
        this.projectStatus = projectStatus;
    }

    public Project() {
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getHoursPlanned() {
        return hoursPlanned;
    }

    public void setHoursPlanned(Integer hoursPlanned) {
        this.hoursPlanned = hoursPlanned;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(projectId, project.projectId) && Objects.equals(projectName, project.projectName) && Objects.equals(hoursPlanned, project.hoursPlanned) && Objects.equals(projectStatus, project.projectStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, projectName, hoursPlanned, projectStatus);
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", hoursPlanned=" + hoursPlanned +
                ", projectStatus='" + projectStatus + '\'' +
                '}';
    }
}

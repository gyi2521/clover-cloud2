package com.clovercloud.controller;

import com.clovercloud.dto.ProjectEmployeeLog;
import com.clovercloud.model.Employee;
import com.clovercloud.model.Log;
import com.clovercloud.model.Project;
import com.clovercloud.repository.EmployeeRepository;
import com.clovercloud.repository.LogRepository;
import com.clovercloud.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    LogRepository logRepo;

    @Autowired
    ProjectRepository projRepo;

    @Autowired
    EmployeeRepository employeeRepo;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Log createLog(@RequestBody Log log)  {
        return logRepo.save(log);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Log> getAllLogs() {
        return logRepo.findAll();
    }

    @GetMapping(value="/{logId}")
    @ResponseStatus(HttpStatus.OK)
    public Log getOneLog(@PathVariable Integer logId) {
        return logRepo.getById(logId);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateLog(@RequestBody Log log) {
        logRepo.save(log);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProject(@PathVariable Integer id){
        logRepo.deleteById(id);
    }

    @GetMapping(value="/employee/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProjectEmployeeLog> getLogDataByEmployeeId(@PathVariable Integer id) {

        List<Log> logList = logRepo.findAllLogsByEmployeeId(id);
        List<ProjectEmployeeLog> projectEmployeeLogList = new ArrayList<ProjectEmployeeLog>();


        logList.stream()
        .forEach(log ->{
            Optional proj = projRepo.findById(log.getProjectId());
            Optional employee = employeeRepo.findById(log.getEmployeeId());
            if(proj.isPresent()){
                ProjectEmployeeLog empLog = new ProjectEmployeeLog();
                empLog.setLogId(log.getLogId());
                //empLog.setEmployeeId(log.getEmployeeId());
                empLog.setFirstName(((Employee)employee.get()).getFirstName());
                empLog.setCategoryName(log.getCategoryName());
                empLog.setProjectName(((Project)proj.get()).getProjectName());
                empLog.setTimestamp(log.getTimestamp());
                empLog.setTimeSpent(log.getTimeSpent());

                projectEmployeeLogList.add(empLog);
            }
        });
        System.out.println(projectEmployeeLogList);
        return projectEmployeeLogList;
    }

}

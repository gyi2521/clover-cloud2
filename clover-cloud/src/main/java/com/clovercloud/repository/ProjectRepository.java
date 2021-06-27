package com.clovercloud.repository;

import com.clovercloud.model.Log;
import com.clovercloud.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository <Project, Integer> {
 //   Project findById (Integer id);
}

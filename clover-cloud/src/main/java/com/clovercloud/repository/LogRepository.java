package com.clovercloud.repository;

import com.clovercloud.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Integer> {
   List<Log> findAllLogsByEmployeeId(Integer id);

}

package com.example.study.repository;

import com.example.study.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.Instant;
import java.util.List;

/**
 * @program: study
 * @description:
 * @author: WangJJ
 * @create: 2020-09-08 18:49
 **/
public interface StudentRepository extends JpaRepository<Student, String>, JpaSpecificationExecutor<Student> {

    Integer countBySchoolAndCreatedTimeBetween(String name, Instant startTime,Instant endTime);

    List<Student> findAllByCreatedTimeBetween(Instant startTime, Instant endTime);

    List<Student> findAllByLastModifiedTimeAfter(Instant start);

}

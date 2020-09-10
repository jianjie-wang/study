package com.example.study.service;


import com.example.study.Utils.DateUtil;
import com.example.study.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;
/**
 * @program: study
 * @description:
 * @author: WangJJ
 * @create: 2020-07-17 16:45
 **/
@Service
public class StudentService {
    private final Logger log = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Integer countStudent(String schoolName){
        Instant startTime = DateUtil.formatStartTime(System.currentTimeMillis());
        Instant endTime = DateUtil.formatEndTime(System.currentTimeMillis());

        Integer times =studentRepository.countBySchoolAndCreatedTimeBetween(schoolName, startTime, endTime);

        return times;
    }


}

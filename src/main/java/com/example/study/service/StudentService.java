package com.example.study.service;


import com.example.study.Utils.DateUtil;
import com.example.study.Utils.ExcelUtils;
import com.example.study.domain.Student;
import com.example.study.repository.StudentRepository;
import com.example.study.service.DTO.StudentDTO;
import com.example.study.service.mapper.StudentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Integer countStudent(String schoolName){
        Instant startTime = DateUtil.formatStartTime(System.currentTimeMillis());
        Instant endTime = DateUtil.formatEndTime(System.currentTimeMillis());

        Integer times =studentRepository.countBySchoolAndCreatedTimeBetween(schoolName, startTime, endTime);

        return times;
    }

    public void mysqlText(){
        StringBuilder SQL = new StringBuilder();
        SQL.append("SELECT * ");
        SQL.append("FROM jian_jie ");

    }

    public List<StudentDTO> findStudent(){
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentDTOs = studentMapper.toDto(students);
        return studentDTOs;
    }

    public StudentDTO findAStudent(String id){
        log.debug("find a student by ID:{}",id);
        Student student = studentRepository.getOne(id);

        StudentDTO studentDTO = studentMapper.toDto(student);
        return  studentDTO;
    }

    public Student creatStudent(StudentDTO studentDTO){
        Student student = studentRepository.save(studentMapper.toEntity(studentDTO));
        return student;
    }

    public InputStream exportExcel() throws IOException {
        Map<String, Object> map = new LinkedHashMap<>();
        List<Map<String, Object>> result = new ArrayList<>();
        List<StudentDTO> studentDTOS =  findStudent();
        for (StudentDTO studentDTO : studentDTOS){
            map.put("姓名",studentDTO.getName());
            map.put("年龄",studentDTO.getName());
            map.put("学校",studentDTO.getName());

            result.add(map);
        }

        return ExcelUtils.getUploadExportData("学生明细表", result);
    }


}

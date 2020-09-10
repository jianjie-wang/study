package com.example.study.service.mysql;


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
import java.util.*;

/**
 * @program: study
 * @description:
 * @author: WangJJ
 * @create: 2020-07-03 15:22
 **/
@Service
public class MysqlService {
    private final static Logger log = LoggerFactory.getLogger(MysqlService.class);

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

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
        StudentDTO studentDTO = new StudentDTO();
        studentDTO = studentMapper.toDto(student);
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

    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now.getEpochSecond()); // 秒
        System.out.println(now.toEpochMilli()); // 毫秒
    }

}

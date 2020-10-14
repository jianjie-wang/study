package com.example.study.service;


import com.example.study.Utils.DateUtil;
import com.example.study.Utils.ExcelUtils;
import com.example.study.domain.Student;
import com.example.study.repository.StudentRepository;
import com.example.study.service.DTO.StudentDTO;
import com.example.study.service.VM.StudentVM;
import com.example.study.service.mapper.StudentMapper;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
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

    public Student creatStudent(StudentVM studentVM){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(studentVM.getName());
        studentDTO.setSchool(studentVM.getSchool());
        studentDTO.setAge(studentVM.getAge());
        studentDTO.setCreatedBy(studentVM.getName());
        studentDTO.setCreatedTime(Instant.now());
        studentDTO.setLastModifiedTime(Instant.now());
        studentDTO.setLastModifiedBy(studentVM.getName());
        studentDTO.setDelFlag(false);
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

    public Page<Student> specification(StudentDTO studentDTO , Pageable pageable,Long startTime,Long endTime){

        Specification<Student> sp = (root ,criteriaQuery,criteriaBuilder)->{
            List<Predicate> predicateList = new ArrayList<>();

            //开始时间
            if (startTime != null) {
                Path<Instant> createdTime = root.get("createdTime");
                Predicate p = criteriaBuilder.greaterThanOrEqualTo(createdTime, DateUtil.formatStartTime(startTime));
                predicateList.add(p);
            }

            //搜索结算时间
            if (endTime != null) {
                Path<Instant> createdTime = root.get("createdTime");
                Predicate p = criteriaBuilder.lessThanOrEqualTo(createdTime, DateUtil.formatEndTime(endTime));
                predicateList.add(p);
            }

            //年龄筛选
            if ( !"null".equals(String.valueOf(studentDTO.getAge()))  ){
                Path<Integer> age =root.get("age");
                Predicate p = criteriaBuilder.equal(age,studentDTO.getAge());
                predicateList.add(p);
            }

            //姓名学校模糊查询
            if (studentDTO.getSchool()!=null||studentDTO.getName()!=null){
                Path<String> name  = root.get("name");
                Path<String> school = root.get("school");
                Predicate p1 = criteriaBuilder.like(name,studentDTO.getName());
                Predicate p2 = criteriaBuilder.like(school,studentDTO.getSchool());
                Predicate p = criteriaBuilder.or(p1, p2);
                predicateList.add(p);
            }

            if (CollectionUtils.isEmpty(predicateList)){
                return null;
            }

            Predicate[] predicates = new Predicate[predicateList.size()];
            predicateList.toArray(predicates);
            return  criteriaBuilder.and(predicates);
        };

        Page<Student> students = studentRepository.findAll(sp,pageable);

        return students;
    }


}

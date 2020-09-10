package com.example.study.web.rest;


import com.example.study.domain.Student;
import com.example.study.service.DTO.StudentDTO;
import com.example.study.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: shijian
 * @description: 淦
 * @author: WangJJ
 * @create: 2020-07-02 10:16
 **/
@Api(tags = "openApi-学生接口")
@RestController
@RequestMapping("/user")
public class StudentResource {
    private final Logger log = LoggerFactory.getLogger(StudentResource.class);

    private final StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @ApiOperation("1.添加一个学生信息")
    @PostMapping("/created")
    public ResponseEntity<Student> createdStudet(@RequestBody StudentDTO studentDTO){
        log.debug("REST TO CREAT STUDENT {}",studentDTO);
        log.info("REST TO CREAT STUDENT {}",studentDTO);
        Student student = studentService.creatStudent(studentDTO);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("wangjianjie","handsome");
        return new ResponseEntity<>(student,httpHeaders, HttpStatus.OK);
    }

    @ApiOperation("2.获取单个学生信息")
    @GetMapping("/jian")
    public ResponseEntity<StudentDTO> findStudent(@ApiParam(value = "学生Id")@RequestParam(value = "id") String id){

        StudentDTO studentDTO = studentService.findAStudent(id);
        if (studentDTO !=null ) {
            return ResponseEntity.ok(studentDTO);
        }
        return null;
    }

    @ApiOperation("3.获取所有学生列表")
    @GetMapping("/jj")
    public List<StudentDTO> fdjf(){
        List<StudentDTO> studentDTOS = studentService.findStudent();
        if (studentDTOS!=null) {
            return studentDTOS;
        }
        return null;
    }

    @ApiOperation("4.计算当天创建的人中某个学校的人数")
    @GetMapping("/count")
    public ResponseEntity<Integer> count(@ApiParam(value = "学校名") @RequestParam(value = "schoolName") String schoolName){
        Integer s = studentService.countStudent(schoolName);
        return ResponseEntity.ok(s);
    }

    @ApiOperation("5.导出列表")
    @GetMapping
    public void exportExcel(){

    }

}

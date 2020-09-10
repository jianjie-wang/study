package com.example.study.web.rest;


import com.example.study.domain.Student;
import com.example.study.service.DTO.StudentDTO;
import com.example.study.service.StudentService;
import com.example.study.service.mysql.MysqlService;
import com.example.study.service.string.StringSplitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: shijian
 * @description:
 * @author: WangJJ
 * @create: 2020-07-02 10:16
 **/
@Api(tags = "测试接口信息")
@RestController
@RequestMapping("/user")
public class StudentResource {
    private final static Logger log = LoggerFactory.getLogger(StudentResource.class);

    @Autowired
    private MysqlService mysqlService;

    private final StudentService studentService;

    @Autowired
    StringSplitService stringSplitService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @ApiOperation("获取单个学生信息")
    @GetMapping("/jian")
    public ResponseEntity<StudentDTO> findStudent(@ApiParam(value = "学生Id")@RequestParam(value = "id") String id){

        StudentDTO studentDTO = mysqlService.findAStudent(id);
        if (studentDTO !=null ) {
            return ResponseEntity.ok(studentDTO);
        }
        return null;
    }

    @ApiOperation("获取所有学生列表")
    @GetMapping("/jj")
    public List<StudentDTO> fdjf(){
        List<StudentDTO> studentDTOS = mysqlService.findStudent();
        if (studentDTOS!=null) {
            return studentDTOS;
        }
        return null;
    }

    @ApiOperation("添加一个学生信息")
    @PostMapping("/created")
    public ResponseEntity<Student> createdStudet(@RequestBody StudentDTO studentDTO){
        log.debug("REST TO CREAT STUDENT {}",studentDTO);
        log.info("REST TO CREAT STUDENT {}",studentDTO);
        Student student = mysqlService.creatStudent(studentDTO);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("wangjianjie","handsome");
        return new ResponseEntity<>(student,httpHeaders, HttpStatus.OK);
    }

    @ApiOperation("HttpURLConnection获取中国地区IP")
    @GetMapping("/bb")
    public ResponseEntity<String> bb(){
        System.out.println("stat bb");
        String s = stringSplitService.dididi();
        System.out.println("end  bb");
        return ResponseEntity.ok(s);
    }

    @ApiOperation("计算当天创建的人中某个学校的人数")
    @GetMapping("/count")
    public ResponseEntity<Integer> count(@ApiParam(value = "学校名") @RequestParam(value = "schoolName") String schoolName){
        Integer s = studentService.countStudent(schoolName);
        return ResponseEntity.ok(s);
    }

    @ApiOperation("导出列表")
    @GetMapping
    public void exportExcel(){

    }

}

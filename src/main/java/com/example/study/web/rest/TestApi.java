package com.example.study.web.rest;


import com.example.study.domain.Student;
import com.example.study.service.DTO.StudentDTO;
import com.example.study.service.StudentService;
import com.example.study.service.mysql.MysqlService;
import com.example.study.service.string.StringSplitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
public class TestApi {
    private final static Logger log = LoggerFactory.getLogger(TestApi.class);

    @Autowired
    private MysqlService mysqlService;

    private final StudentService studentService;

    @Autowired
    StringSplitService stringSplitService;

    public TestApi(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/jian")
    public ResponseEntity<StudentDTO> findStudent(String id){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO = mysqlService.findAStudent(id);
        if (studentDTO !=null ) {
            return ResponseEntity.ok(studentDTO);
        }
        return ResponseEntity.ok(studentDTO);
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
        System.out.println(student);
//        StudentDTO studentDTO1 = studentMapper.toDto(student);
//        System.out.println(studentDTO1);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("wangjianjie","handsome");
        return new ResponseEntity<>(student,httpHeaders, HttpStatus.OK);
    }

    @ApiOperation("完整获取中国地区IP")
    @GetMapping("/aa")
    public List<String> aa(){
        System.out.println("stat aa");
        List<String> list = stringSplitService.jie();
        System.out.println("end aa");
        System.out.println(list);
        return list;
    }

    @ApiOperation("HttpURLConnection获取中国地区IP")
    @GetMapping("/bb")
    public String bb(){
        System.out.println("stat bb");
        String s = stringSplitService.dididi();
        System.out.println("end  bb");
        return s;
    }

    @ApiOperation("计算当天创建的人数")
    @GetMapping("/count")
    public Integer count(@RequestParam(required = true) String name){
        System.out.println("stat bb");
        Integer s = studentService.countStudent(name);
        System.out.println("end  bb");
        return s;
    }

    @ApiOperation("导出列表")
    @GetMapping
    public void exportExcel(){

    }

}

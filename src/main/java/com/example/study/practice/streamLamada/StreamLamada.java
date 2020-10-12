package com.example.study.practice.streamLamada;

import com.example.study.service.DTO.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: study
 * @description:
 * @author: WangJJ
 * @create: 2020-07-07 10:16
 **/
@Service
public class StreamLamada {

    public List<StudentDTO> stt(){
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (int i = 0 ; i<=9; i++) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setName("name"+i);
            studentDTO.setAge(i);
            studentDTO.setSchool("school"+i);
            studentDTOS.add(studentDTO);
        }
        Long o = studentDTOS.stream()
                .filter(studentDTO->studentDTO.getAge()>5)
                .count();
        System.out.println(o);
        return studentDTOS;
    }

    public static void main(String[] args) {
        StreamLamada streamLamada = new StreamLamada();
        List<StudentDTO> studentDTOS = streamLamada.stt();
        System.out.println(studentDTOS);
    }


}

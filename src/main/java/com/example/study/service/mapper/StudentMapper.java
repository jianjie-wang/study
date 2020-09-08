package com.example.study.service.mapper;


import com.example.study.domain.Student;
import com.example.study.service.DTO.StudentDTO;

import org.mapstruct.Mapper;

/**
 * @program: study
 * @description:
 * @author: WangJJ
 * @create: 2020-07-03 16:17
 **/
@Mapper(componentModel = "spring", uses = {})
public interface StudentMapper extends EntityMapper<StudentDTO, Student> {
}

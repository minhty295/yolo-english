package com.yolo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.yolo.entities.Student;
import com.yolo.responses.StudentRes;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(source = "level.id", target = "level.id")
    @Mapping(source = "level.name", target = "level.name")
    StudentRes toRes(Student student);
}

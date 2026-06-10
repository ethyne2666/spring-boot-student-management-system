package dev.nullLogic.student_management_system.service;

import dev.nullLogic.student_management_system.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();
}

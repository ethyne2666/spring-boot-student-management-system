package dev.nullLogic.student_management_system.service;

import dev.nullLogic.student_management_system.dto.StudentDto;
import jakarta.validation.Valid;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();

    void createStudent(StudentDto student);

    StudentDto getStudentById(Long studentId);

    void updateStudent(@Valid StudentDto studentDto);
}

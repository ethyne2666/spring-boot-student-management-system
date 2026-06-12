package dev.nullLogic.student_management_system.service.impl;

import dev.nullLogic.student_management_system.dto.StudentDto;
import dev.nullLogic.student_management_system.entity.Student;
import dev.nullLogic.student_management_system.mapper.StudentMapper;
import dev.nullLogic.student_management_system.repository.StudentRepository;
import dev.nullLogic.student_management_system.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = students.stream()
                .map((student) -> StudentMapper.mapToStudentDto(student))
                .collect(Collectors.toList());
        return studentDtos;
    }

    @Override
    public void createStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        studentRepository.save(student);

    }
}

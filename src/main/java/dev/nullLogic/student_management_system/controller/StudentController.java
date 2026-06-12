package dev.nullLogic.student_management_system.controller;

import dev.nullLogic.student_management_system.dto.StudentDto;
import dev.nullLogic.student_management_system.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

     private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // handler method to handle list students request

    @GetMapping("/students")
    public String listStudents(Model model){
        List<StudentDto> students = studentService.getAllStudents();
        model.addAttribute("students" , students);
        return "students";
    }


    //handler method to handle new student request

    @GetMapping("/students/new")
    public String newStudent(Model model){
        // student model object to store student form data
        StudentDto studentDto = new StudentDto();
        model.addAttribute("student",studentDto);
        return "create_student";
    }

    @PostMapping("/students")
    //handler method to handle save student form submit request
    public String saveStudent(@ModelAttribute("student") StudentDto student){
        studentService.createStudent(student);
        return "redirect:/students";
    }


}

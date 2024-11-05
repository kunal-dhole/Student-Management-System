package com.shubham.StudentManagementSystem.controller;

import org.apache.logging.log4j.util.StringBuilderFormattable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.shubham.StudentManagementSystem.Service.StudentService;
import com.shubham.StudentManagementSystem.entity.Student;


@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;	
	
	@GetMapping("/home")
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/students")
public String getAllStudents(Model model)
{
	model.addAttribute("students",studentService.getAllStudents());
	return "students";
	}
	
	@GetMapping("students/new")
	public String createStudentForm(Model model)
	{
		Student student =new Student();
		model.addAttribute("students",student);
		
		
		return "Create-student"; //html page is to be made
	}
	
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student)
	{
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable int id, Model model) {
	    model.addAttribute("student", studentService.getById(id));
	    return "edit_student";
	}

	
	   @PostMapping("/students/edit/{id}")
	public String updateStudent(@PathVariable int id,@ModelAttribute("student")  Student student)
	{
	Student existingStudent=	studentService.getById(id);
		
	existingStudent.setFirstName(student.getFirstName());
	existingStudent.setLastName(student.getLastName());
	existingStudent.setEmail(student.getEmail());
	
	studentService.saveStudent(existingStudent);
	return "redirect:/students";
	
	}
	
	   @GetMapping("/students/{id}")
	public String deleteById(@PathVariable int id)
	{
		studentService.deleteById(id);
		return"redirect:/students";
	}
	
	
	
	
}

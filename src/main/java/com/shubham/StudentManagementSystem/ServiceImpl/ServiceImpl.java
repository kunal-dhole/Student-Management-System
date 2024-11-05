package com.shubham.StudentManagementSystem.ServiceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubham.StudentManagementSystem.Repository.StudentRepository;
import com.shubham.StudentManagementSystem.Service.StudentService;
import com.shubham.StudentManagementSystem.entity.Student;

@Service
public class ServiceImpl implements StudentService {
	@Autowired
private	StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudents() { //THIS METHOD IS CALLING TO REPOSITORY
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public Student getById(int id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
	}

}

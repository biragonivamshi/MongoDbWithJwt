package com.virtusa.MongoDBWithJwt.service;

import com.virtusa.MongoDBWithJwt.entitity.Student;
import com.virtusa.MongoDBWithJwt.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public String AddStudent(Student student) {
        studentRepository.save(student);
        return "Added book with id:"+student.getId();


    }

    public List<Student> FindStudents() {
        return studentRepository.findAll();
    }

    public String UpdateStudent(Student student) {
        studentRepository.save(student);
        return "student got updated:"+student.getId();
    }


    public String DeleteStudent(int id) {
        studentRepository.deleteById(id);
        return "student got deleted:"+id;

    }
}

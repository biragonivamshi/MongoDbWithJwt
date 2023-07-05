package com.virtusa.MongoDBWithJwt.service;

import com.virtusa.MongoDBWithJwt.entitity.Student;
import com.virtusa.MongoDBWithJwt.exceptions.InvalidStudentId;
import com.virtusa.MongoDBWithJwt.exceptions.StudentAlreadyExists;
import com.virtusa.MongoDBWithJwt.exceptions.StudentIdDoesntExists;
import com.virtusa.MongoDBWithJwt.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentService {
    private StudentRepository studentRepository;

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {


        this.studentRepository = studentRepository;
        log.info("student sucsessfully saved into the dataBase");
    }

    public ResponseEntity<Object> AddStudent(Student student) {
        Optional<Student> studentD = studentRepository.findById(student.getId());

        if (studentD.isEmpty()) {
            try {
                studentRepository.save(student);
                log.info("Student added into Db successfully!");
                return new ResponseEntity<Object>(student, HttpStatus.CREATED);
            } catch (Exception e) {
                log.error("Failed to save student into the Db: " + e.getMessage());
                throw new RuntimeException("Error occurred while saving student");
            }
        } else {
            log.error("Student already exists in the Db");
            throw new StudentAlreadyExists("Student already exists");
        }

    }


  public ResponseEntity FindStudents() {
        List<Student> students = studentRepository.findAll();
        if (students.isEmpty()) {
            log.info("No students found in the Db");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            log.info("Students retrieved from the Db");
            return new ResponseEntity<>(students, HttpStatus.OK);
        }
    }


    public ResponseEntity<Object> UpdateStudent (Student student){
            Optional<Student> studentD = studentRepository.findById(student.getId());
            if (!studentD.isEmpty()) {

                studentRepository.save(student);
                log.info("Student Updated Succesfully!");
                return new ResponseEntity<Object>(student, HttpStatus.CREATED);

            } else {
                throw new StudentIdDoesntExists("Student Id Doesn't exists");
            }
        }


        public ResponseEntity<Object> DeleteStudent (int id){
            Optional<Student> studentDb = studentRepository.findById(id);
            if (!studentDb.isEmpty()) {

                studentRepository.deleteById(id);
                log.info("Succesfully Deleted from thr Db");
            }else{
                  log.error("Enter valid Id to delete from the Db ");
                throw new InvalidStudentId("Enter Valid student Id");
            }
            return new  ResponseEntity<> (id,null,HttpStatus.OK);

        }
    }

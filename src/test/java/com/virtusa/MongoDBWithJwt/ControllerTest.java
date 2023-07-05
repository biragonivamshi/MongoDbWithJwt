package com.virtusa.MongoDBWithJwt;

import com.virtusa.MongoDBWithJwt.controller.StudentController;
import com.virtusa.MongoDBWithJwt.entitity.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {
    @Mock
    StudentController studentController;
    @Test
    void createStudentTestControllerPositive() {
        Student student=new Student();
        student.setId(1);
        student.setName("vamshi");
        student.setVillage("thumkunta");
        ResponseEntity<Object> res = new ResponseEntity<Object>(student, HttpStatus.OK);
        when(studentController.saveStudent(student)).thenReturn(res);
        assertEquals(studentController.saveStudent(student),res);

    }


        @Test
    void getStudentTestControllerPositive() {
        List<Student> students = new ArrayList<>();
      //  students.add(new Student(1, "John", "Thumkunta"));



    }
    @Test
    void updateStudentTestControllerPositive() {
        Student student=new Student();
        student.setId(1);
        student.setName("mahender");
        student.setVillage("madhapur");
        ResponseEntity<Object> res = new ResponseEntity<Object>(student, HttpStatus.OK);
        when(studentController.editStudnet(1,student)).thenReturn(res);
        assertEquals(studentController.editStudnet(1,student),res);
    }


    @Test
    void deleteStudentTestControllerPositive() {
        Student student=new Student();
        student.setId(1);
        student.setName("vamshi");
        student.setVillage("thumkunta");
        ResponseEntity<Object> res = new ResponseEntity<Object>(student, HttpStatus.OK);
        when(studentController.deleteStudent(1)).thenReturn(res);
        assertEquals(studentController.deleteStudent(1),res);


    }
    @Test
    void createStudentTestControllerNegative() {
        Student student = new Student();
        student.setId(1);
        student.setName("vamshi");
        student.setVillage("thumkunta");
        ResponseEntity<Object> resactual = new ResponseEntity<Object>(student,HttpStatus.BAD_GATEWAY);
        ResponseEntity<Object> resExpected = new ResponseEntity<Object>(student,HttpStatus.OK);

        when(studentController.saveStudent(student)).thenReturn(resactual);
        assertEquals(studentController.saveStudent	(student),resExpected);

    }
   @Test
    void updateStudentTestControllerNegative() {
        Student student = new Student();
        student.setId(1);
        student.setName("mahender");
        student.setVillage("madhapur");
        ResponseEntity<Object> resactual = new ResponseEntity<Object>(student,HttpStatus.BAD_GATEWAY);
        ResponseEntity<Object> resExpected = new ResponseEntity<Object>(student,HttpStatus.OK);

        when(studentController.editStudnet(1,student)).thenReturn(resactual);
        assertEquals(studentController.editStudnet	(1,student),resExpected);

    }
    void deleteStudentTestControllerNegative() {
        Student student = new Student();
        student.setId(1);
        student.setName("vamshi");
        student.setVillage("thumkunta");
        ResponseEntity<Object> resactual = new ResponseEntity<Object>(student, HttpStatus.BAD_GATEWAY);
        ResponseEntity<Object> resExpected = new ResponseEntity<Object>(student, HttpStatus.OK);

        when(studentController.deleteStudent(1)).thenReturn(resactual);
        assertEquals(studentController.deleteStudent(1), resExpected);


    }

    }

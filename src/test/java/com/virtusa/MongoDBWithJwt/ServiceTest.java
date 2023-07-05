package com.virtusa.MongoDBWithJwt;

import com.virtusa.MongoDBWithJwt.entitity.Student;
import com.virtusa.MongoDBWithJwt.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class ServiceTest {
    @Mock
    StudentService studentService;
    @Test
    void createStudentTestServicePositive() {
        Student student=new Student();
        student.setId(1);
        student.setName("vamshi");
        student.setVillage("thumkunta");
        ResponseEntity<Object> res = new ResponseEntity<Object>(student, HttpStatus.OK);
        when(studentService.AddStudent(student)).thenReturn(res);
        assertEquals(studentService.AddStudent(student),res);

    }

    @Test
    void updateStudentTestServicePositive() {
        Student student=new Student();
        student.setId(1);
        student.setName("mahender");
        student.setVillage("madhapur");
        ResponseEntity<Object> res = new ResponseEntity<Object>(student, HttpStatus.OK);
        when(studentService.UpdateStudent(student)).thenReturn(res);
        assertEquals(studentService.UpdateStudent(student),res);
    }
    @Test
    void deleteStudentTestServicePositive() {
        Student student=new Student();
        student.setId(1);
        student.setName("vamshi");
        student.setVillage("thumkunta");
        ResponseEntity<Object> res = new ResponseEntity<Object>(student, HttpStatus.OK);
        when(studentService.DeleteStudent(1)).thenReturn(res);
        assertEquals(studentService.DeleteStudent(1),res);


    }


    @Test
    void createStudentTestServiceNegative() {
        Student student = new Student();
        student.setId(1);
        student.setName("vamshi");
        student.setVillage("thumkunta");
        ResponseEntity<Object> resactual = new ResponseEntity<Object>(student,HttpStatus.BAD_GATEWAY);
        ResponseEntity<Object> resExpected = new ResponseEntity<Object>(student,HttpStatus.OK);

        when(studentService.AddStudent(student)).thenReturn(resactual);
        assertEquals(studentService.AddStudent(student),resExpected);

    }
    @Test
    void updateStudentTestServiceNegative() {
        Student student = new Student();
        student.setId(1);
        student.setName("mahender");
        student.setVillage("madhapur");
        ResponseEntity<Object> resactual = new ResponseEntity<Object>(student,HttpStatus.BAD_GATEWAY);
        ResponseEntity<Object> resExpected = new ResponseEntity<Object>(student,HttpStatus.OK);

        when(studentService.UpdateStudent(student)).thenReturn(resactual);
        assertEquals(studentService.UpdateStudent(student),resExpected);

    }
    void deleteStudentTestServiceNegative() {
        Student student = new Student();
        student.setId(1);
        student.setName("vamshi");
        student.setVillage("thumkunta");
        ResponseEntity<Object> resactual = new ResponseEntity<Object>(student, HttpStatus.BAD_GATEWAY);
        ResponseEntity<Object> resExpected = new ResponseEntity<Object>(student, HttpStatus.OK);

        when(studentService.DeleteStudent(1)).thenReturn(resactual);
        assertEquals(studentService.DeleteStudent(1), resExpected);


    }

}

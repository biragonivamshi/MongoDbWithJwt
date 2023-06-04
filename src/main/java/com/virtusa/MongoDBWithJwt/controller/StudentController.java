package com.virtusa.MongoDBWithJwt.controller;

import com.virtusa.MongoDBWithJwt.entitity.AuthenticationRequest;
import com.virtusa.MongoDBWithJwt.entitity.AuthenticationResponse;
import com.virtusa.MongoDBWithJwt.entitity.Student;
import com.virtusa.MongoDBWithJwt.filter.JwtRequestFilter;
import com.virtusa.MongoDBWithJwt.repository.StudentRepository;
import com.virtusa.MongoDBWithJwt.service.MyUserDetailsService;
import com.virtusa.MongoDBWithJwt.service.StudentService;
import com.virtusa.MongoDBWithJwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class StudentController {

    private StudentRepository studentRepository;


    private AuthenticationManager authenticationManager;

    private StudentService studentService;

    private MyUserDetailsService userDetailsService;

    private JwtUtil jwtTokenUtil;

    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    public StudentController(StudentRepository studentRepository, AuthenticationManager authenticationManager, StudentService studentService, MyUserDetailsService userDetailsService, JwtUtil jwtTokenUtil, JwtRequestFilter jwtRequestFilter) {
        this.studentRepository = studentRepository;
        this.authenticationManager = authenticationManager;
        this.studentService = studentService;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @RequestMapping(value = "/authenaticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);

        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/addStudent")
    public String saveBook(@RequestBody Student student) {
        return studentService.AddStudent(student);
    }

    @GetMapping("/findAllStudents")
    public List<Student> getStudents() {
        return studentService.FindStudents();
    }

    @PutMapping("/update/{id}")
    public String editBook(@PathVariable int id, @RequestBody Student student) {
        return studentService.UpdateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        return studentService.DeleteStudent(id);
    }
}

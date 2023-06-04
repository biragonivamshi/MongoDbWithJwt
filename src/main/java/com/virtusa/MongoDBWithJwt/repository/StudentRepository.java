package com.virtusa.MongoDBWithJwt.repository;

import com.virtusa.MongoDBWithJwt.entitity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student,Integer> {

}
